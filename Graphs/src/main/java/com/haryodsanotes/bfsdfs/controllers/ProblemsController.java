package com.haryodsanotes.bfsdfs.controllers;

import com.haryodsanotes.bfsdfs.constants.ApiPath;
import com.haryodsanotes.bfsdfs.dtos.AdjacencyBaseRequest;
import com.haryodsanotes.bfsdfs.services.AdjacencyBFSService;
import com.haryodsanotes.bfsdfs.services.AdjacencyDFSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = ApiPath.BFS_DFS)
@RequiredArgsConstructor
public class ProblemsController {
    private final AdjacencyBFSService adjacencyBfsService;
    private final AdjacencyDFSService adjacencyDFSService;

    @PostMapping(value = ApiPath.SUB_PATH_ADJACENCY_BFS)
    public ResponseEntity<List<Integer>> traverseBfs(
            @RequestBody @Validated AdjacencyBaseRequest request) {
        return ResponseEntity.ok(
                adjacencyBfsService.traverseBfsResult(request.getStartIdx(), request.getMatrix()));
    }

    @PostMapping(value = ApiPath.SUB_PATH_ADJACENCY_DFS)
    public ResponseEntity<List<Integer>> traverseDfs(
            @RequestBody @Validated AdjacencyBaseRequest request) {
        return ResponseEntity.ok(
                adjacencyDFSService.traverseDfsResult(request.getStartIdx(), request.getMatrix()));
    }
}
