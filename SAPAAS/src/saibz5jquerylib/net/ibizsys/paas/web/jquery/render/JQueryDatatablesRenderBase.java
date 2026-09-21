/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.ICtrlRender
 *  net.ibizsys.paas.ctrlhandler.IMDCtrlRender
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.web.jquery.render;

import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.ctrlhandler.ICtrlRender;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class JQueryDatatablesRenderBase
implements ICtrlRender,
IMDCtrlRender {
    public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext == null) {
            return;
        }
        String strSort0 = null;
        String strOrder0Column = iWebContext.getPostOrParamValue("order[0][column]");
        String strOrder0Dir = iWebContext.getPostOrParamValue("order[0][dir]");
        if (!StringHelper.isNullOrEmpty((String)strOrder0Column) && !StringHelper.isNullOrEmpty((String)strOrder0Column)) {
            strSort0 = iWebContext.getPostOrParamValue(String.format("columns[%1$s][data]", strOrder0Column));
        }
        String strSort1 = null;
        String strOrder1Column = iWebContext.getPostOrParamValue("order[1][column]");
        String strOrder1Dir = iWebContext.getPostOrParamValue("order[1][dir]");
        if (!StringHelper.isNullOrEmpty((String)strOrder1Column) && !StringHelper.isNullOrEmpty((String)strOrder1Column)) {
            strSort1 = iWebContext.getPostOrParamValue(String.format("columns[%1$s][data]", strOrder1Column));
        }
        if (!StringHelper.isNullOrEmpty((String)strSort0)) {
            deDataSetFetchContextImpl.setSort(strSort0);
            deDataSetFetchContextImpl.setSortDir(strOrder0Dir);
        }
        if (!StringHelper.isNullOrEmpty(strSort1)) {
            deDataSetFetchContextImpl.setSort2(strSort1);
            deDataSetFetchContextImpl.setSort2Dir(strOrder1Dir);
        }
        String strLimit = iWebContext.getPostOrParamValue("length");
        String strOffset = iWebContext.getPostOrParamValue("start");
        int nStartRow = 0;
        if (!StringHelper.isNullOrEmpty((String)strOffset)) {
            nStartRow = Integer.parseInt(strOffset);
        }
        int nSize = 25;
        if (!StringHelper.isNullOrEmpty((String)strLimit)) {
            nSize = Integer.parseInt(strLimit);
        }
        deDataSetFetchContextImpl.setStartRow(nStartRow);
        deDataSetFetchContextImpl.setPageSize(nSize);
    }

    public String getFetchQuickSearch() {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext == null) {
            return null;
        }
        return iWebContext.getPostOrParamValue("search");
    }

    public void filteAjaxActionResult(AjaxActionResult ajaxActionResult, JSONObject jo) {
        if (StringHelper.compare((String)ajaxActionResult.getAjaxAction(), (String)"fetch", (boolean)true) == 0) {
            MDAjaxActionResult mdAjaxActionResult = (MDAjaxActionResult)ajaxActionResult;
            jo.put("iTotalDisplayRecords", mdAjaxActionResult.getTotalRow());
            if (mdAjaxActionResult.getPageSize() > 0) {
                jo.put("iTotalRecords", mdAjaxActionResult.getPageSize());
            }
        }
    }
}

