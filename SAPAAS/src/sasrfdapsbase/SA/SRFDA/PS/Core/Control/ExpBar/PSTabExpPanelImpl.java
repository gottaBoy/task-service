/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPage;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPanel;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSTabExpPanelParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlContainerImpl;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDETabViewPanel;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDETabViewPanelRuntime;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"TABEXPPANEL"})
public class PSTabExpPanelImpl
extends PSControlContainerImpl
implements IPSTabExpPanel {
    private static final Log log = LogFactory.getLog(PSTabExpPanelImpl.class);
    private IPSTabExpPanelParam iPSTabExpPanelParam = null;
    private ArrayList<IPSTabExpPage> psTabExpPageList = new ArrayList();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.iPSTabExpPanelParam = (IPSTabExpPanelParam)iPSControlParam;
            this.setId(String.valueOf(iPSControlContainer.getPSAppView().getId()) + "_" + strName);
            this.setName(strName);
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
    protected String onGetControlType() {
        return "TABEXPPANEL";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    protected IPSControlParam onGetPSControlParam() {
        return this.iPSTabExpPanelParam;
    }

    @Override
    public String getModelScope() {
        return "VIEW";
    }

    @Override
    public String getModelType() {
        return "PSTABEXPPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u9762\u677f\u5e03\u5c40", codelist="TabViewTabPos")
    public String getTabLayout() {
        return this.iPSTabExpPanelParam.getTabLayout();
    }

    @Override
    public IPSControl registerPSControl(String strKey, String strPSCtrlType, IPSControlParam iPSControlParam) throws Exception {
        IPSControl iPSControl = super.registerPSControl(strKey, strPSCtrlType, iPSControlParam);
        if (iPSControl instanceof IPSTabExpPage) {
            IPSTabExpPage iPSTabExpPage = (IPSTabExpPage)iPSControl;
            this.psTabExpPageList.add(iPSTabExpPage);
            if (iPSTabExpPage instanceof IPSDETabViewPanel) {
                IPSDETabViewPanel iPSDETabViewPanel = (IPSDETabViewPanel)iPSControl;
                if (iPSDETabViewPanel instanceof IPSDETabViewPanelRuntime) {
                    ((IPSDETabViewPanelRuntime)((Object)iPSDETabViewPanel)).setIndex(this.psTabExpPageList.size() - 1);
                }
                String strViewRefMode = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s:%2$s", (Object)"EXPITEM", (Object)iPSControl.getName());
                PSAppViewRef psAppViewRef = new PSAppViewRef();
                psAppViewRef.setPSAPPVIEWREFNAME(strViewRefMode);
                psAppViewRef.setREFMODETEXT(SA.SRFramework.Utility.StringHelper.Format((String)"[%1$s]\u5bfc\u822a\u89c6\u56fe", (Object)iPSTabExpPage.getCaption()));
                psAppViewRef.setMINORPSAPPVIEWID(iPSDETabViewPanel.getPSAppDEView().getId());
                psAppViewRef.setParamValue("EMBEDVIEWID", iPSDETabViewPanel.getEmbedViewId());
                IPSAppViewRef ipsAppViewRef = this.registerPSAppViewRef(psAppViewRef);
                if (iPSDETabViewPanel.getNavPSDER() != null && iPSDETabViewPanel.getNavPSDER() instanceof IPSDER1N) {
                    IPSDER1N iPSDER1N = (IPSDER1N)iPSDETabViewPanel.getNavPSDER();
                    JSONObject parentDataJO = ipsAppViewRef.getParentDataJO(true);
                    parentDataJO.put("srfparentmode", (Object)iPSDER1N.getName());
                    parentDataJO.put("srfparentdename", (Object)iPSDER1N.getMajorDEName());
                    parentDataJO.put("srfparentdefname", (Object)iPSDER1N.getPickupDEFName());
                }
            }
        }
        return iPSControl;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u9762\u677f\u5206\u9875\u96c6\u5408", dumpref=true, child=true, modelreftype="LINK", group="\u90e8\u4ef6\u5143\u7d20", order=170)
    public Iterator<IPSTabExpPage> getPSTabExpPages() {
        if (this.psTabExpPageList == null || this.psTabExpPageList.size() == 0) {
            return null;
        }
        return this.psTabExpPageList.iterator();
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u552f\u4e00\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSAppView() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getName())) {
            return String.format("%1$s__%2$s", this.getPSAppView().getCodeName(), this.getName());
        }
        return null;
    }
}

