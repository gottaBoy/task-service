/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="b19a68e5affe4c7984e6f82124d8eae0",name="文件编码",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="ANSI",text="ANSI",realtext="ANSI" )
    ,@CodeItem(value="UTF-8",text="UTF-8",realtext="UTF-8" )
})


/**
 * 静态代码表[文件编码]模型基类
 */
public abstract class CodeList39CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  ANSI
     */
    public final static String ANSI = "ANSI";
    /**
     *  UTF-8
     */
    public final static String UTF_SUB_8 = "UTF-8";


    public CodeList39CodeListModelBase() {
        super();
        this.initAnnotation(CodeList39CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList39CodeListModel", this);
    }

}