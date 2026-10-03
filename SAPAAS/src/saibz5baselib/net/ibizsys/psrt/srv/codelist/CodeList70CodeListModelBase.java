/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="5bd615c5ef0d39a336b95a76142856b1",name="页面处理逻辑类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="AFTERINITPAGEPARAM",text="页面变量初始化之后",realtext="页面变量初始化之后" )
})


/**
 * 静态代码表[页面处理逻辑类型]模型基类
 */
public abstract class CodeList70CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  页面变量初始化之后
     */
    public final static String AFTERINITPAGEPARAM = "AFTERINITPAGEPARAM";


    public CodeList70CodeListModelBase() {
        super();
        this.initAnnotation(CodeList70CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList70CodeListModel", this);
    }

}