package com.abdoulahouali.battleship.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Enumerated(EnumType.STRING)
    private GameStatus status; // Enum for game status (ongoing, completed, etc.)

    // Add fields for game details (start time, end time, winner, etc.)

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Ship> ships;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Move> moves;

    // Add constructors, getters, setters, and other methods as needed
}

