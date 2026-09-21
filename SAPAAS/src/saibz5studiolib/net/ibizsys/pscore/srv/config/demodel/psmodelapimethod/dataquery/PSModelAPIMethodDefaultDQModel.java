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
package net.ibizsys.pscore.srv.config.demodel.psmodelapimethod.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D802EDE0-FE55-4E4E-B569-992CC8CBA0B1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSMODELAPIINTID`, t1.`PSMODELAPIINTNAME`, t1.`PSMODELAPIMETHODID`, t1.`PSMODELAPIMETHODNAME`, t21.`PSMODELAPINAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELAPIMETHOD` t1  LEFT JOIN T_SRFPSMODELAPIINT t11 ON t1.PSMODELAPIINTID = t11.PSMODELAPIINTID  LEFT JOIN T_SRFPSMODELAPI t21 ON t11.PSMODELAPIID = t21.PSMODELAPIID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSMODELAPIINTID", expression="t1.`PSMODELAPIINTID`", showorder=3), @DEDataQueryCodeExp(name="PSMODELAPIINTNAME", expression="t1.`PSMODELAPIINTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSMODELAPIMETHODID", expression="t1.`PSMODELAPIMETHODID`", showorder=5), @DEDataQueryCodeExp(name="PSMODELAPIMETHODNAME", expression="t1.`PSMODELAPIMETHODNAME`", showorder=6), @DEDataQueryCodeExp(name="PSMODELAPINAME", expression="t21.`PSMODELAPINAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSMODELAPIINTID, t1.PSMODELAPIINTNAME, t1.PSMODELAPIMETHODID, t1.PSMODELAPIMETHODNAME, t21.PSMODELAPINAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELAPIMETHOD t1  LEFT JOIN T_SRFPSMODELAPIINT t11 ON t1.PSMODELAPIINTID = t11.PSMODELAPIINTID  LEFT JOIN T_SRFPSMODELAPI t21 ON t11.PSMODELAPIID = t21.PSMODELAPIID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSMODELAPIINTID", expression="t1.PSMODELAPIINTID", showorder=3), @DEDataQueryCodeExp(name="PSMODELAPIINTNAME", expression="t1.PSMODELAPIINTNAME", showorder=4), @DEDataQueryCodeExp(name="PSMODELAPIMETHODID", expression="t1.PSMODELAPIMETHODID", showorder=5), @DEDataQueryCodeExp(name="PSMODELAPIMETHODNAME", expression="t1.PSMODELAPIMETHODNAME", showorder=6), @DEDataQueryCodeExp(name="PSMODELAPINAME", expression="t21.PSMODELAPINAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSModelAPIMethodDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelAPIMethodDefaultDQModel() {
        this.initAnnotation(PSModelAPIMethodDefaultDQModel.class);
    }
}

