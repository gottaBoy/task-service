package net.ibizsys.paas.web.util;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

/**
 * 远程服务 Servlet
 * 
 * @author Administrator
 * 
 */
public class ServiceServlet extends HttpServletBase {
	private static final Log log = LogFactory.getLog(ServiceServlet.class);

	@Override
	protected AjaxActionResult onProcessAction() throws Exception {
		MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();

		String strDEId = WebContext.getDEId(this.getWebContext());
		String strCall = WebContext.getRemoteCall(this.getWebContext());
		String strRemoteAddr = this.getWebContext().getRemoteAddr();

		try {

			if (StringHelper.isNullOrEmpty(strDEId)) {
				// if (StringHelper.compare(strCall, "GETSV", false) == 0)
				// {
				// String strArg = this.getWebContext().GetPostValue("srfarg");
				// BaseDataEntity dataEntity = BaseDataEntity.FromJSONString(strArg);
				//
				// Hashtable totalParamList = dataEntity.getTotalParamList();
				// for (Object objKey : totalParamList.keySet())
				// {
				// Object objValue = this.getWebContext().GetSessionValue(objKey.toString());
				// dataEntity.SetParamValue(objKey.toString(), objValue);
				// }
				// ajaxActionResult.getItems().add(BaseDataEntity.ToString(dataEntity, true));
				// return ajaxActionResult;
				// }
				//
				// if (StringHelper.compare(strCall, "GETGV", false) == 0)
				// {
				// String strArg = this.getWebContext().GetPostValue("srfarg");
				// BaseDataEntity dataEntity = BaseDataEntity.FromJSONString(strArg);
				//
				// Hashtable totalParamList = dataEntity.getTotalParamList();
				// for (Object objKey : totalParamList.keySet())
				// {
				// Object objValue = this.getWebContext().GetGlobalValue(objKey.toString());
				// dataEntity.SetParamValue(objKey.toString(), objValue);
				// }
				// ajaxActionResult.getItems().add(BaseDataEntity.ToString(dataEntity, true));
				// return ajaxActionResult;
				// }
				throw new Exception(StringHelper.format("无法识别的远程调用[%1$s]", strCall));
			} else {
				IService iService = ServiceGlobal.getService(strDEId, this.getSessionFactory());
				if ((StringHelper.compare(strCall, IService.ACTION_SAVE, true) == 0) || (StringHelper.compare(strCall, IService.ACTION_GET, true) == 0) || (StringHelper.compare(strCall, IService.ACTION_CREATE, true) == 0) || (StringHelper.compare(strCall, IService.ACTION_UPDATE, true) == 0) || (StringHelper.compare(strCall, IService.ACTION_REMOVE, true) == 0) || (StringHelper.compare(strCall, IService.ACTION_GETDRAFT, true) == 0))

				{
					String strArg = WebContext.getRemoteCallArg(this.getWebContext());
					IEntity iEntity = iService.getDEModel().createEntity();
					JSONObject joArg = JSONObjectHelper.fromString(strArg);
					DataObject.fromJSONObject(iEntity, joArg);
					iService.executeAction(strCall, iEntity);
					ajaxActionResult.getRows().add(DataObject.toJSONString(iEntity, false));
					return ajaxActionResult;
				}

				if (StringHelper.compare(strCall, "SELECT", true) == 0) {
					SelectCond selectCond = new SelectCond();
					String strArg = WebContext.getRemoteCallArg(this.getWebContext());
					JSONObject joArg = JSONObjectHelper.fromString(strArg);
					DataObject.fromJSONObject(selectCond, joArg);

					ArrayList list = iService.select(selectCond);
					for (Object objItem : list) {
						IDataObject iDataObject = (IDataObject) objItem;
						ajaxActionResult.getRows().add(DataObject.toJSONString(iDataObject, false));
					}
					return ajaxActionResult;
				}

				if (StringHelper.compare(strCall, "FETCH", true) == 0) {
					String strArg = WebContext.getRemoteCallArg(this.getWebContext());
					IEntity iEntity = new SimpleEntity();

					DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
					deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());

					onFillFetchConditions(iService.getDEModel(), deDataSetFetchContextImpl.getConditionList());

					DBFetchResult fetchResult = iService.fetchDataSet(strArg, deDataSetFetchContextImpl);
					ajaxActionResult.setTotalRow(fetchResult.getTotalRow());
					ajaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
					ajaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());

					IDataTable dt = fetchResult.getDataSet().getDataTable(0);
					if (dt.getCachedRowCount() == -1) {
						while (true) {
							IDataRow iDataRow = dt.next();
							if (iDataRow == null) break;
							SimpleEntity simpleEntity = new SimpleEntity();
							DataObject.fromDataRow(simpleEntity, iDataRow);
							ajaxActionResult.getRows().add(DataObject.toJSONObject(simpleEntity, false));
						}
					} else {
						int nRows = dt.getCachedRowCount();
						for (int i = 0; i < nRows; i++) {
							IDataRow iDataRow = dt.getCachedRow(i);
							SimpleEntity simpleEntity = new SimpleEntity();
							DataObject.fromDataRow(simpleEntity, iDataRow);
							ajaxActionResult.getRows().add(DataObject.toJSONObject(simpleEntity, false));
						}
					}
					return ajaxActionResult;
				}
			}

			throw new Exception(StringHelper.format("无法识别的远程调用[%1$s]", strCall));
		} catch (Exception ex) {
			log.error(StringHelper.format("远程请求发生异常，%1$s", ex.getMessage()), ex);
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		}

	}

	protected void onFillFetchConditions(IDataEntityModel iDEModel, ArrayList<IDEDataSetCond> userConditions) throws Exception {
		java.util.Iterator<IDEField> deFields = iDEModel.getDEFields();
		while (deFields.hasNext()) {
			IDEField defield = deFields.next();
			java.util.Iterator<IDEFSearchMode> defSearchModes = defield.getDEFSearchModes();
			if (defSearchModes == null) continue;

			while (defSearchModes.hasNext()) {
				IDEFSearchMode iDEFSearchMode = defSearchModes.next();

				String strFormItemId = iDEFSearchMode.getName();
				String strValue = getWebContext().getPostValue(strFormItemId.toLowerCase());
				if (StringHelper.isNullOrEmpty(strValue)) continue;

				DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
				deDataSetCondImpl.setCondType(IDEDataSetCond.CONDTYPE_DEFIELD);
				deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
				deDataSetCondImpl.setDEFName(defield.getName());
				deDataSetCondImpl.setCondValue(strValue);

				userConditions.add(deDataSetCondImpl);

			}

		}

	}
}
