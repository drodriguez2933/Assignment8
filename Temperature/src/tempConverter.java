import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tempConverter extends JFrame{

	JPanel pane;
	JButton convert;
	JButton reset;
	JLabel fah;
	JLabel cel;
	JTextField f;
	JTextField c;
	boolean ccheck;
	boolean fcheck;
	
	public tempConverter(){
		setSize(450,70);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildPanel();
		add(pane);
		setVisible(true);
		
		convert.addActionListener(new convert());
		reset.addActionListener(new reset());
		
	}
	
	public void buildPanel(){
		
		
		pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 20;
		
		
		fah = new JLabel("Fahrenheit");
		g.gridx++;
		pane.add(fah, g);
		
		f = new JTextField();
		g.gridx++;
		g.ipadx = 75;
		pane.add(f, g);
		
		cel = new JLabel("Celcius");
		g.gridx++;
		g.ipadx = 0;
		pane.add(cel, g);
		
		c = new JTextField();
		g.gridx++;
		g.ipadx = 75;
		pane.add(c, g);
		
		convert = new JButton("Convert");
		g.gridx++;
		g.ipadx = 0;
		pane.add(convert, g);
		
		reset = new JButton("Reset");
		g.gridx++;
		pane.add(reset, g);
		}
	
	public class convert implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			double cel = 0;
			double fah = 0;
			String fahrenheit;
			String celsius;
			
			if(e.getSource() == convert){
				if(checkFahEmpty() == false){
					fahrenheit = f.getText();
					fah = Double.parseDouble(fahrenheit);
					cel = ((fah - 32.0) * 5) / 9;
					celsius = String.valueOf(cel);
					 
					if(celsius.length() > 4){
						String cutCel = celsius.substring(0,5);
						c.setText(cutCel);
					}
					else{
						c.setText(celsius);
					}
					
				}
				else if(checkCelEmpty() == false){
					celsius = c.getText();
					cel = Double.parseDouble(celsius);
					fah = ((9 * cel) / 5)+ 32;
					fahrenheit = String.valueOf(fah);
					
					if(fahrenheit.length() > 4){
						String cutFah = fahrenheit.substring(0, 5);
						f.setText(cutFah);
					}
					else{
						f.setText(fahrenheit);
					}
				}
				else if(checkCelEmpty() == true || checkFahEmpty() == true){
					JOptionPane.showMessageDialog(null, "Error: Both values are empty.");
				}
			}
		}
	}
	
	public class reset implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == reset){
				c.setText("");
				f.setText("");
			}
		}
	}
	
	public boolean checkFahEmpty(){
		 if(f.getText().equals("")){
			 fcheck = true;
		 }
			 else {
		        fcheck = false;
		    }
		 
		 return fcheck;
	}
	
	public boolean checkCelEmpty(){
		if(c.getText().equals("")){
			 ccheck = true;
		 }
		else {
	        ccheck = false;
	    }
		
		return ccheck;
	}
	
	public static void main(String Args[]){
		new tempConverter();
	}
}
