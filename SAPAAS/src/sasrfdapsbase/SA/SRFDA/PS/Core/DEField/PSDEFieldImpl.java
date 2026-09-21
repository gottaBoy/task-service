/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDEFDBValueFunc
 *  net.ibizsys.paas.core.IDEFDTColumn
 *  net.ibizsys.paas.core.IDEFSearchMode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.valuerule.IDEFValueRule
 *  net.ibizsys.paas.util.KeyValueHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DEField;

import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEFGridColumn;
import SA.SRFDA.PS.Core.DEField.IPSDEFInputTip;
import SA.SRFDA.PS.Core.DEField.IPSDEFSearchMode;
import SA.SRFDA.PS.Core.DEField.IPSDEFUIMode;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldRuntime;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldType;
import SA.SRFDA.PS.Core.DEField.IPSSysDEFType;
import SA.SRFDA.PS.Core.DEField.PSDEFInputTipGlobalModel;
import SA.SRFDA.PS.Core.DEField.PSDEFSearchModeGlobalModel;
import SA.SRFDA.PS.Core.DEField.PSDEFUIModeGlobalModel;
import SA.SRFDA.PS.Core.DEField.Search.IPSDEFSearch;
import SA.SRFDA.PS.Core.DEField.Search.PSDEFSearchGlobalModel;
import SA.SRFDA.PS.Core.DEField.ValueRule.IPSDEFValueRule;
import SA.SRFDA.PS.Core.DEField.ValueRule.PSDEFValueRuleGlobalModel;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1NDEFieldMap;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEFLogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.PSDataEntityObjectImpl;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSDEDBTable;
import SA.SRFDA.PS.Core.Database.IPSDEFDTColumn;
import SA.SRFDA.PS.Core.Database.IPSSysDBColumn;
import SA.SRFDA.PS.Core.IPSSysEngineConfig;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemSetting;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPIDEField;
import SA.SRFDA.PS.Core.Service.PSSubSysServiceAPIDEFieldImpl;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Data.PSDEFSearchMode;
import SA.SRFDA.PS.Data.PSDEFUIMode;
import SA.SRFDA.PS.Data.PSDEField;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.Utility.StringHelper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.core.IDEFDBValueFunc;
import net.ibizsys.paas.core.IDEFDTColumn;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.valuerule.IDEFValueRule;
import net.ibizsys.paas.util.KeyValueHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEFieldImpl
extends PSDataEntityObjectImpl
implements IPSDEField,
IPSDataEntityObject,
IPSDEFieldRuntime {
    private static final Log log = LogFactory.getLog(PSDEFieldImpl.class);
    public static final String MODELGROUP_LOGIC = "\u5904\u7406\u903b\u8f91";
    public static final String MODELGROUP_SEARCH = "\u641c\u7d22\u903b\u8f91";
    public static final String MODELGROUP_PERSISTENT = "\u6301\u4e45\u5316";
    public static final String MODELGROUP_DB = "\u6570\u636e\u5e93\u5b58\u50a8";
    public static final String MODELGROUP_VALUERULE = "\u503c\u89c4\u5219";
    public static final String MODELGROUP_DER = "\u5173\u7cfb";
    public static final String MODELGROUP_ACCCTRL = "\u8bbf\u95ee\u63a7\u5236";
    public static final String MODELGROUP_TEST = "\u6d4b\u8bd5";
    public static final String MODELGROUP_ADVMODEL = "\u6a21\u578b\u9ad8\u7ea7";
    public static final String[] MODELGROUPS = new String[]{"\u57fa\u672c", "\u5904\u7406\u903b\u8f91", "\u641c\u7d22\u903b\u8f91", "\u6301\u4e45\u5316", "\u6570\u636e\u5e93\u5b58\u50a8", "\u503c\u89c4\u5219", "\u5173\u7cfb", "\u8bbf\u95ee\u63a7\u5236", "\u6d4b\u8bd5", "\u6a21\u578b\u9ad8\u7ea7", "\u7528\u6237\u6269\u5c55", "\u5176\u5b83"};
    public static final int MODELORDER_LOGIC = 200;
    public static final int MODELORDER_SEARCH = 250;
    public static final int MODELORDER_PERSISTENT = 280;
    public static final int MODELORDER_DB = 310;
    public static final int MODELORDER_VALUERULE = 340;
    public static final int MODELORDER_DER = 390;
    public static final int MODELORDER_ACCCTRL = 420;
    public static final int MODELORDER_TEST = 450;
    public static final int MODELORDER_ADVMODEL = 500;
    protected PSDEField psDEField = null;
    protected IPSDEFieldType iPSDEFieldType = null;
    protected IPSSysDEFType iPSSysDEFType = null;
    private static final ArrayList<IPSDEFSearchMode> emptyPSDEFSearchModeList = new ArrayList();
    private static final ArrayList<IPSDEFInputTip> emptyPSDEFInputTipList = new ArrayList();
    private static final ArrayList<IPSDEFSearch> emptyPSDEFSearchList = new ArrayList();
    private static final ArrayList<IPSDEFLogic> emptyPSDEFLogicList = new ArrayList();
    protected static HashMap<String, Integer> systemFields = new HashMap();
    private static Map<String, String> ignoreAuditDEFPredefinedTypeMap = new HashMap<String, String>();
    protected Properties defProperties = null;
    protected boolean bUserVisible = true;
    private boolean bMajorField = false;
    private boolean bKeyNameField = false;
    private boolean bKeyField = false;
    private boolean bIndexTypeField = false;
    private boolean bFormTypeField = false;
    private boolean bUniTagField = false;
    private boolean bValidFlag = true;
    private boolean bInit = false;
    private boolean bAllowEmpty = true;
    private String strCodeListId = "";
    private String strValueFormat = "";
    private String strJSFormat = "";
    private String strJsonFormat = "";
    private String strPreDefinedType = "";
    private boolean bEnableQuickSearch = false;
    private IPSCodeList iPSCodeList = null;
    private String strDupCheckMode = "NONE";
    private String[] dupCheckValues = null;
    private String strUpdateDBValueMode = null;
    private String strInsertDBValueMode = null;
    private int nStringLength = -1;
    private int nMinStringLength = -1;
    private int nLength = -1;
    private int nPrecision = 0;
    private int nImportOrder = 1000;
    private String strImportTag = "";
    private boolean bEnablePrivilege = false;
    private int nOrderValue = 1000;
    private String strLNLanResTag = "";
    private IPSLanguageRes lnPSLanguageRes = null;
    private IPSSysUnit iPSSysUnit = null;
    private boolean bCheckRecursion = false;
    private int nExtendMode = 0;
    private boolean bDynaStorageDEField = false;
    private boolean bPhisicalDEField = true;
    private int nEnableActions = 0;
    protected PSDEFUIModeGlobalModel psDEFUIModeGlobalModel = new PSDEFUIModeGlobalModel();
    protected PSDEFValueRuleGlobalModel psDEFValueRuleGlobalModel = new PSDEFValueRuleGlobalModel();
    protected PSDEFSearchModeGlobalModel psDEFSearchModeGlobalModel = null;
    protected PSDEFInputTipGlobalModel psDEFInputTipGlobalModel = null;
    protected PSDEFSearchGlobalModel psDEFSearchGlobalModel = null;
    private String strCodeName = "";
    private boolean bQueryColumn = true;
    private int nStdDataType = 0;
    private IPSSysSampleValue iPSSysSampleValue = null;
    protected String strXmlTagName = null;
    private boolean bEnableTempData = false;
    private long nCreateTime = 0L;
    private int nViewColLevel = 0;
    private ArrayList<IPSDEFDTColumn> psDEFDTColumnList = null;
    private int nDEFType = 0;
    private String strNullValueOrderMode = null;
    private int nUserInputMode = 0;
    private String strServiceCodeName = null;
    private IPSDEDBTable iPSDEDBTable = null;
    private IPSSysDBColumn iPSSysDBColumn = null;
    private IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField = null;
    private String strMinValue = null;
    private String strMaxValue = null;
    private ArrayList<IPSDEFLogic> psDEFLogicList = null;
    private IPSSysValueRule iPSSysValueRule = null;
    private IPSSysSequence iPSSysSequence = null;
    private IPSSysTranslator iPSSysTranslator = null;
    private String strSequenceMode = "NONE";
    private String strTranslatorMode = "NONE";
    private boolean bEnableAudit = false;
    private IPSSysTranslator importPSSysTranslator = null;
    private IPSSysTranslator exportPSSysTranslator = null;
    private Integer nInitFlag = 0;
    private boolean bCalcSystemReserver = false;
    private boolean bSystemReserver = false;
    private boolean bCalcDataType = false;
    private String strDataType = "";
    private boolean bCalcUnit = false;
    private String strUnit = "";
    private boolean bCalcUnitWidth = false;
    private int nUnitWidth = 0;
    private boolean bCalcRestrictedPSDEField = false;
    private IPSDEField restrictedPSDEField = null;
    private boolean bCalcValuePSDEField = false;
    private IPSDEField valuePSDEField = null;

    static {
        systemFields.put("LOGICVALID", 0);
        systemFields.put("CREATEMAN", 0);
        systemFields.put("CREATEMANNAME", 0);
        systemFields.put("CREATEDATE", 0);
        systemFields.put("UPDATEMAN", 0);
        systemFields.put("UPDATEMANNAME", 0);
        systemFields.put("UPDATEDATE", 1);
        ignoreAuditDEFPredefinedTypeMap.put("LOGICVALID", "");
        ignoreAuditDEFPredefinedTypeMap.put("CREATEMAN", "");
        ignoreAuditDEFPredefinedTypeMap.put("CREATEMANNAME", "");
        ignoreAuditDEFPredefinedTypeMap.put("CREATEDATE", "");
        ignoreAuditDEFPredefinedTypeMap.put("UPDATEMAN", "");
        ignoreAuditDEFPredefinedTypeMap.put("UPDATEMANNAME", "");
        ignoreAuditDEFPredefinedTypeMap.put("UPDATEDATE", "");
    }

    @Override
    public void setInitParam(ISRFDAGlobalHelper iDAGlobalHelper, IPSDataEntity iPSDataEntity, IPSDEFieldType iPSDEFieldType, PSDEField psDEField) {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSDataEntity(iPSDataEntity);
        this.psDEField = psDEField;
        this.iPSDEFieldType = iPSDEFieldType;
        if (this.iPSDEFieldType instanceof IPSSysDEFType) {
            this.iPSSysDEFType = (IPSSysDEFType)this.iPSDEFieldType;
        }
        this.setId(this.psDEField.getPSDEFIELDID());
        this.setName(this.psDEField.getPSDEFIELDNAME().toUpperCase());
        this.setPSObjectData(this.psDEField);
        if (!this.psDEField.isDEFTYPENull()) {
            this.nDEFType = this.psDEField.getDEFTYPE();
        }
        boolean bl = this.bDynaStorageDEField = this.nDEFType == 4;
        if (this.nDEFType == 5) {
            this.bPhisicalDEField = false;
        }
        this.bEnableTempData = iPSDataEntity.isEnableTempData();
        if (this.bEnableTempData && !this.psDEField.isENABLETEMPDATANull()) {
            this.bEnableTempData = this.psDEField.getENABLETEMPDATA();
        }
        if (!this.psDEField.isMAJORFIELDNull()) {
            if (this.psDEField.getMAJORFIELD() == 1) {
                this.bMajorField = true;
            }
            if (this.psDEField.getMAJORFIELD() == 2) {
                this.bKeyNameField = true;
            }
        }
        if (!this.psDEField.isPKEYNull()) {
            if (this.psDEField.getPKEY() == 1) {
                this.bKeyField = true;
            }
            if (this.psDEField.getPKEY() == 2) {
                this.bUniTagField = true;
            }
        }
        if (!this.psDEField.isREADONLYMODENull()) {
            int nAction = this.psDEField.getREADONLYMODE();
            if ((nAction & 1) == 0) {
                this.nEnableActions |= 1;
            }
            if ((nAction & 2) == 0) {
                this.nEnableActions |= 2;
            }
        } else {
            this.nEnableActions = 3;
        }
        this.nUserInputMode = this.psDEField.getENABLEUSERINPUT();
        if (this.psDEField.getINDEXTYPE()) {
            this.bIndexTypeField = true;
        }
        if (this.psDEField.getMULTIFORMFIELD()) {
            this.bFormTypeField = true;
        }
        this.strCodeName = this.psDEField.getCODENAME();
        if (StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
            this.strCodeName = this.psDEField.getPSDEFIELDNAME().toLowerCase();
        }
        if (!(StringHelper.IsNullOrEmpty((String)this.strCodeName) || iPSDataEntity != null && iPSDataEntity.getPSSystem().getPSSystemSetting().isFixCodeNameAutoCapitalize())) {
            String strHeader = this.strCodeName.substring(0, 1).toUpperCase();
            this.strCodeName = String.valueOf(strHeader) + this.strCodeName.substring(1);
        }
        this.strXmlTagName = this.strCodeName.toUpperCase();
        this.nStdDataType = this.iPSDEFieldType.getStdDataType();
        this.psDEFUIModeGlobalModel.Init(this.getDAGlobalHelper(), this);
        this.psDEFValueRuleGlobalModel.Init(this.getDAGlobalHelper(), this);
        if (this.psDEField.getPSDEFSearchModes(false) != null) {
            this.psDEFSearchModeGlobalModel = new PSDEFSearchModeGlobalModel();
            this.psDEFSearchModeGlobalModel.Init(this.getDAGlobalHelper(), this);
        }
        if (this.psDEField.getPSDEFInputTips(false) != null) {
            this.psDEFInputTipGlobalModel = new PSDEFInputTipGlobalModel();
            this.psDEFInputTipGlobalModel.Init(this.getDAGlobalHelper(), this);
        }
        if (this.psDEField.getPSSysSearchDEFields(false) != null) {
            this.psDEFSearchGlobalModel = new PSDEFSearchGlobalModel();
            this.psDEFSearchGlobalModel.Init(this.getDAGlobalHelper(), this);
        }
        this.strValueFormat = this.psDEField.getVALUEFORMAT();
        if (StringHelper.IsNullOrEmpty((String)this.strValueFormat) && !this.isLinkDEField()) {
            this.strValueFormat = this.iPSDEFieldType.getValueFormat(this.getPSDataEntity().getPSSystem().getSFType());
        }
        this.strJSFormat = this.psDEField.getJSFORMAT();
        if (StringHelper.IsNullOrEmpty((String)this.strJSFormat) && !this.isLinkDEField()) {
            this.strJSFormat = this.iPSDEFieldType.getValueFormat("JS");
        }
        this.strJsonFormat = this.psDEField.getJSONFORMAT();
        if (StringHelper.IsNullOrEmpty((String)this.strJsonFormat)) {
            if (!this.isLinkDEField()) {
                this.strJsonFormat = this.iPSDEFieldType.getValueFormat("JS");
            }
            if (!StringHelper.IsNullOrEmpty((String)this.strJsonFormat)) {
                this.strJsonFormat = this.strJsonFormat.replace("YYYY-MM-DD", "yyyy-MM-dd");
            }
        }
        this.bEnableQuickSearch = !this.psDEField.isENABLEQSNull() ? this.psDEField.getENABLEQS() : this.isMajorDEField();
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getDUPCHECKMODE())) {
            this.strDupCheckMode = this.psDEField.getDUPCHECKMODE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getDUPCHECKVALUES())) {
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
        this.strNullValueOrderMode = this.psDEField.getNULLVALORDER();
        this.strServiceCodeName = this.psDEField.getSERVICECODENAME();
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getSEQUENCEMODE())) {
            this.strSequenceMode = this.psDEField.getSEQUENCEMODE();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getPSCODELISTID())) {
            this.strCodeListId = this.psDEField.getPSCODELISTID();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getTRANSLATORMODE())) {
            this.strTranslatorMode = this.psDEField.getTRANSLATORMODE();
            if ((StringHelper.Compare((String)this.strTranslatorMode, (String)"TRANSLATE", (boolean)false) == 0 || StringHelper.Compare((String)this.strTranslatorMode, (String)"TRANSLATE2", (boolean)false) == 0) && StringHelper.IsNullOrEmpty((String)this.getPSSysTranslatorId())) {
                this.strTranslatorMode = "NONE";
            }
        }
        this.bInit = false;
    }

    @Override
    public synchronized void init() throws Exception {
        if (this.bInit) {
            return;
        }
        try {
            if (this.iPSDataEntity == null || this.psDEField == null || this.iPSDEFieldType == null || this.getDAGlobalHelper() == null) {
                throw new Exception("\u521d\u59cb\u5316\u53c2\u6570\u65e0\u6548");
            }
            if (StringHelper.IsNullOrEmpty((String)this.getName())) {
                throw new Exception("\u5c5e\u6027\u540d\u79f0\u4e0d\u80fd\u4e3a\u7a7a");
            }
            this.bInit = true;
            this.nViewColLevel = !this.psDEField.isVIEWCOLLEVELNull() ? this.psDEField.getVIEWCOLLEVEL() : this.onCalcViewLevel();
            if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getPSSYSSAMPLEVALUEID())) {
                this.iPSSysSampleValue = this.getPSDataEntity().getPSSystem().getPSSysSampleValue(this.psDEField.getPSSYSSAMPLEVALUEID());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getPSSYSUNITID())) {
                this.iPSSysUnit = this.getPSDataEntity().getPSSystem().getPSSysUnit(this.psDEField.getPSSYSUNITID());
            } else if (this.iPSSysDEFType != null && !StringHelper.IsNullOrEmpty((String)this.iPSSysDEFType.getPSSysUnitId())) {
                this.iPSSysUnit = this.getPSDataEntity().getPSSystem().getPSSysUnit(this.iPSSysDEFType.getPSSysUnitId());
            }
            if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getLNPSLANRESID())) {
                this.lnPSLanguageRes = this.getPSDataEntity().getPSSystem().getPSLanguageRes(this.psDEField.getLNPSLANRESID());
            }
            this.onInit();
        }
        catch (Exception ex) {
            String strLogName = StringHelper.Format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.Format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.Format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public boolean isInit() {
        return this.bInit;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void init2() throws Exception {
        Integer n = this.nInitFlag;
        synchronized (n) {
            if (this.nInitFlag == 1) {
                return;
            }
            this.strCodeListId = this.onGetCodeListId();
            this.strMinValue = this.onGetMinValueString();
            this.strMaxValue = this.onGetMaxValueString();
            this.nStdDataType = this.onGetStdDataType();
            this.bCheckRecursion = this.onCalcCheckRecursion();
            this.bAllowEmpty = this.onGetAllowEmpty();
            if (this.getPSDataEntity().getAuditMode() != 0) {
                this.bEnableAudit = !this.psDEField.isENABLEAUDITNull() ? this.psDEField.getENABLEAUDIT() : this.onGetEnableAudit();
            }
            if (!this.psDEField.isLENGTHNull()) {
                this.nLength = this.psDEField.getLENGTH();
            }
            if (DataTypeHelper.IsStringType((int)this.nStdDataType)) {
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
                    this.nStringLength = DataTypeHelper.IsLongStringType((int)this.nStdDataType) ? 0x100000 : 200;
                }
                if (this.nLength <= 0) {
                    this.nLength = this.nStringLength;
                }
                this.nMinStringLength = !this.psDEField.isMINSTRLENGTHNull() ? this.psDEField.getMINSTRLENGTH() : this.onGetMinStringLength();
                if (this.nMinStringLength < 0) {
                    this.nMinStringLength = 0;
                }
            } else {
                this.nPrecision = !this.psDEField.isPRECISION2Null() && this.psDEField.getPRECISION2() > 0 ? this.psDEField.getPRECISION2() : this.onGetPrecision();
                if (this.nLength < 0) {
                    this.nLength = this.onGetLength();
                }
            }
            this.bQueryColumn = !this.psDEField.isQUERYCOLUMNNull() ? this.psDEField.getQUERYCOLUMN() : this.onCalcQueryColumn();
            this.nInitFlag = 1;
            return;
        }
    }

    protected boolean onCalcQueryColumn() {
        if (DataTypeHelper.IsLongStringType((int)this.nStdDataType)) {
            return false;
        }
        return this.nStdDataType != 24;
    }

    protected boolean initEx() {
        try {
            this.init2();
            return true;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return false;
        }
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

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", outputdoc="false")
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    @Override
    public PSDEField getPSDEFieldData() {
        return this.psDEField;
    }

    @Override
    public int check() throws Exception {
        return super.check();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getDupCheckPSDEField();
        this.getNo2DupCheckPSDEField();
        this.getNo3DupCheckPSDEField();
        this.getPSCodeList();
        if (!StringHelper.IsNullOrEmpty((String)this.getSequenceMode()) && !"NONE".equals(this.getSequenceMode()) && this.getPSSysSequence() == null) {
            throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u503c\u5e8f\u5217\u5bf9\u8c61");
        }
        if (!StringHelper.IsNullOrEmpty((String)this.getTranslatorMode()) && !"NONE".equals(this.getTranslatorMode()) && ("TRANSLATE".equals(this.getTranslatorMode()) || "TRANSLATE2".equals(this.getTranslatorMode())) && this.getPSSysTranslator() == null) {
            throw new Exception("\u672a\u6307\u5b9a\u7cfb\u7edf\u503c\u8f6c\u6362\u5668\u5bf9\u8c61");
        }
        return super.onCheck();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0", fields={"LOGICNAME"})
    public String getLogicName() {
        return this.getLogicName("");
    }

    @Override
    public String getLogicName(String strLanguage) {
        if (StringHelper.IsNullOrEmpty((String)this.psDEField.getLOGICNAME())) {
            return this.getName();
        }
        return this.psDEField.getLOGICNAME();
    }

    public static boolean isLinkDataType(String strDataType) {
        if (StringHelper.Compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
            return true;
        }
        return StringHelper.Compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0;
    }

    @Override
    public boolean isLinkDEField() {
        return false;
    }

    @Override
    public boolean isFormulaDEField() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u7269\u7406\u5c5e\u6027", ignoredumpvalues="true")
    public boolean isPhisicalDEField() {
        return this.bPhisicalDEField;
    }

    protected void setPhisicalDEField(boolean bPhisicalDEField) {
        this.bPhisicalDEField = bPhisicalDEField;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u5c5e\u6027", ignoredumpvalues="false", group="\u57fa\u672c", order=141, fields={"MAJORFIELD"})
    public boolean isMajorDEField() {
        return this.bMajorField;
    }

    @Override
    @PSModelRTMeta(description="\u952e\u540d\u5c5e\u6027", ignoredumpvalues="false", group="\u57fa\u672c", order=141, fields={"MAJORFIELD"})
    public boolean isKeyNameDEField() {
        return this.bKeyNameField;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u952e\u5c5e\u6027", ignoredumpvalues="false", group="\u57fa\u672c", order=140, fields={"PKEY"})
    public boolean isKeyDEField() {
        return this.bKeyField;
    }

    @Override
    @PSModelRTMeta(description="\u552f\u4e00\u4e1a\u52a1\u6807\u8bc6\u5c5e\u6027", ignoredumpvalues="false", group="\u57fa\u672c", order=142, fields={"PKEY"})
    public boolean isUniTagField() {
        return this.bUniTagField;
    }

    @Override
    @PSModelRTMeta(description="\u7d22\u5f15\u7c7b\u578b\u5c5e\u6027", ignoredumpvalues="false", group="\u57fa\u672c", order=143, fields={"INDEXTYPE"})
    public boolean isIndexTypeDEField() {
        return this.bIndexTypeField;
    }

    @Override
    public boolean isInheritDEField() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b\u5c5e\u6027", ignoredumpvalues="false", group="\u57fa\u672c", order=144)
    public boolean isDataTypeDEField() {
        return this.getPSDataEntity().getDataTypePSDEField() != null && this.getPSDataEntity().getDataTypePSDEField().getId().equals(this.getId());
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u5c5e\u6027", ignoredumpvalues="false")
    public boolean isSystemReserver() {
        if (!this.bCalcSystemReserver) {
            this.bSystemReserver = this.onCalcSystemReserver();
            this.bCalcSystemReserver = true;
        }
        return this.bSystemReserver;
    }

    protected boolean onCalcSystemReserver() {
        return systemFields.containsKey(this.getPredefinedType());
    }

    @Override
    public boolean isUserVisible() {
        return this.bUserVisible;
    }

    public final String getCodeListId() {
        this.initEx();
        return this.strCodeListId;
    }

    protected String onGetCodeListId() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getPSCODELISTID())) {
            return this.psDEField.getPSCODELISTID();
        }
        if (this.iPSSysDEFType != null && !StringHelper.IsNullOrEmpty((String)this.iPSSysDEFType.getPSCodeListId())) {
            return this.iPSSysDEFType.getPSCodeListId();
        }
        String strCodeListTemplId = this.iPSDEFieldType.getPSCodeListTemplId();
        if (StringHelper.IsNullOrEmpty((String)strCodeListTemplId)) {
            return "";
        }
        return this.getPSDataEntity().getPSSystem().getPSCodeListByTempl(strCodeListTemplId).getId();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u51c6\u6570\u636e\u7c7b\u578b", codelist="StdDataType", group="\u57fa\u672c", order=131, fields={"STDDATATYPE"})
    public final int getStdDataType() {
        this.initEx();
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

    protected int onGetMinStringLength() throws Exception {
        return this.iPSDEFieldType.getMinStringLength();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7c7b\u578b", codelist="DEFDataType", group="\u57fa\u672c", order=130, fields={"PSDATATYPEID"})
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

    @Override
    public String getUnit() {
        if (!this.bCalcUnit) {
            this.strUnit = this.onGetUnit();
            this.bCalcUnit = true;
        }
        return this.strUnit;
    }

    protected String onGetUnit() {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getUNIT())) {
            return this.psDEField.getUNIT();
        }
        if (this.getPSSysUnit() != null) {
            return this.getPSSysUnit().getName();
        }
        return this.iPSDEFieldType.getUnit();
    }

    @Override
    public int getUnitWidth() {
        if (!this.bCalcUnitWidth) {
            this.nUnitWidth = this.onGetUnitWidth();
            this.bCalcUnitWidth = true;
        }
        return this.nUnitWidth;
    }

    protected int onGetUnitWidth() {
        if (this.psDEField.getUNITWIDTH() != 0) {
            return this.psDEField.getUNITWIDTH();
        }
        return this.iPSDEFieldType.getUnitWidth();
    }

    @Override
    @PSModelRTMeta(description="\u62f7\u8d1d\u91cd\u7f6e", ignoredumpvalues="false", fields={"PASTERESET"})
    public boolean isPasteReset() {
        if (this.isKeyDEField() || this.isUniTagField()) {
            return true;
        }
        return this.psDEField.getPASTERESET();
    }

    @Override
    public Object getDEFValue(String strValue) {
        return DataTypeParse.Parse((int)this.getStdDataType(), (String)strValue);
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5ba1\u8ba1", ignoredumpvalues="false", fields={"ENABLEAUDIT"})
    public boolean isEnableAudit() {
        this.initEx();
        if (this.bEnableAudit) {
            if (!StringHelper.IsNullOrEmpty((String)this.getPredefinedType()) && ignoreAuditDEFPredefinedTypeMap.containsKey(this.getPredefinedType())) {
                return false;
            }
            if (this.isKeyDEField() || this.isUniTagField()) {
                return false;
            }
        }
        return this.bEnableAudit;
    }

    protected boolean onGetEnableAudit() throws Exception {
        return !this.isKeyDEField() && !this.isUniTagField() && this.isPhisicalDEField() && this.getPSSystemSetting().isEnableDEFieldAudit();
    }

    @Override
    @PSModelRTMeta(description="\u5ba1\u8ba1\u683c\u5f0f", fields={"AUDITINFOFORMAT"})
    public String getAuditInfoFormat() {
        if (!this.isEnableAudit()) {
            return "";
        }
        String strAuditInfoFormat = this.psDEField.getAUDITINFOFORMAT();
        return strAuditInfoFormat;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7cbe\u5ea6", ignoredumpvalues="0", group="\u57fa\u672c", order=135, fields={"PRECISION"})
    public final int getPrecision() {
        this.initEx();
        return this.nPrecision;
    }

    @Override
    public String getUpdateOVMode() {
        return this.psDEField.getUPDATEOVMODE();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    public boolean isEnableUserInsert() {
        return (this.getUserInputMode() & 1) > 0;
    }

    @Override
    public boolean isEnableUserUpdate() {
        return (this.getUserInputMode() & 2) > 0;
    }

    @Override
    public boolean testUserInput(int nUserInput) {
        return (this.getUserInputMode() & nUserInput) == nUserInput;
    }

    @Override
    public int getUserInputMode() {
        return this.nUserInputMode;
    }

    @Override
    public boolean isFormulaPhisical() {
        return false;
    }

    @Override
    public IPSDEFDTColumn getPSDTColumn(String strDBType) throws Exception {
        return this.getPSDataEntity().getPSDEDBConfig(strDBType).getPSDEFDTColumn(this.getName());
    }

    @Override
    public boolean isIgnoreInherit() {
        return false;
    }

    @Override
    public String getDupCheckCode(boolean bInsert) {
        return null;
    }

    @Override
    public boolean isEnablePriv() {
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u7b26\u4e32\u8f6c\u5316", codelist="StringCaseMode", fields={"STRINGCASE"})
    public String getStringCase() {
        return this.psDEField.getSTRINGCASE();
    }

    @Override
    public String getCodeListParam() {
        return null;
    }

    @Override
    public String getFullName() {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)this.getPSDataEntity().getFullName(), (Object)this.getName());
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

    @Override
    public IPSDEFUIMode getPSDEFUIMode(String strPSDEFUIModeId) throws Exception {
        return (IPSDEFUIMode)this.psDEFUIModeGlobalModel.FindModelHelper(strPSDEFUIModeId);
    }

    @Override
    public IPSDEFUIMode getPSDEFUIMode(String strPSDEFUIModeId, boolean bTryMode) throws Exception {
        return (IPSDEFUIMode)this.psDEFUIModeGlobalModel.FindModelHelper(strPSDEFUIModeId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u754c\u9762\u6a21\u5f0f\u96c6\u5408", child=true, ignorert=3, dynamodelmode=4, outputdoc="false")
    public Iterator<IPSDEFUIMode> getAllPSDEFUIModes() throws Exception {
        return this.psDEFUIModeGlobalModel.getAllModelHelpers();
    }

    @Override
    public IPSDEFSearchMode createPSDEFSearchMode(PSDEFSearchMode psDEFSearchMode) throws Exception {
        return this.getPSDEFieldType().createPSDEFSearchMode(psDEFSearchMode);
    }

    @Override
    public IPSDEFSearchMode getPSDEFSearchMode(String strPSDEFSearchModeId) throws Exception {
        if (this.psDEFSearchModeGlobalModel == null) {
            this.psDEFSearchModeGlobalModel = new PSDEFSearchModeGlobalModel();
            this.psDEFSearchModeGlobalModel.Init(this.getDAGlobalHelper(), this);
        }
        return (IPSDEFSearchMode)this.psDEFSearchModeGlobalModel.FindModelHelper(strPSDEFSearchModeId);
    }

    @Override
    public IPSDEFSearchMode getPSDEFSearchMode(String strPSDEFSearchModeId, boolean bTryMode) throws Exception {
        if (this.psDEFSearchModeGlobalModel == null) {
            if (bTryMode) {
                return null;
            }
            this.psDEFSearchModeGlobalModel = new PSDEFSearchModeGlobalModel();
            this.psDEFSearchModeGlobalModel.Init(this.getDAGlobalHelper(), this);
        }
        return this.psDEFSearchModeGlobalModel.FindModelHelper(strPSDEFSearchModeId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u5141\u8bb8\u7a7a\u503c\u8f93\u5165", ignoredumpvalues="true", group="\u57fa\u672c", order=180, fields={"ALLOWEMPTY"})
    public boolean isAllowEmpty() {
        this.initEx();
        return this.bAllowEmpty;
    }

    protected boolean onGetAllowEmpty() {
        return this.psDEField.getALLOWEMPTY();
    }

    @Override
    public int getEncryptStorage() {
        return 0;
    }

    @Override
    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22", ignoredumpvalues="false", fields={"ENABLEQS"})
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    public Iterator<IDEFSearchMode> getDEFSearchModes() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5b57\u6bb5\u6743\u9650", ignoredumpvalues="false", fields={"ENABLECOLPRIV"})
    public boolean isEnablePrivilege() {
        return this.bEnablePrivilege;
    }

    @Override
    public IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId) throws Exception {
        return (IPSDEFValueRule)this.psDEFValueRuleGlobalModel.FindModelHelper(strPSDEFValueRuleId);
    }

    @Override
    public IPSDEFValueRule getPSDEFValueRule(String strPSDEFValueRuleId, boolean bTryMode) throws Exception {
        return (IPSDEFValueRule)this.psDEFValueRuleGlobalModel.FindModelHelper(strPSDEFValueRuleId, bTryMode);
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u503c\u89c4\u5219\u96c6\u5408", child=true, group="\u503c\u89c4\u5219", order=380)
    public Iterator<IPSDEFValueRule> getAllPSDEFValueRules() throws Exception {
        return this.psDEFValueRuleGlobalModel.getAllModelHelpers();
    }

    public IDEFValueRule getDEFValueRule(String strDVRId) throws Exception {
        return this.getPSDEFValueRule(strDVRId);
    }

    @Override
    @PSModelRTMeta(description="\u503c\u683c\u5f0f\u5316", fields={"VALUEFORMAT"})
    public String getValueFormat() {
        return this.strValueFormat;
    }

    protected void setValueFormat(String strValueFormat) {
        this.strValueFormat = strValueFormat;
    }

    @Override
    @PSModelRTMeta(description="JS\u683c\u5f0f\u5316", fields={"JSFORMAT"}, dump=false)
    public String getJSFormat() {
        return this.strJSFormat;
    }

    protected void setJSFormat(String strJSFormat) {
        this.strJSFormat = strJSFormat;
    }

    @Override
    @PSModelRTMeta(description="Json\u683c\u5f0f\u5316", fields={"JSONFORMAT"})
    public String getJsonFormat() {
        return this.strJsonFormat;
    }

    protected void setJsonFormat(String strJsonFormat) {
        this.strJsonFormat = strJsonFormat;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f\u96c6\u5408", child=true, dynamodelmode=4, group="\u641c\u7d22\u903b\u8f91", order=290)
    public Iterator<IPSDEFSearchMode> getAllPSDEFSearchModes() throws Exception {
        if (this.psDEFSearchModeGlobalModel != null) {
            return this.psDEFSearchModeGlobalModel.getAllModelHelpers();
        }
        return emptyPSDEFSearchModeList.iterator();
    }

    public String getPreDefinedType() {
        return this.strPreDefinedType;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u4e1a\u52a1\u7c7b\u578b", codelist="PredefinedFieldType", group="\u57fa\u672c", order=150, fields={"PREDEFINEDTYPE"})
    public String getPredefinedType() {
        return this.strPreDefinedType;
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u7c7b\u578b\u53c2\u6570", fields={"PREDEFINEDTYPEPARAM"})
    public String getPredefinedTypeParam() {
        return this.psDEField.getPREDEFINEDTYPEPARAM();
    }

    @Override
    public void setPreDefinedType(String strPreDefinedType) {
        this.strPreDefinedType = strPreDefinedType;
    }

    @Override
    public int getEnableUserInput() {
        return this.psDEField.getENABLEUSERINPUT();
    }

    @Override
    @PSModelRTMeta(description="\u8054\u5408\u952e\u503c\u5c5e\u6027", ignorert=3, codelist="UnionKeyValueMode", fields={"UNIONKEYVALUE"})
    public String getUnionKeyValue() {
        return this.psDEField.getUNIONKEYVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u591a\u8868\u5355\u8bc6\u522b\u5c5e\u6027", ignoredumpvalues="false", fields={"MULTIFORMFIELD"})
    public boolean isMultiFormDEField() {
        return this.psDEField.getMULTIFORMFIELD();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u4ee3\u7801\u8868", dumpref=true, group="\u57fa\u672c", order=143, fields={"PSCODELISTID"})
    public IPSCodeList getPSCodeList() throws Exception {
        if (this.iPSCodeList != null || StringHelper.IsNullOrEmpty((String)this.getCodeListId())) {
            return this.iPSCodeList;
        }
        this.iPSCodeList = this.getPSDataEntity().getPSSystem().getPSCodeList(this.strCodeListId);
        return this.iPSCodeList;
    }

    @Override
    public boolean isFormTypeDEField() {
        return this.bFormTypeField;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u590d\u503c\u68c0\u67e5", codelist="DEFDupCheckMode", ignoredumpvalues="NONE", dynamodelmode=4, group="\u503c\u89c4\u5219", order=356, fields={"DUPCHECKMODE"})
    public String getDupCheckMode() {
        return this.strDupCheckMode;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u590d\u503c\u68c0\u67e5\u96c6\u5408", hideempty=true, child=true, dynamodelmode=4, fields={"DUPCHECKVALUES"})
    public String[] getDupCheckValues() {
        return this.dupCheckValues;
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u590d\u503c\u68c0\u67e5\u8303\u56f4\u5c5e\u6027\u96c6\u5408", child=true, hideempty=true, dumpref=true, rtdump=3, rtname="getDupCheckDEFields", from="IPSDataEntity", dynamodelmode=4, outputdoc="false", fields={"DUPCHKPSDEFID", "NO2DUPCHKPSDEFID", "NO3DUPCHKPSDEFID"})
    public Iterator<IPSDEField> getDupCheckPSDEFields() throws Exception {
        IPSDEField field1 = this.getDupCheckPSDEField();
        IPSDEField field2 = this.getNo2DupCheckPSDEField();
        IPSDEField field3 = this.getNo3DupCheckPSDEField();
        if (field1 == null && field2 == null && field3 == null) {
            return null;
        }
        ArrayList<IPSDEField> list = new ArrayList<IPSDEField>();
        if (field1 != null) {
            list.add(field1);
        }
        if (field2 != null) {
            list.add(field2);
        }
        if (field3 != null) {
            list.add(field3);
        }
        return list.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u590d\u503c\u68c0\u67e5\u8303\u56f4\u5c5e\u6027", hideempty=true, group="\u503c\u89c4\u5219", order=358, fields={"DUPCHKPSDEFID"})
    public IPSDEField getDupCheckPSDEField() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psDEField.getDUPCHKPSDEFID())) {
            return null;
        }
        if (StringHelper.Compare((String)this.getDupCheckMode(), (String)"NONE", (boolean)true) == 0) {
            return null;
        }
        return this.getPSDataEntity().getPSDEField(this.psDEField.getDUPCHKPSDEFID());
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u590d\u503c\u68c0\u67e5\u8303\u56f4\u5c5e\u60272", group="\u503c\u89c4\u5219", order=359, fields={"NO2DUPCHKPSDEFID"})
    public IPSDEField getNo2DupCheckPSDEField() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psDEField.getNO2DUPCHKPSDEFID())) {
            return null;
        }
        if (StringHelper.Compare((String)this.getDupCheckMode(), (String)"NONE", (boolean)true) == 0) {
            return null;
        }
        return this.getPSDataEntity().getPSDEField(this.psDEField.getNO2DUPCHKPSDEFID());
    }

    @Override
    @PSModelRTMeta(description="\u91cd\u590d\u503c\u68c0\u67e5\u8303\u56f4\u5c5e\u60273", group="\u503c\u89c4\u5219", order=360, fields={"NO3DUPCHKPSDEFID"})
    public IPSDEField getNo3DupCheckPSDEField() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.psDEField.getNO3DUPCHKPSDEFID())) {
            return null;
        }
        if (StringHelper.Compare((String)this.getDupCheckMode(), (String)"NONE", (boolean)true) == 0) {
            return null;
        }
        return this.getPSDataEntity().getPSDEField(this.psDEField.getNO3DUPCHKPSDEFID());
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1", group="\u503c\u89c4\u5219", order=346, outputdoc="item.getStdDataType()==25", fields={"STRLENGTH"})
    public final int getStringLength() {
        this.initEx();
        return this.nStringLength;
    }

    @Override
    @PSModelRTMeta(description="\u5b57\u6bb5\u957f\u5ea6", ignoredumpvalues="0;-1", group="\u57fa\u672c", order=133, fields={"LENGTH"})
    public final int getLength() {
        this.initEx();
        return this.nLength;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u7c7b\u578b", codelist="DEFDefaultValueType", group="\u5904\u7406\u903b\u8f91", order=201, fields={"DVT"})
    public String getDefaultValueType() {
        return this.psDEField.getDVT();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c", group="\u5904\u7406\u903b\u8f91", order=202, fields={"DEFAULTVALUE"})
    public String getDefaultValue() {
        return this.psDEField.getDEFAULTVALUE();
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u5217", ignoredumpvalues="true", group="\u641c\u7d22\u903b\u8f91", order=253, fields={"QUERYCOLUMN"})
    public final boolean isQueryColumn() {
        this.initEx();
        return this.bQueryColumn;
    }

    public String getDBValueFunc() {
        return this.strUpdateDBValueMode;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSDataEntity().getPSSysModelInstId();
    }

    @Override
    public String getPSSysValueRuleId() {
        String strPSSysValueRuleId = this.psDEField.getPSSYSVALUERULEID();
        if (!StringHelper.IsNullOrEmpty((String)strPSSysValueRuleId)) {
            return strPSSysValueRuleId;
        }
        if (this.iPSSysDEFType != null) {
            this.iPSSysDEFType.getPSSysValueRuleId();
        }
        return strPSSysValueRuleId;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u89c4\u5219", group="\u503c\u89c4\u5219", order=355, fields={"PSSYSVALUERULEID"})
    public IPSSysValueRule getPSSysValueRule() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getPSSysValueRuleId())) {
            return null;
        }
        if (this.iPSSysValueRule == null) {
            this.iPSSysValueRule = this.getPSSystem().getPSSysValueRule(this.getPSSysValueRuleId());
        }
        return this.iPSSysValueRule;
    }

    @Override
    @PSModelRTMeta(description="\u9650\u5b9a\u5c5e\u6027", hideempty=true, fields={"RESTRICTEDPSDEFID"})
    public IPSDEField getRestrictedPSDEField() throws Exception {
        if (!this.bCalcRestrictedPSDEField) {
            this.restrictedPSDEField = this.onGetRestrictedPSDEField();
            this.bCalcRestrictedPSDEField = true;
        }
        return this.restrictedPSDEField;
    }

    protected IPSDEField onGetRestrictedPSDEField() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getRESTRICTEDPSDEFID())) {
            if (StringHelper.Compare((String)this.getId(), (String)this.psDEField.getRESTRICTEDPSDEFID(), (boolean)false) == 0) {
                throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u7684\u9650\u5b9a\u5c5e\u6027\u4e0d\u80fd\u6307\u5411\u81ea\u8eab", (Object)this.getFullName()));
            }
            return this.getPSDataEntity().getPSDEField(this.psDEField.getRESTRICTEDPSDEFID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u5c5e\u6027", hideempty=true, dumpref=true, from="IPSDataEntity", fields={"VALUEPSDEFID"})
    public IPSDEField getValuePSDEField() throws Exception {
        if (!this.bCalcValuePSDEField) {
            this.valuePSDEField = this.onGetValuePSDEField();
            this.bCalcValuePSDEField = true;
        }
        return this.valuePSDEField;
    }

    protected IPSDEField onGetValuePSDEField() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getVALUEPSDEFID())) {
            if (StringHelper.Compare((String)this.getId(), (String)this.psDEField.getVALUEPSDEFID(), (boolean)false) == 0) {
                throw new Exception(StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u7684\u503c\u9879\u5c5e\u6027\u4e0d\u80fd\u6307\u5411\u81ea\u8eab", (Object)this.getFullName()));
            }
            return this.getPSDataEntity().getPSDEField(this.psDEField.getVALUEPSDEFID());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u4e3b\u72b6\u6001\u5c5e\u6027\u6a21\u5f0f", codelist="DEMSFieldMode", ignorert=3, fields={"STATEFIELD"})
    public String getDEMSFieldMode() {
        return this.psDEField.getSTATEFIELD();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u5165\u6b21\u5e8f", ignorert=3, fields={"IMPORTORDER"})
    public int getImportOrder() {
        return this.nImportOrder;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u5165\u6807\u8bc6", ignorert=3, fields={"IMPORTTAG"})
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

    @Override
    public String getMemo() {
        return this.psDEField.getMEMO();
    }

    public String getDERName() {
        return null;
    }

    public String getLinkDEFName() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868\u540d\u79f0", dump=false)
    public String getTableName() {
        if (this.isPhisicalDEField() && !this.isDynaStorageDEField()) {
            return this.getPSDataEntity().getTableName();
        }
        return "";
    }

    public boolean isEnableWriteBack() throws Exception {
        return false;
    }

    @Override
    public String getTestDataValue() {
        String strTestDataValue = this.getTestDataValueDefault();
        if (StringHelper.IsNullOrEmpty((String)strTestDataValue)) {
            return this.getPSDEFieldType().getTestDataValue();
        }
        return strTestDataValue;
    }

    protected String getTestDataValueDefault() {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getTESTDATA())) {
            return this.psDEField.getTESTDATA();
        }
        if (this.getPSSampleValue() != null) {
            return this.getPSSampleValue().getSampleValue(false);
        }
        return "";
    }

    @Override
    public IPSSysSampleValue getPSSampleValue() {
        return this.iPSSysSampleValue;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u793a\u4f8b\u6570\u636e", fields={"PSSYSSAMPLEVALUEID"})
    public IPSSysSampleValue getPSSysSampleValue() {
        return this.iPSSysSampleValue;
    }

    @Override
    public String getXmlTagName() {
        return this.strXmlTagName;
    }

    @Override
    public boolean isEnableTempData() {
        return this.bEnableTempData;
    }

    @Override
    public IPSDEFInputTip getPSDEFInputTip(String strPSDEFInputTipId, boolean bTryMode) throws Exception {
        IPSDEFInputTip iPSDEFInputTip;
        if (this.psDEFInputTipGlobalModel != null && (iPSDEFInputTip = (IPSDEFInputTip)this.psDEFInputTipGlobalModel.FindModelHelper(strPSDEFInputTipId, true)) != null) {
            return iPSDEFInputTip;
        }
        return this.getPSDataEntity().getPSSystem().getPSSysDEFInputTip(strPSDEFInputTipId, bTryMode);
    }

    @Override
    public IPSDEFInputTip getPSDEFInputTip(String strPSDEFInputTipId) throws Exception {
        IPSDEFInputTip iPSDEFInputTip;
        if (this.psDEFInputTipGlobalModel != null && (iPSDEFInputTip = (IPSDEFInputTip)this.psDEFInputTipGlobalModel.FindModelHelper(strPSDEFInputTipId, true)) != null) {
            return iPSDEFInputTip;
        }
        return this.getPSDataEntity().getPSSystem().getPSSysDEFInputTip(strPSDEFInputTipId);
    }

    @Override
    public Iterator<IPSDEFInputTip> getAllPSDEFInputTips() throws Exception {
        if (this.psDEFInputTipGlobalModel != null) {
            return this.psDEFInputTipGlobalModel.getAllModelHelpers();
        }
        return emptyPSDEFInputTipList.iterator();
    }

    @Override
    public IPSDEFInputTip getDefaultPSDEFInputTip() {
        if (this.psDEFInputTipGlobalModel != null) {
            return this.psDEFInputTipGlobalModel.getDefaultPSDEFInputTip();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6392\u5e8f\u503c", ignorert=3, fields={"ORDERVALUE"})
    public int getOrderValue() {
        return this.nOrderValue;
    }

    @Override
    public String getLNLanResTag() {
        if (this.getLNPSLanguageRes() == null) {
            return this.strLNLanResTag;
        }
        return this.getLNPSLanguageRes().getLanResTag();
    }

    @Override
    @PSModelRTMeta(description="\u903b\u8f91\u540d\u79f0\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getLNPSLanguageRes() {
        return this.lnPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u5355\u4f4d\u5bf9\u8c61")
    public IPSSysUnit getPSSysUnit() {
        return this.iPSSysUnit;
    }

    @Override
    public String getUnitLanResTag() {
        if (this.getUnitPSLanguageRes() != null) {
            return this.getUnitPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @Override
    public long getCreateTime() {
        return this.nCreateTime;
    }

    @Override
    public IPSLanguageRes getUnitPSLanguageRes() {
        if (this.getPSSysUnit() != null) {
            return this.getPSSysUnit().getNamePSLanguageRes();
        }
        return null;
    }

    protected IPSSysEngineConfig getPSSysEngineConfig() {
        return ((IPSSystemSetting)((Object)this.getPSDataEntity().getPSSystem())).getPSSysEngineConfig();
    }

    @Override
    @PSModelRTMeta(description="\u68c0\u67e5\u9012\u5f52", ignoredumpvalues="false", group="\u503c\u89c4\u5219", order=365, fields={"CHECKRECURSION"})
    public final boolean isCheckRecursion() {
        this.initEx();
        return this.bCheckRecursion;
    }

    protected boolean onCalcCheckRecursion() throws Exception {
        if (this.psDEField.isCHECKRECURSIONNull()) {
            return false;
        }
        return this.psDEField.getCHECKRECURSION();
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u5217\u7ea7\u522b", ignoredumpvalues="1", group="\u641c\u7d22\u903b\u8f91", order=254, fields={"VIEWCOLLEVEL"})
    public int getViewLevel() {
        return this.nViewColLevel;
    }

    protected int onCalcViewLevel() {
        if (this.isPhisicalDEField()) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean isQueryColumn(int nViewLevel) {
        if (this.isDynaStorageDEField() || this.isUIAssistDEField()) {
            return false;
        }
        if (nViewLevel == -1) {
            return this.isQueryColumn();
        }
        if (this.isKeyDEField()) {
            return true;
        }
        if (StringHelper.Compare((String)this.getPreDefinedType(), (String)"LOGICVALID", (boolean)true) == 0) {
            return true;
        }
        return this.getViewLevel() >= nViewLevel;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u81ea\u52a8\u4ea7\u751f\u503c", ignoredumpvalues="false")
    public boolean isEnableDBAutoValue() {
        if (this.isEnableDBValueInsertUpdateMode() && !StringHelper.IsNullOrEmpty((String)this.getDBValueInsertMode())) {
            return true;
        }
        return this.iPSDEFieldType.isAutoIncrement();
    }

    @PSModelRTMeta(description="\u6570\u636e\u5e93\u65b0\u5efa\u503c\u6a21\u5f0f", codelist="DBValueMode", hideempty2=true, fields={"DBVALUEMODE"})
    public String getDBValueInsertMode() {
        return this.strInsertDBValueMode;
    }

    @PSModelRTMeta(description="\u6570\u636e\u5e93\u66f4\u65b0\u503c\u6a21\u5f0f", codelist="DBValueMode", hideempty2=true, fields={"DBVALUEMODE2"})
    public String getDBValueUpdateMode() {
        return this.strUpdateDBValueMode;
    }

    @Override
    public String getModelType() {
        return "PSDEFIELD";
    }

    @Override
    public String getModelName() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getName(), (Object)this.getLogicName());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.Format((String)"%1$s|%2$s#%3$s", (Object)this.getPSDataEntity().getFullModelName(), (Object)this.getName(), (Object)this.getLogicName());
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

    @Override
    public IPSDEFDTColumn getPSDETDTColumn(String strDBType) throws Exception {
        return this.getPSDataEntity().getPSDEDBConfig(strDBType).getPSDEFDTColumn(this.getName());
    }

    @Override
    public IPSDEFDTColumn getPSDEFDTColumn(String strDBType) throws Exception {
        return this.getPSDataEntity().getPSDEDBConfig(strDBType).getPSDEFDTColumn(this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u5217\u5bf9\u8c61\u96c6\u5408", child=true, dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=330)
    public synchronized Iterator<IPSDEFDTColumn> getAllPSDEFDTColumns() throws Exception {
        if (this.psDEFDTColumnList == null) {
            ArrayList<IPSDEFDTColumn> psDEFDTColumnList = new ArrayList<IPSDEFDTColumn>();
            if (!this.isDynaStorageDEField() && !this.isUIAssistDEField()) {
                Iterator<IPSDEDBConfig> psDEDBConfigs = this.getPSDataEntity().getAllPSDEDBConfigs();
                while (psDEDBConfigs.hasNext()) {
                    IPSDEFDTColumn iPSDEFDTColumn = psDEDBConfigs.next().getPSDEFDTColumn(this.getName());
                    psDEFDTColumnList.add(iPSDEFDTColumn);
                }
            }
            if (this.psDEFDTColumnList == null) {
                this.psDEFDTColumnList = psDEFDTColumnList;
            }
        }
        return this.psDEFDTColumnList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5b50\u7cfb\u7edf\u6269\u5c55", codelist="DEExtendMode", ignoredumpvalues="0")
    public int getExtendMode() {
        return this.nExtendMode;
    }

    public IDEFDTColumn getDEFDTColumn(String strDBType) throws Exception {
        return this.getPSDETDTColumn(strDBType);
    }

    @Override
    public boolean isEnableGetPSObjectParam() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u7c7b\u578b", codelist="DEFieldType", group="\u57fa\u672c", order=125, fields={"DEFTYPE"})
    public int getDEFType() {
        return this.nDEFType;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u5b58\u50a8\u5c5e\u6027", ignoredumpvalues="false")
    public boolean isDynaStorageDEField() {
        return this.bDynaStorageDEField;
    }

    protected void setDynaStorageDEField(boolean bDynaStorageDEField) {
        this.bDynaStorageDEField = bDynaStorageDEField;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f", dumpref=true, from="__self__", dynamodelmode=4, group="\u641c\u7d22\u903b\u8f91", order=260)
    public IPSDEFSearchMode getDefaultPSDEFSearchMode() {
        if (this.psDEFSearchModeGlobalModel == null) {
            return null;
        }
        return this.psDEFSearchModeGlobalModel.getDefaultPSDEFSearchMode();
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u7a7a\u503c\u6392\u5e8f\u6a21\u5f0f", codelist="DBNullValueOrderMode", fields={"NULLVALORDER"})
    public String getNullValueOrderMode() {
        return this.strNullValueOrderMode;
    }

    @Override
    @PSModelRTMeta(description="\u4e1a\u52a1\u6807\u8bb0", codelist="DEFBizTag", fields={"BIZTAG"})
    public String getBizTag() {
        return this.psDEField.getBIZTAG();
    }

    @Override
    @PSModelRTMeta(description="\u670d\u52a1\u4ee3\u7801\u6807\u8bc6", dynamodelmode=8, calccode="this.getCodeName()", fields={"SERVICECODENAME"})
    public String getServiceCodeName() {
        return this.onGetServiceCodeName();
    }

    protected String onGetServiceCodeName() {
        if (!StringHelper.IsNullOrEmpty((String)this.strServiceCodeName)) {
            return this.strServiceCodeName;
        }
        return this.getPSDataEntity().getAPICodeName(null, this.getCodeName(), null);
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u6570\u636e\u8868\u5bf9\u8c61", hideempty=true, dumpref=true, from="IPSDataEntity", dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=312)
    public IPSDEDBTable getPSDEDBTable() throws Exception {
        if (this.iPSDEDBTable != null) {
            return this.iPSDEDBTable;
        }
        if (this.getPSDataEntity().getPSSysDBScheme() != null && !StringHelper.IsNullOrEmpty((String)this.getTableName())) {
            this.iPSDEDBTable = this.getPSDataEntity().getPSDEDBTable(this.getTableName(), true);
        }
        return this.iPSDEDBTable;
    }

    @Override
    @PSModelRTMeta(description="\u5173\u7cfb\u6570\u636e\u5e93\u5217\u5bf9\u8c61", hideempty=true, dumpref=true, from="__self__", from_method="getPSDEDBTableMust().getPSSysDBTableMust().getPSSysDBColumn", dynamodelmode=4, group="\u6570\u636e\u5e93\u5b58\u50a8", order=316)
    public IPSSysDBColumn getPSSysDBColumn() throws Exception {
        if (this.iPSSysDBColumn != null) {
            return this.iPSSysDBColumn;
        }
        if (this.getPSDEDBTable() != null && this.getPSDEDBTable().getPSSysDBTable() != null) {
            this.iPSSysDBColumn = this.getPSDEDBTable().getPSSysDBTable().getPSSysDBColumn(this.getName(), true);
        }
        return this.iPSSysDBColumn;
    }

    @Override
    @PSModelRTMeta(description="\u5916\u90e8\u670d\u52a1\u5b9e\u4f53\u5c5e\u6027\u5bf9\u8c61", hideempty=true)
    public IPSSubSysServiceAPIDEField getPSSubSysServiceAPIDEField() throws Exception {
        if (this.iPSSubSysServiceAPIDEField != null) {
            if (this.iPSSubSysServiceAPIDEField == PSSubSysServiceAPIDEFieldImpl.EMPTY) {
                return null;
            }
            return this.iPSSubSysServiceAPIDEField;
        }
        if (this.getPSDataEntity().getPSSubSysServiceAPIDE() != null) {
            this.iPSSubSysServiceAPIDEField = !StringHelper.IsNullOrEmpty((String)this.psDEField.getPSSUBSYSSADEFIELDID()) ? this.getPSDataEntity().getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDEField(this.psDEField.getPSSUBSYSSADEFIELDID()) : this.getPSDataEntity().getPSSubSysServiceAPIDE().getPSSubSysServiceAPIDEField(this.getName(), true);
        }
        if (this.iPSSubSysServiceAPIDEField == null) {
            this.iPSSubSysServiceAPIDEField = PSSubSysServiceAPIDEFieldImpl.EMPTY;
            return null;
        }
        return this.iPSSubSysServiceAPIDEField;
    }

    @Override
    public Iterator<IPSDEFSearch> getAllPSDEFSearchs() throws Exception {
        if (this.psDEFSearchGlobalModel != null) {
            return this.psDEFSearchGlobalModel.getAllModelHelpers();
        }
        return emptyPSDEFSearchList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u5168\u6587\u68c0\u7d22\u96c6\u5408", group="\u641c\u7d22\u903b\u8f91", order=292)
    public Iterator<IPSDEFSearch> getAllPSDEFSearches() throws Exception {
        if (this.psDEFSearchGlobalModel != null) {
            return this.psDEFSearchGlobalModel.getAllModelHelpers();
        }
        return emptyPSDEFSearchList.iterator();
    }

    @Override
    public IPSDEFSearch getPSDEFSearch(String strPSDEFSearchId) throws Exception {
        return this.getPSDEFSearch(strPSDEFSearchId, false);
    }

    @Override
    public IPSDEFSearch getPSDEFSearch(String strPSDEFSearchId, boolean bTryMode) throws Exception {
        if (this.psDEFSearchGlobalModel == null) {
            if (bTryMode) {
                return null;
            }
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u5168\u6587\u68c0\u7d22[%2$s]", (Object)this.getName(), (Object)strPSDEFSearchId));
        }
        return (IPSDEFSearch)this.psDEFSearchGlobalModel.FindModelHelper(strPSDEFSearchId, bTryMode);
    }

    @Override
    public void setPSSubSysServiceAPIDEField(IPSSubSysServiceAPIDEField iPSSubSysServiceAPIDEField) {
        this.iPSSubSysServiceAPIDEField = iPSSubSysServiceAPIDEField;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u7f72\u6570\u636e\u6807\u8bc6", dump=false)
    public String getDeployId() {
        return KeyValueHelper.genUniqueId((String)this.getPSDataEntity().getDeployId(), (String)this.getName());
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u8f85\u52a9\u5c5e\u6027", ignoredumpvalues="false")
    public boolean isUIAssistDEField() {
        return this.getDEFType() == 5;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u5b57\u7b26\u4e32\u957f\u5ea6", ignoredumpvalues="0;-1", group="\u503c\u89c4\u5219", order=345, outputdoc="item.getStdDataType()==25", fields={"MINSTRLENGTH"})
    public int getMinStringLength() {
        this.initEx();
        return this.nMinStringLength;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c\uff08\u5b57\u7b26\u4e32\uff09", group="\u503c\u89c4\u5219", order=347, fields={"MAXVALUE"})
    public String getMaxValueString() {
        this.initEx();
        return this.strMaxValue;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c\uff08\u5b57\u7b26\u4e32\uff09", group="\u503c\u89c4\u5219", order=349, fields={"MINVALUE"})
    public String getMinValueString() {
        this.initEx();
        return this.strMinValue;
    }

    protected String onGetMinValueString() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getMINVALUE())) {
            return this.psDEField.getMINVALUE();
        }
        if (this.iPSSysDEFType != null && !StringHelper.IsNullOrEmpty((String)this.iPSSysDEFType.getMinValueString())) {
            return this.iPSSysDEFType.getMinValueString();
        }
        return this.iPSDEFieldType.getMinValueString();
    }

    protected String onGetMaxValueString() throws Exception {
        if (!StringHelper.IsNullOrEmpty((String)this.psDEField.getMAXVALUE())) {
            return this.psDEField.getMAXVALUE();
        }
        if (this.iPSSysDEFType != null && !StringHelper.IsNullOrEmpty((String)this.iPSSysDEFType.getMaxValueString())) {
            return this.iPSSysDEFType.getMaxValueString();
        }
        return this.iPSDEFieldType.getMaxValueString();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5c5e\u6027\u903b\u8f91\u96c6\u5408", outputdoc="false")
    public synchronized Iterator<IPSDEFLogic> getAllPSDEFLogics() throws Exception {
        if (this.psDEFLogicList == null) {
            ArrayList<IPSDEFLogic> psDEFLogicList = new ArrayList<IPSDEFLogic>();
            Iterator<IPSDELogic> psDELogics = this.getPSDataEntity().getAllPSDELogics();
            if (psDELogics != null) {
                while (psDELogics.hasNext()) {
                    IPSDEFLogic iPSDEFLogic;
                    IPSDELogic iPSDELogic = psDELogics.next();
                    if (!(iPSDELogic instanceof IPSDEFLogic) || StringHelper.Compare((String)(iPSDEFLogic = (IPSDEFLogic)iPSDELogic).getPSDEField().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                    psDEFLogicList.add(iPSDEFLogic);
                }
            }
            if (this.psDEFLogicList == null) {
                this.psDEFLogicList = psDEFLogicList.size() != 0 ? psDEFLogicList : emptyPSDEFLogicList;
            }
        }
        return this.psDEFLogicList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u503c\u903b\u8f91", dumpref=true, from="IPSDataEntity", from_method="getPSDELogic", origin="IPSDEFLogic", group="\u5904\u7406\u903b\u8f91", order=204)
    public IPSDEFLogic getDefaultValuePSDEFLogic() throws Exception {
        return this.getPSDEFLogicByMode("DEFAULT");
    }

    @Override
    @PSModelRTMeta(description="\u503c\u53d8\u66f4\u903b\u8f91", dumpref=true, from="IPSDataEntity", from_method="getPSDELogic", origin="IPSDEFLogic", group="\u5904\u7406\u903b\u8f91", order=210)
    public IPSDEFLogic getOnChangePSDEFLogic() throws Exception {
        return this.getPSDEFLogicByMode("ONCHANGE");
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8ba1\u7b97\u903b\u8f91", dumpref=true, from="IPSDataEntity", from_method="getPSDELogic", origin="IPSDEFLogic", group="\u5904\u7406\u903b\u8f91", order=205)
    public IPSDEFLogic getComputePSDEFLogic() throws Exception {
        return this.getPSDEFLogicByMode("COMPUTE");
    }

    @Override
    @PSModelRTMeta(description="\u503c\u68c0\u67e5\u903b\u8f91", dumpref=true, from="IPSDataEntity", from_method="getPSDELogic", origin="IPSDEFLogic", group="\u5904\u7406\u903b\u8f91", order=215)
    public IPSDEFLogic getCheckPSDEFLogic() throws Exception {
        return this.getPSDEFLogicByMode("CHECK");
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u81ea\u5b9a\u4e49\u903b\u8f91", dumpref=true, from="IPSDataEntity", from_method="getPSDELogic", origin="IPSDEFLogic", group="\u5904\u7406\u903b\u8f91", order=216)
    public IPSDEFLogic getUserPSDEFLogic() throws Exception {
        return this.getPSDEFLogicByMode("USER");
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u81ea\u5b9a\u4e49\u903b\u8f912", dumpref=true, from="IPSDataEntity", from_method="getPSDELogic", origin="IPSDEFLogic", group="\u5904\u7406\u903b\u8f91", order=217)
    public IPSDEFLogic getUser2PSDEFLogic() throws Exception {
        return this.getPSDEFLogicByMode("USER2");
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u81ea\u5b9a\u4e49\u903b\u8f913", dumpref=true, from="IPSDataEntity", from_method="getPSDELogic", origin="IPSDEFLogic", group="\u5904\u7406\u903b\u8f91", order=218)
    public IPSDEFLogic getUser3PSDEFLogic() throws Exception {
        return this.getPSDEFLogicByMode("USER3");
    }

    @Override
    @PSModelRTMeta(description="\u7528\u6237\u81ea\u5b9a\u4e49\u903b\u8f914", dumpref=true, from="IPSDataEntity", from_method="getPSDELogic", origin="IPSDEFLogic", group="\u5904\u7406\u903b\u8f91", order=219)
    public IPSDEFLogic getUser4PSDEFLogic() throws Exception {
        return this.getPSDEFLogicByMode("USER4");
    }

    protected IPSDEFLogic getPSDEFLogicByMode(String strMode) throws Exception {
        Iterator<IPSDEFLogic> psDEFLogics = this.getAllPSDEFLogics();
        if (psDEFLogics != null) {
            while (psDEFLogics.hasNext()) {
                IPSDEFLogic iPSDEFLogic = psDEFLogics.next();
                if (!iPSDEFLogic.isEnableBackend() || StringHelper.Compare((String)iPSDEFLogic.getDEFLogicMode(), (String)strMode, (boolean)false) != 0) continue;
                return iPSDEFLogic;
            }
        }
        return null;
    }

    @Override
    public int getEnableActions() {
        return this.nEnableActions;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5efa\u7acb", ignoredumpvalues="true")
    public boolean isEnableCreate() {
        return (this.getEnableActions() & 1) == 1;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u4fee\u6539", ignoredumpvalues="true")
    public boolean isEnableModify() {
        return (this.getEnableActions() & 2) == 2;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u5efa\u7acb", ignoredumpvalues="true")
    public boolean isEnableUICreate() {
        return this.isEnableUserInsert();
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u754c\u9762\u4fee\u6539", ignoredumpvalues="true")
    public boolean isEnableUIModify() {
        return this.isEnableUserUpdate();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5c5e\u6027\u6570\u636e\u5e93\u5217")
    public IPSDEFDTColumn getDefaultPSDEFDTColumn() throws Exception {
        if (this.getPSDataEntity().getPSSystem().getDefaultPSSystemDBConfig() != null) {
            String strDBType = this.getPSDataEntity().getPSSystem().getDefaultPSSystemDBConfig().getDBType();
            IPSDEDBConfig iPSDEDBConfig = this.getPSDataEntity().getPSDEDBConfig(strDBType, true);
            if (iPSDEDBConfig != null) {
                return iPSDEDBConfig.getPSDEFDTColumn(this.getName(), true);
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u5e8f\u5217", hideempty=true, dumpref=true, group="\u5904\u7406\u903b\u8f91", order=225, fields={"PSSYSSEQUENCEID"})
    public IPSSysSequence getPSSysSequence() throws Exception {
        if (StringHelper.Compare((String)this.getSequenceMode(), (String)"NONE", (boolean)false) == 0) {
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPSSysSequenceId())) {
            return null;
        }
        if (this.iPSSysSequence == null) {
            this.iPSSysSequence = this.getPSSystem().getPSSysSequence(this.getPSSysSequenceId());
        }
        return this.iPSSysSequence;
    }

    public String getPSSysSequenceId() {
        return this.psDEField.getPSSYSSEQUENCEID();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8ba1\u7b97\u8868\u8fbe\u5f0f", hideempty=true, fields={"COMPUTEEXP"})
    public String getComputeExpression() {
        return this.psDEField.getCOMPUTEEXP();
    }

    @Override
    @PSModelRTMeta(description="\u503c\u5e8f\u5217\u4f7f\u7528\u6a21\u5f0f", ignoredumpvalues="NONE", codelist="DEFSequenceMode", group="\u5904\u7406\u903b\u8f91", order=224, fields={"SEQUENCEMODE"})
    public String getSequenceMode() {
        return this.strSequenceMode;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u8f6c\u6362\u5668\u4f7f\u7528\u6a21\u5f0f", ignoredumpvalues="NONE", codelist="DEFTranslatorMode", group="\u5904\u7406\u903b\u8f91", order=226, fields={"TRANSLATORMODE"})
    public String getTranslatorMode() {
        return this.strTranslatorMode;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u503c\u8f6c\u6362\u5668", hideempty=true, dumpref=true, group="\u5904\u7406\u903b\u8f91", order=227, fields={"PSSYSTRANSLATORID"})
    public IPSSysTranslator getPSSysTranslator() throws Exception {
        if (StringHelper.Compare((String)this.getTranslatorMode(), (String)"NONE", (boolean)false) == 0) {
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)this.getPSSysTranslatorId())) {
            return null;
        }
        if (this.iPSSysTranslator == null) {
            this.iPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.getPSSysTranslatorId());
        }
        return this.iPSSysTranslator;
    }

    public String getPSSysTranslatorId() {
        return this.psDEField.getPSSYSTRANSLATORID();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @PSModelRTMeta(description="\u4e3b1:N\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u96c6\u5408", hideempty=true, group="\u5173\u7cfb", order=410)
    public Iterator<IPSDER1NDEFieldMap> getMajorPSDER1NDEFieldMaps() throws Exception {
        psDER1Ns = this.getPSDataEntity().getMajorPSDER1Ns();
        if (psDER1Ns == null) {
            return null;
        }
        list = null;
        while (psDER1Ns.hasNext()) {
            iPSDER1N = psDER1Ns.next();
            psDER1NDEFieldMaps = iPSDER1N.getPSDER1NDEFieldMaps();
            if (psDER1NDEFieldMaps != null) ** GOTO lbl16
            continue;
lbl-1000:
            // 1 sources

            {
                iPSDER1NDEFieldMap = psDER1NDEFieldMaps.next();
                if (iPSDER1NDEFieldMap.getMajorPSDEField() == null || StringHelper.Compare((String)iPSDER1NDEFieldMap.getMajorPSDEField().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                if (list == null) {
                    list = new ArrayList<IPSDER1NDEFieldMap>();
                }
                list.add(iPSDER1NDEFieldMap);
lbl16:
                // 3 sources

                ** while (psDER1NDEFieldMaps.hasNext())
            }
lbl17:
            // 1 sources

        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator();
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @PSModelRTMeta(description="\u4ece1:N\u5173\u7cfb\u5c5e\u6027\u6620\u5c04\u96c6\u5408", hideempty=true, group="\u5173\u7cfb", order=411)
    public Iterator<IPSDER1NDEFieldMap> getMinorPSDER1NDEFieldMaps() throws Exception {
        psDER1Ns = this.getPSDataEntity().getMinorPSDER1Ns();
        if (psDER1Ns == null) {
            return null;
        }
        list = null;
        while (psDER1Ns.hasNext()) {
            iPSDER1N = psDER1Ns.next();
            psDER1NDEFieldMaps = iPSDER1N.getPSDER1NDEFieldMaps();
            if (psDER1NDEFieldMaps != null) ** GOTO lbl16
            continue;
lbl-1000:
            // 1 sources

            {
                iPSDER1NDEFieldMap = psDER1NDEFieldMaps.next();
                if (iPSDER1NDEFieldMap.getMinorPSDEField() == null || StringHelper.Compare((String)iPSDER1NDEFieldMap.getMinorPSDEField().getId(), (String)this.getId(), (boolean)false) != 0) continue;
                if (list == null) {
                    list = new ArrayList<IPSDER1NDEFieldMap>();
                }
                list.add(iPSDER1NDEFieldMap);
lbl16:
                // 3 sources

                ** while (psDER1NDEFieldMaps.hasNext())
            }
lbl17:
            // 1 sources

        }
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u67e5\u8be2\u9009\u9879", codelist="DEFQueryCSMode", group="\u641c\u7d22\u903b\u8f91", order=254, fields={"QUERYCS"})
    public String getQueryOption() {
        return this.psDEField.getQUERYCS();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb0", hideempty2=true, fields={"FIELDTAG"})
    public String getFieldTag() {
        return this.psDEField.getFIELDTAG();
    }

    @Override
    @PSModelRTMeta(description="\u5c5e\u6027\u6807\u8bb02", hideempty2=true, fields={"FIELDTAG2"})
    public String getFieldTag2() {
        return this.psDEField.getFIELDTAG2();
    }

    public String getImportPSSysTranslatorId() {
        return this.psDEField.getIMPPSSYSTRANSLATORID();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5bfc\u5165\u503c\u8f6c\u6362\u5668", hideempty2=true, fields={"IMPPSSYSTRANSLATORID"})
    public IPSSysTranslator getImportPSSysTranslator() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getImportPSSysTranslatorId())) {
            return null;
        }
        if (this.importPSSysTranslator == null) {
            this.importPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.getImportPSSysTranslatorId());
        }
        return this.importPSSysTranslator;
    }

    public String getExportPSSysTranslatorId() {
        return this.psDEField.getEXPPSSYSTRANSLATORID();
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5bfc\u51fa\u503c\u8f6c\u6362\u5668", hideempty2=true, fields={"EXPPSSYSTRANSLATORID"})
    public IPSSysTranslator getExportPSSysTranslator() throws Exception {
        if (StringHelper.IsNullOrEmpty((String)this.getExportPSSysTranslatorId())) {
            return null;
        }
        if (this.exportPSSysTranslator == null) {
            this.exportPSSysTranslator = this.getPSSystem().getPSSysTranslator(this.getExportPSSysTranslatorId());
        }
        return this.exportPSSysTranslator;
    }

    @Override
    protected String onGetMOSFileName() {
        return this.getName();
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        PSDEFieldImpl.putJsonProperty(objectNode, "name", this.getName());
        PSDEFieldImpl.putJsonProperty(objectNode, "codeName", this.getCodeName());
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (StringHelper.Compare((String)this.getCodeName(), (String)this.getServiceCodeName(), (boolean)false) != 0 && !StringHelper.IsNullOrEmpty((String)this.getServiceCodeName())) {
            objectNode.remove("serviceCodeName");
            objectNode.put("serviceCodeName", this.getServiceCodeName());
        }
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u8868\uff08\u8fd0\u884c\u65f6\u5185\u8054\uff09", rtdump=2, hideempty=true, child=true)
    public IPSCodeList getInlinePSCodeList() {
        return null;
    }
}

