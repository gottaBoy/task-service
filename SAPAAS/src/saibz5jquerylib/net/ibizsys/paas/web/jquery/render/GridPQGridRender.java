/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.ctrlhandler.ICtrlRender
 *  net.ibizsys.paas.ctrlhandler.IGridRender
 *  net.ibizsys.paas.ctrlhandler.IMDCtrlRender
 *  net.ibizsys.paas.ctrlmodel.IGridModel
 *  net.ibizsys.paas.db.IDataTable
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
import net.ibizsys.paas.ctrlhandler.IGridRender;
import net.ibizsys.paas.ctrlhandler.IMDCtrlRender;
import net.ibizsys.paas.ctrlmodel.IGridModel;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public class GridPQGridRender
implements ICtrlRender,
IMDCtrlRender,
IGridRender {
    public void fillDEDataSetFetchContext(DEDataSetFetchContext deDataSetFetchContextImpl) throws Exception {
        IWebContext iWebContext = WebContext.getCurrent();
        if (iWebContext == null) {
            return;
        }
        String strOrder0Column = iWebContext.getPostOrParamValue("pqorder[0][column]");
        String strOrder0Dir = iWebContext.getPostOrParamValue("pqorder[0][direction]");
        if (!StringHelper.isNullOrEmpty((String)strOrder0Column) && !StringHelper.isNullOrEmpty((String)strOrder0Dir)) {
            deDataSetFetchContextImpl.setSort(strOrder0Column);
            deDataSetFetchContextImpl.setSortDir(strOrder0Dir);
        }
        String strOrder1Column = iWebContext.getPostOrParamValue("pqorder[1][column]");
        String strOrder1Dir = iWebContext.getPostOrParamValue("pqorder[1][direction]");
        if (!StringHelper.isNullOrEmpty((String)strOrder1Column) && !StringHelper.isNullOrEmpty((String)strOrder1Dir)) {
            deDataSetFetchContextImpl.setSort2(strOrder1Column);
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
            jo.put("totalRecords", mdAjaxActionResult.getTotalRow());
            if (mdAjaxActionResult.getPageSize() > 0) {
                jo.put("iTotalRecords", mdAjaxActionResult.getPageSize());
            }
            int nPageSize = mdAjaxActionResult.getPageSize();
            int nStartRow = mdAjaxActionResult.getStartRow();
            int curPage = nStartRow / nPageSize + 1;
            jo.put("curPage", curPage);
        }
    }

    public void fillFetchResult(IGridModel iGridModel, MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        iGridModel.fillFetchResult(fetchResult, dt);
    }
}

