/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.codelist.uiaction;


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

import net.ibizsys.psrt.srv.common.entity.CodeList;
import net.ibizsys.psrt.srv.common.service.CodeListService;

/**
 *  实体界面行为[刷新代码表]对象模型
 */
public abstract class CodeListRefreshModelUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<CodeList> {

    private static final Log log = LogFactory.getLog(CodeListRefreshModelUIActionModelBase.class);

    public CodeListRefreshModelUIActionModelBase() {
        super();

        this.setId("21C9ECE1-5A81-4448-A892-B674240C1FCB");
        this.setName("RefreshModel");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("RefreshModel");
        this.setReloadData(true);
        this.setSuccessMsg("刷新代码表成功！");
    }

}