/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfucpolicy.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="7476674A-5DBF-4358-BABB-C92BBE4804C3",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.MAJORWFUSERID, t11.WFUSERNAME AS MAJORWFUSERNAME, t1.MEMO, t1.MINORWFUSERID, t21.WFUSERNAME AS MINORWFUSERNAME, t1.POLICYSTATE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.VALIDFLAG, t1.WFUCPOLICYID, t1.WFUCPOLICYNAME FROM T_SRFWFUCPOLICY t1  LEFT JOIN T_SRFWFUSER t11 ON t1.MAJORWFUSERID = t11.WFUSERID  LEFT JOIN T_SRFWFUSER t21 ON t1.MINORWFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="BEGINTIME",expression="t1.BEGINTIME",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="ENDTIME",expression="t1.ENDTIME",showorder=3)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERID",expression="t1.MAJORWFUSERID",showorder=4)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERNAME",expression="t11.WFUSERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=6)
        ,@DEDataQueryCodeExp(name="MINORWFUSERID",expression="t1.MINORWFUSERID",showorder=7)
        ,@DEDataQueryCodeExp(name="MINORWFUSERNAME",expression="t21.WFUSERNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="POLICYSTATE",expression="t1.POLICYSTATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=12)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=13)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=14)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYID",expression="t1.WFUCPOLICYID",showorder=15)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYNAME",expression="t1.WFUCPOLICYNAME",showorder=16)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`begintime`, t1.`createdate`, t1.`createman`, t1.`endtime`, t1.`majorwfuserid`, t11.`wfusername` AS `majorwfusername`, t1.`memo`, t1.`minorwfuserid`, t21.`wfusername` AS `minorwfusername`, t1.`policystate`, t1.`updatedate`, t1.`updateman`, t1.`userdata`, t1.`userdata2`, t1.`validflag`, t1.`wfucpolicyid`, t1.`wfucpolicyname` FROM `t_srfwfucpolicy` t1  LEFT JOIN t_srfwfuser t11 ON t1.majorwfuserid = t11.wfuserid  LEFT JOIN t_srfwfuser t21 ON t1.minorwfuserid = t21.wfuserid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="BEGINTIME",expression="t1.`begintime`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="ENDTIME",expression="t1.`endtime`",showorder=3)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERID",expression="t1.`majorwfuserid`",showorder=4)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERNAME",expression="t11.`wfusername`",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=6)
        ,@DEDataQueryCodeExp(name="MINORWFUSERID",expression="t1.`minorwfuserid`",showorder=7)
        ,@DEDataQueryCodeExp(name="MINORWFUSERNAME",expression="t21.`wfusername`",showorder=8)
        ,@DEDataQueryCodeExp(name="POLICYSTATE",expression="t1.`policystate`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.`userdata`",showorder=12)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.`userdata2`",showorder=13)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.`validflag`",showorder=14)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYID",expression="t1.`wfucpolicyid`",showorder=15)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYNAME",expression="t1.`wfucpolicyname`",showorder=16)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.MAJORWFUSERID, t11.WFUSERNAME AS MAJORWFUSERNAME, t1.MEMO, t1.MINORWFUSERID, t21.WFUSERNAME AS MINORWFUSERNAME, t1.POLICYSTATE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.VALIDFLAG, t1.WFUCPOLICYID, t1.WFUCPOLICYNAME FROM T_SRFWFUCPOLICY t1  LEFT JOIN T_SRFWFUSER t11 ON t1.MAJORWFUSERID = t11.WFUSERID  LEFT JOIN T_SRFWFUSER t21 ON t1.MINORWFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="BEGINTIME",expression="t1.BEGINTIME",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="ENDTIME",expression="t1.ENDTIME",showorder=3)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERID",expression="t1.MAJORWFUSERID",showorder=4)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERNAME",expression="t11.WFUSERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=6)
        ,@DEDataQueryCodeExp(name="MINORWFUSERID",expression="t1.MINORWFUSERID",showorder=7)
        ,@DEDataQueryCodeExp(name="MINORWFUSERNAME",expression="t21.WFUSERNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="POLICYSTATE",expression="t1.POLICYSTATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=12)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=13)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=14)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYID",expression="t1.WFUCPOLICYID",showorder=15)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYNAME",expression="t1.WFUCPOLICYNAME",showorder=16)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.MAJORWFUSERID, t11.WFUSERNAME AS MAJORWFUSERNAME, t1.MEMO, t1.MINORWFUSERID, t21.WFUSERNAME AS MINORWFUSERNAME, t1.POLICYSTATE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.VALIDFLAG, t1.WFUCPOLICYID, t1.WFUCPOLICYNAME FROM T_SRFWFUCPOLICY t1  LEFT JOIN T_SRFWFUSER t11 ON t1.MAJORWFUSERID = t11.WFUSERID  LEFT JOIN T_SRFWFUSER t21 ON t1.MINORWFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="BEGINTIME",expression="t1.BEGINTIME",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="ENDTIME",expression="t1.ENDTIME",showorder=3)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERID",expression="t1.MAJORWFUSERID",showorder=4)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERNAME",expression="t11.WFUSERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=6)
        ,@DEDataQueryCodeExp(name="MINORWFUSERID",expression="t1.MINORWFUSERID",showorder=7)
        ,@DEDataQueryCodeExp(name="MINORWFUSERNAME",expression="t21.WFUSERNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="POLICYSTATE",expression="t1.POLICYSTATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=12)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=13)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=14)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYID",expression="t1.WFUCPOLICYID",showorder=15)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYNAME",expression="t1.WFUCPOLICYNAME",showorder=16)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.MAJORWFUSERID, t11.WFUSERNAME AS MAJORWFUSERNAME, t1.MEMO, t1.MINORWFUSERID, t21.WFUSERNAME AS MINORWFUSERNAME, t1.POLICYSTATE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.VALIDFLAG, t1.WFUCPOLICYID, t1.WFUCPOLICYNAME FROM T_SRFWFUCPOLICY t1  LEFT JOIN T_SRFWFUSER t11 ON t1.MAJORWFUSERID = t11.WFUSERID  LEFT JOIN T_SRFWFUSER t21 ON t1.MINORWFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="BEGINTIME",expression="t1.BEGINTIME",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="ENDTIME",expression="t1.ENDTIME",showorder=3)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERID",expression="t1.MAJORWFUSERID",showorder=4)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERNAME",expression="t11.WFUSERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=6)
        ,@DEDataQueryCodeExp(name="MINORWFUSERID",expression="t1.MINORWFUSERID",showorder=7)
        ,@DEDataQueryCodeExp(name="MINORWFUSERNAME",expression="t21.WFUSERNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="POLICYSTATE",expression="t1.POLICYSTATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=12)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=13)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=14)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYID",expression="t1.WFUCPOLICYID",showorder=15)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYNAME",expression="t1.WFUCPOLICYNAME",showorder=16)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[BEGINTIME], t1.[CREATEDATE], t1.[CREATEMAN], t1.[ENDTIME], t1.[MAJORWFUSERID], t11.[WFUSERNAME] AS [MAJORWFUSERNAME], t1.[MEMO], t1.[MINORWFUSERID], t21.[WFUSERNAME] AS [MINORWFUSERNAME], t1.[POLICYSTATE], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERDATA], t1.[USERDATA2], t1.[VALIDFLAG], t1.[WFUCPOLICYID], t1.[WFUCPOLICYNAME] FROM [T_SRFWFUCPOLICY] t1  LEFT JOIN T_SRFWFUSER t11 ON t1.MAJORWFUSERID = t11.WFUSERID  LEFT JOIN T_SRFWFUSER t21 ON t1.MINORWFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="BEGINTIME",expression="t1.[BEGINTIME]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="ENDTIME",expression="t1.[ENDTIME]",showorder=3)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERID",expression="t1.[MAJORWFUSERID]",showorder=4)
        ,@DEDataQueryCodeExp(name="MAJORWFUSERNAME",expression="t11.[WFUSERNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=6)
        ,@DEDataQueryCodeExp(name="MINORWFUSERID",expression="t1.[MINORWFUSERID]",showorder=7)
        ,@DEDataQueryCodeExp(name="MINORWFUSERNAME",expression="t21.[WFUSERNAME]",showorder=8)
        ,@DEDataQueryCodeExp(name="POLICYSTATE",expression="t1.[POLICYSTATE]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.[USERDATA]",showorder=12)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.[USERDATA2]",showorder=13)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.[VALIDFLAG]",showorder=14)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYID",expression="t1.[WFUCPOLICYID]",showorder=15)
        ,@DEDataQueryCodeExp(name="WFUCPOLICYNAME",expression="t1.[WFUCPOLICYNAME]",showorder=16)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFUCPolicyDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFUCPolicyDefaultDQModelBase() {
        super();

        this.initAnnotation(WFUCPolicyDefaultDQModelBase.class);
    }

}