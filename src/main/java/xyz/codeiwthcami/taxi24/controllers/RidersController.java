package xyz.codeiwthcami.taxi24.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.codeiwthcami.taxi24.models.Driver;
import xyz.codeiwthcami.taxi24.models.Rider;
import xyz.codeiwthcami.taxi24.services.DriverService;
import xyz.codeiwthcami.taxi24.services.RiderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/riders")
public class RidersController {
    private final RiderService riderService;

    public RidersController(RiderService riderService, DriverService driverService) {
        this.riderService = riderService;
    }

    @GetMapping("")
    public ResponseEntity<List<Rider>> getAllRiders() {
        return ResponseEntity.ok(riderService.getAllRiders());
    }

    // get rider by id
    @GetMapping("/{id}")
    public ResponseEntity<Rider> getRiderById(@PathVariable Long id) {

        Rider riderById = riderService.findRiderById(id);

        if (riderById == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(riderById);
    }

    // get closes driver by specific rider
    @GetMapping("/closest-drivers")
    public ResponseEntity<List<Driver>> getClosestDrivers(
            @RequestParam(value = "lat") Double lat,
            @RequestParam(value = "lng") Double lng) {

        return ResponseEntity.ok(riderService.getClosestDrivers(lat, lng));
    }

}
