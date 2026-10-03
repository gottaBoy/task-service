/**
 *  iBizSys 5.0 用户自定义代码
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv;

import net.ibizsys.paas.entity.IEntity;

/**
 * 系统[PSRuntime]服务对象基类
 */
public abstract class PSRuntimeSysServiceBase<ET extends IEntity> extends net.ibizsys.paas.service.ServiceBase<ET> {

    public PSRuntimeSysServiceBase() {
        super();

    }

}