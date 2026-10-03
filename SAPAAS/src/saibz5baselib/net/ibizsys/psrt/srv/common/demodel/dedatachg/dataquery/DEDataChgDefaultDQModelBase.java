/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.dedatachg.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="6EBA0D55-8C03-4647-B442-32399C8FA930",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DEDATACHGID, t1.DEDATACHGNAME, t1.DEID, t1.DENAME, t1.EVENTTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDEDATACHG t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGID",expression="t1.DEDATACHGID",showorder=3)
        ,@DEDataQueryCodeExp(name="DEDATACHGNAME",expression="t1.DEDATACHGNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`datakey`, t1.`dedatachgid`, t1.`dedatachgname`, t1.`deid`, t1.`dename`, t1.`eventtype`, t1.`updatedate`, t1.`updateman` FROM `t_srfdedatachg` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.`data`",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.`logicdata`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.`datakey`",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGID",expression="t1.`dedatachgid`",showorder=3)
        ,@DEDataQueryCodeExp(name="DEDATACHGNAME",expression="t1.`dedatachgname`",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.`deid`",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.`dename`",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.`eventtype`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DEDATACHGID, t1.DEDATACHGNAME, t1.DEID, t1.DENAME, t1.EVENTTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDEDATACHG t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGID",expression="t1.DEDATACHGID",showorder=3)
        ,@DEDataQueryCodeExp(name="DEDATACHGNAME",expression="t1.DEDATACHGNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DEDATACHGID, t1.DEDATACHGNAME, t1.DEID, t1.DENAME, t1.EVENTTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDEDATACHG t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGID",expression="t1.DEDATACHGID",showorder=3)
        ,@DEDataQueryCodeExp(name="DEDATACHGNAME",expression="t1.DEDATACHGNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DEDATACHGID, t1.DEDATACHGNAME, t1.DEID, t1.DENAME, t1.EVENTTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDEDATACHG t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGID",expression="t1.DEDATACHGID",showorder=3)
        ,@DEDataQueryCodeExp(name="DEDATACHGNAME",expression="t1.DEDATACHGNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[DATAKEY], t1.[DEDATACHGID], t1.[DEDATACHGNAME], t1.[DEID], t1.[DENAME], t1.[EVENTTYPE], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFDEDATACHG] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.[DATA]",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.[LOGICDATA]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.[DATAKEY]",showorder=2)
        ,@DEDataQueryCodeExp(name="DEDATACHGID",expression="t1.[DEDATACHGID]",showorder=3)
        ,@DEDataQueryCodeExp(name="DEDATACHGNAME",expression="t1.[DEDATACHGNAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.[DEID]",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.[DENAME]",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.[EVENTTYPE]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=9)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class DEDataChgDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public DEDataChgDefaultDQModelBase() {
        super();

        this.initAnnotation(DEDataChgDefaultDQModelBase.class);
    }

}