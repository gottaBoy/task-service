/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="9c4e88e3d0474a60a18770fb4be7aeeb",name="主实体删除关系实体操作",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="1",text="同时删除",realtext="同时删除" )
    ,@CodeItem(value="2",text="置空",realtext="置空" )
    ,@CodeItem(value="3",text="限制删除",realtext="限制删除" )
})


/**
 * 静态代码表[主实体删除关系实体操作]模型基类
 */
public abstract class CodeList21CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  同时删除
     */
    public final static String ITEM_1 = "1";
    /**
     *  置空
     */
    public final static String ITEM_2 = "2";
    /**
     *  限制删除
     */
    public final static String ITEM_3 = "3";


    public CodeList21CodeListModelBase() {
        super();
        this.initAnnotation(CodeList21CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList21CodeListModel", this);
    }

}