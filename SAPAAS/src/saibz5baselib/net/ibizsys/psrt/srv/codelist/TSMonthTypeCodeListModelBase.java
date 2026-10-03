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


@CodeList(id="c7d219f186cee41ed8bbea15fcaa5528",name="任务时刻策略月类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="EVERY",text="每月",realtext="每月")
    ,@CodeItem(value="SOME",text="指定月",realtext="指定月")
})


/**
 * 静态代码表[任务时刻策略月类型]模型基类
 */
public abstract class TSMonthTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  每月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String EVERY = "EVERY";
    /**
     *  指定月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String SOME = "SOME";

    public TSMonthTypeCodeListModelBase() {
        super();
        this.initAnnotation(TSMonthTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMonthTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMonthTypeCodeListModel");
    }

}