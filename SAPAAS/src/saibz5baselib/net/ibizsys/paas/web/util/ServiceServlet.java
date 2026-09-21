/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import java.util.ArrayList;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceServlet
extends HttpServletBase {
    private static final Log log = LogFactory.getLog(ServiceServlet.class);

    @Override
    protected AjaxActionResult onProcessAction() throws Exception {
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        String strDEId = WebContext.getDEId(this.getWebContext());
        String strCall = WebContext.getRemoteCall(this.getWebContext());
        String strRemoteAddr = this.getWebContext().getRemoteAddr();
        try {
            if (StringHelper.isNullOrEmpty(strDEId)) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528[%1$s]", strCall));
            }
            IService iService = ServiceGlobal.getService(strDEId, this.getSessionFactory());
            if (StringHelper.compare(strCall, "SAVE", true) == 0 || StringHelper.compare(strCall, "GET", true) == 0 || StringHelper.compare(strCall, "CREATE", true) == 0 || StringHelper.compare(strCall, "UPDATE", true) == 0 || StringHelper.compare(strCall, "REMOVE", true) == 0 || StringHelper.compare(strCall, "GETDRAFT", true) == 0) {
                String strArg = WebContext.getRemoteCallArg(this.getWebContext());
                Object iEntity = iService.getDEModel().createEntity();
                JSONObject joArg = JSONObjectHelper.fromString(strArg);
                DataObject.fromJSONObject(iEntity, joArg);
                iService.executeAction(strCall, (IEntity)iEntity);
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
                    IDataObject iDataObject = (IDataObject)objItem;
                    ajaxActionResult.getRows().add(DataObject.toJSONString(iDataObject, false));
                }
                return ajaxActionResult;
            }
            if (StringHelper.compare(strCall, "FETCH", true) == 0) {
                String strArg = WebContext.getRemoteCallArg(this.getWebContext());
                SimpleEntity iEntity = new SimpleEntity();
                DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
                deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
                this.onFillFetchConditions(iService.getDEModel(), deDataSetFetchContextImpl.getConditionList());
                DBFetchResult fetchResult = iService.fetchDataSet(strArg, deDataSetFetchContextImpl);
                ajaxActionResult.setTotalRow(fetchResult.getTotalRow());
                ajaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
                ajaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
                IDataTable dt = fetchResult.getDataSet().getDataTable(0);
                if (dt.getCachedRowCount() == -1) {
                    IDataRow iDataRow;
                    while ((iDataRow = dt.next()) != null) {
                        SimpleEntity simpleEntity = new SimpleEntity();
                        DataObject.fromDataRow(simpleEntity, iDataRow);
                        ajaxActionResult.getRows().add(DataObject.toJSONObject(simpleEntity, false));
                    }
                } else {
                    int nRows = dt.getCachedRowCount();
                    int i = 0;
                    while (i < nRows) {
                        IDataRow iDataRow = dt.getCachedRow(i);
                        SimpleEntity simpleEntity = new SimpleEntity();
                        DataObject.fromDataRow(simpleEntity, iDataRow);
                        ajaxActionResult.getRows().add(DataObject.toJSONObject(simpleEntity, false));
                        ++i;
                    }
                }
                return ajaxActionResult;
            }
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528[%1$s]", strCall));
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u8fdc\u7a0b\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            return ajaxActionResult;
        }
    }

    /*
     * Unable to fully structure code
     */
    protected void onFillFetchConditions(IDataEntityModel iDEModel, ArrayList<IDEDataSetCond> userConditions) throws Exception {
        deFields = iDEModel.getDEFields();
        while (deFields.hasNext()) {
            defield = deFields.next();
            defSearchModes = defield.getDEFSearchModes();
            if (defSearchModes != null) ** GOTO lbl18
            continue;
lbl-1000:
            // 1 sources

            {
                iDEFSearchMode = defSearchModes.next();
                strFormItemId = iDEFSearchMode.getName();
                strValue = this.getWebContext().getPostValue(strFormItemId.toLowerCase());
                if (StringHelper.isNullOrEmpty(strValue)) continue;
                deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
                deDataSetCondImpl.setDEFName(defield.getName());
                deDataSetCondImpl.setCondValue(strValue);
                userConditions.add(deDataSetCondImpl);
lbl18:
                // 3 sources

                ** while (defSearchModes.hasNext())
            }
lbl19:
            // 1 sources

        }
    }
}

