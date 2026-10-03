/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusergroup.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="95DACEE8-1185-41FF-81E2-78B53F7744CF",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFUSERGROUPID, t1.WFUSERGROUPNAME FROM T_SRFWFUSERGROUP t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.WFUSERGROUPID",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t1.WFUSERGROUPNAME",showorder=6)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`memo`, t1.`updatedate`, t1.`updateman`, t1.`wfusergroupid`, t1.`wfusergroupname` FROM `t_srfwfusergroup` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.`wfusergroupid`",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t1.`wfusergroupname`",showorder=6)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFUSERGROUPID, t1.WFUSERGROUPNAME FROM T_SRFWFUSERGROUP t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.WFUSERGROUPID",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t1.WFUSERGROUPNAME",showorder=6)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFUSERGROUPID, t1.WFUSERGROUPNAME FROM T_SRFWFUSERGROUP t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.WFUSERGROUPID",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t1.WFUSERGROUPNAME",showorder=6)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFUSERGROUPID, t1.WFUSERGROUPNAME FROM T_SRFWFUSERGROUP t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.WFUSERGROUPID",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t1.WFUSERGROUPNAME",showorder=6)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WFUSERGROUPID], t1.[WFUSERGROUPNAME] FROM [T_SRFWFUSERGROUP] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.[WFUSERGROUPID]",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t1.[WFUSERGROUPNAME]",showorder=6)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFUserGroupDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFUserGroupDefaultDQModelBase() {
        super();

        this.initAnnotation(WFUserGroupDefaultDQModelBase.class);
    }

}