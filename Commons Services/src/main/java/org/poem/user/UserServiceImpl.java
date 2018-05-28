package org.poem.user;

import org.poem.user.vo.UserVo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /**
     *
     * @param id
     * @return
     */
    @Override
    public UserVo getById(String id) {
        UserVo userVo = new UserVo();
        userVo.setId(id);
        userVo.setName("UserName");
        userVo.setAge(120);
        return userVo;
    }

    /**
     *
     * @param name
     * @param id
     * @return
     */
    @Override
    public UserVo getUserAndName(String name, String id) {
        return new UserVo(name,id);
    }
}
