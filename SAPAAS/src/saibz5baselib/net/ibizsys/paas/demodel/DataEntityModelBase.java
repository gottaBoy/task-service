/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEACMode;
import net.ibizsys.paas.core.IDEAction;
import net.ibizsys.paas.core.IDEActionWizard;
import net.ibizsys.paas.core.IDEActionWizardGroup;
import net.ibizsys.paas.core.IDEBATable;
import net.ibizsys.paas.core.IDEDBConfig;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataImport;
import net.ibizsys.paas.core.IDEDataQuery;
import net.ibizsys.paas.core.IDEDataQueryCodeCond;
import net.ibizsys.paas.core.IDEDataSet;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSync;
import net.ibizsys.paas.core.IDEDataSyncIn;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDELogic;
import net.ibizsys.paas.core.IDEMainState;
import net.ibizsys.paas.core.IDEOPPrivRole;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDERIndex;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.core.IDEUniState;
import net.ibizsys.paas.core.IDEUserRole;
import net.ibizsys.paas.core.IDEWF;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.datasync.DataSyncGlobal;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.ISelectFieldFilter;
import net.ibizsys.paas.db.ProcParam;
import net.ibizsys.paas.db.ProcParamList;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEActionLogicModel;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEActionLogicModel;
import net.ibizsys.paas.demodel.IDEDBConfigModel;
import net.ibizsys.paas.demodel.IDELogicModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDEWFModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.ISqlCommandModel;
import net.ibizsys.paas.demodel.SqlCommandModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionSupporter;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pswf.core.IWFDEModel;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class DataEntityModelBase<ET extends IEntity>
extends ModelBase3Impl
implements IDataEntityModel<ET>,
IDEDBConfig {
    private static final Log log = LogFactory.getLog(DataEntityModelBase.class);
    protected HashMap<String, IDEDataQuery> deDataQueryMap = new HashMap();
    protected ArrayList<IDEDataQuery> deDataQueryList = new ArrayList();
    protected HashMap<String, IDEDataSet> deDataSetModelMap = new HashMap();
    private HashMap<String, IDEField> deFieldMap = new HashMap();
    private ArrayList<IDEField> deFieldList = new ArrayList();
    private HashMap<String, IDEField> pdtDEFieldMap = new HashMap();
    private HashMap<String, IDEAction> deActionMap = new HashMap();
    private HashMap<String, IDEACMode> deACModeMap = new HashMap();
    private HashMap<String, IDELogic> deLogicMap = new HashMap();
    private HashMap<String, IDEUIAction> deUIActionMap = new HashMap();
    private HashMap<String, IDEWF> deWFMap = new HashMap();
    private ArrayList<IDEWF> deWFList = new ArrayList();
    private HashMap<String, IDEMainState> deMainStateMap = new HashMap();
    private HashMap<String, String> pdtDEViewMap = new HashMap();
    private HashMap<String, String> deOPPrivMapMap = new HashMap();
    private ArrayList<IDEDataSync> deDataSyncInList = null;
    private ArrayList<IDEDataSync> deDataSyncOutList = null;
    private HashMap<String, IDEDataExport> deDataExportMap = new HashMap();
    private HashMap<String, IDEDataImport> deDataImportMap = new HashMap();
    private IDEDataImport defaultDEDataImport = null;
    protected HashMap<String, IDEActionWizardGroup> deActionWizardGroupMap = new HashMap();
    protected HashMap<String, IDEActionWizard> deActionWizardMap = new HashMap();
    private HashMap<String, IDEUniState> deUniStateMap = new HashMap();
    private HashMap<String, IDEUserRole> deUserRoleMap = new HashMap();
    private HashMap<String, ArrayList<IDEOPPrivRole>> deOPPrivRoleListMap = new HashMap();
    private HashMap<String, IDEBATable> deBATableMap = null;
    private ArrayList<IDEBATable> deBATablList = null;
    private HashMap<String, IDEDBConfig> deDBConfigMap = null;
    private HashMap<String, ArrayList<IDELogicModel<ET>>> actionDELogicsMap = new HashMap();
    private HashMap<String, ArrayList<IDEActionLogicModel>> actionDELogicsMap2 = new HashMap();
    protected ArrayList<IDEField> unionKeyValueFieldList = new ArrayList();
    protected HashMap<String, IDEField> unionKeyValueFieldMap = new HashMap();
    private IDEACMode defaultDEACMode = null;
    private IDEField keyDEField = null;
    private IDEField uniTagDEField = null;
    private IDEField majorDEField = null;
    private IDEField logicValidDEField = null;
    private IDEField orgIdDEField = null;
    private Object validValue = null;
    private Object invalidValue = null;
    private boolean bLogicValid = false;
    private String strValidValue = null;
    private String strInvalidValue = null;
    private String strTableName = null;
    private String strViewName = null;
    private String strLogicName = null;
    private String strDSLink = null;
    private boolean bEnableMultiDS = false;
    private String[] mainStateFields = null;
    private IDEWF defaultDEWF = null;
    private IDEField updateDateDEField = null;
    private HashMap<String, IDEFSearchMode> defSearchModeMap = new HashMap();
    private IDEMainState defaultDEMainState = null;
    private IDEDataAccMgr iDEDataAccMgr = null;
    private int nDataAccCtrlMode = 1;
    private ArrayList<IDER1N> masterDERList = null;
    private int nAuditMode = 0;
    private boolean bEnableMultiForm = false;
    private String strIndexDEType = null;
    private IDEField multiFormDEField = null;
    private IDEField indexTypeDEField = null;
    private String strInheritDEId = null;
    private IDataEntityModel inheritDEModel = null;
    private int nDynamicMode = 0;
    private int nDataChangeLogMode = 0;
    private boolean bNoViewMode = false;
    private IDEDataQuery defaultDEDataQuery = null;
    private int nStorageMode = 1;
    private IServicePlugin iServicePlugin = null;
    private String strView2Name = null;
    private String strView3Name = null;
    private String strView4Name = null;
    private String strDataInfoFormat = null;
    private String[] dataInfoFields = null;
    private boolean bEnableEntityCache = false;
    private int nEntityCacheTimeout = -1;
    private int nEntityCacheCount = 1000;
    private IDEUniState defaultDEUniState = null;
    private int nDataImpExpMode = 3;
    private Object objRuntimeId = null;
    private String strServiceAPIClientId = null;
    private String strServiceActionDETag = null;
    private String strDefaultDEDTSQueueId = null;
    private int nDataAccCtrlArch = 1;
    private String strAuditDEName = null;
    private String strAuditDetailDEName = null;
    private IDynaViewSetting iDynaViewSetting = null;
    private ISystemModel iSystemModel = null;
    private boolean bEnableDynaStorage = false;
    private String strDynaStorageDEName = null;
    private boolean bHasDynaStorageField = false;
    private String strInheritTypeValue = null;
    private boolean bEnableTempData = false;

    /*
     * Unable to fully structure code
     */
    protected void prepareModels() throws Exception {
        block6: {
            this.prepareDEFields();
            this.updateDateDEField = this.getDEFieldByPDT("UPDATEDATE", true);
            if (this.isLogicValid()) {
                this.validValue = DataTypeHelper.parse(this.logicValidDEField.getStdDataType(), this.getValidValue());
                this.invalidValue = DataTypeHelper.parse(this.logicValidDEField.getStdDataType(), this.getInvalidValue());
            }
            this.unionKeyValueFieldList.clear();
            if (this.unionKeyValueFieldMap.size() > 0) {
                i = 1;
                while (i < 9) {
                    strKey = StringHelper.format("KEY%1$s", i);
                    iDEField = this.unionKeyValueFieldMap.get(strKey);
                    if (iDEField != null) {
                        this.unionKeyValueFieldList.add(iDEField);
                    }
                    ++i;
                }
            }
            this.prepareDEDBConfigs();
            this.prepareDEACModes();
            this.prepareDEDataQueries();
            this.prepareDEDataSets();
            this.prepareDELogics();
            this.prepareDEUIActions();
            this.prepareDEActions();
            this.prepareDEMainStates();
            this.prepareDEDataSyncs();
            this.prepareDEDataImports();
            this.prepareDEDataExports();
            this.prepareDEWFs();
            this.preparePDTDEViews();
            this.prepareDEOPPrivTagMaps();
            this.prepareDEPrints();
            this.prepareDEReports();
            this.prepareDEActionWizards();
            this.prepareDEActionWizardGroups();
            this.prepareDEUniStates();
            this.prepareDEDTSQueues();
            this.prepareDEUserRoles();
            this.prepareDEOPPrivRoles();
            this.prepareDEBATables();
            this.setNoViewMode(this.getSystemModel().isNoViewMode(this));
            this.iDEDataAccMgr = this.prepareDEDataAccMgr();
            if (this.getDataAccCtrlMode() != 2 && this.getDataAccCtrlMode() != 3) break block6;
            derBases = this.getDERs(false);
            if (derBases != null) ** GOTO lbl52
            throw new Exception(StringHelper.format("\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u63a7\u5236\u5b9a\u4e49\u4e3a\u4e3b\u5b9e\u4f53\uff0c\u4f46\u672a\u627e\u5230\u4efb\u4f55\u5173\u7cfb", this.getName()));
lbl-1000:
            // 1 sources

            {
                iDERBase = derBases.next();
                if (!(iDERBase instanceof IDER1N) || ((iDER1N = (IDER1N)iDERBase).getMasterRS() & 4) <= 0) continue;
                if (this.masterDERList == null) {
                    this.masterDERList = new ArrayList<E>();
                }
                this.masterDERList.add(iDER1N);
lbl52:
                // 3 sources

                ** while (derBases.hasNext())
            }
        }
    }

    protected IDEDataAccMgr prepareDEDataAccMgr() throws Exception {
        if (this.getSystemModel() != null) {
            return this.getSystemModel().createDEDataAccMgr(this);
        }
        DEDataAccMgr iDEDataAccMgr = new DEDataAccMgr();
        iDEDataAccMgr.init(this);
        return iDEDataAccMgr;
    }

    protected void prepareDEDBConfigs() throws Exception {
    }

    protected void prepareDEDataQueries() throws Exception {
    }

    protected void prepareDEDataSets() throws Exception {
    }

    protected void prepareDEActions() throws Exception {
    }

    protected void prepareDEACModes() throws Exception {
    }

    protected void prepareDELogics() throws Exception {
    }

    protected void prepareDEUIActions() throws Exception {
    }

    protected void prepareDEWFs() throws Exception {
    }

    protected void prepareDEMainStates() throws Exception {
    }

    protected void preparePDTDEViews() throws Exception {
    }

    protected void prepareDEOPPrivTagMaps() throws Exception {
    }

    protected void prepareDEPrints() throws Exception {
    }

    protected void prepareDEReports() throws Exception {
    }

    protected void prepareDEDataSyncs() throws Exception {
    }

    protected void prepareDEDataImports() throws Exception {
    }

    protected void prepareDEDataExports() throws Exception {
    }

    protected void prepareDEActionWizards() throws Exception {
    }

    protected void prepareDEActionWizardGroups() throws Exception {
    }

    protected void prepareDEBATables() throws Exception {
    }

    protected void prepareDEUniStates() throws Exception {
    }

    protected void prepareDEDTSQueues() throws Exception {
    }

    protected void prepareDEUserRoles() throws Exception {
    }

    protected void prepareDEOPPrivRoles() throws Exception {
    }

    @Override
    public ArrayList<ET> createEntityList() {
        return new ArrayList();
    }

    protected IDEField createDEField(String strDEFName) throws Exception {
        return null;
    }

    protected IDEFSearchMode createDEFSearchMode(IDEField iDEField, String strDEFSearchModeName) throws Exception {
        return null;
    }

    protected void prepareDEFields() throws Exception {
    }

    @Override
    public void registerDEField(IDEField iDEField) {
        Iterator<IDEFSearchMode> defSearchModes;
        this.deFieldList.add(iDEField);
        this.deFieldMap.put(iDEField.getId(), iDEField);
        this.deFieldMap.put(iDEField.getName(), iDEField);
        if (this.keyDEField == null && iDEField.isKeyDEField()) {
            this.keyDEField = iDEField;
        }
        if (this.uniTagDEField == null && iDEField.isUniTagField()) {
            this.uniTagDEField = iDEField;
        }
        if (this.majorDEField == null && iDEField.isMajorDEField()) {
            this.majorDEField = iDEField;
        }
        if (this.logicValidDEField == null && StringHelper.compare(iDEField.getPreDefinedType(), "LOGICVALID", true) == 0) {
            this.logicValidDEField = iDEField;
        }
        if (this.orgIdDEField == null && StringHelper.compare(iDEField.getPreDefinedType(), "ORGID", true) == 0) {
            this.orgIdDEField = iDEField;
        }
        if (!StringHelper.isNullOrEmpty(iDEField.getPreDefinedType())) {
            this.pdtDEFieldMap.put(iDEField.getPreDefinedType(), iDEField);
        }
        if (!StringHelper.isNullOrEmpty(iDEField.getUnionKeyValue())) {
            this.unionKeyValueFieldMap.put(iDEField.getUnionKeyValue(), iDEField);
        }
        if (iDEField.isMultiFormDEField()) {
            this.multiFormDEField = iDEField;
        }
        if (iDEField.isIndexTypeDEField()) {
            this.indexTypeDEField = iDEField;
        }
        if (iDEField.getDEFType() == 4) {
            this.bHasDynaStorageField = true;
        }
        if ((defSearchModes = iDEField.getDEFSearchModes()) != null) {
            while (defSearchModes.hasNext()) {
                IDEFSearchMode iDEFSearchMode = defSearchModes.next();
                this.defSearchModeMap.put(iDEFSearchMode.getName().toLowerCase(), iDEFSearchMode);
            }
        }
    }

    @Override
    public IDEField getDEField(String strName, boolean bTry) throws Exception {
        IDEField deField = this.deFieldMap.get(strName);
        if (deField == null && (deField = this.deFieldMap.get(strName.toUpperCase())) == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5c5e\u6027[%1$s]", strName));
        }
        return deField;
    }

    @Override
    public Iterator<IDEField> getDEFields() {
        return this.deFieldList.iterator();
    }

    @Override
    public void registerDEDataQuery(IDEDataQuery iDEDataQuery) {
        String strId = iDEDataQuery.getId();
        String strName = iDEDataQuery.getName();
        this.deDataQueryMap.put(strId, iDEDataQuery);
        this.deDataQueryMap.put(strName, iDEDataQuery);
        this.deDataQueryMap.put(strName.toUpperCase(), iDEDataQuery);
        this.deDataQueryList.add(iDEDataQuery);
        if (iDEDataQuery.isDefaultMode()) {
            this.defaultDEDataQuery = iDEDataQuery;
        } else if (this.defaultDEDataQuery == null && StringHelper.compare(strName, "DEFAULT", false) == 0) {
            this.defaultDEDataQuery = iDEDataQuery;
        }
    }

    @Override
    public void registerDEDataSet(IDEDataSet iDEDataSet) {
        String strId = iDEDataSet.getId();
        String strName = iDEDataSet.getName();
        this.deDataSetModelMap.put(strId, iDEDataSet);
        this.deDataSetModelMap.put(strName, iDEDataSet);
        this.deDataSetModelMap.put(strName.toUpperCase(), iDEDataSet);
    }

    @Override
    public void registerDEAction(IDEAction iDEAction) {
        this.deActionMap.put(iDEAction.getId(), iDEAction);
        this.deActionMap.put(iDEAction.getName(), iDEAction);
    }

    @Override
    public void registerDEACMode(IDEACMode iDEACMode) {
        this.deACModeMap.put(iDEACMode.getId(), iDEACMode);
        this.deACModeMap.put(iDEACMode.getName(), iDEACMode);
        if (iDEACMode.isDefaultMode()) {
            this.defaultDEACMode = iDEACMode;
        }
    }

    @Override
    public void registerDELogic(IDELogic iDELogic) {
        this.deLogicMap.put(iDELogic.getId(), iDELogic);
        this.deLogicMap.put(iDELogic.getName(), iDELogic);
    }

    @Override
    public void registerDEUIAction(IDEUIAction iDEUIAction) {
        this.deUIActionMap.put(iDEUIAction.getId(), iDEUIAction);
        this.deUIActionMap.put(iDEUIAction.getName(), iDEUIAction);
        if (iDEUIAction.isGlobalUIAction() && iDEUIAction instanceof IDEUIActionModel) {
            try {
                this.getSystemModel().registerDEUIActionModel((IDEUIActionModel)iDEUIAction);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format("\u6ce8\u518c\u7cfb\u7edf\u5168\u5c40\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u5bf9\u8c61\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            }
        }
    }

    @Override
    public void registerDEDataExport(IDEDataExport iDEDataExport) {
        this.deDataExportMap.put(iDEDataExport.getId(), iDEDataExport);
        this.deDataExportMap.put(iDEDataExport.getName(), iDEDataExport);
    }

    @Override
    public void registerDEDataImport(IDEDataImport iDEDataImport) {
        this.deDataImportMap.put(iDEDataImport.getId(), iDEDataImport);
        this.deDataImportMap.put(iDEDataImport.getName(), iDEDataImport);
        if (iDEDataImport.isDefault()) {
            this.defaultDEDataImport = iDEDataImport;
        }
    }

    @Override
    public void registerDEWF(IDEWF iDEWF) {
        this.deWFMap.put(iDEWF.getId(), iDEWF);
        this.deWFMap.put(iDEWF.getWorkflowId(), iDEWF);
        if (this.defaultDEWF == null) {
            this.defaultDEWF = iDEWF;
        }
        this.deWFList.add(iDEWF);
    }

    public void resetDEWFs() {
        this.deWFMap.clear();
        this.defaultDEWF = null;
        this.deWFList.clear();
    }

    @Override
    public void registerDEMainState(IDEMainState iDEMainState) {
        if (!StringHelper.isNullOrEmpty(iDEMainState.getId())) {
            this.deMainStateMap.put(iDEMainState.getId(), iDEMainState);
        }
        if (!StringHelper.isNullOrEmpty(iDEMainState.getMSTag())) {
            this.deMainStateMap.put(iDEMainState.getMSTag(), iDEMainState);
        }
        if (iDEMainState.isDefault()) {
            this.defaultDEMainState = iDEMainState;
        }
    }

    @Override
    public void registerDEUniState(IDEUniState iDEUniState) {
        if (!StringHelper.isNullOrEmpty(iDEUniState.getId())) {
            this.deUniStateMap.put(iDEUniState.getId(), iDEUniState);
        }
        if (iDEUniState.isDefault()) {
            this.defaultDEUniState = iDEUniState;
        }
    }

    @Override
    public IDEUniState getDEUniState(String strDEUniStateId) throws Exception {
        IDEUniState iDEUniState = this.deUniStateMap.get(strDEUniStateId);
        if (iDEUniState == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u7edf\u4e00\u72b6\u6001\u5bf9\u8c61[%1$s]", strDEUniStateId));
        }
        return iDEUniState;
    }

    @Override
    public Iterator<IDEUniState> getDEUniStates() {
        if (this.deUniStateMap.size() == 0) {
            return null;
        }
        return this.deUniStateMap.values().iterator();
    }

    @Override
    public IDEUniState getDefaultDEUniState() {
        return this.defaultDEUniState;
    }

    @Override
    public IDEDataSet getDEDataSet(String strName, boolean bTry) throws Exception {
        IDEDataSet iDEDataSet = this.deDataSetModelMap.get(strName);
        if (iDEDataSet == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6570\u636e\u96c6\u5408[%1$s]", strName));
        }
        return iDEDataSet;
    }

    @Override
    public ISystem getSystem() {
        return null;
    }

    @Override
    public IDEField getKeyDEField() {
        return this.keyDEField;
    }

    @Override
    public IDEField getUniTagDEField() {
        if (this.uniTagDEField != null) {
            return this.uniTagDEField;
        }
        if (this.getKeyDEField() != null && DataTypeHelper.isStringDataType(this.getKeyDEField().getStdDataType())) {
            return this.getKeyDEField();
        }
        return null;
    }

    @Override
    public IDEField getMajorDEField() {
        return this.majorDEField;
    }

    @Override
    public String getTableName() {
        return this.strTableName;
    }

    @Override
    public String getUserTable() {
        return null;
    }

    @Override
    public String getViewName() {
        return this.strViewName;
    }

    @Override
    public IDERBase getDER(boolean bMajor, String strDERId) throws Exception {
        return null;
    }

    @Override
    public Iterator<IDERBase> getDERs(boolean bMajor) {
        return ((ISystemModel)this.getSystem()).getDERs(this.getId(), bMajor);
    }

    @Override
    public IDEDataSet getDEDataSet(String strDEDataSetId) throws Exception {
        return this.getDEDataSet(strDEDataSetId, false);
    }

    @Override
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    public String getLogicName(String strLocalization) {
        return this.getLogicName();
    }

    @Override
    public IDEAction getDEAction(String strDEActionId) throws Exception {
        IDEAction iDEAction = this.deActionMap.get(strDEActionId);
        if (iDEAction == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c[%1$s]", strDEActionId));
        }
        return iDEAction;
    }

    @Override
    public IDEUIAction getDEUIAction(String strDEUIActionId) throws Exception {
        IDEUIAction iDEUIAction = this.deUIActionMap.get(strDEUIActionId);
        if (iDEUIAction == null && strDEUIActionId.indexOf("@") != -1) {
            String strNewId = strDEUIActionId.split("[@]")[0];
            iDEUIAction = this.deUIActionMap.get(strNewId);
        }
        if (iDEUIAction == null) {
            iDEUIAction = this.getSystemModel().getDEUIActionModel(strDEUIActionId, true);
        }
        if (iDEUIAction == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u754c\u9762\u884c\u4e3a[%1$s]", strDEUIActionId));
        }
        return iDEUIAction;
    }

    @Override
    public IDELogic getDELogic(String strDELogicId) throws Exception {
        IDELogic iDELogic = this.deLogicMap.get(strDELogicId);
        if (iDELogic == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u903b\u8f91[%1$s]", strDELogicId));
        }
        return iDELogic;
    }

    @Override
    public IDEWF getDEWF(String strDEWFId) throws Exception {
        IDEWF iDEWF = this.deWFMap.get(strDEWFId);
        if (iDEWF == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5de5\u4f5c\u6d41[%1$s]", strDEWFId));
        }
        return iDEWF;
    }

    @Override
    public IDataObject createDataObject() throws Exception {
        return this.createEntity();
    }

    @Override
    public IDEACMode getDEACMode(String strACModeName) throws Exception {
        IDEACMode iDEACMode = this.deACModeMap.get(strACModeName);
        if (iDEACMode == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u81ea\u586b\u6a21\u5f0f[%1$s]", strACModeName));
        }
        return iDEACMode;
    }

    @Override
    public IDEACMode getDefaultDEACMode() throws Exception {
        return this.defaultDEACMode;
    }

    @Override
    public IDEDataQuery getDEDataQuery(String strDEDataQueryId) throws Exception {
        IDEDataQuery iDEDataQuery = this.deDataQueryMap.get(strDEDataQueryId);
        if (iDEDataQuery == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u67e5\u8be2\u6a21\u578b[%1$s]", strDEDataQueryId));
        }
        return iDEDataQuery;
    }

    @Override
    public IDEDataImport getDEDataImport(String strDEDataImportId) throws Exception {
        IDEDataImport iDEDataImport = this.deDataImportMap.get(strDEDataImportId);
        if (iDEDataImport == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u6570\u636e\u5bfc\u5165[%1$s]", strDEDataImportId));
        }
        return iDEDataImport;
    }

    @Override
    public IDEDataExport getDEDataExport(String strDEDataExportId) throws Exception {
        IDEDataExport iDEDataExport = this.deDataExportMap.get(strDEDataExportId);
        if (iDEDataExport == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa[%1$s]", strDEDataExportId));
        }
        return iDEDataExport;
    }

    @Override
    public ISqlCommandModel getGetSqlCommandModel(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
        return this.getGetSqlCommandModel(iDBDialect, 0, bTempMode);
    }

    @Override
    public ISqlCommandModel getGetSqlCommandModel(IDBDialect iDBDialect, int nViewLevel, boolean bTempMode) throws Exception {
        if (this.isNoViewMode()) {
            throw new Exception("\u65e0\u89c6\u56fe\u6a21\u5f0f\u4e0d\u652f\u6301\u5f53\u524d\u64cd\u4f5c");
        }
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        SqlCommandModel sqlCommandModel = new SqlCommandModel();
        sqlCommandModel.setDataEntityModel(this);
        sqlCommandModel.setDBDialect(iDBDialect);
        StringBuilderEx sql = new StringBuilderEx();
        ProcParamList procParamList = new ProcParamList();
        if (this.getKeyDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null || bTempMode) {
            if (bTempMode) {
                sql.append("SELECT m1.* FROM %1$s m1 WHERE m1.%2$s = ? ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getViewName()) + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
            } else {
                sql.append("SELECT m1.* FROM %1$s m1 WHERE m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
                if (this.isLogicValid()) {
                    Object objInvalidValue = this.getLogicValidValue(true);
                    String strInvalidValue = "";
                    strInvalidValue = objInvalidValue instanceof String ? StringHelper.format("'%1$s'", objInvalidValue) : StringHelper.format("%1$s", objInvalidValue);
                    sql.append(" AND m1.%1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getName()), strInvalidValue);
                }
            }
            ProcParam procParam = new ProcParam();
            procParam.setDataType(this.getKeyDEField().getStdDataType());
            procParam.setParamName(StringHelper.format("VAR_%1$s", this.getKeyDEField().getName().toUpperCase()));
            procParamList.add(procParam);
        } else {
            sql.append("SELECT m1.* FROM %1$s m1  ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)));
            boolean bFirst = true;
            Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
            while (deFields.hasNext()) {
                IDEField iDEField = deFields.next();
                if (bFirst) {
                    sql.append(" WHERE ");
                    bFirst = false;
                } else {
                    sql.append(" AND ");
                }
                sql.append("m1.%1$s = ? ", iDBDialect.getDBObjStandardName(iDEField.getName()));
                ProcParam procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                procParamList.add(procParam);
            }
            if (this.isLogicValid()) {
                Object objInvalidValue = this.getLogicValidValue(true);
                String strInvalidValue = "";
                strInvalidValue = objInvalidValue instanceof String ? StringHelper.format("'%1$s'", objInvalidValue) : StringHelper.format("%1$s", objInvalidValue);
                sql.append(" AND m1.%1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getName()), strInvalidValue);
            }
        }
        sqlCommandModel.setSql(sql.toString());
        sqlCommandModel.setProcParamList(procParamList);
        return sqlCommandModel;
    }

    @Override
    public ISqlCommandModel getGetSqlCommandModel2(IDBDialect iDBDialect, int nViewLevel, boolean bTempMode) throws Exception {
        if (this.isNoViewMode()) {
            throw new Exception("\u65e0\u89c6\u56fe\u6a21\u5f0f\u4e0d\u652f\u6301\u5f53\u524d\u64cd\u4f5c");
        }
        if (this.getUniTagDEField() == null) {
            throw new Exception("\u5f53\u524d\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u552f\u4e00\u4e1a\u52a1\u6807\u8bc6\u5c5e\u6027");
        }
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        SqlCommandModel sqlCommandModel = new SqlCommandModel();
        sqlCommandModel.setDataEntityModel(this);
        sqlCommandModel.setDBDialect(iDBDialect);
        StringBuilderEx sql = new StringBuilderEx();
        ProcParamList procParamList = new ProcParamList();
        if (this.getUniTagDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null || bTempMode) {
            if (bTempMode) {
                sql.append("SELECT m1.* FROM %1$s m1 WHERE m1.%2$s = ? ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getViewName()) + "_TMP"), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getName()));
            } else {
                sql.append("SELECT m1.* FROM %1$s m1 WHERE m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getName()));
                if (this.isLogicValid()) {
                    Object objInvalidValue = this.getLogicValidValue(true);
                    String strInvalidValue = "";
                    strInvalidValue = objInvalidValue instanceof String ? StringHelper.format("'%1$s'", objInvalidValue) : StringHelper.format("%1$s", objInvalidValue);
                    sql.append(" AND m1.%1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getName()), strInvalidValue);
                }
            }
            ProcParam procParam = new ProcParam();
            procParam.setDataType(this.getUniTagDEField().getStdDataType());
            procParam.setParamName(StringHelper.format("VAR_%1$s", this.getUniTagDEField().getName().toUpperCase()));
            procParamList.add(procParam);
        } else {
            sql.append("SELECT m1.* FROM %1$s m1  ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)));
            boolean bFirst = true;
            Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
            while (deFields.hasNext()) {
                IDEField iDEField = deFields.next();
                if (bFirst) {
                    sql.append(" WHERE ");
                    bFirst = false;
                } else {
                    sql.append(" AND ");
                }
                sql.append("m1.%1$s = ? ", iDBDialect.getDBObjStandardName(iDEField.getName()));
                ProcParam procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                procParamList.add(procParam);
            }
            if (this.isLogicValid()) {
                Object objInvalidValue = this.getLogicValidValue(true);
                String strInvalidValue = "";
                strInvalidValue = objInvalidValue instanceof String ? StringHelper.format("'%1$s'", objInvalidValue) : StringHelper.format("%1$s", objInvalidValue);
                sql.append(" AND m1.%1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getName()), strInvalidValue);
            }
        }
        sqlCommandModel.setSql(sql.toString());
        sqlCommandModel.setProcParamList(procParamList);
        return sqlCommandModel;
    }

    @Override
    public ISqlCommandModel getCheckKeySqlCommandModel(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        SqlCommandModel sqlCommandModel = new SqlCommandModel();
        sqlCommandModel.setDataEntityModel(this);
        sqlCommandModel.setDBDialect(iDBDialect);
        StringBuilderEx sql = new StringBuilderEx();
        ProcParamList procParamList = new ProcParamList();
        if (this.getKeyDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null) {
            if (bTempMode) {
                sql.append("select m1.%2$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getTableName()) + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
            } else {
                sql.append("select m1.%2$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
            }
            ProcParam procParam = new ProcParam();
            procParam.setDataType(this.getKeyDEField().getStdDataType());
            procParam.setParamName(StringHelper.format("VAR_%1$s", this.getKeyDEField().getName().toUpperCase()));
            procParamList.add(procParam);
        } else {
            if (bTempMode) {
                sql.append("select m1.%2$s from %1$s m1 ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getViewName()) + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
            } else {
                sql.append("select m1.%2$s from %1$s m1 ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
            }
            boolean bFirst = true;
            Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
            while (deFields.hasNext()) {
                IDEField iDEField = deFields.next();
                if (bFirst) {
                    sql.append(" where ");
                    bFirst = false;
                } else {
                    sql.append(" and ");
                }
                sql.append("m1.%1$s = ? ", iDBDialect.getDBObjStandardName(iDEField.getName()));
                ProcParam procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                procParamList.add(procParam);
            }
        }
        sqlCommandModel.setSql(sql.toString());
        sqlCommandModel.setProcParamList(procParamList);
        return sqlCommandModel;
    }

    @Override
    public ISqlCommandModel getCheckKeySqlCommandModel2(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        if (this.getUniTagDEField() == null) {
            throw new Exception("\u5f53\u524d\u5b9e\u4f53\u6ca1\u6709\u5b9a\u4e49\u552f\u4e00\u4e1a\u52a1\u6807\u8bc6\u5c5e\u6027");
        }
        SqlCommandModel sqlCommandModel = new SqlCommandModel();
        sqlCommandModel.setDataEntityModel(this);
        sqlCommandModel.setDBDialect(iDBDialect);
        StringBuilderEx sql = new StringBuilderEx();
        ProcParamList procParamList = new ProcParamList();
        if (this.getUniTagDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null) {
            if (this.getKeyDEField().isPhisicalDEField()) {
                if (bTempMode) {
                    sql.append("select m1.%3$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getTableName()) + "_TMP"), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                } else {
                    sql.append("select m1.%3$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
            } else if (bTempMode) {
                sql.append("select m1.%3$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getViewName()) + "_TMP"), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
            } else {
                sql.append("select m1.%3$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName()), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
            }
            ProcParam procParam = new ProcParam();
            procParam.setDataType(this.getUniTagDEField().getStdDataType());
            procParam.setParamName(StringHelper.format("VAR_%1$s", this.getUniTagDEField().getName().toUpperCase()));
            procParamList.add(procParam);
        } else {
            if (bTempMode) {
                sql.append("select m1.%2$s from %1$s m1 ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getViewName()) + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
            } else {
                sql.append("select m1.%2$s from %1$s m1 ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
            }
            boolean bFirst = true;
            Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
            while (deFields.hasNext()) {
                IDEField iDEField = deFields.next();
                if (bFirst) {
                    sql.append(" where ");
                    bFirst = false;
                } else {
                    sql.append(" and ");
                }
                sql.append("m1.%1$s = ? ", iDBDialect.getDBObjStandardName(iDEField.getName()));
                ProcParam procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                procParamList.add(procParam);
            }
        }
        sqlCommandModel.setSql(sql.toString());
        sqlCommandModel.setProcParamList(procParamList);
        return sqlCommandModel;
    }

    @Override
    public ISqlCommandModel getCreateSqlCommandModel(IDBDialect iDBDialect, IEntity iEntity, boolean bTempMode) throws Exception {
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        SqlCommandModel createCommandModel = new SqlCommandModel();
        createCommandModel.setDataEntityModel(this);
        createCommandModel.setDBDialect(iDBDialect);
        HashMap<String, Object> insertFieldMap = new HashMap<String, Object>();
        if (bTempMode) {
            ProcParam procParam = new ProcParam();
            procParam.setDataType(this.getKeyDEField().getStdDataType());
            procParam.setParamName(StringHelper.format("VAR_%1$s", "SRFORIKEY"));
            insertFieldMap.put("SRFORIKEY", procParam);
            procParam = new ProcParam();
            procParam.setDataType(9);
            procParam.setParamName("SRF_DRAFTFLAG");
            procParam.setValue(1);
            insertFieldMap.put("SRFDRAFTFLAG", procParam);
        }
        Iterator<IDEField> deFields = this.getDEFields();
        while (deFields.hasNext()) {
            ProcParam procParam;
            IDEField iDEField = deFields.next();
            if (iDEField.isDynaStorageDEField() || !iDEField.isPhisicalDEField() || iDEField.isInheritDEField() || iDEField.isFormulaDEField() || bTempMode && !iDEField.isEnableTempData()) continue;
            if (StringHelper.isNullOrEmpty(iDEField.getPreDefinedType()) || bTempMode) {
                String strDirectCode;
                if (iDEField.isEnableDBValueInsertUpdateMode() && !StringHelper.isNullOrEmpty(iDEField.getDBValueInsertMode()) && StringHelper.compare(iDEField.getDBValueInsertMode(), "IGNORE", true) == 0) continue;
                if (iEntity != null) {
                    if (iEntity.contains(iDEField.getName())) {
                        if (iDEField.isKeyDEField() && !bTempMode && iEntity.get(iDEField.getName()) == null) {
                            strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, true, bTempMode);
                            if (StringHelper.isNullOrEmpty(strDirectCode)) continue;
                            insertFieldMap.put(iDEField.getName(), strDirectCode);
                            continue;
                        }
                        procParam = new ProcParam();
                        procParam.setDataType(iDEField.getStdDataType());
                        procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                        insertFieldMap.put(iDEField.getName(), procParam);
                        continue;
                    }
                    strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, true, bTempMode);
                    if (StringHelper.isNullOrEmpty(strDirectCode)) continue;
                    insertFieldMap.put(iDEField.getName(), strDirectCode);
                    continue;
                }
                strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, true, bTempMode);
                if (!StringHelper.isNullOrEmpty(strDirectCode)) {
                    insertFieldMap.put(iDEField.getName(), strDirectCode);
                    continue;
                }
                if (strDirectCode != null) continue;
                ProcParam procParam2 = new ProcParam();
                procParam2.setDataType(iDEField.getStdDataType());
                procParam2.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                insertFieldMap.put(iDEField.getName(), procParam2);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "CREATEDATE", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEDATE", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_CURTIME");
                insertFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "CREATEMAN", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEMAN", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                if (SysModelGlobal.isUseLoginNameAsOperator()) {
                    procParam.setParamName("SRF_LOGINNAME");
                } else {
                    procParam.setParamName("SRF_PERSONID");
                }
                insertFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "CREATEMANNAME", true) == 0 || StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEMANNAME", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_PERSONNAME");
                insertFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "LOGICVALID", true) == 0) {
                Object objValidValue = this.getLogicValidValue(true);
                String strValidValue = "";
                strValidValue = objValidValue instanceof String ? StringHelper.format("'%1$s'", objValidValue) : StringHelper.format("%1$s", objValidValue);
                insertFieldMap.put(iDEField.getName(), strValidValue);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "ORGID", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_ORGID");
                insertFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "ORGNAME", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_ORGNAME");
                insertFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "ORGSECTORID", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_ORGSECTORID");
                insertFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "ORGSECTORNAME", true) != 0) continue;
            procParam = new ProcParam();
            procParam.setDataType(iDEField.getStdDataType());
            procParam.setParamName("SRF_ORGSECTORNAME");
            insertFieldMap.put(iDEField.getName(), procParam);
        }
        if (this.isLogicValid() && bTempMode) {
            Object objValidValue = this.getLogicValidValue(true);
            String strValidValue = "";
            strValidValue = objValidValue instanceof String ? StringHelper.format("'%1$s'", objValidValue) : StringHelper.format("%1$s", objValidValue);
            insertFieldMap.put(this.getLogicValidDEField().getName(), strValidValue);
        }
        ProcParamList procParamList = new ProcParamList();
        StringBuilderEx sql = new StringBuilderEx();
        if (bTempMode) {
            sql.append("INSERT INTO %1$s (", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getTableName()) + "_TMP"));
        } else {
            sql.append("INSERT INTO %1$s (", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()));
        }
        boolean bFirst = true;
        if (iDBDialect.getDBType().indexOf("ORACLE") == 0) {
            Object objValue;
            IDEField iDEField;
            HashMap insertFieldNormalMap = new HashMap();
            HashMap insertFieldClobMap = new HashMap();
            for (String strField : insertFieldMap.keySet()) {
                iDEField = this.getDEField(strField, true);
                if (iDEField == null || !DataTypeHelper.isLongStringType(iDEField.getStdDataType())) {
                    insertFieldNormalMap.put(strField, insertFieldMap.get(strField));
                    continue;
                }
                insertFieldClobMap.put(strField, insertFieldMap.get(strField));
            }
            for (String strField : insertFieldNormalMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                    continue;
                }
                sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
            }
            for (String strField : insertFieldClobMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                    continue;
                }
                sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
            }
            sql.append(")VALUES(");
            bFirst = true;
            for (String strField : insertFieldNormalMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                objValue = insertFieldNormalMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append("?");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
            for (String strField : insertFieldClobMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                objValue = insertFieldClobMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append("?");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
        } else {
            for (String strField : insertFieldMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                IDEField iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                    continue;
                }
                sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
            }
            sql.append(")VALUES(");
            bFirst = true;
            for (String strField : insertFieldMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                Object objValue = insertFieldMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append("?");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
        }
        sql.append(")");
        createCommandModel.setSql(sql.toString());
        createCommandModel.setProcParamList(procParamList);
        return createCommandModel;
    }

    @Override
    public ISqlCommandModel getCreateSqlCommandModel(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
        return this.getCreateSqlCommandModel(iDBDialect, null, bTempMode);
    }

    @Override
    public ISqlCommandModel getUpdateSqlCommandModel(IDBDialect iDBDialect, IEntity iEntity, boolean bTempMode) throws Exception {
        String strValidValue;
        Object objValidValue;
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        SqlCommandModel updateCommandModel = new SqlCommandModel();
        updateCommandModel.setDataEntityModel(this);
        updateCommandModel.setDBDialect(iDBDialect);
        HashMap<String, Object> updateFieldMap = new HashMap<String, Object>();
        if (bTempMode) {
            ProcParam procParam;
            if (iEntity.contains("SRFORIKEY")) {
                if (iEntity.get("SRFORIKEY") == null) {
                    updateFieldMap.put("SRFORIKEY", "NULL");
                } else {
                    procParam = new ProcParam();
                    procParam.setDataType(this.getKeyDEField().getStdDataType());
                    procParam.setParamName(StringHelper.format("VAR_%1$s", "SRFORIKEY"));
                    updateFieldMap.put("SRFORIKEY", procParam);
                }
            }
            procParam = new ProcParam();
            procParam.setDataType(9);
            procParam.setParamName("SRF_DRAFTFLAG");
            procParam.setValue(0);
            updateFieldMap.put("SRFDRAFTFLAG", procParam);
        }
        Iterator<IDEField> deFields = this.getDEFields();
        while (deFields.hasNext()) {
            ProcParam procParam;
            IDEField iDEField = deFields.next();
            if (iDEField.isKeyDEField() || !this.getKeyDEField().isPhisicalDEField() && !StringHelper.isNullOrEmpty(iDEField.getUnionKeyValue()) || iDEField.isDynaStorageDEField() || !iDEField.isPhisicalDEField() || iDEField.isInheritDEField() || iDEField.isFormulaDEField() || bTempMode && !iDEField.isEnableTempData()) continue;
            if (StringHelper.isNullOrEmpty(iDEField.getPreDefinedType())) {
                if (iDEField.isEnableDBValueInsertUpdateMode() && !StringHelper.isNullOrEmpty(iDEField.getDBValueUpdateMode()) && StringHelper.compare(iDEField.getDBValueUpdateMode(), "IGNORE", true) == 0) continue;
                if (iEntity.contains(iDEField.getName())) {
                    if (iEntity.get(iDEField.getName()) == null) {
                        updateFieldMap.put(iDEField.getName(), "NULL");
                        continue;
                    }
                    procParam = new ProcParam();
                    procParam.setDataType(iDEField.getStdDataType());
                    procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                    updateFieldMap.put(iDEField.getName(), procParam);
                    continue;
                }
                String strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, false, bTempMode);
                if (StringHelper.isNullOrEmpty(strDirectCode)) continue;
                updateFieldMap.put(iDEField.getName(), strDirectCode);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEDATE", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_CURTIME");
                updateFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEMAN", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                if (SysModelGlobal.isUseLoginNameAsOperator()) {
                    procParam.setParamName("SRF_LOGINNAME");
                } else {
                    procParam.setParamName("SRF_PERSONID");
                }
                updateFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "UPDATEMANNAME", true) == 0) {
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_PERSONNAME");
                updateFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "ORGID", true) == 0) {
                if (iEntity.get("SRF_ORGID") == null && iEntity.get(iDEField.getName()) == null) continue;
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_ORGID");
                updateFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "ORGNAME", true) == 0) {
                if (iEntity.get("SRF_ORGNAME") == null && iEntity.get(iDEField.getName()) == null) continue;
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_ORGNAME");
                updateFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "ORGSECTORID", true) == 0) {
                if (iEntity.get("SRF_ORGSECTORID") == null && iEntity.get(iDEField.getName()) == null) continue;
                procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName("SRF_ORGSECTORID");
                updateFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            if (StringHelper.compare(iDEField.getPreDefinedType(), "ORGSECTORNAME", true) != 0 || iEntity.get("SRF_ORGSECTORNAME") == null && iEntity.get(iDEField.getName()) == null) continue;
            procParam = new ProcParam();
            procParam.setDataType(iDEField.getStdDataType());
            procParam.setParamName("SRF_ORGSECTORNAME");
            updateFieldMap.put(iDEField.getName(), procParam);
        }
        ProcParamList procParamList = new ProcParamList();
        StringBuilderEx sql = new StringBuilderEx();
        if (!bTempMode) {
            sql.append("UPDATE %1$s SET ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()));
        } else {
            sql.append("UPDATE %1$s SET ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getTableName()) + "_TMP"));
        }
        boolean bFirst = true;
        if (iDBDialect.getDBType().indexOf("ORACLE") == 0) {
            Object objValue;
            IDEField iDEField;
            HashMap updateFieldNormalMap = new HashMap();
            HashMap updateFieldClobMap = new HashMap();
            for (String strField : updateFieldMap.keySet()) {
                iDEField = this.getDEField(strField, true);
                if (iDEField == null || !DataTypeHelper.isLongStringType(iDEField.getStdDataType())) {
                    updateFieldNormalMap.put(strField, updateFieldMap.get(strField));
                    continue;
                }
                updateFieldClobMap.put(strField, updateFieldMap.get(strField));
            }
            for (String strField : updateFieldNormalMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                } else {
                    sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
                sql.append(" = ");
                objValue = updateFieldNormalMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append(" ? ");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
            for (String strField : updateFieldClobMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                } else {
                    sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
                sql.append(" = ");
                objValue = updateFieldClobMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append(" ? ");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
        } else {
            for (String strField : updateFieldMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                IDEField iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                } else {
                    sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
                sql.append(" = ");
                Object objValue = updateFieldMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append(" ? ");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
        }
        if (this.getKeyDEField().isPhisicalDEField() || this.getUniTagDEField() != null && this.getUniTagDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null) {
            ProcParam procParam;
            if ((!this.getKeyDEField().isPhisicalDEField() || iEntity.get(this.getKeyDEField().getName()) == null) && this.getUniTagDEField() != null && this.getUniTagDEField().isPhisicalDEField() && iEntity.get(this.getUniTagDEField().getName()) != null) {
                if (this.isLogicValid() && !bTempMode) {
                    objValidValue = this.getLogicValidValue(true);
                    strValidValue = "";
                    strValidValue = objValidValue instanceof String ? StringHelper.format("'%1$s'", objValidValue) : StringHelper.format("%1$s", objValidValue);
                    sql.append(" WHERE %1$s = ? AND %2$s=%3$s ", iDBDialect.getDBObjStandardName(this.getUniTagDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
                } else {
                    sql.append(" WHERE %1$s = ? ", iDBDialect.getDBObjStandardName(this.getUniTagDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
                procParam = new ProcParam();
                procParam.setDataType(this.getUniTagDEField().getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", this.getUniTagDEField().getName().toUpperCase()));
                procParamList.add(procParam);
            } else {
                if (this.isLogicValid() && !bTempMode) {
                    objValidValue = this.getLogicValidValue(true);
                    strValidValue = "";
                    strValidValue = objValidValue instanceof String ? StringHelper.format("'%1$s'", objValidValue) : StringHelper.format("%1$s", objValidValue);
                    sql.append(" WHERE %1$s = ? AND %2$s=%3$s ", iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
                } else {
                    sql.append(" WHERE %1$s = ? ", iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
                procParam = new ProcParam();
                procParam.setDataType(this.getKeyDEField().getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", this.getKeyDEField().getName().toUpperCase()));
                procParamList.add(procParam);
            }
        } else {
            bFirst = true;
            deFields = this.getUnionKeyValueDEFields();
            while (deFields.hasNext()) {
                IDEField iDEField = deFields.next();
                if (bFirst) {
                    sql.append(" WHERE ");
                    bFirst = false;
                } else {
                    sql.append(" AND ");
                }
                sql.append("%1$s = ? ", iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                ProcParam procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                procParamList.add(procParam);
            }
            if (this.isLogicValid() && !bTempMode) {
                objValidValue = this.getLogicValidValue(true);
                strValidValue = "";
                strValidValue = objValidValue instanceof String ? StringHelper.format("'%1$s'", objValidValue) : StringHelper.format("%1$s", objValidValue);
                sql.append(" AND %1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
            }
        }
        updateCommandModel.setSql(sql.toString());
        updateCommandModel.setProcParamList(procParamList);
        return updateCommandModel;
    }

    @Override
    public ISqlCommandModel getSysUpdateSqlCommandModel(IDBDialect iDBDialect, IEntity iEntity, boolean bTempMode) throws Exception {
        String strValidValue;
        Object objValidValue;
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        SqlCommandModel updateCommandModel = new SqlCommandModel();
        updateCommandModel.setDataEntityModel(this);
        updateCommandModel.setDBDialect(iDBDialect);
        HashMap<String, Object> updateFieldMap = new HashMap<String, Object>();
        if (bTempMode) {
            ProcParam procParam;
            if (iEntity.contains("SRFORIKEY")) {
                if (iEntity.get("SRFORIKEY") == null) {
                    updateFieldMap.put("SRFORIKEY", "NULL");
                } else {
                    procParam = new ProcParam();
                    procParam.setDataType(this.getKeyDEField().getStdDataType());
                    procParam.setParamName(StringHelper.format("VAR_%1$s", "SRFORIKEY"));
                    updateFieldMap.put("SRFORIKEY", procParam);
                }
            }
            procParam = new ProcParam();
            procParam.setDataType(9);
            procParam.setParamName("SRF_DRAFTFLAG");
            procParam.setValue(0);
            updateFieldMap.put("SRFDRAFTFLAG", procParam);
        }
        Iterator<IDEField> deFields = this.getDEFields();
        while (deFields.hasNext()) {
            IDEField iDEField = deFields.next();
            if (iDEField.isKeyDEField() || !this.getKeyDEField().isPhisicalDEField() && !StringHelper.isNullOrEmpty(iDEField.getUnionKeyValue()) || !iDEField.isPhisicalDEField() || iDEField.isInheritDEField() || iDEField.isFormulaDEField() || bTempMode && !iDEField.isEnableTempData() || !StringHelper.isNullOrEmpty(iDEField.getPreDefinedType())) continue;
            if (iEntity.contains(iDEField.getName())) {
                if (iEntity.get(iDEField.getName()) == null) {
                    updateFieldMap.put(iDEField.getName(), "NULL");
                    continue;
                }
                ProcParam procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                updateFieldMap.put(iDEField.getName(), procParam);
                continue;
            }
            String strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, false, bTempMode);
            if (StringHelper.isNullOrEmpty(strDirectCode)) continue;
            updateFieldMap.put(iDEField.getName(), strDirectCode);
        }
        ProcParamList procParamList = new ProcParamList();
        StringBuilderEx sql = new StringBuilderEx();
        if (!bTempMode) {
            sql.append("UPDATE %1$s SET ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()));
        } else {
            sql.append("UPDATE %1$s SET ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getTableName()) + "_TMP"));
        }
        boolean bFirst = true;
        if (iDBDialect.getDBType().indexOf("ORACLE") == 0) {
            Object objValue;
            IDEField iDEField;
            HashMap updateFieldNormalMap = new HashMap();
            HashMap updateFieldClobMap = new HashMap();
            for (String strField : updateFieldMap.keySet()) {
                iDEField = this.getDEField(strField, true);
                if (iDEField == null || !DataTypeHelper.isLongStringType(iDEField.getStdDataType())) {
                    updateFieldNormalMap.put(strField, updateFieldMap.get(strField));
                    continue;
                }
                updateFieldClobMap.put(strField, updateFieldMap.get(strField));
            }
            for (String strField : updateFieldNormalMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                } else {
                    sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
                sql.append(" = ");
                objValue = updateFieldNormalMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append(" ? ");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
            for (String strField : updateFieldClobMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                } else {
                    sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
                sql.append(" = ");
                objValue = updateFieldClobMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append(" ? ");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
        } else {
            for (String strField : updateFieldMap.keySet()) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sql.append(",");
                }
                IDEField iDEField = this.getDEField(strField, true);
                if (iDEField == null) {
                    sql.append(iDBDialect.getDBObjStandardName(strField));
                } else {
                    sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                }
                sql.append(" = ");
                Object objValue = updateFieldMap.get(strField);
                if (objValue instanceof ProcParam) {
                    sql.append(" ? ");
                    procParamList.add((ProcParam)objValue);
                    continue;
                }
                sql.append((String)objValue);
            }
        }
        if (this.getKeyDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null) {
            if (this.isLogicValid() && !bTempMode) {
                objValidValue = this.getLogicValidValue(true);
                strValidValue = "";
                strValidValue = objValidValue instanceof String ? StringHelper.format("'%1$s'", objValidValue) : StringHelper.format("%1$s", objValidValue);
                sql.append(" WHERE %1$s = ? AND %2$s=%3$s ", iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
            } else {
                sql.append(" WHERE %1$s = ? ", iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
            }
            ProcParam procParam = new ProcParam();
            procParam.setDataType(this.getKeyDEField().getStdDataType());
            procParam.setParamName(StringHelper.format("VAR_%1$s", this.getKeyDEField().getName().toUpperCase()));
            procParamList.add(procParam);
        } else {
            bFirst = true;
            deFields = this.getUnionKeyValueDEFields();
            while (deFields.hasNext()) {
                IDEField iDEField = deFields.next();
                if (bFirst) {
                    sql.append(" WHERE ");
                    bFirst = false;
                } else {
                    sql.append(" AND ");
                }
                sql.append("%1$s = ? ", iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                ProcParam procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                procParamList.add(procParam);
            }
            if (this.isLogicValid() && !bTempMode) {
                objValidValue = this.getLogicValidValue(true);
                strValidValue = "";
                strValidValue = objValidValue instanceof String ? StringHelper.format("'%1$s'", objValidValue) : StringHelper.format("%1$s", objValidValue);
                sql.append(" AND %1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
            }
        }
        updateCommandModel.setSql(sql.toString());
        updateCommandModel.setProcParamList(procParamList);
        return updateCommandModel;
    }

    @Override
    public ISqlCommandModel getRemoveSqlCommandModel(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        SqlCommandModel sqlCommandModel = new SqlCommandModel();
        sqlCommandModel.setDataEntityModel(this);
        sqlCommandModel.setDBDialect(iDBDialect);
        StringBuilderEx sql = new StringBuilderEx();
        ProcParamList procParamList = new ProcParamList();
        if (this.getKeyDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null || bTempMode) {
            if (bTempMode) {
                sql.append("DELETE FROM %1$s WHERE %2$s = ? ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getTableName()) + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
            } else if (this.isLogicValid()) {
                Object objInvalidValue = this.getLogicValidValue(false);
                String strInvalidValue = "";
                strInvalidValue = objInvalidValue instanceof String ? StringHelper.format("'%1$s'", objInvalidValue) : StringHelper.format("%1$s", objInvalidValue);
                sql.append("UPDATE %1$s SET %3$s=%4$s WHERE %2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strInvalidValue);
            } else {
                sql.append("DELETE FROM %1$s WHERE %2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
            }
            ProcParam procParam = new ProcParam();
            procParam.setDataType(this.getKeyDEField().getStdDataType());
            procParam.setParamName(StringHelper.format("VAR_%1$s", this.getKeyDEField().getName().toUpperCase()));
            procParamList.add(procParam);
        } else {
            if (this.isLogicValid()) {
                Object objInvalidValue = this.getLogicValidValue(false);
                String strInvalidValue = "";
                strInvalidValue = objInvalidValue instanceof String ? StringHelper.format("'%1$s'", objInvalidValue) : StringHelper.format("%1$s", objInvalidValue);
                sql.append("UPDATE %1$s SET %2$s=%3$s  ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strInvalidValue);
            } else {
                sql.append("DELETE FROM %1$s ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()));
            }
            boolean bFirst = true;
            Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
            while (deFields.hasNext()) {
                IDEField iDEField = deFields.next();
                if (bFirst) {
                    sql.append(" WHERE ");
                    bFirst = false;
                } else {
                    sql.append(" AND ");
                }
                sql.append("%1$s = ? ", iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
                ProcParam procParam = new ProcParam();
                procParam.setDataType(iDEField.getStdDataType());
                procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
                procParamList.add(procParam);
            }
        }
        sqlCommandModel.setSql(sql.toString());
        sqlCommandModel.setProcParamList(procParamList);
        return sqlCommandModel;
    }

    @Override
    public ISqlCommandModel getSelectSqlCommandModelEx(IDBDialect iDBDialect, ISelectContext iSelectContext, boolean bTempMode) throws Exception {
        return this.getSelectSqlCommandModel(iDBDialect, iSelectContext, bTempMode);
    }

    @Override
    public ISqlCommandModel getSelectSqlCommandModel(IDBDialect iDBDialect, ISelectCond iSelectCond, boolean bTempMode) throws Exception {
        IDEDataQueryCodeCond iDEDataQueryCodeCond;
        String strCode;
        if (this.isNoViewMode()) {
            throw new Exception("\u65e0\u89c6\u56fe\u6a21\u5f0f\u4e0d\u652f\u6301\u5f53\u524d\u64cd\u4f5c");
        }
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        IDEDBConfig iDEDBConfig = this.getDEDBConfig(iDBDialect.getDBType());
        if (iDEDBConfig == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u914d\u7f6e[%2$s]", this.getName(), iDBDialect.getDBType()));
        }
        SqlCommandModel sqlCommandModel = new SqlCommandModel();
        sqlCommandModel.setDataEntityModel(this);
        sqlCommandModel.setDBDialect(iDBDialect);
        StringBuilderEx sql = new StringBuilderEx();
        ISelectContext iSelectContext = null;
        Iterator<ISelectField> selectFields = null;
        int nViewLevel = 0;
        if (iSelectCond instanceof ISelectContext) {
            iSelectContext = (ISelectContext)iSelectCond;
            selectFields = iSelectContext.getSelectFields();
            nViewLevel = iSelectContext.getViewLevel();
        }
        if (selectFields == null) {
            if (bTempMode) {
                sql.append("SELECT m1.* FROM %1$s m1  ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getViewName()) + "_TMP"));
            } else {
                sql.append("SELECT m1.* FROM %1$s m1  ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)));
            }
        } else {
            sql.append("SELECT ");
            int nIndex = 0;
            while (selectFields.hasNext()) {
                if (nIndex != 0) {
                    sql.append(",");
                }
                ++nIndex;
                ISelectField iSelectField = selectFields.next();
                String strAlias = iSelectField.getAlias();
                if (StringHelper.isNullOrEmpty(iSelectField.getFunc())) {
                    if (StringHelper.isNullOrEmpty(iSelectField.getName())) {
                        throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b57\u6bb5\u540d\u79f0");
                    }
                    if (StringHelper.isNullOrEmpty(strAlias)) {
                        sql.append("%1$s", iDBDialect.getDBObjStandardName(iSelectField.getName()));
                        continue;
                    }
                    sql.append("%1$s AS %2$s", iDBDialect.getDBObjStandardName(iSelectField.getName()), iDBDialect.getDBObjStandardName(strAlias));
                    continue;
                }
                String[] fields = null;
                if (!StringHelper.isNullOrEmpty(iSelectField.getName())) {
                    fields = iSelectField.getName().split("[,]");
                }
                if (StringHelper.isNullOrEmpty(strAlias)) {
                    strAlias = fields != null && fields.length > 0 ? fields[0] : StringHelper.format("A%1$s", strAlias);
                }
                sql.append("%1$s AS %2$s", iDBDialect.getFuncSQL(iSelectField.getFunc(), fields), iDBDialect.getDBObjStandardName(strAlias));
            }
            if (bTempMode) {
                sql.append(" FROM %1$s m1  ", iDBDialect.getDBObjStandardName(String.valueOf(iDEDBConfig.getViewName()) + "_TMP"));
            } else {
                sql.append(" FROM %1$s m1 ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)));
            }
        }
        ProcParamList procParamList = new ProcParamList();
        boolean bFirstCond = true;
        if (bTempMode) {
            bFirstCond = false;
            sql.append(" WHERE m1.SRFDRAFTFLAG=0 ");
        } else if (this.isLogicValid()) {
            Object objInvalidValue = this.getLogicValidValue(true);
            String strInvalidValue = "";
            strInvalidValue = objInvalidValue instanceof String ? StringHelper.format("'%1$s'", objInvalidValue) : StringHelper.format("%1$s", objInvalidValue);
            sql.append(" WHERE m1.%1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getName()), strInvalidValue);
            bFirstCond = false;
        }
        HashMap<String, Object> paramMap = new HashMap<String, Object>();
        iSelectCond.fillMap(paramMap);
        for (String strFieldName : paramMap.keySet()) {
            IDEField iDEField = this.getDEField(strFieldName, true);
            if (iDEField == null) continue;
            if (bFirstCond) {
                bFirstCond = false;
                sql.append(" WHERE ");
            } else {
                sql.append("AND ");
            }
            Object objValue = paramMap.get(strFieldName);
            if (objValue == SelectCond.ISNOTNULL) {
                sql.append(" %1$s IS NOT NULL ", iDBDialect.getDBObjStandardName(iDEField.getName()));
                continue;
            }
            if (objValue == SelectCond.ISNULL) {
                sql.append(" %1$s IS NULL ", iDBDialect.getDBObjStandardName(iDEField.getName()));
                continue;
            }
            ProcParam procParam = new ProcParam();
            procParam.setDataType(iDEField.getStdDataType());
            procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
            procParamList.add(procParam);
            sql.append(" %1$s = ? ", iDBDialect.getDBObjStandardName(iDEField.getName()));
        }
        if (iSelectContext != null && iSelectContext.getSelectFilter() != null && iSelectContext.getSelectFilter() instanceof IDEDataQueryCodeCond && !StringHelper.isNullOrEmpty(strCode = this.getSelectConditionSql(iDEDataQueryCodeCond = (IDEDataQueryCodeCond)iSelectContext.getSelectFilter(), iDBDialect, procParamList))) {
            if (bFirstCond) {
                bFirstCond = false;
                sql.append(" WHERE %1$s", strCode);
            } else {
                sql.append("AND (%1$s)", strCode);
            }
        }
        if (!StringHelper.isNullOrEmpty(iSelectCond.getOrderInfo())) {
            sql.append(" ");
            sql.append(iSelectCond.getOrderInfo());
        }
        sqlCommandModel.setSql(sql.toString());
        sqlCommandModel.setProcParamList(procParamList);
        return sqlCommandModel;
    }

    @Override
    public ISqlCommandModel getMergeSqlCommandModel(IDBDialect iDBDialect) throws Exception {
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        SqlCommandModel mergeCommandModel = new SqlCommandModel();
        mergeCommandModel.setDataEntityModel(this);
        mergeCommandModel.setDBDialect(iDBDialect);
        ProcParamList procParamList = new ProcParamList();
        String strSQL = iDBDialect.getMergeSQL(this, procParamList);
        mergeCommandModel.setSql(strSQL);
        mergeCommandModel.setProcParamList(procParamList);
        return mergeCommandModel;
    }

    @Override
    public IDEFSearchMode getDEFSearchMode(String strName, boolean bTryMode) throws Exception {
        IDEFSearchMode iDEFSearchMode = this.defSearchModeMap.get(strName.toLowerCase());
        if (iDEFSearchMode == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5236\u5b9a\u5c5e\u6027\u641c\u7d22\u6a21\u5f0f[%1$s]", strName));
        }
        return iDEFSearchMode;
    }

    @Override
    public IDEDataSetCond getFetchQuickSearchCondition(String strQuickSearch) throws Exception {
        DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
        deDataSetCondImpl.setCondType("GROUP");
        deDataSetCondImpl.setCondOp("OR");
        this.onFillFetchQuickSearchConditions(deDataSetCondImpl, strQuickSearch);
        if (deDataSetCondImpl.getChildDEDataQueryConds() == null) {
            return null;
        }
        return deDataSetCondImpl;
    }

    protected void onFillFetchQuickSearchConditions(DEDataSetCond groupCondImpl, String strQuickSearch) throws Exception {
    }

    @Override
    public ISystemRuntime getSystemRuntime() {
        return (ISystemRuntime)this.getSystem();
    }

    @Override
    public boolean isLogicValid() {
        return this.bLogicValid;
    }

    @Override
    public Object getLogicValidValue(boolean bValid) {
        return bValid ? this.validValue : this.invalidValue;
    }

    @Override
    public IDEField getLogicValidDEField() {
        return this.logicValidDEField;
    }

    protected void setId(String strId) {
        this.strId = strId;
    }

    protected void setName(String strName) {
        this.strName = strName;
    }

    public String getValidValue() {
        return this.strValidValue;
    }

    public void setValidValue(String strValidValue) {
        this.strValidValue = strValidValue;
    }

    public String getInvalidValue() {
        return this.strInvalidValue;
    }

    public void setInvalidValue(String strInvalidValue) {
        this.strInvalidValue = strInvalidValue;
    }

    public void setLogicValid(boolean bLogicValid) {
        this.bLogicValid = bLogicValid;
    }

    public void setTableName(String strTableName) {
        this.strTableName = strTableName;
    }

    public void setViewName(String strViewName) {
        this.strViewName = strViewName;
    }

    public void setLogicName(String strLogicName) {
        this.strLogicName = strLogicName;
    }

    @Override
    public String getDSLink() {
        return this.strDSLink;
    }

    public void setDSLink(String strDSLink) {
        this.strDSLink = strDSLink;
    }

    public void setEnableMultiDS(boolean bEnableMultiDS) {
        this.bEnableMultiDS = bEnableMultiDS;
    }

    @Override
    public boolean isEnableMultiDS() {
        return this.bEnableMultiDS;
    }

    public void setNoViewMode(boolean bNoViewMode) {
        this.bNoViewMode = bNoViewMode;
    }

    @Override
    public boolean isNoViewMode() {
        return this.bNoViewMode;
    }

    @Override
    public IService getService(SessionFactory sessionFactory) throws Exception {
        if (sessionFactory == null) {
            return this.getService();
        }
        return ServiceGlobal.getService(this.getServiceId(), sessionFactory);
    }

    @Override
    public void registerDEActionLogic(String strAction, String strAttachMode, String strLogicName) throws Exception {
        IDELogicModel iDELogicModel = (IDELogicModel)this.getDELogic(strLogicName);
        String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
        ArrayList<IDELogicModel<Object>> logicList = this.actionDELogicsMap.get(strKey);
        if (logicList == null) {
            logicList = new ArrayList();
            this.actionDELogicsMap.put(strKey, logicList);
        }
        logicList.add(iDELogicModel);
    }

    @Override
    public void registerDEActionLogic(String strAction, String strAttachMode, String strDstDEName, String strDstActionName) throws Exception {
        String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
        ArrayList<IDEActionLogicModel> logicList = this.actionDELogicsMap2.get(strKey);
        if (logicList == null) {
            logicList = new ArrayList();
            this.actionDELogicsMap2.put(strKey, logicList);
        }
        DEActionLogicModel deActionLogicModel = new DEActionLogicModel();
        deActionLogicModel.setDEName(strDstDEName);
        deActionLogicModel.setDEActionName(strDstActionName);
        logicList.add(deActionLogicModel);
    }

    @Override
    public IDEActionLogicModel registerDEActionLogic(String strAction, String strAttachMode, String strDstDEName, String strDstActionName, boolean bCloneParam, boolean bIgnoreException) throws Exception {
        String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
        ArrayList<IDEActionLogicModel> logicList = this.actionDELogicsMap2.get(strKey);
        if (logicList == null) {
            logicList = new ArrayList();
            this.actionDELogicsMap2.put(strKey, logicList);
        }
        DEActionLogicModel deActionLogicModel = new DEActionLogicModel();
        deActionLogicModel.setDEName(strDstDEName);
        deActionLogicModel.setDEActionName(strDstActionName);
        deActionLogicModel.setCloneParam(bCloneParam);
        deActionLogicModel.setIgnoreException(bIgnoreException);
        logicList.add(deActionLogicModel);
        return deActionLogicModel;
    }

    @Override
    public Iterator<IDELogicModel<ET>> getDEActionLogics(String strAction, String strAttachMode) {
        String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
        ArrayList<IDELogicModel<ET>> logicList = this.actionDELogicsMap.get(strKey);
        if (logicList == null) {
            return null;
        }
        return logicList.iterator();
    }

    @Override
    public Iterator<IDEActionLogicModel> getDEActionLogics2(String strAction, String strAttachMode) {
        String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
        ArrayList<IDEActionLogicModel> logicList = this.actionDELogicsMap2.get(strKey);
        if (logicList == null) {
            return null;
        }
        return logicList.iterator();
    }

    @Override
    public IDEMainState getDEMainState(ISimpleDataObject iSimpleDataObject) throws Exception {
        String strDEMainStateTag = this.getDEMainStateTag(iSimpleDataObject);
        if (strDEMainStateTag == null) {
            return null;
        }
        IDEMainState iDEMainState = this.deMainStateMap.get(strDEMainStateTag);
        if (iDEMainState != null) {
            return iDEMainState;
        }
        return this.defaultDEMainState;
    }

    public void setMainStateFields(String[] mainStateFields) {
        this.mainStateFields = mainStateFields;
    }

    @Override
    public String getDEMainStateTag(ISimpleDataObject iSimpleDataObject) throws Exception {
        if (this.mainStateFields == null) {
            return null;
        }
        String[] stringArray = this.mainStateFields;
        int n = this.mainStateFields.length;
        int n2 = 0;
        while (n2 < n) {
            String strField = stringArray[n2];
            if (!iSimpleDataObject.contains(strField)) {
                if (iSimpleDataObject instanceof IEntityActionSupporter) {
                    if (((IEntityActionSupporter)((Object)iSimpleDataObject)).getActionHelper() != null) {
                        ((IEntityActionSupporter)((Object)iSimpleDataObject)).get(true);
                        break;
                    }
                } else {
                    log.warn((Object)StringHelper.format("\u5f53\u524d\u6570\u636e\u5bf9\u8c61\u4e0d\u5305\u542b\u5c5e\u6027[%1$s]\uff0c\u53ef\u80fd\u4f1a\u53d1\u751f\u9519\u8bef", strField));
                    break;
                }
            }
            ++n2;
        }
        IDEMainState iDEMainState = null;
        String strTag = "";
        int i = 0;
        while (i <= 1) {
            strTag = StringHelper.format("%1$s", i == 0 ? iSimpleDataObject.get(this.mainStateFields[0]) : "*");
            if (this.mainStateFields.length >= 2) {
                int j = 0;
                while (j <= 1) {
                    String strTag2 = StringHelper.format("%1$s__%2$s", strTag, j == 0 ? iSimpleDataObject.get(this.mainStateFields[1]) : "*");
                    if (this.mainStateFields.length >= 3) {
                        int k = 0;
                        while (k <= 1) {
                            String strTag3 = StringHelper.format("%1$s__%2$s", strTag2, k == 0 ? iSimpleDataObject.get(this.mainStateFields[2]) : "*");
                            iDEMainState = this.deMainStateMap.get(strTag3);
                            if (iDEMainState != null) {
                                return iDEMainState.getMSTag();
                            }
                            ++k;
                        }
                    } else {
                        iDEMainState = this.deMainStateMap.get(strTag2);
                        if (iDEMainState != null) {
                            return iDEMainState.getMSTag();
                        }
                    }
                    ++j;
                }
            } else {
                iDEMainState = this.deMainStateMap.get(strTag);
                if (iDEMainState != null) {
                    return iDEMainState.getMSTag();
                }
            }
            ++i;
        }
        return null;
    }

    @Override
    public String getDEMainStateDenyMsg(IDEMainState iDEMainState, ISimpleDataObject iSimpleDataObject, int nActionType, String strActionOrOPPrivName) throws Exception {
        if (iDEMainState == null) {
            return null;
        }
        if (StringHelper.isNullOrEmpty(iDEMainState.getLogicName())) {
            return StringHelper.format("\u5f53\u524d\u6570\u636e\u72b6\u6001\u62d2\u7edd\u6b64\u64cd\u4f5c", iDEMainState.getLogicName());
        }
        return StringHelper.format("\u5f53\u524d\u6570\u636e\u72b6\u6001[%1$s]\u62d2\u7edd\u6b64\u64cd\u4f5c", iDEMainState.getLogicName());
    }

    @Override
    public String getDataInfo(ET et) throws Exception {
        return DataObject.getStringValue(et, this.getMajorDEField().getName(), "");
    }

    @Override
    public IDEWF getDefaultDEWF() {
        return this.defaultDEWF;
    }

    @Override
    public IDEField getPickupDEField(String strDERId) throws Exception {
        IDER1N iDER1N = (IDER1N)this.getSystem().getDER(strDERId);
        return this.getDEField(iDER1N.getPickupDEFName(), false);
    }

    @Override
    public IDEField getPickupDEField(IDataEntityModel majorDEModel, boolean bTryMode) throws Exception {
        Iterator<IDERBase> minorDERs = this.getDERs(false);
        if (minorDERs != null) {
            while (minorDERs.hasNext()) {
                IDERBase iDERBase = minorDERs.next();
                if (!(iDERBase instanceof IDER1N)) continue;
                IDER1N iDER1N = (IDER1N)iDERBase;
                if (StringHelper.compare(majorDEModel.getId(), iDER1N.getMajorDEId(), false) == 0) {
                    return this.getDEField(iDER1N.getPickupDEFName(), false);
                }
                if (majorDEModel.getInheritDataEntity() == null || StringHelper.compare(majorDEModel.getInheritDataEntity().getId(), iDER1N.getMajorDEId(), false) != 0) continue;
                return this.getDEField(iDER1N.getPickupDEFName(), false);
            }
        }
        if (!bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5b9e\u4f53[%1$s]\u5916\u952e\u503c\u5c5e\u6027", majorDEModel.getName()));
        }
        return null;
    }

    @Override
    public IDEField getDEFieldByPDT(String strPreDefinedType, boolean bTryMode) throws Exception {
        IDEField iDEField = this.pdtDEFieldMap.get(strPreDefinedType);
        if (iDEField == null) {
            if (!bTryMode) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u627e\u5230\u9884\u5b9a\u4e49\u7c7b\u578b[%1$s]\u5c5e\u6027", strPreDefinedType));
            }
            return null;
        }
        return iDEField;
    }

    @Override
    public IDER1N getAccMasterDER(ET et) throws Exception {
        if (this.masterDERList == null || et == null) {
            return null;
        }
        for (IDER1N iDER1N : this.masterDERList) {
            if (et.get(iDER1N.getPickupDEFName()) == null) continue;
            return iDER1N;
        }
        return null;
    }

    @Override
    public boolean isEnableAudit() {
        return this.getAuditMode() != 0;
    }

    @Override
    public boolean isLogAuditDetail() {
        return this.getAuditMode() == 2;
    }

    @Override
    public IDEDataAccMgr getDEDataAccMgr() {
        return this.iDEDataAccMgr;
    }

    public void setAuditMode(int nAuditMode) {
        this.nAuditMode = nAuditMode;
    }

    @Override
    public IDEWFModel testDataInWF(IEntity iEntity) throws Exception {
        for (IDEWF iDEWF : this.deWFMap.values()) {
            if (!((IWFDEModel)((Object)iDEWF)).testDataInWF(iEntity)) continue;
            return (IDEWFModel)iDEWF;
        }
        return null;
    }

    @Override
    public Object getOrgId(IEntity iEntity) throws Exception {
        if (this.orgIdDEField == null || iEntity == null) {
            return null;
        }
        if (!iEntity.contains(this.orgIdDEField.getName()) && iEntity instanceof IEntityActionSupporter && ((IEntityActionSupporter)((Object)iEntity)).getActionHelper() != null) {
            ((IEntityActionSupporter)((Object)iEntity)).get();
        }
        return iEntity.get(this.orgIdDEField.getName());
    }

    @Override
    public int getDataAccCtrlMode() {
        return this.nDataAccCtrlMode;
    }

    public void setDataAccCtrlMode(int nDataAccCtrlMode) {
        this.nDataAccCtrlMode = nDataAccCtrlMode;
    }

    @Override
    public ISystemModel getSystemModel() {
        if (this.iSystemModel == null) {
            this.iSystemModel = (ISystemModel)this.getSystem();
        }
        return this.iSystemModel;
    }

    @Override
    public IDEField getUpdateDateDEField() {
        return this.updateDateDEField;
    }

    @Override
    public int getAuditMode() {
        return this.nAuditMode;
    }

    @Override
    public String getDEViewIdByPDT(String strPreDefinedType, boolean bTryMode) throws Exception {
        String strDEViewId = this.pdtDEViewMap.get(strPreDefinedType.toUpperCase());
        if (strDEViewId == null && !bTryMode) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u9884\u5b9a\u4e49[%1$s]\u5b9e\u4f53\u89c6\u56fe\u6807\u8bc6", strPreDefinedType));
        }
        return strDEViewId;
    }

    @Override
    public void registerPDTDEView(String strPreDefinedType, String strDEViewId) throws Exception {
        this.pdtDEViewMap.put(strPreDefinedType.toUpperCase(), strDEViewId);
    }

    @Override
    public String getSDDEViewPDTParam(ET et, boolean bEnableWF, boolean bWFWorkMode, int nAppType) throws Exception {
        String strPDTParam = null;
        if (bEnableWF) {
            for (IDEWF iDEWF : this.deWFList) {
                strPDTParam = iDEWF.getWFEditViewPDTParam((IEntity)et, bWFWorkMode, nAppType);
                if (!StringHelper.isNullOrEmpty(strPDTParam)) break;
            }
            if (!StringHelper.isNullOrEmpty(strPDTParam)) {
                return strPDTParam;
            }
        }
        if (this.isEnableMultiForm() && this.getMultiFormDEField() != null) {
            Object objFormValue = et.get(this.getMultiFormDEField().getName());
            if (nAppType == 2) {
                return StringHelper.format("%1$s:%2$s", "MOBEDITVIEW", objFormValue);
            }
            return StringHelper.format("%1$s:%2$s", "EDITVIEW", objFormValue);
        }
        if (nAppType == 2) {
            return "MOBEDITVIEW";
        }
        return "EDITVIEW";
    }

    @Override
    public String getSDDEViewPDTParam(ET et, boolean bEnableWF, boolean bWFWorkMode) throws Exception {
        return this.getSDDEViewPDTParam(et, bEnableWF, bWFWorkMode, 1);
    }

    @Override
    public boolean isEnableMultiForm() {
        return this.bEnableMultiForm;
    }

    public void setEnableMultiForm(boolean bEnableMultiForm) {
        this.bEnableMultiForm = bEnableMultiForm;
    }

    @Override
    public String getIndexDEType() {
        return this.strIndexDEType;
    }

    public void setIndexDEType(String strIndexDEType) {
        this.strIndexDEType = strIndexDEType;
    }

    @Override
    public IDEField getMultiFormDEField() {
        return this.multiFormDEField;
    }

    @Override
    public IDEField getIndexTypeDEField() {
        return this.indexTypeDEField;
    }

    @Override
    public IDERIndex getDERIndex(boolean bMajor, String strIndexValue) throws Exception {
        Iterator<IDERBase> derBases = this.getDERs(bMajor);
        if (derBases != null) {
            while (derBases.hasNext()) {
                IDERIndex iDERIndex;
                IDERBase iDERBase = derBases.next();
                if (!(iDERBase instanceof IDERIndex) || StringHelper.compare((iDERIndex = (IDERIndex)iDERBase).getTypeValue(), strIndexValue, true) != 0) continue;
                return iDERIndex;
            }
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u7c7b\u578b\u503c[%2$s]\u7d22\u5f15\u5173\u7cfb[%3$s]", this.getName(), strIndexValue, bMajor));
    }

    @Override
    public IDataEntity getInheritDataEntity() throws Exception {
        return this.getInheritDEModel();
    }

    @Override
    public IDataEntityModel getInheritDEModel() throws Exception {
        IDataEntityModel iDataEntity;
        if (StringHelper.isNullOrEmpty(this.getInheritDEId())) {
            return null;
        }
        if (this.inheritDEModel != null) {
            return this.inheritDEModel;
        }
        this.inheritDEModel = iDataEntity = DEModelGlobal.getDEModel(this.getInheritDEId());
        return this.inheritDEModel;
    }

    protected void setInheritDEId(String strInheritDEId) {
        this.strInheritDEId = strInheritDEId;
    }

    public String getInheritDEId() {
        return this.strInheritDEId;
    }

    @Override
    public Iterator<IDEWF> getDEWFs() {
        if (this.deWFMap.size() == 0) {
            return null;
        }
        return this.deWFMap.values().iterator();
    }

    @Override
    public boolean hasDEWF() {
        return this.deWFMap.size() > 0;
    }

    @Override
    public int getDynamicMode() {
        return this.nDynamicMode;
    }

    public void setDynamicMode(int nDynamicMode) {
        this.nDynamicMode = nDynamicMode;
    }

    @Override
    public void registerMapDEOPPrivTag(String strDEOPPrivTag, String strDERName, String strMapDEOPPrivTag) {
        String strTag = StringHelper.format("%1$s|%2$s", strDEOPPrivTag, strDERName).toUpperCase();
        this.deOPPrivMapMap.put(strTag, strMapDEOPPrivTag);
    }

    @Override
    public String getMapDEOPPrivTag(String strDEOPPrivTag, String strDERName) {
        String strTag = StringHelper.format("%1$s|%2$s", strDEOPPrivTag, strDERName).toUpperCase();
        String strMapDEOPPrivTag = this.deOPPrivMapMap.get(strTag);
        if (StringHelper.isNullOrEmpty(strMapDEOPPrivTag) && StringHelper.compare(strDEOPPrivTag, "ALL", true) != 0) {
            return this.getMapDEOPPrivTag("ALL", strDERName);
        }
        return strMapDEOPPrivTag;
    }

    @Override
    public IDEWFModel getDEWFModel(ET et, IWebContext iWebContext) throws Exception {
        String strWFMode = iWebContext.getWFMode();
        return null;
    }

    @Override
    public int getDataChangeLogMode() {
        return this.nDataChangeLogMode;
    }

    public void setDataChangeLogMode(int nDataChangeLogMode) {
        this.nDataChangeLogMode = nDataChangeLogMode;
    }

    @Override
    public Iterator<IDEDataSync> getDEDataSyncs(boolean bIn) {
        if (bIn) {
            if (this.deDataSyncInList == null) {
                return null;
            }
            return this.deDataSyncInList.iterator();
        }
        if (this.deDataSyncOutList == null) {
            return null;
        }
        return this.deDataSyncOutList.iterator();
    }

    @Override
    public void registerDEDataSync(IDEDataSync iDEDataSync) {
        if (iDEDataSync.isInMode()) {
            if (this.deDataSyncInList == null) {
                this.deDataSyncInList = new ArrayList();
            }
            this.deDataSyncInList.add(iDEDataSync);
            DataSyncGlobal.registerDEDataSyncIn((IDEDataSyncIn)iDEDataSync);
        } else {
            if (this.deDataSyncOutList == null) {
                this.deDataSyncOutList = new ArrayList();
            }
            this.deDataSyncOutList.add(iDEDataSync);
        }
    }

    @Override
    public Iterator<IDEField> getUnionKeyValueDEFields() {
        if (this.unionKeyValueFieldList == null || this.unionKeyValueFieldList.size() == 0) {
            return null;
        }
        return this.unionKeyValueFieldList.iterator();
    }

    @Override
    public ET createEntity() {
        return null;
    }

    @Override
    public IService getService() {
        return null;
    }

    @Override
    public String getServiceId() {
        return null;
    }

    @Override
    public String getDEFieldConditionSql(IDBDialect iDBDialect, String strFieldName, String strFieldExp, int nStdDataType, String strCondOp, String strValue) throws Exception {
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        return iDBDialect.getConditionSQL(strFieldExp, nStdDataType, strCondOp, strValue, false, null);
    }

    @Override
    public String getDEFieldConditionSql(IDBDialect iDBDialect, String strFieldName, String strFieldExp, int nStdDataType, String strCondOp, String strValueOrParam, boolean bParam, SqlParamList sqlParamList) throws Exception {
        if (iDBDialect == null) {
            throw new Exception(StringHelper.format("\u4f20\u5165\u6570\u636e\u5e93\u9002\u914d\u5668\u65e0\u6548"));
        }
        return iDBDialect.getConditionSQL(strFieldExp, nStdDataType, strCondOp, strValueOrParam, bParam, sqlParamList);
    }

    @Override
    public IDEDataQuery getDefaultDEDataQuery() {
        return this.defaultDEDataQuery;
    }

    @Override
    public int getStorageMode() {
        return this.nStorageMode;
    }

    public void setStorageMode(int nStorageMode) {
        this.nStorageMode = nStorageMode;
    }

    @Override
    public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception {
        return this.getDEActionWizardGroup(strDEActionWizardGroupId, false);
    }

    @Override
    public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId, boolean bTry) throws Exception {
        IDEActionWizardGroup iDEActionWizardGroup = this.deActionWizardGroupMap.get(strDEActionWizardGroupId);
        if (iDEActionWizardGroup == null && !bTry) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4[%1$s]", strDEActionWizardGroupId));
        }
        return iDEActionWizardGroup;
    }

    @Override
    public IDEActionWizard getDEActionWizard(String strDEActionWizardId) throws Exception {
        IDEActionWizard iDEActionWizard = this.deActionWizardMap.get(strDEActionWizardId);
        if (iDEActionWizard == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u64cd\u4f5c\u5411\u5bfc\u7ec4[%1$s]", strDEActionWizardId));
        }
        return iDEActionWizard;
    }

    @Override
    public void registerDEActionWizard(IDEActionWizard iDEActionWizard) {
        this.deActionWizardMap.put(iDEActionWizard.getId(), iDEActionWizard);
    }

    @Override
    public void registerDEActionWizardGroup(IDEActionWizardGroup iDEActionWizardGroup) {
        this.deActionWizardGroupMap.put(iDEActionWizardGroup.getId(), iDEActionWizardGroup);
    }

    @Override
    public IDEBATable getDEBATable(String strDEBATableId) throws Exception {
        IDEBATable iDEBATable = null;
        if (this.deBATableMap != null) {
            iDEBATable = this.deBATableMap.get(strDEBATableId);
        }
        if (iDEBATable == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5927\u6570\u636e\u8868[%1$s]", strDEBATableId));
        }
        return iDEBATable;
    }

    @Override
    public Iterator<IDEBATable> getDEBATables() {
        if (this.deBATablList == null) {
            return null;
        }
        return this.deBATablList.iterator();
    }

    @Override
    public void registerDEBATable(IDEBATable iDEBATable) {
        if (this.deBATableMap == null) {
            this.deBATableMap = new HashMap();
            this.deBATablList = new ArrayList();
        }
        this.deBATableMap.put(iDEBATable.getId(), iDEBATable);
        this.deBATablList.add(iDEBATable);
    }

    @Override
    public void setServicePlugin(IServicePlugin iServicePlugin) throws Exception {
        this.setServicePlugin(iServicePlugin, false);
    }

    @Override
    public void setServicePlugin(IServicePlugin iServicePlugin, boolean bIgnoreOrigin) throws Exception {
        IServicePlugin lastPlugin = null;
        if (!bIgnoreOrigin && (lastPlugin = this.iServicePlugin) == null && this.getSystemModel().getSystemPlugin() != null) {
            lastPlugin = this.getSystemModel().getSystemPlugin().getServicePlugin();
        }
        iServicePlugin.setPrevPlugin(lastPlugin);
        this.iServicePlugin = iServicePlugin;
    }

    @Override
    public IServicePlugin getServicePlugin() {
        if (this.iServicePlugin != null) {
            return this.iServicePlugin;
        }
        if (this.getSystemModel().getSystemPlugin() != null) {
            return this.getSystemModel().getSystemPlugin().getServicePlugin();
        }
        return null;
    }

    @Override
    public String getView2Name() {
        return this.strView2Name;
    }

    @Override
    public String getView3Name() {
        return this.strView3Name;
    }

    @Override
    public String getView4Name() {
        return this.strView4Name;
    }

    public void setView2Name(String strView2Name) {
        this.strView2Name = strView2Name;
    }

    public void setView3Name(String strView3Name) {
        this.strView3Name = strView3Name;
    }

    public void setView4Name(String strView4Name) {
        this.strView4Name = strView4Name;
    }

    @Override
    public IDEDataQuery getViewDEDataQuery(int nViewLevel) {
        IDEDataQuery viewDEDataQuery = null;
        for (IDEDataQuery iDEDataQuery : this.deDataQueryList) {
            if (iDEDataQuery.getViewLevel() == -1 || iDEDataQuery.getViewLevel() > nViewLevel) continue;
            if (iDEDataQuery.getViewLevel() == nViewLevel) {
                return iDEDataQuery;
            }
            if (iDEDataQuery.getViewLevel() >= nViewLevel) continue;
            if (viewDEDataQuery == null) {
                viewDEDataQuery = iDEDataQuery;
                continue;
            }
            if (viewDEDataQuery.getViewLevel() >= iDEDataQuery.getViewLevel()) continue;
            viewDEDataQuery = iDEDataQuery;
        }
        if (viewDEDataQuery == null) {
            return this.getDefaultDEDataQuery();
        }
        return viewDEDataQuery;
    }

    @Override
    public String getViewName(int nViewLevel) {
        switch (nViewLevel) {
            case -1: 
            case 0: {
                return this.getViewName();
            }
            case 3: {
                if (!StringHelper.isNullOrEmpty(this.getView4Name())) {
                    return this.getView4Name();
                }
            }
            case 2: {
                if (!StringHelper.isNullOrEmpty(this.getView3Name())) {
                    return this.getView3Name();
                }
            }
            case 1: {
                if (StringHelper.isNullOrEmpty(this.getView2Name())) break;
                return this.getView2Name();
            }
        }
        return this.getViewName();
    }

    protected String getSelectConditionSql(IDEDataQueryCodeCond iDEDataQueryCond, IDBDialect iDBDialect, ProcParamList list) throws Exception {
        if (StringHelper.compare(iDEDataQueryCond.getCondType(), "GROUP", true) == 0) {
            ArrayList<String> condList = new ArrayList<String>();
            Iterator<IDEDataQueryCodeCond> childDEDataQueryConds = iDEDataQueryCond.getChildDEDataQueryConds();
            if (childDEDataQueryConds != null) {
                while (childDEDataQueryConds.hasNext()) {
                    IDEDataQueryCodeCond childDEDataQueryCond = childDEDataQueryConds.next();
                    String strCond = this.getSelectConditionSql(childDEDataQueryCond, iDBDialect, list);
                    if (StringHelper.isNullOrEmpty(strCond)) continue;
                    condList.add(strCond);
                }
            }
            if (condList.size() == 0) {
                return null;
            }
            StringBuilderEx sb = new StringBuilderEx();
            boolean bFirst = true;
            for (String strCond : condList) {
                if (bFirst) {
                    bFirst = false;
                } else {
                    sb.append(" %1$s ", iDEDataQueryCond.getCondOp());
                }
                sb.append("( %1$s )", strCond);
            }
            if (iDEDataQueryCond.isNotMode()) {
                return StringHelper.format(" NOT( %1$s )", sb.toString());
            }
            return sb.toString();
        }
        if (StringHelper.compare(iDEDataQueryCond.getCondType(), "DEFIELD", true) == 0) {
            String strDEFieldExp = iDEDataQueryCond.getDEFieldExp();
            int nStdDataType = iDEDataQueryCond.getStdDataType();
            if (StringHelper.isNullOrEmpty(strDEFieldExp)) {
                strDEFieldExp = iDBDialect.getDBObjStandardName(iDEDataQueryCond.getDEFName());
            }
            if (nStdDataType == 0) {
                IDEField iDEField = this.getDEField(iDEDataQueryCond.getDEFName(), false);
                nStdDataType = iDEField.getStdDataType();
            }
            if (DataTypeHelper.isStringDataType(nStdDataType)) {
                return this.getDEFieldConditionSql(iDBDialect, iDEDataQueryCond.getDEFName(), strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue());
            }
            SqlParamList sqlParamList = new SqlParamList();
            String strSql = this.getDEFieldConditionSql(iDBDialect, iDEDataQueryCond.getDEFName(), strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getDEFName(), true, sqlParamList);
            if (sqlParamList.size() > 0) {
                ProcParam procParam = new ProcParam();
                procParam.setDataType(nStdDataType);
                procParam.setParamName("");
                if (iDEDataQueryCond instanceof ISelectFieldFilter) {
                    procParam.setValue(((ISelectFieldFilter)iDEDataQueryCond).getCondObjectValue());
                } else if (nStdDataType != 0) {
                    procParam.setValue(DataTypeHelper.parse(nStdDataType, iDEDataQueryCond.getCondValue()));
                } else {
                    procParam.setValue(iDEDataQueryCond.getCondValue());
                }
                list.add(procParam);
            }
            return strSql;
        }
        if (StringHelper.compare(iDEDataQueryCond.getCondType(), "CUSTOM", true) == 0) {
            throw new Exception("\u4e0d\u652f\u6301\u81ea\u5b9a\u4e49\u6761\u4ef6");
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6761\u4ef6\u7c7b\u578b[%1$s]", iDEDataQueryCond.getCondType()));
    }

    @Override
    public boolean hasDEMainState() {
        return this.deMainStateMap.size() > 0;
    }

    @Override
    public boolean isEnableEntityCache() {
        return this.bEnableEntityCache;
    }

    @Override
    public int getEntityCacheTimeout() {
        return this.nEntityCacheTimeout;
    }

    @Override
    public int getEntityCacheCount() {
        return this.nEntityCacheCount;
    }

    public void setEnableEntityCache(boolean bEnableEntityCache) {
        this.bEnableEntityCache = bEnableEntityCache;
    }

    public void setEntityCacheCount(int nEntityCacheCount) {
        this.nEntityCacheCount = nEntityCacheCount;
    }

    public void setEntityCacheTimeout(int nEntityCacheTimeout) {
        this.nEntityCacheTimeout = nEntityCacheTimeout;
    }

    @Override
    public int getDataImpExpMode() {
        return this.nDataImpExpMode;
    }

    public void setDataImpExpMode(int nDataImpExpMode) {
        this.nDataImpExpMode = nDataImpExpMode;
    }

    @Override
    public Object getRuntimeId() {
        if (this.objRuntimeId == null) {
            return this.getId();
        }
        return this.objRuntimeId;
    }

    @Override
    public void setRuntimeId(Object objRuntimeId) {
        this.objRuntimeId = objRuntimeId;
    }

    @Override
    public String getDEOPPrivTarget(String strDEOPPriv) {
        return this.getSystemModel().getDEOPPrivTarget(strDEOPPriv);
    }

    @Override
    public String getServiceAPIClientId() {
        return this.strServiceAPIClientId;
    }

    public void setServiceAPIClientId(String strServiceAPIClientId) {
        this.strServiceAPIClientId = strServiceAPIClientId;
    }

    @Override
    public String getServiceAPIActionTag(String strActionType, String strAction) throws Exception {
        if (StringHelper.isNullOrEmpty(this.strServiceActionDETag)) {
            if (StringHelper.isNullOrEmpty(strAction)) {
                return StringHelper.format("%1$s__%2$s", this.getName(), strActionType).toUpperCase();
            }
            return StringHelper.format("%1$s__%2$s__%3$s", this.getName(), strActionType, strAction).toUpperCase();
        }
        if (StringHelper.isNullOrEmpty(strAction)) {
            return StringHelper.format("%1$s__%2$s", this.strServiceActionDETag, strActionType).toUpperCase();
        }
        return StringHelper.format("%1$s__%2$s__%3$s", this.strServiceActionDETag, strActionType, strAction).toUpperCase();
    }

    @Override
    public boolean isUseServiceAPI() {
        if (this.getStorageMode() == 4) {
            return true;
        }
        return this.getSystemRuntime().isDEUseServiceAPI(this);
    }

    @Override
    public IServiceAPIClientModel getServiceAPIClientModel() throws Exception {
        if (StringHelper.isNullOrEmpty(this.getServiceAPIClientId())) {
            return this.getSystemRuntime().getServiceAPIClientModel();
        }
        return this.getSystemModel().getServiceAPIClientModel(this.getServiceAPIClientId());
    }

    @Override
    public String getDefaultDEDTSQueueId() {
        return this.strDefaultDEDTSQueueId;
    }

    public void setDefaultDEDTSQueueId(String strDefaultDEDTSQueueId) {
        this.strDefaultDEDTSQueueId = strDefaultDEDTSQueueId;
    }

    @Override
    public int getDataAccCtrlArch() {
        return this.nDataAccCtrlArch;
    }

    public void setDataAccCtrlArch(int nDataAccCtrlArch) {
        this.nDataAccCtrlArch = nDataAccCtrlArch;
    }

    @Override
    public void registerDEUserRole(IDEUserRole iDEUserRole) {
        if (!StringHelper.isNullOrEmpty(iDEUserRole.getId())) {
            this.deUserRoleMap.put(iDEUserRole.getId(), iDEUserRole);
        }
    }

    @Override
    public IDEUserRole getDEUserRole(String strDEUserRoleId) throws Exception {
        IDEUserRole iDEUserRole = this.deUserRoleMap.get(strDEUserRoleId);
        if (iDEUserRole == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u7528\u6237\u89d2\u8272\u5bf9\u8c61[%1$s]", strDEUserRoleId));
        }
        return iDEUserRole;
    }

    @Override
    public Iterator<IDEUserRole> getDEUserRoles() {
        if (this.deUserRoleMap.size() == 0) {
            return null;
        }
        return this.deUserRoleMap.values().iterator();
    }

    @Override
    public void registerDEOPPrivRole(IDEOPPrivRole iDEOPPrivRole) {
        if (StringHelper.isNullOrEmpty(iDEOPPrivRole.getDEOPPrivTag())) {
            return;
        }
        ArrayList<IDEOPPrivRole> deOPPrivRoleList = this.deOPPrivRoleListMap.get(iDEOPPrivRole.getDEOPPrivTag());
        if (deOPPrivRoleList == null) {
            deOPPrivRoleList = new ArrayList();
            this.deOPPrivRoleListMap.put(iDEOPPrivRole.getDEOPPrivTag(), deOPPrivRoleList);
        }
        deOPPrivRoleList.add(iDEOPPrivRole);
    }

    @Override
    public Iterator<IDEOPPrivRole> getDEOPPrivRoles(String strDEOPrivTag) {
        ArrayList<IDEOPPrivRole> deOPPrivRoleList = this.deOPPrivRoleListMap.get(strDEOPrivTag);
        if (deOPPrivRoleList == null || deOPPrivRoleList.size() == 0) {
            return null;
        }
        return deOPPrivRoleList.iterator();
    }

    @Override
    public String getAuditDEName() {
        return this.strAuditDEName;
    }

    @Override
    public String getAuditDetailDEName() {
        return this.strAuditDetailDEName;
    }

    public void setAuditDEName(String strAuditDEName) {
        this.strAuditDEName = strAuditDEName;
    }

    public void setAuditDetailDEName(String strAuditDetailDEName) {
        this.strAuditDetailDEName = strAuditDetailDEName;
    }

    @Override
    public IDynaViewSetting getDynaViewSetting() {
        if (this.iDynaViewSetting == null) {
            return this.getSystemModel().getDynaSystemSetting().getDynaViewSetting();
        }
        return this.iDynaViewSetting;
    }

    public void setDynaViewSetting(IDynaViewSetting iDynaViewSetting) {
        this.iDynaViewSetting = iDynaViewSetting;
    }

    @Override
    public IDEDBConfig getDEDBConfig(String strDBType) throws Exception {
        if (this.deDBConfigMap == null) {
            return this;
        }
        IDEDBConfig iDEDBConfig = this.deDBConfigMap.get(strDBType);
        if (iDEDBConfig != null) {
            return iDEDBConfig;
        }
        return this;
    }

    @Override
    public void registerDEDBConfig(IDEDBConfig iDEDBConfig) {
        IDEDBConfigModel iDEDBConfigModel = (IDEDBConfigModel)iDEDBConfig;
        if (this.deDBConfigMap == null) {
            this.deDBConfigMap = new HashMap();
        }
        this.deDBConfigMap.put(iDEDBConfigModel.getDBType(), iDEDBConfig);
    }

    @Override
    public JSONObject toJSONObject(IEntity iEntity, boolean bIncludeEmpty, int nOption) throws Exception {
        if (this.getSystemModel() != null) {
            return this.getSystemModel().toJSONObject(this, iEntity, bIncludeEmpty, nOption);
        }
        return DataObject.toJSONObject(iEntity, bIncludeEmpty);
    }

    @Override
    public IDEDataImport getDefaultDEDataImport() {
        return this.defaultDEDataImport;
    }

    @Override
    public boolean isEnableDynaStorage() {
        return this.bEnableDynaStorage;
    }

    public void setEnableDynaStorage(boolean bEnableDynaStorage) {
        this.bEnableDynaStorage = bEnableDynaStorage;
    }

    @Override
    public String getDynaStorageDEName() {
        return this.strDynaStorageDEName;
    }

    public void setDynaStorageDEName(String strDynaStorageDEName) {
        this.strDynaStorageDEName = strDynaStorageDEName;
    }

    @Override
    public boolean hasDynaStorageDEField() {
        return this.bHasDynaStorageField;
    }

    @Override
    public String getInheritTypeValue() {
        return this.strInheritTypeValue;
    }

    protected void setInheritTypeValue(String strInheritTypeValue) {
        this.strInheritTypeValue = strInheritTypeValue;
    }

    protected boolean isRegisterToDEModelGlobal() {
        return true;
    }

    @Override
    public IDEField getOrgIdDEField() {
        return this.orgIdDEField;
    }

    @Override
    public boolean isEnableTempData() {
        return this.bEnableTempData;
    }

    public void setEnableTempData(boolean bEnableTempData) {
        this.bEnableTempData = bEnableTempData;
    }
}

