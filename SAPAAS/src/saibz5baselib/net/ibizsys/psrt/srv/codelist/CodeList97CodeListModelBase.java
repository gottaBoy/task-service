/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="fce0a2be420665e49abcb647a02f3460",name="数据同步方向",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="IN",text="输入",realtext="输入")
    ,@CodeItem(value="OUT",text="输出",realtext="输出")
})


/**
 * 静态代码表[数据同步方向]模型基类
 */
public abstract class CodeList97CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  输入，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String IN = "IN";
    /**
     *  输出，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String OUT = "OUT";

    public CodeList97CodeListModelBase() {
        super();
        this.initAnnotation(CodeList97CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList97CodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList97CodeListModel");
    }

}