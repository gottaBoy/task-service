/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdgroupdetail.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="8AF80FF8-ED53-4204-B177-4A25E3944B15",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.TSSDGROUPDETAILID AS TSSDGROUPDETAILID, t1.TSSDGROUPDETAILNAME AS TSSDGROUPDETAILNAME, t1.TSSDGROUPID AS TSSDGROUPID, t11.TSSDGROUPNAME AS TSSDGROUPNAME, t1.TSSDITEMID AS TSSDITEMID, t21.TSSDITEMNAME AS TSSDITEMNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDGROUPDETAIL t1  LEFT JOIN T_SRFTSSDGROUP t11 ON t1.TSSDGROUPID = t11.TSSDGROUPID  LEFT JOIN T_SRFTSSDITEM t21 ON t1.TSSDITEMID = t21.TSSDITEMID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILID",expression="t1.TSSDGROUPDETAILID",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILNAME",expression="t1.TSSDGROUPDETAILNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDGROUPID",expression="t1.TSSDGROUPID",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDGROUPNAME",expression="t11.TSSDGROUPNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.TSSDITEMID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t21.TSSDITEMNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`tssdgroupdetailid`, t1.`tssdgroupdetailname`, t1.`tssdgroupid`, t11.`tssdgroupname`, t1.`tssditemid`, t21.`tssditemname`, t1.`updatedate`, t1.`updateman` FROM `t_srftssdgroupdetail` t1  LEFT JOIN t_srftssdgroup t11 ON t1.tssdgroupid = t11.tssdgroupid  LEFT JOIN t_srftssditem t21 ON t1.tssditemid = t21.tssditemid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILID",expression="t1.`tssdgroupdetailid`",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILNAME",expression="t1.`tssdgroupdetailname`",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDGROUPID",expression="t1.`tssdgroupid`",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDGROUPNAME",expression="t11.`tssdgroupname`",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.`tssditemid`",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t21.`tssditemname`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.TSSDGROUPDETAILID AS TSSDGROUPDETAILID, t1.TSSDGROUPDETAILNAME AS TSSDGROUPDETAILNAME, t1.TSSDGROUPID AS TSSDGROUPID, t11.TSSDGROUPNAME AS TSSDGROUPNAME, t1.TSSDITEMID AS TSSDITEMID, t21.TSSDITEMNAME AS TSSDITEMNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDGROUPDETAIL t1  LEFT JOIN T_SRFTSSDGROUP t11 ON t1.TSSDGROUPID = t11.TSSDGROUPID  LEFT JOIN T_SRFTSSDITEM t21 ON t1.TSSDITEMID = t21.TSSDITEMID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILID",expression="t1.TSSDGROUPDETAILID",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILNAME",expression="t1.TSSDGROUPDETAILNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDGROUPID",expression="t1.TSSDGROUPID",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDGROUPNAME",expression="t11.TSSDGROUPNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.TSSDITEMID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t21.TSSDITEMNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.TSSDGROUPDETAILID AS TSSDGROUPDETAILID, t1.TSSDGROUPDETAILNAME AS TSSDGROUPDETAILNAME, t1.TSSDGROUPID AS TSSDGROUPID, t11.TSSDGROUPNAME AS TSSDGROUPNAME, t1.TSSDITEMID AS TSSDITEMID, t21.TSSDITEMNAME AS TSSDITEMNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDGROUPDETAIL t1  LEFT JOIN T_SRFTSSDGROUP t11 ON t1.TSSDGROUPID = t11.TSSDGROUPID  LEFT JOIN T_SRFTSSDITEM t21 ON t1.TSSDITEMID = t21.TSSDITEMID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILID",expression="t1.TSSDGROUPDETAILID",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILNAME",expression="t1.TSSDGROUPDETAILNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDGROUPID",expression="t1.TSSDGROUPID",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDGROUPNAME",expression="t11.TSSDGROUPNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.TSSDITEMID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t21.TSSDITEMNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.TSSDGROUPDETAILID AS TSSDGROUPDETAILID, t1.TSSDGROUPDETAILNAME AS TSSDGROUPDETAILNAME, t1.TSSDGROUPID AS TSSDGROUPID, t11.TSSDGROUPNAME AS TSSDGROUPNAME, t1.TSSDITEMID AS TSSDITEMID, t21.TSSDITEMNAME AS TSSDITEMNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDGROUPDETAIL t1  LEFT JOIN T_SRFTSSDGROUP t11 ON t1.TSSDGROUPID = t11.TSSDGROUPID  LEFT JOIN T_SRFTSSDITEM t21 ON t1.TSSDITEMID = t21.TSSDITEMID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILID",expression="t1.TSSDGROUPDETAILID",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILNAME",expression="t1.TSSDGROUPDETAILNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDGROUPID",expression="t1.TSSDGROUPID",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDGROUPNAME",expression="t11.TSSDGROUPNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.TSSDITEMID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t21.TSSDITEMNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE] AS [CREATEDATE], t1.[CREATEMAN] AS [CREATEMAN], t1.[TSSDGROUPDETAILID] AS [TSSDGROUPDETAILID], t1.[TSSDGROUPDETAILNAME] AS [TSSDGROUPDETAILNAME], t1.[TSSDGROUPID] AS [TSSDGROUPID], t11.[TSSDGROUPNAME] AS [TSSDGROUPNAME], t1.[TSSDITEMID] AS [TSSDITEMID], t21.[TSSDITEMNAME] AS [TSSDITEMNAME], t1.[UPDATEDATE] AS [UPDATEDATE], t1.[UPDATEMAN] AS [UPDATEMAN] FROM [T_SRFTSSDGROUPDETAIL] t1  LEFT JOIN T_SRFTSSDGROUP t11 ON t1.TSSDGROUPID = t11.TSSDGROUPID  LEFT JOIN T_SRFTSSDITEM t21 ON t1.TSSDITEMID = t21.TSSDITEMID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILID",expression="t1.[TSSDGROUPDETAILID]",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDGROUPDETAILNAME",expression="t1.[TSSDGROUPDETAILNAME]",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDGROUPID",expression="t1.[TSSDGROUPID]",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDGROUPNAME",expression="t11.[TSSDGROUPNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.[TSSDITEMID]",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t21.[TSSDITEMNAME]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=9)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class TSSDGroupDetailDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public TSSDGroupDetailDefaultDQModelBase() {
        super();

        this.initAnnotation(TSSDGroupDetailDefaultDQModelBase.class);
    }

}