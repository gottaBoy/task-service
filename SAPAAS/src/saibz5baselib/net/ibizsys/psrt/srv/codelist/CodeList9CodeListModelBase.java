/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="4bff90297bbb99646628959ec2da43e7",name="表格列构建器",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="NUMBER",text="数值",realtext="数值" )
    ,@CodeItem(value="CODELIST",text="代码表",realtext="代码表" )
})


/**
 * 静态代码表[表格列构建器]模型基类
 */
public abstract class CodeList9CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  数值
     */
    public final static String NUMBER = "NUMBER";
    /**
     *  代码表
     */
    public final static String CODELIST = "CODELIST";


    public CodeList9CodeListModelBase() {
        super();
        this.initAnnotation(CodeList9CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList9CodeListModel", this);
    }

}