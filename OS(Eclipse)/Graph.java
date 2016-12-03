
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JPanel {
    int[] data;
    final int PAD = 20;

    public Graph(int[] input, int x) {
    	setBackground(new Color(240, 230, 140));
        this.data = new int[x];
        int i = 0;
        while (i < x) {
            this.data[i] = input[i];
            ++i;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = this.getWidth();
        int h = this.getHeight();
        g2.draw(new Line2D.Double(20.0, 20.0, 20.0, h - 20));
        g2.draw(new Line2D.Double(20.0, h - 20, w - 20, h - 20));
        Font font = g2.getFont();
        FontRenderContext frc = g2.getFontRenderContext();
        LineMetrics lm = font.getLineMetrics("0", frc);
        float sh = lm.getAscent() + lm.getDescent();
        String s = "Disk Location";
        float sy = 20.0f + ((float)(h - 40) - (float)s.length() * sh) / 2.0f + lm.getAscent();
        int i = 0;
        while (i < s.length()) {
            String letter = String.valueOf(s.charAt(i));
            float sw = (float)font.getStringBounds(letter, frc).getWidth();
            float sx = (20.0f - sw) / 2.0f;
            g2.drawString(letter, sx, sy);
            sy += sh;
            ++i;
        }
        s = "Seek Time";
        sy = (float)(h - 20) + (20.0f - sh) / 2.0f + lm.getAscent();
        float sw = (float)font.getStringBounds(s, frc).getWidth();
        float sx = ((float)w - sw) / 2.0f;
        g2.drawString(s, sx, sy);
        double xInc = (double)(w - 40) / (double)(this.data.length - 1);
        double scale = (double)(h - 40) / (double)this.getMax();
        g2.setPaint(Color.blue.darker());
        int i2 = 0;
        while (i2 < this.data.length - 1) {
            double x1 = 20.0 + (double)i2 * xInc;
            double y1 = (double)(h - 20) - scale * (double)this.data[i2];
            double x2 = 20.0 + (double)(i2 + 1) * xInc;
            double y2 = (double)(h - 20) - scale * (double)this.data[i2 + 1];
            g2.draw(new Line2D.Double(x1, y1, x2, y2));
            ++i2;
        }
        g2.setPaint(Color.red);
        i2 = 0;
        while (i2 < this.data.length) {
            double x = 20.0 + (double)i2 * xInc;
            double y = (double)(h - 20) - scale * (double)this.data[i2];
            g2.fill(new Ellipse2D.Double(x - 2.0, y - 2.0, 4.0, 4.0));
            ++i2;
        }
    }

    private int getMax() {
        int max = -2147483647;
        int i = 0;
        while (i < this.data.length) {
            if (this.data[i] > max) {
                max = this.data[i];
            }
            ++i;
        }
        return max;
    }

    public static void test(int[] input, int x) {
        JFrame f = new JFrame();
        f.getContentPane().add(new Graph(input, x));
        f.setSize(400, 400);
        f.setLocation(200, 200);
        f.setVisible(true);
    }
}