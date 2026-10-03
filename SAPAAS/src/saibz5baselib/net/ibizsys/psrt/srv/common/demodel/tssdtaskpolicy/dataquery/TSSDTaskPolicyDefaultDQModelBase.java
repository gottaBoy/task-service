/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtaskpolicy.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="68B1EB5E-1467-484F-AFA4-0A0C1960D0C6",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.TSSDPOLICYID AS TSSDPOLICYID, t11.TSSDPOLICYNAME AS TSSDPOLICYNAME, t1.TSSDTASKID AS TSSDTASKID, t21.TSSDTASKNAME AS TSSDTASKNAME, t1.TSSDTASKPOLICYID AS TSSDTASKPOLICYID, t1.TSSDTASKPOLICYNAME AS TSSDTASKPOLICYNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDTASKPOLICY t1  LEFT JOIN T_SRFTSSDPOLICY t11 ON t1.TSSDPOLICYID = t11.TSSDPOLICYID  LEFT JOIN T_SRFTSSDTASK t21 ON t1.TSSDTASKID = t21.TSSDTASKID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYID",expression="t1.TSSDPOLICYID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYNAME",expression="t11.TSSDPOLICYNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.TSSDTASKID",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t21.TSSDTASKNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYID",expression="t1.TSSDTASKPOLICYID",showorder=10)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYNAME",expression="t1.TSSDTASKPOLICYNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`tssdpolicyid`, t11.`tssdpolicyname`, t1.`tssdtaskid`, t21.`tssdtaskname`, t1.`tssdtaskpolicyid`, t1.`tssdtaskpolicyname`, t1.`updatedate`, t1.`updateman` FROM `t_srftssdtaskpolicy` t1  LEFT JOIN t_srftssdpolicy t11 ON t1.tssdpolicyid = t11.tssdpolicyid  LEFT JOIN t_srftssdtask t21 ON t1.tssdtaskid = t21.tssdtaskid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYID",expression="t1.`tssdpolicyid`",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYNAME",expression="t11.`tssdpolicyname`",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.`tssdtaskid`",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t21.`tssdtaskname`",showorder=9)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYID",expression="t1.`tssdtaskpolicyid`",showorder=10)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYNAME",expression="t1.`tssdtaskpolicyname`",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.TSSDPOLICYID AS TSSDPOLICYID, t11.TSSDPOLICYNAME AS TSSDPOLICYNAME, t1.TSSDTASKID AS TSSDTASKID, t21.TSSDTASKNAME AS TSSDTASKNAME, t1.TSSDTASKPOLICYID AS TSSDTASKPOLICYID, t1.TSSDTASKPOLICYNAME AS TSSDTASKPOLICYNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDTASKPOLICY t1  LEFT JOIN T_SRFTSSDPOLICY t11 ON t1.TSSDPOLICYID = t11.TSSDPOLICYID  LEFT JOIN T_SRFTSSDTASK t21 ON t1.TSSDTASKID = t21.TSSDTASKID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYID",expression="t1.TSSDPOLICYID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYNAME",expression="t11.TSSDPOLICYNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.TSSDTASKID",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t21.TSSDTASKNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYID",expression="t1.TSSDTASKPOLICYID",showorder=10)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYNAME",expression="t1.TSSDTASKPOLICYNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.TSSDPOLICYID AS TSSDPOLICYID, t11.TSSDPOLICYNAME AS TSSDPOLICYNAME, t1.TSSDTASKID AS TSSDTASKID, t21.TSSDTASKNAME AS TSSDTASKNAME, t1.TSSDTASKPOLICYID AS TSSDTASKPOLICYID, t1.TSSDTASKPOLICYNAME AS TSSDTASKPOLICYNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDTASKPOLICY t1  LEFT JOIN T_SRFTSSDPOLICY t11 ON t1.TSSDPOLICYID = t11.TSSDPOLICYID  LEFT JOIN T_SRFTSSDTASK t21 ON t1.TSSDTASKID = t21.TSSDTASKID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYID",expression="t1.TSSDPOLICYID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYNAME",expression="t11.TSSDPOLICYNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.TSSDTASKID",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t21.TSSDTASKNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYID",expression="t1.TSSDTASKPOLICYID",showorder=10)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYNAME",expression="t1.TSSDTASKPOLICYNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.TSSDPOLICYID AS TSSDPOLICYID, t11.TSSDPOLICYNAME AS TSSDPOLICYNAME, t1.TSSDTASKID AS TSSDTASKID, t21.TSSDTASKNAME AS TSSDTASKNAME, t1.TSSDTASKPOLICYID AS TSSDTASKPOLICYID, t1.TSSDTASKPOLICYNAME AS TSSDTASKPOLICYNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDTASKPOLICY t1  LEFT JOIN T_SRFTSSDPOLICY t11 ON t1.TSSDPOLICYID = t11.TSSDPOLICYID  LEFT JOIN T_SRFTSSDTASK t21 ON t1.TSSDTASKID = t21.TSSDTASKID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYID",expression="t1.TSSDPOLICYID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYNAME",expression="t11.TSSDPOLICYNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.TSSDTASKID",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t21.TSSDTASKNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYID",expression="t1.TSSDTASKPOLICYID",showorder=10)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYNAME",expression="t1.TSSDTASKPOLICYNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE] AS [CREATEDATE], t1.[CREATEMAN] AS [CREATEMAN], t1.[RESERVER] AS [RESERVER], t1.[RESERVER2] AS [RESERVER2], t1.[RESERVER3] AS [RESERVER3], t1.[RESERVER4] AS [RESERVER4], t1.[TSSDPOLICYID] AS [TSSDPOLICYID], t11.[TSSDPOLICYNAME] AS [TSSDPOLICYNAME], t1.[TSSDTASKID] AS [TSSDTASKID], t21.[TSSDTASKNAME] AS [TSSDTASKNAME], t1.[TSSDTASKPOLICYID] AS [TSSDTASKPOLICYID], t1.[TSSDTASKPOLICYNAME] AS [TSSDTASKPOLICYNAME], t1.[UPDATEDATE] AS [UPDATEDATE], t1.[UPDATEMAN] AS [UPDATEMAN] FROM [T_SRFTSSDTASKPOLICY] t1  LEFT JOIN T_SRFTSSDPOLICY t11 ON t1.TSSDPOLICYID = t11.TSSDPOLICYID  LEFT JOIN T_SRFTSSDTASK t21 ON t1.TSSDTASKID = t21.TSSDTASKID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYID",expression="t1.[TSSDPOLICYID]",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYNAME",expression="t11.[TSSDPOLICYNAME]",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.[TSSDTASKID]",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t21.[TSSDTASKNAME]",showorder=9)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYID",expression="t1.[TSSDTASKPOLICYID]",showorder=10)
        ,@DEDataQueryCodeExp(name="TSSDTASKPOLICYNAME",expression="t1.[TSSDTASKPOLICYNAME]",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=13)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class TSSDTaskPolicyDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public TSSDTaskPolicyDefaultDQModelBase() {
        super();

        this.initAnnotation(TSSDTaskPolicyDefaultDQModelBase.class);
    }

}