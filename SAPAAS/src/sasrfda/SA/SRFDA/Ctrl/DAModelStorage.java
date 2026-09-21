/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.CodeList.CodeListConfig
 *  SA.SRFramework.CodeList.ICodeListFiller
 *  SA.SRFramework.CodeList.ICodeListFiller2
 *  SA.SRFramework.CodeList.ICodeListQuery
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Base64
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  SA.SRFramework.UtilityEx.PropertiesHelper
 *  SA.SRFramework.WebEx.Data.WebDBCallerHelperEx
 *  SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.bouncycastle.jce.provider.BouncyCastleProvider
 */
package SA.SRFDA.Ctrl;

import SA.SRFDA.Ctrl.BaseDAQueryModelHelper;
import SA.SRFDA.Ctrl.CounterGlobalModel;
import SA.SRFDA.Ctrl.CounterTypeGlobalModel;
import SA.SRFDA.Ctrl.DAModelVersionHelper;
import SA.SRFDA.Ctrl.DEBHGroupGlobalModel;
import SA.SRFDA.Ctrl.DEBehaviorGlobalModel;
import SA.SRFDA.Ctrl.DEDataCtrl.DataLockDataCtrl;
import SA.SRFDA.Ctrl.DEDataCtrl.IPageDataCtrl;
import SA.SRFDA.Ctrl.DERGroupFolderGlobalModel;
import SA.SRFDA.Ctrl.DERModeGlobalModel;
import SA.SRFDA.Ctrl.DERTypeGlobalModel;
import SA.SRFDA.Ctrl.DETBBHandlerGlobalModel;
import SA.SRFDA.Ctrl.Data.CodeList;
import SA.SRFDA.Ctrl.Data.DBStorage;
import SA.SRFDA.Ctrl.Data.DEBHGroup;
import SA.SRFDA.Ctrl.Data.DEBehavior;
import SA.SRFDA.Ctrl.Data.DataEntity;
import SA.SRFDA.Ctrl.Data.DataGrid;
import SA.SRFDA.Ctrl.Data.DevImage;
import SA.SRFDA.Ctrl.Data.FIUpdate;
import SA.SRFDA.Ctrl.Data.Form;
import SA.SRFDA.Ctrl.Data.GSR2;
import SA.SRFDA.Ctrl.Data.GSRGroupColumn;
import SA.SRFDA.Ctrl.Data.GSRMeasure;
import SA.SRFDA.Ctrl.Data.GroupStatisticsRep;
import SA.SRFDA.Ctrl.Data.MBPanel;
import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Ctrl.Data.PageLogic;
import SA.SRFDA.Ctrl.Data.PageParamFolder;
import SA.SRFDA.Ctrl.Data.PageParamType;
import SA.SRFDA.Ctrl.Data.QueryModel;
import SA.SRFDA.Ctrl.Data.SubSystem;
import SA.SRFDA.Ctrl.Data.TBTempl;
import SA.SRFDA.Ctrl.Data.THGroup;
import SA.SRFDA.Ctrl.Data.Toolbar;
import SA.SRFDA.Ctrl.Data.TreeView;
import SA.SRFDA.Ctrl.Data.ValueRule;
import SA.SRFDA.Ctrl.DataSync.ISyncAgentTypeHelper;
import SA.SRFDA.Ctrl.DataSync.SyncAgentTypeGlobalModel;
import SA.SRFDA.Ctrl.DefaultDAGlobalModel;
import SA.SRFDA.Ctrl.DefaultDBStorage;
import SA.SRFDA.Ctrl.DevImageHelper;
import SA.SRFDA.Ctrl.GSR2Helper;
import SA.SRFDA.Ctrl.ICounterHelper;
import SA.SRFDA.Ctrl.ICounterTypeHelper;
import SA.SRFDA.Ctrl.IDAGlobalModel;
import SA.SRFDA.Ctrl.IDAModelHelper;
import SA.SRFDA.Ctrl.IDAModelStorage;
import SA.SRFDA.Ctrl.IDASubSystemHelper;
import SA.SRFDA.Ctrl.IDBStorage;
import SA.SRFDA.Ctrl.IDEBehaviorHelper;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Ctrl.IDEDataCtrlHelper;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFDA.Ctrl.IDERGroupFolderHelper;
import SA.SRFDA.Ctrl.IDERModeHelper;
import SA.SRFDA.Ctrl.IDERTypeHelper;
import SA.SRFDA.Ctrl.ILayoutItemHelper;
import SA.SRFDA.Ctrl.IPageHelper;
import SA.SRFDA.Ctrl.LayoutItemlGlobalModel;
import SA.SRFDA.Ctrl.MBPanelGlobalModel;
import SA.SRFDA.Ctrl.ORG.IORGTreeNodeTypeHelper;
import SA.SRFDA.Ctrl.ORG.IORGTreeTypeHelper;
import SA.SRFDA.Ctrl.ORG.IORGUnitTypeHelper;
import SA.SRFDA.Ctrl.ORG.ORGTreeNodeTypeGlobalModel;
import SA.SRFDA.Ctrl.ORG.ORGTreeTypeGlobalModel;
import SA.SRFDA.Ctrl.ORG.ORGUnitTypeGlobalModel;
import SA.SRFDA.Ctrl.PageParamFolderGlobalModel;
import SA.SRFDA.Ctrl.PageParamTypeGlobalModel;
import SA.SRFDA.Ctrl.TBTemplGlobalModel;
import SA.SRFDA.Ctrl.ThresholdGroupGlobalModel;
import SA.SRFDA.Ctrl.ToolbarGlobalModel;
import SA.SRFDA.Ctrl.TreeViewGlobalModel;
import SA.SRFDA.Ctrl.UIGearGlobalModelHelper;
import SA.SRFDA.Ctrl.ValueRuleGlobalHelper;
import SA.SRFDA.Model.DGModelMainQueryConfig;
import SA.SRFDA.Security.IRCAccListHelper;
import SA.SRFDA.Security.RCAccListGlobalModel;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.UIGear.IUIGear;
import SA.SRFDA.Web.Utility.GlobalHelperEx;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.CodeList.CodeListConfig;
import SA.SRFramework.CodeList.ICodeListFiller;
import SA.SRFramework.CodeList.ICodeListFiller2;
import SA.SRFramework.CodeList.ICodeListQuery;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import SA.SRFramework.WebEx.Data.WebDBCallerHelperEx;
import SA.SRFramework.WebEx.Utility.ISRFExGlobalHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public final class DAModelStorage
implements IDAModelStorage {
    private final Hashtable<String, IDEHelper> deHelperMap = new Hashtable();
    private final Hashtable<String, Long> deHelperRenewMap = new Hashtable();
    private static final String TAG_LICENSEKEY = "{49A0D78B-8D96-4EEF-A29A-C98BE65D0321}";
    private static final String TAG_LICENSEPWD = "{715009AA-5AC8-45B6-B2BE-0AC1A7354FE3}";
    private static final String strRSAPubKey1 = "H4sIAAAAAAAAAAGBAH7/AKovW9ViNR6tr3ZyQlvhJ1YL7HDjvLNVzTW/nZZqveKOAB+Mn+TO2eRcHXhVnhFILQaKfJaYLePjCfFTvVryJwzHEwmea8bFoFyz3bc6nOeJ+G2/SF/wH4TQMjS7k0fkEh4C85ldJvfb3TsNGbqAtxeYtul5vytteKNeOS6+85K/L4JjjoEAAAA=";
    private static final String strRSAPubKey2 = "H4sIAAAAAAAAAGNkYAQAs4OEiQMAAAA=";
    private int nUserBOCount = 200;
    private Hashtable<String, String> licenseDEMap = new Hashtable();
    private Hashtable<String, String> userLicenseDEMap = new Hashtable();
    private boolean bGA = true;
    private boolean bGA2 = false;
    private IDAModelHelper iDAModelHelper = null;
    protected ISRFDAGlobalHelper contextHelperEx = null;
    protected int DERENEWTIMER = 5000;
    protected int PAGERENEWTIMER = 5000;
    protected int QMRENEWTIMER = 5000;
    protected int DEMFRENEWTIMER = 5000;
    protected int FIUPDATERENEWTIMER = 5000;
    protected int GSRRENEWTIMER = 5000;
    private static final Log log = LogFactory.getLog(DAModelStorage.class);
    private final Hashtable<String, CodeListConfig> codeListMap = new Hashtable();
    private final Hashtable<String, String> codeListOriginMap = new Hashtable();
    private Hashtable<String, IDBStorage> dbStorageMap = null;
    private final Hashtable<String, Page> pageMap = new Hashtable();
    private final Hashtable<String, Long> pageRenewMap = new Hashtable();
    private final Hashtable<String, IPageHelper> pageHelperMap = new Hashtable();
    private final Hashtable<String, QueryModel> queryModelMap = new Hashtable();
    private final Hashtable<String, Long> queryModelRenewMap = new Hashtable();
    private final Hashtable<String, Form> deMainFormMap = new Hashtable();
    private final Hashtable<String, Long> deMainFormRenewMap = new Hashtable();
    private final Hashtable<String, FIUpdate> fiUpdateMap = new Hashtable();
    private final Hashtable<String, Long> fiUpdateRenewMap = new Hashtable();
    private final Hashtable<String, GroupStatisticsRep> gsrMap = new Hashtable();
    private final Hashtable<String, Long> gsrRenewMap = new Hashtable();
    private DataLockDataCtrl dataLockDataCtrl = null;
    private IDEDataCtrl sessionDataDataCtrl = null;
    protected boolean bEnableJSPageFunc = false;
    private DAModelVersionHelper daModelVersionHelper = new DAModelVersionHelper();
    private ThresholdGroupGlobalModel thresholdGroupHelper = new ThresholdGroupGlobalModel();
    private TreeViewGlobalModel treeViewHelper = new TreeViewGlobalModel();
    private ValueRuleGlobalHelper valueRuleHelper = new ValueRuleGlobalHelper();
    private GSR2Helper gsr2Helper = new GSR2Helper();
    private DevImageHelper devImageHelper = new DevImageHelper();
    private TBTemplGlobalModel tbTemplHelper = new TBTemplGlobalModel();
    private ToolbarGlobalModel toolbarHelper = new ToolbarGlobalModel();
    private DEBehaviorGlobalModel deBehaviorHelper = new DEBehaviorGlobalModel();
    private PageParamTypeGlobalModel pageParamTypeHelper = new PageParamTypeGlobalModel();
    private PageParamFolderGlobalModel pageParamFolderHelper = new PageParamFolderGlobalModel();
    private DEBHGroupGlobalModel deBHGroupHelper = new DEBHGroupGlobalModel();
    private UIGearGlobalModelHelper uiGearHelper = new UIGearGlobalModelHelper();
    private MBPanelGlobalModel mbPanelGlobalModel = new MBPanelGlobalModel();
    private DERModeGlobalModel derModeGlobalModel = new DERModeGlobalModel();
    private DERTypeGlobalModel derTypeGlobalModel = new DERTypeGlobalModel();
    private DERGroupFolderGlobalModel derGroupFolderGlobalModel = new DERGroupFolderGlobalModel();
    private SyncAgentTypeGlobalModel syncAgentTypeGlobalModel = new SyncAgentTypeGlobalModel();
    private DETBBHandlerGlobalModel deTBBHandlerGlobalModel = new DETBBHandlerGlobalModel();
    private ORGUnitTypeGlobalModel orgUnitTypeGlobalModel = new ORGUnitTypeGlobalModel();
    private ORGTreeTypeGlobalModel orgTreeTypeGlobalModel = new ORGTreeTypeGlobalModel();
    private ORGTreeNodeTypeGlobalModel orgTreeNodeTypeGlobalModel = new ORGTreeNodeTypeGlobalModel();
    private RCAccListGlobalModel rcAccListGlobalModel = new RCAccListGlobalModel();
    private CounterTypeGlobalModel counterTypeGlobalModel = new CounterTypeGlobalModel();
    private CounterGlobalModel counterGlobalModel = new CounterGlobalModel();
    private LayoutItemlGlobalModel layoutItemlGlobalModel = new LayoutItemlGlobalModel();
    private Hashtable<String, IDAGlobalModel> globalModelMap = new Hashtable();
    private Hashtable<String, IDEDataCtrl> globalDEDataCtrlMap = new Hashtable();
    private Hashtable<String, String> licenseProductMap = new Hashtable();
    private ArrayList<IDASubSystemHelper> subSystemHelperList = new ArrayList();

    public DAModelStorage(IDAModelHelper iDAModelHelper, ISRFDAGlobalHelper contextHelperEx) {
        this.iDAModelHelper = iDAModelHelper;
        this.contextHelperEx = contextHelperEx;
        this.bEnableJSPageFunc = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "PAGEFUNC", false);
        this.DERENEWTIMER = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "DERENEWTIMER", this.DERENEWTIMER);
        if (this.DERENEWTIMER < 5000) {
            this.DERENEWTIMER = 5000;
        }
        this.PAGERENEWTIMER = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "PAGERENEWTIMER", this.PAGERENEWTIMER);
        if (this.PAGERENEWTIMER < 5000) {
            this.PAGERENEWTIMER = 5000;
        }
        this.QMRENEWTIMER = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "QMRENEWTIMER", this.QMRENEWTIMER);
        if (this.QMRENEWTIMER < 5000) {
            this.QMRENEWTIMER = 5000;
        }
        this.DEMFRENEWTIMER = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "DEMFRENEWTIMER", this.DEMFRENEWTIMER);
        if (this.DEMFRENEWTIMER < 5000) {
            this.DEMFRENEWTIMER = 5000;
        }
        this.FIUPDATERENEWTIMER = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "FIUPDATERENEWTIMER", this.FIUPDATERENEWTIMER);
        if (this.FIUPDATERENEWTIMER < 5000) {
            this.FIUPDATERENEWTIMER = 5000;
        }
        this.GSRRENEWTIMER = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "GSRRENEWTIMER", this.GSRRENEWTIMER);
        if (this.GSRRENEWTIMER < 5000) {
            this.GSRRENEWTIMER = 5000;
        }
        this.bGA2 = this.bGA;
        if (this.bGA) {
            this.InitLicense();
        }
        if (contextHelperEx.getWebExConfig().GetValue("SRFDA", "MULTIDBSTORAGE", false)) {
            this.OnPrepareDBStorage();
        }
    }

    @Override
    public CallResult Init() {
        this.daModelVersionHelper = new DAModelVersionHelper();
        this.daModelVersionHelper.Init(this.contextHelperEx);
        this.derGroupFolderGlobalModel.Init(this.contextHelperEx);
        this.thresholdGroupHelper.Init(this.contextHelperEx);
        this.treeViewHelper.Init(this.contextHelperEx);
        this.gsr2Helper.Init(this.contextHelperEx);
        this.valueRuleHelper.Init(this.contextHelperEx);
        this.devImageHelper.Init(this.contextHelperEx);
        this.tbTemplHelper.Init(this.contextHelperEx);
        this.toolbarHelper.Init(this.contextHelperEx);
        this.deBehaviorHelper.Init(this.contextHelperEx);
        this.pageParamTypeHelper.Init(this.contextHelperEx);
        this.pageParamFolderHelper.Init(this.contextHelperEx);
        this.deBHGroupHelper.Init(this.contextHelperEx);
        this.uiGearHelper.Init(this.contextHelperEx);
        this.mbPanelGlobalModel.Init(this.contextHelperEx);
        this.derModeGlobalModel.Init(this.contextHelperEx);
        this.derTypeGlobalModel.Init(this.contextHelperEx);
        this.syncAgentTypeGlobalModel.Init(this.contextHelperEx);
        this.deTBBHandlerGlobalModel.Init(this.contextHelperEx);
        this.orgUnitTypeGlobalModel.Init(this.contextHelperEx);
        this.orgTreeTypeGlobalModel.Init(this.contextHelperEx);
        this.orgTreeNodeTypeGlobalModel.Init(this.contextHelperEx);
        this.rcAccListGlobalModel.Init(this.contextHelperEx);
        this.counterTypeGlobalModel.Init(this.contextHelperEx);
        this.counterGlobalModel.Init(this.contextHelperEx);
        this.layoutItemlGlobalModel.Init(this.contextHelperEx);
        CallResult callResult = this.InitGlobalModel();
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5168\u5c40\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        callResult = this.InitSubSystem();
        if (callResult.IsError()) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b50\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return callResult;
        }
        return callResult;
    }

    protected CallResult InitGlobalModel() {
        Vector<DataEntity> dataEntities = new Vector<DataEntity>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDEGlobalModels(dataEntities);
        if (callResult.IsError()) {
            return callResult;
        }
        for (DataEntity dataEntity : dataEntities) {
            IDEHelper iDEHelper = this.FindDEHelper(dataEntity.getDEID());
            if (iDEHelper == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dataEntity.getDEID()));
                continue;
            }
            String strGlobalModelObj = iDEHelper.getDataEntity().getGLOBALMODELOBJ();
            if (StringHelper.IsNullOrEmpty((String)strGlobalModelObj)) {
                DefaultDAGlobalModel defaultDAGlobalModel = new DefaultDAGlobalModel();
                callResult = defaultDAGlobalModel.Init(this.contextHelperEx, iDEHelper);
                if (callResult.IsError()) {
                    log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53[%1$s] DefaultDAGlobalModel \u5931\u8d25\uff0c%2$s", (Object)dataEntity.getDEID(), (Object)callResult.getErrorInfo()));
                    continue;
                }
                this.globalModelMap.put(dataEntity.getDEID(), defaultDAGlobalModel);
                continue;
            }
            Object objDAGlobalModel = ObjectHelper.Create((String)strGlobalModelObj);
            if (objDAGlobalModel == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u5168\u5c40\u6a21\u578b\u5b58\u50a8\u5bf9\u8c61[%1$s]", (Object)strGlobalModelObj));
                continue;
            }
            if (!(objDAGlobalModel instanceof IDAGlobalModel)) {
                log.error((Object)StringHelper.Format((String)"\u5168\u5c40\u6a21\u578b\u5b58\u50a8\u5bf9\u8c61[%1$s]\u4e0d\u6b63\u786e", (Object)strGlobalModelObj));
                continue;
            }
            IDAGlobalModel iDAGlobalModel = (IDAGlobalModel)objDAGlobalModel;
            callResult = iDAGlobalModel.Init(this.contextHelperEx);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b9e\u4f53[%1$s] DefaultDAGlobalModel \u5931\u8d25\uff0c%2$s", (Object)dataEntity.getDEID(), (Object)callResult.getErrorInfo()));
                continue;
            }
            this.globalModelMap.put(dataEntity.getDEID(), iDAGlobalModel);
        }
        return new CallResult();
    }

    protected CallResult InitSubSystem() {
        try {
            Vector<SubSystem> subSystemList = new Vector<SubSystem>();
            CallResult callResult = this.contextHelperEx.getDAModelHelper().GetSubSystems(subSystemList);
            if (callResult.IsError()) {
                log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u5b50\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                return callResult;
            }
            for (SubSystem subSystem : subSystemList) {
                if (StringHelper.IsNullOrEmpty((String)subSystem.getHELPEROBJECT())) continue;
                IDASubSystemHelper iDASubSystemHelper = (IDASubSystemHelper)ObjectHelper.Create((String)subSystem.getHELPEROBJECT());
                iDASubSystemHelper.Init(this.contextHelperEx, subSystem);
                this.subSystemHelperList.add(iDASubSystemHelper);
            }
        }
        catch (Exception ex) {
            CallResult callResult = new CallResult();
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
        return new CallResult();
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelper(String strQueryModelId) {
        return this.FindDAQueryModelHelperEx(strQueryModelId, false);
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String strQueryModelId, boolean bDeleteMode) {
        QueryModel queryModel = new QueryModel();
        CallResult callResult = this.GetQueryModel(strQueryModelId, queryModel, true);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strQueryModelId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return this.FindDAQueryModelHelperEx(queryModel, bDeleteMode);
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelper(QueryModel queryModel) {
        return this.FindDAQueryModelHelperEx(queryModel, false);
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(QueryModel queryModel, boolean bDeleteMode) {
        IDEHelper iDEHelper = this.FindDEHelper(queryModel.getDEID());
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)queryModel.getDEID()));
            return null;
        }
        String strDAQueryModeHelperId = StringHelper.Format((String)"%1$s_%2$s_%3$s%4$s", (Object)queryModel.getQUERYMODELID(), (Object)queryModel.getQMVERSION(), (Object)iDEHelper.getDataEntity().getDEVERSION(), (Object)(bDeleteMode ? "_DELETE" : ""));
        String strQMId = StringHelper.Format((String)"QM_%1$s%2$s", (Object)queryModel.getQUERYMODELID(), (Object)(bDeleteMode ? "_DELETE" : ""));
        BaseDAQueryModelHelper daQueryModelHelper = null;
        daQueryModelHelper = iDEHelper.GetDAQueryModelHelper(strQMId);
        if (daQueryModelHelper != null && StringHelper.Compare((String)daQueryModelHelper.getDAQueryModelHelperId(), (String)strDAQueryModeHelperId, (boolean)true) == 0) {
            return daQueryModelHelper;
        }
        daQueryModelHelper = queryModel.isRAWMODE() ? this.GetDAQueryModelHelperRawCodeMode(iDEHelper, queryModel, queryModel.getQUERYOBJECT()) : this.GetDAQueryModelHelper(iDEHelper, queryModel.getQueryModelConfig(), null, queryModel.getQUERYOBJECT(), bDeleteMode);
        if (daQueryModelHelper != null) {
            daQueryModelHelper.setDAQueryModelHelperId(strDAQueryModeHelperId);
            iDEHelper.RegisterDAQueryModelHelper(strQMId, daQueryModelHelper);
        }
        return daQueryModelHelper;
    }

    @Override
    public BaseDAQueryModelHelper GetDAQueryModelHelper(String strDEId, DGModelMainQueryConfig mainQueryConfig) {
        IDEHelper iDEHelper = this.FindDEHelper(strDEId);
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)strDEId));
            return null;
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        daQueryModelHelper = this.GetDAQueryModelHelper(iDEHelper, mainQueryConfig, null, "", false);
        return daQueryModelHelper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetQueryModel(String strQueryModelId) {
        Hashtable<String, QueryModel> hashtable = this.queryModelMap;
        synchronized (hashtable) {
            this.queryModelRenewMap.remove(strQueryModelId);
            this.queryModelMap.remove(strQueryModelId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult GetQueryModel(String strQueryModelId, QueryModel queryModel, boolean bCache) {
        QueryModel srcQueryModel;
        Long curTime = new Date().getTime();
        if (bCache) {
            srcQueryModel = null;
            Hashtable<String, QueryModel> hashtable = this.queryModelMap;
            synchronized (hashtable) {
                if (this.queryModelMap.containsKey(strQueryModelId) && curTime - this.queryModelRenewMap.get(strQueryModelId) < (long)this.QMRENEWTIMER) {
                    srcQueryModel = this.queryModelMap.get(strQueryModelId);
                }
            }
            if (srcQueryModel != null) {
                srcQueryModel.CopyTo(queryModel, true);
                return new CallResult();
            }
        }
        srcQueryModel = new QueryModel();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetQueryModel(strQueryModelId, srcQueryModel);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strQueryModelId, (Object)callResult.getErrorInfo()));
            return null;
        }
        Hashtable<String, QueryModel> hashtable = this.queryModelMap;
        synchronized (hashtable) {
            this.queryModelRenewMap.put(strQueryModelId, new Date().getTime());
            this.queryModelMap.put(strQueryModelId, srcQueryModel);
        }
        srcQueryModel.CopyTo(queryModel, true);
        return callResult;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void ResetDEMainForm(String strDEId) {
        Hashtable<String, Form> hashtable = this.deMainFormMap;
        synchronized (hashtable) {
            this.deMainFormRenewMap.remove(strDEId);
            this.deMainFormMap.remove(strDEId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CallResult GetDEMainForm(String strDEId, Form form, boolean bCache) {
        Form srcForm;
        Long curTime = new Date().getTime();
        if (bCache) {
            srcForm = null;
            Hashtable<String, Form> hashtable = this.deMainFormMap;
            synchronized (hashtable) {
                if (this.deMainFormMap.containsKey(strDEId) && curTime - this.deMainFormRenewMap.get(strDEId) < (long)this.DEMFRENEWTIMER) {
                    srcForm = this.deMainFormMap.get(strDEId);
                }
            }
            if (srcForm != null) {
                srcForm.CopyTo(form, true);
                return new CallResult();
            }
        }
        srcForm = new Form();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDefaultDEMainForm(strDEId, srcForm);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]\u9ed8\u8ba4\u8868\u5355\u89c6\u56fe\u5931\u8d25,%2$s", (Object)strDEId, (Object)callResult.getErrorInfo()));
            return callResult;
        }
        Hashtable<String, Form> hashtable = this.deMainFormMap;
        synchronized (hashtable) {
            this.deMainFormRenewMap.put(strDEId, new Date().getTime());
            this.deMainFormMap.put(strDEId, srcForm);
        }
        srcForm.CopyTo(form, true);
        return callResult;
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelper(String strQueryModelId, DataGrid gridView) {
        return this.FindDAQueryModelHelperEx(strQueryModelId, gridView, false);
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(String strQueryModelId, DataGrid gridView, boolean bDeleteMode) {
        IDEHelper iDEHelper = this.FindDEHelper(gridView.getDEID());
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)gridView.getDEID()));
            return null;
        }
        QueryModel queryModel = new QueryModel();
        CallResult callResult = this.GetQueryModel(strQueryModelId, queryModel, true);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strQueryModelId, (Object)callResult.getErrorInfo()));
            return null;
        }
        if (StringHelper.Compare((String)queryModel.getDEID(), (String)iDEHelper.getId(), (boolean)true) != 0) {
            log.error((Object)StringHelper.Format((String)"\u67e5\u8be2\u6a21\u578b\u6570\u636e\u5bf9\u8c61[%1$s]\u4e0e\u8868\u683c\u6a21\u578b\u6570\u636e\u5bf9\u8c61[%2$s]\u4e00\u81f4", (Object)queryModel.getDEID(), (Object)iDEHelper.getId()));
            return null;
        }
        boolean bOptimize = gridView.getOptimizeQueryMode();
        String strDAQueryModeHelperId = StringHelper.Format((String)"%1$s_%2$s_%3$s_%4$s_%5$s%6$s", (Object)gridView.getDATAGRIDID(), (Object)gridView.getDGVERSION(), (Object)iDEHelper.getDataEntity().getDEVERSION(), (Object)strQueryModelId, (Object)queryModel.getQMVERSION(), (Object)(bDeleteMode ? "_DELETE" : ""));
        if (bOptimize) {
            strDAQueryModeHelperId = String.valueOf(strDAQueryModeHelperId) + "_O";
        }
        String strGridViewId = StringHelper.Format((String)"DG_%1$s_%2$s%3$s", (Object)gridView.getDATAGRIDID(), (Object)strQueryModelId, (Object)(bDeleteMode ? "_DELETE" : ""));
        if (bOptimize) {
            strGridViewId = String.valueOf(strGridViewId) + "_O";
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        daQueryModelHelper = iDEHelper.GetDAQueryModelHelper(strGridViewId);
        if (daQueryModelHelper != null && StringHelper.Compare((String)daQueryModelHelper.getDAQueryModelHelperId(), (String)strDAQueryModeHelperId, (boolean)true) == 0) {
            return daQueryModelHelper;
        }
        DGModelMainQueryConfig mainQueryConfig = null;
        if (gridView.getDataGridModelConfig() != null) {
            mainQueryConfig = gridView.getDataGridModelConfig().getMainQueryConfig();
        }
        if ((daQueryModelHelper = this.GetDAQueryModelHelper(iDEHelper, queryModel.getQueryModelConfig(), mainQueryConfig, queryModel.getQUERYOBJECT(), bDeleteMode)) != null) {
            daQueryModelHelper.setDAQueryModelHelperId(strDAQueryModeHelperId);
            iDEHelper.RegisterDAQueryModelHelper(strGridViewId, daQueryModelHelper);
        }
        return daQueryModelHelper;
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelper(DataGrid gridView) {
        return this.FindDAQueryModelHelperEx(gridView, false);
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelperEx(DataGrid gridView, boolean bDeleteMode) {
        IDEHelper iDEHelper = this.FindDEHelper(gridView.getDEID());
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25", (Object)gridView.getDEID()));
            return null;
        }
        boolean bOptimize = gridView.getOptimizeQueryMode();
        String strDAQueryModeHelperId = StringHelper.Format((String)"%1$s_%2$s_%3$s%4$s", (Object)gridView.getDATAGRIDID(), (Object)gridView.getDGVERSION(), (Object)iDEHelper.getVersion(), (Object)(bDeleteMode ? "_DELETE" : ""));
        if (bOptimize) {
            strDAQueryModeHelperId = String.valueOf(strDAQueryModeHelperId) + "_O";
        }
        String strGridViewId = StringHelper.Format((String)"DG_%1$s%2$s", (Object)gridView.getDATAGRIDID(), (Object)(bDeleteMode ? "_DELETE" : ""));
        if (bOptimize) {
            strGridViewId = String.valueOf(strGridViewId) + "_O";
        }
        BaseDAQueryModelHelper daQueryModelHelper = null;
        daQueryModelHelper = iDEHelper.GetDAQueryModelHelper(strGridViewId);
        if (daQueryModelHelper != null && StringHelper.Compare((String)daQueryModelHelper.getDAQueryModelHelperId(), (String)strDAQueryModeHelperId, (boolean)true) == 0) {
            return daQueryModelHelper;
        }
        DGModelMainQueryConfig mainQueryConfig = null;
        if (gridView.getDataGridModelConfig() != null) {
            mainQueryConfig = gridView.getDataGridModelConfig().getMainQueryConfig();
        }
        if ((daQueryModelHelper = this.GetDAQueryModelHelper(iDEHelper, mainQueryConfig, bDeleteMode)) != null) {
            daQueryModelHelper.setDAQueryModelHelperId(strDAQueryModeHelperId);
            iDEHelper.RegisterDAQueryModelHelper(strGridViewId, daQueryModelHelper);
        }
        return daQueryModelHelper;
    }

    @Override
    public BaseDAQueryModelHelper FindDAQueryModelHelper(IDEHelper iDEHelper) {
        String strDAQueryModeHelperId = StringHelper.Format((String)"DE_%1$s_%2$s", (Object)iDEHelper.getId(), (Object)iDEHelper.getVersion());
        String strQMId = StringHelper.Format((String)"QM_DE%1$s", (Object)iDEHelper.getId());
        BaseDAQueryModelHelper daQueryModelHelper = null;
        daQueryModelHelper = iDEHelper.GetDAQueryModelHelper(strQMId);
        if (daQueryModelHelper != null && StringHelper.Compare((String)daQueryModelHelper.getDAQueryModelHelperId(), (String)strDAQueryModeHelperId, (boolean)true) == 0) {
            return daQueryModelHelper;
        }
        daQueryModelHelper = this.getDAQueryModelHelper(iDEHelper);
        if (daQueryModelHelper != null) {
            daQueryModelHelper.setDAQueryModelHelperId(strDAQueryModeHelperId);
            iDEHelper.RegisterDAQueryModelHelper(strQMId, daQueryModelHelper);
        }
        return daQueryModelHelper;
    }

    @Override
    public BaseDAQueryModelHelper getDAQueryModelHelper(IDEHelper iDEHelper) {
        BaseDAQueryModelHelper daQueryModelHelper;
        CallResult callResult;
        String strDEHelperObject = "";
        if (!StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage())) {
            strDEHelperObject = this.contextHelperEx.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DAQUERYMODELHELPER");
        }
        if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
            strDEHelperObject = this.contextHelperEx.getGlobalConfigMgr().GetWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
        }
        if ((callResult = (daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strDEHelperObject)).Init(iDEHelper, this.contextHelperEx)).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25"));
            return null;
        }
        callResult = daQueryModelHelper.Compile(new DGModelMainQueryConfig());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u7f16\u8bd1\u67e5\u8be2\u6a21\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return null;
        }
        return daQueryModelHelper;
    }

    private final BaseDAQueryModelHelper GetDAQueryModelHelper(IDEHelper iDEHelper, DGModelMainQueryConfig mainQueryConfig, boolean bDeleteMode) {
        return this.GetDAQueryModelHelper(iDEHelper, mainQueryConfig, null, "", bDeleteMode);
    }

    private final BaseDAQueryModelHelper GetDAQueryModelHelper(IDEHelper iDEHelper, DGModelMainQueryConfig mainQueryConfig, DGModelMainQueryConfig mainQueryConfig2, String strDEHelperObject, boolean bDeleteMode) {
        BaseDAQueryModelHelper daQueryModelHelper;
        CallResult callResult;
        if (mainQueryConfig == null) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25\uff0c\u65e0\u6cd5\u83b7\u53d6\u914d\u7f6e"));
            return null;
        }
        if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
            if (!StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage())) {
                strDEHelperObject = this.contextHelperEx.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DAQUERYMODELHELPER");
            }
            if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
                strDEHelperObject = this.contextHelperEx.getGlobalConfigMgr().GetWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
            }
        }
        if ((callResult = (daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strDEHelperObject)).Init(iDEHelper, this.contextHelperEx)).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25"));
            return null;
        }
        callResult = daQueryModelHelper.CompileEx(mainQueryConfig, mainQueryConfig2, bDeleteMode);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u7f16\u8bd1\u67e5\u8be2\u6a21\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return null;
        }
        return daQueryModelHelper;
    }

    private final BaseDAQueryModelHelper GetDAQueryModelHelperRawCodeMode(IDEHelper iDEHelper, QueryModel queryModel, String strDEHelperObject) {
        BaseDAQueryModelHelper daQueryModelHelper;
        CallResult callResult;
        if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
            if (!StringHelper.IsNullOrEmpty((String)iDEHelper.GetDBStorage())) {
                strDEHelperObject = this.contextHelperEx.getDAModelStorage().FindDBStorage(iDEHelper.GetDBStorage()).GetProperty("DAQUERYMODELHELPER");
            }
            if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
                strDEHelperObject = this.contextHelperEx.getGlobalConfigMgr().GetWebExConfig().GetValue("SRFDA", "DAQUERYMODELHELPER", "");
            }
        }
        if ((callResult = (daQueryModelHelper = (BaseDAQueryModelHelper)ObjectHelper.Create((String)strDEHelperObject)).Init(iDEHelper, this.contextHelperEx)).getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u67e5\u8be2\u8f85\u52a9\u5bf9\u8c61\u5931\u8d25"));
            return null;
        }
        callResult = daQueryModelHelper.CompileRawCodeMode(queryModel.getQUERYSQL(), queryModel.getQUERYCOND(), queryModel.getQUERYPARAM(), queryModel.getQUERYFIELD());
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u7f16\u8bd1\u67e5\u8be2\u6a21\u578b\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return null;
        }
        return daQueryModelHelper;
    }

    @Override
    public IDEDataCtrl FindDEDataCtrl2(String strDEID, ISRFDAWebContext webContext) throws Exception {
        IDEDataCtrl iDEDataCtrl = this.FindDEDataCtrl(strDEID, webContext);
        if (iDEDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEID));
        }
        return iDEDataCtrl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IDEDataCtrl FindGlobalDEDataCtrl(String strDEId, String strUserTag) throws Exception {
        String strKey = StringHelper.Format((String)"%1$s|%2$s", (Object)strDEId, (Object)strUserTag);
        IDEDataCtrl iDEDataCtrl = null;
        Hashtable<String, IDEDataCtrl> hashtable = this.globalDEDataCtrlMap;
        synchronized (hashtable) {
            iDEDataCtrl = this.globalDEDataCtrlMap.get(strKey);
        }
        if (iDEDataCtrl != null) {
            IDEHelper iDEHelper = this.FindDEHelper2(strDEId);
            if (iDEDataCtrl.GetDEHelper() == iDEHelper) {
                iDEDataCtrl.ResetAttributes();
                return iDEDataCtrl;
            }
            iDEDataCtrl = null;
        }
        iDEDataCtrl = this.FindDEDataCtrl2(strDEId, "SYSTEM", null);
        hashtable = this.globalDEDataCtrlMap;
        synchronized (hashtable) {
            this.globalDEDataCtrlMap.put(strKey, iDEDataCtrl);
        }
        return iDEDataCtrl;
    }

    @Override
    public IDEDataCtrl FindDEDataCtrl(String strDEID, ISRFDAWebContext webContext) {
        IDEHelper iDEHelper = this.FindDEHelper(strDEID);
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
            return null;
        }
        return iDEHelper.GetDEDataCtrl("", webContext);
    }

    @Override
    public IDEDataCtrl FindDEDataCtrl2(String strDEID, String strOpPersonId, ISRFDAWebContext webContext) throws Exception {
        IDEDataCtrl iDEDataCtrl = this.FindDEDataCtrl(strDEID, strOpPersonId, webContext);
        if (iDEDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEID));
        }
        return iDEDataCtrl;
    }

    @Override
    public IDEDataCtrl FindDEDataCtrl(String strDEID, String strOpPersonId, ISRFDAWebContext webContext) {
        IDEHelper iDEHelper = this.FindDEHelper(strDEID);
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
            return null;
        }
        return iDEHelper.GetDEDataCtrl(strOpPersonId, webContext);
    }

    @Override
    public IDEDataCtrl FindDEDataCtrlEx2(String strDEID, IDEDataCtrl curDataCtrl) throws Exception {
        IDEDataCtrl iDEDataCtrl = this.FindDEDataCtrlEx(strDEID, curDataCtrl);
        if (iDEDataCtrl == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEID));
        }
        return iDEDataCtrl;
    }

    @Override
    public final IDEDataCtrl FindDEDataCtrlEx(String strDEID, IDEDataCtrl curDataCtrl) {
        IDEHelper iDEHelper = this.FindDEHelper(strDEID);
        if (iDEHelper == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
            return null;
        }
        IDEDataCtrl iDataCtrl = iDEHelper.GetDEDataCtrl(curDataCtrl.getOPPersonId(), curDataCtrl.getWebContext());
        if (iDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strDEID));
            return null;
        }
        iDataCtrl.setReferDataCtrl(curDataCtrl);
        if (curDataCtrl.getTransactionManager() != null) {
            curDataCtrl.getTransactionManager().Register(iDataCtrl);
        }
        iDataCtrl.setLanguage(curDataCtrl.getLanguage());
        return iDataCtrl;
    }

    @Override
    public final IDEHelper FindDEHelper2(String strDEID) throws Exception {
        IDEHelper iDEHelper = this.FindDEHelper(strDEID);
        if (iDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
        }
        return iDEHelper;
    }

    @Override
    public final IDEHelper FindDEHelper2(String strDEID, boolean bCache) throws Exception {
        IDEHelper iDEHelper = this.FindDEHelper(strDEID);
        if (iDEHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEID));
        }
        return iDEHelper;
    }

    @Override
    public final IDEHelper FindDEHelper(String strDEID) {
        return this.FindDEHelper(strDEID, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final IDEHelper FindDEHelper(String strDEID, boolean bCache) {
        CallResult callResult;
        Hashtable<String, IDEHelper> hashtable;
        String strOriginDEID = strDEID;
        strDEID = strDEID.toUpperCase();
        Long curTime = new Date().getTime();
        IDEHelper lastDEHelper = null;
        if (bCache) {
            Hashtable<String, IDEHelper> hashtable2 = this.deHelperMap;
            synchronized (hashtable2) {
                if (this.deHelperMap.containsKey(strDEID)) {
                    lastDEHelper = this.deHelperMap.get(strDEID);
                    if (curTime - this.deHelperRenewMap.get(strDEID) < (long)this.DERENEWTIMER) {
                        return lastDEHelper;
                    }
                }
            }
        }
        DataEntity dataEntity = new DataEntity();
        if (lastDEHelper != null) {
            int nDEVersion = this.GetDAModelVersion("DE0001", strOriginDEID);
            if (nDEVersion != -1) {
                if (lastDEHelper.getVersion() == nDEVersion) {
                    Hashtable<String, IDEHelper> hashtable3 = this.deHelperMap;
                    synchronized (hashtable3) {
                        this.deHelperRenewMap.put(strDEID, new Date().getTime());
                    }
                    return lastDEHelper;
                }
            } else {
                boolean bCheckVersion = true;
                CallResult callResult2 = this.iDAModelHelper.GetDEVersion(strOriginDEID, dataEntity);
                if (callResult2 == null || callResult2.getRetCode() != 0) {
                    log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u7248\u672c[%1$s]\u5931\u8d25", (Object)strOriginDEID));
                    bCheckVersion = false;
                }
                if (bCheckVersion && lastDEHelper.getDataEntity().getDEVERSION() == dataEntity.getDEVERSION()) {
                    Hashtable<String, IDEHelper> hashtable4 = this.deHelperMap;
                    synchronized (hashtable4) {
                        this.deHelperRenewMap.put(strDEID, new Date().getTime());
                    }
                    return lastDEHelper;
                }
            }
            hashtable = this.deHelperMap;
            synchronized (hashtable) {
                this.deHelperMap.remove(strDEID);
                this.deHelperRenewMap.remove(strDEID);
            }
        }
        if ((callResult = this.iDAModelHelper.GetDataEntity(strOriginDEID, dataEntity)) == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53[%1$s]\u5931\u8d25", (Object)strOriginDEID));
            return null;
        }
        lastDEHelper = this.GetDEHelper(dataEntity);
        if (lastDEHelper == null) {
            return lastDEHelper;
        }
        hashtable = this.deHelperMap;
        synchronized (hashtable) {
            this.deHelperMap.put(strDEID, lastDEHelper);
            this.deHelperRenewMap.put(strDEID, new Date().getTime());
        }
        if (!lastDEHelper.PrepareDEFields(true)) {
            log.error((Object)StringHelper.Format((String)"\u5b9e\u4f53[%1$s]\u5931\u8d25", (Object)strOriginDEID));
            hashtable = this.deHelperMap;
            synchronized (hashtable) {
                this.deHelperMap.remove(strDEID);
                this.deHelperRenewMap.remove(strDEID);
            }
            return null;
        }
        return lastDEHelper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final IDEHelper GetDEHelper(DataEntity dataEntity) {
        String strDEHelperObject;
        block13: {
            String strDEName2;
            log.debug((Object)StringHelper.Format((String)"\u5185\u90e8\u83b7\u53d6\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)dataEntity.getDEID()));
            strDEHelperObject = dataEntity.getDEHELPER();
            try {
                String strKey;
                Properties deProperties;
                if (!StringHelper.IsNullOrEmpty((String)dataEntity.getDEPARAM()) && StringHelper.IsNullOrEmpty((String)(strDEHelperObject = PropertiesHelper.GetProperty((Properties)(deProperties = PropertiesHelper.Load((String)dataEntity.getDEPARAM())), (String)(strKey = StringHelper.Format((String)"%2$s.%1$s", (Object)this.contextHelperEx.getDAModelDB(), (Object)"DEHELPER")))))) {
                    strKey = StringHelper.Format((String)"%1$s.%2$s", (Object)this.contextHelperEx.getDAModelDB(), (Object)"DEHELPER");
                    strDEHelperObject = PropertiesHelper.GetProperty((Properties)deProperties, (String)strKey);
                }
            }
            catch (Exception e) {
                log.error((Object)StringHelper.Format((String)"\u52a0\u8f7d\u5b9e\u4f53\u914d\u7f6e\u53c2\u6570\u53d1\u751f\u9519\u8bef"), (Throwable)e);
            }
            boolean bOk = false;
            String strDEId = dataEntity.getDEID().toUpperCase();
            String strDEName = dataEntity.getDENAME().toUpperCase();
            if (this.licenseDEMap.containsKey(strDEId) && StringHelper.Compare((String)strDEName, (String)(strDEName2 = this.licenseDEMap.get(strDEId)), (boolean)false) == 0) {
                bOk = true;
            }
            if (!this.bGA2 || bOk) break block13;
            Hashtable<String, String> hashtable = this.userLicenseDEMap;
            synchronized (hashtable) {
                block12: {
                    block14: {
                        if (!this.userLicenseDEMap.containsKey(strDEId)) break block14;
                        bOk = true;
                        break block13;
                    }
                    if (this.userLicenseDEMap.size() <= this.nUserBOCount) break block12;
                    log.error((Object)StringHelper.Format((String)"\u8d85\u8fc7\u7528\u6237\u81ea\u5b9a\u4e49\u4e1a\u52a1\u5bf9\u8c61\u6388\u6743\u6570\u91cf\uff0c\u65e0\u6cd5\u52a0\u8f7d\u5b9e\u4f53[%1$s]\u8f85\u52a9\u5bf9\u8c61", (Object)strDEId));
                    return null;
                }
                this.userLicenseDEMap.put(strDEId, strDEName);
            }
        }
        if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
            strDEHelperObject = dataEntity.getDEHELPER();
        }
        if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
            if (!StringHelper.IsNullOrEmpty((String)dataEntity.getDBSTORAGE())) {
                strDEHelperObject = this.FindDBStorage(dataEntity.getDBSTORAGE()).GetProperty("DEHELPER");
            }
            if (StringHelper.IsNullOrEmpty((String)strDEHelperObject)) {
                strDEHelperObject = this.contextHelperEx.getWebExConfig().GetValue("SRFDA", "DEHELPER", "");
            }
        }
        IDEHelper iDEHelper = (IDEHelper)ObjectHelper.Create((String)strDEHelperObject);
        iDEHelper.Init(dataEntity, this.iDAModelHelper, this.contextHelperEx);
        return iDEHelper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetCodeListConfig(String strCodeListId) {
        strCodeListId = strCodeListId.toUpperCase();
        Hashtable<String, CodeListConfig> hashtable = this.codeListMap;
        synchronized (hashtable) {
            this.codeListMap.remove(strCodeListId);
            this.codeListOriginMap.remove(strCodeListId);
        }
        this.contextHelperEx.getCodeListMgr().ResetCodeListConfig(strCodeListId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetAllCodeList() {
        Hashtable<String, CodeListConfig> hashtable = this.codeListMap;
        synchronized (hashtable) {
            this.codeListMap.clear();
            this.codeListOriginMap.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public CodeListConfig FindCodeListConfig(String strCodeListId) {
        String strLookupCodeListId = strCodeListId;
        strCodeListId = strCodeListId.toUpperCase();
        CodeListConfig lastCodeListConfig = null;
        String strOriginCodeList = "";
        Hashtable<String, CodeListConfig> hashtable = this.codeListMap;
        synchronized (hashtable) {
            if (this.codeListMap.containsKey(strCodeListId)) {
                return this.codeListMap.get(strCodeListId);
            }
            strOriginCodeList = this.codeListOriginMap.get(strCodeListId);
        }
        if (!StringHelper.IsNullOrEmpty((String)strOriginCodeList)) {
            return this.contextHelperEx.getCodeListMgr().GetOriginCodeListConfig(strOriginCodeList);
        }
        CodeList codeList = new CodeList();
        CallResult callResult = this.iDAModelHelper.GetCodeList(strLookupCodeListId, codeList);
        if (callResult == null || callResult.getRetCode() != 0) {
            if (callResult.getRetCode() == 3) {
                Hashtable<String, CodeListConfig> hashtable2 = this.codeListMap;
                synchronized (hashtable2) {
                    this.codeListOriginMap.put(strCodeListId, strCodeListId);
                }
                return this.contextHelperEx.getCodeListMgr().GetOriginCodeListConfig(strCodeListId);
            }
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u4ee3\u7801\u8868[%1$s]\u5931\u8d25", (Object)strCodeListId));
            return null;
        }
        if (!StringHelper.IsNullOrEmpty((String)codeList.getCLPATH())) {
            Hashtable<String, CodeListConfig> hashtable3 = this.codeListMap;
            synchronized (hashtable3) {
                this.codeListOriginMap.put(strCodeListId, codeList.getCLPATH());
            }
            return this.contextHelperEx.getCodeListMgr().GetOriginCodeListConfig(codeList.getCLPATH());
        }
        lastCodeListConfig = this.GetCodeListConfig(codeList);
        if (lastCodeListConfig == null) {
            return lastCodeListConfig;
        }
        Hashtable<String, CodeListConfig> hashtable4 = this.codeListMap;
        synchronized (hashtable4) {
            this.codeListMap.put(strCodeListId, lastCodeListConfig);
        }
        return lastCodeListConfig;
    }

    private final CodeListConfig GetCodeListConfig(CodeList codeList) {
        CodeListConfig codeListConfig = new CodeListConfig();
        String strCodeListModel = codeList.getCLMODEL();
        if (!StringHelper.IsNullOrEmpty((String)strCodeListModel)) {
            XMLConfig.LoadFromXML((String)strCodeListModel, (XMLConfig)codeListConfig);
        }
        codeListConfig.setID(codeList.getCODELISTID());
        Properties codeListProperties = codeList.GetCodeListParams();
        if (codeListProperties != null) {
            Enumeration<Object> en = codeListProperties.keys();
            while (en.hasMoreElements()) {
                String strKey = (String)en.nextElement();
                String strValue = PropertiesHelper.GetProperty((Properties)codeListProperties, (String)strKey);
                if (StringHelper.IsNullOrEmpty((String)strValue)) continue;
                codeListConfig.SetValue(strKey, strValue);
            }
        }
        if (codeList.isNOVALUEEMPTY()) {
            codeListConfig.setEmptyText("");
            codeListConfig.setBlankEmptyText(true);
        } else if (!StringHelper.IsNullOrEmpty((String)codeList.getEMPTYTEXT())) {
            codeListConfig.setEmptyText(codeList.getEMPTYTEXT());
        }
        if (!StringHelper.IsNullOrEmpty((String)codeList.getFILLER())) {
            codeListConfig.setFiller(codeList.getFILLER());
        }
        if (!StringHelper.IsNullOrEmpty((String)codeList.getSEPERATOR())) {
            codeListConfig.setSeperator(codeList.getSEPERATOR());
        }
        if (!StringHelper.IsNullOrEmpty((String)codeList.getVALUESEPERATOR())) {
            codeListConfig.setValueSeperator(codeList.getVALUESEPERATOR());
        }
        if (codeList.isUSERSCOPE()) {
            codeListConfig.setUserScope(true);
        }
        if (!StringHelper.IsNullOrEmpty((String)codeList.getORMODE())) {
            if (StringHelper.Compare((String)codeList.getORMODE(), (String)"STRINGORMODE", (boolean)true) == 0) {
                codeListConfig.setStringOrMode(true);
            }
            if (StringHelper.Compare((String)codeList.getORMODE(), (String)"NUMBERORMODE", (boolean)true) == 0) {
                codeListConfig.setNumberOrMode(true);
            }
        }
        if (!codeList.isUSERSCOPE() && !StringHelper.IsNullOrEmpty((String)codeListConfig.getFiller())) {
            Object obj = ObjectHelper.Create((String)codeListConfig.getFiller());
            if (obj == null) {
                log.error((Object)StringHelper.Format((String)"\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]\u586b\u5145\u5668[%2$s]\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bf9\u8c61", (Object)codeList.getCODELISTID(), (Object)codeListConfig.getFiller()));
                return null;
            }
            if (obj instanceof ICodeListFiller2) {
                ICodeListFiller2 iCodeListFiller2 = (ICodeListFiller2)obj;
                iCodeListFiller2.setGlobalHelper((ISRFExGlobalHelper)this.contextHelperEx);
            }
            if (!(obj instanceof ICodeListFiller)) {
                log.error((Object)StringHelper.Format((String)"\u4ee3\u7801\u8868\u914d\u7f6e[%1$s]\u586b\u5145\u5668[%2$s]\u65e0\u6548\uff0c\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3[ICodeListFiller]", (Object)codeList.getCODELISTID(), (Object)codeListConfig.getFiller()));
                return null;
            }
            ICodeListFiller iCodeListFiller = (ICodeListFiller)obj;
            iCodeListFiller.Fill(this.contextHelperEx.getDBCaller(), codeListConfig);
            if (obj instanceof ICodeListQuery) {
                ICodeListQuery iCodeListQuery = (ICodeListQuery)obj;
                codeListConfig.SetRealTimeQueryParam(this.contextHelperEx.getDBCaller(), iCodeListQuery);
            }
        }
        return codeListConfig;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Page FindPage(String strPageId) {
        Vector<PageLogic> pageLogics;
        Vector<BaseDataEntity> pageParams;
        IPageDataCtrl pageDataCtrl;
        int nVersion;
        String strLookupPageId = strPageId;
        Page lastPage = null;
        strPageId = strPageId.toUpperCase();
        Long curTime = new Date().getTime();
        Hashtable<String, Page> hashtable = this.pageMap;
        synchronized (hashtable) {
            if (this.pageMap.containsKey(strPageId)) {
                lastPage = this.pageMap.get(strPageId);
                if (curTime - this.pageRenewMap.get(strPageId) < (long)this.PAGERENEWTIMER) {
                    return lastPage;
                }
            }
        }
        if (lastPage != null && (nVersion = this.iDAModelHelper.GetPageVersion(strLookupPageId)) != -1 && nVersion == lastPage.getVERSION() * lastPage.getPTVERSION()) {
            Hashtable<String, Page> hashtable2 = this.pageMap;
            synchronized (hashtable2) {
                this.pageRenewMap.put(strPageId, curTime);
            }
            return lastPage;
        }
        Page pageEx = new Page();
        CallResult callResult = this.iDAModelHelper.GetPage(strLookupPageId, pageEx);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u4fe1\u606f[%1$s]\u5931\u8d25", (Object)strPageId));
            return null;
        }
        pageEx.BuildProperties();
        if (this.contextHelperEx.getDAModelVersion() >= 11052400 && (callResult = (pageDataCtrl = (IPageDataCtrl)this.FindDEDataCtrl("DE0006", "SYSTEM", null)).ListPageParams(strLookupPageId, pageParams = new Vector<BaseDataEntity>())).IsOk()) {
            pageEx.setAdvPageParams(pageParams);
        }
        if ((callResult = this.iDAModelHelper.GetPageLogics(strLookupPageId, pageLogics = new Vector<PageLogic>())) == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u903b\u8f91[%1$s]\u5931\u8d25", (Object)strPageId));
            return null;
        }
        pageEx.BuildPageLogics(this.contextHelperEx, pageLogics);
        Hashtable<String, Page> hashtable3 = this.pageMap;
        synchronized (hashtable3) {
            this.pageMap.put(strPageId, pageEx);
            this.pageRenewMap.put(strPageId, curTime);
        }
        return pageEx;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public IPageHelper FindPage2(String strPageId) throws Exception {
        Page page = this.FindPage(strPageId);
        if (page == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u9875\u9762\u5bf9\u8c61[%1$s]", (Object)strPageId));
        }
        strPageId = strPageId.toUpperCase();
        IPageHelper iPageHelper = null;
        Hashtable<String, IPageHelper> hashtable = this.pageHelperMap;
        synchronized (hashtable) {
            iPageHelper = this.pageHelperMap.get(strPageId);
        }
        if (iPageHelper != null && iPageHelper.getData() == page) {
            return iPageHelper;
        }
        iPageHelper = this.OnCreatePageHelper(page);
        iPageHelper.Init(this.contextHelperEx, page);
        hashtable = this.pageHelperMap;
        synchronized (hashtable) {
            this.pageHelperMap.put(strPageId, iPageHelper);
        }
        return iPageHelper;
    }

    protected IPageHelper OnCreatePageHelper(Page page) throws Exception {
        return (IPageHelper)ObjectHelper.Create((String)"SA.SRFDA.Ctrl.PageHelper");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetPage(String strPageId) {
        strPageId = strPageId.toUpperCase();
        Hashtable<String, Page> hashtable = this.pageMap;
        synchronized (hashtable) {
            this.pageMap.remove(strPageId);
        }
    }

    @Override
    public THGroup FindTHGroup(String strTHGroupId) {
        Object objTHGroup = this.thresholdGroupHelper.FindModel(strTHGroupId);
        if (objTHGroup != null) {
            return (THGroup)((Object)objTHGroup);
        }
        return null;
    }

    @Override
    public void ResetTHGroup(String strTHGroupId) {
        if (StringHelper.IsNullOrEmpty((String)strTHGroupId)) {
            this.thresholdGroupHelper.ResetAll();
        } else {
            this.thresholdGroupHelper.ResetModel(strTHGroupId);
        }
    }

    @Override
    public TreeView FindTreeView(String strTreeViewId) {
        Object objTreeView = this.treeViewHelper.FindModel(strTreeViewId);
        if (objTreeView != null) {
            return (TreeView)((Object)objTreeView);
        }
        return null;
    }

    @Override
    public void ResetTreeView(String strTreeViewId) {
        if (StringHelper.IsNullOrEmpty((String)strTreeViewId)) {
            this.treeViewHelper.ResetAll();
        } else {
            this.treeViewHelper.ResetModel(strTreeViewId);
        }
    }

    @Override
    public ValueRule FindValueRule(String strValueRuleId) {
        Object objValueRule = this.valueRuleHelper.FindModel(strValueRuleId);
        if (objValueRule != null) {
            return (ValueRule)((Object)objValueRule);
        }
        return null;
    }

    @Override
    public void ResetValueRule(String strValueRuleId) {
        if (StringHelper.IsNullOrEmpty((String)strValueRuleId)) {
            this.valueRuleHelper.ResetAll();
        } else {
            this.valueRuleHelper.ResetModel(strValueRuleId);
        }
    }

    @Override
    public DevImage FindDevImage(String strDevImageId) {
        Object objDevImage = this.devImageHelper.FindModel(strDevImageId);
        if (objDevImage != null) {
            return (DevImage)((Object)objDevImage);
        }
        return null;
    }

    @Override
    public void ResetDevImage(String strDevImageId) {
        if (StringHelper.IsNullOrEmpty((String)strDevImageId)) {
            this.devImageHelper.ResetAll();
        } else {
            this.devImageHelper.ResetModel(strDevImageId);
        }
    }

    @Override
    public TBTempl FindTBTempl(String strTBTemplId) {
        Object objTBTempl = this.tbTemplHelper.FindModel(strTBTemplId);
        if (objTBTempl != null) {
            return (TBTempl)((Object)objTBTempl);
        }
        return null;
    }

    @Override
    public void ResetTBTempl(String strTBTemplId) {
        if (StringHelper.IsNullOrEmpty((String)strTBTemplId)) {
            this.tbTemplHelper.ResetAll();
        } else {
            this.tbTemplHelper.ResetModel(strTBTemplId);
        }
    }

    @Override
    public Toolbar FindToolbar(String strToolbarId) {
        Object objToolbar = this.toolbarHelper.FindModel(strToolbarId);
        if (objToolbar != null) {
            return (Toolbar)((Object)objToolbar);
        }
        return null;
    }

    @Override
    public void ResetToolbar(String strToolbarId) {
        if (StringHelper.IsNullOrEmpty((String)strToolbarId)) {
            this.toolbarHelper.ResetAll();
        } else {
            this.toolbarHelper.ResetModel(strToolbarId);
        }
    }

    @Override
    public DEBehavior FindDEBehavior(String strDEBehaviorId) {
        Object objDEBehavior = this.deBehaviorHelper.FindModel(strDEBehaviorId);
        if (objDEBehavior != null) {
            return (DEBehavior)((Object)objDEBehavior);
        }
        return null;
    }

    @Override
    public IDEBehaviorHelper FindDEBehavior2(String strDEBehaviorId) throws Exception {
        return (IDEBehaviorHelper)this.deBehaviorHelper.FindModelHelper(strDEBehaviorId);
    }

    @Override
    public void ResetDEBehavior(String strDEBehaviorId) {
        if (StringHelper.IsNullOrEmpty((String)strDEBehaviorId)) {
            this.deBehaviorHelper.ResetAll();
        } else {
            this.deBehaviorHelper.ResetModel(strDEBehaviorId);
        }
    }

    @Override
    public MBPanel FindMBPanel(String strMBPanelId) {
        Object objMBPanel = this.mbPanelGlobalModel.FindModel(strMBPanelId);
        if (objMBPanel != null) {
            return (MBPanel)((Object)objMBPanel);
        }
        return null;
    }

    @Override
    public void ResetMBPanel(String strMBPanelId) {
        if (StringHelper.IsNullOrEmpty((String)strMBPanelId)) {
            this.mbPanelGlobalModel.ResetAll();
        } else {
            this.mbPanelGlobalModel.ResetModel(strMBPanelId);
        }
    }

    @Override
    public IUIGear FindUIGear(String strUIGearId) {
        Object objUIGear = this.uiGearHelper.FindModel(strUIGearId);
        if (objUIGear != null) {
            return (IUIGear)objUIGear;
        }
        return null;
    }

    @Override
    public void ResetUIGear(String strUIGearId) {
        if (StringHelper.IsNullOrEmpty((String)strUIGearId)) {
            this.uiGearHelper.ResetAll();
        } else {
            this.uiGearHelper.ResetModel(strUIGearId);
        }
    }

    @Override
    public PageParamType FindPageParamType(String strPageParamTypeId) {
        Object objPageParamType = this.pageParamTypeHelper.FindModel(strPageParamTypeId);
        if (objPageParamType != null) {
            return (PageParamType)((Object)objPageParamType);
        }
        return null;
    }

    @Override
    public void ResetPageParamType(String strPageParamTypeId) {
        if (StringHelper.IsNullOrEmpty((String)strPageParamTypeId)) {
            this.pageParamTypeHelper.ResetAll();
        } else {
            this.pageParamTypeHelper.ResetModel(strPageParamTypeId);
        }
    }

    @Override
    public PageParamFolder FindPageParamFolder(String strPageParamFolderId) {
        Object objPageParamFolder = this.pageParamFolderHelper.FindModel(strPageParamFolderId);
        if (objPageParamFolder != null) {
            return (PageParamFolder)((Object)objPageParamFolder);
        }
        return null;
    }

    @Override
    public void ResetPageParamFolder(String strPageParamFolderId) {
        if (StringHelper.IsNullOrEmpty((String)strPageParamFolderId)) {
            this.pageParamFolderHelper.ResetAll();
        } else {
            this.pageParamFolderHelper.ResetModel(strPageParamFolderId);
        }
    }

    @Override
    public DEBHGroup FindDEBHGroup(String strDEBHGroupId) {
        Object objDEBHGroup = this.deBHGroupHelper.FindModel(strDEBHGroupId);
        if (objDEBHGroup != null) {
            return (DEBHGroup)((Object)objDEBHGroup);
        }
        return null;
    }

    @Override
    public void ResetDEBHGroup(String strDEBHGroupId) {
        if (StringHelper.IsNullOrEmpty((String)strDEBHGroupId)) {
            this.deBHGroupHelper.ResetAll();
        } else {
            this.deBHGroupHelper.ResetModel(strDEBHGroupId);
        }
    }

    @Override
    public GSR2 FindGSR2(String strGSR2Id) {
        Object objGSR2 = this.gsr2Helper.FindModel(strGSR2Id);
        if (objGSR2 != null) {
            return (GSR2)((Object)objGSR2);
        }
        return null;
    }

    @Override
    public void ResetGSR2(String strGSR2Id) {
        if (StringHelper.IsNullOrEmpty((String)strGSR2Id)) {
            this.gsr2Helper.ResetAll();
        } else {
            this.gsr2Helper.ResetModel(strGSR2Id);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public FIUpdate FindFIUpdate(String strDEId, String strFIUpdateMode) {
        int nVersion;
        String strFIUpdateId = StringHelper.Format((String)"%1$s|%2$s", (Object)strDEId, (Object)strFIUpdateMode).toUpperCase();
        FIUpdate lastFIUpdate = null;
        strFIUpdateId = strFIUpdateId.toUpperCase();
        Long curTime = new Date().getTime();
        Hashtable<String, FIUpdate> hashtable = this.fiUpdateMap;
        synchronized (hashtable) {
            if (this.fiUpdateMap.containsKey(strFIUpdateId)) {
                lastFIUpdate = this.fiUpdateMap.get(strFIUpdateId);
                if (curTime - this.fiUpdateRenewMap.get(strFIUpdateId) < (long)this.FIUPDATERENEWTIMER) {
                    return lastFIUpdate;
                }
            }
        }
        if (lastFIUpdate != null && (nVersion = this.iDAModelHelper.GetFIUpdateVersion(strDEId, strFIUpdateMode)) != -1 && nVersion == lastFIUpdate.getVERSION()) {
            Hashtable<String, FIUpdate> hashtable2 = this.fiUpdateMap;
            synchronized (hashtable2) {
                this.fiUpdateRenewMap.put(strFIUpdateId, curTime);
            }
            return lastFIUpdate;
        }
        FIUpdate fiUpdateEx = new FIUpdate();
        CallResult callResult = this.iDAModelHelper.GetFIUpdate(strDEId, strFIUpdateMode, fiUpdateEx);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u8868\u5355\u9879\u66f4\u65b0\u6a21\u5f0f[%1$s]\u5931\u8d25", (Object)strFIUpdateId));
            return null;
        }
        fiUpdateEx.BuildModel();
        Hashtable<String, FIUpdate> hashtable3 = this.fiUpdateMap;
        synchronized (hashtable3) {
            this.fiUpdateMap.put(strFIUpdateId, fiUpdateEx);
            this.fiUpdateRenewMap.put(strFIUpdateId, curTime);
        }
        return fiUpdateEx;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetFIUpdate(String strDEid, String strFIUpdateMode) {
        String strFIUpdateId = StringHelper.Format((String)"%1$s|%2$s", (Object)strDEid, (Object)strFIUpdateMode).toUpperCase();
        Hashtable<String, FIUpdate> hashtable = this.fiUpdateMap;
        synchronized (hashtable) {
            this.fiUpdateMap.remove(strFIUpdateId);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public GroupStatisticsRep FindGroupStatisticsRep(String strGroupStatisticsRepId) {
        int nVersion;
        GroupStatisticsRep lastGroupStatisticsRep = null;
        Long curTime = new Date().getTime();
        Hashtable<String, GroupStatisticsRep> hashtable = this.gsrMap;
        synchronized (hashtable) {
            if (this.gsrMap.containsKey(strGroupStatisticsRepId)) {
                lastGroupStatisticsRep = this.gsrMap.get(strGroupStatisticsRepId);
                if (curTime - this.gsrRenewMap.get(strGroupStatisticsRepId) < (long)this.FIUPDATERENEWTIMER) {
                    return lastGroupStatisticsRep;
                }
            }
        }
        if (lastGroupStatisticsRep != null && (nVersion = this.iDAModelHelper.GetGroupStatisticsRepVersion(strGroupStatisticsRepId)) != -1 && nVersion == lastGroupStatisticsRep.getVERSION()) {
            Hashtable<String, GroupStatisticsRep> hashtable2 = this.gsrMap;
            synchronized (hashtable2) {
                this.gsrRenewMap.put(strGroupStatisticsRepId, curTime);
            }
            return lastGroupStatisticsRep;
        }
        GroupStatisticsRep gsrEx = new GroupStatisticsRep();
        CallResult callResult = this.iDAModelHelper.GetGroupStatisticsRep(strGroupStatisticsRepId, gsrEx);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strGroupStatisticsRepId, (Object)callResult.getErrorInfo()));
            return null;
        }
        Vector<GSRMeasure> measures = new Vector<GSRMeasure>();
        Vector<GSRGroupColumn> groupColumns = new Vector<GSRGroupColumn>();
        callResult = this.iDAModelHelper.GetGSRMeasures(strGroupStatisticsRepId, measures);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868[%1$s]\u6307\u6807\u5931\u8d25,%2$s", (Object)strGroupStatisticsRepId, (Object)callResult.getErrorInfo()));
            return null;
        }
        callResult = this.iDAModelHelper.GetGSRGroupColumns(strGroupStatisticsRepId, groupColumns);
        if (callResult == null || callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u5206\u7ec4\u7edf\u8ba1\u62a5\u8868[%1$s]\u5206\u7ec4\u7ef4\u5ea6\u5931\u8d25,%2$s", (Object)strGroupStatisticsRepId, (Object)callResult.getErrorInfo()));
            return null;
        }
        gsrEx.setGroupColumns(groupColumns);
        gsrEx.setMeasures(measures);
        Hashtable<String, GroupStatisticsRep> hashtable3 = this.gsrMap;
        synchronized (hashtable3) {
            this.gsrMap.put(strGroupStatisticsRepId, gsrEx);
            this.gsrRenewMap.put(strGroupStatisticsRepId, curTime);
        }
        return gsrEx;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void ResetGroupStatisticsRep(String strGroupStatisticsRepId) {
        Hashtable<String, GroupStatisticsRep> hashtable = this.gsrMap;
        synchronized (hashtable) {
            this.gsrMap.remove(strGroupStatisticsRepId);
        }
    }

    @Override
    public DataLockDataCtrl GetDataLockDataCtrl() {
        if (this.dataLockDataCtrl != null) {
            return this.dataLockDataCtrl;
        }
        IDEDataCtrl iDataCtrl = this.FindDEDataCtrl("DE0029", "SYSTEM", null);
        if (iDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u9501\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61"));
            return null;
        }
        if (iDataCtrl instanceof DataLockDataCtrl) {
            this.dataLockDataCtrl = (DataLockDataCtrl)iDataCtrl;
        } else {
            log.error((Object)StringHelper.Format((String)"\u6570\u636e\u9501\u6570\u636e\u7c7b\u578b\u4e0d\u6b63\u786e"));
        }
        return this.dataLockDataCtrl;
    }

    @Override
    public IDEDataCtrl GetSessionDataDataCtrl() {
        if (this.sessionDataDataCtrl != null) {
            return this.sessionDataDataCtrl;
        }
        IDEDataCtrl iDataCtrl = this.FindDEDataCtrl("DE0149", "SYSTEM", null);
        if (iDataCtrl == null) {
            log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6SESSION\u6570\u636e\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61"));
            return null;
        }
        this.sessionDataDataCtrl = iDataCtrl;
        return this.sessionDataDataCtrl;
    }

    @Override
    public IDAGlobalModel FindGlobalModel(String strDEId) {
        return this.globalModelMap.get(strDEId);
    }

    private final void OnPrepareDBStorage() {
        Vector<DBStorage> dbStorages = new Vector<DBStorage>();
        CallResult callResult = this.contextHelperEx.getDAModelHelper().GetDBStorages(dbStorages);
        if (callResult.getRetCode() != 0) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6570\u636e\u5b58\u50a8\u5931\u8d25\uff0c%1$s", (Object)callResult.getErrorInfo()));
            return;
        }
        this.dbStorageMap = new Hashtable();
        for (DBStorage dbStorage : dbStorages) {
            Object objDBStorage;
            String strObject = dbStorage.getDBSTORAGEOBJECT();
            if (StringHelper.IsNullOrEmpty((String)strObject)) {
                strObject = DefaultDBStorage.class.getName();
            }
            if ((objDBStorage = ObjectHelper.Create((String)strObject)) == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)strObject));
                return;
            }
            if (!(objDBStorage instanceof IDBStorage)) {
                log.error((Object)StringHelper.Format((String)"[%1$s]\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strObject));
                return;
            }
            IDBStorage iDBStorage = (IDBStorage)objDBStorage;
            iDBStorage.Init(this.contextHelperEx, dbStorage);
            String strDBCaller = iDBStorage.GetDBCaller();
            if (StringHelper.IsNullOrEmpty((String)strDBCaller)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u6570\u636e\u5b58\u50a8[%1$s]\u6307\u5b9a\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)iDBStorage.GetId()));
                return;
            }
            Object objDBCaller = ObjectHelper.Create((String)strDBCaller);
            if (objDBCaller == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61[%1$s]", (Object)strDBCaller));
                return;
            }
            if (!(objDBCaller instanceof WebDBCallerHelperEx)) {
                log.error((Object)StringHelper.Format((String)"[%1$s]\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strDBCaller));
                return;
            }
            WebDBCallerHelperEx webDBCallerHelperEx = (WebDBCallerHelperEx)objDBCaller;
            webDBCallerHelperEx.setDSN(dbStorage.getDSN());
            this.contextHelperEx.SetGlobalValue("SRFDBCALLERHELPER" + dbStorage.getDBSTORAGEID(), webDBCallerHelperEx);
            String strDEDataCtrlHelper = iDBStorage.GetProperty("DEDATACTRLHELPER");
            if (StringHelper.IsNullOrEmpty((String)strDEDataCtrlHelper)) {
                log.error((Object)StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u6570\u636e\u5b58\u50a8[%1$s]\u6307\u5b9a\u6570\u636e\u8bbf\u95ee\u8f85\u52a9\u5bf9\u8c61", (Object)iDBStorage.GetId()));
                return;
            }
            Object objDEDataCtrl = ObjectHelper.Create((String)strDEDataCtrlHelper);
            if (objDEDataCtrl == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u6570\u636e\u8bbf\u95ee\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)strDEDataCtrlHelper));
                return;
            }
            if (!(objDEDataCtrl instanceof IDEDataCtrlHelper)) {
                log.error((Object)StringHelper.Format((String)"[%1$s]\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strDEDataCtrlHelper));
                return;
            }
            IDEDataCtrlHelper iDEDataCtrlHelper = (IDEDataCtrlHelper)objDEDataCtrl;
            iDEDataCtrlHelper.Init(this.contextHelperEx, iDBStorage);
            String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)"SRFDADEDATACTRLHELPER", (Object)iDBStorage.GetId());
            this.contextHelperEx.SetGlobalValue(strKey, iDEDataCtrlHelper);
            this.dbStorageMap.put(iDBStorage.GetId().toUpperCase(), iDBStorage);
        }
    }

    @Override
    public IDBStorage FindDBStorage(String strDBStorageId) {
        if (this.dbStorageMap == null) {
            return null;
        }
        IDBStorage iDBStorage = this.dbStorageMap.get(strDBStorageId.toUpperCase());
        if (iDBStorage != null) {
            return iDBStorage;
        }
        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u5b58\u50a8\u914d\u7f6e[%1$s]", (Object)strDBStorageId));
        return null;
    }

    private void InitLicense() {
        try {
            Object objLicensePwd;
            String strLicenseKey = "";
            byte[] licensePwd = null;
            Object objLicenseKey = this.contextHelperEx.GetGlobalValue(TAG_LICENSEKEY);
            if (objLicenseKey != null) {
                strLicenseKey = (String)objLicenseKey;
            }
            if ((objLicensePwd = this.contextHelperEx.GetGlobalValue(TAG_LICENSEPWD)) != null) {
                licensePwd = (byte[])objLicensePwd;
            }
            if (StringHelper.IsNullOrEmpty((String)strLicenseKey)) {
                GlobalHelperEx globalHelperEx = null;
                if (this.contextHelperEx instanceof GlobalHelperEx) {
                    globalHelperEx = (GlobalHelperEx)this.contextHelperEx;
                    String strPath = globalHelperEx.getServletContext().getRealPath(StringHelper.Format((String)"/WEB-INF/srflic/%1$s.lic", (Object)"srf"));
                    this.LoadDELicenseFile(strPath);
                }
                return;
            }
            byte[] buff = Base64.decode((String)strLicenseKey);
            byte[] buff2 = DAModelStorage.SymmetricDecrypto(buff, licensePwd);
            strLicenseKey = new String(buff2);
            XMLConfig xmlConfig = new XMLConfig();
            XMLConfig.LoadFromXML((String)strLicenseKey, (XMLConfig)xmlConfig);
            if (xmlConfig.GetExtValue("RETCODE", 1) == 0) {
                this.nUserBOCount = xmlConfig.GetExtValue("USERBOCOUNT", 0);
                GlobalHelperEx globalHelperEx = null;
                if (this.contextHelperEx instanceof GlobalHelperEx) {
                    globalHelperEx = (GlobalHelperEx)this.contextHelperEx;
                    String strPath = globalHelperEx.getServletContext().getRealPath(StringHelper.Format((String)"/WEB-INF/srflic/%1$s.lic", (Object)"srf"));
                    this.LoadDELicenseFile(strPath);
                    String strProductId = xmlConfig.GetExtValue("PRODUCTID", "");
                    if (!StringHelper.IsNullOrEmpty((String)strProductId)) {
                        String[] products = strProductId.split("[|]");
                        int i = 0;
                        while (i < products.length) {
                            strPath = globalHelperEx.getServletContext().getRealPath(StringHelper.Format((String)"/WEB-INF/srflic/%1$s.lic", (Object)products[i].toLowerCase()));
                            this.LoadDELicenseFile(strPath);
                            ++i;
                        }
                        i = 0;
                        while (i < products.length) {
                            this.licenseProductMap.put(products[i].toLowerCase(), "");
                            ++i;
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void LoadDELicenseFile(String strFile) {
        File file = new File(strFile);
        if (!file.exists()) {
            return;
        }
        log.info((Object)StringHelper.Format((String)"\u52a0\u8f7d\u5b9e\u4f53\u6388\u6743\u6587\u4ef6:%1$s", (Object)strFile));
        String strContent = this.RSADecrypt(strFile);
        strContent = strContent.replace("\r", ";");
        strContent = strContent.replace("\n", ";");
        strContent = strContent.toUpperCase();
        String[] deList = strContent.split("[;]");
        int i = 0;
        while (i < deList.length) {
            String[] depart;
            String strDataEntity = deList[i];
            if (!StringHelper.IsNullOrEmpty((String)strDataEntity) && (depart = strDataEntity.split("[|]")).length == 2) {
                this.licenseDEMap.put(depart[0], depart[1]);
                log.info((Object)StringHelper.Format((String)"\u6388\u6743\u5b9e\u4f53[%1$s][%2$s]", (Object)depart[0], (Object)depart[1]));
            }
            ++i;
        }
    }

    @Override
    public int GetDAModelVersion(String strDEId, Object objDataId) {
        int nVersion = this.daModelVersionHelper.GetDEDataVersion(strDEId, objDataId, false);
        return nVersion;
    }

    @Override
    public int GetDAModelVersion(String strDEId, Object objDataId, boolean bReset) {
        int nVersion = this.daModelVersionHelper.GetDEDataVersion(strDEId, objDataId, true);
        return nVersion;
    }

    @Override
    public boolean IsEnableGlobalModel() {
        return this.contextHelperEx.getDAModelVersion() >= 11062700;
    }

    @Override
    public IDERModeHelper FindDERMode(String strDERModeId) throws Exception {
        return (IDERModeHelper)this.derModeGlobalModel.FindModelHelper(strDERModeId);
    }

    public void ResetDERMode(String strDERModeId) {
        if (StringHelper.IsNullOrEmpty((String)strDERModeId)) {
            this.derModeGlobalModel.ResetAll();
        } else {
            this.derModeGlobalModel.ResetModel(strDERModeId);
        }
    }

    @Override
    public IDERTypeHelper FindDERType(String strDERTypeId) throws Exception {
        return (IDERTypeHelper)this.derTypeGlobalModel.FindModelHelper(strDERTypeId);
    }

    @Override
    public void ResetDERType(String strDERTypeId) {
        if (StringHelper.IsNullOrEmpty((String)strDERTypeId)) {
            this.derTypeGlobalModel.ResetAll();
        } else {
            this.derTypeGlobalModel.ResetModel(strDERTypeId);
        }
    }

    @Override
    public IDERGroupFolderHelper FindDERGroupFolder(String strDERGroupFolderId) throws Exception {
        return (IDERGroupFolderHelper)this.derGroupFolderGlobalModel.FindModelHelper(strDERGroupFolderId);
    }

    @Override
    public void ResetDERGroupFolder(String strDERGroupFolderId) {
        if (StringHelper.IsNullOrEmpty((String)strDERGroupFolderId)) {
            this.derGroupFolderGlobalModel.ResetAll();
        } else {
            this.derGroupFolderGlobalModel.ResetModel(strDERGroupFolderId);
        }
    }

    @Override
    public ISyncAgentTypeHelper FindSyncAgentType(String strSyncAgentTypeId) throws Exception {
        return (ISyncAgentTypeHelper)this.syncAgentTypeGlobalModel.FindModelHelper(strSyncAgentTypeId);
    }

    @Override
    public void ResetSyncAgentType(String strSyncAgentTypeId) {
        if (StringHelper.IsNullOrEmpty((String)strSyncAgentTypeId)) {
            this.syncAgentTypeGlobalModel.ResetAll();
        } else {
            this.syncAgentTypeGlobalModel.ResetModel(strSyncAgentTypeId);
        }
    }

    @Override
    public IORGUnitTypeHelper FindORGUnitType(String strORGUnitTypeId) throws Exception {
        return (IORGUnitTypeHelper)this.orgUnitTypeGlobalModel.FindModelHelper(strORGUnitTypeId);
    }

    @Override
    public IORGTreeTypeHelper FindORGTreeType(String strORGTreeTypeId) throws Exception {
        return (IORGTreeTypeHelper)this.orgTreeTypeGlobalModel.FindModelHelper(strORGTreeTypeId);
    }

    @Override
    public IORGTreeNodeTypeHelper FindORGTreeNodeType(String strORGTreeNodeTypeId) throws Exception {
        return (IORGTreeNodeTypeHelper)this.orgTreeNodeTypeGlobalModel.FindModelHelper(strORGTreeNodeTypeId);
    }

    @Override
    public void ReloadDETBBHandlers() throws Exception {
        this.deTBBHandlerGlobalModel.Reload();
    }

    @Override
    public String GetDETBBHandler(String strDEId, String strTBBHandler) {
        return this.deTBBHandlerGlobalModel.GetTBBHandler(strDEId, strTBBHandler);
    }

    @Override
    public IRCAccListHelper FindRCAccList(String strRCAccListId) throws Exception {
        return (IRCAccListHelper)this.rcAccListGlobalModel.FindModelHelper(strRCAccListId);
    }

    @Override
    public void ResetRCAccList(String strRCAccListId) {
        if (StringHelper.IsNullOrEmpty((String)strRCAccListId)) {
            this.rcAccListGlobalModel.ResetAll();
        } else {
            this.rcAccListGlobalModel.ResetModel(strRCAccListId);
        }
    }

    @Override
    public ICounterTypeHelper FindCounterType(String strCounterTypeId) throws Exception {
        return (ICounterTypeHelper)this.counterTypeGlobalModel.FindModelHelper(strCounterTypeId);
    }

    @Override
    public ICounterHelper FindCounter(String strCounterId) throws Exception {
        return (ICounterHelper)this.counterGlobalModel.FindModelHelper(strCounterId);
    }

    @Override
    public final boolean TestProduct(String strProductId) {
        return this.licenseProductMap.containsKey(strProductId.toLowerCase());
    }

    @Override
    public final boolean TestDataEntity(String strDEId) {
        return this.licenseDEMap.containsKey(strDEId.toUpperCase());
    }

    @Override
    public Iterator<IDASubSystemHelper> getSubSystems() {
        return this.subSystemHelperList.iterator();
    }

    @Override
    public ILayoutItemHelper FindLayoutItem(String strLayoutItemId) throws Exception {
        return (ILayoutItemHelper)this.layoutItemlGlobalModel.FindModelHelper(strLayoutItemId);
    }

    private static byte[] SymmetricDecrypto(byte[] byteSource, byte[] keyData) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int mode = 2;
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            DESKeySpec keySpec = new DESKeySpec(keyData);
            SecretKey key = keyFactory.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(mode, key);
            int blockSize = cipher.getBlockSize();
            int position = 0;
            int length = byteSource.length;
            boolean more = true;
            while (more) {
                if (position + blockSize <= length) {
                    baos.write(cipher.update(byteSource, position, blockSize));
                    position += blockSize;
                    continue;
                }
                more = false;
            }
            if (position < length) {
                baos.write(cipher.doFinal(byteSource, position, length - position));
            } else {
                baos.write(cipher.doFinal());
            }
            byte[] byArray = baos.toByteArray();
            return byArray;
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            baos.close();
        }
    }

    private final String RSADecrypt(String strSourceFile) {
        try {
            byte[] pubModBytes = Base64.decode((String)strRSAPubKey1);
            byte[] pubPubExpBytes = Base64.decode((String)strRSAPubKey2);
            RSAPublicKey recoveryPubKey = DAModelStorage.GenerateRSAPublicKey(pubModBytes, pubPubExpBytes);
            File file = new File(strSourceFile);
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] tmpbuf = new byte[1024];
            int count = 0;
            while ((count = in.read(tmpbuf)) != -1) {
                bout.write(tmpbuf, 0, count);
                tmpbuf = new byte[1024];
            }
            in.close();
            String strTemp = new String(bout.toByteArray());
            byte[] buf = Base64.decode((String)strTemp);
            byte[] raw = DAModelStorage.Decrypt(recoveryPubKey, buf);
            String strOutput = new String(raw);
            return strOutput;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    private static final RSAPublicKey GenerateRSAPublicKey(byte[] modulus, byte[] publicExponent) throws Exception {
        KeyFactory keyFac = null;
        try {
            keyFac = KeyFactory.getInstance("RSA", (Provider)new BouncyCastleProvider());
        }
        catch (NoSuchAlgorithmException ex) {
            throw new Exception(ex.getMessage());
        }
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
        try {
            return (RSAPublicKey)keyFac.generatePublic(pubKeySpec);
        }
        catch (InvalidKeySpecException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private static byte[] Decrypt(Key key, byte[] raw) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("RSA", (Provider)new BouncyCastleProvider());
            cipher.init(2, key);
            int blockSize = cipher.getBlockSize();
            ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
            int j = 0;
            while (raw.length - j * blockSize > 0) {
                bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
                ++j;
            }
            return bout.toByteArray();
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

