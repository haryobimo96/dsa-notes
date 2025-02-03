package com.haryodsanotes.bfsdfs.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AdjacencyDFSService extends BaseService {
    private final List<Integer> result = new ArrayList<>();
    private final Set<Integer> traversedNode = new HashSet<>();
    private final Stack<Integer> stack = new Stack<>();

    public List<Integer> traverseDfsMatrixResult(Integer idx, List<List<Integer>> matrix) {
        validateAdjacencyMatrixInput(idx, matrix);
        traverseDfsMatrix(idx, matrix);
        return result;
    }

    public List<Integer> traverseDfsListUsingStackResult(Integer idx, List<List<Integer>> list) {
        validateAdjacencyInput(idx, list);
        traverseDfsListUsingStack(idx, list);
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

    // Cormen Exercise 22.3-6
    private void traverseDfsListUsingStack(Integer idx, List<List<Integer>> list) {
        traversedNode.add(idx);
        stack.add(idx);
        result.add(idx);

        List<Integer> currentRow = list.get(idx);

        while (!stack.isEmpty()) {
            int rowIdx = 0;

            // see if the node is already traversed, this would trigger the loop back
            while (traversedNode.contains(currentRow.get(rowIdx))) {
                rowIdx++;
                if (rowIdx == currentRow.size()) break;
            }

            // loop back by popping last stack entry
            if (rowIdx == currentRow.size()) {
                stack.pop();
                if (stack.isEmpty()) break;
                currentRow = list.get(stack.peek());
                continue;
            }

            int currentIdx = currentRow.get(rowIdx);
            traversedNode.add(currentIdx);
            stack.add(currentIdx);
            result.add(currentIdx);

            currentRow = list.get(currentIdx);
        }
    }
}
