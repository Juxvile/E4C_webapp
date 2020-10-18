package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле не может быть пустым")
    private String time;

    @ManyToOne(fetch = FetchType.EAGER, optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;


}
