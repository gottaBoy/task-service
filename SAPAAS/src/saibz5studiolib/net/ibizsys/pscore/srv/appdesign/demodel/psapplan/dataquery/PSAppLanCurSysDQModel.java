/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.appdesign.demodel.psapplan.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AFD67B8E-E5F0-480C-9B8E-8FDFD35B7353", name="CurSys")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSAPPLANID`, t1.`PSAPPLANNAME`, t1.`PSLANGUAGEID`, t11.`PSLANGUAGENAME`, t1.`PSSYSAPPID`, t21.`PSSYSAPPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4`, t1.`VALIDFLAG` FROM `T_SRFPSAPPLAN` t1  LEFT JOIN `T_SRFPSLANGUAGE` t11 ON t1.`PSLANGUAGEID` = t11.`PSLANGUAGEID`  LEFT JOIN `T_SRFPSSYSAPP` t21 ON t1.`PSSYSAPPID` = t21.`PSSYSAPPID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSAPPLANID", expression="t1.`PSAPPLANID`", showorder=4), @DEDataQueryCodeExp(name="PSAPPLANNAME", expression="t1.`PSAPPLANNAME`", showorder=5), @DEDataQueryCodeExp(name="PSLANGUAGEID", expression="t1.`PSLANGUAGEID`", showorder=6), @DEDataQueryCodeExp(name="PSLANGUAGENAME", expression="t11.`PSLANGUAGENAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.`PSSYSAPPNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t21.`PSSYSTEMID` =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSAPP\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSAPPLANID, t1.PSAPPLANNAME, t1.PSLANGUAGEID, t11.PSLANGUAGENAME, t1.PSSYSAPPID, t21.PSSYSAPPNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4, t1.VALIDFLAG FROM T_SRFPSAPPLAN t1  LEFT JOIN T_SRFPSLANGUAGE t11 ON t1.PSLANGUAGEID = t11.PSLANGUAGEID  LEFT JOIN T_SRFPSSYSAPP t21 ON t1.PSSYSAPPID = t21.PSSYSAPPID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSAPPLANID", expression="t1.PSAPPLANID", showorder=4), @DEDataQueryCodeExp(name="PSAPPLANNAME", expression="t1.PSAPPLANNAME", showorder=5), @DEDataQueryCodeExp(name="PSLANGUAGEID", expression="t1.PSLANGUAGEID", showorder=6), @DEDataQueryCodeExp(name="PSLANGUAGENAME", expression="t11.PSLANGUAGENAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=8), @DEDataQueryCodeExp(name="PSSYSAPPNAME", expression="t21.PSSYSAPPNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=16), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=17)}, conds={@DEDataQueryCodeCond(condition="( t21.PSSYSTEMID =  ${srfdatacontext('pssystemid','{\"defname\":\"PSSYSTEMID\",\"dename\":\"PSSYSAPP\"}')} )")})})
public class PSAppLanCurSysDQModel
extends DEDataQueryModelBase {
    public PSAppLanCurSysDQModel() {
        this.initAnnotation(PSAppLanCurSysDQModel.class);
    }
}

