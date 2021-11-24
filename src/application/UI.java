package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UI {

    //Text Colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";

    //Background Colors
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static ChessPosition readChessPosition(Scanner sc) { //Return a chess position according to the row and column typed
        try {
            String s = sc.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));//Cut the string from the position 1 and converts to Integer
            return new ChessPosition(column, row);
        }
        catch (RuntimeException e) {
            throw new InputMismatchException("Error reading chess position. Please insert from a1 to h8.");
        }
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces()); //Print the board and the pieces
        System.out.println();
        printCapturedPieces(captured); //Print captured pieces
        System.out.println("Turn " + chessMatch.getTurn());
        if (!chessMatch.getCheckMate()) { //If the game isn't in checkmate
            System.out.println("Waiting player " + chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) { //If the is in check
                System.out.println("CHECK!");
            }
        } else {
            System.out.println("CHECKMATE!");
            System.out.println("Winner: " + chessMatch.getCurrentPlayer());
        }
    }

    public static void printBoard(ChessPiece[][]pieces) {
        for (int i = 0; i < pieces.length ; i++) {
            System.out.print((8 - i) + " "); //Print the numbers on the left
            for (int j = 0; j < pieces.length ; j++) {
                printPiece(pieces[i][j], false); //print the pieces on the board
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length ; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]); //Print the board informing the possible moves highlighted
            }
            System.out.println();
        }
        System.out.println("  A B C D E F G H");
    }

    public static void printPiece(ChessPiece piece, boolean background) {
        if (background) { //If the background is true, highlight with blue color
            System.out.print(ANSI_CYAN_BACKGROUND);
        }
        if (piece == null) { //If there is no piece, print a -
            System.out.print("-" + ANSI_RESET);
        } else {
            if (piece.getColor() == Color.WHITE) { //If the piece's color is white, print the white color
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    private static void printCapturedPieces(List<ChessPiece> captured) {
        System.out.println("Captured pieces: ");
        System.out.print("White: ");
        System.out.print(ANSI_WHITE);
        //Create a list of chess pieces filtering by color
        System.out.println(Arrays.toString(captured.stream().filter(x -> x.getColor() == Color.WHITE).toArray())); //Print the list of white captured pieces on the board
        System.out.print(ANSI_YELLOW);
        System.out.print("Black: ");
        System.out.println(Arrays.toString(captured.stream().filter(x -> x.getColor() == Color.WHITE).toArray()));
        System.out.print(ANSI_RESET);
    }
}