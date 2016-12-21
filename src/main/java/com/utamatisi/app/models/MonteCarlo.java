package com.utamatisi.app.models;

import controller.UsefulFunctions;
import org.eclipse.collections.impl.list.mutable.FastList;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by: tituskc
 * Created On  Sat, Nov 26, 2016 at 11:14 AM.
 */
public class MonteCarlo
{

    @Column(name = "time", nullable = false)
    private List<Double> timeSeries;
    @Column(name = "simulation", nullable = false)
    private List<List<Double>> simulation;

    public MonteCarlo(double s0, double r, double sigma, double T, int N, int M)
    {
        this.timeSeries = timeBand(T, N);
        this.simulation = getLists(s0, r, sigma, T, N, M);
    }

    private static List<Double> timeBand(double T, int N)
    {
        double delta = T / N;
        List<Double> list = FastList.newList();
        for (int i = 0; i <= N; i++) {
            list.add(delta * i);
        }
        return list;
    }

    private static List<List<Double>> getLists(double s0, double r, double sigma, double T, int N, int M)
    {
        List<List<Double>> things = FastList.newList();
        double dt = T / N;
        double muDt = (r + sigma * sigma / 2) * dt;
        for (int i = 0; i < M; i++) {
            final List<Double> vals = UsefulFunctions.randomGaussian(N + 1);
            vals.set(0, s0);
            for (int j = 0; j < N; j++) {
                vals.set(j + 1, vals.get(j) * Math.exp(muDt + sigma * Math.sqrt(dt) * vals.get(j + 1)));
            }
            things.add(vals);
        }
        return things;
    }

    public List<Double> getTimeSeries()
    {
        return timeSeries;
    }

    public void setTimeSeries(List<Double> timeSeries)
    {
        this.timeSeries = timeSeries;
    }

    public List<List<Double>> getSimulation()
    {
        return simulation;
    }

    public void setSimulation(List<List<Double>> simulation)
    {
        this.simulation = simulation;
    }

}
