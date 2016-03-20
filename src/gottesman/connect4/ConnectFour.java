package gottesman.connect4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConnectFour extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Piece[][] board;
	private Piece player;
	private int[] columnCount; // To keep a count of how many pieces are in the column

	private enum Piece {
		RED, BLUE, EMPTY;
	}

	public ConnectFour(int rows, int columns) {

		/*
		 * Instantiate the board with a 2d array of Pieces. instantiate the columnCount array with the amount of rows
		 * that there are on the board and fill each spot in the array with the number of rows
		 */

		board = new Piece[columns][rows];
		columnCount = new int[rows];

		for (int i = 0; i < 6; i++) {
			columnCount[i] = 6;
		}

		player = Piece.RED; // First player will be red

		// Fills the board with empty pieces
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				board[i][j] = Piece.EMPTY;
			}
		}

		addMouseListener(new Mouse()); // Add the mouse listener

	}

	// Method that redraws the board by resetting each spot in the array to be an empty piece

	private void redrawBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Piece.EMPTY;
			}
		}
		// Resets the columnCount array back to original
		for (int i = 0; i < 6; i++) {
			columnCount[i] = 6;
		}
		repaint();
	}

	/*
	 * Method inserts a piece onto the board by using the coordinates of the mouse click, and the coordinates of the
	 * oval pieces on the board. The width and height of each oval is 150, so the columns are separated by a distance of
	 * 150. Therefore, if the mouse click coordinates are between 0 and 150, then the click is in the first column, and
	 * if the mouse click is between 150 and 300, then it is in the second column etc... The if statement checks if the
	 * columnCount for that specific column is greater than 0, in order to see if there is more room in the column for
	 * pieces to be placed. It then places the player enum piece in that slot of the array, and decrements the
	 * columnCount array, so that there is one less slot that can now be filled. The method calls repaint so that the
	 * board repaints itself with the new piece in place. It checks for wins, and then switches the turn of the players.
	 */

	private void insertPiece(int x) {

		if ((x > 0) && (x < 150) && (columnCount[0] >= 0)) {

			board[0][columnCount[0]] = player; // Place the piece in the column
			columnCount[0]--; // Decrement the array
			repaint(); // repaint the board

			if (columnCount[0] < 0) { // Let the user know when the column is full
				JOptionPane.showMessageDialog(this, "No more room in this column!");
			}

			this.checkWin(); // Call the check method

			// player = (player == Piece.RED) ? Piece.BLUE : Piece.RED; // Switch the player
		} else if ((x > 150) && (x < 300) && (columnCount[1] >= 0)) {

			board[1][columnCount[1]] = player;
			columnCount[1]--;
			repaint();
			if (columnCount[1] < 0) {
				JOptionPane.showMessageDialog(this, "No more room in this column!");
			}
			this.checkWin();
			// player = (player == Piece.RED) ? Piece.BLUE : Piece.RED;
		} else if ((x > 450) && (x < 600) && (columnCount[2] >= 0)) {
			board[2][columnCount[2]] = player;
			columnCount[2]--;
			repaint();
			if (columnCount[2] < 0) {
				JOptionPane.showMessageDialog(this, "No more room in this column!");
			}
			this.checkWin();
			// player = (player == Piece.RED) ? Piece.BLUE : Piece.RED;
		} else if ((x > 600) && (x < 750) && (columnCount[3] >= 0)) {
			board[3][columnCount[3]] = player;
			columnCount[3]--;
			repaint();
			if (columnCount[3] < 0) {
				JOptionPane.showMessageDialog(this, "No more room in this column!");
			}
			this.checkWin();
			// player = (player == Piece.RED) ? Piece.BLUE : Piece.RED;
		} else if ((x > 750) && (x < 900) && (columnCount[4] >= 0)) {
			board[4][columnCount[4]] = player;
			columnCount[4]--;
			repaint();
			if (columnCount[4] < 0) {
				JOptionPane.showMessageDialog(this, "No more room in this column!");
			}
			this.checkWin();
			// player = (player == Piece.RED) ? Piece.BLUE : Piece.RED;
		} else if ((x > 950) && (x < 2000) && (columnCount[5] >= 0)) {
			board[5][columnCount[5]] = player;
			columnCount[5]--;
			repaint();
			if (columnCount[5] < 0) {
				JOptionPane.showMessageDialog(this, "No more room in this column!");
			}
			this.checkWin();

		}

		player = (player == Piece.RED) ? Piece.BLUE : Piece.RED;

	}

	public void checkWin() {

		// check for four in a row horizontally
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				if (i < (board.length - 3)) {

					if ((board[i][j] == player) && (board[i + 1][j] == player) && (board[i + 2][j] == player)
							&& (board[i + 3][j] == player)) {

						// Print out the winner based on the player piece color
						String winner = (player == Piece.RED) ? "Red is the Winner!! Awesome Job!!"
								: "Blue is the winner!! awesome job!";

						JOptionPane.showMessageDialog(this, winner);
						this.redrawBoard(); // Redraw the board
					}
				}

				if ((i < board.length) && (j < (board[i].length - 2))) {

					// check for four in a row vertically
					if ((board[i][j] == player) && (board[i][j + 1] == player) && (board[i][j + 2] == player)
							&& (board[i][j + 3] == player)) {

						String winner = (player == Piece.RED) ? "Red is the Winner!! Awesome Job!!"
								: "Blue is the winner!! awesome job!";

						JOptionPane.showMessageDialog(this, winner);
						this.redrawBoard();
					}
				}
				if ((i > 3) && (j > 3)) {
					// check for four in a row diagonally
					if ((board[i][j] == player) && (board[i - 1][j - 1] == player) && (board[i - 2][j - 2] == player)
							&& (board[i - 3][j - 3] == player)) {

						String winner = (player == Piece.RED) ? "Red is the Winner!! Awesome Job!!"
								: "Blue is the winner!! awesome job!";

						JOptionPane.showMessageDialog(this, winner);
						this.redrawBoard();
					}
				}

			}
		}

		for (int i = 0; i < (board.length - 3); i++) {
			for (int j = 6; j > 2; j--) { // check for four in a row diagonally

				if ((board[i][j] == player) && (board[i + 1][j - 1] == player) && (board[i + 2][j - 2] == player)
						&& (board[i + 3][j - 3] == player)) {

					String winner = (player == Piece.RED) ? "Red is the Winner!! Awesome Job!!"
							: "Blue is winner!! awesome job!";

					JOptionPane.showMessageDialog(this, winner);
					this.redrawBoard();
				}
			}
		}

		for (int i = 0; i < columnCount.length; i++) {
			if (columnCount[i] >= 0) {
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Game Tied! No Winner!");
		this.redrawBoard();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		/*
		 * Each time the paint component is called, it loops through the board, and checks the spot in the array to see
		 * what color it is, since if the column was clicked, then that slot in the array will be equal to a specific
		 * color based on which player's turn it is. If there is no piece in that slot, then it sets the color as white.
		 * It then fills the specified oval based on the coordinates of the slot, with the proper color.
		 */

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {

				g.setColor(Color.GREEN);

				g.fillRect(i * 200, j * 200, 200, 200);

				if (board[i][j] == Piece.BLUE) {
					g.setColor(Color.BLUE);

				} else if (board[i][j] == Piece.RED) {
					g.setColor(Color.RED);

				} else {
					g.setColor(Color.WHITE);

				}

				g.fillOval(i * 200, j * 200, 150, 150);

			}
		}

	}

	public class Mouse implements MouseListener {

		// The mouseEvent e calls the getX method which returns the coordinate of the mouse click to an int variable,
		// and then calls the insertPiece method, passing through the X coordinate as an argument.

		@Override
		public void mousePressed(MouseEvent e) {
			int clicked = e.getX();
			insertPiece(clicked);

		}

		// (methods that needs to be implemented from the MouseListener interface)

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

	}

}
