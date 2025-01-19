package com.haryodsanotes.bfsdfs.dtos;

import com.haryodsanotes.bfsdfs.constants.ExceptionMessage;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AdjacencyBaseRequest {
    @Min(value = 0, message = ExceptionMessage.ADJACENCY_MATRIX_INPUT_OUT_OF_BOUND)
    private int startIdx;

    @NotEmpty(message = ExceptionMessage.ADJACENCY_MATRIX_EMPTY)
    private List<@NotEmpty(message = ExceptionMessage.ADJACENCY_MATRIX_EMPTY) List<Integer>> matrix;
}
