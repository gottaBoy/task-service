/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="f4eba8faeb176761d0a128944afae743",name="代码发布路径",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DEFAULT",text="默认",realtext="默认" )
})


/**
 * 静态代码表[代码发布路径]模型基类
 */
public abstract class CodeList116CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  默认
     */
    public final static String DEFAULT = "DEFAULT";


    public CodeList116CodeListModelBase() {
        super();
        this.initAnnotation(CodeList116CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList116CodeListModel", this);
    }

}