package xyz.codeiwthcami.taxi24.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.codeiwthcami.taxi24.models.Trip;
import xyz.codeiwthcami.taxi24.respositories.TripRepository;

import java.util.List;

@Service
@Slf4j
public class TripService {
    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip saveTrip(Trip trip) {
        trip.getDriver().setIsAvailable(false);
        return tripRepository.save(trip);
    }

    public Trip completeTrip(Trip trip) {
        trip.setCompleted(true);
        trip.getDriver().setIsAvailable(true);
        return tripRepository.save(trip);
    }

    public List<Trip> getActiveTrips() {
        return tripRepository.findByCompleted(false);
    }


    public Trip findTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }
}
