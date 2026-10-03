/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="d62ba560b42f88d71683dab85cd77fc4",name="表格每页记录数",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="10",text="10行",realtext="10行" )
    ,@CodeItem(value="20",text="20行",realtext="20行" )
    ,@CodeItem(value="30",text="30行",realtext="30行" )
    ,@CodeItem(value="40",text="40行",realtext="40行" )
    ,@CodeItem(value="50",text="50行",realtext="50行" )
    ,@CodeItem(value="60",text="60行",realtext="60行" )
    ,@CodeItem(value="70",text="70行",realtext="70行" )
    ,@CodeItem(value="80",text="80行",realtext="80行" )
    ,@CodeItem(value="90",text="90行",realtext="90行" )
    ,@CodeItem(value="100",text="100行",realtext="100行" )
})


/**
 * 静态代码表[表格每页记录数]模型基类
 */
public abstract class CodeList26CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  10行
     */
    public final static String ITEM_10 = "10";
    /**
     *  20行
     */
    public final static String ITEM_20 = "20";
    /**
     *  30行
     */
    public final static String ITEM_30 = "30";
    /**
     *  40行
     */
    public final static String ITEM_40 = "40";
    /**
     *  50行
     */
    public final static String ITEM_50 = "50";
    /**
     *  60行
     */
    public final static String ITEM_60 = "60";
    /**
     *  70行
     */
    public final static String ITEM_70 = "70";
    /**
     *  80行
     */
    public final static String ITEM_80 = "80";
    /**
     *  90行
     */
    public final static String ITEM_90 = "90";
    /**
     *  100行
     */
    public final static String ITEM_100 = "100";


    public CodeList26CodeListModelBase() {
        super();
        this.initAnnotation(CodeList26CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList26CodeListModel", this);
    }

}