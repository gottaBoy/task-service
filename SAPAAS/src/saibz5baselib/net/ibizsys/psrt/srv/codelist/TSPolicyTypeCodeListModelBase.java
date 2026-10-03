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


@CodeList(id="e7616bafaba6e474f4ee06340c6d47b1",name="任务时刻策略类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="GROUP",text="策略组",realtext="策略组")
    ,@CodeItem(value="ITEM",text="策略项",realtext="策略项")
})


/**
 * 静态代码表[任务时刻策略类型]模型基类
 */
public abstract class TSPolicyTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  策略组，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String GROUP = "GROUP";
    /**
     *  策略项，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM = "ITEM";

    public TSPolicyTypeCodeListModelBase() {
        super();
        this.initAnnotation(TSPolicyTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSPolicyTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSPolicyTypeCodeListModel");
    }

}