/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="156dff28186d169365fb4a646c58607a",name="功能类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DEDATAGRID",text="默认实体表格视图",realtext="默认实体表格视图" )
    ,@CodeItem(value="PAGELINK",text="页面链接",realtext="页面链接" )
    ,@CodeItem(value="JSCODE",text="纯JS代码",realtext="纯JS代码" )
    ,@CodeItem(value="DEGRIDVIEW",text="指定实体表格视图",realtext="指定实体表格视图" )
    ,@CodeItem(value="PAGE",text="内置页面",realtext="内置页面" )
})


/**
 * 静态代码表[功能类型]模型基类
 */
public abstract class CodeList4CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  默认实体表格视图
     */
    public final static String DEDATAGRID = "DEDATAGRID";
    /**
     *  页面链接
     */
    public final static String PAGELINK = "PAGELINK";
    /**
     *  纯JS代码
     */
    public final static String JSCODE = "JSCODE";
    /**
     *  指定实体表格视图
     */
    public final static String DEGRIDVIEW = "DEGRIDVIEW";
    /**
     *  内置页面
     */
    public final static String PAGE = "PAGE";


    public CodeList4CodeListModelBase() {
        super();
        this.initAnnotation(CodeList4CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList4CodeListModel", this);
    }

}