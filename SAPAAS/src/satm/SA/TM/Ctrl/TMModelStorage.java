/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.DefaultTransactionManager
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 */
package SA.TM.Ctrl;

import SA.SRFDA.Ctrl.DefaultTransactionManager;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.TM.Ctrl.Data.TMBTPRJInst;
import SA.TM.Ctrl.Data.TMRBRule;
import SA.TM.Ctrl.Data.TMRBRuleType;
import SA.TM.Ctrl.Data.TMResBT;
import SA.TM.Ctrl.Data.TMResBase;
import SA.TM.Ctrl.Data.TMResCatalog;
import SA.TM.Ctrl.Data.TMResType;
import SA.TM.Ctrl.Data.TMResView;
import SA.TM.Ctrl.Data.TMTaskBase;
import SA.TM.Ctrl.Data.TMTaskResAE;
import SA.TM.Ctrl.Data.TMTaskResAEType;
import SA.TM.Ctrl.Data.TMTaskType;
import SA.TM.Ctrl.Data.TMTimeRule;
import SA.TM.Ctrl.ITMBTPRJInstArrangeEngine;
import SA.TM.Ctrl.ITMBTPRJInstHelper;
import SA.TM.Ctrl.ITMBTTypeHelper;
import SA.TM.Ctrl.ITMModelStorage;
import SA.TM.Ctrl.ITMRBRuleHelper;
import SA.TM.Ctrl.ITMRBRuleTypeHelper;
import SA.TM.Ctrl.ITMResBTHelper;
import SA.TM.Ctrl.ITMResBaseHelper;
import SA.TM.Ctrl.ITMResCatalogHelper;
import SA.TM.Ctrl.ITMResTypeHelper;
import SA.TM.Ctrl.ITMResViewHelper;
import SA.TM.Ctrl.ITMTaskResAETypeHelper;
import SA.TM.Ctrl.ITMTaskResArrangeEngine;
import SA.TM.Ctrl.ITMTaskTypeHelper;
import SA.TM.Ctrl.ITMTimeRuleHelper;
import SA.TM.Ctrl.TMActionContext;
import SA.TM.Ctrl.TMBTPRJInstArrangeEngine;
import SA.TM.Ctrl.TMBTPRJInstArrangeEngineThread;
import SA.TM.Ctrl.TMBTTypeGlobalModel;
import SA.TM.Ctrl.TMObjectFactory;
import SA.TM.Ctrl.TMRBRuleGlobalModel;
import SA.TM.Ctrl.TMRBRuleTypeGlobalModel;
import SA.TM.Ctrl.TMRBRuleTypeHelper;
import SA.TM.Ctrl.TMResBTGlobalModel;
import SA.TM.Ctrl.TMResBTHelper;
import SA.TM.Ctrl.TMResCatalogGlobalModel;
import SA.TM.Ctrl.TMResCatalogHelper;
import SA.TM.Ctrl.TMResGlobalModel;
import SA.TM.Ctrl.TMResTypeGlobalModel;
import SA.TM.Ctrl.TMResTypeHelper;
import SA.TM.Ctrl.TMResViewGlobalModel;
import SA.TM.Ctrl.TMResViewHelper;
import SA.TM.Ctrl.TMTaskGlobalModel;
import SA.TM.Ctrl.TMTaskResAEGlobalModel;
import SA.TM.Ctrl.TMTaskResAETypeGlobalModel;
import SA.TM.Ctrl.TMTaskResAETypeHelper;
import SA.TM.Ctrl.TMTaskTypeGlobalModel;
import SA.TM.Ctrl.TMTaskTypeHelper;
import SA.TM.Ctrl.TMTimeRuleGlobalModel;
import SA.TM.Ctrl.TMTimeRuleHelper;
import java.util.Hashtable;

public class TMModelStorage
implements ITMModelStorage {
    protected ISRFDAGlobalHelper iDAGlobalHelper = null;
    protected TMTaskTypeGlobalModel tmTaskTypeGlobalModel = new TMTaskTypeGlobalModel();
    protected TMTaskGlobalModel tmTaskGlobalModel = new TMTaskGlobalModel();
    protected TMResGlobalModel tmResGlobalModel = new TMResGlobalModel();
    protected TMResTypeGlobalModel tmResTypeGlobalModel = new TMResTypeGlobalModel();
    protected TMRBRuleTypeGlobalModel tmRBRuleTypeGlobalModel = new TMRBRuleTypeGlobalModel();
    protected TMRBRuleGlobalModel tmRBRuleGlobalModel = new TMRBRuleGlobalModel();
    protected TMResCatalogGlobalModel tmResCatalogGlobalModel = new TMResCatalogGlobalModel();
    protected TMResViewGlobalModel tmResViewGlobalModel = new TMResViewGlobalModel();
    protected TMTimeRuleGlobalModel tmTimeRuleGlobalModel = new TMTimeRuleGlobalModel();
    protected TMTaskResAEGlobalModel tmTaskResAEGlobalModel = new TMTaskResAEGlobalModel();
    protected TMTaskResAETypeGlobalModel tmTaskResAETypeGlobalModel = new TMTaskResAETypeGlobalModel();
    protected TMResBTGlobalModel tmResBTGlobalModel = new TMResBTGlobalModel();
    protected TMBTTypeGlobalModel tmBTTypeGlobalModel = new TMBTTypeGlobalModel();
    protected Hashtable<String, ITMTaskTypeHelper> tmTaskTypeHelperMap = new Hashtable();
    protected Hashtable<String, ITMResTypeHelper> tmResTypeHelperMap = new Hashtable();
    protected Hashtable<String, ITMResBaseHelper> tmResBaseHelperMap = new Hashtable();
    protected Hashtable<String, ITMRBRuleTypeHelper> tmRBRuleTypeHelperMap = new Hashtable();
    protected Hashtable<String, ITMRBRuleHelper> tmRBRuleHelperMap = new Hashtable();
    protected Hashtable<String, ITMResCatalogHelper> tmResCatalogHelperMap = new Hashtable();
    protected Hashtable<String, ITMResViewHelper> tmResViewHelperMap = new Hashtable();
    protected Hashtable<String, ITMTimeRuleHelper> tmTimeRuleHelperMap = new Hashtable();
    protected Hashtable<String, ITMTaskResAETypeHelper> tmTaskResAETypeHelperMap = new Hashtable();
    protected Hashtable<String, ITMResBTHelper> tmResBTHelperMap = new Hashtable();
    protected Hashtable<String, ITMBTPRJInstArrangeEngine> tmBTPRJInstArrangeEngineMap = new Hashtable();

    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
        this.tmTaskTypeGlobalModel.Init(iDAGlobalHelper);
        this.tmTaskGlobalModel.Init(iDAGlobalHelper);
        this.tmResGlobalModel.Init(iDAGlobalHelper);
        this.tmResTypeGlobalModel.Init(iDAGlobalHelper);
        this.tmRBRuleTypeGlobalModel.Init(iDAGlobalHelper);
        this.tmRBRuleGlobalModel.Init(iDAGlobalHelper);
        this.tmResCatalogGlobalModel.Init(iDAGlobalHelper);
        this.tmResViewGlobalModel.Init(iDAGlobalHelper);
        this.tmTimeRuleGlobalModel.Init(iDAGlobalHelper);
        this.tmTaskResAEGlobalModel.Init(iDAGlobalHelper);
        this.tmTaskResAETypeGlobalModel.Init(iDAGlobalHelper);
        this.tmResBTGlobalModel.Init(iDAGlobalHelper);
        this.tmBTTypeGlobalModel.Init(iDAGlobalHelper);
        this.OnInit();
    }

    protected void OnInit() {
    }

    public ITMTaskTypeHelper FindTMTaskType(String strTMTaskTypeId) throws Exception {
        Object objTMTaskType = this.tmTaskTypeGlobalModel.FindModel(strTMTaskTypeId);
        if (objTMTaskType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4efb\u52a1\u7c7b\u578b[%1$s]", (Object)strTMTaskTypeId));
        }
        TMTaskType tmTaskType = (TMTaskType)((Object)objTMTaskType);
        ITMTaskTypeHelper iTMTaskTypeHelper = this.tmTaskTypeHelperMap.get(strTMTaskTypeId);
        if (iTMTaskTypeHelper != null) {
            return iTMTaskTypeHelper;
        }
        iTMTaskTypeHelper = this.OnCreateTMTaskTypeHelper(tmTaskType);
        iTMTaskTypeHelper.Init(this.iDAGlobalHelper, tmTaskType);
        this.tmTaskTypeHelperMap.put(strTMTaskTypeId, iTMTaskTypeHelper);
        return iTMTaskTypeHelper;
    }

    protected ITMTaskTypeHelper OnCreateTMTaskTypeHelper(TMTaskType tmTaskType) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)tmTaskType.getHELPEROBJECT())) {
            return new TMTaskTypeHelper();
        }
        Object objHelper = ObjectHelper.Create((String)tmTaskType.getHELPEROBJECT());
        if (objHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1\u7c7b\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)tmTaskType.getHELPEROBJECT()));
        }
        if (!(objHelper instanceof ITMTaskTypeHelper)) {
            throw new Exception(StringHelper.Format((String)"\u4efb\u52a1\u7c7b\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)tmTaskType.getHELPEROBJECT()));
        }
        return (ITMTaskTypeHelper)objHelper;
    }

    public ITMResCatalogHelper FindTMResCatalog(String strTMResCatalogId) throws Exception {
        Object objTMResCatalog = this.tmResCatalogGlobalModel.FindModel(strTMResCatalogId);
        if (objTMResCatalog == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8d44\u6e90\u5206\u7c7b[%1$s]", (Object)strTMResCatalogId));
        }
        TMResCatalog tmResCatalog = (TMResCatalog)((Object)objTMResCatalog);
        ITMResCatalogHelper iTMResCatalogHelper = this.tmResCatalogHelperMap.get(strTMResCatalogId);
        if (iTMResCatalogHelper != null && iTMResCatalogHelper.getVersion() == tmResCatalog.getVERSION()) {
            return iTMResCatalogHelper;
        }
        iTMResCatalogHelper = this.OnCreateTMResCatalogHelper(tmResCatalog);
        iTMResCatalogHelper.Init(this.iDAGlobalHelper, tmResCatalog);
        this.tmResCatalogHelperMap.put(strTMResCatalogId, iTMResCatalogHelper);
        return iTMResCatalogHelper;
    }

    protected ITMResCatalogHelper OnCreateTMResCatalogHelper(TMResCatalog tmResCatalog) throws Exception {
        return new TMResCatalogHelper();
    }

    public ITMRBRuleTypeHelper FindTMRBRuleType(String strTMRBRuleTypeId) throws Exception {
        Object objTMRBRuleType = this.tmRBRuleTypeGlobalModel.FindModel(strTMRBRuleTypeId);
        if (objTMRBRuleType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8d44\u6e90\u9884\u7ea6\u89c4\u5219\u7c7b\u578b[%1$s]", (Object)strTMRBRuleTypeId));
        }
        TMRBRuleType tmRBRuleType = (TMRBRuleType)((Object)objTMRBRuleType);
        ITMRBRuleTypeHelper iTMRBRuleTypeHelper = this.tmRBRuleTypeHelperMap.get(strTMRBRuleTypeId);
        if (iTMRBRuleTypeHelper != null) {
            return iTMRBRuleTypeHelper;
        }
        iTMRBRuleTypeHelper = this.OnCreateTMRBRuleTypeHelper(tmRBRuleType);
        iTMRBRuleTypeHelper.Init(this.iDAGlobalHelper, tmRBRuleType);
        this.tmRBRuleTypeHelperMap.put(strTMRBRuleTypeId, iTMRBRuleTypeHelper);
        return iTMRBRuleTypeHelper;
    }

    protected ITMRBRuleTypeHelper OnCreateTMRBRuleTypeHelper(TMRBRuleType tmRBRuleType) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)tmRBRuleType.getHELPEROBJECT())) {
            return new TMRBRuleTypeHelper();
        }
        Object objHelper = ObjectHelper.Create((String)tmRBRuleType.getHELPEROBJECT());
        if (objHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u8d44\u6e90\u9884\u7ea6\u89c4\u5219\u7c7b\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)tmRBRuleType.getHELPEROBJECT()));
        }
        if (!(objHelper instanceof ITMRBRuleTypeHelper)) {
            throw new Exception(StringHelper.Format((String)"\u8d44\u6e90\u9884\u7ea6\u89c4\u5219\u7c7b\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)tmRBRuleType.getHELPEROBJECT()));
        }
        return (ITMRBRuleTypeHelper)objHelper;
    }

    public ITMResTypeHelper FindTMResType(String strTMResTypeId) throws Exception {
        Object objTMResType = this.tmResTypeGlobalModel.FindModel(strTMResTypeId);
        if (objTMResType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8d44\u6e90\u7c7b\u578b[%1$s]", (Object)strTMResTypeId));
        }
        TMResType tmResType = (TMResType)((Object)objTMResType);
        ITMResTypeHelper iTMResTypeHelper = this.tmResTypeHelperMap.get(strTMResTypeId);
        if (iTMResTypeHelper != null) {
            return iTMResTypeHelper;
        }
        iTMResTypeHelper = this.OnCreateTMResTypeHelper(tmResType);
        iTMResTypeHelper.Init(this.iDAGlobalHelper, tmResType);
        this.tmResTypeHelperMap.put(strTMResTypeId, iTMResTypeHelper);
        return iTMResTypeHelper;
    }

    protected ITMResTypeHelper OnCreateTMResTypeHelper(TMResType tmResType) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)tmResType.getHELPEROBJECT())) {
            return new TMResTypeHelper();
        }
        Object objHelper = ObjectHelper.Create((String)tmResType.getHELPEROBJECT());
        if (objHelper == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u8d44\u6e90\u7c7b\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]", (Object)tmResType.getHELPEROBJECT()));
        }
        if (!(objHelper instanceof ITMResTypeHelper)) {
            throw new Exception(StringHelper.Format((String)"\u8d44\u6e90\u7c7b\u578b\u8f85\u52a9\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)tmResType.getHELPEROBJECT()));
        }
        return (ITMResTypeHelper)objHelper;
    }

    public ITMResBTHelper FindTMResBT(String strTMResBTId) throws Exception {
        Object objTMResBT = this.tmResBTGlobalModel.FindModel(strTMResBTId);
        if (objTMResBT == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8d44\u6e90\u9884\u7ea6\u7c7b\u578b[%1$s]", (Object)strTMResBTId));
        }
        TMResBT tmResBT = (TMResBT)((Object)objTMResBT);
        ITMResBTHelper iTMResBTHelper = this.tmResBTHelperMap.get(strTMResBTId);
        if (iTMResBTHelper != null) {
            return iTMResBTHelper;
        }
        iTMResBTHelper = this.OnCreateTMResBTHelper(tmResBT);
        iTMResBTHelper.Init(this.iDAGlobalHelper, tmResBT);
        this.tmResBTHelperMap.put(strTMResBTId, iTMResBTHelper);
        return iTMResBTHelper;
    }

    protected ITMResBTHelper OnCreateTMResBTHelper(TMResBT tmResBT) throws Exception {
        return new TMResBTHelper();
    }

    public ITMResBaseHelper FindTMResource(String strTMResBaseId) throws Exception {
        Object objTMResBase = this.tmResGlobalModel.FindModel(strTMResBaseId);
        if (objTMResBase == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8d44\u6e90[%1$s]", (Object)strTMResBaseId));
        }
        TMResBase tmResBase = (TMResBase)((Object)objTMResBase);
        ITMResBaseHelper iTMResBaseHelper = this.tmResBaseHelperMap.get(strTMResBaseId);
        if (iTMResBaseHelper != null && iTMResBaseHelper.getVersion() == tmResBase.getVERSION()) {
            return iTMResBaseHelper;
        }
        ITMResTypeHelper iTMResTypeHelper = this.FindTMResType(tmResBase.getTMRESBASETYPE());
        iTMResBaseHelper = iTMResTypeHelper.CreateResource();
        iTMResBaseHelper.Init(this.iDAGlobalHelper, iTMResTypeHelper, tmResBase);
        this.tmResBaseHelperMap.put(strTMResBaseId, iTMResBaseHelper);
        return iTMResBaseHelper;
    }

    public TMTaskBase FindTMTask(String strTMTaskBaseId, int nVersion) throws Exception {
        Object objTMTaskBase = this.tmTaskGlobalModel.FindModel(strTMTaskBaseId);
        if (objTMTaskBase == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4efb\u52a1[%1$s]", (Object)strTMTaskBaseId));
        }
        TMTaskBase tmTaskBase = (TMTaskBase)((Object)objTMTaskBase);
        if (tmTaskBase.getVERSION() == nVersion) {
            return tmTaskBase;
        }
        this.tmTaskGlobalModel.ResetModel(strTMTaskBaseId);
        return this.FindTMTask(strTMTaskBaseId);
    }

    public TMTaskBase FindTMTask(String strTMTaskBaseId) throws Exception {
        Object objTMTaskBase = this.tmTaskGlobalModel.FindModel(strTMTaskBaseId);
        if (objTMTaskBase == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4efb\u52a1[%1$s]", (Object)strTMTaskBaseId));
        }
        return (TMTaskBase)((Object)objTMTaskBase);
    }

    public ITMRBRuleHelper FindTMRBRule(String strTMRBRuleId) throws Exception {
        Object objTMRBRule = this.tmRBRuleGlobalModel.FindModel(strTMRBRuleId);
        if (objTMRBRule == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8d44\u6e90\u89c4\u5219[%1$s]", (Object)strTMRBRuleId));
        }
        return this.FindTMRBRule((TMRBRule)((Object)objTMRBRule));
    }

    public ITMRBRuleHelper FindTMRBRule(TMRBRule tmRBRule) throws Exception {
        ITMRBRuleHelper iTMRBRuleHelper = this.tmRBRuleHelperMap.get(tmRBRule.getTMRBRULEID());
        if (iTMRBRuleHelper != null && iTMRBRuleHelper.getVersion() == tmRBRule.getVERSION()) {
            return iTMRBRuleHelper;
        }
        iTMRBRuleHelper = this.OnCreateTMRBRuleHelper(tmRBRule);
        iTMRBRuleHelper.Init(this.iDAGlobalHelper, tmRBRule);
        this.tmRBRuleHelperMap.put(tmRBRule.getTMRBRULEID(), iTMRBRuleHelper);
        return iTMRBRuleHelper;
    }

    protected ITMRBRuleHelper OnCreateTMRBRuleHelper(TMRBRule tmRBRule) throws Exception {
        ITMRBRuleTypeHelper iTMRBRuleTypeHelper = this.FindTMRBRuleType(tmRBRule.getTMRBRULETYPE());
        return iTMRBRuleTypeHelper.CreateRBRule(tmRBRule);
    }

    public ITMResViewHelper FindTMResView(String strTMResViewId) throws Exception {
        Object objTMResView = this.tmResViewGlobalModel.FindModel(strTMResViewId);
        if (objTMResView == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u8d44\u6e90\u89c6\u56fe[%1$s]", (Object)strTMResViewId));
        }
        return this.FindTMResView((TMResView)((Object)objTMResView));
    }

    public ITMResViewHelper FindTMResView(TMResView tmResView) throws Exception {
        ITMResViewHelper iTMResViewHelper = this.tmResViewHelperMap.get(tmResView.getTMRESVIEWID());
        if (iTMResViewHelper != null && iTMResViewHelper.getVersion() == tmResView.getVERSION()) {
            return iTMResViewHelper;
        }
        iTMResViewHelper = this.OnCreateTMResViewHelper(tmResView);
        iTMResViewHelper.Init(this.iDAGlobalHelper, tmResView);
        this.tmResViewHelperMap.put(tmResView.getTMRESVIEWID(), iTMResViewHelper);
        return iTMResViewHelper;
    }

    protected ITMResViewHelper OnCreateTMResViewHelper(TMResView tmResView) throws Exception {
        return new TMResViewHelper();
    }

    public ITMTimeRuleHelper FindTMTimeRule(String strTMTimeRuleId) throws Exception {
        Object objTMTimeRule = this.tmTimeRuleGlobalModel.FindModel(strTMTimeRuleId);
        if (objTMTimeRule == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u65f6\u95f4\u89c4\u5219[%1$s]", (Object)strTMTimeRuleId));
        }
        return this.FindTMTimeRule((TMTimeRule)((Object)objTMTimeRule));
    }

    public ITMTimeRuleHelper FindTMTimeRule(TMTimeRule tmTimeRule) throws Exception {
        ITMTimeRuleHelper iTMTimeRuleHelper = this.tmTimeRuleHelperMap.get(tmTimeRule.getTMTIMERULEID());
        if (iTMTimeRuleHelper != null && iTMTimeRuleHelper.getVersion() == tmTimeRule.getVERSION()) {
            return iTMTimeRuleHelper;
        }
        iTMTimeRuleHelper = this.OnCreateTMTimeRuleHelper(tmTimeRule);
        iTMTimeRuleHelper.Init(this.iDAGlobalHelper, tmTimeRule);
        this.tmTimeRuleHelperMap.put(tmTimeRule.getTMTIMERULEID(), iTMTimeRuleHelper);
        return iTMTimeRuleHelper;
    }

    protected ITMTimeRuleHelper OnCreateTMTimeRuleHelper(TMTimeRule tmTimeRule) throws Exception {
        return new TMTimeRuleHelper();
    }

    public ITMTaskResArrangeEngine CreateTMTaskResArrangeEngine(String strTMTaskResAEId) throws Exception {
        Object objTMTaskResAE = this.tmTaskResAEGlobalModel.FindModel(strTMTaskResAEId);
        if (objTMTaskResAE == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4efb\u52a1\u8d44\u6e90\u6392\u5e03\u5f15\u64ce[%1$s]", (Object)strTMTaskResAEId));
        }
        TMTaskResAE tmTaskResAE = (TMTaskResAE)((Object)objTMTaskResAE);
        ITMTaskResAETypeHelper iTMTaskResAETypeHelper = this.FindTMTaskResAEType(tmTaskResAE.getTMTASKRESAETYPEID());
        ITMTaskResArrangeEngine iTMTaskResArrangeEngine = iTMTaskResAETypeHelper.CreateEngine();
        iTMTaskResArrangeEngine.Init(this.iDAGlobalHelper, tmTaskResAE);
        return iTMTaskResArrangeEngine;
    }

    public ITMTaskResAETypeHelper FindTMTaskResAEType(String strTMTaskResAETypeId) throws Exception {
        Object objTMTaskResAEType = this.tmTaskResAETypeGlobalModel.FindModel(strTMTaskResAETypeId);
        if (objTMTaskResAEType == null) {
            throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u4efb\u52a1\u8d44\u6e90\u6392\u5e03\u5f15\u64ce\u7c7b\u578b[%1$s]", (Object)strTMTaskResAETypeId));
        }
        TMTaskResAEType tmTaskResAEType = (TMTaskResAEType)((Object)objTMTaskResAEType);
        ITMTaskResAETypeHelper iTMTaskResAETypeHelper = this.tmTaskResAETypeHelperMap.get(strTMTaskResAETypeId);
        if (iTMTaskResAETypeHelper != null) {
            return iTMTaskResAETypeHelper;
        }
        iTMTaskResAETypeHelper = this.OnCreateTMTaskResAETypeHelper(tmTaskResAEType);
        iTMTaskResAETypeHelper.Init(this.iDAGlobalHelper, tmTaskResAEType);
        this.tmTaskResAETypeHelperMap.put(strTMTaskResAETypeId, iTMTaskResAETypeHelper);
        return iTMTaskResAETypeHelper;
    }

    protected ITMTaskResAETypeHelper OnCreateTMTaskResAETypeHelper(TMTaskResAEType tmTaskResAEType) throws Exception {
        return new TMTaskResAETypeHelper();
    }

    public ITMBTTypeHelper FindTMBTType(String strTMBTTypeId) throws Exception {
        return (ITMBTTypeHelper)this.tmBTTypeGlobalModel.FindModelHelper(strTMBTTypeId);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void RunTMBTPrjInst(String strTMBTPrjInstId) throws Exception {
        Hashtable<String, ITMBTPRJInstArrangeEngine> hashtable = this.tmBTPRJInstArrangeEngineMap;
        synchronized (hashtable) {
            boolean bLoop = true;
            block3: while (bLoop) {
                bLoop = false;
                for (String strKey : this.tmBTPRJInstArrangeEngineMap.keySet()) {
                    ITMBTPRJInstArrangeEngine iTMBTPRJInstArrangeEngine = this.tmBTPRJInstArrangeEngineMap.get(strKey);
                    if (!iTMBTPRJInstArrangeEngine.isStop()) continue;
                    this.tmBTPRJInstArrangeEngineMap.remove(strKey);
                    bLoop = true;
                    continue block3;
                }
            }
            if (this.tmBTPRJInstArrangeEngineMap.containsKey(strTMBTPrjInstId)) {
                throw new Exception("\u6d4b\u7b97\u9879\u76ee\u5b9e\u4f8b\u6b63\u5728\u8ba1\u7b97\u4e2d");
            }
            TMBTPRJInst tmBTPRJInst = new TMBTPRJInst();
            tmBTPRJInst.setTMBTPRJINSTID(strTMBTPrjInstId);
            IDEDataCtrl tmBTPRJInstDataCtrl = this.iDAGlobalHelper.getDAModelStorage().FindDEDataCtrl2("TM0147", "SYSTEM", null);
            DefaultTransactionManager transactionManager = new DefaultTransactionManager();
            transactionManager.Init(this.iDAGlobalHelper);
            transactionManager.Register(tmBTPRJInstDataCtrl);
            CallResult callResult = tmBTPRJInstDataCtrl.Get((BaseDataEntity)tmBTPRJInst);
            if (callResult.IsError()) {
                throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u8bd5\u7b97\u9879\u76ee\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            if (!StringHelper.IsNullOrEmpty((String)tmBTPRJInst.getBTSTATE()) && StringHelper.Compare((String)tmBTPRJInst.getBTSTATE(), (String)"UNTEST", (boolean)true) != 0) {
                throw new Exception(StringHelper.Format((String)"\u8bd5\u7b97\u9879\u76ee\u5b9e\u4f8b\u5df2\u7ecf\u8fdb\u884c\u8fc7\u8ba1\u7b97\uff0c\u65e0\u6cd5\u518d\u6b21\u8ba1\u7b97"));
            }
            TMActionContext tmActionContext = new TMActionContext();
            tmActionContext.Init(this.iDAGlobalHelper, tmBTPRJInstDataCtrl);
            ITMBTPRJInstHelper iTMBTPRJInstHelper = TMObjectFactory.getCurrent().CreateBTPRJInstHelper(this.iDAGlobalHelper, tmBTPRJInst);
            TMBTPRJInstArrangeEngine tmBTPRJInstArrangeEngine = new TMBTPRJInstArrangeEngine();
            tmBTPRJInstArrangeEngine.Init(tmActionContext, iTMBTPRJInstHelper);
            this.tmBTPRJInstArrangeEngineMap.put(strTMBTPrjInstId, tmBTPRJInstArrangeEngine);
            TMBTPRJInstArrangeEngineThread thread = new TMBTPRJInstArrangeEngineThread(tmBTPRJInstArrangeEngine);
            Thread thread1 = new Thread(thread);
            thread1.start();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void CancelRunTMBTPrjInst(String strTMBTPrjInstId) throws Exception {
        Hashtable<String, ITMBTPRJInstArrangeEngine> hashtable = this.tmBTPRJInstArrangeEngineMap;
        synchronized (hashtable) {
            boolean bLoop = true;
            block3: while (bLoop) {
                bLoop = false;
                for (String strKey : this.tmBTPRJInstArrangeEngineMap.keySet()) {
                    ITMBTPRJInstArrangeEngine iTMBTPRJInstArrangeEngine = this.tmBTPRJInstArrangeEngineMap.get(strKey);
                    if (!iTMBTPRJInstArrangeEngine.isStop()) continue;
                    this.tmBTPRJInstArrangeEngineMap.remove(strKey);
                    bLoop = true;
                    continue block3;
                }
            }
            if (!this.tmBTPRJInstArrangeEngineMap.containsKey(strTMBTPrjInstId)) {
                throw new Exception("\u6d4b\u7b97\u9879\u76ee\u5b9e\u4f8b\u4e0d\u5728\u8ba1\u7b97\u8fc7\u7a0b\u4e2d\uff0c\u4e0d\u80fd\u505c\u6b62");
            }
            ITMBTPRJInstArrangeEngine iTMBTPRJInstArrangeEngine = this.tmBTPRJInstArrangeEngineMap.get(strTMBTPrjInstId);
            iTMBTPRJInstArrangeEngine.setUserStop();
        }
    }
}

