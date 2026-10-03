/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userdict.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="5FD03BE2-5AFA-4929-A01E-D63C3A76E241",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.OWNERID, t1.OWNERTYPE, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDICTID, t1.USERDICTNAME FROM T_SRFUSERDICT t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.OWNERID",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.OWNERTYPE",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDICTID",expression="t1.USERDICTID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDICTNAME",expression="t1.USERDICTNAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`memo`, t1.`ownerid`, t1.`ownertype`, t1.`reserver`, t1.`reserver2`, t1.`reserver3`, t1.`reserver4`, t1.`updatedate`, t1.`updateman`, t1.`userdictid`, t1.`userdictname` FROM `t_srfuserdict` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=2)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.`ownerid`",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.`ownertype`",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.`reserver3`",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.`reserver4`",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDICTID",expression="t1.`userdictid`",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDICTNAME",expression="t1.`userdictname`",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.OWNERID, t1.OWNERTYPE, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDICTID, t1.USERDICTNAME FROM T_SRFUSERDICT t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.OWNERID",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.OWNERTYPE",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDICTID",expression="t1.USERDICTID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDICTNAME",expression="t1.USERDICTNAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.OWNERID, t1.OWNERTYPE, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDICTID, t1.USERDICTNAME FROM T_SRFUSERDICT t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.OWNERID",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.OWNERTYPE",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDICTID",expression="t1.USERDICTID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDICTNAME",expression="t1.USERDICTNAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.OWNERID, t1.OWNERTYPE, t1.RESERVER, t1.RESERVER2, t1.RESERVER3, t1.RESERVER4, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDICTID, t1.USERDICTNAME FROM T_SRFUSERDICT t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.OWNERID",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.OWNERTYPE",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.RESERVER3",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.RESERVER4",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDICTID",expression="t1.USERDICTID",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDICTNAME",expression="t1.USERDICTNAME",showorder=12)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[OWNERID], t1.[OWNERTYPE], t1.[RESERVER], t1.[RESERVER2], t1.[RESERVER3], t1.[RESERVER4], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERDICTID], t1.[USERDICTNAME] FROM [T_SRFUSERDICT] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=2)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.[OWNERID]",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.[OWNERTYPE]",showorder=4)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=5)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=6)
        ,@DEDataQueryCodeExp(name="RESERVER3",expression="t1.[RESERVER3]",showorder=7)
        ,@DEDataQueryCodeExp(name="RESERVER4",expression="t1.[RESERVER4]",showorder=8)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=9)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=10)
        ,@DEDataQueryCodeExp(name="USERDICTID",expression="t1.[USERDICTID]",showorder=11)
        ,@DEDataQueryCodeExp(name="USERDICTNAME",expression="t1.[USERDICTNAME]",showorder=12)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserDictDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserDictDefaultDQModelBase() {
        super();

        this.initAnnotation(UserDictDefaultDQModelBase.class);
    }

}