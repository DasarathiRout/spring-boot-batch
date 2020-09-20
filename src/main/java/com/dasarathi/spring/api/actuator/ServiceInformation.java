package com.dasarathi.spring.api.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ServiceInformation implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> environmentVariables = System.getenv();
        builder.withDetail("environmentVariables", environmentVariables);
    }
}
