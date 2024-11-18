package com.BingeBook.BingeBook.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.RowId;

@Data
@Table(name = "watched")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Watched {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userid;
    private int  watched;
    private int rating;
    private String comment;
}
