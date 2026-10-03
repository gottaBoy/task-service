/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.codeitem.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="05FAA261-0651-458F-8269-ECD08771AFD9",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CODEITEMID, t1.CODEITEMNAME, t1.CODEITEMVALUE, t1.CODELISTID, t11.CODELISTNAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PCODEITEMID, t21.CODEITEMNAME AS PCODEITEMNAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.RESERVER5, t1.SHORTKEY, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFCODEITEM t1  LEFT JOIN T_SRFCODELIST t11 ON t1.CODELISTID = t11.CODELISTID  LEFT JOIN T_SRFCODEITEM t21 ON t1.PCODEITEMID = t21.CODEITEMID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CODEITEMID",expression="t1.CODEITEMID",showorder=0)
        ,@DEDataQueryCodeExp(name="CODEITEMNAME",expression="t1.CODEITEMNAME",showorder=1)
        ,@DEDataQueryCodeExp(name="CODEITEMVALUE",expression="t1.CODEITEMVALUE",showorder=2)
        ,@DEDataQueryCodeExp(name="CODELISTID",expression="t1.CODELISTID",showorder=3)
        ,@DEDataQueryCodeExp(name="CODELISTNAME",expression="t11.CODELISTNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=5)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=7)
        ,@DEDataQueryCodeExp(name="ORDERVALUE",expression="t1.ORDERVALUE",showorder=8)
        ,@DEDataQueryCodeExp(name="PCODEITEMID",expression="t1.PCODEITEMID",showorder=9)
        ,@DEDataQueryCodeExp(name="PCODEITEMNAME",expression="t21.CODEITEMNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER5",expression="t1.RESERVER5",showorder=15)
        ,@DEDataQueryCodeExp(name="SHORTKEY",expression="t1.SHORTKEY",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`codeitemid`, t1.`codeitemname`, t1.`codeitemvalue`, t1.`codelistid`, t11.`codelistname`, t1.`createdate`, t1.`createman`, t1.`memo`, t1.`ordervalue`, t1.`pcodeitemid`, t21.`codeitemname` AS `pcodeitemname`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`reserver5`, t1.`shortkey`, t1.`updatedate`, t1.`updateman` FROM `t_srfcodeitem` t1  LEFT JOIN t_srfcodelist t11 ON t1.codelistid = t11.codelistid  LEFT JOIN t_srfcodeitem t21 ON t1.pcodeitemid = t21.codeitemid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CODEITEMID",expression="t1.`codeitemid`",showorder=0)
        ,@DEDataQueryCodeExp(name="CODEITEMNAME",expression="t1.`codeitemname`",showorder=1)
        ,@DEDataQueryCodeExp(name="CODEITEMVALUE",expression="t1.`codeitemvalue`",showorder=2)
        ,@DEDataQueryCodeExp(name="CODELISTID",expression="t1.`codelistid`",showorder=3)
        ,@DEDataQueryCodeExp(name="CODELISTNAME",expression="t11.`codelistname`",showorder=4)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=5)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=7)
        ,@DEDataQueryCodeExp(name="ORDERVALUE",expression="t1.`ordervalue`",showorder=8)
        ,@DEDataQueryCodeExp(name="PCODEITEMID",expression="t1.`pcodeitemid`",showorder=9)
        ,@DEDataQueryCodeExp(name="PCODEITEMNAME",expression="t21.`codeitemname`",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER5",expression="t1.`reserver5`",showorder=15)
        ,@DEDataQueryCodeExp(name="SHORTKEY",expression="t1.`shortkey`",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CODEITEMID, t1.CODEITEMNAME, t1.CODEITEMVALUE, t1.CODELISTID, t11.CODELISTNAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PCODEITEMID, t21.CODEITEMNAME AS PCODEITEMNAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.RESERVER5, t1.SHORTKEY, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFCODEITEM t1  LEFT JOIN T_SRFCODELIST t11 ON t1.CODELISTID = t11.CODELISTID  LEFT JOIN T_SRFCODEITEM t21 ON t1.PCODEITEMID = t21.CODEITEMID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CODEITEMID",expression="t1.CODEITEMID",showorder=0)
        ,@DEDataQueryCodeExp(name="CODEITEMNAME",expression="t1.CODEITEMNAME",showorder=1)
        ,@DEDataQueryCodeExp(name="CODEITEMVALUE",expression="t1.CODEITEMVALUE",showorder=2)
        ,@DEDataQueryCodeExp(name="CODELISTID",expression="t1.CODELISTID",showorder=3)
        ,@DEDataQueryCodeExp(name="CODELISTNAME",expression="t11.CODELISTNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=5)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=7)
        ,@DEDataQueryCodeExp(name="ORDERVALUE",expression="t1.ORDERVALUE",showorder=8)
        ,@DEDataQueryCodeExp(name="PCODEITEMID",expression="t1.PCODEITEMID",showorder=9)
        ,@DEDataQueryCodeExp(name="PCODEITEMNAME",expression="t21.CODEITEMNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER5",expression="t1.RESERVER5",showorder=15)
        ,@DEDataQueryCodeExp(name="SHORTKEY",expression="t1.SHORTKEY",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CODEITEMID, t1.CODEITEMNAME, t1.CODEITEMVALUE, t1.CODELISTID, t11.CODELISTNAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PCODEITEMID, t21.CODEITEMNAME AS PCODEITEMNAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.RESERVER5, t1.SHORTKEY, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFCODEITEM t1  LEFT JOIN T_SRFCODELIST t11 ON t1.CODELISTID = t11.CODELISTID  LEFT JOIN T_SRFCODEITEM t21 ON t1.PCODEITEMID = t21.CODEITEMID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CODEITEMID",expression="t1.CODEITEMID",showorder=0)
        ,@DEDataQueryCodeExp(name="CODEITEMNAME",expression="t1.CODEITEMNAME",showorder=1)
        ,@DEDataQueryCodeExp(name="CODEITEMVALUE",expression="t1.CODEITEMVALUE",showorder=2)
        ,@DEDataQueryCodeExp(name="CODELISTID",expression="t1.CODELISTID",showorder=3)
        ,@DEDataQueryCodeExp(name="CODELISTNAME",expression="t11.CODELISTNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=5)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=7)
        ,@DEDataQueryCodeExp(name="ORDERVALUE",expression="t1.ORDERVALUE",showorder=8)
        ,@DEDataQueryCodeExp(name="PCODEITEMID",expression="t1.PCODEITEMID",showorder=9)
        ,@DEDataQueryCodeExp(name="PCODEITEMNAME",expression="t21.CODEITEMNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER5",expression="t1.RESERVER5",showorder=15)
        ,@DEDataQueryCodeExp(name="SHORTKEY",expression="t1.SHORTKEY",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CODEITEMID, t1.CODEITEMNAME, t1.CODEITEMVALUE, t1.CODELISTID, t11.CODELISTNAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PCODEITEMID, t21.CODEITEMNAME AS PCODEITEMNAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.RESERVER5, t1.SHORTKEY, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFCODEITEM t1  LEFT JOIN T_SRFCODELIST t11 ON t1.CODELISTID = t11.CODELISTID  LEFT JOIN T_SRFCODEITEM t21 ON t1.PCODEITEMID = t21.CODEITEMID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CODEITEMID",expression="t1.CODEITEMID",showorder=0)
        ,@DEDataQueryCodeExp(name="CODEITEMNAME",expression="t1.CODEITEMNAME",showorder=1)
        ,@DEDataQueryCodeExp(name="CODEITEMVALUE",expression="t1.CODEITEMVALUE",showorder=2)
        ,@DEDataQueryCodeExp(name="CODELISTID",expression="t1.CODELISTID",showorder=3)
        ,@DEDataQueryCodeExp(name="CODELISTNAME",expression="t11.CODELISTNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=5)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=7)
        ,@DEDataQueryCodeExp(name="ORDERVALUE",expression="t1.ORDERVALUE",showorder=8)
        ,@DEDataQueryCodeExp(name="PCODEITEMID",expression="t1.PCODEITEMID",showorder=9)
        ,@DEDataQueryCodeExp(name="PCODEITEMNAME",expression="t21.CODEITEMNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER5",expression="t1.RESERVER5",showorder=15)
        ,@DEDataQueryCodeExp(name="SHORTKEY",expression="t1.SHORTKEY",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=18)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CODEITEMID], t1.[CODEITEMNAME], t1.[CODEITEMVALUE], t1.[CODELISTID], t11.[CODELISTNAME], t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[ORDERVALUE], t1.[PCODEITEMID], t21.[CODEITEMNAME] AS [PCODEITEMNAME], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[RESERVER5], t1.[SHORTKEY], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFCODEITEM] t1  LEFT JOIN T_SRFCODELIST t11 ON t1.CODELISTID = t11.CODELISTID  LEFT JOIN T_SRFCODEITEM t21 ON t1.PCODEITEMID = t21.CODEITEMID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CODEITEMID",expression="t1.[CODEITEMID]",showorder=0)
        ,@DEDataQueryCodeExp(name="CODEITEMNAME",expression="t1.[CODEITEMNAME]",showorder=1)
        ,@DEDataQueryCodeExp(name="CODEITEMVALUE",expression="t1.[CODEITEMVALUE]",showorder=2)
        ,@DEDataQueryCodeExp(name="CODELISTID",expression="t1.[CODELISTID]",showorder=3)
        ,@DEDataQueryCodeExp(name="CODELISTNAME",expression="t11.[CODELISTNAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=5)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=7)
        ,@DEDataQueryCodeExp(name="ORDERVALUE",expression="t1.[ORDERVALUE]",showorder=8)
        ,@DEDataQueryCodeExp(name="PCODEITEMID",expression="t1.[PCODEITEMID]",showorder=9)
        ,@DEDataQueryCodeExp(name="PCODEITEMNAME",expression="t21.[CODEITEMNAME]",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER5",expression="t1.[RESERVER5]",showorder=15)
        ,@DEDataQueryCodeExp(name="SHORTKEY",expression="t1.[SHORTKEY]",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=18)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class CodeItemDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public CodeItemDefaultDQModelBase() {
        super();

        this.initAnnotation(CodeItemDefaultDQModelBase.class);
    }

}