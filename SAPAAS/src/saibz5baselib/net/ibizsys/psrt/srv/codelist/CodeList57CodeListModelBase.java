/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="d2a0cb8de72772d12d793c7c8f860866",name="物理信息更新模式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="UPDATEWHENMODIFY",text="变更时更新",realtext="变更时更新" )
})


/**
 * 静态代码表[物理信息更新模式]模型基类
 */
public abstract class CodeList57CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  变更时更新
     */
    public final static String UPDATEWHENMODIFY = "UPDATEWHENMODIFY";


    public CodeList57CodeListModelBase() {
        super();
        this.initAnnotation(CodeList57CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList57CodeListModel", this);
    }

}