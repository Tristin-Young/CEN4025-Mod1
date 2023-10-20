import java.io.File;
import java.util.Scanner;

public class FileTree {
    public static TreeNode buildTree(String path) {
        File root = new File(path);
        if (!root.isDirectory() || !root.exists()) {
            return null;
        }
        return recBuildTree(root);
    }

    private static TreeNode recBuildTree(File directory) {
        TreeNode folder = new TreeNode(directory.getName());

        File[] files = directory.listFiles();
        if (files == null) {
            return folder;
        } else {
            for (File file : files) {
                if (!file.getName().startsWith(".")) {
                    if (file.isDirectory()) {
                        TreeNode subFolder = recBuildTree(file);
                        if (subFolder.getNumFiles() > 0 || subFolder.getChildNodes().size() > 0) {
                            folder.addChildNode(subFolder);
                        }
                    } else {
                        folder.incrementFileCount();
                        folder.incrementSize(file.length());
                        folder.addFile(file.getName());
                    }
                }
            }
        }
        return folder;
    }

    private static void printTree(TreeNode root, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(">" + root.getFolderName() + " (" + root.getNumFiles() + " files, " + root.getSizeFiles() + " bytes)");
        for (String fileName : root.getFilesInFolder()) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.println("  --" + fileName);
        }
        for (TreeNode child : root.getChildNodes()) {
            printTree(child, depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path to directory: ");
        String path = sc.nextLine();
        sc.close();

        TreeNode root = buildTree(path);
        if (root == null) {
            System.out.println("Invalid path");
        } else {
            printTree(root, 0);
        }
    }
}