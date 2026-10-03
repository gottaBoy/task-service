/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="c8495a290c2636dfc95ccc621699e17d",name="系统内置菜单",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="SYSTEMDEVELOP",text="系统设计主菜单",realtext="系统设计主菜单" )
    ,@CodeItem(value="DEFAULT4",text="IBIZSYS产品演示主菜单",realtext="IBIZSYS产品演示主菜单" )
    ,@CodeItem(value="EAI",text="EAI主菜单",realtext="EAI主菜单" )
    ,@CodeItem(value="DEFAULT",text="系统默认主菜单",realtext="系统默认主菜单" )
    ,@CodeItem(value="DEFAULT:ZHCN:SL",text="系统默认主菜单(SilverLight，中文)",realtext="系统默认主菜单(SilverLight，中文)" )
    ,@CodeItem(value="GAADMIN",text="正版管理",realtext="正版管理" )
    ,@CodeItem(value="SUBMENU_DEMO1",text="测试菜单",realtext="测试菜单" )
    ,@CodeItem(value="SYSTEMDEVELOP2",text="系统设计主菜单",realtext="系统设计主菜单" )
    ,@CodeItem(value="测试子菜单2",text="测试子菜单2 ",realtext="测试子菜单2 " )
    ,@CodeItem(value="DEFAULT:EN",text="系统默认主菜单",realtext="系统默认主菜单" )
    ,@CodeItem(value="DEFAULT::SL",text="系统默认主菜单(SilverLight，中文)",realtext="系统默认主菜单(SilverLight，中文)" )
    ,@CodeItem(value="DEFAULT::WinRT",text="系统默认主菜单(WinRT，中文)",realtext="系统默认主菜单(WinRT，中文)" )
})


/**
 * 静态代码表[系统内置菜单]模型基类
 */
public abstract class CodeList79CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  系统设计主菜单
     */
    public final static String SYSTEMDEVELOP = "SYSTEMDEVELOP";
    /**
     *  IBIZSYS产品演示主菜单
     */
    public final static String DEFAULT4 = "DEFAULT4";
    /**
     *  EAI主菜单
     */
    public final static String EAI = "EAI";
    /**
     *  系统默认主菜单
     */
    public final static String DEFAULT = "DEFAULT";
    /**
     *  系统默认主菜单(SilverLight，中文)
     */
    public final static String DEFAULT_ZHCN_SL = "DEFAULT:ZHCN:SL";
    /**
     *  正版管理
     */
    public final static String GAADMIN = "GAADMIN";
    /**
     *  测试菜单
     */
    public final static String SUBMENU_DEMO1 = "SUBMENU_DEMO1";
    /**
     *  系统设计主菜单
     */
    public final static String SYSTEMDEVELOP2 = "SYSTEMDEVELOP2";
    /**
     *  测试子菜单2
     */
    public final static String ITEM_9 = "测试子菜单2";
    /**
     *  系统默认主菜单
     */
    public final static String DEFAULT_EN = "DEFAULT:EN";
    /**
     *  系统默认主菜单(SilverLight，中文)
     */
    public final static String DEFAULT_SL = "DEFAULT::SL";
    /**
     *  系统默认主菜单(WinRT，中文)
     */
    public final static String DEFAULT_WINRT = "DEFAULT::WinRT";


    public CodeList79CodeListModelBase() {
        super();
        this.initAnnotation(CodeList79CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList79CodeListModel", this);
    }

}