/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0cc45b174e5994e6475000e524e154d1",name="实体规则处理_数据类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="VARCHAR",text="文本",realtext="文本" )
    ,@CodeItem(value="INT",text="整形",realtext="整形" )
    ,@CodeItem(value="FLOAT",text="浮点",realtext="浮点" )
    ,@CodeItem(value="DATETIME",text="日期",realtext="日期" )
})


/**
 * 静态代码表[实体规则处理_数据类型]模型基类
 */
public abstract class CodeList112CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  文本
     */
    public final static String VARCHAR = "VARCHAR";
    /**
     *  整形
     */
    public final static String INT = "INT";
    /**
     *  浮点
     */
    public final static String FLOAT = "FLOAT";
    /**
     *  日期
     */
    public final static String DATETIME = "DATETIME";


    public CodeList112CodeListModelBase() {
        super();
        this.initAnnotation(CodeList112CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList112CodeListModel", this);
    }

}