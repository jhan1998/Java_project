import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class VaccPanel extends Main {
	private JPanel topPanel;
    private JTextPane tPane;
    private JTextPane pPane;	      	   
    private JLayeredPane layeredPane;	      	   

    public VaccPanel(double vacc_progress)
    {	
    	topPanel = new JPanel();       
        EmptyBorder eb = new EmptyBorder(new Insets(0, 0, 100, 100));
        Font f = new Font("Arial Bold",Font.BOLD|Font.ITALIC,12);
        Font ff = new Font("Arial Bold",Font.ITALIC,25);


        tPane = new JTextPane();                
        tPane.setBorder(eb);
        tPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        tPane.setBounds(10,730-((int)(720*vacc_progress)),150,(int)(720*vacc_progress));
        tPane.setMargin(new Insets(0, 0,500, 500));
        tPane.setLayout(null);
        tPane.setFont(f);
        appendToPane(tPane, String.format("%n%n"  ), Color.RED);
		appendToPane(tPane, String.format(" Vaccine : %6.2f %%",vacc_progress*100), Color.RED);
		tPane.setBackground(Color.green);   
        tPane.setEditable(false);
        
        pPane = new JTextPane();                
        pPane.setBorder(eb);
        pPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        pPane.setBounds(10,10,150,(int)(720));
        pPane.setMargin(new Insets(0, 0,20, 20));
        pPane.setLayout(null);
        pPane.setFont(ff);
        appendToPane(pPane, String.format("%n%n"  ), Color.RED);
		appendToPane(pPane, String.format("  Vaccine "), Color.RED);
        pPane.setEditable(false);
        
        topPanel.setLayout(null);
        topPanel.setBounds(0, 0, 1200, 800);
	    //topPanel.add(tPane);
	    //topPanel.add(pPane);	   
        
        layeredPane =new JLayeredPane();
        layeredPane.setBorder(eb);
        layeredPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        layeredPane.setBounds(10,10,150,(int)(720));
        layeredPane.setLayout(null);
        layeredPane.add(pPane, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(tPane, JLayeredPane.MODAL_LAYER);
        topPanel.add(layeredPane);
        
        frame.getContentPane().add(topPanel);
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

