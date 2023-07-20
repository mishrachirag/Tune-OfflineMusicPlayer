/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Src.JTableDeleteIcon;

import Src.JTableDeleteIcon.PanelDelete;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Chirag
 */
public class TableDeletesCellEditor extends DefaultCellEditor{
    private TableDeleteEvent event;
    public TableDeletesCellEditor(TableDeleteEvent event) {
        super(new JCheckBox());
        this.event = event;
    }
    
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelDelete delete = new PanelDelete();
        delete.initevent(event, row);
        delete.setBackground(table.getSelectionBackground());
        return delete;
    }
    
    
}
