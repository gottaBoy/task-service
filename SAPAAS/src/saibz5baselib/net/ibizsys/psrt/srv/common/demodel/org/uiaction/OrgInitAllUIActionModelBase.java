/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.org.uiaction;


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

import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.service.OrgService;

/**
 *  实体界面行为[InitAll]对象模型
 */
public abstract class OrgInitAllUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<Org> {

    private static final Log log = LogFactory.getLog(OrgInitAllUIActionModelBase.class);

    public OrgInitAllUIActionModelBase() {
        super();

        this.setId("04647C73-AFFA-4495-9D53-D1B874C1AA15");
        this.setName("InitAll");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitAll");
        this.setSuccessMsg("初始化机构相关数据完成！");
    }

}