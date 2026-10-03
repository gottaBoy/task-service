/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="aecf6d488539a7c4df72030f9c308e2a",name="输入辅助_实体处理逻辑代码",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CARETTEMPLGROUP_SRFDA_DEDCCONTEXT",text="实体处理逻辑引擎",realtext="实体处理逻辑引擎" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFDA_DEACTION",text="实体属性操作",realtext="实体属性操作" )
})


/**
 * 静态代码表[输入辅助_实体处理逻辑代码]模型基类
 */
public abstract class CodeList103CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  实体处理逻辑引擎
     */
    public final static String CARETTEMPLGROUP_SRFDA_DEDCCONTEXT = "CARETTEMPLGROUP_SRFDA_DEDCCONTEXT";
    /**
     *  实体属性操作
     */
    public final static String CARETTEMPLGROUP_SRFDA_DEACTION = "CARETTEMPLGROUP_SRFDA_DEACTION";


    public CodeList103CodeListModelBase() {
        super();
        this.initAnnotation(CodeList103CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList103CodeListModel", this);
    }

}