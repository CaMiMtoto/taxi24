package xyz.codeiwthcami.taxi24.services;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import xyz.codeiwthcami.taxi24.models.Driver;
import xyz.codeiwthcami.taxi24.models.Rider;
import xyz.codeiwthcami.taxi24.respositories.DriverRepository;
import xyz.codeiwthcami.taxi24.respositories.RiderRepository;

import java.util.List;
import java.util.Locale;

@Service
public class RiderService {
    private final RiderRepository riderRepository;
    private final DriverRepository driverRepository;

    public RiderService(RiderRepository riderRepository, DriverRepository driverRepository) {
        this.riderRepository = riderRepository;
        this.driverRepository = driverRepository;
    }

    // get all riders from database
    public List<Rider> getAllRiders() {
        return riderRepository.findAll();
    }

    public Rider saveRider(Rider rider) {
        return riderRepository.save(rider);
    }

    public Rider findRiderById(Long id) {
        return riderRepository.findById(id).orElse(null);
    }

    public void seedRiders() {
        Faker faker = new Faker(Locale.US);
        for (int i = 0; i < 10; i++) {
            Rider rider = new Rider();
            rider.setName(faker.name().fullName());
            rider.setPhone(faker.phoneNumber().cellPhone());
            rider.setEmail(faker.internet().emailAddress());
            riderRepository.save(rider);
        }
    }

    public List<Driver> getClosestDrivers( Double lat, Double lng) {
        return driverRepository.findDriversOrderByClosestDistance(lat, lng, 3);
    }
}
