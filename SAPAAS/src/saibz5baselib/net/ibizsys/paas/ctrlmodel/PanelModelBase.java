/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.ctrlmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.control.panel.IPanelField;
import net.ibizsys.paas.ctrlhandler.CtrlHandler;
import net.ibizsys.paas.ctrlhandler.ICtrlHandler;
import net.ibizsys.paas.ctrlhandler.ISDCtrlHandler;
import net.ibizsys.paas.ctrlmodel.CtrlModelBase;
import net.ibizsys.paas.ctrlmodel.IPanelModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PanelModelBase
extends CtrlModelBase
implements IPanelModel {
    private static final Log log = LogFactory.getLog(PanelModelBase.class);
    protected ArrayList<IPanelField> panelFieldList = new ArrayList();
    protected HashMap<String, IPanelField> panelFieldMap = new HashMap();

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.preparePanelFields();
    }

    protected IPanelField createPanelField(String strPanelFieldName) {
        return null;
    }

    protected void preparePanelFields() throws Exception {
    }

    @Override
    public Iterator<IPanelField> getPanelFields() {
        return this.panelFieldList.iterator();
    }

    public IPanelField getPanelField(String strName) throws Exception {
        return this.getPanelField(strName, false);
    }

    @Override
    public IPanelField getPanelField(String strName, boolean bTryMode) throws Exception {
        IPanelField iPanelField = this.panelFieldMap.get(strName.toLowerCase());
        if (iPanelField == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u9762\u677f\u5c5e\u6027\u9879[%1$s]", strName));
        }
        return iPanelField;
    }

    protected void registerPanelField(IPanelField iPanelField) {
        this.panelFieldMap.put(iPanelField.getName().toLowerCase(), iPanelField);
        this.panelFieldList.add(iPanelField);
    }

    @Override
    public void fillOutputDatas(IDataObject iDataObject, JSONObject data, JSONObject config) throws Exception {
        if (iDataObject == null) {
            throw new Exception(StringHelper.format("\u6570\u636e\u5bf9\u8c61\u65e0\u6548"));
        }
        this.onFillOutputDatas(iDataObject, data, config);
    }

    protected void onFillOutputDatas(IDataObject iDataObject, JSONObject data, JSONObject config) throws Exception {
        ICtrlHandler iCtrlHandler = CtrlHandler.getCurrent();
        ISDCtrlHandler iSDCtrlHandler = null;
        boolean bEnableItemPriv = false;
        if (iCtrlHandler != null && iCtrlHandler instanceof ISDCtrlHandler) {
            iSDCtrlHandler = (ISDCtrlHandler)iCtrlHandler;
            bEnableItemPriv = iSDCtrlHandler.isEnableItemPriv();
        }
        Iterator<IPanelField> panelFields = this.getPanelFields();
        panelFields = this.getPanelFields();
        while (panelFields.hasNext()) {
            JSONObject itemConfig;
            IPanelField iPanelField = panelFields.next();
            boolean bItemReadOk = true;
            Object objValue = null;
            if (bItemReadOk) {
                objValue = iPanelField.getOutputValue(this.getViewController().getWebContext(), iDataObject, true);
                if (objValue == null) {
                    objValue = "";
                }
            } else {
                objValue = "";
            }
            JSONObjectHelper.put(data, iPanelField.getName(), objValue);
            if (config == null || (itemConfig = iPanelField.getConfig(this.getViewController().getWebContext(), iDataObject)) == null) continue;
            config.put(iPanelField.getName(), (Object)itemConfig);
        }
    }

    @Override
    public String getControlType() {
        return "PANEL";
    }
}

