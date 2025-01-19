package com.haryodsanotes.bfsdfs.controllers;

import com.haryodsanotes.bfsdfs.constants.ApiPath;
import com.haryodsanotes.bfsdfs.constants.ExceptionMessage;
import com.haryodsanotes.bfsdfs.services.ProblemsService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = ApiPath.BFS_DFS)
@RequiredArgsConstructor
public class ProblemsController {
    private final ProblemsService problemsService;

    @PostMapping(value = ApiPath.SUB_PATH_BFS)
    public ResponseEntity<List<Integer>> traverseBfs(
            @RequestBody @NotEmpty(message = ExceptionMessage.ADJACENCY_MATRIX_EMPTY) List<List<Integer>> input) {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping(value = ApiPath.SUB_PATH_DFS)
    public ResponseEntity<List<Integer>> traverseDfs(
            @RequestBody @NotEmpty(message = ExceptionMessage.ADJACENCY_MATRIX_EMPTY) List<List<Integer>> input) {
        return ResponseEntity.ok(List.of());
    }
}
