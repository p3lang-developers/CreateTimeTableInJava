/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practise;

import java.awt.Component;
import java.util.EventObject;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.*;

/**
 *
 * @author Abhishek
 */
public class editingtable implements TableCellEditor{
    public static void main(String srga[])
    {
    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    JTable table=new JTable();
    JComboBox jcb=new JComboBox();
    frame.setVisible(true);
    panel.add(table);
    frame.add(panel);
    
}

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getCellEditorValue() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean stopCellEditing() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void cancelCellEditing() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}