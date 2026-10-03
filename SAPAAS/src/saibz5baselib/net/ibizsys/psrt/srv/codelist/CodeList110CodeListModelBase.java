/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="cb40f89c998132ba192bca103ba680ef",name="实体规则处理_值处理函数",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DATE_DIFF_D",text="距今天数（日期）",realtext="距今天数（日期）" )
    ,@CodeItem(value="DATE_DIFF_W",text="距今周数（日期）",realtext="距今周数（日期）" )
    ,@CodeItem(value="DATE_DIFF_M",text="距今月份数（日期）",realtext="距今月份数（日期）" )
    ,@CodeItem(value="DATE_DIFF_Q",text="距今季度数（日期）",realtext="距今季度数（日期）" )
    ,@CodeItem(value="DATE_DIFF_Y",text="距今年数（日期）",realtext="距今年数（日期）" )
})


/**
 * 静态代码表[实体规则处理_值处理函数]模型基类
 */
public abstract class CodeList110CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  距今天数（日期）
     */
    public final static String DATE_DIFF_D = "DATE_DIFF_D";
    /**
     *  距今周数（日期）
     */
    public final static String DATE_DIFF_W = "DATE_DIFF_W";
    /**
     *  距今月份数（日期）
     */
    public final static String DATE_DIFF_M = "DATE_DIFF_M";
    /**
     *  距今季度数（日期）
     */
    public final static String DATE_DIFF_Q = "DATE_DIFF_Q";
    /**
     *  距今年数（日期）
     */
    public final static String DATE_DIFF_Y = "DATE_DIFF_Y";


    public CodeList110CodeListModelBase() {
        super();
        this.initAnnotation(CodeList110CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList110CodeListModel", this);
    }

}