package com.dasarathi.spring.api.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Random;
@Component
public class CountVisualizeRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(CountVisualizeRegistry.class);
    private static final Random randomMe = new Random();
    private static final int oneSec = 1000;

    @Autowired
    MeterRegistry meterRegistry;

    public void dasarathiCounter() {
            meterRegistry.timer("count.visualize.registry").record(Duration.ofMillis(randomMe.nextInt(3) * oneSec));
    }
}


