/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="47c76377e18ef3bf9c6addef69400fce",name="数据通知_时间条件",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="BEFORE",text="之前",realtext="之前" )
    ,@CodeItem(value="AFTER",text="之后",realtext="之后" )
})


/**
 * 静态代码表[数据通知_时间条件]模型基类
 */
public abstract class CodeList62CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  之前
     */
    public final static String BEFORE = "BEFORE";
    /**
     *  之后
     */
    public final static String AFTER = "AFTER";


    public CodeList62CodeListModelBase() {
        super();
        this.initAnnotation(CodeList62CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList62CodeListModel", this);
    }

}