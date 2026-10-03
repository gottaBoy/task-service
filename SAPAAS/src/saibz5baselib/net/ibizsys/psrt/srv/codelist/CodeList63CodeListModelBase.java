/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="271cd41fbe4d765ae22c8f88be592896",name="页面参数值变量",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="PARAM1",text="参数1(字符)",realtext="参数1(字符)" )
    ,@CodeItem(value="PARAM2",text="参数2(字符)",realtext="参数2(字符)" )
})


/**
 * 静态代码表[页面参数值变量]模型基类
 */
public abstract class CodeList63CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  参数1(字符)
     */
    public final static String PARAM1 = "PARAM1";
    /**
     *  参数2(字符)
     */
    public final static String PARAM2 = "PARAM2";


    public CodeList63CodeListModelBase() {
        super();
        this.initAnnotation(CodeList63CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList63CodeListModel", this);
    }

}