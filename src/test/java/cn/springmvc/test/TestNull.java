package cn.springmvc.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestNull {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Student s = new Student();
		String strBirth="2015/10/12";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		s.setId(11);
		s.setName("刘德华");
		s.setAge(55);
		s.setSex(0);
		s.setBirtday(sdf.parse(strBirth));
		save(s);
	}
	public static void save(Student stu){  
	    String sql="insert into student(id,name,age,sex,birthday) values(sq_student_id.nextval,?,?,?,?)";  
	    Object []params={stu.getName(),stu.getAge(),stu.getSex(),stu.getBirtday()};  
	    DBUtil dbUtil=new DBUtil();  
	    try {  
	        dbUtil.executeUpdate(sql, params);  
	    } catch (SQLException e) {  
	        e.printStackTrace();  
	    } catch (ClassNotFoundException e) {  
	        e.printStackTrace();  
	    }finally{  
//	        dbUtil.closeAll();  
	    }  
	}

}
