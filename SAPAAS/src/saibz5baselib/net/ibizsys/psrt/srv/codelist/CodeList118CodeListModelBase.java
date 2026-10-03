/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="d423ad45d077876d562a796f3056c030",name="平台内置处理组件类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CODELISTFILLER",text="代码表填充器",realtext="代码表填充器" )
    ,@CodeItem(value="WFPROCESS",text="工作流嵌入处理",realtext="工作流嵌入处理" )
    ,@CodeItem(value="DGACTIONHELPER",text="表格后台处理对象",realtext="表格后台处理对象" )
    ,@CodeItem(value="FORMACTIONHELPER",text="表单后台处理类",realtext="表单后台处理类" )
    ,@CodeItem(value="PAGE",text="页面对象",realtext="页面对象" )
})


/**
 * 静态代码表[平台内置处理组件类型]模型基类
 */
public abstract class CodeList118CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  代码表填充器
     */
    public final static String CODELISTFILLER = "CODELISTFILLER";
    /**
     *  工作流嵌入处理
     */
    public final static String WFPROCESS = "WFPROCESS";
    /**
     *  表格后台处理对象
     */
    public final static String DGACTIONHELPER = "DGACTIONHELPER";
    /**
     *  表单后台处理类
     */
    public final static String FORMACTIONHELPER = "FORMACTIONHELPER";
    /**
     *  页面对象
     */
    public final static String PAGE = "PAGE";


    public CodeList118CodeListModelBase() {
        super();
        this.initAnnotation(CodeList118CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList118CodeListModel", this);
    }

}