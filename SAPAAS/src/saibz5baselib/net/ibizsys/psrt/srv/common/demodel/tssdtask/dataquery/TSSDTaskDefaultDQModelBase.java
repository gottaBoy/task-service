/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdtask.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="ED7E4322-9554-499E-B32B-0F13A8EB8507",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLEFLAG, t1.TSSDENGINEID, t11.TSSDENGINENAME, t1.TSSDTASKID, t1.TSSDTASKNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4, t1.VERSION FROM T_SRFTSSDTASK t1  LEFT JOIN T_SRFTSSDENGINE t11 ON t1.TSSDENGINEID = t11.TSSDENGINEID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="TASKPARAM",expression="t1.TASKPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLEFLAG",expression="t1.ENABLEFLAG",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.TSSDENGINEID",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t11.TSSDENGINENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.TSSDTASKID",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t1.TSSDTASKNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=12)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`enableflag`, t1.`tssdengineid`, t11.`tssdenginename`, t1.`tssdtaskid`, t1.`tssdtaskname`, t1.`updatedate`, t1.`updateman`, t1.`userdata`, t1.`userdata2`, t1.`userdata3`, t1.`userdata4`, t1.`version` FROM `t_srftssdtask` t1  LEFT JOIN t_srftssdengine t11 ON t1.tssdengineid = t11.tssdengineid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="TASKPARAM",expression="t1.`taskparam`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLEFLAG",expression="t1.`enableflag`",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.`tssdengineid`",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t11.`tssdenginename`",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.`tssdtaskid`",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t1.`tssdtaskname`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.`userdata`",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.`userdata2`",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.`userdata3`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.`userdata4`",showorder=12)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.`version`",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLEFLAG, t1.TSSDENGINEID, t11.TSSDENGINENAME, t1.TSSDTASKID, t1.TSSDTASKNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4, t1.VERSION FROM T_SRFTSSDTASK t1  LEFT JOIN T_SRFTSSDENGINE t11 ON t1.TSSDENGINEID = t11.TSSDENGINEID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="TASKPARAM",expression="t1.TASKPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLEFLAG",expression="t1.ENABLEFLAG",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.TSSDENGINEID",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t11.TSSDENGINENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.TSSDTASKID",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t1.TSSDTASKNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=12)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLEFLAG, t1.TSSDENGINEID, t11.TSSDENGINENAME, t1.TSSDTASKID, t1.TSSDTASKNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4, t1.VERSION FROM T_SRFTSSDTASK t1  LEFT JOIN T_SRFTSSDENGINE t11 ON t1.TSSDENGINEID = t11.TSSDENGINEID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="TASKPARAM",expression="t1.TASKPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLEFLAG",expression="t1.ENABLEFLAG",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.TSSDENGINEID",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t11.TSSDENGINENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.TSSDTASKID",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t1.TSSDTASKNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=12)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLEFLAG, t1.TSSDENGINEID, t11.TSSDENGINENAME, t1.TSSDTASKID, t1.TSSDTASKNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4, t1.VERSION FROM T_SRFTSSDTASK t1  LEFT JOIN T_SRFTSSDENGINE t11 ON t1.TSSDENGINEID = t11.TSSDENGINEID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="TASKPARAM",expression="t1.TASKPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLEFLAG",expression="t1.ENABLEFLAG",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.TSSDENGINEID",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t11.TSSDENGINENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.TSSDTASKID",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t1.TSSDTASKNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=12)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[ENABLEFLAG], t1.[TSSDENGINEID], t11.[TSSDENGINENAME], t1.[TSSDTASKID], t1.[TSSDTASKNAME], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERDATA], t1.[USERDATA2], t1.[USERDATA3], t1.[USERDATA4], t1.[VERSION] FROM [T_SRFTSSDTASK] t1  LEFT JOIN T_SRFTSSDENGINE t11 ON t1.TSSDENGINEID = t11.TSSDENGINEID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="TASKPARAM",expression="t1.[TASKPARAM]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLEFLAG",expression="t1.[ENABLEFLAG]",showorder=2)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.[TSSDENGINEID]",showorder=3)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t11.[TSSDENGINENAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="TSSDTASKID",expression="t1.[TSSDTASKID]",showorder=5)
        ,@DEDataQueryCodeExp(name="TSSDTASKNAME",expression="t1.[TSSDTASKNAME]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.[USERDATA]",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.[USERDATA2]",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.[USERDATA3]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.[USERDATA4]",showorder=12)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.[VERSION]",showorder=13)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class TSSDTaskDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public TSSDTaskDefaultDQModelBase() {
        super();

        this.initAnnotation(TSSDTaskDefaultDQModelBase.class);
    }

}