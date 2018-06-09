package org.poem.user;

import org.poem.user.vo.UserVo;

public interface UserService {

    /**
     * 根据ip查询数据
     * @param id
     * @return
     */
    public UserVo getById(String id);

    /**
     *
     * @param name
     * @param id
     * @return
     */
    public UserVo getUserAndName(String name , String id);

    /**
     *
     * @return
     */
    public int count();
}
