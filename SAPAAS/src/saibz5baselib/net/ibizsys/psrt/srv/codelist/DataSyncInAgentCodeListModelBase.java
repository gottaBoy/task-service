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


@CodeList(id="de1a16047efd7cdfcbda77df156c73df",name="数据同步代理（输入）",type="DYNAMIC",userscope=false,emptytext="未定义")

@CodeItems({
})


/**
 * 动态代码表[数据同步代理（输入）]模型基类
 */
public abstract class DataSyncInAgentCodeListModelBase extends net.ibizsys.paas.sysmodel.DynamicCodeListModelBase  {


    public DataSyncInAgentCodeListModelBase() {
        super();
        this.initAnnotation(DataSyncInAgentCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DataSyncInAgentCodeListModel");
    }

}