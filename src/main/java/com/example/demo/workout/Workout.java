package com.example.demo.workout;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="workouts")
public class Workout {
    @Id
    @SequenceGenerator(
            name="workout_sequence",
            sequenceName = "workout_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workout_sequence"
    )
    private Long Id;
    private String Title;
    private int Reps;
    private int Sets;

    public Workout() {
    }

    public Workout(Long id, String title, int reps, int sets) {
        Id = id;
        Title = title;
        Reps = reps;
        Sets = sets;
    }

    public Workout(String title, int reps, int sets) {
        Title = title;
        Reps = reps;
        Sets = sets;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getReps() {
        return Reps;
    }

    public void setReps(int reps) {
        Reps = reps;
    }

    public int getSets() {
        return Sets;
    }

    public void setSets(int sets) {
        Sets = sets;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", Reps=" + Reps +
                ", Sets=" + Sets +
                '}';
    }
}
