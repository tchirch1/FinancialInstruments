package simulations;

/**
 * Created by titus.chirchir12 on 11/28/2016.
 */
import com.utamatisi.app.models.domain.Stock;

import javax.ws.rs.client.ClientBuilder;
import java.io.*;
import java.net.*;

public class Rest {

    public static void main(String[] args) throws IOException {
        Stock responseEntity = ClientBuilder.newClient()
                .target("http://localhost:9123/").path("stocks/test")
                .request().get(Stock.class);
        System.out.print(responseEntity.getCompanyName()+" ("+responseEntity.getSymbol()+") @ $" + responseEntity.getValue());
    }
}
