package app.resources;

import app.models.MonteCarlo;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by titus.chirchir12
 * Date Created 2/27/2016.
 * Package: ${PACKAGE}
 */
@Path("/montes")
@Produces(MediaType.APPLICATION_JSON)
public class MonteCarloResource
{

    public MonteCarloResource()
    {
    }

    @GET
    @UnitOfWork
    public MonteCarlo monteMans(@QueryParam("s0") double s0, @QueryParam("sigma") double sigma, @QueryParam("r") double r, @QueryParam("nValue") int N, @QueryParam("mValue") int M, @QueryParam("time") double time)
    {
        return new MonteCarlo(s0, r, sigma, time, N, M);
    }
}
