/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxorgsector.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="6E8FF7D3-FD25-43A7-92C0-000AD52828BC",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEPTID, t1.MEMO, t1.ORGSECTORID, t11.ORGSECTORNAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCOUNTID, t1.WXACCOUNTNAME, t1.WXORGSECTORID, t1.WXORGSECTORNAME FROM T_SRFWXORGSECTOR t1  LEFT JOIN T_SRFORGSECTOR t11 ON t1.ORGSECTORID = t11.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DEPTID",expression="t1.DEPTID",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="ORGSECTORID",expression="t1.ORGSECTORID",showorder=4)
        ,@DEDataQueryCodeExp(name="ORGSECTORNAME",expression="t11.ORGSECTORNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="WXORGSECTORID",expression="t1.WXORGSECTORID",showorder=14)
        ,@DEDataQueryCodeExp(name="WXORGSECTORNAME",expression="t1.WXORGSECTORNAME",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`deptid`, t1.`memo`, t1.`orgsectorid`, t11.`orgsectorname`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`wxaccountid`, t1.`wxaccountname`, t1.`wxorgsectorid`, t1.`wxorgsectorname` FROM `t_srfwxorgsector` t1  LEFT JOIN t_srforgsector t11 ON t1.orgsectorid = t11.orgsectorid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="DEPTID",expression="t1.`deptid`",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=3)
        ,@DEDataQueryCodeExp(name="ORGSECTORID",expression="t1.`orgsectorid`",showorder=4)
        ,@DEDataQueryCodeExp(name="ORGSECTORNAME",expression="t11.`orgsectorname`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.`wxaccountid`",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.`wxaccountname`",showorder=13)
        ,@DEDataQueryCodeExp(name="WXORGSECTORID",expression="t1.`wxorgsectorid`",showorder=14)
        ,@DEDataQueryCodeExp(name="WXORGSECTORNAME",expression="t1.`wxorgsectorname`",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEPTID, t1.MEMO, t1.ORGSECTORID, t11.ORGSECTORNAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCOUNTID, t1.WXACCOUNTNAME, t1.WXORGSECTORID, t1.WXORGSECTORNAME FROM T_SRFWXORGSECTOR t1  LEFT JOIN T_SRFORGSECTOR t11 ON t1.ORGSECTORID = t11.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DEPTID",expression="t1.DEPTID",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="ORGSECTORID",expression="t1.ORGSECTORID",showorder=4)
        ,@DEDataQueryCodeExp(name="ORGSECTORNAME",expression="t11.ORGSECTORNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="WXORGSECTORID",expression="t1.WXORGSECTORID",showorder=14)
        ,@DEDataQueryCodeExp(name="WXORGSECTORNAME",expression="t1.WXORGSECTORNAME",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEPTID, t1.MEMO, t1.ORGSECTORID, t11.ORGSECTORNAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCOUNTID, t1.WXACCOUNTNAME, t1.WXORGSECTORID, t1.WXORGSECTORNAME FROM T_SRFWXORGSECTOR t1  LEFT JOIN T_SRFORGSECTOR t11 ON t1.ORGSECTORID = t11.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DEPTID",expression="t1.DEPTID",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="ORGSECTORID",expression="t1.ORGSECTORID",showorder=4)
        ,@DEDataQueryCodeExp(name="ORGSECTORNAME",expression="t11.ORGSECTORNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="WXORGSECTORID",expression="t1.WXORGSECTORID",showorder=14)
        ,@DEDataQueryCodeExp(name="WXORGSECTORNAME",expression="t1.WXORGSECTORNAME",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEPTID, t1.MEMO, t1.ORGSECTORID, t11.ORGSECTORNAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCOUNTID, t1.WXACCOUNTNAME, t1.WXORGSECTORID, t1.WXORGSECTORNAME FROM T_SRFWXORGSECTOR t1  LEFT JOIN T_SRFORGSECTOR t11 ON t1.ORGSECTORID = t11.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DEPTID",expression="t1.DEPTID",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="ORGSECTORID",expression="t1.ORGSECTORID",showorder=4)
        ,@DEDataQueryCodeExp(name="ORGSECTORNAME",expression="t11.ORGSECTORNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="WXORGSECTORID",expression="t1.WXORGSECTORID",showorder=14)
        ,@DEDataQueryCodeExp(name="WXORGSECTORNAME",expression="t1.WXORGSECTORNAME",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[DEPTID], t1.[MEMO], t1.[ORGSECTORID], t11.[ORGSECTORNAME], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WXACCOUNTID], t1.[WXACCOUNTNAME], t1.[WXORGSECTORID], t1.[WXORGSECTORNAME] FROM [T_SRFWXORGSECTOR] t1  LEFT JOIN T_SRFORGSECTOR t11 ON t1.ORGSECTORID = t11.ORGSECTORID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="DEPTID",expression="t1.[DEPTID]",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=3)
        ,@DEDataQueryCodeExp(name="ORGSECTORID",expression="t1.[ORGSECTORID]",showorder=4)
        ,@DEDataQueryCodeExp(name="ORGSECTORNAME",expression="t11.[ORGSECTORNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.[WXACCOUNTID]",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.[WXACCOUNTNAME]",showorder=13)
        ,@DEDataQueryCodeExp(name="WXORGSECTORID",expression="t1.[WXORGSECTORID]",showorder=14)
        ,@DEDataQueryCodeExp(name="WXORGSECTORNAME",expression="t1.[WXORGSECTORNAME]",showorder=15)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WXOrgSectorDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WXOrgSectorDefaultDQModelBase() {
        super();

        this.initAnnotation(WXOrgSectorDefaultDQModelBase.class);
    }

}