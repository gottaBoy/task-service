/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="7cc93f7d8e55391b4e9e5043be433cfb",name="季度（1～4）",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="1季度",realtext="1季度" )
    ,@CodeItem(value="2",text="2季度",realtext="2季度" )
    ,@CodeItem(value="3",text="3季度",realtext="3季度" )
    ,@CodeItem(value="4",text="4季度",realtext="4季度" )
})


/**
 * 静态代码表[季度（1～4）]模型基类
 */
public abstract class CodeList83CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  1季度
     */
    public final static String ITEM_1 = "1";
    /**
     *  2季度
     */
    public final static String ITEM_2 = "2";
    /**
     *  3季度
     */
    public final static String ITEM_3 = "3";
    /**
     *  4季度
     */
    public final static String ITEM_4 = "4";


    public CodeList83CodeListModelBase() {
        super();
        this.initAnnotation(CodeList83CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList83CodeListModel", this);
    }

}