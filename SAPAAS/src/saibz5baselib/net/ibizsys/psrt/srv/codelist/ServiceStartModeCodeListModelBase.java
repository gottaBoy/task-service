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


@CodeList(id="0a17383cf8095d9796c32e74a8696e01",name="服务启动模式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="AUTO",text="自动",realtext="自动")
    ,@CodeItem(value="MANUAL",text="手动",realtext="手动")
})


/**
 * 静态代码表[服务启动模式]模型基类
 */
public abstract class ServiceStartModeCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  自动，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String AUTO = "AUTO";
    /**
     *  手动，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String MANUAL = "MANUAL";

    public ServiceStartModeCodeListModelBase() {
        super();
        this.initAnnotation(ServiceStartModeCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.ServiceStartModeCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.ServiceStartModeCodeListModel");
    }

}