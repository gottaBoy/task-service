/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDAModelHelper
 *  SA.SRFDA.Ctrl.IDAModelStorage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IModelBase
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.Inflector
 *  net.ibizsys.pscore.srv.util.JsonUtils
 *  net.ibizsys.pscore.srv.util.PropertiesEx
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModel;
import SA.SRFDA.PS.Core.DynaModel.IPSDynaModelAttr;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSModel;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelInfo;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelObject3;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSModelObjectRuntime;
import SA.SRFDA.PS.Core.IPSModelStorage;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSObjectRuntime;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelCheckException;
import SA.SRFDA.PS.Core.PSModelInfoImpl;
import SA.SRFDA.PS.Core.PSModelInitException;
import SA.SRFDA.PS.Core.PSModelPFIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSSysIssues;
import SA.SRFDA.PS.Core.Plugin.IPSModelCheckPlugin;
import SA.SRFDA.PS.Core.Plugin.IPSModelPlugin;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysCss;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Data.PSSysIssue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import net.ibizsys.paas.core.IModelBase;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.Inflector;
import net.ibizsys.pscore.srv.util.JsonUtils;
import net.ibizsys.pscore.srv.util.PropertiesEx;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelPFIgnoreMeta
public abstract class PSObjectImpl
implements IPSObject,
IModelBase,
IPSObjectRuntime,
IPSModelObject,
IPSModelObjectRuntime {
    private static final Log log = LogFactory.getLog(PSObjectImpl.class);
    public static final String TAG_AUTOMODEL = "AUTOMODEL";
    public static final String TAG_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String TAG_DYNAMODELLEVEL = "DYNAMODELLEVEL";
    public static final String MODELREFTYPE_SIMPLE = "SIMPLE";
    public static final String MODELREFTYPE_IGNOREDESIGN = "IGNOREDESIGN";
    public static final int DYNAMODEL_DEFAULTINST = 1;
    public static final int DYNAMODEL_MODULEINST = 2;
    public static final int DYNAMODEL_CORE = 4;
    public static final int DYNAMODEL_CODEGEN = 8;
    public static final int DYNAMODEL_MEMO = 16;
    public static final int DYNAMODEL_CORE_MEMO = 20;
    public static final int DYNAMODEL_ALL = 7;
    public static final int DYNAMODEL_ALLINST = 3;
    public static final int DYNAMODEL_CORE_DEFAULTINST = 5;
    public static final String MODELGROUP_BASE = "\u57fa\u672c";
    public static final String MODELGROUP_FUNC = "\u903b\u8f91";
    public static final String MODELGROUP_POS = "\u4f4d\u7f6e";
    public static final String MODELGROUP_USER = "\u7528\u6237\u6269\u5c55";
    public static final String MODELGROUP_OTHER = "\u5176\u5b83";
    public static final int MODELORDER_BASE = 100;
    public static final int MODELORDER_FUNC = 200;
    public static final int MODELORDER_USER = 900;
    public static final int MODELORDER_OTHER = 950;
    public static final String LOGINFO_MODELCOUNT = "\u6a21\u578b\u8ba1\u6570";
    public static final String MODELTYPE_SIMPLEAPP = "SIMPLEAPP";
    public static final String MODELTYPE_HUBSUBAPP = "HUBSUBAPP";
    private static ThreadLocal<Integer> dynaModelPubModeLocal = new ThreadLocal();
    private static ThreadLocal<Boolean> dynaModelPubIgnorePFLocal = new ThreadLocal();
    private static ThreadLocal<Boolean> dynaModelPubIgnorePFLocalReal = new ThreadLocal();
    private ISRFDAGlobalHelper iDAGlobalHelper = null;
    private String strPSObjectId = "";
    private String strPSObjectName = "";
    private int nPSObjVersion = 0;
    private BaseDataEntity dataEntity = null;
    private Properties userParams = null;
    private IPSModel iPSModel = null;
    private HashMap<String, Object> attributeMap = null;
    private IPSDynaModel iPSDynaModel = null;
    private String strPSDynaModelId = null;
    private String strMemo = "";
    private String strUserTag = "";
    private String strUserTag2 = "";
    private String strUserTag3 = "";
    private String strUserTag4 = "";
    private String strUserCat = "";
    private boolean bAutoModel = false;
    private List<IPSModelInfo> psModelInfoList = null;
    private static ThreadLocal<Map<String, Integer>> modelExportMapLocal = new ThreadLocal();

    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.getModelType())) {
            this.iPSModel = this.getPSModelStorage().getPSModel(this.getModelType(), true);
        }
        if (this.hasPSSysDynaModel() && !StringHelper.isNullOrEmpty((String)this.getPSDynaModelId())) {
            this.iPSDynaModel = this.internalGetPSSysDynaModel(this.getPSDynaModelId());
        }
        this.onCheckModel();
    }

    protected void onCheckModel() throws Exception {
    }

    @Override
    public String getId() {
        return this.strPSObjectId;
    }

    @Override
    @PSModelRTMeta(description="\u540d\u79f0", order=100)
    public String getName() {
        return this.strPSObjectName;
    }

    public String getLogicName() {
        return null;
    }

    @Override
    public int getVersion() {
        return this.nPSObjVersion;
    }

    protected void setId(String strPSObjectId) {
        this.strPSObjectId = strPSObjectId;
    }

    protected void setName(String strPSObjectName) {
        this.strPSObjectName = strPSObjectName;
    }

    protected void setMemo(String strMemo) {
        this.strMemo = strMemo;
    }

    protected void setVersion(int nPSObjVersion) {
        this.nPSObjVersion = nPSObjVersion;
    }

    @Override
    public final ISRFDAGlobalHelper getDAGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    public final void setDAGlobalHelper(ISRFDAGlobalHelper iDAGlobalHelper) {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    @Override
    public abstract String getPSSysModelInstId();

    protected boolean isAlwaysActivePSSysModelInst() {
        return false;
    }

    protected final IPSModelHelper getPSModelHelper() throws Exception {
        return PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, this.getPSSysModelInstId(), this.isAlwaysActivePSSysModelInst());
    }

    protected final IPSModelHelper getPSModelHelper(String strPSSysModelInstId) throws Exception {
        return PSObjectFactory.getPSModelHelper(this.iDAGlobalHelper, strPSSysModelInstId, this.isAlwaysActivePSSysModelInst());
    }

    protected final IPSModelStorage getPSModelStorage() throws Exception {
        return PSObjectFactory.getPSModelStorage(this.iDAGlobalHelper);
    }

    protected final IDAModelHelper getDAModelHelper() {
        return this.getDAGlobalHelper().getDAModelHelper();
    }

    protected final IDAModelStorage getDAModelStorage() {
        return this.getDAGlobalHelper().getDAModelStorage();
    }

    @Override
    @PSModelRTMeta(description="\u5907\u6ce8", hideempty2=true, dynamodelmode=8)
    public String getMemo() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getMemo();
        }
        return this.strMemo;
    }

    protected void setPSObjectData(BaseDataEntity baseDataEntity) {
        this.setPSObjectData(baseDataEntity, true);
    }

    protected void setPSObjectData(BaseDataEntity baseDataEntity, boolean bCache) {
        try {
            this.dataEntity = baseDataEntity;
            if (this.dataEntity == null) {
                this.userParams = null;
                this.setPSDynaModelId(null);
                this.strMemo = "";
                this.strUserTag = "";
                this.strUserTag2 = "";
                this.strUserTag3 = "";
                this.strUserTag4 = "";
                this.strUserCat = "";
                this.bAutoModel = false;
            } else {
                String strPSSysDynaModelId;
                String strUserParams = this.dataEntity.getParamStringValue("USERPARAMS", "");
                if (!StringHelper.isNullOrEmpty((String)strUserParams)) {
                    this.userParams = PropertiesHelper.load((String)strUserParams);
                }
                if (!StringHelper.isNullOrEmpty((String)(strPSSysDynaModelId = this.dataEntity.getParamStringValue("PSSYSDYNAMODELID", "")))) {
                    this.setPSDynaModelId(strPSSysDynaModelId);
                }
                this.strMemo = this.dataEntity.getParamStringValue("MEMO", "");
                this.strUserTag = this.dataEntity.getParamStringValue("USERTAG", "");
                this.strUserTag2 = this.dataEntity.getParamStringValue("USERTAG2", "");
                this.strUserTag3 = this.dataEntity.getParamStringValue("USERTAG3", "");
                this.strUserTag4 = this.dataEntity.getParamStringValue("USERTAG4", "");
                this.strUserCat = this.dataEntity.getParamStringValue("USERCAT", "");
                boolean bl = this.bAutoModel = this.dataEntity.GetParamIntValue(TAG_AUTOMODEL, 0) == 1;
            }
            if (!bCache) {
                this.dataEntity = null;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected void setPSObjectData(IEntity iEntity, boolean bCache) {
        try {
            IEntity dataEntity = iEntity;
            if (dataEntity == null) {
                this.userParams = null;
                this.setPSDynaModelId(null);
                this.strMemo = "";
                this.strUserTag = "";
                this.strUserTag2 = "";
                this.strUserTag3 = "";
                this.strUserTag4 = "";
                this.strUserCat = "";
                this.bAutoModel = false;
            } else {
                String strPSSysDynaModelId;
                String strUserParams = DataObject.getStringValue((IDataObject)dataEntity, (String)"USERPARAMS", (String)"");
                if (!StringHelper.isNullOrEmpty((String)strUserParams)) {
                    this.userParams = PropertiesHelper.load((String)strUserParams);
                }
                if (!StringHelper.isNullOrEmpty((String)(strPSSysDynaModelId = DataObject.getStringValue((IDataObject)dataEntity, (String)"PSSYSDYNAMODELID", (String)"")))) {
                    this.setPSDynaModelId(strPSSysDynaModelId);
                }
                this.strMemo = DataObject.getStringValue((IDataObject)dataEntity, (String)"MEMO", (String)"");
                this.strUserTag = DataObject.getStringValue((IDataObject)dataEntity, (String)"USERTAG", (String)"");
                this.strUserTag2 = DataObject.getStringValue((IDataObject)dataEntity, (String)"USERTAG2", (String)"");
                this.strUserTag3 = DataObject.getStringValue((IDataObject)dataEntity, (String)"USERTAG3", (String)"");
                this.strUserTag4 = DataObject.getStringValue((IDataObject)dataEntity, (String)"USERTAG4", (String)"");
                this.strUserCat = DataObject.getStringValue((IDataObject)dataEntity, (String)"USERCAT", (String)"");
                this.bAutoModel = DataObject.getIntegerValue((IDataObject)dataEntity, (String)TAG_AUTOMODEL, (int)0) == 1;
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected BaseDataEntity getPSObjectData() {
        return this.dataEntity;
    }

    @Override
    public Object getPSObjectParam(String strKey, Object objDefault) {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getPSObjectParam(strKey, objDefault);
        }
        if (!this.isEnableGetPSObjectParam() || this.getPSObjectData() == null) {
            return objDefault;
        }
        Object objValue = this.getPSObjectData().getParamValue(strKey);
        if (objValue == null) {
            return objDefault;
        }
        return objValue;
    }

    @Override
    public Object getUserParam(String strParamName) {
        String objValue;
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserParam(strParamName);
        }
        if (this.userParams != null && (objValue = PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, null)) != null) {
            return objValue;
        }
        if (this.getPSDynaModel() != null) {
            try {
                return this.getPSDynaModel().get(strParamName);
            }
            catch (Exception ex) {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean containsUserParam(String strParamName) {
        String objValue;
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().containsUserParam(strParamName);
        }
        if (this.userParams != null && (objValue = PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, null)) != null) {
            return true;
        }
        if (this.getPSDynaModel() != null) {
            try {
                return this.getPSDynaModel().has(strParamName);
            }
            catch (Exception ex) {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getUserParam(String strParamName, String strDefault) {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserParam(strParamName, strDefault);
        }
        if (this.getPSDynaModel() == null) {
            return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (String)strDefault);
        }
        Object objValue = PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, null);
        if (objValue != null) {
            return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (String)strDefault);
        }
        try {
            objValue = this.getPSDynaModel().get(strParamName);
            if (objValue == null) {
                return strDefault;
            }
            return (String)objValue;
        }
        catch (Exception ex) {
            return strDefault;
        }
    }

    @Override
    public boolean getUserParam(String strParamName, boolean bDefault) {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserParam(strParamName, bDefault);
        }
        if (this.getPSDynaModel() == null) {
            return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (boolean)bDefault);
        }
        Object objValue = PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, null);
        if (objValue != null) {
            return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (boolean)bDefault);
        }
        try {
            objValue = this.getPSDynaModel().get(strParamName);
            if (objValue == null) {
                return bDefault;
            }
            return Boolean.parseBoolean((String)objValue);
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    @Override
    public int getUserParam(String strParamName, int nDefault) {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserParam(strParamName, nDefault);
        }
        if (this.getPSDynaModel() == null) {
            return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (int)nDefault);
        }
        Object objValue = PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, null);
        if (objValue != null) {
            return PropertiesHelper.getProperty((Properties)this.userParams, (String)strParamName, (int)nDefault);
        }
        try {
            objValue = this.getPSDynaModel().get(strParamName);
            if (objValue == null) {
                return nDefault;
            }
            return Integer.parseInt((String)objValue);
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u5b9a\u4e49\u53c2\u6570\u540d\u79f0\u96c6\u5408", hideempty=true)
    public Enumeration<Object> getUserParamNames() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserParamNames();
        }
        if (this.getPSDynaModel() != null && this.getPSDynaModel().getPSDynaModelAttrCount() > 0) {
            Hashtable<Object, String> totalMap = new Hashtable<Object, String>();
            Iterator<? extends IPSDynaModelAttr> psDynaModelAttrs = this.getPSDynaModel().getPSDynaModelAttrs();
            if (psDynaModelAttrs != null) {
                while (psDynaModelAttrs.hasNext()) {
                    IPSDynaModelAttr iPSDynaModelAttr = psDynaModelAttrs.next();
                    if (iPSDynaModelAttr.getValue() == null) continue;
                    totalMap.put(iPSDynaModelAttr.getName(), "");
                }
            }
            if (this.userParams != null) {
                Enumeration<Object> keys = this.userParams.keys();
                while (keys.hasMoreElements()) {
                    totalMap.put(keys.nextElement(), "");
                }
            }
            if (totalMap.size() == 0) {
                return null;
            }
            return totalMap.keys();
        }
        if (this.userParams == null) {
            return null;
        }
        return this.userParams.keys();
    }

    @Override
    public BaseDataEntity getModelData() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getModelData();
        }
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"\u6a21\u677f\u53d1\u5e03\u4e2d\u7981\u6b62\u8bbf\u95ee[getModelData]"));
            return null;
        }
        return this.getPSObjectData();
    }

    @Override
    public String getModelType() {
        return null;
    }

    @Override
    public IPSModel getPSModel() {
        return this.iPSModel;
    }

    @Override
    public int check() throws Exception {
        if (PSTemplHelper.isBusy()) {
            log.warn((Object)StringHelper.format((String)"\u6a21\u677f\u53d1\u5e03\u4e2d\u7981\u6b62\u8bbf\u95ee[check]"));
            return 0;
        }
        try {
            return this.onCheck();
        }
        catch (Exception ex) {
            if (ex instanceof PSModelCheckException) {
                throw ex;
            }
            throw new PSModelCheckException(this, ex);
        }
    }

    protected int onCheck() throws Exception {
        if (this.getPSModel() == null) {
            return 0;
        }
        Iterator<IPSModelPlugin> psModelPlugins = this.getPSModel().getPSModelPlugins("CHECK");
        if (psModelPlugins == null) {
            return 0;
        }
        int nCount = 0;
        while (psModelPlugins.hasNext()) {
            IPSModelCheckPlugin iPSModelCheckPlugin = (IPSModelCheckPlugin)psModelPlugins.next();
            nCount += iPSModelCheckPlugin.check(this);
        }
        return nCount;
    }

    public static PSSysIssue createPSSysIssue(String strErrorCode) {
        return PSObjectImpl.createPSSysIssue(strErrorCode, "WARN");
    }

    public static PSSysIssue createPSSysIssue(String strErrorCode, String strType) {
        PSSysIssue psSysIssue = new PSSysIssue();
        psSysIssue.setISSUETYPE(strType);
        psSysIssue.setPSSYSISSUETYPEID(strErrorCode);
        psSysIssue.setPSSYSISSUETYPENAME(PSSysIssues.getIssueInfo(strErrorCode));
        return psSysIssue;
    }

    @Override
    public Object getRTAttribute(String strName) {
        if (this.getProxyPSModelObject() != null && this.getProxyPSModelObject() instanceof IPSObjectRuntime) {
            return ((IPSObjectRuntime)((Object)this.getProxyPSModelObject())).getRTAttribute(strName);
        }
        if (PSTemplHelper.isBusy()) {
            log.error((Object)StringHelper.format((String)"\u4e0d\u80fd\u5728\u6a21\u677f\u53d1\u5e03\u8fc7\u7a0b\u4e2d\u8c03\u7528\u6b64\u65b9\u6cd5"));
            return null;
        }
        if (this.attributeMap == null) {
            return null;
        }
        return this.attributeMap.get(strName.toUpperCase());
    }

    @Override
    public void setRTAttribute(String strName, Object objValue) {
        if (this.getProxyPSModelObject() != null && this.getProxyPSModelObject() instanceof IPSObjectRuntime) {
            ((IPSObjectRuntime)((Object)this.getProxyPSModelObject())).setRTAttribute(strName, objValue);
            return;
        }
        if (PSTemplHelper.isBusy()) {
            log.error((Object)StringHelper.format((String)"\u4e0d\u80fd\u5728\u6a21\u677f\u53d1\u5e03\u8fc7\u7a0b\u4e2d\u8c03\u7528\u6b64\u65b9\u6cd5"));
            return;
        }
        if (objValue == null) {
            if (this.attributeMap != null) {
                this.attributeMap.remove(strName.toUpperCase());
            }
        } else {
            if (this.attributeMap == null) {
                this.attributeMap = new HashMap();
            }
            this.attributeMap.put(strName.toUpperCase(), objValue);
        }
    }

    @Override
    public String getModelId() {
        String strModelId = this.getId();
        if (strModelId == null) {
            return "";
        }
        return strModelId;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u5bf9\u8c61", hideempty=true, dumpref=true, ignorepf=true)
    public IPSDynaModel getPSDynaModel() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getPSDynaModel();
        }
        return this.iPSDynaModel;
    }

    protected boolean hasPSSysDynaModel() {
        return true;
    }

    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        throw new Exception(StringHelper.format((String)"\u6a21\u578b\u5bf9\u8c61[%1$s|%2$s]\u65e0\u6cd5\u83b7\u53d6\u52a8\u6001\u6a21\u578b\u5bf9\u8c61\uff0c\u4e0d\u63d0\u4f9b\u6b64\u80fd\u529b", (Object)this.getModelType(), (Object)this.getName()));
    }

    @Override
    public String getModelName() {
        return this.getName();
    }

    @Override
    public String getModelType(String strModelType) {
        return this.getModelType();
    }

    @Override
    public String getModelId(String strModelType) {
        return this.getModelId();
    }

    @Override
    public String getModelName(String strModelType) {
        return this.getModelName();
    }

    @Override
    public Class<?> getModelClass(String strModelType) {
        try {
            return Class.forName(strModelType);
        }
        catch (Exception ex) {
            return null;
        }
    }

    @Override
    public String getFullModelName() {
        return this.getModelName();
    }

    protected String getLogName() {
        return StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
    }

    protected void setPSDynaModelId(String strPSDynaModelId) {
        this.strPSDynaModelId = strPSDynaModelId;
    }

    public String getPSDynaModelId() {
        return this.strPSDynaModelId;
    }

    public boolean isEnableGetPSObjectParam() {
        return false;
    }

    public static final int getV3IntValue(Integer nValue) {
        if (nValue == null) {
            return 0;
        }
        return nValue;
    }

    public static final boolean getV3BoolValue(Integer nValue) {
        if (nValue == null) {
            return false;
        }
        return nValue == 1;
    }

    public static final boolean getV3BoolValue(Object objValue) {
        if (objValue == null) {
            return false;
        }
        String strValueString = objValue.toString();
        if (StringHelper.compare((String)strValueString, (String)"TRUE", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.compare((String)strValueString, (String)"1", (boolean)true) == 0) {
            return true;
        }
        return Boolean.parseBoolean(strValueString);
    }

    public static final String getV3StringValue(Object objValue) {
        return PSObjectImpl.getStringValue(objValue, "");
    }

    public static final String getStringValue(Object objValue, String strDefault) {
        if (objValue == null) {
            return strDefault;
        }
        if (objValue instanceof String) {
            return (String)objValue;
        }
        return objValue.toString();
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb0", hideempty2=true)
    public String getUserTag() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserTag();
        }
        return this.strUserTag;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb02", hideempty2=true)
    public String getUserTag2() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserTag2();
        }
        return this.strUserTag2;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb03", hideempty2=true)
    public String getUserTag3() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserTag3();
        }
        return this.strUserTag3;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6807\u8bb04", hideempty2=true)
    public String getUserTag4() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserTag4();
        }
        return this.strUserTag4;
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u6a21\u578b\u5206\u7c7b", hideempty2=true)
    public String getUserCat() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getUserCat();
        }
        return this.strUserCat;
    }

    protected IPSModelObject getProxyPSModelObject() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u81ea\u52a8\u4ea7\u751f\u6a21\u578b", dump=false, group="\u5176\u5b83", order=10949, outputdoc="%1$s.isAutoModel()")
    public boolean isAutoModel() {
        return this.onGetAutoModel();
    }

    protected boolean onGetAutoModel() {
        if (this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().isAutoModel();
        }
        return this.bAutoModel;
    }

    protected void setAutoModel(boolean bAutoModel) {
        this.bAutoModel = bAutoModel;
    }

    protected void registerToPSModelObject(IPSModelObject iPSModelObject) {
        if (iPSModelObject == null) {
            return;
        }
        if (iPSModelObject instanceof IPSModelObject3) {
            ((IPSModelObject3)((Object)iPSModelObject)).registerRefPSModelObject(this);
        }
    }

    public static void registerRefPSModelObject(IPSModelObject iPSModelObject, IPSModelObject refPSModelObject) {
        if (iPSModelObject == null || refPSModelObject == null) {
            return;
        }
        if (iPSModelObject instanceof IPSModelObject3) {
            ((IPSModelObject3)((Object)iPSModelObject)).registerRefPSModelObject(refPSModelObject);
        }
    }

    @Override
    public String getDeployId() {
        return this.getId();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u578b\u63a5\u53e3\u5bf9\u8c61", hideempty2=true, dump=false)
    public String getModelInterface() {
        String strInterface = PSModels.getModelInterface(this.getModelType());
        if (StringHelper.isNullOrEmpty((String)strInterface) && this.getProxyPSModelObject() != null) {
            return this.getProxyPSModelObject().getModelInterface();
        }
        return strInterface;
    }

    @Override
    public String info(String strInfo) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.info(this, strInfo);
        }
        return strInfo;
    }

    @Override
    public String warn(String strInfo) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.warn(this, strInfo);
        }
        return strInfo;
    }

    @Override
    public String error(String strInfo) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.error(this, strInfo);
        }
        return strInfo;
    }

    @Override
    public String info(String strInfo, String strIssueSN) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.info(this, strInfo, strIssueSN, null);
        }
        return strInfo;
    }

    @Override
    public String warn(String strInfo, String strIssueSN) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.warn(this, strInfo, strIssueSN, null);
        }
        return strInfo;
    }

    @Override
    public String error(String strInfo, String strIssueSN) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.error(this, strInfo, strIssueSN, null);
        }
        return strInfo;
    }

    @Override
    public String info(String strInfo, String strIssueSN, Object objTag) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.info(this, strInfo, strIssueSN, objTag);
        }
        return strInfo;
    }

    @Override
    public String warn(String strInfo, String strIssueSN, Object objTag) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.warn(this, strInfo, strIssueSN, objTag);
        }
        return strInfo;
    }

    @Override
    public String error(String strInfo, String strIssueSN, Object objTag) {
        IPSModelObjectLogger iPSModelObjectLogger = this.getPSModelObjectLogger();
        if (iPSModelObjectLogger != null) {
            iPSModelObjectLogger.error(this, strInfo, strIssueSN, objTag);
        }
        return strInfo;
    }

    @Override
    public String command(String strCommand, String arg) {
        return this.onCommand(strCommand, arg);
    }

    protected String onCommand(String strCommand, String arg) {
        return StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6a21\u578b\u6307\u4ee4[%1$s]", (Object)strCommand);
    }

    protected IPSModelObjectLogger getPSModelObjectLogger() {
        Object obj;
        Map<String, Object> params = PSTemplHelper.getCurrentParams();
        if (params != null && (obj = params.get("sys")) != null && obj instanceof IPSSystemRuntime) {
            return ((IPSSystemRuntime)obj).getPSModelObjectLogger();
        }
        return null;
    }

    protected void throwInitException(Exception ex) throws Exception {
        if (ex instanceof PSModelInitException) {
            throw ex;
        }
        throw new PSModelInitException(this, ex);
    }

    protected void throwInitException(Exception ex, boolean bCritical) throws Exception {
        if (bCritical) {
            throw new PSModelInitException(this, ex, true);
        }
        if (ex instanceof PSModelInitException) {
            throw ex;
        }
        throw new PSModelInitException(this, ex);
    }

    protected void throwCriticalInitException(Exception ex) throws Exception {
        PSModelInitException psModelInitException = this.getCriticalPSModelInitException(ex);
        if (psModelInitException != null) {
            throw psModelInitException;
        }
    }

    protected PSModelInitException getCriticalPSModelInitException(Throwable ex) {
        PSModelInitException psModelInitException;
        if (ex instanceof PSModelInitException && (psModelInitException = (PSModelInitException)ex).isCritical()) {
            return psModelInitException;
        }
        if (ex.getCause() == null) {
            return null;
        }
        return this.getCriticalPSModelInitException(ex.getCause());
    }

    @Override
    public IPSModelObject getParentModel() {
        return this.onGetParentModel();
    }

    protected IPSModelObject onGetParentModel() {
        return null;
    }

    @Override
    public IPSModelObject getScopeModel() {
        return this.onGetScopeModel();
    }

    protected IPSModelObject onGetScopeModel() {
        return this.getParentModel();
    }

    @Override
    public IPSModelInfo getPSModelInfo(String strTag) {
        if (this.psModelInfoList != null) {
            for (IPSModelInfo iPSModelInfo : this.psModelInfoList) {
                if (StringHelper.compare((String)iPSModelInfo.getTag(), (String)strTag, (boolean)true) != 0) continue;
                return iPSModelInfo;
            }
        }
        return null;
    }

    @Override
    public Iterator<IPSModelInfo> getPSModelInfos() {
        if (this.psModelInfoList == null || this.psModelInfoList.size() == 0) {
            return null;
        }
        return this.psModelInfoList.iterator();
    }

    protected void logPSModelInfo(String strType, String strTag, String strInfo) {
        this.logPSModelInfo(strType, strTag, strInfo, false);
    }

    protected void logPSModelInfo(String strType, String strTag, String strInfo, boolean bReplace) {
        PSModelInfoImpl psModelInfoImpl = new PSModelInfoImpl();
        psModelInfoImpl.setTag(strTag);
        psModelInfoImpl.setType(strType);
        psModelInfoImpl.setInfo(strInfo);
        if (this.psModelInfoList == null) {
            this.psModelInfoList = new ArrayList<IPSModelInfo>();
        } else if (bReplace) {
            for (IPSModelInfo iPSModelInfo : this.psModelInfoList) {
                if (StringHelper.compare((String)iPSModelInfo.getTag(), (String)strTag, (boolean)true) != 0) continue;
                this.psModelInfoList.remove(iPSModelInfo);
                break;
            }
        }
        this.psModelInfoList.add(psModelInfoImpl);
    }

    protected void resetPSModelInfo(String strTag) {
        if (this.psModelInfoList != null) {
            for (IPSModelInfo iPSModelInfo : this.psModelInfoList) {
                if (StringHelper.compare((String)iPSModelInfo.getTag(), (String)strTag, (boolean)true) != 0) continue;
                this.psModelInfoList.remove(iPSModelInfo);
                break;
            }
            if (this.psModelInfoList.size() == 0) {
                this.psModelInfoList = null;
            }
        }
    }

    @Override
    public String getFullName() {
        if (this.getParentModel() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getParentModel().getFullName(), (Object)this.getName());
        }
        return this.getName();
    }

    protected int onGetDynaInstMode() {
        return 0;
    }

    protected String onGetDynaInstTag() {
        return "";
    }

    protected String onGetDynaInstTag2() {
        return "";
    }

    @PSModelRTMeta(description="\u52a8\u6001\u6a21\u578b\u6807\u8bb0", hideempty=true, dump=false)
    public String getDynaModelTag() {
        return this.onGetDynaModelTag();
    }

    protected String onGetDynaModelTag() {
        return this.getCodeName();
    }

    public String getDynaModelFullTag() {
        return this.onGetDynaModelFullTag();
    }

    protected String onGetDynaModelFullTag() {
        return this.getDynaModelTag();
    }

    public String getDynaInstTag() {
        return this.onGetDynaInstTag();
    }

    protected String onGetDynaModelFolder() {
        String strDumpModelType = this.getDumpModelType();
        if (StringHelper.isNullOrEmpty((String)strDumpModelType)) {
            return null;
        }
        String strDynaModelTag = this.getDynaModelTag();
        if (StringHelper.isNullOrEmpty((String)strDynaModelTag)) {
            return null;
        }
        return String.format("%1$s/%2$s", Inflector.getInstance().pluralize((Object)strDumpModelType).toUpperCase(), strDynaModelTag);
    }

    public boolean isEnableDynaModel() {
        return this.onGetEnableDynaModel();
    }

    protected boolean onGetEnableDynaModel() {
        return false;
    }

    public boolean isDynaInstModel() {
        return !StringHelper.isNullOrEmpty((String)this.getPSDynaInstId());
    }

    public int getDynaInstMode() {
        return this.onGetDynaInstMode();
    }

    public String getDynaInstTag2() {
        return this.onGetDynaInstTag2();
    }

    public String getDynaModelFolder() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        return this.onGetDynaModelFolder();
    }

    @Override
    public String getDynaModelFilePath() {
        if (!this.isEnableDynaModel()) {
            return null;
        }
        String strDynaModelFolder = this.getDynaModelFolder();
        if (!StringHelper.isNullOrEmpty((String)strDynaModelFolder)) {
            return String.format("%1$s.json", strDynaModelFolder, this.getDumpModelType());
        }
        return null;
    }

    @Override
    public ObjectNode getModel() {
        if (!this.isEnableExportModel()) {
            return null;
        }
        return this.toModelNode(null);
    }

    @Override
    public ObjectNode toModel(String strType) {
        if (!this.isEnableExportModel()) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)strType)) {
            return this.getModel();
        }
        return this.toModelNode(strType);
    }

    @Override
    public ObjectNode getRuntimeModel() {
        if (!this.isEnableExportModel()) {
            return null;
        }
        return this.toModelNode("RUNTIME");
    }

    protected boolean isEnableExportModel() {
        return true;
    }

    protected boolean isExportModelCodeName() {
        return true;
    }

    protected boolean isExportModelName() {
        return true;
    }

    protected ObjectNode toModelNode(String strType) {
        boolean bNewMap = false;
        String strTag = String.format("%1$s", this);
        Map<String, Integer> map = modelExportMapLocal.get();
        if (map == null) {
            map = new HashMap<String, Integer>();
            modelExportMapLocal.set(map);
            bNewMap = true;
        } else if (map.containsKey(strTag)) {
            return this.getModelRef();
        }
        try {
            String strModelRefId;
            Enumeration<Object> keys;
            String strMemo;
            int nDynaModelPubMode;
            map.put(strTag, 0);
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            this.onFillModelNode(objectNode, strType);
            if (!this.isExportModelCodeName() && objectNode.has("codeName")) {
                objectNode.remove("codeName");
            }
            if (!this.isExportModelName() && objectNode.has("name")) {
                objectNode.remove("name");
            }
            if (((nDynaModelPubMode = PSObjectImpl.getDynaModelPubMode()) & 0x10) != 0 && !StringHelper.isNullOrEmpty((String)(strMemo = this.getMemo())) && !objectNode.has("memo")) {
                objectNode.put("memo", strMemo);
            }
            if (!objectNode.has("getUserParam") && (keys = this.getUserParamNames()) != null) {
                ObjectNode paramNode = JsonNodeHelper.createObjectNode();
                while (keys.hasMoreElements()) {
                    Object objKey = keys.nextElement();
                    Object objValue = this.getUserParam((String)objKey);
                    if (objValue == null) continue;
                    PSObjectImpl.putJsonProperty(paramNode, (String)objKey, objValue);
                }
                if (paramNode.size() != 0) {
                    objectNode.put("getUserParam", (JsonNode)paramNode);
                }
            }
            if (!(objectNode.has("dynaModelFilePath") || StringHelper.isNullOrEmpty((String)(strModelRefId = this.getModelRefId())) || objectNode.has("id"))) {
                String strName = null;
                if (objectNode.has("codeName")) {
                    strName = objectNode.get("codeName").asText();
                } else if (objectNode.has("name")) {
                    strName = objectNode.get("name").asText();
                }
                if (!strModelRefId.equals(strName)) {
                    objectNode.put("id", strModelRefId);
                }
            }
            map.remove(strTag);
            if (bNewMap) {
                modelExportMapLocal.set(null);
            }
            return objectNode;
        }
        catch (Exception ex) {
            modelExportMapLocal.set(null);
            log.error((Object)StringHelper.format((String)"\u5bfc\u51fa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            objectNode.put("error", 1);
            objectNode.put("msg", ex.getMessage());
            return objectNode;
        }
    }

    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        PSObjectImpl.fillModelNode(this, objectNode, strModelType);
    }

    public static void fillModelNode(IPSModelObject iPSModelObject, ObjectNode objectNode, String strModelType) throws Exception {
        int n;
        Method[] methods;
        Class<?> intClass;
        HashMap<String, Method> clsMethodMap = null;
        if (!StringHelper.isNullOrEmpty((String)strModelType) && (intClass = iPSModelObject.getModelClass(strModelType)) != null) {
            clsMethodMap = new HashMap<String, Method>();
            Method[] methodArray = methods = intClass.getMethods();
            n = methods.length;
            int n2 = 0;
            while (n2 < n) {
                Method m = methodArray[n2];
                clsMethodMap.put(m.getName(), m);
                ++n2;
            }
        }
        Class<?> modelCls = iPSModelObject.getClass();
        methods = modelCls.getMethods();
        TreeMap<String, Method> methodMap = new TreeMap<String, Method>();
        Method[] methodArray = methods;
        int n3 = methods.length;
        n = 0;
        while (n < n3) {
            PSModelRTMeta meta;
            Method m = methodArray[n];
            if ((clsMethodMap == null || clsMethodMap.containsKey(m.getName())) && (meta = m.getAnnotation(PSModelRTMeta.class)) != null) {
                methodMap.put(m.getName(), m);
            }
            ++n;
        }
        int nDynaModelPubMode = PSObjectImpl.getDynaModelPubMode();
        boolean bIgnorePF = PSObjectImpl.getDynaModelPubIgnorePF();
        for (Map.Entry entry : methodMap.entrySet()) {
            Method m = (Method)entry.getValue();
            PSModelRTMeta meta = m.getAnnotation(PSModelRTMeta.class);
            if (meta == null || meta.debugmode() || meta.hidemethod() || !meta.dump() || (meta.dynamodelmode() & nDynaModelPubMode) == 0 || bIgnorePF && meta.ignorepf()) continue;
            try {
                Object[] objectArray;
                Object objValue;
                String strRealText;
                String strText;
                block52: {
                    strRealText = strText = meta.modelattr();
                    if (StringHelper.isNullOrEmpty((String)strText)) {
                        strRealText = strText = m.getName();
                        if (strText.indexOf("getPS") != 0 && strText.indexOf("getAllPS") != 0) {
                            if (strText.indexOf("get") == 0) {
                                strText = strText.substring(3);
                            } else if (strText.indexOf("is") == 0) {
                                strText = strText.substring(2);
                            }
                            strText = String.valueOf(strText.substring(0, 1).toLowerCase()) + strText.substring(1);
                        }
                    } else if (strText.indexOf("getPS") != 0 && strText.indexOf("getAllPS") != 0) {
                        if (strText.indexOf("get") == 0) {
                            strText = strText.substring(3);
                        } else if (strText.indexOf("is") == 0) {
                            strText = strText.substring(2);
                        }
                        strText = String.valueOf(strText.substring(0, 1).toLowerCase()) + strText.substring(1);
                    }
                    objValue = null;
                    try {
                        objValue = m.invoke(iPSModelObject, new Object[0]);
                    }
                    catch (Exception ex2) {
                        objValue = ex2.getMessage();
                        if (!StringHelper.isNullOrEmpty((Object)objValue)) break block52;
                        if (ex2.getCause() != null) {
                            objValue = ex2.getCause().getMessage();
                        }
                        if (!StringHelper.isNullOrEmpty((Object)objValue)) break block52;
                        objValue = "!\u672a\u77e5\u5f02\u5e38";
                    }
                }
                if (objValue == null) continue;
                if (objValue instanceof IPSModelObject) {
                    String strExportType;
                    IPSModelObject iPSModelObject2;
                    if (meta.child() || meta.dumpref()) {
                        iPSModelObject2 = (IPSModelObject)objValue;
                        ObjectNode childNode = null;
                        if (meta.dumpref()) {
                            strExportType = meta.modelreftype();
                            childNode = iPSModelObject2.toModelRef(strExportType);
                        } else {
                            strExportType = meta.modeltype();
                            childNode = iPSModelObject2.toModel(strExportType);
                        }
                        PSObjectImpl.putJsonProperty(objectNode, strRealText, childNode);
                        continue;
                    }
                    if (!meta.dump() || !(objValue instanceof IPSSysImage) && !(objValue instanceof IPSSysCss) && !(objValue instanceof IPSSysPFPlugin) && !(objValue instanceof IPSSysSFPlugin) && !(objValue instanceof IPSDEOPPriv) && !(objValue instanceof IPSSysUniRes) && !(objValue instanceof IPSLanguageRes)) continue;
                    iPSModelObject2 = (IPSModelObject)objValue;
                    ObjectNode childNode = null;
                    strExportType = meta.modelreftype();
                    childNode = iPSModelObject2.toModelRef(strExportType);
                    PSObjectImpl.putJsonProperty(objectNode, strRealText, childNode);
                    continue;
                }
                if (objValue instanceof Iterator || objValue instanceof ArrayList || objValue.getClass().isArray()) {
                    if (!meta.child()) continue;
                    ArrayList arrList = new ArrayList();
                    if (objValue instanceof Iterator) {
                        Iterator it = (Iterator)objValue;
                        while (it.hasNext()) {
                            Object objItem2 = it.next();
                            arrList.add(objItem2);
                        }
                    } else if (objValue instanceof ArrayList) {
                        for (Object objItem : (ArrayList)objValue) {
                            arrList.add(objItem);
                        }
                    } else if (objValue.getClass().isArray()) {
                        if (objValue instanceof Object[]) {
                            Object[] list2;
                            Object[] objectArray2 = list2 = (Object[])objValue;
                            int n4 = list2.length;
                            int n5 = 0;
                            while (n5 < n4) {
                                Object objItem;
                                objItem = objectArray2[n5];
                                arrList.add(objItem);
                                ++n5;
                            }
                        } else if (objValue instanceof double[]) {
                            double[] list2;
                            objectArray = list2 = (double[])objValue;
                            int n6 = list2.length;
                            int n7 = 0;
                            while (n7 < n6) {
                                double objItem3 = objectArray[n7];
                                arrList.add(objItem3);
                                ++n7;
                            }
                        } else {
                            int[] list2;
                            if (!(objValue instanceof int[])) continue;
                            int[] nArray = list2 = (int[])objValue;
                            int n8 = list2.length;
                            int n9 = 0;
                            while (n9 < n8) {
                                int objItem4 = nArray[n9];
                                arrList.add(objItem4);
                                ++n9;
                            }
                        }
                    }
                    boolean bPSModelArray = false;
                    ArrayNode arrayNode = objectNode.putArray(strText);
                    for (Object objItem5 : arrList) {
                        if (objItem5 instanceof IPSModelObject) {
                            String strExportType;
                            IPSModelObject iPSModelObject2 = (IPSModelObject)objItem5;
                            bPSModelArray = true;
                            ObjectNode childNode = null;
                            if (meta.dumpref()) {
                                strExportType = meta.modelreftype();
                                childNode = iPSModelObject2.toModelRef(strExportType);
                            } else {
                                strExportType = meta.modeltype();
                                childNode = iPSModelObject2.toModel(strExportType);
                            }
                            if (childNode == null) continue;
                            arrayNode.add((JsonNode)childNode);
                            continue;
                        }
                        if (objItem5 instanceof String) {
                            arrayNode.add((String)objItem5);
                            continue;
                        }
                        if (objItem5 instanceof Integer) {
                            arrayNode.add((Integer)objItem5);
                            continue;
                        }
                        if (!(objItem5 instanceof Double)) continue;
                        arrayNode.add((Double)objItem5);
                    }
                    if (arrayNode.size() == 0) {
                        objectNode.remove(strText);
                        continue;
                    }
                    if (!bPSModelArray) continue;
                    objectNode.remove(strText);
                    objectNode.put(strRealText, (JsonNode)arrayNode);
                    continue;
                }
                if (objValue instanceof String && StringHelper.isNullOrEmpty((String)((String)objValue))) continue;
                if (!StringHelper.isNullOrEmpty((String)meta.ignoredumpvalues())) {
                    String strValue = objValue.toString();
                    if (meta.ignoredumpvalues().indexOf(";") == -1) {
                        if (meta.ignoredumpvalues().equals(strValue)) {
                            continue;
                        }
                    } else {
                        boolean bExists = false;
                        String[] items = meta.ignoredumpvalues().split("[;]");
                        objectArray = items;
                        int n10 = items.length;
                        int n11 = 0;
                        while (n11 < n10) {
                            double strItem = objectArray[n11];
                            if (strValue.equals(strItem)) {
                                bExists = true;
                                break;
                            }
                            ++n11;
                        }
                        if (bExists) continue;
                    }
                }
                PSObjectImpl.putJsonProperty(objectNode, strText, objValue);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
        }
    }

    @Override
    public ObjectNode getModelRef() {
        if (!this.isEnableExportModelRef()) {
            return null;
        }
        return this.toModelRefNode(null);
    }

    @Override
    public ObjectNode toModelRef(String strType) {
        if (this.isExportModelAlways() && StringHelper.compare((String)"MUSTREF", (String)strType, (boolean)true) != 0) {
            return this.toModel(strType);
        }
        if (!this.isEnableExportModelRef()) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)strType)) {
            return this.getModelRef();
        }
        return this.toModelRefNode(strType);
    }

    protected boolean isEnableExportModelRef() {
        return true;
    }

    protected boolean isExportModelAlways() {
        return false;
    }

    protected ObjectNode toModelRefNode(String strType) {
        Boolean bRet;
        if (StringHelper.compare((String)MODELREFTYPE_IGNOREDESIGN, (String)strType, (boolean)true) == 0 && (bRet = PSAppViewImpl.getCurrentDesignMode()) != null && bRet.booleanValue()) {
            return this.toModel(null);
        }
        try {
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            this.onFillModelRefNode(objectNode, strType);
            return objectNode;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5bfc\u51fa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\u5f15\u7528\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            objectNode.put("error", 1);
            objectNode.put("msg", ex.getMessage());
            return objectNode;
        }
    }

    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        objectNode.put("modelref", true);
        String strModelRefId = null;
        if (this.isEnableDynaModel()) {
            strModelRefId = this.getDynaModelFilePath();
            if (!StringHelper.isNullOrEmpty((String)strModelRefId)) {
                objectNode.put("path", strModelRefId);
            }
            if (this.isDynaInstModel()) {
                objectNode.put("dynaModel", true);
            }
        }
        if (StringHelper.isNullOrEmpty(strModelRefId) && !StringHelper.isNullOrEmpty((String)(strModelRefId = this.getModelRefId()))) {
            objectNode.put("id", this.getModelRefId());
        }
    }

    @Override
    public String getDumpModelType() {
        return this.getModelType();
    }

    @Override
    public String getCodeName() {
        return null;
    }

    @Override
    public String getPSDynaInstId() {
        if (this.getPSObjectData() != null) {
            return this.getPSObjectData().getParamStringValue(TAG_PSDYNAINSTID, null);
        }
        return null;
    }

    public int getDynaModelLevel() {
        if (this.getPSObjectData() != null) {
            return this.getPSObjectData().GetParamIntValue(TAG_DYNAMODELLEVEL, 0);
        }
        return 0;
    }

    @Override
    public String getModelRefId() {
        String strModelRefId = this.getDynaModelFilePath();
        if (!StringHelper.isNullOrEmpty((String)strModelRefId)) {
            return strModelRefId;
        }
        if (this.isExportModelCodeName() && !StringHelper.isNullOrEmpty((String)(strModelRefId = this.getCodeName()))) {
            return strModelRefId;
        }
        if (this.isExportModelName() && !StringHelper.isNullOrEmpty((String)(strModelRefId = this.getName()))) {
            return strModelRefId;
        }
        return this.getId();
    }

    @Override
    @PSModelRTMeta(description="MOS\u6587\u4ef6\u8def\u5f84", hideempty2=true, dump=false)
    public String getMOSFilePath() {
        return this.onGetMOSFilePath();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6MOS\u6587\u4ef6\u8def\u5f84", hideempty2=true, dump=false)
    public String getRTMOSFilePath() {
        return this.onGetRTMOSFilePath();
    }

    public String getRTMOSFolder() {
        return this.onGetRTMOSFolder();
    }

    public String getRTMOSModelType() {
        return this.getDumpModelType();
    }

    protected String onGetRTMOSFolder() {
        String strRootPath = "";
        if (this.getParentModel() != null && StringHelper.compare((String)"PSSYSTEM", (String)this.getParentModel().getModelType(), (boolean)false) != 0 && StringHelper.isNullOrEmpty((String)(strRootPath = this.getParentModel().getRTMOSFilePath()))) {
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)strRootPath)) {
            return String.valueOf(strRootPath) + "/" + Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    public String getMOSFolder() {
        return this.onGetMOSFolder();
    }

    public String getMOSModelType() {
        return this.getModelType();
    }

    protected String onGetMOSFolder() {
        String strRootPath = "";
        if (this.getParentModel() != null && StringHelper.compare((String)"PSSYSTEM", (String)this.getParentModel().getModelType(), (boolean)false) != 0 && StringHelper.isNullOrEmpty((String)(strRootPath = this.getParentModel().getMOSFilePath()))) {
            return null;
        }
        if (!StringHelper.isNullOrEmpty((String)strRootPath)) {
            return String.valueOf(strRootPath) + "/" + Inflector.getInstance().pluralize((Object)this.getMOSModelType()).toLowerCase();
        }
        return Inflector.getInstance().pluralize((Object)this.getMOSModelType()).toLowerCase();
    }

    protected String onGetMOSFilePath() {
        if (this.isAutoModel()) {
            return null;
        }
        String strMOSFolder = this.getMOSFolder();
        if (StringHelper.isNullOrEmpty((String)strMOSFolder)) {
            return null;
        }
        String strMOSFileName = this.getMOSFileName();
        if (StringHelper.isNullOrEmpty((String)strMOSFileName)) {
            return null;
        }
        return String.format("%1$s/%2$s", strMOSFolder, strMOSFileName);
    }

    public String getRTMOSFileNameMust() {
        String strFileName = this.getRTMOSFileName();
        if (!StringHelper.isNullOrEmpty((String)strFileName)) {
            return strFileName;
        }
        strFileName = "_" + KeyValueHelper.genUniqueId((String)this.getId()).substring(0, 10);
        return strFileName;
    }

    public String getRTMOSFileName() {
        return this.onGetRTMOSFileName();
    }

    protected String onGetRTMOSFileName() {
        return this.getMOSFileName();
    }

    public String getMOSFileName() {
        return this.onGetMOSFileName();
    }

    protected String onGetMOSFileName() {
        String strFileName = this.getCodeName();
        return strFileName;
    }

    protected String onGetRTMOSFilePath() {
        String strMOSFolder = this.getRTMOSFolder();
        if (StringHelper.isNullOrEmpty((String)strMOSFolder)) {
            return null;
        }
        String strMOSFileName = this.getRTMOSFileName();
        if (StringHelper.isNullOrEmpty((String)strMOSFileName)) {
            return null;
        }
        return String.format("%1$s/%2$s", strMOSFolder, strMOSFileName);
    }

    @Override
    public String getWiki() {
        return null;
    }

    public static void putJsonProperty(ObjectNode jsonObject, String strPropertyName, Object objValue) throws Exception {
        if (objValue == null) {
            jsonObject.putNull(strPropertyName);
            return;
        }
        if (objValue instanceof JSONObject) {
            ObjectNode child = jsonObject.putObject(strPropertyName);
            JSONObject node = (JSONObject)objValue;
            Iterator iterator = node.keys();
            if (iterator != null) {
                while (iterator.hasNext()) {
                    String key = (String)iterator.next();
                    Object value = node.get(key);
                    PSObjectImpl.putJsonProperty(child, key, value);
                }
            }
            if (child.size() == 0) {
                jsonObject.remove(strPropertyName);
            }
            return;
        }
        if (objValue instanceof PropertiesEx) {
            PropertiesEx propertiesEx = (PropertiesEx)objValue;
            if (propertiesEx.getMap().size() == 0) {
                return;
            }
            jsonObject.put(strPropertyName, (JsonNode)JsonUtils.toObjectNode((Object)propertiesEx.getMap()));
            return;
        }
        if (objValue instanceof Properties) {
            ObjectNode child = jsonObject.putObject(strPropertyName);
            Properties node = (Properties)objValue;
            for (Object objKey : node.keySet()) {
                String strValue = PropertiesHelper.getProperty((Properties)node, (String)((String)objKey), null);
                if (strValue == null) continue;
                PSObjectImpl.putJsonProperty(child, (String)objKey, strValue);
            }
            if (child.size() == 0) {
                jsonObject.remove(strPropertyName);
            }
            return;
        }
        if (objValue instanceof BigInteger) {
            jsonObject.put(strPropertyName, ((BigInteger)objValue).longValue());
            return;
        }
        if (objValue instanceof String) {
            jsonObject.put(strPropertyName, (String)objValue);
            return;
        }
        if (objValue instanceof Long) {
            jsonObject.put(strPropertyName, (Long)objValue);
            return;
        }
        if (objValue instanceof Integer) {
            jsonObject.put(strPropertyName, (Integer)objValue);
            return;
        }
        if (objValue instanceof Boolean) {
            jsonObject.put(strPropertyName, (Boolean)objValue);
            return;
        }
        if (objValue instanceof Float) {
            jsonObject.put(strPropertyName, (Float)objValue);
            return;
        }
        if (objValue instanceof Double) {
            jsonObject.put(strPropertyName, (Double)objValue);
            return;
        }
        if (objValue instanceof JsonNode) {
            jsonObject.put(strPropertyName, (JsonNode)objValue);
            return;
        }
        if (objValue instanceof Character) {
            jsonObject.put(strPropertyName, (int)((Character)objValue).charValue());
            return;
        }
        if (objValue instanceof BigDecimal) {
            jsonObject.put(strPropertyName, ((BigDecimal)objValue).doubleValue());
            return;
        }
        if (objValue instanceof List) {
            ArrayNode arrayNode = jsonObject.putArray(strPropertyName);
            for (Object obj : (List)objValue) {
                PSObjectImpl.addToArrayNode(arrayNode, obj);
            }
            return;
        }
        if (objValue instanceof Map) {
            ObjectNode child = jsonObject.putObject(strPropertyName);
            Map node = (Map)objValue;
            for (Object key : node.keySet()) {
                Object value = node.get(key);
                PSObjectImpl.putJsonProperty(child, (String)key, value);
            }
            return;
        }
        throw new Exception(StringHelper.format((String)"\u4e0d\u652f\u6301\u7684\u5bf9\u8c61\u7c7b\u578b[%1$s]", (Object)objValue.getClass().getCanonicalName()));
    }

    public static void addToArrayNode(ArrayNode arrayNode, Object objValue) throws Exception {
        if (objValue == null) {
            arrayNode.addNull();
            return;
        }
        if (objValue instanceof JsonNode) {
            arrayNode.add((JsonNode)objValue);
            return;
        }
        if (objValue instanceof String) {
            arrayNode.add((String)objValue);
            return;
        }
        if (objValue instanceof Character) {
            arrayNode.add((int)((Character)objValue).charValue());
            return;
        }
        if (objValue instanceof BigInteger) {
            arrayNode.add((Long)objValue);
            return;
        }
        if (objValue instanceof BigInteger) {
            arrayNode.add(((BigInteger)objValue).longValue());
            return;
        }
        if (objValue instanceof Long) {
            arrayNode.add((Long)objValue);
            return;
        }
        if (objValue instanceof Integer) {
            arrayNode.add((Integer)objValue);
            return;
        }
        if (objValue instanceof Float) {
            arrayNode.add((Float)objValue);
            return;
        }
        if (objValue instanceof Double) {
            arrayNode.add((Double)objValue);
            return;
        }
        if (objValue instanceof BigDecimal) {
            arrayNode.add(((BigDecimal)objValue).doubleValue());
            return;
        }
        if (objValue instanceof Map) {
            arrayNode.add((JsonNode)JsonUtils.toObjectNode((Object)objValue));
            return;
        }
        if (objValue instanceof List) {
            arrayNode.add((JsonNode)JsonUtils.toArrayNode((Object)objValue));
            return;
        }
        throw new Exception(StringHelper.format((String)"\u4e0d\u652f\u6301\u7684\u5bf9\u8c61\u7c7b\u578b[%1$s]", (Object)objValue.getClass().getCanonicalName()));
    }

    public static void setDynaModelPubMode(int nDynaModelPubMode) {
        dynaModelPubModeLocal.set(nDynaModelPubMode);
    }

    public static int getDynaModelPubMode() {
        Integer nDynaModelPubMode = dynaModelPubModeLocal.get();
        return nDynaModelPubMode != null ? nDynaModelPubMode : 7;
    }

    public static void setDynaModelPubIgnorePF(Boolean bDynaModelPubIgnorePF) {
        dynaModelPubIgnorePFLocal.set(bDynaModelPubIgnorePF);
    }

    public static boolean getDynaModelPubIgnorePF() {
        Boolean bDynaModelPubIgnorePF = dynaModelPubIgnorePFLocal.get();
        return bDynaModelPubIgnorePF != null ? bDynaModelPubIgnorePF : false;
    }

    public static void setDynaModelPubIgnorePFReal(Boolean bDynaModelPubIgnorePF2) {
        dynaModelPubIgnorePFLocalReal.set(bDynaModelPubIgnorePF2);
    }

    public static boolean getDynaModelPubIgnorePFReal() {
        Boolean bDynaModelPubIgnorePF2 = dynaModelPubIgnorePFLocalReal.get();
        return bDynaModelPubIgnorePF2 != null ? bDynaModelPubIgnorePF2 : false;
    }

    public static boolean isDynaModelCodeGenMode() {
        return (PSObjectImpl.getDynaModelPubMode() & 8) == 8;
    }

    public static void resetModelExportMap() {
        modelExportMapLocal.set(null);
    }
}

