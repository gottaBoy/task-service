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


@CodeList(id="2DF82870-2B81-4EE2-A53D-95B6A0DA14B1",name="数据对象能力用户数据范围",type="STATIC",userscope=false,emptytext="未定义",ormode="NUM",textseparator="、")

@CodeItems({
    @CodeItem(value="1",text="建立人",realtext="建立人")
    ,@CodeItem(value="2",text="更新人",realtext="更新人")
})


/**
 * 静态代码表[数据对象能力用户数据范围]模型基类
 */
public abstract class URDUserDRCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  建立人，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer CREATEMAN = 1;

    /**
     *  建立人，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_CREATEMAN = 1;
    /**
     *  更新人，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer UPDATEMAN = 2;

    /**
     *  更新人，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_UPDATEMAN = 2;

    public URDUserDRCodeListModelBase() {
        super();
        this.initAnnotation(URDUserDRCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.URDUserDRCodeListModel");
    }

}