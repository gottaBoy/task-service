/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.dataaudit.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="66064FCB-6E42-48DE-A6E0-3DB2F71181C4",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.AUDITTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DATAAUDITID, t1.DATAAUDITNAME, t1.IPADDRESS, t1.OBJECTID, t1.OBJECTTYPE, t1.OPPERSONID, t1.OPPERSONNAME, t1.SESSIONID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATAAUDIT t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="AUDITINFO",expression="t1.AUDITINFO",showorder=-1)
        ,@DEDataQueryCodeExp(name="AUDITTYPE",expression="t1.AUDITTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAAUDITID",expression="t1.DATAAUDITID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATAAUDITNAME",expression="t1.DATAAUDITNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.IPADDRESS",showorder=5)
        ,@DEDataQueryCodeExp(name="OBJECTID",expression="t1.OBJECTID",showorder=6)
        ,@DEDataQueryCodeExp(name="OBJECTTYPE",expression="t1.OBJECTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="OPPERSONID",expression="t1.OPPERSONID",showorder=8)
        ,@DEDataQueryCodeExp(name="OPPERSONNAME",expression="t1.OPPERSONNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="SESSIONID",expression="t1.SESSIONID",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`audittype`, t1.`createdate`, t1.`createman`, t1.`dataauditid`, t1.`dataauditname`, t1.`ipaddress`, t1.`objectid`, t1.`objecttype`, t1.`oppersonid`, t1.`oppersonname`, t1.`sessionid`, t1.`updatedate`, t1.`updateman` FROM `t_srfdataaudit` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="AUDITINFO",expression="t1.`auditinfo`",showorder=-1)
        ,@DEDataQueryCodeExp(name="AUDITTYPE",expression="t1.`audittype`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAAUDITID",expression="t1.`dataauditid`",showorder=3)
        ,@DEDataQueryCodeExp(name="DATAAUDITNAME",expression="t1.`dataauditname`",showorder=4)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.`ipaddress`",showorder=5)
        ,@DEDataQueryCodeExp(name="OBJECTID",expression="t1.`objectid`",showorder=6)
        ,@DEDataQueryCodeExp(name="OBJECTTYPE",expression="t1.`objecttype`",showorder=7)
        ,@DEDataQueryCodeExp(name="OPPERSONID",expression="t1.`oppersonid`",showorder=8)
        ,@DEDataQueryCodeExp(name="OPPERSONNAME",expression="t1.`oppersonname`",showorder=9)
        ,@DEDataQueryCodeExp(name="SESSIONID",expression="t1.`sessionid`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.AUDITTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DATAAUDITID, t1.DATAAUDITNAME, t1.IPADDRESS, t1.OBJECTID, t1.OBJECTTYPE, t1.OPPERSONID, t1.OPPERSONNAME, t1.SESSIONID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATAAUDIT t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="AUDITINFO",expression="t1.AUDITINFO",showorder=-1)
        ,@DEDataQueryCodeExp(name="AUDITTYPE",expression="t1.AUDITTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAAUDITID",expression="t1.DATAAUDITID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATAAUDITNAME",expression="t1.DATAAUDITNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.IPADDRESS",showorder=5)
        ,@DEDataQueryCodeExp(name="OBJECTID",expression="t1.OBJECTID",showorder=6)
        ,@DEDataQueryCodeExp(name="OBJECTTYPE",expression="t1.OBJECTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="OPPERSONID",expression="t1.OPPERSONID",showorder=8)
        ,@DEDataQueryCodeExp(name="OPPERSONNAME",expression="t1.OPPERSONNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="SESSIONID",expression="t1.SESSIONID",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.AUDITTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DATAAUDITID, t1.DATAAUDITNAME, t1.IPADDRESS, t1.OBJECTID, t1.OBJECTTYPE, t1.OPPERSONID, t1.OPPERSONNAME, t1.SESSIONID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATAAUDIT t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="AUDITINFO",expression="t1.AUDITINFO",showorder=-1)
        ,@DEDataQueryCodeExp(name="AUDITTYPE",expression="t1.AUDITTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAAUDITID",expression="t1.DATAAUDITID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATAAUDITNAME",expression="t1.DATAAUDITNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.IPADDRESS",showorder=5)
        ,@DEDataQueryCodeExp(name="OBJECTID",expression="t1.OBJECTID",showorder=6)
        ,@DEDataQueryCodeExp(name="OBJECTTYPE",expression="t1.OBJECTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="OPPERSONID",expression="t1.OPPERSONID",showorder=8)
        ,@DEDataQueryCodeExp(name="OPPERSONNAME",expression="t1.OPPERSONNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="SESSIONID",expression="t1.SESSIONID",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.AUDITTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DATAAUDITID, t1.DATAAUDITNAME, t1.IPADDRESS, t1.OBJECTID, t1.OBJECTTYPE, t1.OPPERSONID, t1.OPPERSONNAME, t1.SESSIONID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFDATAAUDIT t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="AUDITINFO",expression="t1.AUDITINFO",showorder=-1)
        ,@DEDataQueryCodeExp(name="AUDITTYPE",expression="t1.AUDITTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAAUDITID",expression="t1.DATAAUDITID",showorder=3)
        ,@DEDataQueryCodeExp(name="DATAAUDITNAME",expression="t1.DATAAUDITNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.IPADDRESS",showorder=5)
        ,@DEDataQueryCodeExp(name="OBJECTID",expression="t1.OBJECTID",showorder=6)
        ,@DEDataQueryCodeExp(name="OBJECTTYPE",expression="t1.OBJECTTYPE",showorder=7)
        ,@DEDataQueryCodeExp(name="OPPERSONID",expression="t1.OPPERSONID",showorder=8)
        ,@DEDataQueryCodeExp(name="OPPERSONNAME",expression="t1.OPPERSONNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="SESSIONID",expression="t1.SESSIONID",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[AUDITTYPE], t1.[CREATEDATE], t1.[CREATEMAN], t1.[DATAAUDITID], t1.[DATAAUDITNAME], t1.[IPADDRESS], t1.[OBJECTID], t1.[OBJECTTYPE], t1.[OPPERSONID], t1.[OPPERSONNAME], t1.[SESSIONID], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFDATAAUDIT] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="AUDITINFO",expression="t1.[AUDITINFO]",showorder=-1)
        ,@DEDataQueryCodeExp(name="AUDITTYPE",expression="t1.[AUDITTYPE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="DATAAUDITID",expression="t1.[DATAAUDITID]",showorder=3)
        ,@DEDataQueryCodeExp(name="DATAAUDITNAME",expression="t1.[DATAAUDITNAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.[IPADDRESS]",showorder=5)
        ,@DEDataQueryCodeExp(name="OBJECTID",expression="t1.[OBJECTID]",showorder=6)
        ,@DEDataQueryCodeExp(name="OBJECTTYPE",expression="t1.[OBJECTTYPE]",showorder=7)
        ,@DEDataQueryCodeExp(name="OPPERSONID",expression="t1.[OPPERSONID]",showorder=8)
        ,@DEDataQueryCodeExp(name="OPPERSONNAME",expression="t1.[OPPERSONNAME]",showorder=9)
        ,@DEDataQueryCodeExp(name="SESSIONID",expression="t1.[SESSIONID]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=11)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=12)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class DataAuditDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public DataAuditDefaultDQModelBase() {
        super();

        this.initAnnotation(DataAuditDefaultDQModelBase.class);
    }

}