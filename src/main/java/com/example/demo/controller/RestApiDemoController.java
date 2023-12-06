package com.example.demo.controller;

import com.example.demo.domain.Solution;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cc")
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
    @GetMapping("/solutions")
    Iterable<Solution> getSolutions() {
        return solutions;
    }

    @GetMapping("/solutions/{id}")
    Optional<Solution> getCoffeeById(@PathVariable String id) {
        for (Solution s : solutions) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }

        return Optional.empty();
    }
}
