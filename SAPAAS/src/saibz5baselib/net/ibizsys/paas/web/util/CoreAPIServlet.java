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
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginLog;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CoreAPIServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(CoreAPIServlet.class);

    @Override
    protected AjaxActionResult onProcessAction() throws Exception {
        try {
            String strKey;
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
            MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
            String strDEId = WebContext.getDEId(this.getWebContext());
            String strCall = WebContext.getRemoteCall(this.getWebContext());
            String strRemoteAddr = this.getWebContext().getRemoteAddr();
            String strUserId = DataObject.getStringValue(loginLog, "userid", "");
            String strUserName = DataObject.getStringValue(loginLog, "username", "");
            String strCallRetIncEmpty = WebContext.getRemoteCallRetIncEmpty(this.getWebContext());
            boolean bCallRetIncEmpty = StringHelper.compare(strCallRetIncEmpty, "true", true) == 0;
            String strCallRetTimeFmt = WebContext.getRemoteCallRetTimeFmt(this.getWebContext());
            if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
                strCallRetTimeFmt = DateHelper.getTimeJavaFormat(strCallRetTimeFmt);
            }
            this.getWebContext().setSessionValue("SRFPERSONID", strUserId);
            this.getWebContext().setSessionValue("SRFUSERNAME", strUserName);
            if (StringHelper.isNullOrEmpty(strDEId)) {
                throw new Exception(StringHelper.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528[%1$s]", strCall));
            }
            IDataEntityModel iEntityModel = DEModelGlobal.getDEModel(strDEId);
            IService iService = iEntityModel.getService(this.getSessionFactory());
            if (StringHelper.compare(strCall, "SAVE", true) == 0 || StringHelper.compare(strCall, "GET", true) == 0 || StringHelper.compare(strCall, "CREATE", true) == 0 || StringHelper.compare(strCall, "UPDATE", true) == 0 || StringHelper.compare(strCall, "REMOVE", true) == 0 || StringHelper.compare(strCall, "GETDRAFT", true) == 0) {
                String strKey2;
                String strArg = WebContext.getRemoteCallArg(this.getWebContext());
                Object iEntity = iService.getDEModel().createEntity();
                if (!StringHelper.isNullOrEmpty(strArg)) {
                    JSONObject joArg = JSONObjectHelper.fromString(strArg);
                    DataObject.fromJSONObject(iEntity, joArg);
                }
                if (!StringHelper.isNullOrEmpty(strKey2 = WebContext.getKey(this.getWebContext()))) {
                    iEntity.set(iEntityModel.getKeyDEField().getName(), strKey2);
                }
                iService.executeAction(strCall, (IEntity)iEntity);
                JSONObject itemJsonObject = DataObject.toJSONObject(iEntity, bCallRetIncEmpty);
                if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
                    itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
                }
                ajaxActionResult.getRows().add(itemJsonObject);
                ajaxActionResult.setTotalRow(1);
                return ajaxActionResult;
            }
            if (StringHelper.compare(strCall, "SELECT", true) == 0) {
                SelectCond selectCond = new SelectCond();
                String strArg = WebContext.getRemoteCallArg(this.getWebContext());
                if (!StringHelper.isNullOrEmpty(strArg)) {
                    JSONObject joArg = JSONObjectHelper.fromString(strArg);
                    DataObject.fromJSONObject(selectCond, joArg);
                }
                ArrayList list = iService.select(selectCond);
                for (Object objItem : list) {
                    IDataObject iDataObject = (IDataObject)objItem;
                    JSONObject itemJsonObject = DataObject.toJSONObject(iDataObject, bCallRetIncEmpty);
                    if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
                        itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
                    }
                    ajaxActionResult.getRows().add(itemJsonObject);
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
                        JSONObject itemJsonObject = DataObject.toJSONObject(simpleEntity, bCallRetIncEmpty);
                        if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
                            itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
                        }
                        ajaxActionResult.getRows().add(itemJsonObject);
                    }
                } else {
                    int nRows = dt.getCachedRowCount();
                    int i = 0;
                    while (i < nRows) {
                        IDataRow iDataRow = dt.getCachedRow(i);
                        SimpleEntity simpleEntity = new SimpleEntity();
                        DataObject.fromDataRow(simpleEntity, iDataRow);
                        JSONObject itemJsonObject = DataObject.toJSONObject(simpleEntity, bCallRetIncEmpty);
                        if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
                            itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
                        }
                        ajaxActionResult.getRows().add(itemJsonObject);
                        ++i;
                    }
                }
                return ajaxActionResult;
            }
            String strArg = WebContext.getRemoteCallArg(this.getWebContext());
            Object iEntity = iService.getDEModel().createEntity();
            if (!StringHelper.isNullOrEmpty(strArg)) {
                JSONObject joArg = JSONObjectHelper.fromString(strArg);
                DataObject.fromJSONObject(iEntity, joArg);
            }
            if (!StringHelper.isNullOrEmpty(strKey = WebContext.getKey(this.getWebContext()))) {
                iEntity.set(iEntityModel.getKeyDEField().getName(), strKey);
            }
            iService.executeAction(strCall, (IEntity)iEntity);
            JSONObject itemJsonObject = DataObject.toJSONObject(iEntity, bCallRetIncEmpty);
            if (!StringHelper.isNullOrEmpty(strCallRetTimeFmt)) {
                itemJsonObject = DataObject.convertJSONValueTimeFmt(itemJsonObject, strCallRetTimeFmt);
            }
            ajaxActionResult.getRows().add(itemJsonObject);
            ajaxActionResult.setTotalRow(1);
            return ajaxActionResult;
        }
        catch (Exception ex) {
            AjaxActionResult ajaxActionResult = new AjaxActionResult();
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

