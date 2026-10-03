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


@CodeList(id="02e68ecd17390b6a576481dc2b7105fb",name="工作流配置状态",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="正常状态",realtext="正常状态")
    ,@CodeItem(value="2",text="暂停状态",realtext="暂停状态")
})


/**
 * 静态代码表[工作流配置状态]模型基类
 */
public abstract class WFConfigStateCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  正常状态，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_1 = "1";
    /**
     *  暂停状态，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_2 = "2";

    public WFConfigStateCodeListModelBase() {
        super();
        this.initAnnotation(WFConfigStateCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WFConfigStateCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WFConfigStateCodeListModel");
    }

}