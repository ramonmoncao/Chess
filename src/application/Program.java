package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		List<ChessPiece> capturedPieces = new ArrayList<>();
		
		ChessMatch chessMatch = new ChessMatch();
		while(!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch,capturedPieces);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves= chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printMatch(chessMatch, possibleMoves, capturedPieces);
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				if(capturedPiece != null) {
					capturedPieces.add(capturedPiece);	
				}
			}
			catch(ChessException error) {
				System.out.println(error.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException error) {
				System.out.println(error.getMessage());
				sc.nextLine();
			}
		}
		
	}

}
