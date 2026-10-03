package net.ibizsys.paas.report;

import java.util.ArrayList;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 报表服务基类
 * 
 * @author Administrator
 *
 */
public abstract class ReportServiceBase extends ModelBaseImpl implements IReportService {
	private String strAccessKey = null;

	private ArrayList<String> subReportList = new ArrayList<String>();

	private String strDEDataSetName = null;
	private boolean bEnableLog = false;
	private IDataEntity iDataEntity = null;
	private String strReportFilePath = null;
	private String strId = null;
	private String strName = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.ModelBaseImpl#onInit()
	 */
	protected void onInit() throws Exception {
		if (!StringHelper.isNullOrEmpty(this.getId())) {
			ReportServiceGlobal.registerReportService(this.getId(), this);
		}
	}

	/**
	 * 获取实体对象
	 * 
	 * @return the iDataEntity
	 */
	public IDataEntity getDataEntity() {
		return iDataEntity;
	}

	/**
	 * 设置实体对象
	 * 
	 * @param iDataEntity the iDataEntity to set
	 */
	protected void setDataEntity(IDataEntity iDataEntity) {
		this.iDataEntity = iDataEntity;
	}

	/**
	 * 获取系统模型
	 * 
	 * @return
	 */
	protected ISystemModel getSystemModel() {
		return (ISystemModel) this.getDataEntity().getSystem();
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	public IDataEntityModel getDEModel() {
		return (IDataEntityModel) this.getDataEntity();
	}

	/**
	 * 注册子报表
	 * 
	 * @param strReportId
	 */
	public void registerSubReport(String strReportId) {
		this.subReportList.add(strReportId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#getDEDataSetName()
	 */
	@Override
	public String getDEDataSetName() {
		return this.strDEDataSetName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#isEnableLog()
	 */
	@Override
	public boolean isEnableLog() {
		return this.bEnableLog;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#getAccessKey()
	 */
	@Override
	public String getAccessKey() {
		return strAccessKey;
	}

	/**
	 * 设置数据集合名称
	 * 
	 * @param strDEDataSetName
	 */
	public void setDEDataSetName(String strDEDataSetName) {
		this.strDEDataSetName = strDEDataSetName;
	}

	/**
	 * 设置是否启用报表查询日志
	 * 
	 * @param bEnableLog
	 */
	public void setEnableLog(boolean bEnableLog) {
		this.bEnableLog = bEnableLog;
	}

	/**
	 * 设置访问报表需要的资源标识
	 * 
	 * @param strAccessKey
	 */
	public void setAccessKey(String strAccessKey) {
		this.strAccessKey = strAccessKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#getReportFilePath()
	 */
	@Override
	public String getReportFilePath() {
		return strReportFilePath;
	}

	/**
	 * 设置报表文件路径
	 * 
	 * @param strReportFilePath
	 */
	public void setReportFilePath(String strReportFilePath) {
		this.strReportFilePath = strReportFilePath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getId()
	 */
	@Override
	public String getId() {
		// return getDELogic().id();
		return this.strId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IModelBase#getName()
	 */
	@Override
	public String getName() {
		// return getDELogic().name();
		return this.strName;
	}

	/**
	 * 设置标识
	 * 
	 * @param strId the strId to set
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName the strName to set
	 */
	public void setName(String strName) {
		this.strName = strName;
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
	 * 填充报表查询搜索条件
	 * 
	 * @param deDataSetFetchContextImpl
	 * @throws Exception
	 */
	protected void fillFetchConditions(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
		this.onFillFetchSearchFormCSMConditions(deDataSetFetchContextImpl.getConditionList());
		this.onFillFetchSearchFormConditions(deDataSetFetchContextImpl.getConditionList());
		this.onFillFetchURLConditions(deDataSetFetchContextImpl.getConditionList());
	}

	/**
	 * 填充报表查询URL搜索条件
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
		// String strQuickSearch = null;
		// IMDCtrlRender iMDCtrlRender = this.getMDCtrlRender();
		// if(iMDCtrlRender!=null)
		// strQuickSearch = iMDCtrlRender.getFetchQuickSearch();
		// if(StringHelper.isNullOrEmpty(strQuickSearch))
		// {
		// strQuickSearch = WebContext.getFetchQuickSearch(this.getWebContext());
		// }
		// if(!StringHelper.isNullOrEmpty(strQuickSearch))
		// {
		// IDEDataSetCond iDEDataSetCond = this.getFetchQuickSearchCondition(strQuickSearch);
		// if(iDEDataSetCond!=null)
		// {
		// userConditions.add(iDEDataSetCond);
		// }
		// }

		// if(isEnableParentCondition())
		// {
		// onFillFetchParentCondition(userConditions);
		// }

	}

	// /**
	// * 填充父数据条件
	// * @param userConditions
	// * @throws Exception
	// */
	// protected void onFillFetchParentCondition(ArrayList<IDEDataSetCond> userConditions) throws Exception
	// {
	// String strParentType = WebContext.getParentType(this.getWebContext());
	// if (StringHelper.isNullOrEmpty(strParentType))
	// return;
	//
	// String strParentKey = WebContext.getParentKey(this.getWebContext());
	// if (StringHelper.isNullOrEmpty(strParentKey))
	// {
	// DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
	// deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_CUSTOM);
	// deDataSetCondImpl.setCustomCond("1<>1");
	// userConditions.add(deDataSetCondImpl);
	// return;
	// }
	//
	// if( (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
	// || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0))
	// {
	// String strDER1N = WebContext.getDER1NId(this.getWebContext());
	// IDER1N der = (IDER1N) this.getSystemModel().getDER(strDER1N);
	// IDEField iDEFieldModel = this.getDEModel().getDEField(der.getPickupDEFName(), false);
	//
	// DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
	// deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
	// deDataSetCondImpl.setCondOp(ICondition.CONDOP_EQ);
	// deDataSetCondImpl.setDEFName(iDEFieldModel.getName());
	// deDataSetCondImpl.setCondValue(strParentKey);
	//
	// userConditions.add(deDataSetCondImpl);
	// return;
	// }
	// }

	/**
	 * 填充报表查询搜索表单条件
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
				if (StringHelper.isNullOrEmpty(strValue)) continue;

				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
				deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
				deDataSetCondImpl.setDEFName(defield.getName());
				deDataSetCondImpl.setCondValue(strValue);

				userConditions.add(deDataSetCondImpl);

			}
		}
	}

	/**
	 * 填充搜索表单自定义搜索条件
	 * 
	 * @param userConditions
	 */
	protected void onFillFetchSearchFormCSMConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {

	}

	/**
	 * 填充快速搜索条件
	 * 
	 * @param strQuickSearch
	 * @throws Exception
	 */
	protected IDEDataSetCond getFetchQuickSearchCondition(String strQuickSearch) throws Exception {
		return this.getDEModel().getFetchQuickSearchCondition(strQuickSearch);
	}

	/**
	 * 获取网络访问请求上下文对象
	 * 
	 * @return
	 */
	protected IWebContext getWebContext() {
		return WebContext.getCurrent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#getSubReportIds()
	 */
	@Override
	public java.util.Iterator<String> getSubReportIds() {
		return this.subReportList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#hasSubReport()
	 */
	@Override
	public boolean hasSubReport() {
		return this.subReportList.size() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IReportService#getCodeListText(java.lang.String, java.lang.String)
	 */
	@Override
	public String getCodeListText(String strCodeListId, String strValue) throws Exception {
		return CodeListGlobal.getCodeList(strCodeListId).getCodeListText(strValue, true);
	}

	public String getJSONArrayText(Object objValue) {
		return getJSONArrayText(JSONArray.fromObject(objValue),"name",",","");
	}

	public String getJSONArrayText(Object objValue, String strKey, String strSplit, String strDefault) {
		return getJSONArrayText(JSONArray.fromObject(objValue),strKey,strSplit,strDefault);
	}

	public String getJSONArrayText(JSONArray jaList) {
		return getJSONArrayText(jaList,"name",",","");
	}

	public String getJSONArrayText(JSONArray jaList, String strKey, String strSplit, String strDefault) {
		String strResult = strDefault;
		if(jaList != null) {
			for(int i=0;i<jaList.length();i++) {
				JSONObject jo = jaList.optJSONObject(i);
				String strText = jo.optString(strKey, "");
				if(!StringHelper.isNullOrEmpty(strText)) {
					if(!StringHelper.isNullOrEmpty(strResult))
						strResult += strSplit;
					strResult += strText;
				}
			}
		}
		return strResult;
	}
}
