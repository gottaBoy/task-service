/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.core.IDEDataQuery
 *  net.ibizsys.paas.core.IDEDataSetGroupParam
 *  net.ibizsys.paas.core.IDEDataSetQuery
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.Service;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERAggData;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetCode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetGroupParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetInput;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetParam;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSetReturn;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.Service.IPSDEDataSetMethod;
import SA.SRFDA.PS.Core.DataEntity.Service.PSDEMethodImplBase;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.Res.IPSSysUniState;
import SA.SRFDA.PS.Core.SF.IPSSFXCodeObject;
import SA.SRFDA.PS.Core.SF.PSSFXCodeObjectProxy;
import SA.SRFDA.PS.Core.Security.IPSSysUserDR;
import SA.SRFDA.PS.Core.Service.IPSRESTfulAPI;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEMethod;
import SA.SRFDA.PS.Data.PSDEDataSet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataSetGroupParam;
import net.ibizsys.paas.core.IDEDataSetQuery;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelIgnoreMeta
public class PSDEDataSetMethodImpl
extends PSDEMethodImplBase
implements IPSDEDataSetMethod {
    private static final Log log = LogFactory.getLog(PSDEDataSetMethodImpl.class);
    private IPSDEDataSet iPSDEDataSet = null;
    private IPSSFXCodeObject iPSSFXCodeObject = null;
    private IPSDER1N iPSDER1N = null;
    private String strParentKeyMode = null;
    private String strCodeName = null;
    private IPSDEField pickupPSDEField = null;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataSet iPSDEDataSet) throws Exception {
        this.init(iDAGlobalHelper, iPSDEDataSet, null, null, null);
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEDataSet iPSDEDataSet, IPSDER1N iPSDER1N, IPSDEField pickupPSDEField, String strParentKeyMode) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEDataSet(iPSDEDataSet);
            if (this.getDAGlobalHelper() == null || this.getPSDEDataSet() == null) {
                throw new Exception("\u4f20\u5165\u53c2\u6570\u65e0\u6548");
            }
            this.setPSDataEntity(this.getPSDEDataSet().getPSDataEntity());
            this.setPSDER1N(iPSDER1N);
            if (this.getPSDER1N() == null) {
                this.setId(this.getPSDEDataSet().getId());
                this.setName(this.getPSDEDataSet().getName());
                this.strCodeName = StringHelper.format((String)"Fetch%1$s", (Object)this.getPSDEDataSet().getCodeName());
            } else {
                this.strParentKeyMode = strParentKeyMode;
                this.pickupPSDEField = pickupPSDEField;
                if (StringHelper.isNullOrEmpty((String)this.getParentKeyMode()) || this.getPickupPSDEField() == null) {
                    throw new Exception("\u4f20\u5165\u53c2\u6570\u65e0\u6548");
                }
                this.setId(KeyValueHelper.genUniqueId((String)this.getPSDEDataSet().getId(), (String)this.getPSDER1N().getId(), (String)this.getParentKeyMode()));
                if (StringHelper.compare((String)this.getParentKeyMode(), (String)"DEFAULT", (boolean)true) == 0) {
                    this.setName(StringHelper.format((String)"%1$s_BY_%2$s", (Object)this.getPSDEDataSet().getName(), (Object)this.getPickupPSDEField().getName()));
                    this.strCodeName = StringHelper.format((String)"Fetch%1$sBy%2$s", (Object)this.getPSDEDataSet().getCodeName(), (Object)this.getPickupPSDEField().getCodeName());
                } else if (StringHelper.compare((String)this.getParentKeyMode(), (String)"CHILDOF", (boolean)true) == 0) {
                    this.setName(StringHelper.format((String)"%1$s_CHILDOF_%2$s", (Object)this.getPSDEDataSet().getName(), (Object)this.getPickupPSDEField().getName()));
                    this.strCodeName = StringHelper.format((String)"Fetch%1$sChildOf%2$s", (Object)this.getPSDEDataSet().getCodeName(), (Object)this.getPickupPSDEField().getCodeName());
                } else {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7236\u503c\u5904\u7406\u6a21\u5f0f[%1$s]", (Object)this.getParentKeyMode()));
                }
            }
            this.onInit();
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
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSDEDataSet().getPSSysSFPlugin() != null) {
            String strPSSysSFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSDEDataSet().getPSSysSFPlugin().getId(), (String)this.getPSSystem().getPSSFId());
            IPSSysSFPluginTempl iPSSysSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, true);
            if (iPSSysSFPluginTempl != null) {
                this.iPSSFXCodeObject = new PSSFXCodeObjectProxy(iPSSysSFPluginTempl, this);
            }
        }
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u65b9\u6cd5\u7c7b\u578b", codelist="DESADetailType")
    public String getMethodType() {
        return "DEACTION";
    }

    @Override
    public String getModelType() {
        return "PSDEDATASETMETHOD";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u6269\u5c55\u7ed8\u5236\u5668", hideempty=true)
    public IPSSFXCodeObject getRender() {
        return this.iPSSFXCodeObject;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u96c6")
    public IPSDEDataSet getPSDEDataSet() {
        return this.iPSDEDataSet;
    }

    protected void setPSDEDataSet(IPSDEDataSet iPSDEDataSet) {
        this.iPSDEDataSet = iPSDEDataSet;
    }

    @Override
    protected IPSModelObject getProxyPSModelObject() {
        return this.getPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5173\u7cfb")
    public IPSDER1N getPSDER1N() {
        return this.iPSDER1N;
    }

    protected void setPSDER1N(IPSDER1N iPSDER1N) {
        this.iPSDER1N = iPSDER1N;
    }

    @Override
    @PSModelRTMeta(description="\u7236\u503c\u5904\u7406\u6a21\u5f0f", hideempty=true)
    public String getParentKeyMode() {
        return this.strParentKeyMode;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u62fe\u53d6\u5c5e\u6027", hideempty=true)
    public IPSDEField getPickupPSDEField() {
        return this.pickupPSDEField;
    }

    @Override
    public IPSDEDataSetCode getPSDEDataSetCode(String strDBType) throws Exception {
        return this.getPSDEDataSet().getPSDEDataSetCode(strDBType);
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u67e5\u8be2\u96c6\u5408", hideempty2=true)
    public Iterator<IPSDEDataQuery> getPSDEDataQueries() {
        return this.getPSDEDataSet().getPSDEDataQueries();
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getPSDEDataSet().getDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u9ed8\u8ba4\u6570\u636e\u96c6")
    public boolean isDefaultMode() {
        return this.getPSDEDataSet().isDefaultMode();
    }

    public Iterator<IDEDataQuery> getDEDataQueries() throws Exception {
        return this.getPSDEDataSet().getDEDataQueries();
    }

    public Iterator<IDEDataSetQuery> getDEDataSetQueries() {
        return this.getPSDEDataSet().getDEDataSetQueries();
    }

    @Override
    @Deprecated
    public String getPredefineType() {
        return this.getPSDEDataSet().getPredefineType();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u5206\u7ec4")
    public boolean isEnableGroup() {
        return this.getPSDEDataSet().isEnableGroup();
    }

    public Iterator<IDEDataSetGroupParam> getDEDataSetGroupParams() {
        return this.getPSDEDataSet().getDEDataSetGroupParams();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u5206\u7ec4\u53c2\u6570\u96c6\u5408", hideempty2=true)
    public Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParams() {
        return this.getPSDEDataSet().getPSDEDataSetGroupParams();
    }

    @Override
    public IPSDEDataSetGroupParam getPSDEDataSetGroupParam(String strName, boolean bTry) throws Exception {
        return this.getPSDEDataSet().getPSDEDataSetGroupParam(strName, bTry);
    }

    @Override
    public int getGroupTopCount() {
        return this.getPSDEDataSet().getGroupTopCount();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\u5bf9\u8c61", hideempty=true)
    public IPSCodeList getPSCodeList() {
        return this.getPSDEDataSet().getPSCodeList();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u6269\u5c55", codelist="DEExtendMode")
    public int getExtendMode() {
        return this.getPSDEDataSet().getExtendMode();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.getPSDEDataSet().getLogicName();
    }

    public void init(IDataEntity iDataEntity) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u673a\u6784\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableOrgDR() {
        return this.getPSDEDataSet().isEnableOrgDR();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u90e8\u95e8\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableSecDR() {
        return this.getPSDEDataSet().isEnableSecDR();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u90e8\u95e8\u4e1a\u52a1\u6761\u7ebf", ignoredumpvalues="false")
    public boolean isEnableSecBC() {
        return this.getPSDEDataSet().isEnableSecBC();
    }

    @Override
    @PSModelRTMeta(description="\u673a\u6784\u6570\u636e\u8303\u56f4", codelist="ACHOrgDR", ignoredumpvalues="0")
    public long getOrgDR() {
        return this.getPSDEDataSet().getOrgDR();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u95e8\u6570\u636e\u8303\u56f4", codelist="ACHSecDR", ignoredumpvalues="0")
    public long getSecDR() {
        return this.getPSDEDataSet().getSecDR();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u95e8\u4e1a\u52a1\u6761\u4ef6")
    public String getSecBC() {
        return this.getPSDEDataSet().getSecBC();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7528\u6237\u6570\u636e\u8303\u56f4", ignoredumpvalues="false")
    public boolean isEnableUserDR() {
        return this.getPSDEDataSet().isEnableUserDR();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u4f7f\u7528\u64cd\u4f5c\u6807\u8bc6")
    public String getUserDRAction() {
        return this.getPSDEDataSet().getUserDRAction();
    }

    @Override
    public String getCustomDRMode() {
        return this.getPSDEDataSet().getCustomDRMode();
    }

    @Override
    public String getCustomDRMode2() {
        return this.getPSDEDataSet().getCustomDRMode2();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f4\u53c2\u6570")
    public String getCustomDRModeParam() {
        return this.getPSDEDataSet().getCustomDRModeParam();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u8303\u56f42\u53c2\u6570")
    public String getCustomDRMode2Param() {
        return this.getPSDEDataSet().getCustomDRMode2Param();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u8303\u56f4\u5bf9\u8c61", dumpref=true)
    public IPSSysUserDR getPSSysUserDR() {
        return this.getPSDEDataSet().getPSSysUserDR();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6570\u636e\u8303\u56f4\u5bf9\u8c612", dumpref=true)
    public IPSSysUserDR getPSSysUserDR2() {
        return this.getPSDEDataSet().getPSSysUserDR2();
    }

    @Override
    public String getPredefinedType() {
        return this.getPSDEDataSet().getPredefinedType();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7f13\u5b58")
    public boolean isEnableCache() {
        return this.getPSDEDataSet().isEnableCache();
    }

    @PSModelRTMeta(description="\u7f13\u5b58\u8303\u56f4", codelist="DEDSCacheScope")
    public String getCacheScope() {
        return this.getPSDEDataSet().getCacheScope();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u8d85\u65f6")
    public int getCacheTimeout() {
        return this.getPSDEDataSet().getCacheTimeout();
    }

    public String getMajorSortField() {
        return this.getPSDEDataSet().getMajorSortField();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4e3b\u6392\u5e8f\u65b9\u5411")
    public String getMajorSortDir() {
        return this.getPSDEDataSet().getMajorSortDir();
    }

    public String getMinorSortField() {
        return this.getPSDEDataSet().getMinorSortField();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4ece\u6392\u5e8f\u65b9\u5411")
    public String getMinorSortDir() {
        return this.getPSDEDataSet().getMinorSortDir();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5206\u9875\u5927\u5c0f")
    public int getPageSize() {
        return this.getPSDEDataSet().getPageSize();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4e3b\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMajorSortPSDEField() {
        return this.getPSDEDataSet().getMajorSortPSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u4ece\u6392\u5e8f\u5c5e\u6027")
    public IPSDEField getMinorSortPSDEField() {
        return this.getPSDEDataSet().getMinorSortPSDEField();
    }

    public String getCacheUniStateId() {
        return this.getPSDEDataSet().getCacheUniStateId();
    }

    public String getCacheUniStateDELogicId() {
        return this.getPSDEDataSet().getCacheUniStateDELogicId();
    }

    public String getCacheHookState() {
        return this.getPSDEDataSet().getCacheHookState();
    }

    @Override
    @PSModelRTMeta(description="\u7f13\u5b58\u7edf\u4e00\u72b6\u6001\u5bf9\u8c61", hideempty2=true, dumpref=true)
    public IPSSysUniState getPSSysUniState() {
        return this.getPSDEDataSet().getPSSysUniState();
    }

    @Override
    public IPSDELogic getCacheStatePSDELogic() {
        return this.getPSDEDataSet().getCacheStatePSDELogic();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u53d1\u5e03\u670d\u52a1", dump=false)
    public boolean isPubServiceDefault() {
        return this.getPSDEDataSet().isPubServiceDefault();
    }

    @Override
    public IPSRESTfulAPI getPSRESTfulAPI() {
        return (IPSRESTfulAPI)((Object)this.getPSDEDataSet());
    }

    @Override
    @PSModelRTMeta(description="\u5f53\u524d\u6570\u636e\u8f6c\u6362\u903b\u8f91")
    public IPSDELogic getActiveDataPSDELogic() {
        return this.getPSDEDataSet().getActiveDataPSDELogic();
    }

    public String getActiveDataDELogicId() {
        return this.getPSDEDataSet().getActiveDataDELogicId();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4e34\u65f6\u6570\u636e", ignoredumpvalues="false")
    public boolean isEnableTempData() {
        return this.getPSDEDataSet().isEnableTempData();
    }

    @Override
    @PSModelRTMeta(description="\u4e0a\u4e0b\u6587\u6570\u636e\u6761\u4ef6", outputdoc="false")
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() {
        return this.getPSDEDataSet().getADPSDEDQConditions();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u5b9e\u4f53\u63a5\u53e3\u65b9\u6cd5", hideempty=true)
    public IPSSubSysServiceAPIDEMethod getPSSubSysServiceAPIDEMethod() throws Exception {
        return this.getPSDEDataSet().getPSSubSysServiceAPIDEMethod();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u6301\u6709\u8005", codelist="DELogicHolder", dump=false)
    public int getActionHolder() {
        return this.getPSDEDataSet().getActionHolder();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u540e\u53f0\u6267\u884c", dump=false)
    public boolean isEnableBackend() {
        return this.getPSDEDataSet().isEnableBackend();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u524d\u53f0\u6267\u884c", dump=false)
    public boolean isEnableFront() {
        return this.getPSDEDataSet().isEnableFront();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.getPSDEDataSet().getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u540e\u7aef\u6269\u5c55\u63d2\u4ef6", hideempty=true)
    public IPSSysSFPlugin getPSSysSFPlugin() {
        return this.getPSDEDataSet().getPSSysSFPlugin();
    }

    @Override
    public String getPSSubSysServiceAPIDEMethodId() {
        return this.getPSDEDataSet().getPSSubSysServiceAPIDEMethodId();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u8bbf\u95ee\u64cd\u4f5c\u6807\u8bc6")
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.getPSDEDataSet().getPSDEOPPriv();
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity majorPSDataEntity, PSDEDataSet psDEDataSet) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528")
    public boolean isValid() {
        return this.getPSDEDataSet().isValid();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u8bbf\u95ee\u5ba1\u8ba1", ignoredumpvalues="false")
    public boolean isEnableAudit() {
        return this.getPSDEDataSet().isEnableAudit();
    }

    @Override
    @PSModelRTMeta(description="\u7ed3\u679c\u96c6\u7c7b\u578b", codelist="DEDataSetType")
    public String getDataSetType() {
        return this.getPSDEDataSet().getDataSetType();
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801")
    public String getScriptCode() {
        return this.getPSDEDataSet().getScriptCode();
    }

    @Override
    @PSModelRTMeta(description="\u9009\u62e9\u5217\u7ea7\u522b", codelist="DEDataQueryColLevel3", ignoredumpvalues="-1", ignorepf=true, doc="\u4ece\u5305\u542b\u7684\u6570\u636e\u67e5\u8be2\u8ba1\u7b97\u5f97\u51fa")
    public int getViewLevel() {
        return this.getPSDEDataSet().getViewLevel();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDataEntity", ignorepf=true, doc="\u4ece\u5305\u542b\u7684\u6570\u636e\u67e5\u8be2\u8ba1\u7b97\u5f97\u51fa")
    public IPSDEFGroup getPSDEFGroup() {
        return this.getPSDEDataSet().getPSDEFGroup();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8f93\u5165\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u57fa\u672c", order=135)
    public IPSDEDataSetInput getPSDEDataSetInput() {
        return this.getPSDEDataSet().getPSDEDataSetInput();
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u8fd4\u56de\u5bf9\u8c61", child=true, ignorepf=true, doctype="item", group="\u57fa\u672c", order=136)
    public IPSDEDataSetReturn getPSDEDataSetReturn() {
        return this.getPSDEDataSet().getPSDEDataSetReturn();
    }

    @Override
    @PSModelRTMeta(description="\u5206\u7ec4\u6a21\u5f0f", ignoredumpvalues="0", ignorepf=true, codelist="DEDataSetGroupMode")
    public int getGroupMode() {
        return this.getPSDEDataSet().getGroupMode();
    }

    @Override
    public Iterator<IPSDEDataSetGroupParam> getPSDEDataSetGroupParamsByDBType(String strDBType) throws Exception {
        return this.getPSDEDataSet().getPSDEDataSetGroupParamsByDBType(strDBType);
    }

    @Override
    @PSModelRTMeta(description="\u805a\u5408\u6570\u636e\u5173\u7cfb", hideempty=true, ignorepf=true)
    public IPSDERAggData getPSDERAggData() {
        return this.getPSDEDataSet().getPSDERAggData();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5904\u7406\u903b\u8f91", hideempty=true, ignorepf=true)
    public IPSDELogic getPSDELogic() throws Exception {
        return this.getPSDEDataSet().getPSDELogic();
    }

    @Override
    public String getBeforeCode() {
        return this.getPSDEDataSet().getBeforeCode();
    }

    @Override
    public String getAfterCode() {
        return this.getPSDEDataSet().getAfterCode();
    }

    @Override
    @PSModelRTMeta(description="\u6027\u80fd\u4f18\u5316\u9884\u8b66\u65f6\u957f\uff08ms\uff09", ignorepf=true, ignoredumpvalues="-1")
    public int getPOTime() {
        return this.getPSDEDataSet().getPOTime();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb0", fields={"DSTAG"})
    public String getDataSetTag() {
        return this.getPSDEDataSet().getDataSetTag();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb02", fields={"DSTAG2"})
    public String getDataSetTag2() {
        return this.getPSDEDataSet().getDataSetTag2();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb03", fields={"DSTAG3"})
    public String getDataSetTag3() {
        return this.getPSDEDataSet().getDataSetTag3();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u6807\u8bb04", fields={"DSTAG4"})
    public String getDataSetTag4() {
        return this.getPSDEDataSet().getDataSetTag4();
    }

    @Override
    public String getReturnValueType() {
        return this.getPSDEDataSet().getReturnValueType();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u53c2\u6570\u6a21\u5f0f", codelist="DEDataSetParamMode", ignoredumpvalues="1", ignorepf=true, fields={"PARAMTYPE"})
    public int getParamMode() {
        return this.getPSDEDataSet().getParamMode();
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u6570\u636e\u96c6\u53c2\u6570", ignoredumpvalues="false", ignorepf=true, fields={"PARAMTYPE"}, doc="\u662f\u5426\u6709\u8bbe\u7f6e\u884c\u4e3a\u53c2\u6570")
    public boolean isCustomParam() {
        return this.getPSDEDataSet().isCustomParam();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u53c2\u6570\u96c6\u5408", child=true, ignorepf=true, group="\u57fa\u672c", order=130)
    public Iterator<IPSDEDataSetParam> getPSDEDataSetParams() {
        return this.getPSDEDataSet().getPSDEDataSetParams();
    }

    @Override
    @PSModelRTMeta(description="\u8f93\u5165\u5c5e\u6027\u7ec4\u5bf9\u8c61", hideempty=true, dump=false)
    public IPSDEFGroup getInPSDEFGroup() {
        return this.getPSDEDataSet().getInPSDEFGroup();
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u63a5\u53e3\u5b9e\u4f53\u65b9\u6cd5\u7ed1\u5b9a\u6a21\u5f0f", codelist="SubSysSADEMethodBindingMode", dump=false)
    public int getSubSysServiceAPIDEMethodBindingMode() {
        return this.getPSDEDataSet().getSubSysServiceAPIDEMethodBindingMode();
    }

    @Override
    public String getServiceCodeName() {
        return this.getPSDEDataSet().getServiceCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u9009\u9879", codelist="DEDataSetOption", ignoredumpvalues="0", fields={"DSOPTION"})
    public int getDataSetOption() {
        return this.getPSDEDataSet().getDataSetOption();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u96c6\u52a8\u6001\u53c2\u6570", hideempty2=true, ignorepf=true, fields={"DATASETPARAMS"})
    public Properties getDataSetParams() {
        return this.getPSDEDataSet().getDataSetParams();
    }

    @Override
    @PSModelRTMeta(description="\u8fde\u63a5\u6a21\u5f0f", hideempty2=true, ignorepf=true, codelist="DEDataSetUnionMode", ignoredumpvalues="UNION", fields={"UNIONMODE"})
    public String getUnionMode() {
        return this.getPSDEDataSet().getUnionMode();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u8bb0\u5f55\u6570", ignorepf=true, ignoredumpvalues="-1", fields={"MAXROWCNT"})
    public int getMaxRowCount() {
        return this.getPSDEDataSet().getMaxRowCount();
    }
}

