package Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "hotels")
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "hotel_name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "stars")
    private int stars;

    @Column(name = "daily_price")
    private BigDecimal dailyPrice;
}
