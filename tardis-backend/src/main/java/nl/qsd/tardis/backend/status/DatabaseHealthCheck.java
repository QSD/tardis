package nl.qsd.tardis.backend.status;

import com.codahale.metrics.health.HealthCheck;

import java.util.Random;

public class DatabaseHealthCheck extends HealthCheck {

    private final Random random = new Random();

    @Override
    protected Result check() throws Exception {
        if (random.nextInt(5) % 5 == 1) {
            return Result.healthy();
        } else {
            return Result.unhealthy("Cannot is down");
        }
    }

}
