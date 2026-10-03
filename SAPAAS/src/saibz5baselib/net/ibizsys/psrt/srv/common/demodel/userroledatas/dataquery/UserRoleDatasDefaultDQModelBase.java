/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledatas.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="21B77E1F-6533-40F2-BF31-7D69A99C6EEA",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t21.DENAME AS DENAME, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERROLEDATAID AS USERROLEDATAID, t11.USERROLEDATANAME AS USERROLEDATANAME, t1.USERROLEDATASID AS USERROLEDATASID, t1.USERROLEDATASNAME AS USERROLEDATASNAME, t1.USERROLEID AS USERROLEID, t31.USERROLENAME AS USERROLENAME FROM T_SRFUSERROLEDATAS t1  LEFT JOIN T_SRFUSERROLEDATA t11 ON t1.USERROLEDATAID = t11.USERROLEDATAID  LEFT JOIN t_srfdataentity t21 ON t11.DEID = t21.DEID  LEFT JOIN T_SRFUSERROLE t31 ON t1.USERROLEID = t31.USERROLEID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t21.DENAME",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t11.USERROLEDATANAME",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDATASID",expression="t1.USERROLEDATASID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATASNAME",expression="t1.USERROLEDATASNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.USERROLEID",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t31.USERROLENAME",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t21.`dename`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`userroledataid`, t11.`userroledataname`, t1.`userroledatasid`, t1.`userroledatasname`, t1.`userroleid`, t31.`userrolename` FROM `t_srfuserroledatas` t1  LEFT JOIN t_srfuserroledata t11 ON t1.userroledataid = t11.userroledataid  LEFT JOIN t_srfdataentity t21 ON t11.deid = t21.deid  LEFT JOIN t_srfuserrole t31 ON t1.userroleid = t31.userroleid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t21.`dename`",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.`userroledataid`",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t11.`userroledataname`",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDATASID",expression="t1.`userroledatasid`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATASNAME",expression="t1.`userroledatasname`",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.`userroleid`",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t31.`userrolename`",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t21.DENAME AS DENAME, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERROLEDATAID AS USERROLEDATAID, t11.USERROLEDATANAME AS USERROLEDATANAME, t1.USERROLEDATASID AS USERROLEDATASID, t1.USERROLEDATASNAME AS USERROLEDATASNAME, t1.USERROLEID AS USERROLEID, t31.USERROLENAME AS USERROLENAME FROM T_SRFUSERROLEDATAS t1  LEFT JOIN T_SRFUSERROLEDATA t11 ON t1.USERROLEDATAID = t11.USERROLEDATAID  LEFT JOIN t_srfdataentity t21 ON t11.DEID = t21.DEID  LEFT JOIN T_SRFUSERROLE t31 ON t1.USERROLEID = t31.USERROLEID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t21.DENAME",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t11.USERROLEDATANAME",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDATASID",expression="t1.USERROLEDATASID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATASNAME",expression="t1.USERROLEDATASNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.USERROLEID",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t31.USERROLENAME",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t21.DENAME AS DENAME, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERROLEDATAID AS USERROLEDATAID, t11.USERROLEDATANAME AS USERROLEDATANAME, t1.USERROLEDATASID AS USERROLEDATASID, t1.USERROLEDATASNAME AS USERROLEDATASNAME, t1.USERROLEID AS USERROLEID, t31.USERROLENAME AS USERROLENAME FROM T_SRFUSERROLEDATAS t1  LEFT JOIN T_SRFUSERROLEDATA t11 ON t1.USERROLEDATAID = t11.USERROLEDATAID  LEFT JOIN t_srfdataentity t21 ON t11.DEID = t21.DEID  LEFT JOIN T_SRFUSERROLE t31 ON t1.USERROLEID = t31.USERROLEID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t21.DENAME",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t11.USERROLEDATANAME",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDATASID",expression="t1.USERROLEDATASID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATASNAME",expression="t1.USERROLEDATASNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.USERROLEID",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t31.USERROLENAME",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t21.DENAME AS DENAME, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERROLEDATAID AS USERROLEDATAID, t11.USERROLEDATANAME AS USERROLEDATANAME, t1.USERROLEDATASID AS USERROLEDATASID, t1.USERROLEDATASNAME AS USERROLEDATASNAME, t1.USERROLEID AS USERROLEID, t31.USERROLENAME AS USERROLENAME FROM T_SRFUSERROLEDATAS t1  LEFT JOIN T_SRFUSERROLEDATA t11 ON t1.USERROLEDATAID = t11.USERROLEDATAID  LEFT JOIN t_srfdataentity t21 ON t11.DEID = t21.DEID  LEFT JOIN T_SRFUSERROLE t31 ON t1.USERROLEID = t31.USERROLEID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t21.DENAME",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t11.USERROLEDATANAME",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDATASID",expression="t1.USERROLEDATASID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATASNAME",expression="t1.USERROLEDATASNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.USERROLEID",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t31.USERROLENAME",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE] AS [CREATEDATE], t1.[CREATEMAN] AS [CREATEMAN], t21.[DENAME] AS [DENAME], t1.[RESERVER] AS [RESERVER], t1.[RESERVER2] AS [RESERVER2], t1.[RESERVER3] AS [RESERVER3], t1.[RESERVER4] AS [RESERVER4], t1.[UPDATEDATE] AS [UPDATEDATE], t1.[UPDATEMAN] AS [UPDATEMAN], t1.[USERROLEDATAID] AS [USERROLEDATAID], t11.[USERROLEDATANAME] AS [USERROLEDATANAME], t1.[USERROLEDATASID] AS [USERROLEDATASID], t1.[USERROLEDATASNAME] AS [USERROLEDATASNAME], t1.[USERROLEID] AS [USERROLEID], t31.[USERROLENAME] AS [USERROLENAME] FROM [T_SRFUSERROLEDATAS] t1  LEFT JOIN T_SRFUSERROLEDATA t11 ON t1.USERROLEDATAID = t11.USERROLEDATAID  LEFT JOIN t_srfdataentity t21 ON t11.DEID = t21.DEID  LEFT JOIN T_SRFUSERROLE t31 ON t1.USERROLEID = t31.USERROLEID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t21.[DENAME]",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.[USERROLEDATAID]",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t11.[USERROLEDATANAME]",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDATASID",expression="t1.[USERROLEDATASID]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATASNAME",expression="t1.[USERROLEDATASNAME]",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.[USERROLEID]",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t31.[USERROLENAME]",showorder=14)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserRoleDatasDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserRoleDatasDefaultDQModelBase() {
        super();

        this.initAnnotation(UserRoleDatasDefaultDQModelBase.class);
    }

}