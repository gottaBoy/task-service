package net.ibizsys.paas.demodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.IApplication;
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
import net.ibizsys.paas.db.IProcParam;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.ISelectFieldFilter;
import net.ibizsys.paas.db.ProcParam;
import net.ibizsys.paas.db.ProcParamList;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionSupporter;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.security.DEDataAccMgr;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.security.IDEDataAccMgr;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.ISystemRuntime;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IDynaViewSetting;
import net.ibizsys.paas.view.IView;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.pswf.core.IWFDEModel;
import net.sf.json.JSONObject;

/**
 * 数据实体模型对象基类
 * 
 * @author lionlau
 *
 */
public abstract class DataEntityModelBase<ET extends IEntity> extends ModelBase3Impl implements IDataEntityModel<ET>,IDEDBConfig {

	private static final Log log = LogFactory.getLog(DataEntityModelBase.class);
	
	protected HashMap<String, IDEDataQuery> deDataQueryMap = new HashMap<String, IDEDataQuery>();
	protected ArrayList<IDEDataQuery> deDataQueryList = new ArrayList<IDEDataQuery>();
	protected HashMap<String, IDEDataSet> deDataSetModelMap = new HashMap<String, IDEDataSet>();

	private HashMap<String, IDEField> deFieldMap = new HashMap<String, IDEField>();
	private ArrayList<IDEField> deFieldList = new ArrayList<IDEField>();
	private HashMap<String, IDEField> pdtDEFieldMap = new HashMap<String, IDEField>();

	private HashMap<String, IDEAction> deActionMap = new HashMap<String, IDEAction>();
	private HashMap<String, IDEACMode> deACModeMap = new HashMap<String, IDEACMode>();
	private HashMap<String, IDELogic> deLogicMap = new HashMap<String, IDELogic>();
	private HashMap<String, IDEUIAction> deUIActionMap = new HashMap<String, IDEUIAction>();
	private HashMap<String, IDEWF> deWFMap = new HashMap<String, IDEWF>();
	private ArrayList<IDEWF> deWFList = new ArrayList<IDEWF>();
	private HashMap<String, IDEMainState> deMainStateMap = new HashMap<String, IDEMainState>();
	private HashMap<String, String> pdtDEViewMap = new HashMap<String, String>();
	private HashMap<String, String> deOPPrivMapMap = new HashMap<String, String>();
	private ArrayList<IDEDataSync> deDataSyncInList = null;
	private ArrayList<IDEDataSync> deDataSyncOutList = null;
	private HashMap<String, IDEDataExport> deDataExportMap = new HashMap<String, IDEDataExport>();
	private HashMap<String, IDEDataImport> deDataImportMap = new HashMap<String, IDEDataImport>();
	private IDEDataImport defaultDEDataImport = null;
	
	protected HashMap<String, IDEActionWizardGroup> deActionWizardGroupMap = new HashMap<String, IDEActionWizardGroup>();
	protected HashMap<String, IDEActionWizard> deActionWizardMap = new HashMap<String, IDEActionWizard>();

	private HashMap<String, IDEUniState> deUniStateMap = new HashMap<String, IDEUniState>();
	private HashMap<String, IDEUserRole> deUserRoleMap = new HashMap<String, IDEUserRole>();
	private HashMap<String, ArrayList<IDEOPPrivRole>> deOPPrivRoleListMap = new HashMap<String, ArrayList<IDEOPPrivRole>>();
	
	private HashMap<String, IDEBATable> deBATableMap = null;
	private ArrayList<IDEBATable> deBATablList = null;
	private HashMap<String, IDEDBConfig> deDBConfigMap = null;
	
	/**
	 * 实体操作逻辑集合
	 */
	private HashMap<String, ArrayList<IDELogicModel<ET>>> actionDELogicsMap = new HashMap<String, ArrayList<IDELogicModel<ET>>>();

	private HashMap<String, ArrayList<IDEActionLogicModel>> actionDELogicsMap2 = new HashMap<String, ArrayList<IDEActionLogicModel>>();

	/**
	 * 联合键值属性集合
	 */
	protected ArrayList<IDEField> unionKeyValueFieldList = new ArrayList<IDEField>();

	protected HashMap<String, IDEField> unionKeyValueFieldMap = new HashMap<String, IDEField>();

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
	private HashMap<String, IDEFSearchMode> defSearchModeMap = new HashMap<String, IDEFSearchMode>();

	private IDEMainState defaultDEMainState = null;

	private IDEDataAccMgr iDEDataAccMgr = null;

	private int nDataAccCtrlMode = DATAACCCTRL_SELF;

	private ArrayList<IDER1N> masterDERList = null;

	private int nAuditMode = AUDITMODE_NONE;

	private boolean bEnableMultiForm = false;

	private String strIndexDEType = null;

	private IDEField multiFormDEField = null;

	private IDEField indexTypeDEField = null;

	private String strInheritDEId = null;

	private IDataEntityModel inheritDEModel = null;

	private int nDynamicMode = IDataEntity.DYNAMICMODE_STATIC;

	private int nDataChangeLogMode = IDataEntity.DATACHGLOG_NONE;

	private boolean bNoViewMode = false;

	private IDEDataQuery defaultDEDataQuery = null;

	private int nStorageMode = IDataEntity.STORAGEMODE_SQL;
	
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
	
	private int nDataImpExpMode = DATAIMPEXPFLAG_ALL;

	private Object objRuntimeId = null;
	
	private String strServiceAPIClientId = null;
	
	private String strServiceActionDETag = null;
	
	private String strDefaultDEDTSQueueId = null;
	
	private int nDataAccCtrlArch = IDataEntity.DATAACCCTRLARCH_RTSYSROLE;
	
	private String strAuditDEName = null;
	
	private String strAuditDetailDEName = null;
	
	private IDynaViewSetting iDynaViewSetting = null;
	
	private ISystemModel iSystemModel = null;
	
	private boolean bEnableDynaStorage = false;
	
	private String strDynaStorageDEName = null;
	
	private boolean bHasDynaStorageField = false;
	
	private String strInheritTypeValue = null;
	
	private boolean bEnableTempData = false;
	
	
	public DataEntityModelBase() throws Exception {

	}

	/**
	 * 准备实体相关模型
	 * 
	 * @throws Exception
	 */
	protected void prepareModels() throws Exception {

		prepareDEFields();
		this.updateDateDEField = this.getDEFieldByPDT(IDEField.PREDEFINEDTYPE_UPDATEDATE, true);
		if (this.isLogicValid()) {
			validValue = DataTypeHelper.parse(logicValidDEField.getStdDataType(), this.getValidValue());
			invalidValue = DataTypeHelper.parse(logicValidDEField.getStdDataType(), this.getInvalidValue());
		}

		this.unionKeyValueFieldList.clear();
		if (unionKeyValueFieldMap.size() > 0) {
			for (int i = 1; i < 9; i++) {
				String strKey = StringHelper.format("KEY%1$s", i);
				IDEField iDEField = unionKeyValueFieldMap.get(strKey);
				if (iDEField != null) this.unionKeyValueFieldList.add(iDEField);
			}
		}

		prepareDEDBConfigs();
		prepareDEACModes();
		prepareDEDataQueries();
		prepareDEDataSets();
		prepareDELogics();
		prepareDEUIActions();
		prepareDEActions();
		prepareDEMainStates();
		prepareDEDataSyncs();
		prepareDEDataImports();
		prepareDEDataExports();
		prepareDEWFs();
		preparePDTDEViews();
		prepareDEOPPrivTagMaps();
		prepareDEPrints();
		prepareDEReports();
		prepareDEActionWizards();
		prepareDEActionWizardGroups();
		prepareDEUniStates();
		prepareDEDTSQueues();
		prepareDEUserRoles();
		prepareDEOPPrivRoles();
		prepareDEBATables();

		this.setNoViewMode(this.getSystemModel().isNoViewMode(this));
		iDEDataAccMgr = prepareDEDataAccMgr();
		if (this.getDataAccCtrlMode() == DATAACCCTRL_MASTER 
				||this.getDataAccCtrlMode() == IDataEntityModel.DATAACCCTRL_MASTER_SELF) {
			java.util.Iterator<IDERBase> derBases = this.getDERs(false);
			if (derBases == null) {
				throw new Exception(StringHelper.format("实体[%1$s]数据访问控制定义为主实体，但未找到任何关系",this.getName()));
			}

			while (derBases.hasNext()) {
				IDERBase iDERBase = derBases.next();
				if (iDERBase instanceof IDER1N) {
					IDER1N iDER1N = (IDER1N) iDERBase;
					if ((iDER1N.getMasterRS() & IDER1N.MASTERRS_ATTACHED_ACC) > 0) {
						if (masterDERList == null) masterDERList = new ArrayList<IDER1N>();
						masterDERList.add(iDER1N);
					}
				}
			}
		}
	}

	/**
	 * 建立实体数据访问控制对象
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IDEDataAccMgr prepareDEDataAccMgr() throws Exception {
		if (this.getSystemModel() != null) return this.getSystemModel().createDEDataAccMgr(this);

		DEDataAccMgr iDEDataAccMgr = new DEDataAccMgr();
		iDEDataAccMgr.init(this);
		return iDEDataAccMgr;
	}
	
	/**
	 * 准备实体数据库配置
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDBConfigs() throws Exception {
	}
	

	/**
	 * 准备实体数据查询模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDataQueries() throws Exception {
	}

	/**
	 * 准备实体数据集合模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDataSets() throws Exception {
	}

	/**
	 * 准备实体行为模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEActions() throws Exception {
	}

	/**
	 * 准备实体自动填充模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEACModes() throws Exception {
	}

	/**
	 * 准备实体逻辑模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDELogics() throws Exception {
	}

	/**
	 * 准备实体界面行为模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEUIActions() throws Exception {
	}

	/**
	 * 准备实体工作流模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEWFs() throws Exception {
	}

	/**
	 * 准备实体主状态模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEMainStates() throws Exception {
	}

	/**
	 * 准备实体预定义类型视图模型
	 * 
	 * @throws Exception
	 */
	protected void preparePDTDEViews() throws Exception {
	}

	/**
	 * 准备实体操作标识映射模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEOPPrivTagMaps() throws Exception {
	}

	/**
	 * 准备实体打印模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEPrints() throws Exception {
	}

	/**
	 * 准备实体报表模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEReports() throws Exception {
	}

	/**
	 * 准备实体同步模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDataSyncs() throws Exception {
	}

	/**
	 * 准备实体数据导入模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDataImports() throws Exception {
	}

	/**
	 * 准备实体数据导出模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDataExports() throws Exception {
	}

	
	/**
	 * 准备实体操作向导
	 * @throws Exception
	 */
	protected void prepareDEActionWizards() throws Exception {
	
	}
	
	/**
	 * 准备实体操作向导组
	 * @throws Exception
	 */
	protected void prepareDEActionWizardGroups() throws Exception {
		
	}
	
	/**
	 * 准备实体大数据表配置
	 * 
	 * @throws Exception
	 */
	protected void prepareDEBATables() throws Exception {
	}
	
	
	/**
	 * 准备实体统一状态模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEUniStates() throws Exception {
	}

	/**
	 * 准备实体分布事务队列模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEDTSQueues() throws Exception {
	}

	/**
	 * 准备实体用户角色
	 * 
	 * @throws Exception
	 */
	protected void prepareDEUserRoles() throws Exception {
	}
	
	/**
	 * 准备实体操作标识绑定角色
	 * 
	 * @throws Exception
	 */
	protected void prepareDEOPPrivRoles() throws Exception {
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#createEntity()
	 */
	@Override
	public ArrayList<ET> createEntityList() {
		return new ArrayList<ET>();
	}

	/**
	 * 建立属性对象
	 * 
	 * @param strDEFName
	 * @return
	 * @throws Exception
	 */
	protected IDEField createDEField(String strDEFName) throws Exception {
		return null;
	}

	/**
	 * 建立属性搜索项
	 * 
	 * @param iDEField
	 * @param strDEFSearchModeName
	 * @return
	 * @throws Exception
	 */
	protected IDEFSearchMode createDEFSearchMode(IDEField iDEField, String strDEFSearchModeName) throws Exception {
		return null;
	}

	/**
	 * 准备实体属性模型
	 * 
	 * @throws Exception
	 */
	protected void prepareDEFields() throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEField(net.ibizsys.paas.core.IDEField)
	 */
	@Override
	public void registerDEField(IDEField iDEField) {
		deFieldList.add(iDEField);
		deFieldMap.put(iDEField.getId(), iDEField);
		deFieldMap.put(iDEField.getName(), iDEField);

		if (keyDEField == null && iDEField.isKeyDEField()) {
			keyDEField = iDEField;
		}
		
		if (uniTagDEField == null && iDEField.isUniTagField()) {
			uniTagDEField = iDEField;
		}

		if (majorDEField == null && iDEField.isMajorDEField()) {
			majorDEField = iDEField;
		}

		if (logicValidDEField == null && StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_LOGICVALID, true) == 0) {
			logicValidDEField = iDEField;
		}

		if (orgIdDEField == null && StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGID, true) == 0) {
			orgIdDEField = iDEField;
		}

		if (!StringHelper.isNullOrEmpty(iDEField.getPreDefinedType())) {
			pdtDEFieldMap.put(iDEField.getPreDefinedType(), iDEField);
		}

		if (!StringHelper.isNullOrEmpty(iDEField.getUnionKeyValue())) {
			this.unionKeyValueFieldMap.put(iDEField.getUnionKeyValue(), iDEField);
		}

		if (iDEField.isMultiFormDEField()) {
			multiFormDEField = iDEField;
		}

		if (iDEField.isIndexTypeDEField()) {
			indexTypeDEField = iDEField;
		}
		
		if(iDEField.getDEFType() == IDEField.DEFTYPE_DYNASTORAGE){
			bHasDynaStorageField = true;
		}

		java.util.Iterator<IDEFSearchMode> defSearchModes = iDEField.getDEFSearchModes();
		if (defSearchModes != null) {
			while (defSearchModes.hasNext()) {
				IDEFSearchMode iDEFSearchMode = defSearchModes.next();
				defSearchModeMap.put(iDEFSearchMode.getName().toLowerCase(), iDEFSearchMode);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEField(java.lang.String, boolean)
	 */
	@Override
	public IDEField getDEField(String strName, boolean bTry) throws Exception {

		IDEField deField = deFieldMap.get(strName);
		if (deField == null) {
			deField = deFieldMap.get(strName.toUpperCase());
			if (deField == null) {
				if (!bTry) {
					throw new Exception(StringHelper.format("无法获取属性[%1$s]", strName));
				}
			}
		}
		return deField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEFields()
	 */
	@Override
	public java.util.Iterator<IDEField> getDEFields() {
		return this.deFieldList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEDataQuery(net.ibizsys.paas.core.IDEDataQuery)
	 */
	@Override
	public void registerDEDataQuery(IDEDataQuery iDEDataQuery) {
		String strId = iDEDataQuery.getId();
		String strName = iDEDataQuery.getName();

		deDataQueryMap.put(strId, iDEDataQuery);
		deDataQueryMap.put(strName, iDEDataQuery);
		deDataQueryMap.put(strName.toUpperCase(), iDEDataQuery);

		this.deDataQueryList.add(iDEDataQuery);
		
		if (iDEDataQuery.isDefaultMode()) {
			this.defaultDEDataQuery = iDEDataQuery;
		}
		else{
			if(this.defaultDEDataQuery == null){
				if(StringHelper.compare(strName, "DEFAULT", false)==0){
					this.defaultDEDataQuery = iDEDataQuery;
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEDataSet(net.ibizsys.paas.core.IDEDataSet)
	 */
	@Override
	public void registerDEDataSet(IDEDataSet iDEDataSet) {
		String strId = iDEDataSet.getId();
		String strName = iDEDataSet.getName();

		deDataSetModelMap.put(strId, iDEDataSet);
		deDataSetModelMap.put(strName, iDEDataSet);
	//	deDataSetModelMap.put(strId.toUpperCase(), iDEDataSet);
		deDataSetModelMap.put(strName.toUpperCase(), iDEDataSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEAction(net.ibizsys.paas.core.IDEAction)
	 */
	@Override
	public void registerDEAction(IDEAction iDEAction) {
		deActionMap.put(iDEAction.getId(), iDEAction);
		deActionMap.put(iDEAction.getName(), iDEAction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEACMode(net.ibizsys.paas.core.IDEACMode)
	 */
	@Override
	public void registerDEACMode(IDEACMode iDEACMode) {
		deACModeMap.put(iDEACMode.getId(), iDEACMode);
		deACModeMap.put(iDEACMode.getName(), iDEACMode);

		if (iDEACMode.isDefaultMode()) defaultDEACMode = iDEACMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDELogic(net.ibizsys.paas.core.IDELogic)
	 */
	@Override
	public void registerDELogic(IDELogic iDELogic) {
		deLogicMap.put(iDELogic.getId(), iDELogic);
		deLogicMap.put(iDELogic.getName(), iDELogic);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEUIAction(net.ibizsys.paas.core.IDEUIAction)
	 */
	@Override
	public void registerDEUIAction(IDEUIAction iDEUIAction) {
		deUIActionMap.put(iDEUIAction.getId(), iDEUIAction);
		deUIActionMap.put(iDEUIAction.getName(), iDEUIAction);
		if(iDEUIAction.isGlobalUIAction()){
			if(iDEUIAction instanceof IDEUIActionModel){
				try {
					this.getSystemModel().registerDEUIActionModel((IDEUIActionModel)iDEUIAction);
				} catch (Exception ex) {
					log.error(StringHelper.format("注册系统全局实体界面行为对象发生异常，%1$s",ex.getMessage()),ex);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEDataExport(net.ibizsys.paas.core.IDEDataExport)
	 */
	@Override
	public void registerDEDataExport(IDEDataExport iDEDataExport) {
		deDataExportMap.put(iDEDataExport.getId(), iDEDataExport);
		deDataExportMap.put(iDEDataExport.getName(), iDEDataExport);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEDataImport(net.ibizsys.paas.core.IDEDataImport)
	 */
	@Override
	public void registerDEDataImport(IDEDataImport iDEDataImport) {
		deDataImportMap.put(iDEDataImport.getId(), iDEDataImport);
		deDataImportMap.put(iDEDataImport.getName(), iDEDataImport);
		if(iDEDataImport.isDefault()){
			this.defaultDEDataImport = iDEDataImport;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEWF(net.ibizsys.paas.core.IDEWF)
	 */
	@Override
	public void registerDEWF(IDEWF iDEWF) {
		deWFMap.put(iDEWF.getId(), iDEWF);
		deWFMap.put(iDEWF.getWorkflowId(), iDEWF);
		if (defaultDEWF == null) {
			this.defaultDEWF = iDEWF;
		}

		deWFList.add(iDEWF);
	}
	
	/**
	 * 重置实体工作流
	 */
	public void resetDEWFs() {
		deWFMap.clear();
		defaultDEWF = null;
		deWFList.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEMainState(net.ibizsys.paas.core.IDEMainState)
	 */
	@Override
	public void registerDEMainState(IDEMainState iDEMainState) {
		if (!StringHelper.isNullOrEmpty(iDEMainState.getId())) deMainStateMap.put(iDEMainState.getId(), iDEMainState);
		if (!StringHelper.isNullOrEmpty(iDEMainState.getMSTag())) deMainStateMap.put(iDEMainState.getMSTag(), iDEMainState);
		if (iDEMainState.isDefault()) {
			this.defaultDEMainState = iDEMainState;
		}
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEUniState(net.ibizsys.paas.core.IDEUniState)
	 */
	@Override
	public void registerDEUniState(IDEUniState iDEUniState) {
		if (!StringHelper.isNullOrEmpty(iDEUniState.getId())) deUniStateMap.put(iDEUniState.getId(), iDEUniState);
		if (iDEUniState.isDefault()) {
			this.defaultDEUniState = iDEUniState;
		}
	}
	
	
	@Override
	public IDEUniState getDEUniState(String strDEUniStateId) throws Exception {
		IDEUniState iDEUniState = deUniStateMap.get(strDEUniStateId);
		if (iDEUniState == null) {
			throw new Exception(StringHelper.format("无法获取统一状态对象[%1$s]", strDEUniStateId));
		}

		return iDEUniState;
	}

	@Override
	public Iterator<IDEUniState> getDEUniStates() {
		if (this.deUniStateMap.size() == 0) return null;
		return this.deUniStateMap.values().iterator();
	}
	
	

	@Override
	public IDEUniState getDefaultDEUniState() {
		return this.defaultDEUniState;
	}

	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEDataSet(java.lang.String, boolean)
	 */
	@Override
	public IDEDataSet getDEDataSet(String strName, boolean bTry) throws Exception {
		IDEDataSet iDEDataSet = deDataSetModelMap.get(strName);
		if (iDEDataSet == null) {
			if (!bTry) {
				throw new Exception(StringHelper.format("无法获取数据集合[%1$s]", strName));
			}
		}

		return iDEDataSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getSystem()
	 */
	@Override
	public ISystem getSystem() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getKeyDEField()
	 */
	@Override
	public IDEField getKeyDEField() {
		return this.keyDEField;
	}

	
	
	
	@Override
	public IDEField getUniTagDEField() {
		if(this.uniTagDEField!=null)
			return this.uniTagDEField;
		if(getKeyDEField()!=null && DataTypeHelper.isStringDataType(getKeyDEField().getStdDataType())){
			return getKeyDEField();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getMajorDEField()
	 */
	@Override
	public IDEField getMajorDEField() {
		return this.majorDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getTableName()
	 */
	@Override
	public String getTableName() {
		return this.strTableName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getUserTable()
	 */
	@Override
	public String getUserTable() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getViewName()
	 */
	@Override
	public String getViewName() {
		return this.strViewName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDER(boolean, java.lang.String)
	 */
	@Override
	public IDERBase getDER(boolean bMajor, String strDERId) throws Exception {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDERs(boolean)
	 */
	@Override
	public Iterator<IDERBase> getDERs(boolean bMajor) {
		return ((ISystemModel) this.getSystem()).getDERs(this.getId(), bMajor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEDataSet(java.lang.String)
	 */
	@Override
	public IDEDataSet getDEDataSet(String strDEDataSetId) throws Exception {
		return this.getDEDataSet(strDEDataSetId, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getLogicName()
	 */
	@Override
	public String getLogicName() {
		return this.strLogicName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getLogicName(java.lang.String)
	 */
	@Override
	public String getLogicName(String strLocalization) {
		return this.getLogicName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEAction(java.lang.String)
	 */
	@Override
	public IDEAction getDEAction(String strDEActionId) throws Exception {
		IDEAction iDEAction = deActionMap.get(strDEActionId);
		if (iDEAction == null) {
			throw new Exception(StringHelper.format("无法获取实体操作[%1$s]", strDEActionId));
		}

		return iDEAction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEUIAction(java.lang.String)
	 */
	@Override
	public IDEUIAction getDEUIAction(String strDEUIActionId) throws Exception {
		IDEUIAction iDEUIAction = deUIActionMap.get(strDEUIActionId);
		if (iDEUIAction == null && strDEUIActionId.indexOf("@")!=-1) {
			String strNewId = strDEUIActionId.split("[@]")[0];
			iDEUIAction = deUIActionMap.get(strNewId);
		}
		if (iDEUIAction == null) {
			iDEUIAction = this.getSystemModel().getDEUIActionModel(strDEUIActionId, true);
		}
		if (iDEUIAction == null) {
			throw new Exception(StringHelper.format("无法获取实体界面行为[%1$s]", strDEUIActionId));
		}

		return iDEUIAction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDELogic(java.lang.String)
	 */
	@Override
	public IDELogic getDELogic(String strDELogicId) throws Exception {
		IDELogic iDELogic = deLogicMap.get(strDELogicId);
		if (iDELogic == null) {
			throw new Exception(StringHelper.format("无法获取实体逻辑[%1$s]", strDELogicId));
		}
		return iDELogic;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEWF(java.lang.String)
	 */
	@Override
	public IDEWF getDEWF(String strDEWFId) throws Exception {
		IDEWF iDEWF = deWFMap.get(strDEWFId);
		if (iDEWF == null) {
			throw new Exception(StringHelper.format("无法获取实体工作流[%1$s]", strDEWFId));
		}

		return iDEWF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#createDataObject()
	 */
	@Override
	public IDataObject createDataObject() throws Exception {
		return this.createEntity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEACMode(java.lang.String)
	 */
	@Override
	public IDEACMode getDEACMode(String strACModeName) throws Exception {
		IDEACMode iDEACMode = deACModeMap.get(strACModeName);
		if (iDEACMode == null) {
			throw new Exception(StringHelper.format("无法获取自填模式[%1$s]", strACModeName));
		}
		return iDEACMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDefaultDEACMode()
	 */
	@Override
	public IDEACMode getDefaultDEACMode() throws Exception {
		return defaultDEACMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEDataQuery(java.lang.String)
	 */
	@Override
	public IDEDataQuery getDEDataQuery(String strDEDataQueryId) throws Exception {
		IDEDataQuery iDEDataQuery = deDataQueryMap.get(strDEDataQueryId);
		if (iDEDataQuery == null) {
			throw new Exception(StringHelper.format("无法获取查询模型[%1$s]", strDEDataQueryId));
		}
		return iDEDataQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEDataImport(java.lang.String)
	 */
	@Override
	public IDEDataImport getDEDataImport(String strDEDataImportId) throws Exception {
		IDEDataImport iDEDataImport = deDataImportMap.get(strDEDataImportId);
		if (iDEDataImport == null) {
			throw new Exception(StringHelper.format("无法获取实体数据导入[%1$s]", strDEDataImportId));
		}

		return iDEDataImport;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEDataExport(java.lang.String)
	 */
	@Override
	public IDEDataExport getDEDataExport(String strDEDataExportId) throws Exception {
		IDEDataExport iDEDataExport = deDataExportMap.get(strDEDataExportId);
		if (iDEDataExport == null) {
			throw new Exception(StringHelper.format("无法获取实体数据导出[%1$s]", strDEDataExportId));
		}

		return iDEDataExport;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getGetSqlCommandModel(net.ibizsys.paas.db.IDBDialect)
	 */
	@Override
	public ISqlCommandModel getGetSqlCommandModel(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
		return getGetSqlCommandModel(iDBDialect,IDataEntity.VIEWLEVEL_DEFAULT,bTempMode);
	}
	
	
	@Override
	public ISqlCommandModel getGetSqlCommandModel(IDBDialect iDBDialect, int nViewLevel, boolean bTempMode) throws Exception {
		if (this.isNoViewMode()) {
			throw new Exception("无视图模式不支持当前操作");
		}

		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}		
		
		SqlCommandModel sqlCommandModel = new SqlCommandModel();
		sqlCommandModel.setDataEntityModel(this);
		sqlCommandModel.setDBDialect(iDBDialect);

		StringBuilderEx sql = new StringBuilderEx();
		ProcParamList procParamList = new ProcParamList();

		if (this.getKeyDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null || bTempMode) {
			if (bTempMode) {
				sql.append("SELECT m1.* FROM %1$s m1 WHERE m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName() + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
			} else {
				sql.append("SELECT m1.* FROM %1$s m1 WHERE m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
				if (this.isLogicValid()) {
					Object objInvalidValue = this.getLogicValidValue(true);
					String strInvalidValue = "";
					if (objInvalidValue instanceof String) {
						strInvalidValue = StringHelper.format("'%1$s'", objInvalidValue);
					} else {
						strInvalidValue = StringHelper.format("%1$s", objInvalidValue);
					}
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
			java.util.Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
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
				if (objInvalidValue instanceof String) {
					strInvalidValue = StringHelper.format("'%1$s'", objInvalidValue);
				} else {
					strInvalidValue = StringHelper.format("%1$s", objInvalidValue);
				}
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
			throw new Exception("无视图模式不支持当前操作");
		}
		
		if (this.getUniTagDEField() == null) {
			throw new Exception("当前实体没有定义唯一业务标识属性");
		}


		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}	
		
		SqlCommandModel sqlCommandModel = new SqlCommandModel();
		sqlCommandModel.setDataEntityModel(this);
		sqlCommandModel.setDBDialect(iDBDialect);

		StringBuilderEx sql = new StringBuilderEx();
		ProcParamList procParamList = new ProcParamList();

		if (this.getUniTagDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null || bTempMode) {
			if (bTempMode) {
				sql.append("SELECT m1.* FROM %1$s m1 WHERE m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName() + "_TMP"), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getName()));
			} else {
				sql.append("SELECT m1.* FROM %1$s m1 WHERE m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getName()));
				if (this.isLogicValid()) {
					Object objInvalidValue = this.getLogicValidValue(true);
					String strInvalidValue = "";
					if (objInvalidValue instanceof String) {
						strInvalidValue = StringHelper.format("'%1$s'", objInvalidValue);
					} else {
						strInvalidValue = StringHelper.format("%1$s", objInvalidValue);
					}
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
			java.util.Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
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
				if (objInvalidValue instanceof String) {
					strInvalidValue = StringHelper.format("'%1$s'", objInvalidValue);
				} else {
					strInvalidValue = StringHelper.format("%1$s", objInvalidValue);
				}
				sql.append(" AND m1.%1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getName()), strInvalidValue);
			}
		}

		sqlCommandModel.setSql(sql.toString());
		sqlCommandModel.setProcParamList(procParamList);
		return sqlCommandModel;
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getGetSqlCommandModel(net.ibizsys.paas.db.IDBDialect)
	 */
	@Override
	public ISqlCommandModel getCheckKeySqlCommandModel(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
		
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}
		
		
		SqlCommandModel sqlCommandModel = new SqlCommandModel();
		sqlCommandModel.setDataEntityModel(this);
		sqlCommandModel.setDBDialect(iDBDialect);

		StringBuilderEx sql = new StringBuilderEx();
		ProcParamList procParamList = new ProcParamList();

		if (this.getKeyDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null) {
			if (bTempMode) {
				sql.append("select m1.%2$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName() + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
			} else {
				sql.append("select m1.%2$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
			}

			ProcParam procParam = new ProcParam();
			procParam.setDataType(this.getKeyDEField().getStdDataType());
			procParam.setParamName(StringHelper.format("VAR_%1$s", this.getKeyDEField().getName().toUpperCase()));
			procParamList.add(procParam);

		} else {
			if (bTempMode) {
				sql.append("select m1.%2$s from %1$s m1 ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName() + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
			} else {
				sql.append("select m1.%2$s from %1$s m1 ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
			}
			boolean bFirst = true;
			java.util.Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
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
		
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}
		
		if (this.getUniTagDEField() == null) {
			throw new Exception("当前实体没有定义唯一业务标识属性");
		}
		
		
		SqlCommandModel sqlCommandModel = new SqlCommandModel();
		sqlCommandModel.setDataEntityModel(this);
		sqlCommandModel.setDBDialect(iDBDialect);

		StringBuilderEx sql = new StringBuilderEx();
		ProcParamList procParamList = new ProcParamList();

		if (this.getUniTagDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null) {
			
			if(this.getKeyDEField().isPhisicalDEField()){
				if (bTempMode) {
					sql.append("select m1.%3$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName() + "_TMP")
							,iDBDialect.getDBObjStandardName(this.getUniTagDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName())
							,iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				} else {
					sql.append("select m1.%3$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName())
							,iDBDialect.getDBObjStandardName(this.getUniTagDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName())
							,iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
			}
			else{
				if (bTempMode) {
					sql.append("select m1.%3$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName() + "_TMP"), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getName()),iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
				} else {
					sql.append("select m1.%3$s from %1$s m1 where m1.%2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName()), iDBDialect.getDBObjStandardName(this.getUniTagDEField().getName()),iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
				}
			}
			

			ProcParam procParam = new ProcParam();
			procParam.setDataType(this.getUniTagDEField().getStdDataType());
			procParam.setParamName(StringHelper.format("VAR_%1$s", this.getUniTagDEField().getName().toUpperCase()));
			procParamList.add(procParam);

		} else {
			if (bTempMode) {
				sql.append("select m1.%2$s from %1$s m1 ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName() + "_TMP")
						,iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
			} else {
				sql.append("select m1.%2$s from %1$s m1 ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName())
						,iDBDialect.getDBObjStandardName(this.getKeyDEField().getName()));
			}
			boolean bFirst = true;
			java.util.Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
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
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getCreateSqlCommandModel(net.ibizsys.paas.db.IDBDialect, net.ibizsys.paas.entity.IEntity, boolean)
	 */
	@Override
	public ISqlCommandModel getCreateSqlCommandModel(IDBDialect iDBDialect, IEntity iEntity, boolean bTempMode) throws Exception {
	
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}
		
		SqlCommandModel createCommandModel = new SqlCommandModel();
		createCommandModel.setDataEntityModel(this);
		createCommandModel.setDBDialect(iDBDialect);

		HashMap<String, Object> insertFieldMap = new HashMap<String, Object>();

		if (bTempMode) {
			if (true) {
				ProcParam procParam = new ProcParam();
				procParam.setDataType(this.getKeyDEField().getStdDataType());
				procParam.setParamName(StringHelper.format("VAR_%1$s", "SRFORIKEY"));
				insertFieldMap.put("SRFORIKEY", procParam);
			}

			if (true) {
				ProcParam procParam = new ProcParam();
				procParam.setDataType(DataTypes.INT);
				procParam.setParamName(IProcParam.TAG_DRAFTFLAG);
				procParam.setValue(1);
				insertFieldMap.put(ServiceBase.DRAFTFLAG, procParam);
			}
		}

		java.util.Iterator<IDEField> deFields = this.getDEFields();
		while (deFields.hasNext()) {
			IDEField iDEField = deFields.next();

			// 是否为动态存储属性
			if (iDEField.isDynaStorageDEField()) continue;
			
			// 判断插入
			if (!iDEField.isPhisicalDEField()) continue;

			// 继承属性
			if (iDEField.isInheritDEField()) continue;

			// 公式属性
			if (iDEField.isFormulaDEField()) continue;

			// 属性不支持临时临时数据
			if (bTempMode && !iDEField.isEnableTempData()) continue;

			if (StringHelper.isNullOrEmpty(iDEField.getPreDefinedType()) || bTempMode) {
				
				if(iDEField.isEnableDBValueInsertUpdateMode() && !StringHelper.isNullOrEmpty(iDEField.getDBValueInsertMode())){
					//忽略插入
					if(StringHelper.compare(iDEField.getDBValueInsertMode(),IDEField.DBVALUEMODE_IGNORE,true)==0){
						continue;
					}	
				}
				
				
				if(iEntity!=null){
					if(iEntity.contains(iDEField.getName())){
						if(iDEField.isKeyDEField() && !bTempMode && iEntity.get(iDEField.getName()) == null){
							String strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, true, bTempMode); 
							if(!StringHelper.isNullOrEmpty(strDirectCode)){
								insertFieldMap.put(iDEField.getName(), strDirectCode);
								continue;
							}
						}
						else{
							ProcParam procParam = new ProcParam();
							procParam.setDataType(iDEField.getStdDataType());
							procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
							insertFieldMap.put(iDEField.getName(), procParam);
						}
					}
					else{
						String strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, true, bTempMode); 
						if(!StringHelper.isNullOrEmpty(strDirectCode)){
							insertFieldMap.put(iDEField.getName(), strDirectCode);
							continue;
						}
					}
				}
				else{
					String strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, true, bTempMode); 
					if(!StringHelper.isNullOrEmpty(strDirectCode)){
						insertFieldMap.put(iDEField.getName(), strDirectCode);
						continue;
					}
					if(strDirectCode == null){
						ProcParam procParam = new ProcParam();
						procParam.setDataType(iDEField.getStdDataType());
						procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
						insertFieldMap.put(iDEField.getName(), procParam);
					}
				}
			} else {
				if ((StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_CREATEDATE, true) == 0) || (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEDATE, true) == 0)) {
					// String strDirectCode = iDBDialect.getFuncSQL(IDBDialect.FUNC_CURDATETIME,true,new String[]{ iDEField.getName()});
					// insertFieldMap.put(iDEField.getName(), strDirectCode);
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					procParam.setParamName(IProcParam.TAG_CURTIME);
					insertFieldMap.put(iDEField.getName(), procParam);
					continue;
				}

				if ((StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_CREATEMAN, true) == 0) || (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEMAN, true) == 0)) {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					if(SysModelGlobal.isUseLoginNameAsOperator()) {
						procParam.setParamName(IProcParam.TAG_LOGINNAME);
					}
					else {
						procParam.setParamName(IProcParam.TAG_PERSONID);
					}
					
					insertFieldMap.put(iDEField.getName(), procParam);
					continue;
				}
				
				if ((StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_CREATEMANNAME, true) == 0) || (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEMANNAME, true) == 0)) {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					procParam.setParamName(IProcParam.TAG_PERSONNAME);
					insertFieldMap.put(iDEField.getName(), procParam);
					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_LOGICVALID, true) == 0) {
					Object objValidValue = this.getLogicValidValue(true);
					String strValidValue = "";
					if (objValidValue instanceof String) {
						strValidValue = StringHelper.format("'%1$s'", objValidValue);
					} else {
						strValidValue = StringHelper.format("%1$s", objValidValue);
					}
					insertFieldMap.put(iDEField.getName(), strValidValue);
					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGID, true) == 0) {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					procParam.setParamName(IProcParam.TAG_ORGID);
					insertFieldMap.put(iDEField.getName(), procParam);
					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGNAME, true) == 0) {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					procParam.setParamName(IProcParam.TAG_ORGNAME);
					insertFieldMap.put(iDEField.getName(), procParam);
					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGSECTORID, true) == 0) {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					procParam.setParamName(IProcParam.TAG_ORGSECTORID);
					insertFieldMap.put(iDEField.getName(), procParam);
					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGSECTORNAME, true) == 0) {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					procParam.setParamName(IProcParam.TAG_ORGSECTORNAME);
					insertFieldMap.put(iDEField.getName(), procParam);
					continue;
				}

			}
		}

		if (this.isLogicValid() && bTempMode) {
			Object objValidValue = this.getLogicValidValue(true);
			String strValidValue = "";
			if (objValidValue instanceof String) {
				strValidValue = StringHelper.format("'%1$s'", objValidValue);
			} else {
				strValidValue = StringHelper.format("%1$s", objValidValue);
			}
			insertFieldMap.put(this.getLogicValidDEField().getName(), strValidValue);
		}

		ProcParamList procParamList = new ProcParamList();

		StringBuilderEx sql = new StringBuilderEx();
		if (bTempMode) {
			sql.append("INSERT INTO %1$s (", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName() + "_TMP"));
		} else {
			sql.append("INSERT INTO %1$s (", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()));
		}

		boolean bFirst = true;
		if(iDBDialect.getDBType().indexOf(IDBDialect.DBTYPE_ORACLE) == 0){
			//重新排序
			HashMap<String, Object> insertFieldNormalMap = new HashMap<String, Object>();
			HashMap<String, Object> insertFieldClobMap = new HashMap<String, Object>();
			for ( String strField : insertFieldMap.keySet()) {
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null || !DataTypeHelper.isLongStringType(iDEField.getStdDataType())){
					insertFieldNormalMap.put(strField, insertFieldMap.get(strField));
				}
				else{
					insertFieldClobMap.put(strField, insertFieldMap.get(strField));
				}
			}
			
			for (String strField : insertFieldNormalMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
			}
			for (String strField : insertFieldClobMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
			}
			sql.append(")VALUES(");
			bFirst = true;
			for (String strField : insertFieldNormalMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
	
				Object objValue = insertFieldNormalMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append("?");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
			for (String strField : insertFieldClobMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
	
				Object objValue = insertFieldClobMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append("?");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
		}
		else{
			for (String strField : insertFieldMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
			}
			sql.append(")VALUES(");
			bFirst = true;
			for (String strField : insertFieldMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
	
				Object objValue = insertFieldMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append("?");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
		}
		
		
		sql.append(")");
		createCommandModel.setSql(sql.toString());
		createCommandModel.setProcParamList(procParamList);
		return createCommandModel;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getCreateSqlCommandModel(net.ibizsys.paas.db.IDBDialect, boolean)
	 */
	@Override
	public ISqlCommandModel getCreateSqlCommandModel(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
		return this.getCreateSqlCommandModel(iDBDialect, null, bTempMode);
	}
	
	
	

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getUpdateSqlCommandModel(net.ibizsys.paas.db.IDBDialect, net.ibizsys.paas.entity.IEntity, boolean)
	 */
	@Override
	public ISqlCommandModel getUpdateSqlCommandModel(IDBDialect iDBDialect, IEntity iEntity, boolean bTempMode) throws Exception {
		
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}
		
		
		SqlCommandModel updateCommandModel = new SqlCommandModel();
		updateCommandModel.setDataEntityModel(this);
		updateCommandModel.setDBDialect(iDBDialect);

		HashMap<String, Object> updateFieldMap = new HashMap<String, Object>();

		if (bTempMode) {
			if (iEntity.contains("SRFORIKEY")) {
				if (iEntity.get("SRFORIKEY") == null) {
					updateFieldMap.put("SRFORIKEY", "NULL");
				} else {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(this.getKeyDEField().getStdDataType());
					procParam.setParamName(StringHelper.format("VAR_%1$s", "SRFORIKEY"));
					updateFieldMap.put("SRFORIKEY", procParam);
				}
			}

			if (true) {
				ProcParam procParam = new ProcParam();
				procParam.setDataType(DataTypes.INT);
				procParam.setParamName(IProcParam.TAG_DRAFTFLAG);
				// procParam.setParamName(StringHelper.format("VAR_%1$s",ServiceBase.DRAFTFLAG));
				procParam.setValue(0);
				updateFieldMap.put(ServiceBase.DRAFTFLAG, procParam);
			}
		}

		java.util.Iterator<IDEField> deFields = this.getDEFields();
		while (deFields.hasNext()) {
			IDEField iDEField = deFields.next();
			if (iDEField.isKeyDEField()) continue;

			if (!this.getKeyDEField().isPhisicalDEField()) {
				if (!StringHelper.isNullOrEmpty(iDEField.getUnionKeyValue())) continue;
			}

			// 是否为动态存储属性
			if (iDEField.isDynaStorageDEField()) continue;
			
			// 判断插入
			if (!iDEField.isPhisicalDEField()) continue;

			// 继承属性
			if (iDEField.isInheritDEField()) continue;

			// 公式属性
			if (iDEField.isFormulaDEField()) continue;

			// 属性不支持临时临时数据
			if (bTempMode && !iDEField.isEnableTempData()) continue;

			if (StringHelper.isNullOrEmpty(iDEField.getPreDefinedType())) {
				
				if(iDEField.isEnableDBValueInsertUpdateMode() && !StringHelper.isNullOrEmpty(iDEField.getDBValueUpdateMode())){
					//忽略更新
					if(StringHelper.compare(iDEField.getDBValueUpdateMode(),IDEField.DBVALUEMODE_IGNORE,true)==0){
						continue;
					}	
				}
				
				if(iEntity.contains(iDEField.getName())){
					if (iEntity.get(iDEField.getName()) == null) {
						updateFieldMap.put(iDEField.getName(), "NULL");
					} else {
						ProcParam procParam = new ProcParam();
						procParam.setDataType(iDEField.getStdDataType());
						procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
						updateFieldMap.put(iDEField.getName(), procParam);
					}
				}
				else{
					String strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, false, bTempMode); 
					if(!StringHelper.isNullOrEmpty(strDirectCode)){
						updateFieldMap.put(iDEField.getName(), strDirectCode);
						continue;
					}
				}
//				
//				
//				if (!iEntity.contains(iDEField.getName())) {
//					if (!StringHelper.isNullOrEmpty(iDEField.getDBValueFunc())) {
//						String strDirectCode = iDBDialect.getFuncSQL(iDEField.getDBValueFunc(), false, new String[] { iDEField.getName() });
//						updateFieldMap.put(iDEField.getName(), strDirectCode);
//					}
//					continue;
//				}
//
//				
			} else {
				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEDATE, true) == 0) {
					// String strDirectCode = iDBDialect.getFuncSQL(IDBDialect.FUNC_CURDATETIME,false,new String[]{ iDEField.getName()});
					// updateFieldMap.put(iDEField.getName(), strDirectCode);

					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					procParam.setParamName(IProcParam.TAG_CURTIME);
					updateFieldMap.put(iDEField.getName(), procParam);

					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEMAN, true) == 0) {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					if(SysModelGlobal.isUseLoginNameAsOperator()) {
						procParam.setParamName(IProcParam.TAG_LOGINNAME);
					}
					else {
						procParam.setParamName(IProcParam.TAG_PERSONID);
					}
					updateFieldMap.put(iDEField.getName(), procParam);
					continue;
				}
				
				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_UPDATEMANNAME, true) == 0) {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(iDEField.getStdDataType());
					procParam.setParamName(IProcParam.TAG_PERSONNAME);
					updateFieldMap.put(iDEField.getName(), procParam);
					continue;
				}
				

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGID, true) == 0) {
					if (iEntity.get(IProcParam.TAG_ORGID) != null || iEntity.get(iDEField.getName()) != null) {
						ProcParam procParam = new ProcParam();
						procParam.setDataType(iDEField.getStdDataType());
						procParam.setParamName(IProcParam.TAG_ORGID);
						updateFieldMap.put(iDEField.getName(), procParam);
					}
					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGNAME, true) == 0) {
					if (iEntity.get(IProcParam.TAG_ORGNAME) != null || iEntity.get(iDEField.getName()) != null) {
						ProcParam procParam = new ProcParam();
						procParam.setDataType(iDEField.getStdDataType());
						procParam.setParamName(IProcParam.TAG_ORGNAME);
						updateFieldMap.put(iDEField.getName(), procParam);
					}
					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGSECTORID, true) == 0) {
					if (iEntity.get(IProcParam.TAG_ORGSECTORID) != null || iEntity.get(iDEField.getName()) != null) {
						ProcParam procParam = new ProcParam();
						procParam.setDataType(iDEField.getStdDataType());
						procParam.setParamName(IProcParam.TAG_ORGSECTORID);
						updateFieldMap.put(iDEField.getName(), procParam);
					}

					continue;
				}

				if (StringHelper.compare(iDEField.getPreDefinedType(), IDEField.PREDEFINEDTYPE_ORGSECTORNAME, true) == 0) {
					if (iEntity.get(IProcParam.TAG_ORGSECTORNAME) != null || iEntity.get(iDEField.getName()) != null) {
						ProcParam procParam = new ProcParam();
						procParam.setDataType(iDEField.getStdDataType());
						procParam.setParamName(IProcParam.TAG_ORGSECTORNAME);
						updateFieldMap.put(iDEField.getName(), procParam);
					}

					continue;
				}

				continue;
			}
		}

		ProcParamList procParamList = new ProcParamList();

		StringBuilderEx sql = new StringBuilderEx();
		if (!bTempMode) {
			sql.append("UPDATE %1$s SET ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()));
		} else {
			sql.append("UPDATE %1$s SET ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName() + "_TMP"));
		}
		boolean bFirst = true;
		if(iDBDialect.getDBType().indexOf(IDBDialect.DBTYPE_ORACLE) == 0){
			//重新排序
			HashMap<String, Object> updateFieldNormalMap = new HashMap<String, Object>();
			HashMap<String, Object> updateFieldClobMap = new HashMap<String, Object>();
			for ( String strField : updateFieldMap.keySet()) {
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null || !DataTypeHelper.isLongStringType(iDEField.getStdDataType())){
					updateFieldNormalMap.put(strField, updateFieldMap.get(strField));
				}
				else{
					updateFieldClobMap.put(strField, updateFieldMap.get(strField));
				}
			}
			for (String strField : updateFieldNormalMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
				sql.append(" = ");
				Object objValue = updateFieldNormalMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append(" ? ");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
			for (String strField : updateFieldClobMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
				sql.append(" = ");
				Object objValue = updateFieldClobMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append(" ? ");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
		}
		else{
			for (String strField : updateFieldMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
				sql.append(" = ");
				Object objValue = updateFieldMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append(" ? ");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
		}
		
		// 输出主键
		if (this.getKeyDEField().isPhisicalDEField() ||  (this.getUniTagDEField()!=null && this.getUniTagDEField().isPhisicalDEField()) || this.getUnionKeyValueDEFields() == null) {
			
			if((!this.getKeyDEField().isPhisicalDEField()|| (iEntity.get(this.getKeyDEField().getName()) == null))
					&& (this.getUniTagDEField()!=null && this.getUniTagDEField().isPhisicalDEField() && (iEntity.get(this.getUniTagDEField().getName()) != null))){
				if (this.isLogicValid() && !bTempMode) {
					Object objValidValue = this.getLogicValidValue(true);
					String strValidValue = "";
					if (objValidValue instanceof String) {
						strValidValue = StringHelper.format("'%1$s'", objValidValue);
					} else {
						strValidValue = StringHelper.format("%1$s", objValidValue);
					}
					sql.append(" WHERE %1$s = ? AND %2$s=%3$s ", iDBDialect.getDBObjStandardName(this.getUniTagDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
				} else {
					sql.append(" WHERE %1$s = ? ", iDBDialect.getDBObjStandardName(this.getUniTagDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}

				ProcParam procParam = new ProcParam();
				procParam.setDataType(this.getUniTagDEField().getStdDataType());
				procParam.setParamName(StringHelper.format("VAR_%1$s", this.getUniTagDEField().getName().toUpperCase()));
				procParamList.add(procParam);
			}
			else{
				if (this.isLogicValid() && !bTempMode) {
					Object objValidValue = this.getLogicValidValue(true);
					String strValidValue = "";
					if (objValidValue instanceof String) {
						strValidValue = StringHelper.format("'%1$s'", objValidValue);
					} else {
						strValidValue = StringHelper.format("%1$s", objValidValue);
					}
					sql.append(" WHERE %1$s = ? AND %2$s=%3$s ", iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
				} else {
					sql.append(" WHERE %1$s = ? ", iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}

				ProcParam procParam = new ProcParam();
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
				Object objValidValue = this.getLogicValidValue(true);
				String strValidValue = "";
				if (objValidValue instanceof String) {
					strValidValue = StringHelper.format("'%1$s'", objValidValue);
				} else {
					strValidValue = StringHelper.format("%1$s", objValidValue);
				}
				sql.append(" AND %1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
			}
		}

		updateCommandModel.setSql(sql.toString());
		updateCommandModel.setProcParamList(procParamList);
		return updateCommandModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getSysUpdateSqlCommandModel(net.ibizsys.paas.db.IDBDialect, net.ibizsys.paas.entity.IEntity, boolean)
	 */
	@Override
	public ISqlCommandModel getSysUpdateSqlCommandModel(IDBDialect iDBDialect, IEntity iEntity, boolean bTempMode) throws Exception {
		
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}
		
		SqlCommandModel updateCommandModel = new SqlCommandModel();
		updateCommandModel.setDataEntityModel(this);
		updateCommandModel.setDBDialect(iDBDialect);

		HashMap<String, Object> updateFieldMap = new HashMap<String, Object>();

		if (bTempMode) {
			if (iEntity.contains("SRFORIKEY")) {
				if (iEntity.get("SRFORIKEY") == null) {
					updateFieldMap.put("SRFORIKEY", "NULL");
				} else {
					ProcParam procParam = new ProcParam();
					procParam.setDataType(this.getKeyDEField().getStdDataType());
					procParam.setParamName(StringHelper.format("VAR_%1$s", "SRFORIKEY"));
					updateFieldMap.put("SRFORIKEY", procParam);
				}
			}

			if (true) {
				ProcParam procParam = new ProcParam();
				procParam.setDataType(DataTypes.INT);
				procParam.setParamName(IProcParam.TAG_DRAFTFLAG);
				// procParam.setParamName(StringHelper.format("VAR_%1$s",ServiceBase.DRAFTFLAG));
				procParam.setValue(0);
				updateFieldMap.put(ServiceBase.DRAFTFLAG, procParam);
			}
		}

		java.util.Iterator<IDEField> deFields = this.getDEFields();
		while (deFields.hasNext()) {
			IDEField iDEField = deFields.next();
			if (iDEField.isKeyDEField()) continue;

			if (!this.getKeyDEField().isPhisicalDEField()) {
				if (!StringHelper.isNullOrEmpty(iDEField.getUnionKeyValue())) continue;
			}

			// 判断插入
			if (!iDEField.isPhisicalDEField()) continue;

			// 继承属性
			if (iDEField.isInheritDEField()) continue;

			// 公式属性
			if (iDEField.isFormulaDEField()) continue;

			// 属性不支持临时临时数据
			if (bTempMode && !iDEField.isEnableTempData()) continue;

			
			if (StringHelper.isNullOrEmpty(iDEField.getPreDefinedType())) {

				if(iEntity.contains(iDEField.getName())){
					if (iEntity.get(iDEField.getName()) == null) {
						updateFieldMap.put(iDEField.getName(), "NULL");
					} else {
						ProcParam procParam = new ProcParam();
						procParam.setDataType(iDEField.getStdDataType());
						procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
						updateFieldMap.put(iDEField.getName(), procParam);
					}	
				}
				else{
					String strDirectCode = iDBDialect.getDEFieldValueSQL(iDEField, iEntity, false, bTempMode); 
					if(!StringHelper.isNullOrEmpty(strDirectCode)){
						updateFieldMap.put(iDEField.getName(), strDirectCode);
						continue;
					}
				}
				
				
//				if (!iEntity.contains(iDEField.getName())) {
//					if (!StringHelper.isNullOrEmpty(iDEField.getDBValueFunc())) {
//						String strDirectCode = iDBDialect.getFuncSQL(iDEField.getDBValueFunc(), false, new String[] { iDEField.getName() });
//						updateFieldMap.put(iDEField.getName(), strDirectCode);
//					}
//					continue;
//				}

//				if (iEntity.get(iDEField.getName()) == null) {
//					updateFieldMap.put(iDEField.getName(), "NULL");
//				} else {
//					ProcParam procParam = new ProcParam();
//					procParam.setDataType(iDEField.getStdDataType());
//					procParam.setParamName(StringHelper.format("VAR_%1$s", iDEField.getName().toUpperCase()));
//					updateFieldMap.put(iDEField.getName(), procParam);
//				}
			} else {
			}
		}

		ProcParamList procParamList = new ProcParamList();

		StringBuilderEx sql = new StringBuilderEx();
		if (!bTempMode) {
			sql.append("UPDATE %1$s SET ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()));
		} else {
			sql.append("UPDATE %1$s SET ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName() + "_TMP"));
		}

//		boolean bFirst = true;
//
//		for (String strField : updateFieldMap.keySet()) {
//			if (bFirst)
//				bFirst = false;
//			else {
//				sql.append(",");
//			}
//			sql.append(iDBDialect.getDBObjStandardName(strField));
//			sql.append(" = ");
//			Object objValue = updateFieldMap.get(strField);
//			if (objValue instanceof ProcParam) {
//				sql.append(" ? ");
//				procParamList.add((ProcParam) objValue);
//			} else {
//				sql.append((String) objValue);
//			}
//		}
		
		boolean bFirst = true;
		if(iDBDialect.getDBType().indexOf(IDBDialect.DBTYPE_ORACLE) == 0){
			//重新排序
			HashMap<String, Object> updateFieldNormalMap = new HashMap<String, Object>();
			HashMap<String, Object> updateFieldClobMap = new HashMap<String, Object>();
			for ( String strField : updateFieldMap.keySet()) {
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null || !DataTypeHelper.isLongStringType(iDEField.getStdDataType())){
					updateFieldNormalMap.put(strField, updateFieldMap.get(strField));
				}
				else{
					updateFieldClobMap.put(strField, updateFieldMap.get(strField));
				}
			}
			for (String strField : updateFieldNormalMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
				sql.append(" = ");
				Object objValue = updateFieldNormalMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append(" ? ");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
			for (String strField : updateFieldClobMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
				sql.append(" = ");
				Object objValue = updateFieldClobMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append(" ? ");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
		}
		else{
			for (String strField : updateFieldMap.keySet()) {
				if (bFirst)
					bFirst = false;
				else {
					sql.append(",");
				}
				IDEField iDEField = this.getDEField(strField,true);
				if(iDEField==null){
					sql.append(iDBDialect.getDBObjStandardName(strField));
				}
				else{
					sql.append(iDBDialect.getDBObjStandardName(iDEField.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}
				sql.append(" = ");
				Object objValue = updateFieldMap.get(strField);
				if (objValue instanceof ProcParam) {
					sql.append(" ? ");
					procParamList.add((ProcParam) objValue);
				} else {
					sql.append((String) objValue);
				}
			}
		}

		// 输出主键
		if (this.getKeyDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null) {
			if (this.isLogicValid() && !bTempMode) {
				Object objValidValue = this.getLogicValidValue(true);
				String strValidValue = "";
				if (objValidValue instanceof String) {
					strValidValue = StringHelper.format("'%1$s'", objValidValue);
				} else {
					strValidValue = StringHelper.format("%1$s", objValidValue);
				}
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
				Object objValidValue = this.getLogicValidValue(true);
				String strValidValue = "";
				if (objValidValue instanceof String) {
					strValidValue = StringHelper.format("'%1$s'", objValidValue);
				} else {
					strValidValue = StringHelper.format("%1$s", objValidValue);
				}
				sql.append(" AND %1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strValidValue);
			}
		}

		updateCommandModel.setSql(sql.toString());
		updateCommandModel.setProcParamList(procParamList);
		return updateCommandModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getRemoveSqlCommandModel(net.ibizsys.paas.db.IDBDialect)
	 */
	@Override
	public ISqlCommandModel getRemoveSqlCommandModel(IDBDialect iDBDialect, boolean bTempMode) throws Exception {
	
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}
		
		SqlCommandModel sqlCommandModel = new SqlCommandModel();
		sqlCommandModel.setDataEntityModel(this);
		sqlCommandModel.setDBDialect(iDBDialect);

		StringBuilderEx sql = new StringBuilderEx();
		ProcParamList procParamList = new ProcParamList();
		if (this.getKeyDEField().isPhisicalDEField() || this.getUnionKeyValueDEFields() == null || bTempMode) {
			if (bTempMode) {
				sql.append("DELETE FROM %1$s WHERE %2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName() + "_TMP"), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
			} else {
				if (this.isLogicValid()) {
					Object objInvalidValue = this.getLogicValidValue(false);
					String strInvalidValue = "";
					if (objInvalidValue instanceof String) {
						strInvalidValue = StringHelper.format("'%1$s'", objInvalidValue);
					} else {
						strInvalidValue = StringHelper.format("%1$s", objInvalidValue);
					}
					sql.append("UPDATE %1$s SET %3$s=%4$s WHERE %2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strInvalidValue);
				} else {
					sql.append("DELETE FROM %1$s WHERE %2$s = ? ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getKeyDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
				}

			}

			ProcParam procParam = new ProcParam();
			procParam.setDataType(this.getKeyDEField().getStdDataType());
			procParam.setParamName(StringHelper.format("VAR_%1$s", this.getKeyDEField().getName().toUpperCase()));
			procParamList.add(procParam);
		} else {

			if (this.isLogicValid()) {
				Object objInvalidValue = this.getLogicValidValue(false);
				String strInvalidValue = "";
				if (objInvalidValue instanceof String) {
					strInvalidValue = StringHelper.format("'%1$s'", objInvalidValue);
				} else {
					strInvalidValue = StringHelper.format("%1$s", objInvalidValue);
				}
				sql.append("UPDATE %1$s SET %2$s=%3$s  ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()), iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getDEFDTColumn(iDBDialect.getDBType()).getColumnName()), strInvalidValue);
			} else {
				sql.append("DELETE FROM %1$s ", iDBDialect.getDBObjStandardName(iDEDBConfig.getTableName()));
			}

			boolean bFirst = true;
			java.util.Iterator<IDEField> deFields = this.getUnionKeyValueDEFields();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getSelectSqlCommandModelEx(net.ibizsys.paas.db.IDBDialect, net.ibizsys.paas.db.ISelectContext, boolean)
	 */
	@Override
	public ISqlCommandModel getSelectSqlCommandModelEx(IDBDialect iDBDialect, ISelectContext iSelectContext, boolean bTempMode) throws Exception {
		return getSelectSqlCommandModel(iDBDialect, iSelectContext, bTempMode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getGetSqlCommandModel(net.ibizsys.paas.db.IDBDialect)
	 */
	@Override
	public ISqlCommandModel getSelectSqlCommandModel(IDBDialect iDBDialect, ISelectCond iSelectCond, boolean bTempMode) throws Exception {
		if (this.isNoViewMode()) {
			throw new Exception("无视图模式不支持当前操作");
		}
		
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		IDEDBConfig iDEDBConfig	= this.getDEDBConfig(iDBDialect.getDBType());
		if(iDEDBConfig == null) {
			throw new Exception(StringHelper.format("无法获取实体[%1$s]数据库配置[%2$s]",this.getName(),iDBDialect.getDBType()));
		}
			

		SqlCommandModel sqlCommandModel = new SqlCommandModel();
		sqlCommandModel.setDataEntityModel(this);
		sqlCommandModel.setDBDialect(iDBDialect);

		StringBuilderEx sql = new StringBuilderEx();

		ISelectContext iSelectContext = null;
		java.util.Iterator<ISelectField> selectFields = null;
		int nViewLevel = IDataEntity.VIEWLEVEL_DEFAULT;
		if (iSelectCond instanceof ISelectContext) {
			iSelectContext = (ISelectContext) iSelectCond;
			selectFields = iSelectContext.getSelectFields();
			nViewLevel = iSelectContext.getViewLevel();
		}

		if (selectFields == null) {
			
			
			if (bTempMode) {
				sql.append("SELECT m1.* FROM %1$s m1  ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName() + "_TMP"));
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
				nIndex++;
				ISelectField iSelectField = selectFields.next();
				String strAlias = iSelectField.getAlias();
				if (StringHelper.isNullOrEmpty(iSelectField.getFunc())) {
					if (StringHelper.isNullOrEmpty(iSelectField.getName())) {
						throw new Exception("没有指定字段名称");
					}

					if (StringHelper.isNullOrEmpty(strAlias)) {
						sql.append("%1$s", iDBDialect.getDBObjStandardName(iSelectField.getName()));
					} else {
						sql.append("%1$s AS %2$s", iDBDialect.getDBObjStandardName(iSelectField.getName()), iDBDialect.getDBObjStandardName(strAlias));
					}

				} else {
					String fields[] = null;
					if (!StringHelper.isNullOrEmpty(iSelectField.getName())) {
						fields = iSelectField.getName().split("[,]");
					}
					if (StringHelper.isNullOrEmpty(strAlias)) {
						if (fields != null && fields.length > 0) {
							strAlias = fields[0];
						} else {
							strAlias = StringHelper.format("A%1$s", strAlias);
						}
					}
					sql.append("%1$s AS %2$s", iDBDialect.getFuncSQL(iSelectField.getFunc(), fields), iDBDialect.getDBObjStandardName(strAlias));
				}
			}

			if (bTempMode) {
				sql.append(" FROM %1$s m1  ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName() + "_TMP"));
			} else {
				sql.append(" FROM %1$s m1 ", iDBDialect.getDBObjStandardName(iDEDBConfig.getViewName(nViewLevel)));
			}

		}

		ProcParamList procParamList = new ProcParamList();

		boolean bFirstCond = true;

		if (bTempMode) {
			bFirstCond = false;
			sql.append(" WHERE m1.SRFDRAFTFLAG=0 ");
		} else {
			if (this.isLogicValid()) {
				Object objInvalidValue = this.getLogicValidValue(true);
				String strInvalidValue = "";
				if (objInvalidValue instanceof String) {
					strInvalidValue = StringHelper.format("'%1$s'", objInvalidValue);
				} else {
					strInvalidValue = StringHelper.format("%1$s", objInvalidValue);
				}
				sql.append(" WHERE m1.%1$s=%2$s ", iDBDialect.getDBObjStandardName(this.getLogicValidDEField().getName()), strInvalidValue);
				bFirstCond = false;
			}
		}

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		iSelectCond.fillMap(paramMap);
		for (String strFieldName : paramMap.keySet()) {
			IDEField iDEField = this.getDEField(strFieldName, true);
			if (iDEField == null) continue;

			if (bFirstCond) {
				bFirstCond = false;
				sql.append(" WHERE ");
			} else
				sql.append("AND ");

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

		if(iSelectContext!=null && iSelectContext.getSelectFilter()!=null && ( iSelectContext.getSelectFilter() instanceof IDEDataQueryCodeCond)){
			IDEDataQueryCodeCond iDEDataQueryCodeCond = (IDEDataQueryCodeCond)iSelectContext.getSelectFilter();
			String strCode = getSelectConditionSql(iDEDataQueryCodeCond,iDBDialect,procParamList);
			if(!StringHelper.isNullOrEmpty(strCode)){
				if (bFirstCond) {
					bFirstCond = false;
					sql.append(" WHERE %1$s",strCode);
				} else
					sql.append("AND (%1$s)",strCode);
			}
		}
		
		if (!StringHelper.isNullOrEmpty(iSelectCond.getOrderInfo())){
			sql.append(" ");
			sql.append(iSelectCond.getOrderInfo());
		}

		sqlCommandModel.setSql(sql.toString());
		sqlCommandModel.setProcParamList(procParamList);
		return sqlCommandModel;

	}
	
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getMergeSqlCommandModel(net.ibizsys.paas.db.IDBDialect)
	 */
	@Override
	public ISqlCommandModel getMergeSqlCommandModel(IDBDialect iDBDialect) throws Exception {
		
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
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
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEFSearchMode(java.lang.String, boolean)
	 */
	@Override
	public IDEFSearchMode getDEFSearchMode(String strName, boolean bTryMode) throws Exception {
		IDEFSearchMode iDEFSearchMode = defSearchModeMap.get(strName.toLowerCase());
		if (iDEFSearchMode == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取制定属性搜索模式[%1$s]", strName));
		}
		return iDEFSearchMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getFetchQuickSearchCondition(java.lang.String)
	 */
	@Override
	public IDEDataSetCond getFetchQuickSearchCondition(String strQuickSearch) throws Exception {
		DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
		deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_GROUP);
		deDataSetCondImpl.setCondOp(ICondition.CONDOP_OR);
		onFillFetchQuickSearchConditions(deDataSetCondImpl, strQuickSearch);
		if (deDataSetCondImpl.getChildDEDataQueryConds() == null) {
			return null;
		}

		return deDataSetCondImpl;

	}

	/**
	 * 填充快速搜索条件
	 * 
	 * @param groupCondImpl
	 * @param strQuickSearch
	 * @throws Exception
	 */
	protected void onFillFetchQuickSearchConditions(DEDataSetCond groupCondImpl, String strQuickSearch) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getSystemRuntime()
	 */
	@Override
	public ISystemRuntime getSystemRuntime() {
		return (ISystemRuntime) this.getSystem();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#isLogicValid()
	 */
	@Override
	public boolean isLogicValid() {
		return this.bLogicValid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getLogicValidValue(boolean)
	 */
	@Override
	public Object getLogicValidValue(boolean bValid) {
		return bValid ? validValue : invalidValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getLogicValidDEField()
	 */
	@Override
	public IDEField getLogicValidDEField() {
		return this.logicValidDEField;
	}

	/**
	 * 设置实体模型标识
	 * 
	 * @param strId the strId to set
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置实体模型名称
	 * 
	 * @param strName the strName to set
	 */
	protected void setName(String strName) {
		this.strName = strName;
	}

	/**
	 * 获取实体模型启用标识值
	 * 
	 * @return the strValidValue
	 */
	public String getValidValue() {
		return strValidValue;
	}

	/**
	 * 设置取实体模型启用标识值
	 * 
	 * @param strValidValue the strValidValue to set
	 */
	public void setValidValue(String strValidValue) {
		this.strValidValue = strValidValue;
	}

	/**
	 * 获取实体模型未启用标识值
	 * 
	 * @return the strInvalidValue
	 */
	public String getInvalidValue() {
		return strInvalidValue;
	}

	/**
	 * 设置实体模型未启用标识值
	 * 
	 * @param strInvalidValue the strInvalidValue to set
	 */
	public void setInvalidValue(String strInvalidValue) {
		this.strInvalidValue = strInvalidValue;
	}

	/**
	 * 设置实体模型是否启用逻辑有效
	 * 
	 * @param bLogicValid the bLogicValid to set
	 */
	public void setLogicValid(boolean bLogicValid) {
		this.bLogicValid = bLogicValid;
	}

	/**
	 * 设置实体模型表名称
	 * 
	 * @param strTableName the strTableName to set
	 */
	public void setTableName(String strTableName) {
		this.strTableName = strTableName;
	}

	/**
	 * 设置实体模型视图名称
	 * 
	 * @param strViewName the strViewName to set
	 */
	public void setViewName(String strViewName) {
		this.strViewName = strViewName;
	}

	/**
	 * 设置实体模型逻辑名称
	 * 
	 * @param strLogicName the strLogicName to set
	 */
	public void setLogicName(String strLogicName) {
		this.strLogicName = strLogicName;
	}

	/**
	 * 获取数据源链接
	 * 
	 * @return
	 */
	public String getDSLink() {
		return this.strDSLink;
	}

	/**
	 * 设置实体数据连接
	 * 
	 * @param strDSLink
	 */
	public void setDSLink(String strDSLink) {
		this.strDSLink = strDSLink;
	}

	/**
	 * 设置是否启用多数据源
	 * 
	 * @param bEnableMultiDS
	 */
	public void setEnableMultiDS(boolean bEnableMultiDS) {
		this.bEnableMultiDS = bEnableMultiDS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see SA.SRFDA.PS.Core.DataEntity.IPSDataEntity#isEnableMultiDS()
	 */
	@Override
	public boolean isEnableMultiDS() {
		return this.bEnableMultiDS;
	}

	/**
	 * 设置是否为无视图模式
	 * 
	 * @param bNoViewMode
	 */
	public void setNoViewMode(boolean bNoViewMode) {
		this.bNoViewMode = bNoViewMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#isNoViewMode()
	 */
	@Override
	public boolean isNoViewMode() {
		return this.bNoViewMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getService(org.hibernate.SessionFactory)
	 */
	@Override
	public IService getService(SessionFactory sessionFactory) throws Exception {
		if (sessionFactory == null)
			return this.getService();
		else {
			return ServiceGlobal.getService(getServiceId(), sessionFactory);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEActionLogic(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void registerDEActionLogic(String strAction, String strAttachMode, String strLogicName) throws Exception {
		IDELogicModel<ET> iDELogicModel = (IDELogicModel<ET>) this.getDELogic(strLogicName);
		String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
		ArrayList<IDELogicModel<ET>> logicList = this.actionDELogicsMap.get(strKey);
		if (logicList == null) {
			logicList = new ArrayList<IDELogicModel<ET>>();
			this.actionDELogicsMap.put(strKey, logicList);
		}
		logicList.add(iDELogicModel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEActionLogic(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void registerDEActionLogic(String strAction, String strAttachMode, String strDstDEName, String strDstActionName) throws Exception {
		String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
		ArrayList<IDEActionLogicModel> logicList = this.actionDELogicsMap2.get(strKey);
		if (logicList == null) {
			logicList = new ArrayList<IDEActionLogicModel>();
			this.actionDELogicsMap2.put(strKey, logicList);
		}

		DEActionLogicModel deActionLogicModel = new DEActionLogicModel();
		deActionLogicModel.setDEName(strDstDEName);
		deActionLogicModel.setDEActionName(strDstActionName);
		logicList.add(deActionLogicModel);
	}

	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEActionLogic(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean)
	 */
	@Override
	public IDEActionLogicModel registerDEActionLogic(String strAction, String strAttachMode, String strDstDEName, String strDstActionName, boolean bCloneParam, boolean bIgnoreException) throws Exception {
		String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
		ArrayList<IDEActionLogicModel> logicList = this.actionDELogicsMap2.get(strKey);
		if (logicList == null) {
			logicList = new ArrayList<IDEActionLogicModel>();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEActionLogics(java.lang.String, java.lang.String)
	 */
	@Override
	public java.util.Iterator<IDELogicModel<ET>> getDEActionLogics(String strAction, String strAttachMode) {
		String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
		ArrayList<IDELogicModel<ET>> logicList = this.actionDELogicsMap.get(strKey);
		if (logicList == null) {
			return null;
		}
		return logicList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEActionLogics2(java.lang.String, java.lang.String)
	 */
	@Override
	public java.util.Iterator<IDEActionLogicModel> getDEActionLogics2(String strAction, String strAttachMode) {
		String strKey = StringHelper.format("%1$s|%2$s", strAction, strAttachMode).toUpperCase();
		ArrayList<IDEActionLogicModel> logicList = this.actionDELogicsMap2.get(strKey);
		if (logicList == null) {
			return null;
		}
		return logicList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDEMainState(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public IDEMainState getDEMainState(ISimpleDataObject iSimpleDataObject) throws Exception {
		String strDEMainStateTag = getDEMainStateTag(iSimpleDataObject);
		if (strDEMainStateTag == null) {
			return null;
		}

		IDEMainState iDEMainState = this.deMainStateMap.get(strDEMainStateTag);
		if (iDEMainState != null) return iDEMainState;
		return defaultDEMainState;
	}

	/**
	 * 设置主状态属性
	 * 
	 * @param mainStateFields
	 */
	public void setMainStateFields(String[] mainStateFields) {
		this.mainStateFields = mainStateFields;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEMainStateTag(net.ibizsys.paas.data.ISimpleDataObject)
	 */
	@Override
	public String getDEMainStateTag(ISimpleDataObject iSimpleDataObject) throws Exception {
		if (this.mainStateFields == null) return null;

		/**
		 * 20170911 添加
		 */
		for(String strField:this.mainStateFields){
			if(!iSimpleDataObject.contains(strField)){
				if(iSimpleDataObject instanceof IEntityActionSupporter){
					if(((IEntityActionSupporter)iSimpleDataObject).getActionHelper() != null){
						((IEntityActionSupporter)iSimpleDataObject).get(true);
						break;
					}
				}
				else{
					log.warn(StringHelper.format("当前数据对象不包含属性[%1$s]，可能会发生错误",strField));
					break;
				}
			}
		}
		
		
		
		IDEMainState iDEMainState = null;
		String strTag = "";
		for (int i = 0; i <= 1; i++) {
			strTag = StringHelper.format("%1$s", ((i == 0) ? iSimpleDataObject.get(this.mainStateFields[0]) : "*"));
			if (this.mainStateFields.length >= 2) {
				for (int j = 0; j <= 1; j++) {
					String strTag2 = StringHelper.format("%1$s__%2$s", strTag, ((j == 0) ? iSimpleDataObject.get(this.mainStateFields[1]) : "*"));
					if (this.mainStateFields.length >= 3) {
						for (int k = 0; k <= 1; k++) {
							String strTag3 = StringHelper.format("%1$s__%2$s", strTag2, ((k == 0) ? iSimpleDataObject.get(this.mainStateFields[2]) : "*"));
							// 判断是否存在
							iDEMainState = this.deMainStateMap.get(strTag3);
							if (iDEMainState != null) {
								return iDEMainState.getMSTag();
							}
						}
					} else {
						iDEMainState = this.deMainStateMap.get(strTag2);
						if (iDEMainState != null) {
							return iDEMainState.getMSTag();
						}
					}
				}
			} else {
				iDEMainState = this.deMainStateMap.get(strTag);
				if (iDEMainState != null) {
					return iDEMainState.getMSTag();
				}
			}
		}
		return null;
	}

	
	
	
	@Override
	public String getDEMainStateDenyMsg(IDEMainState iDEMainState, ISimpleDataObject iSimpleDataObject, int nActionType, String strActionOrOPPrivName) throws Exception {
		if(iDEMainState == null)
			return null;

		if(StringHelper.isNullOrEmpty(iDEMainState.getLogicName())){
			return StringHelper.format("当前数据状态拒绝此操作",iDEMainState.getLogicName());
		}
		else{
			return StringHelper.format("当前数据状态[%1$s]拒绝此操作",iDEMainState.getLogicName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDataInfo(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public String getDataInfo(ET et) throws Exception {
		return DataObject.getStringValue(et, this.getMajorDEField().getName(), "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDefaultDEWF()
	 */
	@Override
	public IDEWF getDefaultDEWF() {
		return this.defaultDEWF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getPickupDEField(java.lang.String)
	 */
	@Override
	public IDEField getPickupDEField(String strDERId) throws Exception {
		IDER1N iDER1N = (IDER1N) this.getSystem().getDER(strDERId);
		return this.getDEField(iDER1N.getPickupDEFName(), false);
	}
	
	

	@Override
	public IDEField getPickupDEField(IDataEntityModel majorDEModel, boolean bTryMode) throws Exception {
		
		java.util.Iterator<IDERBase> minorDERs = this.getDERs(false);
		if(minorDERs != null){
			while(minorDERs.hasNext()){
				IDERBase iDERBase = minorDERs.next();
				if(iDERBase instanceof IDER1N){
					IDER1N iDER1N = (IDER1N)iDERBase;
					if(StringHelper.compare(majorDEModel.getId(),iDER1N.getMajorDEId(),false) == 0){
						return this.getDEField(iDER1N.getPickupDEFName(), false);
					}
					if(majorDEModel.getInheritDataEntity()!=null){
						if(StringHelper.compare(majorDEModel.getInheritDataEntity().getId(),iDER1N.getMajorDEId(),false) == 0){
							return this.getDEField(iDER1N.getPickupDEFName(), false);
						}
					}
				}
			}
		}
		
		if(!bTryMode){
			throw new Exception(StringHelper.format("无法获取指定实体[%1$s]外键值属性",majorDEModel.getName()));
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEFieldByPDT(java.lang.String, boolean)
	 */
	@Override
	public IDEField getDEFieldByPDT(String strPreDefinedType, boolean bTryMode) throws Exception {
		IDEField iDEField = this.pdtDEFieldMap.get(strPreDefinedType);
		if (iDEField == null) {
			if (!bTryMode) throw new Exception(StringHelper.format("无法找到预定义类型[%1$s]属性", strPreDefinedType));
			return null;
		}
		return iDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getMajorDEModel()
	 */
	@Override
	public IDER1N getAccMasterDER(ET et) throws Exception {
		if (masterDERList == null || et == null) return null;

		for (IDER1N iDER1N : masterDERList) {
			if (et.get(iDER1N.getPickupDEFName()) != null) return iDER1N;
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#isEnableAudit()
	 */
	@Override
	public boolean isEnableAudit() {
		return getAuditMode() != AUDITMODE_NONE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#isLogAuditDetail()
	 */
	@Override
	public boolean isLogAuditDetail() {
		return getAuditMode() == AUDITMODE_ADV;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEDataAccMgr()
	 */
	@Override
	public IDEDataAccMgr getDEDataAccMgr() {
		return iDEDataAccMgr;
	}

	/**
	 * 设置实体模型审计模式
	 * 
	 * @param nAuditMode
	 */
	public void setAuditMode(int nAuditMode) {
		this.nAuditMode = nAuditMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#testDataInWF(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public IDEWFModel testDataInWF(IEntity iEntity) throws Exception {
		for (IDEWF iDEWF : deWFMap.values()) {
			if (((IWFDEModel) iDEWF).testDataInWF(iEntity)){
				return (IDEWFModel) iDEWF;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getOrgId(net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	public Object getOrgId(IEntity iEntity) throws Exception {
		if (orgIdDEField == null || iEntity == null) return null;
		/**
		 * 20170911 添加
		 */
		if(!iEntity.contains(this.orgIdDEField.getName())){
			if(iEntity instanceof IEntityActionSupporter){
				if(((IEntityActionSupporter)iEntity).getActionHelper() != null){
					((IEntityActionSupporter)iEntity).get();
				}
			}
		}
		return iEntity.get(orgIdDEField.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDataAccCtrlMode()
	 */
	@Override
	public int getDataAccCtrlMode() {
		return this.nDataAccCtrlMode;
	}

	/**
	 * 设置实体访问数据控制模式
	 * 
	 * @param nDataAccCtrlMode
	 */
	public void setDataAccCtrlMode(int nDataAccCtrlMode) {
		this.nDataAccCtrlMode = nDataAccCtrlMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getSystemModel()
	 */
	@Override
	public ISystemModel getSystemModel() {
		if(iSystemModel == null){
			iSystemModel = (ISystemModel) getSystem();
		}
		return iSystemModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getUpdateDateDEField()
	 */
	@Override
	public IDEField getUpdateDateDEField() {
		return this.updateDateDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getAuditMode()
	 */
	@Override
	public int getAuditMode() {
		return nAuditMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEViewIdByPDT(java.lang.String, boolean)
	 */
	@Override
	public String getDEViewIdByPDT(String strPreDefinedType, boolean bTryMode) throws Exception {
		String strDEViewId = pdtDEViewMap.get(strPreDefinedType.toUpperCase());
		if (strDEViewId == null && !bTryMode) {
			throw new Exception(StringHelper.format("无法获取预定义[%1$s]实体视图标识", strPreDefinedType));
		}
		return strDEViewId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerPDTDEView(java.lang.String, java.lang.String)
	 */
	@Override
	public void registerPDTDEView(String strPreDefinedType, String strDEViewId) throws Exception {
		pdtDEViewMap.put(strPreDefinedType.toUpperCase(), strDEViewId);
	}

	
	
	
	@Override
	public String getSDDEViewPDTParam(ET et, boolean bEnableWF, boolean bWFWorkMode, int nAppType) throws Exception {
		String strPDTParam = null;
		if (bEnableWF) {
			// 判断数据是否在流程中
			for (IDEWF iDEWF : deWFList) {
				strPDTParam = iDEWF.getWFEditViewPDTParam(et, bWFWorkMode,nAppType);
				if (!StringHelper.isNullOrEmpty(strPDTParam)) break;
			}

			if (!StringHelper.isNullOrEmpty(strPDTParam)) return strPDTParam;
		}

		if (this.isEnableMultiForm() && this.getMultiFormDEField() != null) {
			Object objFormValue = et.get(this.getMultiFormDEField().getName());
			if(nAppType == IApplication.APPTYPE_MOBILE){
				return StringHelper.format("%1$s:%2$s", IView.PREDEFINEDVIEWTYPE_MOBEDITVIEW, objFormValue);
			}
			return StringHelper.format("%1$s:%2$s", IView.PREDEFINEDVIEWTYPE_EDITVIEW, objFormValue);
		}

		if(nAppType == IApplication.APPTYPE_MOBILE){
			return IView.PREDEFINEDVIEWTYPE_MOBEDITVIEW;
		}
		return IView.PREDEFINEDVIEWTYPE_EDITVIEW;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getSDDEViewPDTParam(net.ibizsys.paas.entity.IEntity, boolean, boolean)
	 */
	@Override
	public String getSDDEViewPDTParam(ET et, boolean bEnableWF, boolean bWFWorkMode) throws Exception {
		return getSDDEViewPDTParam(et,  bEnableWF,  bWFWorkMode,IApplication.APPTYPE_DESKTOP);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#isEnableMultiForm()
	 */
	@Override
	public boolean isEnableMultiForm() {
		return bEnableMultiForm;
	}

	/**
	 * 设置是否启用实体多表单
	 * 
	 * @param bEnableMultiForm
	 */
	public void setEnableMultiForm(boolean bEnableMultiForm) {
		this.bEnableMultiForm = bEnableMultiForm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getIndexDEType()
	 */
	@Override
	public String getIndexDEType() {
		return this.strIndexDEType;
	}

	/**
	 * 设置索引实体模式
	 * 
	 * @param strIndexDEType
	 */
	public void setIndexDEType(String strIndexDEType) {
		this.strIndexDEType = strIndexDEType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getMultiFormDEField()
	 */
	@Override
	public IDEField getMultiFormDEField() {
		return multiFormDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getIndexTypeDEField()
	 */
	@Override
	public IDEField getIndexTypeDEField() {
		return indexTypeDEField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDERIndex(boolean, java.lang.String)
	 */
	@Override
	public IDERIndex getDERIndex(boolean bMajor, String strIndexValue) throws Exception {
		java.util.Iterator<IDERBase> derBases = this.getDERs(bMajor);
		if (derBases != null) {
			while (derBases.hasNext()) {
				IDERBase iDERBase = derBases.next();
				if (iDERBase instanceof IDERIndex) {
					IDERIndex iDERIndex = (IDERIndex) iDERBase;
					if (StringHelper.compare(iDERIndex.getTypeValue(), strIndexValue, true) == 0) return iDERIndex;
				}
			}
		}
		throw new Exception(StringHelper.format("无法获取实体[%1$s]类型值[%2$s]索引关系[%3$s]", this.getName(), strIndexValue, bMajor));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getInheritDataEntity()
	 */
	@Override
	public IDataEntity getInheritDataEntity() throws Exception {
		return this.getInheritDEModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getInheritDEModel()
	 */
	@Override
	public IDataEntityModel getInheritDEModel() throws Exception {
		if (StringHelper.isNullOrEmpty(getInheritDEId())) {
			return null;
		}
		if (this.inheritDEModel != null) return this.inheritDEModel;

		IDataEntity iDataEntity = DEModelGlobal.getDEModel(getInheritDEId());
		this.inheritDEModel = (IDataEntityModel) iDataEntity;
		return this.inheritDEModel;
	}

	/**
	 * 设置继承的实体名称
	 * 
	 * @param strInheritDEId the strInheritDEId to set
	 */
	protected void setInheritDEId(String strInheritDEId) {
		this.strInheritDEId = strInheritDEId;
	}

	/**
	 * 获取继承的实体名称
	 * 
	 * @return
	 */
	public String getInheritDEId() {
		return this.strInheritDEId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEWFs()
	 */
	@Override
	public Iterator<IDEWF> getDEWFs() {
		if (deWFMap.size() == 0) return null;
		return deWFMap.values().iterator();
	}

	
	
	
	@Override
	public boolean hasDEWF() {
		return deWFMap.size()>0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDynamicMode()
	 */
	@Override
	public int getDynamicMode() {
		return this.nDynamicMode;
	}

	/**
	 * 设置实体动态模式
	 * 
	 * @param nDynamicMode
	 */

	public void setDynamicMode(int nDynamicMode) {
		this.nDynamicMode = nDynamicMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerMapDEOPPrivTag(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void registerMapDEOPPrivTag(String strDEOPPrivTag, String strDERName, String strMapDEOPPrivTag) {
		String strTag = StringHelper.format("%1$s|%2$s", strDEOPPrivTag, strDERName).toUpperCase();
		this.deOPPrivMapMap.put(strTag, strMapDEOPPrivTag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getMapDEOPPrivTag(java.lang.String, java.lang.String)
	 */
	@Override
	public String getMapDEOPPrivTag(String strDEOPPrivTag, String strDERName) {
		String strTag = StringHelper.format("%1$s|%2$s", strDEOPPrivTag, strDERName).toUpperCase();
		String strMapDEOPPrivTag = this.deOPPrivMapMap.get(strTag);
		if (StringHelper.isNullOrEmpty(strMapDEOPPrivTag)) {
			if (StringHelper.compare(strDEOPPrivTag, DataAccessActions.ALL, true) != 0) {
				return getMapDEOPPrivTag(DataAccessActions.ALL, strDERName);
			}
		}
		return strMapDEOPPrivTag;
	}

	@Override
	public IDEWFModel getDEWFModel(ET et, IWebContext iWebContext) throws Exception {
		String strWFMode = iWebContext.getWFMode();

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDataChangeLogMode()
	 */
	@Override
	public int getDataChangeLogMode() {
		return this.nDataChangeLogMode;
	}

	/**
	 * 设置实体数据变化日志模式
	 * 
	 * @param nDataChangeLogMode
	 */
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
		} else {
			if (this.deDataSyncOutList == null) {
				return null;
			}
			return this.deDataSyncOutList.iterator();
		}
	}

	@Override
	public void registerDEDataSync(IDEDataSync iDEDataSync) {
		if (iDEDataSync.isInMode()) {
			if (this.deDataSyncInList == null) {
				this.deDataSyncInList = new ArrayList<IDEDataSync>();
			}
			this.deDataSyncInList.add(iDEDataSync);
			DataSyncGlobal.registerDEDataSyncIn((IDEDataSyncIn) iDEDataSync);
		} else {
			if (this.deDataSyncOutList == null) {
				this.deDataSyncOutList = new ArrayList<IDEDataSync>();
			}
			this.deDataSyncOutList.add(iDEDataSync);
		}
	}

	/**
	 * 获取联合键值属性集合
	 * 
	 * @return 无值返回 null
	 */
	@Override
	public java.util.Iterator<IDEField> getUnionKeyValueDEFields() {
		if (this.unionKeyValueFieldList == null || this.unionKeyValueFieldList.size() == 0) return null;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDEFieldConditionSql(net.ibizsys.paas.db.IDBDialect, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	@Override
	public String getDEFieldConditionSql(IDBDialect iDBDialect, String strFieldName, String strFieldExp, int nStdDataType, String strCondOp, String strValue) throws Exception {
		
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		return iDBDialect.getConditionSQL(strFieldExp, nStdDataType, strCondOp, strValue, false, null);
	}
	
	
	

	@Override
	public String getDEFieldConditionSql(IDBDialect iDBDialect, String strFieldName, String strFieldExp, int nStdDataType, String strCondOp, String strValueOrParam, boolean bParam, SqlParamList sqlParamList) throws Exception {
		
		if(iDBDialect == null) {
			throw new Exception(StringHelper.format("传入数据库适配器无效"));
		}
		
		return iDBDialect.getConditionSQL(strFieldExp, nStdDataType, strCondOp, strValueOrParam, bParam, sqlParamList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getDefaultDEDataQuery()
	 */
	@Override
	public IDEDataQuery getDefaultDEDataQuery() {
		return this.defaultDEDataQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntity#getStorageMode()
	 */
	@Override
	public int getStorageMode() {
		return this.nStorageMode;
	}

	/**
	 * 设置实体存储模式
	 * 
	 * @param nStorageMode
	 */
	public void setStorageMode(int nStorageMode) {
		this.nStorageMode = nStorageMode;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDataEntity#getDEActionWizardGroup(java.lang.String)
	 */
	public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId) throws Exception {
		return getDEActionWizardGroup(strDEActionWizardGroupId,false);
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDataEntity#getDEActionWizardGroup(java.lang.String, boolean)
	 */
	@Override
	public IDEActionWizardGroup getDEActionWizardGroup(String strDEActionWizardGroupId, boolean bTry) throws Exception {
		IDEActionWizardGroup iDEActionWizardGroup = deActionWizardGroupMap.get(strDEActionWizardGroupId);
		if (iDEActionWizardGroup == null) {
			if (!bTry) {
				throw new Exception(StringHelper.format("无法获取实体操作向导组[%1$s]", strDEActionWizardGroupId));
			}
		}

		return iDEActionWizardGroup;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDataEntity#getDEActionWizard(java.lang.String)
	 */
	@Override
	public IDEActionWizard getDEActionWizard(String strDEActionWizardId) throws Exception {
		IDEActionWizard iDEActionWizard = deActionWizardMap.get(strDEActionWizardId);
		if (iDEActionWizard == null) {
			throw new Exception(StringHelper.format("无法获取实体操作向导组[%1$s]", strDEActionWizardId));
		}

		return iDEActionWizard;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEActionWizard(net.ibizsys.paas.core.IDEActionWizard)
	 */
	@Override
	public void registerDEActionWizard(IDEActionWizard iDEActionWizard) {
		this.deActionWizardMap.put(iDEActionWizard.getId(), iDEActionWizard);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEActionWizardGroup(net.ibizsys.paas.core.IDEActionWizardGroup)
	 */
	@Override
	public void registerDEActionWizardGroup(IDEActionWizardGroup iDEActionWizardGroup) {
		this.deActionWizardGroupMap.put(iDEActionWizardGroup.getId(), iDEActionWizardGroup);
	}

	
	@Override
	public IDEBATable getDEBATable(String strDEBATableId) throws Exception {
		IDEBATable iDEBATable = null;
		if(this.deBATableMap!=null)
			iDEBATable = deBATableMap.get(strDEBATableId);
		if (iDEBATable == null) {
			throw new Exception(StringHelper.format("无法获取实体大数据表[%1$s]", strDEBATableId));
		}

		return iDEBATable;
	}

	@Override
	public Iterator<IDEBATable> getDEBATables() {
		if(deBATablList == null)
			return null;
		return deBATablList.iterator();
	}

	@Override
	public void registerDEBATable(IDEBATable iDEBATable) {
		if(deBATableMap==null){
			deBATableMap = new HashMap<String, IDEBATable>();
			deBATablList = new ArrayList<IDEBATable>();
		}
		this.deBATableMap.put(iDEBATable.getId(), iDEBATable);
		this.deBATablList.add(iDEBATable);
	}

	@Override
	public void setServicePlugin(IServicePlugin iServicePlugin) throws Exception {
		setServicePlugin(iServicePlugin,false);
	}

	@Override
	public void setServicePlugin(IServicePlugin iServicePlugin, boolean bIgnoreOrigin) throws Exception {
		IServicePlugin lastPlugin = null;
		if(!bIgnoreOrigin){
			lastPlugin = this.iServicePlugin;
			if(lastPlugin == null){
				//拿到当前系统插件
				if(this.getSystemModel().getSystemPlugin()!=null){
					lastPlugin =  getSystemModel().getSystemPlugin().getServicePlugin();
				}
			}
		}
		
		iServicePlugin.setPrevPlugin(lastPlugin);
		this.iServicePlugin = iServicePlugin;
	}

	@Override
	public IServicePlugin getServicePlugin() {
		if(this.iServicePlugin!=null){
			return this.iServicePlugin;
		}
		else
		{
			//拿到当前系统插件
			if(this.getSystemModel().getSystemPlugin()!=null){
				return getSystemModel().getSystemPlugin().getServicePlugin();
			}
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
	
	/**
	 * 设置实体模型视图名称（模式2）
	 * 
	 * @param strView2Name the strView2Name to set
	 */
	public void setView2Name(String strView2Name) {
		this.strView2Name = strView2Name;
	}
	
	
	/**
	 * 设置实体模型视图名称（模式3）
	 * 
	 * @param strView3Name the strView3Name to set
	 */
	public void setView3Name(String strView3Name) {
		this.strView3Name = strView3Name;
	}

	
	
	/**
	 * 设置实体模型视图名称（模式4）
	 * 
	 * @param strView4Name the strView4Name to set
	 */
	public void setView4Name(String strView4Name) {
		this.strView4Name = strView4Name;
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDataEntity#getViewDEDataQuery(int)
	 */
	@Override
	public IDEDataQuery getViewDEDataQuery(int nViewLevel) {
		IDEDataQuery viewDEDataQuery = null;
		for(IDEDataQuery iDEDataQuery:this.deDataQueryList){
			if(iDEDataQuery.getViewLevel()!=IDataEntity.VIEWLEVEL_UNKNOWN){
				if(iDEDataQuery.getViewLevel()>nViewLevel){
					continue;
				}
				
				if(iDEDataQuery.getViewLevel()==nViewLevel){
					return iDEDataQuery;
				}
				
				if(iDEDataQuery.getViewLevel()<nViewLevel){
					if(viewDEDataQuery == null){
						viewDEDataQuery = iDEDataQuery;
					}
					else{
						if(viewDEDataQuery.getViewLevel()<iDEDataQuery.getViewLevel()){
							viewDEDataQuery = iDEDataQuery;
						}
					}
				}
			}
		}
		
		if(viewDEDataQuery==null)
			return this.getDefaultDEDataQuery();
		return viewDEDataQuery;
		
	}

	@Override
	public String getViewName(int nViewLevel) {
		//注意，此处故意没有break
		switch(nViewLevel){
		case VIEWLEVEL_DEFAULT:
		case VIEWLEVEL_UNKNOWN:
			return this.getViewName();
		case VIEWLEVEL_LEVEL4:
			if(!StringHelper.isNullOrEmpty(this.getView4Name()))
				return this.getView4Name();
		case VIEWLEVEL_LEVEL3:
			if(!StringHelper.isNullOrEmpty(this.getView3Name()))
				return this.getView3Name();	
		case VIEWLEVEL_LEVEL2:
			if(!StringHelper.isNullOrEmpty(this.getView2Name()))
				return this.getView2Name();
		default:
			return this.getViewName();
		}
	}

	

	/**
	 * 获取查询条件语句
	 * @param iDEDataQueryCond
	 * @param iDBDialect
	 * @param list
	 * @return
	 * @throws Exception
	 */
	protected String getSelectConditionSql( IDEDataQueryCodeCond iDEDataQueryCond, IDBDialect iDBDialect, ProcParamList list) throws Exception {
		if (StringHelper.compare(iDEDataQueryCond.getCondType(), IDEDataQueryCodeCond.CONDTYPE_GROUP, true) == 0) {
			ArrayList<String> condList = new ArrayList<String>();
			java.util.Iterator<IDEDataQueryCodeCond> childDEDataQueryConds = iDEDataQueryCond.getChildDEDataQueryConds();
			if (childDEDataQueryConds != null) {
				while (childDEDataQueryConds.hasNext()) {
					IDEDataQueryCodeCond childDEDataQueryCond = childDEDataQueryConds.next();
					String strCond = getSelectConditionSql(childDEDataQueryCond, iDBDialect, list);
					if (!StringHelper.isNullOrEmpty(strCond)) {
						condList.add(strCond);
					}
				}
			}

			if (condList.size() == 0) return null;

			StringBuilderEx sb = new StringBuilderEx();

			boolean bFirst = true;
			for (String strCond : condList) {
				if (bFirst)
					bFirst = false;
				else
					sb.append(" %1$s ", iDEDataQueryCond.getCondOp());
				sb.append("( %1$s )", strCond);
			}

			if (iDEDataQueryCond.isNotMode()) {
				return StringHelper.format(" NOT( %1$s )", sb.toString());
			} else
				return sb.toString();
		}

		if (StringHelper.compare(iDEDataQueryCond.getCondType(), IDEDataQueryCodeCond.CONDTYPE_DEFIELD, true) == 0) {
			String strDEFieldExp = iDEDataQueryCond.getDEFieldExp();
			int nStdDataType = iDEDataQueryCond.getStdDataType();
			if (StringHelper.isNullOrEmpty(strDEFieldExp)) {
				strDEFieldExp = iDBDialect.getDBObjStandardName(iDEDataQueryCond.getDEFName()) ;//StringHelper.format("m1.%1$s", iDEDataQueryCond.getDEFName());
			}
			if (nStdDataType == DataTypes.UNKNOWN) {
				IDEField iDEField = this.getDEField(iDEDataQueryCond.getDEFName(), false);
				nStdDataType = iDEField.getStdDataType();
			}

			if(DataTypeHelper.isStringDataType(nStdDataType) ){
				return this.getDEFieldConditionSql(iDBDialect, iDEDataQueryCond.getDEFName(), strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(), iDEDataQueryCond.getCondValue());
			}
			else{
				SqlParamList sqlParamList = new SqlParamList();
				String strSql =  this.getDEFieldConditionSql(iDBDialect, iDEDataQueryCond.getDEFName(), strDEFieldExp, nStdDataType, iDEDataQueryCond.getCondOp(),iDEDataQueryCond.getDEFName(),true,sqlParamList);
				if(sqlParamList.size()>0){
					ProcParam procParam = new ProcParam();
					procParam.setDataType(nStdDataType);
					procParam.setParamName("");
					if(iDEDataQueryCond instanceof ISelectFieldFilter)
					{
						procParam.setValue(((ISelectFieldFilter)iDEDataQueryCond).getCondObjectValue());
					}
					else{
						if(nStdDataType != DataTypes.UNKNOWN){
							procParam.setValue( DataTypeHelper.parse(nStdDataType,iDEDataQueryCond.getCondValue()));
						}
						else
							procParam.setValue( iDEDataQueryCond.getCondValue());
					}
					list.add(procParam);
				}
				return strSql;
			}

			
		}

		if (StringHelper.compare(iDEDataQueryCond.getCondType(), IDEDataQueryCodeCond.CONDTYPE_CUSTOM, true) == 0) {
			throw new Exception("不支持自定义条件");
//			// 自定义代码，要分析是否有参数
//			SqlCodeHelper sqlCodeHelper = this.sqlCodeHelperMap.get(iDEDataQueryCond.getCustomCond());
//			if (sqlCodeHelper == null) {
//				sqlCodeHelper = new SqlCodeHelper();
//				sqlCodeHelper.init(this, iDEDataQueryCond.getCustomCond());
//				sqlCodeHelperMap.put(iDEDataQueryCond.getCustomCond(), sqlCodeHelper);
//			}
//			return sqlCodeHelper.generateCode(list, iDEDataSetFetchContext.getSessionFactory());
		}

		throw new Exception(StringHelper.format("无法识别的条件类型[%1$s]", iDEDataQueryCond.getCondType()));
	}

	@Override
	public boolean hasDEMainState() {
		return deMainStateMap.size()>0;
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


	/**
	 * 设置是否启用实体数据对象缓存
	 * @param bEnableEntityCache
	 */
	public void setEnableEntityCache(boolean bEnableEntityCache) {
		this.bEnableEntityCache = bEnableEntityCache;
	}
	
	
	/**
	 * 设置实体数据对象缓存数量
	 * @param nEntityCacheCount
	 */
	public void setEntityCacheCount(int nEntityCacheCount) {
		this.nEntityCacheCount = nEntityCacheCount;
	}
	
	
	/**
	 * 设置实体数据对象缓存超时时长
	 * @param nEntityCacheTimeout
	 */
	public void setEntityCacheTimeout(int nEntityCacheTimeout) {
		this.nEntityCacheTimeout = nEntityCacheTimeout;
	}

	@Override
	public int getDataImpExpMode() {
		return this.nDataImpExpMode;
	}

	
	/**
	 * 设置数据的导入导出模式
	 * @param nDataImpExpMode
	 */
	public void setDataImpExpMode(int nDataImpExpMode){
		this.nDataImpExpMode = nDataImpExpMode;
	}

	@Override
	public Object getRuntimeId() {
		if(objRuntimeId == null)
			return this.getId();
		return objRuntimeId;
	}

	@Override
	public void setRuntimeId(Object objRuntimeId) {
		this.objRuntimeId = objRuntimeId;
	}

	@Override
	public String getDEOPPrivTarget(String strDEOPPriv) {
		return this.getSystemModel().getDEOPPrivTarget(strDEOPPriv);
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDataEntity#getServiceAPIClientId()
	 */
	@Override
	public String getServiceAPIClientId() {
		return this.strServiceAPIClientId;
	}
	
	
	/**
	 * 设置服务接口客户端标识
	 * @param strServiceAPIClientId
	 */
	public void setServiceAPIClientId(String strServiceAPIClientId){
		this.strServiceAPIClientId = strServiceAPIClientId;
	}

	
	@Override
	public String getServiceAPIActionTag(String strActionType, String strAction) throws Exception {
		if(StringHelper.isNullOrEmpty(this.strServiceActionDETag)){
			if(StringHelper.isNullOrEmpty(strAction)){
				return StringHelper.format("%1$s__%2$s",this.getName(),strActionType).toUpperCase();
			}
			return StringHelper.format("%1$s__%2$s__%3$s",this.getName(),strActionType,strAction).toUpperCase();
		}
		else{
			if(StringHelper.isNullOrEmpty(strAction)){
				return StringHelper.format("%1$s__%2$s",this.strServiceActionDETag,strActionType).toUpperCase();
			}
			return StringHelper.format("%1$s__%2$s__%3$s",this.strServiceActionDETag,strActionType,strAction).toUpperCase();
		}
	}

	@Override
	public boolean isUseServiceAPI() {
		if(this.getStorageMode() == IDataEntity.STORAGEMODE_SERVICEAPI)
			return true;
		return this.getSystemRuntime().isDEUseServiceAPI(this);
	}

	@Override
	public IServiceAPIClientModel getServiceAPIClientModel() throws Exception {
		if(StringHelper.isNullOrEmpty(this.getServiceAPIClientId())){
			return this.getSystemRuntime().getServiceAPIClientModel();
		}
		return this.getSystemModel().getServiceAPIClientModel(getServiceAPIClientId());
	}

	@Override
	public String getDefaultDEDTSQueueId() {
		return this.strDefaultDEDTSQueueId;
	}
	
	
	/**
	 * 设置默认的实体分布事务队列标识
	 * @param strDefaultDEDTSQueueId
	 */
	public void setDefaultDEDTSQueueId(String strDefaultDEDTSQueueId){
		this.strDefaultDEDTSQueueId = strDefaultDEDTSQueueId;
	}

	@Override
	public int getDataAccCtrlArch() {
		return this.nDataAccCtrlArch;
	}
	
	
	/**
	 * 获取实体的数据访问控制体系
	 * @param nDataAccCtrlArch
	 */
	public void setDataAccCtrlArch(int nDataAccCtrlArch){
		this.nDataAccCtrlArch = nDataAccCtrlArch;
	}
	

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#registerDEUserRole(net.ibizsys.paas.core.IDEUserRole)
	 */
	@Override
	public void registerDEUserRole(IDEUserRole iDEUserRole) {
		if (!StringHelper.isNullOrEmpty(iDEUserRole.getId())){
			deUserRoleMap.put(iDEUserRole.getId(), iDEUserRole);
		}
	}
	
	
	@Override
	public IDEUserRole getDEUserRole(String strDEUserRoleId) throws Exception {
		IDEUserRole iDEUserRole = deUserRoleMap.get(strDEUserRoleId);
		if (iDEUserRole == null) {
			throw new Exception(StringHelper.format("无法获取实体用户角色对象[%1$s]", strDEUserRoleId));
		}

		return iDEUserRole;
	}

	@Override
	public Iterator<IDEUserRole> getDEUserRoles() {
		if (this.deUserRoleMap.size() == 0) return null;
		return this.deUserRoleMap.values().iterator();
	}

	@Override
	public void registerDEOPPrivRole(IDEOPPrivRole iDEOPPrivRole) {
		if(StringHelper.isNullOrEmpty(iDEOPPrivRole.getDEOPPrivTag()))
			return;
		
		ArrayList<IDEOPPrivRole> deOPPrivRoleList = this.deOPPrivRoleListMap.get(iDEOPPrivRole.getDEOPPrivTag());
		if(deOPPrivRoleList==null){
			deOPPrivRoleList = new ArrayList<IDEOPPrivRole> ();
			this.deOPPrivRoleListMap.put(iDEOPPrivRole.getDEOPPrivTag(), deOPPrivRoleList);
		}
		deOPPrivRoleList.add(iDEOPPrivRole);
	}
	
	

	@Override
	public Iterator<IDEOPPrivRole> getDEOPPrivRoles(String strDEOPrivTag) {
		ArrayList<IDEOPPrivRole> deOPPrivRoleList = this.deOPPrivRoleListMap.get(strDEOPrivTag);
		if(deOPPrivRoleList == null || deOPPrivRoleList.size()==0)
			return null;
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
	
	
	/**
	 * 设置审计主记录实体名称
	 * @param strAuditDEName
	 */
	public void setAuditDEName(String strAuditDEName){
		this.strAuditDEName = strAuditDEName;
	}
	
	
	/**
	 * 设置审计明细记录实体名称
	 * @param strAuditDetailDEName
	 */
	public void setAuditDetailDEName(String strAuditDetailDEName){
		this.strAuditDetailDEName = strAuditDetailDEName;
	}
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getDynaViewSetting()
	 */
	@Override
	public IDynaViewSetting getDynaViewSetting() {
		if( this.iDynaViewSetting==null){
			return this.getSystemModel().getDynaSystemSetting().getDynaViewSetting();
		}
		return this.iDynaViewSetting;
	}


	/**
	 * 设置实体的动态视图设置对象
	 * @param iDynaViewSetting
	 */
	public void setDynaViewSetting(IDynaViewSetting iDynaViewSetting) {
		this.iDynaViewSetting = iDynaViewSetting;
	}

	@Override
	public IDEDBConfig getDEDBConfig(String strDBType)  throws Exception{
		if(this.deDBConfigMap == null)
			return this;
		IDEDBConfig iDEDBConfig = this.deDBConfigMap.get(strDBType);
		if(iDEDBConfig!=null)
			return iDEDBConfig;
		return this;
	}


	@Override
	public void registerDEDBConfig(IDEDBConfig iDEDBConfig) {
		IDEDBConfigModel iDEDBConfigModel = (IDEDBConfigModel)iDEDBConfig;
		if(this.deDBConfigMap == null)
			this.deDBConfigMap = new HashMap<String, IDEDBConfig>();
		this.deDBConfigMap.put(iDEDBConfigModel.getDBType(), iDEDBConfig);
	}


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#toJSONObject(net.ibizsys.paas.entity.IEntity, boolean, int)
	 */
	@Override
	public JSONObject toJSONObject(IEntity iEntity, boolean bIncludeEmpty,int nOption) throws Exception {
		if(this.getSystemModel()!=null)
			return this.getSystemModel().toJSONObject(this, iEntity, bIncludeEmpty,nOption);
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

	/**
	 * 设设置实体是否支持动态存储
	 * @param bEnableDynaStorage
	 */
	public void setEnableDynaStorage(boolean bEnableDynaStorage){
		this.bEnableDynaStorage = bEnableDynaStorage;
	}

	@Override
	public String getDynaStorageDEName() {
		return this.strDynaStorageDEName;
	}
	
	/**
	 * 设置动态存储实体名称
	 * @param strDynaStorageDEName
	 */
	public void setDynaStorageDEName(String strDynaStorageDEName){
		this.strDynaStorageDEName = strDynaStorageDEName;
	}

	@Override
	public boolean hasDynaStorageDEField() {
		return this.bHasDynaStorageField;
	}

	@Override
	public String getInheritTypeValue() {
		return strInheritTypeValue;
	}
	
	/**
	 * 设置继承的类型值
	 * @param strInheritTypeValue
	 */
	protected void setInheritTypeValue(String strInheritTypeValue){
		this.strInheritTypeValue = strInheritTypeValue;
	}
	
	/**
	 * 是否登记到实体全局模型
	 * @return
	 */
	protected boolean isRegisterToDEModelGlobal(){
		return true;
	}
	
	@Override
	public IDEField getOrgIdDEField() {
		return this.orgIdDEField;
	}
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#isEnableTempData()
	 */
	@Override
	public boolean isEnableTempData() {
		return this.bEnableTempData;
	}

	/**
	 * 是否支持临时数据
	 * 
	 * @param bEnableTempData
	 */
	public void setEnableTempData(boolean bEnableTempData) {
		this.bEnableTempData = bEnableTempData;
	}
}
