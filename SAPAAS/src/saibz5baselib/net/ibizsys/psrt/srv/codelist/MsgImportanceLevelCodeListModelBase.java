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


@CodeList(id="9BC9CA8C-A271-41BF-AD28-55C77F27A63E",name="日历、邮件重要程度（数值）",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="100",text="高",realtext="高")
    ,@CodeItem(value="50",text="普通",realtext="普通")
    ,@CodeItem(value="10",text="低",realtext="低")
})


/**
 * 静态代码表[日历、邮件重要程度（数值）]模型基类
 */
public abstract class MsgImportanceLevelCodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  高，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer HIGH = 100;

    /**
     *  高，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_HIGH = 100;
    /**
     *  普通，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer NORMAL = 50;

    /**
     *  普通，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_NORMAL = 50;
    /**
     *  低，注意：值为对象值，不能直接用于 == 比较，可使用 INT_ 替换
     */
    public final static Integer LOW = 10;

    /**
     *  低，整形类型，可用于 switch 或 == 比较
     */
    public final static int INT_LOW = 10;

    public MsgImportanceLevelCodeListModelBase() {
        super();
        this.initAnnotation(MsgImportanceLevelCodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.MsgImportanceLevelCodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.MsgImportanceLevelCodeListModel");
    }

}