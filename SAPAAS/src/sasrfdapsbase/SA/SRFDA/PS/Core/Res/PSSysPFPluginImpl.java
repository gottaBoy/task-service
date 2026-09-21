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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile
 *  net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.IPSModelSortable;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin2;
import SA.SRFDA.PS.Core.PF.IPSPFPluginTempl;
import SA.SRFDA.PS.Core.PF.IPSPFPluginType;
import SA.SRFDA.PS.Core.PF.IPSPFPubCode2;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.IPSPFViewLogicTempl2;
import SA.SRFDA.PS.Core.PF.PSPFViewLogicTempl2Impl2;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Util.FileWriterHelper2;
import SA.SRFDA.PS.Data.PSPFViewLogicTempl;
import SA.SRFDA.PS.Data.PSSysPFPlugin;
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSNDFile;
import net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysPFPluginImpl
extends PSSystemObjectImpl
implements IPSSysPFPlugin,
IPSPFPlugin2,
IPSModelSortable {
    private static Map<String, String> codeNameMap = new HashMap<String, String>();
    private static final Log log;
    protected PSSysPFPlugin psSysPFPlugin = null;
    private String strCodeName = "";
    private String strPFPluginTag = "";
    private IPSPFPluginType iPSPFPluginType = null;
    private ThreadLocal<Integer> currentThreadCallCount = new ThreadLocal();
    private String strPSPFPluginId = null;
    private HashMap<String, IPSPFViewLogicTempl2> psPFViewLogicTempl2Map = null;
    private String strPreviewHtml = null;
    private String strPreviewPSNDFileId = "";
    private String strPluginCode = "";
    private boolean bExtendStyleOnly = false;
    private ObjectNode pluginModel = null;
    private boolean bReplaceDefault = false;
    private IPSSystemModule iPSSystemModule = null;
    private boolean bRuntimeObject = false;
    private String strRTObjectName = null;
    private String strRTObjectRepo = null;
    private int nRTObjectSource = 0;
    private Properties pluginParams = null;
    private int nOrderValue = 99999;
    private List<IPSSysPFPluginTempl> psSysPFPluginTemplList = null;

    static {
        codeNameMap.put("CODE", "");
        codeNameMap.put("CODE2", "");
        codeNameMap.put("CODE3", "");
        codeNameMap.put("CODE4", "");
        codeNameMap.put("CODE5", "");
        codeNameMap.put("CODE6", "");
        log = LogFactory.getLog(PSSysPFPluginImpl.class);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysPFPlugin psSysPFPlugin) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSSystem(iPSSystem);
            this.psSysPFPlugin = psSysPFPlugin;
            this.setId(this.psSysPFPlugin.getPSSYSPFPLUGINID());
            this.setName(this.psSysPFPlugin.getPSSYSPFPLUGINNAME());
            this.setPSObjectData(this.psSysPFPlugin);
            if (!StringHelper.isNullOrEmpty((String)this.psSysPFPlugin.getPSMODULEID())) {
                this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psSysPFPlugin.getPSMODULEID());
            }
            this.iPSPFPluginType = this.getPSModelStorage().getPSPFPluginType(psSysPFPlugin.getPLUGINTYPE());
            this.strPluginCode = this.strPFPluginTag = this.psSysPFPlugin.getPLUGINTAG();
            this.strCodeName = this.psSysPFPlugin.getCODENAME();
            if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.strPFPluginTag;
            }
            if (!this.psSysPFPlugin.isEXTENDSTYLEONLYNull()) {
                this.bExtendStyleOnly = this.psSysPFPlugin.getEXTENDSTYLEONLY();
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPFPlugin.getPLUGINMODEL())) {
                this.pluginModel = (ObjectNode)JsonNodeHelper.fromString((String)this.psSysPFPlugin.getPLUGINMODEL());
            }
            if (!StringHelper.isNullOrEmpty((String)this.psSysPFPlugin.getPLUGINPARAMS())) {
                this.pluginParams = PropertiesHelper.load((String)this.psSysPFPlugin.getPLUGINPARAMS());
            }
            if (StringHelper.isNullOrEmpty((String)this.strPFPluginTag)) {
                this.strPFPluginTag = String.valueOf(this.iPSPFPluginType.getId()) + KeyValueHelper.genUniqueId((String)this.psSysPFPlugin.getPSSYSPFPLUGINID()).substring(0, 10);
            }
            if (!this.psSysPFPlugin.isREPDEFAULTNull()) {
                this.bReplaceDefault = this.psSysPFPlugin.getREPDEFAULT();
            }
            this.strPSPFPluginId = this.psSysPFPlugin.getPSPFPLUGINID();
            this.strPreviewPSNDFileId = this.psSysPFPlugin.getPREVIEWPSNDFILEID();
            if (!this.psSysPFPlugin.isRTOBJECTMODENull()) {
                this.nRTObjectSource = this.psSysPFPlugin.getRTOBJECTMODE();
                if (this.getRTObjectSource() != 0) {
                    this.bRuntimeObject = true;
                    this.strRTObjectName = this.psSysPFPlugin.getRTOBJECTNAME();
                    this.strRTObjectRepo = this.psSysPFPlugin.getRTOBJECTREPO();
                }
            }
            if (!this.psSysPFPlugin.isORDERVALUENull() && this.psSysPFPlugin.getORDERVALUE() >= 0) {
                this.nOrderValue = this.psSysPFPlugin.getORDERVALUE();
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
        super.onInit();
    }

    @Override
    public String getPFPluginType() {
        return this.iPSPFPluginType.getId();
    }

    @Override
    public IPSPFPluginType getPSPFPluginType() {
        return this.iPSPFPluginType;
    }

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String strPSPFId) throws Exception {
        return this.getPSPFPluginTempl(strPSPFId, "", false);
    }

    @Override
    public IPSPFPluginTempl getPSPFPluginTempl(String strPSPFId, String strPSPFPubCodeId, boolean bTryMode) throws Exception {
        try {
            IPSSysPFPluginTempl iPSPFPluginTempl;
            String strPSPFPluginTemplId = null;
            if (!StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
                strPSPFPluginTemplId = Helper.GenUniqueId((String)this.getId(), (String)strPSPFId, (String)strPSPFPubCodeId);
                iPSPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSPFPluginTemplId, true);
                if (iPSPFPluginTempl != null) {
                    return iPSPFPluginTempl;
                }
            }
            strPSPFPluginTemplId = Helper.GenUniqueId((String)this.getId(), (String)strPSPFId);
            iPSPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSPFPluginTemplId, bTryMode || !StringHelper.isNullOrEmpty((String)this.getPSPFPluginId()));
            if (iPSPFPluginTempl != null) {
                return iPSPFPluginTempl;
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPSPFPluginId())) {
                strPSPFPluginTemplId = Helper.GenUniqueId((String)this.getPSPFPluginId(), (String)strPSPFId);
                return this.getPSModelStorage().getPSPFPluginTempl(strPSPFPluginTemplId, bTryMode);
            }
            return iPSPFPluginTempl;
        }
        catch (Exception ex) {
            if (StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u5e94\u7528\u6846\u67b6\u63d2\u4ef6\u6a21\u677f[%1$s][%2$s]", (Object)this.getName(), (Object)strPSPFId), ex);
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u7cfb\u7edf\u5e94\u7528\u6846\u67b6\u63d2\u4ef6\u6a21\u677f[%1$s][%2$s][%3$s]", (Object)this.getName(), (Object)strPSPFId, (Object)strPSPFPubCodeId), ex);
        }
    }

    @Override
    public String getCode(String strCodeType, String strPSPFId, String strPSPFStyleId, Object objView, Object objCtrl, Object objItem) throws Exception {
        try {
            this.logCallCount(1);
            IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(strPSPFId);
            HashMap<String, Object> params = new HashMap<String, Object>();
            if (PSTemplHelper.getCurrentParams() != null) {
                params.putAll(PSTemplHelper.getCurrentParams());
            }
            if (objItem != null) {
                params.put("item", objItem);
            }
            if (objCtrl != null) {
                params.put("ctrl", objCtrl);
            }
            IPSAppView iPSAppView = null;
            if (objView != null && objView instanceof IPSAppView) {
                iPSAppView = (IPSAppView)objView;
                params.put("app", iPSAppView.getPSApplication());
                params.put("view", iPSAppView);
                params.put("sys", iPSAppView.getPSApplication().getPSSystem());
            }
            IPSPFStyle iPSPFStyle = null;
            IPSPF iPSPF = null;
            if (iPSAppView != null) {
                iPSPF = iPSAppView.getPSApplication().getPSPF();
                if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) {
                    iPSPFStyle = iPSAppView.getPSApplication().getPSPFStyle(strPSPFStyleId);
                }
            } else {
                iPSPF = this.getPSModelStorage().getPSPF(strPSPFId);
                if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) {
                    iPSPFStyle = iPSPF.getPSPFStyle(strPSPFStyleId);
                }
            }
            params.put("pf", iPSPF);
            if (iPSPFStyle != null) {
                params.put("pfstyle", iPSPFStyle);
            }
            String strCodeName = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType);
            String strCode = PSTemplHelper.generateCode(iPSPFPluginTempl.getPSPFPluginTemplData(iPSPFStyle), strCodeName, params);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    public String getCode(String strCodeType, String strPSPFPubCodeId, String strPSPFId, String strPSPFStyleId, Object objView, Object objCtrl, Object objItem) throws Exception {
        try {
            this.logCallCount(1);
            IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(strPSPFId, strPSPFPubCodeId, false);
            HashMap<String, Object> params = new HashMap<String, Object>();
            if (PSTemplHelper.getCurrentParams() != null) {
                params.putAll(PSTemplHelper.getCurrentParams());
            }
            if (objItem != null) {
                params.put("item", objItem);
            }
            if (objCtrl != null) {
                params.put("ctrl", objCtrl);
            }
            IPSAppView iPSAppView = null;
            if (objView != null && objView instanceof IPSAppView) {
                iPSAppView = (IPSAppView)objView;
                params.put("app", iPSAppView.getPSApplication());
                params.put("view", iPSAppView);
                params.put("sys", iPSAppView.getPSApplication().getPSSystem());
            }
            IPSPFStyle iPSPFStyle = null;
            IPSPF iPSPF = null;
            if (iPSAppView != null) {
                iPSPF = iPSAppView.getPSApplication().getPSPF();
                if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) {
                    iPSPFStyle = iPSAppView.getPSApplication().getPSPFStyle(strPSPFStyleId);
                }
            } else {
                iPSPF = this.getPSModelStorage().getPSPF(strPSPFId);
                if (!StringHelper.isNullOrEmpty((String)strPSPFStyleId)) {
                    iPSPFStyle = iPSPF.getPSPFStyle(strPSPFStyleId);
                }
            }
            params.put("pf", iPSPF);
            if (iPSPFStyle != null) {
                params.put("pfstyle", iPSPFStyle);
            }
            String strCodeName = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType);
            String strCode = PSTemplHelper.generateCode(iPSPFPluginTempl.getPSPFPluginTemplData(iPSPFStyle), strCodeName, params);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    public String getPFPluginTag() {
        return this.strPFPluginTag;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u4ee3\u7801")
    public String getPluginCode() {
        return this.getPFPluginCode();
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u6807\u8bb0")
    public String getPluginTag() {
        return this.getPFPluginTag();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u63d2\u4ef6\u7c7b\u578b", codelist="PFPluginType", group="\u57fa\u672c", order=125)
    public String getPluginType() {
        return this.getPFPluginType();
    }

    @Override
    public String getModelType() {
        return "PSSYSPFPLUGIN";
    }

    @Override
    public String getCode(String strCodeType) throws Exception {
        return this.getCode(strCodeType, "");
    }

    @Override
    public String getCode(String strCodeType, String strPSPFPubCodeId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeType) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return "";
        }
        try {
            this.logCallCount(1);
            Map<String, Object> params = PSTemplHelper.getCurrentParams();
            if (params == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSPF iPSPF = null;
            IPSPFStyle iPSPFStyle = null;
            Object objPF = params.get("pf");
            Object objPFStyle = params.get("pfstyle");
            if (objPF != null && objPF instanceof IPSPF) {
                iPSPF = (IPSPF)objPF;
            }
            if (objPFStyle != null && objPFStyle instanceof IPSPFStyle) {
                iPSPFStyle = (IPSPFStyle)objPFStyle;
            }
            if (iPSPF == null || iPSPFStyle == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(iPSPF.getId(), strPSPFPubCodeId, false);
            String strCodeName = "";
            strCodeName = StringHelper.isNullOrEmpty((String)iPSPFPluginTempl.getPSPFPubCodeId()) ? StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType) : "TEMPLCODE";
            String strCode = PSTemplHelper.generateCode(iPSPFPluginTempl.getPSPFPluginTemplData(iPSPFStyle), strCodeName);
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
            if (nValue >= 20) {
                this.currentThreadCallCount.set(null);
                throw new Exception(StringHelper.format((String)"\u524d\u7aef\u6a21\u677f\u63d2\u4ef6[%1$s]\u5b58\u5728\u9012\u5f52\u8c03\u7528", (Object)this.getName()));
            }
            this.currentThreadCallCount.set(nValue);
        }
    }

    @Override
    public boolean hasCode(String strCodeType) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeType)) {
            return false;
        }
        String strCodeType2 = strCodeType.toUpperCase();
        if (codeNameMap.containsKey(strCodeType2)) {
            return this.hasCode(strCodeType2, "");
        }
        return this.hasCode("", strCodeType2);
    }

    @Override
    public boolean hasCode(String strCodeType, String strPSPFPubCodeId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeType) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return false;
        }
        Map<String, Object> params = PSTemplHelper.getCurrentParams();
        if (params == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSPF iPSPF = null;
        IPSPFStyle iPSPFStyle = null;
        Object objPF = params.get("pf");
        Object objPFStyle = params.get("pfstyle");
        if (objPF != null && objPF instanceof IPSPF) {
            iPSPF = (IPSPF)objPF;
        }
        if (objPFStyle != null && objPFStyle instanceof IPSPFStyle) {
            iPSPFStyle = (IPSPFStyle)objPFStyle;
        }
        if (iPSPF == null || iPSPFStyle == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(iPSPF.getId(), strPSPFPubCodeId, true);
        if (iPSPFPluginTempl == null) {
            return false;
        }
        String strCodeName = "";
        strCodeName = StringHelper.isNullOrEmpty((String)iPSPFPluginTempl.getPSPFPubCodeId()) ? StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType) : "TEMPLCODE";
        String strCode = iPSPFPluginTempl.getPSPFPluginTemplData(iPSPFStyle).getParamStringValue(strCodeName, "");
        return !StringHelper.isNullOrEmpty((String)strCode);
    }

    @Override
    public boolean hasCode(String strCodeType, String strPSPFPubCodeId, String strPSPFId, String strPSPFStyleId) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeType) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return false;
        }
        Map<String, Object> params = PSTemplHelper.getCurrentParams();
        if (params == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        boolean bTryMode = StringHelper.isNullOrEmpty((String)strCodeType);
        IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(strPSPFId, strPSPFPubCodeId, true);
        if (iPSPFPluginTempl == null) {
            return false;
        }
        IPSPF iPSPF = this.getPSModelStorage().getPSPF(strPSPFId);
        IPSPFStyle iPSPFStyle = iPSPF.getPSPFStyle(strPSPFStyleId);
        String strCodeName = "";
        strCodeName = StringHelper.isNullOrEmpty((String)iPSPFPluginTempl.getPSPFPubCodeId()) ? StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType) : "TEMPLCODE";
        String strCode = iPSPFPluginTempl.getPSPFPluginTemplData(iPSPFStyle).getParamStringValue(strCodeName, "");
        return !StringHelper.isNullOrEmpty((String)strCode);
    }

    @Override
    public boolean hasCode2(String strPSPFPubCodeId) throws Exception {
        return this.hasCodeX(strPSPFPubCodeId, "TEMPLCODE2");
    }

    @Override
    public boolean hasCode3(String strPSPFPubCodeId) throws Exception {
        return this.hasCodeX(strPSPFPubCodeId, "TEMPLCODE3");
    }

    @Override
    public boolean hasCode4(String strPSPFPubCodeId) throws Exception {
        return this.hasCodeX(strPSPFPubCodeId, "TEMPLCODE4");
    }

    @Override
    public String getCode2(String strPSPFPubCodeId) throws Exception {
        return this.getCodeX(strPSPFPubCodeId, "TEMPLCODE2");
    }

    @Override
    public String getCode3(String strPSPFPubCodeId) throws Exception {
        return this.getCodeX(strPSPFPubCodeId, "TEMPLCODE3");
    }

    @Override
    public String getCode4(String strPSPFPubCodeId) throws Exception {
        return this.getCodeX(strPSPFPubCodeId, "TEMPLCODE4");
    }

    protected boolean hasCodeX(String strPSPFPubCodeId, String strCodeName) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeName) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return false;
        }
        Map<String, Object> params = PSTemplHelper.getCurrentParams();
        if (params == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSPF iPSPF = null;
        IPSPFStyle iPSPFStyle = null;
        Object objPF = params.get("pf");
        Object objPFStyle = params.get("pfstyle");
        if (objPF != null && objPF instanceof IPSPF) {
            iPSPF = (IPSPF)objPF;
        }
        if (objPFStyle != null && objPFStyle instanceof IPSPFStyle) {
            iPSPFStyle = (IPSPFStyle)objPFStyle;
        }
        if (iPSPF == null || iPSPFStyle == null) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
        }
        IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(iPSPF.getId(), strPSPFPubCodeId, true);
        if (iPSPFPluginTempl == null) {
            return false;
        }
        String strCode = iPSPFPluginTempl.getPSPFPluginTemplData(iPSPFStyle).getParamStringValue(strCodeName, "");
        return !StringHelper.isNullOrEmpty((String)strCode);
    }

    protected String getCodeX(String strPSPFPubCodeId, String strCodeName) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strCodeName) && StringHelper.isNullOrEmpty((String)strPSPFPubCodeId)) {
            return "";
        }
        try {
            this.logCallCount(1);
            Map<String, Object> params = PSTemplHelper.getCurrentParams();
            if (params == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSPF iPSPF = null;
            IPSPFStyle iPSPFStyle = null;
            Object objPF = params.get("pf");
            Object objPFStyle = params.get("pfstyle");
            if (objPF != null && objPF instanceof IPSPF) {
                iPSPF = (IPSPF)objPF;
            }
            if (objPFStyle != null && objPFStyle instanceof IPSPFStyle) {
                iPSPFStyle = (IPSPFStyle)objPFStyle;
            }
            if (iPSPF == null || iPSPFStyle == null) {
                throw new Exception(StringHelper.format((String)"\u5f53\u524d\u53d1\u5e03\u53c2\u6570\u65e0\u6548"));
            }
            IPSPFPluginTempl iPSPFPluginTempl = this.getPSPFPluginTempl(iPSPF.getId(), strPSPFPubCodeId, false);
            String strCode = PSTemplHelper.generateCode(iPSPFPluginTempl.getPSPFPluginTemplData(iPSPFStyle), strCodeName);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    public String getPSPFPluginId() {
        return this.strPSPFPluginId;
    }

    @Override
    public String getPFPluginCode() {
        return this.strPluginCode;
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            return this.getPFPluginCode();
        }
        return this.strCodeName;
    }

    @Override
    public IPSPFViewLogicTempl2 getPSPFViewLogicTempl2(IPSPFPubCode2 iPSPFPubCode2, boolean bTryMode) throws Exception {
        IPSPFViewLogicTempl2 iPSPFViewLogicTempl2;
        String strPSPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getId(), (String)iPSPFPubCode2.getPSPF().getId(), (String)iPSPFPubCode2.getName().toUpperCase());
        if (this.psPFViewLogicTempl2Map != null && (iPSPFViewLogicTempl2 = this.psPFViewLogicTempl2Map.get(strPSPFPluginTemplId)) != null) {
            return iPSPFViewLogicTempl2;
        }
        IPSSysPFPluginTempl iPSPFPluginTempl = this.getPSSystem().getPSSysPFPluginTempl(strPSPFPluginTemplId, true);
        if (iPSPFPluginTempl == null) {
            if (!bTryMode) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u524d\u7aef\u6269\u5c55\u63d2\u4ef6[%1$s]\u4ee3\u7801\u6a21\u677f[%2$s]", (Object)iPSPFPubCode2.getPSPF().getName(), (Object)iPSPFPubCode2.getName()));
            }
            return null;
        }
        BaseDataEntity psPFPluginTempl = iPSPFPluginTempl.getPSPFPluginTemplData(null);
        PSPFViewLogicTempl psPFViewLogicTempl = new PSPFViewLogicTempl();
        psPFPluginTempl.CopyTo((BaseDataEntity)psPFViewLogicTempl, false);
        psPFViewLogicTempl.setPSPFVLTEMPLID(strPSPFPluginTemplId);
        psPFViewLogicTempl.setPSPFVLTEMPLNAME(StringHelper.format((String)"%1$s-%2$s", (Object)iPSPFPubCode2.getPSPF().getName(), (Object)iPSPFPubCode2.getName()));
        PSPFViewLogicTempl2Impl2 psPFViewLogicTempl2Impl2 = new PSPFViewLogicTempl2Impl2();
        psPFViewLogicTempl2Impl2.init(this.getDAGlobalHelper(), iPSPFPubCode2, psPFViewLogicTempl);
        if (this.psPFViewLogicTempl2Map == null) {
            this.psPFViewLogicTempl2Map = new HashMap();
        }
        this.psPFViewLogicTempl2Map.put(strPSPFPluginTemplId, psPFViewLogicTempl2Impl2);
        return psPFViewLogicTempl2Impl2;
    }

    @Override
    public String getXCode(String strCodeType, Object objView, Object objCtrl, Object objItem, Map<String, Object> paramsInput) throws Exception {
        try {
            Object objApp;
            IPSApplication iPSApplication;
            this.logCallCount(1);
            if (StringHelper.isNullOrEmpty((String)strCodeType)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u4ee3\u7801\u7c7b\u578b");
            }
            HashMap<String, Object> params = new HashMap<String, Object>();
            Map<String, Object> curParams = PSTemplHelper.getCurrentParams();
            if (curParams != null) {
                params.putAll(curParams);
            }
            if (paramsInput != null) {
                params.putAll(paramsInput);
            }
            if (objView != null) {
                params.put("view", objView);
            }
            if (objItem != null) {
                params.put("item", objItem);
            }
            if (objCtrl != null) {
                params.put("ctrl", objCtrl);
            }
            String strPSPFId = null;
            objView = params.get("view");
            if (objView instanceof IPSAppView) {
                strPSPFId = ((IPSAppView)objView).getPSPFStyle().getPSPF().getId();
            }
            if (StringHelper.isNullOrEmpty(strPSPFId) && (objItem = params.get("item")) != null && (iPSApplication = PSSystemUtil.getRefPSApplication(objItem, true)) != null) {
                strPSPFId = iPSApplication.getPSPF().getId();
            }
            if (StringHelper.isNullOrEmpty(strPSPFId) && (objApp = params.get("app")) instanceof IPSApplication) {
                strPSPFId = ((IPSApplication)objApp).getPSPF().getId();
            }
            IPSPFPluginTempl iPSPFPluginTempl = null;
            String strCodeName = null;
            String strCodeType2 = strCodeType.toUpperCase();
            if (codeNameMap.containsKey(strCodeType2)) {
                iPSPFPluginTempl = this.getPSPFPluginTempl(strPSPFId);
                strCodeName = StringHelper.format((String)"TEMPL%1$s", (Object)strCodeType);
            } else {
                iPSPFPluginTempl = this.getPSPFPluginTempl(strPSPFId, strCodeType2, false);
                strCodeName = "TEMPLCODE";
            }
            String strCode = PSTemplHelper.generateCode(iPSPFPluginTempl.getPSPFPluginTemplData(null), strCodeName, params);
            this.logCallCount(-1);
            return strCode;
        }
        catch (Exception ex) {
            this.currentThreadCallCount.set(null);
            throw ex;
        }
    }

    @Override
    public String getPreviewHtml() {
        if (StringHelper.isNullOrEmpty((String)this.strPreviewPSNDFileId)) {
            return "";
        }
        if (this.strPreviewHtml != null) {
            return this.strPreviewHtml;
        }
        try {
            PSNDFile psNDFile = new PSNDFile();
            psNDFile.setPSNDFileId(this.strPreviewPSNDFileId);
            PSNDFileService.getFromRemote((PSNDFile)psNDFile);
            this.strPreviewHtml = FileWriterHelper2.readFile(psNDFile.getFilePath());
        }
        catch (Exception ex) {
            this.strPreviewHtml = ex.getMessage();
        }
        return this.strPreviewHtml;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u6a21\u677f\u96c6\u5408")
    public Iterator<IPSSysPFPluginTempl> getPSSysPFPluginTempls() throws Exception {
        if (this.psSysPFPluginTemplList == null) {
            ArrayList<IPSSysPFPluginTempl> psSysPFPluginTemplList = new ArrayList<IPSSysPFPluginTempl>();
            Iterator<IPSSysPFPluginTempl> psSysPFPluginTempls = this.getPSSystem().getAllPSSysPFPluginTempls();
            if (psSysPFPluginTempls != null) {
                while (psSysPFPluginTempls.hasNext()) {
                    IPSSysPFPluginTempl iPSSysPFPluginTempl = psSysPFPluginTempls.next();
                    if (StringHelper.compare((String)iPSSysPFPluginTempl.getPSSysPFPlugin().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psSysPFPluginTemplList.add(iPSSysPFPluginTempl);
                }
            }
            if (this.psSysPFPluginTemplList == null) {
                this.psSysPFPluginTemplList = psSysPFPluginTemplList;
            }
        }
        if (this.psSysPFPluginTemplList == null || this.psSysPFPluginTemplList.size() == 0) {
            return null;
        }
        return this.psSysPFPluginTemplList.iterator();
    }

    @Override
    protected ObjectNode toModelRefNode(String strType) {
        try {
            Enumeration<Object> keys;
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            if (!StringHelper.isNullOrEmpty((String)this.getPFPluginType())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"pluginType", (Object)this.getPFPluginType());
            }
            if (!StringHelper.isNullOrEmpty((String)this.getPFPluginCode())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"pluginCode", (Object)this.getPFPluginCode());
            } else if (!StringHelper.isNullOrEmpty((String)this.getCodeName())) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"pluginCode", (Object)this.getCodeName());
            }
            if (this.isRuntimeObject()) {
                JsonNodeHelper.put((ObjectNode)objectNode, (String)"runtimeObject", (Object)true);
            }
            if (this.getPluginParams() != null) {
                ObjectNode paramNode = JsonNodeHelper.createObjectNode();
                Properties pluginParams = this.getPluginParams();
                for (Object objKey : pluginParams.keySet()) {
                    Object objValue = pluginParams.get(objKey);
                    if (objValue == null) continue;
                    PSSysPFPluginImpl.putJsonProperty(paramNode, (String)objKey, objValue);
                }
                if (paramNode.size() != 0) {
                    objectNode.put("pluginParams", (JsonNode)paramNode);
                }
            }
            if (!objectNode.has("getUserParam") && (keys = this.getUserParamNames()) != null) {
                ObjectNode paramNode = JsonNodeHelper.createObjectNode();
                while (keys.hasMoreElements()) {
                    Object objKey;
                    objKey = keys.nextElement();
                    Object objValue = this.getUserParam((String)objKey);
                    if (objValue == null) continue;
                    PSSysPFPluginImpl.putJsonProperty(paramNode, (String)objKey, objValue);
                }
                if (paramNode.size() != 0) {
                    objectNode.put("getUserParam", (JsonNode)paramNode);
                }
            }
            return objectNode;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5bfc\u51fa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            ObjectNode objectNode = JsonNodeHelper.createObjectNode();
            objectNode.put("error", 1);
            objectNode.put("msg", ex.getMessage());
            return objectNode;
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ec5\u6269\u5c55\u754c\u9762\u6837\u5f0f", ignoredumpvalues="false")
    public boolean isExtendStyleOnly() {
        return this.bExtendStyleOnly;
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
    @PSModelRTMeta(description="\u7cfb\u7edf\u6a21\u5757")
    public IPSSystemModule getPSSystemModule() {
        return this.iPSSystemModule;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u4ed3\u5e93", hideempty2=true, dump=false)
    public String getRTObjectRepo() {
        return this.strRTObjectRepo;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61", ignoredumpvalues="false")
    public boolean isRuntimeObject() {
        return this.bRuntimeObject;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u6765\u6e90", ignoredumpvalues="0")
    public int getRTObjectSource() {
        return this.nRTObjectSource;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u65f6\u5bf9\u8c61\u540d\u79f0", hideempty2=true)
    public String getRTObjectName() {
        return this.strRTObjectName;
    }

    @Override
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    @PSModelRTMeta(description="\u63d2\u4ef6\u52a8\u6001\u53c2\u6570", hideempty=true, fields={"PLUGINPARAMS"})
    public Properties getPluginParams() {
        return this.pluginParams;
    }
}

