/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0d947aa77b9ea53b3a069eb655d69dc5",name="DA日志操作类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CREATE",text="新建",realtext="新建")
    ,@CodeItem(value="UPDATE",text="更新",realtext="更新")
    ,@CodeItem(value="DELETE",text="删除",realtext="删除")
})


/**
 * 静态代码表[DA日志操作类型]模型基类
 */
public abstract class CodeList24CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  新建，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String CREATE = "CREATE";
    /**
     *  更新，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String UPDATE = "UPDATE";
    /**
     *  删除，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DELETE = "DELETE";

    public CodeList24CodeListModelBase() {
        super();
        this.initAnnotation(CodeList24CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList24CodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList24CodeListModel");
    }

}