package com.utamatisi.app.models;

import javax.persistence.Column;
import java.util.List;

/**
 * Created by: tituskc
 * Created On  Sat, Nov 26, 2016 at 11:14 AM.
 */
public class MonteCarlo {
    @Column(name="time", nullable = false)
    private List<Double> timeSeries;
    @Column(name="simulation", nullable = false)
    private List<List<Double>> simulation;

    public MonteCarlo(List<Double> timeSeries, List<List<Double>> simulation)
    {
        this.timeSeries = timeSeries;
        this.simulation = simulation;
    }

    public List<Double> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(List<Double> timeSeries) {
        this.timeSeries = timeSeries;
    }

    public List<List<Double>> getSimulation() {
        return simulation;
    }

    public void setSimulation(List<List<Double>> simulation) {
        this.simulation = simulation;
    }
}
