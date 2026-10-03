package net.ibizsys.ssdynawf.ctrlhandler;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.ajax.IPSMDAjaxControlHandler;
import net.ibizsys.model.control.grid.IPSDEGrid;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import net.ibizsys.pswf.ctrlhandler.WFGridHandlerBase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 工作流表格处理对象
 * 
 * @author Administrator
 * 
 */
public class DynaWFGridHandler extends WFGridHandlerBase implements IDynaCtrlHandler {
	private static final Log log = LogFactory.getLog(DynaWFGridHandler.class);
	private IPSControl iPSControl = null;
	private IGridModel iGridModel = null;

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;

		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}

	/**
	 * @return
	 */
	public IPSDEGrid getPSDEGrid() {
		return (IPSDEGrid) getPSControl();
	}

	@Override
	protected void onInit() throws Exception {

		IPSDEGrid iPSDEGrid = getPSDEGrid();
		if (iPSDEGrid.isNoSort()) {
			this.setEnableUserSort(false);
		}
		if (iPSDEGrid.getMinorSortPSDEF() != null) {
			this.setMinorSortField(iPSDEGrid.getMinorSortPSDEF().getName());
			this.setMinorSortDir(iPSDEGrid.getMinorSortDir());
		}
		if (iPSDEGrid.isEnableRowEdit()) {
			this.setEnableRowEdit(true);
		}
		if (iPSDEGrid.isEnableItemPrivilege()) {
			this.setEnableItemPriv(true);
		}
		if (iPSDEGrid.getPSAjaxControlHandler() != null) {
			IPSMDAjaxControlHandler achandler = (IPSMDAjaxControlHandler) iPSDEGrid.getPSAjaxControlHandler();

			if (achandler.isEnableOrgDR()) {
				this.setEnableOrgDR(true);
				this.setOrgDR(achandler.getOrgDR());
			}
			if (achandler.isEnableSecDR()) {
				this.setEnableSecDR(true);
				this.setSecDR(achandler.getSecDR());
			}
			if (achandler.isEnableSecBC()) {
				this.setEnableSecBC(true);
				this.setSecBC(achandler.getSecBC());
			}
			if (achandler.isEnableUserDR()) {
				this.setEnableUserDR(true);
			}
//			if (achandler.getPSDEDataExport() != null) {
//				// 设置数据导出处理[${achandler.getPSDEDataExport().name}]
//				this.setDEDataExportId(achandler.getPSDEDataExport().getId());
//			}
		}

		iGridModel = (IGridModel) this.getViewController().getCtrlModel(getPSControl().getName().toLowerCase());

		super.onInit();
	}

	/**
	 * 获取当前的表格模型
	 * 
	 * @return
	 */
	protected IGridModel getGridModel() {
		return iGridModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#fetchDEDataSet(net.ibizsys
	 * .paas.core.DEDataSetFetchContext)
	 */
	@Override
	protected DBFetchResult fetchDEDataSet(DEDataSetFetchContext deDataSetFetchContext) throws Exception {
		IPSMDAjaxControlHandler achandler = (IPSMDAjaxControlHandler) this.getPSDEGrid().getPSAjaxControlHandler();
		if (!getPSControl().getPSAppView().isPickupView() || !this.getPSDEGrid().getPSDataEntity().isEnableTempData()) {
			if (this.getPSDEGrid().getPSAjaxControlHandler().getTempMode() > 0) {
				return this.getService().fetchDataSetTemp(achandler.getPSDEDataSet().getName(), deDataSetFetchContext);
			} else {
				return this.getService().fetchDataSet(achandler.getPSDEDataSet().getName(), deDataSetFetchContext);
			}
		} else {
			if (WebContext.isTempMode(this.getWebContext()))
				return this.getService().fetchDataSetTemp(achandler.getPSDEDataSet().getName(), deDataSetFetchContext);
			else
				return this.getService().fetchDataSet(achandler.getPSDEDataSet().getName(), deDataSetFetchContext);

		}

	}

	//
	// if(!appview.isPickupMode()>
	//
	// if(iPSDEGrid.isEnableRowEdit()>
	// /**
	// * 准备部件成员处理对象
	// * @throws Exception
	// */
	// @Override
	// protected void prepareCtrlItemHandlers()throws Exception
	// {
	// super.prepareCtrlItemHandlers();
	//
	// <#list item.getPSDEGridEditItems() as gridedititem>
	// if((gridedititem.getItemHandlerType()??) &&
	// (gridedititem.getItemHandlerType()?length>0)>
	// //注册 '${gridedititem.name}'
	// ${appview.codeName}${srfclassname('${item.name}')}${srfclassname('${gridedititem.name}')}Handler
	// ${srfparamname('${gridedititem.name}')}Handler = new
	// ${appview.codeName}${srfclassname('${item.name}')}${srfclassname('${gridedititem.name}')}Handler();
	// ${srfparamname('${gridedititem.name}')}Handler.init(this.getGridModel(),this);
	// this.registerCtrlItemHandler(ITEMACTIONTYPE_GRIDEDITITEM+"${gridedititem.codeName}",${srfparamname('${gridedititem.name}')}Handler);
	//
	// }
	// </#list>
	//
	// if(iPSDEGrid.getPSDEGridEditItemUpdates()??>
	// <#list item.getPSDEGridEditItemUpdates() as geiupdate>
	// //注册表格编辑项更新 '${geiupdate.codeName}'
	// ${appview.codeName}${srfclassname('${item.name}')}${srfclassname('${geiupdate.codeName}')}Handler
	// ${srfparamname('${geiupdate.codeName}')}Handler = new
	// ${appview.codeName}${srfclassname('${item.name}')}${srfclassname('${geiupdate.codeName}')}Handler();
	// ${srfparamname('${geiupdate.codeName}')}Handler.init(this.getGridModel(),this);
	// this.registerCtrlItemHandler(ITEMACTIONTYPE_GRIDEDITITEMUPDATE+"${geiupdate.codeName}",${srfparamname('${geiupdate.codeName}')}Handler);
	// </#list>
	// }
	// }
	//
	// }
	// <#-- 加载草稿操作 -->
	// if(iPSDEGrid.getPSAjaxControlHandler().getDEActionName('loaddraft')??>
	// <#assign deactionname
	// =item.getPSAjaxControlHandler().getDEActionName('loaddraft')>
	// if((deactionname?length>0)>
	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#getDraftEntity()
	// */
	// @Override
	// protected IEntity getDraftEntity()throws Exception
	// {
	// ${de.codeName} entity = new ${de.codeName}();
	// getDraftEntity(entity);
	// return entity;
	// }
	//
	// /**
	// * 获取操作数据对象
	// * @param entity
	// * @throws Exception
	// */
	// protected void getDraftEntity(${de.codeName} entity)throws Exception
	// {
	// this.getRealService().executeAction(${de.codeName}Service.ACTION_${deactionname?upper_case},entity);
	// }
	// }
	// }
	//
	// <#-- 加载操作 -->
	// if(iPSDEGrid.getPSAjaxControlHandler().getDEActionName('load')??>
	// <#assign deactionname
	// =item.getPSAjaxControlHandler().getDEActionName('load')>
	// if((deactionname?length>0)>
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#getEntity(java.lang.Object)
	// */
	// @Override
	// protected IEntity getEntity(Object objKeyValue)throws Exception
	// {
	// ${de.codeName} entity = new ${de.codeName}();
	// entity.set(${de.codeName}.FIELD_${de.getKeyDEField().codeName?upper_case},objKeyValue);
	// this.getRealService().executeAction(${de.codeName}Service.ACTION_${deactionname?upper_case},entity);
	// return entity;
	// }
	// }
	// }
	//
	//
	// <#-- 建立操作 -->
	// if(iPSDEGrid.getPSAjaxControlHandler().getDEActionName('create')??>
	// <#assign deactionname
	// =item.getPSAjaxControlHandler().getDEActionName('create')>
	// if((deactionname?length>0)>
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#createEntity(net.ibizsys.paas.entity.IEntity)
	// */
	// @Override
	// protected IEntity createEntity(IEntity iEntity)throws Exception
	// {
	// this.getRealService().executeAction(${de.codeName}Service.ACTION_${deactionname?upper_case},iEntity);
	// return iEntity;
	// }
	// }
	// }
	//
	// <#-- 更新操作 -->
	// if(iPSDEGrid.getPSAjaxControlHandler().getDEActionName('update')??>
	// <#assign deactionname
	// =item.getPSAjaxControlHandler().getDEActionName('update')>
	// if((deactionname?length>0)>
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#updateEntity(net.ibizsys.paas.entity.IEntity)
	// */
	// @Override
	// protected IEntity updateEntity(IEntity iEntity)throws Exception
	// {
	// this.getRealService().executeAction(${de.codeName}Service.ACTION_${deactionname?upper_case},iEntity);
	// return iEntity;
	// }
	// }
	// }
	//
	// <#-- 删除操作 -->
	// if(iPSDEGrid.getPSAjaxControlHandler().getDEActionName('remove')??>
	// <#assign deactionname
	// =item.getPSAjaxControlHandler().getDEActionName('remove')>
	// if((deactionname?length>0)>
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#removeEntity(java.lang.Object)
	// */
	// @Override
	// protected void removeEntity(Object objKeyValue)throws Exception
	// {
	// ${de.codeName} entity = new ${de.codeName}();
	// entity.set(${de.codeName}.FIELD_${de.getKeyDEField().codeName?upper_case},objKeyValue);
	// this.getRealService().executeAction(${de.codeName}Service.ACTION_${deactionname?upper_case},entity);
	// }
	// }
	// }
	//
	// if((appview.isEnableBatchAdd())>
	// <#assign dernn=de.getPSDERNN()>
	// /* (non-Javadoc)
	// * @see
	// net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#getDraftEntity(java.lang.String,java.lang.String,java.lang.String,java.lang.String)
	// */
	// @Override
	// protected IEntity getDraftEntity(String strParentType,String
	// strTypeParam,String strParentKey,String strParentKey2) throws Exception
	// {
	// ${de.codeName} entity = new ${de.codeName}();
	// <#assign der1n=dernn.getFirstPSDER1N()>
	// <#assign der1n2=dernn.getSecondPSDER1N()>
	// if ( (StringHelper.compare(strTypeParam,"${der1n.name}",true)==0))
	// {
	// entity.set(${de.codeName}.FIELD_${de.getPSDEField('${der1n2.getPickupDEFName()}').codeName?upper_case},strParentKey2);
	// this.getDraftEntity(entity);
	// return entity;
	// }
	// <#assign der1n2=dernn.getFirstPSDER1N()>
	// <#assign der1n=dernn.getSecondPSDER1N()>
	// if ((StringHelper.compare(strTypeParam,"${der1n.name}",true)==0))
	// {
	// entity.set(${de.codeName}.FIELD_${de.getPSDEField('${der1n2.getPickupDEFName()}').codeName?upper_case},strParentKey2);
	// this.getDraftEntity(entity);
	// return entity;
	// }
	//
	// throw new Exception("无法填充关系数据对象");
	// }
	//
	// }
	//
	// if((item.getPSAjaxControlHandler().getTempMode()==2)>
	// /* (non-Javadoc)
	// * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#getTempMode()
	// */
	// @Override
	// public int getTempMode()
	// {
	// //临时数据从模式
	// return TEMPMODE_MINOR;
	// }
	// }
	//

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.MDCtrlHandlerBase#getTempMode()
	 */
	@Override
	public int getTempMode() {
		if (this.getPSDEGrid().getPSAjaxControlHandler().getTempMode() == 1) {
			// 临时数据主模式
			return TEMPMODE_MAJOR;
		}
		if (this.getPSDEGrid().getPSAjaxControlHandler().getTempMode() == 2) {
			// 临时数据从模式
			return TEMPMODE_MINOR;
		}

		return super.getTempMode();
	}

}
