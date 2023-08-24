package cn.com.chinahitech.bjmarket.user.service;

import cn.com.chinahitech.bjmarket.user.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhufu
 * @since 2023-08-21
 */
public interface IUserService extends IService<User> {
   //根据姓氏进行用户列表的模糊查询
    List<User> queryUsersByName(String name);
    //根据用户id，查询用户详情
    User getUserByUserId(String userid);
   //模糊查询基础上，进行分页操作
   public IPage<User> getUserAtPage(int p, int size, String name);
   //添加用户
    int addUser(User user);
    //更新某人电话
    int updatePhone(String phoneNumber,String uid);
    //删除某用户
    int deleteUser(String userid);
}









