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

    public List<Integer> traverseBfsMatrixResult(Integer idx, List<List<Integer>> matrix) {
        validateAdjacencyMatrixInput(idx, matrix);
        result.add(idx);
        traverseBfsMatrix(idx, matrix);
        return result;
    }

    public List<Integer> traverseBfsListResult(Integer idx, List<List<Integer>> list) {
        validateAdjacencyInput(idx, list);
        result.add(idx);
        traverseBfsList(idx, list);
        return result;
    }

    // O(V^2) time and space complexity since all node connection possibility
    // in each row must be examined
    private void traverseBfsMatrix(Integer idx, List<List<Integer>> matrix) {
        List<Integer> row = matrix.get(idx);
        traversedNode.add(idx);

        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) > 0 && !traversedNode.contains(i)) dataStore.add(i);
        }

        if (dataStore.isEmpty()) return;

        Integer pollIdx = dataStore.poll();
        result.add(pollIdx);
        traverseBfsMatrix(pollIdx, matrix);
    }

    // O(V+E) time and O(V) space complexity since all node connection possibility
    // in each row must be examined
    private void traverseBfsList(Integer idx, List<List<Integer>> list) {
        List<Integer> row = list.get(idx);
        traversedNode.add(idx);

        for (Integer rowIdx : row) {
            if (!traversedNode.contains(rowIdx)) dataStore.add(rowIdx);
        }

        if (dataStore.isEmpty()) return;

        Integer pollIdx = dataStore.poll();
        result.add(pollIdx);
        traverseBfsList(pollIdx, list);
    }
}
