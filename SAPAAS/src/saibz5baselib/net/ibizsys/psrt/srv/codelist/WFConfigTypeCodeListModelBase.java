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


@CodeList(id="d771544aaf079482d32250d80bc4d9b2",name="流程类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="STATIC",text="静态流程",realtext="静态流程")
    ,@CodeItem(value="DYNAMIC",text="动态流程",realtext="动态流程")
})


/**
 * 静态代码表[流程类型]模型基类
 */
public abstract class WFConfigTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  静态流程，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String STATIC = "STATIC";
    /**
     *  动态流程，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DYNAMIC = "DYNAMIC";

    public WFConfigTypeCodeListModelBase() {
        super();
        this.initAnnotation(WFConfigTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFConfigTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFConfigTypeCodeListModel");
    }

}