/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.api.FetchResult
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.HttpServletBase
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.psrt.srv.demodel.entity.DataEntity
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psportal.web.util;

import net.ibizsys.paas.api.FetchResult;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.psportal.api.PortalAPIClientModel;
import net.ibizsys.psrt.srv.demodel.entity.DataEntity;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeadFuncServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(HeadFuncServlet.class);

    protected AjaxActionResult onProcessAction() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        this.getWebContext().setCurAjaxActionResult((AjaxActionResult)mdAjaxActionResult);
        if (StringHelper.isNullOrEmpty((String)this.getWebContext().getCurUserId())) {
            mdAjaxActionResult.setRetCode(3);
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
        }
        DataEntity cond = new DataEntity();
        cond.set("ACUSERID", (Object)this.getWebContext().getCurUserId());
        deDataSetFetchContextImpl.setActiveDataObject((ISimpleDataObject)cond);
        FetchResult fetchResult = portalAPIClientModel.getTopMenu((IDEDataSetFetchContext)deDataSetFetchContextImpl);
        mdAjaxActionResult.setTotalRow(fetchResult.getTotalRow());
        mdAjaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
        mdAjaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
        for (IDataRow iDataRow : fetchResult.getDataRows()) {
            DataEntity entity = new DataEntity();
            DataEntity.fromDataRow((IDataObject)entity, (IDataRow)iDataRow);
            JSONObject jo = new JSONObject();
            entity.fillJSONObject(jo, false);
            mdAjaxActionResult.getRows().add(jo);
        }
        return mdAjaxActionResult;
    }
}

