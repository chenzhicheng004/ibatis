package com.chenzhicheng.ibatis;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.junit.*;

import java.io.Reader;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/10.
 */

public class UserDao {

    private SqlMapClient client;

    public UserDao(){
        try {
            Reader reader = Resources.getResourceAsReader("config.xml");
            client = SqlMapClientBuilder.buildSqlMapClient(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void test1(){
        System.out.println("test1");
    }

    @Before
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @After
    public void test4(){
        System.out.println("test4");
    }

    @AfterClass
    public static void test5(){
        System.out.println("test5");
    }

    public void selectUserById() throws Exception{
        List list = client.queryForList("user.selectById");
        System.out.println(list);
    }

    public void selectUserMapById() throws Exception{
        Map<String,User> map = client.queryForMap("user.selectMapById",null,"id");
        System.out.println(map);
    }

    public static void main(String[] args) throws Exception{
        UserDao userDao = new UserDao();
        userDao.selectUserById();
        userDao.selectUserMapById();
    }

}
