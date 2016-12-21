package controller;

import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.utility.ListIterate;

import java.util.List;
import java.util.Random;

/**
 * Created by: tituskc
 * Created On  Wed, Nov 23, 2016 at 9:22 AM.
 */
public class UsefulFunctions
{

    static int fibonacci(int i)
    {
        return i <= 2 ? 1 : fibonacci(i - 2) + fibonacci(i - 1);
    }

    static String reverse(String toReverse)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = toReverse.length() - 1; i >= 0; i--) {
            sb.append(toReverse.charAt(i));
        }
        return sb.toString();
    }

    static int factorial(int i)
    {
        return i <= 1 ? 1 : factorial(i - 1) * i;
    }

    public static double mean(List<Double> values)
    {
        final double[] sum = new double[1];
        ListIterate.forEach(values, (Procedure<Double>) val -> sum[0] += val);
        return sum[0] / values.size();
    }

    public static double variance(List<Double> values)
    {
        double mean = mean(values);
        final double[] sum = new double[1];
        ListIterate.forEach(values, (Procedure<Double>) val -> sum[0] += Math.pow((val - mean), 2));
        return sum[0] / (values.size() - 1);
    }

    public static double max(double a, double b)
    {
        return a > b ? a : b;
    }

    public static List<Double> randomGaussian(int size)
    {
        List<Double> array = FastList.newList();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextGaussian());
        }
        return array;
    }

    public static double var(List<Double> values, double varAt)
    {
        int position = (int) ((1 - varAt) * values.size());
        values.sort((o1, o2) -> o1 > o2 ? 1 : 0);
        return values.get(position);
    }

    public static double cVar(List<Double> values, double cVarAt)
    {
        int position = (int) ((1 - cVarAt) * values.size());
        values.sort((o1, o2) -> o1 > o2 ? 1 : 0);
        double sum = 0.0;
        for (int i = 0; i < position; i++) {
            sum += values.get(i);
        }
        return sum / position;
    }
}
