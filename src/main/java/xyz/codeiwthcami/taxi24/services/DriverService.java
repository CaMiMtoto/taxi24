package xyz.codeiwthcami.taxi24.services;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import xyz.codeiwthcami.taxi24.models.Driver;
import xyz.codeiwthcami.taxi24.respositories.DriverRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DriverService {
    private final DriverRepository driverRepository;


    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public List<Driver> getAllAvailable() {
        return driverRepository.findAllByIsAvailable(true);
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver findDriverById(Long id) {
        return driverRepository.findById(id).orElse(null);
    }

    public List<Driver> findDriversWithinSpecificDistance(double latitude, double longitude, double distance) {
        return driverRepository.findDriversWithinSpecificDistance(latitude, longitude, distance);
    }

    public void seedDrivers() {
        Faker faker = new Faker(new Random(24));

        List<Driver> drivers = new ArrayList<>();

        drivers.add(new Driver(
                faker.name().fullName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                String.valueOf(-1.956537),
                String.valueOf(30.063616),
                true
        ));

        drivers.add(new Driver(
                faker.name().fullName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                String.valueOf(-1.971142),
                String.valueOf(30.103683),
                true
        ));
        drivers.add(new Driver(
                faker.name().fullName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                String.valueOf(-1.949549),
                String.valueOf(30.126161),
                false
        ));
        drivers.add(new Driver(
                faker.name().fullName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                String.valueOf(-1.978963),
                String.valueOf(30.223335),
                true
        ));
        drivers.add(new Driver(
                faker.name().fullName(),
                faker.phoneNumber().cellPhone(),
                faker.internet().emailAddress(),
                String.valueOf(-1.977940),
                String.valueOf(30.043773),
                true
        ));

        driverRepository.saveAll(drivers);

    }
}
