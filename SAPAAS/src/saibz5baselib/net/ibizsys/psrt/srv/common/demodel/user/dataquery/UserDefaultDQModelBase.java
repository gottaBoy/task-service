/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.user.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="24680F99-7889-4963-B07A-123C1A0E94A1",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ISSYSTEM, t1.LOGINNAME, t1.LOGINPWD, t11.MEMO, t11.OWNERID, t11.OWNERTYPE, t1.RESERVER, t1.RESERVER2, t11.SUBTYPE, t1.TIMEZONE, t1.UPDATEDATE, t1.UPDATEMAN, t11.USERDATA, t11.USERDATA2, t1.USERID, t1.USERMODE, t1.USERNAME, t11.USEROBJECTLEVEL, t11.USEROBJECTTYPE, t1.VALIDFLAG FROM T_SRFUSER t1  LEFT JOIN T_SRFUSEROBJECT t11 ON t1.USERID = t11.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="ISSYSTEM",expression="t1.ISSYSTEM",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINNAME",expression="t1.LOGINNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINPWD",expression="t1.LOGINPWD",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t11.MEMO",showorder=6)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t11.OWNERID",showorder=7)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t11.OWNERTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=10)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t11.SUBTYPE",showorder=11)
        ,@DEDataQueryCodeExp(name="TIMEZONE",expression="t1.TIMEZONE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=14)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t11.USERDATA",showorder=15)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t11.USERDATA2",showorder=16)
        ,@DEDataQueryCodeExp(name="USERID",expression="t1.USERID",showorder=17)
        ,@DEDataQueryCodeExp(name="USERMODE",expression="t1.USERMODE",showorder=18)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.USERNAME",showorder=19)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t11.USEROBJECTLEVEL",showorder=20)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t11.USEROBJECTTYPE",showorder=21)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=22)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`enable`, t1.`issystem`, t1.`loginname`, t1.`loginpwd`, t11.`memo`, t11.`ownerid`, t11.`ownertype`, t1.`reserver`, t1.`reserver2`, t11.`subtype`, t1.`timezone`, t1.`updatedate`, t1.`updateman`, t11.`userdata`, t11.`userdata2`, t1.`userid`, t1.`usermode`, t1.`username`, t11.`userobjectlevel`, t11.`userobjecttype`, t1.`validflag` FROM `t_srfuser` t1  LEFT JOIN t_srfuserobject t11 ON t1.userid = t11.userobjectid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.`enable`",showorder=2)
        ,@DEDataQueryCodeExp(name="ISSYSTEM",expression="t1.`issystem`",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINNAME",expression="t1.`loginname`",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINPWD",expression="t1.`loginpwd`",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t11.`memo`",showorder=6)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t11.`ownerid`",showorder=7)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t11.`ownertype`",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.`reserver`",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.`reserver2`",showorder=10)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t11.`subtype`",showorder=11)
        ,@DEDataQueryCodeExp(name="TIMEZONE",expression="t1.`timezone`",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=14)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t11.`userdata`",showorder=15)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t11.`userdata2`",showorder=16)
        ,@DEDataQueryCodeExp(name="USERID",expression="t1.`userid`",showorder=17)
        ,@DEDataQueryCodeExp(name="USERMODE",expression="t1.`usermode`",showorder=18)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.`username`",showorder=19)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t11.`userobjectlevel`",showorder=20)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t11.`userobjecttype`",showorder=21)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.`validflag`",showorder=22)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.enable = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ISSYSTEM, t1.LOGINNAME, t1.LOGINPWD, t11.MEMO, t11.OWNERID, t11.OWNERTYPE, t1.RESERVER, t1.RESERVER2, t11.SUBTYPE, t1.TIMEZONE, t1.UPDATEDATE, t1.UPDATEMAN, t11.USERDATA, t11.USERDATA2, t1.USERID, t1.USERMODE, t1.USERNAME, t11.USEROBJECTLEVEL, t11.USEROBJECTTYPE, t1.VALIDFLAG FROM T_SRFUSER t1  LEFT JOIN T_SRFUSEROBJECT t11 ON t1.USERID = t11.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="ISSYSTEM",expression="t1.ISSYSTEM",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINNAME",expression="t1.LOGINNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINPWD",expression="t1.LOGINPWD",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t11.MEMO",showorder=6)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t11.OWNERID",showorder=7)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t11.OWNERTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=10)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t11.SUBTYPE",showorder=11)
        ,@DEDataQueryCodeExp(name="TIMEZONE",expression="t1.TIMEZONE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=14)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t11.USERDATA",showorder=15)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t11.USERDATA2",showorder=16)
        ,@DEDataQueryCodeExp(name="USERID",expression="t1.USERID",showorder=17)
        ,@DEDataQueryCodeExp(name="USERMODE",expression="t1.USERMODE",showorder=18)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.USERNAME",showorder=19)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t11.USEROBJECTLEVEL",showorder=20)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t11.USEROBJECTTYPE",showorder=21)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=22)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ISSYSTEM, t1.LOGINNAME, t1.LOGINPWD, t11.MEMO, t11.OWNERID, t11.OWNERTYPE, t1.RESERVER, t1.RESERVER2, t11.SUBTYPE, t1.TIMEZONE, t1.UPDATEDATE, t1.UPDATEMAN, t11.USERDATA, t11.USERDATA2, t1.USERID, t1.USERMODE, t1.USERNAME, t11.USEROBJECTLEVEL, t11.USEROBJECTTYPE, t1.VALIDFLAG FROM T_SRFUSER t1  LEFT JOIN T_SRFUSEROBJECT t11 ON t1.USERID = t11.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="ISSYSTEM",expression="t1.ISSYSTEM",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINNAME",expression="t1.LOGINNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINPWD",expression="t1.LOGINPWD",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t11.MEMO",showorder=6)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t11.OWNERID",showorder=7)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t11.OWNERTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=10)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t11.SUBTYPE",showorder=11)
        ,@DEDataQueryCodeExp(name="TIMEZONE",expression="t1.TIMEZONE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=14)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t11.USERDATA",showorder=15)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t11.USERDATA2",showorder=16)
        ,@DEDataQueryCodeExp(name="USERID",expression="t1.USERID",showorder=17)
        ,@DEDataQueryCodeExp(name="USERMODE",expression="t1.USERMODE",showorder=18)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.USERNAME",showorder=19)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t11.USEROBJECTLEVEL",showorder=20)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t11.USEROBJECTTYPE",showorder=21)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=22)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.ISSYSTEM, t1.LOGINNAME, t1.LOGINPWD, t11.MEMO, t11.OWNERID, t11.OWNERTYPE, t1.RESERVER, t1.RESERVER2, t11.SUBTYPE, t1.TIMEZONE, t1.UPDATEDATE, t1.UPDATEMAN, t11.USERDATA, t11.USERDATA2, t1.USERID, t1.USERMODE, t1.USERNAME, t11.USEROBJECTLEVEL, t11.USEROBJECTTYPE, t1.VALIDFLAG FROM T_SRFUSER t1  LEFT JOIN T_SRFUSEROBJECT t11 ON t1.USERID = t11.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="ISSYSTEM",expression="t1.ISSYSTEM",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINNAME",expression="t1.LOGINNAME",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINPWD",expression="t1.LOGINPWD",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t11.MEMO",showorder=6)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t11.OWNERID",showorder=7)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t11.OWNERTYPE",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.RESERVER",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.RESERVER2",showorder=10)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t11.SUBTYPE",showorder=11)
        ,@DEDataQueryCodeExp(name="TIMEZONE",expression="t1.TIMEZONE",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=14)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t11.USERDATA",showorder=15)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t11.USERDATA2",showorder=16)
        ,@DEDataQueryCodeExp(name="USERID",expression="t1.USERID",showorder=17)
        ,@DEDataQueryCodeExp(name="USERMODE",expression="t1.USERMODE",showorder=18)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.USERNAME",showorder=19)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t11.USEROBJECTLEVEL",showorder=20)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t11.USEROBJECTTYPE",showorder=21)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.VALIDFLAG",showorder=22)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[ENABLE], t1.[ISSYSTEM], t1.[LOGINNAME], t1.[LOGINPWD], t11.[MEMO], t11.[OWNERID], t11.[OWNERTYPE], t1.[RESERVER], t1.[RESERVER2], t11.[SUBTYPE], t1.[TIMEZONE], t1.[UPDATEDATE], t1.[UPDATEMAN], t11.[USERDATA], t11.[USERDATA2], t1.[USERID], t1.[USERMODE], t1.[USERNAME], t11.[USEROBJECTLEVEL], t11.[USEROBJECTTYPE], t1.[VALIDFLAG] FROM [T_SRFUSER] t1  LEFT JOIN T_SRFUSEROBJECT t11 ON t1.USERID = t11.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.[ENABLE]",showorder=2)
        ,@DEDataQueryCodeExp(name="ISSYSTEM",expression="t1.[ISSYSTEM]",showorder=3)
        ,@DEDataQueryCodeExp(name="LOGINNAME",expression="t1.[LOGINNAME]",showorder=4)
        ,@DEDataQueryCodeExp(name="LOGINPWD",expression="t1.[LOGINPWD]",showorder=5)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t11.[MEMO]",showorder=6)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t11.[OWNERID]",showorder=7)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t11.[OWNERTYPE]",showorder=8)
        ,@DEDataQueryCodeExp(name="RESERVER",expression="t1.[RESERVER]",showorder=9)
        ,@DEDataQueryCodeExp(name="RESERVER2",expression="t1.[RESERVER2]",showorder=10)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t11.[SUBTYPE]",showorder=11)
        ,@DEDataQueryCodeExp(name="TIMEZONE",expression="t1.[TIMEZONE]",showorder=12)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=13)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=14)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t11.[USERDATA]",showorder=15)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t11.[USERDATA2]",showorder=16)
        ,@DEDataQueryCodeExp(name="USERID",expression="t1.[USERID]",showorder=17)
        ,@DEDataQueryCodeExp(name="USERMODE",expression="t1.[USERMODE]",showorder=18)
        ,@DEDataQueryCodeExp(name="USERNAME",expression="t1.[USERNAME]",showorder=19)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t11.[USEROBJECTLEVEL]",showorder=20)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t11.[USEROBJECTTYPE]",showorder=21)
        ,@DEDataQueryCodeExp(name="VALIDFLAG",expression="t1.[VALIDFLAG]",showorder=22)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    })
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserDefaultDQModelBase() {
        super();

        this.initAnnotation(UserDefaultDQModelBase.class);
    }

}