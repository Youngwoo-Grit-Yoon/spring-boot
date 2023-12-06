package com.example.demo.controller;

import com.example.demo.domain.Solution;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cc/solutions")
public class RestApiDemoController {
    private List<Solution> solutions = new ArrayList<>();

    public RestApiDemoController() {
        solutions.addAll(List.of(
                new Solution("CTI"),
                new Solution("IVR"),
                new Solution("PDS"),
                new Solution("통계"),
                new Solution("녹취")
        ));
    }

    // @RequestMapping(value = "/solutions", method = RequestMethod.GET)
    // @GetMapping("/solutions")
    @GetMapping
    Iterable<Solution> getSolutions() {
        return solutions;
    }

    @GetMapping("/{id}")
    Optional<Solution> getSolutionById(@PathVariable String id) {
        for (Solution s : solutions) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    Solution postSolution(@RequestBody Solution solution) {
        solutions.add(solution);
        return solution;
    }

    @PutMapping("/{id}")
    Solution putSolution(@PathVariable String id, @RequestBody Solution solution) {
        int solutionIndex = -1;

        for (Solution s : solutions) {
            if (s.getId().equals(id)) {
                solutionIndex = solutions.indexOf(s);
                solutions.set(solutionIndex, solution);
            }
        }

        return (solutionIndex == -1) ? postSolution(solution) : solution;
    }

    @DeleteMapping("/{id}")
    void deleteSolution(@PathVariable String id) {
        solutions.removeIf(s -> s.getId().equals(id));
    }
}
