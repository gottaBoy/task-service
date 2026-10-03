/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfappsetting.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="C336E5BD-3D0D-45C2-BBF5-91C43BBAE20A",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.APPLICATIONID, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.REMINDMSGTEMPID, t1.REMINDMSGTEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFAPPSETTINGID, t1.WFAPPSETTINGNAME FROM T_SRFWFAPPSETTING t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="APPLICATIONID",expression="t1.APPLICATIONID",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPID",expression="t1.REMINDMSGTEMPID",showorder=4)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPLNAME",expression="t1.REMINDMSGTEMPLNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGID",expression="t1.WFAPPSETTINGID",showorder=8)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGNAME",expression="t1.WFAPPSETTINGNAME",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`applicationid`, t1.`createdate`, t1.`createman`, t1.`memo`, t1.`remindmsgtempid`, t1.`remindmsgtemplname`, t1.`updatedate`, t1.`updateman`, t1.`wfappsettingid`, t1.`wfappsettingname` FROM `t_srfwfappsetting` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="APPLICATIONID",expression="t1.`applicationid`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=3)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPID",expression="t1.`remindmsgtempid`",showorder=4)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPLNAME",expression="t1.`remindmsgtemplname`",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=7)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGID",expression="t1.`wfappsettingid`",showorder=8)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGNAME",expression="t1.`wfappsettingname`",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.APPLICATIONID, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.REMINDMSGTEMPID, t1.REMINDMSGTEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFAPPSETTINGID, t1.WFAPPSETTINGNAME FROM T_SRFWFAPPSETTING t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="APPLICATIONID",expression="t1.APPLICATIONID",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPID",expression="t1.REMINDMSGTEMPID",showorder=4)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPLNAME",expression="t1.REMINDMSGTEMPLNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGID",expression="t1.WFAPPSETTINGID",showorder=8)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGNAME",expression="t1.WFAPPSETTINGNAME",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.APPLICATIONID, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.REMINDMSGTEMPID, t1.REMINDMSGTEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFAPPSETTINGID, t1.WFAPPSETTINGNAME FROM T_SRFWFAPPSETTING t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="APPLICATIONID",expression="t1.APPLICATIONID",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPID",expression="t1.REMINDMSGTEMPID",showorder=4)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPLNAME",expression="t1.REMINDMSGTEMPLNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGID",expression="t1.WFAPPSETTINGID",showorder=8)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGNAME",expression="t1.WFAPPSETTINGNAME",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.APPLICATIONID, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.REMINDMSGTEMPID, t1.REMINDMSGTEMPLNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFAPPSETTINGID, t1.WFAPPSETTINGNAME FROM T_SRFWFAPPSETTING t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="APPLICATIONID",expression="t1.APPLICATIONID",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPID",expression="t1.REMINDMSGTEMPID",showorder=4)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPLNAME",expression="t1.REMINDMSGTEMPLNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGID",expression="t1.WFAPPSETTINGID",showorder=8)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGNAME",expression="t1.WFAPPSETTINGNAME",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[APPLICATIONID], t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[REMINDMSGTEMPID], t1.[REMINDMSGTEMPLNAME], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WFAPPSETTINGID], t1.[WFAPPSETTINGNAME] FROM [T_SRFWFAPPSETTING] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="APPLICATIONID",expression="t1.[APPLICATIONID]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=3)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPID",expression="t1.[REMINDMSGTEMPID]",showorder=4)
        ,@DEDataQueryCodeExp(name="REMINDMSGTEMPLNAME",expression="t1.[REMINDMSGTEMPLNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=7)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGID",expression="t1.[WFAPPSETTINGID]",showorder=8)
        ,@DEDataQueryCodeExp(name="WFAPPSETTINGNAME",expression="t1.[WFAPPSETTINGNAME]",showorder=9)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFAppSettingDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFAppSettingDefaultDQModelBase() {
        super();

        this.initAnnotation(WFAppSettingDefaultDQModelBase.class);
    }

}