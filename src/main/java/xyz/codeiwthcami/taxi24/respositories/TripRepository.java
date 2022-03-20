package xyz.codeiwthcami.taxi24.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.codeiwthcami.taxi24.models.Trip;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByCompleted(boolean completed);

}
