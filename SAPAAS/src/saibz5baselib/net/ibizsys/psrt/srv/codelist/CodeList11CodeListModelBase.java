/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0c29f7bdeef16549e16a83da2102ef24",name="数据操作步骤",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="USERDECLARE",text="变量定义",realtext="变量定义" )
    ,@CodeItem(value="USERINIT",text="变量初始化",realtext="变量初始化" )
    ,@CodeItem(value="INPUTCHECK",text="数据检查",realtext="数据检查" )
    ,@CodeItem(value="BEFOREACTION",text="操作之前",realtext="操作之前" )
    ,@CodeItem(value="EXECUTEACTION",text="执行操作",realtext="执行操作" )
    ,@CodeItem(value="AFTERACTION",text="操作之后",realtext="操作之后" )
})


/**
 * 静态代码表[数据操作步骤]模型基类
 */
public abstract class CodeList11CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  变量定义
     */
    public final static String USERDECLARE = "USERDECLARE";
    /**
     *  变量初始化
     */
    public final static String USERINIT = "USERINIT";
    /**
     *  数据检查
     */
    public final static String INPUTCHECK = "INPUTCHECK";
    /**
     *  操作之前
     */
    public final static String BEFOREACTION = "BEFOREACTION";
    /**
     *  执行操作
     */
    public final static String EXECUTEACTION = "EXECUTEACTION";
    /**
     *  操作之后
     */
    public final static String AFTERACTION = "AFTERACTION";


    public CodeList11CodeListModelBase() {
        super();
        this.initAnnotation(CodeList11CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList11CodeListModel", this);
    }

}