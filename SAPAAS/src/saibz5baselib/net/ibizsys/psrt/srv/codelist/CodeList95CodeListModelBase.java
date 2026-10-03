/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="1b0fc14560be977c47f0fa3463cd09df",name="同构汇总表时间维度",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="MINUTE",text="每分钟",realtext="每分钟" )
    ,@CodeItem(value="MINUTE15",text="15分钟",realtext="15分钟" )
    ,@CodeItem(value="MINUTE05",text="5分钟",realtext="5分钟" )
    ,@CodeItem(value="HOUR",text="每小时",realtext="每小时" )
    ,@CodeItem(value="DAY",text="每天",realtext="每天" )
    ,@CodeItem(value="MONTH",text="每月",realtext="每月" )
    ,@CodeItem(value="SEASON",text="每季度",realtext="每季度" )
})


/**
 * 静态代码表[同构汇总表时间维度]模型基类
 */
public abstract class CodeList95CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  每分钟
     */
    public final static String MINUTE = "MINUTE";
    /**
     *  15分钟
     */
    public final static String MINUTE15 = "MINUTE15";
    /**
     *  5分钟
     */
    public final static String MINUTE05 = "MINUTE05";
    /**
     *  每小时
     */
    public final static String HOUR = "HOUR";
    /**
     *  每天
     */
    public final static String DAY = "DAY";
    /**
     *  每月
     */
    public final static String MONTH = "MONTH";
    /**
     *  每季度
     */
    public final static String SEASON = "SEASON";


    public CodeList95CodeListModelBase() {
        super();
        this.initAnnotation(CodeList95CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList95CodeListModel", this);
    }

}