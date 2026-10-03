/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="f2889e5249c0df08a524d556bd2acc37",name="脚本功能",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="基础",realtext="基础" )
    ,@CodeItem(value="128",text="树视图常规",realtext="树视图常规" )
    ,@CodeItem(value="2",text="树视图高级",realtext="树视图高级" )
    ,@CodeItem(value="4",text="TAB视图",realtext="TAB视图" )
    ,@CodeItem(value="8",text="动态面板",realtext="动态面板" )
    ,@CodeItem(value="16",text="搜索面板",realtext="搜索面板" )
    ,@CodeItem(value="32",text="表格视图常规",realtext="表格视图常规" )
    ,@CodeItem(value="64",text="表格视图高级",realtext="表格视图高级" )
    ,@CodeItem(value="256",text="数据视图",realtext="数据视图" )
})


/**
 * 静态代码表[脚本功能]模型基类
 */
public abstract class CodeList114CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  基础
     */
    public final static String ITEM_1 = "1";
    /**
     *  树视图常规
     */
    public final static String ITEM_128 = "128";
    /**
     *  树视图高级
     */
    public final static String ITEM_2 = "2";
    /**
     *  TAB视图
     */
    public final static String ITEM_4 = "4";
    /**
     *  动态面板
     */
    public final static String ITEM_8 = "8";
    /**
     *  搜索面板
     */
    public final static String ITEM_16 = "16";
    /**
     *  表格视图常规
     */
    public final static String ITEM_32 = "32";
    /**
     *  表格视图高级
     */
    public final static String ITEM_64 = "64";
    /**
     *  数据视图
     */
    public final static String ITEM_256 = "256";


    public CodeList114CodeListModelBase() {
        super();
        this.initAnnotation(CodeList114CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList114CodeListModel", this);
    }

}