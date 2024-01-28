package rupesh.entity;

import jakarta.persistence.*;

/**
 * @author Rupesh Dangi
 * @date: 2024/01/27 16/44
 */
@Entity
@Table(name = "USER_TABLE")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long balance;
    // USED BY HIBERNATE - NOT OPTIONAL
    public User(){}
    public User(String name) {

        this.name = name;
        this.balance=0;
    }
    public void addBalance(long value){
        this.balance = this.balance + value;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public long getBalance() {
        return balance;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

