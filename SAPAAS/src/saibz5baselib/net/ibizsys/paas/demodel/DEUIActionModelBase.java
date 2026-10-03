package net.ibizsys.paas.demodel;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.DataAccessActions;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IUIAction;
import net.ibizsys.paas.view.UIActionModelBase;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.UIActionModelAjaxActionResult;

/**
 * 实体界面行为模型基类
 * 
 * @author lionlau
 *
 * @param <ET>
 */
public abstract class DEUIActionModelBase<ET extends IEntity> extends UIActionModelBase implements IDEUIActionModel<ET> {
	
	private IDataEntity iDataEntity = null;
	private boolean bReloadData = false;
	private String strDEActionName = "";
	private String strSuccessMsg = null;
	private String strDataAccessAction = null;
	private boolean bCloseEditView = false;
	private boolean bGlobalUIAction = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#init(net.ibizsys.paas.core.IDataEntity)
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

	}

	/**
	 * 初始化注解
	 * 
	 * @param c
	 * @throws Exception
	 */
	protected void initAnnotation(Class c) {
		// Annotation[] annotations = c.getAnnotations();
		// if (annotations != null){
		// for (Annotation annotation : annotations){
		// if (annotation instanceof DEUIAction){
		// setDEUIAction( (DEUIAction)annotation);
		// continue;
		// }
		// }
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEUIActionModel#getDEModel()
	 */
	@Override
	public IDataEntityModel<ET> getDEModel() {
		return (IDataEntityModel<ET>) getDataEntity();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDataEntityObject#getDataEntity()
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEUIActionModel#getDEActionName()
	 */
	@Override
	public String getDEActionName() {
		return this.strDEActionName;
	}

	/**
	 * 设置实体操作名称
	 * 
	 * @param strDEActionName
	 */
	public void setDEActionName(String strDEActionName) {
		this.strDEActionName = strDEActionName;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDEUIActionModel#execute(java.util.ArrayList, org.hibernate.SessionFactory)
	 */
	@Override
	public void execute(ArrayList<ET> entities, SessionFactory sessionFactory) throws Exception {
		onExecute(entities, sessionFactory);
	}

	/**
	 * 支持实体界面后台操作
	 * 
	 * @param entities 数据对象列表
	 * @param sessionFactory 会话工厂
	 * @throws Exception
	 */
	protected void onExecute(ArrayList<ET> entities, SessionFactory sessionFactory) throws Exception {
		if (StringHelper.compare(this.getActionTarget(), IUIAction.ACTIONTARGET_NONE, true) == 0) {
			ET et = this.getDEModel().createEntity();
			this.getDEModel().getService(sessionFactory).executeAction(getDEActionName(), et);
		} else if ((StringHelper.compare(this.getActionTarget(), IUIAction.ACTIONTARGET_SINGLEKEY, true) == 0) || (StringHelper.compare(this.getActionTarget(), ACTIONTARGET_SINGLEDATA, true) == 0) || (StringHelper.compare(this.getActionTarget(), ACTIONTARGET_MULTIKEY, true) == 0) || (StringHelper.compare(this.getActionTarget(), ACTIONTARGET_MULTIDATA, true) == 0)) {
			this.getDEModel().getService(sessionFactory).executeAction(getDEActionName(), entities);
		} else
			throw new Exception(StringHelper.format("无法识别的目标类型[%1$s]", this.getActionTarget()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#isReloadData()
	 */
	@Override
	public boolean isReloadData() {
		return this.bReloadData;
	}

	/**
	 * 设置是否重新加载数据
	 * 
	 * @param bReloadData
	 */
	public void setReloadData(boolean bReloadData) {
		this.bReloadData = bReloadData;
	}

	/**
	 * 设置标识
	 * 
	 * @param strId
	 */
	public void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName
	 */
	public void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#getSuccessMsg()
	 */
	@Override
	public String getSuccessMsg() {
		return this.strSuccessMsg;
	}

	/**
	 * 设置常规提示信息
	 * 
	 * @param strSuccessMsg the strSuccessMsg to set
	 */
	public void setSuccessMsg(String strSuccessMsg) {
		this.strSuccessMsg = strSuccessMsg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#getDataAccessAction()
	 */
	@Override
	public String getDataAccessAction() {
		if (!StringHelper.isNullOrEmpty(this.strDataAccessAction)) return this.strDataAccessAction;

		if (StringHelper.compare(this.getActionTarget(), IDEUIAction.ACTIONTARGET_NONE, true) == 0) {
			return "";
		} else {
			return DataAccessActions.UPDATE;
		}
	}

	/**
	 * 设置实体操作标识（用于权限判断）
	 * 
	 * @param strDataAccessAction
	 */
	public void setDataAccessAction(String strDataAccessAction) {
		this.strDataAccessAction = strDataAccessAction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDEUIAction#isCloseEditView()
	 */
	@Override
	public boolean isCloseEditView() {
		return bCloseEditView;
	}

	/**
	 * 设置是否关闭编辑视图
	 * 
	 * @param bCloseEditView the bCloseEditView to set
	 */
	public void setCloseEditView(boolean bCloseEditView) {
		this.bCloseEditView = bCloseEditView;
	}
	
	
	

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.view.IUIAction#isClosePopupView()
	 */
	@Override
	public boolean isClosePopupView() {
		return this.bCloseEditView;
	}

	
	/**
	 * 设置是否关闭弹出视图
	 * 
	 * @param bCloseEditView the bCloseEditView to set
	 */
	public void setClosePopupView(boolean bCloseEditView) {
		this.bCloseEditView = bCloseEditView;
	}
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.core.IDEUIAction#isGlobalUIAction()
	 */
	@Override
	public boolean isGlobalUIAction() {
		return this.bGlobalUIAction;
	}
	
	/**
	 * 设置是否为全局的界面行为
	 * @param bGlobalUIAction
	 */
	public void setGlobalUIAction(boolean bGlobalUIAction){
		this.bGlobalUIAction = bGlobalUIAction;
	}

	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.demodel.IDEUIActionModel#getRuntimeModelAjaxActionResult(org.hibernate.SessionFactory)
	 */
	@Override
	public AjaxActionResult getRuntimeModelAjaxActionResult(SessionFactory sessionFactory) throws Exception {
		if(!this.isEnableRuntimeModel()){
			throw new Exception("不支持运行时模型");
		}
		UIActionModelAjaxActionResult uiActionModelAjaxActionResult = new UIActionModelAjaxActionResult();
		onFillRuntimeModelAjaxActionResult(uiActionModelAjaxActionResult,sessionFactory);
		return uiActionModelAjaxActionResult;
	}
	
	
	/**
	 * 填充界面行为运行时模型异步请求结果
	 * @param uiActionModelAjaxActionResult
	 * @param sessionFactory
	 * @throws Exception
	 */
	protected void onFillRuntimeModelAjaxActionResult(UIActionModelAjaxActionResult uiActionModelAjaxActionResult,SessionFactory sessionFactory) throws Exception {
		
	}
	
	
}
