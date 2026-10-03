package net.ibizsys.ssdyna.demodel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.dataentity.field.IPSDEFSearchMode;
import net.ibizsys.model.dataentity.field.IPSDEField;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.demodel.DEFSearchModeModel;
import net.ibizsys.paas.demodel.DEFieldModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.ssdyna.sysmodel.IDynaSysModel;

/**
 * 动态实体模型基类
 * 
 * @author Administrator
 *
 * @param <ET>
 */
public abstract class DataEntityModelBase<ET extends IEntity> extends net.ibizsys.saas.demodel.DataEntityModelBase<ET> implements IDynaDEModel<ET> {

	private static final Log log = LogFactory.getLog(DataEntityModelBase.class);
	private IPSDataEntity iPSDataEntity = null;
	private IDynaSysModel iDynaSysModel = null;
	private boolean bInit = false;

	public DataEntityModelBase() throws Exception {
		super();
	}

	@Override
	public void init(IDynaSysModel iDynaSysModel, IPSDataEntity iPSDataEntity) throws Exception {
		if (!isDynaDETemplMode()) {
			throw new Exception("当前实体模型对象不支持初始化操作");
		}
		this.iDynaSysModel = iDynaSysModel;
		this.iPSDataEntity = iPSDataEntity;
		this.bInit = true;
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
		this.prepareModels();
		this.onInit();
		this.iPSDataEntity = null;
	}

	@Override
	protected void prepareModels() throws Exception {
		if (isDynaDETemplMode()) {
			if (!this.bInit)
				return;
			// 准备静态模型
			super.prepareModels();
			// 准备动态模型
			prepareDynaModels();
		} else {
			super.prepareModels();
		}
	}

	/**
	 * 准备动态模型集合
	 * 
	 * @throws Exception
	 */
	protected void prepareDynaModels() throws Exception {

		this.prepareDynaDEFields();
		this.prepareDynaDEWFs();
		this.prepareDynaPDTDEViews();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.ssdyna.demodel.IDynaDEModel#getPSDataEntity()
	 */
	//@Override
	public IPSDataEntity getPSDataEntity() throws Exception{
		if(this.iPSDataEntity == null) {
			throw new Exception(StringHelper.format("无法获取实体]%1$s][%2$s]动态模型对象",this.getName(),this.getId()));
		}
		return this.iPSDataEntity;
	}

	/**
	 * 设置实体对象
	 * 
	 * @param iPSDataEntity
	 */
	protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
		this.iPSDataEntity = iPSDataEntity;
	}

	@Override
	public IDynaSysModel getDynaSysModel() {
		return (IDynaSysModel) this.getSystemModel();
	}

	@Override
	public boolean isDynaDETemplMode() {
		return false;
	}

	@Override
	protected boolean isRegisterToDEModelGlobal() {
		return !isDynaDETemplMode();
	}

	/**
	 * 准备动态实体工作流
	 * 
	 * @throws Exception
	 */
	protected void prepareDynaDEWFs() throws Exception {

		this.resetDEWFs();
		
		java.util.Iterator<IPSDEWF> psDEWFs = this.getPSDataEntity().getAllPSDEWFs();
		while (psDEWFs.hasNext()) {
			IPSDEWF iPSDEWF = psDEWFs.next();
			DynaDEWFModel psJITDEWFModel = new DynaDEWFModel();
			psJITDEWFModel.init(this, iPSDEWF);
			this.registerDEWF(psJITDEWFModel);
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

	/**
	 * 准备实体动态属性
	 * @throws Exception
	 */
	protected void prepareDynaDEFields()throws Exception{
		IDEField iDEField = null;
		IDEFSearchMode iDEFSearchMode = null;
		java.util.Iterator<IPSDEField> psDEFields = this.getPSDataEntity().getPSDEFields();
		while (psDEFields.hasNext()) {
			IPSDEField iPSDEField = psDEFields.next();
			//判断当前属性是否存在
			if(this.getDEField(iPSDEField.getName(),true)!=null)
				continue;
			
			// 注册属性 iPSDEField.name}"
			iDEField = this.createDEField(iPSDEField.getName());
			if (iDEField == null) {
				DEFieldModel deFieldModel = new DEFieldModel();
				deFieldModel.setDataEntity(this);
				deFieldModel.setId(iPSDEField.getId());
				deFieldModel.setName(iPSDEField.getName());
				deFieldModel.setLogicName(iPSDEField.getLogicName());
				deFieldModel.setDEFType(iPSDEField.getDEFType());
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
	}
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.DataEntityModelBase#preparePDTDEViews()
	 */
	//@Override
	protected void prepareDynaPDTDEViews() throws Exception
	{
		java.util.Iterator<String> pdtViewNames = this.getPSDataEntity().getPDTViewNames();
		if(pdtViewNames!=null) {
			while(pdtViewNames.hasNext()) {
				String strPDTViewName = pdtViewNames.next();
				this.registerPDTDEView(strPDTViewName,this.getPSDataEntity().getPSDEViewIdByPDT(strPDTViewName));
			}
		}
		
		
//<#if item.getPDTViewNames()??>
//<#list item.getPDTViewNames() as pdtname>
//         //注册视图 ${item.getPSDEViewDataByPDT('${pdtname}',false).getPSDEVIEWBASENAME()}
//         this.registerPDTDEView("${pdtname}","${item.getPSDEViewIdByPDT('${pdtname}')}");
//</#list>
//</#if>
	}
}
