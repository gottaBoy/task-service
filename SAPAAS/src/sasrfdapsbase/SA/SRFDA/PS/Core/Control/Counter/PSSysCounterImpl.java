/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Counter;

import SA.SRFDA.PS.Core.Control.Counter.IPSCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSCounterType;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterItem;
import SA.SRFDA.PS.Core.Control.Counter.PSSysCounterItemImpl;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.IPSXCodeObject;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.PSSFCodeObjectHelper;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysCounter;
import SA.SRFDA.PS.Data.PSSysCounterItem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysCounterImpl
extends PSSystemObjectImpl
implements IPSSysCounter {
    private static final Log log = LogFactory.getLog(PSSysCounterImpl.class);
    protected PSSysCounter psSysCounter = null;
    private String strCodeName = "";
    private IPSCounterType iPSCounterType = null;
    private Properties classOrPkgNameMap = null;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bSubSysCounter = false;
    private ArrayList<IPSSysCounterItem> psSysCounterItemList = new ArrayList();
    private int nTimer = 60000;
    private String strPSCounterId = null;
    private IPSCounter iPSCounter = null;
    private IPSDataEntity iPSDataEntity = null;
    private IPSDEAction iPSDEAction = null;
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSSysSFPlugin iPSSysSFPlugin = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private IPSXCodeObject iPSXCodeObject = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysCounter psSysCounter) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysCounter = psSysCounter;
            this.setId(this.psSysCounter.getPSSYSCOUNTERID());
            this.setName(this.psSysCounter.getPSSYSCOUNTERNAME());
            this.setPSObjectData(this.psSysCounter);
            this.iPSCounterType = this.getPSModelStorage().getPSCounterType(psSysCounter.getCOUNTERTYPE());
            this.strCodeName = this.psSysCounter.getCODENAME();
            this.classOrPkgNameMap = PropertiesHelper.load((String)this.psSysCounter.getBASECLSPARAMS());
            if (!this.psSysCounter.isRELOADTIMERNull()) {
                this.nTimer = this.psSysCounter.getRELOADTIMER();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCounter.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysCounter.getPSMODULEID());
            }
            if (this.iPSSystemModule != null) {
                this.bSubSysCounter = this.iPSSystemModule.isSubSysModule();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCounter.getPSDEID())) {
                this.iPSDataEntity = this.getPSSystem().getPSDataEntity2(this.psSysCounter.getPSDEID());
            }
            this.strPSCounterId = this.psSysCounter.getPSCOUNTERID();
            if (!StringHelper.isNullOrEmpty((String)psSysCounter.getCOUNTERPARAMS())) {
                Properties properties = PropertiesHelper.load((String)psSysCounter.getCOUNTERPARAMS());
                this.onPreparePSUIActionParams(properties);
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCounter.getPSSYSSFPLUGINID())) {
                this.iPSSysSFPlugin = this.getPSSystem().getPSSysSFPlugin(this.psSysCounter.getPSSYSSFPLUGINID());
            }
            if (this.getPSSysSFPlugin() != null) {
                String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
                IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
                if (iPSSysSFPluginTempl != null) {
                    this.iPSXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysCounter.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = this.getPSSystem().getPSSysPFPlugin(this.psSysCounter.getPSSYSPFPLUGINID());
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
        if (!StringHelper.isNullOrEmpty((String)this.strPSCounterId)) {
            this.iPSCounter = this.getPSModelStorage().getPSCounter(this.strPSCounterId);
        }
        super.onInit();
    }

    protected void onPreparePSUIActionParams(Properties uiactionParams) throws Exception {
        if (uiactionParams != null) {
            for (Object objKey : uiactionParams.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                boolean bRawValue;
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)uiactionParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
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
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                bRawValue = true;
                if (!StringHelper.isNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag.toLowerCase(), strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag.toLowerCase(), PSNavigateParamImpl2);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u7c7b\u578b", codelist="CounterType", fields={"COUNTERTYPE"})
    public String getCounterType() {
        return this.iPSCounterType.getId();
    }

    @Override
    public IPSCounterType getPSCounterType() {
        return this.iPSCounterType;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    public String getBaseClass(String strPSSFStyleId) throws Exception {
        String strBaseClass = PropertiesHelper.getProperty((Properties)this.classOrPkgNameMap, (String)strPSSFStyleId);
        if (StringHelper.isNullOrEmpty((String)strBaseClass) && this.classOrPkgNameMap != null) {
            for (Object objKey : this.classOrPkgNameMap.keySet()) {
                String strKey = (String)objKey;
                if (strPSSFStyleId.indexOf(strKey) != 0) continue;
                strBaseClass = PropertiesHelper.getProperty((Properties)this.classOrPkgNameMap, (String)strKey);
                break;
            }
        }
        if (!StringHelper.isNullOrEmpty((String)strBaseClass)) {
            strBaseClass = strBaseClass.trim();
        }
        if (!StringHelper.isNullOrEmpty((String)strBaseClass)) {
            return strBaseClass;
        }
        return this.getPSCounterType().getBaseClass(strPSSFStyleId);
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u95f4\u9694\uff08ms\uff09", ignoredumpvalues="0;-1", fields={"RELOADTIMER"})
    public int getTimer() {
        return this.nTimer;
    }

    @Override
    public boolean getRefFlag() {
        return true;
    }

    @Override
    public String getClassOrPkgName(String strCodeType, IPSSysSFPub iPSSysSFPub) throws Exception {
        String strPKGName = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, this.classOrPkgNameMap, "PKG", iPSSysSFPub);
        String strNameFormat = PSSFCodeObjectHelper.getClassOrPkgName(this, this.iPSSystemModule, this.classOrPkgNameMap, strCodeType, iPSSysSFPub);
        if (StringHelper.isNullOrEmpty((String)strNameFormat)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u8ba1\u6570\u5668[%1$s]\u4ee3\u7801\u7c7b\u578b[%2$s]\u4ee3\u7801\u540d\u79f0"));
        }
        if (StringHelper.isNullOrEmpty((String)strPKGName)) {
            strPKGName = iPSSysSFPub.getPKGCodeName();
        }
        String strModuleName = "";
        if (this.getPSSystemModule() != null) {
            strModuleName = this.getPSSystemModule().getCodeName();
        }
        if (iPSSysSFPub.getPSSFStyle().getPSSF().isPkgLowercase()) {
            strModuleName = strModuleName.toLowerCase();
        }
        return StringHelper.format((String)strNameFormat, (Object)strPKGName, (Object)strModuleName, (Object)this.getCodeName());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, ignorepf=true)
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    public boolean isSubSysCounter() {
        return this.bSubSysCounter;
    }

    @Override
    public String getModelType() {
        return "PSSYSCOUNTER";
    }

    protected IPSSysCounterItem registerPSSysCounterItem(PSSysCounterItem psSysCounterItem) throws Exception {
        PSSysCounterItemImpl iPSSysCounterItem = new PSSysCounterItemImpl();
        iPSSysCounterItem.init(this.getDAGlobalHelper(), this, psSysCounterItem);
        this.psSysCounterItemList.add(iPSSysCounterItem);
        return iPSSysCounterItem;
    }

    protected void resetPSSysCounterItems() {
        this.psSysCounterItemList.clear();
    }

    @Override
    public Iterator<IPSSysCounterItem> getPSSysCounterItems() {
        if (this.psSysCounterItemList == null || this.psSysCounterItemList.size() == 0) {
            return null;
        }
        return this.psSysCounterItemList.iterator();
    }

    @Override
    public IPSCounter getPSCounter() {
        return this.iPSCounter;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u670d\u52a1\u53d1\u5e03\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        if (this.getPSSystemModule() != null) {
            return this.getPSSystemModule().getPSSysSFPub();
        }
        return this.getPSSystem().getDefaultPSSysSFPub();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true, fields={"PSDEID"})
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u884c\u4e3a\u5bf9\u8c61", hideempty=true, from="IPSDataEntity", dumpref=true, ignorepf=true, ignorert=3, fields={"PSDEACTIONID"})
    public IPSDEAction getPSDEAction() throws Exception {
        if (this.iPSDEAction != null) {
            return this.iPSDEAction;
        }
        if (this.getPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.psSysCounter.getPSDEACTIONID())) {
            this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psSysCounter.getPSDEACTIONID());
        }
        return this.iPSDEAction;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6\u5bf9\u8c61", hideempty=true, from="IPSDataEntity", dumpref=true, ignorepf=true, fields={"PSDEDATASETID"})
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (this.iPSDEDataSet != null) {
            return this.iPSDEDataSet;
        }
        if (this.getPSDataEntity() != null && !StringHelper.isNullOrEmpty((String)this.psSysCounter.getPSDEDATASETID())) {
            this.iPSDEDataSet = this.getPSDataEntity().getPSDEDataSet(this.psSysCounter.getPSDEDATASETID());
        }
        return this.iPSDEDataSet;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u67e5\u8be2\u6761\u4ef6", hideempty2=true, fields={"CUSTOMCOND"})
    public String getCustomCond() {
        if (!StringHelper.isNullOrEmpty((String)this.psSysCounter.getPSDEDATASETID())) {
            return this.psSysCounter.getCUSTOMCOND();
        }
        return "";
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSXCodeObject getRender() {
        return this.iPSXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6570\u636e", hideempty2=true, fields={"COUNTERDATA"})
    public String getCounterData() {
        return this.psSysCounter.getCOUNTERDATA();
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6570\u636e2", hideempty2=true, fields={"COUNTERDATA2"})
    public String getCounterData2() {
        return this.psSysCounter.getCOUNTERDATA2();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6a21\u677f\u63d2\u4ef6\u5bf9\u8c61", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.iPSSysSFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u8ba1\u6570\u5668\u6807\u8bc6", hideempty2=true)
    public String getPSCounterId() {
        return this.strPSCounterId;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u5668\u6807\u8bb0")
    public String getUniqueTag() {
        if (this.getPSSystemModule() != null) {
            if (this.getPSSystemModule().getPSSysModelGroup() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            if (this.getPSSystemModule().getPSSysRef() != null) {
                return String.format("%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName());
            }
            return String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
        }
        return this.getCodeName();
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
}

