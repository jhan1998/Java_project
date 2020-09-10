import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.*;

import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


public class PopulationDiagram extends Main{
	private JPanel topPanel;
    private JTextPane tPane;	      	   
    public PopulationDiagram(int k,String country, int population0, int population1, int population2, int temp1, int temp2, double v_inf)
    {		    
    	topPanel = new JPanel();       
        EmptyBorder eb = new EmptyBorder(new Insets(0, 0, 100, 100));
        tPane = new JTextPane();                
        tPane.setBorder(eb);
        tPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        tPane.setMargin(new Insets(0, 0,500, 500));
        tPane.setLayout(null);
        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 1200, 800);
        tPane.setBounds(860,200+75*k,300,75);
        topPanel.add(tPane);
        Font f = new Font("Arial Bold",Font.BOLD|Font.ITALIC,12);
        tPane.setFont(f);
        if (k==0) {
			appendToPane(tPane, String.format("Population ： %n%n"  ), Color.RED);
	        tPane.setBounds(860,180+95*k,300,95);
		}
        appendToPane(tPane, String.format("%-8s：  %n" ,country ), Color.BLUE);
        appendToPane(tPane, String.format("Health people         : %8d%n",population0), Color.GRAY);
        appendToPane(tPane, String.format("Infection people      : %8d(+%6d)%n",population1,temp1), Color.GRAY);
        appendToPane(tPane, String.format("Dead people           : %8d(+%6d)%n",population2,temp2), Color.GRAY);
        appendToPane(tPane, String.format("Infection coefficient : %8.3f%n",v_inf), Color.GRAY);
        
        tPane.setEditable(false);
        frame.getContentPane().add(topPanel);
        //pframe.pack();
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


