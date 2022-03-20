package xyz.codeiwthcami.taxi24.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.codeiwthcami.taxi24.models.Driver;
import xyz.codeiwthcami.taxi24.services.DriverService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drivers")
public class DriversController {
    private final DriverService driverService;

    public DriversController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("")
    public ResponseEntity<List<Driver>> getDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/available")
    public ResponseEntity<List<Driver>> getAllAvailable() {
        return ResponseEntity.ok(driverService.getAllAvailable());
    }

    // get a driver by id
    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        Driver driverById = driverService.findDriverById(id);

        if (driverById == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(driverById);
    }

    // get closes driver by specific rider
    @GetMapping("/available/in-range")
    public ResponseEntity<List<Driver>> getAvailableWithingDistance(
            @RequestParam(value = "lat") Double lat,
            @RequestParam(value = "lng") Double lng,
            @RequestParam(value = "range") Double range
    ) {

        return ResponseEntity.ok(driverService.findDriversWithinSpecificDistance(lat, lng, range));
    }
}
