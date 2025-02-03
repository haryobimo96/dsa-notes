package com.haryodsanotes.bfsdfs.services;

import com.haryodsanotes.bfsdfs.exceptions.MatrixDimensionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class AdjacencyBFSServiceTest {
    @InjectMocks
    AdjacencyBFSService adjacencyBFSService;

    static Stream<Arguments> generateDataAdjacencyBFS() {
        return Stream.of(
                Arguments.of(3,
                        List.of(
                                List.of(0, 1, 1, 1, 0, 0),
                                List.of(1, 0, 0, 0, 1, 0),
                                List.of(1, 0, 0, 0, 0, 0),
                                List.of(1, 0, 0, 0, 0, 1),
                                List.of(0, 1, 0, 0, 0, 0),
                                List.of(0, 0, 0, 1, 0, 0)
                        ),
                        List.of(3, 0, 5, 1, 2, 4)
                ),
                Arguments.of(0,
                        List.of(
                                List.of(0, 1, 1, 1, 0, 0),
                                List.of(1, 0, 0, 0, 1, 0),
                                List.of(1, 0, 0, 0, 0, 0),
                                List.of(1, 0, 0, 0, 0, 1),
                                List.of(0, 1, 0, 0, 0, 0),
                                List.of(0, 0, 0, 1, 0, 0)
                        ),
                        List.of(0, 1, 2, 3, 4, 5)
                ),
                Arguments.of(5,
                        List.of(
                                List.of(0, 1, 1, 1, 0, 0),
                                List.of(1, 0, 0, 0, 1, 0),
                                List.of(1, 0, 0, 0, 0, 0),
                                List.of(1, 0, 0, 0, 0, 1),
                                List.of(0, 1, 0, 0, 0, 0),
                                List.of(0, 0, 0, 1, 0, 0)
                        ),
                        List.of(5, 3, 0, 1, 2, 4)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("generateDataAdjacencyBFS")
    void checkReturnedValuesAdjacencyBFS(
            int startIdx, List<List<Integer>> matrix, List<Integer> expectedResult){
        List<Integer> result = adjacencyBFSService.traverseBfsMatrixResult(startIdx, matrix);
        Assertions.assertEquals(expectedResult.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expectedResult.get(i), result.get(i));
        }
    }

    @Test
    void checkInvalidInputsInAdjacencyBFSFunctionCall() {
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyBFSService.traverseBfsMatrixResult(-5, List.of(List.of(1))));
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyBFSService.traverseBfsMatrixResult(2, List.of(List.of(1))));
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyBFSService.traverseBfsMatrixResult(0, null));
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyBFSService.traverseBfsMatrixResult(0, List.of(List.of(1, 2), List.of(1))));
    }
}
