/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.registry.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="18FD18E5-9F07-4F2C-B94E-D2F542AB2897",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PARAM1, t1.PARAM2, t1.PARAM3, t1.PARAM4, t1.PARAM5, t1.PARAM6, t1.PARAM7, t1.PARAM8, t1.REGISTRYID, t1.REGISTRYNAME, t1.SECTION, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFREGISTRY t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="PARAM9",expression="t1.PARAM9",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="PARAM1",expression="t1.PARAM1",showorder=3)
        ,@DEDataQueryCodeExp(name="PARAM2",expression="t1.PARAM2",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM3",expression="t1.PARAM3",showorder=5)
        ,@DEDataQueryCodeExp(name="PARAM4",expression="t1.PARAM4",showorder=6)
        ,@DEDataQueryCodeExp(name="PARAM5",expression="t1.PARAM5",showorder=7)
        ,@DEDataQueryCodeExp(name="PARAM6",expression="t1.PARAM6",showorder=8)
        ,@DEDataQueryCodeExp(name="PARAM7",expression="t1.PARAM7",showorder=9)
        ,@DEDataQueryCodeExp(name="PARAM8",expression="t1.PARAM8",showorder=10)
        ,@DEDataQueryCodeExp(name="REGISTRYID",expression="t1.REGISTRYID",showorder=11)
        ,@DEDataQueryCodeExp(name="REGISTRYNAME",expression="t1.REGISTRYNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="SECTION",expression="t1.SECTION",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`memo`, t1.`param1`, t1.`param2`, t1.`param3`, t1.`param4`, t1.`param5`, t1.`param6`, t1.`param7`, t1.`param8`, t1.`registryid`, t1.`registryname`, t1.`section`, t1.`updatedate`, t1.`updateman` FROM `t_srfregistry` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="PARAM9",expression="t1.`param9`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=2)
        ,@DEDataQueryCodeExp(name="PARAM1",expression="t1.`param1`",showorder=3)
        ,@DEDataQueryCodeExp(name="PARAM2",expression="t1.`param2`",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM3",expression="t1.`param3`",showorder=5)
        ,@DEDataQueryCodeExp(name="PARAM4",expression="t1.`param4`",showorder=6)
        ,@DEDataQueryCodeExp(name="PARAM5",expression="t1.`param5`",showorder=7)
        ,@DEDataQueryCodeExp(name="PARAM6",expression="t1.`param6`",showorder=8)
        ,@DEDataQueryCodeExp(name="PARAM7",expression="t1.`param7`",showorder=9)
        ,@DEDataQueryCodeExp(name="PARAM8",expression="t1.`param8`",showorder=10)
        ,@DEDataQueryCodeExp(name="REGISTRYID",expression="t1.`registryid`",showorder=11)
        ,@DEDataQueryCodeExp(name="REGISTRYNAME",expression="t1.`registryname`",showorder=12)
        ,@DEDataQueryCodeExp(name="SECTION",expression="t1.`section`",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PARAM1, t1.PARAM2, t1.PARAM3, t1.PARAM4, t1.PARAM5, t1.PARAM6, t1.PARAM7, t1.PARAM8, t1.REGISTRYID, t1.REGISTRYNAME, t1.SECTION, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFREGISTRY t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="PARAM9",expression="t1.PARAM9",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="PARAM1",expression="t1.PARAM1",showorder=3)
        ,@DEDataQueryCodeExp(name="PARAM2",expression="t1.PARAM2",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM3",expression="t1.PARAM3",showorder=5)
        ,@DEDataQueryCodeExp(name="PARAM4",expression="t1.PARAM4",showorder=6)
        ,@DEDataQueryCodeExp(name="PARAM5",expression="t1.PARAM5",showorder=7)
        ,@DEDataQueryCodeExp(name="PARAM6",expression="t1.PARAM6",showorder=8)
        ,@DEDataQueryCodeExp(name="PARAM7",expression="t1.PARAM7",showorder=9)
        ,@DEDataQueryCodeExp(name="PARAM8",expression="t1.PARAM8",showorder=10)
        ,@DEDataQueryCodeExp(name="REGISTRYID",expression="t1.REGISTRYID",showorder=11)
        ,@DEDataQueryCodeExp(name="REGISTRYNAME",expression="t1.REGISTRYNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="SECTION",expression="t1.SECTION",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PARAM1, t1.PARAM2, t1.PARAM3, t1.PARAM4, t1.PARAM5, t1.PARAM6, t1.PARAM7, t1.PARAM8, t1.REGISTRYID, t1.REGISTRYNAME, t1.SECTION, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFREGISTRY t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="PARAM9",expression="t1.PARAM9",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="PARAM1",expression="t1.PARAM1",showorder=3)
        ,@DEDataQueryCodeExp(name="PARAM2",expression="t1.PARAM2",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM3",expression="t1.PARAM3",showorder=5)
        ,@DEDataQueryCodeExp(name="PARAM4",expression="t1.PARAM4",showorder=6)
        ,@DEDataQueryCodeExp(name="PARAM5",expression="t1.PARAM5",showorder=7)
        ,@DEDataQueryCodeExp(name="PARAM6",expression="t1.PARAM6",showorder=8)
        ,@DEDataQueryCodeExp(name="PARAM7",expression="t1.PARAM7",showorder=9)
        ,@DEDataQueryCodeExp(name="PARAM8",expression="t1.PARAM8",showorder=10)
        ,@DEDataQueryCodeExp(name="REGISTRYID",expression="t1.REGISTRYID",showorder=11)
        ,@DEDataQueryCodeExp(name="REGISTRYNAME",expression="t1.REGISTRYNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="SECTION",expression="t1.SECTION",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PARAM1, t1.PARAM2, t1.PARAM3, t1.PARAM4, t1.PARAM5, t1.PARAM6, t1.PARAM7, t1.PARAM8, t1.REGISTRYID, t1.REGISTRYNAME, t1.SECTION, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFREGISTRY t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="PARAM9",expression="t1.PARAM9",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="PARAM1",expression="t1.PARAM1",showorder=3)
        ,@DEDataQueryCodeExp(name="PARAM2",expression="t1.PARAM2",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM3",expression="t1.PARAM3",showorder=5)
        ,@DEDataQueryCodeExp(name="PARAM4",expression="t1.PARAM4",showorder=6)
        ,@DEDataQueryCodeExp(name="PARAM5",expression="t1.PARAM5",showorder=7)
        ,@DEDataQueryCodeExp(name="PARAM6",expression="t1.PARAM6",showorder=8)
        ,@DEDataQueryCodeExp(name="PARAM7",expression="t1.PARAM7",showorder=9)
        ,@DEDataQueryCodeExp(name="PARAM8",expression="t1.PARAM8",showorder=10)
        ,@DEDataQueryCodeExp(name="REGISTRYID",expression="t1.REGISTRYID",showorder=11)
        ,@DEDataQueryCodeExp(name="REGISTRYNAME",expression="t1.REGISTRYNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="SECTION",expression="t1.SECTION",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=15)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[PARAM1], t1.[PARAM2], t1.[PARAM3], t1.[PARAM4], t1.[PARAM5], t1.[PARAM6], t1.[PARAM7], t1.[PARAM8], t1.[REGISTRYID], t1.[REGISTRYNAME], t1.[SECTION], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFREGISTRY] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="PARAM9",expression="t1.[PARAM9]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=2)
        ,@DEDataQueryCodeExp(name="PARAM1",expression="t1.[PARAM1]",showorder=3)
        ,@DEDataQueryCodeExp(name="PARAM2",expression="t1.[PARAM2]",showorder=4)
        ,@DEDataQueryCodeExp(name="PARAM3",expression="t1.[PARAM3]",showorder=5)
        ,@DEDataQueryCodeExp(name="PARAM4",expression="t1.[PARAM4]",showorder=6)
        ,@DEDataQueryCodeExp(name="PARAM5",expression="t1.[PARAM5]",showorder=7)
        ,@DEDataQueryCodeExp(name="PARAM6",expression="t1.[PARAM6]",showorder=8)
        ,@DEDataQueryCodeExp(name="PARAM7",expression="t1.[PARAM7]",showorder=9)
        ,@DEDataQueryCodeExp(name="PARAM8",expression="t1.[PARAM8]",showorder=10)
        ,@DEDataQueryCodeExp(name="REGISTRYID",expression="t1.[REGISTRYID]",showorder=11)
        ,@DEDataQueryCodeExp(name="REGISTRYNAME",expression="t1.[REGISTRYNAME]",showorder=12)
        ,@DEDataQueryCodeExp(name="SECTION",expression="t1.[SECTION]",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=15)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class RegistryDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public RegistryDefaultDQModelBase() {
        super();

        this.initAnnotation(RegistryDefaultDQModelBase.class);
    }

}