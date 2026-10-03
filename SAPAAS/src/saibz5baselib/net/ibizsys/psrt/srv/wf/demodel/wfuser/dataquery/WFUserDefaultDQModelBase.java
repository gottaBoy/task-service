/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuser.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="A8AEA90E-7DDF-4AA6-BB89-D1C0BE931E79",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ISRECVWORK, t1.MEMO, t1.RECVINFORM, t1.RESERVER, t1.RESERVER2, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WFUSERID, t1.WFUSERNAME FROM T_SRFWFUSER t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ISRECVWORK",expression="t1.ISRECVWORK",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="RECVINFORM",expression="t1.RECVINFORM",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.WFUSERID",showorder=10)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t1.WFUSERNAME",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`isrecvwork`, t1.`memo`, t1.`recvinform`, t1.`reserver`, t1.`reserver2`, t1.`updatedate`, t1.`updateman`, t1.`validflag`, t1.`wfuserid`, t1.`wfusername` FROM `t_srfwfuser` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="ISRECVWORK",expression="t1.`isrecvwork`",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=3)
        ,@DEDataQueryCodeExp(name="RECVINFORM",expression="t1.`recvinform`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=8)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.`validflag`",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.`wfuserid`",showorder=10)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t1.`wfusername`",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ISRECVWORK, t1.MEMO, t1.RECVINFORM, t1.RESERVER, t1.RESERVER2, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WFUSERID, t1.WFUSERNAME FROM T_SRFWFUSER t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ISRECVWORK",expression="t1.ISRECVWORK",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="RECVINFORM",expression="t1.RECVINFORM",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.WFUSERID",showorder=10)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t1.WFUSERNAME",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ISRECVWORK, t1.MEMO, t1.RECVINFORM, t1.RESERVER, t1.RESERVER2, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WFUSERID, t1.WFUSERNAME FROM T_SRFWFUSER t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ISRECVWORK",expression="t1.ISRECVWORK",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="RECVINFORM",expression="t1.RECVINFORM",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.WFUSERID",showorder=10)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t1.WFUSERNAME",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ISRECVWORK, t1.MEMO, t1.RECVINFORM, t1.RESERVER, t1.RESERVER2, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WFUSERID, t1.WFUSERNAME FROM T_SRFWFUSER t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ISRECVWORK",expression="t1.ISRECVWORK",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="RECVINFORM",expression="t1.RECVINFORM",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.WFUSERID",showorder=10)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t1.WFUSERNAME",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[ISRECVWORK], t1.[MEMO], t1.[RECVINFORM], t1.[RESERVER], t1.[RESERVER2], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[VALIDFLAG], t1.[WFUSERID], t1.[WFUSERNAME] FROM [T_SRFWFUSER] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="ISRECVWORK",expression="t1.[ISRECVWORK]",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=3)
        ,@DEDataQueryCodeExp(name="RECVINFORM",expression="t1.[RECVINFORM]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=8)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.[VALIDFLAG]",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.[WFUSERID]",showorder=10)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t1.[WFUSERNAME]",showorder=11)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFUserDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFUserDefaultDQModelBase() {
        super();

        this.initAnnotation(WFUserDefaultDQModelBase.class);
    }

}