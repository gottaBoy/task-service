/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="3ac6db3b9ce065e05ac98656c8363cb5",name="平台内置流程状态",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="0",text="未启动",realtext="未启动" )
    ,@CodeItem(value="1",text="流程中",realtext="流程中" )
    ,@CodeItem(value="2",text="已完成",realtext="已完成" )
    ,@CodeItem(value="3",text="已取消",realtext="已取消" )
    ,@CodeItem(value="31",text="已取消(人工)",realtext="已取消(人工)" )
    ,@CodeItem(value="32",text="已取消(超时)",realtext="已取消(超时)" )
    ,@CodeItem(value="4",text="处理故障",realtext="处理故障" )
    ,@CodeItem(value="5",text="取消启动",realtext="取消启动" )
})


/**
 * 静态代码表[平台内置流程状态]模型基类
 */
public abstract class WFStatesCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  未启动
     */
    public final static Integer ITEM_0 = 0;
    /**
     *  流程中
     */
    public final static Integer ITEM_1 = 1;
    /**
     *  已完成
     */
    public final static Integer ITEM_2 = 2;
    /**
     *  已取消
     */
    public final static Integer ITEM_3 = 3;
    /**
     *  已取消(人工)
     */
    public final static Integer ITEM_31 = 31;
    /**
     *  已取消(超时)
     */
    public final static Integer ITEM_32 = 32;
    /**
     *  处理故障
     */
    public final static Integer ITEM_4 = 4;
    /**
     *  取消启动
     */
    public final static Integer ITEM_5 = 5;


    public WFStatesCodeListModelBase() {
        super();
        this.initAnnotation(WFStatesCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFStatesCodeListModel", this);
    }

}