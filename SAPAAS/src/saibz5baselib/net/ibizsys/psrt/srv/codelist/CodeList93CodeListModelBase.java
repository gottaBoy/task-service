/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="182e9b4bb6bcab7216fb161b5af86790",name="动态面板分区缩放样式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="EXPAND",text="展开",realtext="展开" )
    ,@CodeItem(value="COLLAPSE",text="收缩",realtext="收缩" )
})


/**
 * 静态代码表[动态面板分区缩放样式]模型基类
 */
public abstract class CodeList93CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  展开
     */
    public final static String EXPAND = "EXPAND";
    /**
     *  收缩
     */
    public final static String COLLAPSE = "COLLAPSE";


    public CodeList93CodeListModelBase() {
        super();
        this.initAnnotation(CodeList93CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList93CodeListModel", this);
    }

}