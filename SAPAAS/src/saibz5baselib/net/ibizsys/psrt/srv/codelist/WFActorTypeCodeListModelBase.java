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


@CodeList(id="c59d8132dd946cdf9a681a0c969aa95e",name="工作流操作者类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="USER",text="用户",realtext="用户")
    ,@CodeItem(value="USERGROUP",text="用户组",realtext="用户组")
    ,@CodeItem(value="SYSTEMUSER",text="系统保留用户",realtext="系统保留用户")
    ,@CodeItem(value="DYNAMICUSER",text="动态用户",realtext="动态用户")
})


/**
 * 静态代码表[工作流操作者类型]模型基类
 */
public abstract class WFActorTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  用户，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String USER = "USER";
    /**
     *  用户组，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String USERGROUP = "USERGROUP";
    /**
     *  系统保留用户，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String SYSTEMUSER = "SYSTEMUSER";
    /**
     *  动态用户，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DYNAMICUSER = "DYNAMICUSER";

    public WFActorTypeCodeListModelBase() {
        super();
        this.initAnnotation(WFActorTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFActorTypeCodeListModel");
    }

}