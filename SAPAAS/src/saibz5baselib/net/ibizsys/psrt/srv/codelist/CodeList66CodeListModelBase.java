/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="48f8fa9e84cb9134562d9034af8ce962",name="数据库触发器事件",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="INSERT",text="Insert",realtext="Insert" )
    ,@CodeItem(value="UPDATE",text="Update",realtext="Update" )
    ,@CodeItem(value="DELETE",text="Delete",realtext="Delete" )
})


/**
 * 静态代码表[数据库触发器事件]模型基类
 */
public abstract class CodeList66CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  Insert
     */
    public final static String INSERT = "INSERT";
    /**
     *  Update
     */
    public final static String UPDATE = "UPDATE";
    /**
     *  Delete
     */
    public final static String DELETE = "DELETE";


    public CodeList66CodeListModelBase() {
        super();
        this.initAnnotation(CodeList66CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList66CodeListModel", this);
    }

}