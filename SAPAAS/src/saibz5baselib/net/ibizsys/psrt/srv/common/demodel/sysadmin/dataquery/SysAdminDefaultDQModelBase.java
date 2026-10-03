/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.sysadmin.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="E569F918-C2CF-4BC5-8F13-60FCE083A83C",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.ADMINOBJECT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SYSADMINID, t1.SYSADMINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFSYSADMIN t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t1.ADMINOBJECT",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.SYSADMINID",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t1.SYSADMINNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`adminobject`, t1.`createdate`, t1.`createman`, t1.`memo`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`sysadminid`, t1.`sysadminname`, t1.`updatedate`, t1.`updateman` FROM `t_srfsysadmin` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t1.`adminobject`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.`sysadminid`",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t1.`sysadminname`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ADMINOBJECT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SYSADMINID, t1.SYSADMINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFSYSADMIN t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t1.ADMINOBJECT",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.SYSADMINID",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t1.SYSADMINNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ADMINOBJECT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SYSADMINID, t1.SYSADMINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFSYSADMIN t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t1.ADMINOBJECT",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.SYSADMINID",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t1.SYSADMINNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ADMINOBJECT, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SYSADMINID, t1.SYSADMINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFSYSADMIN t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t1.ADMINOBJECT",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.SYSADMINID",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t1.SYSADMINNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[ADMINOBJECT], t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[SYSADMINID], t1.[SYSADMINNAME], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFSYSADMIN] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t1.[ADMINOBJECT]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.[SYSADMINID]",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t1.[SYSADMINNAME]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class SysAdminDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public SysAdminDefaultDQModelBase() {
        super();

        this.initAnnotation(SysAdminDefaultDQModelBase.class);
    }

}