package com.example.demo.models;


import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@Entity
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String number;

    @ManyToOne(fetch = FetchType.EAGER, optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

}
