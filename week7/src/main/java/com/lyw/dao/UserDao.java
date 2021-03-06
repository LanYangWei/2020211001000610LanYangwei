package com.lyw.dao;

import com.lyw.model.User;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.Date;
import java.util.List;


@WebServlet(name = "LoginServlet", value = "/login")
public class UserDao implements IUserDao {


    public boolean saveUser(Connection con, User user) throws SQLException {

        return false;
    }


    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from usertable lywere id=?";
        PreparedStatement st=con.prepareStatement(sql);
//        st.setString(1,user.getId());
        int rs=st.executeUpdate();
        return rs;
    }


    public int updateUser(Connection con, User user) throws SQLException {

        return 0;
    }


    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }


    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException{
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/waijiao";
        String name = "root";
        String word = "123";
        con = DriverManager.getConnection(url,name,word);
        String sql="select id,username,password,email,gender,birthdate from usertable lywere username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=st.executeQuery();

        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("Id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }


    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }


    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }


    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }


    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }


    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }


    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
