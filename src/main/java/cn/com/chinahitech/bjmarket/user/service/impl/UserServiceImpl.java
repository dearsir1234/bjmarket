package cn.com.chinahitech.bjmarket.user.service.impl;

import cn.com.chinahitech.bjmarket.user.entity.User;
import cn.com.chinahitech.bjmarket.user.mapper.UserMapper;
import cn.com.chinahitech.bjmarket.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhufu
 * @since 2023-08-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    //按照姓氏模糊查询
    @Override
    public List<User> queryUsersByName(String uname) {
        List<User> userList =null;
        //1) 封装查询条件  QueryWrapper  sql="select * from t_user where name like '吴%' "
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name", uname);
        //2) 执行查询
        userList = userMapper.selectList(wrapper);
        return userList;
    }

    @Override
    public User getUserByUserId(String id) {
        //1)封装查询条件  QueryWrapper
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("userid",id);
        //2)执行查询
        User user = userMapper.selectOne(wrapper);
        return user;
    }


    /**
     * 模糊查询的基础上，实现分页操作
     * @param p  :希望查看的第？页
     * @param size ：每页记录条数
     * @param name ：模糊查询的参数
     * @return
     */
    @Override
    public IPage<User> getUserAtPage(int p, int size, String name) {
        //1)封装模糊查询的条件
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("name",name);
        //2) 封装page参数，执行查询
        Page<User> page = new Page<User>(p,size);
        IPage<User> result =userMapper.selectPage(page,wrapper);

        return result;
    }

    @Override
    public int addUser(User user) {
        int count = userMapper.insert(user);
        return count;
    }

    public int updatePhone(String phoneNumber, String uid) {
        //1)封装条件
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("userid",uid);
        //2)封装新值
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        //3)执行更新并返回
        return userMapper.update(user,wrapper);
    }

    @Override
    public int deleteUser(String userid) {

        return userMapper.deleteById(userid);
    }


}









