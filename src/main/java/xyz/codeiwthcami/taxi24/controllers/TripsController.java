package xyz.codeiwthcami.taxi24.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.codeiwthcami.taxi24.models.Driver;
import xyz.codeiwthcami.taxi24.models.Rider;
import xyz.codeiwthcami.taxi24.models.Trip;
import xyz.codeiwthcami.taxi24.services.DriverService;
import xyz.codeiwthcami.taxi24.services.RiderService;
import xyz.codeiwthcami.taxi24.services.TripService;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/trips")
@Slf4j
public class TripsController {
    private final TripService tripService;
    private final DriverService driverService;
    private final RiderService riderService;

    public TripsController(TripService tripService, DriverService driverService, RiderService riderService) {
        this.tripService = tripService;
        this.driverService = driverService;
        this.riderService = riderService;
    }


    @PostMapping("")
    public ResponseEntity<?> createTrip(@Valid Trip trip) throws URISyntaxException {

        Driver driver = driverService.findDriverById(trip.getDriverId());
        Map<String, String> errors = new HashMap<>();
        if (driver == null) {
            errors.put("driver", "Driver not found");
            return ResponseEntity.badRequest().body(errors);
        }
        Rider rider = riderService.findRiderById(trip.getRiderId());
        if (rider == null) {
            errors.put("rider", "Rider not found");
            return ResponseEntity.badRequest().body(errors);
        }

        trip.setDriver(driver);
        trip.setRider(rider);

        log.info("Creating trip: {}", trip.toString());


        Trip savedTrip = tripService.saveTrip(trip);

        return ResponseEntity.created(
                new URI("/api/v1/trips/" + savedTrip.getId())
        ).body(savedTrip);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTrip(@PathVariable Long id) {
        Trip trip = tripService.findTripById(id);
        if (trip == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trip);
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<Trip> completeTrip(@PathVariable Long id) {

        Trip trip = tripService.findTripById(id);
        if (trip == null) {
            return ResponseEntity.notFound().build();
        }

        Trip completedTrip = tripService.completeTrip(trip);
        return ResponseEntity.ok(completedTrip);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Trip>> getActiveTrips() {
        return ResponseEntity.ok(tripService.getActiveTrips());
    }

}
