/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 */
package net.ibizsys.paas.ctrlhandler;

import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEFSearchMode;
import net.ibizsys.paas.ctrlhandler.GridEditItemHandlerBase;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.demodel.IDEACModeModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.MDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.sf.json.JSONObject;

public abstract class ACGridEditItemHandlerBase
extends GridEditItemHandlerBase {
    protected abstract IService getPickupDEService() throws Exception;

    protected String getPickupDEDataSetName() {
        return "DEFAULT";
    }

    @Override
    protected AjaxActionResult onItemFetch() throws Exception {
        MDAjaxActionResult mdAjaxActionResult = new MDAjaxActionResult();
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(this.getWebContext());
        deDataSetFetchContextImpl.setSessionFactory(this.getViewController().getSessionFactory());
        IDEACModeModel iDEACModeModel = this.getPickupDEACModeModel();
        if (!StringHelper.isNullOrEmpty(iDEACModeModel.getMinorSortField())) {
            deDataSetFetchContextImpl.setSort2(iDEACModeModel.getMinorSortField());
            deDataSetFetchContextImpl.setSort2Dir(iDEACModeModel.getMinorSortDir());
        }
        this.fillFetchConditions(deDataSetFetchContextImpl);
        DBFetchResult fetchResult = null;
        fetchResult = this.getCtrlHandler().getTempMode() != 0 && this.isEnableTempData() ? this.getPickupDEService().fetchDataSetTemp(this.getPickupDEDataSetName(), deDataSetFetchContextImpl) : this.getPickupDEService().fetchDataSet(this.getPickupDEDataSetName(), deDataSetFetchContextImpl);
        mdAjaxActionResult.setTotalRow(fetchResult.getTotalRow());
        this.fillFetchResult(mdAjaxActionResult, fetchResult.getDataSet().getDataTable(0));
        return mdAjaxActionResult;
    }

    @Override
    protected void onFillFetchConditions(ArrayList<IDEDataSetCond> userConditions) throws Exception {
        IDEDataSetCond iDEDataSetCond;
        String strQuickSearch;
        super.onFillFetchConditions(userConditions);
        String strFetchCond = WebContext.getFetchCond(this.getWebContext());
        if (!StringHelper.isNullOrEmpty(strFetchCond)) {
            JSONObject jo = JSONObjectHelper.fromString(strFetchCond);
            Iterator conds = jo.keys();
            while (conds.hasNext()) {
                String strCond = (String)conds.next();
                String objValue = jo.optString(strCond, null);
                IDEFSearchMode iDEFSearchMode = this.getPickupDEService().getDEModel().getDEFSearchMode(strCond, false);
                DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
                deDataSetCondImpl.setCondType("DEFIELD");
                deDataSetCondImpl.setCondOp(iDEFSearchMode.getValueOp());
                deDataSetCondImpl.setDEFName(iDEFSearchMode.getDEFName());
                deDataSetCondImpl.setCondValue(objValue);
                userConditions.add(deDataSetCondImpl);
            }
        }
        if (!StringHelper.isNullOrEmpty(strQuickSearch = WebContext.getFetchQuickSearch(this.getWebContext())) && (iDEDataSetCond = this.getFetchQuickSearchCondition(strQuickSearch)) != null) {
            userConditions.add(iDEDataSetCond);
        }
    }

    protected IDEDataSetCond getFetchQuickSearchCondition(String strQuickSearch) throws Exception {
        return this.getPickupDEService().getDEModel().getFetchQuickSearchCondition(strQuickSearch);
    }

    protected String getPickupDEACModeName() {
        return "";
    }

    protected IDEACModeModel getPickupDEACModeModel() throws Exception {
        IDEACModeModel iDEACModeModel = null;
        iDEACModeModel = StringHelper.isNullOrEmpty(this.getPickupDEACModeName()) ? (IDEACModeModel)this.getPickupDEService().getDEModel().getDefaultDEACMode() : (IDEACModeModel)this.getPickupDEService().getDEModel().getDEACMode(this.getPickupDEACModeName());
        return iDEACModeModel;
    }

    protected void fillFetchResult(MDAjaxActionResult fetchResult, IDataTable dt) throws Exception {
        IDEACModeModel iDEACModeModel = this.getPickupDEACModeModel();
        iDEACModeModel.fillFetchResult(fetchResult, dt, this.getWebContext());
    }
}

