package KW.CH05;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static KW.CH05.GridColors.*;

/**
 * A class to test Maze.java.
 * 
 * @author Koffman and Wolfgang
 */
@SuppressWarnings("serial")
public class MazeDemo extends JFrame {

	// data field
	private TwoDimGrid theGrid; // a 2-D grid of buttons

	/**
	 * Reads data file and defines array bitMap to match data file
	 * 
	 * @param args Command line arguments. args[0] if present contains the name of
	 *             the input file that describes the maze.
	 */
	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				// no file name given
				String reply = JOptionPane.showInputDialog("Enter number of rows");
				int nRows = Integer.parseInt(reply);
				reply = JOptionPane.showInputDialog("Enter number of columns");
				int nCols = Integer.parseInt(reply);
				TwoDimGrid aGrid = new TwoDimGrid(nRows, nCols);
				SwingUtilities.invokeLater(() -> new MazeDemo(aGrid));
			} else {
				// Create array bitMap from a data file
				// Read each data line (a string) into
				// gridArrayList. Each element is a char array.
				ArrayList<char[]> gridArrayList = new ArrayList<>();
				try (var br = new BufferedReader(new FileReader(args[0]))) {
					String line;
					while ((line = br.readLine()) != null) {
						char[] row = line.toCharArray();
						gridArrayList.add(row);
					}
				}

				// bitMap is a 2-D array based on data in gridArrayList
				char[][] bitMap = gridArrayList.toArray(new char[gridArrayList.size()][]);
				int nRows = bitMap.length;
				int nCols = bitMap[0].length;

				// create a new TwoDimGrid and recolor it based on bitMap
				TwoDimGrid aGrid = new TwoDimGrid(nRows, nCols);
				aGrid.recolor(bitMap, NON_BACKGROUND);
				SwingUtilities.invokeLater(() -> new MazeDemo(aGrid));
			}
		} catch (IOException ex) {
			System.err.println("Exception " + ex);
			ex.printStackTrace();
			System.exit(1);
		}
	}

	// Builds the GUI
	private MazeDemo(TwoDimGrid aGrid) {
		theGrid = aGrid;
		getContentPane().add(aGrid, BorderLayout.CENTER);
		JTextArea instruct = new JTextArea(2, 20);
		instruct.setText("Toggle a button to change its color" + "\nPress SOLVE when ready");
		getContentPane().add(instruct, BorderLayout.NORTH);
		JButton solveButton = new JButton("SOLVE");
		solveButton.addActionListener(e -> solve());
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(e -> (new Maze(theGrid)).restore());
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(solveButton);
		bottomPanel.add(resetButton);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public final void solve() {
		Maze m = new Maze(theGrid);
		boolean found = m.findMazePath();
		if (found) {
			JOptionPane.showMessageDialog(null, "Success - reset maze and try again");
		} else {
			JOptionPane.showMessageDialog(null, "No path - reset maze and try again");
		}
	}
}
