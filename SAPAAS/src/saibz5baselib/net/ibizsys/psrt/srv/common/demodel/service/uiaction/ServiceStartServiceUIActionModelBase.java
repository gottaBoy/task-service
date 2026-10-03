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
 *  实体界面行为[StartService]对象模型
 */
public abstract class ServiceStartServiceUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<Service> {

    private static final Log log = LogFactory.getLog(ServiceStartServiceUIActionModelBase.class);

    public ServiceStartServiceUIActionModelBase() {
        super();

        this.setId("4289D139-69BA-439E-8C91-B1BF69B6403A");
        this.setName("StartService");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("StartService");
        this.setReloadData(true);
        this.setSuccessMsg("服务启动成功！");
    }

}