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
import net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicNodeDEModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import org.hibernate.SessionFactory;

@CodeList(id="D95B202E-B866-46B0-AAEE-F833D34772F9", name="\u5b9e\u4f53\u903b\u8f91\u5904\u7406\u5f02\u5e38\u5bf9\u8c61", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={})
public class DELNExceptionObjCodeListModel
extends PSDynamicCodeListModelBase {
    private PSDELogicNodeDEModel pSDELogicNodeDEModel;
    private PSDELogicNodeService pSDELogicNodeService;

    public DELNExceptionObjCodeListModel() {
        this.initAnnotation(DELNExceptionObjCodeListModel.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DELNExceptionObjCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DELNExceptionObjCodeListModel");
    }

    public PSDELogicNodeDEModel getPSDELogicNodeDEModel() {
        if (this.pSDELogicNodeDEModel == null) {
            try {
                this.pSDELogicNodeDEModel = (PSDELogicNodeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDELogicNodeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELogicNodeDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getPSDELogicNodeDEModel();
    }

    public PSDELogicNodeService getRealService() {
        if (this.pSDELogicNodeService == null) {
            try {
                this.pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDELogicNodeService;
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

