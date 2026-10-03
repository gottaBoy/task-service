/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfstepinst.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="C9AE1372-E208-4120-B0F0-ABD3B1869845",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CLOSEFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.RETURNDATA, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFINSTANCEID, t1.WFINSTANCENAME, t1.WFSTEPID, t1.WFSTEPINSTID, t1.WFSTEPINSTNAME, t1.WFSTEPLANRESTAG, t1.WFSTEPNAME FROM T_SRFWFSTEPINST t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CLOSEFLAG",expression="t1.CLOSEFLAG",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="RETURNDATA",expression="t1.RETURNDATA",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.WFINSTANCEID",showorder=6)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.WFINSTANCENAME",showorder=7)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.WFSTEPID",showorder=8)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTID",expression="t1.WFSTEPINSTID",showorder=9)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTNAME",expression="t1.WFSTEPINSTNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.WFSTEPLANRESTAG",showorder=11)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.WFSTEPNAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`closeflag`, t1.`createdate`, t1.`createman`, t1.`returndata`, t1.`updatedate`, t1.`updateman`, t1.`wfinstanceid`, t1.`wfinstancename`, t1.`wfstepid`, t1.`wfstepinstid`, t1.`wfstepinstname`, t1.`wfsteplanrestag`, t1.`wfstepname` FROM `t_srfwfstepinst` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CLOSEFLAG",expression="t1.`closeflag`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="RETURNDATA",expression="t1.`returndata`",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=5)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.`wfinstanceid`",showorder=6)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.`wfinstancename`",showorder=7)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.`wfstepid`",showorder=8)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTID",expression="t1.`wfstepinstid`",showorder=9)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTNAME",expression="t1.`wfstepinstname`",showorder=10)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.`wfsteplanrestag`",showorder=11)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.`wfstepname`",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CLOSEFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.RETURNDATA, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFINSTANCEID, t1.WFINSTANCENAME, t1.WFSTEPID, t1.WFSTEPINSTID, t1.WFSTEPINSTNAME, t1.WFSTEPLANRESTAG, t1.WFSTEPNAME FROM T_SRFWFSTEPINST t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CLOSEFLAG",expression="t1.CLOSEFLAG",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="RETURNDATA",expression="t1.RETURNDATA",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.WFINSTANCEID",showorder=6)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.WFINSTANCENAME",showorder=7)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.WFSTEPID",showorder=8)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTID",expression="t1.WFSTEPINSTID",showorder=9)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTNAME",expression="t1.WFSTEPINSTNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.WFSTEPLANRESTAG",showorder=11)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.WFSTEPNAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CLOSEFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.RETURNDATA, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFINSTANCEID, t1.WFINSTANCENAME, t1.WFSTEPID, t1.WFSTEPINSTID, t1.WFSTEPINSTNAME, t1.WFSTEPLANRESTAG, t1.WFSTEPNAME FROM T_SRFWFSTEPINST t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CLOSEFLAG",expression="t1.CLOSEFLAG",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="RETURNDATA",expression="t1.RETURNDATA",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.WFINSTANCEID",showorder=6)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.WFINSTANCENAME",showorder=7)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.WFSTEPID",showorder=8)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTID",expression="t1.WFSTEPINSTID",showorder=9)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTNAME",expression="t1.WFSTEPINSTNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.WFSTEPLANRESTAG",showorder=11)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.WFSTEPNAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CLOSEFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.RETURNDATA, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFINSTANCEID, t1.WFINSTANCENAME, t1.WFSTEPID, t1.WFSTEPINSTID, t1.WFSTEPINSTNAME, t1.WFSTEPLANRESTAG, t1.WFSTEPNAME FROM T_SRFWFSTEPINST t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CLOSEFLAG",expression="t1.CLOSEFLAG",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="RETURNDATA",expression="t1.RETURNDATA",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.WFINSTANCEID",showorder=6)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.WFINSTANCENAME",showorder=7)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.WFSTEPID",showorder=8)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTID",expression="t1.WFSTEPINSTID",showorder=9)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTNAME",expression="t1.WFSTEPINSTNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.WFSTEPLANRESTAG",showorder=11)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.WFSTEPNAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CLOSEFLAG], t1.[CREATEDATE], t1.[CREATEMAN], t1.[RETURNDATA], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WFINSTANCEID], t1.[WFINSTANCENAME], t1.[WFSTEPID], t1.[WFSTEPINSTID], t1.[WFSTEPINSTNAME], t1.[WFSTEPLANRESTAG], t1.[WFSTEPNAME] FROM [T_SRFWFSTEPINST] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CLOSEFLAG",expression="t1.[CLOSEFLAG]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="RETURNDATA",expression="t1.[RETURNDATA]",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=5)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.[WFINSTANCEID]",showorder=6)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.[WFINSTANCENAME]",showorder=7)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.[WFSTEPID]",showorder=8)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTID",expression="t1.[WFSTEPINSTID]",showorder=9)
        ,@DEDataQueryCodeExp(name="WFSTEPINSTNAME",expression="t1.[WFSTEPINSTNAME]",showorder=10)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.[WFSTEPLANRESTAG]",showorder=11)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.[WFSTEPNAME]",showorder=12)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFStepInstDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFStepInstDefaultDQModelBase() {
        super();

        this.initAnnotation(WFStepInstDefaultDQModelBase.class);
    }

}