/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="b33f1e647b1defd975ffd25f50ab7a74",name="数据库触发器目标",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="TABLE",text="主表",realtext="主表" )
    ,@CodeItem(value="VIEW",text="视图",realtext="视图" )
})


/**
 * 静态代码表[数据库触发器目标]模型基类
 */
public abstract class CodeList68CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  主表
     */
    public final static String TABLE = "TABLE";
    /**
     *  视图
     */
    public final static String VIEW = "VIEW";


    public CodeList68CodeListModelBase() {
        super();
        this.initAnnotation(CodeList68CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList68CodeListModel", this);
    }

}