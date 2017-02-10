package simulations;

import sun.reflect.generics.tree.Tree;

/**
 * Created by: tituskc
 * Created On  Wed, Dec 21, 2016 at 2:40 PM.
 */
public class BinomialTree
{
    TreeNode parent;
    BinomialTree(int steps, double u, double d)
    {
        this.parent = TreeNode.createWithParent(null);
    }

}
