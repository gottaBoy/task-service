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


@CodeList(id="68e95831f1ab736026fab82cca2e7b7e",name="任务时刻月周",type="STATIC",userscope=false,emptytext="未定义",ormode="STR",valueseparator=",",textseparator=",")

@CodeItems({
    @CodeItem(value="2",text="星期一",realtext="星期一")
    ,@CodeItem(value="3",text="星期二",realtext="星期二")
    ,@CodeItem(value="4",text="星期三",realtext="星期三")
    ,@CodeItem(value="5",text="星期四",realtext="星期四")
    ,@CodeItem(value="6",text="星期五",realtext="星期五")
    ,@CodeItem(value="7",text="星期六",realtext="星期六")
    ,@CodeItem(value="1",text="星期日",realtext="星期日")
})


/**
 * 静态代码表[任务时刻月周]模型基类
 */
public abstract class TSWeekCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  星期一，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_2 = "2";
    /**
     *  星期二，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_3 = "3";
    /**
     *  星期三，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_4 = "4";
    /**
     *  星期四，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_5 = "5";
    /**
     *  星期五，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_6 = "6";
    /**
     *  星期六，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_7 = "7";
    /**
     *  星期日，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_1 = "1";

    public TSWeekCodeListModelBase() {
        super();
        this.initAnnotation(TSWeekCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSWeekCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSWeekCodeListModel");
    }

}