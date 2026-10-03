/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdpolicyowner.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="D365105B-BF2D-435F-A0E1-C5C4A6AC7816",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.TSSDPOLICYOWNERID AS TSSDPOLICYOWNERID, t1.TSSDPOLICYOWNERID2 AS TSSDPOLICYOWNERID2, t1.TSSDPOLICYOWNERNAME AS TSSDPOLICYOWNERNAME, t1.TSSDPOLICYOWNERTYPE AS TSSDPOLICYOWNERTYPE, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDPOLICYOWNER t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID",expression="t1.TSSDPOLICYOWNERID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID2",expression="t1.TSSDPOLICYOWNERID2",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERNAME",expression="t1.TSSDPOLICYOWNERNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERTYPE",expression="t1.TSSDPOLICYOWNERTYPE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`tssdpolicyownerid`, t1.`tssdpolicyownerid2`, t1.`tssdpolicyownername`, t1.`tssdpolicyownertype`, t1.`updatedate`, t1.`updateman` FROM `t_srftssdpolicyowner` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID",expression="t1.`tssdpolicyownerid`",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID2",expression="t1.`tssdpolicyownerid2`",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERNAME",expression="t1.`tssdpolicyownername`",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERTYPE",expression="t1.`tssdpolicyownertype`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.TSSDPOLICYOWNERID AS TSSDPOLICYOWNERID, t1.TSSDPOLICYOWNERID2 AS TSSDPOLICYOWNERID2, t1.TSSDPOLICYOWNERNAME AS TSSDPOLICYOWNERNAME, t1.TSSDPOLICYOWNERTYPE AS TSSDPOLICYOWNERTYPE, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDPOLICYOWNER t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID",expression="t1.TSSDPOLICYOWNERID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID2",expression="t1.TSSDPOLICYOWNERID2",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERNAME",expression="t1.TSSDPOLICYOWNERNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERTYPE",expression="t1.TSSDPOLICYOWNERTYPE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.TSSDPOLICYOWNERID AS TSSDPOLICYOWNERID, t1.TSSDPOLICYOWNERID2 AS TSSDPOLICYOWNERID2, t1.TSSDPOLICYOWNERNAME AS TSSDPOLICYOWNERNAME, t1.TSSDPOLICYOWNERTYPE AS TSSDPOLICYOWNERTYPE, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDPOLICYOWNER t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID",expression="t1.TSSDPOLICYOWNERID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID2",expression="t1.TSSDPOLICYOWNERID2",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERNAME",expression="t1.TSSDPOLICYOWNERNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERTYPE",expression="t1.TSSDPOLICYOWNERTYPE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.TSSDPOLICYOWNERID AS TSSDPOLICYOWNERID, t1.TSSDPOLICYOWNERID2 AS TSSDPOLICYOWNERID2, t1.TSSDPOLICYOWNERNAME AS TSSDPOLICYOWNERNAME, t1.TSSDPOLICYOWNERTYPE AS TSSDPOLICYOWNERTYPE, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN FROM T_SRFTSSDPOLICYOWNER t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID",expression="t1.TSSDPOLICYOWNERID",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID2",expression="t1.TSSDPOLICYOWNERID2",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERNAME",expression="t1.TSSDPOLICYOWNERNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERTYPE",expression="t1.TSSDPOLICYOWNERTYPE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE] AS [CREATEDATE], t1.[CREATEMAN] AS [CREATEMAN], t1.[RESERVER] AS [RESERVER], t1.[RESERVER2] AS [RESERVER2], t1.[RESERVER3] AS [RESERVER3], t1.[RESERVER4] AS [RESERVER4], t1.[TSSDPOLICYOWNERID] AS [TSSDPOLICYOWNERID], t1.[TSSDPOLICYOWNERID2] AS [TSSDPOLICYOWNERID2], t1.[TSSDPOLICYOWNERNAME] AS [TSSDPOLICYOWNERNAME], t1.[TSSDPOLICYOWNERTYPE] AS [TSSDPOLICYOWNERTYPE], t1.[UPDATEDATE] AS [UPDATEDATE], t1.[UPDATEMAN] AS [UPDATEMAN] FROM [T_SRFTSSDPOLICYOWNER] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID",expression="t1.[TSSDPOLICYOWNERID]",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERID2",expression="t1.[TSSDPOLICYOWNERID2]",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERNAME",expression="t1.[TSSDPOLICYOWNERNAME]",showorder=8)
        ,@DEDataQueryCodeExp(name="TSSDPOLICYOWNERTYPE",expression="t1.[TSSDPOLICYOWNERTYPE]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class TSSDPolicyOwnerDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public TSSDPolicyOwnerDefaultDQModelBase() {
        super();

        this.initAnnotation(TSSDPolicyOwnerDefaultDQModelBase.class);
    }

}