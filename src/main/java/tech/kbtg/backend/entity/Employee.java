package tech.kbtg.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "status")
    private String status;

    @Column(name = "address")
    private String address;
    @Column(name = "position")
    private String position;

    public Employee() {
    }

    public Employee(String firstname, String lastname, String nickname, Integer salary, String status, String address, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nickname = nickname;
        this.salary = salary;
        this.status = status;
        this.address = address;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", salary=" + salary +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
