/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="2381396a56c91424cc5724a02cef9f66",name="扩展表格单元格垂直对齐方式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="TOP",text="上对齐",realtext="上对齐" )
    ,@CodeItem(value="MIDDLE",text="居中对齐",realtext="居中对齐" )
    ,@CodeItem(value="BOTTOM",text="下对齐",realtext="下对齐" )
})


/**
 * 静态代码表[扩展表格单元格垂直对齐方式]模型基类
 */
public abstract class CodeList75CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  上对齐
     */
    public final static String TOP = "TOP";
    /**
     *  居中对齐
     */
    public final static String MIDDLE = "MIDDLE";
    /**
     *  下对齐
     */
    public final static String BOTTOM = "BOTTOM";


    public CodeList75CodeListModelBase() {
        super();
        this.initAnnotation(CodeList75CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList75CodeListModel", this);
    }

}