/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgaccount.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="B62E6807-6EBA-4D27-A5CB-ACA8E4987130",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ISLIST, t1.MAILADDRESS, t1.MOBILE, t1.MSGACCOUNTID, t1.MSGACCOUNTNAME, t1.MSGADDRESS, t1.MSNEMAIL, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WECHARADDR, t1.WXADDR FROM T_SRFMSGACCOUNT t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="FOLDERMODEL",expression="t1.FOLDERMODEL",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="ISLIST",expression="t1.ISLIST",showorder=3)
        ,@DEDataQueryCodeExp(name="MAILADDRESS",expression="t1.MAILADDRESS",showorder=4)
        ,@DEDataQueryCodeExp(name="MOBILE",expression="t1.MOBILE",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTID",expression="t1.MSGACCOUNTID",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTNAME",expression="t1.MSGACCOUNTNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGADDRESS",expression="t1.MSGADDRESS",showorder=8)
        ,@DEDataQueryCodeExp(name="MSNEMAIL",expression="t1.MSNEMAIL",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=15)
        ,@DEDataQueryCodeExp(name="WECHARADDR",expression="t1.WECHARADDR",showorder=16)
        ,@DEDataQueryCodeExp(name="WXADDR",expression="t1.WXADDR",showorder=17)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`enable`, t1.`islist`, t1.`mailaddress`, t1.`mobile`, t1.`msgaccountid`, t1.`msgaccountname`, t1.`msgaddress`, t1.`msnemail`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`wecharaddr`, t1.`wxaddr` FROM `t_srfmsgaccount` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="FOLDERMODEL",expression="t1.`foldermodel`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.`enable`",showorder=2)
        ,@DEDataQueryCodeExp(name="ISLIST",expression="t1.`islist`",showorder=3)
        ,@DEDataQueryCodeExp(name="MAILADDRESS",expression="t1.`mailaddress`",showorder=4)
        ,@DEDataQueryCodeExp(name="MOBILE",expression="t1.`mobile`",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTID",expression="t1.`msgaccountid`",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTNAME",expression="t1.`msgaccountname`",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGADDRESS",expression="t1.`msgaddress`",showorder=8)
        ,@DEDataQueryCodeExp(name="MSNEMAIL",expression="t1.`msnemail`",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=15)
        ,@DEDataQueryCodeExp(name="WECHARADDR",expression="t1.`wecharaddr`",showorder=16)
        ,@DEDataQueryCodeExp(name="WXADDR",expression="t1.`wxaddr`",showorder=17)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.enable = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ISLIST, t1.MAILADDRESS, t1.MOBILE, t1.MSGACCOUNTID, t1.MSGACCOUNTNAME, t1.MSGADDRESS, t1.MSNEMAIL, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WECHARADDR, t1.WXADDR FROM T_SRFMSGACCOUNT t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="FOLDERMODEL",expression="t1.FOLDERMODEL",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="ISLIST",expression="t1.ISLIST",showorder=3)
        ,@DEDataQueryCodeExp(name="MAILADDRESS",expression="t1.MAILADDRESS",showorder=4)
        ,@DEDataQueryCodeExp(name="MOBILE",expression="t1.MOBILE",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTID",expression="t1.MSGACCOUNTID",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTNAME",expression="t1.MSGACCOUNTNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGADDRESS",expression="t1.MSGADDRESS",showorder=8)
        ,@DEDataQueryCodeExp(name="MSNEMAIL",expression="t1.MSNEMAIL",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=15)
        ,@DEDataQueryCodeExp(name="WECHARADDR",expression="t1.WECHARADDR",showorder=16)
        ,@DEDataQueryCodeExp(name="WXADDR",expression="t1.WXADDR",showorder=17)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ISLIST, t1.MAILADDRESS, t1.MOBILE, t1.MSGACCOUNTID, t1.MSGACCOUNTNAME, t1.MSGADDRESS, t1.MSNEMAIL, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WECHARADDR, t1.WXADDR FROM T_SRFMSGACCOUNT t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="FOLDERMODEL",expression="t1.FOLDERMODEL",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="ISLIST",expression="t1.ISLIST",showorder=3)
        ,@DEDataQueryCodeExp(name="MAILADDRESS",expression="t1.MAILADDRESS",showorder=4)
        ,@DEDataQueryCodeExp(name="MOBILE",expression="t1.MOBILE",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTID",expression="t1.MSGACCOUNTID",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTNAME",expression="t1.MSGACCOUNTNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGADDRESS",expression="t1.MSGADDRESS",showorder=8)
        ,@DEDataQueryCodeExp(name="MSNEMAIL",expression="t1.MSNEMAIL",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=15)
        ,@DEDataQueryCodeExp(name="WECHARADDR",expression="t1.WECHARADDR",showorder=16)
        ,@DEDataQueryCodeExp(name="WXADDR",expression="t1.WXADDR",showorder=17)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ISLIST, t1.MAILADDRESS, t1.MOBILE, t1.MSGACCOUNTID, t1.MSGACCOUNTNAME, t1.MSGADDRESS, t1.MSNEMAIL, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WECHARADDR, t1.WXADDR FROM T_SRFMSGACCOUNT t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="FOLDERMODEL",expression="t1.FOLDERMODEL",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="ISLIST",expression="t1.ISLIST",showorder=3)
        ,@DEDataQueryCodeExp(name="MAILADDRESS",expression="t1.MAILADDRESS",showorder=4)
        ,@DEDataQueryCodeExp(name="MOBILE",expression="t1.MOBILE",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTID",expression="t1.MSGACCOUNTID",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTNAME",expression="t1.MSGACCOUNTNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGADDRESS",expression="t1.MSGADDRESS",showorder=8)
        ,@DEDataQueryCodeExp(name="MSNEMAIL",expression="t1.MSNEMAIL",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=15)
        ,@DEDataQueryCodeExp(name="WECHARADDR",expression="t1.WECHARADDR",showorder=16)
        ,@DEDataQueryCodeExp(name="WXADDR",expression="t1.WXADDR",showorder=17)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[ENABLE], t1.[ISLIST], t1.[MAILADDRESS], t1.[MOBILE], t1.[MSGACCOUNTID], t1.[MSGACCOUNTNAME], t1.[MSGADDRESS], t1.[MSNEMAIL], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WECHARADDR], t1.[WXADDR] FROM [T_SRFMSGACCOUNT] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="FOLDERMODEL",expression="t1.[FOLDERMODEL]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.[ENABLE]",showorder=2)
        ,@DEDataQueryCodeExp(name="ISLIST",expression="t1.[ISLIST]",showorder=3)
        ,@DEDataQueryCodeExp(name="MAILADDRESS",expression="t1.[MAILADDRESS]",showorder=4)
        ,@DEDataQueryCodeExp(name="MOBILE",expression="t1.[MOBILE]",showorder=5)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTID",expression="t1.[MSGACCOUNTID]",showorder=6)
        ,@DEDataQueryCodeExp(name="MSGACCOUNTNAME",expression="t1.[MSGACCOUNTNAME]",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGADDRESS",expression="t1.[MSGADDRESS]",showorder=8)
        ,@DEDataQueryCodeExp(name="MSNEMAIL",expression="t1.[MSNEMAIL]",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=14)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=15)
        ,@DEDataQueryCodeExp(name="WECHARADDR",expression="t1.[WECHARADDR]",showorder=16)
        ,@DEDataQueryCodeExp(name="WXADDR",expression="t1.[WXADDR]",showorder=17)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    })
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class MsgAccountDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public MsgAccountDefaultDQModelBase() {
        super();

        this.initAnnotation(MsgAccountDefaultDQModelBase.class);
    }

}