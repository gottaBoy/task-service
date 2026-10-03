/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfuiwizard.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="A42F37CA-9CD0-4B2D-9653-CFDC7B59AFBF",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.ACTIONMODE AS ACTIONMODE, t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.DATAINFO AS DATAINFO, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.WFSTEPVALUE AS WFSTEPVALUE, t1.WFUIWIZARDID AS WFUIWIZARDID, t1.WFUIWIZARDNAME AS WFUIWIZARDNAME FROM t_WFUIWIZARD t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="ACTIONPARAM",expression="t1.ACTIONPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="ACTIONMODE",expression="t1.ACTIONMODE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAINFO",expression="t1.DATAINFO",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFSTEPVALUE",expression="t1.WFSTEPVALUE",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDID",expression="t1.WFUIWIZARDID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDNAME",expression="t1.WFUIWIZARDNAME",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`actionmode`, t1.`createdate`, t1.`createman`, t1.`datainfo`, t1.`updatedate`, t1.`updateman`, t1.`wfstepvalue`, t1.`wfuiwizardid`, t1.`wfuiwizardname` FROM `t_wfuiwizard` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="ACTIONPARAM",expression="t1.`actionparam`",showorder=-1)
        ,@DEDataQueryCodeExp(name="ACTIONMODE",expression="t1.`actionmode`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAINFO",expression="t1.`datainfo`",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=5)
        ,@DEDataQueryCodeExp(name="WFSTEPVALUE",expression="t1.`wfstepvalue`",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDID",expression="t1.`wfuiwizardid`",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDNAME",expression="t1.`wfuiwizardname`",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ACTIONMODE AS ACTIONMODE, t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.DATAINFO AS DATAINFO, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.WFSTEPVALUE AS WFSTEPVALUE, t1.WFUIWIZARDID AS WFUIWIZARDID, t1.WFUIWIZARDNAME AS WFUIWIZARDNAME FROM t_WFUIWIZARD t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="ACTIONPARAM",expression="t1.ACTIONPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="ACTIONMODE",expression="t1.ACTIONMODE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAINFO",expression="t1.DATAINFO",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFSTEPVALUE",expression="t1.WFSTEPVALUE",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDID",expression="t1.WFUIWIZARDID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDNAME",expression="t1.WFUIWIZARDNAME",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ACTIONMODE AS ACTIONMODE, t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.DATAINFO AS DATAINFO, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.WFSTEPVALUE AS WFSTEPVALUE, t1.WFUIWIZARDID AS WFUIWIZARDID, t1.WFUIWIZARDNAME AS WFUIWIZARDNAME FROM t_WFUIWIZARD t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="ACTIONPARAM",expression="t1.ACTIONPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="ACTIONMODE",expression="t1.ACTIONMODE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAINFO",expression="t1.DATAINFO",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFSTEPVALUE",expression="t1.WFSTEPVALUE",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDID",expression="t1.WFUIWIZARDID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDNAME",expression="t1.WFUIWIZARDNAME",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ACTIONMODE AS ACTIONMODE, t1.CREATEDATE AS CREATEDATE, t1.CREATEMAN AS CREATEMAN, t1.DATAINFO AS DATAINFO, t1.UPDATEDATE AS UPDATEDATE, t1.UPDATEMAN AS UPDATEMAN, t1.WFSTEPVALUE AS WFSTEPVALUE, t1.WFUIWIZARDID AS WFUIWIZARDID, t1.WFUIWIZARDNAME AS WFUIWIZARDNAME FROM t_WFUIWIZARD t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="ACTIONPARAM",expression="t1.ACTIONPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="ACTIONMODE",expression="t1.ACTIONMODE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAINFO",expression="t1.DATAINFO",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="WFSTEPVALUE",expression="t1.WFSTEPVALUE",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDID",expression="t1.WFUIWIZARDID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDNAME",expression="t1.WFUIWIZARDNAME",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[ACTIONMODE] AS [ACTIONMODE], t1.[CREATEDATE] AS [CREATEDATE], t1.[CREATEMAN] AS [CREATEMAN], t1.[DATAINFO] AS [DATAINFO], t1.[UPDATEDATE] AS [UPDATEDATE], t1.[UPDATEMAN] AS [UPDATEMAN], t1.[WFSTEPVALUE] AS [WFSTEPVALUE], t1.[WFUIWIZARDID] AS [WFUIWIZARDID], t1.[WFUIWIZARDNAME] AS [WFUIWIZARDNAME] FROM [t_WFUIWIZARD] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="ACTIONPARAM",expression="t1.[ACTIONPARAM]",showorder=-1)
        ,@DEDataQueryCodeExp(name="ACTIONMODE",expression="t1.[ACTIONMODE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAINFO",expression="t1.[DATAINFO]",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=5)
        ,@DEDataQueryCodeExp(name="WFSTEPVALUE",expression="t1.[WFSTEPVALUE]",showorder=6)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDID",expression="t1.[WFUIWIZARDID]",showorder=7)
        ,@DEDataQueryCodeExp(name="WFUIWIZARDNAME",expression="t1.[WFUIWIZARDNAME]",showorder=8)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFUIWizardDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFUIWizardDefaultDQModelBase() {
        super();

        this.initAnnotation(WFUIWizardDefaultDQModelBase.class);
    }

}