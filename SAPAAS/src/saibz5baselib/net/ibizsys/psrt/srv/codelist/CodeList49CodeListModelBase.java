/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="81e4a2fad174062abec0154ca7ee92cc",name="工作时间代码表",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="WORKTIME_WEEK1",text="每周一至每周五，9～12，13～18",realtext="每周一至每周五，9～12，13～18" )
})


/**
 * 静态代码表[工作时间代码表]模型基类
 */
public abstract class CodeList49CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  每周一至每周五，9～12，13～18
     */
    public final static String WORKTIME_WEEK1 = "WORKTIME_WEEK1";


    public CodeList49CodeListModelBase() {
        super();
        this.initAnnotation(CodeList49CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList49CodeListModel", this);
    }

}