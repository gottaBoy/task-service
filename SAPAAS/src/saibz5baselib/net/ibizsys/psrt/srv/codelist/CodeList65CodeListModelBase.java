/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="d15219b301d6e4024ff1d17b1f90874c",name="数据库触发器操作",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="BEFORE",text="Before",realtext="Before" )
    ,@CodeItem(value="AFTER",text="After",realtext="After" )
    ,@CodeItem(value="INSTEADOF",text="Instead of",realtext="Instead of" )
})


/**
 * 静态代码表[数据库触发器操作]模型基类
 */
public abstract class CodeList65CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  Before
     */
    public final static String BEFORE = "BEFORE";
    /**
     *  After
     */
    public final static String AFTER = "AFTER";
    /**
     *  Instead of
     */
    public final static String INSTEADOF = "INSTEADOF";


    public CodeList65CodeListModelBase() {
        super();
        this.initAnnotation(CodeList65CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList65CodeListModel", this);
    }

}