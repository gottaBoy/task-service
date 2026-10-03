package net.ibizsys.psportal.web.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.api.IServiceAPIClientModel;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psportal.api.PortalAPIClientModel;
import net.ibizsys.psrt.srv.PSRuntimeSysModel;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.sf.json.JSONObject;

/**
 * 用户头部功能组
 * 
 * @author Administrator
 * 
 */
public class HeadFuncServlet extends HttpServletBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(HeadFuncServlet.class);


	@Override
	protected AjaxActionResult onProcessAction() throws Exception {
		MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
		this.getWebContext().setCurAjaxActionResult(mdAjaxActionResult);

		if(StringHelper.isNullOrEmpty(this.getWebContext().getCurUserId())) {
			mdAjaxActionResult.setRetCode(Errors.INVALIDDATA);
			return mdAjaxActionResult;
		}
		
		PortalAPIClientModel portalAPIClientModel = PortalAPIClientModel.getCurrent();
		
		DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
		deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
		deDataSetFetchContextImpl.setSort("ordervalue");
		deDataSetFetchContextImpl.setSortDir("asc");
		if (deDataSetFetchContextImpl.isCancel()) {
			mdAjaxActionResult.setTotalRow(0);
			mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
			mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
			return mdAjaxActionResult;
		} else {
//			UserFuncGrpDetailService userFuncGrpDetailService = UserFuncGrpDetailService.getInstance() ;
//			DBFetchResult fetchResult = userFuncGrpDetailService.fetchDataSet(UserFuncGrpDetailService.DATASET_TOPUSERGROUP, deDataSetFetchContextImpl);
			
			DataEntity cond = new DataEntity();
			cond.set("ACUSERID", this.getWebContext().getCurUserId());
			deDataSetFetchContextImpl.setActiveDataObject(cond);
			FetchResult fetchResult = portalAPIClientModel.getTopMenu(deDataSetFetchContextImpl);
			
			mdAjaxActionResult.setTotalRow(fetchResult.getTotalRow());
			mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
			mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());

			
			
			for (IDataRow iDataRow : fetchResult.getDataRows()) {
				DataEntity entity = new DataEntity();
				DataEntity.fromDataRow(entity, iDataRow);
				JSONObject jo = new JSONObject();
				entity.fillJSONObject(jo, false);
				mdAjaxActionResult.getRows().add(jo);
			}
				
				
			return mdAjaxActionResult;
		}

	}

}
