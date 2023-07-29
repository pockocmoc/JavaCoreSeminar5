package task_one;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File sourceDir = new File("/home/marat/IdeaProjects/JavaCoreSeminar5/src/main/resources/test_dir");
        File backupDir = new File("/home/marat/IdeaProjects/JavaCoreSeminar5/src/main/resources/backup");
        backupDir.mkdir();
        BackupFiles.copyAllFiles(sourceDir, backupDir);
//        task_one.BackupFiles.backupDirectory(sourceDir, backupDir);

    }
}
