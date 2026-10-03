package net.ibizsys.paas.web.util;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.DataTypes;
import net.ibizsys.paas.core.Errors;
import net.ibizsys.paas.ctrlmodel.CtrlModelGlobal;
import net.ibizsys.paas.ctrlmodel.ICtrlModel;
import net.ibizsys.paas.ctrlmodel.IEditFormModel;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginLog;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 控件模型 API Servlet
 * 
 * @author Administrator
 * 
 */
public class CtrlModelAPIServlet extends HttpServletBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(CtrlModelAPIServlet.class);

	@Override
	protected AjaxActionResult onProcessAction() throws Exception {

		try {
			String strLoginKey = WebContext.getLoginKey(this.getWebContext());
			if (StringHelper.isNullOrEmpty(strLoginKey)) {
				AjaxActionResult ajaxActionResult = new AjaxActionResult();
				ajaxActionResult.setRetCode(Errors.ACCESSDENY);
				ajaxActionResult.setErrorInfo("没有指定登录标识，请先进行登录");
				return ajaxActionResult;
			}

			LoginLog loginLog = RemoteLoginGlobal.getLoginLog(strLoginKey);
			if (loginLog == null) {
				AjaxActionResult ajaxActionResult = new AjaxActionResult();
				ajaxActionResult.setRetCode(Errors.ACCESSDENY);
				ajaxActionResult.setErrorInfo("无效登录标识，请重新登录");
				return ajaxActionResult;
			}

			SDAjaxActionResult sdAjaxActionResult = new SDAjaxActionResult();
			// srfctrlid
			String strCtrlId = WebContext.getCtrlId(this.getWebContext());
			ICtrlModel iCtrlModel = CtrlModelGlobal.getCtrlModel(strCtrlId);
			if (iCtrlModel instanceof IEditFormModel) {
				// 编辑表单模型
				ArrayList ja = new ArrayList();
				IEditFormModel iEditFormModel = (IEditFormModel) iCtrlModel;
				java.util.Iterator<IFormItem> formItems = iEditFormModel.getFormItems();
				while (formItems.hasNext()) {
					IFormItem iFormItem = formItems.next();
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("name", JSONObjectHelper.stripQuotes(iFormItem.getName(),true));
					jsonObject.put("defname", JSONObjectHelper.stripQuotes(iFormItem.getDEFName(),true));
					jsonObject.put("allowempty", iFormItem.isAllowEmpty());
					jsonObject.put("caption", JSONObjectHelper.stripQuotes(iFormItem.getCaption(),true));
					jsonObject.put("enablecond", iFormItem.getEnableCond());
					if (iFormItem.getDataItem() != null) {
						jsonObject.put("datatype", DataTypes.toString(iFormItem.getDataItem().getDataType()));
					}

					ja.add(jsonObject);
				}

				JSONObject item = new JSONObject();
				item.put("items", JSONArray.fromArray(ja.toArray()));
				sdAjaxActionResult.setData(item);
				return sdAjaxActionResult;
			}

			throw new Exception(StringHelper.format("无法识别的远程调用"));
		} catch (Exception ex) {
			AjaxActionResult ajaxActionResult = new AjaxActionResult();
			log.error(StringHelper.format("远程请求发生异常，%1$s", ex.getMessage()), ex);
			ajaxActionResult.setRetCode(Errors.INTERNALERROR);
			ajaxActionResult.setErrorInfo(ex.getMessage());
			return ajaxActionResult;
		}
	}

}
