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
package SA.SRFDA.PS.Core.DataEntity.DR;

import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSDEDRItem;
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

@PSModelPFIgnoreMeta
public class PSDEDRItemImpl
extends PSDataEntityObjectImpl
implements IPSDEDRItem,
IPSModelSortable {
    private static final Log log = LogFactory.getLog(PSDEDRItemImpl.class);
    private PSDEDRItem psDEDRItem = null;
    private String strCaption = "";
    private IPSSysImage iPSSysImage = null;
    private String strCounterId = null;
    private String strEnableMode = null;
    private IPSDEAction testPSDEAction = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private IPSDELogic testPSDELogic = null;
    private IPSSysUniRes testPSSysUniRes = null;
    private String strTestScriptCode = null;
    private JSONObject viewParamJO = new JSONObject();
    private IPSLanguageRes capPSLanguageRes = null;
    private JSONObject parentDataJO = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private IPSDEDRGroup iPSDEDRGroup = null;
    private IPSDataEntity viewPSDataEntity = null;
    private int nCounterMode = 0;
    private IPSSysPFPlugin headerPSSysPFPlugin = null;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, PSDEDRItem psDEDRItem) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEDRItemData(psDEDRItem);
            this.setPSDataEntity(iPSDataEntity);
            this.setId(this.psDEDRItem.getPSDEDRITEMID());
            this.setName(this.psDEDRItem.getPSDEDRITEMNAME());
            this.setPSObjectData(this.psDEDRItem);
            this.strCaption = this.psDEDRItem.getPSDEDRITEMNAME();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getCOUNTERID())) {
                this.strCounterId = this.psDEDRItem.getCOUNTERID();
            }
            if (!this.psDEDRItem.isCOUNTERMODENull()) {
                this.nCounterMode = this.psDEDRItem.getCOUNTERMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getENABLEMODE())) {
                this.strEnableMode = this.psDEDRItem.getENABLEMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getEnableMode())) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getEnableMode(), (String)"CUSTOM", (boolean)true) == 0) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getTESTPSDEACTIONID())) throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u5224\u65ad\u884c\u4e3a");
                    this.testPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEDRItem.getTESTPSDEACTIONID());
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getEnableMode(), (String)"DEOPPRIV", (boolean)true) == 0) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getPSDEOPPRIVID())) throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u5224\u65ad\u64cd\u4f5c\u6807\u8bc6");
                    this.iPSDEOPPriv = this.getPSDataEntity().getPSDEOPPriv(this.psDEDRItem.getPSDEOPPRIVID());
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getEnableMode(), (String)"DELOGIC", (boolean)true) == 0) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getTESTPSDELOGICID())) throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u5224\u65ad\u903b\u8f91");
                    this.testPSDELogic = this.getPSDataEntity().getPSDELogic(this.psDEDRItem.getTESTPSDELOGICID());
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getEnableMode(), (String)"SCRIPT", (boolean)true) == 0) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getTESTCUSTOMCODE())) throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u5224\u65ad\u811a\u672c");
                    this.strTestScriptCode = this.psDEDRItem.getTESTCUSTOMCODE();
                }
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getEnableMode(), (String)"UNIRES", (boolean)true) == 0) {
                    if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getPSSYSUNIRESID())) throw new Exception("\u672a\u6307\u5b9a\u542f\u7528\u7edf\u4e00\u8d44\u6e90");
                    this.testPSSysUniRes = this.getPSSystem().getPSSysUniRes(this.psDEDRItem.getPSSYSUNIRESID());
                }
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEDRItem.getCAPPSLANRESID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEDRGroupId())) {
                this.iPSDEDRGroup = this.getPSDataEntity().getPSDEDRGroup(this.getPSDEDRGroupId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getHEADERPSSYSPFPLUGINID())) {
                this.headerPSSysPFPlugin = this.getPSDataEntity().getPSSystem().getPSSysPFPlugin(this.psDEDRItem.getHEADERPSSYSPFPLUGINID());
            }
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getPSSYSIMAGEID())) {
            this.iPSSysImage = this.getPSDataEntity().getPSSystem().getPSSysImage(this.psDEDRItem.getPSSYSIMAGEID());
        }
        this.onFillViewParamJO(this.viewParamJO);
        super.onInit();
    }

    protected void onFillViewParamJO(JSONObject viewParamJO) throws Exception {
        Properties properties;
        String strViewParams = this.psDEDRItem.getVIEWPARAMS();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strViewParams) && (properties = PropertiesHelper.load((String)strViewParams)) != null) {
            for (Object objKey : properties.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                String strKey = (String)objKey;
                String strValue = PropertiesHelper.getProperty((Properties)properties, (String)strKey);
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
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag.toLowerCase(), strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag.toLowerCase(), PSNavigateParamImpl2);
                strKey = strKey.toUpperCase();
                if (viewParamJO.has(strKey)) continue;
                viewParamJO.put(strKey, (Object)PropertiesHelper.getProperty((Properties)properties, (String)((String)objKey), (String)""));
            }
        }
    }

    @Override
    public String getCaption(String strLanguage) {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCaption)) {
            return this.onGetCaption();
        }
        return this.strCaption;
    }

    protected String onGetCaption() {
        return "";
    }

    public PSDEDRItem getPSDEDRItemData() {
        return this.psDEDRItem;
    }

    protected void setPSDEDRItemData(PSDEDRItem psDEDRItem) {
        this.psDEDRItem = psDEDRItem;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u9879\u7c7b\u578b", codelist="DEDRItemType", fields={"DRITEMTYPE"})
    public String getItemType() {
        return this.getPSDEDRItemData().getDRITEMTYPE();
    }

    @Override
    public String getPSDEDRGroupId() {
        return this.getPSDEDRItemData().getPSDEDRGROUPID();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u5173\u7cfb\u5206\u7ec4", fields={"PSDEDRGROUPID"})
    public IPSDEDRGroup getPSDEDRGroup() {
        return this.iPSDEDRGroup;
    }

    @Override
    public String getPSDEViewId() {
        return this.getPSDEDRItemData().getPSDEVIEWBASEID();
    }

    @Override
    @PSModelRTMeta(description="\u9879\u56fe\u6807\u8d44\u6e90\u5bf9\u8c61", fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u6a21\u5f0f", codelist="DEDRDetailEnableMode", fields={"ENABLEMODE"})
    public String getEnableMode() {
        return this.strEnableMode;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u9879\u6807\u8bc6", fields={"COUNTERID"})
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6a21\u5f0f", codelist="DETreeNodeCounterMode", ignoredumpvalues="0", fields={"COUNTERMODE"})
    public int getCounterMode() {
        return this.nCounterMode;
    }

    @Override
    @PSModelRTMeta(description="\u5224\u65ad\u8f93\u51fa\u5b9e\u4f53\u884c\u4e3a")
    public IPSDEAction getTestPSDEAction() {
        return this.testPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5224\u65ad\u8f93\u51fa\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", ignorepf=true, fields={"PSDEOPPRIVID"})
    public IPSDEOPPriv getTestPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    public String getModelType() {
        return "PSDEDRITEM";
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u53c2\u6570\u5bf9\u8c61")
    public JSONObject getViewParamJO() {
        return this.viewParamJO;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
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

    protected void fillParentDataJO(IPSDERBase iPSDERBase) throws Exception {
        JSONObject parentDataJO = this.getParentDataJO(true);
        this.onFillViewParamJO(parentDataJO);
        if (!parentDataJO.has("srfparentdename") && !parentDataJO.has("SRFPARENTDENAME")) {
            if (iPSDERBase != null && iPSDERBase instanceof IPSDER1N) {
                parentDataJO.put("srfparentdename", (Object)((IPSDER1N)iPSDERBase).getMajorDEName());
            } else {
                parentDataJO.put("srfparentdename", (Object)this.getPSDataEntity().getName());
            }
        }
        if (iPSDERBase != null) {
            if (!parentDataJO.has("srfparentmode") && !parentDataJO.has("SRFPARENTMODE")) {
                parentDataJO.put("srfparentmode", (Object)iPSDERBase.getName());
            }
            if (iPSDERBase instanceof IPSDER1N && !parentDataJO.has("srfparentdefname") && !parentDataJO.has("SRFPARENTDEFNAME")) {
                parentDataJO.put("srfparentdefname", (Object)((IPSDER1N)iPSDERBase).getPickupDEFName());
            }
        }
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDataEntity().getModelId(), (Object)this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.psDEDRItem.getCODENAME();
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
    @PSModelRTMeta(description="\u89c6\u56fe\u76f8\u5173\u5b9e\u4f53", dumpref=true, fields={"VIEWPSDEID"})
    public IPSDataEntity getViewPSDataEntity() throws Exception {
        if (this.viewPSDataEntity == null) {
            this.viewPSDataEntity = !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEDRItem.getVIEWPSDEID()) ? this.getPSSystem().getPSDataEntity2(this.psDEDRItem.getVIEWPSDEID()) : this.onGetViewPSDataEntity();
        }
        return this.viewPSDataEntity;
    }

    protected IPSDataEntity onGetViewPSDataEntity() throws Exception {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u4ee3\u7801\u6807\u8bc6", fields={"VIEWCODENAME"})
    public String getViewCodeName() {
        return this.psDEDRItem.getVIEWCODENAME();
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u5904\u7406\u903b\u8f91", dumpref=true, ignorepf=true, fields={"TESTPSDELOGICID"}, from="IPSDataEntity")
    public IPSDELogic getTestPSDELogic() {
        return this.testPSDELogic;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5224\u65ad\u811a\u672c", fields={"TESTCUSTOMCODE"})
    public String getTestScriptCode() {
        return this.strTestScriptCode;
    }

    @Override
    @PSModelRTMeta(description="\u5934\u90e8\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getHeaderPSSysPFPlugin() {
        return this.headerPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7edf\u4e00\u8d44\u6e90", fields={"PSSYSUNIRESID"})
    public IPSSysUniRes getTestPSSysUniRes() {
        return this.testPSSysUniRes;
    }
}

