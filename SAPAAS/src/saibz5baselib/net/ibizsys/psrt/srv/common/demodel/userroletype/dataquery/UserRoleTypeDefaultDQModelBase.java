/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroletype.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="4E220EBE-F3F4-4428-A744-E5BF7CA00DA2",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.MEMO AS MEMO, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERDATA AS USERDATA, t1.USERDATA2 AS USERDATA2, t1.USERROLETYPEID AS USERROLETYPEID, t1.USERROLETYPENAME AS USERROLETYPENAME FROM T_SRFUSERROLETYPE t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLETYPEID",expression="t1.USERROLETYPEID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLETYPENAME",expression="t1.USERROLETYPENAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`memo`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`userdata`, t1.`userdata2`, t1.`userroletypeid`, t1.`userroletypename` FROM `t_srfuserroletype` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.`userdata`",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.`userdata2`",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLETYPEID",expression="t1.`userroletypeid`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLETYPENAME",expression="t1.`userroletypename`",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.MEMO AS MEMO, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERDATA AS USERDATA, t1.USERDATA2 AS USERDATA2, t1.USERROLETYPEID AS USERROLETYPEID, t1.USERROLETYPENAME AS USERROLETYPENAME FROM T_SRFUSERROLETYPE t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLETYPEID",expression="t1.USERROLETYPEID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLETYPENAME",expression="t1.USERROLETYPENAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.MEMO AS MEMO, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERDATA AS USERDATA, t1.USERDATA2 AS USERDATA2, t1.USERROLETYPEID AS USERROLETYPEID, t1.USERROLETYPENAME AS USERROLETYPENAME FROM T_SRFUSERROLETYPE t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLETYPEID",expression="t1.USERROLETYPEID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLETYPENAME",expression="t1.USERROLETYPENAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.MEMO AS MEMO, t1.RESERVER AS RESERVER, t1.RESERVER2 AS RESERVER2, t1.RESERVER3 AS RESERVER3, t1.RESERVER4 AS RESERVER4, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.USERDATA AS USERDATA, t1.USERDATA2 AS USERDATA2, t1.USERROLETYPEID AS USERROLETYPEID, t1.USERROLETYPENAME AS USERROLETYPENAME FROM T_SRFUSERROLETYPE t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLETYPEID",expression="t1.USERROLETYPEID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLETYPENAME",expression="t1.USERROLETYPENAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE] AS [CREATEDATE], t1.[CREATEMAN] AS [CREATEMAN], t1.[MEMO] AS [MEMO], t1.[RESERVER] AS [RESERVER], t1.[RESERVER2] AS [RESERVER2], t1.[RESERVER3] AS [RESERVER3], t1.[RESERVER4] AS [RESERVER4], t1.[UPDATEDATE] AS [UPDATEDATE], t1.[UPDATEMAN] AS [UPDATEMAN], t1.[USERDATA] AS [USERDATA], t1.[USERDATA2] AS [USERDATA2], t1.[USERROLETYPEID] AS [USERROLETYPEID], t1.[USERROLETYPENAME] AS [USERROLETYPENAME] FROM [T_SRFUSERROLETYPE] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.[USERDATA]",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.[USERDATA2]",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLETYPEID",expression="t1.[USERROLETYPEID]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLETYPENAME",expression="t1.[USERROLETYPENAME]",showorder=12)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserRoleTypeDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserRoleTypeDefaultDQModelBase() {
        super();

        this.initAnnotation(UserRoleTypeDefaultDQModelBase.class);
    }

}