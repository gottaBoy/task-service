/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="11d8d830d8c4a615d926b43ad2df1f70",name="时间维度类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="YM",text="年、月",realtext="年、月" )
    ,@CodeItem(value="YMW",text="年、月、周",realtext="年、月、周" )
    ,@CodeItem(value="YMWD",text="年、月、周、天",realtext="年、月、周、天" )
    ,@CodeItem(value="YMWDH",text="年、月、周、天、小时",realtext="年、月、周、天、小时" )
    ,@CodeItem(value="YMD",text="年、月、天",realtext="年、月、天" )
    ,@CodeItem(value="YMDH",text="年、月、天、小时",realtext="年、月、天、小时" )
    ,@CodeItem(value="YW",text="年、周",realtext="年、周" )
    ,@CodeItem(value="YWD",text="年、周、天",realtext="年、周、天" )
    ,@CodeItem(value="YWDH",text="年、周、天、小时",realtext="年、周、天、小时" )
})


/**
 * 静态代码表[时间维度类型]模型基类
 */
public abstract class CodeList87CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  年、月
     */
    public final static String YM = "YM";
    /**
     *  年、月、周
     */
    public final static String YMW = "YMW";
    /**
     *  年、月、周、天
     */
    public final static String YMWD = "YMWD";
    /**
     *  年、月、周、天、小时
     */
    public final static String YMWDH = "YMWDH";
    /**
     *  年、月、天
     */
    public final static String YMD = "YMD";
    /**
     *  年、月、天、小时
     */
    public final static String YMDH = "YMDH";
    /**
     *  年、周
     */
    public final static String YW = "YW";
    /**
     *  年、周、天
     */
    public final static String YWD = "YWD";
    /**
     *  年、周、天、小时
     */
    public final static String YWDH = "YWDH";


    public CodeList87CodeListModelBase() {
        super();
        this.initAnnotation(CodeList87CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList87CodeListModel", this);
    }

}