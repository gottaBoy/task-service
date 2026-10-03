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


@CodeList(id="1e43c9c2b94911ff15708c0d13e66391",name="任务时刻策略月周类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="EVERY",text="每周",realtext="每周")
    ,@CodeItem(value="ONE",text="第一周",realtext="第一周")
    ,@CodeItem(value="TWO",text="第二周",realtext="第二周")
    ,@CodeItem(value="THREE",text="第三周",realtext="第三周")
    ,@CodeItem(value="FOUR",text="第四周",realtext="第四周")
    ,@CodeItem(value="FIVE",text="第五周",realtext="第五周")
    ,@CodeItem(value="NONE",text="不指定",realtext="不指定")
})


/**
 * 静态代码表[任务时刻策略月周类型]模型基类
 */
public abstract class TSMonthWeekTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  每周，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String EVERY = "EVERY";
    /**
     *  第一周，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ONE = "ONE";
    /**
     *  第二周，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String TWO = "TWO";
    /**
     *  第三周，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String THREE = "THREE";
    /**
     *  第四周，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String FOUR = "FOUR";
    /**
     *  第五周，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String FIVE = "FIVE";
    /**
     *  不指定，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String NONE = "NONE";

    public TSMonthWeekTypeCodeListModelBase() {
        super();
        this.initAnnotation(TSMonthWeekTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMonthWeekTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMonthWeekTypeCodeListModel");
    }

}