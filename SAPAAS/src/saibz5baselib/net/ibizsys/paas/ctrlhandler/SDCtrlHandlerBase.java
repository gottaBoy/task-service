package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;

/**
 * 单数据处理对象基类
 * 
 * @author lionlau
 *
 */
public abstract class SDCtrlHandlerBase extends CtrlHandlerBase implements ISDCtrlHandler {
	private boolean bEnableItemPriv = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang .String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.isNullOrEmpty(strAction)) {
			// 某些客户端默认请求
			return new AjaxActionResult();
		}

		if (StringHelper.compare(strAction, ACTION_LOAD, true) == 0) {
			return onLoad();
		}

		if (StringHelper.compare(strAction, ACTION_CREATE, true) == 0) {
			return onCreate();
		}

		if (StringHelper.compare(strAction, ACTION_UPDATE, true) == 0) {
			return onUpdate();
		}

		if (StringHelper.compare(strAction, ACTION_REMOVE, true) == 0) {
			return onRemove();
		}

		if (StringHelper.compare(strAction, ACTION_UIACTION, true) == 0) {
			return onUIAction();
		}
		
		if (StringHelper.compare(strAction, ACTION_LOADUIACTION, true) == 0) {
			return onLoadUIAction();
		}

		return super.onProcessAction(strAction);
	}

	/**
	 * 数据加载处理
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoad() throws Exception {
		throw new Exception("没有实现");
	}

	/**
	 * 数据建立处理
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onCreate() throws Exception {
		throw new Exception("没有实现");
	}

	/**
	 * 数据更新处理
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onUpdate() throws Exception {
		throw new Exception("没有实现");
	}

	/**
	 * 数据删除处理
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onRemove() throws Exception {
		throw new Exception("没有实现");
	}

	/**
	 * 界面行为处理
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onUIAction() throws Exception {
		throw new Exception("没有实现");
	}

	
	/**
	 * 加载界面行为运行时模型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onLoadUIAction() throws Exception {
		throw new Exception("没有实现");
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ISDCtrlHandler#isEnableItemPriv()
	 */
	@Override
	public boolean isEnableItemPriv() {
		return this.bEnableItemPriv;
	}

	/**
	 * 设置是否启用列权限控制
	 * 
	 * @param bEnableItemPriv
	 */
	protected void setEnableItemPriv(boolean bEnableItemPriv) {
		this.bEnableItemPriv = bEnableItemPriv;
	}
}
