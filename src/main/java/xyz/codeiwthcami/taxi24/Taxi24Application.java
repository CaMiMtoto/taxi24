package xyz.codeiwthcami.taxi24;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import xyz.codeiwthcami.taxi24.services.DriverService;
import xyz.codeiwthcami.taxi24.services.RiderService;

@SpringBootApplication
public class Taxi24Application {

    public static void main(String[] args) {
        SpringApplication.run(Taxi24Application.class, args);
    }

    @Bean
    CommandLineRunner runner(DriverService driverService, RiderService riderService) {
        return args -> {
            driverService.seedDrivers();
            riderService.seedRiders();
        };
    }
}
