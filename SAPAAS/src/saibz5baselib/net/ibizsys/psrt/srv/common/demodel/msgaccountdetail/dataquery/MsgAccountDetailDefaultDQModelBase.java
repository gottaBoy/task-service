/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgaccountdetail.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="BBEB9F49-775E-43A2-A019-B588F9A9CAE4",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAJORMSGACCOUNTID, t11.MSGACCOUNTNAME AS MAJORMSGACCOUNTNAME, t1.MINORMSGACCOUNTID, t21.MSGACCOUNTNAME AS MINORMSGACCOUNTNAME, t1.MSGACCOUNTDETAILID, t1.MSGACCOUNTDETAILNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFMSGACCOUNTDETAIL t1  LEFT JOIN T_SRFMSGACCOUNT t11 ON t1.MAJORMSGACCOUNTID = t11.MSGACCOUNTID  LEFT JOIN T_SRFMSGACCOUNT t21 ON t1.MINORMSGACCOUNTID = t21.MSGACCOUNTID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTID",expression="t1.MAJORMSGACCOUNTID",showorder=2)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTNAME",expression="t11.MSGACCOUNTNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTID",expression="t1.MINORMSGACCOUNTID",showorder=4)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTNAME",expression="t21.MSGACCOUNTNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILID",expression="t1.MSGACCOUNTDETAILID",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILNAME",expression="t1.MSGACCOUNTDETAILNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`majormsgaccountid`, t11.`msgaccountname` AS `majormsgaccountname`, t1.`minormsgaccountid`, t21.`msgaccountname` AS `minormsgaccountname`, t1.`msgaccountdetailid`, t1.`msgaccountdetailname`, t1.`updatedate`, t1.`updateman` FROM `t_srfmsgaccountdetail` t1  LEFT JOIN t_srfmsgaccount t11 ON t1.majormsgaccountid = t11.msgaccountid  LEFT JOIN t_srfmsgaccount t21 ON t1.minormsgaccountid = t21.msgaccountid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTID",expression="t1.`majormsgaccountid`",showorder=2)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTNAME",expression="t11.`msgaccountname`",showorder=3)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTID",expression="t1.`minormsgaccountid`",showorder=4)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTNAME",expression="t21.`msgaccountname`",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILID",expression="t1.`msgaccountdetailid`",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILNAME",expression="t1.`msgaccountdetailname`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAJORMSGACCOUNTID, t11.MSGACCOUNTNAME AS MAJORMSGACCOUNTNAME, t1.MINORMSGACCOUNTID, t21.MSGACCOUNTNAME AS MINORMSGACCOUNTNAME, t1.MSGACCOUNTDETAILID, t1.MSGACCOUNTDETAILNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFMSGACCOUNTDETAIL t1  LEFT JOIN T_SRFMSGACCOUNT t11 ON t1.MAJORMSGACCOUNTID = t11.MSGACCOUNTID  LEFT JOIN T_SRFMSGACCOUNT t21 ON t1.MINORMSGACCOUNTID = t21.MSGACCOUNTID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTID",expression="t1.MAJORMSGACCOUNTID",showorder=2)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTNAME",expression="t11.MSGACCOUNTNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTID",expression="t1.MINORMSGACCOUNTID",showorder=4)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTNAME",expression="t21.MSGACCOUNTNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILID",expression="t1.MSGACCOUNTDETAILID",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILNAME",expression="t1.MSGACCOUNTDETAILNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAJORMSGACCOUNTID, t11.MSGACCOUNTNAME AS MAJORMSGACCOUNTNAME, t1.MINORMSGACCOUNTID, t21.MSGACCOUNTNAME AS MINORMSGACCOUNTNAME, t1.MSGACCOUNTDETAILID, t1.MSGACCOUNTDETAILNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFMSGACCOUNTDETAIL t1  LEFT JOIN T_SRFMSGACCOUNT t11 ON t1.MAJORMSGACCOUNTID = t11.MSGACCOUNTID  LEFT JOIN T_SRFMSGACCOUNT t21 ON t1.MINORMSGACCOUNTID = t21.MSGACCOUNTID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTID",expression="t1.MAJORMSGACCOUNTID",showorder=2)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTNAME",expression="t11.MSGACCOUNTNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTID",expression="t1.MINORMSGACCOUNTID",showorder=4)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTNAME",expression="t21.MSGACCOUNTNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILID",expression="t1.MSGACCOUNTDETAILID",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILNAME",expression="t1.MSGACCOUNTDETAILNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAJORMSGACCOUNTID, t11.MSGACCOUNTNAME AS MAJORMSGACCOUNTNAME, t1.MINORMSGACCOUNTID, t21.MSGACCOUNTNAME AS MINORMSGACCOUNTNAME, t1.MSGACCOUNTDETAILID, t1.MSGACCOUNTDETAILNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFMSGACCOUNTDETAIL t1  LEFT JOIN T_SRFMSGACCOUNT t11 ON t1.MAJORMSGACCOUNTID = t11.MSGACCOUNTID  LEFT JOIN T_SRFMSGACCOUNT t21 ON t1.MINORMSGACCOUNTID = t21.MSGACCOUNTID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTID",expression="t1.MAJORMSGACCOUNTID",showorder=2)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTNAME",expression="t11.MSGACCOUNTNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTID",expression="t1.MINORMSGACCOUNTID",showorder=4)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTNAME",expression="t21.MSGACCOUNTNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILID",expression="t1.MSGACCOUNTDETAILID",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILNAME",expression="t1.MSGACCOUNTDETAILNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[MAJORMSGACCOUNTID], t11.[MSGACCOUNTNAME] AS [MAJORMSGACCOUNTNAME], t1.[MINORMSGACCOUNTID], t21.[MSGACCOUNTNAME] AS [MINORMSGACCOUNTNAME], t1.[MSGACCOUNTDETAILID], t1.[MSGACCOUNTDETAILNAME], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFMSGACCOUNTDETAIL] t1  LEFT JOIN T_SRFMSGACCOUNT t11 ON t1.MAJORMSGACCOUNTID = t11.MSGACCOUNTID  LEFT JOIN T_SRFMSGACCOUNT t21 ON t1.MINORMSGACCOUNTID = t21.MSGACCOUNTID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTID",expression="t1.[MAJORMSGACCOUNTID]",showorder=2)
        ,@DEDataQueryCodeExp(name="MAJORMSGACCOUNTNAME",expression="t11.[MSGACCOUNTNAME]",showorder=3)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTID",expression="t1.[MINORMSGACCOUNTID]",showorder=4)
        ,@DEDataQueryCodeExp(name="MINORMSGACCOUNTNAME",expression="t21.[MSGACCOUNTNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILID",expression="t1.[MSGACCOUNTDETAILID]",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTDETAILNAME",expression="t1.[MSGACCOUNTDETAILNAME]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=9)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class MsgAccountDetailDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public MsgAccountDetailDefaultDQModelBase() {
        super();

        this.initAnnotation(MsgAccountDetailDefaultDQModelBase.class);
    }

}