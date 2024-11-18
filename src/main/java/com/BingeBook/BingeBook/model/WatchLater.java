package com.BingeBook.BingeBook.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "watchlater")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WatchLater {
    @Id
    private int id;
    private List<Integer> watchlater;
}



