import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sound extends JFrame{
	
	
	private JPanel pane;
	private JButton a;
	private JButton done;
	private int count = 0;

	public sound(){
		setSize(200,100);
		
		pane = new JPanel();
		a = new JButton("OK");
		done = new JButton("Done");
		pane.add(a);
		pane.add(done);
		
		add(pane);
		
		a.addActionListener(new clickButton());
		done.addActionListener(new clickButton());
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class clickButton implements ActionListener{

		public void actionPerformed(ActionEvent e){
			if(e.getSource() == a){				
				count++;
				Toolkit.getDefaultToolkit().beep();
			}
			if(e.getSource() == done){
				JOptionPane.showMessageDialog(null, "You pressed the button " + count + " times");
				System.exit(0);
			}
		}

		
	}
	
	public static void main(String Args[]){
		new sound();
	}
	

}
