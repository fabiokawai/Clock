import javax.swing.JFrame;

public class Main
{
	
	public static void main(String[] args)
	{
		Painel p = new Painel();
		JFrame frame = new JFrame("Clock");
		frame.add(p);
		frame.setSize(350, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
