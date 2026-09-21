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

import SA.SRFDA.PS.Core.App.Util.IPSAppDynaDashboardUtil;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBContainerPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboard;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDashboardParam;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Layout.IPSLayout;
import SA.SRFDA.PS.Core.Control.Layout.PSLayoutFactory;
import SA.SRFDA.PS.Core.Control.PSAjaxControlContainerImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Data.PSLayout;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
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
    private String strLayoutMode = null;
    private String strFlexDir = "";
    private String strFlexAlign = "";
    private String strFlexVAlign = "";
    private IPSLayout iPSLayout = null;
    protected ArrayList<IPSDBPortletPart> allPSPortletList = null;
    private boolean bEnableCustomized = false;
    private int nCustomizeMode = 0;
    private IPSAppDynaDashboardUtil iPSAppDynaDashboardUtil = null;
    private String strDashboardStyle = null;
    private boolean bShowDashboardNavBar = false;
    private IPSSysCss iNavBarPSSysCss = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSDashboardParam = (IPSDashboardParam)iPSControlParam;
            this.setId(iPSControlContainer.getId());
            this.setName(strName);
            this.strLayoutMode = this.iPSDashboardParam.getLayoutMode();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
                this.strLayoutMode = this.getPSAppView().getPSApplication().getPSPF().getPanelLayoutMode();
            }
            this.strDashboardStyle = this.iPSDashboardParam.getDashboardStyle();
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strLayoutMode)) {
            PSLayout psLayout = new PSLayout();
            this.iPSLayout = PSLayoutFactory.createPSLayout(this, this.strLayoutMode, psLayout);
        }
        if (this.iPSDashboardParam.isEnableCustomized() != null) {
            this.bEnableCustomized = this.iPSDashboardParam.isEnableCustomized();
            if (this.bEnableCustomized && !this.getPSAppView().getPSApplication().getPSApplicationUI().isEnableDynaDashboard()) {
                this.bEnableCustomized = false;
                this.getPSSystemUtil().getPSSysConsole().warn(this.getLogName(), SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u542f\u7528\u770b\u677f\u81ea\u5b9a\u4e49\u529f\u80fd\uff0c\u5e94\u7528\u672a\u914d\u7f6e[\u52a8\u6001\u770b\u677f]\u529f\u80fd"));
            } else {
                this.iPSAppDynaDashboardUtil = this.getPSAppView().getPSApplication().getPSAppDynaDashboardUtil();
                if (this.iPSDashboardParam.getCustomizeMode() != null) {
                    this.nCustomizeMode = this.iPSDashboardParam.getCustomizeMode();
                } else if (this.bEnableCustomized) {
                    this.nCustomizeMode = 1;
                }
            }
        }
        if (this.iPSDashboardParam.isShowDashboardNavBar() != null) {
            this.bShowDashboardNavBar = this.iPSDashboardParam.isShowDashboardNavBar();
        }
        if (this.isShowDashboardNavBar() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDashboardParam.getNavBarPSSysCssId())) {
            this.iNavBarPSSysCss = this.getPSAppView().getPSApplication().getPSSystem().getPSSysCss(this.iPSDashboardParam.getNavBarPSSysCssId());
        }
        super.onInit();
    }

    @Override
    protected String onGetControlType() {
        return "DASHBOARD";
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDashboardParam;
    }

    @PSModelRTMeta(description="\u5217\u5e03\u5c40\u6a21\u578b", hideempty2=true, dump=false)
    public double[] getColumnModels() {
        return this.iPSDashboardParam.getColumnModels();
    }

    public Iterator<IPortlet> getPortlets() {
        return this.portletList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u770b\u677f\u90e8\u4ef6\u96c6\u5408", hideempty2=true, child=true, dumpref=true, modelreftype="IGNOREDESIGN", modelattr="getPSControls", ignorert=3)
    public Iterator<IPSDBPortletPart> getPSPortlets() {
        return this.psPortletList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5168\u90e8\u6570\u636e\u770b\u677f\u90e8\u4ef6\u96c6\u5408")
    public Iterator<IPSDBPortletPart> getAllPSPortlets() {
        if (this.allPSPortletList == null) {
            ArrayList<IPSDBPortletPart> list = new ArrayList<IPSDBPortletPart>();
            for (IPSDBPortletPart iPSDBPortletPart : this.psPortletList) {
                this.fillPSPortlets(iPSDBPortletPart, list);
            }
            this.allPSPortletList = list;
        }
        return this.allPSPortletList.iterator();
    }

    protected void fillPSPortlets(IPSDBPortletPart iPSDBPortletPart, ArrayList<IPSDBPortletPart> list) {
        IPSDBContainerPortletPart iPSDBContainerPortletPart;
        Iterator psDBPortletParts;
        list.add(iPSDBPortletPart);
        if (iPSDBPortletPart instanceof IPSDBContainerPortletPart && (psDBPortletParts = (iPSDBContainerPortletPart = (IPSDBContainerPortletPart)iPSDBPortletPart).getPSPortlets()) != null) {
            while (psDBPortletParts.hasNext()) {
                this.fillPSPortlets((IPSDBPortletPart)psDBPortletParts.next(), list);
            }
        }
    }

    @Override
    public void registerPSPortlet(IPSDBPortletPart iPSPortlet) throws Exception {
        this.psPortletList.add(iPSPortlet);
        this.portletList.add(iPSPortlet);
        iPSPortlet.setPSDashboardContainer(this);
    }

    @Override
    public String getModelScope() {
        return "VIEW";
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
        return this.strLayoutMode;
    }

    @Override
    @PSModelRTMeta(description="Flex\u5e03\u5c40\u65b9\u5411", codelist="FlexLayoutDir", dump=false)
    public String getFlexDir() {
        return this.strFlexDir;
    }

    @Override
    @PSModelRTMeta(description="Flex\u6a2a\u8f74\u5bf9\u9f50\u65b9\u5411", codelist="FlexAlign", dump=false)
    public String getFlexAlign() {
        return this.strFlexAlign;
    }

    @Override
    @PSModelRTMeta(description="Flex\u7eb5\u8f74\u5bf9\u9f50\u65b9\u5411", codelist="FlexVAlign", dump=false)
    public String getFlexVAlign() {
        return this.strFlexVAlign;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u770b\u677f\u6837\u5f0f", codelist="DashboardStyle")
    public String getDashboardStyle() {
        return this.strDashboardStyle;
    }

    @Override
    public String getModelType() {
        return "PSSYSDASHBOARD";
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }

    @Override
    @PSModelRTMeta(description="\u770b\u677f\u5e03\u5c40", child=true)
    public IPSLayout getPSLayout() {
        return this.iPSLayout;
    }

    @Override
    public String getCodeName() {
        if (this.getPSAppView() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_db", (Object)this.getPSAppView().getCodeName());
        }
        return super.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u770b\u677f\u5b9a\u5236")
    public boolean isEnableCustomized() {
        return this.bEnableCustomized;
    }

    @Override
    @PSModelRTMeta(description="\u770b\u677f\u5b9a\u5236\u6a21\u5f0f", ignoredumpvalues="0", codelist="CtrlCustomizeMode")
    public int getCustomizeMode() {
        return this.nCustomizeMode;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u52a8\u6001\u770b\u677f\u529f\u80fd", hideempty2=true, dumpref=true, from="IPSApplication", from_method="getPSAppUtil", origin="IPSAppDynaDashboardUtil")
    public IPSAppDynaDashboardUtil getPSAppDynaDashboardUtil() {
        return this.iPSAppDynaDashboardUtil;
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u770b\u677f\u5bfc\u822a\u680f", ignoredumpvalues="false")
    public boolean isShowDashboardNavBar() {
        return this.bShowDashboardNavBar;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408", hideempty2=true, child=true, dumpref=false, modelreftype="IGNOREDESIGN", dump=false)
    public Iterator<IPSControl> getPSControls() {
        return super.getPSControls();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u4f4d\u7f6e", codelist="FormNavBarPos")
    public String getNavBarPos() {
        if (this.isShowDashboardNavBar()) {
            return this.iPSDashboardParam.getNavBarPos();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u6837\u5f0f")
    public String getNavBarStyle() {
        if (this.isShowDashboardNavBar()) {
            return this.iPSDashboardParam.getNavBarStyle();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getNavBarWidth() {
        if (this.isShowDashboardNavBar() && this.iPSDashboardParam.getNavBarWidth() != null && this.iPSDashboardParam.getNavBarWidth() > 0.0) {
            return this.iPSDashboardParam.getNavBarWidth();
        }
        return 0.0;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getNavbarHeight() {
        if (this.isShowDashboardNavBar() && this.iPSDashboardParam.getNavBarHeight() != null && this.iPSDashboardParam.getNavBarHeight() > 0.0) {
            return this.iPSDashboardParam.getNavBarHeight();
        }
        return 0.0;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u680f\u6837\u5f0f\u8868")
    public IPSSysCss getNavBarPSSysCss() {
        if (this.isShowDashboardNavBar()) {
            return this.iNavBarPSSysCss;
        }
        return null;
    }
}

