package com.qinzhu;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.qinzhu.soundsystem.CDPlayerConfig;
import com.qinzhu.soundsystem.CompactDisc;

@RunWith(SpringJUnit4ClassRunner.class)/* 使用SpringJUnit4ClassRunner，以便在测试的时候自动创建Spring的上下文 相当于实例化Context对象*/
@ContextConfiguration(classes= CDPlayerConfig.class)/* 该注解告诉应用需要在此类中加载配置。相当于固定的读取xml配置文件中的配置*/
public class CDPlayerTest {

    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void cdShoudBeNotNull(){
        Assert.assertNotNull(compactDisc);
    }

}
