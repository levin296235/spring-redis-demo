package cn.springmvc.test;

public class TestJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.getConnection();
		/*******************增*********************/
		/*		String sql = "insert into userinfo (username, pswd) values (?, ?), (?, ?), (?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add("小明");
		params.add("123xiaoming");
		params.add("张三");
		params.add("zhangsan");
		params.add("李四");
		params.add("lisi000");
		try {
			boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
			System.out.println(flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/


		/*******************删*********************/
		//删除名字为张三的记录
		/*		String sql = "delete from userinfo where username = ?";
		List<Object> params = new ArrayList<Object>();
		params.add("小明");
		boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);*/

		/*******************改*********************/
		//将名字为李四的密码改了
		/*		String sql = "update userinfo set pswd = ? where username = ? ";
		List<Object> params = new ArrayList<Object>();
		params.add("lisi88888");
		params.add("李四");
		boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
		System.out.println(flag);*/

		/*******************查*********************/
		//不利用反射查询多个记录
		/*		String sql2 = "select * from userinfo ";
		List<Map<String, Object>> list = jdbcUtils.findModeResult(sql2, null);
		System.out.println(list);*/

		//利用反射查询 单条记录
//		String sql = "select * from userinfo where username = ? ";
//		List<Object> params = new ArrayList<Object>();
//		params.add("李四");
//		UserInfo userInfo;
//		try {
//			userInfo = jdbcUtils.findSimpleRefResult(sql, params, UserInfo.class);
//			System.out.print(userInfo);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
