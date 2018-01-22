import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GuessMyColor extends JFrame{
	private JPanel targetPanel = new JPanel();
	private JPanel myColorPanel = new JPanel();
	
	private int targetRed = 0;
	private int targetGreen = 0;
	private int targetBlue = 0;
	
	private int red = 0;
	private int green = 0;
	private int blue = 0;

	public GuessMyColor(){ //makes the window
		initGUI();//initialize GUI
		
		setTitle("Guess My Color Game"); //window title at the top
		setSize(200, 100); //pixels
		setResizable(true); //so we can adjust the window. 
		pack(); //condenses it within what's in there; don't really need it. 
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible

		setVisible(true); //make it visible
		setDefaultCloseOperation(EXIT_ON_CLOSE); //what happens when you hit the red x button
	}
	
	public void initGUI(){ //inside the window/frame
		//title panel
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.PAGE_START);
		titlePanel.setBackground(Color.black); //sets background color to yellow
		//title label
		JLabel titleLabel = new JLabel("Guess My Color"); //calls constructor. once you create it, you have to add it 
		titlePanel.add(titleLabel);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		//titlePanel.add(titleLabel, BorderLayout.PAGE_START); //sets it at top
		
		Font titleFont = new Font ("Courier", Font.PLAIN, 18);
		titleLabel.setFont(titleFont);
		titleLabel.setForeground(Color.white);
		
		//center panel
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBackground(Color.white);
		
		//target panel
		
		centerPanel.add(targetPanel);
		generateColor();		
		Dimension size = new Dimension (50, 50);
		targetPanel.setPreferredSize(size);
		targetPanel.setSize(getPreferredSize());
		
		
		//my color panel
		centerPanel.add(myColorPanel);
		myColorPanel.setBackground(new Color(red, green, blue));
		myColorPanel.setPreferredSize(size);
		myColorPanel.setSize(getPreferredSize());
		
		
		
		
		
		//bottom panel
		JPanel bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.PAGE_END);
		bottomPanel.setBackground(Color.black);
		
		
		
		
		
		//buttons
		Font buttonFont = new Font ("Arial", Font.PLAIN, 16);

		
		JButton plusRed = new JButton("+");
		plusRed.setFont(buttonFont);
		plusRed.setBackground(Color.red);
		plusRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this is the only thing that will change between buttons
				//what we want to happen when clicked
				addRed();
			}
		});
		bottomPanel.add(plusRed);
		
		JButton minusRed = new JButton("-");
		minusRed.setFont(buttonFont);
		minusRed.setBackground(Color.red);
		minusRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lessRed();
			}
		});
		bottomPanel.add(minusRed);
		
		JButton plusGreen = new JButton("+");
		plusGreen.setFont(buttonFont);
		plusGreen.setBackground(Color.green);
		plusGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGreen();
			}
		});
		bottomPanel.add(plusGreen);
		
		JButton minusGreen = new JButton("-");
		minusGreen.setFont(buttonFont);
		minusGreen.setBackground(Color.green);
		minusGreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lessGreen();
			}
		});
		bottomPanel.add(minusGreen);
		
		JButton plusBlue = new JButton("+");
		plusBlue.setFont(buttonFont);
		plusBlue.setBackground(Color.blue);
		plusBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBlue();
			}
		});
		bottomPanel.add(plusBlue);
		
		JButton minusBlue = new JButton("-");
		minusBlue.setFont(buttonFont);
		minusBlue.setBackground(Color.blue);
		minusBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lessBlue();
			}
		});
		bottomPanel.add(minusBlue);
		
		JButton newGame = new JButton("New Game");
		newGame.setFont(titleFont);
		newGame.setBackground(Color.white);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateColor();
				resetMyColor();
				//maybe a give up button
			}
		});
		bottomPanel.add(newGame);
		
	}
	
	public void addRed() {
		if (red <= 240) {
			red += 15;
		}
		updateAndCheck();
	}
	public void lessRed() {
		if (red >= 15) {
			red -= 15;
		}
		updateAndCheck();
	}
	
	public void addGreen() {
		if (green <= 240) {
			green += 15;
		}
		updateAndCheck();
	}
	public void lessGreen() {
		if (green >= 15) {
			green -= 15;
		}
		updateAndCheck();
	}
	
	public void addBlue() {
		if (blue <= 240) {
			blue += 15;
		}
		updateAndCheck();
	}
	public void lessBlue() {
		if (blue >= 15) {
			blue -= 15;
		}
		updateAndCheck();
	}
	
	
	public void updateAndCheck() {
		myColorPanel.setBackground(new Color(red, green, blue));
		
		if (red == targetRed && green == targetGreen && blue == targetBlue) {
			JOptionPane.showMessageDialog(null, "You got it right!");
			generateColor();
			resetMyColor();
		}
	}
	
	public void generateColor() {
		targetRed = (int) (Math.random() * 17) * 15;//random number between 0 and 17 and then multiplies that by 15
		targetGreen = (int) (Math.random() * 17) * 15;
		targetBlue = (int) (Math.random() * 17) * 15;
		
		
		Color targetColor = new Color (targetRed, targetGreen, targetBlue);
		targetPanel.setBackground(targetColor);
	}
	
	public void resetMyColor() {
		red = 0;
		blue = 0;
		green = 0;
		myColorPanel.setBackground(new Color(red, green, blue));
		
	}

	
	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new GuessMyColor();
            }   
        });

	}

}
