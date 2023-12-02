import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IncrementalBackupUI extends JFrame {

    private JTextField sourceFolderField;
    private JTextField backupFolderField;

    public IncrementalBackupUI() {
        setTitle("Incremental Backup System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        initializeUI();
    }

    private void initializeUI() {
        // Create the main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        // Add components to the panel
        panel.add(new JLabel("Source Folder:"));
        sourceFolderField = new JTextField();
        panel.add(sourceFolderField);

        JButton sourceFolderButton = new JButton("Choose Source Folder");
        sourceFolderButton.addActionListener(e -> chooseFolder(sourceFolderField));
        panel.add(sourceFolderButton);

        panel.add(new JLabel("Backup Folder:"));
        backupFolderField = new JTextField();
        panel.add(backupFolderField);

        JButton backupFolderButton = new JButton("Choose Backup Folder");
        backupFolderButton.addActionListener(e -> chooseFolder(backupFolderField));
        panel.add(backupFolderButton);

        JButton backupButton = new JButton("Backup");
        backupButton.addActionListener(e -> {
            performIncrementalBackup(sourceFolderField.getText(), backupFolderField.getText());
            JOptionPane.showMessageDialog(null, "Backup completed successfully.");
        });
        panel.add(backupButton);

        JButton recoverButton = new JButton("Recover");
        recoverButton.addActionListener(e -> {
            recoverFiles(backupFolderField.getText());
            JOptionPane.showMessageDialog(null, "Recovery completed successfully.");
        });
        panel.add(recoverButton);

        // Add the panel to the frame
        add(panel);
    }

    private void chooseFolder(JTextField folderField) {
        // Create a file chooser dialog for selecting folders
        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Show the dialog and get the selected folder
        int result = folderChooser.showDialog(null, "Choose Folder");
        if (result == JFileChooser.APPROVE_OPTION) {
            folderField.setText(folderChooser.getSelectedFile().getAbsolutePath());
        }
    }
    private void performIncrementalBackup(String sourceFolder, String backupFolder) {
        // Generate a timestamp for the current backup
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());
    
        // Create the backup folder using the timestamp
        String backupFolderPath = backupFolder + File.separator + "backup_" + timestamp;
        File backupFolderFile = new File(backupFolderPath);
    
        // Create the backup folder if it doesn't exist
        if (!backupFolderFile.exists()) {
            backupFolderFile.mkdirs();
        }
    
        try {
            // Walk through the source folder and copy files to the backup folder
            Files.walkFileTree(Paths.get(sourceFolder), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // Determine the relative path of the file in the source folder
                    String relativePath = Paths.get(sourceFolder).relativize(file).toString();
    
                    // Create the corresponding file in the backup folder
                    File backupFile = new File(backupFolderFile, relativePath);
    
                    // Copy the file only if it's newer or doesn't exist in the backup
                    if (!backupFile.exists() || Files.getLastModifiedTime(file).toMillis() > backupFile.lastModified()) {
                        Files.copy(file, backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
    
                    return FileVisitResult.CONTINUE;
                }
            });
    
            // Zip the contents of the backup folder
            zipFolder(backupFolderFile, backupFolderPath + ".zip");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Backup failed. Check the error message for details.");
        }
    }
    

    private void zipFolder(File sourceFolder, String zipFilePath) throws IOException {
        // Create a ZipOutputStream to write to the specified zip file
        try (FileOutputStream fos = new FileOutputStream(zipFilePath);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            // Walk through the source folder and add files to the zip file
            Files.walkFileTree(sourceFolder.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // Determine the relative path of the file in the source folder
                    String relativePath = sourceFolder.toPath().relativize(file).toString();

                    // Read the file and add it to the zip file
                    try (FileInputStream fis = new FileInputStream(file.toFile())) {
                        ZipEntry zipEntry = new ZipEntry(relativePath);
                        zipOut.putNextEntry(zipEntry);

                        byte[] bytes = new byte[1024];
                        int length;
                        while ((length = fis.read(bytes)) >= 0) {
                            zipOut.write(bytes, 0, length);
                        }
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }

    private void recoverFiles(String backupFolder) {
        // Prompt the user to enter the name of the backup to recover
        String selectedBackup = JOptionPane.showInputDialog("Enter the name of the backup to recover from (without extension):");

        try {
            // Unzip the specified backup to the original backup folder
            unzipFolder(backupFolder + File.separator + selectedBackup + ".zip", backupFolder);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Recovery failed. Check the error message for details.");
        }
    }

    private void unzipFolder(String zipFilePath, String outputFolder) throws IOException {
        // Create a ZipInputStream to read from the specified zip file
        try (FileInputStream fis = new FileInputStream(zipFilePath);
             ZipInputStream zipIn = new ZipInputStream(fis)) {

            // Read entries from the zip file and extract them to the output folder
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                // Determine the path of the entry in the output folder
                String filePath = outputFolder + File.separator + entry.getName();

                // Create directories if the entry is a directory
                if (!entry.isDirectory()) {
                    try (FileOutputStream fos = new FileOutputStream(filePath)) {
                        // Read and write bytes from the zip entry to the output file
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = zipIn.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                } else {
                    // Create directories for directory entries
                    File dir = new File(filePath);
                    dir.mkdirs();
                }

                // Move to the next zip entry
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    public static void main(String[] args) {
        // Start the Swing UI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new IncrementalBackupUI().setVisible(true));
    }
}

