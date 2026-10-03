/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="c821c14e8cbf700654b01dbe618ec7b5",name="页面跳转处理_页面类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="PAGE",text="内置页面",realtext="内置页面" )
    ,@CodeItem(value="URL",text="网页路径",realtext="网页路径" )
    ,@CodeItem(value="SCRIPT",text="脚本",realtext="脚本" )
})


/**
 * 静态代码表[页面跳转处理_页面类型]模型基类
 */
public abstract class CodeList113CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  内置页面
     */
    public final static String PAGE = "PAGE";
    /**
     *  网页路径
     */
    public final static String URL = "URL";
    /**
     *  脚本
     */
    public final static String SCRIPT = "SCRIPT";


    public CodeList113CodeListModelBase() {
        super();
        this.initAnnotation(CodeList113CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList113CodeListModel", this);
    }

}