package ru.max.str.smolSBApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "captains_team")
public class Nemo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    @NotEmpty(message = "Поле 'Имя' не может быть пустым")
    @Size(min = 4, max = 20, message = "Максимальное количество символов поля 'Имя (логин)', 20 символов")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "Поле 'Пароль' не мнжет быть пустым")
    @Size(min = 4, message = "Минимальное количество символов - 4")
    private String password;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "medic_polys")
    private String medic_polys;

    @Column(name = "emergency_phone")
    private String emergency_phone;

    @Column(name = "place_of_residence")
    @Size(max = 100, message = "Максимальное количество символов поля 'Место проживания', 100 символов")
    private String place_of_residence;

    @Column(name = "rh_factor")
    @NotEmpty(message = "Поле 'Резус-фактор' не может быть пустым или напишите *НЕ ЗНАЮ*")
    private String rh_factor;

    @Column(name = "blood_type")
    @NotEmpty(message = "Поле 'Группа крови' не может быть пустым или напишите *НЕ ЗНАЮ*")
    private String blood_type;

    @Column(name = "allergy")
    @NotEmpty(message = "Поле 'Аллергия' не может быть пустым или напишите *НЕ ЗНАЮ* или *НЕТ*")
    @Size(max = 300, message = "Максимальное колличество символов поля 'Аллергия' 300 символов")
    private String allergy;

    @Column(name = "medical_contraindications")
    @NotEmpty(message = "Поле 'Противопоказания' не может быть пустым или напишите *НЕ ЗНАЮ* или *НЕТ*")
    @Size(max = 300, message = "Максимальное колличество символов поля 'Противопоказания' 300 символов")
    private String medical_contraindications;

    @Column(name = "chronic_diseases")
    @NotEmpty(message = "Поле 'Хронические заболевания' не может быть пустым или напишите *НЕ ЗНАЮ* или *НЕТ*")
    @Size(max = 500, message = "Максимальное колличество символов поля 'Хронические заболевания' 500 символов")
    private String chronic_diseases;

    @Column(name = "metal_implants")
    @NotEmpty(message = "Поле 'Металлические импланты' не может быть пустым или напишите *НЕТ*")
    @Size(max = 500, message = "Максимальное колличество символов поля 'Металлические импланты' 500 символов")
    private String metal_implants;

    @Column(name = "electronic_implants")
    @NotEmpty(message = "Поле 'Электронные импланты' не может быть пустым или напишите *НЕТ*")
    @Size(max = 500, message = "Максимальное колличество символов поля 'Электронные импланты' 500 символов")
    private String electronic_implants;

    @Column(name = "necessary_medicines")
    @NotEmpty(message = "Поле 'Обязательные для приема лекарства' не может быть пустым или напишите *НЕТ*")
    @Size(max = 500, message = "Максимальное колличество символов поля 'Обязательные для приема лекарства' 500 символов")
    private String necessary_medicines;

    @Column(name = "role")
    private String role;

    @Column(name = "create_date")
    private LocalDateTime create_date;
}
