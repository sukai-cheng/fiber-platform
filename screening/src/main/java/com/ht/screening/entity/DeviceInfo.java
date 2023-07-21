package com.ht.screening.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 设备表
 * @author chengsukai
 */
@Data
@TableName("device_info")
public class DeviceInfo implements Serializable {

    @TableId(value = "device_id",type = IdType.AUTO)
    private Integer deviceId;

    @TableField("device_ip")
    private String deviceIp;

    @TableField("device_name")
    private String deviceName;

    @TableField("device_port")
    private String devicePort;

    @TableField("computer_ip")
    private String computerIp;
}