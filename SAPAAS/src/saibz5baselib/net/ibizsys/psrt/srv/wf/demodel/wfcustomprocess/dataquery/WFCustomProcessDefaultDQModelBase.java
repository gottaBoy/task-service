/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.demodel.wfcustomprocess.dataquery;



import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodeCond;

@DEDataQuery(id="042C742C-717B-4437-83DA-6717A0D1A255",name="DEFAULT" )
@DEDataQueryCodes({
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PROCESSOBJECT, t1.UPDATEDATE, t1.UPDATEMAN, t1.VERSION, t1.WFCUSTOMPROCESSID, t1.WFCUSTOMPROCESSNAME FROM T_SRFWFCUSTOMPROCESS t1  ",querycodetemp="",declarecode="",dbtype="DB2",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="PROCESSOBJECT",expression="t1.PROCESSOBJECT",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=6)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSID",expression="t1.WFCUSTOMPROCESSID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSNAME",expression="t1.WFCUSTOMPROCESSNAME",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.`createdate`, t1.`createman`, t1.`memo`, t1.`processobject`, t1.`updatedate`, t1.`updateman`, t1.`version`, t1.`wfcustomprocessid`, t1.`wfcustomprocessname` FROM `t_srfwfcustomprocess` t1  ",querycodetemp="",declarecode="",dbtype="MYSQL5",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.`createdate`",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.`createman`",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.`memo`",showorder=2)
        ,@DEDataQueryCodeExp(name="PROCESSOBJECT",expression="t1.`processobject`",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.`updatedate`",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.`updateman`",showorder=5)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.`version`",showorder=6)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSID",expression="t1.`wfcustomprocessid`",showorder=7)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSNAME",expression="t1.`wfcustomprocessname`",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PROCESSOBJECT, t1.UPDATEDATE, t1.UPDATEMAN, t1.VERSION, t1.WFCUSTOMPROCESSID, t1.WFCUSTOMPROCESSNAME FROM T_SRFWFCUSTOMPROCESS t1  ",querycodetemp="",declarecode="",dbtype="ORACLE",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="PROCESSOBJECT",expression="t1.PROCESSOBJECT",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=6)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSID",expression="t1.WFCUSTOMPROCESSID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSNAME",expression="t1.WFCUSTOMPROCESSNAME",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PROCESSOBJECT, t1.UPDATEDATE, t1.UPDATEMAN, t1.VERSION, t1.WFCUSTOMPROCESSID, t1.WFCUSTOMPROCESSNAME FROM T_SRFWFCUSTOMPROCESS t1  ",querycodetemp="",declarecode="",dbtype="POSTGRESQL",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="PROCESSOBJECT",expression="t1.PROCESSOBJECT",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=6)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSID",expression="t1.WFCUSTOMPROCESSID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSNAME",expression="t1.WFCUSTOMPROCESSNAME",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PROCESSOBJECT, t1.UPDATEDATE, t1.UPDATEMAN, t1.VERSION, t1.WFCUSTOMPROCESSID, t1.WFCUSTOMPROCESSNAME FROM T_SRFWFCUSTOMPROCESS t1  ",querycodetemp="",declarecode="",dbtype="PPAS",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.CREATEDATE",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.CREATEMAN",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.MEMO",showorder=2)
        ,@DEDataQueryCodeExp(name="PROCESSOBJECT",expression="t1.PROCESSOBJECT",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.UPDATEDATE",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.UPDATEMAN",showorder=5)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.VERSION",showorder=6)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSID",expression="t1.WFCUSTOMPROCESSID",showorder=7)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSNAME",expression="t1.WFCUSTOMPROCESSNAME",showorder=8)
    },
    conds={}),
    @DEDataQueryCode(querycode="SELECT t1.[CREATEDATE], t1.[CREATEMAN], t1.[MEMO], t1.[PROCESSOBJECT], t1.[UPDATEDATE], t1.[UPDATEMAN], t1.[VERSION], t1.[WFCUSTOMPROCESSID], t1.[WFCUSTOMPROCESSNAME] FROM [T_SRFWFCUSTOMPROCESS] t1  ",querycodetemp="",declarecode="",dbtype="SQLSERVER",
    fieldexps={
        @DEDataQueryCodeExp(name="CREATEDATE",expression="t1.[CREATEDATE]",showorder=0)
        ,@DEDataQueryCodeExp(name="CREATEMAN",expression="t1.[CREATEMAN]",showorder=1)
        ,@DEDataQueryCodeExp(name="MEMO",expression="t1.[MEMO]",showorder=2)
        ,@DEDataQueryCodeExp(name="PROCESSOBJECT",expression="t1.[PROCESSOBJECT]",showorder=3)
        ,@DEDataQueryCodeExp(name="UPDATEDATE",expression="t1.[UPDATEDATE]",showorder=4)
        ,@DEDataQueryCodeExp(name="UPDATEMAN",expression="t1.[UPDATEMAN]",showorder=5)
        ,@DEDataQueryCodeExp(name="VERSION",expression="t1.[VERSION]",showorder=6)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSID",expression="t1.[WFCUSTOMPROCESSID]",showorder=7)
        ,@DEDataQueryCodeExp(name="WFCUSTOMPROCESSNAME",expression="t1.[WFCUSTOMPROCESSNAME]",showorder=8)
    },
    conds={})
})
/**
 *  实体数据查询 [DEFAULT]模型基类
 */
public abstract class WFCustomProcessDefaultDQModelBase extends net.ibizsys.paas.demodel.DEDataQueryModelBase {

    public WFCustomProcessDefaultDQModelBase() {
        super();

        this.initAnnotation(WFCustomProcessDefaultDQModelBase.class);
    }

}