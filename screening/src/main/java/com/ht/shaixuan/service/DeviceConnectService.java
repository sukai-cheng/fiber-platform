package com.ht.shaixuan.service;

import HslCommunication.Profinet.Siemens.SiemensS7Net;
import com.github.s7connector.api.S7Connector;

/**
 * 连接设备
 * @author chengsukai
 */
public interface DeviceConnectService {
    SiemensS7Net getSiemensS7Net(String ip, int port);
    SiemensS7Net getLongSiemensS7Net(String ip, int port);
    S7Connector getConnection(String ip, int port);


}
