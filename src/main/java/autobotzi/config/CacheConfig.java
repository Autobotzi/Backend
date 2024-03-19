package autobotzi.config;

import com.google.common.cache.CacheBuilder;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(
                "images", "userSkills", "departments"
                , "users", "organizations", "roles", "projects")
        {
            @NotNull
            @Override
            protected Cache createConcurrentMapCache(@NotNull final String name) {
                return new ConcurrentMapCache(name,
                        CacheBuilder.newBuilder().expireAfterWrite(60, TimeUnit.SECONDS).build().asMap(), false);
            }
        };
    }
}