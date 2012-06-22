package org.zephyrsoft.sdb2.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.zephyrsoft.sdb2.model.Song;

/**
 * List entry for a {@link Song}.
 * 
 * @author Mathis Dirksen-Thedens
 */
public class SongCell extends JPanel {
	
	private static final long serialVersionUID = 6861947343987825552L;
	
	private JLabel songTitle;
	private JLabel firstLine;
	
	/**
	 * Constructor.
	 * 
	 * @param leftSpace space to insert left of the second line, in pixels
	 */
	public SongCell(Integer leftSpace) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0};
		gridBagLayout.columnWeights = new double[] {1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		songTitle = new JLabel("<SONG TITLE>");
		songTitle.setBorder(new EmptyBorder(2, 3, 0, 3));
		GridBagConstraints gbc_songTitle = new GridBagConstraints();
		gbc_songTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_songTitle.anchor = GridBagConstraints.NORTH;
		gbc_songTitle.gridx = 0;
		gbc_songTitle.gridy = 0;
		add(songTitle, gbc_songTitle);
		
		firstLine = new JLabel("<FIRST LINE>");
		// set a fixed-size border first so WindowBuilder is content
		firstLine.setBorder(new EmptyBorder(0, 23, 2, 3));
		if (leftSpace != null) {
			firstLine.setBorder(new EmptyBorder(0, leftSpace + 3, 2, 3));
		}
		firstLine.setFont(new Font("SansSerif", Font.ITALIC, 10));
		GridBagConstraints gbc_firstLine = new GridBagConstraints();
		gbc_firstLine.anchor = GridBagConstraints.NORTH;
		gbc_firstLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstLine.gridx = 0;
		gbc_firstLine.gridy = 1;
		add(firstLine, gbc_firstLine);
	}
	
	public void setSongTitle(String text) {
		songTitle.setText(text);
	}
	
	public void setFirstLine(String text) {
		firstLine.setText(text);
	}
	
	@Override
	public void setForeground(Color color) {
		if (songTitle != null && firstLine != null) {
			songTitle.setForeground(color);
			firstLine.setForeground(color);
		}
	}
}