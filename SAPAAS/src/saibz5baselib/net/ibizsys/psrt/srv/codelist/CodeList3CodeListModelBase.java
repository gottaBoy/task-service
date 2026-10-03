/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="369c29b3d93c0a32f9954712be7a1697",name="实体属性表单默认值类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="SESSION",text="用户全局对象",realtext="用户全局对象" )
    ,@CodeItem(value="APPLICATION",text="系统全局对象",realtext="系统全局对象" )
    ,@CodeItem(value="UNIQUEID",text="唯一编码",realtext="唯一编码" )
    ,@CodeItem(value="CONTEXT",text="网页请求",realtext="网页请求" )
    ,@CodeItem(value="PARAM",text="数据对象属性",realtext="数据对象属性" )
    ,@CodeItem(value="OPERATOR",text="当前操作用户(编号)",realtext="当前操作用户(编号)" )
    ,@CodeItem(value="OPERATORNAME",text="当前操作用户(名称)",realtext="当前操作用户(名称)" )
    ,@CodeItem(value="CURTIME",text="当前时间",realtext="当前时间" )
})


/**
 * 静态代码表[实体属性表单默认值类型]模型基类
 */
public abstract class CodeList3CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  用户全局对象
     */
    public final static String SESSION = "SESSION";
    /**
     *  系统全局对象
     */
    public final static String APPLICATION = "APPLICATION";
    /**
     *  唯一编码
     */
    public final static String UNIQUEID = "UNIQUEID";
    /**
     *  网页请求
     */
    public final static String CONTEXT = "CONTEXT";
    /**
     *  数据对象属性
     */
    public final static String PARAM = "PARAM";
    /**
     *  当前操作用户(编号)
     */
    public final static String OPERATOR = "OPERATOR";
    /**
     *  当前操作用户(名称)
     */
    public final static String OPERATORNAME = "OPERATORNAME";
    /**
     *  当前时间
     */
    public final static String CURTIME = "CURTIME";


    public CodeList3CodeListModelBase() {
        super();
        this.initAnnotation(CodeList3CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList3CodeListModel", this);
    }

}