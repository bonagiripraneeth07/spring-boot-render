package com.BingeBook.BingeBook.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "watchbucket")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WatchBucket {
    @Id
    private int id;
    private int watchLater;
    private int  watched;
    private int rating;
    private String comment;
}
