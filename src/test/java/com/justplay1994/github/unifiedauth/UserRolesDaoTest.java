package com.justplay1994.github.unifiedauth;

import com.justplay1994.github.unifiedauth.dao.UserRolesDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Package: com.justplay1994.github.unifiedauth
 * @Project: unified-auth
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/11/2 17:43
 * @Updater: huangzezhou
 * @Update_Date: 2018/11/2 17:43
 * @Update_Description: huangzezhou 补充
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UnifiedAuthApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRolesDaoTest {

    @Autowired
    UserRolesDao userRolesDao;

    @Test
    public void insertUserRolesTest(){
        List<String> roles = new ArrayList<String>();
        roles.add("role1");
        roles.add("role2");
        HashMap map = new HashMap();
        map.put("account","admin");
        map.put("roles",roles);
        userRolesDao.insertRolesPerUser(map);
    }

}
