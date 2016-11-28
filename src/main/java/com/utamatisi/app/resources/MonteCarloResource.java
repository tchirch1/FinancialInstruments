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
    public MonteCarlo monteMans(@QueryParam("s0") double s0,
                                @QueryParam("sigma") double sigma,
                                @QueryParam("r") double r,
                                @QueryParam("nValue") int N,
                                @QueryParam("mValue") int M,
                                @QueryParam("time") double time) {
        return new MonteCarlo(s0,r,sigma, time, N, M);
    }
}
