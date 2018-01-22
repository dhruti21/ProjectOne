import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * This class creates a panel displaying a name and a counter which increments from 0 to 9 every second.
 * @author Ruihao Zhou, rzhou21@asu.edu
 * @version 1.0
 * @TimeLine 01.19.2018 - 01.22.2018
 */

public class P131_Zhou_Panel extends JPanel {
	JLabel fullname;
	JLabel number;
	int count = 0;
	Timer t;
	Boolean mark;

	/**
	* Class constructor.
	* Determine the background color depends on the number received in increment or descend order.
	* Run the program.
	*/
	public P131_Zhou_Panel(int n){

		setPreferredSize(new Dimension(100,100));
		setBorder(BorderFactory.createLineBorder(Color.black));
		setBackgroundinfo(n);
		setLayout(null);


		fullname=new JLabel("<html>Ruihao<br>Zhou</html>");
		fullname.setBounds(0, 0, 100, 50);
		number.setBounds(0, 30, 100, 50);
		fullname.setHorizontalAlignment(JLabel.CENTER);
		number.setHorizontalAlignment(JLabel.CENTER);
		fullname.setFont(new Font("Papyrus",Font.PLAIN,15));
		number.setFont(new Font("Papyrus",Font.PLAIN,15));

		add(number);
		add(fullname);

		t = new Timer(1000, new NumberReceive());
		t.start();

	}

        /**
	* Method which create the Panel with your full name and timer.
	*/
	public void setBackgroundinfo(int n) {

		int res = (n % 2);

		try {
			if (res == 0) {
				count = 0;
				number = new JLabel("0");
				setBackground(Color.white);
			} else {
				count = 9;
				number = new JLabel("9");
				setBackground(new Color(173, 216, 230));
				mark = true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

        /**
	* Method which the number sent is odd or even.
	* Then set background color to the specified color and count repeatedly.
	*/

	public class NumberReceive implements ActionListener{
        
		public void actionPerformed(ActionEvent event) {
			try{
				number.setText(String.valueOf(count));
				if(mark == false) {
					if(count != 9) {
						count++;
					}else{
						count = 0;
					}
				}
				else{
					if(count != 0) {
						count--;
					}else{
						count = 9;
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}

		}
	}

        /**
	public static void main(String[] args) {

        P131_Zhou_Panel zhou = new P131_Zhou_Panel(5);
		JFrame frame = new JFrame();
		frame.setSize(100, 100);
		frame.add(zhou);
		frame.setVisible(true);

	}
	
	* Test Myself.
	*/
}












		
