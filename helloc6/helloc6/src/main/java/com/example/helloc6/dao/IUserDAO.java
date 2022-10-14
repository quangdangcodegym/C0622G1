package com.example.helloc6.dao;

import com.example.helloc6.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public boolean updateUserWithSP(User user) throws SQLException;

    public boolean checkEmailExists(String email) throws SQLException;
}
