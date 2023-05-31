package com.ht.screening.service.impl;

import HslCommunication.Core.Types.OperateResult;
import HslCommunication.Profinet.Siemens.SiemensPLCS;
import HslCommunication.Profinet.Siemens.SiemensS7Net;
import com.github.s7connector.api.S7Connector;
import com.github.s7connector.api.factory.S7ConnectorFactory;
import com.ht.screening.service.DeviceConnectService;
import org.springframework.stereotype.Service;

/**
 * @author chengsukai
 */
@Service
public class DeviceConnectServiceImpl implements DeviceConnectService {

    @Override
    public SiemensS7Net getSiemensS7Net(String ip, int port) {
        SiemensPLCS s1500 = SiemensPLCS.S1500;
        SiemensS7Net siemensS7Net = new SiemensS7Net(s1500,ip);
        siemensS7Net.setPort(port);
        siemensS7Net.SetPersistentConnection();
        siemensS7Net.setConnectTimeOut(2000);
        OperateResult operateResult = siemensS7Net.ConnectServer();
        boolean isSuccess = operateResult.IsSuccess;
        if (!isSuccess) {
            System.out.println("S7-S1500协议模块 - 连接失败-V");
            return null;
        }
        System.out.println("S7-S1500协议模块 - 连接成功");
        return siemensS7Net;
    }

    @Override
    public SiemensS7Net getLongSiemensS7Net(String ip, int port) {
        SiemensPLCS s1500 = SiemensPLCS.S1500;
        SiemensS7Net siemensS7Net = new SiemensS7Net(s1500,ip);
        siemensS7Net.setPort(port);
        siemensS7Net.setConnectTimeOut(2000);
        OperateResult operateResult = siemensS7Net.ConnectServer();
        boolean isSuccess = operateResult.IsSuccess;
        if (!isSuccess) {
            System.out.printf("S7-S1500协议模块 - 连接失败,IP:(%s),端口:(%s)%n",ip,port);
            return null;
        }
        System.out.printf("S7-S1500协议模块 - 连接成功,IP:(%s),端口:(%s)%n", ip, port);
        return siemensS7Net;
    }

    @Override
    public S7Connector getConnection(String ip, int port) {
        S7Connector s7Connector = S7ConnectorFactory
                    .buildTCPConnector()
                    .withHost(ip)
                    .withPort(port)
                    .withRack(0)
                    .withSlot(1)
                    .build();
            if(s7Connector != null){
                System.out.printf("s7Connector协议模块 - 连接成功,IP:(%s),端口:(%s)%n",ip,port);
                return s7Connector;
            }
            else {
                System.out.printf("s7Connector协议模块 - 连接失败,IP:(%s),端口:(%s)%n",ip,port);
                return null;
            }

    }
}
