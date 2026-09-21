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
import net.ibizsys.pscore.srv.config.demodel.PSCounterTypeDEModel;
import net.ibizsys.pscore.srv.config.service.PSCounterTypeService;
import net.ibizsys.pscore.srv.core.PSDynamicCodeListModelBase;
import org.hibernate.SessionFactory;

@CodeList(id="79a443cb70b7dcd0d5ee103e2fadd9be", name="\u4e91\u5e73\u53f0\u8ba1\u6570\u5668\u7c7b\u578b", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={})
public class CounterTypeCodeListModel
extends PSDynamicCodeListModelBase {
    private PSCounterTypeDEModel pSCounterTypeDEModel;
    private PSCounterTypeService pSCounterTypeService;

    public CounterTypeCodeListModel() {
        this.initAnnotation(CounterTypeCodeListModel.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.CounterTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.CounterTypeCodeListModel");
    }

    public PSCounterTypeDEModel getPSCounterTypeDEModel() {
        if (this.pSCounterTypeDEModel == null) {
            try {
                this.pSCounterTypeDEModel = (PSCounterTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSCounterTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCounterTypeDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getPSCounterTypeDEModel();
    }

    public PSCounterTypeService getRealService() {
        if (this.pSCounterTypeService == null) {
            try {
                this.pSCounterTypeService = (PSCounterTypeService)ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCounterTypeService", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSCounterTypeService;
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

