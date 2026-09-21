/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherHelper;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPublisherContext;
import SA.SRFDA.PS.Core.Pub.IPSSFSysCodePublisher;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import SA.SRFDA.PS.Core.Pub.PSRecursionException;
import SA.SRFDA.PS.Core.Pub.PSSFCodePublisher2Impl;
import SA.SRFDA.PS.Core.Pub.PSSFSysCodePublisherContextBase;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder;
import SA.SRFDA.PS.Core.SF.IPSSFCodeTempl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSSFSysCodePublisherImpl
extends PSSFCodePublisher2Impl
implements IPSSFSysCodePublisher,
IPSCodePublisherHelper {
    private static final Log log = LogFactory.getLog(PSSFSysCodePublisherImpl.class);
    public static final int MAXKEYCOUNT = 5000;
    protected IPSSFCodeType iPSSFCodeType = null;
    protected IPSSF iPSSF = null;
    protected IPSSFStyle iPSSFStyle = null;
    protected IPSPublisherContext iPSPublisherContext = null;
    protected IPSSysSFPub iPSSysSFPub = null;
    protected IPSSystem iPSSystem = null;
    protected String strDEFilter = "";
    private String strCodeFolder = null;
    private String strToolFolder = null;
    private HashMap<String, Integer> callLoopMap = new HashMap();
    private HashMap<String, String> keyMap = new HashMap();
    private boolean bCheckModelOnly = false;
    private boolean bRemoveEmptyFile = true;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFCodeType iPSSFCodeType) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSFCodeType = iPSSFCodeType;
        this.iPSSFStyle = iPSSFCodeType.getPSSFCodeFolder().getPSSFStyle();
        this.iPSSF = this.iPSSFStyle.getPSSF();
        this.strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", null);
        this.strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", null);
        if (this.iPSSFCodeType instanceof IPSSFCodeType2) {
            IPSSFCodeType2 iPSSFCodeType2 = (IPSSFCodeType2)this.iPSSFCodeType;
            this.bCheckModelOnly = iPSSFCodeType2.isCheckModelOnly();
            this.bRemoveEmptyFile = iPSSFCodeType2.isRemoveEmptyFile();
        }
        this.onInit();
    }

    @Override
    public void generateCode(IPSPublisherContext iPSPublisherContext, IPSSysSFPub iPSSysSFPub) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        Object objDEFilter = iPSPublisherContext.getUserTag("DEFILTER");
        if (objDEFilter != null) {
            this.strDEFilter = (String)objDEFilter;
        }
        this.iPSSysSFPub = iPSSysSFPub;
        this.iPSSystem = iPSSysSFPub.getPSSystem();
        this.callLoopMap.clear();
        this.keyMap.clear();
        if (this.iPSSFCodeType.getPSSFCodeFolder().getModelLevel() > this.iPSSystem.getLoadedLevel()) {
            return;
        }
        this.onGenerateCode();
    }

    protected abstract void onGenerateCode() throws Exception;

    protected IPSGenerateCodeResult generateCode(String strType, Object obj, HashMap<String, Object> params2) throws Exception {
        final HashMap<String, Object> params = new HashMap<String, Object>();
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null) {
            params.putAll(this.iPSPublisherContext.getPubParams());
        }
        if (params2 != null) {
            params.putAll(params2);
        }
        params.put("publisher", this);
        params.put("P", new PSSFSysCodePublisherContextBase(){

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart) throws Exception {
                return this.getPartCode(objPart, null);
            }

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart, String strCodeType) throws Exception {
                return PSSFSysCodePublisherImpl.this.internalGetPartCode(objPart, strCodeType, params);
            }

            @Override
            public boolean hasPartCode(Object objPart) throws Exception {
                return PSSFSysCodePublisherImpl.this.internalTestPartCode(objPart);
            }

            @Override
            public boolean exists(String strType, String strParam, String strParam2) {
                return PSSFSysCodePublisherImpl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSSFSysCodePublisherImpl.this.internalGetLogicCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getHelpCode(Object objCtrl, String strCodeType) throws Exception {
                return PSSFSysCodePublisherImpl.this.internalGetHelpCode(objCtrl, strCodeType, params);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSSFSysCodePublisherImpl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSSFSysCodePublisherImpl.this.internalGet(strParam, strDefault);
            }
        });
        params.put("item", obj);
        params.put("sys", this.iPSSystem);
        params.put("pub", this.iPSSysSFPub);
        params.put("codetype", this.iPSSFCodeType);
        params.put("sfcodetype", this.iPSSFCodeType);
        params.put("codetempl", this.iPSSFCodeType);
        params.put("sf", this.iPSSF);
        params.put("sfstyle", this.iPSSFStyle);
        params.put("sysrun", this.iPSSysSFPub);
        params.put("toolfolder", this.strToolFolder);
        params.put("codefolder", this.strCodeFolder);
        this.onFillGenerateCodeParams(strType, obj, params);
        IPSSFCodeTempl iPSSFCodeTempl = null;
        try {
            iPSSFCodeTempl = this.iPSSFCodeType.getPSSFCodeTemplByTag(strType);
        }
        catch (Exception e) {
            log.error((Object)e.getMessage(), (Throwable)e);
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s-%2$s]\u4ee3\u7801\u6a21\u7248", (Object)this.iPSSFCodeType.getName(), (Object)strType));
        }
        PSGenerateCodeResultImpl psGenerateCodeResultImpl = new PSGenerateCodeResultImpl();
        psGenerateCodeResultImpl.setObject(obj);
        if (!StringHelper.IsNullOrEmpty((String)this.iPSSFCodeType.getPSSFCodeTypeData().getHEADERCODE())) {
            if (StringHelper.IsNullOrEmpty((String)iPSSFCodeTempl.getPSSFCodeTemplData().getParamStringValue("TEMPLCODE_HEADER", ""))) {
                iPSSFCodeTempl.getPSSFCodeTemplData().set("TEMPLCODE_HEADER", String.valueOf(this.iPSSFCodeType.getPSSFCodeTypeData().getHEADERCODE()) + "\r\n" + iPSSFCodeTempl.getPSSFCodeTemplData().getTEMPLCODE());
            }
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)iPSSFCodeTempl.getPSSFCodeTemplData(), "TEMPLCODE_HEADER", params));
        } else {
            psGenerateCodeResultImpl.setCode(PSTemplHelper.generateCode((BaseDataEntity)iPSSFCodeTempl.getPSSFCodeTemplData(), "TEMPLCODE", params));
        }
        psGenerateCodeResultImpl.setParams(params);
        return psGenerateCodeResultImpl;
    }

    protected void onFillGenerateCodeParams(String strType, Object obj, HashMap<String, Object> params) throws Exception {
    }

    protected void savePSSysSFCode(Object obj, PSSysSFCode psSysSFCodeSrc, HashMap<String, Object> params2) throws Exception {
        boolean bV2 = false;
        if (StringHelper.Compare((String)((IPSSystemUtil)((Object)this.iPSSystem)).getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            bV2 = true;
        }
        String strFolderCode = this.iPSSFCodeType.getPSSFCodeFolder().getFolderCode();
        if (bV2 && StringHelper.Compare((String)strFolderCode, (String)"PRJ", (boolean)true) != 0 && StringHelper.Compare((String)strFolderCode, (String)"SLN", (boolean)true) != 0 && StringHelper.Compare((String)strFolderCode, (String)"TOOL", (boolean)true) != 0) {
            return;
        }
        this.keyMap.clear();
        PSSysSFCode psSysSFCode = new PSSysSFCode();
        psSysSFCode.setPSSYSSFPUBID(this.iPSSysSFPub.getId());
        psSysSFCode.setPSSYSSFPUBNAME(this.iPSSysSFPub.getName());
        psSysSFCode.setPSSFCODEFOLDERID(this.iPSSFCodeType.getPSSFCodeFolder().getId());
        psSysSFCode.setPSSFCODEFOLDERNAME(this.iPSSFCodeType.getPSSFCodeFolder().getName());
        psSysSFCode.setPSSFCODETYPEID(this.iPSSFCodeType.getId());
        psSysSFCode.setPSSFCODETYPENAME(this.iPSSFCodeType.getName());
        if (obj instanceof IPSObject) {
            IPSObject iPSObject = (IPSObject)obj;
            psSysSFCode.setSYSOBJID(iPSObject.getId());
            psSysSFCode.setSYSOBJNAME(iPSObject.getName());
        }
        boolean bPSModelSFCodeMode = false;
        if (psSysSFCodeSrc != null) {
            psSysSFCodeSrc.CopyTo(psSysSFCode, false);
            bPSModelSFCodeMode = psSysSFCodeSrc.GetParamIntValue("PSSYSSFCODE", 0) == 1;
        }
        final HashMap<String, Object> params = new HashMap<String, Object>();
        if (params2 != null) {
            params.putAll(params2);
        }
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null) {
            params.putAll(this.iPSPublisherContext.getPubParams());
        }
        params.put("publisher", this);
        params.put("P", new PSSFSysCodePublisherContextBase(){

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart) throws Exception {
                return this.getPartCode(objPart, null);
            }

            @Override
            public IPSGenerateCodeResult getPartCode(Object objPart, String strCodeType) throws Exception {
                return PSSFSysCodePublisherImpl.this.internalGetPartCode(objPart, strCodeType, params);
            }

            @Override
            public boolean hasPartCode(Object objPart) throws Exception {
                return PSSFSysCodePublisherImpl.this.internalTestPartCode(objPart);
            }

            @Override
            public boolean exists(String strType, String strParam, String strParam2) {
                return PSSFSysCodePublisherImpl.this.internalExists(strType, strParam, strParam2);
            }

            @Override
            public IPSGenerateCodeResult getLogicCode(Object objCtrl, String strCodeType) throws Exception {
                return PSSFSysCodePublisherImpl.this.internalGetLogicCode(objCtrl, strCodeType, params);
            }

            @Override
            public IPSGenerateCodeResult getHelpCode(Object objCtrl, String strCodeType) throws Exception {
                return PSSFSysCodePublisherImpl.this.internalGetHelpCode(objCtrl, strCodeType, params);
            }

            @Override
            public boolean set(String strParam, String strValue) {
                return PSSFSysCodePublisherImpl.this.internalSet(strParam, strValue);
            }

            @Override
            public String get(String strParam, String strDefault) {
                return PSSFSysCodePublisherImpl.this.internalGet(strParam, strDefault);
            }
        });
        params.put("item", obj);
        params.put("sys", this.iPSSystem);
        params.put("pub", this.iPSSysSFPub);
        params.put("sysrun", this.iPSSysSFPub);
        params.put("codetype", this.iPSSFCodeType);
        params.put("sfcodetype", this.iPSSFCodeType);
        params.put("codetempl", this.iPSSFCodeType);
        params.put("sf", this.iPSSF);
        params.put("sfstyle", this.iPSSFStyle);
        params.put("toolfolder", this.strToolFolder);
        params.put("codefolder", this.strCodeFolder);
        this.onFillGenerateCodeParams("", obj, params);
        IPSSysPubRuntime iPSSysPubRuntime = null;
        if (this.iPSPublisherContext != null && this.iPSPublisherContext.getPubParams() != null && this.iPSPublisherContext.getPubParams().containsKey("syspub")) {
            iPSSysPubRuntime = (IPSSysPubRuntime)this.iPSPublisherContext.getPubParams().get("syspub");
        }
        PSSFCodeType psSFCodeType = this.iPSSFCodeType.getPSSFCodeTypeData();
        String strPubCode = null;
        try {
            if (!StringHelper.IsNullOrEmpty((String)psSFCodeType.getCODEPATH())) {
                psSysSFCode.setCODEPATH(PSTemplHelper.generateCode((BaseDataEntity)psSFCodeType, "CODEPATH", params));
            }
            if (!StringHelper.IsNullOrEmpty((String)psSFCodeType.getFILENAME())) {
                psSysSFCode.setPSSYSSFCODENAME(PSTemplHelper.generateCode((BaseDataEntity)psSFCodeType, "FILENAME", params));
            }
            if (!StringHelper.IsNullOrEmpty((String)psSFCodeType.getFULLCODENAME())) {
                psSysSFCode.setFULLCODENAME(PSTemplHelper.generateCode((BaseDataEntity)psSFCodeType, "FULLCODENAME", params));
            }
            strPubCode = PSTemplHelper.generateCode((BaseDataEntity)psSFCodeType, "CODETEMPL", params);
        }
        catch (Exception ex) {
            throw new Exception(StringHelper.Format((String)"\u540e\u53f0\u4ee3\u7801\u6a21\u677f[%1$s]\u53d1\u5e03\u5f02\u5e38\uff1a\r\n%2$s", (Object)this.iPSSFCodeType.getName(), (Object)ex.getMessage()));
        }
        psSysSFCode.setPUBCODE(strPubCode);
        if (bPSModelSFCodeMode) {
            psSysSFCode.setParamValue("CODETEMPL", psSFCodeType.getCODETEMPL());
            psSysSFCode.CopyTo(psSysSFCodeSrc, true);
            return;
        }
        if (!this.isCheckModelOnly()) {
            File folder;
            String strFolder = this.strCodeFolder;
            if (StringHelper.IsNullOrEmpty((String)strFolder)) {
                throw new Exception("\u6ca1\u6709\u5b9a\u4e49\u4ee3\u7801\u53d1\u5e03\u76ee\u5f55");
            }
            strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getPSDevCenterDomain();
            strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getPubSystemId();
            IPSSFCodeFolder iPSSFCodeFolder = this.iPSSFCodeType.getPSSFCodeFolder();
            String strPubFolder = null;
            String strPubFolder2 = null;
            if (bV2) {
                if (StringHelper.Compare((String)strFolderCode, (String)"TOOL", (boolean)true) == 0) {
                    strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getVCName();
                    strFolder = String.valueOf(strFolder) + File.separator + "." + "TOOL";
                } else {
                    if (this.iPSSysSFPub.isDocMode() && this.iPSSystem.getDocPSSVNInstRepo() != null) {
                        strFolder = String.valueOf(strFolder) + File.separator + "@DOCUMENT";
                    } else {
                        strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getVCName();
                        strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getCodeName();
                    }
                    if (!this.iPSSysSFPub.getDefaultFlag()) {
                        strFolder = String.valueOf(strFolder) + File.separator + this.iPSSysSFPub.getCodeName();
                    }
                }
                strPubFolder = strFolder;
                strPubFolder2 = strFolder;
            } else {
                strFolder = String.valueOf(strFolder) + File.separator + this.iPSSystem.getVCName();
                strPubFolder = String.valueOf(strFolder) + File.separator + "srv_" + this.iPSSysSFPub.getCodeName();
                strPubFolder2 = String.valueOf(strPubFolder) + File.separator + iPSSFCodeFolder.getFolderCode();
            }
            String strFullPath = strPubFolder2;
            if (StringHelper.Compare((String)psSysSFCode.getCODEPATH(), (String)"/", (boolean)true) != 0) {
                strFullPath = String.valueOf(strFullPath) + psSysSFCode.getCODEPATH();
            }
            if (!(folder = new File(strFullPath = strFullPath.replace("/", File.separator))).exists()) {
                folder.mkdirs();
            }
            strFullPath = String.valueOf(strFullPath) + File.separator + psSysSFCode.getPSSYSSFCODENAME();
            String strCode = psSysSFCode.getUSERCODE();
            if (StringHelper.IsNullOrEmpty((String)strCode)) {
                strCode = psSysSFCode.getPUBCODE();
            }
            if (strFullPath.length() >= PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()) {
                String strInfo = StringHelper.Format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u8def\u5f84\u8fc7\u957f[%2$s]\uff0c\u53ef\u80fd\u65e0\u6cd5\u5199\u5165", (Object)strFullPath, (Object)strFullPath.length());
                ((IPSSystemUtil)((Object)this.iPSSystem)).log(4, this.iPSSysSFPub, strInfo);
                log.warn((Object)strInfo);
                this.iPSPublisherContext.log(4, null, strInfo);
                if (PSTaskServerEnvImpl.getCurrent().isThrowExceptionWhenFileNameTooLong()) {
                    throw new Exception(StringHelper.Format((String)"\u53d1\u5e03\u4ee3\u7801[%1$s]\u540d\u79f0\u957f\u5ea6\u8d85\u8fc7[%2$s]", (Object)strFullPath, (Object)PSTaskServerEnvImpl.getCurrent().getMaxFileNameLength()));
                }
            }
            if (this.iPSSFStyle instanceof IPSSFStyle2 && StringHelper.IsNullOrEmpty((String)strCode.trim())) {
                File removeFile;
                if (this.isRemoveEmptyFile() && (removeFile = new File(strFullPath)).exists()) {
                    removeFile.delete();
                }
                return;
            }
            if (iPSSysPubRuntime != null) {
                ((IPSSystemUtil)((Object)this.iPSSystem)).pubSFCode(iPSSysPubRuntime, this.iPSSysSFPub, iPSSFCodeFolder.getFolderCode(), strFullPath, strCode, null);
            } else {
                ((IPSSystemUtil)((Object)this.iPSSystem)).writeFile(strFullPath, strCode, null);
            }
        }
    }

    @Override
    protected void onClose() {
        this.callLoopMap.clear();
        this.keyMap.clear();
        this.iPSPublisherContext = null;
        this.iPSSysSFPub = null;
        this.iPSSystem = null;
        this.strDEFilter = null;
        super.onClose();
        if (this.iPSSFCodeType != null) {
            this.iPSSFCodeType.releasePSSFSysCodePublisher(this);
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSSysSFPub.getPSSysModelInstId();
    }

    @Override
    public IPSPublisherContext getContext() {
        return this.iPSPublisherContext;
    }

    @Override
    public ArrayList<PSSysSFCode> generateCode(IPSPublisherContext iPSPublisherContext, IPSSysSFPub iPSSysSFPub, IPSObject iPSObject) throws Exception {
        this.iPSPublisherContext = iPSPublisherContext;
        this.iPSSysSFPub = iPSSysSFPub;
        this.iPSSystem = iPSSysSFPub.getPSSystem();
        this.callLoopMap.clear();
        this.keyMap.clear();
        if (this.iPSSFCodeType.getPSSFCodeFolder().getModelLevel() > this.iPSSystem.getLoadedLevel()) {
            return null;
        }
        return this.onGenerateCode(iPSObject);
    }

    protected abstract ArrayList<PSSysSFCode> onGenerateCode(IPSObject var1) throws Exception;

    protected PSSysSFCode createPSSysSFCode(boolean bAlways, boolean bReturnMode) {
        PSSysSFCode psSysSFCode = null;
        if (bAlways || bReturnMode) {
            psSysSFCode = new PSSysSFCode();
        }
        if (bReturnMode) {
            psSysSFCode.setParamValue("PSSYSSFCODE", 1);
        }
        return psSysSFCode;
    }

    protected IPSSysSFPub getPSSysSFPub() {
        return this.iPSSysSFPub;
    }

    @Override
    public String getCodePart(String strCodePart, Object objItem) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(strCodePart, objItem, null);
        return iPSGenerateCodeResult.getCode();
    }

    @Override
    public boolean hasCodePart(String strCodePart) throws Exception {
        return this.iPSSFCodeType.getPSSFCodeTemplByTag(strCodePart, true) != null;
    }

    protected IPSGenerateCodeResult internalGetPartCode(Object objPart, String strCodeType, HashMap<String, Object> params) throws Exception {
        Object objItem = null;
        if (!StringHelper.IsNullOrEmpty((String)strCodeType)) {
            objItem = objPart;
        }
        String strTag = null;
        if (objItem instanceof IPSModelObject) {
            IPSModelObject iPSModelObject = (IPSModelObject)objItem;
            strTag = KeyValueHelper.genUniqueId((String)iPSModelObject.getModelType(), (String)iPSModelObject.getModelId(), (String)strCodeType);
            if (this.callLoopMap.containsKey(strTag)) {
                throw new PSRecursionException(StringHelper.Format((String)"\u53d1\u5e03[%1$s][%2$s]\u6210\u5458\u4ee3\u7801[%3$s]\u51fa\u73b0\u9012\u5f52", (Object)iPSModelObject.getModelType(), (Object)iPSModelObject.getModelName(), (Object)strCodeType));
            }
            this.callLoopMap.put(strTag, 1);
        }
        HashMap<String, Object> params2 = new HashMap<String, Object>();
        params2.putAll(params);
        IPSGenerateCodeResult iPSGenerateCodeResult = this.generateCode(strCodeType, objItem, params);
        if (!StringHelper.IsNullOrEmpty((String)strTag)) {
            this.callLoopMap.remove(strTag);
        }
        return iPSGenerateCodeResult;
    }

    protected boolean internalTestPartCode(Object objPart) throws Exception {
        return this.iPSSFCodeType.getPSSFCodeTemplByTag((String)objPart, true) != null;
    }

    protected boolean internalExists(String strType, String strParam, String strParam2) {
        String strKey = KeyValueHelper.genUniqueId((String)strType, (String)strParam, (String)strParam2);
        if (this.keyMap.containsKey(strKey)) {
            return true;
        }
        if (this.keyMap.size() > 5000) {
            log.error((Object)StringHelper.Format((String)"\u91cd\u590d\u9879\u9650\u5236\u8d85\u51fa\u9650\u5236[%1$s]", (Object)5000));
            return true;
        }
        this.keyMap.put(strKey, "");
        return false;
    }

    protected boolean internalSet(String strParam, String strValue) {
        String strKey = KeyValueHelper.genUniqueId((String)"_PARAMTYPE_", (String)strParam, null);
        if (!this.keyMap.containsKey(strKey) && this.keyMap.size() > 5000) {
            log.error((Object)StringHelper.Format((String)"\u91cd\u590d\u9879\u9650\u5236\u8d85\u51fa\u9650\u5236[%1$s]", (Object)5000));
            return false;
        }
        this.keyMap.put(strKey, strValue);
        return true;
    }

    protected String internalGet(String strParam, String strDefault) {
        String strKey = KeyValueHelper.genUniqueId((String)"_PARAMTYPE_", (String)strParam, null);
        String strValue = this.keyMap.get(strKey);
        if (!StringHelper.IsNullOrEmpty((String)strValue)) {
            return strValue;
        }
        if (!StringHelper.IsNullOrEmpty((String)strDefault)) {
            return strDefault;
        }
        return "";
    }

    @Override
    public IPSSFStyle2 getPSSFStyle2() {
        if (this.iPSSFStyle instanceof IPSSFStyle2) {
            return (IPSSFStyle2)this.iPSSFStyle;
        }
        return null;
    }

    @Override
    public void fillPublisherParams(IPSModelObject iPSModelObject, Map<String, IPSCodePublisherParam> publisherParamMap) {
    }

    protected boolean isCheckModelOnly() {
        return this.bCheckModelOnly;
    }

    protected boolean isRemoveEmptyFile() {
        return this.bRemoveEmptyFile;
    }
}

