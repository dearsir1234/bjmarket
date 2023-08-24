package cn.com.chinahitech.bjmarket.pie.service.impl;

import cn.com.chinahitech.bjmarket.pie.entity.Pie;
import cn.com.chinahitech.bjmarket.pie.mapper.PieMapper;
import cn.com.chinahitech.bjmarket.pie.service.IPieService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @since 2023-08-22
 */
@Service
public class PieServiceImpl extends ServiceImpl<PieMapper, Pie> implements IPieService {
    @Autowired
    private PieMapper pieMapper;
    @Override
    public List<Pie> getCityData() {
        List<Pie> pieList= pieMapper.selectList(new QueryWrapper<Pie>());
        return pieList;
    }
}
