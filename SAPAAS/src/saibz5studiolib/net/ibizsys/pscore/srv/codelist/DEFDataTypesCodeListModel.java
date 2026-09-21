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
import net.ibizsys.pscore.srv.config.demodel.PSDEFDataTypeDEModel;
import net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService;
import net.ibizsys.pscore.srv.core.PSDynamicCodeListModelBase;
import org.hibernate.SessionFactory;

@CodeList(id="f0986090ffbb54c7a874e819af0fb9b4", name="\u4e91\u5b9e\u4f53\u5c5e\u6027\u6570\u636e\u7c7b\u578b", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={})
public class DEFDataTypesCodeListModel
extends PSDynamicCodeListModelBase {
    private PSDEFDataTypeDEModel pSDEFDataTypeDEModel;
    private PSDEFDataTypeService pSDEFDataTypeService;

    public DEFDataTypesCodeListModel() {
        this.initAnnotation(DEFDataTypesCodeListModel.class);
        this.setDSCondition("");
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
        this.setDataField("MEMO");
        this.setUserData2("DEFDataType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDataTypesCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEFDataTypesCodeListModel");
    }

    public PSDEFDataTypeDEModel getPSDEFDataTypeDEModel() {
        if (this.pSDEFDataTypeDEModel == null) {
            try {
                this.pSDEFDataTypeDEModel = (PSDEFDataTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDEFDataTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDataTypeDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getPSDEFDataTypeDEModel();
    }

    public PSDEFDataTypeService getRealService() {
        if (this.pSDEFDataTypeService == null) {
            try {
                this.pSDEFDataTypeService = (PSDEFDataTypeService)ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEFDataTypeService", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEFDataTypeService;
    }

    protected IService getService() {
        return this.getRealService();
    }

    protected void onPrepareCodeItems() throws Exception {
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext(null);
        dEDataSetFetchContext.setSort(this.getMinorSortField());
        dEDataSetFetchContext.setSortDir(this.getMinorSortDir());
        this.fillFetchConditions(dEDataSetFetchContext);
        DBFetchResult dBFetchResult = this.getRealService().fetchValid((IDEDataSetFetchContext)dEDataSetFetchContext);
        this.fillFetchResult(dBFetchResult.getDataSet().getDataTable(0));
    }
}

