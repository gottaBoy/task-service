package net.ibizsys.paas.report;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.report.util.PDFPrintHelper;
import net.ibizsys.paas.report.util.PrintDialogModes;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 打印服务基类
 * 
 * @author Administrator
 * 
 */
public abstract class PrintServiceBase extends ModelBaseImpl implements IPrintService {

	private static final Log log = LogFactory.getLog(PrintServiceBase.class);

	private String strDetailDEDataSetName = null;
	private boolean bEnableColPriv = false;
	private boolean bEnableLog = false;
	private boolean bEnableMultiPrint = false;
	private String strGetDataDEActionName = IService.ACTION_GET;
	private String strGetDataDataAccessAction = DataAccessActions.READ;
	private IDataEntity iDataEntity = null;
	private String strReportFilePath = null;
	private String strId = null;
	private String strName = null;
	private String strDetailDEName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#init(net.ibizsys.paas.core.IDataEntity)
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
			PrintServiceGlobal.registerPrintService(this.getId(), this);
		}
	}

	/**
	 * 获取实体模型对象
	 * 
	 * @return the iDataEntity
	 */
	public IDataEntity getDataEntity() {
		return iDataEntity;
	}

	/**
	 * 设置实体模型对象
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#getDEModel()
	 */
	@Override
	public IDataEntityModel getDEModel() {
		return (IDataEntityModel) this.getDataEntity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#getPrintFile(java.lang.String, net.ibizsys.paas.web.IWebContext, org.hibernate.SessionFactory, java.lang.String, java.lang.String)
	 */
	@Override
	public String getPrintFile(String strKeys, IWebContext iWebContext, SessionFactory sessionFactory, String strContentType, String strPrintFileFolder) throws Exception {
		if (net.ibizsys.paas.util.StringHelper.isNullOrEmpty(strKeys)) {
			throw new ErrorException(net.ibizsys.paas.core.Errors.INVALIDDATAKEYS, "没有打印数据键值");
		}
		IService iService = this.getDEModel().getService(sessionFactory);

		// 判断是否作为多项数据打印
		if (this.isEnableMulitPrint()) {
			return doMulitplePrintInDataSource(strKeys, iService, iWebContext, strContentType, strPrintFileFolder);
		}

		// 多选导出模式--拦截
		String strPrintMode = iWebContext.getParamValue("PRINTMODE");
		if (StringHelper.compare(strPrintMode, "MULTIPLE", true) == 0 && StringHelper.compare(strContentType, IPrintService.CONTENTTYPE_PDF, true) == 0) {
			// && strKeyValue.split(",").length>1
			return doMulitplePrint(strKeys, iService, iWebContext, strContentType, strPrintFileFolder);
		}

		// 查询对应的数据
		IEntity iEntity = this.getDEModel().createEntity();
		iEntity.set(this.getDEModel().getKeyDEField().getName(), strKeys);
		// 判断用户是否有访问数据的能力
		net.ibizsys.paas.core.CallResult callResult = iWebContext.getUserPrivilegeMgr().testDataAccessAction(iWebContext, this.getDEModel(), iEntity, this.getGetDataDataAccessAction());
		if (callResult.getRetCode() != Errors.OK) {
			throw new ErrorException(net.ibizsys.paas.core.Errors.ACCESSDENY);
			// SendbackError(servletContext,
			// StringHelper.Format("检查用户数据权限发生错误,%1$s",
			// callResult.getErrorInfo()), strContentType, request, response);
		}

		iService.executeAction(this.getGetDataDEActionName(), iEntity);
		String strReportFile = getPrintFile(iEntity, iService, iWebContext, strContentType, strPrintFileFolder);
		return strReportFile;

	}

	/**
	 * 执行多数据打印
	 * 
	 * @param strContentType
	 * @param strDEId
	 * @param iDEHelper
	 * @param strKey
	 * @param strKeyMultiValue
	 * @param servletContext
	 * @param request
	 * @param response
	 */
	protected String doMulitplePrintInDataSource(String strKey, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception {
		ArrayList<IEntity> entityList = new ArrayList<IEntity>();
		String[] arrKeyValue = net.ibizsys.paas.util.StringHelper.splitEx(strKey);
		for (String strKeyValue : arrKeyValue) {
			// 查询对应的数据
			IEntity iEntity = this.getDEModel().createEntity();
			iEntity.set(this.getDEModel().getKeyDEField().getName(), strKeyValue);
			// 判断用户是否有访问数据的能力
			net.ibizsys.paas.core.CallResult callResult = iWebContext.getUserPrivilegeMgr().testDataAccessAction(iWebContext, this.getDEModel(), iEntity, this.getGetDataDataAccessAction());
			if (callResult.getRetCode() != Errors.OK) {
				throw new ErrorException(net.ibizsys.paas.core.Errors.ACCESSDENY);
				// SendbackError(servletContext,
				// StringHelper.Format("检查用户数据权限发生错误,%1$s",
				// callResult.getErrorInfo()), strContentType, request,
				// response);
			}

			iService.executeAction(this.getGetDataDEActionName(), iEntity);

			// 如果启用字段权限，要对控制的进行移除
			// if(this.isEnableColPriv())
			// {
			// IUserPrivilegeMgr iUserPrivilegeMgr =
			// iWebContext.getUserPrivilegeMgr();
			// for(IDEFHelper iDEFHelper:iDEHelper.GetDEFHelpers())
			// {
			// if(iDEFHelper.IsEnableDEFieldPriv())
			// {
			// int nRet = iUserPrivilegeMgr.TestColumn(servletContext,
			// StringHelper.Format("%1$s|%2$s",iDEHelper.getId(),iDEFHelper.getId()));
			// if(nRet == PrivilegeAbility.NONE)
			// {
			// dataEntity.RemoveParam(iDEFHelper.getName());
			// }
			// }
			// }
			// }

			entityList.add(iEntity);

		}

		String strReportFile = getPrintFile(entityList, iService, iWebContext, strContentType, strPrintFileFolder);
		// if (StringHelper.IsNullOrEmpty(strReportFile))
		// {
		// log.error(StringHelper.Format("生成报表文件失败"));
		// return;
		// }
		//
		// if(SendBackFile(strReportFile, strContentType, request, response))
		// {
		// if(printForm.getENABLELOG())
		// {
		// //判断是否需要增加日志
		// PrintLog printLog = new PrintLog();
		// printLog.setPRINTFORMID(printForm.getPRINTFORMID());
		// printLog.setFORMDATA(strKeyMultiValue);
		// IDEDataCtrl printLogDataCtrl =
		// servletContext.getGlobalHelper().getDAModelStorage().FindDEDataCtrl(SRFDAGlobal.DEID_PRINTLOG,
		// servletContext);
		// if(printLogDataCtrl!=null)
		// {
		// printLogDataCtrl.Save(true, printLog);
		// }
		// }
		// }

		return strReportFile;
	}

	/**
	 * 获取打印文件
	 * 
	 * @param entityList
	 * @param iService
	 * @param iWebContext
	 * @param strContentType
	 * @param strPrintFileFolder
	 * @return
	 * @throws Exception
	 */
	protected abstract String getPrintFile(ArrayList<IEntity> entityList, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception;

	/**
	 * 获取打印文件
	 * 
	 * @param entity
	 * @param iService
	 * @param iWebContext
	 * @param strContentType
	 * @param strPrintFileFolder
	 * @return
	 * @throws Exception
	 */
	protected abstract String getPrintFile(IEntity entity, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception;

	/**
	 * 执行多数据打印
	 * 
	 * @param strContentType
	 * @param strDEId
	 * @param iDEHelper
	 * @param strKey
	 * @param strKeyMultiValue
	 * @param servletContext
	 * @param request
	 * @param response
	 */
	protected String doMulitplePrint(String strKey, IService iService, IWebContext iWebContext, String strContentType, String strPrintFileFolder) throws Exception {
		ArrayList<String> arrPdfFiles = new ArrayList<String>();
		String[] arrKeyValue = net.ibizsys.paas.util.StringHelper.splitEx(strKey);
		for (String strKeyValue : arrKeyValue) {
			// 查询对应的数据
			IEntity iEntity = this.getDEModel().createEntity();
			iEntity.set(this.getDEModel().getKeyDEField().getName(), strKeyValue);
			// 判断用户是否有访问数据的能力
			net.ibizsys.paas.core.CallResult callResult = iWebContext.getUserPrivilegeMgr().testDataAccessAction(iWebContext, this.getDEModel(), iEntity, this.getGetDataDataAccessAction());
			if (callResult.getRetCode() != Errors.OK) {
				throw new ErrorException(net.ibizsys.paas.core.Errors.ACCESSDENY);
				// SendbackError(servletContext,
				// StringHelper.Format("检查用户数据权限发生错误,%1$s",
				// callResult.getErrorInfo()), strContentType, request,
				// response);
			}

			iService.executeAction(this.getGetDataDEActionName(), iEntity);
			String strReportFile = getPrintFile(iEntity, iService, iWebContext, strContentType, strPrintFileFolder);

			// //如果启用字段权限，要对控制的进行移除
			// if(printForm.getENABLECOLPRIV())
			// {
			// IUserPrivilegeMgr iUserPrivilegeMgr =
			// servletContext.GetUserPrivilegeMgr();
			// for(IDEFHelper iDEFHelper:iDEHelper.GetDEFHelpers())
			// {
			// if(iDEFHelper.IsEnableDEFieldPriv())
			// {
			// int nRet = iUserPrivilegeMgr.TestColumn(servletContext,
			// StringHelper.Format("%1$s|%2$s",iDEHelper.getId(),iDEFHelper.getId()));
			// if(nRet == PrivilegeAbility.NONE)
			// {
			// dataEntity.RemoveParam(iDEFHelper.getName());
			// }
			// }
			// }
			// }

			arrPdfFiles.add(strReportFile);// 获取各个打印表单
		}

		String strMergedPdfURL = File.createTempFile("MERGED_", ".pdf").getPath();
		PDFPrintHelper pdfPrintHelper = new PDFPrintHelper(strMergedPdfURL, arrPdfFiles, getPrintDialogMode(iWebContext));
		try {
			pdfPrintHelper.doMerge();
			pdfPrintHelper.close();
		} catch (Exception e) {

			pdfPrintHelper.close();
			throw e;
		}

		return strMergedPdfURL;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#getDEDataSetName()
	 */
	@Override
	public String getDEDataSetName() {
		return this.strDetailDEDataSetName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#isEnableColPriv()
	 */
	@Override
	public boolean isEnableColPriv() {
		return this.bEnableColPriv;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#isEnableLog()
	 */
	@Override
	public boolean isEnableLog() {
		return this.bEnableLog;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#isEnableMulitPrint()
	 */
	@Override
	public boolean isEnableMulitPrint() {
		return this.bEnableMultiPrint;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#getGetDataDEActionName()
	 */
	@Override
	public String getGetDataDEActionName() {
		return strGetDataDEActionName;
	}

	/**
	 * 设置实体数据集对象名称
	 * 
	 * @param strDEDataSetName
	 */
	public void setDEDataSetName(String strDetailDEDataSetName) {
		this.strDetailDEDataSetName = strDetailDEDataSetName;
	}

	/**
	 * 设置是否启用列权限控制
	 * 
	 * @param bEnableColPriv
	 */
	public void setEnableColPriv(boolean bEnableColPriv) {
		this.bEnableColPriv = bEnableColPriv;
	}

	/**
	 * 设置是否启用打印日志
	 * 
	 * @param bEnableLog
	 */
	public void setEnableLog(boolean bEnableLog) {
		this.bEnableLog = bEnableLog;
	}

	/**
	 * 设置是否支持多数据打印
	 * 
	 * @param bEnableMultiPrint
	 */
	public void setEnableMultiPrint(boolean bEnableMultiPrint) {
		this.bEnableMultiPrint = bEnableMultiPrint;
	}

	/**
	 * 设置获取数据实体行为名称
	 * 
	 * @param strGetDataDEActionName
	 */
	public void setGetDataDEActionName(String strGetDataDEActionName) {
		this.strGetDataDEActionName = strGetDataDEActionName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#getGetDataDataAccessAction()
	 */
	@Override
	public String getGetDataDataAccessAction() {
		return this.strGetDataDataAccessAction;
	}

	/**
	 * 获取获取数据判断操作
	 * 
	 * @param strGetDataDataAccessAction
	 */
	public void setGetDataDataAccessAction(String strGetDataDataAccessAction) {
		this.strGetDataDataAccessAction = strGetDataDataAccessAction;
	}

	/**
	 * 获取打印选择窗口模式
	 * 
	 * @param iWebContext
	 * @return
	 */
	protected String getPrintDialogMode(IWebContext iWebContext) {
		String strPrintDialogMode = iWebContext.getParamValue("SRFPRINTDIALOGMODE");
		if (StringHelper.isNullOrEmpty(strPrintDialogMode)) {
			strPrintDialogMode = WebConfig.getCurrent().getAttribute("PRINTDIALOGMODE", PrintDialogModes.NONE);
		}
		return strPrintDialogMode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#getReportFilePath()
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


	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.ModelBaseImpl#getId()
	 */
	@Override
	public String getId() {
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
	 * 填充数据搜索条件
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
	 * 添加获取数据Url条件
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
	 * 添加获取数据搜索表单条件
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
	 * @param daQueryModelHelper
	 */
	protected void onFillFetchSearchFormCSMConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {

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
	 * 获取网络请求上下文对象
	 * 
	 * @return
	 */
	protected IWebContext getWebContext() {
		return WebContext.getCurrent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.report.IPrintService#getCodeListText(java.lang.String, java.lang.String)
	 */
	@Override
	public String getCodeListText(String strCodeListId, String strValue) throws Exception {
		return CodeListGlobal.getCodeList(strCodeListId).getCodeListText(strValue, true);
	}

	@Override
	public String getDetailDEDataSetName() {
		return this.strDetailDEDataSetName;
	}
	
	/**
	 * 设置明细数据实体数据集合
	 * @param strDetailDEDataSetName
	 */
	public void setDetailDEDataSetName(String strDetailDEDataSetName){
		this.strDetailDEDataSetName = strDetailDEDataSetName;
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.report.IPrintService#getDetailDEName()
	 */
	@Override
	public String getDetailDEName() {
		return this.strDetailDEName;
	}
	
	
	/**
	 * 设置明细实体名称
	 * @param strDetailDEName
	 */
	public void setDetailDEName(String strDetailDEName){
		this.strDetailDEName = strDetailDEName;
	}
	
}
