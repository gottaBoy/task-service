/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="95136277e4eea61ed9048cf62b703370",name="实体规则处理_操作逻辑",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="=",text="等于",realtext="等于" )
    ,@CodeItem(value="<>",text="不等于",realtext="不等于" )
    ,@CodeItem(value=">=",text="大于等于",realtext="大于等于" )
    ,@CodeItem(value=">",text="大于",realtext="大于" )
    ,@CodeItem(value="<=",text="小于等于",realtext="小于等于" )
    ,@CodeItem(value="<",text="小于",realtext="小于" )
    ,@CodeItem(value="LIKE",text="文本匹配",realtext="文本匹配" )
    ,@CodeItem(value="ISNULL",text="为空",realtext="为空" )
    ,@CodeItem(value="ISNOTNULL",text="不为空",realtext="不为空" )
})


/**
 * 静态代码表[实体规则处理_操作逻辑]模型基类
 */
public abstract class CodeList111CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  等于
     */
    public final static String EQ = "=";
    /**
     *  不等于
     */
    public final static String LTGT = "<>";
    /**
     *  大于等于
     */
    public final static String GTEQ = ">=";
    /**
     *  大于
     */
    public final static String GT = ">";
    /**
     *  小于等于
     */
    public final static String LTEQ = "<=";
    /**
     *  小于
     */
    public final static String LT = "<";
    /**
     *  文本匹配
     */
    public final static String LIKE = "LIKE";
    /**
     *  为空
     */
    public final static String ISNULL = "ISNULL";
    /**
     *  不为空
     */
    public final static String ISNOTNULL = "ISNOTNULL";


    public CodeList111CodeListModelBase() {
        super();
        this.initAnnotation(CodeList111CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList111CodeListModel", this);
    }

}