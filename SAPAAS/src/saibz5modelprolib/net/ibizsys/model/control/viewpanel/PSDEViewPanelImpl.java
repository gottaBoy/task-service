/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDEView
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.viewpanel.IPSDEViewPanel
 *  net.ibizsys.model.control.viewpanel.IPSDEViewPanelParam
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.viewpanel;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppDEView;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.app.view.PSAppViewRefImpl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSControlImpl;
import net.ibizsys.model.control.viewpanel.IPSDEViewPanel;
import net.ibizsys.model.control.viewpanel.IPSDEViewPanelParam;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEViewPanelImpl
extends PSControlImpl
implements IPSDEViewPanel {
    private static final Log log = LogFactory.getLog(PSDEViewPanelImpl.class);
    protected IPSDEViewPanelParam iPSDEViewPanelParam = null;
    private IPSAppDEView iPSAppDEView = null;
    private String strEmbedViewId = null;
    private String strCaption = "\u6807\u9898";
    private IPSLanguageRes capPSLanguageRes = null;

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            this.setName(strName);
            if (iPSControlParam != null) {
                this.iPSDEViewPanelParam = (IPSDEViewPanelParam)iPSControlParam;
            }
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
        if (!StringHelper.isNullOrEmpty((String)this.iPSDEViewPanelParam.getPSDEViewId())) {
            String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)this.iPSDEViewPanelParam.getPSDEViewId());
            this.iPSAppDEView = (IPSAppDEView)((IPSApplicationRuntime)this.getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, this.iPSDEViewPanelParam.getPSDEViewId(), this.getPSAppView());
            this.strEmbedViewId = ((IPSAppViewRuntime)this.getPSAppView()).generateViewUniId();
            ((IPSAppViewRuntime)this.iPSAppDEView).markViewUsage(4, this);
        }
        if (!StringHelper.isNullOrEmpty((String)this.iPSDEViewPanelParam.getCapPSLanguageResId())) {
            this.capPSLanguageRes = this.getPSSystem().getPSLanguageRes(this.iPSDEViewPanelParam.getCapPSLanguageResId());
        }
        this.strCaption = this.iPSDEViewPanelParam.getCaption();
    }

    public String getControlType() {
        return "VIEWPANEL";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.getPSAppDEView() != null) {
            relatedAppViewList.add((IPSAppView)this.getPSAppDEView());
        }
    }

    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u5bf9\u8c61")
    public IPSAppDEView getPSAppDEView() {
        return this.iPSAppDEView;
    }

    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (StringHelper.isNullOrEmpty((String)this.getEmbedViewId())) {
            return;
        }
        IPSAppDEView refPSAppView = this.getPSAppDEView();
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        PSAppViewRef psAppViewRef = new PSAppViewRef();
        psAppViewRefImpl.init(this.getPSModelStorageContext(), this.getPSAppView(), psAppViewRef);
        psAppViewRefImpl.setRefPSAppView((IPSAppView)refPSAppView);
        String strFullViewId = "";
        strFullViewId = StringHelper.isNullOrEmpty((String)strContainerId) ? this.getEmbedViewId() : StringHelper.format((String)"%1$s_%2$s", (Object)strContainerId, (Object)this.getEmbedViewId());
        psAppViewRefImpl.setEmbedId(strFullViewId);
        embeddedPSAppViewRefList.add(psAppViewRefImpl);
        Iterator childPSAppViewRefs = refPSAppView.getEmbeddedPSAppViewRefs(strFullViewId);
        if (childPSAppViewRefs != null) {
            while (childPSAppViewRefs.hasNext()) {
                embeddedPSAppViewRefList.add((IPSAppViewRef)childPSAppViewRefs.next());
            }
        }
    }

    @PSModelRTMeta(description="\u6807\u9898")
    public String getCaption() {
        return this.strCaption;
    }

    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    public String getModelType() {
        return "PSVIEWPANEL";
    }
}

