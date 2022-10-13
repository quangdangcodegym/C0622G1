package com.example.helloc6.dao;

import com.example.helloc6.model.User;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{

    private static final String INSERT_USER = "INSERT INTO `users` (`name`, `email`, `idCountry`) " +
            "VALUES (?, ?, ?)";
    private static final String CHECK_EMAIL_EXISTS = "SELECT * FROM users where email = ?";
    private String jdbcURL = "jdbc:mysql://localhost:3306/c6_customermanager?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "St180729!!";


    private String SELECT_ALL_USERS = "SELECT id, name, email, idcountry FROM users";
    private String SELECT_USER_BYID = "SELECT id, name, email, idcountry FROM users where id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertUser(User user) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, user.getIdCountry());

        preparedStatement.executeUpdate();

    }

    @Override
    public User selectUser(int id) {
        try{
            Connection connection = getConnection();
            PreparedStatement preparableStatement = connection.prepareStatement(SELECT_USER_BYID);
            preparableStatement.setInt(1 , id);

            ResultSet rs = preparableStatement.executeQuery();

            System.out.println(this.getClass() + " selectUser: " + preparableStatement);
            while (rs.next()){
                int idUser = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int idCountry = rs.getInt("idCountry");
                User user = new User(idUser, name, email, idCountry);
                return user;
            }
            //preparableStatement.setString(2, name);
        }catch (SQLException ex){
            printSQLException(ex);
        }
        return null;
    }

    @Override
    public List<User> selectAllUsers() {

        List<User> listUser = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparableStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = preparableStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int idCountry = rs.getInt("idCountry");
                User user = new User(id, name, email, idCountry);
                listUser.add(user);
            }
        }catch (SQLException ex){
            printSQLException(ex);
        }
        return listUser;
    }

    public  List<User> selectAllUsersStatement(){
        List<User> listUser = new ArrayList<>();
        try{
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(SELECT_ALL_USERS);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int idCountry = rs.getInt("id");
                User user = new User(id, name, email, idCountry);
                listUser.add(user);
            }
        }catch (SQLException ex){
            printSQLException(ex);
        }
        return listUser;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean checkEmailExists(String email) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CHECK_EMAIL_EXISTS);
        preparedStatement.setString(1, email);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()){
            return true;
        }
        return false;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
