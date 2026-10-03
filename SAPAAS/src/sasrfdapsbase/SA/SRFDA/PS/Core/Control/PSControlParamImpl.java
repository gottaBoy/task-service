/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control;

import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlParamRuntime;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSControlParamImpl
extends PSObjectImpl
implements IPSControlParam,
IPSControlParamRuntime {
    private static final Log log = LogFactory.getLog(PSControlParamImpl.class);
    protected IPSAppView iPSAppView = null;
    protected PSDEViewCtrl psDEViewCtrl = null;
    private Map<String, Object> ctrlParams = null;
    private Double fWidth = null;
    private Double fHeight = null;
    private Integer nOrderValue = null;
    private String strCtrlParam = null;
    private String strCtrlParam2 = null;
    private String strPSCtrlMsgId = null;
    private String strPSSysPFPluginId = null;
    private String strPSSysCssId = null;
    private Boolean bDefaultCtrl = null;
    private String strUserTag = null;
    private String strUserTag2 = null;
    private String strPSDEUILogicGroupId = null;
    private String strPSDynaModelId = null;
    private Properties properties = null;
    private String strRefCtrlName = null;
    private String strRefCtrl2Name = null;
    private String strInstallUIEngine = null;
    private String strInstallUIEngine2 = null;
    private String strPredefinedType = null;
    private String strPSDEId = null;
    private Integer nDynaSysMode = null;
    private Integer nPriority = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSAppView iPSAppView, PSDEViewCtrl psDEViewCtrl) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSAppView(iPSAppView);
        this.setPSDEViewCtrlData(psDEViewCtrl);
        this.setName(this.psDEViewCtrl.getPSDEVIEWCTRLNAME());
        if (!psDEViewCtrl.isWIDTHNull() && psDEViewCtrl.getWIDTH() >= 0.0f) {
            this.fWidth = (double)psDEViewCtrl.getWIDTH();
        }
        if (!psDEViewCtrl.isHEIGHTNull() && psDEViewCtrl.getHEIGHT() >= 0.0f) {
            this.fHeight = (double)psDEViewCtrl.getHEIGHT();
        }
        if (!psDEViewCtrl.isORDERVALUENull() && psDEViewCtrl.getORDERVALUE() >= 0) {
            this.nOrderValue = psDEViewCtrl.getORDERVALUE();
        }
        if (!psDEViewCtrl.isUSERTAGNull()) {
            this.strUserTag = psDEViewCtrl.getUSERTAG();
        }
        if (!psDEViewCtrl.isUSERTAG2Null()) {
            this.strUserTag2 = psDEViewCtrl.getUSERTAG2();
        }
        if (!psDEViewCtrl.isPSSYSDYNAMODELIDNull()) {
            this.strPSDynaModelId = psDEViewCtrl.getPSSYSDYNAMODELID();
        }
        if (!psDEViewCtrl.isCTRLPARAMNull()) {
            this.strCtrlParam = psDEViewCtrl.getCTRLPARAM();
        }
        if (!psDEViewCtrl.isCTRLPARAM2Null()) {
            this.strCtrlParam2 = psDEViewCtrl.getCTRLPARAM2();
        }
        if (!psDEViewCtrl.isPSSYSPFPLUGINIDNull()) {
            this.strPSSysPFPluginId = psDEViewCtrl.getPSSYSPFPLUGINID();
        }
        if (!psDEViewCtrl.isPSSYSCSSIDNull()) {
            this.strPSSysCssId = psDEViewCtrl.getPSSYSCSSID();
        }
        if (!psDEViewCtrl.isPSCTRLMSGIDNull()) {
            this.strPSCtrlMsgId = psDEViewCtrl.getPSCTRLMSGID();
        }
        if (!psDEViewCtrl.isPSCTRLLOGICGROUPIDNull()) {
            this.strPSDEUILogicGroupId = psDEViewCtrl.getPSCTRLLOGICGROUPID();
        }
        if (!psDEViewCtrl.isDEFAULTFLAGNull()) {
            this.bDefaultCtrl = psDEViewCtrl.getDEFAULTFLAG();
        }
        if (!psDEViewCtrl.isREFCTRLNAMENull()) {
            this.strRefCtrlName = psDEViewCtrl.getREFCTRLNAME();
        }
        if (!psDEViewCtrl.isREFCTRL2NAMENull()) {
            this.strRefCtrl2Name = psDEViewCtrl.getREFCTRL2NAME();
        }
        if (!psDEViewCtrl.isREFCTRLUSAGENull()) {
            this.strInstallUIEngine = psDEViewCtrl.getREFCTRLUSAGE();
        }
        if (!psDEViewCtrl.isREFCTRL2USAGENull()) {
            this.strInstallUIEngine2 = psDEViewCtrl.getREFCTRL2USAGE();
        }
        if (!psDEViewCtrl.isPREDEFINEDTYPENull()) {
            this.strPredefinedType = psDEViewCtrl.getPREDEFINEDTYPE();
        }
        if (!psDEViewCtrl.isPSDEIDNull()) {
            this.strPSDEId = psDEViewCtrl.getPSDEID();
        }
        if (!psDEViewCtrl.isENABLEDYNASYSNull() && psDEViewCtrl.getENABLEDYNASYS() >= 0) {
            this.nDynaSysMode = psDEViewCtrl.getENABLEDYNASYS();
        }
        if (!this.psDEViewCtrl.isDYNCMODENull() && this.psDEViewCtrl.getDYNCMODE() >= 10) {
            this.nPriority = this.psDEViewCtrl.getDYNCMODE();
        }
        if (!StringHelper.isNullOrEmpty((String)psDEViewCtrl.getCTRLPARAMS())) {
            this.properties = PropertiesHelper.load((String)psDEViewCtrl.getCTRLPARAMS());
            for (Object objKey : this.properties.keySet()) {
                String strValue = PropertiesHelper.getProperty((Properties)this.properties, (String)objKey.toString());
                this.setCtrlParam(objKey.toString(), strValue);
            }
        }
        this.onInit();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected boolean hasPSSysDynaModel() {
        return false;
    }

    public void merge(IPSControlParam iPSControlParam) {
        this.onMerge(iPSControlParam);
    }

    protected void onMerge(IPSControlParam iPSControlParam) {
        Iterator<String> ctrlParamNames;
        if (!StringHelper.isNullOrEmpty((String)iPSControlParam.getName())) {
            this.setName(iPSControlParam.getName());
        }
        if (iPSControlParam.getPSAppView() != null) {
            this.setPSAppView(iPSControlParam.getPSAppView());
        }
        if (iPSControlParam.getWidth() != null) {
            this.setWidth(iPSControlParam.getWidth());
        }
        if (iPSControlParam.getHeight() != null) {
            this.setHeight(iPSControlParam.getHeight());
        }
        if (iPSControlParam.getOrderValue() != null) {
            this.setOrderValue(iPSControlParam.getOrderValue());
        }
        if (iPSControlParam.getUserTag() != null) {
            this.setUserTag(iPSControlParam.getUserTag());
        }
        if (iPSControlParam.getUserTag2() != null) {
            this.setUserTag2(iPSControlParam.getUserTag2());
        }
        if (iPSControlParam.getPSDynaModelId() != null) {
            this.setPSDynaModelId(iPSControlParam.getPSDynaModelId());
        }
        if (iPSControlParam.getCtrlParam() != null) {
            this.setCtrlParam(iPSControlParam.getCtrlParam());
        }
        if (iPSControlParam.getCtrlParam2() != null) {
            this.setCtrlParam2(iPSControlParam.getCtrlParam2());
        }
        if (iPSControlParam.getPSCtrlMsgId() != null) {
            this.setPSCtrlMsgId(iPSControlParam.getPSCtrlMsgId());
        }
        if (iPSControlParam.getPSDEUILogicGroupId() != null) {
            this.setPSDEUILogicGroupId(iPSControlParam.getPSDEUILogicGroupId());
        }
        if (iPSControlParam.getPSSysPFPluginId() != null) {
            this.setPSSysPFPluginId(iPSControlParam.getPSSysPFPluginId());
        }
        if (iPSControlParam.getPSSysCssId() != null) {
            this.setPSSysCssId(iPSControlParam.getPSSysCssId());
        }
        if (iPSControlParam.getRefCtrlName() != null) {
            this.setRefCtrlName(iPSControlParam.getRefCtrlName());
        }
        if (iPSControlParam.getRefCtrl2Name() != null) {
            this.setRefCtrl2Name(iPSControlParam.getRefCtrl2Name());
        }
        if (iPSControlParam.getInstallUIEngine() != null) {
            this.setInstallUIEngine(iPSControlParam.getInstallUIEngine());
        }
        if (iPSControlParam.getInstallUIEngine2() != null) {
            this.setInstallUIEngine2(iPSControlParam.getInstallUIEngine2());
        }
        if (iPSControlParam.getPredefinedType() != null) {
            this.setPredefinedType(iPSControlParam.getPredefinedType());
        }
        if (iPSControlParam.getPSDEId() != null) {
            this.setPSDEId(iPSControlParam.getPSDEId());
        }
        if (iPSControlParam.isDefaultCtrl() != null) {
            this.setDefaultCtrl(iPSControlParam.isDefaultCtrl());
        }
        if (iPSControlParam.getPriority() != null) {
            this.setPriority(iPSControlParam.getPriority());
        }
        if (iPSControlParam.getDynaSysMode() != null) {
            this.setDynaSysMode(iPSControlParam.getDynaSysMode());
        }
        if (iPSControlParam.getCtrlParams() != null) {
            this.setCtrlParams(iPSControlParam.getCtrlParams());
        }
        if ((ctrlParamNames = iPSControlParam.getCtrlParamNames()) != null) {
            while (ctrlParamNames.hasNext()) {
                String strParamName = ctrlParamNames.next();
                Object objValue = iPSControlParam.getCtrlParam(strParamName);
                this.setCtrlParam(strParamName, objValue);
            }
        }
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.iPSAppView;
    }

    public void setPSAppView(IPSAppView iPSAppView) {
        this.iPSAppView = iPSAppView;
    }

    protected void setPSDEViewCtrlData(PSDEViewCtrl psDEViewCtrl) {
        this.psDEViewCtrl = psDEViewCtrl;
    }

    public void setCtrlParam(String strParamName, Object objValue) {
        if (this.ctrlParams == null) {
            this.ctrlParams = new LinkedHashMap<String, Object>();
        }
        strParamName = strParamName.toUpperCase();
        this.ctrlParams.put(strParamName, objValue);
    }

    @Override
    public Object getCtrlParam(String strParamName) {
        if (this.ctrlParams == null) {
            return null;
        }
        return this.ctrlParams.get(strParamName.toUpperCase());
    }

    @Override
    public boolean containsCtrlParam(String strParamName) {
        if (this.ctrlParams == null) {
            return false;
        }
        return this.ctrlParams.get(strParamName.toUpperCase()) != null;
    }

    @Override
    public String getCtrlParam(String strParamName, String strDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        return objValue.toString();
    }

    @Override
    public boolean getCtrlParam(String strParamName, boolean bDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return bDefault;
        }
        return StringHelper.compare((String)objValue.toString(), (String)"TRUE", (boolean)true) == 0;
    }

    @Override
    public int getCtrlParam(String strParamName, int nDefault) {
        Object objValue = this.getCtrlParam(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            return Integer.parseInt(objValue.toString());
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return nDefault;
        }
    }

    @Override
    public Iterator<String> getCtrlParamNames() {
        if (this.ctrlParams == null) {
            return null;
        }
        return this.ctrlParams.keySet().iterator();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSAppView.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u5bbd\u5ea6", ignorert=3)
    public Double getWidth() {
        return this.fWidth;
    }

    @Override
    @PSModelRTMeta(description="\u9ad8\u5ea6", ignorert=3)
    public Double getHeight() {
        return this.fHeight;
    }

    public void setWidth(Double fWidth) {
        this.fWidth = fWidth;
    }

    public void setHeight(Double fHeight) {
        this.fHeight = fHeight;
    }

    @Override
    public PSDEViewCtrl getPSDEViewCtrlData() {
        return this.psDEViewCtrl;
    }

    @Override
    public Integer getOrderValue() {
        return this.nOrderValue;
    }

    public void setOrderValue(Integer nOrderValue) {
        this.nOrderValue = nOrderValue;
    }

    @Override
    public String getCtrlParam() {
        return this.strCtrlParam;
    }

    public void setCtrlParam(String strCtrlParam) {
        this.strCtrlParam = strCtrlParam;
    }

    @Override
    public String getCtrlParam2() {
        return this.strCtrlParam2;
    }

    public void setCtrlParam2(String strCtrlParam2) {
        this.strCtrlParam2 = strCtrlParam2;
    }

    @Override
    public String getPSCtrlMsgId() {
        return this.strPSCtrlMsgId;
    }

    public void setPSCtrlMsgId(String strCtrlMsgId) {
        this.strPSCtrlMsgId = strCtrlMsgId;
    }

    @Override
    public String getPSDEUILogicGroupId() {
        return this.strPSDEUILogicGroupId;
    }

    @Override
    public void setPSDEUILogicGroupId(String strPSDEUILogicGroupId) {
        this.strPSDEUILogicGroupId = strPSDEUILogicGroupId;
    }

    @Override
    public String getPSSysPFPluginId() {
        return this.strPSSysPFPluginId;
    }

    @Override
    public void setPSSysPFPluginId(String strSysPFPluginId) {
        this.strPSSysPFPluginId = strSysPFPluginId;
    }

    @Override
    public String getPSSysCssId() {
        return this.strPSSysCssId;
    }

    @Override
    public void setPSSysCssId(String strSysCssId) {
        this.strPSSysCssId = strSysCssId;
    }

    @Override
    public Boolean isDefaultCtrl() {
        return this.bDefaultCtrl;
    }

    public void setDefaultCtrl(Boolean bDefaultCtrl) {
        this.bDefaultCtrl = bDefaultCtrl;
    }

    @Override
    public String getUserTag() {
        return this.strUserTag;
    }

    @Override
    public String getUserTag2() {
        return this.strUserTag2;
    }

    public void setUserTag(String strUserTag) {
        this.strUserTag = strUserTag;
    }

    public void setUserTag2(String strUserTag2) {
        this.strUserTag2 = strUserTag2;
    }

    @Override
    public String getPSDynaModelId() {
        return this.strPSDynaModelId;
    }

    @Override
    public void setPSDynaModelId(String strPSDynaModelId) {
        this.strPSDynaModelId = strPSDynaModelId;
    }

    @Override
    public String getRefCtrlName() {
        return this.strRefCtrlName;
    }

    @Override
    public void setRefCtrlName(String strRefCtrlName) {
        this.strRefCtrlName = strRefCtrlName;
    }

    @Override
    public String getRefCtrl2Name() {
        return this.strRefCtrl2Name;
    }

    @Override
    public void setRefCtrl2Name(String strRefCtrl2Name) {
        this.strRefCtrl2Name = strRefCtrl2Name;
    }

    @Override
    public String getInstallUIEngine() {
        return this.strInstallUIEngine;
    }

    @Override
    public void setInstallUIEngine(String strInstallUIEngine) {
        this.strInstallUIEngine = strInstallUIEngine;
    }

    @Override
    public String getInstallUIEngine2() {
        return this.strInstallUIEngine2;
    }

    @Override
    public void setInstallUIEngine2(String strInstallUIEngine2) {
        this.strInstallUIEngine2 = strInstallUIEngine2;
    }

    @Override
    public String getPredefinedType() {
        return this.strPredefinedType;
    }

    public void setPredefinedType(String strPredefinedType) {
        this.strPredefinedType = strPredefinedType;
    }

    @Override
    public String getPSDEId() {
        return this.strPSDEId;
    }

    public void setPSDEId(String strPSDEId) {
        this.strPSDEId = strPSDEId;
    }

    @Override
    public String getModelType() {
        return "PSDEVIEWCTRL";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppView() != null) {
            return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSAppView().getId(), (Object)this.getName());
        }
        return super.getModelId();
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u53c2\u6570\u96c6\u5408")
    public Properties getCtrlParams() {
        return this.properties;
    }

    public void setCtrlParams(Properties properties) {
        this.properties = properties;
    }

    public void setCtrlParams(String strCtrlParams) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)strCtrlParams)) {
            this.properties = PropertiesHelper.load((String)strCtrlParams);
            for (Object objKey : this.properties.keySet()) {
                String strValue = PropertiesHelper.getProperty((Properties)this.properties, (String)objKey.toString());
                this.setCtrlParam(objKey.toString(), strValue);
            }
        }
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        Iterator<String> keys;
        super.onFillModelNode(objectNode, strModelType);
        if (objectNode.has("ctrlParams")) {
            objectNode.remove("ctrlParams");
        }
        if ((keys = this.getCtrlParamNames()) != null) {
            ObjectNode paramNode = JsonNodeHelper.createObjectNode();
            while (keys.hasNext()) {
                String objKey = keys.next();
                Object objValue = this.getCtrlParam(objKey);
                if (objValue == null) continue;
                PSControlParamImpl.putJsonProperty(paramNode, objKey, objValue);
            }
            if (paramNode.size() != 0) {
                objectNode.put("ctrlParams", (JsonNode)paramNode);
            }
        }
    }

    @Override
    public Integer getDynaSysMode() {
        return this.nDynaSysMode;
    }

    public void setDynaSysMode(Integer nDynaSysMode) {
        this.nDynaSysMode = nDynaSysMode;
    }

    @Override
    public Integer getPriority() {
        return this.nPriority;
    }

    public void setPriority(Integer nPriority) {
        this.nPriority = nPriority;
    }
}
