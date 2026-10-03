/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxaccesstoken.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="D14A2FA5-7250-4DC0-A0D2-0C5358FCB44C",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.ACCESSTOKEN, t1.CREATEDATE, t1.CREATEMAN, t1.EXPIREDTIME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCESSTOKENID, t1.WXACCESSTOKENNAME, t1.WXACCOUNTID, t1.WXACCOUNTNAME FROM T_SRFWXACCESSTOKEN t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="ACCESSTOKEN",expression="t1.ACCESSTOKEN",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="EXPIREDTIME",expression="t1.EXPIREDTIME",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENID",expression="t1.WXACCESSTOKENID",showorder=10)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENNAME",expression="t1.WXACCESSTOKENNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`accesstoken`, t1.`createdate`, t1.`createman`, t1.`expiredtime`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`wxaccesstokenid`, t1.`wxaccesstokenname`, t1.`wxaccountid`, t1.`wxaccountname` FROM `t_srfwxaccesstoken` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="ACCESSTOKEN",expression="t1.`accesstoken`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="EXPIREDTIME",expression="t1.`expiredtime`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENID",expression="t1.`wxaccesstokenid`",showorder=10)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENNAME",expression="t1.`wxaccesstokenname`",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.`wxaccountid`",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.`wxaccountname`",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ACCESSTOKEN, t1.CREATEDATE, t1.CREATEMAN, t1.EXPIREDTIME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCESSTOKENID, t1.WXACCESSTOKENNAME, t1.WXACCOUNTID, t1.WXACCOUNTNAME FROM T_SRFWXACCESSTOKEN t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="ACCESSTOKEN",expression="t1.ACCESSTOKEN",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="EXPIREDTIME",expression="t1.EXPIREDTIME",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENID",expression="t1.WXACCESSTOKENID",showorder=10)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENNAME",expression="t1.WXACCESSTOKENNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ACCESSTOKEN, t1.CREATEDATE, t1.CREATEMAN, t1.EXPIREDTIME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCESSTOKENID, t1.WXACCESSTOKENNAME, t1.WXACCOUNTID, t1.WXACCOUNTNAME FROM T_SRFWXACCESSTOKEN t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="ACCESSTOKEN",expression="t1.ACCESSTOKEN",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="EXPIREDTIME",expression="t1.EXPIREDTIME",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENID",expression="t1.WXACCESSTOKENID",showorder=10)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENNAME",expression="t1.WXACCESSTOKENNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.ACCESSTOKEN, t1.CREATEDATE, t1.CREATEMAN, t1.EXPIREDTIME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCESSTOKENID, t1.WXACCESSTOKENNAME, t1.WXACCOUNTID, t1.WXACCOUNTNAME FROM T_SRFWXACCESSTOKEN t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="ACCESSTOKEN",expression="t1.ACCESSTOKEN",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="EXPIREDTIME",expression="t1.EXPIREDTIME",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENID",expression="t1.WXACCESSTOKENID",showorder=10)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENNAME",expression="t1.WXACCESSTOKENNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[ACCESSTOKEN], t1.[CREATEDATE], t1.[CREATEMAN], t1.[EXPIREDTIME], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WXACCESSTOKENID], t1.[WXACCESSTOKENNAME], t1.[WXACCOUNTID], t1.[WXACCOUNTNAME] FROM [T_SRFWXACCESSTOKEN] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="ACCESSTOKEN",expression="t1.[ACCESSTOKEN]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="EXPIREDTIME",expression="t1.[EXPIREDTIME]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENID",expression="t1.[WXACCESSTOKENID]",showorder=10)
        ,@DEDataQueryCodeExp(name="WXACCESSTOKENNAME",expression="t1.[WXACCESSTOKENNAME]",showorder=11)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.[WXACCOUNTID]",showorder=12)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.[WXACCOUNTNAME]",showorder=13)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WXAccessTokenDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WXAccessTokenDefaultDQModelBase() {
        super();

        this.initAnnotation(WXAccessTokenDefaultDQModelBase.class);
    }

}