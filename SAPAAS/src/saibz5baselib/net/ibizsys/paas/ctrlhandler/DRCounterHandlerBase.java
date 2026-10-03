package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 实体关系计数器处理对象
 * 
 * @author Administrator
 *
 */
public abstract class DRCounterHandlerBase extends CounterHandlerBase {

	/**
	 * 获取实体模型对象
	 * 
	 * @return
	 */
	protected abstract IDataEntityModel getDEModel() throws Exception;

	/**
	 * 获取服务对象
	 * 
	 * @return
	 */
	protected IService getService() throws Exception {
		return getDEModel().getService(this.getViewController().getSessionFactory());
	}

	@Override
	protected AjaxActionResult onFetch() throws Exception {

		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		String strKey = WebContext.getKey(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKey)) strKey = WebContext.getKeys(this.getWebContext());
		if (StringHelper.isNullOrEmpty(strKey) || (strKey.indexOf(ServiceBase.TEMPKEY) == 0)) {
			// 没有指定主键
			JSONObject dataObject = mdAjaxActionResult.getData(true);
			java.util.Iterator<String> counterItems = this.getCounterItems();
			while (counterItems.hasNext()) {
				dataObject.put(counterItems.next(), 0);
			}
		} else {
			IEntity iEntity = getService().getDEModel().createEntity();
			iEntity.set(getDEModel().getKeyDEField().getName(), strKey);
			getService().get(iEntity);
			JSONObject dataObject = mdAjaxActionResult.getData(true);
			java.util.Iterator<String> counterItems = this.getCounterItems();
			while (counterItems.hasNext()) {
				String strItemName = counterItems.next();
				int nCount = DataObject.getIntegerValue(iEntity, strItemName, 0);
				dataObject.put(strItemName, nCount);
			}
		}

		return mdAjaxActionResult;

	}

}
