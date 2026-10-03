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


@CodeList(id="57e083a5e9c3455f05dc283dc18ce1d0",name="任务时刻表月份",type="STATIC",userscope=false,emptytext="未定义",ormode="STR",valueseparator=",",textseparator=",")

@CodeItems({
    @CodeItem(value="1",text="一月",realtext="一月")
    ,@CodeItem(value="2",text="二月",realtext="二月")
    ,@CodeItem(value="3",text="三月",realtext="三月")
    ,@CodeItem(value="4",text="四月",realtext="四月")
    ,@CodeItem(value="5",text="五月",realtext="五月")
    ,@CodeItem(value="6",text="六月",realtext="六月")
    ,@CodeItem(value="7",text="七月",realtext="七月")
    ,@CodeItem(value="8",text="八月",realtext="八月")
    ,@CodeItem(value="9",text="九月",realtext="九月")
    ,@CodeItem(value="10",text="十月",realtext="十月")
    ,@CodeItem(value="11",text="十一月",realtext="十一月")
    ,@CodeItem(value="12",text="十二月",realtext="十二月")
})


/**
 * 静态代码表[任务时刻表月份]模型基类
 */
public abstract class TSMonthCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  一月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_1 = "1";
    /**
     *  二月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_2 = "2";
    /**
     *  三月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_3 = "3";
    /**
     *  四月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_4 = "4";
    /**
     *  五月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_5 = "5";
    /**
     *  六月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_6 = "6";
    /**
     *  七月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_7 = "7";
    /**
     *  八月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_8 = "8";
    /**
     *  九月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_9 = "9";
    /**
     *  十月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_10 = "10";
    /**
     *  十一月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_11 = "11";
    /**
     *  十二月，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_12 = "12";

    public TSMonthCodeListModelBase() {
        super();
        this.initAnnotation(TSMonthCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSMonthCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSMonthCodeListModel");
    }

}