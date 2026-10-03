/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfinstance.uiaction;


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

import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;

/**
 *  实体界面行为[重启流程]对象模型
 */
public abstract class WFInstanceRestartUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<WFInstance> {

    private static final Log log = LogFactory.getLog(WFInstanceRestartUIActionModelBase.class);

    public WFInstanceRestartUIActionModelBase() {
        super();

        this.setId("4B9CAA8D-5BF7-4B24-8835-B1447EE62477");
        this.setName("Restart");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("Restart");
        this.setReloadData(true);
        this.setSuccessMsg("流程重启完成");
    }

}