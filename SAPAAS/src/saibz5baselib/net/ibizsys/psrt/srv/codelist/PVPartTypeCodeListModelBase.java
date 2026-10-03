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


@CodeList(id="86C55C56-0AD9-45BD-B914-AD21DE1E1479",name="门户视图部件类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="LIST",text="列表",realtext="列表")
    ,@CodeItem(value="CHART",text="图表",realtext="图表")
})


/**
 * 静态代码表[门户视图部件类型]模型基类
 */
public abstract class PVPartTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  列表，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String LIST = "LIST";
    /**
     *  图表，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String CHART = "CHART";

    public PVPartTypeCodeListModelBase() {
        super();
        this.initAnnotation(PVPartTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.PVPartTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.PVPartTypeCodeListModel");
    }

}