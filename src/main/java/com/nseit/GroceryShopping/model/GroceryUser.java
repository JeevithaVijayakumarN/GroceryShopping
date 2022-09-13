package com.nseit.GroceryShopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class GroceryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String userName;
    private String email;
    private Long phone;
    private String password;

    @JsonIgnore
    @OneToOne(mappedBy = "groceryUser", cascade = CascadeType.ALL)
    private Cart cart;

    @JsonIgnore
    @OneToMany(mappedBy = "groceryUser", cascade = CascadeType.ALL)
    private Set<OrderProducts> orderProducts;

    @ManyToMany
    @JsonIgnore
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinTable(joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    public GroceryUser(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }
}
