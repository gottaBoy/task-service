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


@CodeList(id="b2d07f091fbac36e499f4904f56d4b41",name="数据通知监控行为",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="新建",realtext="新建")
    ,@CodeItem(value="2",text="更新",realtext="更新")
    ,@CodeItem(value="3",text="新建或更新",realtext="新建或更新")
    ,@CodeItem(value="4",text="删除",realtext="删除")
})


/**
 * 静态代码表[数据通知监控行为]模型基类
 */
public abstract class DataChangeEventCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  新建，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer CREATE = 1;

    /**
     *  新建，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_CREATE = 1;
    /**
     *  更新，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer UPDATE = 2;

    /**
     *  更新，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_UPDATE = 2;
    /**
     *  新建或更新，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer CREATEORUPDATE = 3;

    /**
     *  新建或更新，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_CREATEORUPDATE = 3;
    /**
     *  删除，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer DELETE = 4;

    /**
     *  删除，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_DELETE = 4;

    public DataChangeEventCodeListModelBase() {
        super();
        this.initAnnotation(DataChangeEventCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.DataChangeEventCodeListModel");
    }

}