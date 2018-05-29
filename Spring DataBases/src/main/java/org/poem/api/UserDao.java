package org.poem.api;

import org.poem.entity.User;

public interface UserDao {

    public int count();

    public int countById(String departmentId);


    public User getUserById(int userId);

    public void update(User user);

    public int insertUser(final  User user);
}
