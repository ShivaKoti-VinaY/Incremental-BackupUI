# Incremental-BackupUI
Incremental File Backup and Recovery System. This user-friendly solution prioritizes incremental backups to optimize storage and streamline recovery. Timestamped backups facilitate organized data management, ensuring users can easily trace and restore specific file versions. The intuitive interface caters to users with diverse technical backgrounds, simplifying the backup and recovery processes. Leveraging Java for cross-platform compatibility, the system employs ZIP compression for storage efficiency. 

System requirements : vscode, JDK 


![Screenshot 2023-12-02 at 9 56 57 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/0ff1f826-7cac-4f61-9ce1-57f48d1b4e6e)

Step-1: program execution


![Screenshot 2023-12-02 at 9 54 30 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/4690ac09-7911-415c-b6e9-3ba9bb8f3f48)

Step-2: Java swing UI will show this window


![Screenshot 2023-12-02 at 9 48 53 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/3bb24980-b2c1-401b-ac36-5f5b544731e7)

Step-3: Choosing the Source folder which you want Backup


![Screenshot 2023-12-02 at 10 16 00 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/d7d3967b-a61f-473e-8256-f69a7aada3f6)

Step-4: Choose the Backup folder where you want to store those source files


![Screenshot 2023-12-02 at 10 16 23 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/a9cadd94-bbcf-48df-aed2-fa7473782411)

Step-5: Backup Success


![Screenshot 2023-12-02 at 9 49 48 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/56442287-50e6-4e01-98d8-c46e1d7b9df7)


Step 6: Check the backup folder to see if the backup was successful.


![Screenshot 2023-12-02 at 10 04 48 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/b1d9cf5f-a841-43b5-9888-3cd28d23cefa)


To recover a backup using the provided Java program, follow these steps:

Run the program:

1.Execute the Java program (IncrementalBackupUI) by running the main method.
The graphical user interface (GUI) will appear.
Choose Backup Folder:

2.Click on the "Choose Backup Folder" button.
Select the folder containing your backup files (the folder that was specified as the backup folder when performing the backup).
Recover Files:

3.Click on the "Recover" button.
A dialog box will prompt you to enter the name of the backup to recover from. Enter the name without the ".zip" extension.
Wait for recovery:

4.The program will unzip the selected backup and restore the files to the original backup folder.
You will see a message dialog indicating the success or failure of the recovery process.
Check Recovered Files:

Open the original backup folder to verify that the files have been successfully recovered.

