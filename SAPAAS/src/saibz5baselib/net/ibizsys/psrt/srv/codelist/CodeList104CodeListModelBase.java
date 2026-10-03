/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="d42252a5abe2deac41dae5f12cd591fc",name="输入辅助_图表参数",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CARETTEMPLGROUP_SRFREPORT_CHARTDATA",text="图表数据定义",realtext="图表数据定义" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFREPORT_CHART",text="图表表现定义",realtext="图表表现定义" )
})


/**
 * 静态代码表[输入辅助_图表参数]模型基类
 */
public abstract class CodeList104CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  图表数据定义
     */
    public final static String CARETTEMPLGROUP_SRFREPORT_CHARTDATA = "CARETTEMPLGROUP_SRFREPORT_CHARTDATA";
    /**
     *  图表表现定义
     */
    public final static String CARETTEMPLGROUP_SRFREPORT_CHART = "CARETTEMPLGROUP_SRFREPORT_CHART";


    public CodeList104CodeListModelBase() {
        super();
        this.initAnnotation(CodeList104CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList104CodeListModel", this);
    }

}