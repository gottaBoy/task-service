package net.ibizsys.ssdynawf.ctrlhandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDEEditFormHandler;
import net.ibizsys.model.control.form.IPSDEForm;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.WFActionParam;
import net.ibizsys.pswf.ctrlhandler.WFActionFormHandlerBase;
import net.ibizsys.ssdyna.ctrlhandler.IDynaCtrlHandler;
import net.ibizsys.ssdyna.view.IDynaViewModel;
import net.ibizsys.sswf.api.SaaSWFActionParam;

/**
 * JIT工作流交互表单处理对象
 * @author Administrator
 *
 */
public class DynaWFActionFormHandler extends WFActionFormHandlerBase  implements IDynaCtrlHandler {

	private IPSControl iPSControl = null;
	private static final Log log = LogFactory.getLog(DynaWFActionFormHandler.class);
	private IEditFormModel iEditFormModel = null;
	private IPSDEEditFormHandler iPSDEEditFormHandler = null;

	@Override
	public void init(IDynaViewModel iDynaViewModel, IPSControl iPSControl) throws Exception {
		this.iPSControl = iPSControl;
		this.init(iDynaViewModel);
	}

	@Override
	public IPSControl getPSControl() {
		return this.iPSControl;
	}

	@Override
	protected void onInit() throws Exception {
		iEditFormModel = (IEditFormModel) this.getViewController().getCtrlModel(getPSControl().getName().toLowerCase());
		if (getPSDEForm().getPSAjaxControlHandler() != null) {
			iPSDEEditFormHandler = (IPSDEEditFormHandler) getPSDEForm().getPSAjaxControlHandler();
		}
		super.onInit();
	}

	@Override
	protected IEditFormModel getEditFormModel() {
		return iEditFormModel;
	}

	public IPSDEForm getPSDEForm() {
		return (IPSDEForm) getPSControl();
	}

	public IPSDEEditFormHandler getPSDEEditFormHandler() {
		return this.iPSDEEditFormHandler;
	}

	/**
	 * 准备部件操作数据访问能力
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareDataAccessActions() throws Exception {
		super.prepareDataAccessActions();
		if (getPSDEEditFormHandler() != null) {
			java.util.Iterator<String> ajaxActions = getPSDEEditFormHandler().getAjaxActions();
			while (ajaxActions.hasNext()) {
				// this.registerDataAccessAction("${ajaxAction}","${item.getPSAjaxControlHandler().getDataAccessAction('${ajaxAction}')}");
				this.registerDataAccessAction(ajaxActions.next(), DataAccessActions.NONE);
			}
		}
	}

	/**
	 * 准备部件成员处理对象
	 * 
	 * @throws Exception
	 */
	@Override
	protected void prepareCtrlItemHandlers() throws Exception {
		super.prepareCtrlItemHandlers();
		//
		// <#list item.getPSDEFormItems() as formitem>
		// <#if (formitem.getItemHandlerType()??) &&
		// (formitem.getItemHandlerType()?length>0)>
		// //注册 '${formitem.name}'
		// ${appview.codeName}${srfclassname('${item.name}')}${srfclassname('${formitem.name}')}Handler
		// ${srfparamname('${formitem.name}')}Handler = new
		// ${appview.codeName}${srfclassname('${item.name}')}${srfclassname('${formitem.name}')}Handler();
		// ${srfparamname('${formitem.name}')}Handler.init(this.getEditFormModel(),this);
		// this.registerCtrlItemHandler(ITEMACTIONTYPE_FORMITEM+"${formitem.codeName}",${srfparamname('${formitem.name}')}Handler);
		//
		// </#if>
		// </#list>
		//
		// <#if item.getPSDEFormItemUpdates()??>
		// <#list item.getPSDEFormItemUpdates() as fiupdate>
		// //注册表单项更新 '${fiupdate.codeName}'
		// ${appview.codeName}${srfclassname('${item.name}')}${srfclassname('${fiupdate.codeName}')}Handler
		// ${srfparamname('${fiupdate.codeName}')}Handler = new
		// ${appview.codeName}${srfclassname('${item.name}')}${srfclassname('${fiupdate.codeName}')}Handler();
		// ${srfparamname('${fiupdate.codeName}')}Handler.init(this.getEditFormModel(),this);
		// this.registerCtrlItemHandler(ITEMACTIONTYPE_FORMITEMUPDATE+"${fiupdate.codeName}",${srfparamname('${fiupdate.codeName}')}Handler);
		// </#list>
		// </#if>
	}

	// <#-- 开始非向导表单 -->
	// <#assign stdfunc="1">
	// <#if item.getFormFuncMode()=='WFACTION'>
	// <#assign stdfunc="0">
	// </#if>

	@Override
	protected IEntity getEntity(Object objKeyValue) throws Exception {
		String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("load");
		if (StringHelper.isNullOrEmpty(strDEActionName)) {
			return super.getEntity(objKeyValue);
		}
		IEntity entity = this.getDEModel().createEntity();
		entity.set(this.getDEModel().getKeyDEField().getName().toLowerCase(), objKeyValue);
		this.getService().executeAction(strDEActionName.toUpperCase(), entity);
		return entity;
	}

	@Override
	protected String getGetEntityAction() {
		String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("load");
		if (StringHelper.isNullOrEmpty(strDEActionName)) {
			return super.getGetEntityAction();
		}
		return strDEActionName.toUpperCase();
	}

	@Override
	protected IEntity updateEntity(IEntity iEntity) throws Exception {
		String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("update");
		if (StringHelper.isNullOrEmpty(strDEActionName)) {
			return super.updateEntity(iEntity);
		}
		this.getService().executeAction(strDEActionName.toUpperCase(), iEntity);
		return iEntity;
	}

	// 以下为非流程操作表单使用

	@Override
	protected IEntity getDraftEntity() throws Exception {
		String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("loaddraft");
		if (StringHelper.isNullOrEmpty(strDEActionName)) {
			return super.getDraftEntity();
		}
		IEntity entity = this.getDEModel().createEntity();
		fillDefaultValues(entity, false);
		this.getService().executeAction(strDEActionName.toUpperCase(), entity);
		return entity;
	}

	@Override
	protected IEntity getDraftEntityFrom(Object objKeyValue) throws Exception {
		String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("loaddraftfrom");
		if (StringHelper.isNullOrEmpty(strDEActionName)) {
			return super.getDraftEntityFrom(objKeyValue);
		}
		IEntity entity = this.getDEModel().createEntity();
		entity.set(this.getDEModel().getKeyDEField().getName().toLowerCase(), objKeyValue);
		this.getService().executeAction(strDEActionName.toUpperCase(), entity);
		return entity;
	}

	@Override
	protected IEntity createEntity(IEntity iEntity) throws Exception {
		String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("create");
		if (StringHelper.isNullOrEmpty(strDEActionName)) {
			return super.createEntity(iEntity);
		}
		this.getService().executeAction(strDEActionName.toUpperCase(), iEntity);
		return iEntity;
	}

	@Override
	protected void removeEntity(Object objKeyValue) throws Exception {
		String strDEActionName = this.getPSDEEditFormHandler().getDEActionName("remove");
		if (StringHelper.isNullOrEmpty(strDEActionName)) {
			super.removeEntity(objKeyValue);
			return;
		}

		IEntity entity = this.getDEModel().createEntity();
		entity.set(this.getDEModel().getKeyDEField().getName().toLowerCase(), objKeyValue);
		this.getService().executeAction(strDEActionName.toUpperCase(), entity);
	}

	@Override
	public int getTempMode() {
		if (getPSDEEditFormHandler().getTempMode() > 0)
			return getPSDEEditFormHandler().getTempMode();
		return super.getTempMode();

	}

	@Override
	protected WFActionParam createWFActionParam(IEntity entity, IEntity srcEntity) throws Exception {
		SaaSWFActionParam wfActionParam = new SaaSWFActionParam();
		String strAddStepType = DataObject.getStringValue(srcEntity, "SRFADDSTEPTYPE", "");
		if(!StringHelper.isNullOrEmpty(strAddStepType)) {
			wfActionParam.setAddStepType(strAddStepType);
			wfActionParam.setAppPersonId(DataObject.getStringValue(srcEntity, "SRFAPPPERSONID", ""));
			wfActionParam.setAppPersonName(DataObject.getStringValue(srcEntity, "SRFAPPPERSONNAME", ""));
			wfActionParam.setAppPersonList(DataObject.getStringValue(srcEntity, "SRFAPPPERSONLIST", ""));
		}
		return wfActionParam;
	}

}
