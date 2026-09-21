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
package net.ibizsys.pscore.srv.config.demodel.pssysmodelfunc.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9B93E3A6-6D1D-4069-B18D-117BE3545718", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FUNCSN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSMODELAPIID`, t11.`PSMODELAPINAME`, t1.`PSMODELFIELDID`, t1.`PSMODELFIELDNAME`, t1.`PSMODELID`, t1.`PSMODELNAME`, t1.`PSSYSMODELFUNCID`, t1.`PSSYSMODELFUNCNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSYSMODELFUNC` t1  LEFT JOIN T_SRFPSMODELAPI t11 ON t1.PSMODELAPIID = t11.PSMODELAPIID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="FUNCDESC", expression="t1.`FUNCDESC`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FUNCSN", expression="t1.`FUNCSN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PSMODELAPIID", expression="t1.`PSMODELAPIID`", showorder=5), @DEDataQueryCodeExp(name="PSMODELAPINAME", expression="t11.`PSMODELAPINAME`", showorder=6), @DEDataQueryCodeExp(name="PSMODELFIELDID", expression="t1.`PSMODELFIELDID`", showorder=7), @DEDataQueryCodeExp(name="PSMODELFIELDNAME", expression="t1.`PSMODELFIELDNAME`", showorder=8), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.`PSMODELID`", showorder=9), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.`PSMODELNAME`", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELFUNCID", expression="t1.`PSSYSMODELFUNCID`", showorder=11), @DEDataQueryCodeExp(name="PSSYSMODELFUNCNAME", expression="t1.`PSSYSMODELFUNCNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FUNCSN, t1.MEMO, t1.ORDERVALUE, t1.PSMODELAPIID, t11.PSMODELAPINAME, t1.PSMODELFIELDID, t1.PSMODELFIELDNAME, t1.PSMODELID, t1.PSMODELNAME, t1.PSSYSMODELFUNCID, t1.PSSYSMODELFUNCNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSYSMODELFUNC t1  LEFT JOIN T_SRFPSMODELAPI t11 ON t1.PSMODELAPIID = t11.PSMODELAPIID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="FUNCDESC", expression="t1.FUNCDESC", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FUNCSN", expression="t1.FUNCSN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PSMODELAPIID", expression="t1.PSMODELAPIID", showorder=5), @DEDataQueryCodeExp(name="PSMODELAPINAME", expression="t11.PSMODELAPINAME", showorder=6), @DEDataQueryCodeExp(name="PSMODELFIELDID", expression="t1.PSMODELFIELDID", showorder=7), @DEDataQueryCodeExp(name="PSMODELFIELDNAME", expression="t1.PSMODELFIELDNAME", showorder=8), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.PSMODELID", showorder=9), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.PSMODELNAME", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELFUNCID", expression="t1.PSSYSMODELFUNCID", showorder=11), @DEDataQueryCodeExp(name="PSSYSMODELFUNCNAME", expression="t1.PSSYSMODELFUNCNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=15)}, conds={})})
public class PSSysModelFuncDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysModelFuncDefaultDQModel() {
        this.initAnnotation(PSSysModelFuncDefaultDQModel.class);
    }
}

