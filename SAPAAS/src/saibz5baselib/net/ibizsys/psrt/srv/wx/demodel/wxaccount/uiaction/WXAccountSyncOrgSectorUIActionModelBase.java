/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccount.uiaction;


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

import net.ibizsys.psrt.srv.wx.entity.WXAccount;
import net.ibizsys.psrt.srv.wx.service.WXAccountService;

/**
 *  实体界面行为[同步部门]对象模型
 */
public abstract class WXAccountSyncOrgSectorUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<WXAccount> {

    private static final Log log = LogFactory.getLog(WXAccountSyncOrgSectorUIActionModelBase.class);

    public WXAccountSyncOrgSectorUIActionModelBase() {
        super();

        this.setId("FF25F1FA-ADF3-498B-A276-5B17CC0873D0");
        this.setName("SyncOrgSector");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("SyncOrgSector");
        this.setSuccessMsg("同步部门成功！");
    }

}