import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String folderName;
    private int numFiles;
    private long sizeFiles;
    private List<TreeNode> childNodes;
    private List<String> filesInFolder;

    public TreeNode(String folderName) {
        this.folderName = folderName;
        this.numFiles = 0;
        this.sizeFiles = 0;
        this.childNodes = new ArrayList<>();
        this.filesInFolder = new ArrayList<>();
    }

    public void addChildNode(TreeNode childNode) {
        this.childNodes.add(childNode);
    }

    public void incrementFileCount() {
        this.numFiles++;
    }

    public void incrementSize(long size) {
        this.sizeFiles += size;
    }

    public void addFile(String fileName) {
        this.filesInFolder.add(fileName);
    }

    public String getFolderName() {
        return this.folderName;
    }

    public int getNumFiles() {
        return this.numFiles;
    }

    public long getSizeFiles() {
        return this.sizeFiles;
    }

    public List<TreeNode> getChildNodes() {
        return this.childNodes;
    }

    public List<String> getFilesInFolder() {
        return this.filesInFolder;
    }
}