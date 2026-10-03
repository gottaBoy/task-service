/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0fc12871fdb34f9175e0b596e64d3d65",name="实体属性访问控制",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="NONE",text="无",realtext="无")
    ,@CodeItem(value="READ",text="读取",realtext="读取")
    ,@CodeItem(value="UPDATE",text="更新",realtext="更新")
})


/**
 * 静态代码表[实体属性访问控制]模型基类
 */
public abstract class DEFieldAccModeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  无，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String NONE = "NONE";
    /**
     *  读取，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String READ = "READ";
    /**
     *  更新，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String UPDATE = "UPDATE";

    public DEFieldAccModeCodeListModelBase() {
        super();
        this.initAnnotation(DEFieldAccModeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DEFieldAccModeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DEFieldAccModeCodeListModel");
    }

}