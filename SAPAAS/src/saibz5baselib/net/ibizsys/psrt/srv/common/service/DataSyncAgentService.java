/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;



import net.ibizsys.paas.service.ServiceGlobal;

/**
 * 实体[DataSyncAgent] 服务对象
 */
@Component
public class DataSyncAgentService extends DataSyncAgentServiceBase {

    private static final Log log = LogFactory.getLog(DataSyncAgentService.class);
    public DataSyncAgentService () {
        super();

    }

}