import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Scoreboard extends JFrame{
	
	private JPanel pane;
	private JLabel redlabel;
	private JLabel bluelabel;
	private JLabel redscore;
	private JLabel bluescore;
	private JButton redbutton;
	private JButton bluebutton;
	private JButton resetButton;
	private int redsc = 0;
	private int bluesc = 0;
	String rscore;
	String bscore;
	
	public Scoreboard(){
		setSize(400,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buildPanel();
		
		add(pane);
		
		setVisible(true);
		
	}
	
	public void buildPanel(){
		
		rscore = String.valueOf(redsc);
		bscore = String.valueOf(bluesc);
		
		pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.weighty = 10;
		c.weightx = 10;
		
		redlabel = new JLabel("Red Team");
		redlabel.setForeground(Color.RED);
		c.gridx = 0;
		c.gridy = 0;
		pane.add(redlabel, c);
		
		bluelabel = new JLabel("Blue Team");
		bluelabel.setForeground(Color.BLUE);
		c.gridx = 1;
		c.gridy = 0;
		pane.add(bluelabel, c);
		
		redscore = new JLabel(rscore);
		c.gridx = 0;
		c.gridy = 1;
		pane.add(redscore, c);
		
		bluescore = new JLabel(bscore);
		c.gridx = 1;
		c.gridy = 1;
		pane.add(bluescore, c);
		
		redbutton = new JButton("Red Score!");
		c.gridx = 0;
		c.gridy = 2;
		pane.add(redbutton, c);
		
		bluebutton = new JButton("Blue Score!");
		c.gridx = 1;
		c.gridy = 2;
		pane.add(bluebutton, c);
		
		resetButton = new JButton("Reset Score");
		c.gridx = 0;
		c.gridy = 3;
		c.ipadx = 110;
		c.gridwidth = 2;
		pane.add(resetButton, c);
		
		redbutton.addActionListener(new teamScore());
		bluebutton.addActionListener(new teamScore());
		resetButton.addActionListener(new teamScore());
		
	}
	
	public class teamScore implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			
			if(e.getSource() == redbutton){
				redsc++;
				rscore = String.valueOf(redsc);
				redscore.setText(rscore);
				
			}
			else if(e.getSource() == bluebutton){
				bluesc++;
				bscore = String.valueOf(bluesc);
				bluescore.setText(bscore);
				
				
			}
			else if(e.getSource() == resetButton){
				
				
				redsc = 0;
				bluesc = 0;
				bscore = String.valueOf(bluesc);
				rscore = String.valueOf(redsc);
				redscore.setText(rscore);
				bluescore.setText(bscore);
				
			}
			
		}
	}
	
	public static void main(String Args[]){
		new Scoreboard();
	}

}
