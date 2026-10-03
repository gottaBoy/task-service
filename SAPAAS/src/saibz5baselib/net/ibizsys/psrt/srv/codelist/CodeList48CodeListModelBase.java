/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="e8488f575f42929d013c1204ac0708fa",name="日期类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="每周",realtext="每周" )
    ,@CodeItem(value="2",text="每月",realtext="每月" )
})


/**
 * 静态代码表[日期类型]模型基类
 */
public abstract class CodeList48CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  每周
     */
    public final static String ITEM_1 = "1";
    /**
     *  每月
     */
    public final static String ITEM_2 = "2";


    public CodeList48CodeListModelBase() {
        super();
        this.initAnnotation(CodeList48CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList48CodeListModel", this);
    }

}