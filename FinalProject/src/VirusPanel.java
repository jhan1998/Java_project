

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class VirusPanel extends Main {
		private JPanel topPanel;
	    private JTextPane tPane;	      	
	    public VirusPanel(int point, double v_air, double v_con, double v_env, double v_fat, double v_resi, double v_var )
	    {		  
	    	topPanel = new JPanel();       
	        EmptyBorder eb = new EmptyBorder(new Insets(0, 0, 100, 100));
	        tPane = new JTextPane();                
	        tPane.setBorder(eb);
	        tPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	        tPane.setMargin(new Insets(0, 0,500, 500));
	        tPane.setLayout(null);
	        topPanel.setLayout(null);
	        topPanel.setBounds(000, 0, 1200, 800);
	        tPane.setBounds(860,10,300,150);
	        topPanel.add(tPane);
	        Font f = new Font("Arial Bold",Font.BOLD|Font.ITALIC,15);
            tPane.setFont(f);
	        appendToPane(tPane, String.format("Virus level ： %n%n  "  ), Color.RED);
	        appendToPane(tPane, String.format("point       = %6d%n  "  , point), Color.GRAY);
	        appendToPane(tPane, String.format("空氣感染        = %6.3f%n  ",v_air ), Color.GRAY);
	        appendToPane(tPane, String.format("接觸傳染        = %6.3f%n  ",v_con ), Color.GRAY);
	        appendToPane(tPane, String.format("環境因子        = %6.3f%n  ",v_env ), Color.GRAY);
	        appendToPane(tPane, String.format("抗藥性           = %6.3f%n  ",v_resi), Color.GRAY);
	        appendToPane(tPane, String.format("致死率           = %6.3f%n  ",v_fat ), Color.GRAY);
	        appendToPane(tPane, String.format("變異率           = %6.3f%n  ",v_var ), Color.GRAY);
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
	
		

