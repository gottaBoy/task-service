/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.StaticCodeListModelBase;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="1e8acf2ededdd5ba8c440d940b493ef1",name="消息模板内容类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="TEXT",text="纯文本",realtext="纯文本")
    ,@CodeItem(value="HTML",text="HTML网页",realtext="HTML网页")
})


/**
 * 静态代码表[消息模板内容类型]模型基类
 */
public abstract class MsgContentTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  纯文本，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String TEXT = "TEXT";
    /**
     *  HTML网页，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String HTML = "HTML";

    public MsgContentTypeCodeListModelBase() {
        super();
        this.initAnnotation(MsgContentTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.MsgContentTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.MsgContentTypeCodeListModel");
    }

}