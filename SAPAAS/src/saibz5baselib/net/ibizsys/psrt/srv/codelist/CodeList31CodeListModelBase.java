/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="4b18fc77eaf8c1661becc3b67b1067f2",name="开发帮助重要程度",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="LOW",text="低",realtext="低" )
    ,@CodeItem(value="NORMAIL",text="中",realtext="中" )
    ,@CodeItem(value="HIGH",text="高",realtext="高" )
})


/**
 * 静态代码表[开发帮助重要程度]模型基类
 */
public abstract class CodeList31CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  低
     */
    public final static String LOW = "LOW";
    /**
     *  中
     */
    public final static String NORMAIL = "NORMAIL";
    /**
     *  高
     */
    public final static String HIGH = "HIGH";


    public CodeList31CodeListModelBase() {
        super();
        this.initAnnotation(CodeList31CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList31CodeListModel", this);
    }

}