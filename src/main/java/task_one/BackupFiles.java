package task_one;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {
    public static void copyAllFiles(File source, File dest) throws IOException {
        if (source.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String[] children = source.list();
            for (String child : children) {
                copyAllFiles(new File(source, child), new File(dest, child));
            }
        } else {
            FileInputStream inputStream = new FileInputStream(source);
            FileOutputStream outputStream = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
        }
    }

    public static void backupDirectory(File sourceDir, File backupDir) {
        File source = new File(sourceDir.toURI());
        File backup = new File(backupDir.toURI());

        if (!source.exists() || !source.isDirectory()) {
            System.out.println("Source directory does not exist or is not a directory.");
            return;
        }

        if (!backup.exists()) {
            backup.mkdirs();
        }

        if (!backup.isDirectory()) {
            System.out.println("Backup directory is not a directory.");
            return;
        }

        File[] files = source.listFiles();

        if (files == null) {
            System.out.println("Error listing files in source directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try {
                    Files.copy(file.toPath(), new File(backup, file.getName()).toPath(),
                            StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    System.out.println("Error copying file " + file.getName() + ": " + e.getMessage());
                }
            }
        }

        System.out.println("Backup complete.");
    }
}