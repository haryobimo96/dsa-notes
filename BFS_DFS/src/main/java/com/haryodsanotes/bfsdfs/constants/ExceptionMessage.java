package com.haryodsanotes.bfsdfs.constants;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExceptionMessage {
    public static final String ADJACENCY_MATRIX_INVALID_DIMENSION =
            "Adjacency matrix must be of dimension V x V where V is the amount of nodes in a undirected graph";
    public static final String ADJACENCY_MATRIX_EMPTY =
            "Adjacency matrix must not be empty";
}
