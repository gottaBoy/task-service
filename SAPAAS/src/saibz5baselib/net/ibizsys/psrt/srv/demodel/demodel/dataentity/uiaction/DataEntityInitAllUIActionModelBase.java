/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.demodel.demodel.dataentity.uiaction;


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

import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.ibizsys.psrt.srv.demodel.service.DataEntityService;

/**
 *  实体界面行为[InitAll]对象模型
 */
public abstract class DataEntityInitAllUIActionModelBase extends net.ibizsys.paas.demodel.DEUIActionModelBase<DataEntity> {

    private static final Log log = LogFactory.getLog(DataEntityInitAllUIActionModelBase.class);

    public DataEntityInitAllUIActionModelBase() {
        super();

        this.setId("F0D30EC1-2C41-409E-B8AC-7E0F983C5127");
        this.setName("InitAll");
        this.setActionTarget("MULTIKEY");
        this.setDEActionName("InitAll");
        this.setSuccessMsg("初始化实体相关配置完成！");
    }

}