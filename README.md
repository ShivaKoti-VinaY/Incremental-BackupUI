# Incremental File Backup and Recovery System
Incremental File Backup and Recovery System. This user-friendly solution prioritizes incremental backups to optimize storage and streamline recovery. Timestamped backups facilitate organized data management, ensuring users can easily trace and restore specific file versions. The intuitive interface caters to users with diverse technical backgrounds, simplifying the backup and recovery processes. Leveraging Java for cross-platform compatibility, the system employs ZIP compression for storage efficiency. 
This Java program provides an incremental backup system with a graphical user interface (GUI) for easy interaction. It allows users to choose source and backup folders, perform backups, and recover files from previous backups. The program creates timestamped backup folders, ensuring multiple backups can be created over time.


System requirements : vscode, JDK 


![Screenshot 2023-12-02 at 9 56 57 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/0ff1f826-7cac-4f61-9ce1-57f48d1b4e6e)

1.Run the Program:Execute the Java program (IncrementalBackupUI) by running the main method.
The graphical user interface (GUI) will appear.


![Screenshot 2023-12-02 at 9 54 30 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/4690ac09-7911-415c-b6e9-3ba9bb8f3f48)

2.Java swing UI will show this window


![Screenshot 2023-12-02 at 9 48 53 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/3bb24980-b2c1-401b-ac36-5f5b544731e7)

3.Choose Source Folder:Click on the "Choose Source Folder" button.
Select the folder containing the files you want to back up.


![Screenshot 2023-12-02 at 10 16 00 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/d7d3967b-a61f-473e-8256-f69a7aada3f6)

4.Choose Backup Folder:Click on the "Choose Backup Folder" button.
Select the folder where you want to store the backup files. The program will create a subfolder within this location with a timestamp.


![Screenshot 2023-12-02 at 10 16 23 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/a9cadd94-bbcf-48df-aed2-fa7473782411)

5.Perform Backup:Click on the "Backup" button.
The program will copy files from the selected source folder to a subfolder within the chosen backup folder. It will only copy files that are newer than the existing ones in the backup.

![Screenshot 2023-12-02 at 9 49 48 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/56442287-50e6-4e01-98d8-c46e1d7b9df7)

6.Check Backup:Open the chosen backup folder to verify that the new backup subfolder has been created, containing the updated or new files.

![Screenshot 2023-12-02 at 10 04 48 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/b1d9cf5f-a841-43b5-9888-3cd28d23cefa)


To recover a backup using the provided Java program, follow these steps:

1.Run the program:
->Execute the Java program (IncrementalBackupUI) by running the main method.
The graphical user interface (GUI) will appear.

![Screenshot 2023-12-04 at 10 08 49 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/90b586d5-ffbc-43bf-9894-94efa9ce52e1)


2.Choose Backup Folder:
->Click on the "Choose Backup Folder" button.
Select the folder containing your backup files (the folder that was specified as the backup folder when performing the backup).


![Screenshot 2023-12-02 at 10 16 23 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/104d67c5-0943-463f-8da8-6880b3aa7b5d)


3.Recover Files:
->Click on the "Recover" button.
A dialog box will prompt you to enter the name of the backup to recover from. Enter the name without the ".zip" extension.


![Screenshot 2023-12-04 at 10 05 35 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/22a39c33-0860-4f5f-9910-36a403e29521)


4.Wait for recovery:
->The program will unzip the selected backup and restore the files to the original backup folder.
You will see a message dialog indicating the success or failure of the recovery process.

![Screenshot 2023-12-04 at 10 05 57 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/e2195ab9-d6f7-4e0e-9207-844837a88910)


5.Check Recovered Files:
->Open the original backup folder to verify that the files have been successfully recovered.


![Screenshot 2023-12-04 at 10 06 57 AM](https://github.com/ShivaKoti-VinaY/Incremental-BackupUI/assets/104214901/d6673aae-6d3f-482f-a865-fdd275841f25)


