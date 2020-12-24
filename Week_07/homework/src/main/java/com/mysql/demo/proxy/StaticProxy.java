package com.mysql.demo.proxy;

/**
 * 静态代理 代理类必须实现被代理对象的接口 或者继承被代理对象
 */
public class StaticProxy implements IUserDao {

    private IUserDao userDao;

    public StaticProxy (IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("开启事务");
        userDao.save();
        System.out.println("提交事务");
    }

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        StaticProxy proxy = new StaticProxy(userDao);
        proxy.save();
    }

}

interface IUserDao{
    public void save();
}

class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
