/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.IPSSystem
 *  net.ibizsys.model.codelist.IPSCodeList
 *  net.ibizsys.model.control.grid.IPSDEFGridColumn
 *  net.ibizsys.model.core.IPSModelObject
 *  net.ibizsys.model.dataentity.IPSDataEntity
 *  net.ibizsys.model.dataentity.IPSDataEntityObject
 *  net.ibizsys.model.dataentity.field.IPSDEFSearchMode
 *  net.ibizsys.model.dataentity.field.IPSDEFUIMode
 *  net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule
 *  net.ibizsys.model.res.IPSLanguageRes
 *  net.ibizsys.paas.core.IDEFDBValueFunc
 *  net.ibizsys.paas.core.IDEFDTColumn
 *  net.ibizsys.paas.core.IDEFSearchMode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.valuerule.IDEFValueRule
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model.dataentity.field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSysEngineConfig;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.IPSSystemSetting;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSModels;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.grid.IPSDEFGridColumn;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEFUIMode;
import net.ibizsys.model.dataentity.field.IPSDEFieldRuntime;
import net.ibizsys.model.dataentity.field.IPSDEFieldType;
import net.ibizsys.model.dataentity.field.IPSSysDEFType;
import net.ibizsys.model.dataentity.field.PSDEFSearchModeGlobalModel;
import net.ibizsys.model.dataentity.field.PSDEFUIModeGlobalModel;
import net.ibizsys.model.dataentity.field.valuerule.IPSDEFValueRule;
import net.ibizsys.model.dataentity.field.valuerule.PSDEFValueRuleGlobalModel;
import net.ibizsys.model.entity.PSDEFSearchMode;
import net.ibizsys.model.entity.PSDEFUIMode;
import net.ibizsys.model.entity.PSDEField;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFieldImpl
extends PSSystemObjectImpl
implements IPSDEFieldRuntime,
IPSDataEntityObject {
    protected IPSDataEntity iPSDataEntity = null;
    protected PSDEField psDEField = null;
    protected IPSDEFieldType iPSDEFieldType = null;
    protected IPSSysDEFType iPSSysDEFType = null;
    private static final Log log = LogFactory.getLog(PSDEFieldImpl.class);
    private static final ArrayList<IPSDEFSearchMode> emptyPSDEFSearchModeList = new ArrayList();
    protected static HashMap<String, Integer> systemFields = new HashMap();
    protected Properties defProperties = null;
    protected boolean bUserVisible = true;
    private boolean bMajorField = false;
    private boolean bKeyField = false;
    private boolean bIndexTypeField = false;
    private boolean bFormTypeField = false;
    private boolean bUniTagField = false;
    private boolean bValidFlag = true;
    private boolean bInit = false;
    private boolean bAllowEmpty = true;
    private String strCodeListId = "";
    private String strValueFormat = "";
    private String strPreDefinedType = "";
    private boolean bEnableQuickSearch = false;
    private IPSCodeList iPSCodeList = null;
    private String strDupCheckMode = "NONE";
    private String[] dupCheckValues = null;
    private String strUpdateDBValueMode = null;
    private String strInsertDBValueMode = null;
    private int nStringLength = -1;
    private int nLength = -1;
    private int nPrecision = 0;
    private int nImportOrder = 1000;
    private String strImportTag = "";
    private boolean bEnablePrivilege = false;
    private int nOrderValue = 1000;
    private String strLNLanResTag = "";
    private IPSLanguageRes lnPSLanguageRes = null;
    private boolean bCheckRecursion = false;
    private int nExtendMode = 0;
    private boolean bDynaStorageDEField = false;
    protected PSDEFUIModeGlobalModel psDEFUIModeGlobalModel = new PSDEFUIModeGlobalModel();
    protected PSDEFValueRuleGlobalModel psDEFValueRuleGlobalModel = new PSDEFValueRuleGlobalModel();
    protected PSDEFSearchModeGlobalModel psDEFSearchModeGlobalModel = null;
    private String strCodeName = "";
    private boolean bQueryColumn = true;
    private int nStdDataType = 0;
    private String strTableName = "";
    private boolean bEnableTempData = false;
    private long nCreateTime = 0L;
    private int nViewColLevel = 0;
    private int nDEFType = 0;
    private boolean bCalcSystemReserver = false;
    private boolean bSystemReserver = false;
    private boolean bCalcDataType = false;
    private String strDataType = "";

    static {
        systemFields.put("CREATEMAN", 0);
        systemFields.put("CREATEMANNAME", 0);
        systemFields.put("CREATEDATE", 0);
        systemFields.put("UPDATEMANNAME", 0);
        systemFields.put("UPDATEMAN", 0);
        systemFields.put("UPDATEDATE", 0);
        systemFields.put("ENABLE", 1);
    }

    @Override
    public void setInitParam(IPSModelStorageContext iPSModelStorageContext, IPSDataEntity iPSDataEntity, IPSDEFieldType iPSDEFieldType, PSDEField psDEField) {
        this.setPSModelStorageContext(iPSModelStorageContext);
        this.iPSDataEntity = iPSDataEntity;
        this.psDEField = psDEField;
        this.iPSDEFieldType = iPSDEFieldType;
        if (this.iPSDEFieldType instanceof IPSSysDEFType) {
            this.iPSSysDEFType = (IPSSysDEFType)this.iPSDEFieldType;
        }
        this.setId(this.psDEField.getPSDEFIELDID());
        this.setName(this.psDEField.getPSDEFIELDNAME());
        this.setPSObjectData(this.psDEField);
        if (!this.psDEField.isDEFTYPENull()) {
            this.nDEFType = this.psDEField.getDEFTYPE();
        }
        this.bDynaStorageDEField = this.nDEFType == 4;
        this.strTableName = this.psDEField.getTABLENAME();
        this.bEnableTempData = iPSDataEntity.isEnableTempData();
        if (this.bEnableTempData && !this.psDEField.isENABLETEMPDATANull()) {
            this.bEnableTempData = this.psDEField.getENABLETEMPDATA();
        }
        if (this.psDEField.getMAJORFIELD()) {
            this.bMajorField = true;
        }
        if (!this.psDEField.isPKEYNull()) {
            if (this.psDEField.getPKEY() == 1) {
                this.bKeyField = true;
            }
            if (this.psDEField.getPKEY() == 2) {
                this.bUniTagField = true;
            }
        }
        this.bAllowEmpty = this.psDEField.getALLOWEMPTY();
        if (this.psDEField.getINDEXTYPE()) {
            this.bIndexTypeField = true;
        }
        if (this.psDEField.getMULTIFORMFIELD()) {
            this.bFormTypeField = true;
        }
        this.strCodeName = this.psDEField.getCODENAME();
        if (StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.psDEField.getPSDEFIELDNAME().toLowerCase();
        }
        if (!StringHelper.isNullOrEmpty((String)this.strCodeName)) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
        }
        this.nStdDataType = this.iPSDEFieldType.getStdDataType();
        try {
            this.psDEFUIModeGlobalModel.init(this.getPSModelStorageContext(), this);
            this.psDEFValueRuleGlobalModel.init(this.getPSModelStorageContext(), this);
            if (this.psDEField.getPSDEFSearchModes(false) != null) {
                this.psDEFSearchModeGlobalModel = new PSDEFSearchModeGlobalModel();
                this.psDEFSearchModeGlobalModel.init(this.getPSModelStorageContext(), this);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
        this.strValueFormat = this.psDEField.getVALUEFORMAT();
        if (StringHelper.isNullOrEmpty((String)this.strValueFormat) && !this.isLinkDEField()) {
            this.strValueFormat = this.iPSDEFieldType.getValueFormat(this.getPSDataEntity().getPSSystem().getSFType());
        }
        this.bEnableQuickSearch = !this.psDEField.isENABLEQSNull() ? this.psDEField.getENABLEQS() : this.isMajorDEField();
        if (!StringHelper.isNullOrEmpty((String)this.psDEField.getDUPCHECKMODE())) {
            this.strDupCheckMode = this.psDEField.getDUPCHECKMODE();
        }
        if (!StringHelper.isNullOrEmpty((String)this.psDEField.getDUPCHECKVALUES())) {
            String strDupCheckValues = this.psDEField.getDUPCHECKVALUES();
            strDupCheckValues = strDupCheckValues.trim();
            this.dupCheckValues = strDupCheckValues.split("[;]");
        }
        if (!this.psDEField.isDBVALUEMODENull()) {
            this.strUpdateDBValueMode = this.psDEField.getDBVALUEMODE();
        }
        if (!this.psDEField.isDBVALUEMODE2Null()) {
            this.strInsertDBValueMode = this.psDEField.getDBVALUEMODE2();
        }
        if (!this.psDEField.isIMPORTORDERNull()) {
            this.nImportOrder = this.psDEField.getIMPORTORDER();
        }
        if (!this.psDEField.isIMPORTTAGNull()) {
            this.strImportTag = this.psDEField.getIMPORTTAG();
        }
        if (!this.psDEField.isENABLECOLPRIVNull()) {
            this.bEnablePrivilege = this.psDEField.getENABLECOLPRIV();
        }
        if (!this.psDEField.isORDERVALUENull() && this.psDEField.getORDERVALUE() >= 0) {
            this.nOrderValue = this.psDEField.getORDERVALUE();
        }
        if (!this.psDEField.isCREATEDATENull()) {
            this.nCreateTime = this.psDEField.getCREATEDATE().getTime();
        }
        if (!this.psDEField.isEXTENDMODENull()) {
            this.nExtendMode = this.psDEField.getEXTENDMODE();
        }
        this.bInit = false;
    }

    @Override
    public synchronized void init() throws Exception {
        if (this.bInit) {
            return;
        }
        try {
            if (this.iPSDataEntity == null || this.psDEField == null || this.iPSDEFieldType == null || this.getPSModelStorageContext() == null) {
                throw new Exception("\u521d\u59cb\u5316\u53c2\u6570\u65e0\u6548");
            }
            this.bInit = true;
            this.nViewColLevel = !this.psDEField.isVIEWCOLLEVELNull() ? this.psDEField.getVIEWCOLLEVEL() : this.onCalcViewLevel();
            this.strCodeListId = this.onGetCodeListId();
            this.nStdDataType = this.onGetStdDataType();
            this.bCheckRecursion = this.onCalcCheckRecursion();
            if (!StringHelper.isNullOrEmpty((String)this.psDEField.getLNPSLANRESID())) {
                this.lnPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEField.getLNPSLANRESID());
            }
            if (!this.psDEField.isLENGTHNull()) {
                this.nLength = this.psDEField.getLENGTH();
            }
            if (DataTypeHelper.isStringType((int)this.getStdDataType())) {
                if (!this.psDEField.isSTRLENGTHNull()) {
                    this.nStringLength = this.psDEField.getSTRLENGTH();
                }
                if (this.nStringLength <= 0) {
                    this.nStringLength = this.psDEField.getLENGTH();
                }
                if (this.nStringLength <= 0) {
                    this.nStringLength = this.onGetStringLength();
                }
                if (this.nStringLength <= 0) {
                    this.nStringLength = DataTypeHelper.isLongStringType((int)this.getStdDataType()) ? 0x100000 : 200;
                }
                if (this.nLength <= 0) {
                    this.nLength = this.nStringLength;
                }
            } else {
                this.nPrecision = !this.psDEField.isPRECISION2Null() && this.psDEField.getPRECISION2() > 0 ? this.psDEField.getPRECISION2() : this.onGetPrecision();
                if (this.nLength < 0) {
                    this.nLength = this.onGetLength();
                }
            }
            if (!this.psDEField.isQUERYCOLUMNNull()) {
                this.bQueryColumn = this.psDEField.getQUERYCOLUMN();
            } else if (DataTypeHelper.isLongStringType((int)this.getStdDataType())) {
                this.bQueryColumn = false;
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName(this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            throw ex;
        }
    }

    @Override
    public boolean isInit() {
        return this.bInit;
    }

    @Override
    protected void onInit() throws Exception {
        IPSSysEngineConfig iPSSysEngineConfig = this.getPSSysEngineConfig();
        if (iPSSysEngineConfig != null && iPSSysEngineConfig.getImpDEFRule() != -1) {
            if (this.psDEField.isIMPORTORDERNull()) {
                this.nImportOrder = this.onCalcImportOrder(iPSSysEngineConfig.getImpDEFRule());
            }
            if (this.getImportOrder() != -1 && this.psDEField.isIMPORTTAGNull()) {
                this.strImportTag = this.onCalcImportTag(iPSSysEngineConfig.getImpDEFRule());
            }
        }
        super.onInit();
    }

    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public PSDEField getPSDEFieldData() {
        return this.psDEField;
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0")
    public String getLogicName() {
        return this.getLogicName("");
    }

    public String getLogicName(String strLanguage) {
        return this.psDEField.getLOGICNAME();
    }

    public static boolean isLinkDataType(String strDataType) {
        if (StringHelper.compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
            return true;
        }
        return StringHelper.compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0;
    }

    public boolean isLinkDEField() {
        return false;
    }

    public boolean isFormulaDEField() {
        return false;
    }

    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027")
    public boolean isPhisicalDEField() {
        return true;
    }

    public boolean isMajorDEField() {
        return this.bMajorField;
    }

    public boolean isKeyDEField() {
        return this.bKeyField;
    }

    public boolean isUniTagField() {
        return this.bUniTagField;
    }

    public boolean isIndexTypeDEField() {
        return this.bIndexTypeField;
    }

    public boolean isInheritDEField() {
        return false;
    }

    public boolean isSystemReserver() {
        if (!this.bCalcSystemReserver) {
            this.bSystemReserver = this.onCalcSystemReserver();
        }
        return this.bSystemReserver;
    }

    protected boolean onCalcSystemReserver() {
        return systemFields.containsKey(this.getName());
    }

    public String getCodeListId() {
        return this.strCodeListId;
    }

    protected String onGetCodeListId() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psDEField.getPSCODELISTID())) {
            return this.psDEField.getPSCODELISTID();
        }
        if (this.iPSSysDEFType != null && !StringHelper.isNullOrEmpty((String)this.iPSSysDEFType.getPSCodeListId())) {
            return this.iPSSysDEFType.getPSCodeListId();
        }
        String strCodeListTemplId = this.iPSDEFieldType.getPSCodeListTemplId();
        if (StringHelper.isNullOrEmpty((String)strCodeListTemplId)) {
            return "";
        }
        return this.getPSDataEntity().getPSSystem().getPSCodeListByTempl(strCodeListTemplId).getId();
    }

    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType")
    public int getStdDataType() {
        return this.nStdDataType;
    }

    protected int onGetStdDataType() throws Exception {
        return this.iPSDEFieldType.getStdDataType();
    }

    protected int onGetLength() throws Exception {
        return this.iPSDEFieldType.getLength();
    }

    protected int onGetPrecision() throws Exception {
        return this.iPSDEFieldType.getPrecision();
    }

    protected int onGetStringLength() throws Exception {
        return this.iPSDEFieldType.getStringLength();
    }

    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b", codelist="DEFDataTypes")
    public String getDataType() {
        if (!this.bCalcDataType) {
            this.strDataType = this.onGetDataType();
            this.bCalcDataType = true;
        }
        return this.strDataType;
    }

    protected String onGetDataType() {
        return this.psDEField.getPSDATATYPEID();
    }

    @PSModelRTMeta(description="\u62f7\u8d1d\u91cd\u7f6e")
    public boolean isPasteReset() {
        if (this.isKeyDEField() || this.isUniTagField()) {
            return true;
        }
        return this.psDEField.getPASTERESET();
    }

    public String getUpdateOVMode() {
        return this.psDEField.getUPDATEOVMODE();
    }

    @PSModelRTMeta(description="\u4ee3\u7801\u540d\u79f0")
    public String getCodeName() {
        return this.strCodeName;
    }

    @PSModelRTMeta(description="\u652f\u6301\u7528\u6237\u8f93\u5165")
    public boolean isEnableUserInsert() {
        return (this.psDEField.getENABLEUSERINPUT() & 1) > 0;
    }

    @PSModelRTMeta(description="\u652f\u6301\u7528\u6237\u66f4\u65b0")
    public boolean isEnableUserUpdate() {
        return (this.psDEField.getENABLEUSERINPUT() & 2) > 0;
    }

    public boolean isEnablePriv() {
        return false;
    }

    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u8f6c\u5316", codelist="StringCaseMode")
    public String getStringCase() {
        return this.psDEField.getSTRINGCASE();
    }

    public String getFullName() {
        return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSDataEntity().getFullName(), (Object)this.getName());
    }

    @Override
    public IPSDEFieldType getPSDEFieldType() {
        return this.iPSDEFieldType;
    }

    @Override
    public IPSDEFGridColumn createPSDEFGridColumn(PSDEFUIMode psDEFUIMode) throws Exception {
        return this.getPSDEFieldType().createPSDEFGridColumn(psDEFUIMode);
    }

    @Override
    public IPSDEFUIMode createPSDEFUIMode(PSDEFUIMode psDEFUIMode) throws Exception {
        return this.getPSDEFieldType().createPSDEFUIMode(psDEFUIMode);
    }

    public IPSDEFUIMode getPSDEFUIMode(String strPSDEFUIModeId) throws Exception {
        return (IPSDEFUIMode)this.psDEFUIModeGlobalModel.findModelHelper(strPSDEFUIModeId);
    }

    @Override
    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode psDEFSearchMode) throws Exception {
        return this.getPSDEFieldType().createPSDEFSearchMode(psDEFSearchMode);
    }

    public IPSDEFSearchMode getPSDEFSearchMode(String strPSDEFSearchModeId) throws Exception {
        if (this.psDEFSearchModeGlobalModel == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u641c\u7d22\u6a21\u5f0f[%2$s]", (Object)this.getName(), (Object)strPSDEFSearchModeId));
        }
        return (IPSDEFSearchMode)this.psDEFSearchModeGlobalModel.findModelHelper(strPSDEFSearchModeId);
    }

    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165")
    public boolean isAllowEmpty() {
        return this.bAllowEmpty;
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22")
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    public Iterator<IDEFSearchMode> getDEFSearchModes() {
        return null;
    }

    @PSModelRTMeta(description="\u652f\u6301\u5b57\u6bb5\u6743\u9650")
    public boolean isEnablePrivilege() {
        return this.bEnablePrivilege;
    }

    public IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId) throws Exception {
        return (IPSDEFValueRule)this.psDEFValueRuleGlobalModel.findModelHelper(strPSDEFValueRuleId);
    }

    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219\u96c6\u5408")
    public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception {
        return this.psDEFValueRuleGlobalModel.getAllModelHelpers();
    }

    public IDEFValueRule getDEFValueRule(String strDVRId) throws Exception {
        return this.getPSDEFValueRule(strDVRId);
    }

    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316")
    public String getValueFormat() {
        return this.strValueFormat;
    }

    protected void setValueFormat(String strValueFormat) {
        this.strValueFormat = strValueFormat;
    }

    @PSModelRTMeta(description="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u96c6\u5408")
    public Iterator<IPSDEFSearchMode> getAllPSDEFSearchModes() throws Exception {
        if (this.psDEFSearchModeGlobalModel != null) {
            return this.psDEFSearchModeGlobalModel.getAllModelHelpers();
        }
        return emptyPSDEFSearchModeList.iterator();
    }

    @PSModelRTMeta(description="\u9884\u7f6e\u4e1a\u52a1\u7c7b\u578b", codelist="PreDefineFieldType")
    public String getPreDefinedType() {
        return this.strPreDefinedType;
    }

    @Override
    public void setPreDefinedType(String strPreDefinedType) {
        this.strPreDefinedType = strPreDefinedType;
    }

    public int getEnableUserInput() {
        return this.psDEField.getENABLEUSERINPUT();
    }

    @PSModelRTMeta(description="\u8054\u5408\u952e\u503c\u5c5e\u6027", codelist="UnionKeyValueMode")
    public String getUnionKeyValue() {
        return this.psDEField.getUNIONKEYVALUE();
    }

    @PSModelRTMeta(description="\u591a\u8868\u5355\u8bc6\u522b\u5c5e\u6027")
    public boolean isMultiFormDEField() {
        return this.psDEField.getMULTIFORMFIELD();
    }

    @PSModelRTMeta(description="\u5c5e\u6027\u4ee3\u7801\u8868")
    public IPSCodeList getPSCodeList() throws Exception {
        if (this.iPSCodeList != null || StringHelper.isNullOrEmpty((String)this.getCodeListId())) {
            return this.iPSCodeList;
        }
        this.iPSCodeList = this.getPSDataEntity().getPSSystem().getPSCodeList(this.strCodeListId);
        return this.iPSCodeList;
    }

    public boolean isFormTypeDEField() {
        return this.bFormTypeField;
    }

    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u6700\u5927\u8f93\u5165\u957f\u5ea6")
    public int getStringLength() {
        return this.nStringLength;
    }

    @PSModelRTMeta(description="\u5b57\u6bb5\u957f\u5ea6")
    public int getLength() {
        return this.nLength;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="DEFDefaultValueType")
    public String getDefaultValueType() {
        return this.psDEField.getDVT();
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c")
    public String getDefaultValue() {
        return this.psDEField.getDEFAULTVALUE();
    }

    public String getDBValueFunc() {
        return this.strUpdateDBValueMode;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysModelInstId((IPSModelObject)this.getPSDataEntity());
    }

    public String getPSSysValueRuleId() {
        String strPSSysValueRuleId = this.psDEField.getPSSYSVALUERULEID();
        if (!StringHelper.isNullOrEmpty((String)strPSSysValueRuleId)) {
            return strPSSysValueRuleId;
        }
        if (this.iPSSysDEFType != null) {
            this.iPSSysDEFType.getPSSysValueRuleId();
        }
        return strPSSysValueRuleId;
    }

    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u5c5e\u6027\u6a21\u5f0f", codelist="DEMSFieldMode")
    public String getDEMSFieldMode() {
        return this.psDEField.getSTATEFIELD();
    }

    @PSModelRTMeta(description="\u5bfc\u5165\u6b21\u5e8f")
    public int getImportOrder() {
        return this.nImportOrder;
    }

    @PSModelRTMeta(description="\u5bfc\u5165\u6807\u8bc6")
    public String getImportTag() {
        return this.strImportTag;
    }

    protected int onCalcImportOrder(int nRuleMode) throws Exception {
        switch (nRuleMode) {
            case 1: {
                if (this.isMajorDEField()) {
                    return 100;
                }
                return -1;
            }
        }
        return this.nImportOrder;
    }

    protected String onCalcImportTag(int nRuleMode) throws Exception {
        return this.strImportTag;
    }

    public String getMemo() {
        return this.psDEField.getMEMO();
    }

    public String getDERName() {
        return null;
    }

    public String getLinkDEFName() {
        return null;
    }

    public boolean isEnableWriteBack() {
        return false;
    }

    public boolean isEnableTempData() {
        return this.bEnableTempData;
    }

    public int getOrderValue() {
        return this.nOrderValue;
    }

    public String getLNLanResTag() {
        if (this.getLNPSLanguageRes() == null) {
            return this.strLNLanResTag;
        }
        return this.getLNPSLanguageRes().getLanResTag();
    }

    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    public long getCreateTime() {
        return this.nCreateTime;
    }

    protected IPSSysEngineConfig getPSSysEngineConfig() {
        return ((IPSSystemSetting)this.getPSDataEntity().getPSSystem()).getPSSysEngineConfig();
    }

    @PSModelRTMeta(description="\u68c0\u67e5\u9012\u5f52")
    public boolean isCheckRecursion() {
        return this.bCheckRecursion;
    }

    protected boolean onCalcCheckRecursion() throws Exception {
        if (this.psDEField.isCHECKRECURSIONNull()) {
            return false;
        }
        return this.psDEField.getCHECKRECURSION();
    }

    protected int onCalcViewLevel() {
        if (this.isPhisicalDEField()) {
            return 1;
        }
        return 0;
    }

    @PSModelRTMeta(description="\u6570\u636e\u5e93\u81ea\u52a8\u4ea7\u751f\u503c")
    public boolean isEnableDBAutoValue() {
        if (this.isEnableDBValueInsertUpdateMode() && !StringHelper.isNullOrEmpty((String)this.getDBValueInsertMode())) {
            return true;
        }
        return this.iPSDEFieldType.isAutoIncrement();
    }

    @PSModelRTMeta(description="\u6570\u636e\u5e93\u65b0\u5efa\u503c\u6a21\u5f0f", codelist="DBValueMode", hideempty2=true)
    public String getDBValueInsertMode() {
        return this.strInsertDBValueMode;
    }

    @PSModelRTMeta(description="\u6570\u636e\u5e93\u66f4\u65b0\u503c\u6a21\u5f0f", codelist="DBValueMode", hideempty2=true)
    public String getDBValueUpdateMode() {
        return this.strUpdateDBValueMode;
    }

    @Override
    public IPSSystem getPSSystem() {
        return this.getPSDataEntity().getPSSystem();
    }

    public boolean isEnableDBValueInsertUpdateMode() {
        return this.getPSSystemSetting().isEnableDBValueInsertUpdateMode();
    }

    public IDEFDBValueFunc getDEFDBValueFunc(String strDBType, boolean bInsert) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public int getDEFType() {
        return this.nDEFType;
    }

    public boolean isDynaStorageDEField() {
        return this.bDynaStorageDEField;
    }

    protected void setDynaStorageDEField(boolean bDynaStorageDEField) {
        this.bDynaStorageDEField = bDynaStorageDEField;
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u5ba1\u8ba1")
    public boolean isEnableAudit() {
        return this.psDEField.getENABLEAUDIT();
    }

    @PSModelRTMeta(description="\u5ba1\u8ba1\u683c\u5f0f")
    public String getAuditInfoFormat() {
        String strAuditInfoFormat = this.psDEField.getAUDITINFOFORMAT();
        return strAuditInfoFormat;
    }

    @PSModelRTMeta(description="\u6570\u636e\u5e93\u7cbe\u5ea6")
    public int getPrecision() {
        return this.nPrecision;
    }

    public IDEFDTColumn getDEFDTColumn(String strDBType) throws Exception {
        return null;
    }

    @Override
    public Object getDEFValue(String strValue) {
        try {
            return DataTypeHelper.parse((int)this.getStdDataType(), (String)strValue);
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }
}

