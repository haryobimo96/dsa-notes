package com.haryodsanotes.bfsdfs.services;

import com.haryodsanotes.bfsdfs.constants.ExceptionMessage;
import com.haryodsanotes.bfsdfs.exceptions.MatrixDimensionException;
import com.haryodsanotes.bfsdfs.helpers.MatrixCheckerHelper;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class BaseService {
    public void validateInput(Integer startIdx, List<List<Integer>> matrix) {
        if (!MatrixCheckerHelper.isAdjacencyMatrixValid(matrix))
            throw new MatrixDimensionException(ExceptionMessage.ADJACENCY_MATRIX_INVALID_DIMENSION);
        if (matrix.size() <= startIdx)
            throw new MatrixDimensionException(ExceptionMessage.ADJACENCY_MATRIX_INPUT_OUT_OF_BOUND);
    }
}
