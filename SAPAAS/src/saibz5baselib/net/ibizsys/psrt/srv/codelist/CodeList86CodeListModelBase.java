/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="40f5d330b000794be41a3aa056eea7a9",name="月周（1～5）",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="1周",realtext="1周" )
    ,@CodeItem(value="2",text="2周",realtext="2周" )
    ,@CodeItem(value="3",text="3周",realtext="3周" )
    ,@CodeItem(value="4",text="4周",realtext="4周" )
    ,@CodeItem(value="5",text="5周",realtext="5周" )
})


/**
 * 静态代码表[月周（1～5）]模型基类
 */
public abstract class CodeList86CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  1周
     */
    public final static String ITEM_1 = "1";
    /**
     *  2周
     */
    public final static String ITEM_2 = "2";
    /**
     *  3周
     */
    public final static String ITEM_3 = "3";
    /**
     *  4周
     */
    public final static String ITEM_4 = "4";
    /**
     *  5周
     */
    public final static String ITEM_5 = "5";


    public CodeList86CodeListModelBase() {
        super();
        this.initAnnotation(CodeList86CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList86CodeListModel", this);
    }

}