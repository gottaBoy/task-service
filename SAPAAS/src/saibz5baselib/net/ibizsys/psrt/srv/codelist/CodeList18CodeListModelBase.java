/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="a2ba74a0808413318d974ea5bfce3f71",name="表格列对齐",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="left",text="左对齐",realtext="左对齐" )
    ,@CodeItem(value="center",text="剧中",realtext="剧中" )
    ,@CodeItem(value="right",text="右对齐",realtext="右对齐" )
})


/**
 * 静态代码表[表格列对齐]模型基类
 */
public abstract class CodeList18CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  左对齐
     */
    public final static String LEFT = "left";
    /**
     *  剧中
     */
    public final static String CENTER = "center";
    /**
     *  右对齐
     */
    public final static String RIGHT = "right";


    public CodeList18CodeListModelBase() {
        super();
        this.initAnnotation(CodeList18CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList18CodeListModel", this);
    }

}