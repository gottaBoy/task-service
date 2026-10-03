/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="1f77a3a48ad9ba04de2c95cf5b500895",name="页面参数类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="PP_SEARCHFORM",text="搜索表单控件参数",realtext="搜索表单控件参数" )
    ,@CodeItem(value="PP_WFWORKTREEBAR",text="工作流工作树边栏参数对象",realtext="工作流工作树边栏参数对象" )
    ,@CodeItem(value="PP_EVTABVIEW",text="编辑界面分页控件参数",realtext="编辑界面分页控件参数" )
    ,@CodeItem(value="PP_MENUTREEBAR",text="菜单树边栏控件参数",realtext="菜单树边栏控件参数" )
    ,@CodeItem(value="PP_TREEVIEWBAR",text="树视图边栏控件参数",realtext="树视图边栏控件参数" )
    ,@CodeItem(value="PP_DATAGRID",text="数据表格控件参数",realtext="数据表格控件参数" )
    ,@CodeItem(value="PP_FORM",text="表单控件参数",realtext="表单控件参数" )
    ,@CodeItem(value="PP_ETMFORM",text="嵌入多表单编辑对象",realtext="嵌入多表单编辑对象" )
    ,@CodeItem(value="PP_CALENDAR",text="日历界面部件参数",realtext="日历界面部件参数" )
    ,@CodeItem(value="PPTREEPICKUPVIEW",text="树选择视图参数对象",realtext="树选择视图参数对象" )
    ,@CodeItem(value="PPNFVIEW",text="框架导航界面参数",realtext="框架导航界面参数" )
    ,@CodeItem(value="PP_TREEPANEL",text="树控件参数",realtext="树控件参数" )
    ,@CodeItem(value="PPEDITVIEW",text="编辑界面参数",realtext="编辑界面参数" )
    ,@CodeItem(value="PPFORMVIEW",text="表单部件页界面参数",realtext="表单部件页界面参数" )
    ,@CodeItem(value="PPINDEXVIEW",text="系统默认界面参数",realtext="系统默认界面参数" )
    ,@CodeItem(value="PPGRIDVIEW",text="常规数据表格界面参数",realtext="常规数据表格界面参数" )
    ,@CodeItem(value="PPWFIAACTIONVIEW",text="工作流交互操作界面参数",realtext="工作流交互操作界面参数" )
})


/**
 * 静态代码表[页面参数类型]模型基类
 */
public abstract class CodeList78CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  搜索表单控件参数
     */
    public final static String PP_SEARCHFORM = "PP_SEARCHFORM";
    /**
     *  工作流工作树边栏参数对象
     */
    public final static String PP_WFWORKTREEBAR = "PP_WFWORKTREEBAR";
    /**
     *  编辑界面分页控件参数
     */
    public final static String PP_EVTABVIEW = "PP_EVTABVIEW";
    /**
     *  菜单树边栏控件参数
     */
    public final static String PP_MENUTREEBAR = "PP_MENUTREEBAR";
    /**
     *  树视图边栏控件参数
     */
    public final static String PP_TREEVIEWBAR = "PP_TREEVIEWBAR";
    /**
     *  数据表格控件参数
     */
    public final static String PP_DATAGRID = "PP_DATAGRID";
    /**
     *  表单控件参数
     */
    public final static String PP_FORM = "PP_FORM";
    /**
     *  嵌入多表单编辑对象
     */
    public final static String PP_ETMFORM = "PP_ETMFORM";
    /**
     *  日历界面部件参数
     */
    public final static String PP_CALENDAR = "PP_CALENDAR";
    /**
     *  树选择视图参数对象
     */
    public final static String PPTREEPICKUPVIEW = "PPTREEPICKUPVIEW";
    /**
     *  框架导航界面参数
     */
    public final static String PPNFVIEW = "PPNFVIEW";
    /**
     *  树控件参数
     */
    public final static String PP_TREEPANEL = "PP_TREEPANEL";
    /**
     *  编辑界面参数
     */
    public final static String PPEDITVIEW = "PPEDITVIEW";
    /**
     *  表单部件页界面参数
     */
    public final static String PPFORMVIEW = "PPFORMVIEW";
    /**
     *  系统默认界面参数
     */
    public final static String PPINDEXVIEW = "PPINDEXVIEW";
    /**
     *  常规数据表格界面参数
     */
    public final static String PPGRIDVIEW = "PPGRIDVIEW";
    /**
     *  工作流交互操作界面参数
     */
    public final static String PPWFIAACTIONVIEW = "PPWFIAACTIONVIEW";


    public CodeList78CodeListModelBase() {
        super();
        this.initAnnotation(CodeList78CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList78CodeListModel", this);
    }

}