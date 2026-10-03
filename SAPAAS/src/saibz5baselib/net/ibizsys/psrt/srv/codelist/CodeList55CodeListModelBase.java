/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0bd398af7ee9eb10505c7a11de90596a",name="语言资源类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DEF.LNAME",text="实体属性逻辑名称",realtext="实体属性逻辑名称" )
    ,@CodeItem(value="CL.ITEM.LNAME",text="代码表项",realtext="代码表项" )
    ,@CodeItem(value="TBB.TEXT",text="工具栏按钮文本",realtext="工具栏按钮文本" )
    ,@CodeItem(value="TBB.TOOLTIP",text="工具栏按钮提示",realtext="工具栏按钮提示" )
    ,@CodeItem(value="MENUITEM.CAPTION",text="菜单项文本",realtext="菜单项文本" )
    ,@CodeItem(value="PAGE.HEADER",text="界面头部标题",realtext="界面头部标题" )
    ,@CodeItem(value="PAGE.COMMON",text="界面常规",realtext="界面常规" )
    ,@CodeItem(value="CONTROL",text="控件文本",realtext="控件文本" )
    ,@CodeItem(value="ERROR.STD",text="标准错误",realtext="标准错误" )
    ,@CodeItem(value="CTRL",text="处理逻辑",realtext="处理逻辑" )
    ,@CodeItem(value="COMMON",text="通用",realtext="通用" )
    ,@CodeItem(value="OTHER",text="其它",realtext="其它" )
})


/**
 * 静态代码表[语言资源类型]模型基类
 */
public abstract class CodeList55CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  实体属性逻辑名称
     */
    public final static String DEF_LNAME = "DEF.LNAME";
    /**
     *  代码表项
     */
    public final static String CL_ITEM_LNAME = "CL.ITEM.LNAME";
    /**
     *  工具栏按钮文本
     */
    public final static String TBB_TEXT = "TBB.TEXT";
    /**
     *  工具栏按钮提示
     */
    public final static String TBB_TOOLTIP = "TBB.TOOLTIP";
    /**
     *  菜单项文本
     */
    public final static String MENUITEM_CAPTION = "MENUITEM.CAPTION";
    /**
     *  界面头部标题
     */
    public final static String PAGE_HEADER = "PAGE.HEADER";
    /**
     *  界面常规
     */
    public final static String PAGE_COMMON = "PAGE.COMMON";
    /**
     *  控件文本
     */
    public final static String CONTROL = "CONTROL";
    /**
     *  标准错误
     */
    public final static String ERROR_STD = "ERROR.STD";
    /**
     *  处理逻辑
     */
    public final static String CTRL = "CTRL";
    /**
     *  通用
     */
    public final static String COMMON = "COMMON";
    /**
     *  其它
     */
    public final static String OTHER = "OTHER";


    public CodeList55CodeListModelBase() {
        super();
        this.initAnnotation(CodeList55CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList55CodeListModel", this);
    }

}