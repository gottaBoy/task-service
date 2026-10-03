/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="87f5acf6e2c3b136d0280133a42f2890",name="表单嵌入表格工具栏能力",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="INSERT",text="新建",realtext="新建" )
    ,@CodeItem(value="UPDATE",text="更新",realtext="更新" )
    ,@CodeItem(value="DELETE",text="删除",realtext="删除" )
    ,@CodeItem(value="ROWEDIT",text="启用行编辑",realtext="启用行编辑" )
})


/**
 * 静态代码表[表单嵌入表格工具栏能力]模型基类
 */
public abstract class CodeList77CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  新建
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
     *  启用行编辑
     */
    public final static String ROWEDIT = "ROWEDIT";


    public CodeList77CodeListModelBase() {
        super();
        this.initAnnotation(CodeList77CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList77CodeListModel", this);
    }

}