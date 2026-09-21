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
import net.ibizsys.pscore.srv.config.demodel.PSViewLogicTypeDEModel;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService;
import net.ibizsys.pscore.srv.core.PSDynamicCodeListModelBase;
import org.hibernate.SessionFactory;

@CodeList(id="2e2741c6c5f19f9eb8428cef535c6a9c", name="\u4e91\u89c6\u56fe\u903b\u8f91\u7c7b\u578b", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={})
public class DEViewLogicTypeCodeListModel
extends PSDynamicCodeListModelBase {
    private PSViewLogicTypeDEModel pSViewLogicTypeDEModel;
    private PSViewLogicTypeService pSViewLogicTypeService;

    public DEViewLogicTypeCodeListModel() {
        this.initAnnotation(DEViewLogicTypeCodeListModel.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DEViewLogicTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DEViewLogicTypeCodeListModel");
    }

    public PSViewLogicTypeDEModel getPSViewLogicTypeDEModel() {
        if (this.pSViewLogicTypeDEModel == null) {
            try {
                this.pSViewLogicTypeDEModel = (PSViewLogicTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSViewLogicTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewLogicTypeDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getPSViewLogicTypeDEModel();
    }

    public PSViewLogicTypeService getRealService() {
        if (this.pSViewLogicTypeService == null) {
            try {
                this.pSViewLogicTypeService = (PSViewLogicTypeService)ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSViewLogicTypeService;
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

