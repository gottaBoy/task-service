/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.service.uiaction;


import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.controller.ViewController;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IUIActionModel;
import net.ibizsys.paas.web.UIActionModelAjaxActionResult;
import net.ibizsys.paas.web.WebContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.psrt.srv.common.entity.Service;
import net.ibizsys.psrt.srv.common.service.ServiceService;

/**
 *  实体界面行为[StopService]对象模型
 */
public abstract class ServiceStopServiceUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<Service> {

    private static final Log log = LogFactory.getLog(ServiceStopServiceUIActionModelBase.class);

    public ServiceStopServiceUIActionModelBase() {
        super();

        this.setId("1DAF43F4-0D78-42EE-BFFA-85F59F1A70FB");
        this.setName("StopService");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("StopService");
        this.setReloadData(true);
        this.setSuccessMsg("服务停止成功！");
    }

}