/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="b7887b6761ae42ad82505631b68dde9d",name="日志级别",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="50000",text="致命(FATAL)",realtext="致命(FATAL)" )
    ,@CodeItem(value="40000",text="错误(ERROR)",realtext="错误(ERROR)" )
    ,@CodeItem(value="30000",text="警告(WARN)",realtext="警告(WARN)" )
    ,@CodeItem(value="20000",text="信息(INFO)",realtext="信息(INFO)" )
    ,@CodeItem(value="10000",text="调试(DEBUG)",realtext="调试(DEBUG)" )
    ,@CodeItem(value="5000",text="调试(TRACE)",realtext="调试(TRACE)" )
})


/**
 * 静态代码表[日志级别]模型基类
 */
public abstract class CodeList32CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  致命(FATAL)
     */
    public final static String ITEM_50000 = "50000";
    /**
     *  错误(ERROR)
     */
    public final static String ITEM_40000 = "40000";
    /**
     *  警告(WARN)
     */
    public final static String ITEM_30000 = "30000";
    /**
     *  信息(INFO)
     */
    public final static String ITEM_20000 = "20000";
    /**
     *  调试(DEBUG)
     */
    public final static String ITEM_10000 = "10000";
    /**
     *  调试(TRACE)
     */
    public final static String ITEM_5000 = "5000";


    public CodeList32CodeListModelBase() {
        super();
        this.initAnnotation(CodeList32CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList32CodeListModel", this);
    }

}