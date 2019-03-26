package com.wumu.fabric;

import com.wumu.fabric.model.User;
import com.wumu.fabric.dao.IUserDao;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Data
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTest {
    @Autowired
    private IUserDao userReopsitory;
    @Test
    public void add(){
        for (int ii=0;ii<10;ii++){
            User user=new User();
            user.setAccount(""+Math.random());
            user.setLocked(false);
            user.setPassword(""+Math.random());
            user.setName(""+Math.random());
            userReopsitory.save(user);
        }

    }
}
