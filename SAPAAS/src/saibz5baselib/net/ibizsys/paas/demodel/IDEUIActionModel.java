package net.ibizsys.paas.demodel;

import java.util.ArrayList;

import org.hibernate.SessionFactory;

import net.ibizsys.paas.core.IDEUIAction;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.view.IUIActionModel;
import net.ibizsys.paas.web.AjaxActionResult;

/**
 * 实体界面行为接口
 * 
 * @author lionlau
 *
 */
public interface IDEUIActionModel<ET extends IEntity> extends IDEUIAction,IUIActionModel {
	/**
	 * 执行操作
	 * 
	 * @param iDELogicActionContext
	 * @throws Exception
	 */
	void execute(ArrayList<ET> entities, SessionFactory sessionFactory) throws Exception;

	/**
	 * 获取实体操作名称
	 * 
	 * @return
	 */
	String getDEActionName();

	/**
	 * 获取实体模型
	 * 
	 * @return
	 */
	IDataEntityModel<ET> getDEModel();
	
	
	
	/**
	 * 获取运行时的异步请求结果
	 * @return
	 */
	AjaxActionResult getRuntimeModelAjaxActionResult(SessionFactory sessionFactory)throws Exception;

}
