/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.psrt.srv.codelist;

import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;
import net.ibizsys.psrt.srv.common.demodel.OrgDEModel;
import net.ibizsys.psrt.srv.common.service.OrgService;

@CodeList(id="DD343073-3729-460F-B85B-ED32C5A034F1", name="\u5168\u90e8\u673a\u6784", type="DYNAMIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={})
public abstract class AllOrgCodeListModelBase
extends DynamicCodeListModelBase {
    private OrgDEModel orgDEModel;
    private OrgService orgService;

    public AllOrgCodeListModelBase() {
        this.initAnnotation(AllOrgCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.AllOrgCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.AllOrgCodeListModel");
    }

    public OrgDEModel getOrgDEModel() {
        if (this.orgDEModel == null) {
            try {
                this.orgDEModel = (OrgDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgDEModel;
    }

    @Override
    protected IDataEntityModel getDEModel() {
        return this.getOrgDEModel();
    }

    public OrgService getRealService() {
        if (this.orgService == null) {
            try {
                this.orgService = (OrgService)ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.OrgService", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.orgService;
    }

    @Override
    protected IService getService() {
        return this.getRealService();
    }

    @Override
    protected void onPrepareCodeItems() throws Exception {
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
        deDataSetFetchContextImpl.setSort(this.getMinorSortField());
        deDataSetFetchContextImpl.setSortDir(this.getMinorSortDir());
        this.fillFetchConditions(deDataSetFetchContextImpl);
        DBFetchResult fetchResult = this.getRealService().fetchDefault(deDataSetFetchContextImpl);
        this.fillFetchResult(fetchResult.getDataSet().getDataTable(0));
    }
}

