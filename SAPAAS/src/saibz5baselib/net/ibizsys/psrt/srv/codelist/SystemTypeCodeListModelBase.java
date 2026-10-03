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


@CodeList(id="ef52a3b19ff3d2a3940d2c7b76bd5318",name="系统类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="WEB",text="WEB系统",realtext="WEB系统")
    ,@CodeItem(value="CS",text="C/S系统",realtext="C/S系统")
})


/**
 * 静态代码表[系统类型]模型基类
 */
public abstract class SystemTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  WEB系统，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String WEB = "WEB";
    /**
     *  C/S系统，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String CS = "CS";

    public SystemTypeCodeListModelBase() {
        super();
        this.initAnnotation(SystemTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.SystemTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.SystemTypeCodeListModel");
    }

}