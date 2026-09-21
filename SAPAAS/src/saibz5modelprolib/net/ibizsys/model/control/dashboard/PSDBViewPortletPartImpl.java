/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.dashboard.IPSDBViewPortletPart
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.dashboard;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.app.IPSApplicationRuntime;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.app.view.IPSAppViewRuntime;
import net.ibizsys.model.app.view.PSAppViewRefImpl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.dashboard.IPSDBViewPortletPart;
import net.ibizsys.model.control.dashboard.PSDBSysPortletPartImpl;
import net.ibizsys.model.entity.PSAppViewRef;
import net.ibizsys.model.res.IPSSysDEViewPortlet;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;

public class PSDBViewPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBViewPortletPart {
    private IPSAppView portletPSAppView = null;
    private String strEmbedViewId = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEViewPortlet iPSSysDEViewPortlet = (IPSSysDEViewPortlet)this.iPSSysPortlet;
        if (!StringHelper.isNullOrEmpty((String)iPSSysDEViewPortlet.getPSDEViewId())) {
            try {
                String strPSAppViewId = KeyValueHelper.genUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)iPSSysDEViewPortlet.getPSDEViewId());
                this.portletPSAppView = ((IPSApplicationRuntime)this.getPSAppView().getPSApplication()).getPSAppView(strPSAppViewId, iPSSysDEViewPortlet.getPSDEViewId(), this.getPSAppView());
                ((IPSAppViewRuntime)this.portletPSAppView).markViewUsage(4, this);
                this.strEmbedViewId = ((IPSAppViewRuntime)this.getPSAppView()).generateViewUniId();
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u89c6\u56fe\u95e8\u6237\u90e8\u4ef6[%1$s]\u76f8\u5173\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)this.getName(), (Object)ex.getMessage()), ex);
            }
        }
        super.onInit();
    }

    @Override
    public IPSControl getContentPSControl() {
        return null;
    }

    public IPSAppView getPortletPSAppView() {
        return this.portletPSAppView;
    }

    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.portletPSAppView != null) {
            relatedAppViewList.add(this.portletPSAppView);
        }
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (StringHelper.isNullOrEmpty((String)this.getEmbedViewId())) {
            return;
        }
        IPSAppView refPSAppView = this.getPortletPSAppView();
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        PSAppViewRef psAppViewRef = new PSAppViewRef();
        psAppViewRefImpl.init(this.getPSModelStorageContext(), this.getPortletPSAppView(), psAppViewRef);
        psAppViewRefImpl.setRefPSAppView(refPSAppView);
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
}

