package com.haryodsanotes.bfsdfs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdjacencyDFSService extends BaseService {
    private final List<Integer> result = new ArrayList<>();
    private final Set<Integer> traversedNode = new HashSet<>();

    public List<Integer> traverseDfsResult(Integer idx, List<List<Integer>> matrix) {
        validateInput(idx, matrix);
        traverseDfs(idx, matrix);
        return result;
    }

    // O(V^2) time and space complexity since all node connection possibility
    // in each row must be examined
    private void traverseDfs(Integer idx, List<List<Integer>> matrix) {
        List<Integer> row = matrix.get(idx);
        traversedNode.add(idx);
        result.add(idx);

        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) > 0 && !traversedNode.contains(i)) traverseDfs(i, matrix);
        }
    }
}
