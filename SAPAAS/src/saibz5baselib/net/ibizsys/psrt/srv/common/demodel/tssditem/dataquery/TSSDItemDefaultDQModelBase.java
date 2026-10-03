/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssditem.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="DC63C7D0-E4DD-4CAB-BBF9-FE8ECAEE1432",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.HOURTYPE AS HOURTYPE, t1.HOURVALUE AS HOURVALUE, t1.MINUTETYPE AS MINUTETYPE, t1.MINUTEVALUE AS MINUTEVALUE, t1.MONTHDAYTYPE AS MONTHDAYTYPE, t1.MONTHDAYVALUE AS MONTHDAYVALUE, t1.MONTHTYPE AS MONTHTYPE, t1.MONTHVALUE AS MONTHVALUE, t1.MONTHWEEKTYPE AS MONTHWEEKTYPE, t1.MONTHWEEKVALUE AS MONTHWEEKVALUE, t1.SECONDTYPE AS SECONDTYPE, t1.SECONDVALUE AS SECONDVALUE, t1.TSSDITEMID AS TSSDITEMID, t1.TSSDITEMNAME AS TSSDITEMNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.VERSION AS VERSION FROM T_SRFTSSDITEM t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="HOURTYPE",expression="t1.HOURTYPE",showorder=2)
        ,@DEDataQueryCodeExp(name="HOURVALUE",expression="t1.HOURVALUE",showorder=3)
        ,@DEDataQueryCodeExp(name="MINUTETYPE",expression="t1.MINUTETYPE",showorder=4)
        ,@DEDataQueryCodeExp(name="MINUTEVALUE",expression="t1.MINUTEVALUE",showorder=5)
        ,@DEDataQueryCodeExp(name="MONTHDAYTYPE",expression="t1.MONTHDAYTYPE",showorder=6)
        ,@DEDataQueryCodeExp(name="MONTHDAYVALUE",expression="t1.MONTHDAYVALUE",showorder=7)
        ,@DEDataQueryCodeExp(name="MONTHTYPE",expression="t1.MONTHTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="MONTHVALUE",expression="t1.MONTHVALUE",showorder=9)
        ,@DEDataQueryCodeExp(name="MONTHWEEKTYPE",expression="t1.MONTHWEEKTYPE",showorder=10)
        ,@DEDataQueryCodeExp(name="MONTHWEEKVALUE",expression="t1.MONTHWEEKVALUE",showorder=11)
        ,@DEDataQueryCodeExp(name="SECONDTYPE",expression="t1.SECONDTYPE",showorder=12)
        ,@DEDataQueryCodeExp(name="SECONDVALUE",expression="t1.SECONDVALUE",showorder=13)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.TSSDITEMID",showorder=14)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t1.TSSDITEMNAME",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=17)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`hourtype`, t1.`hourvalue`, t1.`minutetype`, t1.`minutevalue`, t1.`monthdaytype`, t1.`monthdayvalue`, t1.`monthtype`, t1.`monthvalue`, t1.`monthweektype`, t1.`monthweekvalue`, t1.`secondtype`, t1.`secondvalue`, t1.`tssditemid`, t1.`tssditemname`, t1.`updatedate`, t1.`updateman`, t1.`version` FROM `t_srftssditem` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="HOURTYPE",expression="t1.`hourtype`",showorder=2)
        ,@DEDataQueryCodeExp(name="HOURVALUE",expression="t1.`hourvalue`",showorder=3)
        ,@DEDataQueryCodeExp(name="MINUTETYPE",expression="t1.`minutetype`",showorder=4)
        ,@DEDataQueryCodeExp(name="MINUTEVALUE",expression="t1.`minutevalue`",showorder=5)
        ,@DEDataQueryCodeExp(name="MONTHDAYTYPE",expression="t1.`monthdaytype`",showorder=6)
        ,@DEDataQueryCodeExp(name="MONTHDAYVALUE",expression="t1.`monthdayvalue`",showorder=7)
        ,@DEDataQueryCodeExp(name="MONTHTYPE",expression="t1.`monthtype`",showorder=8)
        ,@DEDataQueryCodeExp(name="MONTHVALUE",expression="t1.`monthvalue`",showorder=9)
        ,@DEDataQueryCodeExp(name="MONTHWEEKTYPE",expression="t1.`monthweektype`",showorder=10)
        ,@DEDataQueryCodeExp(name="MONTHWEEKVALUE",expression="t1.`monthweekvalue`",showorder=11)
        ,@DEDataQueryCodeExp(name="SECONDTYPE",expression="t1.`secondtype`",showorder=12)
        ,@DEDataQueryCodeExp(name="SECONDVALUE",expression="t1.`secondvalue`",showorder=13)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.`tssditemid`",showorder=14)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t1.`tssditemname`",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=17)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.`version`",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.HOURTYPE AS HOURTYPE, t1.HOURVALUE AS HOURVALUE, t1.MINUTETYPE AS MINUTETYPE, t1.MINUTEVALUE AS MINUTEVALUE, t1.MONTHDAYTYPE AS MONTHDAYTYPE, t1.MONTHDAYVALUE AS MONTHDAYVALUE, t1.MONTHTYPE AS MONTHTYPE, t1.MONTHVALUE AS MONTHVALUE, t1.MONTHWEEKTYPE AS MONTHWEEKTYPE, t1.MONTHWEEKVALUE AS MONTHWEEKVALUE, t1.SECONDTYPE AS SECONDTYPE, t1.SECONDVALUE AS SECONDVALUE, t1.TSSDITEMID AS TSSDITEMID, t1.TSSDITEMNAME AS TSSDITEMNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.VERSION AS VERSION FROM T_SRFTSSDITEM t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="HOURTYPE",expression="t1.HOURTYPE",showorder=2)
        ,@DEDataQueryCodeExp(name="HOURVALUE",expression="t1.HOURVALUE",showorder=3)
        ,@DEDataQueryCodeExp(name="MINUTETYPE",expression="t1.MINUTETYPE",showorder=4)
        ,@DEDataQueryCodeExp(name="MINUTEVALUE",expression="t1.MINUTEVALUE",showorder=5)
        ,@DEDataQueryCodeExp(name="MONTHDAYTYPE",expression="t1.MONTHDAYTYPE",showorder=6)
        ,@DEDataQueryCodeExp(name="MONTHDAYVALUE",expression="t1.MONTHDAYVALUE",showorder=7)
        ,@DEDataQueryCodeExp(name="MONTHTYPE",expression="t1.MONTHTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="MONTHVALUE",expression="t1.MONTHVALUE",showorder=9)
        ,@DEDataQueryCodeExp(name="MONTHWEEKTYPE",expression="t1.MONTHWEEKTYPE",showorder=10)
        ,@DEDataQueryCodeExp(name="MONTHWEEKVALUE",expression="t1.MONTHWEEKVALUE",showorder=11)
        ,@DEDataQueryCodeExp(name="SECONDTYPE",expression="t1.SECONDTYPE",showorder=12)
        ,@DEDataQueryCodeExp(name="SECONDVALUE",expression="t1.SECONDVALUE",showorder=13)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.TSSDITEMID",showorder=14)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t1.TSSDITEMNAME",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=17)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.HOURTYPE AS HOURTYPE, t1.HOURVALUE AS HOURVALUE, t1.MINUTETYPE AS MINUTETYPE, t1.MINUTEVALUE AS MINUTEVALUE, t1.MONTHDAYTYPE AS MONTHDAYTYPE, t1.MONTHDAYVALUE AS MONTHDAYVALUE, t1.MONTHTYPE AS MONTHTYPE, t1.MONTHVALUE AS MONTHVALUE, t1.MONTHWEEKTYPE AS MONTHWEEKTYPE, t1.MONTHWEEKVALUE AS MONTHWEEKVALUE, t1.SECONDTYPE AS SECONDTYPE, t1.SECONDVALUE AS SECONDVALUE, t1.TSSDITEMID AS TSSDITEMID, t1.TSSDITEMNAME AS TSSDITEMNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.VERSION AS VERSION FROM T_SRFTSSDITEM t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="HOURTYPE",expression="t1.HOURTYPE",showorder=2)
        ,@DEDataQueryCodeExp(name="HOURVALUE",expression="t1.HOURVALUE",showorder=3)
        ,@DEDataQueryCodeExp(name="MINUTETYPE",expression="t1.MINUTETYPE",showorder=4)
        ,@DEDataQueryCodeExp(name="MINUTEVALUE",expression="t1.MINUTEVALUE",showorder=5)
        ,@DEDataQueryCodeExp(name="MONTHDAYTYPE",expression="t1.MONTHDAYTYPE",showorder=6)
        ,@DEDataQueryCodeExp(name="MONTHDAYVALUE",expression="t1.MONTHDAYVALUE",showorder=7)
        ,@DEDataQueryCodeExp(name="MONTHTYPE",expression="t1.MONTHTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="MONTHVALUE",expression="t1.MONTHVALUE",showorder=9)
        ,@DEDataQueryCodeExp(name="MONTHWEEKTYPE",expression="t1.MONTHWEEKTYPE",showorder=10)
        ,@DEDataQueryCodeExp(name="MONTHWEEKVALUE",expression="t1.MONTHWEEKVALUE",showorder=11)
        ,@DEDataQueryCodeExp(name="SECONDTYPE",expression="t1.SECONDTYPE",showorder=12)
        ,@DEDataQueryCodeExp(name="SECONDVALUE",expression="t1.SECONDVALUE",showorder=13)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.TSSDITEMID",showorder=14)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t1.TSSDITEMNAME",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=17)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.HOURTYPE AS HOURTYPE, t1.HOURVALUE AS HOURVALUE, t1.MINUTETYPE AS MINUTETYPE, t1.MINUTEVALUE AS MINUTEVALUE, t1.MONTHDAYTYPE AS MONTHDAYTYPE, t1.MONTHDAYVALUE AS MONTHDAYVALUE, t1.MONTHTYPE AS MONTHTYPE, t1.MONTHVALUE AS MONTHVALUE, t1.MONTHWEEKTYPE AS MONTHWEEKTYPE, t1.MONTHWEEKVALUE AS MONTHWEEKVALUE, t1.SECONDTYPE AS SECONDTYPE, t1.SECONDVALUE AS SECONDVALUE, t1.TSSDITEMID AS TSSDITEMID, t1.TSSDITEMNAME AS TSSDITEMNAME, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.VERSION AS VERSION FROM T_SRFTSSDITEM t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="HOURTYPE",expression="t1.HOURTYPE",showorder=2)
        ,@DEDataQueryCodeExp(name="HOURVALUE",expression="t1.HOURVALUE",showorder=3)
        ,@DEDataQueryCodeExp(name="MINUTETYPE",expression="t1.MINUTETYPE",showorder=4)
        ,@DEDataQueryCodeExp(name="MINUTEVALUE",expression="t1.MINUTEVALUE",showorder=5)
        ,@DEDataQueryCodeExp(name="MONTHDAYTYPE",expression="t1.MONTHDAYTYPE",showorder=6)
        ,@DEDataQueryCodeExp(name="MONTHDAYVALUE",expression="t1.MONTHDAYVALUE",showorder=7)
        ,@DEDataQueryCodeExp(name="MONTHTYPE",expression="t1.MONTHTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="MONTHVALUE",expression="t1.MONTHVALUE",showorder=9)
        ,@DEDataQueryCodeExp(name="MONTHWEEKTYPE",expression="t1.MONTHWEEKTYPE",showorder=10)
        ,@DEDataQueryCodeExp(name="MONTHWEEKVALUE",expression="t1.MONTHWEEKVALUE",showorder=11)
        ,@DEDataQueryCodeExp(name="SECONDTYPE",expression="t1.SECONDTYPE",showorder=12)
        ,@DEDataQueryCodeExp(name="SECONDVALUE",expression="t1.SECONDVALUE",showorder=13)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.TSSDITEMID",showorder=14)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t1.TSSDITEMNAME",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=17)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE] AS [CREATEDATE], t1.[CREATEMAN] AS [CREATEMAN], t1.[HOURTYPE] AS [HOURTYPE], t1.[HOURVALUE] AS [HOURVALUE], t1.[MINUTETYPE] AS [MINUTETYPE], t1.[MINUTEVALUE] AS [MINUTEVALUE], t1.[MONTHDAYTYPE] AS [MONTHDAYTYPE], t1.[MONTHDAYVALUE] AS [MONTHDAYVALUE], t1.[MONTHTYPE] AS [MONTHTYPE], t1.[MONTHVALUE] AS [MONTHVALUE], t1.[MONTHWEEKTYPE] AS [MONTHWEEKTYPE], t1.[MONTHWEEKVALUE] AS [MONTHWEEKVALUE], t1.[SECONDTYPE] AS [SECONDTYPE], t1.[SECONDVALUE] AS [SECONDVALUE], t1.[TSSDITEMID] AS [TSSDITEMID], t1.[TSSDITEMNAME] AS [TSSDITEMNAME], t1.[UPDATEDATE] AS [UPDATEDATE], t1.[UPDATEMAN] AS [UPDATEMAN], t1.[VERSION] AS [VERSION] FROM [T_SRFTSSDITEM] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="HOURTYPE",expression="t1.[HOURTYPE]",showorder=2)
        ,@DEDataQueryCodeExp(name="HOURVALUE",expression="t1.[HOURVALUE]",showorder=3)
        ,@DEDataQueryCodeExp(name="MINUTETYPE",expression="t1.[MINUTETYPE]",showorder=4)
        ,@DEDataQueryCodeExp(name="MINUTEVALUE",expression="t1.[MINUTEVALUE]",showorder=5)
        ,@DEDataQueryCodeExp(name="MONTHDAYTYPE",expression="t1.[MONTHDAYTYPE]",showorder=6)
        ,@DEDataQueryCodeExp(name="MONTHDAYVALUE",expression="t1.[MONTHDAYVALUE]",showorder=7)
        ,@DEDataQueryCodeExp(name="MONTHTYPE",expression="t1.[MONTHTYPE]",showorder=8)
        ,@DEDataQueryCodeExp(name="MONTHVALUE",expression="t1.[MONTHVALUE]",showorder=9)
        ,@DEDataQueryCodeExp(name="MONTHWEEKTYPE",expression="t1.[MONTHWEEKTYPE]",showorder=10)
        ,@DEDataQueryCodeExp(name="MONTHWEEKVALUE",expression="t1.[MONTHWEEKVALUE]",showorder=11)
        ,@DEDataQueryCodeExp(name="SECONDTYPE",expression="t1.[SECONDTYPE]",showorder=12)
        ,@DEDataQueryCodeExp(name="SECONDVALUE",expression="t1.[SECONDVALUE]",showorder=13)
        ,@DEDataQueryCodeExp(name="TSSDITEMID",expression="t1.[TSSDITEMID]",showorder=14)
        ,@DEDataQueryCodeExp(name="TSSDITEMNAME",expression="t1.[TSSDITEMNAME]",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=17)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.[VERSION]",showorder=18)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class TSSDItemDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public TSSDItemDefaultDQModelBase() {
        super();

        this.initAnnotation(TSSDItemDefaultDQModelBase.class);
    }

}