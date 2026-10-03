package net.ibizsys.paas.demodel;

import net.ibizsys.paas.core.IActionContext;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.ModelBase3Impl;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.logic.ICondition;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;

/**
 * 实体逻辑模型基类
 * 
 * @author Administrator
 *
 * @param <ET>
 */
public abstract class DELogicModelBase<ET extends IEntity> extends ModelBase3Impl implements IDELogicModel<ET> {
	
	private String strDefaultParamName = null;

	private IDataEntity iDataEntity = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDELogic#init(net.ibizsys.paas.core.IDataEntity)
	 */
	public void init(IDataEntity iDataEntity) throws Exception {
		this.setDataEntity(iDataEntity);
		this.onInit();
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
	 * 初始化注解
	 * 
	 * @param c
	 * @throws Exception
	 */
	protected void initAnnotation(Class c) {
		// Annotation[] annotations = c.getAnnotations();
		// if (annotations != null){
		// for (Annotation annotation : annotations){
		// if (annotation instanceof DELogic){
		// setDELogic( (DELogic)annotation);
		// continue;
		// }
		// }
		// }
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
	 * 获取当前实体服务对象
	 * 
	 * @param iActionContext
	 * @return
	 * @throws Exception
	 */
	protected IService<ET> getService(IActionContext iActionContext) throws Exception {
		return ((IDataEntityModel) this.getDataEntity()).getService(iActionContext.getSessionFactory());
	}

	/**
	 * 获取当前实体DAO对象
	 * 
	 * @param iActionContext
	 * @return
	 * @throws Exception
	 */
	protected IDAO<ET> getDAO(IActionContext iActionContext) throws Exception {
		return this.getService(iActionContext).getDAO();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.demodel.IDELogicModel#execute(net.ibizsys.paas.core.IDELogicActionContext)
	 */
	@Override
	public void execute(IActionContext iActionContext) throws Exception {
		onExecute(iActionContext);
	}

	/**
	 * 执行操作
	 * 
	 * @param iActionContext
	 * @throws Exception
	 */
	protected abstract void onExecute(IActionContext iActionContext) throws Exception;

	/**
	 * 测试条件是否成立
	 * 
	 * @param objSrcValue
	 * @param strOP
	 * @param strDstValue
	 * @return
	 * @throws Exception
	 */
	public static boolean testCond(Object objSrcValue, String strOP, Object strDstValue) throws Exception {
		if (StringHelper.compare(strOP, ICondition.CONDOP_ISNULL, true) == 0) {
			return objSrcValue == null;
		}

		if (StringHelper.compare(strOP, ICondition.CONDOP_ISNOTNULL, true) == 0) {
			return objSrcValue != null;
		}

		long nRet = DataTypeHelper.compare(DataTypeHelper.getObjectDataType(objSrcValue), objSrcValue, strDstValue);
		if (StringHelper.compare(strOP, ICondition.CONDOP_EQ, true) == 0) {
			return nRet == 0;
		}

		if (StringHelper.compare(strOP, ICondition.CONDOP_NOTEQ, true) == 0) {
			return nRet != 0;
		}

		if (StringHelper.compare(strOP, ICondition.CONDOP_GT, true) == 0) {
			return nRet > 0;
		}

		if (StringHelper.compare(strOP, ICondition.CONDOP_GTANDEQ, true) == 0) {
			return nRet >= 0;
		}

		if (StringHelper.compare(strOP, ICondition.CONDOP_LT, true) == 0) {
			return nRet < 0;
		}

		if (StringHelper.compare(strOP, ICondition.CONDOP_LTANDEQ, true) == 0) {
			return nRet <= 0;
		}

		throw new Exception(StringHelper.format("无法识别的表达式[%1$s]", strOP));
	}

	/**
	 * 设置标识
	 * 
	 * @param strId the strId to set
	 */
	protected void setId(String strId) {
		this.strId = strId;
	}

	/**
	 * 设置名称
	 * 
	 * @param strName the strName to set
	 */
	protected void setName(String strName) {
		this.strName = strName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.core.IDELogic#getDefaultParamName()
	 */
	@Override
	public String getDefaultParamName() {
		return this.strDefaultParamName;
	}

	/**
	 * 设置默认参数名称
	 * 
	 * @param strDefaultParamName
	 */
	protected void setDefaultParamName(String strDefaultParamName) {
		this.strDefaultParamName = strDefaultParamName;
	}

	
	/**
	 * 获取上下文环境变量
	 * @return
	 * @throws Exception
	 */
	protected IEntity getEnvEntity()throws Exception{
		if(ActionSessionManager.getCurrentSession()==null){
			throw new Exception("当前没有操作会话");
		}
		return ActionSessionManager.getCurrentSession().getEnvEntity(true);
	}
}
