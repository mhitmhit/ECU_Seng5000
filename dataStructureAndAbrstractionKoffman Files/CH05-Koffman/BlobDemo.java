package KW.CH05;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static KW.CH05.GridColors.*;

/**
 * Program to illustrate counting cells in a blob
 * 
 * @author Koffman and Wolfgang
 **/
@SuppressWarnings("serial")
public class BlobDemo extends JFrame {

	// data field
	/** a 2-D grid of buttons */
	private TwoDimGrid theGrid;

	/**
	 * Reads data file and defines array bitMap to match data file
	 * 
	 * @param args - Optional input file containing Blob
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
				SwingUtilities.invokeLater(() -> new BlobDemo(aGrid));
			} else {
				// Create array bitMap from a data file
				// Read each data line (a string) into
				// gridArrayList. Each element is a char array.
				List<char[]> gridArrayList = new ArrayList<>();
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
				SwingUtilities.invokeLater(() -> new BlobDemo(aGrid));
			}
		} catch (IOException ex) {
			System.err.println("Exception " + ex);
			ex.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Builds the GUI
	 * 
	 * @param aGrid - The TwoDimGrid that contains the blob
	 */
	private BlobDemo(TwoDimGrid aGrid) {
		theGrid = aGrid;
		getContentPane().add(aGrid, BorderLayout.CENTER);
		JTextArea instruct = new JTextArea(2, 10);
		instruct.setText("Toggle a button to change its color" + "\nPress SOLVE when ready");
		getContentPane().add(instruct, BorderLayout.NORTH);
		JPanel bottomPanel = new JPanel();
		JButton solveButton = new JButton("SOLVE");
		solveButton.addActionListener(e -> solve());
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(e -> (new Blob(theGrid)).restore());
		bottomPanel.add(solveButton);
		bottomPanel.add(resetButton);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * Respond to pressing SOLVE button
	 */
	public final void solve() {
		String reply = JOptionPane.showInputDialog("Enter x coordinate of blob cell");
		int x = Integer.parseInt(reply);
		reply = JOptionPane.showInputDialog("Enter y coordinate of blob cell");
		int y = Integer.parseInt(reply);
		Blob aBlob = new Blob(theGrid);
		JOptionPane.showMessageDialog(null, "For blob at (" + x + "," + y + ") " + "\ncount is "
				+ aBlob.countCells(x, y) + "\nReset blob and try again");
	}
}
