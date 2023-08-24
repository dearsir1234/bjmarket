package cn.com.chinahitech.bjmarket.pie.controller;




import cn.com.chinahitech.bjmarket.pie.entity.Pie;
import cn.com.chinahitech.bjmarket.pie.service.IPieService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhufu
 * @since 2023-08-22
 */


    @Controller
    @CrossOrigin
    @RequestMapping("/pie")
    public class PieController {
        @Autowired
        private IPieService pieService;
        @RequestMapping(value="/cityData",method = RequestMethod.GET)
        @ResponseBody
        public String getCityData(){
            Map<String,Object> map = new HashMap<String,Object>();
            try{
                List<Pie> pieList =pieService.getCityData();
                map.put("status","200");
                map.put("data",pieList);
            }catch(Exception ex){
                map.put("status","-1");
                map.put("data",ex.getMessage());
            }
            return JSON.toJSONString(map);
        }
    }

