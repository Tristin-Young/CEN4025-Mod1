//imprting packages
import java.util.ArrayList;
import java.util.List;

//TreeNode class
public class TreeNode {
    private String folderName;
    private int numFiles;
    private long sizeFiles;
    private List<TreeNode> childNodes;
    private List<String> filesInFolder;

    //constructor
    public TreeNode(String folderName) {
        this.folderName = folderName;
        this.numFiles = 0;
        this.sizeFiles = 0;
        this.childNodes = new ArrayList<>();
        this.filesInFolder = new ArrayList<>();
    }

    //adding child nodes
    public void addChildNode(TreeNode childNode) {
        this.childNodes.add(childNode);
    }
    //incrementing file count
    public void incrementFileCount() {
        this.numFiles++;
    }
    //incrementing size
    public void incrementSize(long size) {
        this.sizeFiles += size;
    }
    //adding files
    public void addFile(String fileName) {
        this.filesInFolder.add(fileName);
    }
    //getting folder name
    public String getFolderName() {
        return this.folderName;
    }
    //getting file count
    public int getNumFiles() {
        return this.numFiles;
    }
    //getting size
    public long getSizeFiles() {
        return this.sizeFiles;
    }
    //getting child nodes
    public List<TreeNode> getChildNodes() {
        return this.childNodes;
    }
    //getting files
    public List<String> getFilesInFolder() {
        return this.filesInFolder;
    }
}