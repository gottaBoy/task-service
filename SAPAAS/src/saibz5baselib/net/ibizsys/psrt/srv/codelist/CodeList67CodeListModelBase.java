/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="eb8af7f386769a697bf23b11e4d480b8",name="DB2触发器代码模式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="For Each Row",text="For Each Row",realtext="For Each Row" )
    ,@CodeItem(value="For Each Statement",text="For Each Statement",realtext="For Each Statement" )
})


/**
 * 静态代码表[DB2触发器代码模式]模型基类
 */
public abstract class CodeList67CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  For Each Row
     */
    public final static String FOR_EACH_ROW = "For Each Row";
    /**
     *  For Each Statement
     */
    public final static String FOR_EACH_STATEMENT = "For Each Statement";


    public CodeList67CodeListModelBase() {
        super();
        this.initAnnotation(CodeList67CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList67CodeListModel", this);
    }

}