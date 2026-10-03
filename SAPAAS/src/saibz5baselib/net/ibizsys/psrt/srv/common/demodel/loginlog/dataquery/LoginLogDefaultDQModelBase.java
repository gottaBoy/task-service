/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.loginlog.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="1C4097C4-2AC5-4E47-9534-F4E676B4D549",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IPADDRESS, t1.LOGINACCOUNTID, t1.LOGINACCOUNTNAME, t1.LOGINLOGID, t1.LOGINLOGNAME, t1.LOGINTIME, t1.LOGOUTTIME, t1.SERVERADDR, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERAGENT FROM T_SRFLOGINLOG t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.IPADDRESS",showorder=2)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTID",expression="t1.LOGINACCOUNTID",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTNAME",expression="t1.LOGINACCOUNTNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINLOGID",expression="t1.LOGINLOGID",showorder=5)
        ,@DEDataQueryCodeExp(name="LOGINLOGNAME",expression="t1.LOGINLOGNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="LOGINTIME",expression="t1.LOGINTIME",showorder=7)
        ,@DEDataQueryCodeExp(name="LOGOUTTIME",expression="t1.LOGOUTTIME",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERADDR",expression="t1.SERVERADDR",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERAGENT",expression="t1.USERAGENT",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`ipaddress`, t1.`loginaccountid`, t1.`loginaccountname`, t1.`loginlogid`, t1.`loginlogname`, t1.`logintime`, t1.`logouttime`, t1.`serveraddr`, t1.`updatedate`, t1.`updateman`, t1.`useragent` FROM `t_srfloginlog` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.`ipaddress`",showorder=2)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTID",expression="t1.`loginaccountid`",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTNAME",expression="t1.`loginaccountname`",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINLOGID",expression="t1.`loginlogid`",showorder=5)
        ,@DEDataQueryCodeExp(name="LOGINLOGNAME",expression="t1.`loginlogname`",showorder=6)
        ,@DEDataQueryCodeExp(name="LOGINTIME",expression="t1.`logintime`",showorder=7)
        ,@DEDataQueryCodeExp(name="LOGOUTTIME",expression="t1.`logouttime`",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERADDR",expression="t1.`serveraddr`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERAGENT",expression="t1.`useragent`",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IPADDRESS, t1.LOGINACCOUNTID, t1.LOGINACCOUNTNAME, t1.LOGINLOGID, t1.LOGINLOGNAME, t1.LOGINTIME, t1.LOGOUTTIME, t1.SERVERADDR, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERAGENT FROM T_SRFLOGINLOG t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.IPADDRESS",showorder=2)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTID",expression="t1.LOGINACCOUNTID",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTNAME",expression="t1.LOGINACCOUNTNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINLOGID",expression="t1.LOGINLOGID",showorder=5)
        ,@DEDataQueryCodeExp(name="LOGINLOGNAME",expression="t1.LOGINLOGNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="LOGINTIME",expression="t1.LOGINTIME",showorder=7)
        ,@DEDataQueryCodeExp(name="LOGOUTTIME",expression="t1.LOGOUTTIME",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERADDR",expression="t1.SERVERADDR",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERAGENT",expression="t1.USERAGENT",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IPADDRESS, t1.LOGINACCOUNTID, t1.LOGINACCOUNTNAME, t1.LOGINLOGID, t1.LOGINLOGNAME, t1.LOGINTIME, t1.LOGOUTTIME, t1.SERVERADDR, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERAGENT FROM T_SRFLOGINLOG t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.IPADDRESS",showorder=2)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTID",expression="t1.LOGINACCOUNTID",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTNAME",expression="t1.LOGINACCOUNTNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINLOGID",expression="t1.LOGINLOGID",showorder=5)
        ,@DEDataQueryCodeExp(name="LOGINLOGNAME",expression="t1.LOGINLOGNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="LOGINTIME",expression="t1.LOGINTIME",showorder=7)
        ,@DEDataQueryCodeExp(name="LOGOUTTIME",expression="t1.LOGOUTTIME",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERADDR",expression="t1.SERVERADDR",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERAGENT",expression="t1.USERAGENT",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.IPADDRESS, t1.LOGINACCOUNTID, t1.LOGINACCOUNTNAME, t1.LOGINLOGID, t1.LOGINLOGNAME, t1.LOGINTIME, t1.LOGOUTTIME, t1.SERVERADDR, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERAGENT FROM T_SRFLOGINLOG t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.IPADDRESS",showorder=2)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTID",expression="t1.LOGINACCOUNTID",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTNAME",expression="t1.LOGINACCOUNTNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINLOGID",expression="t1.LOGINLOGID",showorder=5)
        ,@DEDataQueryCodeExp(name="LOGINLOGNAME",expression="t1.LOGINLOGNAME",showorder=6)
        ,@DEDataQueryCodeExp(name="LOGINTIME",expression="t1.LOGINTIME",showorder=7)
        ,@DEDataQueryCodeExp(name="LOGOUTTIME",expression="t1.LOGOUTTIME",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERADDR",expression="t1.SERVERADDR",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=11)
        ,@DEDataQueryCodeExp(name="USERAGENT",expression="t1.USERAGENT",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[IPADDRESS], t1.[LOGINACCOUNTID], t1.[LOGINACCOUNTNAME], t1.[LOGINLOGID], t1.[LOGINLOGNAME], t1.[LOGINTIME], t1.[LOGOUTTIME], t1.[SERVERADDR], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERAGENT] FROM [T_SRFLOGINLOG] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="IPADDRESS",expression="t1.[IPADDRESS]",showorder=2)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTID",expression="t1.[LOGINACCOUNTID]",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINACCOUNTNAME",expression="t1.[LOGINACCOUNTNAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINLOGID",expression="t1.[LOGINLOGID]",showorder=5)
        ,@DEDataQueryCodeExp(name="LOGINLOGNAME",expression="t1.[LOGINLOGNAME]",showorder=6)
        ,@DEDataQueryCodeExp(name="LOGINTIME",expression="t1.[LOGINTIME]",showorder=7)
        ,@DEDataQueryCodeExp(name="LOGOUTTIME",expression="t1.[LOGOUTTIME]",showorder=8)
        ,@DEDataQueryCodeExp(name="SERVERADDR",expression="t1.[SERVERADDR]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=10)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERAGENT",expression="t1.[USERAGENT]",showorder=12)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class LoginLogDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public LoginLogDefaultDQModelBase() {
        super();

        this.initAnnotation(LoginLogDefaultDQModelBase.class);
    }

}