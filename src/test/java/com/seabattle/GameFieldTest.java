package com.seabattle;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;
import com.seabattle.seabattlelogic.GameField;
import com.seabattle.seabattlelogic.FieldEastPositionOutOfBoundsException;
import com.seabattle.seabattlelogic.FieldNorthPositionOutOfBoundsException;
import com.seabattle.seabattlelogic.FieldSouthPositionOutOfBoundsException;
import com.seabattle.seabattlelogic.FieldWestPositionOutOfBoundsException;

public class GameFieldTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testSetShipNorth() throws FieldEastPositionOutOfBoundsException, FieldNorthPositionOutOfBoundsException, FieldSouthPositionOutOfBoundsException, FieldWestPositionOutOfBoundsException {
        GameField gameField = new GameField();
        gameField.setShip(1, 1, GameField.Direction.NORTH, 2);

        GameField.Field[][] gameFieldTarget = new GameField.Field[10][10];

        for (int i = 0; i<gameFieldTarget.length; i++){
            for (int j = 0; j<gameFieldTarget[0].length; j++) {
                gameFieldTarget[i][j] = GameField.Field.EMPTY;
            }
        }

        gameFieldTarget[0][1] = GameField.Field.CONTAIN;
        gameFieldTarget[1][1] = GameField.Field.CONTAIN;

        for (int i = 0; i<gameFieldTarget.length; i++){
            assertArrayEquals(gameFieldTarget[i], gameField.fields[i]);
        }
    }

    @Test
    public void testSetShipSouth() throws Exception {
        GameField gameField = new GameField();
        gameField.setShip(1, 1, GameField.Direction.SOUTH, 3);

        GameField.Field[][] gameFieldTarget = new GameField.Field[10][10];

        for (int i = 0; i<gameFieldTarget.length; i++){
            for (int j = 0; j<gameFieldTarget[0].length; j++) {
                gameFieldTarget[i][j] = GameField.Field.EMPTY;
            }
        }

        gameFieldTarget[1][1] = GameField.Field.CONTAIN;
        gameFieldTarget[2][1] = GameField.Field.CONTAIN;
        gameFieldTarget[3][1] = GameField.Field.CONTAIN;

        for (int i = 0; i<gameFieldTarget.length; i++){
            assertArrayEquals(gameFieldTarget[i], gameField.fields[i]);
        }
    }

    @Test
    public void testSetShipWest() throws Exception {
        GameField gameField = new GameField();
        gameField.setShip(5, 5, GameField.Direction.WEST, 4);

        GameField.Field[][] gameFieldTarget = new GameField.Field[10][10];

        for (int i = 0; i<gameFieldTarget.length; i++){
            for (int j = 0; j<gameFieldTarget[0].length; j++) {
                gameFieldTarget[i][j] = GameField.Field.EMPTY;
            }
        }

        gameFieldTarget[5][2] = GameField.Field.CONTAIN;
        gameFieldTarget[5][3] = GameField.Field.CONTAIN;
        gameFieldTarget[5][4] = GameField.Field.CONTAIN;
        gameFieldTarget[5][5] = GameField.Field.CONTAIN;

        for (int i = 0; i<gameFieldTarget.length; i++){
            assertArrayEquals(gameFieldTarget[i], gameField.fields[i]);
        }
    }

    @Test
    public void testSetShipEast() throws Exception {
        GameField gameField = new GameField();
        gameField.setShip(2, 3, GameField.Direction.EAST, 3);

        GameField.Field[][] gameFieldTarget = new GameField.Field[10][10];

        for (int i = 0; i<gameFieldTarget.length; i++){
            for (int j = 0; j<gameFieldTarget[0].length; j++) {
                gameFieldTarget[i][j] = GameField.Field.EMPTY;
            }
        }

        gameFieldTarget[3][2] = GameField.Field.CONTAIN;
        gameFieldTarget[3][3] = GameField.Field.CONTAIN;
        gameFieldTarget[3][4] = GameField.Field.CONTAIN;

        for (int i = 0; i<gameFieldTarget.length; i++){
            assertArrayEquals(gameFieldTarget[i], gameField.fields[i]);
        }
    }

    @Test
    public void testSetShipNorthException() throws Exception {
        GameField gameField = new GameField();
        thrown.expect(FieldNorthPositionOutOfBoundsException.class);
        thrown.expectMessage("North");
        gameField.setShip(2, 2, GameField.Direction.NORTH, 4);
    }

    @Test
    public void testSetShipWestException() throws Exception {
        GameField gameField = new GameField();
        thrown.expect(FieldWestPositionOutOfBoundsException.class);
        thrown.expectMessage("West");
        gameField.setShip(1, 7, GameField.Direction.WEST, 3);
    }

    @Test
    public void testSetShipEastException() throws Exception {
        GameField gameField = new GameField();
        thrown.expect(FieldEastPositionOutOfBoundsException.class);
        thrown.expectMessage("East");
        gameField.setShip(8, 7, GameField.Direction.EAST, 3);
    }

    @Test
    public void testSetShipSouthException() throws Exception {
        GameField gameField = new GameField();
        thrown.expect(FieldSouthPositionOutOfBoundsException.class);
        thrown.expectMessage("South");
        gameField.setShip(9, 9, GameField.Direction.SOUTH, 3);
    }
}