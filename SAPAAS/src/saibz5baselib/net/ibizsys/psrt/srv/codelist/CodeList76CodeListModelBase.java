/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="74f593e62bc52670ed4d13aadb4ceedd",name="扩展表格单元格边框样式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="LEFT",text="左边框",realtext="左边框" )
    ,@CodeItem(value="TOP",text="上边框",realtext="上边框" )
    ,@CodeItem(value="RIGHT",text="右边框",realtext="右边框" )
    ,@CodeItem(value="BOTTOM",text="下边框",realtext="下边框" )
})


/**
 * 静态代码表[扩展表格单元格边框样式]模型基类
 */
public abstract class CodeList76CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  左边框
     */
    public final static String LEFT = "LEFT";
    /**
     *  上边框
     */
    public final static String TOP = "TOP";
    /**
     *  右边框
     */
    public final static String RIGHT = "RIGHT";
    /**
     *  下边框
     */
    public final static String BOTTOM = "BOTTOM";


    public CodeList76CodeListModelBase() {
        super();
        this.initAnnotation(CodeList76CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList76CodeListModel", this);
    }

}