/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userdict.uiaction;


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

import net.ibizsys.psrt.srv.common.entity.UserDict;
import net.ibizsys.psrt.srv.common.service.UserDictService;

/**
 *  实体界面行为[ReloadCurUser]对象模型
 */
public abstract class UserDictReloadCurUserUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<UserDict> {

    private static final Log log = LogFactory.getLog(UserDictReloadCurUserUIActionModelBase.class);

    public UserDictReloadCurUserUIActionModelBase() {
        super();

        this.setId("6BBDD2EC-9323-4984-8A0D-0AA19BAEEF14");
        this.setName("ReloadCurUser");
        this.setActionTarget("NONE");
        this.setDEActionName("ReloadCurUser");
        this.setSuccessMsg("重新加载当前用户成功！");
    }

}