package sist.com.newproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;

/*import login.JtableModel1;
import login.ZipCodeBean;
import sist.com.jdbc3.EmpBean;
import sist.service.util.ServiceUtil;*/

public class ShoseDao {
	static ShoseLoginModel table;
	static ShoseManagerCrudTableModel table1;
	static Vector<ShoseManagerMemberBean>vector = new Vector<ShoseManagerMemberBean>();
	
	
	
	public static void addShose(ShoseManagerMemberBean sm) {
		vector.addElement(sm);
	}
	
	
	public static String idserch(String id, String password) {
		Connection con = ShoseServiceUtil.con().getconnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			String sql="select id,password from login where id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return id;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}return "";
	}
	
	
	public static boolean idCheck(String id) {
		boolean state=false;
		Connection con = ShoseServiceUtil.con().getconnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			String sql="select id from login where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next())return true;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			}catch(Exception e2) {
				
			}
		}return false;
		
	}
	public static void createShoseMember(ShoseLoginMember slm) {
		String sql="insert into login values(?,?,?,?)";
		PreparedStatement pstmt=null;
		Connection con = ShoseServiceUtil.con().getconnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,slm.getId());
			pstmt.setString(2,slm.getPassword());
			pstmt.setString(3, slm.getAddr());
			pstmt.setString(4, slm.getNickname());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void selectZip(String dong,JTable jtable){
		Connection con=ShoseServiceUtil.con().getconnection();//연결객체
		PreparedStatement pstmt=null;//운반객체
		Object[][]data=null;
		StringBuffer sb=new StringBuffer();
		ResultSet rs=null;
		ResultSetMetaData rsmd;
		String []col;
		sb.append("SELECT SEQ,ZIPCODE,SIDO,GUGUN,DONG,NVL(BUNJI,'')BUNJI ")
		  .append("FROM ZIPCODE ")
		  .append("WHERE DONG LIKE '%' || ? || '%' ");
		try {
			pstmt=con.prepareStatement(sb.toString(),ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, dong);
			rs=pstmt.executeQuery();
			rsmd=rs.getMetaData();
			rs.last();
			data=new Object[rs.getRow()][rsmd.getColumnCount()];
			int i=0;			
			rs.beforeFirst();
			while(rs.next()) {
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					data[i][j]=rs.getString(j+1);
				}
				i++;
			}
			col=new String[rsmd.getColumnCount()];
			for (int j = 0; j < col.length; j++) {
				col[j]=rsmd.getColumnName(j+1);
			}
			table=new ShoseLoginModel(data);
			table.setColname(col);
			jtable.setModel(table);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}
	public static String getSbean(int row) {
		return (String)table.getValueAt(row, 0);
	}
	
	public static ShoseLoginBean selectBean(String sbean) {
		Connection con=ShoseServiceUtil.con().getconnection();//연결객체
		PreparedStatement pstmt=null;//운반객체
		ResultSet rs=null;
		ShoseLoginBean shoseLoginBean=new ShoseLoginBean();
		try {
			String sql="SELECT ZIPCODE,SIDO,GUGUN,DONG,NVL(BUNJI,'')BUNJI FROM ZIPCODE WHERE SEQ=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbean));
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				shoseLoginBean.setZipcode(rs.getString(1));
				shoseLoginBean.setSido(rs.getString(2));
				shoseLoginBean.setGugun(rs.getString(3));
				shoseLoginBean.setDong(rs.getString(4));
				shoseLoginBean.setBunji(rs.getString(5));				
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return shoseLoginBean;
	}
	
	public static void createManagerList(ShoseManagerMemberBean smb) {
		String sql="insert into managerlist values(n_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement pstmt=null;
		Connection con = ShoseServiceUtil.con().getconnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,smb.getShosename());
			pstmt.setString(2,smb.getSize());
			pstmt.setString(3, smb.getprice());
			pstmt.setString(4, smb.getCount());
			pstmt.setString(5,smb.getColor());
			pstmt.setInt(6,Integer.parseInt(smb.getNum()));
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static List<ShoseManagerMemberBean> ShowManagerList(){
		Connection con = ShoseServiceUtil.con().getconnection();
		PreparedStatement pstmt =null;
		ArrayList<ShoseManagerMemberBean>list=new ArrayList<ShoseManagerMemberBean>();
		ResultSet rs = null;
		String sql="select no,manager,shosename,to_char(To_number(price),'99,999,999,999'),count,color,num from managerlist order by manager,num";
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
				while(rs.next()) {
					ShoseManagerMemberBean sbean = new ShoseManagerMemberBean();
					sbean.setNumber(rs.getInt(1));
					sbean.setShosename(rs.getString(2));
					sbean.setSize(rs.getString(3));
					sbean.setprice(rs.getString(4));
					sbean.setCount(rs.getString(5));
					sbean.setColor(rs.getString(6));
					sbean.setNum(""+rs.getInt(7));
					list.add(sbean);
				}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
	public static String showPN(int i,String type) {//공부하기
		Connection con = ShoseServiceUtil.con().getconnection();
		PreparedStatement pstmt =null;
		String sql="SELECT MANAGER,PRICE FROM MANAGERLIST WHERE NUM=? and MANAGER LIKE '%'||?||'%'";
		ResultSet rs=null;
		String sss="";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, i+1);
			pstmt.setString(2, type);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				sss=rs.getString(1)+"#"+rs.getString(2);
			}
			return sss;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		return null;
	}
		public static void updateMember(String s1,String s2,String s3,String s4,String s5,String s6 ,int s7) {
			Connection con = ShoseServiceUtil.con().getconnection();
			PreparedStatement pstmt =null;
			String sql="update managerlist set manager=?,shosename=?,price=?,count=?,color=?,num=? where no = ?";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,s1);
				pstmt.setString(2,s2);
				pstmt.setString(3, s3);
				pstmt.setString(4, s4);
				pstmt.setString(5,s5);
				pstmt.setString(6, s6);
				pstmt.setInt(7,s7);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//--너의 코드를 가져가겠다
	public static void deleteMember(int s1) {
		Connection con = ShoseServiceUtil.con().getconnection();
		PreparedStatement pstmt=null;
		String sql="delete from managerlist where no=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, s1);
			pstmt.executeQuery();
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		try {
			con.rollback();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		}finally {
			try {
				if(con!=null)con.close();
				if(pstmt!=null)pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
