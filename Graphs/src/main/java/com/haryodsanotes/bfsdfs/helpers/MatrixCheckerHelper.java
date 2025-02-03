package com.haryodsanotes.bfsdfs.helpers;

import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

public class MatrixCheckerHelper {
    public static boolean isAdjacencyMatrixValid(List<List<Integer>> input) {
        if (ObjectUtils.isEmpty(input)) return false;
        for (List<Integer> columns : input) {
            if (columns.size() != input.size()) return false;
        }
        return true;
    }
}
