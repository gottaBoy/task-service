/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="1e533ab62cd7d0483e65a65e3cf89db5",name="扩展表格单元格水平对齐方式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="LEFT",text="左对齐",realtext="左对齐" )
    ,@CodeItem(value="CENTER",text="居中",realtext="居中" )
    ,@CodeItem(value="RIGHT",text="右对齐",realtext="右对齐" )
})


/**
 * 静态代码表[扩展表格单元格水平对齐方式]模型基类
 */
public abstract class CodeList74CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  左对齐
     */
    public final static String LEFT = "LEFT";
    /**
     *  居中
     */
    public final static String CENTER = "CENTER";
    /**
     *  右对齐
     */
    public final static String RIGHT = "RIGHT";


    public CodeList74CodeListModelBase() {
        super();
        this.initAnnotation(CodeList74CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList74CodeListModel", this);
    }

}