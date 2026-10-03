package net.ibizsys.paas.ctrlhandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IWizardPanelModel;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;

/**
 * 向导面板处理对象基类
 * 
 * @author Administrator
 *
 */
public abstract class WizardPanelHandlerBase extends CtrlHandlerBase implements IWizardPanelHandler {

	private static final Log log = LogFactory.getLog(WizardPanelHandlerBase.class);

	/**
	 * 获取当前的编辑表单模型
	 * 
	 * @return
	 */
	protected abstract IWizardPanelModel getWizardPanelModel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.ICtrlHandler#getCtrlModel()
	 */
	@Override
	public ICtrlModel getCtrlModel() {
		return getWizardPanelModel();
	}

	/**
	 * 初始化向导
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onInitAction() throws Exception {
		SDAjaxActionResult ajaxActionResult = new SDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(ajaxActionResult);
		IEntity iEntity = initWizard();

		this.fillOutputDatas(iEntity, ajaxActionResult);
		return ajaxActionResult;
	}

	/**
	 * 完成向导
	 * 
	 * @return
	 * @throws Exception
	 */
	protected AjaxActionResult onFinishAction() throws Exception {
		SDAjaxActionResult ajaxActionResult = new SDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(ajaxActionResult);

		String strKey = WebContext.getKey(this.getWebContext());
		IEntity iEntity = this.getDEModel().createEntity();
		iEntity.set(this.getDEModel().getKeyDEField().getName(), strKey);
		this.finishWizard(iEntity);

		this.fillOutputDatas(iEntity, ajaxActionResult);
		return ajaxActionResult;
	}

	/**
	 * 初始化向导
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IEntity initWizard() throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 完成向导
	 * 
	 * @param iEntity
	 * @return
	 * @throws Exception
	 */
	protected IEntity finishWizard(IEntity iEntity) throws Exception {
		throw new Exception(StringHelper.format("没有实现"));
	}

	/**
	 * 通过数据实体填充表单
	 * 
	 * @param iDataObject 数据
	 * @param ajaxActionResult 请求结果
	 * @throws Exception
	 */
	protected void fillOutputDatas(IDataObject iDataObject, SDAjaxActionResult ajaxActionResult) throws Exception {
		iDataObject.fillJSONObject(ajaxActionResult.getData(true), false);
		JSONObjectHelper.putRaw(ajaxActionResult.getData(true), "srfkey", iDataObject.get(this.getDEModel().getKeyDEField().getName()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.ibizsys.paas.ctrlhandler.CtrlHandlerBase#onProcessAction(java.lang.String)
	 */
	@Override
	protected AjaxActionResult onProcessAction(String strAction) throws Exception {
		if (StringHelper.compare(strAction, ACTION_INIT, true) == 0) {
			return onInitAction();
		}

		if (StringHelper.compare(strAction, ACTION_FINISH, true) == 0) {
			return onFinishAction();
		}

		return super.onProcessAction(strAction);

	}

}
