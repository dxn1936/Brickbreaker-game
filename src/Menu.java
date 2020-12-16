import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Menu extends JFrame{
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,100,700,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.black);
		
		JLabel lblNewLabel = new JLabel("BrickBreaker Game");
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(154, 89, 378, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setFont(new Font("Segoe Script", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(206, 204, 127, 33);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(355, 212, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel(" -> move Right. <- move Left. P pause. R resume. Q quit.\r\n\r\n");
		lblNewLabel_2.setFont(new Font("Segoe Script", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(65, 390, 552, 67);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Play Easy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				JFrame obj = new JFrame();
				GamePlay g = new GamePlay(username,2,15);
				obj.setBounds(200,100,700,600);
				obj.setTitle("Breakout Ball");
				obj.setResizable(false);
				obj.setVisible(true);
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj.getContentPane().add(g);
			}
		});
		btnNewButton.setFont(new Font("Segoe Script", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(206, 284, 127, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("<Instructions>");
		lblNewLabel_3.setFont(new Font("Segoe Script", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(274, 361, 139, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnPlayExpert = new JButton("Play Expert");
		btnPlayExpert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				JFrame obj = new JFrame();
				GamePlay g = new GamePlay(username,-1,100);
				obj.setBounds(200,100,700,600);
				obj.setTitle("Breakout Ball");
				obj.setResizable(false);
				obj.setVisible(true);
				obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				obj.getContentPane().add(g);
			}
		});
		btnPlayExpert.setFont(new Font("Segoe Script", Font.BOLD, 13));
		btnPlayExpert.setBackground(Color.WHITE);
		btnPlayExpert.setBounds(355, 284, 127, 20);
		contentPane.add(btnPlayExpert);
	}
}
