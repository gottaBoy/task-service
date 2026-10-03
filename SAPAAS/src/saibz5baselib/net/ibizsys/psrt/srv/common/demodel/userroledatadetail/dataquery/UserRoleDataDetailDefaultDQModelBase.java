/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledatadetail.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="39A7C025-DE82-4378-81BC-47A95FA43616",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.ISEXCLUDE AS ISEXCLUDE, t1.MEMO AS MEMO, t1.QUERYMODELID AS QUERYMODELID, t11.QUERYMODELNAME AS QUERYMODELNAME, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERROLEDATADETAILID AS USERROLEDATADETAILID, t1.USERROLEDATADETAILNAME AS USERROLEDATADETAILNAME, t1.USERROLEDATAID AS USERROLEDATAID, t21.USERROLEDATANAME AS USERROLEDATANAME FROM T_SRFUSERROLEDATADETAIL t1  LEFT JOIN T_SRFQUERYMODEL t11 ON t1.QUERYMODELID = t11.QUERYMODELID  LEFT JOIN T_SRFUSERROLEDATA t21 ON t1.USERROLEDATAID = t21.USERROLEDATAID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ISEXCLUDE",expression="t1.ISEXCLUDE",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="QUERYMODELID",expression="t1.QUERYMODELID",showorder=4)
        ,@DEDataQueryCodeExp(name="QUERYMODELNAME",expression="t11.QUERYMODELNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILID",expression="t1.USERROLEDATADETAILID",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILNAME",expression="t1.USERROLEDATADETAILNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=14)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t21.USERROLEDATANAME",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`isexclude`, t1.`memo`, t1.`querymodelid`, t11.`querymodelname`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`userroledatadetailid`, t1.`userroledatadetailname`, t1.`userroledataid`, t21.`userroledataname` FROM `t_srfuserroledatadetail` t1  LEFT JOIN t_srfquerymodel t11 ON t1.querymodelid = t11.querymodelid  LEFT JOIN t_srfuserroledata t21 ON t1.userroledataid = t21.userroledataid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="ISEXCLUDE",expression="t1.`isexclude`",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=3)
        ,@DEDataQueryCodeExp(name="QUERYMODELID",expression="t1.`querymodelid`",showorder=4)
        ,@DEDataQueryCodeExp(name="QUERYMODELNAME",expression="t11.`querymodelname`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILID",expression="t1.`userroledatadetailid`",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILNAME",expression="t1.`userroledatadetailname`",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.`userroledataid`",showorder=14)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t21.`userroledataname`",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.ISEXCLUDE AS ISEXCLUDE, t1.MEMO AS MEMO, t1.QUERYMODELID AS QUERYMODELID, t11.QUERYMODELNAME AS QUERYMODELNAME, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERROLEDATADETAILID AS USERROLEDATADETAILID, t1.USERROLEDATADETAILNAME AS USERROLEDATADETAILNAME, t1.USERROLEDATAID AS USERROLEDATAID, t21.USERROLEDATANAME AS USERROLEDATANAME FROM T_SRFUSERROLEDATADETAIL t1  LEFT JOIN T_SRFQUERYMODEL t11 ON t1.QUERYMODELID = t11.QUERYMODELID  LEFT JOIN T_SRFUSERROLEDATA t21 ON t1.USERROLEDATAID = t21.USERROLEDATAID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ISEXCLUDE",expression="t1.ISEXCLUDE",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="QUERYMODELID",expression="t1.QUERYMODELID",showorder=4)
        ,@DEDataQueryCodeExp(name="QUERYMODELNAME",expression="t11.QUERYMODELNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILID",expression="t1.USERROLEDATADETAILID",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILNAME",expression="t1.USERROLEDATADETAILNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=14)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t21.USERROLEDATANAME",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.ISEXCLUDE AS ISEXCLUDE, t1.MEMO AS MEMO, t1.QUERYMODELID AS QUERYMODELID, t11.QUERYMODELNAME AS QUERYMODELNAME, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERROLEDATADETAILID AS USERROLEDATADETAILID, t1.USERROLEDATADETAILNAME AS USERROLEDATADETAILNAME, t1.USERROLEDATAID AS USERROLEDATAID, t21.USERROLEDATANAME AS USERROLEDATANAME FROM T_SRFUSERROLEDATADETAIL t1  LEFT JOIN T_SRFQUERYMODEL t11 ON t1.QUERYMODELID = t11.QUERYMODELID  LEFT JOIN T_SRFUSERROLEDATA t21 ON t1.USERROLEDATAID = t21.USERROLEDATAID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ISEXCLUDE",expression="t1.ISEXCLUDE",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="QUERYMODELID",expression="t1.QUERYMODELID",showorder=4)
        ,@DEDataQueryCodeExp(name="QUERYMODELNAME",expression="t11.QUERYMODELNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILID",expression="t1.USERROLEDATADETAILID",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILNAME",expression="t1.USERROLEDATADETAILNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=14)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t21.USERROLEDATANAME",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.ISEXCLUDE AS ISEXCLUDE, t1.MEMO AS MEMO, t1.QUERYMODELID AS QUERYMODELID, t11.QUERYMODELNAME AS QUERYMODELNAME, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERROLEDATADETAILID AS USERROLEDATADETAILID, t1.USERROLEDATADETAILNAME AS USERROLEDATADETAILNAME, t1.USERROLEDATAID AS USERROLEDATAID, t21.USERROLEDATANAME AS USERROLEDATANAME FROM T_SRFUSERROLEDATADETAIL t1  LEFT JOIN T_SRFQUERYMODEL t11 ON t1.QUERYMODELID = t11.QUERYMODELID  LEFT JOIN T_SRFUSERROLEDATA t21 ON t1.USERROLEDATAID = t21.USERROLEDATAID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ISEXCLUDE",expression="t1.ISEXCLUDE",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="QUERYMODELID",expression="t1.QUERYMODELID",showorder=4)
        ,@DEDataQueryCodeExp(name="QUERYMODELNAME",expression="t11.QUERYMODELNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILID",expression="t1.USERROLEDATADETAILID",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILNAME",expression="t1.USERROLEDATADETAILNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=14)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t21.USERROLEDATANAME",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE] AS [CREATEDATE], t1.[CREATEMAN] AS [CREATEMAN], t1.[ISEXCLUDE] AS [ISEXCLUDE], t1.[MEMO] AS [MEMO], t1.[QUERYMODELID] AS [QUERYMODELID], t11.[QUERYMODELNAME] AS [QUERYMODELNAME], t1.[RESERVER] AS [RESERVER], t1.[RESERVER2] AS [RESERVER2], t1.[RESERVER3] AS [RESERVER3], t1.[RESERVER4] AS [RESERVER4], t1.[UPDATEDATE] AS [UPDATEDATE], t1.[UPDATEMAN] AS [UPDATEMAN], t1.[USERROLEDATADETAILID] AS [USERROLEDATADETAILID], t1.[USERROLEDATADETAILNAME] AS [USERROLEDATADETAILNAME], t1.[USERROLEDATAID] AS [USERROLEDATAID], t21.[USERROLEDATANAME] AS [USERROLEDATANAME] FROM [T_SRFUSERROLEDATADETAIL] t1  LEFT JOIN T_SRFQUERYMODEL t11 ON t1.QUERYMODELID = t11.QUERYMODELID  LEFT JOIN T_SRFUSERROLEDATA t21 ON t1.USERROLEDATAID = t21.USERROLEDATAID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="ISEXCLUDE",expression="t1.[ISEXCLUDE]",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=3)
        ,@DEDataQueryCodeExp(name="QUERYMODELID",expression="t1.[QUERYMODELID]",showorder=4)
        ,@DEDataQueryCodeExp(name="QUERYMODELNAME",expression="t11.[QUERYMODELNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILID",expression="t1.[USERROLEDATADETAILID]",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLEDATADETAILNAME",expression="t1.[USERROLEDATADETAILNAME]",showorder=13)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.[USERROLEDATAID]",showorder=14)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t21.[USERROLEDATANAME]",showorder=15)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserRoleDataDetailDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserRoleDataDetailDefaultDQModelBase() {
        super();

        this.initAnnotation(UserRoleDataDetailDefaultDQModelBase.class);
    }

}