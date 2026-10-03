package net.ibizsys.ssdyna.demodel;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.ac.IPSDEACMode;
import net.ibizsys.model.dataentity.ds.IPSDEDataQuery;
import net.ibizsys.model.dataentity.ds.IPSDEDataSet;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEFieldModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.entity.DynaEntity;
import net.ibizsys.ssdyna.service.DynaService;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * 动态实体模型对象
 * 
 * @author Administrator
 * 
 */
public class DynaDEModel extends DataEntityModelBase<DynaEntity> implements IDynaDEModel<DynaEntity> {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(DynaDEModel.class);
	private IPSDataEntity iPSDataEntity = null;
	private IDynaSysModel iDynaSysModel = null;

	public DynaDEModel() throws Exception {
		super();
	}

	/**
	 * 初始化
	 * 
	 * @param iDynaSysModel
	 * @param iPSDataEntity
	 */
	public void init(IDynaSysModel iDynaSysModel, IPSDataEntity iPSDataEntity) throws Exception {
		this.iDynaSysModel = iDynaSysModel;
		this.iPSDataEntity = iPSDataEntity;

		this.setId(this.getPSDataEntity().getId());
		this.setName(this.getPSDataEntity().getName());
		this.setTableName(this.getPSDataEntity().getTableName());
		this.setViewName(this.getPSDataEntity().getViewName());
		this.setLogicName(this.getPSDataEntity().getLogicName());
		if (this.getPSDataEntity().isLogicValid()) {
			this.setLogicValid(true);
			this.setValidValue(this.getPSDataEntity().getLogicValidStringValue(true));
			this.setInvalidValue(this.getPSDataEntity().getLogicValidStringValue(false));
		}

		if (!StringHelper.isNullOrEmpty(this.getPSDataEntity().getDSLink())) {
			this.setDSLink(this.getPSDataEntity().getDSLink());
		}

		if (this.getPSDataEntity().isEnableMultiDS()) {
			this.setEnableMultiDS(true);
		}
		if (this.getPSDataEntity().isEnableMultiForm()) {
			this.setEnableMultiForm(true);
		}
		if (!StringHelper.isNullOrEmpty(this.getPSDataEntity().getIndexDEType())) {
			this.setIndexDEType(this.getPSDataEntity().getIndexDEType());
		}
		if (this.getPSDataEntity().getInheritPSDataEntity() != null) {
			// 设置继承实体 this.getPSDataEntity().getInheritPSDataEntity().name}
			this.setInheritDEId(this.getPSDataEntity().getInheritPSDataEntity().getId());
			this.setInheritTypeValue(this.getPSDataEntity().getPSDERInherit().getTypeValue());
		}
		this.setDataAccCtrlMode(this.getPSDataEntity().getDataAccCtrlMode());
		this.setAuditMode(this.getPSDataEntity().getAuditMode());
		if (this.getPSDataEntity().getDataChangeLogMode() != 0) {
			this.setDataChangeLogMode(this.getPSDataEntity().getDataChangeLogMode());
		}
		if (this.getPSDataEntity().isNoViewMode()) {
			this.setNoViewMode(true);
		}
		if (this.getPSDataEntity().getStorageMode() != 1) {
			this.setStorageMode(this.getPSDataEntity().getStorageMode());
		}

		// DEModelGlobal.registerDEModel("${pub.getPKGCodeName()}.srv.this.getPSDataEntity().getPSSystemModule().codeName?lower_case}.demodel.this.getPSDataEntity().codeName}DEModel",this);

		this.prepareModels();
		// 注册到系统中
		this.iDynaSysModel.registerDataEntityModel(this);

	}

	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	@Override
	public IPSDataEntity getPSDataEntity() {
		return this.iPSDataEntity;
	}

	//
	//
	// private ${sys.codeName}SysModel
	// ${srfparamname('${sys.codeName}')}SysModel;
	// /**
	// * 获取当前系统[${sys.codeName}]模型对象
	// * @return
	// */
	// public ${sys.codeName}SysModel get${sys.codeName}SysModel() {
	// if(this.${srfparamname('${sys.codeName}')}SysModel==null)
	// {
	// try
	// {
	// this.${srfparamname('${sys.codeName}')}SysModel =
	// (${sys.codeName}SysModel)SysModelGlobal.getSystem("${pub.getPKGCodeName()}.srv.${sys.codeName}SysModel");
	// }
	// catch(Exception ex)
	// {
	// }
	// }
	// return this.${srfparamname('${sys.codeName}')}SysModel;
	// }
	//
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#getSystem()
	 */
	@Override
	public ISystem getSystem() {
		return this.iDynaSysModel;
	}

	@Override
	public IDynaSysModel getDynaSysModel() {
		return this.iDynaSysModel;
	}

	private DynaService dynaService;

	/**
	 * 获取实际实体服务对象
	 * 
	 * @return
	 */
	public DynaService getRealService() {
		if (this.dynaService == null) {
			try {
				DynaService dynaService = new DynaService();
				dynaService.init(this);
				this.dynaService = dynaService;
			} catch (Exception ex) {
			}
		}
		return this.dynaService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#getService()
	 */
	@Override
	public IService getService() {
		return this.getRealService();
	}
	
	
	@Override
	public IService getService(SessionFactory sessionFactory) throws Exception {
		return getRealService();
	}

	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.demodel.IDataEntityModel#getServiceId()
	// */
	// @Override
	// public String getServiceId()
	// {
	// return
	// "${pub.getPKGCodeName()}.srv.this.getPSDataEntity().getPSSystemModule().codeName?lower_case}.service.this.getPSDataEntity().codeName}Service";
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDataEntityModel#createEntity()
	 */
	@Override
	public DynaEntity createEntity() {
		DynaEntity dynaEntity = new DynaEntity();
		if(!StringHelper.isNullOrEmpty(this.getInheritTypeValue())){
			try{
				dynaEntity.set(this.getPSDataEntity().getInheritPSDataEntity().getIndexTypePSDEField().getName(), this.getInheritTypeValue());
			}
			catch(Exception ex){
				log.error(ex);
			}
		}
		
		return dynaEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEFields()
	 */
	@Override
	protected void prepareDEFields() throws Exception {
		IDEField iDEField = null;
		IDEFSearchMode iDEFSearchMode = null;
		java.util.Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
		while (psDEFields.hasNext()) {
			IPSDEField iPSDEField = psDEFields.next();

			// 注册属性 iPSDEField.name}"
			iDEField = this.createDEField(iPSDEField.getName());
			if (iDEField == null) {
				DEFieldModel deFieldModel = new DEFieldModel();
				deFieldModel.setDataEntity(this);
				deFieldModel.setId(iPSDEField.getId());
				deFieldModel.setName(iPSDEField.getName());
				deFieldModel.setLogicName(iPSDEField.getLogicName());
				deFieldModel.setDataType(iPSDEField.getDataType());
				deFieldModel.setStdDataType(iPSDEField.getStdDataType());
				if (iPSDEField.isKeyDEField()) {
					deFieldModel.setKeyDEField(true);
				}
				if (iPSDEField.isMajorDEField()) {
					deFieldModel.setMajorDEField(true);
				}
				if (!StringHelper.isNullOrEmpty(iPSDEField.getUnionKeyValue())) {
					deFieldModel.setUnionKeyValue(iPSDEField.getUnionKeyValue());
				}
				if (iPSDEField.isLinkDEField()) {
					deFieldModel.setLinkDEField(true);
				}
				if (iPSDEField.isInheritDEField()) {
					deFieldModel.setInheritDEField(true);
				}
				if (iPSDEField.isMultiFormDEField()) {
					deFieldModel.setMultiFormDEField(true);
				}
				if (iPSDEField.isIndexTypeDEField()) {
					deFieldModel.setIndexTypeDEField(true);
				}
				deFieldModel.setImportOrder(iPSDEField.getImportOrder());
				deFieldModel.setImportTag(iPSDEField.getImportTag());
				if (iPSDEField.getDERName() != null) {
					deFieldModel.setDERName(iPSDEField.getDERName());
				}
				if (iPSDEField.getLinkDEFName() != null) {
					deFieldModel.setLinkDEFName(iPSDEField.getLinkDEFName());
				}
				if (!iPSDEField.isPhisicalDEField()) {
					deFieldModel.setPhisicalDEField(false);
				}
				if (iPSDEField.isFormulaDEField()) {
					deFieldModel.setFormulaDEField(true);
				}
				if (!StringHelper.isNullOrEmpty(iPSDEField.getPreDefinedType())) {
					deFieldModel.setPreDefinedType(iPSDEField.getPreDefinedType());
				}
				if (!StringHelper.isNullOrEmpty(iPSDEField.getDBValueFunc())) {
					deFieldModel.setDBValueFunc(iPSDEField.getDBValueFunc());
				}
				if ((iPSDEField.getPSCodeList() != null)) {
					deFieldModel.setCodeListId(iPSDEField.getPSCodeList().getId());
				}
				if (iPSDEField.getValueFormat() != null) {
					deFieldModel.setValueFormat(iPSDEField.getValueFormat());
				}
				if (iPSDEField.isEnableAudit()) {
					deFieldModel.setEnableAudit(true);
					if (!StringHelper.isNullOrEmpty(iPSDEField.getAuditInfoFormat())) {
						deFieldModel.setAuditInfoFormat(iPSDEField.getAuditInfoFormat());
					}
				}

				if (this.getPSDataEntity().isEnableTempData() && !iPSDEField.isEnableTempData()) {
					deFieldModel.setEnableTempData(false);
				}
				java.util.Iterator<IPSDEFSearchMode> psDEFSearchModes = iPSDEField.getAllPSDEFSearchModes();
				while (psDEFSearchModes.hasNext()) {
					IPSDEFSearchMode iPSDEFSearchMode = psDEFSearchModes.next();
					iDEFSearchMode = this.createDEFSearchMode(deFieldModel, iPSDEFSearchMode.getName());
					if (iDEFSearchMode == null) {
						DEFSearchModeModel defSearchModeModel = new DEFSearchModeModel();
						defSearchModeModel.setDEField(deFieldModel);
						defSearchModeModel.setName(iPSDEFSearchMode.getName());
						if (!StringHelper.isNullOrEmpty(iPSDEFSearchMode.getValueFunc())) {
							defSearchModeModel.setValueFunc(iPSDEFSearchMode.getValueFunc());
						}
						defSearchModeModel.setValueOp(iPSDEFSearchMode.getValueOp());
						defSearchModeModel.init();
						deFieldModel.registerDEFSearchMode(defSearchModeModel);
					}
				}

				deFieldModel.init();
				iDEField = deFieldModel;
			}
			this.registerDEField(iDEField);
		}

		psDEFields = this.getPSDataEntity().getDEMainStateDEFields();
		if (psDEFields != null) {
			ArrayList<String> list = new ArrayList<String>();
			while (psDEFields.hasNext()) {
				list.add(psDEFields.next().getName().toLowerCase());
			}
			this.setMainStateFields(list.toArray(new String[list.size()]));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEACModes()
	 */
	@Override
	protected void prepareDEACModes() throws Exception {

		java.util.Iterator<IPSDEACMode> psDEACModes = this.getPSDataEntity().getAllPSDEACModes();
		while (psDEACModes.hasNext()) {
			DynaDEACModel dynaDEACMode = new DynaDEACModel();
			dynaDEACMode.init(this, psDEACModes.next());
			this.registerDEACMode(dynaDEACMode);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataSets()
	 */
	@Override
	protected void prepareDEDataSets() throws Exception {

		java.util.Iterator<IPSDEDataSet> psDEDataSets = this.getPSDataEntity().getAllPSDEDataSets();
		while (psDEDataSets.hasNext()) {
			IPSDEDataSet iPSDEDataSet = psDEDataSets.next();
			if (StringHelper.isNullOrEmpty(iPSDEDataSet.getPredefinedType())) {
				DynaDEDataSetModel dynaDEDataSetModel = new DynaDEDataSetModel();
				dynaDEDataSetModel.init(this, iPSDEDataSet);
				this.registerDEDataSet(dynaDEDataSetModel);
			} else {
				DynaCodeListDEDataSetModel dynaCodeListDEDataSetModel = new DynaCodeListDEDataSetModel();
				dynaCodeListDEDataSetModel.init(this, iPSDEDataSet);
				this.registerDEDataSet(dynaCodeListDEDataSetModel);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataQueries()
	 */
	@Override
	protected void prepareDEDataQueries() throws Exception {

		java.util.Iterator<IPSDEDataQuery> psDEDataQueries = this.getPSDataEntity().getAllPSDEDataQueries();
		while (psDEDataQueries.hasNext()) {
			IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
			DynaDEDataQueryModel dynaDEDataQueryModel = new DynaDEDataQueryModel();
			dynaDEDataQueryModel.init(this, iPSDEDataQuery);
			this.registerDEDataQuery(dynaDEDataQueryModel);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEActions()
	 */
	@Override
	protected void prepareDEActions() throws Exception {
		// <#list this.getPSDataEntity().getAllPSDEActions() as deaction>
		// if((deaction.actionType=='SYSDBPROC')>
		// //注册 ${deaction.name}
		// this.getPSDataEntity().codeName}${deaction.codeName}DBProcModel
		// ${srfparamname('${deaction.codeName}')}DBProcModel = new
		// this.getPSDataEntity().codeName}${deaction.codeName}DBProcModel();
		// ${srfparamname('${deaction.codeName}')}DBProcModel.init(this);
		// this.registerDEAction(${srfparamname('${deaction.codeName}')}DBProcModel);
		// }
		// </#list>

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDELogics()
	 */
	@Override
	protected void prepareDELogics() throws Exception {
		// <#list this.getPSDataEntity().getAllPSDELogics() as delogic>
		// //注册 ${delogic.name}
		// this.getPSDataEntity().codeName}${delogic.codeName}LogicModel
		// ${srfparamname('${delogic.codeName}')}LogicModel = new
		// this.getPSDataEntity().codeName}${delogic.codeName}LogicModel();
		// ${srfparamname('${delogic.codeName}')}LogicModel.init(this);
		// this.registerDELogic(${srfparamname('${delogic.codeName}')}LogicModel);
		//
		// </#list>
		// <#list this.getPSDataEntity().getAllPSDEActions() as deaction>
		// if(deaction.getPSDEActionLogics()!=null>
		// <#list deaction.getPSDEActionLogics() as actionlogic>
		// if(actionlogic.isInternalLogic()>
		// this.registerDEActionLogic("${deaction.codeName?upper_case}","${actionlogic.getAttachMode()}","${actionlogic.getPSDELogic().codeName);
		// }
		// </#list>
		// }
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEUIActions()
	 */
	@Override
	protected void prepareDEUIActions() throws Exception {
		// <#list this.getPSDataEntity().getAllPSDEUIActions() as deuiaction>
		// if((deuiaction.getUIActionMode()=='BACKEND')>
		// //注册 ${deuiaction.name}
		// this.getPSDataEntity().codeName}${deuiaction.codeName}UIActionModel
		// ${srfparamname('${deuiaction.codeName}')}UIActionModel = new
		// this.getPSDataEntity().codeName}${deuiaction.codeName}UIActionModel();
		// ${srfparamname('${deuiaction.codeName}')}UIActionModel.init(this);
		// this.registerDEUIAction(${srfparamname('${deuiaction.codeName}')}UIActionModel);
		// }
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEWFs()
	 */
	@Override
	protected void prepareDEWFs() throws Exception {

		java.util.Iterator<IPSDEWF> psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
		while (psDEWFs.hasNext()) {
			IPSDEWF iPSDEWF = psDEWFs.next();
			DynaDEWFModel dynaDEWFModel = new DynaDEWFModel();
			dynaDEWFModel.init(this, iPSDEWF);
			this.registerDEWF(dynaDEWFModel);
		}

		// <#list this.getPSDataEntity().getAllPSDEWFs() as dewf>
		// //注册 ${dewf.getPSWorkflow().name}
		// this.getPSDataEntity().codeName}${dewf.codeName}DEWFModel
		// ${srfparamname('${dewf.codeName}')}DEWFModel = new
		// this.getPSDataEntity().codeName}${dewf.codeName}DEWFModel();
		// ${srfparamname('${dewf.codeName}')}DEWFModel.init(this);
		// this.registerDEWF(${srfparamname('${dewf.codeName}')}DEWFModel);
		//
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEMainStates()
	 */
	@Override
	protected void prepareDEMainStates() throws Exception {
		// <#list this.getPSDataEntity().getAllPSDEMainStates() as dems>
		// //注册 ${dems.name}
		// DEMainStateModel deMSModel${dems_index = new DEMainStateModel();
		// deMSModel${dems_index.setId("${dems.getId());
		// if(dems.getMSTag()!=null>
		// deMSModel${dems_index.setMSTag("${dems.getMSTag());
		// }
		// deMSModel${dems_index.setLogicName("${dems.logicName);
		// if((dems.isAllowMode())>
		// deMSModel${dems_index.setAllowMode(true);
		// <#else>
		// deMSModel${dems_index.setAllowMode(false);
		// }
		// if((dems.isDefault())>
		// deMSModel${dems_index.setDefault(true);
		// <#else>
		//
		// }
		// if(dems.getPSDEMainStateActions()!=null>
		// <#list dems.getPSDEMainStateActions() as demsaction>
		// deMSModel${dems_index.registerDEAction("${demsaction.getPSDEAction().codeName?upper_case);
		// </#list>
		// }
		// deMSModel${dems_index.init(this);
		// this.registerDEMainState( deMSModel${dems_index);
		//
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataSyncs()
	 */
	@Override
	protected void prepareDEDataSyncs() throws Exception {
		// <#list this.getPSDataEntity().getAllPSDEDataSyncs() as dedatasync>
		// if(dedatasync.isValid()>
		// //注册 ${dedatasync.name}
		// DEDataSyncModel deDataSyncModel${dedatasync_index = new
		// DEDataSyncModel();
		// deDataSyncModel${dedatasync_index.setId("${dedatasync.getId());
		// deDataSyncModel${dedatasync_index.setName("${dedatasync.getName());
		// deDataSyncModel${dedatasync_index.setInMode(if(dedatasync.isInMode()>true<#else>false});
		// deDataSyncModel${dedatasync_index.setEventType(${dedatasync.getEventType());
		// if(dedatasync.getTestDEActionName()!=null>
		// deDataSyncModel${dedatasync_index.setTestDEActionName("${dedatasync.getTestDEActionName());
		// }
		// if(dedatasync.isInMode()>
		// if(dedatasync.getSyncAgent()!=null>
		// //${dedatasync.getInPSSysDataSyncAgent().name}
		// deDataSyncModel${dedatasync_index.setSyncAgent("${dedatasync.getSyncAgent());
		// }
		// if(dedatasync.getImportDEActionName()!=null>
		// deDataSyncModel${dedatasync_index.setImportDEActionName("${dedatasync.getImportDEActionName());
		// }
		// if(dedatasync.getDENames()!=null>
		// <#list dedatasync.getDENames() as dename>
		// deDataSyncModel${dedatasync_index.addDEName("${dename);
		// </#list>
		// }
		// <#else>
		// if(dedatasync.getSyncAgent()!=null>
		// //${dedatasync.getOutPSSysDataSyncAgent().name}
		// deDataSyncModel${dedatasync_index.setSyncAgent("${dedatasync.getSyncAgent());
		// }
		// }
		// deDataSyncModel${dedatasync_index.init(this);
		// this.registerDEDataSync( deDataSyncModel${dedatasync_index);
		// }
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#preparePDTDEViews()
	 */
	@Override
	protected void preparePDTDEViews() throws Exception {
		// if(this.getPSDataEntity().getPDTViewNames()!=null>
		// <#list this.getPSDataEntity().getPDTViewNames() as pdtname>
		// //注册视图
		// this.getPSDataEntity().getPSDEViewDataByPDT('${pdtname}',false).getPSDEVIEWBASENAME()}
		// this.registerPDTDEView("${pdtname}",this.getPSDataEntity().getPSDEViewIdByPDT('${pdtname}'));
		// </#list>
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEOPPrivTagMaps()
	 */
	@Override
	protected void prepareDEOPPrivTagMaps() throws Exception {
		// <#list sys.getAllPSDEOPPrivs() as deoppriv>
		// if(deoppriv.getPSDataEntity()!=null>
		// if((deoppriv.getPSDataEntity().id == this.getPSDataEntity().getId())
		// && deoppriv.getPSDERName()!=null>
		// this.registerMapDEOPPrivTag("${deoppriv.name}","${deoppriv.getPSDERName()}","${deoppriv.getMapPSDEOPPrivName());
		// }
		// }
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEPrints()
	 */
	@Override
	protected void prepareDEPrints() throws Exception {
		// <#list this.getPSDataEntity().getAllPSDEPrints()as deprint>
		// //注册 ${deprint.name}
		// this.getPSDataEntity().codeName}${deprint.codeName}PrintService
		// ${srfparamname('${deprint.codeName}')}PrintService = new
		// this.getPSDataEntity().codeName}${deprint.codeName}PrintService();
		// ${srfparamname('${deprint.codeName}')}PrintService.init(this);
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEReports()
	 */
	@Override
	protected void prepareDEReports() throws Exception {
		// <#list this.getPSDataEntity().getAllPSDEReports()as dereport>
		// //注册 ${dereport.name}
		// this.getPSDataEntity().codeName}${dereport.codeName}ReportService
		// ${srfparamname('${dereport.codeName}')}ReportService = new
		// this.getPSDataEntity().codeName}${dereport.codeName}ReportService();
		// ${srfparamname('${dereport.codeName}')}ReportService.init(this);
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#prepareDEDataExports()
	 */
	@Override
	protected void prepareDEDataExports() throws Exception {
		// <#list this.getPSDataEntity().getAllPSDEDataExports() as
		// dedataexport>
		// //注册 ${dedataexport.name}
		// this.getPSDataEntity().codeName}${dedataexport.codeName}DataExportModel
		// ${srfparamname('${dedataexport.codeName}')}DataExportModel = new
		// this.getPSDataEntity().codeName}${dedataexport.codeName}DataExportModel();
		// ${srfparamname('${dedataexport.codeName}')}DataExportModel.init(this);
		// this.registerDEDataExport(${srfparamname('${dedataexport.codeName}')}DataExportModel);
		// </#list>
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.demodel.DataEntityModelBase#onFillFetchQuickSearchConditions
	 * (net.ibizsys.paas.core.DEDataSetCond, java.lang.String)
	 */
	@Override
	protected void onFillFetchQuickSearchConditions(DEDataSetCond groupCondImpl, String strQuickSearch) throws Exception {
		super.onFillFetchQuickSearchConditions(groupCondImpl, strQuickSearch);

		// <#list this.getPSDataEntity().getPSDEFields() as defield>
		// if(iPSDEField.isEnableQuickSearch()>
		// //放入属性 iPSDEField.name} - iPSDEField.logicName}
		// if(true)
		// {
		// DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
		// deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
		// deDataSetCondImpl.setCondOp(ICondition.CONDOP_LIKE);
		// deDataSetCondImpl.setDEFName(this.getPSDataEntity().codeName}.FIELD_iPSDEField.codeName?upper_case});
		// deDataSetCondImpl.setCondValue(strQuickSearch);
		// groupCondImpl.addChildDEDataQueryCond(deDataSetCondImpl);
		// }
		// }
		// </#list>
	}

	@Override
	public boolean isDynaDETemplMode() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
