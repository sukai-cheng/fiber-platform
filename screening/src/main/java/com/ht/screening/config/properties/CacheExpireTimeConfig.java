package com.ht.screening.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * @author chengsukai
 */
@Component
@ConfigurationProperties(prefix = "cache-expire")
public class CacheExpireTimeConfig {
    private Map<String,Integer> ttl;

    public Map<String, Integer> getTtl() {
        return ttl;
    }

    public void setTtl(Map<String, Integer> ttl) {
        this.ttl = ttl;
    }
}
