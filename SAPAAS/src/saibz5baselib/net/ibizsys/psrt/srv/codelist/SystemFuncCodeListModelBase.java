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


@CodeList(id="08b62e1695176eb1ce95333dd44a3722",name="系统集成功能",type="STATIC",userscope=false,emptytext="未定义",ormode="NUM",textseparator="、")

@CodeItems({
    @CodeItem(value="1",text="统一认证",realtext="统一认证")
    ,@CodeItem(value="2",text="统一权限",realtext="统一权限")
    ,@CodeItem(value="4",text="系统日志",realtext="系统日志")
    ,@CodeItem(value="8",text="工作流服务",realtext="工作流服务")
    ,@CodeItem(value="16",text="短信网关",realtext="短信网关")
})


/**
 * 静态代码表[系统集成功能]模型基类
 */
public abstract class SystemFuncCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  统一认证，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer ITEM_1 = 1;

    /**
     *  统一认证，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_ITEM_1 = 1;
    /**
     *  统一权限，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer ITEM_2 = 2;

    /**
     *  统一权限，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_ITEM_2 = 2;
    /**
     *  系统日志，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer ITEM_4 = 4;

    /**
     *  系统日志，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_ITEM_4 = 4;
    /**
     *  工作流服务，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer ITEM_8 = 8;

    /**
     *  工作流服务，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_ITEM_8 = 8;
    /**
     *  短信网关，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer ITEM_16 = 16;

    /**
     *  短信网关，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_ITEM_16 = 16;

    public SystemFuncCodeListModelBase() {
        super();
        this.initAnnotation(SystemFuncCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.SystemFuncCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.SystemFuncCodeListModel");
    }

}