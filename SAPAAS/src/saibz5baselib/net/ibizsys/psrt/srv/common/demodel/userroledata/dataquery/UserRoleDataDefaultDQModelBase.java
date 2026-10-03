/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledata.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="9C190E15-614B-4F36-AB8B-B41D84F7F3D4",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.BCDR, t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t11.DENAME, t1.DSTORGID, t21.ORGNAME AS DSTORGNAME, t1.DSTORGSECTORID, t31.ORGSECTORNAME AS DSTORGSECTORNAME, t1.DSTSECBC, t1.ISALLDATA, t1.MEMO, t1.ORGDR, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SECDR, t1.SRFSYSPUB, t1.SRFUSERPUB, t1.UDVERSION, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDR, t1.USERROLEDATAID, t1.USERROLEDATANAME FROM T_SRFUSERROLEDATA t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  LEFT JOIN T_SRFORG t21 ON t1.DSTORGID = t21.ORGID  LEFT JOIN T_SRFORGSECTOR t31 ON t1.DSTORGSECTORID = t31.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="BCDR",expression="t1.BCDR",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.DENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DSTORGID",expression="t1.DSTORGID",showorder=5)
        ,@DEDataQueryCodeExp(name="DSTORGNAME",expression="t21.ORGNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORID",expression="t1.DSTORGSECTORID",showorder=7)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORNAME",expression="t31.ORGSECTORNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="DSTSECBC",expression="t1.DSTSECBC",showorder=9)
        ,@DEDataQueryCodeExp(name="ISALLDATA",expression="t1.ISALLDATA",showorder=10)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=11)
        ,@DEDataQueryCodeExp(name="ORGDR",expression="t1.ORGDR",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=15)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=16)
        ,@DEDataQueryCodeExp(name="SECDR",expression="t1.SECDR",showorder=17)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.SRFSYSPUB",showorder=18)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.SRFUSERPUB",showorder=19)
        ,@DEDataQueryCodeExp(name="UDVERSION",expression="t1.UDVERSION",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=21)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDR",expression="t1.USERDR",showorder=23)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=24)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t1.USERROLEDATANAME",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`bcdr`, t1.`createdate`, t1.`createman`, t1.`deid`, t11.`dename`, t1.`dstorgid`, t21.`orgname` AS `dstorgname`, t1.`dstorgsectorid`, t31.`orgsectorname` AS `dstorgsectorname`, t1.`dstsecbc`, t1.`isalldata`, t1.`memo`, t1.`orgdr`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`secdr`, t1.`srfsyspub`, t1.`srfuserpub`, t1.`udversion`, t1.`updatedate`, t1.`updateman`, t1.`userdr`, t1.`userroledataid`, t1.`userroledataname` FROM `t_srfuserroledata` t1  LEFT JOIN t_srfdataentity t11 ON t1.deid = t11.deid  LEFT JOIN t_srforg t21 ON t1.dstorgid = t21.orgid  LEFT JOIN t_srforgsector t31 ON t1.dstorgsectorid = t31.orgsectorid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="BCDR",expression="t1.`bcdr`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.`deid`",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.`dename`",showorder=4)
        ,@DEDataQueryCodeExp(name="DSTORGID",expression="t1.`dstorgid`",showorder=5)
        ,@DEDataQueryCodeExp(name="DSTORGNAME",expression="t21.`orgname`",showorder=6)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORID",expression="t1.`dstorgsectorid`",showorder=7)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORNAME",expression="t31.`orgsectorname`",showorder=8)
        ,@DEDataQueryCodeExp(name="DSTSECBC",expression="t1.`dstsecbc`",showorder=9)
        ,@DEDataQueryCodeExp(name="ISALLDATA",expression="t1.`isalldata`",showorder=10)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=11)
        ,@DEDataQueryCodeExp(name="ORGDR",expression="t1.`orgdr`",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=15)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=16)
        ,@DEDataQueryCodeExp(name="SECDR",expression="t1.`secdr`",showorder=17)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.`srfsyspub`",showorder=18)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.`srfuserpub`",showorder=19)
        ,@DEDataQueryCodeExp(name="UDVERSION",expression="t1.`udversion`",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=21)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDR",expression="t1.`userdr`",showorder=23)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.`userroledataid`",showorder=24)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t1.`userroledataname`",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.BCDR, t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t11.DENAME, t1.DSTORGID, t21.ORGNAME AS DSTORGNAME, t1.DSTORGSECTORID, t31.ORGSECTORNAME AS DSTORGSECTORNAME, t1.DSTSECBC, t1.ISALLDATA, t1.MEMO, t1.ORGDR, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SECDR, t1.SRFSYSPUB, t1.SRFUSERPUB, t1.UDVERSION, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDR, t1.USERROLEDATAID, t1.USERROLEDATANAME FROM T_SRFUSERROLEDATA t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  LEFT JOIN T_SRFORG t21 ON t1.DSTORGID = t21.ORGID  LEFT JOIN T_SRFORGSECTOR t31 ON t1.DSTORGSECTORID = t31.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="BCDR",expression="t1.BCDR",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.DENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DSTORGID",expression="t1.DSTORGID",showorder=5)
        ,@DEDataQueryCodeExp(name="DSTORGNAME",expression="t21.ORGNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORID",expression="t1.DSTORGSECTORID",showorder=7)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORNAME",expression="t31.ORGSECTORNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="DSTSECBC",expression="t1.DSTSECBC",showorder=9)
        ,@DEDataQueryCodeExp(name="ISALLDATA",expression="t1.ISALLDATA",showorder=10)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=11)
        ,@DEDataQueryCodeExp(name="ORGDR",expression="t1.ORGDR",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=15)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=16)
        ,@DEDataQueryCodeExp(name="SECDR",expression="t1.SECDR",showorder=17)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.SRFSYSPUB",showorder=18)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.SRFUSERPUB",showorder=19)
        ,@DEDataQueryCodeExp(name="UDVERSION",expression="t1.UDVERSION",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=21)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDR",expression="t1.USERDR",showorder=23)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=24)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t1.USERROLEDATANAME",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.BCDR, t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t11.DENAME, t1.DSTORGID, t21.ORGNAME AS DSTORGNAME, t1.DSTORGSECTORID, t31.ORGSECTORNAME AS DSTORGSECTORNAME, t1.DSTSECBC, t1.ISALLDATA, t1.MEMO, t1.ORGDR, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SECDR, t1.SRFSYSPUB, t1.SRFUSERPUB, t1.UDVERSION, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDR, t1.USERROLEDATAID, t1.USERROLEDATANAME FROM T_SRFUSERROLEDATA t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  LEFT JOIN T_SRFORG t21 ON t1.DSTORGID = t21.ORGID  LEFT JOIN T_SRFORGSECTOR t31 ON t1.DSTORGSECTORID = t31.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="BCDR",expression="t1.BCDR",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.DENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DSTORGID",expression="t1.DSTORGID",showorder=5)
        ,@DEDataQueryCodeExp(name="DSTORGNAME",expression="t21.ORGNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORID",expression="t1.DSTORGSECTORID",showorder=7)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORNAME",expression="t31.ORGSECTORNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="DSTSECBC",expression="t1.DSTSECBC",showorder=9)
        ,@DEDataQueryCodeExp(name="ISALLDATA",expression="t1.ISALLDATA",showorder=10)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=11)
        ,@DEDataQueryCodeExp(name="ORGDR",expression="t1.ORGDR",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=15)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=16)
        ,@DEDataQueryCodeExp(name="SECDR",expression="t1.SECDR",showorder=17)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.SRFSYSPUB",showorder=18)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.SRFUSERPUB",showorder=19)
        ,@DEDataQueryCodeExp(name="UDVERSION",expression="t1.UDVERSION",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=21)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDR",expression="t1.USERDR",showorder=23)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=24)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t1.USERROLEDATANAME",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.BCDR, t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t11.DENAME, t1.DSTORGID, t21.ORGNAME AS DSTORGNAME, t1.DSTORGSECTORID, t31.ORGSECTORNAME AS DSTORGSECTORNAME, t1.DSTSECBC, t1.ISALLDATA, t1.MEMO, t1.ORGDR, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SECDR, t1.SRFSYSPUB, t1.SRFUSERPUB, t1.UDVERSION, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDR, t1.USERROLEDATAID, t1.USERROLEDATANAME FROM T_SRFUSERROLEDATA t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  LEFT JOIN T_SRFORG t21 ON t1.DSTORGID = t21.ORGID  LEFT JOIN T_SRFORGSECTOR t31 ON t1.DSTORGSECTORID = t31.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="BCDR",expression="t1.BCDR",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.DENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DSTORGID",expression="t1.DSTORGID",showorder=5)
        ,@DEDataQueryCodeExp(name="DSTORGNAME",expression="t21.ORGNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORID",expression="t1.DSTORGSECTORID",showorder=7)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORNAME",expression="t31.ORGSECTORNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="DSTSECBC",expression="t1.DSTSECBC",showorder=9)
        ,@DEDataQueryCodeExp(name="ISALLDATA",expression="t1.ISALLDATA",showorder=10)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=11)
        ,@DEDataQueryCodeExp(name="ORGDR",expression="t1.ORGDR",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=15)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=16)
        ,@DEDataQueryCodeExp(name="SECDR",expression="t1.SECDR",showorder=17)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.SRFSYSPUB",showorder=18)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.SRFUSERPUB",showorder=19)
        ,@DEDataQueryCodeExp(name="UDVERSION",expression="t1.UDVERSION",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=21)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDR",expression="t1.USERDR",showorder=23)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.USERROLEDATAID",showorder=24)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t1.USERROLEDATANAME",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[BCDR], t1.[CREATEDATE], t1.[CREATEMAN], t1.[DEID], t11.[DENAME], t1.[DSTORGID], t21.[ORGNAME] AS [DSTORGNAME], t1.[DSTORGSECTORID], t31.[ORGSECTORNAME] AS [DSTORGSECTORNAME], t1.[DSTSECBC], t1.[ISALLDATA], t1.[MEMO], t1.[ORGDR], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[SECDR], t1.[SRFSYSPUB], t1.[SRFUSERPUB], t1.[UDVERSION], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERDR], t1.[USERROLEDATAID], t1.[USERROLEDATANAME] FROM [T_SRFUSERROLEDATA] t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  LEFT JOIN T_SRFORG t21 ON t1.DSTORGID = t21.ORGID  LEFT JOIN T_SRFORGSECTOR t31 ON t1.DSTORGSECTORID = t31.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="BCDR",expression="t1.[BCDR]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.[DEID]",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.[DENAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="DSTORGID",expression="t1.[DSTORGID]",showorder=5)
        ,@DEDataQueryCodeExp(name="DSTORGNAME",expression="t21.[ORGNAME]",showorder=6)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORID",expression="t1.[DSTORGSECTORID]",showorder=7)
        ,@DEDataQueryCodeExp(name="DSTORGSECTORNAME",expression="t31.[ORGSECTORNAME]",showorder=8)
        ,@DEDataQueryCodeExp(name="DSTSECBC",expression="t1.[DSTSECBC]",showorder=9)
        ,@DEDataQueryCodeExp(name="ISALLDATA",expression="t1.[ISALLDATA]",showorder=10)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=11)
        ,@DEDataQueryCodeExp(name="ORGDR",expression="t1.[ORGDR]",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=15)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=16)
        ,@DEDataQueryCodeExp(name="SECDR",expression="t1.[SECDR]",showorder=17)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.[SRFSYSPUB]",showorder=18)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.[SRFUSERPUB]",showorder=19)
        ,@DEDataQueryCodeExp(name="UDVERSION",expression="t1.[UDVERSION]",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=21)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDR",expression="t1.[USERDR]",showorder=23)
        ,@DEDataQueryCodeExp(name="USERROLEDATAID",expression="t1.[USERROLEDATAID]",showorder=24)
        ,@DEDataQueryCodeExp(name="USERROLEDATANAME",expression="t1.[USERROLEDATANAME]",showorder=25)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserRoleDataDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserRoleDataDefaultDQModelBase() {
        super();

        this.initAnnotation(UserRoleDataDefaultDQModelBase.class);
    }

}