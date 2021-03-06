package com.fun.client.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ApiModel()
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MemUserInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer pkId;
    @ApiModelProperty("用户名")
    private String loginName;
    @ApiModelProperty("登录密码")
    private String loginPwd;
    @ApiModelProperty("注册时间")
    private Date createTime;
    @ApiModelProperty("手机验证码")
    private String Vcode;
    @ApiModelProperty("用户类型(--10管理员--20代理--30超级会员--40测试会员--50普通会员--60超级代理)")
    private Integer userType;
    @ApiModelProperty("银行卡号")
    private String bankAccount;
    @ApiModelProperty("开户名称")
    private String bankAccountName;
    @ApiModelProperty("银行名称")
    private String bankName;
    @ApiModelProperty("开户行")
    private String bankSubName;
    @ApiModelProperty("上级编号")
    private Long agentId;
    @ApiModelProperty("上级名称")
    private String agentName;
    @ApiModelProperty("代理结构")
    private String agentFullId;
    @ApiModelProperty("代理结构名称")
    private String agentFullName;
    @ApiModelProperty("新人奖励(--0未领取--1已领取)")
    private Integer memberReward;
    @ApiModelProperty("推广标识")
    private String Campaign;
    @ApiModelProperty("账户余额")
    private Double Capital1;
    @ApiModelProperty("可用余额")
    private Double Capital2;
    @ApiModelProperty("冻结余额")
    private Double Capital3;
    @ApiModelProperty("充值金额")
    private Double Capital4;
    @ApiModelProperty("消费金额")
    private Double Capital5;
    @ApiModelProperty("中奖金额")
    private Double Capital6;
    @ApiModelProperty("提现金额")
    private Double Capital7;
    @ApiModelProperty("返水金额")
    private Double Capital8;
    @ApiModelProperty("会员积分")
    private Integer userScore;
    @ApiModelProperty("备注信息")
    private String Remark;
    @ApiModelProperty("权限")
    private String authCodes;
    @ApiModelProperty("收货地址")
    private String receivingAddress;
    @ApiModelProperty("收货人")
    private String receivingName;
    @ApiModelProperty("收货人手机号")
    private String receivingMobile;
    @ApiModelProperty(name = "bankLocked", notes = "锁定银行资料")
    private Integer bankLocked;
    @ApiModelProperty("在线状态1在线0不在线")
    private  Integer OnlineFlag;
    @ApiModelProperty("启用状态")
    private Integer enableFlag;
    @ApiModelProperty("玩家数量")
    private Integer count;
    @ApiModelProperty("返佣比例")
    private Double rebate;
    @ApiModelProperty("奖金组")
    private Double extension;
    @ApiModelProperty(name = "google", notes = "是否谷歌验证0未验证1验证")
    private Integer google;
}
