/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="0799d92cc31e56ef8cd479c62f30e1cc",name="数据库存储区域",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="DBSTORAGE001",text="ORACLE数据库",realtext="ORACLE数据库")
    ,@CodeItem(value="DBSTORAGE002",text="MSSQL 数据库",realtext="MSSQL 数据库")
    ,@CodeItem(value="DBSTORAGE0022",text="ORACLE-arena数据库",realtext="ORACLE-arena数据库")
    ,@CodeItem(value="DBSTORAGE003",text="桂林银行",realtext="桂林银行")
    ,@CodeItem(value="DBSTORAGE004",text="ORACLE数据库（培训）",realtext="ORACLE数据库（培训）")
})


/**
 * 静态代码表[数据库存储区域]模型基类
 */
public abstract class CodeList105CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  ORACLE数据库，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DBSTORAGE001 = "DBSTORAGE001";
    /**
     *  MSSQL 数据库，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DBSTORAGE002 = "DBSTORAGE002";
    /**
     *  ORACLE-arena数据库，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DBSTORAGE0022 = "DBSTORAGE0022";
    /**
     *  桂林银行，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DBSTORAGE003 = "DBSTORAGE003";
    /**
     *  ORACLE数据库（培训），注意：值为对象值，不能直接用于 == 比较
     */
    public final static String DBSTORAGE004 = "DBSTORAGE004";

    public CodeList105CodeListModelBase() {
        super();
        this.initAnnotation(CodeList105CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList105CodeListModel", this);
    }

    /**
     * 获取当前代码表对象实例
     */
    public static net.ibizsys.paas.codelist.ICodeList getInstance() throws Exception {
        return CodeListGlobal.getCodeList("net.ibizsys.psrt.srv.codelist.CodeList105CodeListModel");
    }

}