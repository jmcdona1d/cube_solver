package com.dzone.albanoj2.example.rest.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Cube {

    private ArrayList<int[][]> sides;
    private int turnCount;
    private String[] solveInstructions;
    private int state;
    private boolean debug;

    private final static int white = 0;
    private final static int red = 1;
    private final static int blue = 2;
    private final static int green = 3;
    private final static int orange = 4;
    private final static int yellow = 5;

    private final static int w = 0;
    private final static int r = 1;
    private final static int b = 2;
    private final static int g = 3;
    private final static int o = 4;
    private final static int y = 5;

    public Cube() {

        sides = new ArrayList<int[][]>();
        turnCount = 0;
        solveInstructions = new String[] { "", "", "", "", "" };
        state = 0;
        // change for wanting displayed nets
        debug = false;

        int[][] white = { { -1, -1, -1 }, { -1, 0, -1, }, { -1, -1, -1 } }; // index 0
        int[][] red = { { -1, -1, -1 }, { -1, 1, -1, }, { -1, -1, -1 } }; // 1
        int[][] blue = { { -1, -1, -1 }, { -1, 2, -1, }, { -1, -1, -1 } }; // 2
        int[][] green = { { -1, -1, -1 }, { -1, 3, -1, }, { -1, -1, -1 } };// 3
        int[][] orange = { { -1, -1, -1 }, { -1, 4, -1, }, { -1, -1, -1 } };// 4
        int[][] yellow = { { -1, -1, -1 }, { -1, 5, -1, }, { -1, -1, -1 } };// 5

        sides.add(white);
        sides.add(red);
        sides.add(blue);
        sides.add(green);
        sides.add(orange);
        sides.add(yellow);
    }

    /*
     * cubeString will consist of 6 8-character sequences - separated by spaces.
     * Each sequence character represents that squares colour as they get populated
     * based on the net chart from index 0 to index 8 (skipping index 4 since it is
     * the center.
     * 
     * Numbers Example:
     */

    public Cube(String cubeString) {

        char[] chars = cubeString.toCharArray();

        chars = convertToNumeric(chars);

        sides = new ArrayList<int[][]>();
        turnCount = 0;
        solveInstructions = new String[] { "", "", "", "", "" };
        state = 0;
        debug = false;

        int[][] white = {
                { Character.getNumericValue(chars[0]), Character.getNumericValue(chars[1]),
                        Character.getNumericValue(chars[2]) },
                { Character.getNumericValue(chars[3]), 0, Character.getNumericValue(chars[4]) },
                { Character.getNumericValue(chars[5]), Character.getNumericValue(chars[6]),
                        Character.getNumericValue(chars[7]) } };
        // skip 8 for sapce
        int[][] red = {
                { Character.getNumericValue(chars[9]), Character.getNumericValue(chars[10]),
                        Character.getNumericValue(chars[11]) },
                { Character.getNumericValue(chars[12]), 1, Character.getNumericValue(chars[13]) },
                { Character.getNumericValue(chars[14]), Character.getNumericValue(chars[15]),
                        Character.getNumericValue(chars[16]) } };
        // skip 17
        int[][] blue = {
                { Character.getNumericValue(chars[18]), Character.getNumericValue(chars[19]),
                        Character.getNumericValue(chars[20]) },
                { Character.getNumericValue(chars[21]), 2, Character.getNumericValue(chars[22]) },
                { Character.getNumericValue(chars[23]), Character.getNumericValue(chars[24]),
                        Character.getNumericValue(chars[25]) } };
        // skip 26
        int[][] green = {
                { Character.getNumericValue(chars[27]), Character.getNumericValue(chars[28]),
                        Character.getNumericValue(chars[29]) },
                { Character.getNumericValue(chars[30]), 3, Character.getNumericValue(chars[31]) },
                { Character.getNumericValue(chars[32]), Character.getNumericValue(chars[33]),
                        Character.getNumericValue(chars[34]) } };
        // skip 35
        int[][] orange = {
                { Character.getNumericValue(chars[36]), Character.getNumericValue(chars[37]),
                        Character.getNumericValue(chars[38]) },
                { Character.getNumericValue(chars[39]), 4, Character.getNumericValue(chars[40]) },
                { Character.getNumericValue(chars[41]), Character.getNumericValue(chars[42]),
                        Character.getNumericValue(chars[43]) } };
        // skip 44
        int[][] yellow = {
                { Character.getNumericValue(chars[45]), Character.getNumericValue(chars[46]),
                        Character.getNumericValue(chars[47]) },
                { Character.getNumericValue(chars[48]), 5, Character.getNumericValue(chars[49]) },
                { Character.getNumericValue(chars[50]), Character.getNumericValue(chars[51]),
                        Character.getNumericValue(chars[52]) } };

        sides.add(white);
        sides.add(red);
        sides.add(blue);
        sides.add(green);
        sides.add(orange);
        sides.add(yellow);
    }

    public void setSide(int index, int one, int two, int three, int four, int five, int six, int seven, int eight) {
        int[][] target = sides.get(index);
        target[0][0] = one;
        target[0][1] = two;
        target[0][2] = three;
        target[1][0] = four;
        target[1][2] = five;
        target[2][0] = six;
        target[2][1] = seven;
        target[2][2] = eight;
        sides.set(index, target);
    }

    public int[][] getSide(int index) {// May be uneccessary
        return sides.get(index);
    }

    public void displaySide(int index) {
        int[][] target = this.getSide(index);
        System.out.println("Side " + index + ":");

        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                if (y == 2)
                    System.out.println(target[x][y]);
                else
                    System.out.print(target[x][y] + ",");
    }

    public void displayAllSides() {
        for (int i = 0; i < 6; i++) {
            displaySide(i);
            System.out.println();
        }
    }

    public void displayNet() {

        if (!this.debug)
            return;

        int[][] white = this.getSide(0);
        int[][] yellow = this.getSide(5);
        int[][] blue = this.getSide(2);
        int[][] green = this.getSide(3);
        int[][] red = this.getSide(1);
        int[][] orange = this.getSide(4);

        System.out.println("Net of all Sides:");
        System.out.println("     ___    ");
        System.out.println("    |" + orange[2][2] + orange[2][1] + orange[2][0] + "|    ");
        System.out.println("    |" + orange[1][2] + orange[1][1] + orange[1][0] + "|    ");
        System.out.println("    |" + orange[0][2] + orange[0][1] + orange[0][0] + "|    ");
        System.out.println(" ---------- ");
        System.out.println("|" + green[2][0] + green[1][0] + green[0][0] + "|" + white[0][0] + white[0][1] + white[0][2]
                + "|" + blue[0][2] + blue[1][2] + blue[2][2] + "|");
        System.out.println("|" + green[2][1] + green[1][1] + green[0][1] + "|" + white[1][0] + white[1][1] + white[1][2]
                + "|" + blue[0][1] + blue[1][1] + blue[2][1] + "|");
        System.out.println("|" + green[2][2] + green[1][2] + green[0][2] + "|" + white[2][0] + white[2][1] + white[2][2]
                + "|" + blue[0][0] + blue[1][0] + blue[2][0] + "|");
        System.out.println(" _________ ");
        System.out.println("    |" + red[0][0] + red[0][1] + red[0][2] + "|   ");
        System.out.println("    |" + red[1][0] + red[1][1] + red[1][2] + "|   ");
        System.out.println("    |" + red[2][0] + red[2][1] + red[2][2] + "|   ");
        System.out.println("     ---    ");
        System.out.println("    |" + yellow[0][0] + yellow[0][1] + yellow[0][2] + "|   ");
        System.out.println("    |" + yellow[1][0] + yellow[1][1] + yellow[1][2] + "|   ");
        System.out.println("    |" + yellow[2][0] + yellow[2][1] + yellow[2][2] + "|   ");
        System.out.println("     ---    ");
    }

    public void faceTurn(int center, boolean direction) { // true for clockwise, false for CCW
        // array values and indexes are: 0 - index, 1 - first corner coordinate 1, 2 -
        // first corner coordinate 2,
        // 3 - first edge coordinate, 4 - second edge coordinate, 5 - second corner
        // coordinate 1, 6 - second corner coordinate 2
        turnCount++;

        int[] side1 = { 0, 0, 0, 0, 0, 0, 0 };
        int[] side2 = { 0, 0, 0, 0, 0, 0, 0 };
        int[] side3 = { 0, 0, 0, 0, 0, 0, 0 };
        int[] side4 = { 0, 0, 0, 0, 0, 0, 0 };
        int sameSide = -1;

        switch (center) {

        case 0:
            int[] whiteSide1 = { 3, 0, 2, 0, 1, 0, 0 };
            int[] whiteSide2 = { 4, 0, 2, 0, 1, 0, 0 };
            int[] whiteSide3 = { 2, 0, 2, 0, 1, 0, 0 };
            int[] whiteSide4 = { 1, 0, 2, 0, 1, 0, 0 };
            side1 = whiteSide1;
            side2 = whiteSide2;
            side3 = whiteSide3;
            side4 = whiteSide4;
            sameSide = 5;
            break;

        case 1:
            int[] redSide1 = { 3, 2, 2, 1, 2, 0, 2 };
            int[] redSide2 = { 0, 2, 0, 2, 1, 2, 2 };
            int[] redSide3 = { 2, 0, 0, 1, 0, 2, 0 };
            int[] redSide4 = { 5, 0, 2, 0, 1, 0, 0 };
            side1 = redSide1;
            side2 = redSide2;
            side3 = redSide3;
            side4 = redSide4;
            sameSide = 4;
            break;

        case 2:
            int[] blueSide1 = { 0, 2, 2, 1, 2, 0, 2 };
            int[] blueSide2 = { 4, 0, 0, 1, 0, 2, 0 };
            int[] blueSide3 = { 5, 2, 2, 1, 2, 0, 2 };
            int[] blueSide4 = { 1, 2, 2, 1, 2, 0, 2 };
            side1 = blueSide1;
            side2 = blueSide2;
            side3 = blueSide3;
            side4 = blueSide4;
            sameSide = 3;
            break;

        case 3:
            int[] greenSide1 = { 5, 0, 0, 1, 0, 2, 0 };
            int[] greenSide2 = { 4, 2, 2, 1, 2, 0, 2 };
            int[] greenSide3 = { 0, 0, 0, 1, 0, 2, 0 };
            int[] greenSide4 = { 1, 0, 0, 1, 0, 2, 0 };
            side1 = greenSide1;
            side2 = greenSide2;
            side3 = greenSide3;
            side4 = greenSide4;
            sameSide = 2;
            break;

        case 4:
            int[] orangeSide1 = { 3, 0, 0, 1, 0, 2, 0 };
            int[] orangeSide2 = { 5, 2, 0, 2, 1, 2, 2 };
            int[] orangeSide3 = { 2, 2, 2, 1, 2, 0, 2 };
            int[] orangeSide4 = { 0, 0, 2, 0, 1, 0, 0 };
            side1 = orangeSide1;
            side2 = orangeSide2;
            side3 = orangeSide3;
            side4 = orangeSide4;
            sameSide = 1;
            break;

        case 5:
            int[] yellowSide1 = { 3, 2, 0, 2, 1, 2, 2 };
            int[] yellowSide2 = { 1, 2, 0, 2, 1, 2, 2 };
            int[] yellowSide3 = { 2, 2, 0, 2, 1, 2, 2 };
            int[] yelloSide4 = { 4, 2, 0, 2, 1, 2, 2 };
            side1 = yellowSide1;
            side2 = yellowSide2;
            side3 = yellowSide3;
            side4 = yelloSide4;
            sameSide = 0;
            break;
        }

        int centerFace[][] = sides.get(center);
        int sideFace1[][] = sides.get(side1[0]);
        int sideFace2[][] = sides.get(side2[0]);
        int sideFace3[][] = sides.get(side3[0]);
        int sideFace4[][] = sides.get(side4[0]);
        int finalSide[][] = sides.get(sameSide);
        int centerEdgeHold = centerFace[0][1];
        int centerCornerHold = centerFace[0][0];
        int cornerHold1 = sideFace1[side1[1]][side1[2]];
        int edgeHold = sideFace1[side1[3]][side1[4]];
        int cornerHold2 = sideFace1[side1[5]][side1[6]];

        if (direction == true) {
            centerFace[0][1] = centerFace[1][0];
            centerFace[1][0] = centerFace[2][1];
            centerFace[2][1] = centerFace[1][2];
            centerFace[1][2] = centerEdgeHold;

            centerFace[0][0] = centerFace[2][0];
            centerFace[2][0] = centerFace[2][2];
            centerFace[2][2] = centerFace[0][2];
            centerFace[0][2] = centerCornerHold;

            sideFace1[side1[1]][side1[2]] = sideFace4[side4[1]][side4[2]];
            sideFace1[side1[3]][side1[4]] = sideFace4[side4[3]][side4[4]];
            sideFace1[side1[5]][side1[6]] = sideFace4[side4[5]][side4[6]];

            sideFace4[side4[1]][side4[2]] = sideFace3[side3[1]][side3[2]];
            sideFace4[side4[3]][side4[4]] = sideFace3[side3[3]][side3[4]];
            sideFace4[side4[5]][side4[6]] = sideFace3[side3[5]][side3[6]];

            sideFace3[side3[1]][side3[2]] = sideFace2[side2[1]][side2[2]];
            sideFace3[side3[3]][side3[4]] = sideFace2[side2[3]][side2[4]];
            sideFace3[side3[5]][side3[6]] = sideFace2[side2[5]][side2[6]];

            sideFace2[side2[1]][side2[2]] = cornerHold1;
            sideFace2[side2[3]][side2[4]] = edgeHold;
            sideFace2[side2[5]][side2[6]] = cornerHold2;
            // System.out.println("********Clockwise ROTATION around side " + center +
            // "*****************");
        }

        else {
            centerFace[0][1] = centerFace[1][2];
            centerFace[1][2] = centerFace[2][1];
            centerFace[2][1] = centerFace[1][0];
            centerFace[1][0] = centerEdgeHold;

            centerFace[0][0] = centerFace[0][2];
            centerFace[0][2] = centerFace[2][2];
            centerFace[2][2] = centerFace[2][0];
            centerFace[2][0] = centerCornerHold;

            sideFace1[side1[1]][side1[2]] = sideFace2[side2[1]][side2[2]];
            sideFace1[side1[3]][side1[4]] = sideFace2[side2[3]][side2[4]];
            sideFace1[side1[5]][side1[6]] = sideFace2[side2[5]][side2[6]];

            sideFace2[side2[1]][side2[2]] = sideFace3[side3[1]][side3[2]];
            sideFace2[side2[3]][side2[4]] = sideFace3[side3[3]][side3[4]];
            sideFace2[side2[5]][side2[6]] = sideFace3[side3[5]][side3[6]];

            sideFace3[side3[1]][side3[2]] = sideFace4[side4[1]][side4[2]];
            sideFace3[side3[3]][side3[4]] = sideFace4[side4[3]][side4[4]];
            sideFace3[side3[5]][side3[6]] = sideFace4[side4[5]][side4[6]];

            sideFace4[side4[1]][side4[2]] = cornerHold1;
            sideFace4[side4[3]][side4[4]] = edgeHold;
            sideFace4[side4[5]][side4[6]] = cornerHold2;
            // System.out.println("*****Counter-Clockwise ROTATION around side " + center +
            // "*************");
        }
        // rewrites all new faces to their old locations in the array list
        ArrayList<int[][]> newSides = new ArrayList<int[][]>(6);

        for (int i = 0; i < 6; i++) {
            if (i == center)
                newSides.add(i, centerFace);

            if (i == side1[0])
                newSides.add(i, sideFace1);

            if (i == side2[0])
                newSides.add(i, sideFace2);

            if (i == side3[0])
                newSides.add(i, sideFace3);

            if (i == side4[0])
                newSides.add(i, sideFace4);

            if (i == sameSide)
                newSides.add(i, finalSide);
        }

        sides = newSides;
        // this.displayNet(); //remove comment while debugging
        addTurn(center, direction);
    }

    public void faceTurn(int center) {// default the call to a clockwise turn unless specified
        faceTurn(center, true);
    }

    public void faceTurn(int center, boolean direction, boolean multiple) // does 2 turns if multiple is true
    {
        if (multiple == true)
            faceTurn(center, direction);
        faceTurn(center, direction);
    }

    public void setDefault() {
        this.setSide(0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.setSide(1, 1, 1, 1, 1, 1, 1, 1, 1);
        this.setSide(2, 2, 2, 2, 2, 2, 2, 2, 2);
        this.setSide(3, 3, 3, 3, 3, 3, 3, 3, 3);
        this.setSide(4, 4, 4, 4, 4, 4, 4, 4, 4);
        this.setSide(5, 5, 5, 5, 5, 5, 5, 5, 5);
    }

    public void turnTest(int index) {// testing method for debugging turns
        int centerFace[][] = sides.get(index);
        int centerEdgeHold = centerFace[0][1];
        int centerCornerHold = centerFace[0][0];

        centerFace[0][1] = centerFace[1][0];
        centerFace[1][0] = centerFace[2][1];
        centerFace[2][1] = centerFace[1][2];
        centerFace[1][2] = centerEdgeHold;

        centerFace[0][0] = centerFace[2][0];
        centerFace[2][0] = centerFace[2][2];
        centerFace[2][2] = centerFace[0][2];
        centerFace[0][2] = centerCornerHold;

        sides.add(index, centerFace);
    }

    public int solveCube() {// reorder/rename solve method names as more are added

        if (!this.validateCube())
            return 501;// trigger react to show error message

        this.turnCount = 0;

        while (WhiteCross() != true)
            if (turnCount > 500)
                return turnCount;
        ;
        // this.displayNet();
        this.state++;

        while (F2L() != true)
            if (turnCount > 500)
                return turnCount;
        ;

        // this.displayNet();
        this.state++;

        while (OLL() != true)
            if (turnCount > 500)
                return turnCount;
        ;
        // this.displayNet();
        this.state++;

        while (PLL() != true)
            if (turnCount > 500)
                return turnCount;
        ;
        this.state++;

        while (finish() != true)
            if (turnCount > 500)
                return turnCount;
        ;
        this.state++;

        return this.turnCount;
    }

    private boolean finish() {

        int[][] front = this.getSide(1);// loads red

        switch (front[2][1]) {

        case 1:
            this.displayNet();
            return true;

        case 2:
            System.out.println("Aligning top:");
            this.faceTurn(yellow, true);
            return false;

        case 3:
            System.out.println("Aligning top:");
            this.faceTurn(yellow, false);
            return false;

        case 4:
            System.out.println("Aligning top:");
            this.faceTurn(yellow, true, true);
            return false;

        default:
            return false;
        }
    }

    private boolean PLL() {
        // load the array sides of the orange, green red and blue sides

        int sideStatus[] = { -1, -1, -1, -1 };
        ArrayList<int[][]> check = new ArrayList<int[][]>();
        check.add(this.getSide(1));// red at index 0
        check.add(this.getSide(2));// blue at index 1
        check.add(this.getSide(3));// green at index 2
        check.add(this.getSide(4));// orange at index 3
        boolean direction;

        for (int i = 0; i < 4; i++) {
            sideStatus[i] = PLLCheck(check.get(i));
        }

        if (sideStatus[0] == 2 && sideStatus[1] == 2 && sideStatus[2] == 2 && sideStatus[3] == 2)// all the top is the
                                                                                                 // same
            return true;

        if (sideStatus[0] == 1 && sideStatus[1] == 1 || sideStatus[1] == 1 && sideStatus[2] == 1
                || sideStatus[2] == 1 && sideStatus[3] == 1 || sideStatus[3] == 1 && sideStatus[1] == 1) {// all corners
                                                                                                          // match

            if (sideStatus[0] == 1 && sideStatus[1] == 1 && sideStatus[2] == 1 && sideStatus[3] == 1) {
                PLLAlg2(1, true);// default to turn red
                this.displayNet();
                return false;
            }

            else {
                for (int i = 0; i < 4; i++)
                    if (sideStatus[i] == 2) {
                        direction = PLLGetDir(i, check);
                        PLLAlg2(i + 1, direction);
                    }
                this.displayNet();
                return false;
            }
        }

        else if (sideStatus[0] != 0 && sideStatus[1] == 0 || sideStatus[1] != 0 && sideStatus[2] == 0
                || sideStatus[2] != 0 && sideStatus[3] == 0 || sideStatus[3] != 0 && sideStatus[0] == 0) {// only one
                                                                                                          // corner
                                                                                                          // set
                                                                                                          // matches
            for (int i = 0; i < 4; i++) {
                if (sideStatus[i] != 0)
                    PLLAlg1(i + 1);
            }
            return false;
        }

        else
            PLLAlg1(1);// default to turn red
        this.displayNet();
        return false;

    }

    public boolean OLL() {

        int[][] check = { { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 } };//
        int[][] yellow = this.getSide(5);
        int[][] red = this.getSide(1);
        int[][] blue = this.getSide(2);
        int[][] green = this.getSide(3);
        int[][] orange = this.getSide(4);

        for (int x = 1; x < 4; x++) {
            for (int y = 1; y < 4; y++)
                check[x][y] = yellow[x - 1][y - 1];
        }

        check[0][1] = red[2][0];
        check[0][2] = red[2][1];
        check[0][3] = red[2][2];
        check[1][4] = blue[2][0];
        check[2][4] = blue[2][1];
        check[3][4] = blue[2][2];
        check[1][0] = green[2][2];
        check[2][0] = green[2][1];
        check[3][0] = green[2][0];
        check[4][1] = orange[2][2];
        check[4][2] = orange[2][1];
        check[4][3] = orange[2][0];

        int switchSelect1 = OLLSwitch1(yellow);

        if (switchSelect1 != 0) {

            System.out.println("Starting OLL first algorithm");
            switch (switchSelect1) {

            case 1:
                this.faceTurn(4); // line
                this.faceTurn(2);
                this.faceTurn(5);
                this.faceTurn(2, false);
                this.faceTurn(5, false);
                this.faceTurn(4, false);
                break;

            case 2:
                this.faceTurn(4); // L
                this.faceTurn(5);
                this.faceTurn(2);
                this.faceTurn(5, false);
                this.faceTurn(2, false);
                this.faceTurn(4, false);
                break;

            case 3:
                this.faceTurn(4); // 'dot' case does case 1 and then case 2 algorithims
                this.faceTurn(2);
                this.faceTurn(5);
                this.faceTurn(2, false);
                this.faceTurn(5, false);
                this.faceTurn(4, false);
                this.faceTurn(5, true, true);

                this.faceTurn(4);
                this.faceTurn(5);
                this.faceTurn(2);
                this.faceTurn(5, false);
                this.faceTurn(2, false);
                this.faceTurn(4, false);
                break;

            case 4:
                this.faceTurn(5);
            }
            System.out.println(this.turnCount);
            return false;
        }

        int switchSelect2 = OLLSwitch2(check);

        if (switchSelect2 != 0 && switchSelect2 != 8)
            System.out.println("Starting OLL second algorithm:");

        switch (switchSelect2) {

        case 0:
            this.displayNet();
            return true;

        case 1:
            this.faceTurn(2, true, true); // (R2' D) (R' U2) (R D') (R' U2 R')
            this.faceTurn(0);
            this.faceTurn(2, false);
            this.faceTurn(5, true, true);
            this.faceTurn(2);
            this.faceTurn(0, false);
            this.faceTurn(2, false);
            this.faceTurn(5, true, true);
            this.faceTurn(2, false);
            break;

        case 2:
            this.faceTurn(3); // L F R' F' L' F R F'
            this.faceTurn(4);
            this.faceTurn(2, false);
            this.faceTurn(4, false);
            this.faceTurn(3, false);
            this.faceTurn(4);
            this.faceTurn(2);
            this.faceTurn(4, false);
            break;

        case 3:
            this.faceTurn(2); // R U2 R' U' (R U R' U') (R U R' U') R U' R'
            this.faceTurn(5, true, true);
            this.faceTurn(2, false);
            this.faceTurn(5, false);
            this.faceTurn(2);
            this.faceTurn(5);
            this.faceTurn(2, false);
            this.faceTurn(5, false);
            this.faceTurn(2);
            this.faceTurn(5);
            this.faceTurn(2, false);
            this.faceTurn(5, false);
            this.faceTurn(2);
            this.faceTurn(5, false);
            this.faceTurn(2, false);
            break;

        case 4:
            this.faceTurn(2); // sune
            this.faceTurn(5);
            this.faceTurn(2, false);
            this.faceTurn(5);
            this.faceTurn(2);
            this.faceTurn(5, true, true);
            this.faceTurn(2, false);
            break;

        case 5:
            this.faceTurn(2, false); // anti-sune
            this.faceTurn(5);
            this.faceTurn(3);
            this.faceTurn(5, false);
            this.faceTurn(2);
            this.faceTurn(5);
            this.faceTurn(3, false);
            break;

        case 6:
            this.faceTurn(2); // R U2' [R2 U'] [R2 U'] R2 U2' R
            this.faceTurn(5, true, true);
            this.faceTurn(2, true, true);
            this.faceTurn(5, false);
            this.faceTurn(2, true, true);
            this.faceTurn(5, false);
            this.faceTurn(2, true, true);
            this.faceTurn(5, true, true);
            this.faceTurn(2);
            break;

        case 7:
            this.faceTurn(2); // (R U2') (R2' U') (R2 U') (R2' U2' R)
            this.faceTurn(5, true, true);
            this.faceTurn(2, true, true);
            this.faceTurn(5, false);
            this.faceTurn(2, true, true);
            this.faceTurn(5, false);
            this.faceTurn(2, true, true);
            this.faceTurn(5, true, true);
            this.faceTurn(2);
            break;

        case 8:
            this.faceTurn(5);
            break;
        }

        return false;
    }

    public boolean F2L() {
        return F2L(0);
    }

    public boolean F2L(int status) {
        // status int starts at 0, increments by one each time a pair is F2Linserted

        int[][] white = this.getSide(0);
        int[][] red = this.getSide(1);
        int[][] blue = this.getSide(2);
        int[][] green = this.getSide(3);
        int[][] orange = this.getSide(4);
        int[][] yellow = this.getSide(5);

        // corner 1 check

        while (status == 0) { // corner 1 - orange and green

            if (white[0][0] == 0 && orange[0][2] == 4 && green[0][0] == 3 && orange[1][2] == 4 && green[1][0] == 3)
                return F2L(1);

            if (white[0][0] == 0 && orange[0][2] == 4 || white[0][0] == 3 && orange[0][2] == 0
                    || white[0][0] == 4 && orange[0][2] == 3) { // check if corner is in green-orange
                this.faceTurn(4);
                this.faceTurn(5);
                this.faceTurn(4, false);
                this.faceTurn(5, false);
            }

            if (white[0][2] == 0 && blue[0][2] == 4 || white[0][2] == 3 && blue[0][2] == 0
                    || white[0][2] == 4 && blue[0][2] == 3) { // check if corner is in orange - blue
                this.faceTurn(2);
                this.faceTurn(5);
                this.faceTurn(2, false);
            }

            if (white[2][2] == 0 && red[0][2] == 4 || white[2][2] == 3 && red[0][2] == 0
                    || white[2][2] == 4 && red[0][2] == 3) { // check if corner is in blue - red
                this.faceTurn(1);
                this.faceTurn(5);
                this.faceTurn(1, false);
                this.faceTurn(5);
            }

            if (white[2][0] == 0 && green[0][2] == 4 || white[2][0] == 3 && green[0][2] == 0
                    || white[2][0] == 4 && green[0][2] == 3) { // check if corner is in red - green
                this.faceTurn(3);
                this.faceTurn(5);
                this.faceTurn(3, false);
                this.faceTurn(5, true, true);
                this.displayNet();
            }

            // see if corner was in top layer already
            if (yellow[0][0] == 3 && green[2][2] == 4 || yellow[0][0] == 4 && green[2][2] == 0
                    || yellow[0][0] == 0 && green[2][2] == 3) // check if corner is above red-green
                this.faceTurn(5, false);

            if (yellow[0][2] == 3 && red[2][2] == 4 || yellow[0][2] == 4 && red[2][2] == 0
                    || yellow[0][2] == 0 && red[2][2] == 3) // check if corner is above blue-red
                this.faceTurn(5, false, true);

            if (yellow[2][2] == 3 && blue[2][2] == 4 || yellow[2][2] == 4 && blue[2][2] == 0
                    || yellow[2][2] == 0 && blue[2][2] == 3) {
                this.faceTurn(5);
            }

            // corner has to be in top layer now right above where it should go in

            if (green[1][0] == 3 && orange[1][2] == 4 || green[1][0] == 4 && orange[1][2] == 3) {// checks under corner
                                                                                                 // slot (why its
                                                                                                 // longer)
                this.faceTurn(4);
                this.faceTurn(5);
                this.faceTurn(4, false);
                this.faceTurn(5, true, true);
                this.faceTurn(4);
                this.faceTurn(5, false);
                this.faceTurn(4, false);
            }

            if (orange[1][0] == 3 && blue[1][2] == 4 || orange[1][0] == 4 && blue[1][2] == 3) {// orange blue
                this.faceTurn(5);
                this.faceTurn(2);
                this.faceTurn(5, false);
                this.faceTurn(2, false);
            }

            if (blue[1][0] == 3 && red[1][2] == 4 || blue[1][0] == 4 && red[1][2] == 3) { // blue-red
                this.faceTurn(1);
                this.faceTurn(5, false);
                this.faceTurn(1, false);
                this.faceTurn(5);
            }

            if (red[1][0] == 3 && green[1][2] == 4 || red[1][0] == 4 && green[1][2] == 3) { // red-green
                this.faceTurn(5, false);
                this.faceTurn(3);
                this.faceTurn(5, false);
                this.faceTurn(3, false);
                this.faceTurn(5, true, true);
                this.displayNet();
            }

            if (yellow[2][1] == 3 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 3) {// edge is directly
                                                                                                   // to right
                                                                                                   // (orange-yellow)
                this.faceTurn(3, false);
                this.faceTurn(5, true, true);
                this.faceTurn(3);
                this.faceTurn(5);
                // should then activate next if statement
            }

            if (yellow[1][2] == 3 && blue[2][1] == 4 || yellow[1][2] == 4 && blue[2][1] == 3) {// edge is in opposite
                                                                                               // spot of corner
                                                                                               // (blue-yellow)
                this.faceTurn(5);
                this.faceTurn(3, false);
                this.faceTurn(5, false);
                this.faceTurn(3);
                this.faceTurn(5, false);
            }

            if (yellow[1][0] == 3 && orange[2][1] == 4 || yellow[1][0] == 4 && orange[2][1] == 3) {// edge is directly
                                                                                                   // to left
                                                                                                   // (green-yellow)
                this.faceTurn(3, false);
                this.faceTurn(5, true, true);
                this.faceTurn(3);
                this.faceTurn(5);
            }
            // now matching corner and edge are in the top layer and corner to the left -
            // ready for F2Linsert
            this.F2Linsert(0);
        }

        while (status == 1) { // pair 2 - red - green

            this.displayNet();

            if (white[2][0] == 0 && red[0][0] == 1 && red[1][0] == 1 && green[0][2] == 3 && green[1][2] == 3)
                return F2L(2);

            if (white[2][0] == 0 && red[0][0] == 1 || white[2][0] == 1 && red[0][0] == 3
                    || white[2][0] == 3 && red[0][0] == 0) { // check if corner is in red - green
                this.faceTurn(3);
                this.faceTurn(5);
                this.faceTurn(3, false);
                this.faceTurn(5, false);
            }

            if (white[0][2] == 0 && blue[0][2] == 1 || white[0][2] == 1 && blue[0][2] == 3
                    || white[0][2] == 3 && blue[0][2] == 0) { // check if corner is in orange - blue
                this.faceTurn(2);
                this.faceTurn(5);
                this.faceTurn(2, false);
                this.faceTurn(5);
            }

            if (white[2][2] == 0 && blue[0][0] == 1 || white[2][2] == 1 && blue[0][0] == 3
                    || white[2][2] == 3 && blue[0][2] == 0) { // check if corner is in blue - red
                this.faceTurn(1);
                this.faceTurn(5);
                this.faceTurn(1, false);
                this.faceTurn(5, true, true);
            }

            // see if corner was in top layer already
            if (yellow[2][1] == 0 && green[2][0] == 1 || yellow[2][1] == 1 && green[2][0] == 3
                    || yellow[2][1] == 3 && green[2][0] == 0) // check if corner is above orange-green
                this.faceTurn(5);

            if (yellow[0][2] == 0 && red[2][2] == 1 || yellow[0][2] == 1 && red[2][2] == 3
                    || yellow[0][2] == 3 && red[2][2] == 0) // check if corner is above blue-red
                this.faceTurn(5, false);

            if (yellow[2][2] == 0 && blue[2][2] == 1 || yellow[2][2] == 1 && blue[2][2] == 3
                    || yellow[2][2] == 3 && blue[2][2] == 0) {// check above blue-orange
                this.faceTurn(5, true, true);
            }

            // corner has to be in top layer now right above where it should go in

            if (green[1][2] == 3 && red[1][0] == 1 || green[1][2] == 1 && red[1][0] == 3) {// checks under corner slot
                                                                                           // (why its longer)
                this.faceTurn(3);
                this.faceTurn(5);
                this.faceTurn(3, false);
                this.faceTurn(5, true, true);
                this.faceTurn(3);
                this.faceTurn(5, false);
                this.faceTurn(3, false);
            }

            if (blue[1][2] == 1 && orange[1][0] == 3 || blue[1][2] == 3 && orange[1][0] == 1) { // orange-blue
                this.faceTurn(2);
                this.faceTurn(5, false);
                this.faceTurn(2, false);
                this.faceTurn(5);
            }

            if (red[1][2] == 1 && blue[1][0] == 3 || red[1][2] == 3 && blue[1][0] == 1) { // blue-red
                this.faceTurn(5, false);
                this.faceTurn(1);
                this.faceTurn(5, false);
                this.faceTurn(1, false);
                this.faceTurn(5, true, true);
            }

            if (yellow[1][0] == 3 && green[2][1] == 1 || yellow[1][0] == 1 && green[2][1] == 3) {// edge is directly to
                                                                                                 // right
                this.faceTurn(1, false);
                this.faceTurn(5, true, true);
                this.faceTurn(1);
                this.faceTurn(5);
                // should then activate next if statement
            }

            if (yellow[2][1] == 3 && orange[2][1] == 1 || yellow[2][1] == 1 && orange[2][1] == 3) {// edge is in
                                                                                                   // opposite spot of
                                                                                                   // corner
                this.faceTurn(5);
                this.faceTurn(1, false);
                this.faceTurn(5, false);
                this.faceTurn(1);
                this.faceTurn(5, false);

            }

            if (yellow[0][1] == 3 && red[2][1] == 1 || yellow[0][1] == 1 && red[2][1] == 3) {// edge is directly to left
                this.faceTurn(1, false);
                this.faceTurn(5, true, true);
                this.faceTurn(1);
                this.faceTurn(5);
            }
            this.displayNet();
            this.F2Linsert(1);
        }

        while (status == 2) {// pair 3 - blue-red

            if (white[2][2] == 0 && blue[0][0] == 2 && blue[1][0] == 2 && red[0][2] == 1 && red[1][2] == 1)
                return F2L(3);

            if (white[2][2] == 0 && blue[0][0] == 2 || white[2][2] == 2 && blue[0][0] == 1
                    || white[2][2] == 1 && blue[0][0] == 0) { // check if corner is in blue-red
                this.faceTurn(1);
                this.faceTurn(5);
                this.faceTurn(1, false);
                this.faceTurn(5, false);
            }

            if (white[0][2] == 0 && blue[0][2] == 2 || white[0][2] == 2 && blue[0][2] == 1
                    || white[0][2] == 1 && blue[0][2] == 0) { // check if corner is in orange-blue
                this.faceTurn(2);
                this.faceTurn(5);
                this.faceTurn(2, false);
                this.faceTurn(5, true, true);
            }

            // see if corner was in top layer already
            if (yellow[0][0] == 0 && green[2][2] == 2 || yellow[0][0] == 1 && green[2][2] == 0
                    || yellow[0][0] == 2 && green[2][2] == 1) // check if corner is above red-green
                this.faceTurn(5);

            if (yellow[2][0] == 0 && orange[2][2] == 2 || yellow[2][0] == 1 && orange[2][2] == 0
                    || yellow[2][0] == 2 && orange[2][2] == 1) // check if corner is above green-orange
                this.faceTurn(5, false, true);

            if (yellow[2][2] == 0 && blue[2][2] == 2 || yellow[2][2] == 1 && blue[2][2] == 0
                    || yellow[2][2] == 2 && blue[2][2] == 1)// check blue-orange
                this.faceTurn(5, false);

            // corner has to be in top layer now right above where it should go in

            if (blue[1][0] == 1 && red[1][2] == 2 || blue[1][0] == 2 && red[1][2] == 1) {// checks under corner slot
                                                                                         // (why its longer)
                this.faceTurn(1);
                this.faceTurn(5);
                this.faceTurn(1, false);
                this.faceTurn(5, true, true);
                this.faceTurn(1);
                this.faceTurn(5, false);
                this.faceTurn(1, false);
            }

            if (orange[1][0] == 1 && blue[1][2] == 2 || orange[1][0] == 2 && blue[1][2] == 1) {// orange blue
                this.faceTurn(5, false);
                this.faceTurn(2);
                this.faceTurn(5, false);
                this.faceTurn(2, false);
                this.faceTurn(5, true, true);
            }

            if (yellow[0][1] == 1 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 1) {// edge is directly to
                                                                                             // right (red)
                this.faceTurn(1);
                this.faceTurn(5, true, true);
                this.faceTurn(1, false);
                this.faceTurn(5, false);
                // should then activate next if statement
            }

            if (yellow[1][0] == 1 && green[2][1] == 2 || yellow[1][0] == 2 && green[2][1] == 1) {// edge is in opposite
                                                                                                 // spot of corner
                                                                                                 // (green)
                this.faceTurn(5, false);
                this.faceTurn(1);
                this.faceTurn(5, false);
                this.faceTurn(1, false);
                this.faceTurn(5);
            }

            if (yellow[2][0] == 3 && blue[2][1] == 4 || yellow[2][0] == 4 && blue[2][1] == 3) {// edge is directly to
                                                                                               // left (blue)
                this.faceTurn(1);
                this.faceTurn(5, true, true);
                this.faceTurn(1, false);
                this.faceTurn(5, false);
            }
            this.F2Linsert(2);
        }

        while (status == 3) {// pair 4 - orange-blue

            if (white[0][2] == 0 && orange[0][0] == 4 && orange[1][0] == 4 && blue[0][2] == 2 && blue[1][2] == 2)
                return true; // all pairs are matched up

            if (white[0][2] == 0 && orange[0][0] == 4 || white[0][2] == 2 && orange[0][0] == 0
                    || white[0][2] == 4 && orange[0][0] == 2) { // check if corner is in orange-blue
                this.faceTurn(2);
                this.faceTurn(5);
                this.faceTurn(2, false);
                this.faceTurn(5, false);
            }

            // see if corner was in top layer already
            if (yellow[0][2] == 0 && red[2][2] == 4 || yellow[0][2] == 2 && red[2][2] == 0
                    || yellow[0][2] == 4 && red[2][2] == 2) // check if corner is above blue-red
                this.faceTurn(5);

            if (yellow[0][0] == 0 && green[2][2] == 4 || yellow[0][0] == 2 && green[2][2] == 0
                    || yellow[0][0] == 4 && green[2][2] == 2) // check if corner is above red-green
                this.faceTurn(5, false, true);

            if (yellow[2][0] == 0 && orange[2][2] == 4 || yellow[2][0] == 2 && orange[2][2] == 0
                    || yellow[2][0] == 4 && orange[2][2] == 2)// check green-orange
                this.faceTurn(5, false);

            // corner has to be in top layer now right above where it should go in

            if (orange[1][0] == 2 && blue[1][2] == 4 || orange[1][0] == 4 && blue[1][2] == 2) {// checks under corner
                                                                                               // slot (why its longer)
                this.faceTurn(2);
                this.faceTurn(5);
                this.faceTurn(2, false);
                this.faceTurn(5, true, true);
                this.faceTurn(2);
                this.faceTurn(5, false);
                this.faceTurn(2, false);
            }

            if (yellow[1][2] == 4 && blue[2][1] == 2 || yellow[1][2] == 2 && blue[2][1] == 4) {// edge is directly to
                                                                                               // right (blue)
                this.faceTurn(2);
                this.faceTurn(5, true, true);
                this.faceTurn(2, false);
                this.faceTurn(5, false);
                // should then activate next if statement
            }

            if (yellow[0][1] == 4 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 4) {// edge is in opposite spot
                                                                                             // of corner (red
                this.faceTurn(5, false);
                this.faceTurn(2);
                this.faceTurn(5, false);
                this.faceTurn(2, false);
                this.faceTurn(5);
            }

            if (yellow[2][1] == 2 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 2) {// edge is directly
                                                                                                   // to left (orange)
                this.faceTurn(2);
                this.faceTurn(5, true, true);
                this.faceTurn(2, false);
                this.faceTurn(5, false);
            }
            this.F2Linsert(3);
        }
        return false; // never reached
    }

    private boolean WhiteCross() {
        return WhiteCross(0);
    }

    private boolean WhiteCross(int state) {
        // method that will take random cube and create the white cross

        // sequentially find each white edge and move it to the right spot
        // find edges and line them up in order: red, blue, orange, green (improve
        // later)
        int[][] white = this.getSide(0);
        int[][] red = this.getSide(1);
        int[][] blue = this.getSide(2);
        int[][] green = this.getSide(3);
        int[][] orange = this.getSide(4);
        int[][] yellow = this.getSide(5);

        while (state == 0) {// red white

            if (white[2][1] == 0 && red[0][1] == 1) {
                return WhiteCross(1);
            }

            if (yellow[0][1] == 0 && red[2][1] == 1 || yellow[0][1] == 1 && red[2][1] == 0) {
                this.faceTurn(1);
                return WhiteCross(0);
            }

            if (yellow[1][2] == 0 && blue[2][1] == 1 || yellow[1][2] == 1 && blue[2][1] == 0) {
                this.faceTurn(2);
                return WhiteCross(0);
            }

            if (yellow[2][1] == 0 && orange[2][1] == 1 || yellow[2][1] == 1 && orange[2][1] == 0) {
                this.faceTurn(4);
                return WhiteCross(0);
            }

            if (yellow[1][0] == 0 && green[2][1] == 1 || yellow[1][0] == 1 && green[2][1] == 0) {
                this.faceTurn(3);
                return WhiteCross(0);
            }

            if (red[1][2] == 1 && blue[1][0] == 0) {
                this.faceTurn(1, false);
                return WhiteCross(0);
            }

            if (red[1][2] == 0 && blue[1][0] == 1) {
                this.faceTurn(2);
                this.faceTurn(0);
                return WhiteCross(0);
            }

            if (blue[1][2] == 1 && orange[1][0] == 0) {
                this.faceTurn(2, false);
                this.faceTurn(0);
                return WhiteCross(0);
            }

            if (blue[1][2] == 0 && orange[1][0] == 1) {
                this.faceTurn(4);
                this.faceTurn(0, true, true);
                return WhiteCross(0);
            }

            if (orange[1][2] == 1 && green[1][0] == 0) {
                this.faceTurn(4, false);
                this.faceTurn(0, true, true);
                return WhiteCross(0);
            }

            if (orange[1][2] == 0 && green[1][0] == 1) {
                this.faceTurn(3);
                this.faceTurn(0, false);
                return WhiteCross(0);
            }

            if (green[1][2] == 1 && red[1][0] == 0) {
                this.faceTurn(3, false);
                this.faceTurn(0, false);
                return WhiteCross(0);
            }

            if (green[1][2] == 0 && red[1][0] == 1) {
                this.faceTurn(1);
                return WhiteCross(0);
            }

            if (white[2][1] == 1 && red[0][1] == 0) {
                this.faceTurn(1);
                this.faceTurn(0, false);
                this.faceTurn(2);
                this.faceTurn(0);
                return WhiteCross(0);
            }

            if (white[1][2] == 0 && blue[0][1] == 1) {
                this.faceTurn(0);
                return WhiteCross(0);
            }

            if (white[1][2] == 1 && blue[0][1] == 0) {
                this.faceTurn(2, false);
                this.faceTurn(1, false);
                return WhiteCross(0);
            }

            if (white[0][1] == 0 && orange[0][1] == 1) {
                this.faceTurn(0, true, true);
                return WhiteCross(0);
            }

            if (white[0][1] == 1 && orange[0][1] == 0) {
                this.faceTurn(4, false);
                this.faceTurn(0, false);
                this.faceTurn(1, false);
                this.faceTurn(0);
                return WhiteCross(0);
            }

            if (white[1][0] == 0 && green[0][1] == 1) {
                this.faceTurn(0, false);
                return WhiteCross(0);
            }

            if (white[1][0] == 1 && green[0][1] == 0) {
                this.faceTurn(3);
                this.faceTurn(1);
                return WhiteCross(0);
            }
        }

        while (state == 1) {// white blue

            if (white[1][2] == 0 && blue[0][1] == 2) {
                return WhiteCross(2);
            }

            if (yellow[0][1] == 0 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 0) {
                this.faceTurn(1);
                return WhiteCross(1);
            }

            if (yellow[1][2] == 0 && blue[2][1] == 2 || yellow[1][2] == 2 && blue[2][1] == 0) {
                this.faceTurn(2);
                return WhiteCross(1);
            }

            if (yellow[2][1] == 0 && orange[2][1] == 2 || yellow[2][1] == 2 && orange[2][1] == 0) {
                this.faceTurn(4);
                return WhiteCross(1);
            }

            if (yellow[1][0] == 0 && green[2][1] == 2 || yellow[1][0] == 2 && green[2][1] == 0) {
                this.faceTurn(3);
                return WhiteCross(1);
            }

            if (red[1][2] == 2 && blue[1][0] == 0) {
                this.faceTurn(0);
                this.faceTurn(1, false);
                this.faceTurn(0, false);
                return WhiteCross(1);
            }

            if (red[1][2] == 0 && blue[1][0] == 2) {
                this.faceTurn(2);
                return WhiteCross(1);
            }

            if (blue[1][2] == 2 && orange[1][0] == 0) {
                this.faceTurn(2, false);
                return WhiteCross(1);
            }

            if (blue[1][2] == 0 && orange[1][0] == 2) {
                this.faceTurn(0, false);
                this.faceTurn(4);
                this.faceTurn(0, true);
                return WhiteCross(1);
            }

            if (orange[1][2] == 2 && green[1][0] == 0) {
                this.faceTurn(0, false);
                this.faceTurn(4, false);
                this.faceTurn(0, true);
                return WhiteCross(1);
            }

            if (orange[1][2] == 0 && green[1][0] == 2) {
                this.faceTurn(0, true, true);
                this.faceTurn(3);
                this.faceTurn(0, false, true);
                return WhiteCross(1);
            }

            if (green[1][2] == 2 && red[1][0] == 0) {
                this.faceTurn(0, true, true);
                this.faceTurn(3, false);
                this.faceTurn(0, false, true);
                return WhiteCross(1);
            }

            if (green[1][2] == 0 && red[1][0] == 2) {
                this.faceTurn(0);
                this.faceTurn(1);
                this.faceTurn(0, false);
                return WhiteCross(1);
            }

            if (white[1][2] == 2 && blue[0][1] == 0) {
                this.faceTurn(2);
                this.faceTurn(0, false);
                this.faceTurn(4);
                this.faceTurn(0);
                return WhiteCross(1);
            }

            if (white[0][1] == 0 && orange[0][1] == 2) {
                this.faceTurn(0);
                return WhiteCross(1);
            }

            if (white[0][1] == 2 && orange[0][1] == 0) {
                this.faceTurn(4, false);
                this.faceTurn(2, false);
                return WhiteCross(1);
            }

            if (white[1][0] == 0 && green[0][1] == 2) {
                this.faceTurn(0, false, true);
                return WhiteCross(1);
            }

            if (white[1][0] == 2 && green[0][1] == 0) {
                this.faceTurn(3);
                this.faceTurn(0);
                this.faceTurn(1);
                this.faceTurn(0, false);
                return WhiteCross(1);
            }
        }

        while (state == 2) {// white orange

            if (white[0][1] == 0 && orange[0][1] == 4) {
                return WhiteCross(3);
            }

            if (yellow[0][1] == 0 && red[2][1] == 4 || yellow[0][1] == 4 && red[2][1] == 0) {
                this.faceTurn(1);
                return WhiteCross(2);
            }

            if (yellow[1][2] == 0 && blue[2][1] == 4 || yellow[1][2] == 4 && blue[2][1] == 0) {
                this.faceTurn(2);
                return WhiteCross(2);
            }

            if (yellow[2][1] == 0 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 0) {
                this.faceTurn(4);
                return WhiteCross(2);
            }

            if (yellow[1][0] == 0 && green[2][1] == 4 || yellow[1][0] == 4 && green[2][1] == 0) {
                this.faceTurn(3);
                return WhiteCross(2);
            }

            if (red[1][2] == 4 && blue[1][0] == 0) {
                this.faceTurn(0, true, true);
                this.faceTurn(1, false);
                this.faceTurn(0, false, true);
                return WhiteCross(2);
            }

            if (red[1][2] == 0 && blue[1][0] == 4) {
                this.faceTurn(0);
                this.faceTurn(2);
                this.faceTurn(0, false);
                return WhiteCross(2);
            }

            if (blue[1][2] == 4 && orange[1][0] == 0) {

                this.faceTurn(0);
                this.faceTurn(2, false);
                this.faceTurn(0, false);
                return WhiteCross(2);
            }

            if (blue[1][2] == 0 && orange[1][0] == 4) {
                this.faceTurn(2);
                return WhiteCross(2);
            }

            if (orange[1][2] == 4 && green[1][0] == 0) {
                this.faceTurn(4, false);
                return WhiteCross(2);
            }

            if (orange[1][2] == 0 && green[1][0] == 4) {
                this.faceTurn(0, false);
                this.faceTurn(3);
                this.faceTurn(0);
                return WhiteCross(2);
            }

            if (green[1][2] == 4 && red[1][0] == 0) {
                this.faceTurn(0, false);
                this.faceTurn(3, false);
                this.faceTurn(0);
                return WhiteCross(2);
            }

            if (green[1][2] == 0 && red[1][0] == 4) {
                this.faceTurn(0, true, true);
                this.faceTurn(1);
                this.faceTurn(0, false, true);
                return WhiteCross(2);
            }

            if (white[0][1] == 4 && orange[0][1] == 0) {
                this.faceTurn(4, false);
                this.faceTurn(0);
                this.faceTurn(2, false);
                this.faceTurn(0, false);
                return WhiteCross(2);
            }

            if (white[1][0] == 0 && green[0][1] == 4) {
                this.faceTurn(0, true);
                return WhiteCross(2);
            }

            if (white[1][0] == 2 && green[0][1] == 0) {
                this.faceTurn(3, false);
                this.faceTurn(4, false);
                return WhiteCross(2);
            }
        }

        while (state == 3) {// white green

            if (white[1][0] == 0 && green[0][1] == 3) {
                return true;
            }

            if (yellow[0][1] == 0 && red[2][1] == 3 || yellow[0][1] == 3 && red[2][1] == 0) {
                this.faceTurn(1);
                return WhiteCross(3);
            }

            if (yellow[1][2] == 0 && blue[2][1] == 3 || yellow[1][2] == 3 && blue[2][1] == 0) {
                this.faceTurn(2);
                return WhiteCross(3);
            }

            if (yellow[2][1] == 0 && orange[2][1] == 3 || yellow[2][1] == 3 && orange[2][1] == 0) {
                this.faceTurn(4);
                return WhiteCross(3);
            }

            if (yellow[1][0] == 0 && green[2][1] == 3 || yellow[1][0] == 3 && green[2][1] == 0) {
                this.faceTurn(3);
                return WhiteCross(3);
            }

            if (red[1][2] == 3 && blue[1][0] == 0) {
                this.faceTurn(0, false);
                this.faceTurn(1, false);
                this.faceTurn(0);
                return WhiteCross(3);
            }

            if (red[1][2] == 0 && blue[1][0] == 3) {
                this.faceTurn(0, true, true);
                this.faceTurn(2);
                this.faceTurn(0, false, true);
                return WhiteCross(3);
            }

            if (blue[1][2] == 3 && orange[1][0] == 0) {
                this.faceTurn(0, true, true);
                this.faceTurn(2, false);
                this.faceTurn(0, false, true);
                return WhiteCross(3);
            }

            if (blue[1][2] == 0 && orange[1][0] == 3) {
                this.faceTurn(0);
                this.faceTurn(4);
                this.faceTurn(0, false);
                return WhiteCross(3);
            }

            if (orange[1][2] == 3 && green[1][0] == 0) {
                this.faceTurn(0);
                this.faceTurn(4, false);
                this.faceTurn(0, false);
                return WhiteCross(3);
            }

            if (orange[1][2] == 0 && green[1][0] == 3) {
                this.faceTurn(3);
                return WhiteCross(3);
            }

            if (green[1][2] == 3 && red[1][0] == 0) {
                this.faceTurn(3, false);
                return WhiteCross(3);
            }

            if (green[1][2] == 0 && red[1][0] == 3) {
                this.faceTurn(0, false);
                this.faceTurn(1);
                this.faceTurn(0);
                return WhiteCross(3);
            }
        }
        return false; // not reached
    }

    private void F2Linsert(int status) {// inserts corner/edge pairs in F2L

        int left, right, cornerX, cornerY, edgeX, edgeY;

        switch (status) {
        case 0:
            left = green;
            right = orange;
            cornerX = 2;
            cornerY = 0;
            edgeX = 0;
            edgeY = 1;
            break;

        case 1:
            left = red;
            right = green;
            cornerX = 0;
            cornerY = 0;
            edgeX = 1;
            edgeY = 2;
            break;

        case 2:
            left = blue;
            right = red;
            cornerX = 0;
            cornerY = 2;
            edgeX = 2;
            edgeY = 1;
            break;

        case 3:
            left = orange;
            right = blue;
            cornerX = 2;
            cornerY = 2;
            edgeX = 1;
            edgeY = 0;
            break;

        default:
            left = 0;
            right = 0;
            cornerX = 0;
            cornerY = 0;
            edgeX = 0;
            edgeY = 0;
        }

        int[][] Top = this.getSide(yellow);
        // int[][] Left = this.getSide(left);
        // int[][] Right = this.getSide(right);

        if (Top[cornerX][cornerY] == white) {
            // do weird alg
            if (Top[edgeX][edgeY] == left) {
                this.faceTurn(yellow, false, true);// lineup edge with matching colour(right)
                this.faceTurn(right);
                this.faceTurn(yellow);
                this.faceTurn(right, false);
                this.faceTurn(yellow);
                this.faceTurn(right);
                this.faceTurn(yellow, false);
                this.faceTurn(right, false);
            } else {
                this.faceTurn(yellow, false);// lineup edge with matching colour(left)
                this.faceTurn(left, false);
                this.faceTurn(yellow, true, true);
                this.faceTurn(left);
                this.faceTurn(yellow, false);
                this.faceTurn(left, false);
                this.faceTurn(yellow);
                this.faceTurn(left);
            }
        }

        else if (Top[cornerX][cornerY] == Top[edgeX][edgeY]) {
            // do match algorithm
            this.faceTurn(yellow);
            this.faceTurn(left, false);
            this.faceTurn(yellow, false);
            this.faceTurn(left);
            this.faceTurn(yellow, false, true);
            this.faceTurn(left, false);
            this.faceTurn(yellow);
            this.faceTurn(left);

        }

        else {
            // do opposite algorithm
            if (Top[cornerX][cornerY] == left) {
                this.faceTurn(left, false);
                this.faceTurn(yellow, false);
                this.faceTurn(left);
            }

            else {// have to move edge before insertion
                this.faceTurn(yellow);
                this.faceTurn(left, false);
                this.faceTurn(yellow);
                this.faceTurn(left);
                this.faceTurn(yellow, false);
                this.faceTurn(right);
                this.faceTurn(yellow);
                this.faceTurn(right, false);
                this.displayNet();
            }
        }
    }

    private int OLLSwitch1(int[][] yellow) {// returns 0 for cross, 1 for L, 2 for line and 3 for dot

        if (yellow[1][0] == 5 && yellow[1][2] == 5 && yellow[0][1] == 5)
            return 0;

        if (yellow[1][0] == 5 && yellow[1][2] == 5)
            return 1;

        if (yellow[1][0] == 5 && yellow[0][1] == 5)
            return 2;

        if (yellow[1][0] != 5 && yellow[1][2] != 5 && yellow[0][1] != 5)// cant have just 1 right edge - no need to
                                                                        // check
            return 3;

        return 4;
    }

    private int OLLSwitch2(int[][] check) {// 0 for complete, 8 if none and then it will rotate and check again

        int corners = OLLcornerCount(check);

        if (corners == 4)
            return 0;

        if (corners == 2) {

            if (check[4][1] == 5 && check[4][3] == 5)
                return 1;

            if (check[0][1] == 5 && check[4][1] == 5)
                return 2;

            if (check[3][0] == 5 && check[0][3] == 5)
                return 3;
        }

        if (corners == 1) {

            if (check[0][1] == 5 && check[1][4] == 5 && check[4][3] == 5)
                return 4;

            if (check[4][1] == 5 && check[0][3] == 5 && check[3][4] == 5)
                return 5;
        }

        if (corners == 0) {

            if (check[3][0] == 5 && check[1][0] == 5 && check[0][3] == 5 && check[4][3] == 5)
                return 6;

            if (check[0][1] == 5 && check[0][3] == 5 && check[4][1] == 5 && check[4][3] == 5)
                return 7;
        }

        return 8;
    }

    public static int OLLcornerCount(int[][] check) {// counts number of correct corners in OLL
        int corners = 0;

        if (check[1][1] == 5)
            corners++;

        if (check[1][3] == 5)
            corners++;

        if (check[3][1] == 5)
            corners++;

        if (check[3][3] == 5)
            corners++;

        return corners;
    }

    private int PLLCheck(int[][] face) { // returns 0 for [000], 1 for [101] and 2 for [111] (1s being same and 0s being
                                         // different)
        if (face[2][0] == face[2][2]) {
            if (face[2][0] == face[2][1])
                return 2;
            else
                return 1;
        }
        return 0;
    }

    public void PLLAlg1(int back) {// change to private after test
        int side = PLLsideNumberChange(back, true);
        int front = PLLsideNumberChange(side, true);

        System.out.println("Starting final stage - alg 1:");
        this.faceTurn(side, false);
        this.faceTurn(front);
        this.faceTurn(side, false);
        this.faceTurn(back, true, true);
        this.faceTurn(side);
        this.faceTurn(front, false);
        this.faceTurn(side, false);
        this.faceTurn(back, true, true);
        this.faceTurn(side, true, true);

        // this.displayNet();
    }

    private void PLLAlg2(int back, boolean direction /* true is CW, false is CCW */) {
        int rSide = PLLsideNumberChange(back, true);
        int front = PLLsideNumberChange(rSide, true);
        int lSide = PLLsideNumberChange(back, false);

        System.out.println("Starting final stage - alg 2:");
        this.faceTurn(front, true, true);
        this.faceTurn(5, direction);
        this.faceTurn(rSide, false);
        this.faceTurn(lSide, true);
        this.faceTurn(front, true, true);
        this.faceTurn(rSide, true);
        this.faceTurn(lSide, false);
        this.faceTurn(5, direction);
        this.faceTurn(front, true, true);

        // this.displayNet();

    }

    private boolean PLLGetDir(int complete, ArrayList<int[][]> faces) {
        int[][] front, lSide;

        if (complete == 0) {
            front = faces.get(3);
            lSide = faces.get(2);
        }

        else if (complete == 1) {
            front = faces.get(2);
            lSide = faces.get(0);
        }

        else if (complete == 2) {
            front = faces.get(1);
            lSide = faces.get(3);
        }

        else if (complete == 3) {
            front = faces.get(0);
            lSide = faces.get(1);
        }

        else { // never used
            front = faces.get(0);
            lSide = faces.get(0);
        }

        if (front[2][1] == lSide[2][2])
            return true;

        else
            return false;
    }

    private int PLLsideNumberChange(int face, boolean direction) {

        if (direction == true) {

            switch (face) {

            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 3;
            }
        }

        switch (face) {
        case 1:
            return 3;
        case 2:
            return 1;
        case 3:
            return 4;
        case 4:
            return 2;
        default:
            return -1;
        }
    }

    private void addTurn(int center, boolean direction) {

        switch (center) {
        case 0:
            solveInstructions[this.state] += 'W';
            break;
        case 1:
            solveInstructions[this.state] += 'R';
            break;
        case 2:
            solveInstructions[this.state] += 'B';
            break;
        case 3:
            solveInstructions[this.state] += 'G';
            break;
        case 4:
            solveInstructions[this.state] += 'O';
            break;
        case 5:
            solveInstructions[this.state] += 'Y';
        }
        solveInstructions[this.state] += direction ? "  " : "` ";
    }

    public static Cube getRandomCube() {

        Cube cube = new Cube();
        cube.setDefault();

        for (int i = 0; i < 20; i++) {
            cube.faceTurn(getRandomNumberInRange(0, 5));
        }

        return cube;
    }

    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }

    public String springTest() {
        return "testing worked";
    }

    public String getAllSolveInstructionsString() {
        return Arrays.toString(this.solveInstructions);
    }

    public String[] getSolveInstructionsArray() {
        return this.solveInstructions;
    }

    private char[] convertToNumeric(char[] string) {
        for (int i = 0; i < string.length; i++) {
            switch (string[i]) {
            case 'w':
            case 'W':
                string[i] = '0';
                break;
            case 'r':
            case 'R':
                string[i] = '1';
                break;
            case 'b':
            case 'B':
                string[i] = '2';
                break;
            case 'g':
            case 'G':
                string[i] = '3';
                break;
            case 'o':
            case 'O':
                string[i] = '4';
                break;
            case 'y':
            case 'Y':
                string[i] = '5';
                break;
            default:
                break;
            }

        }
        return string;
    }

    private boolean validateCube() {

        // (8 corners and 12 edges)
        // algorithm should check that each of them exist

        // So if one is flipped - then the error will be caught when it tries to solve

        // have a boolean array (length 20) with all set to false
        // we will hard coded-ly load each piece and pass then call a helper method that
        // checks the pieve and sets the appropriate array index to true
        // -if not a real piece then it should return false and make this method return
        // false
        // - if an index it tries to set is already true - also act like above scenario
        // since its impossible

        boolean[] checks = new boolean[21]; // array position 0 will be set to true if error is found

        return true;
    }

    // lets check all edges first and have them first in the array.
    private boolean[] cubeValidationEdge(boolean[] checks, int one, int two) {

        if (one == 4 && two == 3 || one == 3 && two == 4)// green and orange corner
            setAndCheck(checks, 1);

        else if (one == 3 && two == 1 || one == 1 && two == 3)// red and green corner
            setAndCheck(checks, 2);

        else if (one == 2 && two == 1 || one == 1 && two == 2)// blue red
            setAndCheck(checks, 3);

        else if (one == 2 && two == 4 || one == 4 && two == 2)// orange blue
            setAndCheck(checks, 4);

        else if (one == 0 && two == 4 || one == 4 && two == 0)// orange white
            setAndCheck(checks, 5);

        else if (one == 1 && two == 0 || one == 0 && two == 1)// white red
            setAndCheck(checks, 6);

        else if (one == 1 && two == 5 || one == 5 && two == 1)// red yellow
            setAndCheck(checks, 7);

        else if (one == 5 && two == 4 || one == 4 && two == 5)// yellow orange
            setAndCheck(checks, 8);

        else if (one == 3 && two == 0 || one == 0 && two == 3)// green white
            setAndCheck(checks, 9);

        else if (one == 2 && two == 0 || one == 0 && two == 2)// white blue
            setAndCheck(checks, 10);

        else if (one == 2 && two == 5 || one == 5 && two == 2)// blue yellow
            setAndCheck(checks, 11);

        else if (one == 3 && two == 5 || one == 5 && two == 3)// yellow green
            setAndCheck(checks, 12);

        return checks;
    }

    private boolean[] cubeValidationCorener(boolean[] checks, int one, int two, int three) {

        return checks;
    }

    private boolean[] setAndCheck(boolean[] checks, int i) {
        if (checks[i])
            checks[0] = false;
        else
            checks[i] = true;

        return checks;
    }

    // public static void main(String args[]) {

    // Cube cube = new Cube();

    // // cube.setSide(0,o,w,w,w,w,b,b,y);
    // // cube.setSide(1,r,r,b,r,o,g,o,r);
    // // cube.setSide(2,r,b,b,g,b,y,b,g);
    // // cube.setSide(3,y,g,w,y,w,r,r,o);
    // // cube.setSide(4,o,o,b,o,g,o,r,w);
    // // cube.setSide(5,y,y,g,g,y,g,y,w);

    // cube.setSide(0,5,2,1,2,2,2,0,0);
    // cube.setSide(1,0,1,4,4,5,4,3,2);
    // cube.setSide(2,3,4,2,1,3,5,5,3);
    // cube.setSide(3,2,0,4,4,5,1,4,5);
    // cube.setSide(4,0,1,4,1,3,1,3,0);
    // cube.setSide(5,3,0,1,0,2,3,5,5);

    // // Cube cube = getRandomCube();
    // String str = "52122200 01445432 34213553 20445145 01413130 30102355";
    // Cube cube2= new Cube(str);
    // cube.displayNet();
    // cube2.displayNet();

    // int m = cube2.solveCube();
    // // cube.displayNet();
    // // System.out.println("Solved in " +m +" moves");
    // System.out.println("inst:" +cube2.getAllSolveInstructions());

    // }
}