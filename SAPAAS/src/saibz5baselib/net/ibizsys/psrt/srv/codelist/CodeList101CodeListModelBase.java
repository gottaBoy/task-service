/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="e4d7ca43e89e3362ff779839d3226867",name="输入辅助_控件参数",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM",text="控件基本参数",realtext="控件基本参数" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM_CARET",text="辅助输入控件参数",realtext="辅助输入控件参数" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUP",text="选择控件参数",realtext="选择控件参数" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM_TEXTBOX",text="文本控件参数",realtext="文本控件参数" )
    ,@CodeItem(value="CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUPLISTBOX",text="选择列表控件参数",realtext="选择列表控件参数" )
})


/**
 * 静态代码表[输入辅助_控件参数]模型基类
 */
public abstract class CodeList101CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  控件基本参数
     */
    public final static String CARETTEMPLGROUP_SRFDA_CONTROLPARAM = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM";
    /**
     *  辅助输入控件参数
     */
    public final static String CARETTEMPLGROUP_SRFDA_CONTROLPARAM_CARET = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM_CARET";
    /**
     *  选择控件参数
     */
    public final static String CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUP = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUP";
    /**
     *  文本控件参数
     */
    public final static String CARETTEMPLGROUP_SRFDA_CONTROLPARAM_TEXTBOX = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM_TEXTBOX";
    /**
     *  选择列表控件参数
     */
    public final static String CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUPLISTBOX = "CARETTEMPLGROUP_SRFDA_CONTROLPARAM_PICKUPLISTBOX";


    public CodeList101CodeListModelBase() {
        super();
        this.initAnnotation(CodeList101CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList101CodeListModel", this);
    }

}