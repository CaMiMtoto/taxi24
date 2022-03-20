package xyz.codeiwthcami.taxi24.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xyz.codeiwthcami.taxi24.models.Driver;

import java.util.List;


public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findAllByIsAvailable(boolean isAvailable);

    @Query(value = "select * from (SELECT *, (select *from SQRT(POW(69.1 * (cast(latitude as double precision) - :latitude), 2) + POW(69.1 * (:longitude - cast(longitude as double precision)) * COS(cast(latitude as double precision) / 57.3), 2)) AS distance) FROM drivers) al ORDER BY distance limit :limit", nativeQuery = true)
    List<Driver> findDriversOrderByClosestDistance(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("limit") int limit);

    @Query(value = "select * from (SELECT *, (select *from SQRT(POW(69.1 * (cast(latitude as double precision) - :latitude), 2) + POW(69.1 * (:longitude - cast(longitude as double precision)) * COS(cast(latitude as double precision) / 57.3), 2)) AS distance) FROM drivers) al where distance <=:limit ORDER BY distance", nativeQuery = true)
    List<Driver> findDriversWithinSpecificDistance(@Param("latitude") double latitude, @Param("longitude") double longitude, @Param("limit") double limit);

}
