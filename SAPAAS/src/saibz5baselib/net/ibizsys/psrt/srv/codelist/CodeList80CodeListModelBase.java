/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="79e9fa593c9008f53d82dbc1b3776016",name="实体存储类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="STATIC",text="静态存储",realtext="静态存储")
    ,@CodeItem(value="DYNAMIC",text="动态存储",realtext="动态存储")
    ,@CodeItem(value="NONE",text="无存储",realtext="无存储")
})


/**
 * 静态代码表[实体存储类型]模型基类
 */
public abstract class CodeList80CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  静态存储，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String STATIC = "STATIC";
    /**
     *  动态存储，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DYNAMIC = "DYNAMIC";
    /**
     *  无存储，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String NONE = "NONE";

    public CodeList80CodeListModelBase() {
        super();
        this.initAnnotation(CodeList80CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList80CodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList80CodeListModel");
    }

}