/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncin.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="A14D2C92-C1B1-474B-BE28-C46CCD41DD59",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DATASYNCINID, t1.DATASYNCINNAME, t1.DEID, t1.DENAME, t1.EVENTTYPE, t1.FILEFLAG, t1.SYNCAGENT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATASYNCIN t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCINID",expression="t1.DATASYNCINID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCINNAME",expression="t1.DATASYNCINNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEFLAG",expression="t1.FILEFLAG",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.SYNCAGENT",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`datakey`, t1.`datasyncinid`, t1.`datasyncinname`, t1.`deid`, t1.`dename`, t1.`eventtype`, t1.`fileflag`, t1.`syncagent`, t1.`updatedate`, t1.`updateman` FROM `t_srfdatasyncin` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.`data`",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.`logicdata`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.`datakey`",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCINID",expression="t1.`datasyncinid`",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCINNAME",expression="t1.`datasyncinname`",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.`deid`",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.`dename`",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.`eventtype`",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEFLAG",expression="t1.`fileflag`",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.`syncagent`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DATASYNCINID, t1.DATASYNCINNAME, t1.DEID, t1.DENAME, t1.EVENTTYPE, t1.FILEFLAG, t1.SYNCAGENT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATASYNCIN t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCINID",expression="t1.DATASYNCINID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCINNAME",expression="t1.DATASYNCINNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEFLAG",expression="t1.FILEFLAG",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.SYNCAGENT",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DATASYNCINID, t1.DATASYNCINNAME, t1.DEID, t1.DENAME, t1.EVENTTYPE, t1.FILEFLAG, t1.SYNCAGENT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATASYNCIN t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCINID",expression="t1.DATASYNCINID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCINNAME",expression="t1.DATASYNCINNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEFLAG",expression="t1.FILEFLAG",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.SYNCAGENT",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DATASYNCINID, t1.DATASYNCINNAME, t1.DEID, t1.DENAME, t1.EVENTTYPE, t1.FILEFLAG, t1.SYNCAGENT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATASYNCIN t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCINID",expression="t1.DATASYNCINID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCINNAME",expression="t1.DATASYNCINNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEFLAG",expression="t1.FILEFLAG",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.SYNCAGENT",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[DATAKEY], t1.[DATASYNCINID], t1.[DATASYNCINNAME], t1.[DEID], t1.[DENAME], t1.[EVENTTYPE], t1.[FILEFLAG], t1.[SYNCAGENT], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFDATASYNCIN] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.[DATA]",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.[LOGICDATA]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.[DATAKEY]",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCINID",expression="t1.[DATASYNCINID]",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCINNAME",expression="t1.[DATASYNCINNAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.[DEID]",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.[DENAME]",showorder=6)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.[EVENTTYPE]",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEFLAG",expression="t1.[FILEFLAG]",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.[SYNCAGENT]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class DataSyncInDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public DataSyncInDefaultDQModelBase() {
        super();

        this.initAnnotation(DataSyncInDefaultDQModelBase.class);
    }

}