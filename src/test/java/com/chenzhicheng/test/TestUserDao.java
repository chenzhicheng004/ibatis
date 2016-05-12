package com.chenzhicheng.test;

import com.chenzhicheng.ibatis.User;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.junit.*;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/5/12.
 */
public class TestUserDao {

    private SqlMapClient client;

    @BeforeClass
    public static void test1(){
    }

    @Before
    public void test2(){
    }

    @Test
    public void test3(){
    }

    @After
    public void test4(){
    }

    @AfterClass
    public static void test5(){
    }

    public TestUserDao(){
        try {
            Reader reader = Resources.getResourceAsReader("config.xml");
            client = SqlMapClientBuilder.buildSqlMapClient(reader);
            assertNotNull(client);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void selectUserById() throws Exception{
        List list = client.queryForList("user.selectById");
        assertEquals(list.size(),2);
    }

    @Test
    public void selectUserMapById() throws Exception{
        Map<String,User> map = client.queryForMap("user.selectMapById",null,"id");
        assertEquals(map.size(),2);
    }

}
