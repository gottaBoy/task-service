/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="05db5e133118bf8919ebfbb39b13f1a3",name="实体快捷应用范围",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="拾取链接",realtext="拾取链接" )
})


/**
 * 静态代码表[实体快捷应用范围]模型基类
 */
public abstract class CodeList41CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  拾取链接
     */
    public final static String ITEM_1 = "1";


    public CodeList41CodeListModelBase() {
        super();
        this.initAnnotation(CodeList41CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList41CodeListModel", this);
    }

}