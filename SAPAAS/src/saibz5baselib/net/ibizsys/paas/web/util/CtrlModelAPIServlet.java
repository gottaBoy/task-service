/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.control.form.IFormItem;
import net.ibizsys.paas.core.DataTypes;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CtrlModelAPIServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(CtrlModelAPIServlet.class);

    @Override
    protected AjaxActionResult onProcessAction() throws Exception {
        try {
            String strLoginKey = WebContext.getLoginKey(this.getWebContext());
            if (StringHelper.isNullOrEmpty(strLoginKey)) {
                AjaxActionResult ajaxActionResult = new AjaxActionResult();
                ajaxActionResult.setRetCode(2);
                ajaxActionResult.setErrorInfo("\u6ca1\u6709\u6307\u5b9a\u767b\u5f55\u6807\u8bc6\uff0c\u8bf7\u5148\u8fdb\u884c\u767b\u5f55");
                return ajaxActionResult;
            }
            LoginLog loginLog = RemoteLoginGlobal.getLoginLog(strLoginKey);
            if (loginLog == null) {
                AjaxActionResult ajaxActionResult = new AjaxActionResult();
                ajaxActionResult.setRetCode(2);
                ajaxActionResult.setErrorInfo("\u65e0\u6548\u767b\u5f55\u6807\u8bc6\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55");
                return ajaxActionResult;
            }
            SDAjaxActionResult sdAjaxActionResult = new SDAjaxActionResult();
            String strCtrlId = WebContext.getCtrlId(this.getWebContext());
            ICtrlModel iCtrlModel = CtrlModelGlobal.getCtrlModel(strCtrlId);
            if (iCtrlModel instanceof IEditFormModel) {
                ArrayList<JSONObject> ja = new ArrayList<JSONObject>();
                IEditFormModel iEditFormModel = (IEditFormModel)iCtrlModel;
                Iterator<IFormItem> formItems = iEditFormModel.getFormItems();
                while (formItems.hasNext()) {
                    IFormItem iFormItem = formItems.next();
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name", JSONObjectHelper.stripQuotes(iFormItem.getName(), true));
                    jsonObject.put("defname", JSONObjectHelper.stripQuotes(iFormItem.getDEFName(), true));
                    jsonObject.put("allowempty", iFormItem.isAllowEmpty());
                    jsonObject.put("caption", JSONObjectHelper.stripQuotes(iFormItem.getCaption(), true));
                    jsonObject.put("enablecond", iFormItem.getEnableCond());
                    if (iFormItem.getDataItem() != null) {
                        jsonObject.put("datatype", (Object)DataTypes.toString(iFormItem.getDataItem().getDataType()));
                    }
                    ja.add(jsonObject);
                }
                JSONObject item = new JSONObject();
                item.put("items", (Object)JSONArray.fromArray((Object[])ja.toArray()));
                sdAjaxActionResult.setData(item);
                return sdAjaxActionResult;
            }
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528"));
        }
        catch (Exception ex) {
            AjaxActionResult ajaxActionResult = new AjaxActionResult();
            log.error((Object)StringHelper.format("\u8fdc\u7a0b\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
    }
}

