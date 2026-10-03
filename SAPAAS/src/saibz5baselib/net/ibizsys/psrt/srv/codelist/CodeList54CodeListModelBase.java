/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="ad1b5c4ab74e4f1bb645257d58586b5b",name="报表输出格式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="PDF",text="PDF",realtext="PDF" )
    ,@CodeItem(value="EXCEL",text="EXCEL",realtext="EXCEL" )
    ,@CodeItem(value="HTML",text="HTML",realtext="HTML" )
})


/**
 * 静态代码表[报表输出格式]模型基类
 */
public abstract class CodeList54CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  PDF
     */
    public final static String PDF = "PDF";
    /**
     *  EXCEL
     */
    public final static String EXCEL = "EXCEL";
    /**
     *  HTML
     */
    public final static String HTML = "HTML";


    public CodeList54CodeListModelBase() {
        super();
        this.initAnnotation(CodeList54CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList54CodeListModel", this);
    }

}