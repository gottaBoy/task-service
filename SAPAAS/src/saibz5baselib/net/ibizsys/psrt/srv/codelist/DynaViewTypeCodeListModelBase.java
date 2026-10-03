/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="d3220274deae2f484dfb18e927885909",name="动态视图类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="APPINDEXVIEW",text="应用首页视图",realtext="应用首页视图")
    ,@CodeItem(value="APPPORTALVIEW",text="应用门户视图",realtext="应用门户视图")
    ,@CodeItem(value="DECHARTVIEW",text="实体图表视图",realtext="实体图表视图")
    ,@CodeItem(value="DECUSTOMVIEW",text="实体自定义视图",realtext="实体自定义视图")
    ,@CodeItem(value="DEDATAVIEW",text="实体数据视图",realtext="实体数据视图")
    ,@CodeItem(value="DEEDITVIEW",text="实体编辑视图",realtext="实体编辑视图")
    ,@CodeItem(value="DEEDITVIEW2",text="实体编辑视图（左右关系）",realtext="实体编辑视图（左右关系）")
    ,@CodeItem(value="DEEDITVIEW3",text="实体编辑视图（分页关系）",realtext="实体编辑视图（分页关系）")
    ,@CodeItem(value="DEEDITVIEW4",text="实体编辑视图（上下关系）",realtext="实体编辑视图（上下关系）")
    ,@CodeItem(value="DEEDITVIEW9",text="实体编辑视图（嵌入）",realtext="实体编辑视图（嵌入）")
    ,@CodeItem(value="DEFORMPICKUPDATAVIEW",text="实体表单选择数据视图（部件视图）",realtext="实体表单选择数据视图（部件视图）")
    ,@CodeItem(value="DEGRIDVIEW",text="实体表格视图",realtext="实体表格视图")
    ,@CodeItem(value="DEGRIDVIEW2",text="实体表格视图（左右关系）",realtext="实体表格视图（左右关系）")
    ,@CodeItem(value="DEGRIDVIEW4",text="实体表格视图（上下关系）",realtext="实体表格视图（上下关系）")
    ,@CodeItem(value="DEGRIDVIEW8",text="实体关系数据表格视图（嵌入）",realtext="实体关系数据表格视图（嵌入）")
    ,@CodeItem(value="DEGRIDVIEW9",text="实体表格视图（嵌入）",realtext="实体表格视图（嵌入）")
    ,@CodeItem(value="DEHTMLVIEW",text="实体HTML视图",realtext="实体HTML视图")
    ,@CodeItem(value="DEINDEXPICKUPDATAVIEW",text="实体索引关系选择数据视图（部件视图）",realtext="实体索引关系选择数据视图（部件视图）")
    ,@CodeItem(value="DEINDEXVIEW",text="实体首页视图",realtext="实体首页视图")
    ,@CodeItem(value="DEMDCUSTOMVIEW",text="实体多数据自定义视图",realtext="实体多数据自定义视图")
    ,@CodeItem(value="DEMEDITVIEW9",text="实体多表单编辑视图（嵌入）",realtext="实体多表单编辑视图（嵌入）")
    ,@CodeItem(value="DEMOBCUSTOMVIEW",text="实体移动端自定义视图",realtext="实体移动端自定义视图")
    ,@CodeItem(value="DEMOBEDITVIEW",text="实体移动端编辑视图",realtext="实体移动端编辑视图")
    ,@CodeItem(value="DEMOBFORMPICKUPMDVIEW",text="实体移动端表单类型选择多数据视图（部件视图）",realtext="实体移动端表单类型选择多数据视图（部件视图）")
    ,@CodeItem(value="DEMOBINDEXPICKUPMDVIEW",text="实体移动端索引类型选择多数据视图（部件视图）",realtext="实体移动端索引类型选择多数据视图（部件视图）")
    ,@CodeItem(value="DEMOBLISTVIEW",text="实体移动端列表视图",realtext="实体移动端列表视图")
    ,@CodeItem(value="DEMOBMDVIEW",text="实体移动端多数据视图",realtext="实体移动端多数据视图")
    ,@CodeItem(value="DEMOBMDVIEW9",text="实体移动端多数据视图（部件视图）",realtext="实体移动端多数据视图（部件视图）")
    ,@CodeItem(value="DEMOBMPICKUPVIEW",text="实体移动端多数据选择视图",realtext="实体移动端多数据选择视图")
    ,@CodeItem(value="DEMOBPICKUPLISTVIEW",text="实体移动端选择列表视图（部件视图）",realtext="实体移动端选择列表视图（部件视图）")
    ,@CodeItem(value="DEMOBPICKUPMDVIEW",text="实体移动端选择多数据视图（部件视图）",realtext="实体移动端选择多数据视图（部件视图）")
    ,@CodeItem(value="DEMOBPICKUPTREEVIEW",text="实体移动端选择树视图（部件视图）",realtext="实体移动端选择树视图（部件视图）")
    ,@CodeItem(value="DEMOBPICKUPVIEW",text="实体移动端数据选择视图",realtext="实体移动端数据选择视图")
    ,@CodeItem(value="DEMOBTABEXPVIEW",text="实体移动端分页导航视图",realtext="实体移动端分页导航视图")
    ,@CodeItem(value="DEMOBTREEVIEW",text="实体移动端树视图",realtext="实体移动端树视图")
    ,@CodeItem(value="DEMOBWFACTIONVIEW",text="实体移动端工作流操作视图",realtext="实体移动端工作流操作视图")
    ,@CodeItem(value="DEMOBWFEDITVIEW",text="实体移动端工作流编辑视图",realtext="实体移动端工作流编辑视图")
    ,@CodeItem(value="DEMOBWFEDITVIEW3",text="实体移动端工作流编辑视图（分页关系）",realtext="实体移动端工作流编辑视图（分页关系）")
    ,@CodeItem(value="DEMOBWFMDVIEW",text="实体移动端工作流多数据视图",realtext="实体移动端工作流多数据视图")
    ,@CodeItem(value="DEMOBWFSTARTVIEW",text="实体移动端工作流启动视图",realtext="实体移动端工作流启动视图")
    ,@CodeItem(value="DEMPICKUPVIEW",text="实体数据多项选择视图",realtext="实体数据多项选择视图")
    ,@CodeItem(value="DEMPICKUPVIEW2",text="实体多项数据选择视图（左右关系）",realtext="实体多项数据选择视图（左右关系）")
    ,@CodeItem(value="DEOPTVIEW",text="实体选项操作视图",realtext="实体选项操作视图")
    ,@CodeItem(value="DEPICKUPDATAVIEW",text="实体选择数据视图（部件视图）",realtext="实体选择数据视图（部件视图）")
    ,@CodeItem(value="DEPICKUPGRIDVIEW",text="实体选择表格视图（部件视图）",realtext="实体选择表格视图（部件视图）")
    ,@CodeItem(value="DEPICKUPTREEVIEW",text="实体选择树视图（部件视图）",realtext="实体选择树视图（部件视图）")
    ,@CodeItem(value="DEPICKUPVIEW",text="实体数据选择视图",realtext="实体数据选择视图")
    ,@CodeItem(value="DEPICKUPVIEW2",text="实体数据选择视图（左右关系）",realtext="实体数据选择视图（左右关系）")
    ,@CodeItem(value="DEPORTALVIEW",text="实体数据看板视图",realtext="实体数据看板视图")
    ,@CodeItem(value="DEREDIRECTVIEW",text="实体数据重定向视图",realtext="实体数据重定向视图")
    ,@CodeItem(value="DEREPORTVIEW",text="实体报表视图",realtext="实体报表视图")
    ,@CodeItem(value="DETABEXPVIEW",text="实体分页导航视图",realtext="实体分页导航视图")
    ,@CodeItem(value="DETREEEXPVIEW",text="实体树导航视图",realtext="实体树导航视图")
    ,@CodeItem(value="DETREEEXPVIEW2",text="实体树导航视图（IFrame）",realtext="实体树导航视图（IFrame）")
    ,@CodeItem(value="DETREEEXPVIEW3",text="实体树导航视图（菜单模式）",realtext="实体树导航视图（菜单模式）")
    ,@CodeItem(value="DETREEGRIDVIEW9",text="实体树表格视图（嵌入）",realtext="实体树表格视图（嵌入）")
    ,@CodeItem(value="DETREEVIEW",text="实体树视图",realtext="实体树视图")
    ,@CodeItem(value="DETREEVIEW9",text="实体树视图（嵌入）",realtext="实体树视图（嵌入）")
    ,@CodeItem(value="DEWFACTIONVIEW",text="实体工作流操作视图",realtext="实体工作流操作视图")
    ,@CodeItem(value="DEWFDATAREDIRECTVIEW",text="实体全局流程数据重定向视图",realtext="实体全局流程数据重定向视图")
    ,@CodeItem(value="DEWFEDITVIEW",text="实体工作流编辑视图",realtext="实体工作流编辑视图")
    ,@CodeItem(value="DEWFEDITVIEW2",text="实体工作流编辑视图（左右关系）",realtext="实体工作流编辑视图（左右关系）")
    ,@CodeItem(value="DEWFEDITVIEW3",text="实体工作流视图（分页关系）",realtext="实体工作流视图（分页关系）")
    ,@CodeItem(value="DEWFEXPVIEW",text="实体工作流导航视图",realtext="实体工作流导航视图")
    ,@CodeItem(value="DEWFGRIDVIEW",text="实体工作流表格视图",realtext="实体工作流表格视图")
    ,@CodeItem(value="DEWFSTARTVIEW",text="实体工作流启动视图",realtext="实体工作流启动视图")
    ,@CodeItem(value="DEWIZARDVIEW",text="实体向导视图",realtext="实体向导视图")
})


/**
 * 静态代码表[动态视图类型]模型基类
 */
public abstract class DynaViewTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  应用首页视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String APPINDEXVIEW = "APPINDEXVIEW";
    /**
     *  应用门户视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String APPPORTALVIEW = "APPPORTALVIEW";
    /**
     *  实体图表视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DECHARTVIEW = "DECHARTVIEW";
    /**
     *  实体自定义视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DECUSTOMVIEW = "DECUSTOMVIEW";
    /**
     *  实体数据视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEDATAVIEW = "DEDATAVIEW";
    /**
     *  实体编辑视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEEDITVIEW = "DEEDITVIEW";
    /**
     *  实体编辑视图（左右关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEEDITVIEW2 = "DEEDITVIEW2";
    /**
     *  实体编辑视图（分页关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEEDITVIEW3 = "DEEDITVIEW3";
    /**
     *  实体编辑视图（上下关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEEDITVIEW4 = "DEEDITVIEW4";
    /**
     *  实体编辑视图（嵌入），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEEDITVIEW9 = "DEEDITVIEW9";
    /**
     *  实体表单选择数据视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEFORMPICKUPDATAVIEW = "DEFORMPICKUPDATAVIEW";
    /**
     *  实体表格视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEGRIDVIEW = "DEGRIDVIEW";
    /**
     *  实体表格视图（左右关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEGRIDVIEW2 = "DEGRIDVIEW2";
    /**
     *  实体表格视图（上下关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEGRIDVIEW4 = "DEGRIDVIEW4";
    /**
     *  实体关系数据表格视图（嵌入），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEGRIDVIEW8 = "DEGRIDVIEW8";
    /**
     *  实体表格视图（嵌入），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEGRIDVIEW9 = "DEGRIDVIEW9";
    /**
     *  实体HTML视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEHTMLVIEW = "DEHTMLVIEW";
    /**
     *  实体索引关系选择数据视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEINDEXPICKUPDATAVIEW = "DEINDEXPICKUPDATAVIEW";
    /**
     *  实体首页视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEINDEXVIEW = "DEINDEXVIEW";
    /**
     *  实体多数据自定义视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMDCUSTOMVIEW = "DEMDCUSTOMVIEW";
    /**
     *  实体多表单编辑视图（嵌入），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMEDITVIEW9 = "DEMEDITVIEW9";
    /**
     *  实体移动端自定义视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBCUSTOMVIEW = "DEMOBCUSTOMVIEW";
    /**
     *  实体移动端编辑视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBEDITVIEW = "DEMOBEDITVIEW";
    /**
     *  实体移动端表单类型选择多数据视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBFORMPICKUPMDVIEW = "DEMOBFORMPICKUPMDVIEW";
    /**
     *  实体移动端索引类型选择多数据视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBINDEXPICKUPMDVIEW = "DEMOBINDEXPICKUPMDVIEW";
    /**
     *  实体移动端列表视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBLISTVIEW = "DEMOBLISTVIEW";
    /**
     *  实体移动端多数据视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBMDVIEW = "DEMOBMDVIEW";
    /**
     *  实体移动端多数据视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBMDVIEW9 = "DEMOBMDVIEW9";
    /**
     *  实体移动端多数据选择视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBMPICKUPVIEW = "DEMOBMPICKUPVIEW";
    /**
     *  实体移动端选择列表视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBPICKUPLISTVIEW = "DEMOBPICKUPLISTVIEW";
    /**
     *  实体移动端选择多数据视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBPICKUPMDVIEW = "DEMOBPICKUPMDVIEW";
    /**
     *  实体移动端选择树视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBPICKUPTREEVIEW = "DEMOBPICKUPTREEVIEW";
    /**
     *  实体移动端数据选择视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBPICKUPVIEW = "DEMOBPICKUPVIEW";
    /**
     *  实体移动端分页导航视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBTABEXPVIEW = "DEMOBTABEXPVIEW";
    /**
     *  实体移动端树视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBTREEVIEW = "DEMOBTREEVIEW";
    /**
     *  实体移动端工作流操作视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBWFACTIONVIEW = "DEMOBWFACTIONVIEW";
    /**
     *  实体移动端工作流编辑视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBWFEDITVIEW = "DEMOBWFEDITVIEW";
    /**
     *  实体移动端工作流编辑视图（分页关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBWFEDITVIEW3 = "DEMOBWFEDITVIEW3";
    /**
     *  实体移动端工作流多数据视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBWFMDVIEW = "DEMOBWFMDVIEW";
    /**
     *  实体移动端工作流启动视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMOBWFSTARTVIEW = "DEMOBWFSTARTVIEW";
    /**
     *  实体数据多项选择视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMPICKUPVIEW = "DEMPICKUPVIEW";
    /**
     *  实体多项数据选择视图（左右关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEMPICKUPVIEW2 = "DEMPICKUPVIEW2";
    /**
     *  实体选项操作视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEOPTVIEW = "DEOPTVIEW";
    /**
     *  实体选择数据视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEPICKUPDATAVIEW = "DEPICKUPDATAVIEW";
    /**
     *  实体选择表格视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEPICKUPGRIDVIEW = "DEPICKUPGRIDVIEW";
    /**
     *  实体选择树视图（部件视图），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEPICKUPTREEVIEW = "DEPICKUPTREEVIEW";
    /**
     *  实体数据选择视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEPICKUPVIEW = "DEPICKUPVIEW";
    /**
     *  实体数据选择视图（左右关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEPICKUPVIEW2 = "DEPICKUPVIEW2";
    /**
     *  实体数据看板视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEPORTALVIEW = "DEPORTALVIEW";
    /**
     *  实体数据重定向视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEREDIRECTVIEW = "DEREDIRECTVIEW";
    /**
     *  实体报表视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEREPORTVIEW = "DEREPORTVIEW";
    /**
     *  实体分页导航视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DETABEXPVIEW = "DETABEXPVIEW";
    /**
     *  实体树导航视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DETREEEXPVIEW = "DETREEEXPVIEW";
    /**
     *  实体树导航视图（IFrame），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DETREEEXPVIEW2 = "DETREEEXPVIEW2";
    /**
     *  实体树导航视图（菜单模式），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DETREEEXPVIEW3 = "DETREEEXPVIEW3";
    /**
     *  实体树表格视图（嵌入），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DETREEGRIDVIEW9 = "DETREEGRIDVIEW9";
    /**
     *  实体树视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DETREEVIEW = "DETREEVIEW";
    /**
     *  实体树视图（嵌入），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DETREEVIEW9 = "DETREEVIEW9";
    /**
     *  实体工作流操作视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWFACTIONVIEW = "DEWFACTIONVIEW";
    /**
     *  实体全局流程数据重定向视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWFDATAREDIRECTVIEW = "DEWFDATAREDIRECTVIEW";
    /**
     *  实体工作流编辑视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWFEDITVIEW = "DEWFEDITVIEW";
    /**
     *  实体工作流编辑视图（左右关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWFEDITVIEW2 = "DEWFEDITVIEW2";
    /**
     *  实体工作流视图（分页关系），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWFEDITVIEW3 = "DEWFEDITVIEW3";
    /**
     *  实体工作流导航视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWFEXPVIEW = "DEWFEXPVIEW";
    /**
     *  实体工作流表格视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWFGRIDVIEW = "DEWFGRIDVIEW";
    /**
     *  实体工作流启动视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWFSTARTVIEW = "DEWFSTARTVIEW";
    /**
     *  实体向导视图，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DEWIZARDVIEW = "DEWIZARDVIEW";

    public DynaViewTypeCodeListModelBase() {
        super();
        this.initAnnotation(DynaViewTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DynaViewTypeCodeListModel");
    }

}