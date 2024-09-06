package pl.pingwit.pingwitdentalmanager.repository.dental_service;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table (name = "service")
public class DentalService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id_generator")
    @Column(name = "id")
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "description")
    private String description;
    @Column (name = "price")
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}