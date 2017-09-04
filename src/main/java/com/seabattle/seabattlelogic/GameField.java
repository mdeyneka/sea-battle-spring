package com.seabattle.seabattlelogic;

import com.seabattle.seabattlelogic.FieldWestPositionOutOfBoundsException;
import com.seabattle.seabattlelogic.FieldNorthPositionOutOfBoundsException;
import com.seabattle.seabattlelogic.FieldSouthPositionOutOfBoundsException;
import com.seabattle.seabattlelogic.FieldEastPositionOutOfBoundsException;

public class GameField {

    public enum Field {
        EMPTY,
        SHOOTED,
        CONTAIN,
        DAMAGED
    }

    public enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    public Field fields[][];

    public GameField() {
        fields = new Field[10][10];
        setGameFieldAsEmpty();
    }
    public GameField(int x, int y) {
        fields = new Field[x][y];
        setGameFieldAsEmpty();
    }

    public void setShip(int positionX, int positionY, Direction direction, int lenght) throws FieldWestPositionOutOfBoundsException, FieldNorthPositionOutOfBoundsException, FieldEastPositionOutOfBoundsException, FieldSouthPositionOutOfBoundsException {
        switch(direction) {
            case NORTH:
                if (((positionY + 1) - lenght) < 0) throw new FieldNorthPositionOutOfBoundsException("North");
                for (int i = 0; i < lenght; ++i) {
                    fields[positionY - i][positionX] = Field.CONTAIN;
                }
                break;
            case SOUTH:
                if ((positionY + lenght) > (fields[fields.length - 1].length)) throw new FieldSouthPositionOutOfBoundsException("South");
                for (int i = 0; i < lenght; ++i) {
                    fields[positionY + i][positionX] = Field.CONTAIN;
                }
                break;
            case WEST:
                if (((positionX + 1) - lenght) < 0) throw new FieldWestPositionOutOfBoundsException("West");
                for (int i = 0; i < lenght; ++i) {
                    fields[positionY][positionX - i] = Field.CONTAIN;
                }
                break;
            case EAST:
                if ((positionX + lenght) > fields.length) throw new FieldEastPositionOutOfBoundsException("East");
                for (int i = 0; i < lenght; ++i) {
                    fields[positionY][positionX + i] = Field.CONTAIN;
                }
                break;
        }
    }

    private void setGameFieldAsEmpty() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = Field.EMPTY;
            }
        }
    }
    
    public void printGameField() {
        String string="";
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                if (fields[i][j] == Field.EMPTY) {
                    string = string.concat("E");
                } else if (fields[i][j] == Field.CONTAIN) {
                    string = string.concat("C");
                } else if (fields[i][j] == Field.SHOOTED) {
                    string = string.concat("S");
                }

            }
            string = string.concat("\n");
        }
        System.out.println(string);
    }
    
    
}