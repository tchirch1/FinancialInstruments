package app.resources;

import app.db.PortfolioDAO;
import app.models.domain.Portfolio;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by titus.chirchir12
 * Date Created 2/27/2016.
 * Package: ${PACKAGE}
 */
@Path("/portfolios")
@Produces(MediaType.APPLICATION_JSON)
public class PortfolioResource
{

    private final PortfolioDAO portfolioDAO;

    public PortfolioResource(PortfolioDAO portfolioDAO)
    {
        this.portfolioDAO = portfolioDAO;
    }

    @GET
    @UnitOfWork
    public List<Portfolio> listPortfolios()
    {
        return portfolioDAO.findAll();
    }

    @POST
    @UnitOfWork
    public Portfolio createPortfolio(Portfolio portfolio)
    {
        return portfolioDAO.create(portfolio);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Response deletePortfolio(@QueryParam("id") LongParam id)
    {
        portfolioDAO.delete(id.get());
        return Response.ok().build();
    }

}
