/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="402b576dd38baa58e2cdf47659637a1d",name="是否（TRUE，FALSE）",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="TRUE",text="是",realtext="是" )
    ,@CodeItem(value="FALSE",text="否",realtext="否" )
})


/**
 * 静态代码表[是否（TRUE，FALSE）]模型基类
 */
public abstract class TrueFalseCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  是
     */
    public final static String TRUE = "TRUE";
    /**
     *  否
     */
    public final static String FALSE = "FALSE";


    public TrueFalseCodeListModelBase() {
        super();
        this.initAnnotation(TrueFalseCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.TrueFalseCodeListModel", this);
    }

}