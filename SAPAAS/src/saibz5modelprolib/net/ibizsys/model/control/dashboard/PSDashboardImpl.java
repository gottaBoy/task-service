/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppView
 *  net.ibizsys.model.app.view.IPSAppViewRef
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.IPSAjaxControlParam
 *  net.ibizsys.model.control.IPSControlContainer
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.dashboard.IPSDBPortletPart
 *  net.ibizsys.model.control.dashboard.IPSDashboard
 *  net.ibizsys.model.control.dashboard.IPSDashboardParam
 *  net.ibizsys.paas.control.dashboard.IPortlet
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.control.dashboard;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.app.view.IPSAppViewRef;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControlParam;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSAjaxControlContainerImpl;
import net.ibizsys.model.control.dashboard.IPSDBPortletPart;
import net.ibizsys.model.control.dashboard.IPSDBPortletPartRuntime;
import net.ibizsys.model.control.dashboard.IPSDashboard;
import net.ibizsys.model.control.dashboard.IPSDashboardParam;
import net.ibizsys.paas.control.dashboard.IPortlet;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDashboardImpl
extends PSAjaxControlContainerImpl
implements IPSDashboard {
    private static final Log log = LogFactory.getLog(PSDashboardImpl.class);
    protected IPSDashboardParam iPSDashboardParam = null;
    protected ArrayList<IPSDBPortletPart> psPortletList = new ArrayList();
    protected ArrayList<IPortlet> portletList = new ArrayList();

    @Override
    public void init(IPSModelStorageContext iPSModelStorageContext, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setPSModelStorageContext(iPSModelStorageContext);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDashboardParam = (IPSDashboardParam)iPSControlParam;
            this.setId(iPSControlContainer.getId());
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
    }

    public String getControlType() {
        return "DASHBOARD";
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDashboardParam;
    }

    @PSModelRTMeta(description="\u5217\u5e03\u5c40\u6a21\u578b", hideempty2=true)
    public double[] getColumnModels() {
        return this.iPSDashboardParam.getColumnModels();
    }

    public Iterator<IPortlet> getPortlets() {
        return this.portletList.iterator();
    }

    @PSModelRTMeta(description="\u95e8\u6237\u90e8\u4ef6\u96c6\u5408")
    public Iterator<IPSDBPortletPart> getPSPortlets() {
        return this.psPortletList.iterator();
    }

    public void registerPSPortlet(IPSDBPortletPart iPSPortlet) throws Exception {
        this.psPortletList.add(iPSPortlet);
        this.portletList.add((IPortlet)iPSPortlet);
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        for (IPSDBPortletPart iPSDBPortletPart : this.psPortletList) {
            ((IPSDBPortletPartRuntime)iPSDBPortletPart).fillRelatedPSAppViews(relatedAppViewList);
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        for (IPSDBPortletPart iPSDBPortletPart : this.psPortletList) {
            ((IPSDBPortletPartRuntime)iPSDBPortletPart).fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSDBPortletPart iPSDBPortletPart : this.psPortletList) {
            ((IPSDBPortletPartRuntime)iPSDBPortletPart).fillRelatedPSCodeLists(relatedPSCodeListList);
        }
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
    }

    @Override
    public String getModelType() {
        return "PSSYSDASHBOARD";
    }
}

