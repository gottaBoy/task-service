/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.control.drctrl.IPSDEDRCtrl
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.dr.IPSDEDRDetail
 *  net.ibizsys.model.dataentity.dr.IPSDEDRItem
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.drctrl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSObjectImpl;
import net.ibizsys.model.app.IPSAppPDTView;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrl;
import net.ibizsys.model.control.drctrl.IPSDEDRCtrlItemRuntime;
import net.ibizsys.model.control.drctrl.PSDEDRBarItemImpl;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.dr.IPSDEDRDetail;
import net.ibizsys.model.dataentity.dr.IPSDEDRItem;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDEDRCtrlItemImpl
extends PSObjectImpl
implements IPSDEDRCtrlItemRuntime {
    private static final Log log = LogFactory.getLog(PSDEDRBarItemImpl.class);
    private IPSDEDRCtrl iPSDEDRCtrl;
    private IPSDEDRDetail iPSDEDRDetail;
    private IPSAppView iPSAppView = null;
    private String strEmbedViewId = null;
    private ObjectNode viewParamJO = JsonNodeHelper.createObjectNode();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSDEDRCtrl iPSDEDRCtrl, IPSDEDRDetail iPSDEDRDetail) throws Exception {
        Iterator it;
        ObjectNode drViewParamJO;
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDEDRCtrl = iPSDEDRCtrl;
        this.iPSDEDRDetail = iPSDEDRDetail;
        this.setId(this.iPSDEDRDetail.getId());
        this.setName(this.iPSDEDRDetail.getName());
        if (iPSDEDRDetail.getPSSysPDTView() != null) {
            String strPSAppPDTViewId = KeyValueHelper.genUniqueId((String)this.iPSDEDRCtrl.getPSAppView().getPSApplication().getId(), (String)iPSDEDRDetail.getPSSysPDTView().getId());
            IPSAppPDTView iPSAppPDTView = ((IPSApplicationRuntime)this.iPSDEDRCtrl.getPSAppView().getPSApplication()).getPSAppPDTView(strPSAppPDTViewId, true);
            if (iPSAppPDTView != null && iPSAppPDTView.getPSAppView() != null) {
                this.iPSAppView = iPSAppPDTView.getPSAppView();
                this.strEmbedViewId = ((IPSAppViewRuntime)this.iPSDEDRCtrl.getPSAppView()).generateViewUniId();
            }
        }
        if (this.iPSAppView == null && !StringHelper.isNullOrEmpty((String)iPSDEDRDetail.getPSDEViewId())) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.iPSDEDRCtrl.getPSAppView().getPSApplication().getId(), (String)iPSDEDRDetail.getPSDEViewId());
            try {
                this.iPSAppView = ((IPSApplicationRuntime)this.iPSDEDRCtrl.getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, iPSDEDRDetail.getPSDEViewId(), this.iPSDEDRCtrl.getPSAppView());
                this.strEmbedViewId = ((IPSAppViewRuntime)this.iPSDEDRCtrl.getPSAppView()).generateViewUniId();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u89c6\u56fe[%1$s]\u5173\u7cfb\u680f[%2$s]\u5173\u7cfb\u9879[%3$s]\u83b7\u53d6\u5b9e\u4f53\u89c6\u56fe[%4$s]\u53d1\u751f\u5f02\u5e38\uff0c%5$s", (Object)this.iPSDEDRCtrl.getPSAppView().getName(), (Object)iPSDEDRCtrl.getName(), (Object)this.getName(), (Object)this.iPSDEDRDetail.getPSDEViewId(), (Object)ex.getMessage()));
                throw ex;
            }
        }
        this.viewParamJO.put("srfparentdeid".toLowerCase(), this.iPSDEDRCtrl.getPSDataEntity().getId());
        if (this.getPSDEDRItem() != null && (drViewParamJO = this.getPSDEDRItem().getViewParamJO()) != null && (it = drViewParamJO.fieldNames()) != null) {
            while (it.hasNext()) {
                String strKey = (String)it.next();
                String strValue = JsonNodeHelper.getString((ObjectNode)drViewParamJO, (String)strKey, null);
                if (strValue == null) continue;
                this.viewParamJO.put(strKey.toLowerCase(), strValue);
            }
        }
        this.onInit();
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.iPSDEDRDetail.getCaption(this.iPSDEDRCtrl.getPSAppView().getLanguage());
    }

    public IPSDEDRDetail getPSDEDRDetail() {
        return this.iPSDEDRDetail;
    }

    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    public IPSDEDRItem getPSDEDRItem() {
        if (this.iPSDEDRDetail == null) {
            return null;
        }
        return this.iPSDEDRDetail.getPSDEDRItem();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.iPSDEDRCtrl);
    }

    public ObjectNode getViewParamJO() {
        return this.viewParamJO;
    }

    public IPSLanguageRes getCapPSLanguageRes() {
        if (this.iPSDEDRDetail == null) {
            return null;
        }
        return this.iPSDEDRDetail.getCapPSLanguageRes();
    }
}

