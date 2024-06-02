package contactBook.gui.com;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GradientPaint;

public class GradientCreatecontact extends JPanel{

		private static final long serialVersionUID = 1L;

		public GradientCreatecontact() {
			setOpaque(true);
			setPreferredSize(new Dimension(200, 625));
			
		}
		@Override
		protected void paintComponent(Graphics grphcs) {
		    super.paintComponent(grphcs);
		    
		    Graphics2D g2D = (Graphics2D) grphcs;
		    g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		    
		    GradientPaint gradient = new GradientPaint(50, 50, Color.decode("#31475"), 20, getHeight(), Color.decode("#26a0da"));
		    g2D.setPaint(gradient);
		    
		    g2D.fillRect(0, 0, getWidth(), getHeight());
			
		}
	}
