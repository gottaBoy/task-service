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


@CodeList(id="809A3060-7840-4678-8754-1CFD92B9B720",name="工作流界面向导跳转步骤操作用户",type="DYNAMIC",userscope=false,emptytext="未定义")

@CodeItems({
})


/**
 * 动态代码表[工作流界面向导跳转步骤操作用户]模型基类
 */
public abstract class WFGotoStepActorCodeListModelBase extends net.ibizsys.paas.sysmodel.DynamicCodeListModelBase  {


    public WFGotoStepActorCodeListModelBase() {
        super();
        this.initAnnotation(WFGotoStepActorCodeListModelBase.class);
        this.setDSCondition("");
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFGotoStepActorCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFGotoStepActorCodeListModel");
    }

}