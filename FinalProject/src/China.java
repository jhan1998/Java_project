
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class China extends Main {
	private JPanel topPanel;
    private JTextPane tPane;
    private int total_num = 140006;
    
    public China(int population, int people)
    {		    
    	topPanel = new JPanel();       
        EmptyBorder eb = new EmptyBorder(new Insets(0, 0, 100, 100));
        tPane = new JTextPane();                
        tPane.setBorder(eb);
        tPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        tPane.setMargin(new Insets(0, 0,500, 500));
        tPane.setLayout(null);
        topPanel.setLayout(null);
        topPanel.setBounds(20, 10, 1200, 800);
        tPane.setBounds(480,280,250, 100);
	    topPanel.add(tPane);
        Font f = new Font("Arial Bold",Font.BOLD|Font.ITALIC,12);
        tPane.setFont(f);
        appendToPane(tPane, String.format("China%n%n"  ), Color.RED);
		appendToPane(tPane, String.format("Dead : %3.2f %%",(people/(double)population)*100), Color.RED);
		int index = 255 - (int)(255*(people/(float)population)) <= 0 ? 0 : 255 - (int)(255*(people/(float)population));
		tPane.setBackground(new Color(index, index,index));
		
        tPane.setEditable(false);
        frame.getContentPane().add(topPanel);
        frame.setLayout(null);
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
