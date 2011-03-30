package chatroom.classes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @version $Id: ClosableTabbedPane.java,v 1.6 2006/05/17 23:23:00 nano Exp $
 *
 * @author james todd [gonzo at jxta dot org]
 * @author struman
 */

public class ClosableTabbedPane
    extends JTabbedPane {
    private Color iconColor = Color.gray;
    private List<DismissListener> listeners = null;
    protected class CloseTabIcon
        implements Icon {
        private int x_pos;
        private int y_pos;
        private int width;
        private int height;
        private Icon fileIcon;
        public CloseTabIcon(Icon fileIcon) {
            this.fileIcon = fileIcon;
            if(fileIcon != null) width = 16;
            else width = 0;
            height = 16;
        }
        public void paintIcon(Component c, Graphics g, int x, int y) {
            if(fileIcon != null){
                this.x_pos = x;
                this.y_pos = y;
                Color col = g.getColor();
                g.setColor(iconColor);
                int y_p = y + 2;
                g.drawLine(x + 1, y_p, x + 12, y_p);
                g.drawLine(x + 1, y_p + 13, x + 12, y_p + 13);
                g.drawLine(x, y_p + 1, x, y_p + 12);
                g.drawLine(x + 13, y_p + 1, x + 13, y_p + 12);
                g.drawLine(x + 3, y_p + 3, x + 10, y_p + 10);
                g.drawLine(x + 3, y_p + 4, x + 9, y_p + 10);
                g.drawLine(x + 4, y_p + 3, x + 10, y_p + 9);
                g.drawLine(x + 10, y_p + 3, x + 3, y_p + 10);
                g.drawLine(x + 10, y_p + 4, x + 4, y_p + 10);
                g.drawLine(x + 9, y_p + 3, x + 3, y_p + 9);
                g.setColor(col);
                fileIcon.paintIcon(c, g, x + width, y_p);
            }
        }
        public int getIconWidth() {
            return width + (fileIcon != null ? fileIcon.getIconWidth() : 0);
        }
        public int getIconHeight() {
            return height;
        }
        public Rectangle getBounds() {
            return new Rectangle(x_pos, y_pos, width, height);
        }
    }
    public ClosableTabbedPane(/*int placement, int layout*/) {
        //super(placement, layout);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                process(me.getX(), me.getY());
            }
        });
    }

    @Override
    public void addTab(String title, Component component) {
        this.addTab(title, component, null);
    }
    public void addTab(String title, Component component, Icon icon) {
        addTab(title, new CloseTabIcon(icon), component);
    }
    public void setCloseIconColor(Color color) {
        this.iconColor = color;
    }
    @Override
    public void removeTabAt(int i) {
        //((Dismissable)getComponentAt(i)).dismiss();
        super.removeTabAt(i);
        for (Iterator ls = this.listeners != null ?
            this.listeners.iterator() : Collections.EMPTY_LIST.iterator();
            ls.hasNext(); ) {
            ((DismissListener)ls.next()).dismissEvent();
        }
    }
    public void addListener(DismissListener l) {
        if (l != null) {
            if (this.listeners == null) {
                //this.listeners = new ArrayList<DismissListener>();
            }
            this.listeners.add(l);
        }
    }
    protected void process(int x, int y) {
        requestFocus();
        int tab;
        if ((tab = getUI().tabForCoordinate(this, x, y)) >= 0) {
            if (((CloseTabIcon)getIconAt(tab)).getBounds().contains(x, y)) {
                removeTabAt(tab);
            }
        }
    }
}



