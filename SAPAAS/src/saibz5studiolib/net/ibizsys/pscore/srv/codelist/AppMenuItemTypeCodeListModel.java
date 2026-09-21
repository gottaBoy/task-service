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
import net.ibizsys.pscore.srv.core.PSDynamicCodeListModelBase;
import net.ibizsys.pscore.srv.def.demodel.PSAMItemTypeDEModel;
import net.ibizsys.pscore.srv.def.service.PSAMItemTypeService;
import org.hibernate.SessionFactory;

@CodeList(id="cba3541d8d0016d0f53c2e43175183e5", name="\u4e91\u5e94\u7528\u83dc\u5355\u9879\u7c7b\u578b", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={})
public class AppMenuItemTypeCodeListModel
extends PSDynamicCodeListModelBase {
    private PSAMItemTypeDEModel pSAMItemTypeDEModel;
    private PSAMItemTypeService pSAMItemTypeService;

    public AppMenuItemTypeCodeListModel() {
        this.initAnnotation(AppMenuItemTypeCodeListModel.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.AppMenuItemTypeCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.AppMenuItemTypeCodeListModel");
    }

    public PSAMItemTypeDEModel getPSAMItemTypeDEModel() {
        if (this.pSAMItemTypeDEModel == null) {
            try {
                this.pSAMItemTypeDEModel = (PSAMItemTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.def.demodel.PSAMItemTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAMItemTypeDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getPSAMItemTypeDEModel();
    }

    public PSAMItemTypeService getRealService() {
        if (this.pSAMItemTypeService == null) {
            try {
                this.pSAMItemTypeService = (PSAMItemTypeService)ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSAMItemTypeService", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSAMItemTypeService;
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

