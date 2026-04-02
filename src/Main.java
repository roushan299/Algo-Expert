import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        printLine();
        int serialNo = 1;
        String currentPackage = "";
        String currentDir = System.getProperty("user.dir"); // gets current working directory
        String srcPath = currentDir + File.separator + "src";
        //String srcPath = "C:\\Users\\roush\\Downloads\\Algo-Expert\\src";
        Queue<File> queue = new LinkedList<>();
        File root = new File(srcPath);
        File[] files = root.listFiles();
        if (files == null) return;
        addFileToQueue(queue, files);

        while (!queue.isEmpty()) {
            File currentFile = queue.poll();

            if (currentFile.isDirectory()) {
                File[] subFiles = currentFile.listFiles();
                addFileToQueue(queue, subFiles);
            }
            else if (currentFile.isFile() && currentFile.getName().endsWith(".java")) {
                String packageName = getPackageName(root, currentFile);

                // Start a new package section
                if (!packageName.equals(currentPackage)) {
                    serialNo = 1;
                    if (!currentPackage.isEmpty()) {
                        printLine();
                        System.out.println();
                    }
                    printHeader(packageName);
                }

                // Print row
                printRow(serialNo, currentFile.getName(), packageName);
                serialNo++;
                currentPackage = packageName;
            }
        }
        printLine();
    }

    private static void printHeader(String packageName) {
        printLine();
        System.out.printf("| %-4s | %-35s | %-20s |%n", "No", "Filename", "Package");
        printLine();
    }

    private static void printRow(int no, String filename, String packageName) {
        System.out.printf("| %-4d | %-35s | %-20s |%n", no, filename, packageName);
    }

    private static void printLine() {
        System.out.println("+------+-------------------------------------+----------------------+");
    }

    private static void addFileToQueue(Queue<File> queue, File[] files) {
        if (files == null) return;
        for (File file : files) queue.add(file);
    }

    private static String getPackageName(File srcRoot, File javaFile) {
        String srcPath = srcRoot.getAbsolutePath();
        String filePath = javaFile.getAbsolutePath();
        int srcPathLength = srcPath.length() + 1;
        int lastPathSeparatorIndex = filePath.lastIndexOf(File.separator);

        // Remove src path and file name
        String relativePath = srcPathLength > lastPathSeparatorIndex ? "": filePath.substring(srcPathLength, lastPathSeparatorIndex);

        // Convert folder separators to dots
        return relativePath.replace(File.separatorChar, '.');
    }

}