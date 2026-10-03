/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;

import net.ibizsys.paas.sysmodel.DynamicCodeListModelBase;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;

import net.ibizsys.psrt.srv.common.service.UserRoleTypeService;
import net.ibizsys.psrt.srv.common.demodel.UserRoleTypeDEModel;

@CodeList(id="026f7b67ce2b5582082ab1ab104258d9",name="用户角色类型",type="DYNAMIC",userscope=false,emptytext="未定义")

@CodeItems({
})


/**
 * 动态代码表[用户角色类型]模型基类
 */
public abstract class UserRoleTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.DynamicCodeListModelBase  {


    public UserRoleTypeCodeListModelBase() {
        super();
        this.initAnnotation(UserRoleTypeCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.UserRoleTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.UserRoleTypeCodeListModel");
    }

    private UserRoleTypeDEModel userRoleTypeDEModel;

    /**
     * 获取实体[USERROLETYPE]模型对象
     */
    public  UserRoleTypeDEModel getUserRoleTypeDEModel() {
        if(this.userRoleTypeDEModel==null) {
            try {
                this.userRoleTypeDEModel = (UserRoleTypeDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.UserRoleTypeDEModel");
            } catch(Exception ex) {
            }
        }
        return this.userRoleTypeDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#getDEModel()
     */
    @Override
    protected IDataEntityModel getDEModel() {
        return this.getUserRoleTypeDEModel();
    }

    private UserRoleTypeService userRoleTypeService;

    /**
     * 获取实体[USERROLETYPE]实际服务对象
     */
    public  UserRoleTypeService getRealService() {
        if(this.userRoleTypeService==null) {
            try {
                this.userRoleTypeService = (UserRoleTypeService)ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.UserRoleTypeService",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.userRoleTypeService;
    }

    /* (non-Javadoc)
    * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#getService()
    */
    @Override
    protected IService getService() {
        return getRealService();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#onPrepareCodeItems()
     */
    @Override
    protected void onPrepareCodeItems() throws Exception {
        DEDataSetFetchContext deDataSetFetchContextImpl = new DEDataSetFetchContext(null);
        deDataSetFetchContextImpl.setSort(this.getMinorSortField());
        deDataSetFetchContextImpl.setSortDir(this.getMinorSortDir());
        fillFetchConditions(deDataSetFetchContextImpl);
        DBFetchResult fetchResult = this.getRealService().fetchDefault(deDataSetFetchContextImpl);
        fillFetchResult(fetchResult.getDataSet().getDataTable(0));
    }
}