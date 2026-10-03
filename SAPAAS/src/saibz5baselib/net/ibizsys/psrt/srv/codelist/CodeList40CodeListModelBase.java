/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="279fd872b7376ddb13d270deb30c9227",name="周期时间类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="MONTH",text="月度",realtext="月度" )
    ,@CodeItem(value="SEASON",text="季度",realtext="季度" )
    ,@CodeItem(value="WEEK",text="周",realtext="周" )
    ,@CodeItem(value="DAY",text="天",realtext="天" )
})


/**
 * 静态代码表[周期时间类型]模型基类
 */
public abstract class CodeList40CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  月度
     */
    public final static String MONTH = "MONTH";
    /**
     *  季度
     */
    public final static String SEASON = "SEASON";
    /**
     *  周
     */
    public final static String WEEK = "WEEK";
    /**
     *  天
     */
    public final static String DAY = "DAY";


    public CodeList40CodeListModelBase() {
        super();
        this.initAnnotation(CodeList40CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList40CodeListModel", this);
    }

}