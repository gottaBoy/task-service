/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.codelist.CodeItems
 *  net.ibizsys.paas.codelist.CodeList
 *  net.ibizsys.paas.codelist.ICodeList
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.sysmodel.CodeListGlobal
 *  net.ibizsys.paas.sysmodel.ICodeListModel
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.codelist;

import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.pscore.srv.config.demodel.PSChartTypeDEModel;
import net.ibizsys.pscore.srv.config.service.PSChartTypeService;
import net.ibizsys.pscore.srv.core.PSDynamicCodeListModelBase;
import org.hibernate.SessionFactory;

@CodeList(id="74b01bb0f5d114caa3b5a3de08dda7b8", name="\u4e91\u7cfb\u7edf\u56fe\u8868\u7c7b\u578b", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={})
public class ChartType2CodeListModel
extends PSDynamicCodeListModelBase {
    private PSChartTypeDEModel pSChartTypeDEModel;
    private PSChartTypeService pSChartTypeService;

    public ChartType2CodeListModel() {
        this.initAnnotation(ChartType2CodeListModel.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.ChartType2CodeListModel");
    }

    public PSChartTypeDEModel getPSChartTypeDEModel() {
        if (this.pSChartTypeDEModel == null) {
            try {
                this.pSChartTypeDEModel = (PSChartTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSChartTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSChartTypeDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getPSChartTypeDEModel();
    }

    public PSChartTypeService getRealService() {
        if (this.pSChartTypeService == null) {
            try {
                this.pSChartTypeService = (PSChartTypeService)ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSChartTypeService", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSChartTypeService;
    }

    protected IService getService() {
        return this.getRealService();
    }

    protected void onPrepareCodeItems() throws Exception {
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext(null);
        dEDataSetFetchContext.setSort(this.getMinorSortField());
        dEDataSetFetchContext.setSortDir(this.getMinorSortDir());
        this.fillFetchConditions(dEDataSetFetchContext);
        DBFetchResult dBFetchResult = this.getRealService().fetchDefault((IDEDataSetFetchContext)dEDataSetFetchContext);
        this.fillFetchResult(dBFetchResult.getDataSet().getDataTable(0));
    }
}

