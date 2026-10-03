/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="a0e59420bbf0cd26b7e7e4ad5e8029f9",name="实体数据库操作",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="INSERT",text="插入",realtext="插入" )
    ,@CodeItem(value="UPDATE",text="更新",realtext="更新" )
    ,@CodeItem(value="SELECT",text="查询",realtext="查询" )
    ,@CodeItem(value="DELETE",text="删除",realtext="删除" )
    ,@CodeItem(value="CUSTOM",text="自定义",realtext="自定义" )
})


/**
 * 静态代码表[实体数据库操作]模型基类
 */
public abstract class CodeList53CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  插入
     */
    public final static String INSERT = "INSERT";
    /**
     *  更新
     */
    public final static String UPDATE = "UPDATE";
    /**
     *  查询
     */
    public final static String SELECT = "SELECT";
    /**
     *  删除
     */
    public final static String DELETE = "DELETE";
    /**
     *  自定义
     */
    public final static String CUSTOM = "CUSTOM";


    public CodeList53CodeListModelBase() {
        super();
        this.initAnnotation(CodeList53CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList53CodeListModel", this);
    }

}