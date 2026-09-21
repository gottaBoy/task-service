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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysenginecfg.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9B2A930F-614B-40A2-8978-8A8D91AB1281", name="CurDC")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CFGVER`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`GLOBALFLAG`, t1.`IMPDEFRULE`, t1.`MEMO`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSSYSENGINECFGID`, t1.`PSSYSENGINECFGNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG`, t1.`VIEWCTRLAJAXMODE`, t1.`VIEWCTRLHANDLERFIRST`, t1.`VIEWUAREGMODE` FROM `T_SRFPSSYSENGINECFG` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CFGVER", expression="t1.`CFGVER`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="GLOBALFLAG", expression="t1.`GLOBALFLAG`", showorder=3), @DEDataQueryCodeExp(name="IMPDEFRULE", expression="t1.`IMPDEFRULE`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSENGINECFGID", expression="t1.`PSSYSENGINECFGID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSENGINECFGNAME", expression="t1.`PSSYSENGINECFGNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12), @DEDataQueryCodeExp(name="VIEWCTRLAJAXMODE", expression="t1.`VIEWCTRLAJAXMODE`", showorder=13), @DEDataQueryCodeExp(name="VIEWCTRLHANDLERFIRST", expression="t1.`VIEWCTRLHANDLERFIRST`", showorder=14), @DEDataQueryCodeExp(name="VIEWUAREGMODE", expression="t1.`VIEWUAREGMODE`", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.`PSDEVCENTERID` =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSSYSENGINECFG\"}')} )")}), @DEDataQueryCode(querycode="SELECT t1.CFGVER, t1.CREATEDATE, t1.CREATEMAN, t1.GLOBALFLAG, t1.IMPDEFRULE, t1.MEMO, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSSYSENGINECFGID, t1.PSSYSENGINECFGNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.VIEWCTRLAJAXMODE, t1.VIEWCTRLHANDLERFIRST, t1.VIEWUAREGMODE FROM T_SRFPSSYSENGINECFG t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CFGVER", expression="t1.CFGVER", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="GLOBALFLAG", expression="t1.GLOBALFLAG", showorder=3), @DEDataQueryCodeExp(name="IMPDEFRULE", expression="t1.IMPDEFRULE", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSENGINECFGID", expression="t1.PSSYSENGINECFGID", showorder=8), @DEDataQueryCodeExp(name="PSSYSENGINECFGNAME", expression="t1.PSSYSENGINECFGNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12), @DEDataQueryCodeExp(name="VIEWCTRLAJAXMODE", expression="t1.VIEWCTRLAJAXMODE", showorder=13), @DEDataQueryCodeExp(name="VIEWCTRLHANDLERFIRST", expression="t1.VIEWCTRLHANDLERFIRST", showorder=14), @DEDataQueryCodeExp(name="VIEWUAREGMODE", expression="t1.VIEWUAREGMODE", showorder=15)}, conds={@DEDataQueryCodeCond(condition="( t1.PSDEVCENTERID =  ${srfdatacontext('psdevcenterid','{\"defname\":\"PSDEVCENTERID\",\"dename\":\"PSSYSENGINECFG\"}')} )")})})
public class PSSysEngineCfgCurDCDQModel
extends DEDataQueryModelBase {
    public PSSysEngineCfgCurDCDQModel() {
        this.initAnnotation(PSSysEngineCfgCurDCDQModel.class);
    }
}

