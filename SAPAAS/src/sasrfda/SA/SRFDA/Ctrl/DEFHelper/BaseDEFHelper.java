/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Data.DataTypeHelper
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ValueError
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl.DEFHelper;

import SA.SRFDA.Ctrl.DEFHelper.DEFDGItem;
import SA.SRFDA.Ctrl.DEFHelper.DEFDGItemConfig;
import SA.SRFDA.Ctrl.DEFHelper.DEFDTColumnConfig;
import SA.SRFDA.Ctrl.DEFHelper.DEFFormItem;
import SA.SRFDA.Ctrl.DEFHelper.DEFFormItemConfig;
import SA.SRFDA.Ctrl.DEFHelper.DEFHelperConfig;
import SA.SRFDA.Ctrl.DEFHelper.DEFMobileSetting;
import SA.SRFDA.Ctrl.DEFHelper.DEFMobileSettingConfig;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDGItem;
import SA.SRFDA.Ctrl.DEFHelper.IDEFDTColumn;
import SA.SRFDA.Ctrl.DEFHelper.IDEFFormCtrl;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFMobileSetting;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper;
import SA.SRFDA.Ctrl.DEFHelper.IDEFQueryHelper2;
import SA.SRFDA.Ctrl.Data.DEFMobile;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.ValueRule;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Localization.SRFDALocalizationHelper;
import SA.SRFDA.Model.SearchItemConfig;
import SA.SRFDA.Model.SearchModelConfig;
import SA.SRFDA.Model.ValueRuleConfig;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ValueError;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import java.util.Properties;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDEFHelper
implements IDEFHelper {
    protected DEFHelperConfig defHelperConfig = null;
    protected ISRFDAGlobalHelper globalHelperEx = null;
    protected IDEHelper iDEHelper = null;
    protected DEField field = null;
    protected IDEFFormCtrl iDEFFormCtrl = null;
    protected IDEFDTColumn iDTColumn = null;
    protected IDEFDGItem iDEFDGItem = null;
    protected IDEFMobileSetting iDEFMobileSetting = null;
    protected boolean bIsInit = false;
    protected SearchModelConfig searchModelConfig = null;
    protected IDEFQueryHelper iDEFQueryHelper = null;
    private static final Log log = LogFactory.getLog(BaseDEFHelper.class);
    protected static TreeMap<String, IDEFHelper> stdDataTypeDEFHelperMap = new TreeMap();
    protected static TreeMap<String, String> systemFields = new TreeMap();
    protected String strDEFName = "";
    protected String strDEFId = "";
    protected Properties defProperties = null;
    protected boolean bUserVisible = true;
    private boolean bMajorField = false;
    private boolean bKeyField = false;
    private boolean bIndexTypeField = false;
    private boolean bValidFlag = true;
    protected static Vector<String> wordList = new Vector();
    protected static TreeMap<String, String> staticProperties;
    private boolean bCalcSystemReserver = false;
    private boolean bSystemReserver = false;
    private boolean bCalcCodeList = false;
    private String strCodeListId = "";
    private boolean bCalcDataType = false;
    private String strDataType = "";
    private boolean bCalcUnit = false;
    private String strUnit = "";
    private boolean bCalcUnitWidth = false;
    private int nUnitWidth = 0;
    private String strValueRule = "";
    private boolean bCalcValueRule = false;
    private String strValueRuleInfo = "";
    private boolean bCalcValueRuleInfo = false;
    private boolean bCalcIgnoreInherit = false;
    private boolean bIgnoreInherit = false;
    private boolean bCalcPwdStorage = false;
    private int nPwdStorage = 0;
    private boolean bCalcEncryptStorage = false;
    private int nEncryptStorage = 0;

    static {
        systemFields.put("CREATEMAN", "");
        systemFields.put("CREATEDATE", "");
        systemFields.put("UPDATEMAN", "");
        systemFields.put("UPDATEDATE", "");
        systemFields.put("ENABLE", "");
        wordList.add("Description");
        wordList.add("Instance");
        wordList.add("Confirm");
        wordList.add("Target");
        wordList.add("DELogic");
        wordList.add("Related");
        wordList.add("Append");
        wordList.add("DEName");
        wordList.add("Helper");
        wordList.add("Object");
        wordList.add("Create");
        wordList.add("Action");
        wordList.add("Update");
        wordList.add("Pickup");
        wordList.add("Wizard");
        wordList.add("Group");
        wordList.add("Order");
        wordList.add("Logic");
        wordList.add("Index");
        wordList.add("Param");
        wordList.add("Field");
        wordList.add("Model");
        wordList.add("Image");
        wordList.add("Flag");
        wordList.add("Mode");
        wordList.add("Memo");
        wordList.add("Show");
        wordList.add("Page");
        wordList.add("Code");
        wordList.add("Time");
        wordList.add("Type");
        wordList.add("Help");
        wordList.add("DEId");
        wordList.add("Data");
        wordList.add("Date");
        wordList.add("Name");
        wordList.add("View");
        wordList.add("Icon");
        wordList.add("Cond");
        wordList.add("Inst");
        wordList.add("Info");
        wordList.add("DER");
        wordList.add("Key");
        wordList.add("Sub");
        wordList.add("Man");
        wordList.add("Lan");
        wordList.add("Res");
        wordList.add("Obj");
        wordList.add("Id");
        wordList.add("1N");
        wordList.add("DE");
        wordList.add("AC");
        wordList.add("SN");
        wordList.add("SP");
        staticProperties = new TreeMap();
    }

    @Override
    public void SetParam(IDEHelper iDEHelper, DEField field, DEFHelperConfig defHelperConfig, ISRFDAGlobalHelper globalHelperEx) {
        this.bIsInit = false;
        this.iDEHelper = iDEHelper;
        this.field = field;
        this.defHelperConfig = defHelperConfig != null ? defHelperConfig : new DEFHelperConfig();
        this.globalHelperEx = globalHelperEx;
    }

    @Override
    public CallResult Init() {
        CallResult callResult = new CallResult();
        if (this.iDEHelper == null || this.field == null || this.defHelperConfig == null || this.globalHelperEx == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u521d\u59cb\u5316\u53c2\u6570\u65e0\u6548");
            return callResult;
        }
        this.strDEFName = this.field.getDEFNAME().toUpperCase();
        this.strDEFId = this.field.getDEFID();
        if (this.field.isMAJOR()) {
            this.bMajorField = true;
        }
        if (this.field.isPKEY()) {
            this.bKeyField = true;
        }
        if (this.field.isINDEXTYPE()) {
            this.bIndexTypeField = true;
        }
        if (!this.field.isVALIDFLAGNull()) {
            this.bValidFlag = this.field.getVALIDFLAG();
            if (!this.bValidFlag) {
                log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53\u5c5e\u6027[%1$s][%2$s]\u65e0\u6548", (Object)this.strDEFId, (Object)this.strDEFName));
            }
        }
        log.debug((Object)StringHelper.Format((String)"\u5f00\u59cb\u521d\u59cb\u5316\u5b9e\u4f53\u5c5e\u6027[%1$s][%2$s]", (Object)this.strDEFId, (Object)this.strDEFName));
        try {
            String strDEFParam = this.field.getDEFPARAM();
            if (StringHelper.IsNullOrEmpty((String)strDEFParam)) {
                strDEFParam = String.valueOf(strDEFParam) + "\r\n";
            }
            if (!StringHelper.IsNullOrEmpty((String)this.field.getDEFUSERPARAM())) {
                strDEFParam = String.valueOf(strDEFParam) + this.field.getDEFUSERPARAM();
            }
            if (!StringHelper.IsNullOrEmpty((String)strDEFParam)) {
                this.defProperties = PropertiesHelper.Load((String)strDEFParam);
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u5b9e\u4f53\u5c5e\u6027\u914d\u7f6e\u53c2\u6570\u53d1\u751f\u9519\u8bef"), (Throwable)e);
        }
        if (this.iDEHelper.IsExistingModel()) {
            this.bUserVisible = StringHelper.Compare((String)this.field.getPREDEFINETYPE(), (String)"LOGICVALID", (boolean)true) != 0;
        } else {
            boolean bl = this.bUserVisible = StringHelper.Compare((String)this.getName(), (String)"ENABLE", (boolean)true) != 0;
        }
        if (this.field.ContainesParam("ISUSERVISIBLE")) {
            this.bUserVisible = this.field.isUSERVISIBLE();
        }
        return this.OnInit();
    }

    protected CallResult OnInit() {
        this.bIsInit = true;
        return new CallResult();
    }

    @Override
    public boolean IsInit() {
        return this.bIsInit;
    }

    @Override
    public CallResult PrepareCreateDEField(Vector<ValueError> errs) {
        CallResult callResult = new CallResult();
        if (this.iDEHelper == null || this.field == null || this.defHelperConfig == null || this.globalHelperEx == null) {
            callResult.setRetCode(1);
            callResult.setErrorInfo("\u51c6\u5907\u5efa\u7acb\u53c2\u6570\u65e0\u6548");
            return callResult;
        }
        return this.OnPrepareCreateDEField(errs);
    }

    protected CallResult OnPrepareCreateDEField(Vector<ValueError> errs) {
        String strStdDataType;
        int nStdDataType;
        String strFormItemXML;
        CallResult callResult = new CallResult();
        this.field.RemoveParam("DATATYPEPARAM4");
        this.field.RemoveParam("DATATYPEPARAM");
        String strFormItemStyle = this.field.getFORMITEMSTYLE();
        if (StringHelper.Compare((String)strFormItemStyle, (String)"SRFEXUSERCONTROLEX", (boolean)true) == 0 && StringHelper.IsNullOrEmpty((String)(strFormItemXML = this.field.getFORMITEMXML()))) {
            ValueError err = new ValueError();
            err.setErrorCode(1);
            err.setErrorInfo("\u5fc5\u987b\u4e3a\u81ea\u5b9a\u4e49\u8868\u5355\u9879\u6307\u5b9a\u53c2\u6570!");
            err.setValue("FORMITEMXML");
            errs.add(err);
        }
        if (DataTypeHelper.IsStringType((int)(nStdDataType = DataTypeHelper.FromString((String)(strStdDataType = this.GetStdDataType()))))) {
            int nStringLength = this.field.getLENGTH();
            if (nStringLength <= 0) {
                nStringLength = this.defHelperConfig.getStringLength();
            }
            if (nStringLength <= 0) {
                nStringLength = DataTypeHelper.IsLongStringType((int)nStdDataType) ? 0x100000 : 200;
            }
            this.field.setLENGTH(nStringLength);
        }
        if (errs.size() == 0) {
            callResult.setRetCode(0);
        } else {
            callResult.setRetCode(5);
        }
        return callResult;
    }

    @Override
    public final IDEHelper getDEHelper() {
        return this.iDEHelper;
    }

    @Override
    public final DEField getDEField() {
        return this.field;
    }

    @Override
    public IDEFFormCtrl GetFormCtrl() {
        if (this.iDEFFormCtrl != null) {
            return this.iDEFFormCtrl;
        }
        DEFFormItemConfig defFormItemConfig = this.defHelperConfig.getFormItemConfig();
        String strObject = defFormItemConfig.getObject();
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            this.iDEFFormCtrl = new DEFFormItem();
        } else {
            Object obj = ObjectHelper.Create((String)strObject);
            if (obj == null) {
                log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strObject));
                return null;
            }
            if (obj instanceof IDEFFormCtrl) {
                this.iDEFFormCtrl = (IDEFFormCtrl)obj;
            } else {
                log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5305\u542b\u63a5\u53e3[IDEFFormCtrl]", (Object)strObject));
                return null;
            }
        }
        CallResult callResult = this.iDEFFormCtrl.Init(this, defFormItemConfig, this.globalHelperEx);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316[%1$s:IDEFFormCtrl]\u8bc6\u522b\uff0c\u539f\u56e0:%2$s", (Object)strObject, (Object)callResult.getErrorInfo()));
            this.iDEFFormCtrl = null;
            return null;
        }
        return this.iDEFFormCtrl;
    }

    @Override
    public IDEFDTColumn GetDTColumn() {
        if (this.iDTColumn != null) {
            return this.iDTColumn;
        }
        DEFDTColumnConfig dtColumnConfig = this.defHelperConfig.getDTColumnConfig();
        String strObject = dtColumnConfig.getObject();
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            if (!StringHelper.IsNullOrEmpty((String)this.getDEHelper().GetDBStorage())) {
                strObject = this.globalHelperEx.getDAModelStorage().FindDBStorage(this.getDEHelper().GetDBStorage()).GetProperty("DEFDTCOLUMN");
            }
            if (StringHelper.IsNullOrEmpty((String)strObject)) {
                strObject = this.globalHelperEx.getGlobalConfigMgr().GetWebExConfig().GetValue("SRFDA", "DEFDTCOLUMN", "");
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            return null;
        }
        Object obj = ObjectHelper.Create((String)strObject);
        if (obj == null) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strObject));
            return null;
        }
        if (!(obj instanceof IDEFDTColumn)) {
            log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5305\u542b\u63a5\u53e3[IDEFDTColumn]", (Object)strObject));
            return null;
        }
        this.iDTColumn = (IDEFDTColumn)obj;
        CallResult callResult = this.iDTColumn.Init(this, dtColumnConfig, this.globalHelperEx);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316[%1$s:IDEFDTColumn]\u8bc6\u522b\uff0c\u539f\u56e0:%2$s", (Object)strObject, (Object)callResult.getErrorInfo()));
            this.iDEFFormCtrl = null;
            return null;
        }
        return this.iDTColumn;
    }

    @Override
    public IDEFDGItem getDGItem() {
        if (this.iDEFDGItem != null) {
            return this.iDEFDGItem;
        }
        DEFDGItemConfig defDGItemConfig = this.defHelperConfig.getDGItemConfig();
        String strObject = defDGItemConfig.getObject();
        if (StringHelper.IsNullOrEmpty((String)strObject)) {
            this.iDEFDGItem = new DEFDGItem();
        } else {
            Object obj = ObjectHelper.Create((String)strObject);
            if (obj == null) {
                log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5bf9\u8c61[%1$s]\u5931\u8d25", (Object)strObject));
                return null;
            }
            if (obj instanceof IDEFDGItem) {
                this.iDEFDGItem = (IDEFDGItem)obj;
            } else {
                log.error((Object)StringHelper.Format((String)"\u5bf9\u8c61[%1$s]\u6ca1\u6709\u5305\u542b\u63a5\u53e3[IDEFDGItem]", (Object)strObject));
                return null;
            }
        }
        CallResult callResult = this.iDEFDGItem.Init(this, defDGItemConfig, this.globalHelperEx);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316[%1$s:iDEFDGItem]\u8bc6\u522b\uff0c\u539f\u56e0:%2$s", (Object)strObject, (Object)callResult.getErrorInfo()));
            this.iDEFDGItem = null;
            return null;
        }
        return this.iDEFDGItem;
    }

    @Override
    public final String getId() {
        return this.strDEFId;
    }

    @Override
    public final String getName() {
        return this.strDEFName;
    }

    @Override
    public final String getLogicName() {
        return this.getLogicName("");
    }

    @Override
    public final String getLogicName(String strLanguage) {
        String strKey = "";
        strKey = !StringHelper.IsNullOrEmpty((String)strLanguage) ? StringHelper.Format((String)"%1$s.%2$s", (Object)"DEFLOGICNAME", (Object)strLanguage.toUpperCase()) : "DEFLOGICNAME";
        String strDEFLogicName = PropertiesHelper.GetProperty((Properties)this.defProperties, (String)strKey);
        if (strDEFLogicName != null) {
            return strDEFLogicName;
        }
        return this.globalHelperEx.getLocalizationHelper().GetLocalization(strLanguage, SRFDALocalizationHelper.GetRes_DEFLogicName("*", this.getName()), this.field.getDEFLOGICNAME());
    }

    @Override
    public final String GetFullName() {
        return StringHelper.Format((String)"%1$s:%2$s:%3$s {%4$s}", (Object)this.getId(), (Object)this.getName(), (Object)this.getLogicName(""), (Object)this.getDEHelper().GetFullName());
    }

    @Override
    public String GetFormItemStyle() {
        return this.OnGetFormItemStyle();
    }

    protected String OnGetFormItemStyle() {
        String strFormItemStyle = this.field.getFORMITEMSTYLE();
        if (!StringHelper.IsNullOrEmpty((String)strFormItemStyle)) {
            return strFormItemStyle;
        }
        strFormItemStyle = this.defHelperConfig.getFormItemStyle();
        if (StringHelper.IsNullOrEmpty((String)strFormItemStyle)) {
            return this.OnGetDefaultFormItemStyle();
        }
        return strFormItemStyle;
    }

    protected String OnGetDefaultFormItemStyle() {
        return "SRFEXTEXTBOX";
    }

    public boolean IsLinkDataType(String strDataType) {
        if (StringHelper.Compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0) {
            return true;
        }
        if (StringHelper.Compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
            return true;
        }
        return StringHelper.Compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0;
    }

    @Override
    public boolean IsLinkDEField() {
        return false;
    }

    @Override
    public boolean IsFormulaDEField() {
        return false;
    }

    @Override
    public boolean IsPhisicalDEField() {
        return true;
    }

    @Override
    public boolean IsMajorDEField() {
        return this.bMajorField;
    }

    @Override
    public boolean IsKeyDEField() {
        return this.bKeyField;
    }

    @Override
    public boolean IsIndexTypeDEField() {
        return this.bIndexTypeField;
    }

    @Override
    public boolean IsInheritDEField() {
        return false;
    }

    @Override
    public boolean IsSystemReserver() {
        if (!this.bCalcSystemReserver) {
            this.bSystemReserver = this.OnCalcSystemReserver();
        }
        return this.bSystemReserver;
    }

    protected boolean OnCalcSystemReserver() {
        if (this.getDEHelper().IsExistingModel()) {
            return !StringHelper.IsNullOrEmpty((String)this.field.getPREDEFINETYPE());
        }
        if (!StringHelper.IsNullOrEmpty((String)this.field.getPREDEFINETYPE())) {
            return true;
        }
        return systemFields.containsKey(this.getName());
    }

    @Override
    public boolean IsUserVisible() {
        return this.bUserVisible;
    }

    @Override
    public String GetCodeList() {
        if (!this.bCalcCodeList) {
            this.strCodeListId = this.OnGetCodeList();
            this.bCalcCodeList = true;
        }
        return this.strCodeListId;
    }

    protected String OnGetCodeList() {
        if (!StringHelper.IsNullOrEmpty((String)this.field.getCODELIST())) {
            return this.field.getCODELIST();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.field.getCODELISTID())) {
            return this.field.getCODELISTID();
        }
        return this.defHelperConfig.getCodeList();
    }

    @Override
    public String GetStdDataType() {
        return this.OnGetStdDataType();
    }

    protected String OnGetStdDataType() {
        return this.defHelperConfig.getStdDataType();
    }

    @Override
    public String GetDataType() {
        if (!this.bCalcDataType) {
            this.strDataType = this.OnGetDataType();
            this.bCalcDataType = true;
        }
        return this.strDataType;
    }

    protected String OnGetDataType() {
        return this.field.getDATATYPE();
    }

    @Override
    public boolean IsDupCheck() {
        return this.field.isDUPCHECK();
    }

    @Override
    public IDEFHelper GetDupCheckRangeDEFHelper() {
        if (StringHelper.IsNullOrEmpty((String)this.field.getDUPCHECKRANGE())) {
            return null;
        }
        return this.getDEHelper().GetDEFHelper(this.field.getDUPCHECKRANGE());
    }

    @Override
    public SearchModelConfig GetSearchModel() {
        if (this.searchModelConfig != null) {
            return this.searchModelConfig;
        }
        String strSearchModel = this.field.getSEARCHMODEL();
        if (StringHelper.IsNullOrEmpty((String)strSearchModel)) {
            return null;
        }
        SearchModelConfig searchModelConfig = new SearchModelConfig();
        if (!XMLConfig.LoadFromXML((String)strSearchModel, (XMLConfig)searchModelConfig)) {
            searchModelConfig = null;
            return null;
        }
        return searchModelConfig;
    }

    @Override
    public boolean IsSupportSearchAction(SearchItemConfig searchItemConfig) {
        return this.GetDTColumn().IsSupportSearchAction(searchItemConfig);
    }

    @Override
    public String GetUnit() {
        if (!this.bCalcUnit) {
            this.strUnit = this.OnGetUnit();
            this.bCalcUnit = true;
        }
        return this.strUnit;
    }

    protected String OnGetUnit() {
        if (!StringHelper.IsNullOrEmpty((String)this.field.getUNIT())) {
            return this.field.getUNIT();
        }
        return this.defHelperConfig.getUnit();
    }

    @Override
    public int GetUnitWidth() {
        if (!this.bCalcUnitWidth) {
            this.nUnitWidth = this.OnGetUnitWidth();
            this.bCalcUnitWidth = true;
        }
        return this.nUnitWidth;
    }

    protected int OnGetUnitWidth() {
        if (this.field.getUNITWIDTH() != 0) {
            return this.field.getUNITWIDTH();
        }
        return this.defHelperConfig.getUnitWidth();
    }

    @Override
    public boolean IsPasteReset() {
        if (this.IsKeyDEField()) {
            return true;
        }
        return this.field.isPASTERESET();
    }

    @Override
    public IDEFQueryHelper GetQueryHelper() {
        if (StringHelper.IsNullOrEmpty((String)this.field.getQUERYHELPER())) {
            return null;
        }
        if (this.iDEFQueryHelper != null) {
            return this.iDEFQueryHelper;
        }
        Object objQueryHelper = ObjectHelper.Create((String)this.field.getQUERYHELPER());
        if (objQueryHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5c5e\u6027\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)this.field.getQUERYHELPER()));
            return null;
        }
        if (!(objQueryHelper instanceof IDEFQueryHelper)) {
            log.error((Object)StringHelper.Format((String)"\u5c5e\u6027\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.field.getQUERYHELPER()));
            return null;
        }
        this.iDEFQueryHelper = (IDEFQueryHelper)objQueryHelper;
        if (this.iDEFQueryHelper instanceof IDEFQueryHelper2) {
            IDEFQueryHelper2 iDEFQueryHelper2 = (IDEFQueryHelper2)this.iDEFQueryHelper;
            iDEFQueryHelper2.setDAGlobalHelper(this.globalHelperEx);
            iDEFQueryHelper2.setDEFHelper(this);
        }
        return this.iDEFQueryHelper;
    }

    @Override
    public String GetValueRule() {
        if (!this.bCalcValueRule) {
            this.strValueRule = this.OnGetValueRule();
            this.bCalcValueRule = true;
        }
        return this.strValueRule;
    }

    protected String OnGetValueRule() {
        ValueRuleConfig valueRuleConfig;
        String strCustomValueRule = this.field.getCUSTOMVALUERULE();
        if (!StringHelper.IsNullOrEmpty((String)strCustomValueRule)) {
            return strCustomValueRule;
        }
        String strValueRule = this.field.getVALUERULE();
        if (!StringHelper.IsNullOrEmpty((String)strValueRule)) {
            valueRuleConfig = this.globalHelperEx.getDAConfigMgr().getValueRuleMgr().FindRuleConfig(strValueRule);
            if (valueRuleConfig == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49\u503c\u89c4\u5219[%1$s]", (Object)strValueRule));
            } else {
                return valueRuleConfig.getRule();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strValueRule = this.field.getVALUERULEID()))) {
            return StringHelper.Format((String)"SRFDAVALUERULE:%%1$s|%1$s", (Object)strValueRule);
        }
        strCustomValueRule = this.defHelperConfig.getValueRule();
        if (!StringHelper.IsNullOrEmpty((String)strCustomValueRule)) {
            return strCustomValueRule;
        }
        strValueRule = this.defHelperConfig.getCustomValueRule();
        if (!StringHelper.IsNullOrEmpty((String)strValueRule)) {
            valueRuleConfig = this.globalHelperEx.getDAConfigMgr().getValueRuleMgr().FindRuleConfig(strValueRule);
            if (valueRuleConfig == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49\u503c\u89c4\u5219[%1$s]", (Object)strValueRule));
            } else {
                return valueRuleConfig.getRule();
            }
        }
        return "";
    }

    @Override
    public String GetValueRuleInfo() {
        if (!this.bCalcValueRuleInfo) {
            this.strValueRuleInfo = this.OnGetValueRuleInfo();
            this.bCalcValueRuleInfo = true;
        }
        return this.strValueRuleInfo;
    }

    protected String OnGetValueRuleInfo() {
        ValueRuleConfig valueRuleConfig;
        String strValueRuleInfo = this.field.getVALUERULEINFO();
        if (!StringHelper.IsNullOrEmpty((String)strValueRuleInfo)) {
            return strValueRuleInfo;
        }
        String strValueRule = this.field.getVALUERULE();
        if (!StringHelper.IsNullOrEmpty((String)strValueRule)) {
            valueRuleConfig = this.globalHelperEx.getDAConfigMgr().getValueRuleMgr().FindRuleConfig(strValueRule);
            if (valueRuleConfig == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49\u503c\u89c4\u5219[%1$s]", (Object)strValueRule));
            } else {
                return valueRuleConfig.getRuleInfo();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)(strValueRule = this.field.getVALUERULEID()))) {
            ValueRule valueRule = this.globalHelperEx.getDAModelStorage().FindValueRule(strValueRule);
            if (valueRule == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u503c\u89c4\u5219[%1$s]\u914d\u7f6e", (Object)strValueRule));
                return "";
            }
            return valueRule.getRULEINFO();
        }
        strValueRuleInfo = this.defHelperConfig.getValueRuleInfo();
        if (!StringHelper.IsNullOrEmpty((String)strValueRuleInfo)) {
            return strValueRuleInfo;
        }
        strValueRule = this.defHelperConfig.getValueRule();
        if (!StringHelper.IsNullOrEmpty((String)strValueRule)) {
            valueRuleConfig = this.globalHelperEx.getDAConfigMgr().getValueRuleMgr().FindRuleConfig(strValueRule);
            if (valueRuleConfig == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49\u503c\u89c4\u5219[%1$s]", (Object)strValueRule));
            } else {
                return valueRuleConfig.getRuleInfo();
            }
        }
        return "";
    }

    @Override
    public Object GetDEFValue(String strValue) {
        return DataTypeParse.Parse((String)this.GetStdDataType(), (String)strValue);
    }

    @Override
    public boolean IsEnableAudit() {
        return this.field.isENABLEAUDIT();
    }

    @Override
    public String GetAuditInfoFormat() {
        String strAuditInfoFormat = this.field.getAUDITINFOFORMAT();
        if (StringHelper.IsNullOrEmpty((String)strAuditInfoFormat)) {
            return "[%1$s] \u4ece  [%2$s] \u53d8\u66f4\u4e3a [%3$s] ";
        }
        return strAuditInfoFormat;
    }

    @Override
    public int GetPrecision() {
        if (this.field.getPRECISION2() > 0) {
            return this.field.getPRECISION2();
        }
        return this.defHelperConfig.getPrecision();
    }

    @Override
    public boolean IsIgnoreInherit() {
        if (!this.bCalcIgnoreInherit) {
            this.bIgnoreInherit = this.OnCalcIgnoreInherit();
            this.bCalcIgnoreInherit = true;
        }
        return this.bIgnoreInherit;
    }

    protected boolean OnCalcIgnoreInherit() {
        if (this.getDEHelper().IsExistingModel() ? StringHelper.Compare((String)this.field.getPREDEFINETYPE(), (String)"LOGICVALID", (boolean)true) == 0 : StringHelper.Compare((String)this.getName(), (String)"ENABLE", (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.Compare((String)this.field.getPREDEFINETYPE(), (String)"ORGUNITID", (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.Compare((String)this.field.getPREDEFINETYPE(), (String)"ORGUNITNAME", (boolean)true) == 0) {
            return false;
        }
        if (this.IsSystemReserver()) {
            return true;
        }
        if (this.IsKeyDEField()) {
            return true;
        }
        return this.IsMajorDEField();
    }

    @Override
    public String GetDupCheckCode(boolean bInsert) {
        if (bInsert) {
            String strPropertyName = StringHelper.Format((String)"%1$s.%2$s", (Object)"DUPCHECKCODE", (Object)this.getDEHelper().GetDBType());
            return this.GetProperty(strPropertyName, this.field.getDUPCHECKCODE());
        }
        String strPropertyName = StringHelper.Format((String)"%1$s.%2$s", (Object)"DUPCHECKCODE2", (Object)this.getDEHelper().GetDBType());
        return this.GetProperty(strPropertyName, this.field.getDUPCHECKCODE2());
    }

    @Override
    public boolean IsEnableDEFieldPriv() {
        return this.field.getENABLECOLPRIV();
    }

    @Override
    public String GetStringCase() {
        return this.field.getSTRINGCASE();
    }

    @Override
    public String getCaretTemplGroupId() {
        return this.field.getCARETTEMPLGROUPID();
    }

    @Override
    public String getCaretRetMode() {
        return this.field.getCARETRETMODE();
    }

    @Override
    public String getUpdateOVMode() {
        return this.field.getUPDATEOVMODE();
    }

    @Override
    public String getCodeName() {
        String strCodeName = this.field.getRESERVER();
        if (!StringHelper.IsNullOrEmpty((String)strCodeName)) {
            String strName = strCodeName.substring(0, 1).toUpperCase();
            strName = String.valueOf(strName) + strCodeName.substring(1);
            return strName;
        }
        strCodeName = this.getName();
        strCodeName = strCodeName.toLowerCase();
        String strParseWord = "";
        String strNotParseWord = strCodeName;
        while (strNotParseWord.length() > 0) {
            boolean bNotFind = true;
            for (String strWord : wordList) {
                String strWord2 = strWord.toLowerCase();
                if (strNotParseWord.indexOf(strWord2) != 0) continue;
                strParseWord = String.valueOf(strParseWord) + strWord;
                strNotParseWord = strNotParseWord.substring(strWord.length());
                bNotFind = false;
                break;
            }
            if (!bNotFind) continue;
            strParseWord = String.valueOf(strParseWord) + strNotParseWord.charAt(0);
            strNotParseWord = strNotParseWord.substring(1);
        }
        String strName = strParseWord.substring(0, 1).toUpperCase();
        strName = String.valueOf(strName) + strParseWord.substring(1);
        return strName;
    }

    @Override
    public IDEFMobileSetting getMobileSetting() throws Exception {
        if (this.iDEFMobileSetting != null) {
            return this.iDEFMobileSetting;
        }
        DEFMobileSettingConfig mobileSettingConfig = this.defHelperConfig.getMobileSettingConfig();
        this.iDEFMobileSetting = new DEFMobileSetting();
        this.iDEFMobileSetting.Init(this, new DEFMobile(), mobileSettingConfig, this.globalHelperEx);
        return this.iDEFMobileSetting;
    }

    @Override
    public int getPwdStorage() {
        if (!this.bCalcPwdStorage) {
            this.nPwdStorage = this.OnGetPwdStorage();
            this.bCalcPwdStorage = true;
        }
        return this.nPwdStorage;
    }

    protected int OnGetPwdStorage() {
        if (this.field.isPWDSTORAGENull()) {
            return 0;
        }
        return this.field.getPWDSTORAGE();
    }

    @Override
    public String GetProperty(String strPropertyName) {
        strPropertyName = strPropertyName.toUpperCase();
        String strDefaultValue = "";
        if (staticProperties.containsKey(strPropertyName)) {
            strDefaultValue = staticProperties.get(strPropertyName);
        }
        return PropertiesHelper.GetProperty((Properties)this.defProperties, (String)strPropertyName, (String)strDefaultValue);
    }

    @Override
    public String GetProperty(String strPropertyName, String strDefaultValue) {
        strPropertyName = strPropertyName.toUpperCase();
        return PropertiesHelper.GetProperty((Properties)this.defProperties, (String)strPropertyName, (String)strDefaultValue);
    }

    @Override
    public boolean isEnableUpdate() {
        return this.OnGetEnableUpdate();
    }

    protected boolean OnGetEnableUpdate() {
        return this.field.isENABLEMODIFY();
    }

    @Override
    public final String getCodeListParam() {
        return this.OnGetCodeListParam();
    }

    protected String OnGetCodeListParam() {
        return this.field.getCODELISTPARAM();
    }

    @Override
    public boolean isUIAssistField() {
        if (this.field.isUIASSISTNull()) {
            return false;
        }
        return this.field.getUIASSIST();
    }

    @Override
    public int getEncryptStorage() {
        if (!this.bCalcEncryptStorage) {
            this.nEncryptStorage = this.OnGetEncryptStorage();
            this.bCalcEncryptStorage = true;
        }
        return this.nEncryptStorage;
    }

    protected int OnGetEncryptStorage() {
        if (this.field.isENCRYPTSTORAGENull()) {
            return 0;
        }
        return this.field.getENCRYPTSTORAGE();
    }

    @Override
    public String getInputTips() {
        return this.field.getINPUTTIPS();
    }

    @Override
    public boolean IsFormulaPhisical() {
        return this.field.getFORMULAPHY();
    }

    @Override
    public boolean getValidFlag() {
        return false;
    }
}

