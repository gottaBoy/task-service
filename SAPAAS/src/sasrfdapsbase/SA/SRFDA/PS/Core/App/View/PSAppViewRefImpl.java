/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlObject;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppViewRefImpl
extends PSObjectImpl
implements IPSAppViewRef {
    private static final Log log = LogFactory.getLog(PSAppViewRefImpl.class);
    public static final String EMBEDVIEWID = "EMBEDVIEWID";
    public static final String MINORPSDEVIEWBASEID = "MINORPSDEVIEWBASEID";
    public static final String TRYMODE = "TRYMODE";
    protected PSAppViewRef psAppViewRef = null;
    protected IPSAppView iPSAppView = null;
    protected IPSAppView refPSAppView = null;
    protected String strEmbedId = "";
    private JSONObject viewParam = null;
    private JSONObject parentModeJO = null;
    private JSONObject parentDataJO = null;
    private int nWidth = -1;
    private int nHeight = -1;
    private IPSLanguageRes titlePSLanguageRes = null;
    private String strRefModeDesc = null;
    private Object objOwner = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, Object objOwner, PSAppViewRef psAppViewRef) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.objOwner = objOwner;
            if (this.objOwner instanceof IPSControlContainer) {
                this.iPSAppView = ((IPSControlContainer)this.objOwner).getPSAppView();
            } else if (this.objOwner instanceof IPSControlObject) {
                IPSControlObject iPSControlObject = (IPSControlObject)this.objOwner;
                this.iPSAppView = iPSControlObject.getOwnedPSControl().getPSAppView();
            } else if (this.objOwner instanceof IPSControl) {
                IPSControl iPSControl = (IPSControl)this.objOwner;
                this.iPSAppView = iPSControl.getPSAppView();
            }
            this.psAppViewRef = psAppViewRef;
            this.setId(this.psAppViewRef.getPSAPPVIEWREFID());
            this.setName(this.psAppViewRef.getPSAPPVIEWREFNAME());
            this.setPSObjectData(this.psAppViewRef);
            this.strEmbedId = this.psAppViewRef.getParamStringValue(EMBEDVIEWID, "");
            this.strRefModeDesc = this.psAppViewRef.getREFMODETEXT();
            if (!this.psAppViewRef.isWIDTHNull()) {
                this.nWidth = this.psAppViewRef.getWIDTH();
            }
            if (!this.psAppViewRef.isHEIGHTNull()) {
                this.nHeight = this.psAppViewRef.getHEIGHT();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppViewRef.getTITLEPSLANRESID())) {
                this.titlePSLanguageRes = this.iPSAppView.getPSApplication().getPSLanguageRes(this.psAppViewRef.getTITLEPSLANRESID());
            }
            this.onInit();
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
        this.onFillViewParamJO();
        super.onInit();
    }

    protected void onFillViewParamJO() throws Exception {
        Properties viewParams;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppViewRef.getVIEWPARAMS()) && (viewParams = PropertiesHelper.load((String)this.psAppViewRef.getVIEWPARAMS())) != null) {
            for (Object objKey : viewParams.keySet()) {
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)viewParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                boolean bRawValue = true;
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    PSNavigateParamImpl PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                this.getViewParam(true).put(strKey.toLowerCase(), (Object)PropertiesHelper.getProperty((Properties)viewParams, (String)strKey));
            }
        }
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    @Override
    public String getRefPSAppViewId() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psAppViewRef.getMINORPSAPPVIEWID())) {
            return this.psAppViewRef.getMINORPSAPPVIEWID();
        }
        if (this.refPSAppView != null) {
            return this.refPSAppView.getId();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6253\u5f00\u6a21\u5f0f")
    public String getOpenMode() {
        return this.psAppViewRef.getOPENMODE();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe", dumpref=true)
    public IPSAppView getRefPSAppView() throws Exception {
        try {
            if (this.refPSAppView == null) {
                String strMinorPSDEViewId = this.psAppViewRef.getParamStringValue(MINORPSDEVIEWBASEID, null);
                boolean bTryMode = this.psAppViewRef.GetParamBoolValue(TRYMODE, false);
                this.refPSAppView = this.iPSAppView.getPSApplication().getPSAppView(this.getRefPSAppViewId(), strMinorPSDEViewId, bTryMode, this.iPSAppView);
                if (this.refPSAppView != null) {
                    String strOpenMode = this.refPSAppView.getOpenMode(this);
                    if (SA.SRFramework.Utility.StringHelper.Compare((String)strOpenMode, (String)"POPUP", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)strOpenMode, (String)"POPUPMODAL", (boolean)true) == 0) {
                        this.refPSAppView.markViewUsage(2, this);
                    } else {
                        this.refPSAppView.markViewUsage(1, this);
                    }
                }
            }
            return this.refPSAppView;
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u8ba1\u7b97\u5f15\u7528\u89c6\u56fe\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            throw ex;
        }
    }

    public void setRefPSAppView(IPSAppView refPSAppView) {
        this.refPSAppView = refPSAppView;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSAppView.getPSSysModelInstId();
    }

    @Override
    public String getEmbedId() {
        return this.strEmbedId;
    }

    public void setEmbedId(String strEmbedId) {
        this.strEmbedId = strEmbedId;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u9ad8\u5ea6", ignoredumpvalues="0;-1", outputdoc="(%1$s.getHeight() gt 0)")
    public int getHeight() {
        return this.nHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u5bbd\u5ea6", ignoredumpvalues="0;-1", outputdoc="(%1$s.getWidth() gt 0)")
    public int getWidth() {
        return this.nWidth;
    }

    @Override
    public synchronized JSONObject getViewParam(boolean bCreate) {
        if (this.viewParam == null && bCreate) {
            this.viewParam = new JSONObject();
        }
        return this.viewParam;
    }

    @Override
    public JSONObject getViewParam() {
        return this.getViewParam(false);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u6807\u9898")
    public String getRealTitle() throws Exception {
        if (this.getRefPSAppView() == null) {
            return "";
        }
        return this.getRefPSAppView().getTitle(this);
    }

    @Override
    public int getRealWidth(int nDefault) throws Exception {
        int nWidth = this.getWidth();
        if (this.getRefPSAppView() != null) {
            nWidth = this.getRefPSAppView().getWidth(this);
        }
        if (nWidth <= 0) {
            return nDefault;
        }
        return nWidth;
    }

    @Override
    public int getRealHeight(int nDefault) throws Exception {
        int nHeight = this.getHeight();
        if (this.getRefPSAppView() != null) {
            nHeight = this.getRefPSAppView().getHeight(this);
        }
        if (nHeight <= 0) {
            return nDefault;
        }
        return nHeight;
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u6253\u5f00\u6a21\u5f0f")
    public String getRealOpenMode() throws Exception {
        if (this.getRefPSAppView() == null) {
            return this.getOpenMode();
        }
        return this.getRefPSAppView().getOpenMode(this);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u89c6\u56fe\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getRealTitlePSLanguageRes() throws Exception {
        if (this.getRefPSAppView() == null) {
            return null;
        }
        return this.getRefPSAppView().getTitlePSLanguageRes(this);
    }

    @Override
    public String getRealTitleLanResTag() throws Exception {
        if (this.getRealTitlePSLanguageRes() != null) {
            return this.getRealTitlePSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public IPSLanguageRes getTitlePSLanguageRes() {
        return this.titlePSLanguageRes;
    }

    @Override
    public JSONObject getViewParamJO(boolean bCreate) {
        return this.getViewParam(bCreate);
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u53c2\u6570JO\u5bf9\u8c61")
    public JSONObject getViewParamJO() {
        return this.getViewParam();
    }

    @Override
    public JSONObject getParentModeJO(boolean bCreate) {
        if (this.parentModeJO == null && bCreate) {
            this.parentModeJO = new JSONObject();
        }
        return this.parentModeJO;
    }

    @Override
    public JSONObject getParentModeJO() {
        return this.getParentModeJO(false);
    }

    @Override
    public JSONObject getParentDataJO(boolean bCreate) {
        if (this.parentDataJO == null && bCreate) {
            this.parentDataJO = new JSONObject();
        }
        return this.parentDataJO;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u7236\u6570\u636e\u5bf9\u8c61", hideempty=true)
    public JSONObject getParentDataJO() {
        return this.getParentDataJO(false);
    }

    @Override
    public String getModelType() {
        if (this.getOwner() instanceof IPSModelObject) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s$%2$s", (Object)"PSAPPVIEWREF", (Object)((IPSModelObject)this.getOwner()).getModelType());
        }
        return "PSAPPVIEWREF";
    }

    @Override
    public String getModelId() {
        if (this.getOwner() instanceof IPSModelObject) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)((IPSModelObject)this.getOwner()).getModelId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u5f0f", order=100)
    public String getName() {
        return super.getName();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u6a21\u5f0f\u8bf4\u660e", order=110, dump=false)
    public String getRefModeDesc() {
        return this.strRefModeDesc;
    }

    @Override
    public String getModelName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getRefModeDesc())) {
            return super.getModelName();
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s[%2$s]", (Object)this.getRefModeDesc(), (Object)this.getName());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppView().getFullModelName(), (Object)this.getModelName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u8005", outputdoc="false")
    public Object getOwner() {
        return this.objOwner;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0")
    public String getUserTag() {
        return this.psAppViewRef.getUSERTAG();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02")
    public String getUserTag2() {
        return this.psAppViewRef.getUSERTAG2();
    }

    @Override
    public String getParamJOString() {
        return null;
    }

    @Override
    public String getContextJOString() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216, outputdoc="false")
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215, outputdoc="false")
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }
}

