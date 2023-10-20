//Author: Tristin Young

//importing necessary packages
import java.io.File;
import java.util.Scanner;


//fileTree class
public class FileTree {

    //buildTree method
    //takes in initial file path and verifies that it is a directory
    //if it is a directory, it calls recBuildTree method
    public static TreeNode buildTree(String path) {
        File root = new File(path);
        if (!root.isDirectory() || !root.exists()) {
            return null;
        }
        return recBuildTree(root);
    }

    //recBuildTree method
    private static TreeNode recBuildTree(File directory) {
        //takes in a file and creates a TreeNode for it
        TreeNode folder = new TreeNode(directory.getName());

        File[] files = directory.listFiles();
        if (files == null) {
            return folder;
        } else {
            for (File file : files) {
                //ignores hidden files
                if (!file.getName().startsWith(".")) {
                    //if the file is a directory, it recursively calls itself
                    if (file.isDirectory()) {
                        TreeNode subFolder = recBuildTree(file);
                        if (subFolder.getNumFiles() > 0 || subFolder.getChildNodes().size() > 0) {
                            folder.addChildNode(subFolder);
                        }
                    //if the file is a file, it increments the file count and size
                    } else {
                        folder.incrementFileCount();
                        folder.incrementSize(file.length());
                        folder.addFile(file.getName());
                    }
                }
            }
        }
        //returns the TreeNode
        return folder;
    }

    //printTree method
    private static void printTree(TreeNode root, int depth) {

        //handles spacing of tree structure
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        //printing for folders
        System.out.println(">" + root.getFolderName() + " (" + root.getNumFiles() + " files, " + root.getSizeFiles() + " bytes)");
        //handles spacing of tree structure
        for (String fileName : root.getFilesInFolder()) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            //printing for files
            System.out.println("  --" + fileName);
        }
        //recursively calls itself for each child node
        for (TreeNode child : root.getChildNodes()) {
            printTree(child, depth + 1);
        }
    }

    //main method
    public static void main(String[] args) {
        //takes in user input for file path
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path to directory: ");
        String path = sc.nextLine();
        sc.close();

        //calls buildTree method and prints the tree
        TreeNode root = buildTree(path);
        if (root == null) {
            System.out.println("Invalid path");
        } else {
            printTree(root, 0);
        }
    }
}