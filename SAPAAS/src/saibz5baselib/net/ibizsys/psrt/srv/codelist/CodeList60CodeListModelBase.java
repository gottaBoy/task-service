/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="93712a5199ec3e74c7e45d0bf576d38d",name="字段查询扩展选项",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="LIKE",text="LIKE大小写敏感",realtext="LIKE大小写敏感" )
    ,@CodeItem(value="=",text="=（含其它）大小写敏感",realtext="=（含其它）大小写敏感" )
    ,@CodeItem(value="LIKESPLIT",text="LIKE分解",realtext="LIKE分解" )
})


/**
 * 静态代码表[字段查询扩展选项]模型基类
 */
public abstract class CodeList60CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  LIKE大小写敏感
     */
    public final static String LIKE = "LIKE";
    /**
     *  =（含其它）大小写敏感
     */
    public final static String EQ = "=";
    /**
     *  LIKE分解
     */
    public final static String LIKESPLIT = "LIKESPLIT";


    public CodeList60CodeListModelBase() {
        super();
        this.initAnnotation(CodeList60CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList60CodeListModel", this);
    }

}