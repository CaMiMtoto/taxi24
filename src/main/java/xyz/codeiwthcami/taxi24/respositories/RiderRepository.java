package xyz.codeiwthcami.taxi24.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.codeiwthcami.taxi24.models.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long> {

}
