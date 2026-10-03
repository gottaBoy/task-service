/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


/**
 * 继承实体[USEROBJECT]服务操作对象
 */
@Component
public  class UserObjectServiceProxy extends UserObjectServiceProxyBase {

    private static final Log log = LogFactory.getLog(UserObjectServiceProxy.class);
    public UserObjectServiceProxy() {
        super();

    }

}