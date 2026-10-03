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


@CodeList(id="70ba65aab4ff63fee8ce5fa67c686b71",name="任务时刻策略月天类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="EVERY",text="每天",realtext="每天")
    ,@CodeItem(value="SOME",text="指定天",realtext="指定天")
    ,@CodeItem(value="NONE",text="不指定",realtext="不指定")
})


/**
 * 静态代码表[任务时刻策略月天类型]模型基类
 */
public abstract class TSMonthDayTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  每天，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String EVERY = "EVERY";
    /**
     *  指定天，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String SOME = "SOME";
    /**
     *  不指定，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String NONE = "NONE";

    public TSMonthDayTypeCodeListModelBase() {
        super();
        this.initAnnotation(TSMonthDayTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMonthDayTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMonthDayTypeCodeListModel");
    }

}