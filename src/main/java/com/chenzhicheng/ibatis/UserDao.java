package com.chenzhicheng.ibatis;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import java.io.Reader;
import java.util.List;

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

    public void selectUserById() throws Exception{
        List list = client.queryForList("user.selectById");
        System.out.println(list);
    }

    public static void main(String[] args) throws Exception{
        UserDao userDao = new UserDao();
        userDao.selectUserById();
    }

}
