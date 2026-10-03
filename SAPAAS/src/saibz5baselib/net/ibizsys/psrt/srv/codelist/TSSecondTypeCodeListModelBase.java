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


@CodeList(id="d656f8b0316953dca1efb2cb139b1423",name="任务时刻策略秒钟类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="ZERO",text="0秒",realtext="0秒")
    ,@CodeItem(value="EVERY",text="每秒钟",realtext="每秒钟")
    ,@CodeItem(value="SOME",text="指定秒钟",realtext="指定秒钟")
})


/**
 * 静态代码表[任务时刻策略秒钟类型]模型基类
 */
public abstract class TSSecondTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  0秒，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ZERO = "ZERO";
    /**
     *  每秒钟，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String EVERY = "EVERY";
    /**
     *  指定秒钟，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String SOME = "SOME";

    public TSSecondTypeCodeListModelBase() {
        super();
        this.initAnnotation(TSSecondTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TSSecondTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.TSSecondTypeCodeListModel");
    }

}