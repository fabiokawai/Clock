import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Painel extends JPanel
{
	private static final long serialVersionUID = 7070456353994751858L;
	private Clock c;
	private int hour;
	private int minute;
	private int seconds;
	private JTextField textField;
	
	public Painel()
	{
		c = new Clock();
		c.start();
		this.hour = c.getHour();
		this.minute = c.getMinute();
		this.seconds = c.getSeconds();
		textField = new JTextField();
		add(textField);
		textField.setColumns(5);
		textField.setEditable(false);
	}
	
	@Override
	public void paint(Graphics g)
	{
		hour = c.getHour();
		minute = c.getMinute();
		seconds = c.getSeconds();
		
		textField.setText(Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(seconds));
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w = (getWidth() / 2);
		int h = (getHeight() / 2);
		
		g2d.translate(w, h);
		
		g2d.rotate(3.14159265359);
		
		g.setColor(Color.black);
		g.fillOval(-106, -106, 212, 212);
		g.setColor(Color.gray);
		g.fillOval(-100, -100, 200, 200);
		
		
		//horas
		g.setColor(Color.black);
		g2d.rotate(2*3.14159265359*hour/12);
		g2d.fillRect(-4, 0, 8, 50);
		g2d.rotate(-2*3.14159265359*hour/12);
		
		//minutos
		g.setColor(Color.black);
		g2d.rotate(2*3.14159265359*minute/60);
		g2d.fillRect(-3, 0, 6, 95);
		g2d.rotate(-2*3.14159265359*minute/60);		
		
		//segundos
		g.setColor(Color.red);
		g2d.rotate(2*3.14159265359*seconds/60);
		g2d.fillRect(-1, 0, 2, 90);
		g2d.rotate(-2*3.14159265359*seconds/60);
		
		g.setColor(Color.white);
		g2d.fillOval(-3, -3, 6, 6);
	
		repaint();
	}
}
