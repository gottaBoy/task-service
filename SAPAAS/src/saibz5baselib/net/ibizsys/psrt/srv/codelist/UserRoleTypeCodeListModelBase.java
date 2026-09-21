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
import net.ibizsys.psrt.srv.common.demodel.UserRoleTypeDEModel;
import net.ibizsys.psrt.srv.common.service.UserRoleTypeService;

@CodeList(id="026f7b67ce2b5582082ab1ab104258d9", name="\u7528\u6237\u89d2\u8272\u7c7b\u578b", type="DYNAMIC", userscope=false, emptytext="\u672a\u5b9a\u4e49")
@CodeItems(value={})
public abstract class UserRoleTypeCodeListModelBase
extends DynamicCodeListModelBase {
    private UserRoleTypeDEModel userRoleTypeDEModel;
    private UserRoleTypeService userRoleTypeService;

    public UserRoleTypeCodeListModelBase() {
        this.initAnnotation(UserRoleTypeCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.UserRoleTypeCodeListModel", this);
    }

    public static ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.UserRoleTypeCodeListModel");
    }

    public UserRoleTypeDEModel getUserRoleTypeDEModel() {
        if (this.userRoleTypeDEModel == null) {
            try {
                this.userRoleTypeDEModel = (UserRoleTypeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleTypeDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleTypeDEModel;
    }

    @Override
    protected IDataEntityModel getDEModel() {
        return this.getUserRoleTypeDEModel();
    }

    public UserRoleTypeService getRealService() {
        if (this.userRoleTypeService == null) {
            try {
                this.userRoleTypeService = (UserRoleTypeService)ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleTypeService", this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.userRoleTypeService;
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

