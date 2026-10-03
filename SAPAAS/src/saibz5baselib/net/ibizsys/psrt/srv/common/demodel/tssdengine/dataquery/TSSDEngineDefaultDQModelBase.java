/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdengine.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="5FC72289-4F52-43EE-AB72-855389DF00CD",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENGINEOBJECT, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.TSSDENGINEID, t1.TSSDENGINENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFTSSDENGINE t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="ENGINEPARAM",expression="t1.ENGINEPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.ENGINEOBJECT",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.TSSDENGINEID",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t1.TSSDENGINENAME",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`engineobject`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`tssdengineid`, t1.`tssdenginename`, t1.`updatedate`, t1.`updateman` FROM `t_srftssdengine` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="ENGINEPARAM",expression="t1.`engineparam`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.`engineobject`",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.`tssdengineid`",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t1.`tssdenginename`",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENGINEOBJECT, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.TSSDENGINEID, t1.TSSDENGINENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFTSSDENGINE t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="ENGINEPARAM",expression="t1.ENGINEPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.ENGINEOBJECT",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.TSSDENGINEID",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t1.TSSDENGINENAME",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENGINEOBJECT, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.TSSDENGINEID, t1.TSSDENGINENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFTSSDENGINE t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="ENGINEPARAM",expression="t1.ENGINEPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.ENGINEOBJECT",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.TSSDENGINEID",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t1.TSSDENGINENAME",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENGINEOBJECT, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.TSSDENGINEID, t1.TSSDENGINENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFTSSDENGINE t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="ENGINEPARAM",expression="t1.ENGINEPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.ENGINEOBJECT",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.TSSDENGINEID",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t1.TSSDENGINENAME",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=10)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[ENGINEOBJECT], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[TSSDENGINEID], t1.[TSSDENGINENAME], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFTSSDENGINE] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="ENGINEPARAM",expression="t1.[ENGINEPARAM]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="ENGINEOBJECT",expression="t1.[ENGINEOBJECT]",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=6)
        ,@DEDataQueryCodeExp(name="TSSDENGINEID",expression="t1.[TSSDENGINEID]",showorder=7)
        ,@DEDataQueryCodeExp(name="TSSDENGINENAME",expression="t1.[TSSDENGINENAME]",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=10)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class TSSDEngineDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public TSSDEngineDefaultDQModelBase() {
        super();

        this.initAnnotation(TSSDEngineDefaultDQModelBase.class);
    }

}