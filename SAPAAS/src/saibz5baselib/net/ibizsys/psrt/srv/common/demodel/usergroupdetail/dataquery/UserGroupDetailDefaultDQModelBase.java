/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.usergroupdetail.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="3DA05FEA-614F-48A2-B033-C9A4F6BA5C6E",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERGROUPDETAILID, t1.USERGROUPDETAILNAME, t1.USERGROUPID, t11.USERGROUPNAME, t1.USEROBJECTID, t21.USEROBJECTNAME FROM T_SRFUSERGROUPDETAIL t1  LEFT JOIN T_SRFUSERGROUP t11 ON t1.USERGROUPID = t11.USERGROUPID  LEFT JOIN T_SRFUSEROBJECT t21 ON t1.USEROBJECTID = t21.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=4)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=5)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILID",expression="t1.USERGROUPDETAILID",showorder=6)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILNAME",expression="t1.USERGROUPDETAILNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="USERGROUPID",expression="t1.USERGROUPID",showorder=8)
        ,@DEDataQueryCodeExp(name="USERGROUPNAME",expression="t11.USERGROUPNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.USEROBJECTID",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t21.USEROBJECTNAME",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`updatedate`, t1.`updateman`, t1.`userdata`, t1.`userdata2`, t1.`usergroupdetailid`, t1.`usergroupdetailname`, t1.`usergroupid`, t11.`usergroupname`, t1.`userobjectid`, t21.`userobjectname` FROM `t_srfusergroupdetail` t1  LEFT JOIN t_srfusergroup t11 ON t1.usergroupid = t11.usergroupid  LEFT JOIN t_srfuserobject t21 ON t1.userobjectid = t21.userobjectid  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=3)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.`userdata`",showorder=4)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.`userdata2`",showorder=5)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILID",expression="t1.`usergroupdetailid`",showorder=6)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILNAME",expression="t1.`usergroupdetailname`",showorder=7)
        ,@DEDataQueryCodeExp(name="USERGROUPID",expression="t1.`usergroupid`",showorder=8)
        ,@DEDataQueryCodeExp(name="USERGROUPNAME",expression="t11.`usergroupname`",showorder=9)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.`userobjectid`",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t21.`userobjectname`",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERGROUPDETAILID, t1.USERGROUPDETAILNAME, t1.USERGROUPID, t11.USERGROUPNAME, t1.USEROBJECTID, t21.USEROBJECTNAME FROM T_SRFUSERGROUPDETAIL t1  LEFT JOIN T_SRFUSERGROUP t11 ON t1.USERGROUPID = t11.USERGROUPID  LEFT JOIN T_SRFUSEROBJECT t21 ON t1.USEROBJECTID = t21.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=4)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=5)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILID",expression="t1.USERGROUPDETAILID",showorder=6)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILNAME",expression="t1.USERGROUPDETAILNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="USERGROUPID",expression="t1.USERGROUPID",showorder=8)
        ,@DEDataQueryCodeExp(name="USERGROUPNAME",expression="t11.USERGROUPNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.USEROBJECTID",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t21.USEROBJECTNAME",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERGROUPDETAILID, t1.USERGROUPDETAILNAME, t1.USERGROUPID, t11.USERGROUPNAME, t1.USEROBJECTID, t21.USEROBJECTNAME FROM T_SRFUSERGROUPDETAIL t1  LEFT JOIN T_SRFUSERGROUP t11 ON t1.USERGROUPID = t11.USERGROUPID  LEFT JOIN T_SRFUSEROBJECT t21 ON t1.USEROBJECTID = t21.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=4)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=5)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILID",expression="t1.USERGROUPDETAILID",showorder=6)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILNAME",expression="t1.USERGROUPDETAILNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="USERGROUPID",expression="t1.USERGROUPID",showorder=8)
        ,@DEDataQueryCodeExp(name="USERGROUPNAME",expression="t11.USERGROUPNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.USEROBJECTID",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t21.USEROBJECTNAME",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.USERDATA2, t1.USERGROUPDETAILID, t1.USERGROUPDETAILNAME, t1.USERGROUPID, t11.USERGROUPNAME, t1.USEROBJECTID, t21.USEROBJECTNAME FROM T_SRFUSERGROUPDETAIL t1  LEFT JOIN T_SRFUSERGROUP t11 ON t1.USERGROUPID = t11.USERGROUPID  LEFT JOIN T_SRFUSEROBJECT t21 ON t1.USEROBJECTID = t21.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=3)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.USERDATA",showorder=4)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.USERDATA2",showorder=5)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILID",expression="t1.USERGROUPDETAILID",showorder=6)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILNAME",expression="t1.USERGROUPDETAILNAME",showorder=7)
        ,@DEDataQueryCodeExp(name="USERGROUPID",expression="t1.USERGROUPID",showorder=8)
        ,@DEDataQueryCodeExp(name="USERGROUPNAME",expression="t11.USERGROUPNAME",showorder=9)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.USEROBJECTID",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t21.USEROBJECTNAME",showorder=11)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[USERDATA], t1.[USERDATA2], t1.[USERGROUPDETAILID], t1.[USERGROUPDETAILNAME], t1.[USERGROUPID], t11.[USERGROUPNAME], t1.[USEROBJECTID], t21.[USEROBJECTNAME] FROM [T_SRFUSERGROUPDETAIL] t1  LEFT JOIN T_SRFUSERGROUP t11 ON t1.USERGROUPID = t11.USERGROUPID  LEFT JOIN T_SRFUSEROBJECT t21 ON t1.USEROBJECTID = t21.USEROBJECTID  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=2)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=3)
        ,@DEDataQueryCodeExp(name="USERDATA",expression="t1.[USERDATA]",showorder=4)
        ,@DEDataQueryCodeExp(name="USERDATA2",expression="t1.[USERDATA2]",showorder=5)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILID",expression="t1.[USERGROUPDETAILID]",showorder=6)
        ,@DEDataQueryCodeExp(name="USERGROUPDETAILNAME",expression="t1.[USERGROUPDETAILNAME]",showorder=7)
        ,@DEDataQueryCodeExp(name="USERGROUPID",expression="t1.[USERGROUPID]",showorder=8)
        ,@DEDataQueryCodeExp(name="USERGROUPNAME",expression="t11.[USERGROUPNAME]",showorder=9)
        ,@DEDataQueryCodeExp(name="USEROBJECTID",expression="t1.[USEROBJECTID]",showorder=10)
        ,@DEDataQueryCodeExp(name="USEROBJECTNAME",expression="t21.[USEROBJECTNAME]",showorder=11)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class UserGroupDetailDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public UserGroupDetailDefaultDQModelBase() {
        super();

        this.initAnnotation(UserGroupDetailDefaultDQModelBase.class);
    }

}