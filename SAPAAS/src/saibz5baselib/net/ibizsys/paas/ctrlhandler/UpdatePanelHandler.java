/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IUpdatePanelHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.psmsg.util.MsgTemplateGlobal;
import net.ibizsys.psmsg.util.MsgTemplateHelper;
import net.ibizsys.psrt.srv.common.entity.MsgSendQueue;
import net.ibizsys.psrt.srv.common.entity.MsgTemplate;

public class UpdatePanelHandler
extends CtrlHandlerBase
implements IUpdatePanelHandler {
    private String strDEName = "";
    private String strDEActionName = "";
    private String strSysMsgTemplId = "";

    @Override
    public ICtrlModel getCtrlModel() {
        return null;
    }

    public String getDEName() {
        return this.strDEName;
    }

    public void setDEName(String strDEName) {
        this.strDEName = strDEName;
    }

    public String getDEActionName() {
        return this.strDEActionName;
    }

    public void setDEActionName(String strDEActionName) {
        this.strDEActionName = strDEActionName;
    }

    public String getSysMsgTemplId() {
        return this.strSysMsgTemplId;
    }

    public void setSysMsgTemplId(String strSysMsgTemplId) {
        this.strSysMsgTemplId = strSysMsgTemplId;
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.isNullOrEmpty(strAction)) {
            return this.createFetchActionResult();
        }
        if (StringHelper.compare(strAction, "fetch", true) == 0) {
            return this.onFetch();
        }
        return super.onProcessAction(strAction);
    }

    protected AjaxActionResult createFetchActionResult() throws Exception {
        return new AjaxActionResult();
    }

    protected AjaxActionResult onFetch() throws Exception {
        AjaxActionResult ajaxActionResult = this.createFetchActionResult();
        this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
        if (!StringHelper.isNullOrEmpty(this.getSysMsgTemplId())) {
            IEntity activeData = null;
            IDataEntityModel iDEModel = null;
            if (!StringHelper.isNullOrEmpty(this.getDEName())) {
                iDEModel = DEModelGlobal.getDEModel(this.getDEName());
                if (!StringHelper.isNullOrEmpty(this.getDEActionName())) {
                    IService iService = iDEModel.getService(this.getSessionFactory());
                    activeData = (IEntity)iDEModel.createEntity();
                    iService.executeAction(this.getDEActionName(), activeData);
                }
            }
            MsgTemplate msgTemplate = MsgTemplateGlobal.getMsgTemplate(this.getSysMsgTemplId());
            MsgSendQueue msgSendQueue = MsgTemplateHelper.getMsgSendQueue(2, msgTemplate, iDEModel, activeData, null, this.getWebContext(), null, this.getWebContext().getCurUserId(), "");
            ajaxActionResult.setContent(msgSendQueue.getContent());
        }
        return ajaxActionResult;
    }
}

