package task_two;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TicTacToe {

    private static final int EMPTY = 0;
    private static final int CROSS = 1;
    private static final int NOUGHT = 2;
    private static final int RESERVED = 3;

    private static final char[] SYMBOLS = {'•', 'X', 'O', ' '};

    public static void main(String[] args) {
        int[][] board = new int[3][3];
        board[0][0] = CROSS;
        board[1][1] = NOUGHT;
        board[2][2] = CROSS;
        saveBoard(board, "/home/marat/IdeaProjects/JavaCoreSeminar5/src/main/resources/board.txt");
        int[][] loadedBoard = loadBoard("/home/marat/IdeaProjects/JavaCoreSeminar5/src/main/resources/board.txt");
        printBoard(loadedBoard);
    }

    public static void saveBoard(int[][] board, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    writer.write(Integer.toString(board[i][j]));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving board: " + e.getMessage());
        }
    }

    public static int[][] loadBoard(String fileName) {
        int[][] board = new int[3][3];
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null && i < board.length) {
                for (int j = 0; j < line.length() && j < board[i].length; j++) {
                    board[i][j] = Character.getNumericValue(line.charAt(j));
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println("Error loading board: " + e.getMessage());
        }
        return board;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(SYMBOLS[board[i][j]]);
            }
            System.out.println();
        }
    }
}