/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepdata.uiaction;


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

import net.ibizsys.psrt.srv.wf.entity.WFStepData;
import net.ibizsys.psrt.srv.wf.service.WFStepDataService;

/**
 *  实体界面行为[回撤流程操作]对象模型
 */
public abstract class WFStepDataRollbackUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<WFStepData> {

    private static final Log log = LogFactory.getLog(WFStepDataRollbackUIActionModelBase.class);

    public WFStepDataRollbackUIActionModelBase() {
        super();

        this.setId("81FFA1AE-A6F5-49A0-AE3C-995930A6B115");
        this.setName("Rollback");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("Rollback");
        this.setReloadData(true);
        this.setDataAccessAction("NONE");
        this.setSuccessMsg("回撤操作成功！");
    }

}