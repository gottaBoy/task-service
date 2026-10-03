/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="bb6e831c02e4811de3a22a995d9f2d12",name="数据通知类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="TIME",text="定时",realtext="定时" )
    ,@CodeItem(value="NORMAL",text="值变更",realtext="值变更" )
    ,@CodeItem(value="TIMEEX",text="定时+值判断",realtext="定时+值判断" )
})


/**
 * 静态代码表[数据通知类型]模型基类
 */
public abstract class CodeList61CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  定时
     */
    public final static String TIME = "TIME";
    /**
     *  值变更
     */
    public final static String NORMAL = "NORMAL";
    /**
     *  定时+值判断
     */
    public final static String TIMEEX = "TIMEEX";


    public CodeList61CodeListModelBase() {
        super();
        this.initAnnotation(CodeList61CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList61CodeListModel", this);
    }

}