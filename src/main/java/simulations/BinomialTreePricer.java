package simulations;

import controller.OptionPricer;
import model.Option;

/**
 * Created by: tituskc
 * Created On  Wed, Dec 21, 2016 at 2:37 PM.
 */
public class BinomialTreePricer<T extends Option> implements OptionPricer<T>
{

    private double strike;
    private double spot;
    private int numberOfSteps;

    public BinomialTreePricer(double strike, double spot, int numberOfSteps)
    {
        this.strike = strike;
        this.spot = spot;
        this.numberOfSteps = numberOfSteps;
    }


    @Override
    public Double valueOf(T t)
    {
        TreeNode treeNode = new TreeNode();
        buildTree(0, true, treeNode);
        double val = 0;
        TreeNode current = treeNode;
        while (current.hasNext())
        {
            val+=current.value;
            current = current.up;
        }
        return val;
    }

    private void buildTree(int n, boolean up, TreeNode treeNode)
    {
        if (n > numberOfSteps) {
            return;
        }

        TreeNode newUp = TreeNode.createWithParent(treeNode);
        TreeNode newDown = TreeNode.createWithParent(treeNode);
        final double value = treeNode.parent == null ? 0.0 : (up ? this.spot + treeNode.parent.value : -1 * this.strike + treeNode.parent.value);
        treeNode.setChildren(newUp, newDown, value);
        buildTree(++n, true, newUp);
        buildTree(n, false, newDown);
    }
}
