package net.ibizsys.ssdyna.service;

import net.ibizsys.model.der.IPSDER1N;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.saas.service.ServiceBase;
import net.ibizsys.ssdyna.dao.DynaDAO;
import net.ibizsys.ssdyna.demodel.IDynaDEModel;
import net.ibizsys.ssdyna.entity.DynaEntity;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * 动态实体服务对象接口实现
 * 
 * @author Administrator
 * 
 */
public class DynaService extends ServiceBase<DynaEntity> implements IDynaService<DynaEntity> {

	private IDynaDEModel<DynaEntity> iDynaDEModel = null;
	private DynaDAO psJITDAO = null;

	public void init(IDynaDEModel<DynaEntity> iDynaDEModel) throws Exception {
		this.iDynaDEModel = iDynaDEModel;

		psJITDAO = new DynaDAO();
		psJITDAO.setSessionFactory(iDynaDEModel.getDynaSysModel().getSessionFactory());
		psJITDAO.setDBDialect(iDynaDEModel.getDynaSysModel().getDBDialect());
		psJITDAO.init(iDynaDEModel);
	}

	/**
	 * 获取即时系统模型
	 * 
	 * @return
	 */
	public IDynaSysModel getDynaSysModel() {
		return this.iDynaDEModel.getDynaSysModel();
	}

//	/**
//	 * 获取实际实体对象
//	 * 
//	 * @return
//	 */
//	public IPSDataEntity getPSDataEntity() {
//		return this.iDynaDEModel.getPSDataEntity();
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.ServiceBase#getDEModel()
	 */
	@Override
	public IDataEntityModel<DynaEntity> getDEModel() {
		return this.iDynaDEModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.service.IService#getDAO()
	 */
	@Override
	public IDAO getDAO() {
		return this.psJITDAO;
	}

	/**
	 * 内部建立数据
	 * 
	 * @param entity
	 * @throws Exception
	 */
	@Override
	protected void internalCreate(DynaEntity et) throws Exception {
		if (getDEModel().getInheritDEModel() != null) {
			IEntity realET = getDEModel().getInheritDEModel().createEntity();
			et.copyTo(realET, false);
			if(!StringHelper.isNullOrEmpty(getDEModel().getInheritTypeValue())){
				realET.set(getDEModel().getInheritDEModel().getIndexTypeDEField().getName(), getDEModel().getInheritTypeValue());
			}
			IService iService = getDEModel().getInheritDEModel().getService(this.getSessionFactory());
			iService.create(realET, false);
			if (this.isEnableDynaStorage()) {
				internalCreateDynaStorage(et);
			}
			return;
		}
		super.internalCreate(et);
	}

	/**
	 * 内部更新数据
	 * 
	 * @param entity
	 * @throws Exception
	 */
	@Override
	protected void internalUpdate(DynaEntity et) throws Exception {
		if (getDEModel().getInheritDEModel() != null) {
			IEntity realET = getDEModel().getInheritDEModel().createEntity();
			et.copyTo(realET, false);
			IService iService = getDEModel().getInheritDEModel().getService(this.getSessionFactory());
			iService.update(realET, false);
			if (this.isEnableDynaStorage()) {
				internalUpdateDynaStorage(et);
			}
			return;
		}
		super.internalUpdate(et);
	}

	/**
	 * 内部系统更新数据
	 * 
	 * @param entity
	 * @throws Exception
	 */
	@Override
	protected void internalSysUpdate(DynaEntity et) throws Exception {
		if (getDEModel().getInheritDEModel() != null) {
			IEntity realET = getDEModel().getInheritDEModel().createEntity();
			et.copyTo(realET, false);
			
			IService iService = getDEModel().getInheritDEModel().getService(this.getSessionFactory());
			iService.sysUpdate(realET, false);
			if (this.isEnableDynaStorage()) {
				internalUpdateDynaStorage(et);
			}
			return;
		}
		super.internalSysUpdate(et);
	}

	/**
	 * 内部删除数据
	 * 
	 * @param entity
	 * @throws Exception
	 */
	@Override
	protected void internalRemove(DynaEntity et) throws Exception {

		if (getDEModel().getInheritDEModel() != null) {
			if (this.isEnableDynaStorage()) {
				internalRemoveDynaStorage(et);
			}
			IEntity realET = getDEModel().getInheritDEModel().createEntity();
			et.copyTo(realET, false);
			
			IService iService = getDEModel().getInheritDEModel().getService(this.getSessionFactory());
			iService.remove(realET);
			return;

		}
		super.internalRemove(et);
	}

	/**
	 * 内部获取数据
	 * 
	 * @param et
	 * @param bTryMode
	 * @param nViewLevel
	 * @throws Exception
	 */
	@Override
	protected CallResult internalGet(DynaEntity et, boolean bTryMode, int nViewLevel) throws Exception {

		if (getDEModel().getInheritDEModel() != null) {
			CallResult callResult = new CallResult();
			IEntity realET = getDEModel().getInheritDEModel().createEntity();
			et.copyTo(realET, false);
			IService iService = getDEModel().getInheritDEModel().getService(this.getSessionFactory());
			if (!iService.get(realET, bTryMode)) {
				callResult.setRetCode(Errors.INVALIDDATA);
				return callResult;
			}
			realET.copyTo(et, false);
			if (this.isEnableDynaStorage()) {
				internalGetDynaStorage(et);
			}
			et.setSessionFactory(getSessionFactory());
			et.markFullEntity(true);
			return callResult;
		}
		return super.internalGet(et, bTryMode, nViewLevel);
	}

	// <#if item.getAllPSDEBDTables()??>
	// <#list item.getAllPSDEBDTables() as bdtable>
	// private ${bdtable.getClassOrPkgName('BADAO',pub)}
	// ${srfparamname('${bdtable.getPSSysBDScheme().codeName}')}${bdtable.codeName}DAO
	// = null;
	// /**
	// * 获取实体大数据[${item.codeName}]数据操作对象
	// */
	// public ${bdtable.getClassOrPkgName('BADAO',pub)}
	// get${bdtable.getPSSysBDScheme().codeName}${bdtable.codeName}DAO() {
	// if(this.${srfparamname('${bdtable.getPSSysBDScheme().codeName}')}${bdtable.codeName}DAO==null){
	// try
	// {
	// this.${srfparamname('${bdtable.getPSSysBDScheme().codeName}')}${bdtable.codeName}DAO=
	// (${bdtable.getClassOrPkgName('BADAO',pub)})DAOGlobal.getDAO("${bdtable.getClassOrPkgName('BADAO',pub)}");
	// }
	// catch(Exception ex)
	// {
	// }
	// }
	// return
	// ${srfparamname('${bdtable.getPSSysBDScheme().codeName}')}${bdtable.codeName}DAO;
	// }
	// <#if bdtable_index == 0>
	// @Override
	// public net.ibizsys.psba.dao.IBADAO getBADAO() {
	// return
	// this.get${bdtable.getPSSysBDScheme().codeName}${bdtable.codeName}DAO();
	// }
	// </#if>
	// </#list>
	// </#if>

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.service.ServiceBase#onfetchDataSet(java.lang.String,
	 * net.ibizsys.paas.core.IDEDataSetFetchContext)
	 */
	@Override
	protected DBFetchResult onfetchDataSet(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
		DBFetchResult dbFetchResult = doServiceFetchWork(iDEDataSetFetchContext, strDataSetName, false);
		return dbFetchResult;
	}

	/**
	 * 获取数据集合
	 * 
	 * @param strDataSetName
	 * @param iDEDataSetFetchContext
	 * @return
	 * @throws Exception
	 */
	@Override
	protected DBFetchResult onfetchDataSetTemp(String strDataSetName, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
		DBFetchResult dbFetchResult = doServiceFetchWork(iDEDataSetFetchContext, strDataSetName, true);
		return dbFetchResult;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.service.ServiceBase#onExecuteAction(java.lang.String,
	 * net.ibizsys.paas.entity.IEntity)
	 */
	@Override
	protected void onExecuteAction(String strAction, IEntity entity) throws Exception {
		// <#list item.getAllPSDEActions() as deaction>
		// <#if deaction.actionType!='BUILTIN'>
		// if(StringHelper.compare(strAction,ACTION_${deaction.name?upper_case},true)==0){
		// this.${srfmethodname('${deaction.codeName}')}((DynaEntity)entity);
		// return;
		// }
		// </#if>
		// </#list>
		super.onExecuteAction(strAction, entity);
	}

	// <#list item.getAllPSDEActions() as deaction>
	// <#if deaction.getActionType()=='USERCUSTOM'>
	// /*
	// * 执行操作[${deaction.codeName}]
	// */
	// public void ${srfmethodname('${deaction.codeName}')}(DynaEntity
	// ${srfparamname('${item.codeName}')}) throws Exception{
	//
	// final DynaEntity ${srfparamname('${item.codeName}')}2 =
	// ${srfparamname('${item.codeName}')};
	// this.doServiceWork(new IServiceWork()
	// {
	// @Override
	// public void execute(ITransaction iTransaction) throws Exception
	// {
	// on${deaction.codeName}(${srfparamname('${item.codeName}')}2);
	// }
	// });
	// }
	//
	// /*
	// * 执行操作[${deaction.codeName}]
	// */
	// protected void on${deaction.codeName}(DynaEntity
	// ${srfparamname('${item.codeName}')}) throws Exception{
	//
	// throw new Exception("没有实现自定义行为[${deaction.name}]");
	// }
	//
	// </#if>
	// </#list>

	// <#list item.getAllPSDEActions() as deaction>
	// <#if deaction.getActionType()=='DELOGIC'>
	// /*
	// * 执行操作[${deaction.codeName}]
	// */
	// public void ${srfmethodname('${deaction.codeName}')}(DynaEntity
	// ${srfparamname('${item.codeName}')}) throws Exception{
	//
	// final DynaEntity et = ${srfparamname('${item.codeName}')};
	// et.setSessionFactory(this.getSessionFactory());
	// final IDELogicModel iDELogicModel = (IDELogicModel )
	// this.get${item.codeName}DEModel().getDELogic("${deaction.getPSDELogic().codeName}");
	// this.doServiceWork(new IServiceWork()
	// {
	// @Override
	// public void execute(ITransaction iTransaction) throws Exception
	// {
	// ActionContext actionContextImpl = new ActionContext(null);
	// actionContextImpl.setParam(iDELogicModel.getDefaultParamName(), et);
	// actionContextImpl.setSessionFactory(getSessionFactory());
	// iDELogicModel.execute(actionContextImpl);
	// }
	// });
	// }
	// </#if>
	// </#list>

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.service.ServiceBase#onFillParentInfo(net.ibizsys.paas
	 * .entity.IEntity, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	protected void onFillParentInfo(DynaEntity et, String strParentType, String strTypeParam, String strParentKey) throws Exception {
		
		java.util.Iterator<IDERBase> dERBases = this.getDEModel().getDERs(false);
		if(dERBases!=null) {
			while (dERBases.hasNext()) {
				IDERBase iPSDERBase = dERBases.next();
				if ((StringHelper.compare(iPSDERBase.getDERType(), "DER1N", false) == 0) || (StringHelper.compare(iPSDERBase.getDERType(), "DER11", false) == 0)) {

					if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0)) && (StringHelper.compare(strTypeParam, iPSDERBase.getName(), true) == 0)) {
						IService<IEntity> iService = this.getDynaSysModel().getDynaService(iPSDERBase.getMajorDEId(), this.getSessionFactory());
						IEntity parentEntity = iService.getDEModel().createEntity();
						parentEntity.set(iService.getDEModel().getKeyDEField().getName(), DataTypeHelper.parse(iService.getDEModel().getKeyDEField().getStdDataType(), strParentKey));
						if (strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
							iService.getTemp(parentEntity);
						else
							iService.get(parentEntity);
						this.onFillParentInfo_DER1N((IPSDER1N) iPSDERBase, et, parentEntity);
						return;
					}
				}
			}
		}
		

//		java.util.Iterator<IPSDERBase> psDERBases = this.getPSDataEntity().getPSDERs(false);
//		while (psDERBases.hasNext()) {
//			IPSDERBase iPSDERBase = psDERBases.next();
//			if ((StringHelper.compare(iPSDERBase.getDERType(), "DER1N", false) == 0) || (StringHelper.compare(iPSDERBase.getDERType(), "DER11", false) == 0)) {
//
//				if (((StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER1N, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_DER11, true) == 0) || (StringHelper.compare(strParentType, WebContext.PARAM_PARENTTYPE_SYSDER11, true) == 0)) && (StringHelper.compare(strTypeParam, iPSDERBase.getName(), true) == 0)) {
//					IService<IEntity> iService = this.getDynaSysModel().getDynaService(iPSDERBase.getMajorPSDataEntity(), this.getSessionFactory());
//					IEntity parentEntity = iService.getDEModel().createEntity();
//					parentEntity.set(iService.getDEModel().getKeyDEField().getName(), DataTypeHelper.parse(iService.getDEModel().getKeyDEField().getStdDataType(), strParentKey));
//					if (strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
//						iService.getTemp(parentEntity);
//					else
//						iService.get(parentEntity);
//					this.onFillParentInfo_DER1N((IPSDER1N) iPSDERBase, et, parentEntity);
//					return;
//				}
//			}
//		}


		super.onFillParentInfo(et, strParentType, strTypeParam, strParentKey);
	}

	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onSyncDER1NData(java.lang.String,
	// java.lang.String, java.lang.String)
	// */
	// @Override
	// protected String onSyncDER1NData(String strDER1NId, String strParentKey,
	// String strDatas) throws Exception
	// {
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DER1N' >
	// <#if (der.getSyncExportModelMode() gt 0)>
	// <#assign majorde=der.getMajorPSDataEntity()>
	// //关系类型 : ${der.getDERType()} ,主实体 :${majorde.name} / ${majorde.logicName}
	// if (StringHelper.compare(strDER1NId, "${der.name}", true)==0)
	// {
	// IService iService=
	// ServiceGlobal.getService("${majorde.getClassOrPkgName('SERVICE',pub)}",this.getSessionFactory());
	// ${majorde.getClassOrPkgName('ENTITY',pub)} parentEntity = (
	// ${majorde.getClassOrPkgName('ENTITY',pub)})iService.getDEModel().createEntity();
	// parentEntity.set(${majorde.getClassOrPkgName('ENTITY',pub)}.FIELD_${majorde.keyDEField.codeName?upper_case},strParentKey);
	// return this.onSyncDER1NData_${der.codeName}(parentEntity,strDatas);
	// }
	// </#if>
	// </#if>
	// </#list>
	// return super.onSyncDER1NData( strDER1NId, strParentKey, strDatas);
	// }

	/**
	 * 填充数据的父数据信息
	 * 
	 * @param et
	 *            当前数据对象
	 * @param parentEntity
	 *            父数据对象
	 * @throws Exception
	 */
	protected void onFillParentInfo_DER1N(IPSDER1N iPSDER1N, DynaEntity et, IEntity parentEntity) throws Exception {
//		java.util.Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
//		while (psDEFields.hasNext()) {
//			IPSDEField iPSDEField = psDEFields.next();
//			if (iPSDEField.isLinkDEField()) {
//				if (StringHelper.compare(((IPSLinkDEField) iPSDEField).getPSDER().getId(), iPSDER1N.getId(), false) == 0) {
//					et.set(iPSDEField.getName(), parentEntity.get(((IPSLinkDEField) iPSDEField).getRelatedPSDEField().getName()));
//				}
//			}
//		}
		
		// if (iPSDER1N.isEnablePDEREQ()) {
		// // 执行关系等价操作
		// if (parentEntity.get(iPSDER1N.getMajorPPSDER1N().getCodeName()) !=
		// null) {
		// String strParentKey =
		// DataObject.getStringValue(parentEntity.get(iPSDER1N.getMajorPPSDER1N().getCodeName()));
		// IService<IEntity> iService =
		// this.getDynaSysModel().getService(iPSDER1N.getMajorPPSDER1N().getMajorDEName(),
		// this.getSessionFactory());
		// IEntity parentEntity2 = iService.getDEModel().createEntity();
		// parentEntity2.set(iService.getDEModel().getKeyDEField().getName(),
		// parentEntity.get(iPSDER1N.getMajorPPSDER1N().getCodeName()));
		// if (strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
		// iService.getTemp(parentEntity2);
		// else
		// iService.get(parentEntity2);
		//
		// onFillParentInfo_DER1N(iPSDER1N.getMinorPPSDER1N(), et,
		// parentEntity2);
		// }
		// }

	}

	//
	// <#if (der.getSyncExportModelMode() gt 0)>
	// /**
	// * 同步父实体相关子数据
	// * @param parentEntity 父数据对象
	// * @param strDatas 数据主键
	// * @throws Exception
	// */
	// protected String
	// onSyncDER1NData_${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity,String strDatas) throws Exception
	// {
	// if(StringHelper.isNullOrEmpty(strDatas))
	// {
	// this.removeBy${der.codeName}(parentEntity);
	// }
	// else
	// {
	// HashMap<String, String> syncDataMap = new HashMap<String, String>();
	// String[] datas = StringHelper.splitEx(strDatas);
	// if (datas != null)
	// {
	// for (int i = 0; i < datas.length; i++)
	// {
	// if (StringHelper.isNullOrEmpty(datas[i]))
	// continue;
	// syncDataMap.put(datas[i], "");
	// }
	// }
	// ArrayList<${de.codeName}> list =
	// this.selectBy${der.codeName}(parentEntity);
	// for(${de.codeName} et:list)
	// {
	// if(!syncDataMap.containsKey(DataObject.getStringValue(et,${de.codeName}.FIELD_${de.getKeyPSDEField().codeName?upper_case},"")))
	// {
	// this.remove(et);
	// }
	// }
	// }
	// return null;
	// }
	// </#if>
	// </#if>
	// </#list>

//	/**
//	 * 填充主键
//	 * 
//	 * @param et
//	 * @return
//	 * @throws Exception
//	 */
//	@Override
//	protected boolean onFillEntityKeyValue(DynaEntity et, boolean bTempMode) throws Exception {
//		if (this.getPSDataEntity().getUnionKeyValuePSDEFields() != null) {
//			StringBuilderEx sb = new StringBuilderEx();
//			java.util.Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getUnionKeyValuePSDEFields();
//			boolean bFirst = true;
//			while (psDEFields.hasNext()) {
//				if (bFirst) {
//					bFirst = false;
//				} else {
//					sb.append("||");
//				}
//				IPSDEField iPSDEField = psDEFields.next();
//				Object objValue = et.get(iPSDEField.getName().toUpperCase());
//				if (objValue == null)
//					objValue = "__EMTPY__";
//				sb.append("%1$s", objValue);
//			}
//			String strValue = sb.toString();
//			if (this.getPSDataEntity().getKeyPSDEField().isPhisicalDEField()) {
//				et.set(this.getDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId(strValue));
//			} else {
//				et.set(this.getDEModel().getKeyDEField().getName(), strValue);
//			}
//
//			return true;
//		}
//		return super.onFillEntityKeyValue(et, bTempMode);
//
//	}

	@Override
	public boolean isDynaDETemplMode() {
		// TODO Auto-generated method stub
		return false;
	}

	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onFillEntityFullInfo(net.ibizsys.paas.entity.IEntity,
	// boolean)
	// */
	// @Override
	// protected void onFillEntityFullInfo(DynaEntity et, boolean bCreate)
	// throws Exception
	// {
	// <#assign firstflag=0>
	// //填充新建默认值
	// if(bCreate)
	// {
	// <#list item.getPSDEFields() as defield>
	// <#if defield.isPhisicalDEField() && (defield.getDefaultValueType()!='' ||
	// defield.getDefaultValue()!='')>
	// if(et.get${defield.codeName}()==null){
	// et.set${defield.codeName}((${srfjavatype(defield.stdDataType)})DefaultValueHelper.getValue(this.getWebContext(),"${defield.getDefaultValueType()}","${defield.getDefaultValue()}",${defield.stdDataType}));
	// }
	// <#assign firstflag=1>
	// </#if>
	// </#list>
	// }
	// super.onFillEntityFullInfo(et, bCreate);
	//
	// //填充物理化外键相关属性
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DER1N'>
	// <#assign majorde=der.getMajorPSDataEntity()>
	// //关系类型 : ${der.getDERType()} ,主实体 :${majorde.name} / ${majorde.logicName}
	// onFillEntityFullInfo_${der.codeName}(et, bCreate);
	// </#if>
	// </#list>
	// }
	//
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DER1N'>
	// <#assign majorde=der.getMajorPSDataEntity()>
	// <#assign pickupdefield=item.getPSDEField(der.getPickupDEFName())>
	// /**
	// * 填充实体的数据信息 ${majorde.logicName}
	// * @param et
	// * @param bCreate 是否建立
	// * @throws Exception
	// */
	// protected void onFillEntityFullInfo_${der.codeName}(DynaEntity et,
	// boolean bCreate) throws Exception
	// {
	// <#assign phyder=false>
	// <#list item.getPSDEFieldsByDER('${der.id}') as defield >
	// <#if ((defield.dataType!='PICKUP') && defield.isPhisicalDEField())>
	// <#assign phyder=true>
	// </#if>
	// </#list>
	// <#if (phyder)>
	// if(et.is${pickupdefield.codeName}Dirty())
	// {
	// if(et.get${pickupdefield.codeName}()!=null)
	// {
	// if(<#list item.getPSDEFieldsByDER('${der.id}') as defield ><#if
	// (defield_index>0)>||</#if>(<#if
	// (defield.isPhisicalDEField())>true<#else>false</#if>&&et.get${defield.codeName}()==null)</#list>)
	// {
	// ${majorde.getClassOrPkgName('ENTITY',pub)} parentEntity =
	// et.get${der.codeName}();
	// <#list item.getPSDEFieldsByDER('${der.id}') as defield >
	// <#if (defield.dataType!='PICKUP') >
	// et.set${defield.codeName}(parentEntity.get${defield.getRelatedPSDEField().codeName}());
	// </#if>
	// </#list>
	// }
	// <#if der.isEnablePDEREQ()>
	// if(true)
	// {
	// ${majorde.getClassOrPkgName('ENTITY',pub)} parentEntity =
	// et.get${der.codeName}();
	// //执行关系等价操作
	// if(DataTypeHelper.compare(${der.getMajorPPSDER1N().getPSPickupDEField().getStdDataType()?c},parentEntity.get${der.getMajorPPSDER1N().getPSPickupDEField().codeName}(),et.get${der.getMinorPPSDER1N().getPSPickupDEField().codeName}())!=0)
	// {
	// et.set${der.getMinorPPSDER1N().getPSPickupDEField().codeName}(parentEntity.get${der.getMajorPPSDER1N().getPSPickupDEField().codeName}());
	// onFillEntityFullInfo_${der.getMinorPPSDER1N().codeName}(et, bCreate) ;
	// }
	// }
	// </#if>
	//
	// }
	// else
	// {
	// <#list item.getPSDEFieldsByDER('${der.id}') as defield >
	// <#if (defield.dataType!='PICKUP') >
	// et.set${defield.codeName}(null);
	// </#if>
	// </#list>
	// }
	// }
	// </#if>
	// }
	// </#if>
	// </#list>
	//
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onWriteBackParent(net.ibizsys.paas.entity.IEntity,
	// boolean)
	// */
	// @Override
	// protected void onWriteBackParent(DynaEntity et, boolean bCreate) throws
	// Exception
	// {
	// super.onWriteBackParent(et, bCreate);
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DER1N'>
	// <#list item.getPSDEFieldsByDER('${der.id}') as defield >
	// <#if (defield.isEnableWriteBack()) >
	// onWriteBackParent_${der.codeName}(et, bCreate);
	// <#break>
	// </#if>
	// </#list>
	// </#if>
	// </#list>
	// }
	//
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DER1N'>
	// <#list item.getPSDEFieldsByDER('${der.id}') as defield >
	// <#if (defield.isEnableWriteBack()) >
	// <#assign majorde=der.getMajorPSDataEntity()>
	// <#assign pickupdefield=item.getPSDEField(der.getPickupDEFName())>
	// /**
	// * 回写父实体[${majorde.logicName}]数据
	// * @param et 当前数据对象
	// * @param bCreate 是否建立
	// * @throws Exception
	// */
	// protected void onWriteBackParent_${der.codeName}(DynaEntity et, boolean
	// bCreate) throws Exception
	// {
	// if(et.get${pickupdefield.codeName}()!=null && (false<#list
	// item.getPSDEFieldsByDER('${der.id}') as defield ><#if
	// (defield.isEnableWriteBack())>||et.is${defield.codeName}Dirty()</#if></#list>))
	// {
	// ${majorde.getClassOrPkgName('ENTITY',pub)} parentEntity = new
	// ${majorde.getClassOrPkgName('ENTITY',pub)}();
	// parentEntity.set${pickupdefield.getRelatedPSDEField().codeName}(et.get${pickupdefield.codeName}());
	// <#list item.getPSDEFieldsByDER('${der.id}') as defield >
	// <#if (defield.isEnableWriteBack()) >
	// if(et.is${defield.codeName}Dirty())
	// parentEntity.set${defield.getRelatedPSDEField().codeName}(
	// et.get${defield.codeName}());
	// </#if>
	// </#list>
	// String strParentKey =
	// DataObject.getStringValue(et.get${pickupdefield.codeName}());
	// ${majorde.getClassOrPkgName('SERVICE',pub)} parentService =
	// (${majorde.getClassOrPkgName('SERVICE',pub)})ServiceGlobal.getService(${majorde.getClassOrPkgName('SERVICE',pub)}.class,this.getSessionFactory());
	// if(strParentKey.indexOf(ServiceBase.TEMPKEY) == 0)
	// parentService.updateTemp(parentEntity,false);
	// else
	// parentService.update(parentEntity,false);
	// }
	// }
	// <#break>
	// </#if>
	// </#list>
	// </#if>
	// </#list>
	//
	//
	// <#if item.getPSDER1Ns(false,false)??>
	// <#list item.getPSDER1Ns(false,false) as der >
	// <#assign majorde=der.getMajorPSDataEntity()>
	// <#assign pickupdefield=item.getPSDEField(der.getPickupDEFName())>
	//
	// /**
	// * 通过关系[${majorde.logicName}]父数据查询数据
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// public java.util.ArrayList<DynaEntity>
	// selectBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}Base
	// parentEntity) throws Exception
	// {
	// return selectBy${der.codeName}( parentEntity,"");
	// }
	// /**
	// * 通过关系[${majorde.logicName}]父数据查询数据
	// * @param parentEntity 父数据
	// * @param strOrderInfo 排序信息
	// * @throws Exception
	// */
	// public java.util.ArrayList<DynaEntity>
	// selectBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}Base
	// parentEntity,String strOrderInfo) throws Exception
	// {
	// SelectCond selectCond = new SelectCond();
	// selectCond.setConditon(${item.codeName}.FIELD_${pickupdefield.codeName?upper_case},
	// parentEntity.get${pickupdefield.getRelatedPSDEField().codeName}());
	// selectCond.setOrderInfo(strOrderInfo);
	// onFillSelectBy${der.codeName}Cond(selectCond);
	// return this.select(selectCond);
	// }
	//
	// /**
	// * 填充关系[${majorde.logicName}]父数据查询附加条件
	// * @param selectCond 查询条件对象
	// * @throws Exception
	// */
	// protected void onFillSelectBy${der.codeName}Cond(SelectCond selectCond)
	// throws Exception
	// {
	//
	// }
	// <#if (der.getTempDataOrder()>=0)>
	// /**
	// * 通过关系[${majorde.logicName}]父数据查询数据（临时数据模式）
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// public java.util.ArrayList<DynaEntity>
	// selectTempBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}Base
	// parentEntity) throws Exception
	// {
	// return selectTempBy${der.codeName}( parentEntity,"");
	// }
	// /**
	// * 通过关系[${majorde.logicName}]父数据查询数据（临时数据模式）
	// * @param parentEntity 父数据
	// * @param strOrderInfo 排序信息
	// * @throws Exception
	// */
	// public java.util.ArrayList<DynaEntity>
	// selectTempBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}Base
	// parentEntity,String strOrderInfo) throws Exception
	// {
	// SelectCond selectCond = new SelectCond();
	// selectCond.setConditon(${item.codeName}.FIELD_${pickupdefield.codeName?upper_case},
	// parentEntity.get${pickupdefield.getRelatedPSDEField().codeName}());
	// selectCond.setOrderInfo(strOrderInfo);
	// onFillSelectTempBy${der.codeName}Cond(selectCond);
	// return this.selectTemp(selectCond);
	// }
	//
	// /**
	// * 填充关系[${majorde.logicName}]父数据查询附加条件（临时数据模式）
	// * @param selectCond 查询条件对象
	// * @throws Exception
	// */
	// protected void onFillSelectTempBy${der.codeName}Cond(SelectCond
	// selectCond) throws Exception
	// {
	//
	// }
	// </#if>
	// </#list>
	// </#if>
	//
	//
	//
	// <#if item.getPSDER1Ns(false,false)??>
	// <#list item.getPSDER1Ns(false,false) as der >
	// <#assign majorde=der.getMajorPSDataEntity()>
	// <#assign pickupdefield=item.getPSDEField(der.getPickupDEFName())>
	//
	// /**
	// * 判断是否能够通过关系[${majorde.logicName}]删除数据
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// public void
	// testRemoveBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	// <#if (der.getRemoveActionType()==3)>
	// java.util.ArrayList<DynaEntity> list =
	// this.selectBy${der.codeName}(parentEntity);
	// if(list.size()>0)
	// {
	// IDataEntityModel parentDEModel =
	// this.getDEModel().getSystemRuntime().getDataEntityModel("${majorde.codeName?upper_case}");
	// parentDEModel.getService(this.getSessionFactory()).getCache(parentEntity);
	// throw new Exception(getRemoveRejectMsg("${der.name}",<#if
	// ((der.logicName??) && (der.logicName?length >
	// 0))>"${der.logicName}"<#else>""</#if>
	// ,parentDEModel.getName(),"${der.getMinorPSDataEntity().name}",parentDEModel.getDataInfo(parentEntity)));
	// }
	// </#if>
	// }
	//
	//
	// /**
	// * 通过关系[${majorde.logicName}]重置数据
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// public void
	// reset${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	// java.util.ArrayList<DynaEntity> list =
	// this.selectBy${der.codeName}(parentEntity);
	// for(DynaEntity item:list)
	// {
	// DynaEntity item2 = (DynaEntity)getDEModel().createEntity();
	// item2.set${item.getKeyPSDEField().codeName}(item.get${item.getKeyPSDEField().codeName}());
	// item2.set${pickupdefield.codeName}(null);
	// this.update(item2);
	// }
	// }
	//
	// <#if item.isEnableTempData()>
	// <#if (der.getTempDataOrder()>=0)>
	// /**
	// * 判断是否能够通过关系[${majorde.logicName}]删除数据（临时数据模式）
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// public void
	// resetTemp${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	// java.util.ArrayList<DynaEntity> list =
	// this.selectTempBy${der.codeName}(parentEntity);
	// for(DynaEntity item:list)
	// {
	// DynaEntity item2 = (DynaEntity)getDEModel().createEntity();
	// item2.set${item.getKeyPSDEField().codeName}(item.get${item.getKeyPSDEField().codeName}());
	// item2.set${pickupdefield.codeName}(null);
	// this.updateTemp(item2);
	// }
	// }
	// </#if>
	// </#if>
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// public void
	// removeBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	// final ${majorde.getClassOrPkgName('ENTITY',pub)} parentEntity2 =
	// parentEntity;
	// this.doServiceWork(new IServiceWork()
	// {
	// @Override
	// public void execute(ITransaction iTransaction) throws Exception
	// {
	// onBeforeRemoveBy${der.codeName}(parentEntity2);
	// internalRemoveBy${der.codeName}(parentEntity2);
	// onAfterRemoveBy${der.codeName}(parentEntity2);
	// }
	// });
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之前调用
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// protected void
	// onBeforeRemoveBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	//
	// }
	//
	// /**
	// * 内部删除数据，通过关系[${majorde.logicName}]
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// protected void
	// internalRemoveBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	// java.util.ArrayList<DynaEntity> removeList =
	// selectBy${der.codeName}(parentEntity);
	// onBeforeRemoveBy${der.codeName}(parentEntity,removeList );
	//
	// // 执行删除
	// for (DynaEntity item : removeList )
	// {
	// remove(item );
	// }
	// onAfterRemoveBy${der.codeName}(parentEntity,removeList );
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之后调用
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// protected void
	// onAfterRemoveBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	//
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之前调用
	// * @param parentEntity 父数据
	// * @param removeList 要删除的数据清单
	// * @throws Exception
	// */
	// protected void
	// onBeforeRemoveBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity,java.util.ArrayList<DynaEntity> removeList) throws
	// Exception
	// {
	//
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之后调用
	// * @param parentEntity 父数据
	// * @param removeList 要删除的数据清单
	// * @throws Exception
	// */
	// protected void
	// onAfterRemoveBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity,java.util.ArrayList<DynaEntity> removeList) throws
	// Exception
	// {
	//
	// }
	// </#list>
	// </#if>
	//
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onBeforeRemove(net.ibizsys.paas.entity.IEntity)
	// */
	// @Override
	// protected void onBeforeRemove(DynaEntity et) throws Exception
	// {
	// <#if item.getPSDER1Ns(true,true)??>
	// <#list item.getPSDER1Ns(true,true) as der >
	// <#assign minorde=der.getMinorPSDataEntity()>
	// <#if (der.getRemoveActionType()>0)>
	// //判断是否可以删除 关系 ${minorde.logicName} 数据
	// if(true)
	// {
	// ${minorde.codeName}Service service =
	// (${minorde.codeName}Service)ServiceGlobal.getService(${minorde.codeName}Service.class,this.getSessionFactory());
	// service.testRemoveBy${der.codeName}(et);
	// }
	// </#if>
	// </#list>
	//
	// <#list item.getPSDER1Ns(true,true) as der >
	// <#assign minorde=der.getMinorPSDataEntity()>
	// <#if (der.getRemoveActionType()==1)||(der.getRemoveActionType()==2)>
	// //删除 关系 ${minorde.logicName} 数据
	// if(true)
	// {
	// ${minorde.codeName}Service service =
	// (${minorde.codeName}Service)ServiceGlobal.getService(${minorde.codeName}Service.class,this.getSessionFactory());
	// <#if (der.getRemoveActionType()==1)>
	// service.removeBy${der.codeName}(et);
	// </#if>
	// <#if (der.getRemoveActionType()==2)>
	// service.reset${der.codeName}(et);
	// </#if>
	// }
	// </#if>
	// </#list>
	// </#if>
	// super.onBeforeRemove(et);
	// }
	//
	// <#if item.getTempDataPSDER1Ns(true)??>
	// <#assign templist=srflist(item.getTempDataPSDER1Ns(true))>
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onBeforeRemoveTemp(net.ibizsys.paas.entity.IEntity)
	// */
	// @Override
	// protected void onBeforeRemoveTemp(DynaEntity et) throws Exception
	// {
	// <#list templist?reverse as der >
	// <#assign minorde=der.getMinorPSDataEntity()>
	// <#if (der.getTempDataOrder()>0)>
	// //删除 关系 ${minorde.logicName} 数据
	// if(true)
	// {
	// ${minorde.codeName}Service service =
	// (${minorde.codeName}Service)ServiceGlobal.getService(${minorde.codeName}Service.class,this.getSessionFactory());
	// service.removeTempBy${der.codeName}(et);
	// }
	// <#else>
	// //重置 关系 ${minorde.logicName} 数据
	// if(true)
	// {
	// ${minorde.codeName}Service service =
	// (${minorde.codeName}Service)ServiceGlobal.getService(${minorde.codeName}Service.class,this.getSessionFactory());
	// service.resetTemp${der.codeName}(et);
	// }
	// </#if>
	// </#list>
	// super.onBeforeRemoveTemp(et);
	// }
	// </#if>
	//
	// <#if item.getTempDataPSDER1Ns(false)??>
	// <#assign templist=srflist(item.getTempDataPSDER1Ns(false))>
	// <#list templist as der >
	// <#assign majorde=der.getMajorPSDataEntity()>
	// <#if (der.getTempDataOrder()>=0)>
	// /**
	// * 通过关系[${majorde.logicName}]删除数据（临时数据模式）
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// public void
	// removeTempBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	// final ${majorde.getClassOrPkgName('ENTITY',pub)} parentEntity2 =
	// parentEntity;
	// this.doServiceWork(new IServiceWork()
	// {
	// @Override
	// public void execute(ITransaction iTransaction) throws Exception
	// {
	// onBeforeRemoveTempBy${der.codeName}(parentEntity2);
	// internalRemoveTempBy${der.codeName}(parentEntity2);
	// onAfterRemoveTempBy${der.codeName}(parentEntity2);
	// }
	// });
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之前调用（临时数据模式）
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// protected void
	// onBeforeRemoveTempBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	//
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之后调用（临时数据模式）
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// protected void
	// internalRemoveTempBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	// java.util.ArrayList<DynaEntity> removeList =
	// selectTempBy${der.codeName}(parentEntity);
	// onBeforeRemoveTempBy${der.codeName}(parentEntity,removeList );
	//
	// //逐个执行删除
	// for (DynaEntity item : removeList )
	// {
	// removeTemp(item );
	// }
	// onAfterRemoveTempBy${der.codeName}(parentEntity,removeList );
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之后调用（临时数据模式）
	// * @param parentEntity 父数据
	// * @throws Exception
	// */
	// protected void
	// onAfterRemoveTempBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity) throws Exception
	// {
	//
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之前调用（临时数据模式）
	// * @param parentEntity 父数据
	// * @param removeList 删除数据清单
	// * @throws Exception
	// */
	// protected void
	// onBeforeRemoveTempBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity,java.util.ArrayList<DynaEntity> removeList) throws
	// Exception
	// {
	//
	// }
	//
	// /**
	// * 通过关系[${majorde.logicName}]删除数据之后调用（临时数据模式）
	// * @param parentEntity 父数据
	// * @param removeList 删除数据清单
	// * @throws Exception
	// */
	// protected void
	// onAfterRemoveTempBy${der.codeName}(${majorde.getClassOrPkgName('ENTITY',pub)}
	// parentEntity,java.util.ArrayList<DynaEntity> removeList) throws
	// Exception
	// {
	//
	// }
	// </#if>
	// </#list>
	// </#if>
	//
	// <#if item.getTempDataPSDER1Ns(true)??>
	// @Override
	// protected void getRelatedDataTempMajor(DynaEntity et) throws Exception
	// {
	// <#list item.getTempDataPSDER1Ns(true) as der >
	// <#if (der.getTempDataOrder()>0)>
	// <#assign minorde=der.getMinorPSDataEntity()>
	// getRelatedDataTempMajor_${minorde.codeName}(et);
	// </#if>
	// </#list>
	// super.getRelatedDataTempMajor(et);
	// }
	//
	// <#list item.getTempDataPSDER1Ns(true) as der >
	// <#if (der.getTempDataOrder()>0)>
	// <#assign minorde=der.getMinorPSDataEntity()>
	// protected void getRelatedDataTempMajor_${minorde.codeName}(DynaEntity
	// et) throws Exception
	// {
	// <#assign
	// minordeservice=pub.getPKGCodeName()+".srv."+minorde.getPSSystemModule().codeName?lower_case+".service."+minorde.codeName+"Service">
	// <#assign
	// minordeentity=pub.getPKGCodeName()+".srv."+minorde.getPSSystemModule().codeName?lower_case+".entity."+minorde.codeName>
	// ${minordeservice} service = (
	// ${minordeservice})ServiceGlobal.getService(${minordeservice}.class,this.getSessionFactory());
	// java.util.ArrayList<${minordeentity}> list = null;
	// String strKeyValue = et.get${item.getKeyPSDEField().codeName}();
	// if(strKeyValue.indexOf(TEMPKEY)!=0)
	// list = service.selectBy${der.codeName}(et);
	// else
	// list = service.selectTempBy${der.codeName}(et);
	// <#if
	// minorde.getPSDEField("P"+minorde.getKeyPSDEField().getCodeName(),true)??>
	// //重新排序
	// sortHierarchyEntities(list,
	// "${minorde.getKeyPSDEField().codeName?upper_case}","P${minorde.getKeyPSDEField().codeName?upper_case}")
	// ;
	// </#if>
	// for(${minordeentity} entity:list)
	// {
	// service.getTempMajor(entity);
	// }
	// }
	// </#if>
	// </#list>
	// </#if>
	//
	// <#comment>
	// begin updateRelatedDataTempMajor
	// </#comment>
	//
	// <#if item.getTempDataPSDER1Ns(true)??>
	// @Override
	// protected void updateRelatedDataTempMajor(DynaEntity tempET,DynaEntity
	// oriET) throws Exception
	// {
	// <#assign tdlist=srflist(item.getTempDataPSDER1Ns(true))>
	// <#list tdlist?reverse as der >
	// <#if (der.getTempDataOrder()>0)>
	// <#assign minorde=der.getMinorPSDataEntity()>
	// <#assign
	// minordeentity=pub.getPKGCodeName()+".srv."+minorde.getPSSystemModule().codeName?lower_case+".entity."+minorde.codeName>
	// java.util.ArrayList<${minordeentity}>
	// ${srfparamname('${minorde.codeName}')}list =
	// updateRelatedDataTempMajor_remove${minorde.codeName}(tempET,oriET);
	// </#if>
	// </#list>
	//
	// <#list tdlist as der >
	// <#if (der.getTempDataOrder()>0)>
	// <#assign minorde=der.getMinorPSDataEntity()>
	// <#assign
	// minordeentity=pub.getPKGCodeName()+".srv."+minorde.getPSSystemModule().codeName?lower_case+".entity."+minorde.codeName>
	// updateRelatedDataTempMajor_update${minorde.codeName}(tempET,oriET,${srfparamname('${minorde.codeName}')}list);
	// </#if>
	// </#list>
	// super.updateRelatedDataTempMajor(tempET, oriET);
	// }
	//
	// <#list item.getTempDataPSDER1Ns(true) as der >
	// <#if (der.getTempDataOrder()>0)>
	// <#assign minorde=der.getMinorPSDataEntity()>
	// <#assign
	// minordeservice=pub.getPKGCodeName()+".srv."+minorde.getPSSystemModule().codeName?lower_case+".service."+minorde.codeName+"Service">
	// <#assign
	// minordeentity=pub.getPKGCodeName()+".srv."+minorde.getPSSystemModule().codeName?lower_case+".entity."+minorde.codeName>
	//
	// protected java.util.ArrayList<${minordeentity}>
	// updateRelatedDataTempMajor_remove${minorde.codeName}(DynaEntity
	// tempET,DynaEntity oriET) throws Exception
	// {
	// ${minordeservice} service = (
	// ${minordeservice})ServiceGlobal.getService(${minordeservice}.class,this.getSessionFactory());
	// java.util.ArrayList<${minordeentity}> tempList =
	// service.selectTempBy${der.codeName}(tempET);
	// java.util.ArrayList<${minordeentity}> oriList =
	// service.selectBy${der.codeName}(oriET);
	//
	// //放入Map中
	// java.util.HashMap<Object,${minordeentity}> oriMap = new
	// java.util.HashMap<Object,${minordeentity}>();
	// for(${minordeentity} entity:oriList)
	// {
	// oriMap.put(entity.get${minorde.getKeyDEField().codeName}(),entity);
	// }
	// <#if
	// minorde.getPSDEField("P"+minorde.getKeyPSDEField().getCodeName(),true)??>
	// //重新排序
	// sortHierarchyEntities(tempList,
	// "${minorde.getKeyPSDEField().codeName?upper_case}","P${minorde.getKeyPSDEField().codeName?upper_case}")
	// ;
	// </#if>
	// for(${minordeentity} entity:tempList)
	// {
	// Object oriKey = entity.get(ORIGINKEY);
	// oriMap.remove(oriKey);
	// }
	//
	// //移除删除的
	// for(${minordeentity} entity: oriMap.values() )
	// {
	// service.remove(entity);
	// }
	//
	// return tempList;
	// }
	//
	// protected void
	// updateRelatedDataTempMajor_update${minorde.codeName}(DynaEntity
	// tempET,DynaEntity oriET,java.util.ArrayList<${minordeentity}>
	// updateList) throws Exception
	// {
	// if(updateList==null)
	// return;
	// ${minordeservice} service = (
	// ${minordeservice})ServiceGlobal.getService(${minordeservice}.class,this.getSessionFactory());
	// //建立
	// for(${minordeentity} entity:updateList)
	// {
	// service.updateTempMajor(entity);
	// }
	// }
	// </#if>
	// </#list>
	// </#if>
	// <#comment>
	// end updateRelatedDataTempMajor
	// </#comment>
	// <#if item.getPSDER1Ns(false)??>
	// /**
	// * 替换父数据信息
	// * @param et
	// * @throws Exception
	// */
	// @Override
	// protected void replaceParentInfo(DynaEntity et,CloneSession
	// cloneSession) throws Exception
	// {
	// super.replaceParentInfo(et, cloneSession);
	// //循环所有的从关系，判断有误替换
	// <#list item.getPSDER1Ns(false) as der >
	// <#assign majorde=der.getMajorPSDataEntity()>
	// <#assign pickupdef=item.getPSDEField(der.getPickupDEFName())>
	// if(et.get${pickupdef.codeName}()!=null)
	// {
	// IEntity entity =
	// cloneSession.getEntity("${majorde.name}",et.get${pickupdef.codeName}());
	// if(entity !=null)
	// {
	// onFillParentInfo_${der.codeName}(et,(${majorde.getClassOrPkgName('ENTITY',pub)})
	// entity);
	// }
	// }
	// </#list>
	// }
	// </#if>
	//
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onRemoveEntityUncopyValues(net.ibizsys.paas.entity.IEntity,
	// boolean)
	// */
	// @Override
	// protected void onRemoveEntityUncopyValues(DynaEntity et, boolean
	// bTempMode) throws Exception
	// {
	// super.onRemoveEntityUncopyValues(et, bTempMode);
	// <#list item.getPSDEFields() as defield>
	// <#if (defield.dataType!='INHERIT') && (!defield.isKeyDEField()) &&
	// defield.isPasteReset()>
	// et.reset${defield.codeName}();
	// </#if>
	// </#list>
	// }
	//
	//
	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.service.ServiceBase#onCheckEntity(boolean,
	// net.ibizsys.paas.entity.IEntity, boolean, boolean,
	// net.ibizsys.paas.entity.EntityError)
	// */
	// @Override
	// protected void onCheckEntity(boolean bBaseMode,DynaEntity et, boolean
	// bCreate, boolean bTempMode,EntityError entityError) throws Exception
	// {
	// EntityFieldError entityFieldError = null;
	// <#list item.getPSDEFields() as defield>
	// <#if (defield.dataType!='INHERIT') && defield.isPhisicalDEField() &&
	// defield.getPreDefinedType()==''>
	// //检查属性 ${defield.logicName}
	// entityFieldError = onCheckField_${defield.codeName}( bBaseMode, et,
	// bCreate, bTempMode);
	// if(entityFieldError!=null){entityError.register(entityFieldError);}
	// </#if>
	// </#list>
	// super.onCheckEntity(bBaseMode,et, bCreate,bTempMode,entityError);
	// }
	//
	//
	// <#list item.getPSDEFields() as defield>
	// <#if (defield.dataType!='INHERIT') && defield.isPhisicalDEField() &&
	// defield.getPreDefinedType()==''>
	// /**
	// * 获取属性[${defield.codeName}]值错误
	// * @param bBaseMode 是否为基本检查模式，基本检查模式执行值类型，长度及属性值规则检查，非基本模式进行重复值检查
	// * @param et 当前数据对象
	// * @param bCreate 是否为新建数据
	// * @param bTempMode 是否为临时数据模式
	// * @throws Exception
	// */
	// protected EntityFieldError onCheckField_${defield.codeName}(boolean
	// bBaseMode,DynaEntity et, boolean bCreate, boolean bTempMode) throws
	// Exception
	// {
	// //判断是否有值
	// <#comment>
	// //if(!et.is${defield.codeName}Dirty()&&!bCreate)
	// </#comment>
	// if(!et.is${defield.codeName}Dirty())
	// return null;
	//
	// ${srfjavatype(defield.stdDataType)} value = et.get${defield.codeName}();
	// if(bBaseMode)
	// {
	// if(bCreate)
	// {
	// <#if (!defield.isAllowEmpty())>
	// <#if srfjavatype(defield.stdDataType)=='String'>
	// if(StringHelper.isNullOrEmpty(value))
	// {
	// EntityFieldError entityFieldError = new EntityFieldError();
	// entityFieldError.setFieldName(DynaEntity.FIELD_${defield.codeName?upper_case});
	// entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
	// return entityFieldError;
	// }
	// <#else>
	// if(value==null)
	// {
	// EntityFieldError entityFieldError = new EntityFieldError();
	// entityFieldError.setFieldName(DynaEntity.FIELD_${defield.codeName?upper_case});
	// entityFieldError.setErrorType(EntityFieldError.ERROR_EMPTY);
	// return entityFieldError;
	// }
	// </#if>
	// </#if>
	// }
	//
	// <#if defield.getAllPSDEFValueRules()??>
	// String strRuleInfo = null;
	// <#list defield.getAllPSDEFValueRules() as defvr>
	// <#if defvr.isCheckDefault()>
	// //检查值规则[${defvr.name}]
	// strRuleInfo =onTestValueRule_${defield.codeName}_${defvr.codeName}( et,
	// bCreate, bTempMode);
	// if(!StringHelper.isNullOrEmpty(strRuleInfo))
	// {
	// EntityFieldError entityFieldError = new EntityFieldError();
	// entityFieldError.setFieldName(DynaEntity.FIELD_${defield.codeName?upper_case});
	// entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
	// entityFieldError.setErrorInfo(strRuleInfo);
	// return entityFieldError;
	// }
	// </#if>
	// </#list>
	// </#if>
	// }
	// else
	// {
	// <#if defield.getDupCheckMode()=='ALL' ||
	// defield.getDupCheckMode()=='NOTNULL'
	// ||defield.getDupCheckMode()=='CHECKVALUES'>
	// boolean bCheckDup = true;
	// <#if defield.getDupCheckMode()=='NOTNULL'>
	// if(value == null) bCheckDup = false;
	// </#if>
	// <#if defield.getDupCheckMode()=='CHECKVALUES'>
	// <#if (defield.getDupCheckValues()??) && (defield.getDupCheckValues()?size
	// gt 0)>
	// if(<#list defield.getDupCheckValues() as checkvalue ><#if
	// checkvalue_index gt
	// 0>||</#if>(DataTypeHelper.compare(${defield.getStdDataType()?c},value,"${checkvalue}")==0)</#list>)
	// bCheckDup = true;
	// else
	// bCheckDup = false;
	// <#else>
	// //没有指定检查值
	// bCheckDup = false;
	// </#if>
	// </#if>
	// //重复值判断
	// if(bCheckDup)
	// {
	// String strRangeDEFieldName = "";
	// <#if defield.getDupCheckPSDEField()??>
	// strRangeDEFieldName =
	// DynaEntity.FIELD_${defield.getDupCheckPSDEField().codeName?upper_case};
	// </#if>
	// <#assign preparelastforupdate=1>
	// String strDupCheckInfo =
	// checkFieldDupRule(get${item.codeName}DEModel(),DynaEntity.FIELD_${defield.codeName?upper_case},strRangeDEFieldName,
	// et, bCreate, bTempMode);
	// if(!StringHelper.isNullOrEmpty(strDupCheckInfo))
	// {
	// EntityFieldError entityFieldError = new EntityFieldError();
	// entityFieldError.setFieldName(DynaEntity.FIELD_${defield.codeName?upper_case});
	// entityFieldError.setErrorType(EntityFieldError.ERROR_VALUERULE);
	// entityFieldError.setErrorInfo(strDupCheckInfo);
	// return entityFieldError;
	// }
	// }
	// </#if>
	// }
	// return null;
	// }
	//
	//
	// </#if>
	// </#list>
	//
	//
	// <#if item.getAllPSDEMaps()??>
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onSyncEntity(net.ibizsys.paas.entity.IEntity,
	// boolean)
	// */
	// @Override
	// protected void onSyncEntity(DynaEntity et, boolean bRemove) throws
	// Exception
	// {
	// <#list item.getAllPSDEMaps() as demap>
	// onSyncEntity_${demap.codeName}( et, bRemove);
	// </#list>
	// super.onSyncEntity( et, bRemove);
	// }
	//
	// <#list item.getAllPSDEMaps() as demap>
	// /**
	// * 同步实体[${demap.codeName}]
	// * @param et 当前数据对象
	// * @param bRemove 是否为数据删除同步
	// * @throws Exception
	// */
	// protected void onSyncEntity_${demap.codeName}(DynaEntity et, boolean
	// bRemove) throws Exception
	// {
	// <#if demap.getMapTarget()=='SYSREF'>
	// //获取服务对象
	// IService dstService =
	// ServiceGlobal.getService("${demap.getDstPSSysRefDE().getServiceCls()}");
	// IEntity dstEntity = dstService.getDEModel().createEntity();
	// //赋值
	// <#list demap.getPSDEMapDetails() as demapdetail>
	// <#if demapdetail.getSrcValue()!=''>
	// dstEntity.set("${demapdetail.getDstFieldName()}","${demapdetail.getSrcValue()}");
	// <#else>
	// dstEntity.set("${demapdetail.getDstFieldName()}",et.get("${demapdetail.getSrcFieldName()}"));
	// </#if>
	// </#list>
	// if(bRemove)
	// {
	// dstService.remove(dstEntity);
	// }
	// else
	// {
	// dstService.save(dstEntity);
	// }
	// </#if>
	// }
	// </#list>
	// </#if>
	//
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onSyncIndexEntities(net.ibizsys.paas.entity.IEntity,
	// boolean)
	// */
	// @Override
	// protected void onSyncIndexEntities(DynaEntity et,boolean bRemove) throws
	// Exception
	// {
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DERINDEX'>
	// <#assign majorde=der.getMajorPSDataEntity()>
	// onSyncIndexEntity_${der.codeName}(et,bRemove);
	// </#if>
	// </#list>
	// super.onSyncIndexEntities(et,bRemove);
	// }
	//
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DERINDEX'>
	// <#assign majorde=der.getMajorPSDataEntity()>
	//
	// /**
	// * 填充实体的索引实体信息 ${majorde.logicName}
	// * @param et 当前数据对象
	// * @param bRemove 是否删除
	// * @throws Exception
	// */
	// protected void onSyncIndexEntity_${der.codeName}(DynaEntity et,boolean
	// bRemove) throws Exception
	// {
	// //获取服务对象
	// ${majorde.codeName}Service dstService =
	// (${majorde.codeName}Service)ServiceGlobal.getService("${majorde.getClassOrPkgName('SERVICE',pub)}",this.getSessionFactory());
	// ${majorde.codeName} dstEntity =
	// (${majorde.codeName})dstService.getDEModel().createEntity();
	// dstEntity.set${majorde.getKeyPSDEField().codeName}(et.get${item.getKeyPSDEField().codeName}());
	// if(bRemove)
	// {
	// dstEntity.set(IProcParam.TAG_PERSONID,et.get(IProcParam.TAG_PERSONID));
	// dstService.remove(dstEntity);
	// }
	// else
	// {
	// dstEntity.set(IProcParam.TAG_PERSONID,et.get${item.getPSDEFieldByPDT("UPDATEMAN",false).codeName}());
	// dstEntity.set${majorde.getMajorPSDEField().codeName}(et.get${item.getMajorPSDEField().codeName}());
	// dstEntity.set(${majorde.codeName}.FIELD_${majorde.getIndexTypePSDEField().codeName?upper_case},"${der.getTypeValue()}");
	// <#if der.getPropertyMapNames()??>
	// <#list der.getPropertyMapNames() as mapname>
	// dstEntity.set("${mapname}",et.get("${der.getPropertyMap('${mapname}')}"));
	// </#list>
	// </#if>
	// dstService.save(dstEntity);
	// }
	// }
	// </#if>
	// </#list>
	//
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#getDataContextValue(net.ibizsys.paas.entity.IEntity,
	// java.lang.String, net.ibizsys.paas.service.IDataContextParam)
	// */
	// @Override
	// public Object getDataContextValue(DynaEntity et,String
	// strField,IDataContextParam iDataContextParam)throws Exception
	// {
	// Object objValue = null;
	// if(iDataContextParam!=null)
	// {
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DER1N'>
	// <#assign majorde=der.getMajorPSDataEntity()>
	// <#if ((der.getERMajorPSDEFName()??) && (der.getERMajorPSDEFName()?length
	// gt 0) && (der.getERMinorPSDEFName()??) &&
	// (der.getERMinorPSDEFName()?length gt 0) && (der.getERMinorPSDEFName() !=
	// der.getERMajorPSDEFName() )) >
	// if((StringHelper.compare(iDataContextParam.getDEName(),"${majorde.getName()}",true)
	// == 0)
	// &&(StringHelper.compare(iDataContextParam.getDEFName(),"${der.getERMajorPSDEFName()}",true)
	// == 0)
	// &&(StringHelper.isNullOrEmpty(iDataContextParam.getReferItem())<#list
	// item.getPSDEFieldsByDER('${der.id}') as defield
	// >||(StringHelper.compare(iDataContextParam.getReferItem(),"${defield.getName()}",true)
	// == 0)</#list>))
	// {
	// objValue =
	// super.getDataContextValue(et,"${der.getERMinorPSDEFName()?lower_case}",iDataContextParam);
	// if(objValue!=null)
	// return objValue;
	// }
	// </#if>
	// </#if>
	// </#list>
	// }
	//
	// objValue = super.getDataContextValue(et,strField,iDataContextParam);
	// if(objValue!=null)
	// return objValue;
	//
	// <#list item.getPSDERs(false) as der >
	// <#if (der.getDERType()=='DER1N') && ((
	// srfbitfunc("&",der.getMasterRS(),1)) || (
	// srfbitfunc("&",der.getMasterRS(),2))) >
	// <#assign majorde=der.getMajorPSDataEntity()>
	// IEntity ${srfparamname('${der.codeName}')} =et.get${der.codeName}();
	// if(${srfparamname('${der.codeName}')}!=null)
	// {
	// if(${srfparamname('${der.codeName}')}.contains(strField))
	// {
	// return ${srfparamname('${der.codeName}')}.get(strField);
	// }
	// }
	// </#if>
	// </#list>
	// return null;
	// }
	//
	//
	// <#if item.getExportPSDER1Ns()??>
	// <#assign templist=srflist(item.getExportPSDER1Ns())>
	//
	// /**
	// * 导出相关模型
	// * @param et
	// * @param list
	// * @param bFrameOnly
	// */
	// @Override
	// protected void onExportRelatedModel(DynaEntity et, ArrayList<JSONObject>
	// list)throws Exception
	// {
	// <#list templist as der >
	// <#assign minorde=der.getMinorPSDataEntity()>
	// onExportRelatedModel_${minorde.codeName}_${der.codeName}( et, list);
	// </#list>
	// super.onExportRelatedModel(et,list);
	// }
	//
	// <#list templist as der >
	// <#assign minorde=der.getMinorPSDataEntity()>
	// protected void
	// onExportRelatedModel_${minorde.codeName}_${der.codeName}(DynaEntity et,
	// ArrayList<JSONObject> list)throws Exception
	// {
	// ${minorde.codeName}Service service =
	// (${minorde.codeName}Service)ServiceGlobal.getService(${minorde.codeName}Service.class,this.getSessionFactory());
	// ArrayList<${minorde.codeName}> entityList =
	// service.selectBy${der.codeName}(et);
	// <#if (der.getSyncExportModelMode() gt 0) >
	// //同步模型
	// if(true)
	// {
	// JSONObject jo = new JSONObject();
	// jo.put("srfdeid","${minorde.id}");
	// jo.put("srfdename","${minorde.name}");
	// jo.put("srfder1nsync", "true");
	// jo.put("srfder1nid", "${der.name}");
	// jo.put("srfarg",
	// DataObject.getStringValue(et,DynaEntity.FIELD_${item.getKeyPSDEField().codeName?upper_case},""));
	// <#if (der.getSyncExportModelMode() == 1) >
	// String strMinorKeys = "";
	// for (${minorde.codeName} entity : entityList)
	// {
	// if (!StringHelper.isNullOrEmpty(strMinorKeys))
	// strMinorKeys += ";";
	//
	// strMinorKeys +=
	// DataObject.getStringValue(entity,${minorde.codeName}.FIELD_${minorde.getKeyPSDEField().codeName?upper_case},"");
	// }
	// jo.put("srfarg2", strMinorKeys);
	// </#if>
	// <#if (der.getSyncExportModelMode() == 2) >
	// jo.put("srfarg2", "");
	// </#if>
	// list.add(jo);
	// }
	// </#if>
	// //循环导出模型
	// for (${minorde.codeName} entity : entityList)
	// {
	// if(DataObject.getIntegerValue(entity,"srfsyspub",1)==0)
	// continue;
	// service.exportModel(entity, list);
	// }
	// }
	// </#list>
	// </#if>
	//
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onTestValueRule(java.lang.String,
	// java.lang.String, net.ibizsys.paas.entity.IEntity, boolean, boolean)
	// */
	// @Override
	// protected String onTestValueRule(String strDEFieldName,String
	// strRule,IEntity et,boolean bCreate,boolean bTempMode) throws Exception
	// {
	// <#list item.getAllPSDEFValueRules() as defvr>
	// if((StringHelper.compare(strDEFieldName,DynaEntity.FIELD_${defvr.getPSDEField().codeName?upper_case},true)==0)
	// &&(StringHelper.compare(strRule,"${defvr.codeName?upper_case}",true)==0))
	// return
	// onTestValueRule_${defvr.getPSDEField().codeName}_${defvr.codeName}(et,bCreate,bTempMode);
	// </#list>
	//
	// return super.onTestValueRule( strDEFieldName, strRule, et,bCreate,
	// bTempMode);
	// }
	//
	// <#list item.getAllPSDEFValueRules() as defvr>
	// /**
	// * 判断值规则[${defvr.getPSDEField().logicName}][${defvr.name}]
	// * @param et 当前数据对象
	// * @param bCreate 是否为新建数据模式
	// * @param bTempMode 是否为临时数据模式
	// * @return
	// * @throws Exception
	// */
	// protected String
	// onTestValueRule_${defvr.getPSDEField().codeName}_${defvr.codeName}(IEntity
	// et,boolean bCreate,boolean bTempMode) throws Exception
	// {
	// <#assign defvrcode=publisher.getDEFVRCode(defvr)>
	// <#if defvrcode=='true'>
	// return null;
	// <#else>
	// try
	// {
	// if(${defvrcode})
	// return null;
	// return "${defvr.ruleInfo}";
	// }
	// catch(Exception ex)
	// {
	// return ex.getMessage();
	// }
	// </#if>
	// }
	//
	// </#list>
	// <#if (preparelastforupdate==1)>
	// /**
	// * 是否为更新准备最后一次数据，优化操作
	// * @return
	// */
	// @Override
	// protected boolean isPrepareLastForUpdate()
	// {
	// return true;
	// }
	// </#if>
	//
	//
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.service.ServiceBase#onMergeChild(java.lang.String,
	// java.lang.String, net.ibizsys.paas.entity.IEntity)
	// */
	// @Override
	// protected boolean onMergeChild(String strChildType, String strTypeParam,
	// DynaEntity et) throws Exception{
	// boolean bRet = false;
	// <#list item.getPSDERs(true) as der >
	// <#if der.getDERType()=='DER1N'>
	// <#if der.getPSDER1NDEFieldMaps()??>
	// <#if der.getMinorCodeName()?? && der.getMinorCodeName()?length gt 0 >
	// <#assign minorde=der.getMinorPSDataEntity()>
	// //关系类型 : ${der.getDERType()} ,从实体 :${minorde.name} / ${minorde.logicName}
	// if
	// (StringHelper.isNullOrEmpty(strChildType)||(((StringHelper.compare(strChildType,
	// WebContext.PARAM_PARENTTYPE_DER1N, true) == 0)
	// ||(StringHelper.compare(strChildType,
	// WebContext.PARAM_PARENTTYPE_SYSDER1N, true) == 0))
	// && (StringHelper.compare(strTypeParam, "${der.name}", true)==0)))
	// {
	// if( onMergeChild_${der.getMinorCodeName()}(et))
	// bRet = true;
	// }
	// <#else>
	// //TODO:子关系 ${der.name} 没有定义关系代码名称，无法输出执行代码
	// log.error("子关系  ${der.name} 没有定义关系代码名称，无法输出执行代码");
	// </#if>
	// </#if>
	// </#if>
	// </#list>
	// if(super.onMergeChild( strChildType, strTypeParam, et))
	// bRet = true;
	// return bRet;
	// }
	//
	// <#list item.getPSDERs(true) as der >
	// <#if der.getDERType()=='DER1N'>
	// <#if der.getPSDER1NDEFieldMaps()??>
	// <#if der.getMinorCodeName()?? && der.getMinorCodeName()?length gt 0 >
	// <#assign minorde=der.getMinorPSDataEntity()>
	// /**
	// * 合并子数据（${minorde.logicName}）
	// * @param et
	// * @return 是否发生变化
	// * @throws Exception
	// */
	// protected boolean onMergeChild_${der.getMinorCodeName()}(DynaEntity et)
	// throws Exception{
	// net.ibizsys.paas.db.SelectContext selectContext = new
	// net.ibizsys.paas.db.SelectContext();
	// <#list der.getPSDER1NDEFieldMaps() as derdefmap>
	// net.ibizsys.paas.db.SelectField field${derdefmap_index?c} = new
	// net.ibizsys.paas.db.SelectField();
	// field${derdefmap_index?c}.setAlias("${derdefmap.getMajorPSDEField().name}");
	// <#if derdefmap.getMinorPSDEField()??>
	// field${derdefmap_index?c}.setName("${derdefmap.getMinorPSDEField().name}");
	// </#if>
	// field${derdefmap_index?c}.setFunc("${derdefmap.getMapType()}");
	// selectContext.addSelectField(field${derdefmap_index?c});
	// </#list>
	// String strKey =
	// DataObject.getStringValue(et.get${item.getKeyPSDEField().codeName}());
	// IService iService=
	// ServiceGlobal.getService("${minorde.getClassOrPkgName('SERVICE',pub)}",this.getSessionFactory());
	// selectContext.set("${der.getPickupDEFName()}",et.get${item.getKeyPSDEField().codeName}());
	// ArrayList selectList = null;
	// if(strKey.indexOf(ServiceBase.TEMPKEY) == 0)
	// selectList = iService.selectTemp(selectContext);
	// else
	// selectList = iService.select(selectContext);
	//
	// if(selectList.size()==0)
	// throw new Exception("无法获取指定数据");
	//
	// IEntity iEntity = (IEntity)selectList.get(0);
	// iEntity.copyTo(et,false);
	// return true;
	// }
	// </#if>
	// </#if>
	// </#if>
	// </#list>
	//
	//
	// <#assign needupdateparent=0>
	// /**
	// * 更新父数据
	// * @param et
	// * @throws Exception
	// */
	// @Override
	// protected void onUpdateParent(DynaEntity et)throws Exception{
	// <#list item.getPSDERs(false) as der >
	// <#if der.getDERType()=='DER1N'>
	// <#if der.getPSDER1NDEFieldMaps()??>
	// <#assign majorde=der.getMajorPSDataEntity()>
	// <#assign needupdateparent=1>
	// //关系类型 : ${der.getDERType()} ,主实体 :${majorde.name} / ${majorde.logicName}
	// if(true){
	// Object objParentKey = et.get("${der.getPickupDEFName()}");
	// if(objParentKey!=null){
	// IService iService=
	// ServiceGlobal.getService("${majorde.getClassOrPkgName('SERVICE',pub)}",this.getSessionFactory());
	// iService.mergeChild("${der.getDERType()}","${der.name}",objParentKey);
	// }
	// }
	// </#if>
	// </#if>
	// </#list>
	// super.onUpdateParent(et);
	// }
	//
	// <#if needupdateparent==1>
	// /**
	// * 是否需要更新父数据
	// * @return
	// */
	// @Override
	// protected boolean isNeedUpdateParent(){
	// return true;
	// }
	// </#if>
	//
	// <#if item.isVirtual() && item.getPSDERMultiInherits(false)??>
	// /**
	// * 内部建立数据
	// * @param entity
	// * @throws Exception
	// */
	// @Override
	// protected void internalCreate( ${item.codeName} et) throws Exception
	// {
	// //获取主键
	// Object objKey = et.get${de.getKeyPSDEField().codeName}();
	// <#list item.getPSDERMultiInherits(false) as der>
	// //建立主实体[${der.getMajorPSDataEntity().name}]数据
	// if(true){
	// IService service =
	// ServiceGlobal.getService(${der.getMajorPSDataEntity().getClassOrPkgName('SERVICE',pub)}.class,getSessionFactory());
	// ${der.getMajorPSDataEntity().getClassOrPkgName('ENTITY',pub)} entity =
	// new ${der.getMajorPSDataEntity().getClassOrPkgName('ENTITY',pub)}();
	// <#if item.getPSDEFieldsByDER(der.id)??>
	// <#list item.getPSDEFieldsByDER(der.id) as defield>
	// if(et.is${defield.codeName}Dirty()){
	// entity.set${defield.getRelatedPSDEField().codeName}(et.get${defield.codeName}());
	// }
	// </#list>
	// </#if>
	// //设置主键
	// entity.set("${der.getMajorPSDataEntity().getKeyPSDEField().name?upper_case}",objKey);
	// service.create(entity,false);
	// }
	// </#list>
	// }
	//
	// /**
	// * 内部更新数据
	// * @param entity
	// * @throws Exception
	// */
	// @Override
	// protected void internalUpdate( ${item.codeName} et) throws Exception
	// {
	// //获取主键
	// Object objKey = et.get${de.getKeyPSDEField().codeName}();
	// <#list item.getPSDERMultiInherits(false) as der>
	// //更新主实体[${der.getMajorPSDataEntity().name}]数据
	// if(true){
	// IService service =
	// ServiceGlobal.getService(${der.getMajorPSDataEntity().getClassOrPkgName('SERVICE',pub)}.class,getSessionFactory());
	// ${der.getMajorPSDataEntity().getClassOrPkgName('ENTITY',pub)} entity =
	// new ${der.getMajorPSDataEntity().getClassOrPkgName('ENTITY',pub)}();
	// <#if item.getPSDEFieldsByDER(der.id)??>
	// <#list item.getPSDEFieldsByDER(der.id) as defield>
	// if(et.is${defield.codeName}Dirty()){
	// entity.set${defield.getRelatedPSDEField().codeName}(et.get${defield.codeName}());
	// }
	// </#list>
	// </#if>
	// //设置主键
	// entity.set("${der.getMajorPSDataEntity().getKeyPSDEField().name?upper_case}",objKey);
	// service.update(entity,false);
	// }
	// </#list>
	// }
	//
	// /**
	// * 内部系统更新数据
	// * @param entity
	// * @throws Exception
	// */
	// @Override
	// protected void internalSysUpdate( ${item.codeName} et) throws Exception
	// {
	// //获取主键
	// Object objKey = et.get${de.getKeyPSDEField().codeName}();
	// <#list item.getPSDERMultiInherits(false) as der>
	// //系统更新主实体[${der.getMajorPSDataEntity().name}]数据
	// if(true){
	// IService service =
	// ServiceGlobal.getService(${der.getMajorPSDataEntity().getClassOrPkgName('SERVICE',pub)}.class,getSessionFactory());
	// ${der.getMajorPSDataEntity().getClassOrPkgName('ENTITY',pub)} entity =
	// new ${der.getMajorPSDataEntity().getClassOrPkgName('ENTITY',pub)}();
	// <#if item.getPSDEFieldsByDER(der.id)??>
	// <#list item.getPSDEFieldsByDER(der.id) as defield>
	// if(et.is${defield.codeName}Dirty()){
	// entity.set${defield.getRelatedPSDEField().codeName}(et.get${defield.codeName}());
	// }
	// </#list>
	// </#if>
	// //设置主键
	// entity.set("${der.getMajorPSDataEntity().getKeyPSDEField().name?upper_case}",objKey);
	// service.sysUpdate(entity,false);
	// }
	// </#list>
	// }
	//
	// /**
	// * 内部删除数据
	// * @param entity
	// * @throws Exception
	// */
	// @Override
	// protected void internalRemove( ${item.codeName} et) throws Exception
	// {
	// //获取主键
	// Object objKey = et.get${de.getKeyPSDEField().codeName}();
	// <#list srflist(item.getPSDERMultiInherits(false))?reverse as der>
	// //删除主实体[${der.getMajorPSDataEntity().name}]数据
	// if(true){
	// IService service =
	// ServiceGlobal.getService(${der.getMajorPSDataEntity().getClassOrPkgName('SERVICE',pub)}.class,getSessionFactory());
	// ${der.getMajorPSDataEntity().getClassOrPkgName('ENTITY',pub)} entity =
	// new ${der.getMajorPSDataEntity().getClassOrPkgName('ENTITY',pub)}();
	// //设置主键
	// entity.set("${der.getMajorPSDataEntity().getKeyPSDEField().name?upper_case}",objKey);
	// service.remove(entity);
	// }
	// </#list>
	// }
	//
	// </#if>
	
	
	
}
