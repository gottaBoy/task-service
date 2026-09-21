/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEMultiEditViewPanel;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEMultiEditViewPanelParam;
import SA.SRFDA.PS.Core.Control.Grid.PSDEGridImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"MULTIEDITVIEWPANEL"})
public class PSDEMultiEditViewPanelImpl
extends PSDEGridImpl
implements IPSDEMultiEditViewPanel {
    private static final Log log = LogFactory.getLog(PSDEMultiEditViewPanelImpl.class);
    protected IPSDEMultiEditViewPanelParam iPSDEMultiEditViewPanelParam = null;
    private IPSAppDEView iPSAppDEView = null;
    private String strEmbedViewId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.setName(strName);
            if (iPSControlParam != null) {
                this.iPSDEMultiEditViewPanelParam = (IPSDEMultiEditViewPanelParam)iPSControlParam;
            }
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
        super.onInit();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDEMultiEditViewPanelParam.getPSDEViewId())) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)this.iPSDEMultiEditViewPanelParam.getPSDEViewId());
            this.iPSAppDEView = (IPSAppDEView)this.getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, this.iPSDEMultiEditViewPanelParam.getPSDEViewId(), this.getPSAppView());
            this.iPSAppDEView.markViewUsage(4, this);
            this.strEmbedViewId = this.getPSAppView().generateViewUniId();
        }
    }

    @Override
    protected String onGetControlType() {
        return "MULTIEDITVIEWPANEL";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.getPSAppDEView() != null) {
            relatedAppViewList.add(this.getPSAppDEView());
        }
    }

    @Override
    @Deprecated
    public IPSAppDEView getPSAppDEView() {
        return this.iPSAppDEView;
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    public String getEmbeddedViewId() {
        return this.strEmbedViewId;
    }

    @Deprecated
    public String getEmbedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getEmbedViewId())) {
            return;
        }
        IPSAppDEView refPSAppView = this.getPSAppDEView();
        PSAppViewRefImpl psAppViewRefImpl = new PSAppViewRefImpl();
        PSAppViewRef psAppViewRef = new PSAppViewRef();
        psAppViewRefImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), psAppViewRef);
        psAppViewRefImpl.setRefPSAppView(refPSAppView);
        String strFullViewId = "";
        strFullViewId = SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strContainerId) ? this.getEmbedViewId() : SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)strContainerId, (Object)this.getEmbedViewId());
        psAppViewRefImpl.setEmbedId(strFullViewId);
        embeddedPSAppViewRefList.add(psAppViewRefImpl);
        Iterator<IPSAppViewRef> childPSAppViewRefs = refPSAppView.getEmbeddedPSAppViewRefs(strFullViewId);
        if (childPSAppViewRefs != null) {
            while (childPSAppViewRefs.hasNext()) {
                embeddedPSAppViewRefList.add(childPSAppViewRefs.next());
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u9762\u677f\u6837\u5f0f", model="PSDEViewCtrl", fields={"CTRLPARAM"})
    public String getPanelStyle() {
        return this.iPSDEMultiEditViewPanelParam.getPanelStyle();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u90e8\u4ef6\u53c2\u6570")
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.iPSDEMultiEditViewPanelParam;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u5e94\u7528\u89c6\u56fe", dumpref=true, model="PSDEViewCtrl", fields={"PSDEVIEWID"})
    public IPSAppView getEmbeddedPSAppView() {
        return this.iPSAppDEView;
    }
}

