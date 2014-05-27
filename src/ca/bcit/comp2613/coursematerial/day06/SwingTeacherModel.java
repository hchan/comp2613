package ca.bcit.comp2613.coursematerial.day06;

import javax.swing.table.DefaultTableModel;

public class SwingTeacherModel extends DefaultTableModel {
	
	 @Override
	    public boolean isCellEditable(int row, int column) {
	       //all cells false
	       return false;
	    }
	
}
