package es.moki.ratelimij;


import es.moki.ratelimitj.RateLimiter;
import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RateLimitBundle<T extends Configuration> implements ConfiguredBundle<T> {

    private final RateLimiter rateLimit;

    public RateLimitBundle(RateLimiter rateLimit) {
        this.rateLimit = rateLimit;
    }

    @Override
    public void run(T configuration, Environment environment) throws Exception {


        // TODO provide decoupled mechanism to bind ratelimit implementation to dropwizard

        RateLimitFilter rateLimitFilter = new RateLimitFilter(rateLimit);
        environment.jersey().register(rateLimitFilter);
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {

    }
}