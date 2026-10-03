/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.uiaction;


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

import net.ibizsys.psrt.srv.wf.entity.WFUCPolicy;
import net.ibizsys.psrt.srv.wf.service.WFUCPolicyService;

/**
 *  实体界面行为[禁用策略]对象模型
 */
public abstract class WFUCPolicyDisablePolicyUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<WFUCPolicy> {

    private static final Log log = LogFactory.getLog(WFUCPolicyDisablePolicyUIActionModelBase.class);

    public WFUCPolicyDisablePolicyUIActionModelBase() {
        super();

        this.setId("E1E4A34B-93C9-481D-9242-4556BF9ABA1E");
        this.setName("DisablePolicy");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("DisablePolicy");
        this.setReloadData(true);
    }

}