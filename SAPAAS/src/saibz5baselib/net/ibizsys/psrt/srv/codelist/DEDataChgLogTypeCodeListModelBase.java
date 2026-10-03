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


@CodeList(id="896c239f8d11ba397f78cec2a6726b69",name="数据实体_数据变更日志类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="2",text="单项数据（同步）",realtext="单项数据（同步）")
    ,@CodeItem(value="3",text="单项数据（含关联数据）（同步）",realtext="单项数据（含关联数据）（同步）")
    ,@CodeItem(value="4",text="单项数据（异步）",realtext="单项数据（异步）")
    ,@CodeItem(value="5",text="单项数据（含关联数据）（异步）",realtext="单项数据（含关联数据）（异步）")
})


/**
 * 静态代码表[数据实体_数据变更日志类型]模型基类
 */
public abstract class DEDataChgLogTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  单项数据（同步），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_2 = "2";
    /**
     *  单项数据（含关联数据）（同步），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_3 = "3";
    /**
     *  单项数据（异步），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_4 = "4";
    /**
     *  单项数据（含关联数据）（异步），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_5 = "5";

    public DEDataChgLogTypeCodeListModelBase() {
        super();
        this.initAnnotation(DEDataChgLogTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DEDataChgLogTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DEDataChgLogTypeCodeListModel");
    }

}