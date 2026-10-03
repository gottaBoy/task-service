/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="69d6560670dc4808adaf59b3b81382a6",name="数据库操作",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="INSERT",text="插入",realtext="插入" )
    ,@CodeItem(value="UPDATE",text="更新",realtext="更新" )
    ,@CodeItem(value="DELETE",text="删除",realtext="删除" )
})


/**
 * 静态代码表[数据库操作]模型基类
 */
public abstract class CodeList89CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

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


    public CodeList89CodeListModelBase() {
        super();
        this.initAnnotation(CodeList89CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList89CodeListModel", this);
    }

}