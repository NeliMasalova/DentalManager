package pl.pingwit.pingwitdentalmanager.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "id")
    private Appointment appointment;
    @Column(name = "date")
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypePayment typePayment;
    @Column(name = "amount")
    private BigDecimal amount;

    public Payment() {
    }

    public Payment(Long id, String name, Appointment appointment, LocalDate date, TypePayment typePayment, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.appointment = appointment;
        this.date = date;
        this.typePayment = typePayment;
        this.amount = amount;
    }

    public Payment(String name, Appointment appointment, LocalDate date, TypePayment typePayment) {
    }

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

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment aAppointment) {
        this.appointment = appointment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TypePayment getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(TypePayment typePayment) {
        this.typePayment = typePayment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
