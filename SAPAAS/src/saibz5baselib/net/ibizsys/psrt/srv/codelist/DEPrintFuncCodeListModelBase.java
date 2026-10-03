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


@CodeList(id="d5c9515f172104a64b4d7c42a81d770a",name="数据实体_打印功能",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="ENABLE",text="提供",realtext="提供")
    ,@CodeItem(value="DISABLE",text="不提供",realtext="不提供")
    ,@CodeItem(value="AUTO",text="自动判断",realtext="自动判断")
})


/**
 * 静态代码表[数据实体_打印功能]模型基类
 */
public abstract class DEPrintFuncCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  提供，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ENABLE = "ENABLE";
    /**
     *  不提供，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DISABLE = "DISABLE";
    /**
     *  自动判断，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String AUTO = "AUTO";

    public DEPrintFuncCodeListModelBase() {
        super();
        this.initAnnotation(DEPrintFuncCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DEPrintFuncCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DEPrintFuncCodeListModel");
    }

}