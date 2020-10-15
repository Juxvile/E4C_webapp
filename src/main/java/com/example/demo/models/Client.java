package com.example.demo.models;


import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
public class Client{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String number;
    @NotBlank
    private String time;
    @NotBlank
    private String localDate;

    @ManyToOne(fetch = FetchType.EAGER, optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Client() {
    }

}
