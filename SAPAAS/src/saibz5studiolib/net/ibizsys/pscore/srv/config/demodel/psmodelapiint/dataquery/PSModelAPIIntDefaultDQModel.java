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
package net.ibizsys.pscore.srv.config.demodel.psmodelapiint.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="658988F0-7E22-4D22-916F-995A84A2A30C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INTDESC`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSMODELAPIID`, t1.`PSMODELAPIINTID`, t1.`PSMODELAPIINTNAME`, t11.`PSMODELAPINAME`, t1.`PSMODELID`, t1.`PSMODELNAME`, t1.`TYPEFIELD`, t1.`TYPEPARAM`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELAPIINT` t1  LEFT JOIN T_SRFPSMODELAPI t11 ON t1.PSMODELAPIID = t11.PSMODELAPIID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="INTDESC", expression="t1.`INTDESC`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=4), @DEDataQueryCodeExp(name="PSMODELAPIID", expression="t1.`PSMODELAPIID`", showorder=5), @DEDataQueryCodeExp(name="PSMODELAPIINTID", expression="t1.`PSMODELAPIINTID`", showorder=6), @DEDataQueryCodeExp(name="PSMODELAPIINTNAME", expression="t1.`PSMODELAPIINTNAME`", showorder=7), @DEDataQueryCodeExp(name="PSMODELAPINAME", expression="t11.`PSMODELAPINAME`", showorder=8), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.`PSMODELID`", showorder=9), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.`PSMODELNAME`", showorder=10), @DEDataQueryCodeExp(name="TYPEFIELD", expression="t1.`TYPEFIELD`", showorder=11), @DEDataQueryCodeExp(name="TYPEPARAM", expression="t1.`TYPEPARAM`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.INTDESC, t1.MEMO, t1.ORDERVALUE, t1.PSMODELAPIID, t1.PSMODELAPIINTID, t1.PSMODELAPIINTNAME, t11.PSMODELAPINAME, t1.PSMODELID, t1.PSMODELNAME, t1.TYPEFIELD, t1.TYPEPARAM, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELAPIINT t1  LEFT JOIN T_SRFPSMODELAPI t11 ON t1.PSMODELAPIID = t11.PSMODELAPIID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="INTDESC", expression="t1.INTDESC", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=4), @DEDataQueryCodeExp(name="PSMODELAPIID", expression="t1.PSMODELAPIID", showorder=5), @DEDataQueryCodeExp(name="PSMODELAPIINTID", expression="t1.PSMODELAPIINTID", showorder=6), @DEDataQueryCodeExp(name="PSMODELAPIINTNAME", expression="t1.PSMODELAPIINTNAME", showorder=7), @DEDataQueryCodeExp(name="PSMODELAPINAME", expression="t11.PSMODELAPINAME", showorder=8), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.PSMODELID", showorder=9), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.PSMODELNAME", showorder=10), @DEDataQueryCodeExp(name="TYPEFIELD", expression="t1.TYPEFIELD", showorder=11), @DEDataQueryCodeExp(name="TYPEPARAM", expression="t1.TYPEPARAM", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSModelAPIIntDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelAPIIntDefaultDQModel() {
        this.initAnnotation(PSModelAPIIntDefaultDQModel.class);
    }
}

