/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="516d0e18b9dcabdf1f789d5af32b8ec1",name="实体数据处理_数据操作",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="INSERT",text="新建",realtext="新建" )
    ,@CodeItem(value="UPDATE",text="更新",realtext="更新" )
    ,@CodeItem(value="SAVE",text="保存（自动判断）",realtext="保存（自动判断）" )
    ,@CodeItem(value="DELETE",text="删除",realtext="删除" )
    ,@CodeItem(value="CUSTOMCALL",text="自定义调用",realtext="自定义调用" )
    ,@CodeItem(value="CUSTOMPROCCALL",text="自定义存储过程调用",realtext="自定义存储过程调用" )
    ,@CodeItem(value="CUSTOMRAWPROCCALL",text="自定义存储过程调用（全称）",realtext="自定义存储过程调用（全称）" )
    ,@CodeItem(value="GET",text="获取(GET)",realtext="获取(GET)" )
    ,@CodeItem(value="CHECKKEYSTATE",text="检查主键状态(CHECKKEYSTATE)",realtext="检查主键状态(CHECKKEYSTATE)" )
})


/**
 * 静态代码表[实体数据处理_数据操作]模型基类
 */
public abstract class CodeList108CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  新建
     */
    public final static String INSERT = "INSERT";
    /**
     *  更新
     */
    public final static String UPDATE = "UPDATE";
    /**
     *  保存（自动判断）
     */
    public final static String SAVE = "SAVE";
    /**
     *  删除
     */
    public final static String DELETE = "DELETE";
    /**
     *  自定义调用
     */
    public final static String CUSTOMCALL = "CUSTOMCALL";
    /**
     *  自定义存储过程调用
     */
    public final static String CUSTOMPROCCALL = "CUSTOMPROCCALL";
    /**
     *  自定义存储过程调用（全称）
     */
    public final static String CUSTOMRAWPROCCALL = "CUSTOMRAWPROCCALL";
    /**
     *  获取(GET)
     */
    public final static String GET = "GET";
    /**
     *  检查主键状态(CHECKKEYSTATE)
     */
    public final static String CHECKKEYSTATE = "CHECKKEYSTATE";


    public CodeList108CodeListModelBase() {
        super();
        this.initAnnotation(CodeList108CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList108CodeListModel", this);
    }

}