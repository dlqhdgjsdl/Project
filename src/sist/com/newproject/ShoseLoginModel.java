package sist.com.newproject;

import javax.swing.table.AbstractTableModel;

public class ShoseLoginModel extends AbstractTableModel {
	private Object [][] data;
	private String []colname= {""};
	
	
	
	
	
	
	
	public ShoseLoginModel() {
		super();
	}
	public ShoseLoginModel(Object[][] data) {
		super();
		this.data = data;
	}
	public String[] getColname() {
		return colname;
	}
	public void setColname(String[] colname) {
		this.colname = colname;
	}
	public Object[][] getData() {
		return data;
	}
	public void setData(Object[][] data) {
		this.data = data;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colname[column];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		data[rowIndex][columnIndex]=aValue;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colname.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}
	
	
	
}
