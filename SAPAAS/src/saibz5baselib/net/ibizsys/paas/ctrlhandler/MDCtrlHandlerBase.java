package net.ibizsys.paas.ctrlhandler;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDataExport;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.IDEDataExportModel;
import net.ibizsys.paas.demodel.IDEUIActionModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.AccessDenyException;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.security.IUserRoleMgr2;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DEDataExportHelper;
import net.ibizsys.paas.util.DEDataImportTemplateHelper;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.FileHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.UserRoleData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 多数据部件后台处理对象
 * 
 * @author lionlau
 * 
 */
public abstract class MDCtrlHandlerBase extends CtrlHandlerBase implements IMDCtrlHandler {
	/**
	 * 启用用户排序
	 */
	private boolean bEnableUserSort = true;

	/**
	 * 二级排序属性
	 */
	private String strMinorSortField = "";

	/**
	 * 二级排序方向
	 */
	private String strMinorSortDir = "";

	/**
	 * 默认分页大小
	 */
	private int nDefaultPageSize = -1;

	/**
	 * 启用组织机构数据范围
	 */
	private boolean bEnableOrgDR = false;

	/**
	 * 启用组织部门数据范围
	 */
	private boolean bEnableSecDR = false;

	/**
	 * 启用组织部门业务条线代码
	 */
	private boolean bEnableSecBC = false;

	private long nOrgDR = 0;

	private long nSecDR = 0;

	private String strSecBC = "";

	private boolean bEnableUserDR = false;

	private String strUserDRAction = DataAccessActions.READ;

	private boolean bEnableItemPriv = false;

	private String strCustomDRMode = null;

	private String strCustomDRMode2 = null;

	private String strCustomDRModeParam = null;

	private String strCustomDRMode2Param = null;

	private String strDEDataExportId = null;
	
	private int nMaxExportRowCount = 1000;

	private String strActiveDataDELogicId = null;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang.String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.isNullOrEmpty(strAction)) {
			// 某些客户端默认请求
			return this.createFetchActionResult();
		}

		if (StringHelper.compare(strAction, ACTION_FETCH, true) == 0) {
			return onFetch();
		}

		if (StringHelper.compare(strAction, ACTION_EXPORTDATA, true) == 0) {
			return onExportData();
		}

		if (StringHelper.compare(strAction, ACTION_REMOVE, true) == 0) {
			return onRemove();
		}

		if (StringHelper.compare(strAction, ACTION_ADDBATCH, true) == 0) {
			return onAddBatch();
		}

		if (StringHelper.compare(strAction, ACTION_UIACTION, true) == 0) {
			return onUIAction();
		}
		
		if (StringHelper.compare(strAction, ACTION_LOADUIACTION, true) == 0) {
			return onLoadUIAction();
		}

		if (StringHelper.compare(strAction, ACTION_EXPORTMODEL, true) == 0) {
			return onExportModel();
		}

		if (StringHelper.compare(strAction, ACTION_EXPORTIMPTEMPL, true) == 0) {
			return onExportImpTempl();
		}
		
		if (StringHelper.compare(strAction, ACTION_ITEMTIP, true) == 0) {
			return onItemTip();
		}

		return super.onProcessAction(strAction);
	}

	/**
	 * 建立获取行为结果
	 * 
	 * @return
	 */
	protected MDAjaxActionResult createFetchActionResult() {
		return new MDAjaxActionResult();
	}

	/**
	 * 后台处理
	 */
	protected AjaxActionResult onFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);

		DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
		deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
		IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
		if (iMDCtrlRender != null) iMDCtrlRender.fillDEDataSetFetchContext(deDataSetFetchContextImpl);

		/**
		 * 20180828添加，增强上下文数据转化能力
		 */
		if(!StringHelper.isNullOrEmpty(this.getActiveDataDELogicId())){
			IEntity activeData = this.getService().getDEModel().createEntity();
			this.getService().executeLogic(this.getActiveDataDELogicId(), activeData);
			deDataSetFetchContextImpl.setActiveDataObject(activeData);
		}
		
		
		if (!this.isEnableUserSort()) {
			deDataSetFetchContextImpl.resetSortInfo();
		}
		if (!StringHelper.isNullOrEmpty(getMinorSortField())) {
			deDataSetFetchContextImpl.setSort2(getMinorSortField());
			deDataSetFetchContextImpl.setSort2Dir(getMinorSortDir());
		}

		if (this.getDefaultPageSize() > 0) {
			deDataSetFetchContextImpl.setDefaultPageSize(this.getDefaultPageSize());
		}

		fillFetchConditions(deDataSetFetchContextImpl);
		fillDEDataSetFetchContext(deDataSetFetchContextImpl);
		if (deDataSetFetchContextImpl.isCancel()) {
			mdAjaxActionResult.setTotalRow(0);
			mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
			mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
			return mdAjaxActionResult;
		} else {
			fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);

			DBFetchResult fetchResult = fetchDEDataSet(deDataSetFetchContextImpl);
			mdAjaxActionResult.setTotalRow(fetchResult.getTotalRow());
			mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
			mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
			fillFetchResult(mdAjaxActionResult, fetchResult.getDataSet().getDataTable(0));
			fetchResult.getDataSet().close();
			return mdAjaxActionResult;
		}
	}

	/**
	 * 导出数据
	 */
	protected AjaxActionResult onExportData() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);

		DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
		deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
		IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
		if (iMDCtrlRender != null) iMDCtrlRender.fillDEDataSetFetchContext(deDataSetFetchContextImpl);

		/**
		 * 20180828添加，增强上下文数据转化能力
		 */
		if(!StringHelper.isNullOrEmpty(this.getActiveDataDELogicId())){
			IEntity activeData = this.getService().getDEModel().createEntity();
			this.getService().executeLogic(this.getActiveDataDELogicId(), activeData);
			deDataSetFetchContextImpl.setActiveDataObject(activeData);
		}
		
		
		if (!this.isEnableUserSort()) {
			deDataSetFetchContextImpl.resetSortInfo();
		}
		if (!StringHelper.isNullOrEmpty(getMinorSortField())) {
			deDataSetFetchContextImpl.setSort2(getMinorSortField());
			deDataSetFetchContextImpl.setSort2Dir(getMinorSortDir());
		}

		if (this.getDefaultPageSize() > 0) {
			deDataSetFetchContextImpl.setDefaultPageSize(this.getDefaultPageSize());
		}

		fillFetchConditions(deDataSetFetchContextImpl);
		fillDEDataSetFetchContext(deDataSetFetchContextImpl);
		if (deDataSetFetchContextImpl.isCancel()) {
			mdAjaxActionResult.setTotalRow(0);
			mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
			mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
			return mdAjaxActionResult;
		} else {
			fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);

			DBFetchResult fetchResult = fetchDEDataSet(deDataSetFetchContextImpl);
			mdAjaxActionResult.setTotalRow(fetchResult.getTotalRow());
			mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
			mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
			fillExportFileEx(mdAjaxActionResult, fetchResult.getDataSet().getDataTable(0), EXPORTTYPE_EXCEL);
			fetchResult.getDataSet().close();
			return mdAjaxActionResult;
		}
	}

	/**
	 * 获取实体数据集合结果
	 * 
	 * @param deDataSetFetchContextImpl
	 * @return
	 * @throws Exception
	 */
	protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 填充导出文件扩展，如存在处理实体数据导出逻辑，按导出逻辑处理，否则按默认调用处理
	 * 
	 * @param fetchResult
	 * @param dt
	 * @param strType
	 * @throws Exception
	 */
	protected void fillExportFileEx(MDAjaxActionResult fetchResult, IDataTable dt, String strType) throws Exception {
		if (!StringHelper.isNullOrEmpty(this.getDEDataExportId())) {

			String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new java.util.Date());
			if (StringHelper.compare(strType, EXPORTTYPE_EXCEL, true) == 0) {
				IDEDataExport iDEDataExport = this.getDEModel().getDEDataExport(this.getDEDataExportId());
				String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");
				DEDataExportHelper.output(strTempFilePath, dt, (IDEDataExportModel) iDEDataExport, this.getWebContext(), this.isEnableItemPriv());
				String strDownloadTmpFileUrl = this.getViewController().getAppModel().getUtilPageUrl(IApplicationModel.UTILPAGE_DOWNLOADTMPFILE);
				String strDownloadUrl = StringHelper.format("%1$sFILEID=%2$s", strDownloadTmpFileUrl, WebUtility.encodeURLParamValue(strTempFileName + ".xls"));
				fetchResult.setDownloadPath(strDownloadUrl);
				return;
			}
			return;
		}
		this.fillExportFile(fetchResult, dt, strType);
	}

	/**
	 * 填充导出文件
	 * 
	 * @param fetchResult
	 * @param dt
	 * @param strType
	 * @throws Exception
	 */
	protected void fillExportFile(MDAjaxActionResult fetchResult, IDataTable dt, String strType) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 批添加
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onAddBatch() throws Exception {
		AjaxActionResult ajaxActionResult = new AjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(ajaxActionResult);

		String strKeys = WebContext.getKeys(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKeys)) {
			strKeys = WebContext.getKey(this.getWebContext());
		}

		if (StringHelper.isNullOrEmpty(strKeys)) {
			ajaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return ajaxActionResult;
		}

		String[] keys = strKeys.split("[;]");
		addEntities(keys);

		return ajaxActionResult;
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onRemove() throws Exception {
		MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(ajaxActionResult);

		String strKeys = WebContext.getKeys(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKeys)) {
			strKeys = WebContext.getKey(this.getWebContext());
		}

		if (StringHelper.isNullOrEmpty(strKeys)) {
			ajaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return ajaxActionResult;
		}

		String[] keys = strKeys.split("[;]");

		// 判断权限
		String strDataAccessAction = this.getDataAccessAction(ACTION_REMOVE);
		CallResult callResult = this.testDataAccessAction( strDataAccessAction);
		if (!callResult.isOk()) {
			ajaxActionResult.setRetCode(Errors.ACCESSDENY);
			ajaxActionResult.setErrorInfo(callResult.getErrorInfo());
			return ajaxActionResult;
		}
		for (String strKey : keys) {
			IEntity iEntity = getSimpleEntity(strKey);
			if (iEntity != null) {
				callResult = this.testDataAccessAction(iEntity, strDataAccessAction);
				if (!callResult.isOk()) {
					ajaxActionResult.setRetCode(Errors.ACCESSDENY);
					ajaxActionResult.setErrorInfo(callResult.getErrorInfo());
					return ajaxActionResult;
				}
			}
		}

		removeEntities(keys);
		ajaxActionResult.setReloadData(true);
		return ajaxActionResult;
	}

	/**
	 * 批删除数据
	 * 
	 * @param keys
	 * @throws Exception
	 */
	protected void removeEntities(String[] keys) throws Exception {
		for (String strKey : keys) {
			this.removeEntity(strKey);
		}
	}

	/**
	 * 填充获取数据上下文对象
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		onFillDEDataSetFetchContext(deDataSetFetchContextImpl);
	}

	/**
	 * 填充获取数据上下文对象
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void onFillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {

	}

	/**
	 * 填充搜索条件
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillFetchConditions(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		// 获取动态条件
		if (this.getTempMode() != TEMPMODE_NONE || WebContext.isTempMode(this.getWebContext())) {
			onFillTempDataConditions(deDataSetFetchContextImpl.getConditionList());
		}
		this.onFillFetchSearchFormCSMConditions(deDataSetFetchContextImpl.getConditionList());
		this.onFillFetchSearchFormConditions(deDataSetFetchContextImpl.getConditionList());
		this.onFillFetchURLConditions(deDataSetFetchContextImpl.getConditionList());

	}

	/**
	 * 填充临时数据搜索条件
	 * 
	 * @param userConditions
	 */
	protected void onFillTempDataConditions(ArrayList<IDEDataSetCond> userConditions) {
		DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
		deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
		deDataSetCondImpl.setCustomCond("t1.SRFDRAFTFLAG = 0");
		userConditions.add(deDataSetCondImpl);
	}

	/**
	 * 填充来自URL的搜索条件
	 * 
	 * @param userConditions
	 * @throws Exception
	 */
	protected void onFillFetchURLConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
		String strFetchCond = WebContext.getFetchCond(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strFetchCond)) {
			JSONObject jo = JSONObjectHelper.fromString(strFetchCond);
			java.util.Iterator conds = jo.keys();
			while (conds.hasNext()) {
				String strCond = (String) conds.next();
				String objValue = jo.optString(strCond, null);
				IDEFSearchMode iDEFSearchMode = this.getDEModel().getDEFSearchMode(strCond, false);

				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
				deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
				deDataSetCondImpl.setDEFName(iDEFSearchMode.getDEFName());
				deDataSetCondImpl.setCondValue(objValue);
				userConditions.add(deDataSetCondImpl);
			}
		}
		String strQuickSearch = null;
		IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
		if (iMDCtrlRender != null) strQuickSearch = iMDCtrlRender.getFetchQuickSearch();
		if (StringHelper.isNullOrEmpty(strQuickSearch)) {
			strQuickSearch = WebContext.getFetchQuickSearch(this.getWebContext());
		}
		if (!StringHelper.isNullOrEmpty(strQuickSearch)) {
			IDEDataSetCond iDEDataSetCond = this.getFetchQuickSearchCondition(strQuickSearch);
			if (iDEDataSetCond != null) {
				userConditions.add(iDEDataSetCond);
			}
		}

		if (isEnableParentCondition()) {
			onFillFetchParentCondition(userConditions);
		}

	}


	
	/**
	 * 填充父数据条件
	 * 
	 * @param userConditions
	 * @throws Exception
	 */
	protected void onFillFetchParentCondition(ArrayList<IDEDataSetCond> userConditions) throws Exception {
		String strParentType = WebContext.getParentType(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strParentType)) return;

		String strParentKey = WebContext.getParentKey(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strParentKey)) {
			DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
			deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
			deDataSetCondImpl.setCustomCond("1<>1");
			userConditions.add(deDataSetCondImpl);
			return;
		}

		if ((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)) {
			String strDER1N = WebContext.getDER1NId(this.getWebContext());
			IDER1N der = (IDER1N) this.getSystemModel().getDER(strDER1N);
			IDEField iDEFieldModel = this.getDEModel().getDEField(der.getPickupDEFName(), false);

			DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
			deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
			deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
			deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
			deDataSetCondImpl.setCondValue(strParentKey);

			userConditions.add(deDataSetCondImpl);
			return;
		}
	}

	/**
	 * 填充搜索表单搜索条件
	 * 
	 * @param userConditions
	 * @throws Exception
	 */
	protected void onFillFetchSearchFormConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
		java.util.Iterator<IDEField> deFields = this.getDEModel().getDEFields();
		while (deFields.hasNext()) {
			IDEField defield = deFields.next();
			java.util.Iterator<IDEFSearchMode> defSearchModes = defield.getDEFSearchModes();
			if (defSearchModes == null) continue;

			while (defSearchModes.hasNext()) {
				IDEFSearchMode iDEFSearchMode = defSearchModes.next();

				String strFormItemId = iDEFSearchMode.getName();
				String strValue = getWebContext().getPostValue(strFormItemId.toLowerCase());
				if (StringHelper.isNullOrEmpty(strValue)){
					continue;
				}

				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
				deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
				deDataSetCondImpl.setDEFName(defield.getName());
				deDataSetCondImpl.setValueFunc(iDEFSearchMode.getValueFunc());
				deDataSetCondImpl.setCondValue(strValue);
				
				userConditions.add(deDataSetCondImpl);
			}
		}
	}

	/**
	 * 填充搜索表单自定义搜索条件
	 * 
	 * @param userConditions
	 * @param daQueryModelHelper
	 */
	protected void onFillFetchSearchFormCSMConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
		String strCustomSearchVal = this.getWebContext().getPostValue("customsearchval");
   		
   		if(!StringHelper.isNullOrEmpty(strCustomSearchVal)){
   			JSONObject jo = JSONObjectHelper.fromString(strCustomSearchVal);
   			DEDataSetCond cond = this.getCSMConditon(jo);
   			if(cond != null)
   				userConditions.add(cond);
   		}
	}

	protected DEDataSetCond getCSMConditon(JSONObject jo) throws Exception{
   		if(!jo.has("condtype") || !jo.has("condop"))
   			return null;
   		
   		DEDataSetCond cond = new DEDataSetCond();
   		String strCondType = jo.get("condtype").toString();
   		String strCondOP = jo.get("condop").toString();
   		boolean bNotMode = jo.getBoolean("notmode");
   		
   		cond.setCondType(strCondType);
   		cond.setCondOp(strCondOP);
   		cond.setNotMode(bNotMode);
   		
   		if(StringHelper.compare(strCondType, IDEDataSetCond.CONDTYPE_GROUP, true)==0){
   			if(!jo.has("items") || jo.get("items") == null)
   				return null;
   			
   			JSONArray arr = JSONArray.fromString(jo.get("items").toString());
   			for(int i=0,len=arr.length();i<len;i++){
   				JSONObject joChild = (JSONObject) arr.get(i);
   				DEDataSetCond condChild = this.getCSMConditon(joChild);
   				if(condChild != null)
   					cond.addChildDEDataQueryCond(condChild);
   			}
   		}else{
   			if(!jo.has("defid") || jo.get("defid") == null)
   				return null;
   			
   			cond.setDEFName(jo.get("defid").toString());
   			if(jo.has("condvalue") && jo.get("condvalue") != null)
   				cond.setCondValue(jo.get("condvalue").toString());
   			if(!jo.has("stddatatype") && jo.get("stddatatype") != null)
   				cond.setStdDataType(DataTypes.fromString(jo.get("stddatatype").toString()));
   		}
   		
   		return cond;
   	}
	/**
	 * 填充快速搜索条件
	 * 
	 * @param groupCondImpl
	 * @param strQuickSearch
	 * @throws Exception
	 */
	protected IDEDataSetCond getFetchQuickSearchCondition(String strQuickSearch) throws Exception {
		return this.getDEModel().getFetchQuickSearchCondition(strQuickSearch);
	}

	/**
	 * 是否启用父数据条件
	 * 
	 * @return
	 */
	protected boolean isEnableParentCondition() {
		return !this.getViewController().isPickupView();
	}

	/**
	 * 获取草稿实体数据
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IEntity getDraftEntity(String strParentType, String strTypeParam, String strParentKey, String strParentKey2) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 获取业务数据对象
	 * 
	 * @param objKeyValue
	 * @return
	 * @throws Exception
	 */
	protected IEntity getEntity(Object objKeyValue) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 建立业务数据对象
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	protected IEntity createEntity(IEntity iEntity) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 更新业务数据对象
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	protected IEntity updateEntity(IEntity iEntity) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 移除业务数据对象
	 * 
	 * @param objKeyValue
	 * @throws Exception
	 */
	protected void removeEntity(Object objKeyValue) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 获取草稿实体数据
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IEntity getDraftEntity() throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 批添加数据
	 * 
	 * @param keys
	 * @throws Exception
	 */
	protected void addEntities(String[] keys) throws Exception {
		// 判断有无父数据
		String strParentType = WebContext.getParentType(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strParentType)) {
			throw new Exception(StringHelper.format("没有指定父数据类型"));
		}

		String strTypeParam = "";
		if ((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)) {
			strTypeParam = WebContext.getDER1NId(this.getWebContext());
		}

		String strParentKey = WebContext.getParentKey(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strParentKey)) {
			throw new Exception(StringHelper.format("没有指定父数据"));
		}

		for (String strKey : keys) {
			IEntity iEntity = getDraftEntity(strParentType, strTypeParam, strParentKey, strKey);
			if (this.getTempMode() != ICtrlHandler.TEMPMODE_NONE) {
				if (!EntityBase.isDraft(iEntity)) continue;
			} else if (this.getViewController().getService().checkKey(iEntity) != IService.CHECKKEYSTATE_OK) continue;

			// 建立数据
			this.createEntity(iEntity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#isEnableUserSort()
	 */
	protected boolean isEnableUserSort() {
		return this.bEnableUserSort;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#getMinorSortField()
	 */
	protected String getMinorSortField() {
		return this.strMinorSortField;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlmodel.IGridModel#getMinorSortDir()
	 */
	protected String getMinorSortDir() {
		return this.strMinorSortDir;
	}

	/**
	 * 设置是否允许用户排序
	 * 
	 * @param bEnableUserSort the bEnableUserSort to set
	 */
	protected void setEnableUserSort(boolean bEnableUserSort) {
		this.bEnableUserSort = bEnableUserSort;
	}

	/**
	 * 设置默认排序字段
	 * 
	 * @param strMinorSortField the strMinorSortField to set
	 */
	protected void setMinorSortField(String strMinorSortField) {
		this.strMinorSortField = strMinorSortField;
	}

	/**
	 * 设置默认排序方向
	 * 
	 * @param strMinorSortDir the strMinorSortDir to set
	 */
	protected void setMinorSortDir(String strMinorSortDir) {
		this.strMinorSortDir = strMinorSortDir;
	}

	/**
	 * 获取默认分页大小
	 * 
	 * @return
	 */
	protected int getDefaultPageSize() {
		return nDefaultPageSize;
	}

	/**
	 * 设置默认分页大小
	 * 
	 * @param nDefaultPageSize
	 */
	protected void setDefaultPageSize(int nDefaultPageSize) {
		this.nDefaultPageSize = nDefaultPageSize;
	}

	/**
	 * 处理用户界面行为
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onUIAction() throws Exception {
		// 获取对应的行为
		String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
		IDEUIActionModel iDEUIActionModel = (IDEUIActionModel) this.getDEModel().getDEUIAction(strDEUIActionId);
		return this.doUIAction(iDEUIActionModel);
	}
	
	
	/**
	 * 加载界面行为运行时模型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadUIAction() throws Exception {
		String strDEUIActionId = WebContext.getUIActionId(this.getWebContext());
		IDEUIActionModel iDEUIActionModel = (IDEUIActionModel) this.getDEModel().getDEUIAction(strDEUIActionId);
		return onLoadUIAction(iDEUIActionModel);
	}
	
	
	
	/**
	 * 加载界面行为运行时模型
	 * @param iDEUIActionModel
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
		return iDEUIActionModel.getRuntimeModelAjaxActionResult(this.getSessionFactory());
	}
	

	/**
	 * 处理用户界面行为
	 * 
	 * @param iDEUIActionModel 界面行为模型对象
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult doUIAction(IDEUIActionModel iDEUIActionModel) throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);
		IDataEntityModel iDEModel = iDEUIActionModel.getDEModel();
		if (StringHelper.compare(iDEUIActionModel.getActionTarget(), IDEUIAction.ACTIONTARGET_NONE, true) == 0) {
			if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
				// 判断是否有指定行为
				CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), null, iDEUIActionModel.getDataAccessAction());
				if (callResult.isError()) {
					mdAjaxActionResult.from(callResult);
					return mdAjaxActionResult;
				}
			}
			iDEUIActionModel.execute(null, this.getSessionFactory());
		} else {
			String strKeys = WebContext.getKeys(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strKeys)) {
				strKeys = WebContext.getKey(this.getWebContext());
			}

			if (StringHelper.isNullOrEmpty(strKeys)) {
				mdAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
				return mdAjaxActionResult;
			}
			ArrayList entities = iDEModel.createEntityList();
			String[] keys = strKeys.split("[;]");
			for (int i = 0; i < keys.length; i++) {
				IEntity iEntity = iDEModel.createEntity();
				iEntity.set(iDEModel.getKeyDEField().getName(), keys[i]);
				// 判断权限
				if (!StringHelper.isNullOrEmpty(iDEUIActionModel.getDataAccessAction())) {
					if(StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false) == 0){
						IEntity iEntity2 = this.getSimpleEntity(keys[i]);
						if(iEntity2!=null){
							// 判断是否有指定行为
							CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), iEntity2, iDEUIActionModel.getDataAccessAction());
							if (callResult.isError()) {
								mdAjaxActionResult.from(callResult);
								return mdAjaxActionResult;
							}
							//相同主键，赋值
							if(DataTypeHelper.compare(iDEModel.getKeyDEField().getStdDataType(), iEntity.get(iDEModel.getKeyDEField().getName()), iEntity2.get(iDEModel.getKeyDEField().getName()))==0){
								iEntity  = iEntity2;
							}
						}
					}
					else{
						CallResult callResult = iDEModel.getDEDataAccMgr().test(this.getWebContext(), iEntity, iDEUIActionModel.getDataAccessAction());
						if (callResult.isError()) {
							mdAjaxActionResult.from(callResult);
							return mdAjaxActionResult;
						}
					}
				}
				if(this.getDEModel()!=null && (StringHelper.compare(this.getDEModel().getId(), iDEModel.getId(), false)!=0)){
					//放入当前部件的实体标识
					iEntity.set(IFormItem.DEID, this.getDEModel().getId());
				}
				entities.add(iEntity);
			}
			iDEUIActionModel.execute(entities, this.getSessionFactory());
		}
		mdAjaxActionResult.setReloadData(iDEUIActionModel.isReloadData());
		mdAjaxActionResult.setErrorInfo(iDEUIActionModel.getSuccessMsg());
		if(iDEUIActionModel.isClosePopupView()){
			mdAjaxActionResult.setExtAttr(AjaxActionResult.ATTR_CLOSEPOPUPVIEW, iDEUIActionModel.isClosePopupView());
		}
		return mdAjaxActionResult;
	}

	/**
	 * 处理导出数据模型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onExportModel() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);

		String strKeys = WebContext.getKeys(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKeys)) {
			strKeys = WebContext.getKey(this.getWebContext());
		}

		if (StringHelper.isNullOrEmpty(strKeys)) {
			mdAjaxActionResult.setRetCode(Errors.INVALIDDATAKEYS);
			return mdAjaxActionResult;
		}

		ArrayList<JSONObject> jsonObjectList = new ArrayList<JSONObject>();
		String[] keys = strKeys.split("[;]");
		for (int i = 0; i < keys.length; i++) {
			IEntity iEntity = this.getDEModel().createEntity();
			iEntity.set(this.getDEModel().getKeyDEField().getName(), keys[i]);
			this.getService().exportModel(iEntity, jsonObjectList);
		}

		JSONObject rootNode = new JSONObject();
		rootNode.put("items", jsonObjectList.toArray());

		String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new java.util.Date());
		String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".ibzbak");

		// 写入到临时文件
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(strTempFilePath, false), "UTF-8");
		out.write(rootNode.toString());
		out.flush();
		out.close();

		String strDownloadTmpFileUrl = this.getViewController().getAppModel().getUtilPageUrl(IApplicationModel.UTILPAGE_DOWNLOADTMPFILE);
		String strDownloadUrl = StringHelper.format("%1$sFILEID=%2$s", strDownloadTmpFileUrl, WebUtility.encodeURLParamValue(strTempFileName + ".ibzbak"));
		mdAjaxActionResult.setDownloadPath(strDownloadUrl);
		return mdAjaxActionResult;
	}

	/**
	 * 处理导出导入数据模板
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onExportImpTempl() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = createFetchActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);

		String strTempFileName = StringHelper.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new java.util.Date());
		String strTempFilePath = FileHelper.getTmpFileName(this.getWebContext(), strTempFileName, ".xls");

		DEDataImportTemplateHelper.output(this.getDEModel(), strTempFilePath);

		String strDownloadTmpFileUrl = this.getViewController().getAppModel().getUtilPageUrl(IApplicationModel.UTILPAGE_DOWNLOADTMPFILE);
		String strDownloadUrl = StringHelper.format("%1$sFILEID=%2$s", strDownloadTmpFileUrl, WebUtility.encodeURLParamValue(strTempFileName + ".xls"));
		mdAjaxActionResult.setDownloadPath(strDownloadUrl);
		return mdAjaxActionResult;
	}
	
	
	/**
	 * 数据项提示
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onItemTip() throws Exception {
		throw new Exception("没有实现");
	}
	

	/**
	 * 获取当前部件绘制器
	 * 
	 * @return
	 */
	protected IMDCtrlRender getMDCtrlRender() throws Exception {
		ICtrlRender iCtrlRender = this.getCtrlRender();
		if (iCtrlRender == null) return null;
		return (IMDCtrlRender) iCtrlRender;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#isEnableOrgDR()
	 */
	@Override
	public boolean isEnableOrgDR() {
		return this.bEnableOrgDR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#isEnableSecDR()
	 */
	@Override
	public boolean isEnableSecDR() {
		return this.bEnableSecDR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#isEnableSecBC()
	 */
	@Override
	public boolean isEnableSecBC() {
		return this.bEnableSecBC;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#getOrgDR()
	 */
	@Override
	public long getOrgDR() {
		return this.nOrgDR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#getSecDR()
	 */
	@Override
	public long getSecDR() {
		return this.nSecDR;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#getSecBC()
	 */
	@Override
	public String getSecBC() {
		return this.strSecBC;
	}

	/**
	 * 设置是否启用组织数据范围
	 * 
	 * @param bEnableOrgDR the bEnableOrgDR to set
	 */
	protected void setEnableOrgDR(boolean bEnableOrgDR) {
		this.bEnableOrgDR = bEnableOrgDR;
	}

	/**
	 * 设置是否启用部门数据范围
	 * 
	 * @param bEnableSecDR the bEnableSecDR to set
	 */
	protected void setEnableSecDR(boolean bEnableSecDR) {
		this.bEnableSecDR = bEnableSecDR;
	}

	/**
	 * 设置是否启用部门业务代码
	 * 
	 * @param bEnableSecBC the bEnableSecBC to set
	 */
	protected void setEnableSecBC(boolean bEnableSecBC) {
		this.bEnableSecBC = bEnableSecBC;
	}

	/**
	 * 设置组织数据范围
	 * 
	 * @param nOrgDR the nOrgDR to set
	 */
	protected void setOrgDR(long nOrgDR) {
		this.nOrgDR = nOrgDR;
	}

	/**
	 * 设置部门数据范围
	 * 
	 * @param nSecDR the nSecDR to set
	 */
	protected void setSecDR(long nSecDR) {
		this.nSecDR = nSecDR;
	}

	/**
	 * 设置部门业务代码
	 * 
	 * @param strSecBC the strSecBC to set
	 */
	protected void setSecBC(String strSecBC) {
		this.strSecBC = strSecBC;
	}

	/**
	 * 是否启用用户数据范围
	 * 
	 * @return
	 */
	@Override
	public boolean isEnableUserDR() {
		return this.bEnableUserDR;
	}

	/**
	 * 设置是否启用用户数据范围
	 * 
	 * @param bEnableUserDR
	 */
	protected void setEnableUserDR(boolean bEnableUserDR) {
		this.bEnableUserDR = bEnableUserDR;
	}

	/**
	 * 获取用户数据范围对应的操作
	 * 
	 * @return
	 */
	@Override
	public String getUserDRAction() {
		return this.strUserDRAction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.IMDCtrlHandler#isEnableItemPriv()
	 */
	@Override
	public boolean isEnableItemPriv() {
		return this.bEnableItemPriv;
	}

	/**
	 * 设置是否启用列权限控制
	 * 
	 * @param bEnableItemPriv
	 */
	protected void setEnableItemPriv(boolean bEnableItemPriv) {
		this.bEnableItemPriv = bEnableItemPriv;
	}

	/**
	 * 填充获取的数据范围
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillDEDataSetFetchDataRange(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		/**
		 * 20180128修改：用户使用服务接口时不联合用户权限
		 */
		if(!this.isUseServiceAPI()){
			ArrayList<String> condList = new ArrayList<String>();
			// 启用用户权限
			if (this.isEnableUserDR() || this.isEnableOrgDR() || this.isEnableSecDR() || this.isEnableSecBC() || !StringHelper.isNullOrEmpty(this.getCustomDRMode()) || !StringHelper.isNullOrEmpty(this.getCustomDRMode2())) {
				if (StringHelper.isNullOrEmpty(this.getWebContext().getCurUserId())) {
					throw new AccessDenyException("用户还未登录",true);
				}
				IUserRoleMgr iUserRoleMgr = this.getWebContext().getUserRoleMgr();
				if (this.getWebContext().isSuperUser()) {
					condList.add("1=1");
				} else {
					if (this.isEnableUserDR()) {
						fillDEDataSetFetchUserDRCond(deDataSetFetchContextImpl,condList);
					}

					if (!this.isEnableUserDR() || condList.size() > 0 || this.getWebContext().isOrgAdmin()) {
						String strCode = iUserRoleMgr.getDEDataRangeCond(this.getService(), this, deDataSetFetchContextImpl);
						if (!StringHelper.isNullOrEmpty(strCode)) {
							condList.add(strCode);
						}
					}
				}

//				// 获取实体的组织维度
//				IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
//				IDEField secIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
//				DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
				fillDEDataSetFetchOrgDRCond(deDataSetFetchContextImpl,condList);
			}
		}
	}
	
	/**
	 * 填充数据集合获取机构数据范围条件
	 * @param deDataSetFetchContextImpl
	 * @param condList
	 * @throws Exception
	 */
	protected void fillDEDataSetFetchOrgDRCond(DEDataSetFetchContext deDataSetFetchContextImpl,ArrayList<String> condList ) throws Exception {
		// 获取实体的组织维度
		IDEField orgIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGID, true);
		IDEField secIdDEField = this.getDEModel().getDEFieldByPDT(IDEField.PREDEFINEDTYPE_ORGSECTORID, true);
		DEDataSetFetchContext.enableOrgDRCond(deDataSetFetchContextImpl, orgIdDEField, secIdDEField, condList);
	}

	/**
	 * 填充数据集合获取用户数据范围条件
	 * @param deDataSetFetchContextImpl
	 * @param condList
	 * @throws Exception
	 */
	protected void fillDEDataSetFetchUserDRCond(DEDataSetFetchContext deDataSetFetchContextImpl,ArrayList<String> condList ) throws Exception {
		IUserRoleMgr iUserRoleMgr = this.getWebContext().getUserRoleMgr();
		//判断实体使用的权限控制体系
		final int nDataAccCtrlArch = this.getDEModel().getDataAccCtrlArch();
		switch(nDataAccCtrlArch){
		case IDataEntity.DATAACCCTRLARCH_RTSYSROLE:{
				ArrayList<UserRoleData> list = iUserRoleMgr.getUserRoleDatas(this.getDEModel().getId(), this.getUserDRAction());
				if (list != null) {
					for (UserRoleData userRoleData : list) {
						String strCode = iUserRoleMgr.getUserRoleDataCond(this.getService(), userRoleData, deDataSetFetchContextImpl);
						if (!StringHelper.isNullOrEmpty(strCode)) {
							condList.add(strCode);
						}
					}
				}
			}
			break;
		case IDataEntity.DATAACCCTRLARCH_SYSROLE_DEROLE:{
				IUserRoleMgr2 iUserRoleMgr2 = WebContext.getUserRoleMgr2(this.getWebContext());
				String strCode = iUserRoleMgr2.getDEOPPrivRoleCond(this.getService(), this.getUserDRAction(), deDataSetFetchContextImpl);
				if (!StringHelper.isNullOrEmpty(strCode)) {
					condList.add(strCode);
				}
			}
			break;
		default:
			throw new Exception(StringHelper.format("无法识别的数据访问控制体系[%1$s]",nDataAccCtrlArch));
		}
		if(condList.size()==0){
			//没有定义权限，判断有没有父数据约束
			String strParentType = WebContext.getParentType(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strParentType)){
				return;
			}

			String strParentKey = WebContext.getParentKey(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strParentKey)) {
				return;
			}

			if ((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0)) {
				String strDER1N = WebContext.getDER1NId(this.getWebContext());
				IDER1N der = (IDER1N) this.getSystemModel().getDER(strDER1N);
				IDEField iDEFieldModel = this.getDEModel().getDEField(der.getPickupDEFName(), false);
				IEntity iEntity = this.getDEModel().createEntity();
				iEntity.set(iDEFieldModel.getName(), strParentKey);
				CallResult callResult = this.testDataAccessAction(iEntity, this.getUserDRAction());
				if(callResult.isOk()){
					//增加一个空白条件(后续有问题可以放入  1=1)
					condList.add("");
				}
				return;
			}
		}
	}
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataRange#getCustomDRMode()
	 */
	@Override
	public String getCustomDRMode() {
		return this.strCustomDRMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataRange#getCustomDRMode2()
	 */
	@Override
	public String getCustomDRMode2() {
		return this.strCustomDRMode2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataRange#getCustomDRModeParam()
	 */
	@Override
	public String getCustomDRModeParam() {
		return this.strCustomDRModeParam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEDataRange#getCustomDRMode2Param()
	 */
	@Override
	public String getCustomDRMode2Param() {
		return this.strCustomDRMode2Param;
	}

	/**
	 * 设置自定义数据范围模式
	 * 
	 * @param strCustomDRMode
	 */
	protected void setCustomDRMode(String strCustomDRMode) {
		this.strCustomDRMode = strCustomDRMode;
	}

	/**
	 * 设置自定义数据范围模式2
	 * 
	 * @param strCustomDRMode2
	 */
	protected void setCustomDRMode2(String strCustomDRMode2) {
		this.strCustomDRMode2 = strCustomDRMode2;
	}

	/**
	 * 设置自定义数据范围模式参数
	 * 
	 * @param strCustomDRModeParam
	 */
	protected void setCustomDRModeParam(String strCustomDRModeParam) {
		this.strCustomDRModeParam = strCustomDRModeParam;
	}

	/**
	 * 设置自定义数据范围模式2参数
	 * 
	 * @param strCustomDRMode2Param
	 */
	protected void setCustomDRMode2Param(String strCustomDRMode2Param) {
		this.strCustomDRMode2Param = strCustomDRMode2Param;
	}

	/**
	 * 获取实体数据导出标识
	 * 
	 * @return
	 */
	protected String getDEDataExportId() {
		return this.strDEDataExportId;
	}

	/**
	 * 设置实体数据导出标识
	 * 
	 * @param strDEDataExportId the strDEDataExportId to set
	 */
	protected void setDEDataExportId(String strDEDataExportId) {
		this.strDEDataExportId = strDEDataExportId;
	}
	
	
	/**
	 * 获取实体数据导出最大记录数
	 * 
	 * @return
	 */
	protected int getMaxExportRowCount() {
		return this.nMaxExportRowCount;
	}

	/**
	 * 设置实体数据导出最大记录数
	 * 
	 * @param strDEDataExportId the strDEDataExportId to set
	 */
	protected void setMaxExportRowCount(int nMaxExportRowCount) {
		this.nMaxExportRowCount = nMaxExportRowCount;
	}
	
	
	@Override
	protected String getCacheDataTag(String strAction) throws Exception {
		if(StringHelper.compare(strAction, ACTION_FETCH, true)==0){
			DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
			deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
			IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
			if (iMDCtrlRender != null) iMDCtrlRender.fillDEDataSetFetchContext(deDataSetFetchContextImpl);

			
			if (!this.isEnableUserSort()) {
				deDataSetFetchContextImpl.resetSortInfo();
			}
			if (!StringHelper.isNullOrEmpty(getMinorSortField())) {
				deDataSetFetchContextImpl.setSort2(getMinorSortField());
				deDataSetFetchContextImpl.setSort2Dir(getMinorSortDir());
			}

			if (this.getDefaultPageSize() > 0) {
				deDataSetFetchContextImpl.setDefaultPageSize(this.getDefaultPageSize());
			}
			fillFetchConditions(deDataSetFetchContextImpl);
			fillDEDataSetFetchContext(deDataSetFetchContextImpl);
			if (!deDataSetFetchContextImpl.isCancel()) {
				fillDEDataSetFetchDataRange(deDataSetFetchContextImpl);
				if(deDataSetFetchContextImpl.getConditionList().size() > 0){
					return null;
				}
				
				String strDEDataSetFetchContext = StringHelper.format("%1$s|%2$s|%3$s|%4$s|%5$s|%6$s"
						,deDataSetFetchContextImpl.getStartRow()
						,deDataSetFetchContextImpl.getPageSize()
						,deDataSetFetchContextImpl.getSort()
						,deDataSetFetchContextImpl.getSortDir()
						,deDataSetFetchContextImpl.getSort2()
						,deDataSetFetchContextImpl.getSort2Dir());
				
				return KeyValueHelper.genUniqueId(StringHelper.format("%1$s|%2$s|%3$s|%4$s",this.getViewController().getId(),this.getCtrlModel().getId(),
						WebContext.getRender(this.getWebContext()),strDEDataSetFetchContext));
			}
			return null;
		}
		return super.getCacheDataTag(strAction);
	}
	
	

	/**
	 * 获取上下文数据计算逻辑
	 * @return
	 */
	public String getActiveDataDELogicId() {
		return this.strActiveDataDELogicId;
	}
	
	/**
	 * 设置上下文数据计算逻辑
	 * @param strActiveDataDELogicId
	 */
	protected void setActiveDataDELogicId(String strActiveDataDELogicId){
		this.strActiveDataDELogicId = strActiveDataDELogicId;
	}
}
