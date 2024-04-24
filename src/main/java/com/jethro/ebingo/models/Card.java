package com.jethro.ebingo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
@JsonIgnoreProperties({"game"}) // Ignore serialization of game to avoid circular reference
public class Card {
    @Id
    @GeneratedValue
    private int id;
    private List<Integer> b;
    private List<Integer> i;
    private List<Integer> n;
    private List<Integer> g;
    private List<Integer> o;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private Game game;

    public Card(List<Integer> b, List<Integer> i, List<Integer> n, List<Integer> g, List<Integer> o, Game game) {
        this.b = b;
        this.i = i;
        this.n = n;
        this.g = g;
        this.o = o;
        this.game = game;
    }
}
