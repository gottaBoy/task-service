/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="967d906284420dd9cb08f63f79846ab1",name="预定义属性类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="LOGICVALID",text="逻辑有效标识",realtext="逻辑有效标识" )
    ,@CodeItem(value="CREATEMAN",text="建立人",realtext="建立人" )
    ,@CodeItem(value="CREATEDATE",text="建立时间",realtext="建立时间" )
    ,@CodeItem(value="UPDATEMAN",text="更新人",realtext="更新人" )
    ,@CodeItem(value="UPDATEDATE",text="更新时间",realtext="更新时间" )
    ,@CodeItem(value="ORGUNITID",text="组织单元标识",realtext="组织单元标识" )
    ,@CodeItem(value="ORGUNITNAME",text="组织单元名称",realtext="组织单元名称" )
})


/**
 * 静态代码表[预定义属性类型]模型基类
 */
public abstract class CodeList34CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  逻辑有效标识
     */
    public final static String LOGICVALID = "LOGICVALID";
    /**
     *  建立人
     */
    public final static String CREATEMAN = "CREATEMAN";
    /**
     *  建立时间
     */
    public final static String CREATEDATE = "CREATEDATE";
    /**
     *  更新人
     */
    public final static String UPDATEMAN = "UPDATEMAN";
    /**
     *  更新时间
     */
    public final static String UPDATEDATE = "UPDATEDATE";
    /**
     *  组织单元标识
     */
    public final static String ORGUNITID = "ORGUNITID";
    /**
     *  组织单元名称
     */
    public final static String ORGUNITNAME = "ORGUNITNAME";


    public CodeList34CodeListModelBase() {
        super();
        this.initAnnotation(CodeList34CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList34CodeListModel", this);
    }

}