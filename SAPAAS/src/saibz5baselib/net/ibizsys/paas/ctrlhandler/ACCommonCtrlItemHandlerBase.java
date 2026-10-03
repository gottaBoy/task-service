package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.IDEACModeModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 通用自动填充部件项处理对象
 * 
 * @author lionlau
 *
 */
public abstract class ACCommonCtrlItemHandlerBase extends CommonCtrlItemHandlerBase {
	/**
	 * 获取拾取的实体服务
	 * 
	 * @return
	 */
	protected abstract IService getPickupDEService() throws Exception;

	/**
	 * 获取拾取的实体数据集合名称
	 * 
	 * @return
	 */
	protected String getPickupDEDataSetName() {
		return "DEFAULT";
	}

	@Override
	protected AjaxActionResult onItemFetch() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();

		DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
		deDataSetFetchContextImpl.setSessionFactory(this.getViewController().getSessionFactory());

		IDEACModeModel iDEACModeModel = getPickupDEACModeModel();
		if (!StringHelper.isNullOrEmpty(iDEACModeModel.getMinorSortField())) {
			deDataSetFetchContextImpl.setSort2(iDEACModeModel.getMinorSortField());
			deDataSetFetchContextImpl.setSort2Dir(iDEACModeModel.getMinorSortDir());
		}

		fillFetchConditions(deDataSetFetchContextImpl);
		DBFetchResult fetchResult = null;
		if ((this.getCtrlHandler().getTempMode() != ICtrlHandler.TEMPMODE_NONE) && isEnableTempData())
			fetchResult = this.getPickupDEService().fetchDataSetTemp(getPickupDEDataSetName(), deDataSetFetchContextImpl);
		else
			fetchResult = this.getPickupDEService().fetchDataSet(getPickupDEDataSetName(), deDataSetFetchContextImpl);

		mdAjaxActionResult.setTotalRow(fetchResult.getTotalRow());
		fillFetchResult(mdAjaxActionResult, fetchResult.getDataSet().getDataTable(0));
		return mdAjaxActionResult;
	}

	@Override
	protected void onFillFetchConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
		super.onFillFetchConditions(userConditions);

		String strFetchCond = WebContext.getFetchCond(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strFetchCond)) {
			JSONObject jo = JSONObjectHelper.fromString(strFetchCond);
			java.util.Iterator conds = jo.keys();
			while (conds.hasNext()) {
				String strCond = (String) conds.next();
				String objValue = jo.optString(strCond, null);
				IDEFSearchMode iDEFSearchMode = this.getPickupDEService().getDEModel().getDEFSearchMode(strCond, false);

				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
				deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
				deDataSetCondImpl.setDEFName(iDEFSearchMode.getDEFName());
				deDataSetCondImpl.setCondValue(objValue);

				userConditions.add(deDataSetCondImpl);

			}
		}

		String strQuickSearch = WebContext.getFetchQuickSearch(this.getWebContext());
		if (!StringHelper.isNullOrEmpty(strQuickSearch)) {
			IDEDataSetCond iDEDataSetCond = this.getFetchQuickSearchCondition(strQuickSearch);
			if (iDEDataSetCond != null) {
				userConditions.add(iDEDataSetCond);
			}
		}
	}

	/**
	 * 填充快速搜索条件
	 * 
	 * @param groupCondImpl
	 * @param strQuickSearch
	 * @throws Exception
	 */
	protected IDEDataSetCond getFetchQuickSearchCondition(String strQuickSearch) throws Exception {
		return this.getPickupDEService().getDEModel().getFetchQuickSearchCondition(strQuickSearch);
	}

	/**
	 * 获取拾取的实体自填模式名称
	 * 
	 * @return
	 */
	protected String getPickupDEACModeName() {
		return "";
	}

	/**
	 * 获取拾取AC模式模型
	 * 
	 * @return
	 * @throws Exception
	 */
	protected IDEACModeModel getPickupDEACModeModel() throws Exception {
		IDEACModeModel iDEACModeModel = null;
		if (StringHelper.isNullOrEmpty(getPickupDEACModeName())) {
			iDEACModeModel = (IDEACModeModel) this.getPickupDEService().getDEModel().getDefaultDEACMode();
		} else {
			iDEACModeModel = (IDEACModeModel) this.getPickupDEService().getDEModel().getDEACMode(getPickupDEACModeName());
		}
		return iDEACModeModel;
	}

	/**
	 * 填充数据获取结果
	 * 
	 * @param fetchResult
	 * @param dt
	 * @throws Exception
	 */
	protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
		IDEACModeModel iDEACModeModel = getPickupDEACModeModel();
		iDEACModeModel.fillFetchResult(fetchResult, dt, this.getWebContext());
	}

}
