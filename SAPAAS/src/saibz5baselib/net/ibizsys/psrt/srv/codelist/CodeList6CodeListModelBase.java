/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="82dce2142d49fbdeaf68cd418a3d6f3c",name="网页部件类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CHART",text="图形部件",realtext="图形部件" )
    ,@CodeItem(value="LIST",text="列表",realtext="列表" )
    ,@CodeItem(value="CUSTOMWP",text="自定义",realtext="自定义" )
})


/**
 * 静态代码表[网页部件类型]模型基类
 */
public abstract class CodeList6CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  图形部件
     */
    public final static String CHART = "CHART";
    /**
     *  列表
     */
    public final static String LIST = "LIST";
    /**
     *  自定义
     */
    public final static String CUSTOMWP = "CUSTOMWP";


    public CodeList6CodeListModelBase() {
        super();
        this.initAnnotation(CodeList6CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList6CodeListModel", this);
    }

}