/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.dedatachgdisp.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="29477383-FCCB-463B-A56E-64FAC297AC24",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEDATACHGDISPID, t1.DEDATACHGDISPNAME, t1.ENGINEOBJECT, t1.MEMO, t1.ORDERFLAG, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFDEDATACHGDISP t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPID",expression="t1.DEDATACHGDISPID",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPNAME",expression="t1.DEDATACHGDISPNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.ENGINEOBJECT",showorder=4)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=5)
        ,@DEDataQueryCodeExp(name="ORDERFLAG",expression="t1.ORDERFLAG",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`dedatachgdispid`, t1.`dedatachgdispname`, t1.`engineobject`, t1.`memo`, t1.`orderflag`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`validflag` FROM `t_srfdedatachgdisp` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPID",expression="t1.`dedatachgdispid`",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPNAME",expression="t1.`dedatachgdispname`",showorder=3)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.`engineobject`",showorder=4)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=5)
        ,@DEDataQueryCodeExp(name="ORDERFLAG",expression="t1.`orderflag`",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=12)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.`validflag`",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEDATACHGDISPID, t1.DEDATACHGDISPNAME, t1.ENGINEOBJECT, t1.MEMO, t1.ORDERFLAG, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFDEDATACHGDISP t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPID",expression="t1.DEDATACHGDISPID",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPNAME",expression="t1.DEDATACHGDISPNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.ENGINEOBJECT",showorder=4)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=5)
        ,@DEDataQueryCodeExp(name="ORDERFLAG",expression="t1.ORDERFLAG",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEDATACHGDISPID, t1.DEDATACHGDISPNAME, t1.ENGINEOBJECT, t1.MEMO, t1.ORDERFLAG, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFDEDATACHGDISP t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPID",expression="t1.DEDATACHGDISPID",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPNAME",expression="t1.DEDATACHGDISPNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.ENGINEOBJECT",showorder=4)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=5)
        ,@DEDataQueryCodeExp(name="ORDERFLAG",expression="t1.ORDERFLAG",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DEDATACHGDISPID, t1.DEDATACHGDISPNAME, t1.ENGINEOBJECT, t1.MEMO, t1.ORDERFLAG, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFDEDATACHGDISP t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPID",expression="t1.DEDATACHGDISPID",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPNAME",expression="t1.DEDATACHGDISPNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.ENGINEOBJECT",showorder=4)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=5)
        ,@DEDataQueryCodeExp(name="ORDERFLAG",expression="t1.ORDERFLAG",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[DEDATACHGDISPID], t1.[DEDATACHGDISPNAME], t1.[ENGINEOBJECT], t1.[MEMO], t1.[ORDERFLAG], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[VALIDFLAG] FROM [T_SRFDEDATACHGDISP] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPID",expression="t1.[DEDATACHGDISPID]",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGDISPNAME",expression="t1.[DEDATACHGDISPNAME]",showorder=3)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.[ENGINEOBJECT]",showorder=4)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=5)
        ,@DEDataQueryCodeExp(name="ORDERFLAG",expression="t1.[ORDERFLAG]",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=12)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.[VALIDFLAG]",showorder=13)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class DEDataChgDispDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public DEDataChgDispDefaultDQModelBase() {
        super();

        this.initAnnotation(DEDataChgDispDefaultDQModelBase.class);
    }

}