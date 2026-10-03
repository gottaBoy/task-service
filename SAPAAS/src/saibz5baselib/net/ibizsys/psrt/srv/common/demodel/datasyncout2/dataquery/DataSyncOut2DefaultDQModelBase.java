/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncout2.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="E4ECB98C-9832-4F2F-8159-427829CEAD43",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DATASYNCOUT2ID, t1.DATASYNCOUT2NAME, t1.DEID, t1.DENAME, t1.ERROR, t1.EVENTTYPE, t1.SYNCAGENT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATASYNCOUT2 t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="FILELIST",expression="t1.FILELIST",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2ID",expression="t1.DATASYNCOUT2ID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2NAME",expression="t1.DATASYNCOUT2NAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="ERROR",expression="t1.ERROR",showorder=7)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.SYNCAGENT",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`datakey`, t1.`datasyncout2id`, t1.`datasyncout2name`, t1.`deid`, t1.`dename`, t1.`error`, t1.`eventtype`, t1.`syncagent`, t1.`updatedate`, t1.`updateman` FROM `t_srfdatasyncout2` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.`data`",showorder=-1)
        ,@DEDataQueryCodeExp(name="FILELIST",expression="t1.`filelist`",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.`logicdata`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.`datakey`",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2ID",expression="t1.`datasyncout2id`",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2NAME",expression="t1.`datasyncout2name`",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.`deid`",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.`dename`",showorder=6)
        ,@DEDataQueryCodeExp(name="ERROR",expression="t1.`error`",showorder=7)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.`eventtype`",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.`syncagent`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DATASYNCOUT2ID, t1.DATASYNCOUT2NAME, t1.DEID, t1.DENAME, t1.ERROR, t1.EVENTTYPE, t1.SYNCAGENT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATASYNCOUT2 t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="FILELIST",expression="t1.FILELIST",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2ID",expression="t1.DATASYNCOUT2ID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2NAME",expression="t1.DATASYNCOUT2NAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="ERROR",expression="t1.ERROR",showorder=7)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.SYNCAGENT",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DATASYNCOUT2ID, t1.DATASYNCOUT2NAME, t1.DEID, t1.DENAME, t1.ERROR, t1.EVENTTYPE, t1.SYNCAGENT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATASYNCOUT2 t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="FILELIST",expression="t1.FILELIST",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2ID",expression="t1.DATASYNCOUT2ID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2NAME",expression="t1.DATASYNCOUT2NAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="ERROR",expression="t1.ERROR",showorder=7)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.SYNCAGENT",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DATAKEY, t1.DATASYNCOUT2ID, t1.DATASYNCOUT2NAME, t1.DEID, t1.DENAME, t1.ERROR, t1.EVENTTYPE, t1.SYNCAGENT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATASYNCOUT2 t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.DATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="FILELIST",expression="t1.FILELIST",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.LOGICDATA",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.DATAKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2ID",expression="t1.DATASYNCOUT2ID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2NAME",expression="t1.DATASYNCOUT2NAME",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.DENAME",showorder=6)
        ,@DEDataQueryCodeExp(name="ERROR",expression="t1.ERROR",showorder=7)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.EVENTTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.SYNCAGENT",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[DATAKEY], t1.[DATASYNCOUT2ID], t1.[DATASYNCOUT2NAME], t1.[DEID], t1.[DENAME], t1.[ERROR], t1.[EVENTTYPE], t1.[SYNCAGENT], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFDATASYNCOUT2] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="DATA",expression="t1.[DATA]",showorder=-1)
        ,@DEDataQueryCodeExp(name="FILELIST",expression="t1.[FILELIST]",showorder=-1)
        ,@DEDataQueryCodeExp(name="LOGICDATA",expression="t1.[LOGICDATA]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="DATAKEY",expression="t1.[DATAKEY]",showorder=2)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2ID",expression="t1.[DATASYNCOUT2ID]",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCOUT2NAME",expression="t1.[DATASYNCOUT2NAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.[DEID]",showorder=5)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t1.[DENAME]",showorder=6)
        ,@DEDataQueryCodeExp(name="ERROR",expression="t1.[ERROR]",showorder=7)
        ,@DEDataQueryCodeExp(name="EVENTTYPE",expression="t1.[EVENTTYPE]",showorder=8)
        ,@DEDataQueryCodeExp(name="SYNCAGENT",expression="t1.[SYNCAGENT]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class DataSyncOut2DefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public DataSyncOut2DefaultDQModelBase() {
        super();

        this.initAnnotation(DataSyncOut2DefaultDQModelBase.class);
    }

}