package pl.pingwit.pingwitdentalmanager.dto;


public class DoctorDto {
    private String name;
    private String surname;
    private String specialty;
    private String phone;
    private Double rate;

    public DoctorDto(String name, String surname, String specialty, String phone, Double rate) {
        this.name = name;
        this.surname = surname;
        this.specialty = specialty;
        this.phone = phone;
        this.rate = rate;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}