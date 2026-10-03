/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="207d8f3e5d405336dc290365e30b3af8",name="工作日类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="工作日",realtext="工作日" )
    ,@CodeItem(value="2",text="非工作日",realtext="非工作日" )
    ,@CodeItem(value="3",text="自定义工作日",realtext="自定义工作日" )
})


/**
 * 静态代码表[工作日类型]模型基类
 */
public abstract class CodeList45CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  工作日
     */
    public final static String ITEM_1 = "1";
    /**
     *  非工作日
     */
    public final static String ITEM_2 = "2";
    /**
     *  自定义工作日
     */
    public final static String ITEM_3 = "3";


    public CodeList45CodeListModelBase() {
        super();
        this.initAnnotation(CodeList45CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList45CodeListModel", this);
    }

}