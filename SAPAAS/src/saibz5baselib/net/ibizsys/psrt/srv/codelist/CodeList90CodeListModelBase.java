/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="277ed862d320c30630c6197379bd1c80",name="属性引用关系类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DER1N",text="1:N关系",realtext="1:N关系" )
    ,@CodeItem(value="DERCUSTOM",text="自定义关系",realtext="自定义关系" )
})


/**
 * 静态代码表[属性引用关系类型]模型基类
 */
public abstract class CodeList90CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  1:N关系
     */
    public final static String DER1N = "DER1N";
    /**
     *  自定义关系
     */
    public final static String DERCUSTOM = "DERCUSTOM";


    public CodeList90CodeListModelBase() {
        super();
        this.initAnnotation(CodeList90CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList90CodeListModel", this);
    }

}