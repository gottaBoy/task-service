/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="c1362f43a191c5791c535059efcf6dac",name="日历参与者状态",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="UNDECIDED",text="未确定",realtext="未确定" )
    ,@CodeItem(value="ACCEPT",text="接受",realtext="接受" )
    ,@CodeItem(value="REJECT",text="拒绝",realtext="拒绝" )
})


/**
 * 静态代码表[日历参与者状态]模型基类
 */
public abstract class CodeList15CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  未确定
     */
    public final static String UNDECIDED = "UNDECIDED";
    /**
     *  接受
     */
    public final static String ACCEPT = "ACCEPT";
    /**
     *  拒绝
     */
    public final static String REJECT = "REJECT";


    public CodeList15CodeListModelBase() {
        super();
        this.initAnnotation(CodeList15CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList15CodeListModel", this);
    }

}