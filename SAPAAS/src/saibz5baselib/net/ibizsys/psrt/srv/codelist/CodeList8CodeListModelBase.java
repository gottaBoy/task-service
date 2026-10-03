/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="4610c74bc5c254392112c4e93c3bc88b",name="日历、邮件重要程度",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="HIGH",text="高",realtext="高")
    ,@CodeItem(value="NORMAL",text="普通",realtext="普通")
    ,@CodeItem(value="LOW",text="低",realtext="低")
})


/**
 * 静态代码表[日历、邮件重要程度]模型基类
 */
public abstract class CodeList8CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  高
     */
    public final static String HIGH = "HIGH";
    /**
     *  普通
     */
    public final static String NORMAL = "NORMAL";
    /**
     *  低
     */
    public final static String LOW = "LOW";


    public CodeList8CodeListModelBase() {
        super();
        this.initAnnotation(CodeList8CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList8CodeListModel", this);
    }

}