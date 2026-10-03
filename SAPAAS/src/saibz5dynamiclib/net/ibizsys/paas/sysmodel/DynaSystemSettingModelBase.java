package net.ibizsys.paas.sysmodel;

import java.util.HashMap;

import net.ibizsys.paas.controller.IDynaViewController;
import net.ibizsys.paas.controller.IDynaViewControllerInst;
import net.ibizsys.paas.core.ModelBaseImpl;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.view.IDynaViewSettingModel;

import org.hibernate.SessionFactory;

/**
 * 动态系统设置模型对象基类
 * @author Administrator
 *
 */
public abstract class DynaSystemSettingModelBase extends ModelBaseImpl implements IDynaSystemSettingModel {

	private String strDynaInstId = null;
	private SessionFactory sessionFactory = null;
	private ISystemModel iSystemModel = null;
	private HashMap<String, IDynaInst> dynaInstMap = new HashMap<String, IDynaInst>();
	
	@Override
	public void init(ISystemModel iSystemModel) throws Exception {
		this.iSystemModel = iSystemModel;
		this.onInit();
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.IDynaSystemSettingModel#getSystemModel()
	 */
	@Override
	public ISystemModel getSystemModel() {
		return this.iSystemModel;
	}




	@Override
	public String getDynaInstId() {
		return this.strDynaInstId;
	}
	
	/**
	 * 设置动态实例标识
	 * @param strDynaInstId
	 */
	protected void setDynaInstId(String strDynaInstId){
		this.strDynaInstId = strDynaInstId;
	}



	@Override
	public IDynaViewControllerInst createDynaViewControllerInst(IDynaViewController iDynaViewController, String strDynaViewInstId) throws Exception {
		return getDynaViewSettingModel().createDynaViewControllerInst(iDynaViewController, strDynaViewInstId);
	}
	
	
	
	/**
	 * 获取动态系统存储对象
	 * @return
	 * @throws Exception
	 */
	protected abstract IDynaSystemStorage getDynaSystemStorage()throws Exception;
	
	

	@Override
	public void syncAll() throws Exception {
		getDynaSystemStorage().syncAll();
	}

	@Override
	public void syncAllViews() throws Exception {
		getDynaSystemStorage().syncAllViews();
	}

	@Override
	public void syncAllWorkflows() throws Exception {
		getDynaSystemStorage().syncAllWorkflows();
	}

	@Override
	public void syncView(String strViewId) throws Exception {
		getDynaSystemStorage().syncView(strViewId);
	}

	@Override
	public void syncWorkflow(String strWorkflowId) throws Exception {
		getDynaSystemStorage().syncWorkflow(strWorkflowId);
	}
	
	
	/**
	 * 获取动态视图设置模型对象
	 * @return
	 */
	public IDynaViewSettingModel getDynaViewSettingModel(){
		return (IDynaViewSettingModel)this.getDynaViewSetting();
	}

	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.IDynaSystemSetting#getSessionFactory()
	 */
	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	/**
	 * 设置数据库会话工厂
	 * @param sessionFactory
	 */
	protected void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	@Override
	public void installAll() throws Exception {
		getDynaSystemStorage().installAll();
	}




	/* (non-Javadoc)
	 * @see net.ibizsys.paas.sysmodel.IDynaSystemSettingModel#getDynaInst(java.lang.String, boolean)
	 */
	@Override
	public IDynaInst getDynaInst(String strDynaSystemId, boolean bTryMode) throws Exception {
		IDynaInst iDynaInst = this.dynaInstMap.get(strDynaSystemId);
		if(iDynaInst == null && !bTryMode){
			throw new Exception(StringHelper.format("无法获取指定动态系统实例对象, 标识为[%1$s]",strDynaSystemId));
		}
		return iDynaInst;
	}

	/**
	 * 注册动态系统实例对象
	 * @param iDynaInst
	 */
	protected void registerDynaInst(IDynaInst iDynaInst){
		this.dynaInstMap.put(iDynaInst.getId(), iDynaInst);
	}
	

}
