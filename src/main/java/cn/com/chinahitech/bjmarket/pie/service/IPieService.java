package cn.com.chinahitech.bjmarket.pie.service;

import cn.com.chinahitech.bjmarket.pie.entity.Pie;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhufu
 * @since 2023-08-22
 */
public interface IPieService extends IService<Pie> {
    List<Pie> getCityData() ;
}
