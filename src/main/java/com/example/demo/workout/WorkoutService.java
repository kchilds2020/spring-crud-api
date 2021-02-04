package com.example.demo.workout;

import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }
    public List<Workout> getAllWorkouts(){
        return workoutRepository.findAll();
    }

    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }
}
