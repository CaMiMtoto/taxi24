package xyz.codeiwthcami.taxi24.services;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import xyz.codeiwthcami.taxi24.models.Driver;
import xyz.codeiwthcami.taxi24.respositories.DriverRepository;

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
        for (int i = 0; i < 10; i++) {
            Driver driver = new Driver();
            driver.setName(faker.name().fullName());
            driver.setPhone(faker.phoneNumber().phoneNumber());
            driver.setEmail(faker.internet().emailAddress());
            driver.setLatitude(faker.address().latitude());
            driver.setLongitude(faker.address().longitude());
            driver.setIsAvailable(faker.bool().bool());
            driverRepository.save(driver);
        }
    }
}
