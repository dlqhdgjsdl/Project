package sist.com.bullet;

import javax.swing.table.AbstractTableModel;

public class BulletCrudTable extends AbstractTableModel{
	private Object[][]data;
	private String []col= {"순위","플레이어","버틴 시간"};
	
	
	
	
	
	

	public BulletCrudTable() {
		super();
		
	}

	public BulletCrudTable(Object[][] data) {
		super();
		this.data = data;
		
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	public String[] getCol() {
		return col;
	}

	public void setCol(String[] col) {
		this.col = col;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return col[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return data[rowIndex][columnIndex];
	}

	
}
