/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxentapp.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="6ECB5AD7-F77A-48F8-AD7A-66E06251E321",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.AGENTID, t1.APIAPPSECRET, t1.APIENCODINGAESKEY, t1.APITOKEN, t1.APIURL, t1.APPTYPE, t1.APPURL, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.REPENTERFLAG, t1.REPLOCATIONFLAG, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WXACCOUNTID, t11.WXACCOUNTNAME, t1.WXENTAPPID, t1.WXENTAPPNAME FROM T_SRFWXENTAPP t1  LEFT JOIN T_SRFWXACCOUNT t11 ON t1.WXACCOUNTID = t11.WXACCOUNTID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTID",expression="t1.AGENTID",showorder=0)
        ,@DEDataQueryCodeExp(name="APIAPPSECRET",expression="t1.APIAPPSECRET",showorder=1)
        ,@DEDataQueryCodeExp(name="APIENCODINGAESKEY",expression="t1.APIENCODINGAESKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="APITOKEN",expression="t1.APITOKEN",showorder=3)
        ,@DEDataQueryCodeExp(name="APIURL",expression="t1.APIURL",showorder=4)
        ,@DEDataQueryCodeExp(name="APPTYPE",expression="t1.APPTYPE",showorder=5)
        ,@DEDataQueryCodeExp(name="APPURL",expression="t1.APPURL",showorder=6)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=9)
        ,@DEDataQueryCodeExp(name="REPENTERFLAG",expression="t1.REPENTERFLAG",showorder=10)
        ,@DEDataQueryCodeExp(name="REPLOCATIONFLAG",expression="t1.REPLOCATIONFLAG",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=17)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=18)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=19)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t11.WXACCOUNTNAME",showorder=20)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.WXENTAPPID",showorder=21)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.WXENTAPPNAME",showorder=22)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`agentid`, t1.`apiappsecret`, t1.`apiencodingaeskey`, t1.`apitoken`, t1.`apiurl`, t1.`apptype`, t1.`appurl`, t1.`createdate`, t1.`createman`, t1.`memo`, t1.`repenterflag`, t1.`replocationflag`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`validflag`, t1.`wxaccountid`, t11.`wxaccountname`, t1.`wxentappid`, t1.`wxentappname` FROM `t_srfwxentapp` t1  LEFT JOIN t_srfwxaccount t11 ON t1.wxaccountid = t11.wxaccountid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTID",expression="t1.`agentid`",showorder=0)
        ,@DEDataQueryCodeExp(name="APIAPPSECRET",expression="t1.`apiappsecret`",showorder=1)
        ,@DEDataQueryCodeExp(name="APIENCODINGAESKEY",expression="t1.`apiencodingaeskey`",showorder=2)
        ,@DEDataQueryCodeExp(name="APITOKEN",expression="t1.`apitoken`",showorder=3)
        ,@DEDataQueryCodeExp(name="APIURL",expression="t1.`apiurl`",showorder=4)
        ,@DEDataQueryCodeExp(name="APPTYPE",expression="t1.`apptype`",showorder=5)
        ,@DEDataQueryCodeExp(name="APPURL",expression="t1.`appurl`",showorder=6)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=7)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=8)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=9)
        ,@DEDataQueryCodeExp(name="REPENTERFLAG",expression="t1.`repenterflag`",showorder=10)
        ,@DEDataQueryCodeExp(name="REPLOCATIONFLAG",expression="t1.`replocationflag`",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=17)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.`validflag`",showorder=18)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.`wxaccountid`",showorder=19)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t11.`wxaccountname`",showorder=20)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.`wxentappid`",showorder=21)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.`wxentappname`",showorder=22)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.AGENTID, t1.APIAPPSECRET, t1.APIENCODINGAESKEY, t1.APITOKEN, t1.APIURL, t1.APPTYPE, t1.APPURL, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.REPENTERFLAG, t1.REPLOCATIONFLAG, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WXACCOUNTID, t11.WXACCOUNTNAME, t1.WXENTAPPID, t1.WXENTAPPNAME FROM T_SRFWXENTAPP t1  LEFT JOIN T_SRFWXACCOUNT t11 ON t1.WXACCOUNTID = t11.WXACCOUNTID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTID",expression="t1.AGENTID",showorder=0)
        ,@DEDataQueryCodeExp(name="APIAPPSECRET",expression="t1.APIAPPSECRET",showorder=1)
        ,@DEDataQueryCodeExp(name="APIENCODINGAESKEY",expression="t1.APIENCODINGAESKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="APITOKEN",expression="t1.APITOKEN",showorder=3)
        ,@DEDataQueryCodeExp(name="APIURL",expression="t1.APIURL",showorder=4)
        ,@DEDataQueryCodeExp(name="APPTYPE",expression="t1.APPTYPE",showorder=5)
        ,@DEDataQueryCodeExp(name="APPURL",expression="t1.APPURL",showorder=6)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=9)
        ,@DEDataQueryCodeExp(name="REPENTERFLAG",expression="t1.REPENTERFLAG",showorder=10)
        ,@DEDataQueryCodeExp(name="REPLOCATIONFLAG",expression="t1.REPLOCATIONFLAG",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=17)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=18)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=19)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t11.WXACCOUNTNAME",showorder=20)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.WXENTAPPID",showorder=21)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.WXENTAPPNAME",showorder=22)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.AGENTID, t1.APIAPPSECRET, t1.APIENCODINGAESKEY, t1.APITOKEN, t1.APIURL, t1.APPTYPE, t1.APPURL, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.REPENTERFLAG, t1.REPLOCATIONFLAG, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WXACCOUNTID, t11.WXACCOUNTNAME, t1.WXENTAPPID, t1.WXENTAPPNAME FROM T_SRFWXENTAPP t1  LEFT JOIN T_SRFWXACCOUNT t11 ON t1.WXACCOUNTID = t11.WXACCOUNTID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTID",expression="t1.AGENTID",showorder=0)
        ,@DEDataQueryCodeExp(name="APIAPPSECRET",expression="t1.APIAPPSECRET",showorder=1)
        ,@DEDataQueryCodeExp(name="APIENCODINGAESKEY",expression="t1.APIENCODINGAESKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="APITOKEN",expression="t1.APITOKEN",showorder=3)
        ,@DEDataQueryCodeExp(name="APIURL",expression="t1.APIURL",showorder=4)
        ,@DEDataQueryCodeExp(name="APPTYPE",expression="t1.APPTYPE",showorder=5)
        ,@DEDataQueryCodeExp(name="APPURL",expression="t1.APPURL",showorder=6)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=9)
        ,@DEDataQueryCodeExp(name="REPENTERFLAG",expression="t1.REPENTERFLAG",showorder=10)
        ,@DEDataQueryCodeExp(name="REPLOCATIONFLAG",expression="t1.REPLOCATIONFLAG",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=17)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=18)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=19)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t11.WXACCOUNTNAME",showorder=20)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.WXENTAPPID",showorder=21)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.WXENTAPPNAME",showorder=22)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.AGENTID, t1.APIAPPSECRET, t1.APIENCODINGAESKEY, t1.APITOKEN, t1.APIURL, t1.APPTYPE, t1.APPURL, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.REPENTERFLAG, t1.REPLOCATIONFLAG, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.WXACCOUNTID, t11.WXACCOUNTNAME, t1.WXENTAPPID, t1.WXENTAPPNAME FROM T_SRFWXENTAPP t1  LEFT JOIN T_SRFWXACCOUNT t11 ON t1.WXACCOUNTID = t11.WXACCOUNTID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTID",expression="t1.AGENTID",showorder=0)
        ,@DEDataQueryCodeExp(name="APIAPPSECRET",expression="t1.APIAPPSECRET",showorder=1)
        ,@DEDataQueryCodeExp(name="APIENCODINGAESKEY",expression="t1.APIENCODINGAESKEY",showorder=2)
        ,@DEDataQueryCodeExp(name="APITOKEN",expression="t1.APITOKEN",showorder=3)
        ,@DEDataQueryCodeExp(name="APIURL",expression="t1.APIURL",showorder=4)
        ,@DEDataQueryCodeExp(name="APPTYPE",expression="t1.APPTYPE",showorder=5)
        ,@DEDataQueryCodeExp(name="APPURL",expression="t1.APPURL",showorder=6)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=9)
        ,@DEDataQueryCodeExp(name="REPENTERFLAG",expression="t1.REPENTERFLAG",showorder=10)
        ,@DEDataQueryCodeExp(name="REPLOCATIONFLAG",expression="t1.REPLOCATIONFLAG",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=17)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=18)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=19)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t11.WXACCOUNTNAME",showorder=20)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.WXENTAPPID",showorder=21)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.WXENTAPPNAME",showorder=22)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[AGENTID], t1.[APIAPPSECRET], t1.[APIENCODINGAESKEY], t1.[APITOKEN], t1.[APIURL], t1.[APPTYPE], t1.[APPURL], t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[REPENTERFLAG], t1.[REPLOCATIONFLAG], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[VALIDFLAG], t1.[WXACCOUNTID], t11.[WXACCOUNTNAME], t1.[WXENTAPPID], t1.[WXENTAPPNAME] FROM [T_SRFWXENTAPP] t1  LEFT JOIN T_SRFWXACCOUNT t11 ON t1.WXACCOUNTID = t11.WXACCOUNTID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="AGENTID",expression="t1.[AGENTID]",showorder=0)
        ,@DEDataQueryCodeExp(name="APIAPPSECRET",expression="t1.[APIAPPSECRET]",showorder=1)
        ,@DEDataQueryCodeExp(name="APIENCODINGAESKEY",expression="t1.[APIENCODINGAESKEY]",showorder=2)
        ,@DEDataQueryCodeExp(name="APITOKEN",expression="t1.[APITOKEN]",showorder=3)
        ,@DEDataQueryCodeExp(name="APIURL",expression="t1.[APIURL]",showorder=4)
        ,@DEDataQueryCodeExp(name="APPTYPE",expression="t1.[APPTYPE]",showorder=5)
        ,@DEDataQueryCodeExp(name="APPURL",expression="t1.[APPURL]",showorder=6)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=7)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=8)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=9)
        ,@DEDataQueryCodeExp(name="REPENTERFLAG",expression="t1.[REPENTERFLAG]",showorder=10)
        ,@DEDataQueryCodeExp(name="REPLOCATIONFLAG",expression="t1.[REPLOCATIONFLAG]",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=13)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=14)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=15)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=16)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=17)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.[VALIDFLAG]",showorder=18)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.[WXACCOUNTID]",showorder=19)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t11.[WXACCOUNTNAME]",showorder=20)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.[WXENTAPPID]",showorder=21)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.[WXENTAPPNAME]",showorder=22)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WXEntAppDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WXEntAppDefaultDQModelBase() {
        super();

        this.initAnnotation(WXEntAppDefaultDQModelBase.class);
    }

}