/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfworklist.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="D38F06FD-408B-47C3-ABA6-94899C66529C",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CANCELFLAG, t1.CANCELINFORM, t1.CREATEDATE, t1.CREATEMAN, t1.ORIGINALWFUSERID, t1.ORIGINALWFUSERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4, t1.USERDATAINFO, t1.WFACTORID, t1.WFINSTANCEID, t1.WFINSTANCENAME, t1.WFLANRESTAG, t1.WFSTEPID, t1.WFSTEPLANRESTAG, t1.WFSTEPNAME, t1.WFWORKFLOWID, t1.WFWORKFLOWNAME, t1.WFWORKLISTID, t1.WFWORKLISTNAME, t1.WORKINFORM FROM T_SRFWFWORKLIST t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CANCELFLAG",expression="t1.CANCELFLAG",showorder=0)
        ,@DEDataQueryCodeExp(name="CANCELINFORM",expression="t1.CANCELINFORM",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERID",expression="t1.ORIGINALWFUSERID",showorder=4)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERNAME",expression="t1.ORIGINALWFUSERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATAINFO",expression="t1.USERDATAINFO",showorder=12)
        ,@DEDataQueryCodeExp(name="WFACTORID",expression="t1.WFACTORID",showorder=13)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.WFINSTANCEID",showorder=14)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.WFINSTANCENAME",showorder=15)
        ,@DEDataQueryCodeExp(name="WFLANRESTAG",expression="t1.WFLANRESTAG",showorder=16)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.WFSTEPID",showorder=17)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.WFSTEPLANRESTAG",showorder=18)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.WFSTEPNAME",showorder=19)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.WFWORKFLOWID",showorder=20)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.WFWORKFLOWNAME",showorder=21)
        ,@DEDataQueryCodeExp(name="WFWORKLISTID",expression="t1.WFWORKLISTID",showorder=22)
        ,@DEDataQueryCodeExp(name="WFWORKLISTNAME",expression="t1.WFWORKLISTNAME",showorder=23)
        ,@DEDataQueryCodeExp(name="WORKINFORM",expression="t1.WORKINFORM",showorder=24)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`cancelflag`, t1.`cancelinform`, t1.`createdate`, t1.`createman`, t1.`originalwfuserid`, t1.`originalwfusername`, t1.`updatedate`, t1.`updateman`, t1.`userdata`, t1.`userdata2`, t1.`userdata3`, t1.`userdata4`, t1.`userdatainfo`, t1.`wfactorid`, t1.`wfinstanceid`, t1.`wfinstancename`, t1.`wflanrestag`, t1.`wfstepid`, t1.`wfsteplanrestag`, t1.`wfstepname`, t1.`wfworkflowid`, t1.`wfworkflowname`, t1.`wfworklistid`, t1.`wfworklistname`, t1.`workinform` FROM `t_srfwfworklist` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CANCELFLAG",expression="t1.`cancelflag`",showorder=0)
        ,@DEDataQueryCodeExp(name="CANCELINFORM",expression="t1.`cancelinform`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=3)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERID",expression="t1.`originalwfuserid`",showorder=4)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERNAME",expression="t1.`originalwfusername`",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=7)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.`userdata`",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.`userdata2`",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.`userdata3`",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.`userdata4`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATAINFO",expression="t1.`userdatainfo`",showorder=12)
        ,@DEDataQueryCodeExp(name="WFACTORID",expression="t1.`wfactorid`",showorder=13)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.`wfinstanceid`",showorder=14)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.`wfinstancename`",showorder=15)
        ,@DEDataQueryCodeExp(name="WFLANRESTAG",expression="t1.`wflanrestag`",showorder=16)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.`wfstepid`",showorder=17)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.`wfsteplanrestag`",showorder=18)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.`wfstepname`",showorder=19)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.`wfworkflowid`",showorder=20)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.`wfworkflowname`",showorder=21)
        ,@DEDataQueryCodeExp(name="WFWORKLISTID",expression="t1.`wfworklistid`",showorder=22)
        ,@DEDataQueryCodeExp(name="WFWORKLISTNAME",expression="t1.`wfworklistname`",showorder=23)
        ,@DEDataQueryCodeExp(name="WORKINFORM",expression="t1.`workinform`",showorder=24)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CANCELFLAG, t1.CANCELINFORM, t1.CREATEDATE, t1.CREATEMAN, t1.ORIGINALWFUSERID, t1.ORIGINALWFUSERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4, t1.USERDATAINFO, t1.WFACTORID, t1.WFINSTANCEID, t1.WFINSTANCENAME, t1.WFLANRESTAG, t1.WFSTEPID, t1.WFSTEPLANRESTAG, t1.WFSTEPNAME, t1.WFWORKFLOWID, t1.WFWORKFLOWNAME, t1.WFWORKLISTID, t1.WFWORKLISTNAME, t1.WORKINFORM FROM T_SRFWFWORKLIST t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CANCELFLAG",expression="t1.CANCELFLAG",showorder=0)
        ,@DEDataQueryCodeExp(name="CANCELINFORM",expression="t1.CANCELINFORM",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERID",expression="t1.ORIGINALWFUSERID",showorder=4)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERNAME",expression="t1.ORIGINALWFUSERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATAINFO",expression="t1.USERDATAINFO",showorder=12)
        ,@DEDataQueryCodeExp(name="WFACTORID",expression="t1.WFACTORID",showorder=13)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.WFINSTANCEID",showorder=14)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.WFINSTANCENAME",showorder=15)
        ,@DEDataQueryCodeExp(name="WFLANRESTAG",expression="t1.WFLANRESTAG",showorder=16)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.WFSTEPID",showorder=17)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.WFSTEPLANRESTAG",showorder=18)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.WFSTEPNAME",showorder=19)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.WFWORKFLOWID",showorder=20)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.WFWORKFLOWNAME",showorder=21)
        ,@DEDataQueryCodeExp(name="WFWORKLISTID",expression="t1.WFWORKLISTID",showorder=22)
        ,@DEDataQueryCodeExp(name="WFWORKLISTNAME",expression="t1.WFWORKLISTNAME",showorder=23)
        ,@DEDataQueryCodeExp(name="WORKINFORM",expression="t1.WORKINFORM",showorder=24)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CANCELFLAG, t1.CANCELINFORM, t1.CREATEDATE, t1.CREATEMAN, t1.ORIGINALWFUSERID, t1.ORIGINALWFUSERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4, t1.USERDATAINFO, t1.WFACTORID, t1.WFINSTANCEID, t1.WFINSTANCENAME, t1.WFLANRESTAG, t1.WFSTEPID, t1.WFSTEPLANRESTAG, t1.WFSTEPNAME, t1.WFWORKFLOWID, t1.WFWORKFLOWNAME, t1.WFWORKLISTID, t1.WFWORKLISTNAME, t1.WORKINFORM FROM T_SRFWFWORKLIST t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CANCELFLAG",expression="t1.CANCELFLAG",showorder=0)
        ,@DEDataQueryCodeExp(name="CANCELINFORM",expression="t1.CANCELINFORM",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERID",expression="t1.ORIGINALWFUSERID",showorder=4)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERNAME",expression="t1.ORIGINALWFUSERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATAINFO",expression="t1.USERDATAINFO",showorder=12)
        ,@DEDataQueryCodeExp(name="WFACTORID",expression="t1.WFACTORID",showorder=13)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.WFINSTANCEID",showorder=14)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.WFINSTANCENAME",showorder=15)
        ,@DEDataQueryCodeExp(name="WFLANRESTAG",expression="t1.WFLANRESTAG",showorder=16)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.WFSTEPID",showorder=17)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.WFSTEPLANRESTAG",showorder=18)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.WFSTEPNAME",showorder=19)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.WFWORKFLOWID",showorder=20)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.WFWORKFLOWNAME",showorder=21)
        ,@DEDataQueryCodeExp(name="WFWORKLISTID",expression="t1.WFWORKLISTID",showorder=22)
        ,@DEDataQueryCodeExp(name="WFWORKLISTNAME",expression="t1.WFWORKLISTNAME",showorder=23)
        ,@DEDataQueryCodeExp(name="WORKINFORM",expression="t1.WORKINFORM",showorder=24)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CANCELFLAG, t1.CANCELINFORM, t1.CREATEDATE, t1.CREATEMAN, t1.ORIGINALWFUSERID, t1.ORIGINALWFUSERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4, t1.USERDATAINFO, t1.WFACTORID, t1.WFINSTANCEID, t1.WFINSTANCENAME, t1.WFLANRESTAG, t1.WFSTEPID, t1.WFSTEPLANRESTAG, t1.WFSTEPNAME, t1.WFWORKFLOWID, t1.WFWORKFLOWNAME, t1.WFWORKLISTID, t1.WFWORKLISTNAME, t1.WORKINFORM FROM T_SRFWFWORKLIST t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CANCELFLAG",expression="t1.CANCELFLAG",showorder=0)
        ,@DEDataQueryCodeExp(name="CANCELINFORM",expression="t1.CANCELINFORM",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERID",expression="t1.ORIGINALWFUSERID",showorder=4)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERNAME",expression="t1.ORIGINALWFUSERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATAINFO",expression="t1.USERDATAINFO",showorder=12)
        ,@DEDataQueryCodeExp(name="WFACTORID",expression="t1.WFACTORID",showorder=13)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.WFINSTANCEID",showorder=14)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.WFINSTANCENAME",showorder=15)
        ,@DEDataQueryCodeExp(name="WFLANRESTAG",expression="t1.WFLANRESTAG",showorder=16)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.WFSTEPID",showorder=17)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.WFSTEPLANRESTAG",showorder=18)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.WFSTEPNAME",showorder=19)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.WFWORKFLOWID",showorder=20)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.WFWORKFLOWNAME",showorder=21)
        ,@DEDataQueryCodeExp(name="WFWORKLISTID",expression="t1.WFWORKLISTID",showorder=22)
        ,@DEDataQueryCodeExp(name="WFWORKLISTNAME",expression="t1.WFWORKLISTNAME",showorder=23)
        ,@DEDataQueryCodeExp(name="WORKINFORM",expression="t1.WORKINFORM",showorder=24)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CANCELFLAG], t1.[CANCELINFORM], t1.[CREATEDATE], t1.[CREATEMAN], t1.[ORIGINALWFUSERID], t1.[ORIGINALWFUSERNAME], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERDATA], t1.[USERDATA2], t1.[USERDATA3], t1.[USERDATA4], t1.[USERDATAINFO], t1.[WFACTORID], t1.[WFINSTANCEID], t1.[WFINSTANCENAME], t1.[WFLANRESTAG], t1.[WFSTEPID], t1.[WFSTEPLANRESTAG], t1.[WFSTEPNAME], t1.[WFWORKFLOWID], t1.[WFWORKFLOWNAME], t1.[WFWORKLISTID], t1.[WFWORKLISTNAME], t1.[WORKINFORM] FROM [T_SRFWFWORKLIST] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CANCELFLAG",expression="t1.[CANCELFLAG]",showorder=0)
        ,@DEDataQueryCodeExp(name="CANCELINFORM",expression="t1.[CANCELINFORM]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=3)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERID",expression="t1.[ORIGINALWFUSERID]",showorder=4)
        ,@DEDataQueryCodeExp(name="ORIGINALWFUSERNAME",expression="t1.[ORIGINALWFUSERNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=7)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.[USERDATA]",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.[USERDATA2]",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.[USERDATA3]",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.[USERDATA4]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDATAINFO",expression="t1.[USERDATAINFO]",showorder=12)
        ,@DEDataQueryCodeExp(name="WFACTORID",expression="t1.[WFACTORID]",showorder=13)
        ,@DEDataQueryCodeExp(name="WFINSTANCEID",expression="t1.[WFINSTANCEID]",showorder=14)
        ,@DEDataQueryCodeExp(name="WFINSTANCENAME",expression="t1.[WFINSTANCENAME]",showorder=15)
        ,@DEDataQueryCodeExp(name="WFLANRESTAG",expression="t1.[WFLANRESTAG]",showorder=16)
        ,@DEDataQueryCodeExp(name="WFSTEPID",expression="t1.[WFSTEPID]",showorder=17)
        ,@DEDataQueryCodeExp(name="WFSTEPLANRESTAG",expression="t1.[WFSTEPLANRESTAG]",showorder=18)
        ,@DEDataQueryCodeExp(name="WFSTEPNAME",expression="t1.[WFSTEPNAME]",showorder=19)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.[WFWORKFLOWID]",showorder=20)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.[WFWORKFLOWNAME]",showorder=21)
        ,@DEDataQueryCodeExp(name="WFWORKLISTID",expression="t1.[WFWORKLISTID]",showorder=22)
        ,@DEDataQueryCodeExp(name="WFWORKLISTNAME",expression="t1.[WFWORKLISTNAME]",showorder=23)
        ,@DEDataQueryCodeExp(name="WORKINFORM",expression="t1.[WORKINFORM]",showorder=24)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFWorkListDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFWorkListDefaultDQModelBase() {
        super();

        this.initAnnotation(WFWorkListDefaultDQModelBase.class);
    }

}