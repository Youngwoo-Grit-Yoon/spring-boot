package com.example.demo.controller;

import com.example.demo.domain.Solution;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}
