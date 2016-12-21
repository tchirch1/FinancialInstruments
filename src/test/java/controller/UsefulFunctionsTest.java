package controller;

import org.eclipse.collections.impl.list.mutable.FastList;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class UsefulFunctionsTest
{

    private UsefulFunctions usefulFunctions = new UsefulFunctions();

    @Test
    public void fibonacci() throws Exception
    {
        Assert.assertEquals(21, UsefulFunctions.fibonacci(8));
    }

    @Test
    public void reverse() throws Exception
    {
        Assert.assertEquals("rihcrihC sutiT", UsefulFunctions.reverse("Titus Chirchir"));

    }

    @Test
    public void factorial() throws Exception
    {
        Assert.assertEquals(40320, UsefulFunctions.factorial(8));

    }

    @Test
    public void mean() throws Exception
    {
        Assert.assertEquals(3.0, UsefulFunctions.mean(FastList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0)), 0.0001);
    }

    @Test
    public void variance() throws Exception
    {
        Assert.assertEquals(2.5, UsefulFunctions.variance(FastList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0)), 0.0001);
    }

}