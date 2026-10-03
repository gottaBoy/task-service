/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="f2208088b9cb45cb566e01d78f56d2c7",name="数据库类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DB2",text="DB2",realtext="DB2" )
    ,@CodeItem(value="ORACLE",text="ORACLE",realtext="ORACLE" )
    ,@CodeItem(value="MSSQL",text="MSSQLSERVER",realtext="MSSQLSERVER" )
    ,@CodeItem(value="MYSQL",text="MySQL",realtext="MySQL" )
    ,@CodeItem(value="SYBASE",text="SYBASE",realtext="SYBASE" )
    ,@CodeItem(value="INFORMIX",text="INFORMIX",realtext="INFORMIX" )
})


/**
 * 静态代码表[数据库类型]模型基类
 */
public abstract class CodeList33CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  DB2
     */
    public final static String DB2 = "DB2";
    /**
     *  ORACLE
     */
    public final static String ORACLE = "ORACLE";
    /**
     *  MSSQLSERVER
     */
    public final static String MSSQL = "MSSQL";
    /**
     *  MySQL
     */
    public final static String MYSQL = "MYSQL";
    /**
     *  SYBASE
     */
    public final static String SYBASE = "SYBASE";
    /**
     *  INFORMIX
     */
    public final static String INFORMIX = "INFORMIX";


    public CodeList33CodeListModelBase() {
        super();
        this.initAnnotation(CodeList33CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList33CodeListModel", this);
    }

}