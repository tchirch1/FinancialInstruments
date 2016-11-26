package com.utamatisi.app.resources;

import com.utamatisi.app.models.MonteCarlo;
import controller.UsefulFunctions;
import io.dropwizard.hibernate.UnitOfWork;
import org.eclipse.collections.impl.list.mutable.FastList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by titus.chirchir12
 * Date Created 2/27/2016.
 * Package: ${PACKAGE}
 */
@Path("/montes")
@Produces(MediaType.APPLICATION_JSON)
public class MonteCarloResource {

    public MonteCarloResource() {
    }

    @GET
    @UnitOfWork
    @Path("/{size}/{mValue}")
    public MonteCarlo monteMans(@PathParam("size") int N,
                                @PathParam("mValue") int M,
                                @QueryParam("time") double time) {
        List<List<Double>> things = FastList.newList();
        for (int i=0;i<M;i++) {
            final List<Double> vals = UsefulFunctions.randomGaussian(N);
            vals.set(0, 20.0);
            for (int j=0;j<N-1;j++) {
                vals.set(j+1, vals.get(j) + vals.get(j+1));
            }
            things.add(vals);
        }
        return new MonteCarlo(timeBand(time, N), things);
    }
    public static List<Double> timeBand(double T, int N)
    {
        double delta = T/N;
        List<Double> list = FastList.newList();
        for (int i=0; i<N;i++)
        {
            list.add(delta * i);
        }
        return list;
    }
}
