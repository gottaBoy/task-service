/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wx.demodel.wxmedia.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="3BC17A20-6E4B-49A9-84A7-0ACA5DAFE51E",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCOUNTID, t1.WXACCOUNTNAME, t1.WXENTAPPID, t1.WXENTAPPNAME, t1.WXMEDIAID, t1.WXMEDIANAME FROM T_SRFWXMEDIA t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.WXENTAPPID",showorder=11)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.WXENTAPPNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="WXMEDIAID",expression="t1.WXMEDIAID",showorder=13)
        ,@DEDataQueryCodeExp(name="WXMEDIANAME",expression="t1.WXMEDIANAME",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`memo`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`wxaccountid`, t1.`wxaccountname`, t1.`wxentappid`, t1.`wxentappname`, t1.`wxmediaid`, t1.`wxmedianame` FROM `t_srfwxmedia` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=8)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.`wxaccountid`",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.`wxaccountname`",showorder=10)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.`wxentappid`",showorder=11)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.`wxentappname`",showorder=12)
        ,@DEDataQueryCodeExp(name="WXMEDIAID",expression="t1.`wxmediaid`",showorder=13)
        ,@DEDataQueryCodeExp(name="WXMEDIANAME",expression="t1.`wxmedianame`",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCOUNTID, t1.WXACCOUNTNAME, t1.WXENTAPPID, t1.WXENTAPPNAME, t1.WXMEDIAID, t1.WXMEDIANAME FROM T_SRFWXMEDIA t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.WXENTAPPID",showorder=11)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.WXENTAPPNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="WXMEDIAID",expression="t1.WXMEDIAID",showorder=13)
        ,@DEDataQueryCodeExp(name="WXMEDIANAME",expression="t1.WXMEDIANAME",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCOUNTID, t1.WXACCOUNTNAME, t1.WXENTAPPID, t1.WXENTAPPNAME, t1.WXMEDIAID, t1.WXMEDIANAME FROM T_SRFWXMEDIA t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.WXENTAPPID",showorder=11)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.WXENTAPPNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="WXMEDIAID",expression="t1.WXMEDIAID",showorder=13)
        ,@DEDataQueryCodeExp(name="WXMEDIANAME",expression="t1.WXMEDIANAME",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.WXACCOUNTID, t1.WXACCOUNTNAME, t1.WXENTAPPID, t1.WXENTAPPNAME, t1.WXMEDIAID, t1.WXMEDIANAME FROM T_SRFWXMEDIA t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.WXACCOUNTID",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.WXACCOUNTNAME",showorder=10)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.WXENTAPPID",showorder=11)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.WXENTAPPNAME",showorder=12)
        ,@DEDataQueryCodeExp(name="WXMEDIAID",expression="t1.WXMEDIAID",showorder=13)
        ,@DEDataQueryCodeExp(name="WXMEDIANAME",expression="t1.WXMEDIANAME",showorder=14)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[WXACCOUNTID], t1.[WXACCOUNTNAME], t1.[WXENTAPPID], t1.[WXENTAPPNAME], t1.[WXMEDIAID], t1.[WXMEDIANAME] FROM [T_SRFWXMEDIA] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=8)
        ,@DEDataQueryCodeExp(name="WXACCOUNTID",expression="t1.[WXACCOUNTID]",showorder=9)
        ,@DEDataQueryCodeExp(name="WXACCOUNTNAME",expression="t1.[WXACCOUNTNAME]",showorder=10)
        ,@DEDataQueryCodeExp(name="WXENTAPPID",expression="t1.[WXENTAPPID]",showorder=11)
        ,@DEDataQueryCodeExp(name="WXENTAPPNAME",expression="t1.[WXENTAPPNAME]",showorder=12)
        ,@DEDataQueryCodeExp(name="WXMEDIAID",expression="t1.[WXMEDIAID]",showorder=13)
        ,@DEDataQueryCodeExp(name="WXMEDIANAME",expression="t1.[WXMEDIANAME]",showorder=14)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WXMediaDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WXMediaDefaultDQModelBase() {
        super();

        this.initAnnotation(WXMediaDefaultDQModelBase.class);
    }

}