package com.utamatisi.app.client;

import com.utamatisi.app.auth.ExampleAuthenticator;
import com.utamatisi.app.auth.ExampleAuthorizer;
import com.utamatisi.app.db.*;
import com.utamatisi.app.filter.DateRequiredFeature;
import com.utamatisi.app.models.User;
import com.utamatisi.app.resources.*;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.hibernate.SessionFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Created by titus.chirchir12
 * Date Created 1/24/2016.
 * Package: ${PACKAGE}
 */
public class ResourceRegister {
    private static final String ALLOWED_HEADERS = "X-Requested-With,Content-Type,Accept,Origin";
    private static final String ALLOWED_METHODS = "OPTIONS,GET,PUT,POST,DELETE,HEAD";
    public static void registerResources(JerseyEnvironment jersey) {
        jersey.register(DateRequiredFeature.class);
        jersey.register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new ExampleAuthenticator())
                .setAuthorizer(new ExampleAuthorizer())
                .setRealm("SUPER SECRET STUFF")
                .buildAuthFilter()));
        jersey.register(new AuthValueFactoryProvider.Binder<>(User.class));
        jersey.register(RolesAllowedDynamicFeature.class);
    }

    public static void registerHibernateResources(JerseyEnvironment jersey, HibernateBundle<DropwizardConfiguration> hibernateBundle) {
        SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
        jersey.register(new TodoResource(new TodoDAO(sessionFactory)));
        jersey.register(new StockResource(new StockDAO(sessionFactory)));
        jersey.register(new PortfolioResource(new PortfolioDAO(sessionFactory)));
        jersey.register(new MonteCarloResource());
    }
    public static void registerCors(Environment environment) {
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", ALLOWED_HEADERS);
        cors.setInitParameter("allowedMethods", ALLOWED_METHODS);
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
