/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.codelist;


import net.ibizsys.paas.codelist.CodeItem;
import net.ibizsys.paas.codelist.CodeItems;
import net.ibizsys.paas.codelist.CodeList;
import net.ibizsys.paas.sysmodel.CodeListGlobal;


@CodeList(id="f7c4604080f938281b8a473f8ce3ea59",name="补字应用场合类型",type="STATIC",userscope=false,emptytext="未定义")

@CodeItems({
    @CodeItem(value="GG",text="公共",realtext="公共" )
    ,@CodeItem(value="SH",text="审核",realtext="审核" ,parentvalue="GG")
    ,@CodeItem(value="PG",text="派工",realtext="派工" ,parentvalue="GG")
    ,@CodeItem(value="SABTYY",text="SABTYY",realtext="SABTYY" )
    ,@CodeItem(value="RKDSH",text="入库单审核",realtext="入库单审核" ,parentvalue="SABTYY")
    ,@CodeItem(value="CKDSH",text="出库单审核",realtext="出库单审核" ,parentvalue="SABTYY")
    ,@CodeItem(value="BSDSH",text="报损单审核",realtext="报损单审核" ,parentvalue="SABTYY")
    ,@CodeItem(value="SAOA",text="SAOA",realtext="SAOA" )
    ,@CodeItem(value="FW",text="发文",realtext="发文" ,parentvalue="SAOA")
    ,@CodeItem(value="SW",text="收文",realtext="收文" ,parentvalue="SAOA")
})


/**
 * 静态代码表[补字应用场合类型]模型基类
 */
public abstract class CodeList30CodeListModelBase extends net.ibizsys.paas.sysmodel.StaticCodeListModelBase  {

    /**
     *  公共
     */
    public final static String GG = "GG";
    /**
     *  审核
     */
    public final static String SH = "SH";
    /**
     *  派工
     */
    public final static String PG = "PG";
    /**
     *  SABTYY
     */
    public final static String SABTYY = "SABTYY";
    /**
     *  入库单审核
     */
    public final static String RKDSH = "RKDSH";
    /**
     *  出库单审核
     */
    public final static String CKDSH = "CKDSH";
    /**
     *  报损单审核
     */
    public final static String BSDSH = "BSDSH";
    /**
     *  SAOA
     */
    public final static String SAOA = "SAOA";
    /**
     *  发文
     */
    public final static String FW = "FW";
    /**
     *  收文
     */
    public final static String SW = "SW";


    public CodeList30CodeListModelBase() {
        super();
        this.initAnnotation(CodeList30CodeListModelBase.class);
        CodeListGlobal.registerCodeList("net.ibizsys.psrt.srv.codelist.CodeList30CodeListModel", this);
    }

}