/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="4bc7f1433da3a22f25eff878790f0be5",name="代码表或模式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="NUMBERORMODE",text="数字或处理",realtext="数字或处理")
    ,@CodeItem(value="STRINGORMODE",text="文本或模式",realtext="文本或模式")
})


/**
 * 静态代码表[代码表或模式]模型基类
 */
public abstract class CodeList20CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  数字或处理，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String NUMBERORMODE = "NUMBERORMODE";
    /**
     *  文本或模式，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String STRINGORMODE = "STRINGORMODE";

    public CodeList20CodeListModelBase() {
        super();
        this.initAnnotation(CodeList20CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList20CodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList20CodeListModel");
    }

}