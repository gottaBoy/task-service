/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="b81e146d9e42c25dd6b3fb8ca27b9399",name="输入辅助_页面参数",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CARETTEMPLGROUP_SRFDA_PAGEPARAM",text="常规页面参数",realtext="常规页面参数" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFDA_GRIDVIEWPAGEPARAM",text="表格页面参数",realtext="表格页面参数" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFDA_EDITVIEWPAGEPARAM",text="编辑页面参数",realtext="编辑页面参数" )
})


/**
 * 静态代码表[输入辅助_页面参数]模型基类
 */
public abstract class CodeList100CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  常规页面参数
     */
    public final static String CARETTEMPLGROUP_SRFDA_PAGEPARAM = "CARETTEMPLGROUP_SRFDA_PAGEPARAM";
    /**
     *  表格页面参数
     */
    public final static String CARETTEMPLGROUP_SRFDA_GRIDVIEWPAGEPARAM = "CARETTEMPLGROUP_SRFDA_GRIDVIEWPAGEPARAM";
    /**
     *  编辑页面参数
     */
    public final static String CARETTEMPLGROUP_SRFDA_EDITVIEWPAGEPARAM = "CARETTEMPLGROUP_SRFDA_EDITVIEWPAGEPARAM";


    public CodeList100CodeListModelBase() {
        super();
        this.initAnnotation(CodeList100CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList100CodeListModel", this);
    }

}