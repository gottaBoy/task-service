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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcsysres.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="37FA8955-AE39-4C29-B128-0E14A06B96EA", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t21.`PRODUCTSN`, t1.`PSDCSYSRESID`, t1.`PSDCSYSRESNAME`, t1.`PSDEVCENTERID`, t31.`PSDEVCENTERNAME`, t41.`PSSVRPROVIDERNAME`, t1.`PSSYSPRODUCTID`, t1.`PSSYSPRODUCTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCSYSRES` t1  LEFT JOIN T_SRFPSSYSPRODUCT t11 ON t1.PSSYSPRODUCTID = t11.PSSYSPRODUCTID  LEFT JOIN T_SRFPSPRODUCT t21 ON t11.PSSYSPRODUCTID = t21.PSPRODUCTID  LEFT JOIN T_SRFPSDEVCENTER t31 ON t1.PSDEVCENTERID = t31.PSDEVCENTERID  LEFT JOIN T_SRFPSSVRPROVIDER t41 ON t21.PSSVRPROVIDERID = t41.PSSVRPROVIDERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t21.`PRODUCTSN`", showorder=3), @DEDataQueryCodeExp(name="PSDCSYSRESID", expression="t1.`PSDCSYSRESID`", showorder=4), @DEDataQueryCodeExp(name="PSDCSYSRESNAME", expression="t1.`PSDCSYSRESNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t31.`PSDEVCENTERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSVRPROVIDERNAME", expression="t41.`PSSVRPROVIDERNAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSPRODUCTID", expression="t1.`PSSYSPRODUCTID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSPRODUCTNAME", expression="t1.`PSSYSPRODUCTNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t21.PRODUCTSN, t1.PSDCSYSRESID, t1.PSDCSYSRESNAME, t1.PSDEVCENTERID, t31.PSDEVCENTERNAME, t41.PSSVRPROVIDERNAME, t1.PSSYSPRODUCTID, t1.PSSYSPRODUCTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCSYSRES t1  LEFT JOIN T_SRFPSSYSPRODUCT t11 ON t1.PSSYSPRODUCTID = t11.PSSYSPRODUCTID  LEFT JOIN T_SRFPSPRODUCT t21 ON t11.PSSYSPRODUCTID = t21.PSPRODUCTID  LEFT JOIN T_SRFPSDEVCENTER t31 ON t1.PSDEVCENTERID = t31.PSDEVCENTERID  LEFT JOIN T_SRFPSSVRPROVIDER t41 ON t21.PSSVRPROVIDERID = t41.PSSVRPROVIDERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PRODUCTSN", expression="t21.PRODUCTSN", showorder=3), @DEDataQueryCodeExp(name="PSDCSYSRESID", expression="t1.PSDCSYSRESID", showorder=4), @DEDataQueryCodeExp(name="PSDCSYSRESNAME", expression="t1.PSDCSYSRESNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t31.PSDEVCENTERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSVRPROVIDERNAME", expression="t41.PSSVRPROVIDERNAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSPRODUCTID", expression="t1.PSSYSPRODUCTID", showorder=9), @DEDataQueryCodeExp(name="PSSYSPRODUCTNAME", expression="t1.PSSYSPRODUCTNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSDCSysResDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCSysResDefaultDQModel() {
        this.initAnnotation(PSDCSysResDefaultDQModel.class);
    }
}

