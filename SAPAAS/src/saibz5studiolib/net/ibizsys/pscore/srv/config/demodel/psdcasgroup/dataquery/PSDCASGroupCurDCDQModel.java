/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.psdcasgroup.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5E6BD9FB-F9AC-4860-9636-9EAD8AF8D51A", name="CurDC")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ASTYPE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`EXPRIEDTIME`, t1.`HTTPPORT`, t1.`HTTPSPORT`, t1.`MEMO`, t1.`PSASGROUPID`, t1.`PSASGROUPNAME`, t1.`PSDCASGROUPID`, t1.`PSDCASGROUPNAME`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`REFFLAG`, t1.`REFOBJID`, t1.`REFOBJNAME`, t1.`RESPOS`, t1.`RESSTATE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USAGEMODE` FROM `T_SRFPSDCASGROUP` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ASTYPE", expression="t1.`ASTYPE`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="EXPRIEDTIME", expression="t1.`EXPRIEDTIME`", showorder=3), @DEDataQueryCodeExp(name="HTTPPORT", expression="t1.`HTTPPORT`", showorder=4), @DEDataQueryCodeExp(name="HTTPSPORT", expression="t1.`HTTPSPORT`", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=6), @DEDataQueryCodeExp(name="PSASGROUPID", expression="t1.`PSASGROUPID`", showorder=7), @DEDataQueryCodeExp(name="PSASGROUPNAME", expression="t1.`PSASGROUPNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDCASGROUPID", expression="t1.`PSDCASGROUPID`", showorder=9), @DEDataQueryCodeExp(name="PSDCASGROUPNAME", expression="t1.`PSDCASGROUPNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=12), @DEDataQueryCodeExp(name="REFFLAG", expression="t1.`REFFLAG`", showorder=13), @DEDataQueryCodeExp(name="REFOBJID", expression="t1.`REFOBJID`", showorder=14), @DEDataQueryCodeExp(name="REFOBJNAME", expression="t1.`REFOBJNAME`", showorder=15), @DEDataQueryCodeExp(name="RESPOS", expression="t1.`RESPOS`", showorder=16), @DEDataQueryCodeExp(name="RESSTATE", expression="t1.`RESSTATE`", showorder=17), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=18), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=19), @DEDataQueryCodeExp(name="USAGEMODE", expression="t1.`USAGEMODE`", showorder=20)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ASTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.EXPRIEDTIME, t1.HTTPPORT, t1.HTTPSPORT, t1.MEMO, t1.PSASGROUPID, t1.PSASGROUPNAME, t1.PSDCASGROUPID, t1.PSDCASGROUPNAME, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.REFFLAG, t1.REFOBJID, t1.REFOBJNAME, t1.RESPOS, t1.RESSTATE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USAGEMODE FROM T_SRFPSDCASGROUP t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ASTYPE", expression="t1.ASTYPE", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="EXPRIEDTIME", expression="t1.EXPRIEDTIME", showorder=3), @DEDataQueryCodeExp(name="HTTPPORT", expression="t1.HTTPPORT", showorder=4), @DEDataQueryCodeExp(name="HTTPSPORT", expression="t1.HTTPSPORT", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=6), @DEDataQueryCodeExp(name="PSASGROUPID", expression="t1.PSASGROUPID", showorder=7), @DEDataQueryCodeExp(name="PSASGROUPNAME", expression="t1.PSASGROUPNAME", showorder=8), @DEDataQueryCodeExp(name="PSDCASGROUPID", expression="t1.PSDCASGROUPID", showorder=9), @DEDataQueryCodeExp(name="PSDCASGROUPNAME", expression="t1.PSDCASGROUPNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=11), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=12), @DEDataQueryCodeExp(name="REFFLAG", expression="t1.REFFLAG", showorder=13), @DEDataQueryCodeExp(name="REFOBJID", expression="t1.REFOBJID", showorder=14), @DEDataQueryCodeExp(name="REFOBJNAME", expression="t1.REFOBJNAME", showorder=15), @DEDataQueryCodeExp(name="RESPOS", expression="t1.RESPOS", showorder=16), @DEDataQueryCodeExp(name="RESSTATE", expression="t1.RESSTATE", showorder=17), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=18), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=19), @DEDataQueryCodeExp(name="USAGEMODE", expression="t1.USAGEMODE", showorder=20)}, conds={})})
public class PSDCASGroupCurDCDQModel
extends DEDataQueryModelBase {
    public PSDCASGroupCurDCDQModel() {
        this.initAnnotation(PSDCASGroupCurDCDQModel.class);
    }
}

