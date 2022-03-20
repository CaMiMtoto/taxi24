package xyz.codeiwthcami.taxi24.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trips")
@ToString
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull(message = "Specify the trip's origin latitude")
    @Column(nullable = false)
    private Double sourceLatitude;

    @NotNull(message = "Specify the trip's origin longitude")

    @Column(nullable = false)
    private Double sourceLongitude;

    @NotNull(message = "Specify the trip's destination latitude")
    @Column(nullable = false)
    private Double destinationLatitude;

    @NotNull(message = "Specify the trip's destination longitude")
    @Column(nullable = false)
    private Double destinationLongitude;

    @NotNull(message = "Please provide driverId")
    @Column(insertable = false, updatable = false, name = "driver_id")
    private Long driverId;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @NotNull(message = "Please provide riderId")
    @Column(insertable = false, updatable = false, name = "rider_id")
    private Long riderId;

    @ManyToOne
    @JoinColumn(name = "rider_id")
    private Rider rider;

    @Column(columnDefinition = "boolean default false")
    private boolean completed = false;


    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT now()")
    @UpdateTimestamp
    private Date updatedAt;

}
