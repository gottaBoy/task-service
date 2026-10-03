/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="062feef8cc2886829c4838c8c2e1242a",name="输入辅助_消息模板宏",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CARETTEMPLGROUP_SRFMSG_MSGTEMPLATE",text="消息模板",realtext="消息模板" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFDA_FILLENTITYPARAM",text="系统属性",realtext="系统属性" )
})


/**
 * 静态代码表[输入辅助_消息模板宏]模型基类
 */
public abstract class CodeList102CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  消息模板
     */
    public final static String CARETTEMPLGROUP_SRFMSG_MSGTEMPLATE = "CARETTEMPLGROUP_SRFMSG_MSGTEMPLATE";
    /**
     *  系统属性
     */
    public final static String CARETTEMPLGROUP_SRFDA_FILLENTITYPARAM = "CARETTEMPLGROUP_SRFDA_FILLENTITYPARAM";


    public CodeList102CodeListModelBase() {
        super();
        this.initAnnotation(CodeList102CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList102CodeListModel", this);
    }

}