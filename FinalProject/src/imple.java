import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//困難度--------------------------------------------------------------------------------------		
public class imple extends Main implements ActionListener {
	public void actionPerformed(ActionEvent e){		
		if(e.getActionCommand().equals("START")){			
			easy.addActionListener(this);
			medium.addActionListener(this);
			hard.addActionListener(this);
			
			JLabel lbimage1 = new JLabel();
			ImageIcon ez = new ImageIcon("./src/難度.jpg");
			ez.setImage(ez.getImage().getScaledInstance(1200,800,800));
			lbimage1.setIcon(ez);
			lbimage1.setLocation(0,0);
			lbimage1.setSize(1200,800);
	        layeredPane.add(lbimage1, JLayeredPane.PALETTE_LAYER);
	        
	        layeredPane.add(easy, JLayeredPane.MODAL_LAYER);
	        layeredPane.add(medium, JLayeredPane.MODAL_LAYER);
	        layeredPane.add(hard, JLayeredPane.MODAL_LAYER);
			//frame.add(easy);
			//frame.add(medium);
			//frame.add(hard);
			
	        //btn.setBackground(Color.RED);
	        //btn.setContentAreaFilled(false);
	        //btn.setOpaque(false);
	        //easy.setBackground(Color.RED);
	        easy.setContentAreaFilled(false);
	        easy.setOpaque(false);
			easy.setLocation(25, 230); 
			easy.setSize(360, 355);
			
	        medium.setContentAreaFilled(false);
	        medium.setOpaque(false);
			medium.setLocation(421, 230); 
			medium.setSize(360, 355);
			
	        hard.setContentAreaFilled(false);
	        hard.setOpaque(false);
			hard.setLocation(817, 230); 
			hard.setSize(360, 355);
			
			btn.hide();
			
		}
		else if(e.getSource()==easy) {
			easy.hide();
			hard.hide();
			medium.hide();
			//lbimage.hide();
			//lb.hide();			
			
			for (int i = 0; i < coeff.length; i++) {
				for (int j = 0; j < coeff[i].length; j++) {
					coeff[i][j] = coeff[i][j]*1.5;
				}
			}
		    new Game();

		}
		else if(e.getSource()==medium) {
			System.out.println("MEDIUM");	
			easy.hide();
			hard.hide();
			medium.hide();
			//lbimage.hide();
			//lb.hide();			

		    new Game();

		}
		else if(e.getSource()==hard) {
			System.out.println("HARD");
			easy.hide();
			hard.hide();
			medium.hide();
			//lbimage.hide();
			//lb.hide();			
			for (int i = 0; i < coeff.length; i++) {
				for (int j = 0; j < coeff[i].length; j++) {
					coeff[i][j] = coeff[i][j]*0.8;
				}
			}

		    new Game();

		}
		
		
		
	}	

	
	
	
	
	
}