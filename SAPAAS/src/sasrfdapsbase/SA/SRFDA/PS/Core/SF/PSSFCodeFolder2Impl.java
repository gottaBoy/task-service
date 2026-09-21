/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.SF;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.SF.IPSSFCodeFolder2;
import SA.SRFDA.PS.Core.SF.IPSSFCodeType;
import SA.SRFDA.PS.Core.SF.IPSSFPubObj;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Core.SF.PSSFCodeType2Impl;
import SA.SRFDA.PS.Core.Util.TemplFileHelper;
import SA.SRFDA.PS.Data.PSSFCodeFolder;
import SA.SRFDA.PS.Data.PSSFCodeType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.Utility.StringHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSFCodeFolder2Impl
extends PSObjectImpl
implements IPSSFCodeFolder2 {
    private static final Log log = LogFactory.getLog(PSSFCodeFolder2Impl.class);
    protected IPSSFStyle2 iPSSFStyle = null;
    protected PSSFCodeFolder psSFCodeFolder = null;
    protected ArrayList<IPSSFCodeType> psSFCodeTypeList = new ArrayList();
    protected HashMap<String, IPSSFCodeType> psSFCodeTypeMap = new HashMap();
    private String strHeaderCode = null;
    private String strBottomCode = null;
    private int nModelLevel = IPSSystem.LOADLEVEL_PREVIEW;
    private String strPrjFolder = null;
    private IPSSFStylePrj iPSSFStylePrj = null;
    private String strFolderCode = null;
    private File rootFolder = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSFStyle iPSSFStyle, PSSFCodeFolder psSFCodeFolder) throws Exception {
        this.psSFCodeFolder = psSFCodeFolder;
        this.iPSSFStyle = (IPSSFStyle2)iPSSFStyle;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(this.psSFCodeFolder.getPSSFCODEFOLDERID());
        this.setName(this.psSFCodeFolder.getPSSFCODEFOLDERNAME());
        this.setPSObjectData(this.psSFCodeFolder);
        this.strFolderCode = this.psSFCodeFolder.getFOLDERNAME();
        this.strHeaderCode = this.psSFCodeFolder.getHEADERCODE();
        this.strBottomCode = this.psSFCodeFolder.getBOTTOMCODE();
        if (!StringHelper.IsNullOrEmpty((String)this.psSFCodeFolder.getPSSFSTYLEPRJID())) {
            this.iPSSFStylePrj = iPSSFStyle.getPSSFStylePrj(this.psSFCodeFolder.getPSSFSTYLEPRJID(), false);
            this.strPrjFolder = this.psSFCodeFolder.getPRJFOLDER();
        }
        this.rootFolder = new File(this.getPSSFStyle2().getRealLocalPath());
        if (!this.psSFCodeFolder.isMODELLEVELNull()) {
            this.nModelLevel = this.psSFCodeFolder.getMODELLEVEL();
        }
        this.onInit();
    }

    @Override
    public String getFolderCode() {
        return this.strFolderCode;
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.onPreparePSSFCodeTypes();
    }

    protected void onPreparePSSFCodeTypes() throws Exception {
        this.psSFCodeTypeList.clear();
        this.psSFCodeTypeMap.clear();
        File folder = new File(String.valueOf(this.rootFolder.getCanonicalPath()) + File.separator + this.getFolderCode());
        this.onPreparePSSFCodeTypes(folder, "");
    }

    @Override
    public Iterator<IPSSFCodeType> getPSSFCodeTypes() throws Exception {
        return this.psSFCodeTypeList.iterator();
    }

    @Override
    public IPSSFCodeType getPSSFCodeType(String strSFCodeTypeId) throws Exception {
        IPSSFCodeType iPSSFCodeType = this.psSFCodeTypeMap.get(strSFCodeTypeId);
        if (iPSSFCodeType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u7c7b\u578b[%1$s]", (Object)strSFCodeTypeId));
        }
        return iPSSFCodeType;
    }

    @Override
    public IPSSFCodeType getPSSFCodeType(String strSFCodeTypeId, boolean bTryMode) throws Exception {
        IPSSFCodeType iPSSFCodeType = this.psSFCodeTypeMap.get(strSFCodeTypeId);
        if (iPSSFCodeType == null && !bTryMode) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4ee3\u7801\u7c7b\u578b"));
        }
        return iPSSFCodeType;
    }

    @Override
    public void resetPSSFCodeType(String strSFCodeTypeId) throws Exception {
        IPSSFCodeType iPSSFCodeType = this.psSFCodeTypeMap.remove(strSFCodeTypeId);
        if (iPSSFCodeType != null) {
            this.psSFCodeTypeMap.remove(iPSSFCodeType.getId());
            if (!StringHelper.IsNullOrEmpty((String)iPSSFCodeType.getTypeCode())) {
                this.psSFCodeTypeMap.remove(iPSSFCodeType.getTypeCode());
            }
        }
    }

    @Override
    public IPSSFStyle getPSSFStyle() {
        return this.getPSSFStyle2();
    }

    public IPSSFStyle2 getPSSFStyle2() {
        return this.iPSSFStyle;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getHeaderCode() {
        return this.strHeaderCode;
    }

    @Override
    public String getBottomCode() {
        return this.strBottomCode;
    }

    @Override
    public int getModelLevel() {
        return this.nModelLevel;
    }

    @Override
    public IPSSFStylePrj getPSSFStylePrj() {
        return this.iPSSFStylePrj;
    }

    @Override
    public String getPrjFolder() {
        return this.strPrjFolder;
    }

    protected void onPreparePSSFCodeTypes(File folder, String strStartFilePath) throws Exception {
        File[] files;
        File[] fileArray = files = folder.listFiles();
        int n = files.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray[n2];
            if (file.isDirectory()) {
                String strFolderName = file.getName();
                this.onPreparePSSFCodeTypes(file, String.valueOf(strStartFilePath) + "/" + strFolderName);
            } else {
                String strSuffix;
                int nPos;
                String strFilePath = strStartFilePath;
                String strFileName = file.getName();
                if (strFileName.indexOf("#") == -1 && (nPos = strFileName.lastIndexOf(".")) > 0 && (strSuffix = strFileName.substring(nPos + 1)).compareToIgnoreCase("ftl") == 0) {
                    strFileName = strFileName.substring(0, strFileName.length() - 4);
                    String strFileCodeType = this.getName();
                    if (!StringHelper.IsNullOrEmpty((String)strFilePath)) {
                        strFileCodeType = String.valueOf(strFileCodeType) + "/";
                        strFileCodeType = String.valueOf(strFileCodeType) + strFilePath;
                    }
                    strFileCodeType = String.valueOf(strFileCodeType) + "/" + strFileName;
                    TemplFileHelper templFileHelper = new TemplFileHelper();
                    BaseDataEntity baseDataEntity = templFileHelper.getTemplData(file, this.rootFolder);
                    String strTemplate = baseDataEntity.getParamStringValue("TEMPLATE", "");
                    String strContent = baseDataEntity.getParamStringValue("CONTENT", "");
                    Properties macroParams = null;
                    if (!StringHelper.IsNullOrEmpty((String)strTemplate)) {
                        macroParams = PropertiesHelper.load((String)strTemplate);
                    }
                    String templFileName = file.getCanonicalPath().substring(this.rootFolder.getCanonicalPath().length());
                    strFileName = PropertiesHelper.getProperty((Properties)macroParams, (String)"FILENAME", (String)strFileName);
                    String strTarget = PropertiesHelper.getProperty((Properties)macroParams, (String)"TARGET", (String)"");
                    String strCond = PropertiesHelper.getProperty((Properties)macroParams, (String)"COND", (String)"");
                    boolean bCheckModelOnly = PropertiesHelper.getProperty((Properties)macroParams, (String)"CHECKMODELONLY", (boolean)false);
                    boolean bRemoveEmptyFile = PropertiesHelper.getProperty((Properties)macroParams, (String)"REMOVEEMPTYFILE", (boolean)true);
                    String strPubObj = null;
                    String strModelList = strTarget;
                    if (StringHelper.IsNullOrEmpty((String)strTarget)) {
                        strPubObj = PropertiesHelper.getProperty((Properties)macroParams, (String)"PUBOBJ", (String)"");
                        strModelList = PropertiesHelper.getProperty((Properties)macroParams, (String)"MODELS", (String)"");
                        if (StringHelper.IsNullOrEmpty((String)strPubObj)) {
                            throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u6ca1\u6709\u6307\u5b9a\u53d1\u5e03\u6a21\u578b", (Object)templFileName));
                        }
                    }
                    String strPubParam = "";
                    if (strTarget.indexOf("PSAPPVIEWCTRL_") == 0) {
                        strPubParam = strTarget.substring(14);
                        strTarget = "PSAPPVIEWCTRL";
                    }
                    IPSSFPubObj iPSSFPubObj = null;
                    if (!StringHelper.IsNullOrEmpty((String)strTarget) && (iPSSFPubObj = this.getPSSFStyle().getPSSF().getPSSFPubObjByTarget(strTarget, true)) == null) {
                        throw new Exception(StringHelper.Format((String)"\u6a21\u677f[%1$s]\u53d1\u5e03\u6a21\u578b[%2$s]\u65e0\u6cd5\u8bc6\u522b", (Object)templFileName, (Object)strTarget));
                    }
                    if (strFilePath.indexOf("%") != -1 && macroParams != null) {
                        strFilePath = TemplFileHelper.replaceMacros(strFilePath, macroParams);
                    }
                    if (strFilePath.indexOf("%") != -1 && iPSSFPubObj != null) {
                        strFilePath = iPSSFPubObj.replaceMacros(strFilePath);
                    }
                    if (strFileName.indexOf("%") != -1 && macroParams != null) {
                        strFileName = TemplFileHelper.replaceMacros(strFileName, macroParams);
                    }
                    if (strFileName.indexOf("%") != -1 && iPSSFPubObj != null) {
                        strFileName = iPSSFPubObj.replaceMacros(strFileName);
                    }
                    if (strFileName.indexOf("%") != -1) {
                        throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u540d\u79f0[%1$s]", (Object)strFileName));
                    }
                    if (strFilePath.indexOf("%") != -1) {
                        throw new Exception(StringHelper.Format((String)"\u51fa\u73b0\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u8def\u5f84[%1$s]", (Object)strFilePath));
                    }
                    PSSFCodeType psSFCodeType = new PSSFCodeType();
                    psSFCodeType.setPSSFCODETYPEID(KeyValueHelper.genUniqueId((String)this.getId(), (String)strFileCodeType));
                    psSFCodeType.setTYPECODE(strFileCodeType);
                    psSFCodeType.setCODEPATH(strFilePath);
                    psSFCodeType.setFILENAME(strFileName);
                    if (iPSSFPubObj != null) {
                        psSFCodeType.setPUBOBJ(iPSSFPubObj.getPubObj());
                    } else {
                        psSFCodeType.setPUBOBJ(StringHelper.Format((String)"SA.SRFDA.PS.Core.Pub.PSIBiz5%1$sPublisherImpl", (Object)strPubObj));
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strCond)) {
                        strContent = StringHelper.Format((String)"<#if (%1$s) >\r\n%2$s\r\n</#if>", (Object)strCond, (Object)strContent);
                    }
                    psSFCodeType.setCODETEMPL(strContent);
                    psSFCodeType.setPSSFCODETYPENAME(strFileCodeType);
                    if (iPSSFPubObj != null && !StringHelper.IsNullOrEmpty((String)iPSSFPubObj.getModelList())) {
                        strModelList = String.valueOf(strModelList) + ";";
                        strModelList = String.valueOf(strModelList) + iPSSFPubObj.getModelList();
                    }
                    psSFCodeType.setMODELLIST(strModelList);
                    psSFCodeType.setTEMPLCODE2(file.getCanonicalPath());
                    psSFCodeType.setParamValue("PUBPARAM", strPubParam);
                    psSFCodeType.setCHECKMODELONLY(bCheckModelOnly);
                    psSFCodeType.setREMOVEEMPTYFILE(bRemoveEmptyFile);
                    PSSFCodeType2Impl iPSSFCodeType = new PSSFCodeType2Impl();
                    iPSSFCodeType.init(this.getDAGlobalHelper(), this, psSFCodeType);
                    this.psSFCodeTypeMap.put(iPSSFCodeType.getId(), iPSSFCodeType);
                    if (!StringHelper.IsNullOrEmpty((String)iPSSFCodeType.getTypeCode())) {
                        this.psSFCodeTypeMap.put(iPSSFCodeType.getTypeCode(), iPSSFCodeType);
                    }
                    this.psSFCodeTypeList.add(iPSSFCodeType);
                }
            }
            ++n2;
        }
    }
}

