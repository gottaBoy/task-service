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
import net.ibizsys.pscore.srv.config.demodel.PSDBTypeDEModel;
import net.ibizsys.pscore.srv.config.service.PSDBTypeService;
import net.ibizsys.pscore.srv.core.PSDynamicCodeListModelBase;
import org.hibernate.SessionFactory;

@CodeList(id="def578957798cc6225146fd36ace429a", name="\u4e91\u6570\u636e\u5e93\u7c7b\u578b", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09", ormode="STR", valueseparator=";", textseparator="\u3001")
@CodeItems(value={})
public class DBType2CodeListModel
extends PSDynamicCodeListModelBase {
    private PSDBTypeDEModel pSDBTypeDEModel;
    private PSDBTypeService pSDBTypeService;

    public DBType2CodeListModel() {
        this.initAnnotation(DBType2CodeListModel.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.DBType2CodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.DBType2CodeListModel");
    }

    public PSDBTypeDEModel getPSDBTypeDEModel() {
        if (this.pSDBTypeDEModel == null) {
            try {
                this.pSDBTypeDEModel = (PSDBTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSDBTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBTypeDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getPSDBTypeDEModel();
    }

    public PSDBTypeService getRealService() {
        if (this.pSDBTypeService == null) {
            try {
                this.pSDBTypeService = (PSDBTypeService)ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDBTypeService", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDBTypeService;
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

