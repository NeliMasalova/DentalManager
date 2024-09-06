package pl.pingwit.pingwitdentalmanager.repository.patient;

import jakarta.persistence.*;
import pl.pingwit.pingwitdentalmanager.repository.appointment.Appointment;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_id_generator")
    @Column(name = "id")
    private Long id;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Column (name = "birthdate")
    private LocalDate birthdate;
    @Column (name = "email")
    private String email;
    @Column (name = "phone")
    private String phone;
    @Column (name = "address")
    private String address;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    public Patient() {
    }

    public Patient(String name, String surname, LocalDate birthdate, String email, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
        this.phone = phone;
        this.address = address;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
