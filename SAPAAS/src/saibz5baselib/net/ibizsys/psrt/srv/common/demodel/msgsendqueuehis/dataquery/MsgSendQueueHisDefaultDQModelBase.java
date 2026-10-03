/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgsendqueuehis.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="0B9D6E00-228F-4715-A0D4-202C0702124E",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CONTENTTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DSTADDRESSES, t1.DSTUSERS, t1.FILEAT, t1.FILEAT2, t1.FILEAT3, t1.FILEAT4, t1.IMPORTANCEFLAG, t1.ISERROR, t1.ISSEND, t1.MSGSENDQUEUEHISID, t1.MSGSENDQUEUEHISNAME, t1.MSGTYPE, t1.PLANSENDTIME, t1.PROCESSTIME, t1.SENDTAG, t1.SUBJECT, t1.TOTALDSTADDRESSES, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4 FROM T_SRFMSGSENDQUEUEHIS t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.CONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="ERRORINFO",expression="t1.ERRORINFO",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.CONTENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DSTADDRESSES",expression="t1.DSTADDRESSES",showorder=3)
        ,@DEDataQueryCodeExp(name="DSTUSERS",expression="t1.DSTUSERS",showorder=4)
        ,@DEDataQueryCodeExp(name="FILEAT",expression="t1.FILEAT",showorder=5)
        ,@DEDataQueryCodeExp(name="FILEAT2",expression="t1.FILEAT2",showorder=6)
        ,@DEDataQueryCodeExp(name="FILEAT3",expression="t1.FILEAT3",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEAT4",expression="t1.FILEAT4",showorder=8)
        ,@DEDataQueryCodeExp(name="IMPORTANCEFLAG",expression="t1.IMPORTANCEFLAG",showorder=9)
        ,@DEDataQueryCodeExp(name="ISERROR",expression="t1.ISERROR",showorder=10)
        ,@DEDataQueryCodeExp(name="ISSEND",expression="t1.ISSEND",showorder=11)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISID",expression="t1.MSGSENDQUEUEHISID",showorder=12)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISNAME",expression="t1.MSGSENDQUEUEHISNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="MSGTYPE",expression="t1.MSGTYPE",showorder=14)
        ,@DEDataQueryCodeExp(name="PLANSENDTIME",expression="t1.PLANSENDTIME",showorder=15)
        ,@DEDataQueryCodeExp(name="PROCESSTIME",expression="t1.PROCESSTIME",showorder=16)
        ,@DEDataQueryCodeExp(name="SENDTAG",expression="t1.SENDTAG",showorder=17)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.SUBJECT",showorder=18)
        ,@DEDataQueryCodeExp(name="TOTALDSTADDRESSES",expression="t1.TOTALDSTADDRESSES",showorder=19)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=21)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=23)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=24)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`contenttype`, t1.`createdate`, t1.`createman`, t1.`dstaddresses`, t1.`dstusers`, t1.`fileat`, t1.`fileat2`, t1.`fileat3`, t1.`fileat4`, t1.`importanceflag`, t1.`iserror`, t1.`issend`, t1.`msgsendqueuehisid`, t1.`msgsendqueuehisname`, t1.`msgtype`, t1.`plansendtime`, t1.`processtime`, t1.`sendtag`, t1.`subject`, t1.`totaldstaddresses`, t1.`updatedate`, t1.`updateman`, t1.`userdata`, t1.`userdata2`, t1.`userdata3`, t1.`userdata4` FROM `t_srfmsgsendqueuehis` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.`content`",showorder=-1)
        ,@DEDataQueryCodeExp(name="ERRORINFO",expression="t1.`errorinfo`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.`contenttype`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="DSTADDRESSES",expression="t1.`dstaddresses`",showorder=3)
        ,@DEDataQueryCodeExp(name="DSTUSERS",expression="t1.`dstusers`",showorder=4)
        ,@DEDataQueryCodeExp(name="FILEAT",expression="t1.`fileat`",showorder=5)
        ,@DEDataQueryCodeExp(name="FILEAT2",expression="t1.`fileat2`",showorder=6)
        ,@DEDataQueryCodeExp(name="FILEAT3",expression="t1.`fileat3`",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEAT4",expression="t1.`fileat4`",showorder=8)
        ,@DEDataQueryCodeExp(name="IMPORTANCEFLAG",expression="t1.`importanceflag`",showorder=9)
        ,@DEDataQueryCodeExp(name="ISERROR",expression="t1.`iserror`",showorder=10)
        ,@DEDataQueryCodeExp(name="ISSEND",expression="t1.`issend`",showorder=11)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISID",expression="t1.`msgsendqueuehisid`",showorder=12)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISNAME",expression="t1.`msgsendqueuehisname`",showorder=13)
        ,@DEDataQueryCodeExp(name="MSGTYPE",expression="t1.`msgtype`",showorder=14)
        ,@DEDataQueryCodeExp(name="PLANSENDTIME",expression="t1.`plansendtime`",showorder=15)
        ,@DEDataQueryCodeExp(name="PROCESSTIME",expression="t1.`processtime`",showorder=16)
        ,@DEDataQueryCodeExp(name="SENDTAG",expression="t1.`sendtag`",showorder=17)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.`subject`",showorder=18)
        ,@DEDataQueryCodeExp(name="TOTALDSTADDRESSES",expression="t1.`totaldstaddresses`",showorder=19)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=21)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.`userdata`",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.`userdata2`",showorder=23)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.`userdata3`",showorder=24)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.`userdata4`",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CONTENTTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DSTADDRESSES, t1.DSTUSERS, t1.FILEAT, t1.FILEAT2, t1.FILEAT3, t1.FILEAT4, t1.IMPORTANCEFLAG, t1.ISERROR, t1.ISSEND, t1.MSGSENDQUEUEHISID, t1.MSGSENDQUEUEHISNAME, t1.MSGTYPE, t1.PLANSENDTIME, t1.PROCESSTIME, t1.SENDTAG, t1.SUBJECT, t1.TOTALDSTADDRESSES, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4 FROM T_SRFMSGSENDQUEUEHIS t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.CONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="ERRORINFO",expression="t1.ERRORINFO",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.CONTENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DSTADDRESSES",expression="t1.DSTADDRESSES",showorder=3)
        ,@DEDataQueryCodeExp(name="DSTUSERS",expression="t1.DSTUSERS",showorder=4)
        ,@DEDataQueryCodeExp(name="FILEAT",expression="t1.FILEAT",showorder=5)
        ,@DEDataQueryCodeExp(name="FILEAT2",expression="t1.FILEAT2",showorder=6)
        ,@DEDataQueryCodeExp(name="FILEAT3",expression="t1.FILEAT3",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEAT4",expression="t1.FILEAT4",showorder=8)
        ,@DEDataQueryCodeExp(name="IMPORTANCEFLAG",expression="t1.IMPORTANCEFLAG",showorder=9)
        ,@DEDataQueryCodeExp(name="ISERROR",expression="t1.ISERROR",showorder=10)
        ,@DEDataQueryCodeExp(name="ISSEND",expression="t1.ISSEND",showorder=11)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISID",expression="t1.MSGSENDQUEUEHISID",showorder=12)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISNAME",expression="t1.MSGSENDQUEUEHISNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="MSGTYPE",expression="t1.MSGTYPE",showorder=14)
        ,@DEDataQueryCodeExp(name="PLANSENDTIME",expression="t1.PLANSENDTIME",showorder=15)
        ,@DEDataQueryCodeExp(name="PROCESSTIME",expression="t1.PROCESSTIME",showorder=16)
        ,@DEDataQueryCodeExp(name="SENDTAG",expression="t1.SENDTAG",showorder=17)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.SUBJECT",showorder=18)
        ,@DEDataQueryCodeExp(name="TOTALDSTADDRESSES",expression="t1.TOTALDSTADDRESSES",showorder=19)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=21)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=23)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=24)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CONTENTTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DSTADDRESSES, t1.DSTUSERS, t1.FILEAT, t1.FILEAT2, t1.FILEAT3, t1.FILEAT4, t1.IMPORTANCEFLAG, t1.ISERROR, t1.ISSEND, t1.MSGSENDQUEUEHISID, t1.MSGSENDQUEUEHISNAME, t1.MSGTYPE, t1.PLANSENDTIME, t1.PROCESSTIME, t1.SENDTAG, t1.SUBJECT, t1.TOTALDSTADDRESSES, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4 FROM T_SRFMSGSENDQUEUEHIS t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.CONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="ERRORINFO",expression="t1.ERRORINFO",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.CONTENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DSTADDRESSES",expression="t1.DSTADDRESSES",showorder=3)
        ,@DEDataQueryCodeExp(name="DSTUSERS",expression="t1.DSTUSERS",showorder=4)
        ,@DEDataQueryCodeExp(name="FILEAT",expression="t1.FILEAT",showorder=5)
        ,@DEDataQueryCodeExp(name="FILEAT2",expression="t1.FILEAT2",showorder=6)
        ,@DEDataQueryCodeExp(name="FILEAT3",expression="t1.FILEAT3",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEAT4",expression="t1.FILEAT4",showorder=8)
        ,@DEDataQueryCodeExp(name="IMPORTANCEFLAG",expression="t1.IMPORTANCEFLAG",showorder=9)
        ,@DEDataQueryCodeExp(name="ISERROR",expression="t1.ISERROR",showorder=10)
        ,@DEDataQueryCodeExp(name="ISSEND",expression="t1.ISSEND",showorder=11)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISID",expression="t1.MSGSENDQUEUEHISID",showorder=12)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISNAME",expression="t1.MSGSENDQUEUEHISNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="MSGTYPE",expression="t1.MSGTYPE",showorder=14)
        ,@DEDataQueryCodeExp(name="PLANSENDTIME",expression="t1.PLANSENDTIME",showorder=15)
        ,@DEDataQueryCodeExp(name="PROCESSTIME",expression="t1.PROCESSTIME",showorder=16)
        ,@DEDataQueryCodeExp(name="SENDTAG",expression="t1.SENDTAG",showorder=17)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.SUBJECT",showorder=18)
        ,@DEDataQueryCodeExp(name="TOTALDSTADDRESSES",expression="t1.TOTALDSTADDRESSES",showorder=19)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=21)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=23)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=24)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CONTENTTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DSTADDRESSES, t1.DSTUSERS, t1.FILEAT, t1.FILEAT2, t1.FILEAT3, t1.FILEAT4, t1.IMPORTANCEFLAG, t1.ISERROR, t1.ISSEND, t1.MSGSENDQUEUEHISID, t1.MSGSENDQUEUEHISNAME, t1.MSGTYPE, t1.PLANSENDTIME, t1.PROCESSTIME, t1.SENDTAG, t1.SUBJECT, t1.TOTALDSTADDRESSES, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERDATA3, t1.USERDATA4 FROM T_SRFMSGSENDQUEUEHIS t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.CONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="ERRORINFO",expression="t1.ERRORINFO",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.CONTENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DSTADDRESSES",expression="t1.DSTADDRESSES",showorder=3)
        ,@DEDataQueryCodeExp(name="DSTUSERS",expression="t1.DSTUSERS",showorder=4)
        ,@DEDataQueryCodeExp(name="FILEAT",expression="t1.FILEAT",showorder=5)
        ,@DEDataQueryCodeExp(name="FILEAT2",expression="t1.FILEAT2",showorder=6)
        ,@DEDataQueryCodeExp(name="FILEAT3",expression="t1.FILEAT3",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEAT4",expression="t1.FILEAT4",showorder=8)
        ,@DEDataQueryCodeExp(name="IMPORTANCEFLAG",expression="t1.IMPORTANCEFLAG",showorder=9)
        ,@DEDataQueryCodeExp(name="ISERROR",expression="t1.ISERROR",showorder=10)
        ,@DEDataQueryCodeExp(name="ISSEND",expression="t1.ISSEND",showorder=11)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISID",expression="t1.MSGSENDQUEUEHISID",showorder=12)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISNAME",expression="t1.MSGSENDQUEUEHISNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="MSGTYPE",expression="t1.MSGTYPE",showorder=14)
        ,@DEDataQueryCodeExp(name="PLANSENDTIME",expression="t1.PLANSENDTIME",showorder=15)
        ,@DEDataQueryCodeExp(name="PROCESSTIME",expression="t1.PROCESSTIME",showorder=16)
        ,@DEDataQueryCodeExp(name="SENDTAG",expression="t1.SENDTAG",showorder=17)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.SUBJECT",showorder=18)
        ,@DEDataQueryCodeExp(name="TOTALDSTADDRESSES",expression="t1.TOTALDSTADDRESSES",showorder=19)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=21)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=23)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.USERDATA3",showorder=24)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.USERDATA4",showorder=25)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CONTENTTYPE], t1.[CREATEDATE], t1.[CREATEMAN], t1.[DSTADDRESSES], t1.[DSTUSERS], t1.[FILEAT], t1.[FILEAT2], t1.[FILEAT3], t1.[FILEAT4], t1.[IMPORTANCEFLAG], t1.[ISERROR], t1.[ISSEND], t1.[MSGSENDQUEUEHISID], t1.[MSGSENDQUEUEHISNAME], t1.[MSGTYPE], t1.[PLANSENDTIME], t1.[PROCESSTIME], t1.[SENDTAG], t1.[SUBJECT], t1.[TOTALDSTADDRESSES], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERDATA], t1.[USERDATA2], t1.[USERDATA3], t1.[USERDATA4] FROM [T_SRFMSGSENDQUEUEHIS] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.[CONTENT]",showorder=-1)
        ,@DEDataQueryCodeExp(name="ERRORINFO",expression="t1.[ERRORINFO]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.[CONTENTTYPE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="DSTADDRESSES",expression="t1.[DSTADDRESSES]",showorder=3)
        ,@DEDataQueryCodeExp(name="DSTUSERS",expression="t1.[DSTUSERS]",showorder=4)
        ,@DEDataQueryCodeExp(name="FILEAT",expression="t1.[FILEAT]",showorder=5)
        ,@DEDataQueryCodeExp(name="FILEAT2",expression="t1.[FILEAT2]",showorder=6)
        ,@DEDataQueryCodeExp(name="FILEAT3",expression="t1.[FILEAT3]",showorder=7)
        ,@DEDataQueryCodeExp(name="FILEAT4",expression="t1.[FILEAT4]",showorder=8)
        ,@DEDataQueryCodeExp(name="IMPORTANCEFLAG",expression="t1.[IMPORTANCEFLAG]",showorder=9)
        ,@DEDataQueryCodeExp(name="ISERROR",expression="t1.[ISERROR]",showorder=10)
        ,@DEDataQueryCodeExp(name="ISSEND",expression="t1.[ISSEND]",showorder=11)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISID",expression="t1.[MSGSENDQUEUEHISID]",showorder=12)
        ,@DEDataQueryCodeExp(name="MSGSENDQUEUEHISNAME",expression="t1.[MSGSENDQUEUEHISNAME]",showorder=13)
        ,@DEDataQueryCodeExp(name="MSGTYPE",expression="t1.[MSGTYPE]",showorder=14)
        ,@DEDataQueryCodeExp(name="PLANSENDTIME",expression="t1.[PLANSENDTIME]",showorder=15)
        ,@DEDataQueryCodeExp(name="PROCESSTIME",expression="t1.[PROCESSTIME]",showorder=16)
        ,@DEDataQueryCodeExp(name="SENDTAG",expression="t1.[SENDTAG]",showorder=17)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.[SUBJECT]",showorder=18)
        ,@DEDataQueryCodeExp(name="TOTALDSTADDRESSES",expression="t1.[TOTALDSTADDRESSES]",showorder=19)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=20)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=21)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.[USERDATA]",showorder=22)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.[USERDATA2]",showorder=23)
        ,@DEDataQueryCodeExp(name="USERDATA3",expression="t1.[USERDATA3]",showorder=24)
        ,@DEDataQueryCodeExp(name="USERDATA4",expression="t1.[USERDATA4]",showorder=25)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class MsgSendQueueHisDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public MsgSendQueueHisDefaultDQModelBase() {
        super();

        this.initAnnotation(MsgSendQueueHisDefaultDQModelBase.class);
    }

}