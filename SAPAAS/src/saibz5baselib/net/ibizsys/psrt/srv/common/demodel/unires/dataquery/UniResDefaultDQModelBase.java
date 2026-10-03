/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.unires.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="92E66630-E3B4-4E37-90D3-3F46C1E35936",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.RESOURCEID, t1.UNIRESID, t1.UNIRESNAME, t1.UNIRESTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFUNIRES t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="RESOURCEID",expression="t1.RESOURCEID",showorder=7)
        ,@DEDataQueryCodeExp(name="UNIRESID",expression="t1.UNIRESID",showorder=8)
        ,@DEDataQueryCodeExp(name="UNIRESNAME",expression="t1.UNIRESNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UNIRESTYPE",expression="t1.UNIRESTYPE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`memo`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`resourceid`, t1.`uniresid`, t1.`uniresname`, t1.`unirestype`, t1.`updatedate`, t1.`updateman` FROM `t_srfunires` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=6)
        ,@DEDataQueryCodeExp(name="RESOURCEID",expression="t1.`resourceid`",showorder=7)
        ,@DEDataQueryCodeExp(name="UNIRESID",expression="t1.`uniresid`",showorder=8)
        ,@DEDataQueryCodeExp(name="UNIRESNAME",expression="t1.`uniresname`",showorder=9)
        ,@DEDataQueryCodeExp(name="UNIRESTYPE",expression="t1.`unirestype`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.RESOURCEID, t1.UNIRESID, t1.UNIRESNAME, t1.UNIRESTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFUNIRES t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="RESOURCEID",expression="t1.RESOURCEID",showorder=7)
        ,@DEDataQueryCodeExp(name="UNIRESID",expression="t1.UNIRESID",showorder=8)
        ,@DEDataQueryCodeExp(name="UNIRESNAME",expression="t1.UNIRESNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UNIRESTYPE",expression="t1.UNIRESTYPE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.RESOURCEID, t1.UNIRESID, t1.UNIRESNAME, t1.UNIRESTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFUNIRES t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="RESOURCEID",expression="t1.RESOURCEID",showorder=7)
        ,@DEDataQueryCodeExp(name="UNIRESID",expression="t1.UNIRESID",showorder=8)
        ,@DEDataQueryCodeExp(name="UNIRESNAME",expression="t1.UNIRESNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UNIRESTYPE",expression="t1.UNIRESTYPE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.RESOURCEID, t1.UNIRESID, t1.UNIRESNAME, t1.UNIRESTYPE, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFUNIRES t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="RESOURCEID",expression="t1.RESOURCEID",showorder=7)
        ,@DEDataQueryCodeExp(name="UNIRESID",expression="t1.UNIRESID",showorder=8)
        ,@DEDataQueryCodeExp(name="UNIRESNAME",expression="t1.UNIRESNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="UNIRESTYPE",expression="t1.UNIRESTYPE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[RESOURCEID], t1.[UNIRESID], t1.[UNIRESNAME], t1.[UNIRESTYPE], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFUNIRES] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=6)
        ,@DEDataQueryCodeExp(name="RESOURCEID",expression="t1.[RESOURCEID]",showorder=7)
        ,@DEDataQueryCodeExp(name="UNIRESID",expression="t1.[UNIRESID]",showorder=8)
        ,@DEDataQueryCodeExp(name="UNIRESNAME",expression="t1.[UNIRESNAME]",showorder=9)
        ,@DEDataQueryCodeExp(name="UNIRESTYPE",expression="t1.[UNIRESTYPE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=12)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UniResDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UniResDefaultDQModelBase() {
        super();

        this.initAnnotation(UniResDefaultDQModelBase.class);
    }

}