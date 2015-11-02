import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Temperature extends JFrame{
	
	JPanel pane;
	JLabel label1;
	JTextField tf1;
	JTextField tf2;
	JRadioButton cel;
	JRadioButton fah;
	ButtonGroup rbg;
	
	
	public Temperature(){
		setSize(1000,1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		pane = new JPanel(new GridBagLayout());
		GridBagConstraints e = new GridBagConstraints();
		
		e.gridx = 0;
		e.gridy = 0;
		e.insets = new Insets(0,10,0,10);
		
		label1 = new JLabel("Enter a value in Celsius or Fahrenheit");
		pane.add(label1,e);
		e.gridx++;
		
		tf1 = new JTextField("0");
		e.ipadx = 50;
		pane.add(tf1,e);
		
		fah = new JRadioButton("Convert to Fahrenheit");
		e.ipadx = 0;
		e.gridx++;
		pane.add(fah);
		
		cel = new JRadioButton("Convert to Celsius");
		e.gridx++;
		pane.add(cel);
		
		tf2 = new JTextField();
		tf2.setEditable(false);
		tf2.setBackground(Color.WHITE);
		e.ipadx = 50;
		e.gridx++;
		pane.add(tf2,e);
		
		rbg = new ButtonGroup();
		rbg.add(fah);
		rbg.add(cel);
		
		add(pane);
		
		fah.addActionListener(new buttonClicked());
		cel.addActionListener(new buttonClicked());
		
		pack();
			
	}
	
	public class buttonClicked implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			String stringCel;
			String stringFah;
			String subCel;
			String subFah;
			double celsius;
			double fahrenheit;
			
			if(e.getSource() == cel){
				stringFah = tf1.getText();
				fahrenheit = Double.parseDouble(stringFah);
				celsius = ((fahrenheit - 32.0) * 5) / 9;
				stringCel = String.valueOf(celsius);
				
				if(stringCel.length() > 4){
					subCel = stringCel.substring(0,4);
					tf2.setText(subCel);
				}
				else {
					tf2.setText(stringCel);
				}
				
			}
			else if(e.getSource() == fah){
				stringCel = tf1.getText();
				celsius = Double.parseDouble(stringCel);
				fahrenheit = ((9 * celsius) / 5)+ 32;
				stringFah = String.valueOf(fahrenheit);
				
				if(stringFah.length() > 4){
					subFah = stringFah.substring(0,4);
					tf2.setText(subFah);
				}
				else{
					tf2.setText(stringFah);
				}
			}
			
		}
	}
	
	public static void main(String Args[]){
		new Temperature();
	}

}
