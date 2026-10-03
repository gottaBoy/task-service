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
 *  实体界面行为[取消流程]对象模型
 */
public abstract class WFInstanceUserCancelUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<WFInstance> {

    private static final Log log = LogFactory.getLog(WFInstanceUserCancelUIActionModelBase.class);

    public WFInstanceUserCancelUIActionModelBase() {
        super();

        this.setId("EBA9085F-461B-4223-BDAF-EEDD62E2E5BE");
        this.setName("UserCancel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("UserCancel");
        this.setReloadData(true);
        this.setSuccessMsg("流程取消完成");
    }

}