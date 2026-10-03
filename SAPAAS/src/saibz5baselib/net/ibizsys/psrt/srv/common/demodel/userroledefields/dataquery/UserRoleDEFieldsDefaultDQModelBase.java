/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userroledefields.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="CA944323-1549-4BB0-86D9-D5574F891AA9",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERROLEDEFIELDID, t11.USERROLEDEFIELDNAME, t1.USERROLEDEFIELDSID, t1.USERROLEDEFIELDSNAME, t1.USERROLEID, t21.USERROLENAME FROM T_SRFUSERROLEDEFIELDS t1  LEFT JOIN T_SRFUSERROLEDEFIELD t11 ON t1.USERROLEDEFIELDID = t11.USERROLEDEFIELDID  LEFT JOIN T_SRFUSERROLE t21 ON t1.USERROLEID = t21.USERROLEID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDID",expression="t1.USERROLEDEFIELDID",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDNAME",expression="t11.USERROLEDEFIELDNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSID",expression="t1.USERROLEDEFIELDSID",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSNAME",expression="t1.USERROLEDEFIELDSNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.USERROLEID",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t21.USERROLENAME",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`userroledefieldid`, t11.`userroledefieldname`, t1.`userroledefieldsid`, t1.`userroledefieldsname`, t1.`userroleid`, t21.`userrolename` FROM `t_srfuserroledefields` t1  LEFT JOIN t_srfuserroledefield t11 ON t1.userroledefieldid = t11.userroledefieldid  LEFT JOIN t_srfuserrole t21 ON t1.userroleid = t21.userroleid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=7)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDID",expression="t1.`userroledefieldid`",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDNAME",expression="t11.`userroledefieldname`",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSID",expression="t1.`userroledefieldsid`",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSNAME",expression="t1.`userroledefieldsname`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.`userroleid`",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t21.`userrolename`",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERROLEDEFIELDID, t11.USERROLEDEFIELDNAME, t1.USERROLEDEFIELDSID, t1.USERROLEDEFIELDSNAME, t1.USERROLEID, t21.USERROLENAME FROM T_SRFUSERROLEDEFIELDS t1  LEFT JOIN T_SRFUSERROLEDEFIELD t11 ON t1.USERROLEDEFIELDID = t11.USERROLEDEFIELDID  LEFT JOIN T_SRFUSERROLE t21 ON t1.USERROLEID = t21.USERROLEID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDID",expression="t1.USERROLEDEFIELDID",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDNAME",expression="t11.USERROLEDEFIELDNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSID",expression="t1.USERROLEDEFIELDSID",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSNAME",expression="t1.USERROLEDEFIELDSNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.USERROLEID",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t21.USERROLENAME",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERROLEDEFIELDID, t11.USERROLEDEFIELDNAME, t1.USERROLEDEFIELDSID, t1.USERROLEDEFIELDSNAME, t1.USERROLEID, t21.USERROLENAME FROM T_SRFUSERROLEDEFIELDS t1  LEFT JOIN T_SRFUSERROLEDEFIELD t11 ON t1.USERROLEDEFIELDID = t11.USERROLEDEFIELDID  LEFT JOIN T_SRFUSERROLE t21 ON t1.USERROLEID = t21.USERROLEID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDID",expression="t1.USERROLEDEFIELDID",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDNAME",expression="t11.USERROLEDEFIELDNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSID",expression="t1.USERROLEDEFIELDSID",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSNAME",expression="t1.USERROLEDEFIELDSNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.USERROLEID",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t21.USERROLENAME",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERROLEDEFIELDID, t11.USERROLEDEFIELDNAME, t1.USERROLEDEFIELDSID, t1.USERROLEDEFIELDSNAME, t1.USERROLEID, t21.USERROLENAME FROM T_SRFUSERROLEDEFIELDS t1  LEFT JOIN T_SRFUSERROLEDEFIELD t11 ON t1.USERROLEDEFIELDID = t11.USERROLEDEFIELDID  LEFT JOIN T_SRFUSERROLE t21 ON t1.USERROLEID = t21.USERROLEID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=7)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDID",expression="t1.USERROLEDEFIELDID",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDNAME",expression="t11.USERROLEDEFIELDNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSID",expression="t1.USERROLEDEFIELDSID",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSNAME",expression="t1.USERROLEDEFIELDSNAME",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.USERROLEID",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t21.USERROLENAME",showorder=13)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERROLEDEFIELDID], t11.[USERROLEDEFIELDNAME], t1.[USERROLEDEFIELDSID], t1.[USERROLEDEFIELDSNAME], t1.[USERROLEID], t21.[USERROLENAME] FROM [T_SRFUSERROLEDEFIELDS] t1  LEFT JOIN T_SRFUSERROLEDEFIELD t11 ON t1.USERROLEDEFIELDID = t11.USERROLEDEFIELDID  LEFT JOIN T_SRFUSERROLE t21 ON t1.USERROLEID = t21.USERROLEID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=2)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=3)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=5)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=7)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDID",expression="t1.[USERROLEDEFIELDID]",showorder=8)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDNAME",expression="t11.[USERROLEDEFIELDNAME]",showorder=9)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSID",expression="t1.[USERROLEDEFIELDSID]",showorder=10)
        ,@DEDataQueryCodeExp(name="USERROLEDEFIELDSNAME",expression="t1.[USERROLEDEFIELDSNAME]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERROLEID",expression="t1.[USERROLEID]",showorder=12)
        ,@DEDataQueryCodeExp(name="USERROLENAME",expression="t21.[USERROLENAME]",showorder=13)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserRoleDEFieldsDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserRoleDEFieldsDefaultDQModelBase() {
        super();

        this.initAnnotation(UserRoleDEFieldsDefaultDQModelBase.class);
    }

}