/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.sysadminfunc.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="52B5E5D1-4857-479F-AEAF-69B444AE4B5A",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t11.ADMINOBJECT, t1.CREATEDATE, t1.CREATEMAN, t1.FUNCID, t1.MEMO, t1.PARAM, t1.SYSADMINFUNCID, t1.SYSADMINFUNCNAME, t1.SYSADMINID, t11.SYSADMINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFSYSADMINFUNC t1  LEFT JOIN T_SRFSYSADMIN t11 ON t1.SYSADMINID = t11.SYSADMINID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t11.ADMINOBJECT",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="FUNCID",expression="t1.FUNCID",showorder=3)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM",expression="t1.PARAM",showorder=5)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCID",expression="t1.SYSADMINFUNCID",showorder=6)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCNAME",expression="t1.SYSADMINFUNCNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.SYSADMINID",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t11.SYSADMINNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t11.`adminobject`, t1.`createdate`, t1.`createman`, t1.`funcid`, t1.`memo`, t1.`param`, t1.`sysadminfuncid`, t1.`sysadminfuncname`, t1.`sysadminid`, t11.`sysadminname`, t1.`updatedate`, t1.`updateman` FROM `t_srfsysadminfunc` t1  LEFT JOIN t_srfsysadmin t11 ON t1.sysadminid = t11.sysadminid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t11.`adminobject`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="FUNCID",expression="t1.`funcid`",showorder=3)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM",expression="t1.`param`",showorder=5)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCID",expression="t1.`sysadminfuncid`",showorder=6)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCNAME",expression="t1.`sysadminfuncname`",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.`sysadminid`",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t11.`sysadminname`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t11.ADMINOBJECT, t1.CREATEDATE, t1.CREATEMAN, t1.FUNCID, t1.MEMO, t1.PARAM, t1.SYSADMINFUNCID, t1.SYSADMINFUNCNAME, t1.SYSADMINID, t11.SYSADMINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFSYSADMINFUNC t1  LEFT JOIN T_SRFSYSADMIN t11 ON t1.SYSADMINID = t11.SYSADMINID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t11.ADMINOBJECT",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="FUNCID",expression="t1.FUNCID",showorder=3)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM",expression="t1.PARAM",showorder=5)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCID",expression="t1.SYSADMINFUNCID",showorder=6)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCNAME",expression="t1.SYSADMINFUNCNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.SYSADMINID",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t11.SYSADMINNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t11.ADMINOBJECT, t1.CREATEDATE, t1.CREATEMAN, t1.FUNCID, t1.MEMO, t1.PARAM, t1.SYSADMINFUNCID, t1.SYSADMINFUNCNAME, t1.SYSADMINID, t11.SYSADMINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFSYSADMINFUNC t1  LEFT JOIN T_SRFSYSADMIN t11 ON t1.SYSADMINID = t11.SYSADMINID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t11.ADMINOBJECT",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="FUNCID",expression="t1.FUNCID",showorder=3)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM",expression="t1.PARAM",showorder=5)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCID",expression="t1.SYSADMINFUNCID",showorder=6)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCNAME",expression="t1.SYSADMINFUNCNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.SYSADMINID",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t11.SYSADMINNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t11.ADMINOBJECT, t1.CREATEDATE, t1.CREATEMAN, t1.FUNCID, t1.MEMO, t1.PARAM, t1.SYSADMINFUNCID, t1.SYSADMINFUNCNAME, t1.SYSADMINID, t11.SYSADMINNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFSYSADMINFUNC t1  LEFT JOIN T_SRFSYSADMIN t11 ON t1.SYSADMINID = t11.SYSADMINID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t11.ADMINOBJECT",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="FUNCID",expression="t1.FUNCID",showorder=3)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM",expression="t1.PARAM",showorder=5)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCID",expression="t1.SYSADMINFUNCID",showorder=6)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCNAME",expression="t1.SYSADMINFUNCNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.SYSADMINID",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t11.SYSADMINNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t11.[ADMINOBJECT], t1.[CREATEDATE], t1.[CREATEMAN], t1.[FUNCID], t1.[MEMO], t1.[PARAM], t1.[SYSADMINFUNCID], t1.[SYSADMINFUNCNAME], t1.[SYSADMINID], t11.[SYSADMINNAME], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFSYSADMINFUNC] t1  LEFT JOIN T_SRFSYSADMIN t11 ON t1.SYSADMINID = t11.SYSADMINID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="ADMINOBJECT",expression="t11.[ADMINOBJECT]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="FUNCID",expression="t1.[FUNCID]",showorder=3)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM",expression="t1.[PARAM]",showorder=5)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCID",expression="t1.[SYSADMINFUNCID]",showorder=6)
        ,@DEDataQueryCodeExp(name="SYSADMINFUNCNAME",expression="t1.[SYSADMINFUNCNAME]",showorder=7)
        ,@DEDataQueryCodeExp(name="SYSADMINID",expression="t1.[SYSADMINID]",showorder=8)
        ,@DEDataQueryCodeExp(name="SYSADMINNAME",expression="t11.[SYSADMINNAME]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class SysAdminFuncDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public SysAdminFuncDefaultDQModelBase() {
        super();

        this.initAnnotation(SysAdminFuncDefaultDQModelBase.class);
    }

}