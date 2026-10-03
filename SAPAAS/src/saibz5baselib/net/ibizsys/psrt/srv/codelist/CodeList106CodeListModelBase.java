/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="62e71980ba833da6da5d2114ccb7c620",name="实体数据操作步骤",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="GETDEFAULT",text="获取默认值",realtext="获取默认值" )
    ,@CodeItem(value="BEFORESAVE",text="保存之前",realtext="保存之前" )
    ,@CodeItem(value="AFTERSAVE",text="保存之后",realtext="保存之后" )
    ,@CodeItem(value="BEFOREREMOVE",text="删除之前",realtext="删除之前" )
    ,@CodeItem(value="AFTERREMOVE",text="删除之后",realtext="删除之后" )
    ,@CodeItem(value="TESTSAVE",text="测试保存",realtext="测试保存" )
    ,@CodeItem(value="CUSTOMCALL",text="自定义操作",realtext="自定义操作" )
    ,@CodeItem(value="INTERNALCALL",text="内部调用",realtext="内部调用" )
})


/**
 * 静态代码表[实体数据操作步骤]模型基类
 */
public abstract class CodeList106CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  获取默认值
     */
    public final static String GETDEFAULT = "GETDEFAULT";
    /**
     *  保存之前
     */
    public final static String BEFORESAVE = "BEFORESAVE";
    /**
     *  保存之后
     */
    public final static String AFTERSAVE = "AFTERSAVE";
    /**
     *  删除之前
     */
    public final static String BEFOREREMOVE = "BEFOREREMOVE";
    /**
     *  删除之后
     */
    public final static String AFTERREMOVE = "AFTERREMOVE";
    /**
     *  测试保存
     */
    public final static String TESTSAVE = "TESTSAVE";
    /**
     *  自定义操作
     */
    public final static String CUSTOMCALL = "CUSTOMCALL";
    /**
     *  内部调用
     */
    public final static String INTERNALCALL = "INTERNALCALL";


    public CodeList106CodeListModelBase() {
        super();
        this.initAnnotation(CodeList106CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList106CodeListModel", this);
    }

}