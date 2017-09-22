package com.seabattle;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;
import com.seabattle.logic.GameField;
import com.seabattle.exceptions.FieldEastPositionOutOfBoundsException;
import com.seabattle.exceptions.FieldNorthPositionOutOfBoundsException;
import com.seabattle.exceptions.FieldSouthPositionOutOfBoundsException;
import com.seabattle.exceptions.FieldWestPositionOutOfBoundsException;

public class GameFieldTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    GameField gameField = new GameField();
    GameField.Field[][] gameFieldTarget = new GameField.Field[10][10];

    @Before
    public void prepareGameFieldAndTargetFieldArray() {
        gameField.setGameFieldAsEmpty();

        for (int i = 0; i < gameFieldTarget.length; i++) {
            for (int j = 0; j < gameFieldTarget[0].length; j++) {
                gameFieldTarget[i][j] = GameField.Field.EMPTY;
            }
        }
    }

    @After
    public void checkMatches() {
        for (int i = 0; i < gameFieldTarget.length; i++){
            assertArrayEquals(gameFieldTarget[i], gameField.fields[i]);
        }
    }

    @Test
    public void testSetShipNorth() {

        gameField.setShip(1, 1, GameField.Direction.NORTH, 2);

        gameFieldTarget[0][1] = GameField.Field.CONTAIN;
        gameFieldTarget[1][1] = GameField.Field.CONTAIN;
    }

    @Test
    public void testSetShipSouth() {
        gameField.setShip(1, 1, GameField.Direction.SOUTH, 3);
        gameFieldTarget[1][1] = GameField.Field.CONTAIN;
        gameFieldTarget[2][1] = GameField.Field.CONTAIN;
        gameFieldTarget[3][1] = GameField.Field.CONTAIN;
    }

    @Test
    public void testSetShipWest() {
        gameField.setShip(5, 5, GameField.Direction.WEST, 4);
        gameFieldTarget[5][2] = GameField.Field.CONTAIN;
        gameFieldTarget[5][3] = GameField.Field.CONTAIN;
        gameFieldTarget[5][4] = GameField.Field.CONTAIN;
        gameFieldTarget[5][5] = GameField.Field.CONTAIN;
    }

    @Test
    public void testSetShipEast() {
        gameField.setShip(2, 3, GameField.Direction.EAST, 3);
        gameFieldTarget[3][2] = GameField.Field.CONTAIN;
        gameFieldTarget[3][3] = GameField.Field.CONTAIN;
        gameFieldTarget[3][4] = GameField.Field.CONTAIN;
    }

    @Test
    public void testSetShipNorthException() {
        thrown.expect(FieldNorthPositionOutOfBoundsException.class);
        thrown.expectMessage("North");
        gameField.setShip(2, 2, GameField.Direction.NORTH, 4);
    }

    @Test
    public void testSetShipWestException() {
        thrown.expect(FieldWestPositionOutOfBoundsException.class);
        thrown.expectMessage("West");
        gameField.setShip(1, 7, GameField.Direction.WEST, 3);
    }

    @Test
    public void testSetShipEastException() {
        thrown.expect(FieldEastPositionOutOfBoundsException.class);
        thrown.expectMessage("East");
        gameField.setShip(8, 7, GameField.Direction.EAST, 3);
    }

    @Test
    public void testSetShipSouthException() {
        thrown.expect(FieldSouthPositionOutOfBoundsException.class);
        thrown.expectMessage("South");
        gameField.setShip(9, 9, GameField.Direction.SOUTH, 3);
    }
}