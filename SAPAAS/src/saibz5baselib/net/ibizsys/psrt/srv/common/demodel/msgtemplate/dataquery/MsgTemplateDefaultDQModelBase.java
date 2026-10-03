/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.msgtemplate.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="563B84B0-DE2A-4EF1-92D2-3BA701879891",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CONTENTTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t11.DENAME, t1.ENABLE, t1.IMCONTENT, t1.MAILGROUPSEND, t1.MSGTEMPLATEID, t1.MSGTEMPLATENAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SMSCONTENT, t1.SRFSYSPUB, t1.SRFUSERPUB, t1.SUBJECT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFMSGTEMPLATE t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.CONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="WCCONTENT",expression="t1.WCCONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.CONTENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.DENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=5)
        ,@DEDataQueryCodeExp(name="IMCONTENT",expression="t1.IMCONTENT",showorder=6)
        ,@DEDataQueryCodeExp(name="MAILGROUPSEND",expression="t1.MAILGROUPSEND",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATEID",expression="t1.MSGTEMPLATEID",showorder=8)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATENAME",expression="t1.MSGTEMPLATENAME",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=13)
        ,@DEDataQueryCodeExp(name="SMSCONTENT",expression="t1.SMSCONTENT",showorder=14)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.SRFSYSPUB",showorder=15)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.SRFUSERPUB",showorder=16)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.SUBJECT",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=18)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=19)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.`contenttype`, t1.`createdate`, t1.`createman`, t1.`deid`, t11.`dename`, t1.`enable`, t1.`imcontent`, t1.`mailgroupsend`, t1.`msgtemplateid`, t1.`msgtemplatename`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`smscontent`, t1.`srfsyspub`, t1.`srfuserpub`, t1.`subject`, t1.`updatedate`, t1.`updateman` FROM `t_srfmsgtemplate` t1  LEFT JOIN t_srfdataentity t11 ON t1.deid = t11.deid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.`content`",showorder=-1)
        ,@DEDataQueryCodeExp(name="WCCONTENT",expression="t1.`wccontent`",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.`contenttype`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.`deid`",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.`dename`",showorder=4)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.`enable`",showorder=5)
        ,@DEDataQueryCodeExp(name="IMCONTENT",expression="t1.`imcontent`",showorder=6)
        ,@DEDataQueryCodeExp(name="MAILGROUPSEND",expression="t1.`mailgroupsend`",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATEID",expression="t1.`msgtemplateid`",showorder=8)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATENAME",expression="t1.`msgtemplatename`",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=13)
        ,@DEDataQueryCodeExp(name="SMSCONTENT",expression="t1.`smscontent`",showorder=14)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.`srfsyspub`",showorder=15)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.`srfuserpub`",showorder=16)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.`subject`",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=18)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=19)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.enable = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CONTENTTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t11.DENAME, t1.ENABLE, t1.IMCONTENT, t1.MAILGROUPSEND, t1.MSGTEMPLATEID, t1.MSGTEMPLATENAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SMSCONTENT, t1.SRFSYSPUB, t1.SRFUSERPUB, t1.SUBJECT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFMSGTEMPLATE t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.CONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="WCCONTENT",expression="t1.WCCONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.CONTENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.DENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=5)
        ,@DEDataQueryCodeExp(name="IMCONTENT",expression="t1.IMCONTENT",showorder=6)
        ,@DEDataQueryCodeExp(name="MAILGROUPSEND",expression="t1.MAILGROUPSEND",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATEID",expression="t1.MSGTEMPLATEID",showorder=8)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATENAME",expression="t1.MSGTEMPLATENAME",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=13)
        ,@DEDataQueryCodeExp(name="SMSCONTENT",expression="t1.SMSCONTENT",showorder=14)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.SRFSYSPUB",showorder=15)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.SRFUSERPUB",showorder=16)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.SUBJECT",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=18)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=19)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CONTENTTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t11.DENAME, t1.ENABLE, t1.IMCONTENT, t1.MAILGROUPSEND, t1.MSGTEMPLATEID, t1.MSGTEMPLATENAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SMSCONTENT, t1.SRFSYSPUB, t1.SRFUSERPUB, t1.SUBJECT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFMSGTEMPLATE t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.CONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="WCCONTENT",expression="t1.WCCONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.CONTENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.DENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=5)
        ,@DEDataQueryCodeExp(name="IMCONTENT",expression="t1.IMCONTENT",showorder=6)
        ,@DEDataQueryCodeExp(name="MAILGROUPSEND",expression="t1.MAILGROUPSEND",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATEID",expression="t1.MSGTEMPLATEID",showorder=8)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATENAME",expression="t1.MSGTEMPLATENAME",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=13)
        ,@DEDataQueryCodeExp(name="SMSCONTENT",expression="t1.SMSCONTENT",showorder=14)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.SRFSYSPUB",showorder=15)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.SRFUSERPUB",showorder=16)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.SUBJECT",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=18)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=19)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CONTENTTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.DEID, t11.DENAME, t1.ENABLE, t1.IMCONTENT, t1.MAILGROUPSEND, t1.MSGTEMPLATEID, t1.MSGTEMPLATENAME, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.SMSCONTENT, t1.SRFSYSPUB, t1.SRFUSERPUB, t1.SUBJECT, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFMSGTEMPLATE t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.CONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="WCCONTENT",expression="t1.WCCONTENT",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.CONTENTTYPE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.DEID",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.DENAME",showorder=4)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=5)
        ,@DEDataQueryCodeExp(name="IMCONTENT",expression="t1.IMCONTENT",showorder=6)
        ,@DEDataQueryCodeExp(name="MAILGROUPSEND",expression="t1.MAILGROUPSEND",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATEID",expression="t1.MSGTEMPLATEID",showorder=8)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATENAME",expression="t1.MSGTEMPLATENAME",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=13)
        ,@DEDataQueryCodeExp(name="SMSCONTENT",expression="t1.SMSCONTENT",showorder=14)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.SRFSYSPUB",showorder=15)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.SRFUSERPUB",showorder=16)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.SUBJECT",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=18)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=19)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.[CONTENTTYPE], t1.[CREATEDATE], t1.[CREATEMAN], t1.[DEID], t11.[DENAME], t1.[ENABLE], t1.[IMCONTENT], t1.[MAILGROUPSEND], t1.[MSGTEMPLATEID], t1.[MSGTEMPLATENAME], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[SMSCONTENT], t1.[SRFSYSPUB], t1.[SRFUSERPUB], t1.[SUBJECT], t1.[UPDATEDATE], t1.[UPDATEMAN] FROM [T_SRFMSGTEMPLATE] t1  LEFT JOIN t_srfdataentity t11 ON t1.DEID = t11.DEID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CONTENT",expression="t1.[CONTENT]",showorder=-1)
        ,@DEDataQueryCodeExp(name="WCCONTENT",expression="t1.[WCCONTENT]",showorder=-1)
        ,@DEDataQueryCodeExp(name="CONTENTTYPE",expression="t1.[CONTENTTYPE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=1)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=2)
        ,@DEDataQueryCodeExp(name="DEID",expression="t1.[DEID]",showorder=3)
        ,@DEDataQueryCodeExp(name="DENAME",expression="t11.[DENAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.[ENABLE]",showorder=5)
        ,@DEDataQueryCodeExp(name="IMCONTENT",expression="t1.[IMCONTENT]",showorder=6)
        ,@DEDataQueryCodeExp(name="MAILGROUPSEND",expression="t1.[MAILGROUPSEND]",showorder=7)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATEID",expression="t1.[MSGTEMPLATEID]",showorder=8)
        ,@DEDataQueryCodeExp(name="MSGTEMPLATENAME",expression="t1.[MSGTEMPLATENAME]",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=10)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=11)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=12)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=13)
        ,@DEDataQueryCodeExp(name="SMSCONTENT",expression="t1.[SMSCONTENT]",showorder=14)
        ,@DEDataQueryCodeExp(name="SRFSYSPUB",expression="t1.[SRFSYSPUB]",showorder=15)
        ,@DEDataQueryCodeExp(name="SRFUSERPUB",expression="t1.[SRFUSERPUB]",showorder=16)
        ,@DEDataQueryCodeExp(name="SUBJECT",expression="t1.[SUBJECT]",showorder=17)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=18)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=19)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    })
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class MsgTemplateDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public MsgTemplateDefaultDQModelBase() {
        super();

        this.initAnnotation(MsgTemplateDefaultDQModelBase.class);
    }

}