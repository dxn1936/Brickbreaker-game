import javax.swing.JFrame;
import javax.swing.JPanel;
public class MainApp {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Visuals v = new Visuals();
		obj.setBounds(200,100,700,600);
		obj.setTitle("Breakout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(v);

	}

}
