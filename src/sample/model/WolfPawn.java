package sample.model;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class WolfPawn extends Pawn {

    WolfPawn(int col, int row) {
        super(col, row);
    }

    @Override
    public boolean isMoveValid(BoardSquare square) {
        return super.isMoveValid(square)
                || square.getRow() == row + 1 && square.getColumn() == col + 1
                || square.getRow() == row + 1 && square.getColumn() == col - 1;
    }

    public boolean isWolfWinner() {
        return row == Board.boardWidth - 1;
    }

    public boolean isWolfBlocked(Pawn[] pawns) {

        List<Integer[]> listToCheck = new ArrayList<>();
        Integer[][] positionToCheck = {{col + 1, row + 1},
                {col + 1, row - 1},
                {col - 1, row + 1},
                {col - 1, row - 1}};

        listToCheck = Arrays.asList(positionToCheck);

        listToCheck = listToCheck.stream()
                                 .filter(position ->
                                     position[0] >= 0 && position[0] < Board.boardWidth && position[1] >= 0 && position[1] < Board.boardHeight
                                 )
                                 .collect(Collectors.toList());
        int blockingPawnCounter = 0;
        for (int i = 0; i < listToCheck.size(); i++) {
            for (int j = 1; j < pawns.length; j++) {
                if(listToCheck.get(i)[0] == pawns[j].getCol() && listToCheck.get(i)[1] == pawns[j].getRow()){
                    blockingPawnCounter++;
                }
            }
        }
        return blockingPawnCounter==listToCheck.size();

    }
}
