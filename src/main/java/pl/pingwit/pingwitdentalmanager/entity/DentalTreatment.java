package pl.pingwit.pingwitdentalmanager.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "service")
public class DentalTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id_generator")
    @SequenceGenerator(name = "service_id_generator", sequenceName = "service_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigDecimal price;
    @ManyToMany(mappedBy = "dentalTreatments")
    private Set<Appointment> appointments = new HashSet<>();

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public DentalTreatment() {
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public DentalTreatment(Long id, String name, String description, BigDecimal price, Set<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
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