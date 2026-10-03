/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="e54566dfbea72b8c8a3d81406b8eb759",name="页面样式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="0",text="跳转处理界面",realtext="跳转处理界面" )
    ,@CodeItem(value="1",text="数据编辑界面",realtext="数据编辑界面" )
    ,@CodeItem(value="2",text="数据表格界面",realtext="数据表格界面" )
    ,@CodeItem(value="9",text="数据树形界面",realtext="数据树形界面" )
    ,@CodeItem(value="3",text="数据选择界面",realtext="数据选择界面" )
    ,@CodeItem(value="4",text="工作流数据编辑界面",realtext="工作流数据编辑界面" )
    ,@CodeItem(value="5",text="工作流表格界面",realtext="工作流表格界面" )
    ,@CodeItem(value="6",text="工作流管理表格界面",realtext="工作流管理表格界面" )
    ,@CodeItem(value="7",text="导航界面",realtext="导航界面" )
    ,@CodeItem(value="8",text="信息展示界面",realtext="信息展示界面" )
})


/**
 * 静态代码表[页面样式]模型基类
 */
public abstract class CodeList22CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  跳转处理界面
     */
    public final static String ITEM_0 = "0";
    /**
     *  数据编辑界面
     */
    public final static String ITEM_1 = "1";
    /**
     *  数据表格界面
     */
    public final static String ITEM_2 = "2";
    /**
     *  数据树形界面
     */
    public final static String ITEM_9 = "9";
    /**
     *  数据选择界面
     */
    public final static String ITEM_3 = "3";
    /**
     *  工作流数据编辑界面
     */
    public final static String ITEM_4 = "4";
    /**
     *  工作流表格界面
     */
    public final static String ITEM_5 = "5";
    /**
     *  工作流管理表格界面
     */
    public final static String ITEM_6 = "6";
    /**
     *  导航界面
     */
    public final static String ITEM_7 = "7";
    /**
     *  信息展示界面
     */
    public final static String ITEM_8 = "8";


    public CodeList22CodeListModelBase() {
        super();
        this.initAnnotation(CodeList22CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList22CodeListModel", this);
    }

}