/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.ctrlhandler.CtrlHandlerBase;
import net.ibizsys.paas.ctrlhandler.IPanelHandler;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IPanelModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.PanelAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class PanelHandlerBase
extends CtrlHandlerBase
implements IPanelHandler {
    protected abstract IPanelModel getPanelModel();

    @Override
    public ICtrlModel getCtrlModel() {
        return this.getPanelModel();
    }

    @Override
    protected AjaxActionResult onProcessAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, "load", true) == 0) {
            return this.onLoad();
        }
        return super.onProcessAction(strAction);
    }

    protected void fillOutputDatas(IDataObject iDataObject, PanelAjaxActionResult panelAjaxActionResult) throws Exception {
        JSONObject outputData = panelAjaxActionResult.getData(true);
        JSONObject outputConfig = panelAjaxActionResult.getConfig(true);
        this.getPanelModel().fillOutputDatas(iDataObject, outputData, outputConfig);
    }

    protected AjaxActionResult onLoad() throws Exception {
        PanelAjaxActionResult panelAjaxActionResult = new PanelAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult(panelAjaxActionResult);
        String strKey = WebContext.getKey(this.getWebContext());
        if (StringHelper.isNullOrEmpty(strKey)) {
            strKey = WebContext.getKeys(this.getWebContext());
        }
        IEntity iEntity = this.getEntity(strKey);
        this.fillOutputDatas(iEntity, panelAjaxActionResult);
        return panelAjaxActionResult;
    }

    protected IEntity getEntity(Object objKeyValue) throws Exception {
        return new SimpleEntity();
    }
}

