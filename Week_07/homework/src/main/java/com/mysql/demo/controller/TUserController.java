package com.mysql.demo.controller;

import com.mysql.demo.annotation.Action;
import com.mysql.demo.aop.Customer;
import com.mysql.demo.entity.TUser;
import com.mysql.demo.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-12-22 13:21:41
 */
@RestController
@RequestMapping("tUser")
public class TUserController {
    /**
     * 服务对象
     */
    @Autowired
    private TUserService tUserService;

    @Autowired
    private Customer customer;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUser selectOne(@RequestParam("id") Long id) {
        return this.tUserService.queryById(id);
    }

    @GetMapping("insert")
    public void insertBatch() {
        Long start = System.currentTimeMillis();
        List<TUser> list = new ArrayList<>();
        for (int i = 0; i< 1000000 ; i++){
            TUser user = new TUser();
            user.setEmail("2780");
            user.setMobile("111");
            user.setNickname("哈哈哈");
            user.setUuid(12121212121221L);
            user.setPassword("121");
            list.add(user);
        }
        tUserService.insertBatch(list);
        System.out.println("插入100w数据，总共用时： "+(System.currentTimeMillis() - start)/1000+"s");
    }

    @GetMapping
    public void testAop(){
        customer.save();
    }
}
