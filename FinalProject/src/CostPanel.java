

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class CostPanel extends Main {
		private JPanel topPanel;
	    private JTextPane tPane;	      	
	    public CostPanel(int k, int cost, int v_level  )
	    {		  
	    	topPanel = new JPanel();       
	        EmptyBorder eb = new EmptyBorder(new Insets(0, 0, 100, 100));
	        tPane = new JTextPane();                
	        tPane.setBorder(eb);
	        tPane.setBorder(BorderFactory.createLineBorder(Color.CYAN));
	        tPane.setMargin(new Insets(0, 0,500, 500));
	        tPane.setLayout(null);
	        topPanel.setLayout(null);
	        topPanel.setBounds(000, 0, 1200, 800);
	        if (k<=3) {
	        	tPane.setBounds(-20+230*k,590,100,35);
			}
	        else {
	        	tPane.setBounds(-20+230*(k-3),690,100,35);
			}			
	        topPanel.add(tPane);
	        Font f = new Font("Arial Bold",Font.BOLD|Font.ITALIC,15);
            tPane.setFont(f);
	        appendToPane(tPane, String.format("level= %2d%n",v_level), Color.GRAY);
	        appendToPane(tPane, String.format("cost= %3d%n",cost), Color.GRAY);
	        tPane.setEditable(false);
	        frame.add(topPanel);
	        //frame.pack();
	        frame.setVisible(true);   
	    }
	    

	    private void appendToPane(JTextPane tp, String msg, Color c)
	    {
	        StyleContext sc = StyleContext.getDefaultStyleContext();
	        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);
	        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
	        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
	        int len = tp.getDocument().getLength();
	        tp.setCaretPosition(len);
	        tp.setCharacterAttributes(aset, false);
	        tp.replaceSelection(msg);
	    }

	}
	
		

