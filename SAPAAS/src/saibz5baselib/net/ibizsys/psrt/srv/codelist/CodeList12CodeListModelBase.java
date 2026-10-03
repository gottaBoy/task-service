/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="04ebb2b1d0136afcf85aea204da79ef0",name="报表分类",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="REPORTFOLDER_1",text="经营性报表",realtext="经营性报表" )
    ,@CodeItem(value="REPORTFOLDER_2",text="财务报表",realtext="财务报表" )
})


/**
 * 静态代码表[报表分类]模型基类
 */
public abstract class CodeList12CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  经营性报表
     */
    public final static String REPORTFOLDER_1 = "REPORTFOLDER_1";
    /**
     *  财务报表
     */
    public final static String REPORTFOLDER_2 = "REPORTFOLDER_2";


    public CodeList12CodeListModelBase() {
        super();
        this.initAnnotation(CodeList12CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList12CodeListModel", this);
    }

}