/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="3540386765d145c9285a21daad8e61f0",name="实体属性插入模式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="VERSION",text="版本模式",realtext="版本模式" )
})


/**
 * 静态代码表[实体属性插入模式]模型基类
 */
public abstract class CodeList1CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  版本模式
     */
    public final static String VERSION = "VERSION";


    public CodeList1CodeListModelBase() {
        super();
        this.initAnnotation(CodeList1CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList1CodeListModel", this);
    }

}