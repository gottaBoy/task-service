/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.Helper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.util.StringUtils
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSFPluginTempl;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFPluginTempl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Data.PSSysSFPlugin;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.Helper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class PSSysSFPluginImpl
extends PSSystemObjectImpl
implements IPSSysSFPlugin,
IPSModelSortable {
    static final String PLUGINPARAM_RUNTIMEOBJECT = "RUNTIMEOBJECT";
    static final String PLUGINPARAM_REPLACEDEFAULT = "REPLACEDEFAULT";
    static final String PLUGINPARAM_TEMPLATEMODE = "TEMPLATEMODE";
    static final String PLUGINPARAM_TEMPLATEFUNC = "TEMPLATEFUNC";
    static final String PLUGINPARAM_TRYMODE = "TRYMODE";
    private static Map<String, String> codeNameMap = new HashMap<String, String>();
    private static final Log log;
    protected PSSysSFPlugin psSysSFPlugin = null;
    private String strPSSFPluginId = null;
    private String strPluginType = null;
    private ThreadLocal<Integer> currentThreadCallCount = new ThreadLocal();
    private List<IPSSysSFPluginTempl> psSysSFPluginTemplList = null;
    private String strCodeName = null;
    private boolean bRuntimeObject = false;
    private String strRTObjectName = null;
    private String strRTObjectRepo = null;
    private int nRTObjectSource = 0;
    private Properties pluginParams = null;
    private ObjectNode pluginModel = null;
    private boolean bReplaceDefault = false;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bTryMode = false;
    private boolean bTemplateMode = false;
    private String strRealCode = null;
    private String strTemplateFunc = null;
    private int nOrderValue = 99999;

    static {
        codeNameMap.put("CODE", "");
        codeNameMap.put("CODE2", "");
        codeNameMap.put("CODE3", "");
        codeNameMap.put("CODE4", "");
        codeNameMap.put("CODE5", "");
        codeNameMap.put("CODE6", "");
        log = LogFactory.getLog(PSSysSFPluginImpl.class);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysSFPlugin psSysSFPlugin) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysSFPlugin = psSysSFPlugin;
            this.setId(this.psSysSFPlugin.getPSSYSSFPLUGINID());
            this.setName(this.psSysSFPlugin.getPSSYSSFPLUGINNAME());
            this.setPSObjectData(this.psSysSFPlugin);
            this.strPluginType = this.psSysSFPlugin.getPLUGINTYPE();
            this.strPSSFPluginId = this.psSysSFPlugin.getPSSFPLUGINID();
            this.strCodeName = this.psSysSFPlugin.getCODENAME();
            if (!StringHelper.isNullOrEmpty((String)this.psSysSFPlugin.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysSFPlugin.getPSMODULEID());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSFPlugin.getPLUGINMODEL())) {
                this.pluginModel = (ObjectNode)JsonNodeHelper.fromString((String)this.psSysSFPlugin.getPLUGINMODEL());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysSFPlugin.getPLUGINPARAMS())) {
                this.pluginParams = PropertiesHelper.load((String)this.psSysSFPlugin.getPLUGINPARAMS());
            }
            if (!this.psSysSFPlugin.isRTOBJECTMODENull()) {
                this.nRTObjectSource = this.psSysSFPlugin.getRTOBJECTMODE();
                if (this.getRTObjectSource() != 0) {
                    this.bRuntimeObject = true;
                    this.strRTObjectName = this.psSysSFPlugin.getRTOBJECTNAME();
                    this.strRTObjectRepo = this.psSysSFPlugin.getRTOBJECTREPO();
                }
            } else {
                this.strRTObjectName = this.getPluginParam(PLUGINPARAM_RUNTIMEOBJECT, null);
                if (!StringHelper.isNullOrEmpty((String)this.strRTObjectName)) {
                    this.bRuntimeObject = true;
                    this.nRTObjectSource = 1;
                }
            }
            this.bReplaceDefault = !this.psSysSFPlugin.isREPDEFAULTNull() ? this.psSysSFPlugin.getREPDEFAULT() : this.getPluginParam(PLUGINPARAM_REPLACEDEFAULT, false);
            this.bTryMode = this.getPluginParam(PLUGINPARAM_TRYMODE, false);
            this.bTemplateMode = !this.psSysSFPlugin.isTEMPLATEMODENull() ? this.psSysSFPlugin.getTEMPLATEMODE() == 1 : this.getPluginParam(PLUGINPARAM_TEMPLATEMODE, false);
            this.strTemplateFunc = !StringHelper.isNullOrEmpty((String)this.psSysSFPlugin.getTEMPLATEFUNC()) ? this.psSysSFPlugin.getTEMPLATEFUNC() : this.getPluginParam(PLUGINPARAM_TEMPLATEFUNC, null);
            if (!this.psSysSFPlugin.isORDERVALUENull() && this.psSysSFPlugin.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psSysSFPlugin.getORDERVALUE();
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
    @PSModelRTMeta(description="\u63d2\u4ef6\u7c7b\u578b", codelist="SFPluginType", group="\u57fa\u672c", order=125, fields={"PLUGINTYPE"})
    public String getPluginType() {
        return this.strPluginType;
    }

    @Override
    public String getPSSFPluginId() {
        return this.strPSSFPluginId;
    }

    @Override
    public IPSSFPluginTempl getPSSFPluginTempl(String strPSSFId) throws Exception {
        try {
            String strPSSysSFPluginTemplId = Helper.GenUniqueId((String)this.getId(), (String)strPSSFId);
            IPSSysSFPluginTempl iPSSFPluginTempl = this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, !StringHelper.isNullOrEmpty((String)this.getPSSFPluginId()));
            if (iPSSFPluginTempl != null) {
                return iPSSFPluginTempl;
            }
            strPSSysSFPluginTemplId = Helper.GenUniqueId((String)this.getPSSFPluginId(), (String)strPSSFId);
            return this.getPSModelStorage().getPSSFPluginTempl(strPSSysSFPluginTemplId);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u670d\u52a1\u6846\u67b6\u63d2\u4ef6\u6a21\u677f[%1$s][%2$s]", (Object)this.getName(), (Object)strPSSFId), ex);
        }
    }

    @Override
    public IPSSFPluginTempl getPSSFPluginTempl(String strPSSFId, boolean bTryMode) throws Exception {
        try {
            String strPSSysSFPluginTemplId = Helper.GenUniqueId((String)this.getId(), (String)strPSSFId);
            return this.getPSSystem().getPSSysSFPluginTempl(strPSSysSFPluginTemplId, bTryMode);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u670d\u52a1\u6846\u67b6\u63d2\u4ef6\u6a21\u677f[%1$s][%2$s]", (Object)this.getName(), (Object)strPSSFId), ex);
        }
    }

    @Override
    public String getModelType() {
        return "PSSYSSFPLUGIN";
    }

    @Override
    public String getCode(String strCodeType) throws Exception {
        try {
            this.logCallCount(1);
            Map<String, Object> params = PSTemplHelper.getCurrentParams();
            if (params == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSObject iPSSF = null;
            Object objSF = params.get("sf");
            if (objSF != null && objSF instanceof IPSSF) {
                iPSSF = (IPSSF)objSF;
            }
            if (iPSSF == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSSFPluginTempl iPSSFPluginTempl = this.getPSSFPluginTempl(iPSSF.getId());
            String strCodeName = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType);
            String strCode = PSTemplHelper.generateCode(iPSSFPluginTempl.getPSSFPluginTemplData(), strCodeName);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    private void logCallCount(int nStep) throws Exception {
        Integer nValue = this.currentThreadCallCount.get();
        if (nValue == null) {
            if (nStep <= 0) {
                return;
            }
            nValue = 0;
        }
        if ((nValue = Integer.valueOf(nValue + nStep)) <= 0) {
            this.currentThreadCallCount.set(null);
        } else {
            if (nValue >= 3) {
                this.currentThreadCallCount.set(null);
                throw new Exception(StringHelper.format((String)"\u540e\u53f0\u6a21\u677f\u63d2\u4ef6[%1$s]\u5b58\u5728\u9012\u5f52\u8c03\u7528", (Object)this.getName()));
            }
            this.currentThreadCallCount.set(nValue);
        }
    }

    @Override
    public boolean hasCode(String strCodeType) throws Exception {
        Map<String, Object> params = PSTemplHelper.getCurrentParams();
        if (params == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSObject iPSSF = null;
        Object objSF = params.get("sf");
        if (objSF != null && objSF instanceof IPSSF) {
            iPSSF = (IPSSF)objSF;
        }
        if (iPSSF == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSSFPluginTempl iPSSysSFPluginTempl = this.getPSSFPluginTempl(iPSSF.getId());
        String strCodeName = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType);
        String strCode = iPSSysSFPluginTempl.getPSSFPluginTemplData().getParamStringValue(strCodeName, "");
        return !StringHelper.isNullOrEmpty((String)strCode);
    }

    @Override
    public String getXCode(String strCodeType, Object objItem, Map<String, Object> params) throws Exception {
        try {
            this.logCallCount(1);
            if (StringHelper.isNullOrEmpty((String)strCodeType)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u7c7b\u578b");
            }
            HashMap<String, Object> paramMap = new HashMap<String, Object>();
            Map<String, Object> curParams = PSTemplHelper.getCurrentParams();
            if (curParams != null) {
                paramMap.putAll(curParams);
            }
            if (params != null) {
                paramMap.putAll(params);
            }
            if (objItem != null) {
                paramMap.put("item", objItem);
            }
            String strPSSFId = null;
            Object objSF = paramMap.get("sf");
            if (objSF != null && objSF instanceof IPSSF) {
                strPSSFId = ((IPSSF)objSF).getId();
            }
            if (StringHelper.isNullOrEmpty(strPSSFId)) {
                strPSSFId = this.getPSSystem().getPSSFId();
            }
            IPSSFPluginTempl iPSSysSFPluginTempl = this.getPSSFPluginTempl(strPSSFId);
            String strCodeName = null;
            String strCodeType2 = strCodeType.toUpperCase();
            strCodeName = codeNameMap.containsKey(strCodeType2) ? StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType) : "TEMPLCODE";
            String strCode = PSTemplHelper.generateCode(iPSSysSFPluginTempl.getPSSFPluginTemplData(), strCodeName, paramMap);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u6a21\u677f\u96c6\u5408")
    public Iterator<IPSSysSFPluginTempl> getPSSysSFPluginTempls() throws Exception {
        if (this.psSysSFPluginTemplList == null) {
            ArrayList<IPSSysSFPluginTempl> psSysSFPluginTemplList = new ArrayList<IPSSysSFPluginTempl>();
            Iterator<IPSSysSFPluginTempl> psSysSFPluginTempls = this.getPSSystem().getAllPSSysSFPluginTempls();
            if (psSysSFPluginTempls != null) {
                while (psSysSFPluginTempls.hasNext()) {
                    IPSSysSFPluginTempl iPSSysSFPluginTempl = psSysSFPluginTempls.next();
                    if (StringHelper.compare((String)iPSSysSFPluginTempl.getPSSysSFPlugin().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psSysSFPluginTemplList.add(iPSSysSFPluginTempl);
                }
            }
            if (this.psSysSFPluginTemplList == null) {
                this.psSysSFPluginTemplList = psSysSFPluginTemplList;
            }
        }
        if (this.psSysSFPluginTemplList == null || this.psSysSFPluginTemplList.size() == 0) {
            return null;
        }
        return this.psSysSFPluginTemplList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u4ee3\u7801")
    public String getPluginCode() {
        return this.getCodeName();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isRuntimeObject() {
        return this.bRuntimeObject;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u6765\u6e90", codelist="PluginRTMode", ignoredumpvalues="0", fields={"RTOBJECTMODE"})
    public int getRTObjectSource() {
        return this.nRTObjectSource;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u540d\u79f0", hideempty2=true, fields={"RTOBJECTNAME"})
    public String getRTObjectName() {
        return this.strRTObjectName;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u4ed3\u5e93", hideempty2=true, fields={"RTOBJECTREPO"})
    public String getRTObjectRepo() {
        return this.strRTObjectRepo;
    }

    @Override
    public int getPluginParam(String strParam, int nDefault) {
        return PropertiesHelper.getProperty((Properties)this.getPluginParams(), (String)strParam, (int)nDefault);
    }

    @Override
    public String getPluginParam(String strParam, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.getPluginParams(), (String)strParam, (String)strDefault);
    }

    @Override
    public double getPluginParam(String strParam, double fDefault) {
        return PropertiesHelper.getProperty((Properties)this.getPluginParams(), (String)strParam, (double)fDefault);
    }

    @Override
    public boolean getPluginParam(String strParam, boolean bDefault) {
        return PropertiesHelper.getProperty((Properties)this.getPluginParams(), (String)strParam, (boolean)bDefault);
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"PLUGINPARAMS"})
    public Properties getPluginParams() {
        return this.pluginParams;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u6a21\u578b", hideempty=true)
    public ObjectNode getPluginModel() {
        return this.pluginModel;
    }

    @Override
    @PSModelRTMeta(description="\u5168\u5c40\u9ed8\u8ba4\u66ff\u6362", ignoredumpvalues="false")
    public boolean isReplaceDefault() {
        return this.bReplaceDefault;
    }

    @Override
    @PSModelRTMeta(description="\u5c1d\u8bd5\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isTryMode() {
        return this.bTryMode;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757", dumpref=true, dynamodelmode=4, fields={"PSMODULEID"})
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.isTemplateMode()) {
            String strRealCode = this.getRealCode();
            objectNode.remove("templCode");
            objectNode.put("templCode", strRealCode);
        }
    }

    @Override
    protected ObjectNode toModelRefNode(String strType) {
        if (this.isRuntimeObject()) {
            return super.toModelRefNode(strType);
        }
        try {
            Enumeration<Object> keys;
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            if (!StringHelper.isNullOrEmpty((String)this.getPluginType())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"pluginType", (Object)this.getPluginType());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getCodeName())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"pluginCode", (Object)this.getCodeName());
            }
            if (!objectNode.has("getUserParam") && (keys = this.getUserParamNames()) != null) {
                ObjectNode paramNode = JsonNodeHelper.createObjectNode();
                while (keys.hasMoreElements()) {
                    Object objKey = keys.nextElement();
                    Object objValue = this.getUserParam((String)objKey);
                    if (objValue == null) continue;
                    PSSysSFPluginImpl.putJsonProperty(paramNode, (String)objKey, objValue);
                }
                if (paramNode.size() != 0) {
                    objectNode.put("getUserParam", (JsonNode)paramNode);
                }
            }
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

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u6a21\u677f\u4ee3\u7801")
    public String getTemplCode() {
        return this.getTemplCodeX("CODE");
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u6a21\u677f\u4ee3\u78012")
    public String getTemplCode2() {
        return this.getTemplCodeX("CODE2");
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u6a21\u677f\u4ee3\u78013")
    public String getTemplCode3() {
        return this.getTemplCodeX("CODE3");
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u6a21\u677f\u4ee3\u78014")
    public String getTemplCode4() {
        return this.getTemplCodeX("CODE4");
    }

    protected String getTemplCodeX(String strCode) {
        if ((this.isRuntimeObject() || PSObjectImpl.isDynaModelCodeGenMode()) && StringUtils.hasLength((String)this.getPSSystem().getPSSFId())) {
            try {
                IPSSFPluginTempl iPSSFPluginTempl = this.getPSSFPluginTempl(this.getPSSystem().getPSSFId(), true);
                if (iPSSFPluginTempl != null) {
                    return iPSSFPluginTempl.getCode(strCode);
                }
            }
            catch (Exception ex) {
                return ex.getMessage();
            }
        }
        return null;
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u5ef6\u8fdf\u52a0\u8f7d\u6a21\u5f0f", ignoredumpvalues="false")
    public boolean isLazyMode() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u6807\u8bb0", hideempty=true, fields={"PLUGINTAG"})
    public String getPluginTag() {
        return this.psSysSFPlugin.getPLUGINTAG();
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u6807\u8bb02", hideempty=true, fields={"PLUGINTAG2"})
    public String getPluginTag2() {
        return this.psSysSFPlugin.getPLUGINTAG2();
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4f8b\u6a21\u5f0f", ignoredumpvalues="false", fields={"SINGLEINSTMODE"})
    public boolean isSingleInstance() {
        return this.psSysSFPlugin.getSINGLEINSTMODE();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u6a21\u5f0f", ignoredumpvalues="false", dump=false)
    public boolean isTemplateMode() {
        return this.bTemplateMode;
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u51fd\u6570", dump=false)
    public String getTemplateFunc() {
        return this.strTemplateFunc;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u9645\u4ee3\u7801", dump=false)
    public String getRealCode() {
        if (!this.isTemplateMode()) {
            return null;
        }
        if (StringHelper.isNullOrEmpty((String)this.strRealCode)) {
            try {
                this.strRealCode = this.doGetRealCode();
            }
            catch (Exception ex) {
                this.strRealCode = ex.getMessage();
            }
        }
        return this.strRealCode;
    }

    protected String doGetRealCode() throws Exception {
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("item", this);
        paramMap.put("sys", this.getPSSystem());
        String strCodeName = "TEMPLCODE";
        BaseDataEntity baseDataEntity = new BaseDataEntity();
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTemplCode());
        String strTemplateFunc = this.getTemplateFunc();
        if (!StringHelper.isNullOrEmpty((String)strTemplateFunc)) {
            strTemplateFunc = strTemplateFunc.replace(",", ";");
            String[] parts = (strTemplateFunc = strTemplateFunc.replace(" ", "")).split("[;]");
            if (parts != null) {
                String[] stringArray = parts;
                int n = parts.length;
                int n2 = 0;
                while (n2 < n) {
                    Iterator<IPSSysSFPlugin> psSysSFPlugins;
                    String strItem = stringArray[n2];
                    if (!StringHelper.isNullOrEmpty((String)strItem) && (psSysSFPlugins = this.getPSSystem().getAllPSSysSFPlugins()) != null) {
                        String strCode;
                        IPSSFPluginTempl iPSSFPluginTempl;
                        IPSSysSFPlugin iPSSysSFPlugin = null;
                        while (psSysSFPlugins.hasNext()) {
                            IPSSysSFPlugin item = psSysSFPlugins.next();
                            if (!strItem.equalsIgnoreCase(item.getCodeName())) continue;
                            iPSSysSFPlugin = item;
                            break;
                        }
                        if (iPSSysSFPlugin != null && (iPSSFPluginTempl = iPSSysSFPlugin.getPSSFPluginTempl(this.getPSSystem().getPSSFId(), true)) != null && !StringHelper.isNullOrEmpty((String)(strCode = iPSSFPluginTempl.getCode("CODE")))) {
                            sb.append("\r\n");
                            sb.append(strCode);
                        }
                    }
                    ++n2;
                }
            }
        }
        baseDataEntity.set(strCodeName, (Object)sb.toString());
        return PSTemplHelper.generateCode(baseDataEntity, strCodeName, paramMap, false);
    }
}

