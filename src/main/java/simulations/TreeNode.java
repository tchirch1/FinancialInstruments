package simulations;

/**
 * Created by: tituskc
 * Created On  Wed, Dec 21, 2016 at 2:40 PM.
 */
public class TreeNode
{
    public TreeNode up;
    public TreeNode down;
    public TreeNode parent;
    public double value;

    public static TreeNode createWithParent(TreeNode parent)
    {
        TreeNode treeNode = new TreeNode();
        treeNode.parent = parent;
        return treeNode;
    }
    public void setChildren(TreeNode up, TreeNode down, double value)
    {
        this.up = up;
        this.value = value;
        this.down = down;
    }
    public boolean hasNext()
    {
        return this.up != null || this.down !=null;
    }
}
