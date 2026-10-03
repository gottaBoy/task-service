/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="cd54f62f7a50f2afc6c83d39183607f7",name="前端展现技术",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="HTML",text="HTML",realtext="HTML" )
    ,@CodeItem(value="SL",text="SilverLight",realtext="SilverLight" )
    ,@CodeItem(value="WinRT",text="WinRT",realtext="WinRT" )
    ,@CodeItem(value="Android",text="Android",realtext="Android" )
    ,@CodeItem(value="IOS",text="IOS",realtext="IOS" )
})


/**
 * 静态代码表[前端展现技术]模型基类
 */
public abstract class CodeList96CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  HTML
     */
    public final static String HTML = "HTML";
    /**
     *  SilverLight
     */
    public final static String SL = "SL";
    /**
     *  WinRT
     */
    public final static String WINRT = "WinRT";
    /**
     *  Android
     */
    public final static String ANDROID = "Android";
    /**
     *  IOS
     */
    public final static String IOS = "IOS";


    public CodeList96CodeListModelBase() {
        super();
        this.initAnnotation(CodeList96CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList96CodeListModel", this);
    }

}