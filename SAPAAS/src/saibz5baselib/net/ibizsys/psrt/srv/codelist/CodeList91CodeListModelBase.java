/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="2929b68cbf707c6fe610a8122f71ce7c",name="界面功能类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="INHERIT",text="继承模板",realtext="继承模板" )
    ,@CodeItem(value="DEFAULT",text="默认功能",realtext="默认功能" )
    ,@CodeItem(value="CUSTOM",text="自定义",realtext="自定义" )
})


/**
 * 静态代码表[界面功能类型]模型基类
 */
public abstract class CodeList91CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  继承模板
     */
    public final static String INHERIT = "INHERIT";
    /**
     *  默认功能
     */
    public final static String DEFAULT = "DEFAULT";
    /**
     *  自定义
     */
    public final static String CUSTOM = "CUSTOM";


    public CodeList91CodeListModelBase() {
        super();
        this.initAnnotation(CodeList91CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList91CodeListModel", this);
    }

}