package com.dasarathi.spring.api.actuator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "dasarathi")
public class UserActuatorEndPoint {

    private Map<String, Feature> features = new ConcurrentHashMap<>();

    @PostConstruct
    private void init() {
        features.put("K1", new Feature("New Custom End Point K1", true));
        features.put("K2", new Feature("New Custom End Point K2", true));
        features.put("K3", new Feature("New Custom End Point K3", true));
        features.put("K4", new Feature("New Custom End Point K4", true));
        features.put("K5", new Feature("New Custom End Point K5", true));
    }

    @ReadOperation
    public Map<String, Feature> features() {
        return features;
    }

    @ReadOperation
    public Feature feature(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation
    public void configureFeature(@Selector String name, Feature feature) {
        features.put(name, feature);
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        features.remove(name);
    }

    public static class Feature {

        private String details;
        private Boolean enabled;

        public Feature() {
            this.details = null;
            this.enabled = null;
        }

        public Feature(String details, Boolean enabled) {
            this.details = details;
            this.enabled = enabled;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public Boolean getEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

    }
}
