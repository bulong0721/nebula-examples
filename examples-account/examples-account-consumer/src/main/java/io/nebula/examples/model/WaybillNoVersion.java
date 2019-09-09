package io.nebula.examples.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class WaybillNoVersion implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -8070795621014007943L;

    /**
     * 申请ID
     */
    private Long applyId;
    /**
     * 申请类型
     */
    private Integer applyType;
    /**
     * 申请费用
     */
    private BigDecimal applyFee;
    /**
     * 始发网点联系电话
     */
    private String contactPhone;
    /**
     * 运单编号
     */
    private Long waybillNo;
    /**
     * 操作人
     */
    private String optUserCode;
    /**
     * 操作部门
     */
    private String optDeptCode;
    /**
     * 操作时间
     */
    private Date optTime;
    /**
     * 运单件数提供给库存使用
     */
    private Integer oldQuantity;

    /**
     * 版本号
     */
    private Long recordVersion;
    /**
     * 前一版本号
     */
    private Long oldRecordVersion;
    /**
     * 数据来源类型1-PC(开单),2-PC(订单),3-APP(Andriod),4-APP(IOS)
     */
    private Integer dataSourceType;
    /***
     * 运单类型，纵之横与银河区分
     * 1-正常单,2-整车单,3-外传单,4-内转单,5-退货单,6-签回单,7-专线单
     */
    private Integer waybillType;
    /**
     * 目的网点（老）
     */
    private String oldDestZoneCode;
    /**
     * 目的网点（新）
     */
    private String newDestZoneCode;
    /**
     * 服务类型（改单服务类型提供给到件）
     */
    private Integer serviceType;

    /**
     * 关联单号
     */
    private String relationWaybillNo;

    /**
     * 寄方客户编码
     */
    private String column2;

    /**
     * 收方客户编码
     */
    private String column3;
}
