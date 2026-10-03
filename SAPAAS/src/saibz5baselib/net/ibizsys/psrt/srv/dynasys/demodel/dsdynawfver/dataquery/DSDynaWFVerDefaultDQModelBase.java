/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynawfver.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="C68ED47B-3577-449F-8DBD-5B2E70B53124",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DSDYNAWFID, t11.DSDYNAWFNAME, t1.DSDYNAWFVERID, t1.DSDYNAWFVERNAME, t1.DYNASYSINSTID, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFVERSION FROM T_SRFDSDYNAWFVER t1  LEFT JOIN T_SRFDSDYNAWF t11 ON t1.DSDYNAWFID = t11.DSDYNAWFID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="DYNAMODEL",expression="t1.DYNAMODEL",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DSDYNAWFID",expression="t1.DSDYNAWFID",showorder=2)
        ,@DEDataQueryCodeExp(name="DSDYNAWFNAME",expression="t11.DSDYNAWFNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="DSDYNAWFVERID",expression="t1.DSDYNAWFVERID",showorder=4)
        ,@DEDataQueryCodeExp(name="DSDYNAWFVERNAME",expression="t1.DSDYNAWFVERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="DYNASYSINSTID",expression="t1.DYNASYSINSTID",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="WFVERSION",expression="t1.WFVERSION",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`dsdynawfid`, t11.`dsdynawfname`, t1.`dsdynawfverid`, t1.`dsdynawfvername`, t1.`dynasysinstid`, t1.`updatedate`, t1.`updateman`, t1.`wfversion` FROM `t_srfdsdynawfver` t1  LEFT JOIN t_srfdsdynawf t11 ON t1.dsdynawfid = t11.dsdynawfid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="DYNAMODEL",expression="t1.`dynamodel`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="DSDYNAWFID",expression="t1.`dsdynawfid`",showorder=2)
        ,@DEDataQueryCodeExp(name="DSDYNAWFNAME",expression="t11.`dsdynawfname`",showorder=3)
        ,@DEDataQueryCodeExp(name="DSDYNAWFVERID",expression="t1.`dsdynawfverid`",showorder=4)
        ,@DEDataQueryCodeExp(name="DSDYNAWFVERNAME",expression="t1.`dsdynawfvername`",showorder=5)
        ,@DEDataQueryCodeExp(name="DYNASYSINSTID",expression="t1.`dynasysinstid`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=8)
        ,@DEDataQueryCodeExp(name="WFVERSION",expression="t1.`wfversion`",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DSDYNAWFID, t11.DSDYNAWFNAME, t1.DSDYNAWFVERID, t1.DSDYNAWFVERNAME, t1.DYNASYSINSTID, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFVERSION FROM T_SRFDSDYNAWFVER t1  LEFT JOIN T_SRFDSDYNAWF t11 ON t1.DSDYNAWFID = t11.DSDYNAWFID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="DYNAMODEL",expression="t1.DYNAMODEL",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DSDYNAWFID",expression="t1.DSDYNAWFID",showorder=2)
        ,@DEDataQueryCodeExp(name="DSDYNAWFNAME",expression="t11.DSDYNAWFNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="DSDYNAWFVERID",expression="t1.DSDYNAWFVERID",showorder=4)
        ,@DEDataQueryCodeExp(name="DSDYNAWFVERNAME",expression="t1.DSDYNAWFVERNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="DYNASYSINSTID",expression="t1.DYNASYSINSTID",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="WFVERSION",expression="t1.WFVERSION",showorder=9)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[DSDYNAWFID], t11.[DSDYNAWFNAME], t1.[DSDYNAWFVERID], t1.[DSDYNAWFVERNAME], t1.[DYNASYSINSTID], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WFVERSION] FROM [T_SRFDSDYNAWFVER] t1  LEFT JOIN T_SRFDSDYNAWF t11 ON t1.DSDYNAWFID = t11.DSDYNAWFID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="DYNAMODEL",expression="t1.[DYNAMODEL]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="DSDYNAWFID",expression="t1.[DSDYNAWFID]",showorder=2)
        ,@DEDataQueryCodeExp(name="DSDYNAWFNAME",expression="t11.[DSDYNAWFNAME]",showorder=3)
        ,@DEDataQueryCodeExp(name="DSDYNAWFVERID",expression="t1.[DSDYNAWFVERID]",showorder=4)
        ,@DEDataQueryCodeExp(name="DSDYNAWFVERNAME",expression="t1.[DSDYNAWFVERNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="DYNASYSINSTID",expression="t1.[DYNASYSINSTID]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=8)
        ,@DEDataQueryCodeExp(name="WFVERSION",expression="t1.[WFVERSION]",showorder=9)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class DSDynaWFVerDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public DSDynaWFVerDefaultDQModelBase() {
        super();

        this.initAnnotation(DSDynaWFVerDefaultDQModelBase.class);
    }

}