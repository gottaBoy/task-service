/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="35054a044be2d6284067b280814c7788",name="列编辑器样式",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DROPDOWNLIST",text="下拉列表框",realtext="下拉列表框" )
    ,@CodeItem(value="PICKER",text="数据选择框",realtext="数据选择框" )
})


/**
 * 静态代码表[列编辑器样式]模型基类
 */
public abstract class CodeList28CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  下拉列表框
     */
    public final static String DROPDOWNLIST = "DROPDOWNLIST";
    /**
     *  数据选择框
     */
    public final static String PICKER = "PICKER";


    public CodeList28CodeListModelBase() {
        super();
        this.initAnnotation(CodeList28CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList28CodeListModel", this);
    }

}