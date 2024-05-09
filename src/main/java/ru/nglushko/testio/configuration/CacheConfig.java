package ru.nglushko.testio.configuration;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.ehcache.jsr107.EhcacheCachingProvider;
import org.ehcache.xml.XmlConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.cache.Caching;

@Configuration
@EnableConfigurationProperties(CacheProperties.class)
@EnableCaching
@RequiredArgsConstructor
public class CacheConfig {

    private final CacheProperties cacheProperties;

    @SneakyThrows
    @Bean
    public CacheManager ehCacheManager() {
        Resource configLocation = cacheProperties.resolveConfigLocation(cacheProperties.getJcache().getConfig());
        org.ehcache.config.Configuration xmlConfig = new XmlConfiguration(configLocation.getURL());
        EhcacheCachingProvider provider = (EhcacheCachingProvider) Caching.getCachingProvider("org.ehcache.jsr107.EhcacheCachingProvider");
        return new JCacheCacheManager(provider.getCacheManager(provider.getDefaultURI(), xmlConfig));
    }
}