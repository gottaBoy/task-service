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
 * 实体[DALog] 服务对象
 */
@Component
public class DALogService extends DALogServiceBase {

    private static final Log log = LogFactory.getLog(DALogService.class);
    public DALogService () {
        super();

    }

}