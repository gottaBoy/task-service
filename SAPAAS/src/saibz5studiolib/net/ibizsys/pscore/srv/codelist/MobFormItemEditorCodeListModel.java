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
import net.ibizsys.pscore.srv.config.demodel.PSEditorTypeDEModel;
import net.ibizsys.pscore.srv.config.service.PSEditorTypeService;
import net.ibizsys.pscore.srv.core.PSDynamicCodeListModelBase;
import org.hibernate.SessionFactory;

@CodeList(id="30159d9c608f1a4e6f15027e1c25fc5f", name="\u5e73\u53f0\u79fb\u52a8\u7aef\u8868\u5355\u9879\u7f16\u8f91\u5668", type="DYNAMIC", userscope=false, emptytext="\uff08\u9ed8\u8ba4\uff09")
@CodeItems(value={})
public class MobFormItemEditorCodeListModel
extends PSDynamicCodeListModelBase {
    private PSEditorTypeDEModel pSEditorTypeDEModel;
    private PSEditorTypeService pSEditorTypeService;

    public MobFormItemEditorCodeListModel() {
        this.initAnnotation(MobFormItemEditorCodeListModel.class);
        this.setDSCondition("");
        this.setMinorSortField("ORDERVALUE");
        this.setMinorSortDir("ASC");
        this.setUserData2("MobEditorType");
        CodeListGlobal.registerCodeList((String)"net.ibizsys.pscore.srv.codelist.MobFormItemEditorCodeListModel", (ICodeListModel)this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList((String)"net.ibizsys.pscore.srv.codelist.MobFormItemEditorCodeListModel");
    }

    public PSEditorTypeDEModel getPSEditorTypeDEModel() {
        if (this.pSEditorTypeDEModel == null) {
            try {
                this.pSEditorTypeDEModel = (PSEditorTypeDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.config.demodel.PSEditorTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSEditorTypeDEModel;
    }

    protected IDataEntityModel getDEModel() {
        return this.getPSEditorTypeDEModel();
    }

    public PSEditorTypeService getRealService() {
        if (this.pSEditorTypeService == null) {
            try {
                this.pSEditorTypeService = (PSEditorTypeService)ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSEditorTypeService", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSEditorTypeService;
    }

    protected IService getService() {
        return this.getRealService();
    }

    protected void onPrepareCodeItems() throws Exception {
        DEDataSetFetchContext dEDataSetFetchContext = new DEDataSetFetchContext(null);
        dEDataSetFetchContext.setSort(this.getMinorSortField());
        dEDataSetFetchContext.setSortDir(this.getMinorSortDir());
        this.fillFetchConditions(dEDataSetFetchContext);
        DBFetchResult dBFetchResult = this.getRealService().fetchValidMob((IDEDataSetFetchContext)dEDataSetFetchContext);
        this.fillFetchResult(dBFetchResult.getDataSet().getDataTable(0));
    }
}

