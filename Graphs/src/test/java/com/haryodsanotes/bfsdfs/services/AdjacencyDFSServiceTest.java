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
public class AdjacencyDFSServiceTest {
    @InjectMocks
    AdjacencyDFSService adjacencyDFSService;

    static Stream<Arguments> generateDataAdjacencyDFS() {
        return Stream.of(
                Arguments.of(0,
                        List.of(
                                List.of(0, 1, 1, 1, 0, 0),
                                List.of(1, 0, 0, 0, 1, 0),
                                List.of(1, 0, 0, 0, 0, 0),
                                List.of(1, 0, 0, 0, 0, 1),
                                List.of(0, 1, 0, 0, 0, 0),
                                List.of(0, 0, 0, 1, 0, 0)
                        ),
                        List.of(0, 1, 4, 2, 3, 5)
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
                        List.of(5, 3, 0, 1, 4, 2)
                ),
                Arguments.of(2,
                        List.of(
                                List.of(0, 1, 1, 1, 0, 0),
                                List.of(1, 0, 0, 0, 1, 0),
                                List.of(1, 0, 0, 0, 0, 0),
                                List.of(1, 0, 0, 0, 0, 1),
                                List.of(0, 1, 0, 0, 0, 0),
                                List.of(0, 0, 0, 1, 0, 0)
                        ),
                        List.of(2, 0, 1, 4, 3, 5)
                )
        );
    }

    static Stream<Arguments> generateDataAdjacencyDFSList() {
        return Stream.of(
                Arguments.of(0,
                        List.of(
                                List.of(1, 2, 3),
                                List.of(0, 4),
                                List.of(0),
                                List.of(0, 5),
                                List.of(1),
                                List.of(3)
                        ),
                        List.of(0, 1, 4, 2, 3, 5)
                ),
                Arguments.of(5,
                        List.of(
                                List.of(1, 2, 3),
                                List.of(0, 4),
                                List.of(0),
                                List.of(0, 5),
                                List.of(1),
                                List.of(3)
                        ),
                        List.of(5, 3, 0, 1, 4, 2)
                ),
                Arguments.of(2,
                        List.of(
                                List.of(1, 2, 3),
                                List.of(0, 4),
                                List.of(0),
                                List.of(0, 5),
                                List.of(1),
                                List.of(3)
                        ),
                        List.of(2, 0, 1, 4, 3, 5)
                )
        );
    }

    static Stream<Arguments> generateDataDirectedAdjacencyDFSList() {
        return Stream.of(
                Arguments.of(0,
                        List.of(
                                List.of(1, 3),
                                List.of(4),
                                List.of(5, 4),
                                List.of(1),
                                List.of(3),
                                List.of(5)
                        ),
                        List.of(0, 1, 4, 3)
                ),
                Arguments.of(2,
                        List.of(
                                List.of(1, 3),
                                List.of(4),
                                List.of(5, 4),
                                List.of(1),
                                List.of(3),
                                List.of(5)  // beware of this self-reference part
                        ),
                        List.of(2, 5, 4, 3, 1)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("generateDataAdjacencyDFSList")
    void checkReturnedValuesAdjacencyDFSListUsingStack(
            int startIdx, List<List<Integer>> list, List<Integer> expectedResult){
        List<Integer> result = adjacencyDFSService.traverseDfsListUsingStackResult(startIdx, list);
        Assertions.assertEquals(expectedResult.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expectedResult.get(i), result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("generateDataDirectedAdjacencyDFSList")
    void checkReturnedValuesDirectedAdjacencyDFSListUsingStack(
            int startIdx, List<List<Integer>> list, List<Integer> expectedResult){
        List<Integer> result = adjacencyDFSService.traverseDfsListUsingStackResult(startIdx, list);
        Assertions.assertEquals(expectedResult.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expectedResult.get(i), result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("generateDataDirectedAdjacencyDFSList")
    void checkReturnedValuesDirectedAdjacencyDFSList(
            int startIdx, List<List<Integer>> list, List<Integer> expectedResult){
        List<Integer> result = adjacencyDFSService.traverseDfsListResult(startIdx, list);
        Assertions.assertEquals(expectedResult.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expectedResult.get(i), result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("generateDataAdjacencyDFSList")
    void checkReturnedValuesAdjacencyDFSList(
            int startIdx, List<List<Integer>> list, List<Integer> expectedResult){
        List<Integer> result = adjacencyDFSService.traverseDfsListResult(startIdx, list);
        Assertions.assertEquals(expectedResult.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expectedResult.get(i), result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("generateDataAdjacencyDFS")
    void checkReturnedValuesAdjacencyDFS(
            int startIdx, List<List<Integer>> matrix, List<Integer> expectedResult){
        List<Integer> result = adjacencyDFSService.traverseDfsMatrixResult(startIdx, matrix);
        Assertions.assertEquals(expectedResult.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expectedResult.get(i), result.get(i));
        }
    }

    @Test
    void checkInvalidInputsInAdjacencyDFSFunctionCall() {
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyDFSService.traverseDfsMatrixResult(-5, List.of(List.of(1))));
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyDFSService.traverseDfsMatrixResult(2, List.of(List.of(1))));
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyDFSService.traverseDfsMatrixResult(0, null));
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyDFSService.traverseDfsMatrixResult(0, List.of(List.of(1, 2), List.of(1))));
    }

    @Test
    void checkInvalidInputsInAdjacencyDFSListFunctionCall() {
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyDFSService.traverseDfsListResult(-5, List.of(List.of(1))));
        Assertions.assertThrows(
                MatrixDimensionException.class,
                () -> adjacencyDFSService.traverseDfsListResult(2, List.of(List.of(1))));
    }
}
