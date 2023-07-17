package src;
import java.sql.*;


public class SQLutil {

    public static Connection getConn(){
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/C:\\Users\\672\\Desktop\\TEMP\\webDemo\\webDemo.db");

            return connection;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static boolean login(String username,String pwd){
        try {

            Connection connection =getConn();
            Statement statement = connection.createStatement();
            //原始SQL
            String sql = "select count(*) from users where username='"+username+"' and password='"+pwd+"'";
            ResultSet set = statement.executeQuery(sql);
            //SQL预编译
//            String sql = "select count(*) from users where username= ? and password= ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1,username);
//            ps.setString(2,pwd);
//            ResultSet set = ps.executeQuery();
            
            set.next();
            // 有多少条满足条件的数据
            int count = set.getInt(1);
            System.out.println(count);
//            String sql = "create table if not exists hehe(_id integer primary key, username varchar(30),pwd varchar(30))";
//            statement.executeUpdate(sql);
//            String selectSql = "select count(*) from hehe where username='"+username+"' and pwd='"+pwd+"'";
//            ResultSet set = statement.executeQuery(selectSql);
//            set.next();
//            // 有多少条满足条件的数据
//            int count = set.getInt(1);
            if(set!=null){
                set.close();
            }
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
            return count > 0;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//
//        return false;
        return true;
    }


    public  static boolean regist(String username,String pwd){
        try {
            Connection connection =getConn();
            Statement statement = connection.createStatement();
            String sql = "create table if not exists hehe(_id integer primary key, username varchar(30),pwd varchar(30))";
            statement.executeUpdate(sql);
            String selectsql = "select count(*) from hehe where username='"+username+"'";
            ResultSet set = statement.executeQuery(selectsql);
            set.next();
            int count = set.getInt(1);
            if(count>0){
                set.close();
                statement.close();
                connection.close();
                return false;
            }

            // 进行注册的操作
            String insertSql = "insert into hehe(username,pwd) values('"+username+"','"+pwd+"')";
            int count2 = statement.executeUpdate(insertSql);
            if(count2>0){
                statement.close();
                set.close();
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }

}

