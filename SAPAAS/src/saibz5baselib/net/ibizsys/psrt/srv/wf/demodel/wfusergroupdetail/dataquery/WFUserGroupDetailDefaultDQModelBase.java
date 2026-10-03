/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfusergroupdetail.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="F42CBB37-C6B1-42C6-AE9E-7675648D338A",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFUSERGROUPDETAILID, t1.WFUSERGROUPDETAILNAME, t1.WFUSERGROUPID, t11.WFUSERGROUPNAME, t1.WFUSERID, t21.WFUSERNAME FROM T_SRFWFUSERGROUPDETAIL t1  LEFT JOIN T_SRFWFUSERGROUP t11 ON t1.WFUSERGROUPID = t11.WFUSERGROUPID  LEFT JOIN T_SRFWFUSER t21 ON t1.WFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILID",expression="t1.WFUSERGROUPDETAILID",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILNAME",expression="t1.WFUSERGROUPDETAILNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.WFUSERGROUPID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t11.WFUSERGROUPNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.WFUSERID",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t21.WFUSERNAME",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`memo`, t1.`updatedate`, t1.`updateman`, t1.`wfusergroupdetailid`, t1.`wfusergroupdetailname`, t1.`wfusergroupid`, t11.`wfusergroupname`, t1.`wfuserid`, t21.`wfusername` FROM `t_srfwfusergroupdetail` t1  LEFT JOIN t_srfwfusergroup t11 ON t1.wfusergroupid = t11.wfusergroupid  LEFT JOIN t_srfwfuser t21 ON t1.wfuserid = t21.wfuserid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILID",expression="t1.`wfusergroupdetailid`",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILNAME",expression="t1.`wfusergroupdetailname`",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.`wfusergroupid`",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t11.`wfusergroupname`",showorder=8)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.`wfuserid`",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t21.`wfusername`",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFUSERGROUPDETAILID, t1.WFUSERGROUPDETAILNAME, t1.WFUSERGROUPID, t11.WFUSERGROUPNAME, t1.WFUSERID, t21.WFUSERNAME FROM T_SRFWFUSERGROUPDETAIL t1  LEFT JOIN T_SRFWFUSERGROUP t11 ON t1.WFUSERGROUPID = t11.WFUSERGROUPID  LEFT JOIN T_SRFWFUSER t21 ON t1.WFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILID",expression="t1.WFUSERGROUPDETAILID",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILNAME",expression="t1.WFUSERGROUPDETAILNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.WFUSERGROUPID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t11.WFUSERGROUPNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.WFUSERID",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t21.WFUSERNAME",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFUSERGROUPDETAILID, t1.WFUSERGROUPDETAILNAME, t1.WFUSERGROUPID, t11.WFUSERGROUPNAME, t1.WFUSERID, t21.WFUSERNAME FROM T_SRFWFUSERGROUPDETAIL t1  LEFT JOIN T_SRFWFUSERGROUP t11 ON t1.WFUSERGROUPID = t11.WFUSERGROUPID  LEFT JOIN T_SRFWFUSER t21 ON t1.WFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILID",expression="t1.WFUSERGROUPDETAILID",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILNAME",expression="t1.WFUSERGROUPDETAILNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.WFUSERGROUPID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t11.WFUSERGROUPNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.WFUSERID",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t21.WFUSERNAME",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFUSERGROUPDETAILID, t1.WFUSERGROUPDETAILNAME, t1.WFUSERGROUPID, t11.WFUSERGROUPNAME, t1.WFUSERID, t21.WFUSERNAME FROM T_SRFWFUSERGROUPDETAIL t1  LEFT JOIN T_SRFWFUSERGROUP t11 ON t1.WFUSERGROUPID = t11.WFUSERGROUPID  LEFT JOIN T_SRFWFUSER t21 ON t1.WFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILID",expression="t1.WFUSERGROUPDETAILID",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILNAME",expression="t1.WFUSERGROUPDETAILNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.WFUSERGROUPID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t11.WFUSERGROUPNAME",showorder=8)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.WFUSERID",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t21.WFUSERNAME",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WFUSERGROUPDETAILID], t1.[WFUSERGROUPDETAILNAME], t1.[WFUSERGROUPID], t11.[WFUSERGROUPNAME], t1.[WFUSERID], t21.[WFUSERNAME] FROM [T_SRFWFUSERGROUPDETAIL] t1  LEFT JOIN T_SRFWFUSERGROUP t11 ON t1.WFUSERGROUPID = t11.WFUSERGROUPID  LEFT JOIN T_SRFWFUSER t21 ON t1.WFUSERID = t21.WFUSERID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=4)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILID",expression="t1.[WFUSERGROUPDETAILID]",showorder=5)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPDETAILNAME",expression="t1.[WFUSERGROUPDETAILNAME]",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPID",expression="t1.[WFUSERGROUPID]",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUSERGROUPNAME",expression="t11.[WFUSERGROUPNAME]",showorder=8)
        ,@DEDataQueryCodeExp(name="WFUSERID",expression="t1.[WFUSERID]",showorder=9)
        ,@DEDataQueryCodeExp(name="WFUSERNAME",expression="t21.[WFUSERNAME]",showorder=10)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFUserGroupDetailDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFUserGroupDetailDefaultDQModelBase() {
        super();

        this.initAnnotation(WFUserGroupDetailDefaultDQModelBase.class);
    }

}