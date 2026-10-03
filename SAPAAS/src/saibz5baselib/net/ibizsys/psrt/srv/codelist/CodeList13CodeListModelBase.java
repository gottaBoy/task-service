/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="c47cdacce46ae8a902910751fd93f6d2",name="属性预定义值规则",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="INT",text="整数",realtext="整数" )
    ,@CodeItem(value="POSITIVEINT",text="正整数",realtext="正整数" ,parentvalue="INT")
    ,@CodeItem(value="STRING",text="字符串",realtext="字符串" )
    ,@CodeItem(value="STRING_EMAIL",text="电子邮件",realtext="电子邮件" ,parentvalue="STRING")
    ,@CodeItem(value="FLOAT",text="浮点数",realtext="浮点数" )
    ,@CodeItem(value="FLOAT_PERCENT",text="百分比数值(0~100)",realtext="百分比数值(0~100)" ,parentvalue="FLOAT")
    ,@CodeItem(value="DATETIME",text="日期时间",realtext="日期时间" )
    ,@CodeItem(value="DATETIME_GTNOW",text="大于当天时间",realtext="大于当天时间" ,parentvalue="DATETIME")
    ,@CodeItem(value="DATETIME_GTNOWNOHOUR",text="大于当天日期",realtext="大于当天日期" ,parentvalue="DATETIME")
    ,@CodeItem(value="DATETIME_GTNOW3DAY",text="后3天",realtext="后3天" ,parentvalue="DATETIME")
})


/**
 * 静态代码表[属性预定义值规则]模型基类
 */
public abstract class CodeList13CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  整数
     */
    public final static String INT = "INT";
    /**
     *  正整数
     */
    public final static String POSITIVEINT = "POSITIVEINT";
    /**
     *  字符串
     */
    public final static String STRING = "STRING";
    /**
     *  电子邮件
     */
    public final static String STRING_EMAIL = "STRING_EMAIL";
    /**
     *  浮点数
     */
    public final static String FLOAT = "FLOAT";
    /**
     *  百分比数值(0~100)
     */
    public final static String FLOAT_PERCENT = "FLOAT_PERCENT";
    /**
     *  日期时间
     */
    public final static String DATETIME = "DATETIME";
    /**
     *  大于当天时间
     */
    public final static String DATETIME_GTNOW = "DATETIME_GTNOW";
    /**
     *  大于当天日期
     */
    public final static String DATETIME_GTNOWNOHOUR = "DATETIME_GTNOWNOHOUR";
    /**
     *  后3天
     */
    public final static String DATETIME_GTNOW3DAY = "DATETIME_GTNOW3DAY";


    public CodeList13CodeListModelBase() {
        super();
        this.initAnnotation(CodeList13CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList13CodeListModel", this);
    }

}