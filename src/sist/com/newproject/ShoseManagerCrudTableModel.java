package sist.com.newproject;

import javax.swing.table.AbstractTableModel;

public class ShoseManagerCrudTableModel extends AbstractTableModel{
	private Object[][]data1;
	private String [] col1= {"번호","신발명","신발사이즈","가격","수량","색상","사진번호"};
	
	
	
	
	public ShoseManagerCrudTableModel() {
		super();
	}
	public ShoseManagerCrudTableModel(Object[][] data1) {
		//super();
		this.data1 = data1;
	}
	public Object[][] getData1() {
		return data1;
	}
	public void setData1(Object[][] data1) {
		this.data1 = data1;
	}
	public String[] getCol1() {
		return col1;
	}
	public void setCol1(String[] col1) {
		this.col1 = col1;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return col1[column];
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		data1[rowIndex][columnIndex]=aValue;
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data1.length;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col1.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data1[rowIndex][columnIndex];
	}
	
	
	
}
