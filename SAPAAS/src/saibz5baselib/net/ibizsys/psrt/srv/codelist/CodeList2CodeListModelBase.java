/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="3266fc1690f0742cc46c0827b2d3f655",name="实体属性更新模式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="VERSION",text="版本模式",realtext="版本模式" )
})


/**
 * 静态代码表[实体属性更新模式]模型基类
 */
public abstract class CodeList2CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  版本模式
     */
    public final static String VERSION = "VERSION";


    public CodeList2CodeListModelBase() {
        super();
        this.initAnnotation(CodeList2CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList2CodeListModel", this);
    }

}