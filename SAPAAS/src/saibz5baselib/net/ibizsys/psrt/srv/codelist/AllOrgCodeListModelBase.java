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

import net.ibizsys.psrt.srv.common.service.OrgService;
import net.ibizsys.psrt.srv.common.demodel.OrgDEModel;

@CodeList(id="DD343073-3729-460F-B85B-ED32C5A034F1",name="全部机构",type="DYNAMIC",userscope=false,emptytext="未定义")

@CodeItems({
})


/**
 * 动态代码表[全部机构]模型基类
 */
public abstract class AllOrgCodeListModelBase extends net.ibizsys.paas.sysmodel.DynamicCodeListModelBase  {


    public AllOrgCodeListModelBase() {
        super();
        this.initAnnotation(AllOrgCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.AllOrgCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.AllOrgCodeListModel");
    }

    private OrgDEModel orgDEModel;

    /**
     * 获取实体[ORG]模型对象
     */
    public  OrgDEModel getOrgDEModel() {
        if(this.orgDEModel==null) {
            try {
                this.orgDEModel = (OrgDEModel)DEModelGlobal.getDEModel("net.ibizsys.psrt.srv.common.demodel.OrgDEModel");
            } catch(Exception ex) {
            }
        }
        return this.orgDEModel;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.sysmodel.DynamicCodeListModelBase#getDEModel()
     */
    @Override
    protected IDataEntityModel getDEModel() {
        return this.getOrgDEModel();
    }

    private OrgService orgService;

    /**
     * 获取实体[ORG]实际服务对象
     */
    public  OrgService getRealService() {
        if(this.orgService==null) {
            try {
                this.orgService = (OrgService)ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.OrgService",this.getSessionFactory());
            } catch(Exception ex) {
            }
        }
        return this.orgService;
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