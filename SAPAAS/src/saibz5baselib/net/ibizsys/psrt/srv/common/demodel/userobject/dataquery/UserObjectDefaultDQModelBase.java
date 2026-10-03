/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.userobject.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="AC308D65-082C-4F63-A4C3-12A1EEB9C7DB",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.MEMO, t1.OWNERID, t1.OWNERTYPE, t1.SUBTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USEROBJECTID, t1.USEROBJECTLEVEL, t1.USEROBJECTNAME, t1.USEROBJECTTYPE FROM T_SRFUSEROBJECT t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.OWNERID",showorder=4)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.OWNERTYPE",showorder=5)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t1.SUBTYPE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.USEROBJECTID",showorder=11)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t1.USEROBJECTLEVEL",showorder=12)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t1.USEROBJECTNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t1.USEROBJECTTYPE",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`enable`, t1.`memo`, t1.`ownerid`, t1.`ownertype`, t1.`subtype`, t1.`updatedate`, t1.`updateman`, t1.`userdata`, t1.`userdata2`, t1.`userobjectid`, t1.`userobjectlevel`, t1.`userobjectname`, t1.`userobjecttype` FROM `t_srfuserobject` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.`enable`",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.`ownerid`",showorder=4)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.`ownertype`",showorder=5)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t1.`subtype`",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.`userdata`",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.`userdata2`",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.`userobjectid`",showorder=11)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t1.`userobjectlevel`",showorder=12)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t1.`userobjectname`",showorder=13)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t1.`userobjecttype`",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.enable = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.MEMO, t1.OWNERID, t1.OWNERTYPE, t1.SUBTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USEROBJECTID, t1.USEROBJECTLEVEL, t1.USEROBJECTNAME, t1.USEROBJECTTYPE FROM T_SRFUSEROBJECT t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.OWNERID",showorder=4)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.OWNERTYPE",showorder=5)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t1.SUBTYPE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.USEROBJECTID",showorder=11)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t1.USEROBJECTLEVEL",showorder=12)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t1.USEROBJECTNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t1.USEROBJECTTYPE",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.MEMO, t1.OWNERID, t1.OWNERTYPE, t1.SUBTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USEROBJECTID, t1.USEROBJECTLEVEL, t1.USEROBJECTNAME, t1.USEROBJECTTYPE FROM T_SRFUSEROBJECT t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.OWNERID",showorder=4)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.OWNERTYPE",showorder=5)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t1.SUBTYPE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.USEROBJECTID",showorder=11)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t1.USEROBJECTLEVEL",showorder=12)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t1.USEROBJECTNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t1.USEROBJECTTYPE",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.MEMO, t1.OWNERID, t1.OWNERTYPE, t1.SUBTYPE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USEROBJECTID, t1.USEROBJECTLEVEL, t1.USEROBJECTNAME, t1.USEROBJECTTYPE FROM T_SRFUSEROBJECT t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.ENABLE",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.OWNERID",showorder=4)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.OWNERTYPE",showorder=5)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t1.SUBTYPE",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.USEROBJECTID",showorder=11)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t1.USEROBJECTLEVEL",showorder=12)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t1.USEROBJECTNAME",showorder=13)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t1.USEROBJECTTYPE",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    }),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[ENABLE], t1.[MEMO], t1.[OWNERID], t1.[OWNERTYPE], t1.[SUBTYPE], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERDATA], t1.[USERDATA2], t1.[USEROBJECTID], t1.[USEROBJECTLEVEL], t1.[USEROBJECTNAME], t1.[USEROBJECTTYPE] FROM [T_SRFUSEROBJECT] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="ENABLE",expression="t1.[ENABLE]",showorder=2)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=3)
        ,@DEDataQueryCodeExp(name="OWNERID",expression="t1.[OWNERID]",showorder=4)
        ,@DEDataQueryCodeExp(name="OWNERTYPE",expression="t1.[OWNERTYPE]",showorder=5)
        ,@DEDataQueryCodeExp(name="SUBTYPE",expression="t1.[SUBTYPE]",showorder=6)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=7)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=8)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.[USERDATA]",showorder=9)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.[USERDATA2]",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.[USEROBJECTID]",showorder=11)
        ,@DEDataQueryCodeExp(name="USEROBJECTLEVEL",expression="t1.[USEROBJECTLEVEL]",showorder=12)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t1.[USEROBJECTNAME]",showorder=13)
        ,@DEDataQueryCodeExp(name="USEROBJECTTYPE",expression="t1.[USEROBJECTTYPE]",showorder=14)
    },
    conds={
        @DEDataQueryCodeCond(condition="t1.ENABLE = 1")
    })
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserObjectDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserObjectDefaultDQModelBase() {
        super();

        this.initAnnotation(UserObjectDefaultDQModelBase.class);
    }

}