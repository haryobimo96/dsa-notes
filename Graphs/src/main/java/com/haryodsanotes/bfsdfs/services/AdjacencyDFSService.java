package com.haryodsanotes.bfsdfs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdjacencyDFSService extends BaseService {
    private final List<Integer> result = new ArrayList<>();
    private final Set<Integer> traversedNode = new HashSet<>();

    public List<Integer> traverseDfsMatrixResult(Integer idx, List<List<Integer>> matrix) {
        validateAdjacencyMatrixInput(idx, matrix);
        traverseDfsMatrix(idx, matrix);
        return result;
    }

    public List<Integer> traverseDfsListResult(Integer idx, List<List<Integer>> list) {
        validateAdjacencyInput(idx, list);
        traverseDfsList(idx, list);
        return result;
    }

    // O(V^2) time and space complexity since all node connection possibility
    // in each row must be examined
    private void traverseDfsMatrix(Integer idx, List<List<Integer>> matrix) {
        List<Integer> row = matrix.get(idx);
        traversedNode.add(idx);
        result.add(idx);

        for (int i = 0; i < row.size(); i++) {
            if (row.get(i) > 0 && !traversedNode.contains(i)) traverseDfsMatrix(i, matrix);
        }
    }

    // O(V+E) time and O(V) space complexity since all node connection possibility
    // in each row must be examined
    private void traverseDfsList(Integer idx, List<List<Integer>> list) {
        List<Integer> row = list.get(idx);
        traversedNode.add(idx);
        result.add(idx);

        for (Integer rowIdx : row) {
            if (!traversedNode.contains(rowIdx)) traverseDfsList(rowIdx, list);
        }
    }
}
