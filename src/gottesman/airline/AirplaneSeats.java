package gottesman.airline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * This class is part of an Airline Reservation system. It holds seats that are
 * reserved. You are allowed to add your own member variables and private
 * methods.
 */

public class AirplaneSeats {

	// Professor Schwimmer- I know this is not an excuse at all, but I just
	// wanted to explain myself a little.
	// I'm extremely not feeling well tonight, and I did not know if I was going
	// to even make it to class...I came to attempt the
	// test instead of staying in bed and recuperating, but I was totally unable
	// to concentrate at all. My mind went blank
	// and it was impossible for me to fill out most of the methods. I got stuck
	// in the beginning and was therefore unable to
	// even get to the rest. I understand all the material (although it may not
	// seem like it from this test) but i was
	// simply unable to figure out the logic since I felt very faint the whole
	// time.
	// I know that this is not an excuse and that I wont be able to get very
	// much credit,
	// but I just wanted to explain the situation. I'm sorry.

	private int[][] seats;
	final int row;
	final int column;
	HashMap<Character, Integer> seatsMap;
	HashMap<HashMap<Character, Integer>, Boolean> seatFull;
	ArrayList<String> seatList;
	boolean[] fillSeat;

	private char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	/**
	 * @param rows
	 *            the number of rows of seats on the plane.
	 * @param columns
	 *            the number of columns of seats on the plane.
	 */
	public AirplaneSeats(int rows, int columns) {
		// todo

		int seatCount = 0;

		this.row = 26;
		this.column = 4;

		seats = new int[rows][columns];

		seatList = new ArrayList<String>();

		seatFull = new HashMap<HashMap<Character, Integer>, Boolean>(); // to
																		// fill
																		// the
																		// seat

		for (int i = 0; i < rows; i++) {
			if (fillSeat[i] == false) {
				seatCount++;
			}
		}

		// for (int i = 0; i < row; i++) {
		// for (int j = 0; j < column; j++) {
		// seats[i][j] = alpha[i];
		// }
		// }

		seatsMap = new HashMap<Character, Integer>();

		int j = 1;
		for (int i = 0; i < alpha.length; i++) {
			seatsMap.put(alpha[i], j);
			j++;
		}

	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @throws AlreadyReservedException
	 *             if the seat has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if the seat is outside the columns and rows set in the
	 *             constructor
	 */

	public void reserve(String seatName) throws AlreadyReservedException, SeatOutOfBoundsException {

		char letter = seatName.charAt(0);
		char number = seatName.charAt(1);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if ((seats[i][j] == letter) && (seats[i][j] == number)) {

				}
			}
		}

		for (Entry<Character, Integer> entry : seatsMap.entrySet()) {

			if (entry.getKey().equals(letter) && entry.getValue().equals(number)) {

				seatFull.put(seatsMap, true);

			}
		}
	}

	/**
	 * @param seatName
	 *            is a String in the form of "A1" where "A" is the column and 1
	 *            is the row. The first row on the plane is 1.
	 * @return true if the seat has been reserved, otherwise false.
	 */
	public boolean isReserved(String seatName) {
		return false;
	}

	/**
	 * Reserve all seats in the array of seatNames. This is provided her for
	 * convenience of testing. Do not modify this method.
	 * 
	 * @param seatNames
	 *            is an array of seatNames
	 * @throws AlreadyReservedException
	 *             if one of the seats has already been reserved
	 * @throws SeatOutOfBoundsException
	 *             if one of the seats is outside the columns and rows set in
	 *             the constructor
	 */
	public void reserveAll(String... seatNames) throws AlreadyReservedException, SeatOutOfBoundsException {
		for (String seatName : seatNames) {
			reserve(seatName);
		}
	}

	/**
	 * This method is worth 10 points.
	 * 
	 * @return a String representation of reserved and empty seats on the plane
	 *         in the form of.
	 * 
	 *         ABCD 1 #oo#\n 2 #ooo\n 3 ###o\n 4 ##oo\n 5 #ooo\n
	 * 
	 *         Where o is an empty seat and # is a reserved seat.
	 * 
	 */
	@Override
	public String toString() {
		return null;
	}

	/**
	 * This method is worth 10 points Reserve a group of seats in the same row.
	 * For instance, on a 3,4 airplane whose "A1" is occupied, calling
	 * reserveGroup(4) should return a list of elements ["A2", "B2", "C2", "D2"]
	 * 
	 * @param numberOfSeatsTogether
	 *            the number of seats to look for that are together
	 * @return an ArrayList of seatNames of the seats that have been reserved.
	 * @throws NotEnoughSeatsException
	 *             if there are not enough seats together to reserve.
	 */
	public ArrayList<String> reserveGroup(int numberOfSeatsTogether) throws NotEnoughSeatsException {

		return null;
	}

	/**
	 * @return true if the plane is full, otherwise false.
	 */
	public boolean isPlaneFull() {

		return false;
	}

}
