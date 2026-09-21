/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IWizardPanelHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IWizardPanelModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WizardPanelHandlerBase
extends CtrlHandlerBase
implements IWizardPanelHandler {
    private static final Log log = LogFactory.getLog(WizardPanelHandlerBase.class);

    protected abstract IWizardPanelModel getWizardPanelModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getWizardPanelModel();
    }

    protected AjaxActionResult onInitAction() throws Exception {
        SDAjaxActionResult ajaxActionResult = new SDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
        IEntity iEntity = this.initWizard();
        this.fillOutputDatas(iEntity, ajaxActionResult);
        return ajaxActionResult;
    }

    protected AjaxActionResult onFinishAction() throws Exception {
        SDAjaxActionResult ajaxActionResult = new SDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
        String strKey = WebContext.getKey(this.getWebContext());
        Object iEntity = this.getDEModel().createEntity();
        iEntity.set(this.getDEModel().getKeyDEField().getName(), strKey);
        this.finishWizard((IEntity)iEntity);
        this.fillOutputDatas((IDataObject)iEntity, ajaxActionResult);
        return ajaxActionResult;
    }

    protected IEntity initWizard() throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected IEntity finishWizard(IEntity iEntity) throws Exception {
        throw new Exception(StringHelper.format("\u6ca1\u6709\u5b9e\u73b0"));
    }

    protected void fillOutputDatas(IDataObject iDataObject, SDAjaxActionResult ajaxActionResult) throws Exception {
        iDataObject.fillJSONObject(ajaxActionResult.getData(true), false);
        JSONObjectHelper.putRaw(ajaxActionResult.getData(true), "srfkey", iDataObject.get(this.getDEModel().getKeyDEField().getName()));
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "init", true) == 0) {
            return this.onInitAction();
        }
        if (StringHelper.compare(strAction, "finish", true) == 0) {
            return this.onFinishAction();
        }
        return super.onProcessAction(strAction);
    }
}

