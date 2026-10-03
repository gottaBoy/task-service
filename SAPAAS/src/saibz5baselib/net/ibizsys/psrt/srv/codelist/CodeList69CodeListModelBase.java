/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="7e7ebb43ec50bca7337e0512df3b4a24",name="数据通知取值规则",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="AFTER",text="变更后",realtext="变更后" )
    ,@CodeItem(value="BEFORE",text="变更前",realtext="变更前" )
    ,@CodeItem(value="CHANGE",text="值变更",realtext="值变更" )
})


/**
 * 静态代码表[数据通知取值规则]模型基类
 */
public abstract class CodeList69CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  变更后
     */
    public final static String AFTER = "AFTER";
    /**
     *  变更前
     */
    public final static String BEFORE = "BEFORE";
    /**
     *  值变更
     */
    public final static String CHANGE = "CHANGE";


    public CodeList69CodeListModelBase() {
        super();
        this.initAnnotation(CodeList69CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList69CodeListModel", this);
    }

}