package com.qf.service;

import com.qf.dao.UserinfoMapper;
import com.qf.pojo.Userinfo;
import org.apache.ibatis.io.ClassLoaderWrapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        InputStream resourceAsStream  =  Resources.getResourceAsStream("mybatis-config.xml");
        //Properties resourceAsProperties = Resources.getResourceAsProperties("mybatis-config.xml");
        //URL resource = Resources.getDefaultClassLoader().getResource("mybatis-config.xml");
       //Reader reader = Resources.getResourceAsReader("resource");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        final SqlSessionFactory factory  = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();

        //int insert = sqlSession.insert("com.qf.dao.UserinfoMapper.insertSelective");


        Userinfo userinfo = new Userinfo();
        userinfo.setName("666");
        userinfo.setAge(66);

        //UserinfoMapper userinfoMapper  = sqlSession.getMapper(UserinfoMapper.class);
        //userinfoMapper.insertSelective(userinfo);
        //sqlSession.commit();
        //sqlSession.close();

        String statement = "com.qf.dao.UserinfoMapper.insert";
        sqlSession.insert(statement,userinfo);
        //4,提交事务
        sqlSession.commit();
        //5,关闭链接
        sqlSession.close();
    }
}
