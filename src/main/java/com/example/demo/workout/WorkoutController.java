package com.example.demo.workout;

import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/")
public class WorkoutController {

    private final WorkoutService workoutService;

    @Autowired
    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping(path="get-workouts")
    public List<Workout> getAllWorkouts(){
        return workoutService.getAllWorkouts();
    }

    @PostMapping(path="create-workout")
    public Workout createWorkout(@RequestBody Workout workout){ return workoutService.createWorkout(workout);}
}
