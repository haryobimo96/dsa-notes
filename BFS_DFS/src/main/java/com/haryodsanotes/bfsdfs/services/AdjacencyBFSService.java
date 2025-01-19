package com.haryodsanotes.bfsdfs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdjacencyBFSService extends BaseService {
    private final List<Integer> result = new ArrayList<>();
    private final Set<Integer> traversedNode = new HashSet<>();
    private final Queue<Integer> dataStore = new ArrayDeque<>();

    public List<Integer> traverseBfsResult(Integer idx, List<List<Integer>> matrix) {
        validateInput(idx, matrix);
        result.add(idx);
        traverseBfs(idx, matrix);
        return result;
    }

    // O(V^2) time and space complexity since all node connection possibility
    // in each row must be examined
    private void traverseBfs(Integer idx, List<List<Integer>> matrix) {
        List<Integer> row = matrix.get(idx);
        traversedNode.add(idx);

        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) > 0 && !traversedNode.contains(i)) dataStore.add(i);
        }

        if (dataStore.isEmpty()) return;

        Integer pollIdx = dataStore.poll();
        result.add(pollIdx);
        traverseBfs(pollIdx, matrix);
    }
}
