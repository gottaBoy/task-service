/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="e2dfb10528565db08a337a4fa25ce1b2",name="DA日志对象类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DATAENTITY",text="实体",realtext="实体" )
    ,@CodeItem(value="DEFIELD",text="实体属性",realtext="实体属性" )
    ,@CodeItem(value="DER1N",text="实体关系",realtext="实体关系" )
})


/**
 * 静态代码表[DA日志对象类型]模型基类
 */
public abstract class CodeList23CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  实体
     */
    public final static String DATAENTITY = "DATAENTITY";
    /**
     *  实体属性
     */
    public final static String DEFIELD = "DEFIELD";
    /**
     *  实体关系
     */
    public final static String DER1N = "DER1N";


    public CodeList23CodeListModelBase() {
        super();
        this.initAnnotation(CodeList23CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList23CodeListModel", this);
    }

}