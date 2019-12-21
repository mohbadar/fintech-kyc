package af.asr.kyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {H2ConsoleAutoConfiguration.class})
@PropertySource(name = "jdbc.properties", value = "jdbc.properties")
public class KycApplication {

	public static void main(String[] args) {
		SpringApplication.run(KycApplication.class, args);
	}

}
