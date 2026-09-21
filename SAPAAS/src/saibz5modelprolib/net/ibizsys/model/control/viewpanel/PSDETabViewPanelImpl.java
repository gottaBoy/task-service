/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.counter.IPSSysCounter
 *  net.ibizsys.model.control.counter.IPSSysCounterRef
 *  net.ibizsys.model.control.viewpanel.IPSDETabViewPanel
 *  net.ibizsys.model.control.viewpanel.IPSDETabViewPanelParam
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.viewpanel;

import com.fasterxml.jackson.databind.node.ObjectNode;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.counter.IPSSysCounter;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.model.control.viewpanel.IPSDETabViewPanel;
import net.ibizsys.model.control.viewpanel.IPSDETabViewPanelParam;
import net.ibizsys.model.control.viewpanel.PSDEViewPanelImpl;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDETabViewPanelImpl
extends PSDEViewPanelImpl
implements IPSDETabViewPanel {
    private static final Log log = LogFactory.getLog(PSDETabViewPanelImpl.class);
    private IPSDETabViewPanelParam iPSDETabViewPanelParam = null;
    private IPSSysCounterRef iPSSysCounterRef = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDETabViewPanelParam = (IPSDETabViewPanelParam)iPSControlParam;
            this.setId(String.valueOf(iPSControlContainer.getPSAppView().getId()) + "_" + strName);
            this.setName(strName);
            super.init(iPSModelStorageContext, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysCounterRef(this.preparePSSysCounterRef());
    }

    protected IPSSysCounterRef preparePSSysCounterRef() throws Exception {
        String strExpBarCounterId = this.iPSDETabViewPanelParam.getPSSysCounterId();
        if (!StringHelper.isNullOrEmpty((String)strExpBarCounterId)) {
            IPSSysCounter iPSSysCounter = this.getPSAppView().getPSApplication().getPSSystem().getPSSysCounter(strExpBarCounterId, false);
            ObjectNode refModeObj = JsonNodeHelper.createObjectNode();
            return ((IPSAppViewRuntime)this.getPSAppView()).registerPSSysCounter(iPSSysCounter, refModeObj);
        }
        return null;
    }

    public String getCounterId() {
        return this.iPSDETabViewPanelParam.getCounterId();
    }

    @PSModelRTMeta(description="\u7cfb\u7edf\u8ba1\u6570\u5668\u5f15\u7528")
    public IPSSysCounterRef getPSSysCounterRef() {
        return this.iPSSysCounterRef;
    }

    protected void setPSSysCounterRef(IPSSysCounterRef iPSSysCounterRef) {
        this.iPSSysCounterRef = iPSSysCounterRef;
    }

    @Override
    public String getControlType() {
        return "TABVIEWPANEL";
    }
}

