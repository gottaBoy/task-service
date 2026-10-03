/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="68dd60d14c29a2fc32023733a3dc4e33",name="页面资源类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="NONE",text="无资源",realtext="无资源" )
    ,@CodeItem(value="DEDATA",text="数据操作",realtext="数据操作" )
    ,@CodeItem(value="PAGE",text="页面对象",realtext="页面对象" )
    ,@CodeItem(value="CUSTOM",text="自定义",realtext="自定义" )
})


/**
 * 静态代码表[页面资源类型]模型基类
 */
public abstract class CodeList17CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  无资源
     */
    public final static String NONE = "NONE";
    /**
     *  数据操作
     */
    public final static String DEDATA = "DEDATA";
    /**
     *  页面对象
     */
    public final static String PAGE = "PAGE";
    /**
     *  自定义
     */
    public final static String CUSTOM = "CUSTOM";


    public CodeList17CodeListModelBase() {
        super();
        this.initAnnotation(CodeList17CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList17CodeListModel", this);
    }

}