package autobotzi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Autobotzi", version = "v1"))
@SecuritySchemes(value = {
        @SecurityScheme(
                type = SecuritySchemeType.HTTP,
                scheme = "bearer",
                bearerFormat = "JWT"
        )
})
public class OpenAPIConfig {
//    @Bean
//    public Docket api(ServletContext servletContext) {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .securitySchemes(List.of(apiKey()))
//                .securityContexts(Collections.singletonList(securityContext()));
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
//        return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("Bearer", "Authorization", "header");
//    }
}
