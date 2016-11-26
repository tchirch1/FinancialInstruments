package com.utamatisi.app.resources;

import com.utamatisi.app.db.TodoDAO;
import com.utamatisi.app.models.domain.Todo;
import controller.UsefulFunctions;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import org.eclipse.collections.impl.list.mutable.FastList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public List<List<Double>> monte() {
        List<List<Double>> things = FastList.newList();
        double time = 1/12.0;
        int N = 30;
        things.add(timeBand(time, N));
        int M = 200;
        for (int i=0;i<=M;i++) {
            final List<Double> vals = UsefulFunctions.randomGaussian(N);
            vals.set(0, 20.0);
            for (int j=0;j<N-1;j++) {
                vals.set(j+1, vals.get(j) + vals.get(j+1));
            }
            things.add(vals);
        }
        return things;
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
