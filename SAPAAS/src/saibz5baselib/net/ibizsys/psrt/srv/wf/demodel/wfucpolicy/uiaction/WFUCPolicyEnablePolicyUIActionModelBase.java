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
 *  实体界面行为[启用策略]对象模型
 */
public abstract class WFUCPolicyEnablePolicyUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<WFUCPolicy> {

    private static final Log log = LogFactory.getLog(WFUCPolicyEnablePolicyUIActionModelBase.class);

    public WFUCPolicyEnablePolicyUIActionModelBase() {
        super();

        this.setId("F3BA7F9B-0579-4390-91D7-B91CA3133572");
        this.setName("EnablePolicy");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("EnablePolicy");
        this.setReloadData(true);
    }

}