/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.control.dashboard.IPortlet
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBContainerPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBContainerPortletPartParam;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayoutContainer;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutFactory;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSPortletType;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.dashboard.IPortlet;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"CONTAINER"})
public class PSDBContainerPortletPartImpl
extends PSDBPortletPartImpl
implements IPSDBContainerPortletPart {
    private static final Log log = LogFactory.getLog(PSDBContainerPortletPartImpl.class);
    private IPSDBContainerPortletPartParam iPSDBContainerPortletPartParam = null;
    private IPSPortletType iPSPortletType;
    protected ArrayList<IPSDBPortletPart> psPortletList = new ArrayList();
    protected ArrayList<IPortlet> portletList = new ArrayList();
    private IPSLayout iPSLayout = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDBContainerPortletPartParam = (IPSDBContainerPortletPartParam)iPSControlParam;
            this.setName(strName);
            this.iPSPortletType = this.getPSModelStorage().getPSPortletType(this.getPortletType());
            super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        PSLayout psLayout = new PSLayout();
        psLayout.setFLEXALIGN(this.getFlexAlign());
        psLayout.setFLEXDIR(this.getFlexDir());
        psLayout.setFLEXVALIGN(this.getFlexVAlign());
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getLayoutMode())) {
            this.iPSLayout = PSLayoutFactory.createPSLayout(this, this.getLayoutMode(), psLayout);
        }
        super.onInit();
    }

    @Override
    public IPSControl getContentPSControl() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u7c7b\u578b", codelist="PortletType3")
    public String getPortletType() {
        return "CONTAINER";
    }

    @Override
    public IPSPortletType getPSPortetType() {
        return this.iPSPortletType;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u96c6\u5408", hideempty2=true, child=true, dumpref=true, ignorert=3, modelreftype="IGNOREDESIGN", modelattr="getPSControls")
    public Iterator<IPSDBPortletPart> getPSPortlets() {
        return this.psPortletList.iterator();
    }

    @Override
    public void registerPSPortlet(IPSDBPortletPart iPSPortlet) throws Exception {
        this.psPortletList.add(iPSPortlet);
        this.portletList.add(iPSPortlet);
        iPSPortlet.setPSDashboardContainer(this);
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        for (IPSDBPortletPart iPSDBPortletPart : this.psPortletList) {
            iPSDBPortletPart.fillRelatedPSAppViews(relatedAppViewList);
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        for (IPSDBPortletPart iPSDBPortletPart : this.psPortletList) {
            iPSDBPortletPart.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        for (IPSDBPortletPart iPSDBPortletPart : this.psPortletList) {
            iPSDBPortletPart.fillRelatedPSCodeLists(relatedPSCodeListList);
        }
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
    }

    @Override
    @PSModelRTMeta(description="\u5e03\u5c40\u6a21\u5f0f", codelist="FormDetailLayoutMode", dump=false)
    public String getLayoutMode() {
        String strLayout = this.iPSDBContainerPortletPartParam.getLayoutMode();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLayout)) {
            IPSLayout iPSLayout = null;
            if (this.getPSDashboardContainer() != null) {
                iPSLayout = this.getPSDashboardContainer().getPSLayout();
            } else if (this.getPSControlContainer() instanceof IPSLayoutContainer) {
                iPSLayout = ((IPSLayoutContainer)((Object)this.getPSControlContainer())).getPSLayout();
            }
            if (iPSLayout != null) {
                return iPSLayout.getLayout();
            }
        }
        return strLayout;
    }

    @Override
    @PSModelRTMeta(description="Flex\u5e03\u5c40\u65b9\u5411", codelist="FlexLayoutDir", dump=false)
    public String getFlexDir() {
        return this.iPSDBContainerPortletPartParam.getFlexDir();
    }

    @Override
    @PSModelRTMeta(description="Flex\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5411", codelist="FlexAlign", dump=false)
    public String getFlexAlign() {
        return this.iPSDBContainerPortletPartParam.getFlexAlign();
    }

    @Override
    @PSModelRTMeta(description="Flex\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5411", codelist="FlexVAlign", dump=false)
    public String getFlexVAlign() {
        return this.iPSDBContainerPortletPartParam.getFlexVAlign();
    }

    @Override
    public boolean isAjaxCtrl() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5bb9\u5668\u5e03\u5c40", child=true)
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408", hideempty2=true, child=true, dumpref=false, modelreftype="IGNOREDESIGN", dump=false)
    public Iterator<IPSControl> getPSControls() {
        return super.getPSControls();
    }
}

