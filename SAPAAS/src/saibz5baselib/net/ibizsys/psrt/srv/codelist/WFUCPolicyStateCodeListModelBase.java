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


@CodeList(id="fe90f31851408af694c448d7582736d2",name="工作流代办策略状态",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="未应用",realtext="未应用")
    ,@CodeItem(value="2",text="已应用",realtext="已应用")
    ,@CodeItem(value="3",text="已过期",realtext="已过期")
    ,@CodeItem(value="4",text="已取消",realtext="已取消")
})


/**
 * 静态代码表[工作流代办策略状态]模型基类
 */
public abstract class WFUCPolicyStateCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  未应用，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer NOTAPPLIED = 1;

    /**
     *  未应用，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_NOTAPPLIED = 1;
    /**
     *  已应用，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer APPLIED = 2;

    /**
     *  已应用，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_APPLIED = 2;
    /**
     *  已过期，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer EXPIRED = 3;

    /**
     *  已过期，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_EXPIRED = 3;
    /**
     *  已取消，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer CANCELED = 4;

    /**
     *  已取消，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_CANCELED = 4;

    public WFUCPolicyStateCodeListModelBase() {
        super();
        this.initAnnotation(WFUCPolicyStateCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFUCPolicyStateCodeListModel");
    }

}