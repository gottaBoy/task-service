/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.Data.CallParam
 *  SA.SRFramework.Data.CallParamList
 *  SA.SRFramework.Data.DBResult
 *  SA.SRFramework.Data.SelectResult
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.DataEx.ProcParam
 *  SA.SRFramework.Log.LoggerEx
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  freemarker.cache.TemplateLoader
 *  freemarker.template.Configuration
 *  freemarker.template.Template
 *  freemarker.template.TemplateException
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.CaretTemplHelper;
import SA.SRFDA.Ctrl.DEDataCtrl.Model.DEDCBaseProcessConfig;
import SA.SRFDA.Ctrl.DEFHelper.BaseDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.DEFHelperConfig;
import SA.SRFDA.Ctrl.DEFHelper.DEFHelperMgr;
import SA.SRFDA.Ctrl.DEFHelper.IDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.ILinkDEFHelper;
import SA.SRFDA.Ctrl.DEFHelper.IPickupDEFHelper;
import SA.SRFDA.Ctrl.DEFHelperComparator;
import SA.SRFDA.Ctrl.DEMainActionHelper;
import SA.SRFDA.Ctrl.DEMainStateHelper;
import SA.SRFDA.Ctrl.DER11Helper;
import SA.SRFDA.Ctrl.DER1NExHelper;
import SA.SRFDA.Ctrl.DER1NHelper;
import SA.SRFDA.Ctrl.DESubWFHelper;
import SA.SRFDA.Ctrl.DEWFDetailHelper;
import SA.SRFDA.Ctrl.DEWFHelper;
import SA.SRFDA.Ctrl.Data.DBAction;
import SA.SRFDA.Ctrl.Data.DBObject;
import SA.SRFDA.Ctrl.Data.DEACMode;
import SA.SRFDA.Ctrl.Data.DEAction;
import SA.SRFDA.Ctrl.Data.DEDCProcess;
import SA.SRFDA.Ctrl.Data.DEDataCtrl;
import SA.SRFDA.Ctrl.Data.DEDataImport;
import SA.SRFDA.Ctrl.Data.DEDataSync;
import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.DEMainAction;
import SA.SRFDA.Ctrl.Data.DEMainState;
import SA.SRFDA.Ctrl.Data.DEMobile;
import SA.SRFDA.Ctrl.Data.DER11;
import SA.SRFDA.Ctrl.Data.DER1N;
import SA.SRFDA.Ctrl.Data.DER1NEx;
import SA.SRFDA.Ctrl.Data.DERCUSTOM;
import SA.SRFDA.Ctrl.Data.DERGroup;
import SA.SRFDA.Ctrl.Data.DERINDEX;
import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.Data.DEWF;
import SA.SRFDA.Ctrl.Data.DEWFDetail;
import SA.SRFDA.Ctrl.Data.DEWizard;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataNotify;
import SA.SRFDA.Ctrl.Data.PrintForm;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.Data.SummaryPage;
import SA.SRFDA.Ctrl.DataNotify.IDataNotifyHelper;
import SA.SRFDA.Ctrl.IDAConfigHelper;
import SA.SRFDA.Ctrl.IDAMBConfigHelper;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.IDEDataLockKeyHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDEMainActionHelper;
import SA.SRFDA.Ctrl.IDEMainStateHelper;
import SA.SRFDA.Ctrl.IDER11Helper;
import SA.SRFDA.Ctrl.IDER1NHelper;
import SA.SRFDA.Ctrl.IDERGroupHelper;
import SA.SRFDA.Ctrl.IDERHelper;
import SA.SRFDA.Ctrl.IDESubWFHelper;
import SA.SRFDA.Ctrl.IDEToolTipHelper;
import SA.SRFDA.Ctrl.IDEWFDetailHelper;
import SA.SRFDA.Ctrl.IDEWFHelper;
import SA.SRFDA.Ctrl.ISummaryPageHelper;
import SA.SRFDA.Ctrl.Utility.DETemplateLoader;
import SA.SRFDA.Ctrl.Utility.MacroHelper;
import SA.SRFDA.Security.IDataAccHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.Data.CallParam;
import SA.SRFramework.Data.CallParamList;
import SA.SRFramework.Data.DBResult;
import SA.SRFramework.Data.SelectResult;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.DataEx.ProcParam;
import SA.SRFramework.Log.LoggerEx;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseDEHelper
implements IDEHelper {
    private static final Log log = LogFactory.getLog(BaseDEHelper.class);
    public static final int DEDATACHGLOG_NONE = 0;
    public static final int DEDATACHGLOG_KEY = 1;
    public static final int DEDATACHGLOG_SINGLEDATA = 2;
    public static final int DEDATACHGLOG_FULLDATA = 3;
    private String strViewName = "";
    private boolean bLogicValid = false;
    private String strTableName = "";
    private String strExTableName = "";
    private String strMinorTableName = "";
    private String strInfoFormat = "";
    private String strInfoFields = "";
    private String strEditPageId = "";
    private String strGridPageId = "";
    private String strPickupPageId = "";
    private String strMPickupPageId = "";
    protected DataEntity dataEntity = null;
    protected IDAModelHelper iDAModelHelper = null;
    protected Vector<IDEFHelper> defHelpers;
    protected Hashtable<String, IDEFHelper> defHelperMap;
    protected Hashtable<String, IDEFHelper> defHelperMapByName;
    protected Hashtable<String, String> deWFMap = new Hashtable();
    protected Hashtable<String, String> preDefineFields = null;
    protected Hashtable<String, Vector<DEDataCtrl>> deDataCtrlMap = null;
    protected Hashtable<String, DEACMode> deACModeMap = null;
    protected Hashtable<String, DEDataImport> deDataImportMap = null;
    protected Hashtable<String, DEAction> deActionMap = null;
    protected Hashtable<String, IDESubWFHelper> deSubWFMap = null;
    protected Hashtable<String, IDEWFDetailHelper> deWFDetailMap = new Hashtable();
    private final Hashtable<String, BaseDAQueryModelHelper> daQueryModelHelperMap = new Hashtable();
    protected String strInheritDEId = "";
    protected String strInheritDERId = "";
    protected String strInheritTypeValue = "";
    protected DERINDEX inheritDERIndex = null;
    protected Hashtable<String, String> ingoreInheritDEFMap = null;
    protected String strProcPreFix = "SRFSP_";
    protected Hashtable<String, IDAConfigHelper> daConfigHelperMap = null;
    protected Hashtable<String, IDAMBConfigHelper> daMBConfigHelperMap = null;
    protected DEMobile deMobile = null;
    public static final String TAG_PERSONID = "SRF_PERSONID";
    public static final String TAG_ORGUNITID = "SRF_ORGUNITID";
    public static final String TAG_ORGUNITNAME = "SRF_ORGUNITNAME";
    public static final String TAG_RETCODE = "SRF_RETCODE";
    public static final String TAG_RETINFO = "SRF_RETINFO";
    public static final String TAG_TAG = "SRF_TAG";
    public static final String TAG_VAR = "VAR_";
    public static final String TAG_VAREX = "VAREX_";
    public static final String TAG_VF = "VF_";
    private static final Hashtable<String, String> defProperties = new Hashtable();
    protected static DEFHelperComparator defHelperComparator = new DEFHelperComparator();
    protected String[] keyParams = null;
    protected Hashtable<String, Object> dePropertiesCache = new Hashtable();
    protected Hashtable<String, DEField> relatedDEFieldMap = new Hashtable();
    protected ISRFDAGlobalHelper contextHelperEx = null;
    protected Hashtable<String, Object> defieldSearchModelMap = new Hashtable();
    private static final Hashtable<String, String> systemFields;
    protected String strMajorDEId = "";
    protected String strMajorDERId = "";
    protected String strMajorDERType = "";
    protected String strMajorDEKeyField = "";
    protected IDEFHelper keyDEFHelper = null;
    protected IDEFHelper majorDEFHelper = null;
    protected IDEFHelper indexTypeDEFHelper = null;
    protected IDEFHelper updateDateDEFHelper = null;
    protected IDEFHelper orgUnitIdDEFHelper = null;
    protected IDataAccHelper iDataCtrlHelper = null;
    protected Properties deProperties = null;
    protected Vector<DER1N> der1nList = new Vector();
    protected Vector<IDER1NHelper> der1NHelperList = new Vector();
    protected Vector<DER1N> der1nList2 = new Vector();
    protected Vector<DER11> der11List = new Vector();
    protected Vector<IDER11Helper> der11HelperList = new Vector();
    protected Vector<DER11> der11List2 = new Vector();
    protected Vector<DERINDEX> derIndexList = new Vector();
    protected Vector<DERINDEX> derIndexList2 = new Vector();
    protected Vector<DERCUSTOM> derCustomList = new Vector();
    protected Vector<DERCUSTOM> derCustomList2 = new Vector();
    protected Hashtable<String, BaseDataEntity> derMap = new Hashtable();
    protected Hashtable<String, IDERHelper> derHelperMap = new Hashtable();
    protected Hashtable<String, Vector<ProcParam>> procParamMap = new Hashtable();
    protected Hashtable<String, Object> dbActionMap = new Hashtable();
    protected Hashtable<String, Integer> dbProcExistMap = new Hashtable();
    private String strDAConfigHelperObject = "";
    private static boolean bEnablePrintDefault;
    private static boolean bEnableHelpDefault;
    private static boolean bEnableImportDataDefault;
    private static boolean bEnableExportDataDefault;
    protected Hashtable<String, Object> attributeMap = new Hashtable();
    protected boolean bMajorDE = true;
    private String strDGColumns = "";
    private String strSearchableColumns = "";
    protected Hashtable<String, SelectQueryModel> selectQueryModelHelperMap = null;
    protected boolean bInitselectQueryModel = false;
    protected IDEToolTipHelper iDEToolTipHelper = null;
    protected Template toolTipTemplate = null;
    protected Vector<DataNotify> dataNotifies = new Vector();
    protected Vector<DEWizard> createWizards = new Vector();
    protected Hashtable<String, DEWizard> deWizardMap = new Hashtable();
    protected boolean bHasDataNotify = false;
    private String strId = "";
    private String strName = "";
    private int nDEVersion;
    protected boolean bDevelopMode = true;
    private boolean bEnablePrint = true;
    protected IDEDataLockKeyHelper iDEDataLockKeyHelper = null;
    private Vector<IDEFHelper> caretTemplFields = new Vector();
    private int nDEDataChangeLogMode = 0;
    private boolean bExportIncEmpty = false;
    private Vector<DEDataSync> deDataSyncOuts = new Vector();
    private Vector<DEDataSync> deDataSyncIns = new Vector();
    private boolean bEnablePwdStorage = false;
    private Vector<IDEFHelper> pwdStorageFields = null;
    private boolean bEnableEncryptStorage = false;
    private Vector<IDEFHelper> encryptStorageFields = null;
    private Hashtable<String, IDEMainStateHelper> deMainStateHelperMap = null;
    private IDEMainStateHelper defaultDEMainStateHelper = null;
    private Hashtable<String, IDEMainActionHelper> deMainActionHelperMap = null;
    private Hashtable<String, IDERGroupHelper> derGroupHelperMap = null;
    protected IDEWFHelper iDEWFHelper = null;
    private Hashtable<String, IDataNotifyHelper> dataNotifyHelperMap = new Hashtable();
    private boolean bMultiMajorMode = false;
    private HashMap<String, DER1N> multiMajorDERMap = new HashMap();
    private boolean bNoDataInfo = false;
    private boolean bHasPhisicalFormulaField = false;
    private boolean bValidFlag = true;
    private IDEHelper inheritDEHelper = null;
    private Object inheritDEHelperLock = new Object();
    private String strRuntimeInfo = "";
    private boolean bEnableVersionControl = false;
    private String strDataCtrlObject = "";
    private boolean bCalcDataCtrlObject = false;

    static {
        defProperties.put("VALIDVALUE", "1");
        defProperties.put("INVALIDVALUE", "0");
        defProperties.put("MULTIFORM", "FALSE");
        defProperties.put("IGNORESAVEINDEXERROR", "TRUE");
        defProperties.put("LOGPODBACTION", "TRUE");
        defProperties.put("LOGPODBQUERY", "TRUE");
        defProperties.put("DACONFIGVER", "1");
        systemFields = new Hashtable();
        systemFields.put("CREATEMAN", "");
        systemFields.put("CREATEDATE", "");
        systemFields.put("UPDATEMAN", "");
        systemFields.put("UPDATEDATE", "");
        systemFields.put("ENABLE", "");
        bEnablePrintDefault = true;
        bEnableHelpDefault = true;
        bEnableImportDataDefault = true;
        bEnableExportDataDefault = true;
    }

    @Override
    public boolean Init(DataEntity dataEntity, IDAModelHelper iDAModelHelper, ISRFDAGlobalHelper contextHelperEx) {
        String strKeyParams;
        this.dataEntity = dataEntity;
        this.iDAModelHelper = iDAModelHelper;
        this.contextHelperEx = contextHelperEx;
        this.strId = dataEntity.getDEID();
        this.strName = dataEntity.getDENAME();
        this.nDEVersion = this.dataEntity.getDEVERSION();
        if (!this.dataEntity.isVALIDFLAGNull()) {
            this.bValidFlag = this.dataEntity.getVALIDFLAG();
        }
        if (!this.bValidFlag) {
            log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s][%2$s]\u65e0\u6548\uff0c\u4e0d\u518d\u52a0\u8f7d", (Object)this.strId, (Object)this.strName));
            return false;
        }
        if (!this.dataEntity.isDATACHGLOGMODENull()) {
            this.nDEDataChangeLogMode = this.dataEntity.getDATACHGLOGMODE();
        }
        if (!this.dataEntity.isEXPORTINCEMPTYNull()) {
            this.bExportIncEmpty = this.dataEntity.getEXPORTINCEMPTY();
        }
        if (!this.dataEntity.isMULTIMAJORNull()) {
            this.bMultiMajorMode = this.dataEntity.getMULTIMAJOR();
        }
        if (!this.dataEntity.isVCFLAGNull()) {
            this.bEnableVersionControl = this.dataEntity.getVCFLAG();
        }
        if (!this.dataEntity.isNODATAINFONull() && this.dataEntity.getNODATAINFO()) {
            this.bNoDataInfo = true;
        }
        this.bDevelopMode = this.OnGetDevelopMode();
        try {
            String strDEParam = dataEntity.getDEPARAM();
            if (StringHelper.IsNullOrEmpty((String)strDEParam)) {
                strDEParam = String.valueOf(strDEParam) + "\r\n";
            }
            if (!StringHelper.IsNullOrEmpty((String)dataEntity.getDEUSERPARAM())) {
                strDEParam = String.valueOf(strDEParam) + dataEntity.getDEUSERPARAM();
            }
            if (!StringHelper.IsNullOrEmpty((String)strDEParam)) {
                this.deProperties = PropertiesHelper.Load((String)strDEParam);
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u5b9e\u4f53\u914d\u7f6e\u53c2\u6570\u53d1\u751f\u9519\u8bef"), (Throwable)e);
        }
        if (!StringHelper.IsNullOrEmpty((String)(strKeyParams = dataEntity.getKEYPARAMS()))) {
            strKeyParams = strKeyParams.trim();
            strKeyParams = strKeyParams.replace("|", ";");
            this.keyParams = strKeyParams.split("[;]");
        }
        this.InitModel(dataEntity);
        if (!this.i1()) {
            return false;
        }
        this.strDAConfigHelperObject = this.dataEntity.getCONFIGHELPER();
        if (!StringHelper.IsNullOrEmpty((String)this.strDAConfigHelperObject)) {
            this.daConfigHelperMap = new Hashtable();
        }
        if (!StringHelper.IsNullOrEmpty((String)this.dataEntity.getDLKHELPER())) {
            Object objDLKHelper = ObjectHelper.Create((String)this.dataEntity.getDLKHELPER());
            if (objDLKHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u6570\u636e\u5bf9\u8c61\u9501\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)this.dataEntity.getDLKHELPER()));
                return false;
            }
            if (!(objDLKHelper instanceof IDEDataLockKeyHelper)) {
                log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u6570\u636e\u5bf9\u8c61\u9501\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.dataEntity.getDLKHELPER()));
                return false;
            }
            this.iDEDataLockKeyHelper = (IDEDataLockKeyHelper)objDLKHelper;
        }
        if (!this.PrepareDER()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u6570\u636e\u5173\u7cfb\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEDataCtrl()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u6570\u636e\u64cd\u4f5c\u914d\u7f6e\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        return true;
    }

    protected boolean Init2() {
        if (!this.PrepareDEACMode()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]AC\u586b\u5145\u6a21\u5f0f\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareToolTip()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u6570\u636e\u63d0\u793a\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEDataNotify()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u6570\u636e\u901a\u77e5\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEDataImport()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u6570\u636e\u5bfc\u5165\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEAction()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u64cd\u4f5c\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEWF()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u6d41\u7a0b\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEWizard()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u5411\u5bfc\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEPrintForm()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u6253\u5370\u8868\u5355\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEMobile()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u79fb\u52a8\u5e94\u7528\u914d\u7f6e\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEDataSync()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u6570\u636e\u540c\u6b65\u914d\u7f6e\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDERGroup()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u5173\u7cfb\u5206\u7ec4\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEMainAction()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u4e3b\u64cd\u4f5c\u914d\u7f6e\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        if (!this.PrepareDEMainState()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u4e3b\u72b6\u6001\u914d\u7f6e\u5931\u8d25", (Object)this.getId()));
            return false;
        }
        return true;
    }

    protected boolean OnGetDevelopMode() {
        return this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "DEVELOPMODE", this.bDevelopMode);
    }

    protected boolean IsDevelopMode() {
        return this.bDevelopMode;
    }

    private boolean i1() {
        return true;
    }

    private boolean i2() {
        return true;
    }

    private boolean i3() {
        return true;
    }

    @Override
    public final String getId() {
        return this.strId;
    }

    @Override
    public final String getName() {
        return this.strName;
    }

    @Override
    public final String getLogicName() {
        return this.getLogicName("");
    }

    @Override
    public final String getLogicName(String strLanguage) {
        String strKey = "";
        strKey = !StringHelper.IsNullOrEmpty((String)strLanguage) ? StringHelper.Format((String)"%1$s.%2$s", (Object)"DELOGICNAME", (Object)strLanguage.toUpperCase()) : "DELOGICNAME";
        return PropertiesHelper.GetProperty((Properties)this.deProperties, (String)strKey, (String)this.dataEntity.getDELOGICNAME());
    }

    @Override
    public final ISRFDAGlobalHelper getGlobalHelper() {
        return this.contextHelperEx;
    }

    @Override
    public final int getVersion() {
        return this.nDEVersion;
    }

    @Override
    public final String GetFullName() {
        return StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)this.getId(), (Object)this.getName(), (Object)this.getLogicName(""));
    }

    @Override
    public IDEFHelper GetDEFHelper(String strDEField) {
        CallResult callResult;
        this.PrepareDEFields();
        IDEFHelper iDEFHelper = this.OnGetDEFHelper(strDEField);
        if (iDEFHelper == null) {
            LoggerEx.warn((Log)log, (Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5c5e\u6027[%1$s]\u8f85\u52a9\u5904\u7406\u5bf9\u8c61", (Object)strDEField), null, null, (Object)this.getId());
            return null;
        }
        if (!iDEFHelper.IsInit() && (callResult = iDEFHelper.Init()).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25\uff0c\u539f\u56e0\uff1a%2$s", (Object)iDEFHelper.GetFullName(), (Object)callResult.getErrorInfo()));
            return null;
        }
        return iDEFHelper;
    }

    protected IDEFHelper OnGetDEFHelper(String strDEField) {
        if (this.defHelperMap.containsKey(strDEField = strDEField.toUpperCase())) {
            return this.defHelperMap.get(strDEField);
        }
        if (this.defHelperMapByName.containsKey(strDEField)) {
            return this.defHelperMapByName.get(strDEField);
        }
        return null;
    }

    @Override
    public IDEFHelper GetDEFHelper(DEField field) {
        return this.GetDEFHelper(field.getDEFID());
    }

    @Override
    public IPickupDEFHelper GetPickupDEFHelper(ILinkDEFHelper linkDEFHelper) {
        this.PrepareDEFields();
        for (IDEFHelper defHelper : this.defHelpers) {
            IPickupDEFHelper pickupDEFHelper;
            if (!(defHelper instanceof IPickupDEFHelper) || StringHelper.Compare((String)(pickupDEFHelper = (IPickupDEFHelper)defHelper).GetDERId(), (String)linkDEFHelper.GetDERId(), (boolean)true) != 0) continue;
            return pickupDEFHelper;
        }
        return null;
    }

    @Override
    public String GetPickupPageId() {
        return PropertiesHelper.GetProperty((Properties)this.deProperties, (String)"PICKUPPAGEID", (String)this.dataEntity.getPICKUPPAGEID());
    }

    @Override
    public String GetMPickupPageId() {
        return PropertiesHelper.GetProperty((Properties)this.deProperties, (String)"MPICKUPPAGEID", (String)this.dataEntity.getMPICKUPPAGEID());
    }

    @Override
    public String GetEditPageId() {
        return PropertiesHelper.GetProperty((Properties)this.deProperties, (String)"EDITPAGEID", (String)this.dataEntity.getEDITPAGEID());
    }

    @Override
    public String GetInfoPageId() {
        String strInfoPageId = PropertiesHelper.GetProperty((Properties)this.deProperties, (String)"INFOPAGEID", (String)this.dataEntity.getINFOPAGEID());
        if (StringHelper.IsNullOrEmpty((String)strInfoPageId)) {
            return this.GetEditPageId();
        }
        return strInfoPageId;
    }

    @Override
    public String GetGridPageId() {
        return PropertiesHelper.GetProperty((Properties)this.deProperties, (String)"GRIDPAGEID", (String)this.dataEntity.getGRIDPAGEID());
    }

    @Override
    @Deprecated
    public IDEFHelper GetKeyDEFHelper() {
        return this.getKeyDEFHelper();
    }

    @Override
    public IDEFHelper getKeyDEFHelper() {
        this.PrepareDEFields();
        return this.keyDEFHelper;
    }

    @Override
    @Deprecated
    public IDEFHelper GetMajorDEFHelper() {
        return this.getMajorDEFHelper();
    }

    public IDEFHelper getMajorDEFHelper() {
        this.PrepareDEFields();
        return this.majorDEFHelper;
    }

    @Override
    public IDEFHelper GetIndexTypeDEFHelper() {
        this.PrepareDEFields();
        return this.indexTypeDEFHelper;
    }

    @Override
    public IDEFHelper GetUpdateDateDEFHelper() {
        this.PrepareDEFields();
        return this.updateDateDEFHelper;
    }

    @Override
    public synchronized boolean PrepareDEFields(boolean bReset) {
        if (bReset) {
            this.defHelpers = null;
            this.defHelperMap = null;
            this.defHelperMapByName = null;
            this.preDefineFields = null;
        }
        return this.PrepareDEFields();
    }

    @Override
    public Vector<IDEFHelper> GetDEFHelpers() {
        this.PrepareDEFields();
        return this.defHelpers;
    }

    @Override
    public DataEntity getDataEntity() {
        return this.dataEntity;
    }

    private final synchronized boolean PrepareDEFields() {
        long nStartTick;
        block41: {
            CallResult callResult;
            block40: {
                Vector<DEField> defields;
                block39: {
                    if (this.defHelpers != null && this.defHelperMap != null && this.defHelperMapByName != null && this.preDefineFields != null) {
                        return true;
                    }
                    if (!this.Init2()) {
                        return false;
                    }
                    nStartTick = new Date().getTime();
                    log.debug((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u5c5e\u6027\u5f00\u59cb", (Object)this.dataEntity.getDEID()));
                    this.keyDEFHelper = null;
                    this.majorDEFHelper = null;
                    this.indexTypeDEFHelper = null;
                    this.caretTemplFields.clear();
                    this.bHasPhisicalFormulaField = false;
                    defields = new Vector<DEField>();
                    callResult = this.iDAModelHelper.GetDEFieldsNoSort(this.dataEntity.getDEID(), defields);
                    if (callResult != null && callResult.getRetCode() == 0) break block39;
                    log.error((Object)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5c5e\u6027\u96c6\u5408\u9519\u8bef");
                    return false;
                }
                Vector<DEField> normaldefields = new Vector<DEField>();
                Vector<DEField> pickupdefields = new Vector<DEField>();
                Vector<DEField> pickupdatadefields = new Vector<DEField>();
                for (DEField deField : defields) {
                    int nDEFType = deField.getDEFTYPE();
                    if (nDEFType == 2) {
                        normaldefields.add(deField);
                        continue;
                    }
                    String strDataType = deField.getDATATYPE();
                    if (StringHelper.Compare((String)strDataType, (String)"PICKUPDATA", (boolean)true) == 0 || StringHelper.Compare((String)strDataType, (String)"PICKUPTEXT", (boolean)true) == 0) {
                        pickupdatadefields.add(deField);
                        continue;
                    }
                    if (StringHelper.Compare((String)strDataType, (String)"PICKUP", (boolean)true) == 0) {
                        pickupdefields.add(deField);
                        continue;
                    }
                    normaldefields.add(deField);
                }
                this.defHelpers = new Vector();
                this.defHelperMap = new Hashtable();
                this.defHelperMapByName = new Hashtable();
                this.preDefineFields = new Hashtable();
                for (DEField deField : normaldefields) {
                    IDEFHelper iDEFHelper = this.CreateDEFHelper(deField);
                    if (iDEFHelper == null) continue;
                    this.defHelpers.add(iDEFHelper);
                    this.defHelperMap.put(deField.getDEFID().toUpperCase(), iDEFHelper);
                    this.defHelperMapByName.put(deField.getDEFNAME().toUpperCase(), iDEFHelper);
                }
                for (DEField deField : pickupdatadefields) {
                    IDEFHelper iDEFHelper = this.CreateDEFHelper(deField);
                    if (iDEFHelper == null) continue;
                    this.defHelpers.add(iDEFHelper);
                    this.defHelperMap.put(deField.getDEFID().toUpperCase(), iDEFHelper);
                    this.defHelperMapByName.put(deField.getDEFNAME().toUpperCase(), iDEFHelper);
                }
                for (DEField deField : pickupdefields) {
                    IDEFHelper iDEFHelper = this.CreateDEFHelper(deField);
                    if (iDEFHelper == null) continue;
                    this.defHelpers.add(iDEFHelper);
                    this.defHelperMap.put(deField.getDEFID().toUpperCase(), iDEFHelper);
                    this.defHelperMapByName.put(deField.getDEFNAME().toUpperCase(), iDEFHelper);
                }
                if (this.i2()) break block40;
                return false;
            }
            try {
                this.bEnablePwdStorage = false;
                this.pwdStorageFields = null;
                this.bEnableEncryptStorage = false;
                this.pwdStorageFields = null;
                this.strDGColumns = "";
                this.strSearchableColumns = "";
                for (IDEFHelper iDEFHelper : this.defHelpers) {
                    if (!iDEFHelper.IsInit() && (callResult = iDEFHelper.Init()).getRetCode() != 0) {
                        log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25\uff0c\u539f\u56e0\uff1a%2$s", (Object)iDEFHelper.GetFullName(), (Object)callResult.getErrorInfo()));
                        continue;
                    }
                    if (iDEFHelper.IsFormulaPhisical()) {
                        this.bHasPhisicalFormulaField = true;
                    }
                    if (iDEFHelper.IsKeyDEField()) {
                        this.keyDEFHelper = iDEFHelper;
                    }
                    if (iDEFHelper.IsMajorDEField()) {
                        this.majorDEFHelper = iDEFHelper;
                    }
                    if (iDEFHelper.IsIndexTypeDEField()) {
                        this.indexTypeDEFHelper = iDEFHelper;
                    }
                    if (this.IsExistingModel()) {
                        if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.getDEField().getPREDEFINETYPE())) {
                            this.preDefineFields.put(iDEFHelper.getDEField().getPREDEFINETYPE(), iDEFHelper.getId());
                            if (StringHelper.Compare((String)iDEFHelper.getDEField().getPREDEFINETYPE(), (String)"UPDATEDATE", (boolean)true) == 0) {
                                this.updateDateDEFHelper = iDEFHelper;
                            }
                        }
                    } else {
                        if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.getDEField().getPREDEFINETYPE())) {
                            this.preDefineFields.put(iDEFHelper.getDEField().getPREDEFINETYPE(), iDEFHelper.getId());
                        }
                        if (StringHelper.Compare((String)"UPDATEDATE", (String)iDEFHelper.getName(), (boolean)true) == 0) {
                            this.updateDateDEFHelper = iDEFHelper;
                        }
                    }
                    if (!iDEFHelper.getDGItem().isExclude()) {
                        if (!StringHelper.IsNullOrEmpty((String)this.strDGColumns)) {
                            this.strDGColumns = String.valueOf(this.strDGColumns) + ";";
                        }
                        this.strDGColumns = String.valueOf(this.strDGColumns) + iDEFHelper.getName();
                    }
                    if (!iDEFHelper.IsPhisicalDEField() && !iDEFHelper.IsFormulaPhisical() && iDEFHelper.GetSearchModel() != null && iDEFHelper.GetSearchModel().size() > 0) {
                        if (!StringHelper.IsNullOrEmpty((String)this.strSearchableColumns)) {
                            this.strSearchableColumns = String.valueOf(this.strSearchableColumns) + ";";
                        }
                        this.strSearchableColumns = String.valueOf(this.strSearchableColumns) + iDEFHelper.getName();
                    }
                    if (!StringHelper.IsNullOrEmpty((String)iDEFHelper.getCaretTemplGroupId()) && !StringHelper.IsNullOrEmpty((String)iDEFHelper.getCaretRetMode()) && StringHelper.Compare((String)iDEFHelper.getCaretRetMode(), (String)"NONE", (boolean)true) != 0) {
                        this.caretTemplFields.add(iDEFHelper);
                    }
                    if (iDEFHelper.getPwdStorage() != 0) {
                        this.bEnablePwdStorage = true;
                        if (this.pwdStorageFields == null) {
                            this.pwdStorageFields = new Vector();
                        }
                        this.pwdStorageFields.add(iDEFHelper);
                    }
                    if (iDEFHelper.getEncryptStorage() == 0) continue;
                    this.bEnableEncryptStorage = true;
                    if (this.encryptStorageFields == null) {
                        this.encryptStorageFields = new Vector();
                    }
                    this.encryptStorageFields.add(iDEFHelper);
                }
                if (!this.IsExistingModel()) {
                    this.preDefineFields.put("CREATEMAN", "CREATEMAN");
                    this.preDefineFields.put("CREATEDATE", "CREATEDATE");
                    this.preDefineFields.put("UPDATEMAN", "UPDATEMAN");
                    this.preDefineFields.put("UPDATEDATE", "UPDATEDATE");
                    this.preDefineFields.put("LOGICVALID", "ENABLE");
                }
                if (this.keyDEFHelper == null) {
                    log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b58\u5728\u952e\u503c\u5c5e\u6027\uff0c\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef!", (Object)this.GetFullName()));
                } else if (this.IsMajorDE()) {
                    this.strMajorDEKeyField = this.keyDEFHelper.getName();
                }
                if (this.majorDEFHelper == null) {
                    log.warn((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u5b58\u5728\u4e3b\u503c\u5c5e\u6027\uff0c\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef!", (Object)this.GetFullName()));
                }
                if (this.i3()) break block41;
                return false;
            }
            catch (Exception ex) {
                log.error((Object)"\u51c6\u5907\u5b9e\u4f53\u5c5e\u6027\u5931\u8d25", (Throwable)ex);
                return false;
            }
        }
        Collections.sort(this.defHelpers, defHelperComparator);
        log.debug((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f53[%1$s]\u5c5e\u6027\u7ed3\u675f\uff0c\u8017\u65f6[%2$s]", (Object)this.dataEntity.getDEID(), (Object)(new Date().getTime() - nStartTick)));
        return this.OnAfterPrepareDEFields();
    }

    protected boolean OnAfterPrepareDEFields() {
        String strDataAccObject = this.dataEntity.getDATAACCOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strDataAccObject)) {
            strDataAccObject = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "DATAACCHELPER", "SA.SRFDA.Security.DefaultDataAccHelper");
        }
        if (StringHelper.IsNullOrEmpty((String)strDataAccObject)) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u5bf9\u8c61"));
            return false;
        }
        Object objDataAccHelper = ObjectHelper.Create((String)strDataAccObject);
        if (objDataAccHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u5bf9\u8c61[%1$s]", (Object)strDataAccObject));
            return false;
        }
        if (!(objDataAccHelper instanceof IDataAccHelper)) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strDataAccObject));
            return false;
        }
        this.iDataCtrlHelper = (IDataAccHelper)objDataAccHelper;
        this.iDataCtrlHelper.Init(this.contextHelperEx, this);
        return true;
    }

    @Override
    public IDEFHelper CreateDEFHelper(DEField field) {
        if (!field.isVALIDFLAGNull() && !field.getVALIDFLAG()) {
            log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u65e0\u6548", (Object)field.getDEFID()));
            return null;
        }
        Object objHelper = this.GetDEFHelperObject(field);
        if (objHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]\u7684\u8f85\u52a9\u5bf9\u8c61", (Object)field.getDEFID()));
            return null;
        }
        String strObject = "";
        IDEFHelper iDEFHelper = null;
        DEFHelperConfig defHelperConfig = null;
        if (objHelper instanceof DEFHelperConfig) {
            defHelperConfig = (DEFHelperConfig)((Object)objHelper);
            strObject = defHelperConfig.getObject();
        } else if (objHelper instanceof IDEFHelper) {
            iDEFHelper = (IDEFHelper)objHelper;
        } else {
            strObject = objHelper.toString();
        }
        if (iDEFHelper == null) {
            if (StringHelper.Compare((String)strObject, (String)"SA.SRFDA.Ctrl.DEFHelper.BaseDEFHelper", (boolean)false) == 0) {
                iDEFHelper = new BaseDEFHelper();
            } else {
                Object obj = ObjectHelper.Create((String)strObject);
                if (obj == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61[%2$s]", (Object)field.getDEFID(), (Object)strObject));
                    return null;
                }
                if (!(obj instanceof IDEFHelper)) {
                    log.error((Object)StringHelper.Format((String)"\u5c5e\u6027[%1$s]\u8f85\u52a9\u5bf9\u8c61[%2$s]\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[IDEFHelper]", (Object)field.getDEFID(), (Object)strObject));
                    return null;
                }
                iDEFHelper = (IDEFHelper)obj;
            }
        }
        iDEFHelper.SetParam(this, field, defHelperConfig, this.contextHelperEx);
        return iDEFHelper;
    }

    protected Object GetDEFHelperObject(DEField field) {
        return BaseDEHelper.GetDEFHelperObject(this.contextHelperEx.getDAConfigMgr().getDEFHelperMgr(), field);
    }

    protected static Object GetDEFHelperObject(DEFHelperMgr defHelperMgr, DEField field) {
        String strDataType;
        String strDEFHelperId = field.getDEFHELPER();
        if (!StringHelper.IsNullOrEmpty((String)strDEFHelperId)) {
            return strDEFHelperId;
        }
        String strTag = StringHelper.Format((String)"[*:%1$s]", (Object)field.getDEFNAME());
        DEFHelperConfig defHelperConfig = defHelperMgr.FindDEFHelper(strTag);
        if (defHelperConfig != null) {
            return defHelperConfig;
        }
        String strDERType = DEField.ToDEFTypeString(field.getDEFTYPE());
        strTag = StringHelper.Format((String)"%1$s:%2$s", (Object)strDERType, (Object)(strDataType = field.getDATATYPE()));
        defHelperConfig = defHelperMgr.FindDEFHelper(strTag);
        if (defHelperConfig != null) {
            return defHelperConfig;
        }
        strTag = StringHelper.Format((String)"%1$s:*", (Object)strDERType);
        defHelperConfig = defHelperMgr.FindDEFHelper(strTag);
        if (defHelperConfig != null) {
            return defHelperConfig;
        }
        strTag = StringHelper.Format((String)"*:%1$s", (Object)strDataType);
        defHelperConfig = defHelperMgr.FindDEFHelper(strTag);
        if (defHelperConfig != null) {
            return defHelperConfig;
        }
        strTag = StringHelper.Format((String)"*:*");
        defHelperConfig = defHelperMgr.FindDEFHelper(strTag);
        if (defHelperConfig != null) {
            return defHelperConfig;
        }
        return new BaseDEFHelper();
    }

    @Override
    public String GetDEViewName() {
        String strViewName = this.dataEntity.getVIEWNAME();
        if (StringHelper.IsNullOrEmpty((String)strViewName)) {
            strViewName = StringHelper.Format((String)"v_%1$s", (Object)this.dataEntity.getDENAME());
        }
        strViewName = strViewName.toUpperCase();
        return strViewName;
    }

    public String GetDraftInsertProcName() {
        return StringHelper.Format((String)"%1$s%2$s_DINSERT_V%3$s", (Object)this.strProcPreFix, (Object)this.getDataEntity().getDENAME(), (Object)this.OnGetDBVersion());
    }

    @Override
    public String GetInsertProcName() {
        return StringHelper.Format((String)"%1$s%2$s_INSERT_V%3$s", (Object)this.strProcPreFix, (Object)this.getDataEntity().getDENAME(), (Object)this.OnGetDBVersion());
    }

    @Override
    public String GetUpdateProcName() {
        return StringHelper.Format((String)"%1$s%2$s_UPDATE_V%3$s", (Object)this.strProcPreFix, (Object)this.getDataEntity().getDENAME(), (Object)this.OnGetDBVersion());
    }

    @Override
    public String GetDeleteProcName() {
        return StringHelper.Format((String)"%1$s%2$s_DELETE_V%3$s", (Object)this.strProcPreFix, (Object)this.getDataEntity().getDENAME(), (Object)this.OnGetDBVersion());
    }

    protected int OnGetDBVersion() {
        if (this.getDataEntity().isDBVERSIONNull()) {
            return this.getDataEntity().getDEVERSION();
        }
        return this.getDataEntity().getDBVERSION();
    }

    public String GetDraftInsertProcCode() {
        return "";
    }

    @Override
    public String GetInsertProcCode() {
        return "";
    }

    @Override
    public String GetUpdateProcCode() {
        return "";
    }

    @Override
    public String GetDeleteProcCode() {
        return "";
    }

    @Override
    public String GetSelectCode(Vector<ProcParam> procParams) {
        return "";
    }

    @Override
    public String GetCheckKeyCode(Vector<ProcParam> procParams) {
        return "";
    }

    @Override
    public String GetSelectCode(BaseDataEntity dataEntity, Vector<ProcParam> procParams) {
        return "";
    }

    @Override
    public String GetSelectCode(String strActionMode, ISRFDAWebContext iWebContext, BaseDataEntity dataEntity, Vector<CallParam> params) {
        if (!this.bInitselectQueryModel && !this.PrepareSelectQueryModel()) {
            log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u67e5\u8be2\u6a21\u5f0f\u5931\u8d25"));
            return "";
        }
        if (StringHelper.IsNullOrEmpty((String)strActionMode)) {
            log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u67e5\u8be2\u6a21\u5f0f"));
            return "";
        }
        if (this.selectQueryModelHelperMap == null) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u63d0\u4f9b\u67e5\u8be2\u6a21\u5f0f[%2$s]", (Object)this.getId(), (Object)strActionMode));
            return "";
        }
        if (this.selectQueryModelHelperMap.containsKey(strActionMode = strActionMode.toUpperCase())) {
            SelectQueryModel selectQueryMode = this.selectQueryModelHelperMap.get(strActionMode);
            selectQueryMode.baseDAQueryModelHelper.FillQMDeclareParams(params, iWebContext, this.contextHelperEx, "", dataEntity);
            selectQueryMode.baseDAQueryModelHelper.FillCallParams(params, iWebContext, this.contextHelperEx, "", dataEntity);
            return selectQueryMode.strSelectCode;
        }
        log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u6ca1\u6709\u63d0\u4f9b\u67e5\u8be2\u6a21\u5f0f[%2$s]", (Object)this.getId(), (Object)strActionMode));
        return "";
    }

    @Override
    public IDEDataCtrl GetDEDataCtrl(String strCurOpPersonId, ISRFDAWebContext webContext) {
        String strDataCtrl = this.GetDataCtrlObject();
        Object obj = ObjectHelper.Create((String)strDataCtrl);
        if (obj == null || !(obj instanceof IDEDataCtrl)) {
            return null;
        }
        IDEDataCtrl iDEDataCtrl = (IDEDataCtrl)obj;
        if (StringHelper.IsNullOrEmpty((String)strCurOpPersonId) && webContext != null) {
            strCurOpPersonId = webContext.getCurUserId();
        }
        iDEDataCtrl.Init(this, this.contextHelperEx, strCurOpPersonId, webContext);
        return iDEDataCtrl;
    }

    protected String GetDataCtrlObject() {
        if (!this.bCalcDataCtrlObject) {
            this.strDataCtrlObject = this.OnGetDataCtrlObject();
            this.bCalcDataCtrlObject = true;
        }
        return this.strDataCtrlObject;
    }

    protected String OnGetDataCtrlObject() {
        String strKey = StringHelper.Format((String)"%2$s.%1$s", (Object)this.contextHelperEx.getDAModelDB(), (Object)"DATACTRLOBJECT");
        String strObject = this.GetProperty(strKey, this.dataEntity.getDATACTRLOBJECT());
        if (!StringHelper.IsNullOrEmpty((String)strObject)) {
            return strObject;
        }
        strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)this.contextHelperEx.getDAModelDB(), (Object)"DATACTRLOBJECT");
        strObject = this.GetProperty(strKey, this.dataEntity.getDATACTRLOBJECT());
        if (!StringHelper.IsNullOrEmpty((String)strObject)) {
            return strObject;
        }
        if (!StringHelper.IsNullOrEmpty((String)this.GetDBStorage()) && !StringHelper.IsNullOrEmpty((String)(strObject = this.contextHelperEx.getDAModelStorage().FindDBStorage(this.GetDBStorage()).GetProperty("DEDATACTRL")))) {
            return strObject;
        }
        return this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "DEDATACTRL", "");
    }

    @Override
    public String GetDataInfo(BaseDataEntity dataEntity) {
        Object[] valueObj;
        String strInfoFormat;
        block14: {
            String strInfoFields;
            block13: {
                if (this.bNoDataInfo) {
                    return "";
                }
                strInfoFields = this.GetInfoFields();
                strInfoFormat = this.GetInfoFormat();
                if (StringHelper.IsNullOrEmpty((String)strInfoFormat)) {
                    strInfoFormat = "%1$s";
                }
                valueObj = null;
                if (!StringHelper.IsNullOrEmpty((String)strInfoFields)) break block13;
                String strMajorDEFName = this.majorDEFHelper.getName();
                if (StringHelper.IsNullOrEmpty((String)strMajorDEFName)) break block14;
                valueObj = new Object[]{dataEntity.GetParamValue(strMajorDEFName)};
                String strCodeListId = this.majorDEFHelper.GetCodeList();
                if (StringHelper.IsNullOrEmpty((String)strCodeListId)) break block14;
                CodeListConfig codeListConfig = this.contextHelperEx.getCodeListMgr().GetCodeListConfig(strCodeListId);
                if (codeListConfig == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]", (Object)strCodeListId));
                } else {
                    String strCodeListValue = "";
                    if (valueObj[0] != null) {
                        strCodeListValue = valueObj[0].toString();
                    }
                    valueObj[0] = codeListConfig.GetCodeListValue(strCodeListValue, true);
                }
                break block14;
            }
            strInfoFields = strInfoFields.replace(";", "|");
            String[] parts = strInfoFields.split("[|]");
            valueObj = new Object[parts.length];
            int i = 0;
            while (i < parts.length) {
                String strCodeListId;
                String strParam = parts[i];
                strParam = strParam.trim();
                valueObj[i] = dataEntity.GetParamValue(strParam);
                IDEFHelper iDEFHelper = this.GetDEFHelper(strParam);
                if (iDEFHelper != null && !StringHelper.IsNullOrEmpty((String)(strCodeListId = iDEFHelper.GetCodeList()))) {
                    CodeListConfig codeListConfig = this.contextHelperEx.getCodeListMgr().GetCodeListConfig(strCodeListId);
                    if (codeListConfig == null) {
                        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]", (Object)strCodeListId));
                    } else {
                        String strCodeListValue = "";
                        if (valueObj[i] != null) {
                            strCodeListValue = valueObj[i].toString();
                        }
                        valueObj[i] = codeListConfig.GetCodeListValue(strCodeListValue, true);
                    }
                }
                ++i;
            }
        }
        try {
            return StringHelper.Format((String)strInfoFormat, (Object[])valueObj);
        }
        catch (Exception ex) {
            String strMajorDEFName = this.majorDEFHelper.getName();
            if (!StringHelper.IsNullOrEmpty((String)strMajorDEFName)) {
                valueObj = new Object[]{dataEntity.GetParamValue(strMajorDEFName)};
                return StringHelper.Format((String)"%1$s", (Object[])valueObj);
            }
            return "";
        }
    }

    @Override
    public String GetToolTip(BaseDataEntity dataEntity, ISRFDAWebContext webContext, String strOPPersonId) {
        if (this.iDEToolTipHelper != null) {
            return this.iDEToolTipHelper.GetInfo(dataEntity, webContext, strOPPersonId);
        }
        if (this.toolTipTemplate != null) {
            Hashtable<String, Object> params = new Hashtable<String, Object>();
            MacroHelper.FillMacroParams(params, webContext, this.contextHelperEx, strOPPersonId, this, dataEntity, webContext != null ? webContext.getLocalization() : "");
            StringWriter sw = new StringWriter();
            try {
                this.toolTipTemplate.process(params, (Writer)sw);
            }
            catch (TemplateException e) {
                e.printStackTrace();
                return "";
            }
            catch (IOException e) {
                e.printStackTrace();
                return "";
            }
            return sw.toString();
        }
        return this.GetDataInfo(dataEntity);
    }

    @Override
    public String GetInfoFormat() {
        return PropertiesHelper.GetProperty((Properties)this.deProperties, (String)"INFOFORMAT", (String)this.dataEntity.getINFOFORMAT());
    }

    @Override
    public String GetInfoFields() {
        return PropertiesHelper.GetProperty((Properties)this.deProperties, (String)"INFOFIELD", (String)this.dataEntity.getINFOFIELD());
    }

    @Override
    public String GetMainTable() {
        return this.dataEntity.getTABLENAME();
    }

    @Override
    public String GetUserTable() {
        return this.dataEntity.getEXTABLENAME();
    }

    @Override
    public boolean IsLogicValid() {
        return this.dataEntity.isLOGICVALID();
    }

    @Override
    public IPickupDEFHelper FindPickupDEFHelper(String strDERId) {
        for (IDEFHelper iDEFHelper : this.defHelpers) {
            IPickupDEFHelper pickupDEFHelper;
            if (!(iDEFHelper instanceof IPickupDEFHelper) || StringHelper.Compare((String)(pickupDEFHelper = (IPickupDEFHelper)iDEFHelper).GetDERId(), (String)strDERId, (boolean)true) != 0) continue;
            return pickupDEFHelper;
        }
        return null;
    }

    @Override
    public String GetTableSpace() {
        return this.dataEntity.getTABLESPACE();
    }

    @Override
    public boolean IsSupportFA() {
        return this.dataEntity.isSUPPORTFA();
    }

    @Override
    public boolean IsIndexDE() {
        return this.dataEntity.isINDEXDE();
    }

    @Override
    public boolean IsDER11DE() {
        return !StringHelper.IsNullOrEmpty((String)this.dataEntity.getDER11DEID());
    }

    @Override
    public boolean IsEnableWF() {
        return this.dataEntity.isENABLEWF();
    }

    @Override
    public boolean IsEnableDP() {
        return this.dataEntity.isENABLEDP();
    }

    @Override
    public DEWF GetDEWF() {
        try {
            return this.GetDEWFHelper().getData();
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
    }

    @Override
    public IDEWFHelper GetDEWFHelper() throws Exception {
        if (!this.IsEnableWF()) {
            throw new Exception("\u5f53\u524d\u5b9e\u4f53\u4e0d\u652f\u6301\u5de5\u4f5c\u6d41");
        }
        return this.iDEWFHelper;
    }

    @Override
    public String GetDEWFId(String strWFMode) {
        DEWF deWF = this.GetDEWF();
        if (deWF == null) {
            return "";
        }
        if (StringHelper.IsNullOrEmpty((String)strWFMode)) {
            return deWF.getWFID();
        }
        if (this.deWFMap.containsKey(strWFMode = strWFMode.toUpperCase())) {
            return this.deWFMap.get(strWFMode);
        }
        DEWFDetail deWFDetail = new DEWFDetail();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEWFDetail(this.getId(), strWFMode, deWFDetail);
        if (callResult.getRetCode() != 0 && callResult.getRetCode() != 3) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6a21\u5f0f[%2$s]\u5de5\u4f5c\u6d41\u660e\u7ec6\u5931\u8d25\uff0c%3$s", (Object)this.getId(), (Object)strWFMode, (Object)callResult.getErrorInfo()));
            return "";
        }
        String strWFId = "";
        if (callResult.getRetCode() != 3) {
            strWFId = deWFDetail.getWFID();
            IDEWFDetailHelper deWFDetailHelper = this.OnCreateDEWFDetailHelper(deWFDetail);
            if (deWFDetailHelper != null) {
                try {
                    deWFDetailHelper.Init(this.contextHelperEx, this, deWFDetail);
                    this.deWFDetailMap.put(strWFMode, deWFDetailHelper);
                }
                catch (Exception e) {
                    log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u6d41\u7a0b\u591a\u6a21\u5f0f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
                }
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strWFId)) {
            strWFId = deWF.getWFID();
        }
        this.deWFMap.put(strWFMode, strWFId);
        return strWFId;
    }

    @Override
    public IDataAccHelper GetDataAccHelper() {
        return this.iDataCtrlHelper;
    }

    @Override
    public String GetMajorDEId() {
        return this.strMajorDEId;
    }

    @Override
    public String GetMajorDERId() {
        return this.strMajorDERId;
    }

    @Override
    public String GetMajorDERType() {
        return this.strMajorDERType;
    }

    @Override
    public String GetMajorDEPickupField() {
        return this.strMajorDEKeyField;
    }

    @Override
    public IDEHelper GetMajorDEHelper() {
        if (StringHelper.Compare((String)this.strMajorDEId, (String)this.getId(), (boolean)true) == 0) {
            return this;
        }
        return this.contextHelperEx.getDAModelStorage().FindDEHelper(this.strMajorDEId);
    }

    @Override
    public boolean IsEnableAudit() {
        return this.dataEntity.isENABLEAUDIT();
    }

    @Override
    public boolean IsLogAuditDetail() {
        return this.dataEntity.getLOGAUDITDETAIL();
    }

    @Override
    public boolean IsInheritMode() {
        return this.dataEntity.isINHERITMODE();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IDEHelper GetInheritDEHelper() {
        if (this.IsInheritMode()) {
            Object object = this.inheritDEHelperLock;
            synchronized (object) {
                if (this.inheritDEHelper != null) {
                    int nVersion = this.contextHelperEx.getDAModelStorage().GetDAModelVersion("DE0001", this.strInheritDEId);
                    if (this.inheritDEHelper.getVersion() == nVersion) {
                        return this.inheritDEHelper;
                    }
                }
                if (!StringHelper.IsNullOrEmpty((String)this.strInheritDEId)) {
                    this.inheritDEHelper = this.contextHelperEx.getDAModelStorage().FindDEHelper(this.strInheritDEId, false);
                    return this.inheritDEHelper;
                }
            }
        }
        return null;
    }

    @Override
    public String GetInheritDERId() {
        return this.strInheritDERId;
    }

    @Override
    public DERINDEX GetInheritDER() throws Exception {
        if (this.inheritDERIndex == null) {
            throw new Exception("\u7ee7\u627f\u5173\u7cfb\u5bf9\u8c61\u65e0\u6548");
        }
        return this.inheritDERIndex;
    }

    @Override
    public boolean IsInheritDEField(IDEFHelper iDEFHelper) {
        if (!this.IsInheritMode()) {
            return false;
        }
        if (this.GetDEFHelper(iDEFHelper.getName()) != null) {
            return false;
        }
        if (this.ingoreInheritDEFMap == null) {
            return true;
        }
        return !this.ingoreInheritDEFMap.containsKey(iDEFHelper.getName());
    }

    @Override
    public boolean IsContainDEField(String strDEField) {
        this.PrepareDEFields();
        strDEField = strDEField.toUpperCase();
        if (this.defHelperMap.containsKey(strDEField)) {
            return true;
        }
        return this.defHelperMapByName.containsKey(strDEField);
    }

    @Override
    public String GetDBStorage() {
        return this.dataEntity.getDBSTORAGE();
    }

    @Override
    public String GetProperty(String strPropertyName) {
        strPropertyName = strPropertyName.toUpperCase();
        String strDefaultValue = "";
        if (defProperties.containsKey(strPropertyName)) {
            strDefaultValue = defProperties.get(strPropertyName);
        }
        return PropertiesHelper.GetProperty((Properties)this.deProperties, (String)strPropertyName, (String)strDefaultValue);
    }

    @Override
    public String GetProperty(String strPropertyName, String strDefaultValue) {
        Object objValue = this.dePropertiesCache.get(strPropertyName = strPropertyName.toUpperCase());
        if (objValue != null && objValue instanceof String) {
            return (String)objValue;
        }
        String strValue = PropertiesHelper.GetProperty((Properties)this.deProperties, (String)strPropertyName, (String)strDefaultValue);
        if (strValue != null) {
            this.dePropertiesCache.put(strPropertyName, strValue);
        }
        return strValue;
    }

    public void SetProperty(String strPropertyName, Object objValue) {
        strPropertyName = strPropertyName.toUpperCase();
        if (objValue == null) {
            this.dePropertiesCache.remove(strPropertyName);
        } else {
            this.dePropertiesCache.put(strPropertyName, objValue);
        }
    }

    @Override
    public boolean GetProperty(String strPropertyName, boolean bDefault) {
        Object objValue = this.dePropertiesCache.get(strPropertyName = strPropertyName.toUpperCase());
        if (objValue != null && objValue instanceof Boolean) {
            return (Boolean)objValue;
        }
        Boolean bValue = this.InternalGetProperty(strPropertyName, bDefault);
        this.dePropertiesCache.put(strPropertyName, bValue);
        return bValue;
    }

    private boolean InternalGetProperty(String strPropertyName, boolean bDefault) {
        String strValue = this.GetProperty(strPropertyName);
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return bDefault;
        }
        return Boolean.parseBoolean(strValue);
    }

    @Override
    public int GetProperty(String strPropertyName, int nDefault) {
        Object objValue = this.dePropertiesCache.get(strPropertyName = strPropertyName.toUpperCase());
        if (objValue != null && objValue instanceof Integer) {
            return (Integer)objValue;
        }
        Integer nValue = this.InternalGetProperty(strPropertyName, nDefault);
        this.dePropertiesCache.put(strPropertyName, nValue);
        return nValue;
    }

    private int InternalGetProperty(String strPropertyName, int nDefault) {
        String strValue = this.GetProperty(strPropertyName);
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return nDefault;
        }
        return Integer.parseInt(strValue);
    }

    @Override
    public boolean IsExistingModel() {
        return this.dataEntity.isEXITINGMODEL();
    }

    @Override
    public boolean IsEnableUserCreate() {
        return (this.dataEntity.getUSERACTION() & 1) == 0;
    }

    @Override
    public boolean IsEnableUserUpdate() {
        return (this.dataEntity.getUSERACTION() & 2) == 0;
    }

    @Override
    public boolean IsEnableUserView() {
        if (this.IsEnableUserUpdate()) {
            return true;
        }
        return (this.dataEntity.getUSERACTION() & 8) == 0;
    }

    @Override
    public boolean IsEnableUserDelete() {
        return (this.dataEntity.getUSERACTION() & 4) == 0;
    }

    @Override
    public IDEFHelper GetDEFHelperByPreDefineType(String strPreDefineType) {
        if (this.preDefineFields == null) {
            return null;
        }
        if (this.preDefineFields.containsKey(strPreDefineType)) {
            return this.GetDEFHelper(this.preDefineFields.get(strPreDefineType));
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IDAConfigHelper GetDAConfigHelper(String strLanguage, String strPageModel) {
        String strKey = StringHelper.Format((String)"%1$s|%2$s", (Object)strLanguage, (Object)strPageModel);
        if (this.daConfigHelperMap != null) {
            Hashtable<String, IDAConfigHelper> hashtable = this.daConfigHelperMap;
            synchronized (hashtable) {
                if (this.daConfigHelperMap.containsKey(strKey)) {
                    return this.daConfigHelperMap.get(strKey);
                }
            }
            Object objDAConfigHelper = ObjectHelper.Create((String)this.strDAConfigHelperObject);
            if (objDAConfigHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5b9e\u4f53\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)this.strDAConfigHelperObject));
                return null;
            }
            if (!(objDAConfigHelper instanceof IDAConfigHelper)) {
                log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53\u914d\u7f6e\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.strDAConfigHelperObject));
                return null;
            }
            IDAConfigHelper iDAConfigHelper = (IDAConfigHelper)objDAConfigHelper;
            iDAConfigHelper.Init(this.contextHelperEx, strLanguage, strPageModel);
            Hashtable<String, IDAConfigHelper> hashtable2 = this.daConfigHelperMap;
            synchronized (hashtable2) {
                this.daConfigHelperMap.put(strKey, iDAConfigHelper);
            }
            return iDAConfigHelper;
        }
        return this.contextHelperEx.getDAConfigHelper(strLanguage, strPageModel);
    }

    @Override
    public IDAMBConfigHelper GetDAMBConfigHelper(String strLanguage, String strPageModel) throws Exception {
        return this.contextHelperEx.getDAMBConfigHelper(strLanguage, strPageModel);
    }

    @Override
    public String GetDBType() {
        return this.OnGetDBType();
    }

    protected String OnGetDBType() {
        return "UNKNOWN";
    }

    protected boolean PrepareDER() {
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDERINDEXs(false, this.getId(), this.derIndexList2);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
            return false;
        }
        for (DERINDEX derIndex : this.derIndexList2) {
            this.derMap.put("DERINDEX:" + derIndex.getDERINDEXID().toUpperCase(), derIndex);
            if (!derIndex.isINHERITMODE() || !this.IsInheritMode()) continue;
            this.strInheritDERId = derIndex.getDERINDEXID();
            this.strInheritDEId = derIndex.getINDEXDEID();
            this.strInheritTypeValue = derIndex.getTYPEVALUE();
            this.inheritDERIndex = derIndex;
            String strIgnoreInherit = this.inheritDERIndex.getIGNOREINHERIT();
            if (!StringHelper.IsNullOrEmpty((String)strIgnoreInherit)) {
                if (this.ingoreInheritDEFMap != null) {
                    this.ingoreInheritDEFMap = null;
                }
                this.ingoreInheritDEFMap = new Hashtable();
                String[] ignoreFields = strIgnoreInherit.split("[;]");
                int j = 0;
                while (j < ignoreFields.length) {
                    String strIgnoreField = ignoreFields[j];
                    if (!StringHelper.IsNullOrEmpty((String)(strIgnoreField = strIgnoreField.trim()))) {
                        this.ingoreInheritDEFMap.put(strIgnoreField.toUpperCase(), "");
                    }
                    ++j;
                }
            }
            log.info((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u7ee7\u627f[%2$s][%3$s][%4$s]", (Object)this.getId(), (Object)this.strInheritDEId, (Object)this.strInheritDERId, (Object)this.strInheritTypeValue));
        }
        callResult = this.contextHelperEx.getDAModelHelper().GetDER1Ns(this.getId(), this.der1nList);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%2$s]\u5173\u7cfb1:N\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo()), (Object)this.getId()));
            return false;
        }
        try {
            for (DER1N der1N : this.der1nList) {
                DER1NHelper der1NHelper = new DER1NHelper();
                der1NHelper.Init(this.getGlobalHelper(), der1N);
                this.der1NHelperList.add(der1NHelper);
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5b9e\u4f53\u5173\u7cfb1:N\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return false;
        }
        callResult = this.contextHelperEx.getDAModelHelper().GetDERN1s(this.getId(), this.der1nList2);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfbN:1\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
            return false;
        }
        if (this.getDataEntity().getDETYPE() == 2) {
            for (DER1N der1n : this.der1nList2) {
                if ((der1n.getDERSUBTYPE() & 2) == 0) continue;
                if (StringHelper.IsNullOrEmpty((String)this.strMajorDEId)) {
                    this.strMajorDEId = der1n.getMAJORDEID();
                    this.strMajorDEKeyField = der1n.getMAJORKEYDEFNAME();
                    this.strMajorDERId = der1n.getDERID();
                    this.strMajorDERType = "N1";
                }
                if (!this.IsMultiMajorDE()) break;
                this.multiMajorDERMap.put(der1n.getMAJORKEYDEFNAME().toUpperCase(), der1n);
            }
        }
        if (StringHelper.IsNullOrEmpty((String)this.strMajorDEId)) {
            this.strMajorDEId = this.getId();
            this.bMajorDE = true;
        } else {
            this.bMajorDE = false;
        }
        callResult = this.contextHelperEx.getDAModelHelper().GetDERCUSTOMs(true, this.getId(), this.derCustomList);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%2$s]\u81ea\u5b9a\u4e49\u5173\u7cfb\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo()), (Object)this.getId()));
            return false;
        }
        callResult = this.contextHelperEx.getDAModelHelper().GetDERCUSTOMs(false, this.getId(), this.derCustomList2);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u81ea\u5b9a\u4e49\u5173\u7cfb\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
            return false;
        }
        callResult = this.contextHelperEx.getDAModelHelper().GetDER11s(true, this.getId(), this.der11List);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5173\u7cfb1:1\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
            return false;
        }
        Vector<DER1NEx> list = new Vector<DER1NEx>();
        callResult = this.contextHelperEx.getDAModelHelper().GetDER1NExs(this.getId(), list);
        if (callResult.IsOk()) {
            try {
                for (DER1NEx dER1NEx : list) {
                    DER1NExHelper der1NExHelper = new DER1NExHelper();
                    der1NExHelper.Init(this.getGlobalHelper(), dER1NEx);
                    this.derHelperMap.put("DER1NEX:" + der1NExHelper.getDER1NId().toUpperCase(), der1NExHelper);
                }
            }
            catch (Exception exception) {
                log.error((Object)StringHelper.Format((String)"\u51c6\u5907\u5b9e\u4f531:N\u5173\u7cfb\u6269\u5c55\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                return false;
            }
        } else {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f531:N\u5173\u7cfb\u6269\u5c55\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        try {
            for (DER11 dER11 : this.der11List) {
                DER11Helper der11Helper = new DER11Helper();
                der11Helper.Init(this.getGlobalHelper(), dER11);
                this.der11HelperList.add(der11Helper);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5b9e\u4f53\u5173\u7cfb1:1\u8f85\u52a9\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            return false;
        }
        if (this.IsIndexDE() && ((callResult = this.contextHelperEx.getDAModelHelper().GetDERINDEXs(true, this.getId(), this.derIndexList)) == null || callResult.getRetCode() != 0)) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u7d22\u5f15\u5b9e\u4f53\u7d22\u5f15\u5173\u7cfb\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
            return false;
        }
        for (DER1N dER1N : this.der1nList) {
            this.derMap.put("DER1N:" + dER1N.getDERID().toUpperCase(), dER1N);
        }
        for (IDER1NHelper iDER1NHelper : this.der1NHelperList) {
            this.derHelperMap.put("DER1N:" + iDER1NHelper.getId().toUpperCase(), iDER1NHelper);
        }
        for (DER1N dER1N : this.der1nList2) {
            this.derMap.put("DER1N:" + dER1N.getDERID().toUpperCase(), dER1N);
        }
        for (DER11 dER11 : this.der11List) {
            this.derMap.put("DER11:" + dER11.getDERID().toUpperCase(), dER11);
        }
        for (IDER11Helper iDER11Helper : this.der11HelperList) {
            this.derHelperMap.put("DER11:" + iDER11Helper.getId().toUpperCase(), iDER11Helper);
        }
        for (DERINDEX dERINDEX : this.derIndexList) {
            this.derMap.put("DERINDEX:" + dERINDEX.getDERINDEXID().toUpperCase(), dERINDEX);
        }
        for (DERCUSTOM dERCUSTOM : this.derCustomList) {
            this.derMap.put("DERCUSTOM:" + dERCUSTOM.getCUSTOMDERID().toUpperCase(), dERCUSTOM);
        }
        return true;
    }

    protected boolean PrepareDEDataNotify() {
        if (this.getGlobalHelper().getDataNotifyHelper() == null) {
            return true;
        }
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEDataNotifies(this.getId(), this.dataNotifies);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u914d\u7f6e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u6570\u636e\u901a\u77e5\u903b\u8f91\u6570\u91cf[%2$s]", (Object)this.getId(), (Object)this.dataNotifies.size()));
        if (!StringHelper.IsNullOrEmpty((String)this.dataEntity.getDATANOTIFYHELPER())) {
            IDataNotifyHelper iDataNotifyHelper = (IDataNotifyHelper)ObjectHelper.Create((String)this.dataEntity.getDATANOTIFYHELPER());
            this.dataNotifyHelperMap.put("", iDataNotifyHelper);
        } else {
            this.dataNotifyHelperMap.put("", this.getGlobalHelper().getDataNotifyHelper());
        }
        for (DataNotify dataNotify : this.dataNotifies) {
            dataNotify.InitDataNotify();
            if (StringHelper.IsNullOrEmpty((String)dataNotify.getHELPEROBJECT())) continue;
            IDataNotifyHelper iDataNotifyHelper = (IDataNotifyHelper)ObjectHelper.Create((String)dataNotify.getHELPEROBJECT());
            this.dataNotifyHelperMap.put(dataNotify.getDATANOTIFYID(), iDataNotifyHelper);
        }
        return true;
    }

    @Override
    public boolean HasDataNotify() {
        return this.dataNotifies.size() != 0;
    }

    @Override
    public boolean HasDataNotify(int nEventType, boolean bAsyncMode) {
        for (DataNotify dataNotify : this.dataNotifies) {
            if (dataNotify.getASYNCMODE() != bAsyncMode || (dataNotify.getEVENTTYPE() & nEventType) == 0) continue;
            return true;
        }
        return false;
    }

    @Override
    public void ListDataNotifies(int nEventType, boolean bAsyncMode, Vector<DataNotify> list) {
        for (DataNotify dataNotify : this.dataNotifies) {
            if (dataNotify.getASYNCMODE() != bAsyncMode || (dataNotify.getEVENTTYPE() & nEventType) == 0) continue;
            list.add(dataNotify);
        }
    }

    @Override
    public Vector<DataNotify> GetDataNotifies() {
        return this.dataNotifies;
    }

    protected boolean PrepareDEDataCtrl() {
        Vector<DEDataCtrl> list = new Vector<DEDataCtrl>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEDataCtrls(this.getId(), list);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u914d\u7f6e\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u5904\u7406\u903b\u8f91\u6570\u91cf[%2$s]", (Object)this.getId(), (Object)list.size()));
        if (list.size() > 0) {
            this.deDataCtrlMap = new Hashtable();
            for (DEDataCtrl deDataCtrl : list) {
                if (deDataCtrl.getDEDCConfig() == null) continue;
                String strDEDataCtrlId = StringHelper.Format((String)"%1$s:%2$s", (Object)deDataCtrl.getDCSTEP(), (Object)deDataCtrl.getACTIONMODE());
                strDEDataCtrlId = strDEDataCtrlId.toUpperCase();
                boolean bLoadOk = true;
                Iterator iterator = deDataCtrl.getDEDCConfig().getProcessesConfig().iterator();
                while (iterator.hasNext()) {
                    DEDCBaseProcessConfig processConfig = (DEDCBaseProcessConfig)((Object)iterator.next());
                    if (StringHelper.IsNullOrEmpty((String)processConfig.getProcessConfigId())) continue;
                    DEDCProcess dedcProcess = new DEDCProcess();
                    callResult = this.contextHelperEx.getDAModelHelper().GetDEDCProcess(processConfig.getProcessConfigId(), dedcProcess);
                    if (callResult.IsError()) {
                        log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5904\u7406[%1$s]\u5931\u8d25\uff0c%2$s", (Object)processConfig.getProcessConfigId(), (Object)callResult.getErrorInfo()));
                        bLoadOk = false;
                        break;
                    }
                    processConfig.setDEDCProcess(dedcProcess);
                }
                if (!bLoadOk) {
                    log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u5904\u7406\u903b\u8f91[%3$s][%2$s]\u5931\u8d25!", (Object)this.getId(), (Object)strDEDataCtrlId, (Object)deDataCtrl.getDEDATACTRLNAME()));
                    continue;
                }
                log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u5904\u7406\u903b\u8f91[%3$s][%2$s]", (Object)this.getId(), (Object)strDEDataCtrlId, (Object)deDataCtrl.getDEDATACTRLNAME()));
                Vector<DEDataCtrl> deDataCtrls = this.deDataCtrlMap.get(strDEDataCtrlId);
                if (deDataCtrls == null) {
                    deDataCtrls = new Vector();
                    this.deDataCtrlMap.put(strDEDataCtrlId, deDataCtrls);
                }
                deDataCtrls.add(deDataCtrl);
            }
        }
        return true;
    }

    protected boolean PrepareDEACMode() {
        Vector<DEACMode> list = new Vector<DEACMode>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEACModes(this.getId(), list);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u586b\u5145\u6a21\u5f0f\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        if (list.size() > 0) {
            this.deACModeMap = new Hashtable();
            for (DEACMode acMode : list) {
                this.deACModeMap.put(acMode.getDEACMODENAME().toUpperCase(), acMode);
            }
            for (DEACMode acMode : list) {
                String strDEACModeId = acMode.getDEACMODEID().toUpperCase();
                if (this.deACModeMap.containsKey(strDEACModeId)) continue;
                this.deACModeMap.put(strDEACModeId, acMode);
            }
        }
        return true;
    }

    protected boolean PrepareDEDataImport() {
        Vector<DEDataImport> list = new Vector<DEDataImport>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEDataImports(this.getId(), list);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u6570\u636e\u5bfc\u5165\u903b\u8f91\u6570\u91cf[%2$s]", (Object)this.getId(), (Object)list.size()));
        if (list.size() > 0) {
            this.deDataImportMap = new Hashtable();
            for (DEDataImport deDataImport : list) {
                deDataImport.BuildModel();
                this.deDataImportMap.put(deDataImport.getDEDATAIMPORTNAME().toUpperCase(), deDataImport);
            }
        }
        return true;
    }

    protected boolean PrepareDEAction() {
        Vector<DEAction> list = new Vector<DEAction>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEActions(this.getId(), list);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u5b9e\u4f53\u884c\u4e3a\u6570\u91cf[%2$s]", (Object)this.getId(), (Object)list.size()));
        if (list.size() > 0) {
            this.deActionMap = new Hashtable();
            for (DEAction deAction : list) {
                deAction.BuildActionParams();
                this.deActionMap.put(deAction.getDEACTIONID().toUpperCase(), deAction);
            }
        }
        return true;
    }

    protected boolean PrepareDEWF() {
        if (!this.IsEnableWF()) {
            return true;
        }
        DEWF deWF = new DEWF();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEWF(this.getId(), deWF);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6d41\u7a0b\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        try {
            this.iDEWFHelper = new DEWFHelper();
            this.iDEWFHelper.Init(this.contextHelperEx, this, deWF);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u6d41\u7a0b\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return false;
        }
        Vector<DESubWF> list = new Vector<DESubWF>();
        callResult = this.contextHelperEx.getDAModelHelper().GetDESubWFs(this.getId(), list);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        if (list.size() > 0) {
            this.deSubWFMap = new Hashtable();
            for (DESubWF deSubWF : list) {
                try {
                    DESubWFHelper deSubWFHelper = new DESubWFHelper();
                    deSubWFHelper.Init(this.contextHelperEx, this, deSubWF);
                    this.deSubWFMap.put(deSubWF.getDESUBWFID().toUpperCase(), deSubWFHelper);
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)deSubWF.getDESUBWFID(), (Object)ex.getMessage()), (Throwable)ex);
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean PrepareDEWizard() {
        Vector<DEWizard> deWizards = new Vector<DEWizard>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEWizards(this.getId(), deWizards);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5411\u5bfc\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        for (DEWizard deWizard : deWizards) {
            this.deWizardMap.put(deWizard.getDEWIZARDID(), deWizard);
            if (!deWizard.getCREATEWZ()) continue;
            this.createWizards.add(deWizard);
        }
        return true;
    }

    protected boolean PrepareDEMobile() {
        this.deMobile = new DEMobile();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEMobile(this.getId(), this.deMobile);
        if (callResult.IsOk()) {
            return true;
        }
        if (callResult.getRetCode() == 3) {
            this.deMobile = null;
            return true;
        }
        log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u79fb\u52a8\u5e94\u7528\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        this.deMobile = null;
        return false;
    }

    protected boolean PrepareDEDataSync() {
        Vector<DEDataSync> deDataSyncs = new Vector<DEDataSync>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEDataSyncs(this.getId(), deDataSyncs);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u6570\u636e\u540c\u6b65\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u6570\u636e\u540c\u6b65[%2$s]", (Object)this.getId(), (Object)deDataSyncs.size()));
        for (DEDataSync deDataSync : deDataSyncs) {
            if (StringHelper.Compare((String)deDataSync.getSYNCDIR(), (String)"IN", (boolean)true) == 0) {
                this.deDataSyncIns.add(deDataSync);
                continue;
            }
            this.deDataSyncOuts.add(deDataSync);
        }
        return true;
    }

    protected boolean PrepareDERGroup() {
        Vector<DERGroup> derGroups = new Vector<DERGroup>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDERGroups(this.getId(), derGroups);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4[%2$s]", (Object)this.getId(), (Object)derGroups.size()));
        if (derGroups.size() == 0) {
            return true;
        }
        this.derGroupHelperMap = new Hashtable();
        try {
            for (DERGroup derGroup : derGroups) {
                IDERGroupHelper iDERGroupHelper = this.OnCreateDERGroupHelper(derGroup);
                iDERGroupHelper.Init(this.getGlobalHelper(), this, derGroup);
                this.derGroupHelperMap.put(iDERGroupHelper.getId().toUpperCase(), iDERGroupHelper);
            }
        }
        catch (Exception e) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u5173\u7cfb\u5206\u7ec4\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            return false;
        }
        return true;
    }

    protected IDERGroupHelper OnCreateDERGroupHelper(DERGroup derGroup) {
        return (IDERGroupHelper)ObjectHelper.Create((String)"SA.SRFDA.Ctrl.DERGroupHelper");
    }

    @Override
    public Vector<DEDataSync> GetDEDataSyncs(boolean bIn) {
        if (bIn) {
            return this.deDataSyncIns;
        }
        return this.deDataSyncOuts;
    }

    protected boolean PrepareDEPrintForm() {
        if (StringHelper.IsNullOrEmpty((String)this.dataEntity.getPRINTFUNC())) {
            this.bEnablePrint = BaseDEHelper.getEnablePrintDefault();
        } else if (StringHelper.Compare((String)this.dataEntity.getPRINTFUNC(), (String)"DISABLE", (boolean)true) == 0) {
            this.bEnablePrint = false;
        } else if (StringHelper.Compare((String)this.dataEntity.getPRINTFUNC(), (String)"ENABLE", (boolean)true) == 0) {
            this.bEnablePrint = true;
        } else {
            this.bEnablePrint = true;
            Vector<PrintForm> printForms = new Vector<PrintForm>();
            CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEPrintForms(this.getId(), printForms);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6253\u5370\u8868\u5355\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return false;
            }
            this.bEnablePrint = printForms.size() > 0;
        }
        return true;
    }

    protected boolean PrepareToolTip() {
        String strToolTipObject = this.dataEntity.getTIPSOBJECT();
        if (!StringHelper.IsNullOrEmpty((String)strToolTipObject)) {
            Object objToolTipHelper = ObjectHelper.Create((String)strToolTipObject);
            if (objToolTipHelper == null) {
                return false;
            }
            if (!(objToolTipHelper instanceof IDEToolTipHelper)) {
                log.error((Object)StringHelper.Format((String)"\u63d0\u793a\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strToolTipObject));
                return false;
            }
            this.iDEToolTipHelper = (IDEToolTipHelper)objToolTipHelper;
            this.iDEToolTipHelper.Init(this, this.contextHelperEx);
            return true;
        }
        String strToolTipInfo = this.dataEntity.getTIPSINFO();
        if (!StringHelper.IsNullOrEmpty((String)strToolTipInfo)) {
            Configuration config = new Configuration();
            DETemplateLoader deTemplateLoader = new DETemplateLoader(this.dataEntity);
            config.setTemplateLoader((TemplateLoader)deTemplateLoader);
            try {
                this.toolTipTemplate = config.getTemplate("TIPSINFO");
            }
            catch (IOException e) {
                log.error((Object)"\u52a0\u8f7d\u63d0\u793a\u6a21\u677f\u51fa\u9519", (Throwable)e);
                return false;
            }
            return true;
        }
        return true;
    }

    private synchronized boolean PrepareSelectQueryModel() {
        Vector<QueryModel> list = new Vector<QueryModel>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetSelectQueryModels(this.getId(), list);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u67e5\u8be2\u641c\u7d22\u6a21\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        this.bInitselectQueryModel = true;
        if (list.size() > 0) {
            this.selectQueryModelHelperMap = new Hashtable();
            for (QueryModel queryModel : list) {
                BaseDAQueryModelHelper queryModelHelper = this.contextHelperEx.getDAModelStorage().FindDAQueryModelHelper(queryModel);
                if (queryModelHelper == null) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e\u68c0\u7d22\u6a21\u578b[%1$s]", (Object)queryModel.getQUERYMODELID()));
                    return false;
                }
                Vector<String> userConditions = new Vector<String>();
                queryModelHelper.FillMajorConditions(userConditions);
                StringBuilderEx script = new StringBuilderEx();
                script.Append(queryModelHelper.GetQueryModelScript());
                BaseDAQueryModelHelper.AppendConditionSQL(script, userConditions);
                String strSQL = script.toString();
                if (!StringHelper.IsNullOrEmpty((String)queryModel.getSELECTORDER())) {
                    String[] parts2;
                    String[] parts = queryModel.getSELECTORDER().split("[,]");
                    String strMajor = "";
                    String strMajorDirection = "";
                    String strMinor = "";
                    String strMinorDirection = "";
                    if (parts.length >= 1) {
                        parts2 = parts[0].split("[ ]");
                        if (parts2.length >= 1) {
                            strMajor = parts2[0];
                        }
                        if (parts2.length >= 2) {
                            strMajorDirection = parts2[1];
                        }
                    }
                    if (parts.length >= 2) {
                        parts2 = parts[1].split("[ ]");
                        if (parts2.length >= 1) {
                            strMinor = parts2[0];
                        }
                        if (parts2.length >= 2) {
                            strMinorDirection = parts2[1];
                        }
                    }
                    strSQL = queryModelHelper.GetSortSQL(true, strSQL, strMajor, strMajorDirection, strMinor, strMinorDirection);
                }
                strSQL = String.valueOf(queryModelHelper.GetQMDeclareScript()) + strSQL;
                SelectQueryModel selectQueryModel = new SelectQueryModel();
                selectQueryModel.strSelectCode = strSQL;
                selectQueryModel.baseDAQueryModelHelper = queryModelHelper;
                this.selectQueryModelHelperMap.put(queryModel.getSELECTMODE().toUpperCase(), selectQueryModel);
            }
        }
        return true;
    }

    @Override
    public Vector<DEDataCtrl> GetDEDC(String strDCStep, String strActionMode) {
        if (this.deDataCtrlMap == null) {
            return null;
        }
        String strDEDataCtrlId = StringHelper.Format((String)"%1$s:%2$s", (Object)strDCStep, (Object)strActionMode);
        if (this.deDataCtrlMap.containsKey(strDEDataCtrlId = strDEDataCtrlId.toUpperCase())) {
            return this.deDataCtrlMap.get(strDEDataCtrlId);
        }
        return null;
    }

    @Override
    public DEACMode GetACMode(String strACMode) {
        if (this.deACModeMap == null) {
            return null;
        }
        return this.deACModeMap.get(strACMode.toUpperCase());
    }

    @Override
    public DEDataImport GetDataImport(String strDataImportMode) {
        if (this.deDataImportMap == null) {
            return null;
        }
        return this.deDataImportMap.get(strDataImportMode.toUpperCase());
    }

    @Override
    public Vector<DER1N> GetDER1Ns(boolean bMain) {
        if (bMain) {
            return this.der1nList;
        }
        return this.der1nList2;
    }

    @Override
    public Vector<DER11> GetDER11s(boolean bMain) {
        if (bMain) {
            return this.der11List;
        }
        return null;
    }

    @Override
    public Vector<DERINDEX> GetDERINDEXs(boolean bMain) {
        if (bMain) {
            return this.derIndexList;
        }
        return this.derIndexList2;
    }

    @Override
    public DERINDEX FindDERINDEX(String strIndexType) {
        for (DERINDEX dERINDEX : this.derIndexList) {
            if (StringHelper.Compare((String)dERINDEX.getTYPEVALUE(), (String)strIndexType, (boolean)true) != 0) continue;
            return dERINDEX;
        }
        return null;
    }

    @Override
    public Vector<DERCUSTOM> GetDERCUSTOMs(boolean bMain) {
        if (bMain) {
            return this.derCustomList;
        }
        return this.derCustomList2;
    }

    @Override
    public DERCUSTOM FindDERCUSTOM(boolean bMain, String strDERId) {
        if (bMain) {
            for (DERCUSTOM derCustom : this.derCustomList) {
                if (StringHelper.Compare((String)derCustom.getCUSTOMDERID(), (String)strDERId, (boolean)true) != 0) continue;
                return derCustom;
            }
            return null;
        }
        for (DERCUSTOM derCustom : this.derCustomList2) {
            if (StringHelper.Compare((String)derCustom.getCUSTOMDERID(), (String)strDERId, (boolean)true) != 0) continue;
            return derCustom;
        }
        return null;
    }

    @Override
    public DER1N FindDER1N(String strDERId) {
        BaseDataEntity der = this.derMap.get("DER1N:" + strDERId.toUpperCase());
        if (der == null) {
            return null;
        }
        return (DER1N)der;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult GetProcParams(String strProcName, Vector<ProcParam> params) {
        Vector<ProcParam> curParams = null;
        Hashtable<String, Vector<ProcParam>> hashtable = this.procParamMap;
        synchronized (hashtable) {
            if (this.procParamMap.containsKey(strProcName)) {
                curParams = this.procParamMap.get(strProcName);
            }
        }
        if (curParams == null) {
            curParams = new Vector<ProcParam>();
            CallResult callResult = this.InternalGetProcParams(strProcName, curParams);
            if (callResult.IsError()) {
                return callResult;
            }
            Hashtable<String, Vector<ProcParam>> hashtable2 = this.procParamMap;
            synchronized (hashtable2) {
                this.procParamMap.put(strProcName, curParams);
            }
        }
        params.addAll(curParams);
        return new CallResult();
    }

    protected CallResult InternalGetProcParams(String strProcName, Vector<ProcParam> params) {
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_GetProcParams(strProcName);
        return BaseDEDataCtrl.SelectMultiEx(this.contextHelperEx, this.GetDBStorage(), strSQL, params, ProcParam.class.getName());
    }

    protected IDEDataCtrlHelper GetDEDataCtrlHelper() {
        return this.contextHelperEx.getDEDataCtrlHelper(this.GetDBStorage());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult GetDBAction(String strAction, String strActionMode) {
        CallResult callResult = new CallResult();
        String strKey = StringHelper.Format((String)"%1$s[%2$s]", (Object)strAction, (Object)strActionMode).toUpperCase();
        Object objCache = this.dbActionMap.get(strKey);
        if (objCache != null) {
            if (objCache instanceof DBAction) {
                callResult.setUserObject(objCache);
                return callResult;
            }
            if (objCache instanceof String) {
                callResult.setRetCode(3);
                return callResult;
            }
        }
        DBAction dbAction = new DBAction();
        callResult = this.contextHelperEx.getDAModelHelper().GetDBAction(this.getId(), this.GetDBType(), strAction, strActionMode, dbAction);
        if (callResult.getRetCode() == 3) {
            Hashtable<String, Object> hashtable = this.dbActionMap;
            synchronized (hashtable) {
                this.dbActionMap.put(strKey, "");
            }
            return callResult;
        }
        if (callResult.getRetCode() == 0) {
            dbAction.BuildActionParams();
            Hashtable<String, Object> hashtable = this.dbActionMap;
            synchronized (hashtable) {
                this.dbActionMap.put(strKey, (Object)dbAction);
            }
            callResult.setUserObject((Object)dbAction);
            return callResult;
        }
        return callResult;
    }

    @Override
    public DEWizard GetDEWizard(String strDEWizardId) {
        return this.deWizardMap.get(strDEWizardId);
    }

    @Override
    public DEWizard GetDefaultCreateWizard() {
        for (DEWizard deWizard : this.createWizards) {
            if (!deWizard.getCREATEDEFAULT()) continue;
            return deWizard;
        }
        return null;
    }

    @Override
    public Vector<DEWizard> GetCreateWizards() {
        return this.createWizards;
    }

    @Override
    public void RemoveUncopyValue(BaseDataEntity dataEntity) {
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            if (!iDEFHelper.IsPasteReset()) continue;
            dataEntity.RemoveParam(iDEFHelper.getName());
        }
    }

    @Override
    public CallResult PrepareDBProc(boolean bReCreate) {
        return this.OnPrepareDBProc(bReCreate);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected CallResult OnPrepareDBProc(boolean bReCreate) {
        CallResult callResult = new CallResult();
        this.RemoveExpiredProc();
        try {
            String strSQL;
            Hashtable<String, Integer> hashtable = this.dbProcExistMap;
            synchronized (hashtable) {
                this.dbProcExistMap.clear();
            }
            String strProcName = this.GetInsertProcName();
            String strProcCode = this.GetInsertProcCode();
            if (bReCreate && !StringHelper.IsNullOrEmpty((String)strProcCode) && !StringHelper.IsNullOrEmpty((String)(strSQL = this.GetDEDataCtrlHelper().GetSQL_DropProc(strProcName)))) {
                this.DropDBProc(strProcName, strSQL);
            }
            if (!this.IsDBProcExist(strProcName)) {
                log.info((Object)StringHelper.Format((String)"\u5efa\u7acb\u8fc7\u7a0b[%1$s]", (Object)strProcName));
                if (StringHelper.IsNullOrEmpty((String)strProcCode)) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    return callResult;
                }
                log.info((Object)strProcCode);
                callResult = this.CompileDBProc(strProcName, strProcCode);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u7f16\u8bd1[%1$s]\u4ee3\u7801", (Object)strProcCode));
                    return callResult;
                }
            }
            strProcName = this.GetUpdateProcName();
            strProcCode = this.GetUpdateProcCode();
            if (bReCreate && !StringHelper.IsNullOrEmpty((String)strProcCode) && !StringHelper.IsNullOrEmpty((String)(strSQL = this.GetDEDataCtrlHelper().GetSQL_DropProc(strProcName)))) {
                this.DropDBProc(strProcName, strSQL);
            }
            if (!this.IsDBProcExist(strProcName)) {
                log.info((Object)StringHelper.Format((String)"\u5efa\u7acb\u8fc7\u7a0b[%1$s]", (Object)strProcName));
                if (StringHelper.IsNullOrEmpty((String)strProcCode)) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    return callResult;
                }
                log.info((Object)strProcCode);
                callResult = this.CompileDBProc(strProcName, strProcCode);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u7f16\u8bd1[%1$s]\u4ee3\u7801", (Object)strProcCode));
                    return callResult;
                }
            }
            strProcName = this.GetDeleteProcName();
            strProcCode = this.GetDeleteProcCode();
            if (bReCreate && !StringHelper.IsNullOrEmpty((String)strProcCode) && !StringHelper.IsNullOrEmpty((String)(strSQL = this.GetDEDataCtrlHelper().GetSQL_DropProc(strProcName)))) {
                this.DropDBProc(strProcName, strSQL);
            }
            if (!this.IsDBProcExist(strProcName)) {
                log.info((Object)StringHelper.Format((String)"\u5efa\u7acb\u8fc7\u7a0b[%1$s]", (Object)strProcName));
                if (StringHelper.IsNullOrEmpty((String)strProcCode)) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    return callResult;
                }
                log.info((Object)strProcCode);
                callResult = this.CompileDBProc(strProcName, strProcCode);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u7f16\u8bd1[%1$s]\u4ee3\u7801", (Object)strProcCode));
                    return callResult;
                }
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            log.error((Object)"\u51c6\u5907\u5b9e\u4f53\u65b9\u6cd5\u53d1\u751f\u9519\u8bef", (Throwable)ex);
        }
        return callResult;
    }

    @Override
    public CallResult PrepareDBProc(String strAction, String strActionMode) {
        return this.OnPrepareDBProc(strAction, strActionMode);
    }

    protected CallResult OnPrepareDBProc(String strAction, String strActionMode) {
        CallResult callResult = new CallResult();
        if (StringHelper.Compare((String)strAction, (String)"INSERT", (boolean)true) == 0) {
            String strProcName = this.GetInsertProcName();
            if (StringHelper.IsNullOrEmpty((String)strProcName)) {
                String strError = StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49[INSERT]\u8fc7\u7a0b\u7684\u540d\u79f0");
                log.error((Object)strError);
                callResult.setRetCode(1);
                callResult.setErrorInfo(strError);
                return callResult;
            }
            if (!this.IsDBProcExist(strProcName)) {
                log.info((Object)StringHelper.Format((String)"\u6307\u5b9a\u8fc7\u7a0b[%1$s]\u4e0d\u5b58\u5728\uff0c\u5c1d\u8bd5\u5efa\u7acb\u8fc7\u7a0b", (Object)strProcName));
                String strProcCode = this.GetInsertProcCode();
                if (StringHelper.IsNullOrEmpty((String)strProcCode)) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    return callResult;
                }
                log.info((Object)strProcCode);
                callResult = this.CompileDBProc(strProcName, strProcCode);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u7f16\u8bd1[%1$s]\u4ee3\u7801", (Object)strProcCode));
                    return callResult;
                }
            }
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)"UPDATE", (boolean)true) == 0) {
            String strProcName = this.GetUpdateProcName();
            if (StringHelper.IsNullOrEmpty((String)strProcName)) {
                String strError = StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49[UPDATE]\u8fc7\u7a0b\u7684\u540d\u79f0");
                log.error((Object)strError);
                callResult.setRetCode(1);
                callResult.setErrorInfo(strError);
                return callResult;
            }
            if (!this.IsDBProcExist(strProcName)) {
                log.info((Object)StringHelper.Format((String)"\u6307\u5b9a\u8fc7\u7a0b[%1$s]\u4e0d\u5b58\u5728\uff0c\u5c1d\u8bd5\u5efa\u7acb\u8fc7\u7a0b", (Object)strProcName));
                String strProcCode = this.GetUpdateProcCode();
                if (StringHelper.IsNullOrEmpty((String)strProcCode)) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    return callResult;
                }
                log.info((Object)strProcCode);
                callResult = this.CompileDBProc(strProcName, strProcCode);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u7f16\u8bd1[%1$s]\u4ee3\u7801", (Object)strProcCode));
                    return callResult;
                }
            }
            return callResult;
        }
        if (StringHelper.Compare((String)strAction, (String)"DELETE", (boolean)true) == 0) {
            String strProcName = this.GetDeleteProcName();
            if (StringHelper.IsNullOrEmpty((String)strProcName)) {
                String strError = StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49[DELETE]\u8fc7\u7a0b\u7684\u540d\u79f0");
                log.error((Object)strError);
                callResult.setRetCode(1);
                callResult.setErrorInfo(strError);
                return callResult;
            }
            if (!this.IsDBProcExist(strProcName)) {
                log.info((Object)StringHelper.Format((String)"\u6307\u5b9a\u8fc7\u7a0b[%1$s]\u4e0d\u5b58\u5728\uff0c\u5c1d\u8bd5\u5efa\u7acb\u8fc7\u7a0b", (Object)strProcName));
                String strProcCode = this.GetDeleteProcCode();
                if (StringHelper.IsNullOrEmpty((String)strProcCode)) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    callResult.setRetCode(1);
                    callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u8fc7\u7a0b[%1$s]\u4ee3\u7801", (Object)strProcName));
                    return callResult;
                }
                log.info((Object)strProcCode);
                callResult = this.CompileDBProc(strProcName, strProcCode);
                if (callResult.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u7f16\u8bd1[%1$s]\u4ee3\u7801", (Object)strProcCode));
                    return callResult;
                }
            }
            return callResult;
        }
        callResult.setRetCode(1);
        callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u6570\u636e\u5e93\u64cd\u4f5c[%1$s]", (Object)strAction));
        return callResult;
    }

    protected CallResult DropDBProc(String strProcName, String strSQL) {
        CallResult calLResult = new CallResult();
        try {
            DBResult result = this.contextHelperEx.getDBCaller(this.GetDBStorage()).CallRaw3WithoutReturn(strSQL, null);
            if (result.getRetCode() != 0) {
                calLResult.From(result);
                return calLResult;
            }
            if (this.IsDBProcExist(strProcName)) {
                calLResult.setRetCode(1);
                return calLResult;
            }
            calLResult.setRetCode(0);
            return calLResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5220\u9664\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName), (Throwable)ex);
            calLResult.setRetCode(1);
            calLResult.setErrorInfo(StringHelper.Format((String)"\u5220\u9664\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName));
            return calLResult;
        }
    }

    protected boolean IsDBProcExist(String strProcName) {
        Integer nRowCnt = this.dbProcExistMap.get(strProcName);
        if (nRowCnt == null) {
            String strSQL = this.GetDEDataCtrlHelper().GetSQL_IsProcExist(strProcName);
            BaseDataEntity rowCount = new BaseDataEntity();
            CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.contextHelperEx, this.GetDBStorage(), strSQL, rowCount);
            if (callResult.getRetCode() != 0) {
                log.error((Object)StringHelper.Format((String)"\u5224\u65ad\u5b58\u50a8\u8fc7\u7a0b[%1$s]\u662f\u5426\u5b58\u5728\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strProcName, (Object)callResult.getErrorInfo()));
                return false;
            }
            nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
            if (nRowCnt == 1) {
                this.dbProcExistMap.put(strProcName, nRowCnt);
            }
        }
        return nRowCnt == 1;
    }

    protected CallResult CompileDBProc(String strProcName, String strSQL) {
        CallResult calLResult = new CallResult();
        try {
            SelectResult result = this.contextHelperEx.getDBCaller(this.GetDBStorage()).CallRaw2(strSQL);
            if (result.getRetCode() != 0) {
                calLResult.From((DBResult)result);
                return calLResult;
            }
            if (this.IsDBProcExist(strProcName)) {
                calLResult.setRetCode(0);
                return calLResult;
            }
            calLResult.setRetCode(1);
            return calLResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u7f16\u8bd1\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName), (Throwable)ex);
            calLResult.setRetCode(1);
            calLResult.setErrorInfo(StringHelper.Format((String)"\u7f16\u8bd1\u8fc7\u7a0b[%1$s]\u51fa\u73b0\u9519\u8bef", (Object)strProcName));
            return calLResult;
        }
    }

    @Override
    public CallResult RemoveExpiredProc() {
        String strPreFixProcName = this.GetPreFixProcName();
        strPreFixProcName = strPreFixProcName.toUpperCase();
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_AutoGenProcs(strPreFixProcName);
        Vector<BaseDataEntity> procNames = new Vector<BaseDataEntity>();
        CallResult callResult = BaseDEDataCtrl.SelectMultiEx(this.getGlobalHelper(), this.GetDBStorage(), strSQL, null, procNames, null);
        if (callResult.IsError()) {
            return callResult;
        }
        Hashtable<String, String> procNameMap = new Hashtable<String, String>();
        for (BaseDataEntity procName : procNames) {
            procNameMap.put(procName.GetParamStringValue("PROCNAME", ""), "");
        }
        procNameMap.remove(this.GetInsertProcName().toUpperCase());
        procNameMap.remove(this.GetUpdateProcName().toUpperCase());
        procNameMap.remove(this.GetDeleteProcName().toUpperCase());
        procNameMap.remove(this.GetDraftInsertProcName().toUpperCase());
        for (String strProcName : procNameMap.keySet()) {
            String strDropSQL;
            if (strProcName.indexOf(strPreFixProcName) != 0 || StringHelper.IsNullOrEmpty((String)(strDropSQL = this.GetDEDataCtrlHelper().GetSQL_DropProc(strProcName)))) continue;
            callResult = BaseDEDataCtrl.ExecuteWithoutResultEx(this.getGlobalHelper(), this.GetDBStorage(), strDropSQL, null);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u6267\u884cSQL\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                continue;
            }
            log.info((Object)StringHelper.Format((String)"\u6210\u529f\u79fb\u9664\u8fc7\u671f\u5b58\u50a8\u8fc7\u7a0b[%1$s]", (Object)strProcName));
        }
        callResult.setRetCode(0);
        return callResult;
    }

    protected String GetPreFixProcName() {
        return StringHelper.Format((String)"%1$s%2$s_", (Object)this.strProcPreFix, (Object)this.getDataEntity().getDENAME()).toUpperCase();
    }

    @Override
    public CallResult GetDynamicTables(Date startDate, Date endDate, Vector<String> tables) {
        CallResult callResult = new CallResult();
        Hashtable<Date, String> tables2 = new Hashtable<Date, String>();
        try {
            BaseDEHelper.CalcDynamicTables(startDate, endDate, this.dataEntity.getTABLENAME(), this.dataEntity.getDYNAMICINTERVAL(), tables2);
            for (String strTable : tables2.values()) {
                if (!this.IsTableExist(strTable)) continue;
                tables.add(strTable);
            }
        }
        catch (Exception e) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(e.getMessage());
            e.printStackTrace();
            return callResult;
        }
        return callResult;
    }

    protected boolean IsTableExist(String strTableName) {
        String strSQL = this.GetDEDataCtrlHelper().GetSQL_IsTableExist(strTableName);
        BaseDataEntity rowCount = new BaseDataEntity();
        CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.contextHelperEx, this.GetDBStorage(), strSQL, rowCount);
        if (callResult.getRetCode() != 0) {
            return false;
        }
        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        return nRowCnt == 1;
    }

    public static void CalcDynamicTables(Date startDate, Date endDate, String strTableName, int nDynamcInterval, Hashtable<Date, String> tables) throws Exception {
        if (endDate.getTime() < startDate.getTime()) {
            throw new Exception("\u7ed3\u675f\u65f6\u95f4\u5c0f\u4e8e\u5f00\u59cb\u65f6\u95f4");
        }
        if (nDynamcInterval <= 0) {
            throw new Exception("\u52a8\u6001\u8868\u95f4\u9694\u65f6\u95f4\u4e0d\u80fd\u5c0f\u4e8e\u6216\u7b49\u4e8e0");
        }
        long nTime = startDate.getTime() / (long)(nDynamcInterval * 60000);
        Calendar cale = Calendar.getInstance();
        cale.setTimeInMillis(nTime *= (long)(nDynamcInterval * 60000));
        while (cale.getTime().getTime() <= endDate.getTime()) {
            String strRealTableName = StringHelper.Format((String)strTableName, (Object)cale.getTime());
            tables.put(cale.getTime(), strRealTableName);
            cale.add(12, nDynamcInterval);
        }
    }

    @Override
    public boolean IsEnableDEFieldPriv() {
        return this.dataEntity.getENABLECOLPRIV();
    }

    @Override
    public boolean IsDBUnicodeChar() {
        return true;
    }

    @Override
    public String GetDBSchema() {
        return null;
    }

    @Override
    public BaseDataEntity CreateDEObject() {
        if (StringHelper.IsNullOrEmpty((String)this.dataEntity.getDEOBJECT())) {
            return new BaseDataEntity();
        }
        return (BaseDataEntity)ObjectHelper.Create((String)this.dataEntity.getDEOBJECT());
    }

    @Override
    public DEAction GetDEAction(String strDEActionId) {
        if (this.deActionMap == null) {
            return null;
        }
        return this.deActionMap.get(strDEActionId.toUpperCase());
    }

    @Override
    public DESubWF GetDESubWF(String strDESubWFId) {
        try {
            return this.GetDESubWFHelper(strDESubWFId).getData();
        }
        catch (Exception e) {
            log.error((Object)e.getMessage(), (Throwable)e);
            return null;
        }
    }

    @Override
    public IDESubWFHelper GetDESubWFHelper(String strDESubWFId) throws Exception {
        strDESubWFId = strDESubWFId.toUpperCase();
        if (this.deSubWFMap == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]\u914d\u7f6e", (Object)strDESubWFId));
        }
        IDESubWFHelper iDESubWFHelper = this.deSubWFMap.get(strDESubWFId);
        if (iDESubWFHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]\u914d\u7f6e", (Object)strDESubWFId));
        }
        return iDESubWFHelper;
    }

    @Override
    public CallResult PrepareDBObject(String strDBObjectId) {
        DBObject dbObject = new DBObject();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDBObject(this.getId(), this.GetDBType(), strDBObjectId, dbObject);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u6570\u636e\u5e93\u5bf9\u8c61\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return this.OnPrepareDBObject(dbObject);
    }

    protected CallResult OnPrepareDBObject(DBObject dbObject) {
        CallResult callResult = new CallResult();
        if (!dbObject.getPUBLISHFLAG()) {
            log.debug((Object)StringHelper.Format((String)"\u6570\u636e\u5e93\u5bf9\u8c61[%1$s][%2$s]\u8bbe\u7f6e\u4e3a\u672a\u53d1\u5e03\u6807\u5fd7\uff0c\u4e0d\u505a\u53d1\u5e03", (Object)dbObject.getDBOBJTYPE(), (Object)dbObject.getDBOBJECTNAME()));
            return callResult;
        }
        String strTestSQL = "";
        String strDropSQL = "";
        if (StringHelper.Compare((String)dbObject.getDBOBJTYPE(), (String)"PROC", (boolean)true) == 0) {
            strTestSQL = this.GetDEDataCtrlHelper().GetSQL_IsProcExist(dbObject.getDBOBJECTNAME());
            strDropSQL = this.GetDEDataCtrlHelper().GetSQL_DropProc(dbObject.getDBOBJECTNAME());
        } else if (StringHelper.Compare((String)dbObject.getDBOBJTYPE(), (String)"VIEW", (boolean)true) == 0) {
            strTestSQL = this.GetDEDataCtrlHelper().GetSQL_IsViewExist(dbObject.getDBOBJECTNAME());
            strDropSQL = this.GetDEDataCtrlHelper().GetSQL_DropView(dbObject.getDBOBJECTNAME());
        } else if (StringHelper.Compare((String)dbObject.getDBOBJTYPE(), (String)"FUNC", (boolean)true) == 0) {
            strTestSQL = this.GetDEDataCtrlHelper().GetSQL_IsFuncExist(dbObject.getDBOBJECTNAME());
            strDropSQL = this.GetDEDataCtrlHelper().GetSQL_DropFunc(dbObject.getDBOBJECTNAME());
        } else if (StringHelper.Compare((String)dbObject.getDBOBJTYPE(), (String)"SEQUENCE", (boolean)true) == 0) {
            strTestSQL = this.GetDEDataCtrlHelper().GetSQL_IsSequenceExist(dbObject.getDBOBJECTNAME());
            strDropSQL = this.GetDEDataCtrlHelper().GetSQL_DropSequence(dbObject.getDBOBJECTNAME());
        } else if (StringHelper.Compare((String)dbObject.getDBOBJTYPE(), (String)"TRIGGER", (boolean)true) == 0) {
            strTestSQL = this.GetDEDataCtrlHelper().GetSQL_IsTriggerExist(dbObject.getDBOBJECTNAME());
            strDropSQL = this.GetDEDataCtrlHelper().GetSQL_DropTrigger(dbObject.getDBOBJECTNAME());
        }
        if (StringHelper.IsNullOrEmpty((String)strTestSQL)) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5e93\u5bf9\u8c61\u7c7b\u578b[%1$s]\u5bf9\u8c61\u662f\u5426\u5b58\u5728\u68c0\u67e5\u4ee3\u7801", (Object)dbObject.getDBOBJTYPE()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        BaseDataEntity rowCount = new BaseDataEntity();
        callResult = BaseDEDataCtrl.SelectSingleEx(this.contextHelperEx, this.GetDBStorage(), strTestSQL, rowCount);
        if (callResult.getRetCode() != 0) {
            callResult.setErrorInfo(StringHelper.Format((String)"\u5224\u65ad\u6570\u636e\u5e93\u5bf9\u8c61[%1$s][%2$s]\u662f\u5426\u5b58\u5728\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)dbObject.getDBOBJTYPE(), (Object)dbObject.getDBOBJECTNAME(), (Object)callResult.getErrorInfo()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        int nRowCnt = rowCount.GetParamIntValue("ROWCOUNT", 0);
        if (nRowCnt == 1) {
            if (StringHelper.Compare((String)dbObject.getCREATETYPE(), (String)"CREATENOTEXISTS", (boolean)true) == 0) {
                log.debug((Object)StringHelper.Format((String)"\u6570\u636e\u5e93\u5bf9\u8c61[%1$s][%2$s]\u5df2\u7ecf\u5b58\u5728", (Object)dbObject.getDBOBJTYPE(), (Object)dbObject.getDBOBJECTNAME()));
                return callResult;
            }
            if (StringHelper.IsNullOrEmpty((String)strDropSQL)) {
                callResult.setRetCode(1);
                callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5e93\u5bf9\u8c61\u7c7b\u578b[%1$s]\u5bf9\u8c61\u79fb\u9664\u6267\u884c\u4ee3\u7801", (Object)dbObject.getDBOBJTYPE()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult = this.DropDBObject(dbObject.getDBOBJECTNAME(), strDropSQL);
            if (callResult.IsError()) {
                return callResult;
            }
        }
        if ((callResult = this.OnCreateDBObject(dbObject)).IsError()) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u6570\u636e\u5e93\u5bf9\u8c61\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        try {
            DBResult result;
            if (!StringHelper.IsNullOrEmpty((String)dbObject.getAFTERCREATECODE()) && (result = this.contextHelperEx.getDBCaller(this.GetDBStorage()).CallRaw3WithoutReturn(dbObject.getAFTERCREATECODE(), null)).getRetCode() != 0) {
                callResult.From(result);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u5bf9\u8c61[%1$s]\u5efa\u7acb\u6210\u529f\u540e\u4ee3\u7801\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)dbObject.getDBOBJECTNAME(), (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            if (!StringHelper.IsNullOrEmpty((String)dbObject.getAFTERCREATECODE2()) && (result = this.contextHelperEx.getDBCaller(this.GetDBStorage()).CallRaw3WithoutReturn(dbObject.getAFTERCREATECODE2(), null)).getRetCode() != 0) {
                callResult.From(result);
                callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u5bf9\u8c61[%1$s]\u5efa\u7acb\u6210\u529f\u540e\u4ee3\u78012\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)dbObject.getDBOBJECTNAME(), (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u6267\u884c\u6570\u636e\u5e93\u5bf9\u8c61[%1$s]\u5efa\u7acb\u6210\u529f\u4ee3\u7801\u51fa\u73b0\u5f02\u5e38\uff0c%2$s", (Object)dbObject.getDBOBJECTNAME(), (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
        return callResult;
    }

    protected CallResult OnCreateDBObject(DBObject dbObject) {
        CallResult callResult = new CallResult();
        if (StringHelper.IsNullOrEmpty((String)dbObject.getOBJCODE())) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u65e0\u6cd5\u6307\u5b9a\u6570\u636e\u5e93\u5bf9\u8c61[%1$s]\u4ee3\u7801", (Object)dbObject.getDBOBJECTNAME()));
            log.error((Object)callResult.getErrorInfo());
            return callResult;
        }
        return this.CompileDBObject(dbObject.getDBOBJECTNAME(), dbObject.getOBJCODE());
    }

    protected CallResult DropDBObject(String strDBObjectName, String strSQL) {
        CallResult callResult = new CallResult();
        try {
            DBResult result = this.contextHelperEx.getDBCaller(this.GetDBStorage()).CallRaw3WithoutReturn(strSQL, null);
            if (result.getRetCode() != 0) {
                callResult.From(result);
                callResult.setErrorInfo(StringHelper.Format((String)"\u79fb\u9664\u6570\u636e\u5e93\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDBObjectName, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            callResult.setRetCode(0);
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u79fb\u9664\u6570\u636e\u5e93\u5bf9\u8c61[%1$s]\u51fa\u73b0\u5f02\u5e38\uff0c%2$s", (Object)strDBObjectName, (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    protected CallResult CompileDBObject(String strDBObjectName, String strSQL) {
        strSQL = strSQL.replace("\r\n", "\n");
        strSQL = strSQL.replace("\r", "\n");
        strSQL = String.valueOf(strSQL) + "\n\n";
        CallResult callResult = new CallResult();
        try {
            SelectResult result = this.contextHelperEx.getDBCaller(this.GetDBStorage()).CallRaw2(strSQL);
            if (result.getRetCode() != 0) {
                callResult.From((DBResult)result);
                callResult.setErrorInfo(StringHelper.Format((String)"\u7f16\u8bd1\u6570\u636e\u5e93\u5bf9\u8c61[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strDBObjectName, (Object)callResult.getErrorInfo()));
                log.error((Object)callResult.getErrorInfo());
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(StringHelper.Format((String)"\u7f16\u8bd1\u6570\u636e\u5e93\u5bf9\u8c61[%1$s]\u51fa\u73b0\u5f02\u5e38\uff0c%2$s", (Object)strDBObjectName, (Object)ex.getMessage()));
            log.error((Object)callResult.getErrorInfo(), (Throwable)ex);
            return callResult;
        }
    }

    @Override
    public boolean IsEnableQuickSearch() {
        return !StringHelper.IsNullOrEmpty((String)this.GetQuickSearchMask(""));
    }

    @Override
    public String GetQuickSearchMask(String strLanguage) {
        String strText;
        String strQuickSearchMaskKey = "QUICKSEARCHMASK";
        if (!StringHelper.IsNullOrEmpty((String)strLanguage)) {
            strQuickSearchMaskKey = String.valueOf(strQuickSearchMaskKey) + "." + strLanguage;
        }
        if ((strText = this.GetProperty(strQuickSearchMaskKey, null)) != null) {
            return strText;
        }
        strText = "";
        for (IDEFHelper iDEFHelper : this.GetDEFHelpers()) {
            if (!iDEFHelper.getDEField().isACSEARCH(iDEFHelper.IsMajorDEField())) continue;
            if (!StringHelper.IsNullOrEmpty((String)strText)) {
                strText = String.valueOf(strText) + "\u3001";
            }
            strText = String.valueOf(strText) + iDEFHelper.getLogicName(strLanguage);
        }
        this.SetProperty(strQuickSearchMaskKey, strText);
        return strText;
    }

    @Override
    public boolean IsEnablePrint() {
        return this.bEnablePrint;
    }

    public static void setEnablePrintDefault(boolean bDefault) {
        bEnablePrintDefault = bDefault;
    }

    public static boolean getEnablePrintDefault() {
        return bEnablePrintDefault;
    }

    @Override
    public boolean IsEnableHelp() {
        return BaseDEHelper.getEnableHelpDefault();
    }

    public static void setEnableHelpDefault(boolean bDefault) {
        bEnableHelpDefault = bDefault;
    }

    public static boolean getEnableHelpDefault() {
        return bEnableHelpDefault;
    }

    @Override
    public boolean IsEnableImport() {
        return (this.IsEnableUserUpdate() || this.IsEnableUserCreate()) && BaseDEHelper.getEnableImportDefault();
    }

    public static void setEnableImportDefault(boolean bDefault) {
        bEnableImportDataDefault = bDefault;
    }

    public static boolean getEnableImportDefault() {
        return bEnableImportDataDefault;
    }

    @Override
    public boolean IsEnableExport() {
        return BaseDEHelper.getEnableExportDefault();
    }

    public static void setEnableExportDefault(boolean bDefault) {
        bEnableExportDataDefault = bDefault;
    }

    public static boolean getEnableExportDefault() {
        return bEnableExportDataDefault;
    }

    @Override
    public String GetDGColumns() {
        return this.strDGColumns;
    }

    @Override
    public String GetSearchableColumns() {
        return this.strSearchableColumns;
    }

    @Override
    public BaseDAQueryModelHelper GetDAQueryModelHelper(String strQMId) {
        return this.daQueryModelHelperMap.get(strQMId);
    }

    @Override
    public void RegisterDAQueryModelHelper(String strQMId, BaseDAQueryModelHelper daQueryModelHelper) {
        this.daQueryModelHelperMap.put(strQMId, daQueryModelHelper);
    }

    @Override
    public boolean IsEnableModile() {
        if (this.deMobile == null) {
            return false;
        }
        return this.deMobile.getENABLEMOBILE();
    }

    @Override
    public DEMobile GetDEMobile() {
        return this.deMobile;
    }

    @Override
    public String GetDataLockKey(ISRFDAWebContext webContext, BaseDataEntity dataEntity) throws Exception {
        return this.OnGetDataLockKey(webContext, dataEntity);
    }

    protected String OnGetDataLockKey(ISRFDAWebContext webContext, BaseDataEntity dataEntity) throws Exception {
        if (this.iDEDataLockKeyHelper != null) {
            return this.iDEDataLockKeyHelper.GetDataLockKey(webContext, this, dataEntity);
        }
        return "";
    }

    @Override
    public void LogFieldCaretTempl(BaseDataEntity dataEntity, String strOPPersonId) {
        if (this.caretTemplFields.size() == 0) {
            return;
        }
        try {
            CaretTemplHelper caretTemplHelper = CaretTemplHelper.GetCurrent(this.contextHelperEx);
            for (IDEFHelper iDEFHelper : this.caretTemplFields) {
                String strValue = dataEntity.GetParamStringValue(iDEFHelper.getName(), "");
                if (StringHelper.IsNullOrEmpty((String)strValue)) continue;
                if (StringHelper.Compare((String)iDEFHelper.getCaretRetMode(), (String)"USER", (boolean)true) != 0) {
                    caretTemplHelper.Log(iDEFHelper.getCaretTemplGroupId(), null, strValue);
                    continue;
                }
                caretTemplHelper.Log(iDEFHelper.getCaretTemplGroupId(), strOPPersonId, strValue);
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    protected void InitModel(DataEntity item) {
    }

    @Override
    public Vector<IDER1NHelper> GetDER1Ns() {
        return this.der1NHelperList;
    }

    @Override
    public Vector<IDER11Helper> GetDER11s() {
        return this.der11HelperList;
    }

    @Override
    public IDER11Helper FindDER11(String strDER11Id) throws Exception {
        String strDERId = "DER11:" + strDER11Id.toUpperCase();
        if (this.derHelperMap.containsKey(strDERId)) {
            return (IDER11Helper)this.derHelperMap.get(strDERId);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6DER11\u5173\u7cfb[%1$s]", (Object)strDER11Id));
    }

    @Override
    public IDER1NHelper FindDER1N2(String strDER1NId) throws Exception {
        String strDERId = "DER1N:" + strDER1NId.toUpperCase();
        if (this.derHelperMap.containsKey(strDERId)) {
            return (IDER1NHelper)this.derHelperMap.get(strDERId);
        }
        strDERId = "DER1NEX:" + strDER1NId.toUpperCase();
        if (this.derHelperMap.containsKey(strDERId)) {
            return (IDER1NHelper)this.derHelperMap.get(strDERId);
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6DER1N\u5173\u7cfb[%1$s]", (Object)strDER1NId));
    }

    @Override
    public boolean IsExtendDER1N(String strDER1NId) {
        String strDERId = "DER1NEX:" + strDER1NId.toUpperCase();
        return this.derHelperMap.containsKey(strDERId);
    }

    @Override
    public Vector<ISummaryPageHelper> GetSummaryPages() throws Exception {
        Vector<SummaryPage> sumpagelist = new Vector<SummaryPage>();
        CallResult callResult = this.getGlobalHelper().getDAModelHelper().GetSummaryPages(this.getId(), "DER", sumpagelist);
        if (callResult == null || callResult.getRetCode() != 0) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u7f29\u7565\u754c\u9762\u5931\u8d25\uff0c%1$s", (Object)(callResult == null ? "\u4e0d\u660e" : callResult.getErrorInfo())));
        }
        Vector<ISummaryPageHelper> list = new Vector<ISummaryPageHelper>();
        for (SummaryPage summaryPage : sumpagelist) {
            ISummaryPageHelper iSummaryPageHelper = (ISummaryPageHelper)ObjectHelper.Create((String)"SA.SRFDA.Ctrl.SummaryPageHelper");
            iSummaryPageHelper.Init(this.getGlobalHelper(), summaryPage);
            list.add(iSummaryPageHelper);
        }
        return list;
    }

    @Override
    public int GetDataChangeLogMode() {
        return this.nDEDataChangeLogMode;
    }

    @Override
    public boolean IsExportIncEmpty() {
        return this.bExportIncEmpty;
    }

    @Override
    public boolean IsEnablePwdStorage() {
        return this.bEnablePwdStorage;
    }

    @Override
    public Vector<IDEFHelper> GetPwdStorageFields() {
        return this.pwdStorageFields;
    }

    protected boolean PrepareDEMainState() {
        Vector<DEMainState> deMainStates = new Vector<DEMainState>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEMainStates(this.getId(), deMainStates);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u72b6\u6001\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u5b9e\u4f53\u4e3b\u72b6\u6001[%2$s]", (Object)this.getId(), (Object)deMainStates.size()));
        if (deMainStates.size() == 0) {
            return true;
        }
        this.deMainStateHelperMap = new Hashtable();
        for (DEMainState deMainState : deMainStates) {
            try {
                DEMainStateHelper deMainStateHelper = new DEMainStateHelper();
                deMainStateHelper.Init(this.getGlobalHelper(), this, deMainState);
                this.deMainStateHelperMap.put(deMainStateHelper.getName(), deMainStateHelper);
                if (!deMainStateHelper.isDefaultState()) continue;
                this.defaultDEMainStateHelper = deMainStateHelper;
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u4e3b\u72b6\u6001\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                return false;
            }
        }
        return true;
    }

    protected boolean PrepareDEMainAction() {
        Vector<DEMainAction> deMainActions = new Vector<DEMainAction>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEMainActions(this.getId(), deMainActions);
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u914d\u7f6e\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return false;
        }
        log.debug((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u52a0\u8f7d\u5b9e\u4f53\u4e3b\u64cd\u4f5c[%2$s]", (Object)this.getId(), (Object)deMainActions.size()));
        if (deMainActions.size() == 0) {
            return true;
        }
        this.deMainActionHelperMap = new Hashtable();
        for (DEMainAction deMainAction : deMainActions) {
            try {
                DEMainActionHelper deMainActionHelper = new DEMainActionHelper();
                deMainActionHelper.Init(this.getGlobalHelper(), this, deMainAction);
                this.deMainActionHelperMap.put(deMainActionHelper.getName(), deMainActionHelper);
                this.deMainActionHelperMap.put(deMainActionHelper.getId(), deMainActionHelper);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53\u4e3b\u64cd\u4f5c\u914d\u7f6e\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean IsEnableDEMainState() {
        return this.deMainStateHelperMap != null;
    }

    @Override
    public IDEMainStateHelper FindDEMainState(String strDEMainStateName) throws Exception {
        if (this.deMainStateHelperMap != null) {
            IDEMainStateHelper iDEMainStateHelper = this.deMainStateHelperMap.get(strDEMainStateName);
            return iDEMainStateHelper;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684[%1$s]\u4e3b\u72b6\u6001\u914d\u7f6e", (Object)strDEMainStateName));
    }

    @Override
    public IDEMainStateHelper GetDefaultDEMainState() {
        return this.defaultDEMainStateHelper;
    }

    @Override
    public IDEMainStateHelper FindDEMainState(String strPDEId, String strPDEMainStateId) {
        if (this.deMainStateHelperMap == null) {
            return null;
        }
        for (IDEMainStateHelper iDEMainStateHelper : this.deMainStateHelperMap.values()) {
            if (!iDEMainStateHelper.isMapTo(strPDEId, strPDEMainStateId)) continue;
            return iDEMainStateHelper;
        }
        return null;
    }

    @Override
    public boolean HasDEMainStateMapTo(String strPDEId) {
        if (this.deMainStateHelperMap == null) {
            return false;
        }
        for (IDEMainStateHelper iDEMainStateHelper : this.deMainStateHelperMap.values()) {
            if (!iDEMainStateHelper.isMapTo(strPDEId)) continue;
            return true;
        }
        return false;
    }

    @Override
    public final IDEMainStateHelper CalcDEMainState(Object objKey) throws Exception {
        BaseDataEntity dataEntity = new BaseDataEntity();
        dataEntity.SetParamValue(this.GetKeyDEFHelper().getName(), objKey);
        return this.CalcDEMainState(null, dataEntity);
    }

    @Override
    public final IDEMainStateHelper CalcDEMainState(BaseDataEntity dataEntity) throws Exception {
        return this.CalcDEMainState(null, dataEntity);
    }

    @Override
    public IDEMainStateHelper CalcDEMainState(Connection connection, BaseDataEntity dataEntity) throws Exception {
        if (this.deMainStateHelperMap == null) {
            return null;
        }
        CallParamList callParamList = new CallParamList();
        callParamList.Add(dataEntity.GetParamValue(this.GetKeyDEFHelper().getName()));
        BaseDataEntity retDataEntity = new BaseDataEntity();
        IDEMainStateHelper defaultMainStateHelper = null;
        for (IDEMainStateHelper iDEMainStateHelper : this.deMainStateHelperMap.values()) {
            if (iDEMainStateHelper.isDefaultState()) {
                defaultMainStateHelper = iDEMainStateHelper;
                continue;
            }
            String strSQL = iDEMainStateHelper.getStateTestSql();
            CallResult callResult = BaseDEDataCtrl.SelectSingleEx(this.getGlobalHelper(), connection, this.GetDBStorage(), strSQL, callParamList.GetList(), retDataEntity);
            if (callResult.IsOk()) {
                return iDEMainStateHelper;
            }
            if (callResult.getRetCode() == 3) continue;
            throw new Exception(StringHelper.Format((String)"\u68c0\u67e5\u5b9e\u4f53\u6570\u636e\u4e3b\u72b6\u6001\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        return defaultMainStateHelper;
    }

    @Override
    public boolean HasDEMainAction(String strDEMainActionName) {
        if (this.deMainActionHelperMap != null) {
            return this.deMainActionHelperMap.containsKey(strDEMainActionName);
        }
        return false;
    }

    @Override
    public IDEMainActionHelper FindDEMainAction(String strDEMainActionName) throws Exception {
        if (this.deMainActionHelperMap != null) {
            IDEMainActionHelper iDEMainActionHelper = this.deMainActionHelperMap.get(strDEMainActionName);
            return iDEMainActionHelper;
        }
        throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7684[%1$s]\u4e3b\u64cd\u4f5c\u914d\u7f6e", (Object)strDEMainActionName));
    }

    @Override
    public int GetIndexMode() {
        if (this.dataEntity.isINDEXMODENull()) {
            return 0;
        }
        return this.dataEntity.getINDEXMODE();
    }

    public static IDEFHelper GetIndexDERealKeyField(IDEHelper indexDEHelper) throws Exception {
        if (indexDEHelper.GetIndexMode() == 1) {
            String strDEFName = String.valueOf(indexDEHelper.GetKeyDEFHelper().getName()) + "2";
            IDEFHelper realKeyFieldHelper = indexDEHelper.GetDEFHelper(strDEFName);
            if (realKeyFieldHelper == null) {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u7d22\u5f15\u5b9e\u4f53\u5b9e\u9645\u952e\u503c\u5c5e\u6027[%1$s]", (Object)strDEFName));
            }
            return realKeyFieldHelper;
        }
        return indexDEHelper.GetKeyDEFHelper();
    }

    public static String GetIndexDEKeyValueWithType(DERINDEX derIndex, Object objValue) {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)derIndex.getTYPEVALUE(), (Object)objValue);
    }

    public static String GetIndexDEKeyValueWithType(String strTypeValue, Object objValue) {
        return StringHelper.Format((String)"%1$s|%2$s", (Object)strTypeValue, (Object)objValue);
    }

    @Override
    public IDERGroupHelper FindDERGroup(String strDERGroupId) throws Exception {
        strDERGroupId = strDERGroupId.toUpperCase();
        if (this.derGroupHelperMap == null || !this.derGroupHelperMap.containsKey(strDERGroupId)) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a[%1$s]\u5173\u7cfb\u5206\u7ec4", (Object)strDERGroupId));
        }
        return this.derGroupHelperMap.get(strDERGroupId);
    }

    @Override
    public String GetDEWFFormName(String strWFMode, String strWFStep, IDESubWFHelper iDESubWFHelper, String strSubWFStep) throws Exception {
        return this.OnGetDEWFFormName(strWFMode, strWFStep, iDESubWFHelper, strSubWFStep);
    }

    protected String OnGetDEWFFormName(String strWFMode, String strWFStep, IDESubWFHelper iDESubWFHelper, String strSubWFStep) throws Exception {
        if (iDESubWFHelper != null) {
            return iDESubWFHelper.getWFFormName(strWFMode, strWFStep, strSubWFStep);
        }
        String strWFId = this.GetDEWFId(strWFMode);
        IDEWFDetailHelper iDEWFDetailHelper = this.deWFDetailMap.get(strWFMode);
        if (iDEWFDetailHelper != null) {
            return iDEWFDetailHelper.getWFFormName(strWFStep);
        }
        String strWFFormName = StringHelper.Format((String)"WFFORM_STEP_%1$s", (Object)strWFStep);
        return strWFFormName;
    }

    protected IDEWFDetailHelper OnCreateDEWFDetailHelper(DEWFDetail deWFDetail) {
        return new DEWFDetailHelper();
    }

    @Override
    public void SetAttribute(String strKey, Object objValue) {
        if (objValue == null) {
            this.attributeMap.remove(strKey);
        } else {
            this.attributeMap.put(strKey, objValue);
        }
    }

    @Override
    public Object GetAttribute(String strKey) {
        return this.attributeMap.get(strKey);
    }

    @Override
    public boolean IsEnableEncryptStorage() {
        return this.bEnableEncryptStorage;
    }

    @Override
    public Vector<IDEFHelper> GetEncryptStorageFields() {
        return this.encryptStorageFields;
    }

    @Override
    public IDataNotifyHelper GetDataNotifyHelper(DataNotify dataNotify) {
        if (dataNotify == null) {
            return this.dataNotifyHelperMap.get("");
        }
        IDataNotifyHelper iDataNotifyHelper = this.dataNotifyHelperMap.get(dataNotify.getDATANOTIFYID());
        if (iDataNotifyHelper != null) {
            return iDataNotifyHelper;
        }
        return this.dataNotifyHelperMap.get("");
    }

    @Override
    public boolean IsMultiMajorDE() {
        return this.bMultiMajorMode;
    }

    @Override
    public String CalcMajorDEPickupField(BaseDataEntity dataEntity) {
        for (String strKeyFieldName : this.multiMajorDERMap.keySet()) {
            if (dataEntity.IsParamNull(strKeyFieldName)) continue;
            return strKeyFieldName;
        }
        return "";
    }

    @Override
    public String GetMajorDEId(String strMajorDEPickupField) {
        DER1N der1N = this.multiMajorDERMap.get(strMajorDEPickupField);
        if (der1N == null) {
            return this.strMajorDEId;
        }
        return der1N.getMAJORDEID();
    }

    @Override
    public String GetMajorDERId(String strMajorDEPickupField) {
        DER1N der1N = this.multiMajorDERMap.get(strMajorDEPickupField);
        if (der1N == null) {
            return this.strMajorDERId;
        }
        return der1N.getDERID();
    }

    @Override
    public String GetMajorDERType(String strMajorDEPickupField) {
        return "N1";
    }

    @Override
    public IDEHelper GetMajorDEHelper(String strMajorDEPickupField) {
        String strMajorDEId = this.GetMajorDEId(strMajorDEPickupField);
        if (StringHelper.Compare((String)strMajorDEId, (String)this.getId(), (boolean)true) == 0) {
            return this;
        }
        return this.contextHelperEx.getDAModelStorage().FindDEHelper(strMajorDEId);
    }

    @Override
    public boolean IsMajorDE() {
        return this.bMajorDE;
    }

    @Override
    public boolean HasPhisicalFormulaField() {
        return this.bHasPhisicalFormulaField;
    }

    @Override
    public boolean GetValidFlag() {
        return this.bValidFlag;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public String GetRuntimeInfo() {
        String string = this.strRuntimeInfo;
        synchronized (string) {
            if (!StringHelper.IsNullOrEmpty((String)this.strRuntimeInfo)) {
                return this.strRuntimeInfo;
            }
            this.strRuntimeInfo = this.OnCalcRuntimeInfoString();
            return this.strRuntimeInfo;
        }
    }

    protected String OnCalcRuntimeInfoString() {
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("\u5b9e\u4f53[%1$s] \u7248\u672c[%2$s]\r\n", (Object)this.GetFullName(), (Object)this.getVersion());
        sb.Append("\u5b9e\u4f53\u8f85\u52a9\u5bf9\u8c61[%1$s]\r\n", (Object)this.getClass().getName());
        sb.Append("\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61[%1$s]\r\n", (Object)this.GetDataCtrlObject());
        if (this.GetDataAccHelper() != null) {
            sb.Append("\u8bbf\u95ee\u63a7\u5236\u5bf9\u8c61[%1$s]\r\n", (Object)this.GetDataAccHelper().getClass().getName());
        }
        sb.Append("\r\n\u6807\u51c6\u5b58\u50a8\u8fc7\u7a0b\r\n");
        sb.Append("\u63d2\u5165\u8fc7\u7a0b[%1$s]\r\n", (Object)this.GetInsertProcName());
        sb.Append("\u66f4\u65b0\u8fc7\u7a0b[%1$s]\r\n", (Object)this.GetUpdateProcName());
        sb.Append("\u5220\u9664\u8fc7\u7a0b[%1$s]\r\n", (Object)this.GetDeleteProcName());
        sb.Append("\r\n\u6807\u51c6\u67e5\u8be2\u8bed\u53e5\r\n");
        Vector<ProcParam> procParams = new Vector<ProcParam>();
        sb.Append("[%1$s]\r\n", (Object)this.GetSelectCode(procParams));
        return sb.toString();
    }

    @Override
    public boolean IsEnableVersionControl() {
        return this.bEnableVersionControl;
    }

    @Override
    public Object getKeyValue(BaseDataEntity dataEntity) {
        if (this.keyParams == null || this.keyParams.length == 0 || this.keyParams.length > 4) {
            return null;
        }
        String[] params = new String[this.keyParams.length];
        int i = 0;
        while (i < this.keyParams.length) {
            String strValue = dataEntity.getParamStringValue(this.keyParams[i], "");
            if (StringHelper.IsNullOrEmpty((String)strValue)) {
                return null;
            }
            params[i] = strValue;
            ++i;
        }
        switch (this.keyParams.length) {
            case 1: {
                return dataEntity.getParamValue(this.keyParams[0]);
            }
            case 2: {
                return Helper.GenUniqueId((String)params[0], (String)params[1]);
            }
            case 3: {
                return Helper.GenUniqueId((String)params[0], (String)params[1], (String)params[2]);
            }
        }
        return Helper.GenUniqueId((String)params[0], (String)params[1], (String)params[2], (String)params[3]);
    }

    private class SelectQueryModel {
        public BaseDAQueryModelHelper baseDAQueryModelHelper = null;
        public String strSelectCode = "";

        private SelectQueryModel() {
        }
    }
}
