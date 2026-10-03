/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="20bce8400b92312729a0be0766058bb7",name="树视图节点类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="STATIC",text="静态",realtext="静态" )
    ,@CodeItem(value="DE",text="动态（实体）",realtext="动态（实体）" )
    ,@CodeItem(value="CODELIST",text="动态（代码表）",realtext="动态（代码表）" )
})


/**
 * 静态代码表[树视图节点类型]模型基类
 */
public abstract class CodeList94CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  静态
     */
    public final static String STATIC = "STATIC";
    /**
     *  动态（实体）
     */
    public final static String DE = "DE";
    /**
     *  动态（代码表）
     */
    public final static String CODELIST = "CODELIST";


    public CodeList94CodeListModelBase() {
        super();
        this.initAnnotation(CodeList94CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList94CodeListModel", this);
    }

}