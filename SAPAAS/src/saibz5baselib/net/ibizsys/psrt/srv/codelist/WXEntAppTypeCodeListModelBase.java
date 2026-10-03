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


@CodeList(id="1b748a0f68805f9d3a28ba163f4697ff",name="微信企业应用类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="H5",text="H5主页型",realtext="H5主页型")
    ,@CodeItem(value="MSG",text="消息响应型",realtext="消息响应型")
})


/**
 * 静态代码表[微信企业应用类型]模型基类
 */
public abstract class WXEntAppTypeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  H5主页型，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String H5 = "H5";
    /**
     *  消息响应型，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String MSG = "MSG";

    public WXEntAppTypeCodeListModelBase() {
        super();
        this.initAnnotation(WXEntAppTypeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.WXEntAppTypeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.WXEntAppTypeCodeListModel");
    }

}