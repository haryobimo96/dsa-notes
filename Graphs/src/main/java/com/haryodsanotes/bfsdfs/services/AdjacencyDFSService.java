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
    private final Map<Integer, Integer> neighbours = new HashMap<>();

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
    private void traverseDfsListUsingStack(Integer currentNode, List<List<Integer>> list) {
        stack.add(currentNode);
        result.add(currentNode);
        // initialize selected index neighbour
        neighbours.put(currentNode, 0);

        while (!stack.isEmpty()) {
            currentNode = stack.peek();
            List<Integer> currentRow = list.get(currentNode);
            int nextIdx = neighbours.get(currentNode);

            // see if the parent node has all its children covered,
            // will trigger the loop back if all children have been traversed
            if (nextIdx >= currentRow.size()) {
                stack.pop();
                continue;
            }

            // switch current node's child to other child
            neighbours.replace(currentNode, nextIdx + 1);
            int nextNode = currentRow.get(nextIdx);

            if (!neighbours.containsKey(nextNode)) {
                stack.add(nextNode);
                result.add(nextNode);
                neighbours.put(nextNode, 0);
            }
        }
    }
}
