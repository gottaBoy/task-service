/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="40fb23104782bed4ca195d9f1356776d",name="星期（1～7）",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="2",text="星期一",realtext="星期一" )
    ,@CodeItem(value="3",text="星期二",realtext="星期二" )
    ,@CodeItem(value="4",text="星期三",realtext="星期三" )
    ,@CodeItem(value="5",text="星期四",realtext="星期四" )
    ,@CodeItem(value="6",text="星期五",realtext="星期五" )
    ,@CodeItem(value="7",text="星期六",realtext="星期六" )
    ,@CodeItem(value="1",text="星期日",realtext="星期日" )
})


/**
 * 静态代码表[星期（1～7）]模型基类
 */
public abstract class CodeList46CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  星期一
     */
    public final static String ITEM_2 = "2";
    /**
     *  星期二
     */
    public final static String ITEM_3 = "3";
    /**
     *  星期三
     */
    public final static String ITEM_4 = "4";
    /**
     *  星期四
     */
    public final static String ITEM_5 = "5";
    /**
     *  星期五
     */
    public final static String ITEM_6 = "6";
    /**
     *  星期六
     */
    public final static String ITEM_7 = "7";
    /**
     *  星期日
     */
    public final static String ITEM_1 = "1";


    public CodeList46CodeListModelBase() {
        super();
        this.initAnnotation(CodeList46CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList46CodeListModel", this);
    }

}