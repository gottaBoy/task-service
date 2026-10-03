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


@CodeList(id="418F1DBE-278E-46A8-9A0D-2A6B603FAA81",name="门户视图自定义布局",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="70P_30P",text="左右布局（70%;30%）",realtext="左右布局（70%;30%）")
    ,@CodeItem(value="30P_70P",text="左右布局（30%;70%）",realtext="左右布局（30%;70%）")
    ,@CodeItem(value="50P_50P",text="左右布局（50%;50%）",realtext="左右布局（50%;50%）")
})


/**
 * 静态代码表[门户视图自定义布局]模型基类
 */
public abstract class PVLayoutModeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  左右布局（70%;30%），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_1 = "70P_30P";
    /**
     *  左右布局（30%;70%），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_2 = "30P_70P";
    /**
     *  左右布局（50%;50%），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_3 = "50P_50P";

    public PVLayoutModeCodeListModelBase() {
        super();
        this.initAnnotation(PVLayoutModeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.PVLayoutModeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.PVLayoutModeCodeListModel");
    }

}