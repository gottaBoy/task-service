/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0722c2b457b8882dc0602d17c557fd85",name="缩略界面类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="FORM",text="表单",realtext="表单" )
    ,@CodeItem(value="PAGE",text="内置页面",realtext="内置页面" )
})


/**
 * 静态代码表[缩略界面类型]模型基类
 */
public abstract class CodeList7CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  表单
     */
    public final static String FORM = "FORM";
    /**
     *  内置页面
     */
    public final static String PAGE = "PAGE";


    public CodeList7CodeListModelBase() {
        super();
        this.initAnnotation(CodeList7CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList7CodeListModel", this);
    }

}