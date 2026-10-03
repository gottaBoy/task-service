/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.dynasys.demodel.dsdynawf.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="9C3F6870-9BCF-4746-9495-0A84F3EA19CB",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DSDYNAWFID, t1.DSDYNAWFNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFWORKFLOWID, t1.WFWORKFLOWNAME FROM T_SRFDSDYNAWF t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DSDYNAWFID",expression="t1.DSDYNAWFID",showorder=2)
        ,@DEDataQueryCodeExp(name="DSDYNAWFNAME",expression="t1.DSDYNAWFNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.WFWORKFLOWID",showorder=6)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.WFWORKFLOWNAME",showorder=7)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`dsdynawfid`, t1.`dsdynawfname`, t1.`updatedate`, t1.`updateman`, t1.`wfworkflowid`, t1.`wfworkflowname` FROM `t_srfdsdynawf` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="DSDYNAWFID",expression="t1.`dsdynawfid`",showorder=2)
        ,@DEDataQueryCodeExp(name="DSDYNAWFNAME",expression="t1.`dsdynawfname`",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=5)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.`wfworkflowid`",showorder=6)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.`wfworkflowname`",showorder=7)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DSDYNAWFID, t1.DSDYNAWFNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.WFWORKFLOWID, t1.WFWORKFLOWNAME FROM T_SRFDSDYNAWF t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="DSDYNAWFID",expression="t1.DSDYNAWFID",showorder=2)
        ,@DEDataQueryCodeExp(name="DSDYNAWFNAME",expression="t1.DSDYNAWFNAME",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.WFWORKFLOWID",showorder=6)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.WFWORKFLOWNAME",showorder=7)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[DSDYNAWFID], t1.[DSDYNAWFNAME], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WFWORKFLOWID], t1.[WFWORKFLOWNAME] FROM [T_SRFDSDYNAWF] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="DSDYNAWFID",expression="t1.[DSDYNAWFID]",showorder=2)
        ,@DEDataQueryCodeExp(name="DSDYNAWFNAME",expression="t1.[DSDYNAWFNAME]",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=5)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWID",expression="t1.[WFWORKFLOWID]",showorder=6)
        ,@DEDataQueryCodeExp(name="WFWORKFLOWNAME",expression="t1.[WFWORKFLOWNAME]",showorder=7)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class DSDynaWFDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public DSDynaWFDefaultDQModelBase() {
        super();

        this.initAnnotation(DSDynaWFDefaultDQModelBase.class);
    }

}