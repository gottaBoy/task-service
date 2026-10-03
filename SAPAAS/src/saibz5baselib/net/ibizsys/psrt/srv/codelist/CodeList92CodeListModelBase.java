/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="157e71b4a6a4aac6300e048b6272dcb2",name="时间分组类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="Q",text="季度",realtext="季度" )
    ,@CodeItem(value="M",text="月份",realtext="月份" )
    ,@CodeItem(value="D",text="月天",realtext="月天" )
    ,@CodeItem(value="H",text="小时",realtext="小时" )
})


/**
 * 静态代码表[时间分组类型]模型基类
 */
public abstract class CodeList92CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  季度
     */
    public final static String Q = "Q";
    /**
     *  月份
     */
    public final static String M = "M";
    /**
     *  月天
     */
    public final static String D = "D";
    /**
     *  小时
     */
    public final static String H = "H";


    public CodeList92CodeListModelBase() {
        super();
        this.initAnnotation(CodeList92CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList92CodeListModel", this);
    }

}