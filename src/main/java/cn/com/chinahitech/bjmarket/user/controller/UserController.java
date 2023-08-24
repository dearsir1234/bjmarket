package cn.com.chinahitech.bjmarket.user.controller;


import cn.com.chinahitech.bjmarket.tools.Constants;
import cn.com.chinahitech.bjmarket.user.entity.User;
import cn.com.chinahitech.bjmarket.user.service.IUserService;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    //按照姓氏模糊查询
    @RequestMapping(value = "/queryUsersByName", method = RequestMethod.POST)
    public String queryUsersByName(String uname){
        Map<String,Object> result = new HashMap<String,Object>();
        // 如果查询到结果返回200, 没有检索到结果返回-1；出现异常500
        try{
            List<User> userList = userService.queryUsersByName(uname);
            if(userList!=null && userList.size()>0){ //检索到
                result.put("status", 200);
                result.put("data",userList);
            }else{ //没有检索"到
                result.put("status", -1);
                result.put("errorMsg","没有检索到信息");
            }
        }catch (Exception ex){ //出现异常
            result.put("status", 500);
            result.put("errorMsg","出现异常:"+ex.getMessage());
        }
        return JSON.toJSONString(result);
    }

    //根据用户id查询单个用户
    @RequestMapping(value="/getUserById")
    public String queryUserById(String uid){
        Map<String,Object> result = new HashMap<String,Object>();
        try{
            //1)调用userService的 查询单个对象的方法
            User user = userService.getUserByUserId(uid);
            result.put("status",200);
            result.put("data",user);
        }catch (Exception ex){
           result.put("status",500);
           result.put("errorMsg","出现异常:"+ex.getMessage());
           ex.printStackTrace();
        }
        return JSON.toJSONString(result);
    }


    @RequestMapping(value="/queryUserAtPage",method = RequestMethod.POST)
    public String queryUserAtPage(int page, String uname){
        Map<String,Object> result = new HashMap<String,Object>();
        try{
            //1)调用userService的分页查询方法
            IPage<User> userPage = userService.getUserAtPage(page, Constants.PAGE_SIZE,uname);
            //封装
            result.put("status",200);
            result.put("data",userPage);
        }catch (Exception ex){
            result.put("status",500);
            result.put("errorMsg","分页查询出现异常:"+ex.getMessage());
            ex.printStackTrace();
        }
        return JSON.toJSONString(result);
    }


    //添加用户
    @RequestMapping(value="/addUser",method = RequestMethod.POST)
    public String addUser(String uid,String uname,String phoneNumber){
        Map<String,Object> result = new HashMap<String,Object>();
        try{
            //1)调用UserService的添加用户的方法
            User user = new User();
            user.setUserid(uid);
            user.setName(uname);
            user.setPhoneNumber(phoneNumber);
            int count =userService.addUser(user);
            if(count == 1){
                result.put("status",200);
                result.put("msg","添加用户成功！");
            }else{
                result.put("status",-1);
                result.put("msg","添加用户失败！");
            }
        }catch (Exception ex){
            result.put("status",500);
            result.put("msg","添加用户出现异常:"+ex.getMessage());
        }
        return JSON.toJSONString(result);
    }

    //更新用户
    @RequestMapping(value="/updatePhone",method = RequestMethod.POST)
    public String updatePhone(String uid,String phoneNumber){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            int result=userService.updatePhone(phoneNumber,uid);
            if(result==1) {
                map.put("status", "200");
                map.put("msg", "更新成功");
            }else{
                map.put("status", "201");
                map.put("msg", "更新失败");
            }
        }catch(Exception ex){
            map.put("status","-1");
            map.put("errorMsg",ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    //删除用户
    @RequestMapping(value="/delUser")
    public String delUser(String uid){
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            int result=userService.deleteUser(uid);
            if(result==1) {
                map.put("status", "200");
                map.put("msg", "删除成功");
            }else{
                map.put("status", "201");
                map.put("msg", "删除失败");
            }
        }catch(Exception ex){
            map.put("status","-1");
            map.put("errorMsg",ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

  //  http://localhost:8081/user/delUser
}














