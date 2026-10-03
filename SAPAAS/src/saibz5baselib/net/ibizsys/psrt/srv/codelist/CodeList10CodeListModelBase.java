/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="163d7a399f7cd62f8854e18bf933d926",name="实体数据操作",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="INSERT",text="插入",realtext="插入" )
    ,@CodeItem(value="UPDATE",text="更新",realtext="更新" )
    ,@CodeItem(value="DELETE",text="删除",realtext="删除" )
    ,@CodeItem(value="SELECT",text="简单查询",realtext="简单查询" )
    ,@CodeItem(value="CUSTOMCALL",text="自定义",realtext="自定义" )
    ,@CodeItem(value="CUSTOMPROCCALL",text="自定义存储过程",realtext="自定义存储过程" )
})


/**
 * 静态代码表[实体数据操作]模型基类
 */
public abstract class CodeList10CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  插入
     */
    public final static String INSERT = "INSERT";
    /**
     *  更新
     */
    public final static String UPDATE = "UPDATE";
    /**
     *  删除
     */
    public final static String DELETE = "DELETE";
    /**
     *  简单查询
     */
    public final static String SELECT = "SELECT";
    /**
     *  自定义
     */
    public final static String CUSTOMCALL = "CUSTOMCALL";
    /**
     *  自定义存储过程
     */
    public final static String CUSTOMPROCCALL = "CUSTOMPROCCALL";


    public CodeList10CodeListModelBase() {
        super();
        this.initAnnotation(CodeList10CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList10CodeListModel", this);
    }

}