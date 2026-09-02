package Api.Constructor.Version1.Swagger;

import Api.Constructor.Version1.database.model.Cadastro;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class CadastroSwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("Cadastro API")
                .description("Documentacao da API para gerenciamento de cadastros")
                .version("1.0"));
    }
}
