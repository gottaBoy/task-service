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
package SA.SRFDA.PS.Core.Control.ViewPanel;

import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.App.View.PSAppViewRefImpl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlMDataContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSControlImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanel;
import SA.SRFDA.PS.Core.Control.ViewPanel.IPSDEViewPanelParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"VIEWPANEL"})
public class PSDEViewPanelImpl
extends PSControlImpl
implements IPSDEViewPanel {
    private static final Log log = LogFactory.getLog(PSDEViewPanelImpl.class);
    protected IPSDEViewPanelParam iPSDEViewPanelParam = null;
    private IPSAppDEView iPSAppDEView = null;
    private String strEmbedViewId = null;
    private String strCaption = "\u6807\u9898";
    private IPSLanguageRes capPSLanguageRes = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private static ThreadLocal<Boolean> embeddedPSAppDEViewMustLinkThreadLocal = new ThreadLocal();

    public static void setEmbeddedPSAppDEViewMustLink(boolean value) {
        embeddedPSAppDEViewMustLinkThreadLocal.set(value);
    }

    public static boolean isEmbeddedPSAppDEViewMustLink() {
        Boolean value = embeddedPSAppDEViewMustLinkThreadLocal.get();
        return value != null && value != false;
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            this.setName(strName);
            if (iPSControlParam != null) {
                this.iPSDEViewPanelParam = (IPSDEViewPanelParam)iPSControlParam;
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
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDEViewPanelParam.getPSDEViewId())) {
            String strPSAppViewId = Helper.GenUniqueId((String)this.getPSAppView().getPSApplication().getId(), (String)this.iPSDEViewPanelParam.getPSDEViewId());
            this.iPSAppDEView = (IPSAppDEView)this.getPSAppView().getPSApplication().getPSAppView(strPSAppViewId, this.iPSDEViewPanelParam.getPSDEViewId(), this.getPSAppView());
            this.strEmbedViewId = this.getPSAppView().generateViewUniId();
            this.iPSAppDEView.markViewUsage(4, this);
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.iPSDEViewPanelParam.getCapPSLanguageResId())) {
            this.capPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.iPSDEViewPanelParam.getCapPSLanguageResId());
        }
        this.strCaption = this.iPSDEViewPanelParam.getCaption();
        if (this.getPSAppDEView() == null) {
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u89c6\u56fe[%1$s]\u90e8\u4ef6[%2$s]\u6ca1\u6709\u6307\u5b9a\u5d4c\u5165\u89c6\u56fe", (Object)this.getPSAppView().getName(), (Object)this.getName()));
        }
        this.onPreparePSNavViewParams();
    }

    protected void onPreparePSNavViewParams() throws Exception {
        Iterator<String> names;
        if (this.iPSDEViewPanelParam != null && (names = this.iPSDEViewPanelParam.getCtrlParamNames()) != null) {
            while (names.hasNext()) {
                boolean bRawValue;
                String strKey = names.next();
                String strValue = this.iPSDEViewPanelParam.getCtrlParam(strKey, "");
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") != 0) continue;
                bRawValue = true;
                strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
            }
        }
    }

    @Override
    protected String onGetControlType() {
        return "VIEWPANEL";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
        if (this.getPSAppDEView() != null) {
            relatedAppViewList.add(this.getPSAppDEView());
        }
    }

    @Override
    public IPSAppDEView getPSAppDEView() {
        return this.iPSAppDEView;
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
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
    @PSModelRTMeta(description="\u6807\u9898", model="PSDEViewCtrl", fields={"CAPTION"})
    public String getCaption() {
        return this.strCaption;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90\u5bf9\u8c61", model="PSDEViewCtrl", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    public String getModelType() {
        return "PSVIEWPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u89c6\u56fe\u6807\u8bc6", dump=false)
    public String getEmbeddedViewId() {
        return this.strEmbedViewId;
    }

    @Override
    @PSModelRTMeta(description="\u5d4c\u5165\u89c6\u56fe\u5bf9\u8c61", dumpref=true, model="PSDEViewCtrl", fields={"PSDEVIEWID"})
    public IPSAppDEView getEmbeddedPSAppDEView() {
        return this.iPSAppDEView;
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        if (this.getEmbeddedPSAppDEView() instanceof IPSControlMDataContainer) {
            return ((IPSControlMDataContainer)((Object)this.getEmbeddedPSAppDEView())).getADPSDEDQConditions();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    protected boolean isExportModelAlways() {
        return true;
    }
}

