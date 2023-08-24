package cn.com.chinahitech.bjmarket.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhufu
 * @since 2023-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId
    private String userid;

    private String name;

    @TableField("openId")
    private String openId;

    private String accid;

    private String token;

    private String weixinname;

    private String weixinid;

    private String weixinpic;

    @TableField("phoneNumber")
    private String phoneNumber;

    private LocalDateTime registdate;

    private LocalDateTime updatedate;

    @TableField("QRcodepath")
    private String QRcodepath;

    private Integer parentid;

    private Integer userlevel;

    private Integer teamnum;

    private Integer straightpush;

    private Integer userclient;

    private String other1;

    private String other2;


}
