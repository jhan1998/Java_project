
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Level_bar extends Main{
	private int R = 0, G =0, B = 0;
	private JPanel topPanel;
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(R, G , B));
		g.fillRect(0, 0, 300, 800);
	}
	public void CallBar() {
    	topPanel = new JPanel();       
        topPanel.setLayout(null);
        topPanel.setBounds(000, 0, 1200, 800);
	    frame.getContentPane().add(new Level_bar());
	    frame.setVisible(true);

	}

}
