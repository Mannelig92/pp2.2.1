package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    //    @OneToOne(mappedBy = "user") //mappedBy показывает какому объекту принадлежит данный столбец
    //    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE) //при сохранении юзера, его машина тоже добавл. в БД
//    @MapsId //Позволяет использовать один и тот же первичный ключ между двумя разными таблицами
    @OneToOne(cascade = CascadeType.ALL) //При изменении Юзера, будет изменяться и детали о его машине. Владелец
    @JoinColumn(name = "car_id") //Привязывается к id car
    private Car car;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(Car car, String firstName, String lastName, String email) {
        this.car = car;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
