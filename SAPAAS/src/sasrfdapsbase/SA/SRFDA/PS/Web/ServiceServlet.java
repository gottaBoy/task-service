/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetCond
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEFSearchMode
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.AjaxActionResult
 *  net.ibizsys.paas.web.HttpServletBase
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.MDAjaxActionResult
 *  net.ibizsys.paas.web.WebContext
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Web;

import java.util.ArrayList;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceServlet
extends HttpServletBase {
    private static final Log log = LogFactory.getLog(ServiceServlet.class);

    protected AjaxActionResult onProcessAction() throws Exception {
        MDAjaxActionResult ajaxActionResult = new MDAjaxActionResult();
        String strDEId = WebContext.getDEId((IWebContext)this.getWebContext());
        String strCall = WebContext.getRemoteCall((IWebContext)this.getWebContext());
        String strRemoteAddr = this.getWebContext().getRemoteAddr();
        try {
            if (StringHelper.isNullOrEmpty((String)strDEId)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528[%1$s]", (Object)strCall));
            }
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)strDEId);
            IService iService = iDataEntityModel.getService(this.getSessionFactory());
            if (StringHelper.compare((String)strCall, (String)"SAVE", (boolean)true) == 0 || StringHelper.compare((String)strCall, (String)"GET", (boolean)true) == 0 || StringHelper.compare((String)strCall, (String)"CREATE", (boolean)true) == 0 || StringHelper.compare((String)strCall, (String)"UPDATE", (boolean)true) == 0 || StringHelper.compare((String)strCall, (String)"REMOVE", (boolean)true) == 0 || StringHelper.compare((String)strCall, (String)"GETDRAFT", (boolean)true) == 0) {
                String strArg = WebContext.getRemoteCallArg((IWebContext)this.getWebContext());
                IEntity iEntity = iService.getDEModel().createEntity();
                JSONObject joArg = JSONObjectHelper.fromString((String)strArg);
                DataObject.fromJSONObject((IDataObject)iEntity, (JSONObject)joArg);
                iService.executeAction(strCall, iEntity);
                ajaxActionResult.getRows().add(DataObject.toJSONString((IDataObject)iEntity, (boolean)false));
                return ajaxActionResult;
            }
            if (StringHelper.compare((String)strCall, (String)"SELECT", (boolean)true) == 0) {
                SelectCond selectCond = new SelectCond();
                String strArg = WebContext.getRemoteCallArg((IWebContext)this.getWebContext());
                JSONObject joArg = JSONObjectHelper.fromString((String)strArg);
                DataObject.fromJSONObject((IDataObject)selectCond, (JSONObject)joArg);
                ArrayList list = iService.select((ISelectCond)selectCond);
                for (Object objItem : list) {
                    IDataObject iDataObject = (IDataObject)objItem;
                    ajaxActionResult.getRows().add(DataObject.toJSONString((IDataObject)iDataObject, (boolean)false));
                }
                return ajaxActionResult;
            }
            if (StringHelper.compare((String)strCall, (String)"FETCH", (boolean)true) == 0) {
                String strArg = WebContext.getRemoteCallArg((IWebContext)this.getWebContext());
                SimpleEntity iEntity = new SimpleEntity();
                DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
                deDataSetFetchContextImpl.setSessionFactory(this.getSessionFactory());
                this.onFillFetchConditions(iService.getDEModel(), deDataSetFetchContextImpl.getConditionList());
                DBFetchResult fetchResult = iService.fetchDataSet(strArg, (IDEDataSetFetchContext)deDataSetFetchContextImpl);
                ajaxActionResult.setTotalRow(fetchResult.getTotalRow());
                ajaxActionResult.setStartRow(deDataSetFetchContextImpl.getStartRow());
                ajaxActionResult.setPageSize(deDataSetFetchContextImpl.getPageSize());
                IDataTable dt = fetchResult.getDataSet().getDataTable(0);
                if (dt.getCachedRowCount() == -1) {
                    IDataRow iDataRow;
                    while ((iDataRow = dt.next()) != null) {
                        SimpleEntity simpleEntity = new SimpleEntity();
                        DataObject.fromDataRow((IDataObject)simpleEntity, (IDataRow)iDataRow);
                        ajaxActionResult.getRows().add(DataObject.toJSONObject((IDataObject)simpleEntity, (boolean)false));
                    }
                } else {
                    int nRows = dt.getCachedRowCount();
                    int i = 0;
                    while (i < nRows) {
                        IDataRow iDataRow = dt.getCachedRow(i);
                        SimpleEntity simpleEntity = new SimpleEntity();
                        DataObject.fromDataRow((IDataObject)simpleEntity, (IDataRow)iDataRow);
                        ajaxActionResult.getRows().add(DataObject.toJSONObject((IDataObject)simpleEntity, (boolean)false));
                        ++i;
                    }
                }
                return ajaxActionResult;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8fdc\u7a0b\u8c03\u7528[%1$s]", (Object)strCall));
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u8fdc\u7a0b\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
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
            defield = (IDEField)deFields.next();
            defSearchModes = defield.getDEFSearchModes();
            if (defSearchModes != null) ** GOTO lbl18
            continue;
lbl-1000:
            // 1 sources

            {
                iDEFSearchMode = (IDEFSearchMode)defSearchModes.next();
                strFormItemId = iDEFSearchMode.getName();
                strValue = this.getWebContext().getPostValue(strFormItemId.toLowerCase());
                if (StringHelper.isNullOrEmpty((String)strValue)) continue;
                deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
                deDataSetCondImpl.setDEFName(defield.getName());
                deDataSetCondImpl.setCondValue(strValue);
                userConditions.add((IDEDataSetCond)deDataSetCondImpl);
lbl18:
                // 3 sources

                ** while (defSearchModes.hasNext())
            }
lbl19:
            // 1 sources

        }
    }
}

