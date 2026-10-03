/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxentapp.uiaction;


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

import net.ibizsys.psrt.srv.wx.entity.WXEntApp;
import net.ibizsys.psrt.srv.wx.service.WXEntAppService;

/**
 *  实体界面行为[发布菜单]对象模型
 */
public abstract class WXEntAppPubMenuUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<WXEntApp> {

    private static final Log log = LogFactory.getLog(WXEntAppPubMenuUIActionModelBase.class);

    public WXEntAppPubMenuUIActionModelBase() {
        super();

        this.setId("EA4930E9-876E-46F5-A36E-AEAB00FB08F1");
        this.setName("PubMenu");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("PubMenu");
        this.setSuccessMsg("发布菜单成功！");
    }

}