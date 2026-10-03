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


@CodeList(id="99658ab2c11707b73ad6dd240ef4d93d",name="数据实体_索引模式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="主键附加类型",realtext="主键附加类型")
})


/**
 * 静态代码表[数据实体_索引模式]模型基类
 */
public abstract class DEIndexModeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  主键附加类型，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String ITEM_1 = "1";

    public DEIndexModeCodeListModelBase() {
        super();
        this.initAnnotation(DEIndexModeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DEIndexModeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DEIndexModeCodeListModel");
    }

}