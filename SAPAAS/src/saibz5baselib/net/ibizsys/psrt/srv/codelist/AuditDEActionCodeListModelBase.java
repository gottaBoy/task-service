/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="d54260d064a4fea75dd5e1ee7b812790",name="审计操作行为",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CREATE",text="建立",realtext="建立")
    ,@CodeItem(value="UPDATE",text="更新",realtext="更新")
    ,@CodeItem(value="DELETE",text="删除",realtext="删除")
})


/**
 * 静态代码表[审计操作行为]模型基类
 */
public abstract class AuditDEActionCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  建立，注意：值为对象值，不能直接用于 == 比较
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

    public AuditDEActionCodeListModelBase() {
        super();
        this.initAnnotation(AuditDEActionCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.AuditDEActionCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.AuditDEActionCodeListModel");
    }

}