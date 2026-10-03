/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncagent.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="DD1326DD-0A81-4D3C-BB7C-E3F1CEDC95FE",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.AGENTTYPE, t1.CLIENTID, t1.CREATEDATE, t1.CREATEMAN, t1.DATASYNCAGENTID, t1.DATASYNCAGENTNAME, t1.ENABLE, t1.MEMO, t1.PWD, t1.SERVERPATH, t1.SERVICENAME, t1.SYNCDIR, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME FROM T_SRFDATASYNCAGENT t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTPARAM",expression="t1.AGENTPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="AGENTTYPE",expression="t1.AGENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CLIENTID",expression="t1.CLIENTID",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTID",expression="t1.DATASYNCAGENTID",showorder=4)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTNAME",expression="t1.DATASYNCAGENTNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=7)
        ,@DEDataQueryCodeExp(name="PWD",expression="t1.PWD",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERPATH",expression="t1.SERVERPATH",showorder=9)
        ,@DEDataQueryCodeExp(name="SERVICENAME",expression="t1.SERVICENAME",showorder=10)
        ,@DEDataQueryCodeExp(name="SYNCDIR",expression="t1.SYNCDIR",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=13)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.USERNAME",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.`agenttype`, t1.`clientid`, t1.`createdate`, t1.`createman`, t1.`datasyncagentid`, t1.`datasyncagentname`, t1.`enable`, t1.`memo`, t1.`pwd`, t1.`serverpath`, t1.`servicename`, t1.`syncdir`, t1.`updatedate`, t1.`updateman`, t1.`username` FROM `t_srfdatasyncagent` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTPARAM",expression="t1.`agentparam`",showorder=-1)
        ,@DEDataQueryCodeExp(name="AGENTTYPE",expression="t1.`agenttype`",showorder=0)
        ,@DEDataQueryCodeExp(name="CLIENTID",expression="t1.`clientid`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTID",expression="t1.`datasyncagentid`",showorder=4)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTNAME",expression="t1.`datasyncagentname`",showorder=5)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.`enable`",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=7)
        ,@DEDataQueryCodeExp(name="PWD",expression="t1.`pwd`",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERPATH",expression="t1.`serverpath`",showorder=9)
        ,@DEDataQueryCodeExp(name="SERVICENAME",expression="t1.`servicename`",showorder=10)
        ,@DEDataQueryCodeExp(name="SYNCDIR",expression="t1.`syncdir`",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=13)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.`username`",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.enable = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.AGENTTYPE, t1.CLIENTID, t1.CREATEDATE, t1.CREATEMAN, t1.DATASYNCAGENTID, t1.DATASYNCAGENTNAME, t1.ENABLE, t1.MEMO, t1.PWD, t1.SERVERPATH, t1.SERVICENAME, t1.SYNCDIR, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME FROM T_SRFDATASYNCAGENT t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTPARAM",expression="t1.AGENTPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="AGENTTYPE",expression="t1.AGENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CLIENTID",expression="t1.CLIENTID",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTID",expression="t1.DATASYNCAGENTID",showorder=4)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTNAME",expression="t1.DATASYNCAGENTNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=7)
        ,@DEDataQueryCodeExp(name="PWD",expression="t1.PWD",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERPATH",expression="t1.SERVERPATH",showorder=9)
        ,@DEDataQueryCodeExp(name="SERVICENAME",expression="t1.SERVICENAME",showorder=10)
        ,@DEDataQueryCodeExp(name="SYNCDIR",expression="t1.SYNCDIR",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=13)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.USERNAME",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.AGENTTYPE, t1.CLIENTID, t1.CREATEDATE, t1.CREATEMAN, t1.DATASYNCAGENTID, t1.DATASYNCAGENTNAME, t1.ENABLE, t1.MEMO, t1.PWD, t1.SERVERPATH, t1.SERVICENAME, t1.SYNCDIR, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME FROM T_SRFDATASYNCAGENT t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTPARAM",expression="t1.AGENTPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="AGENTTYPE",expression="t1.AGENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CLIENTID",expression="t1.CLIENTID",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTID",expression="t1.DATASYNCAGENTID",showorder=4)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTNAME",expression="t1.DATASYNCAGENTNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=7)
        ,@DEDataQueryCodeExp(name="PWD",expression="t1.PWD",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERPATH",expression="t1.SERVERPATH",showorder=9)
        ,@DEDataQueryCodeExp(name="SERVICENAME",expression="t1.SERVICENAME",showorder=10)
        ,@DEDataQueryCodeExp(name="SYNCDIR",expression="t1.SYNCDIR",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=13)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.USERNAME",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.AGENTTYPE, t1.CLIENTID, t1.CREATEDATE, t1.CREATEMAN, t1.DATASYNCAGENTID, t1.DATASYNCAGENTNAME, t1.ENABLE, t1.MEMO, t1.PWD, t1.SERVERPATH, t1.SERVICENAME, t1.SYNCDIR, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERNAME FROM T_SRFDATASYNCAGENT t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTPARAM",expression="t1.AGENTPARAM",showorder=-1)
        ,@DEDataQueryCodeExp(name="AGENTTYPE",expression="t1.AGENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CLIENTID",expression="t1.CLIENTID",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTID",expression="t1.DATASYNCAGENTID",showorder=4)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTNAME",expression="t1.DATASYNCAGENTNAME",showorder=5)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=7)
        ,@DEDataQueryCodeExp(name="PWD",expression="t1.PWD",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERPATH",expression="t1.SERVERPATH",showorder=9)
        ,@DEDataQueryCodeExp(name="SERVICENAME",expression="t1.SERVICENAME",showorder=10)
        ,@DEDataQueryCodeExp(name="SYNCDIR",expression="t1.SYNCDIR",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=13)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.USERNAME",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.[AGENTTYPE], t1.[CLIENTID], t1.[CREATEDATE], t1.[CREATEMAN], t1.[DATASYNCAGENTID], t1.[DATASYNCAGENTNAME], t1.[ENABLE], t1.[MEMO], t1.[PWD], t1.[SERVERPATH], t1.[SERVICENAME], t1.[SYNCDIR], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERNAME] FROM [T_SRFDATASYNCAGENT] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTPARAM",expression="t1.[AGENTPARAM]",showorder=-1)
        ,@DEDataQueryCodeExp(name="AGENTTYPE",expression="t1.[AGENTTYPE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CLIENTID",expression="t1.[CLIENTID]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=2)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=3)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTID",expression="t1.[DATASYNCAGENTID]",showorder=4)
        ,@DEDataQueryCodeExp(name="DATASYNCAGENTNAME",expression="t1.[DATASYNCAGENTNAME]",showorder=5)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.[ENABLE]",showorder=6)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=7)
        ,@DEDataQueryCodeExp(name="PWD",expression="t1.[PWD]",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERPATH",expression="t1.[SERVERPATH]",showorder=9)
        ,@DEDataQueryCodeExp(name="SERVICENAME",expression="t1.[SERVICENAME]",showorder=10)
        ,@DEDataQueryCodeExp(name="SYNCDIR",expression="t1.[SYNCDIR]",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=13)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.[USERNAME]",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    })
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class DataSyncAgentDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public DataSyncAgentDefaultDQModelBase() {
        super();

        this.initAnnotation(DataSyncAgentDefaultDQModelBase.class);
    }

}