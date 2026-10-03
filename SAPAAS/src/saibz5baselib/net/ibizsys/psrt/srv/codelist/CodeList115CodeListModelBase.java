/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="bd8c17546daf9605625319a4751a1e2e",name="开发数据版本控制状态",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CHECKIN",text="签入",realtext="签入" )
    ,@CodeItem(value="CHECKOUT",text="签出",realtext="签出" )
})


/**
 * 静态代码表[开发数据版本控制状态]模型基类
 */
public abstract class CodeList115CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  签入
     */
    public final static String CHECKIN = "CHECKIN";
    /**
     *  签出
     */
    public final static String CHECKOUT = "CHECKOUT";


    public CodeList115CodeListModelBase() {
        super();
        this.initAnnotation(CodeList115CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList115CodeListModel", this);
    }

}