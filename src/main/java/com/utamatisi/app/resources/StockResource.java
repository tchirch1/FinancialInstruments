package com.utamatisi.app.resources;

import com.utamatisi.app.db.StockDAO;
import com.utamatisi.app.models.domain.Stock;
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
@Path("/stocks")
@Produces(MediaType.APPLICATION_JSON)
public class StockResource
{

    private final StockDAO stockDAO;

    public StockResource(StockDAO stockDAO)
    {
        this.stockDAO = stockDAO;
    }

    @GET
    @UnitOfWork
    public List<Stock> listStocks()
    {
        return stockDAO.findAll();
    }


    @POST
    @UnitOfWork
    public Stock createStock(Stock stock)
    {
        return stockDAO.create(stock);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public Response deleteStock(@QueryParam("id") LongParam id)
    {
        stockDAO.delete(id.get());
        return Response.ok().build();
    }

}
