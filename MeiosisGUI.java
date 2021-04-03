import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MeiosisGUI {
	Diploid cell;
	private boolean cellMade = false; 
	Haploid[] daughterCells; 
	private int numChromatids = 2;
	private int numAllels = 2;
	
	JTextArea leftArea;
	JTextArea midArea;
	JTextArea rightArea;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MeiosisGUI gui = new MeiosisGUI();
		gui.makeDiploids();
	}

	public MeiosisGUI() {
		JFrame frame = new JFrame("Meiosis Simulator");
		frame.setSize(550, 375);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int bWidth = 150;
		int bHeight = 20;
		int buffer = 25;
		JButton d = new JButton("New Diploid");
		JButton h = new JButton("Do Crossover");
		
		d.setBounds(25, 25, bWidth, bHeight);
		d.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// System.out.println("helloworld!");
				makeDiploids();
				makeNewHaploids();
			}

		});
		
		h.setBounds(d.getBounds().width + d.getBounds().x  + buffer + 75 ,
				d.getBounds().y ,
				bWidth ,
				bHeight);
		h.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				makeNewHaploids();
			}
			
		});
		
		leftArea = new JTextArea();
		leftArea.setEditable(false);
		leftArea.setBounds(d.getBounds().x ,
				75,
				bWidth,
				250);
		
		midArea = new JTextArea();
		midArea.setEditable(false);
		midArea.setBounds(
				leftArea.getBounds().x+ bWidth + buffer ,
				75,
				bWidth,
				250);
		
		rightArea = new JTextArea();
		rightArea.setEditable(false);
		rightArea.setBounds(
				midArea.getBounds().x+bWidth + buffer ,
				75,
				bWidth,
				250);

		frame.add(d);
		frame.add(h);
		frame.add(leftArea);
		frame.add(midArea);
		frame.add(rightArea);
		
		//get user SCreen 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int frameY = (int) ((screenSize.getHeight()/2)
				-(frame.getHeight()/2));
		int frameX= (int) ((screenSize.getWidth()/2)
				-(frame.getWidth()/2));
		
		frame.setLocation(frameX, frameY);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	protected void makeDiploids() {
		// TODO Auto-generated method stub
		cell = new Diploid(numChromatids, 5, numAllels);
		cellMade = true; 
		leftArea.setText(cell.toString() );
	}

	private void makeNewHaploids() {
		// TODO Auto-generated method stub
		if (!cellMade){
			makeDiploids();
		}
		 cell.makeHaploids();
		 daughterCells = cell.getHaploids();
		 midArea.setText(daughterCells[0].toString() + "\n" 
				 	+ daughterCells[1].toString());
		 rightArea.setText(daughterCells[2].toString() +"\n"
				 	+ daughterCells[3].toString());
	}

}