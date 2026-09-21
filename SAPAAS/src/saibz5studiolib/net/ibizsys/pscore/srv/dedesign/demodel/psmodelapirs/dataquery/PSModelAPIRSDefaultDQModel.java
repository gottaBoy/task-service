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
package net.ibizsys.pscore.srv.dedesign.demodel.psmodelapirs.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FE02FAA9-D3CE-473B-85EB-2D64A8E6E6F1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEFFORMITEMID`, t11.`PSDEFFORMITEMNAME`, t21.`PSMODELAPIINTNAME`, t1.`PSMODELAPIMETHODID`, t21.`PSMODELAPIMETHODNAME`, t41.`PSMODELAPINAME`, t1.`PSMODELAPIRSID`, t1.`PSMODELAPIRSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELAPIRS` t1  LEFT JOIN T_SRFPSDEFFORMITEM t11 ON t1.PSDEFFORMITEMID = t11.PSDEFFORMITEMID  LEFT JOIN T_SRFPSMODELAPIMETHOD t21 ON t1.PSMODELAPIMETHODID = t21.PSMODELAPIMETHODID  LEFT JOIN T_SRFPSMODELAPIINT t31 ON t21.PSMODELAPIINTID = t31.PSMODELAPIINTID  LEFT JOIN T_SRFPSMODELAPI t41 ON t31.PSMODELAPIID = t41.PSMODELAPIID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEFFORMITEMID", expression="t1.`PSDEFFORMITEMID`", showorder=3), @DEDataQueryCodeExp(name="PSDEFFORMITEMNAME", expression="t11.`PSDEFFORMITEMNAME`", showorder=4), @DEDataQueryCodeExp(name="PSMODELAPIINTNAME", expression="t21.`PSMODELAPIINTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSMODELAPIMETHODID", expression="t1.`PSMODELAPIMETHODID`", showorder=6), @DEDataQueryCodeExp(name="PSMODELAPIMETHODNAME", expression="t21.`PSMODELAPIMETHODNAME`", showorder=7), @DEDataQueryCodeExp(name="PSMODELAPINAME", expression="t41.`PSMODELAPINAME`", showorder=8), @DEDataQueryCodeExp(name="PSMODELAPIRSID", expression="t1.`PSMODELAPIRSID`", showorder=9), @DEDataQueryCodeExp(name="PSMODELAPIRSNAME", expression="t1.`PSMODELAPIRSNAME`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEFFORMITEMID, t11.PSDEFFORMITEMNAME, t21.PSMODELAPIINTNAME, t1.PSMODELAPIMETHODID, t21.PSMODELAPIMETHODNAME, t41.PSMODELAPINAME, t1.PSMODELAPIRSID, t1.PSMODELAPIRSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELAPIRS t1  LEFT JOIN T_SRFPSDEFFORMITEM t11 ON t1.PSDEFFORMITEMID = t11.PSDEFFORMITEMID  LEFT JOIN T_SRFPSMODELAPIMETHOD t21 ON t1.PSMODELAPIMETHODID = t21.PSMODELAPIMETHODID  LEFT JOIN T_SRFPSMODELAPIINT t31 ON t21.PSMODELAPIINTID = t31.PSMODELAPIINTID  LEFT JOIN T_SRFPSMODELAPI t41 ON t31.PSMODELAPIID = t41.PSMODELAPIID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEFFORMITEMID", expression="t1.PSDEFFORMITEMID", showorder=3), @DEDataQueryCodeExp(name="PSDEFFORMITEMNAME", expression="t11.PSDEFFORMITEMNAME", showorder=4), @DEDataQueryCodeExp(name="PSMODELAPIINTNAME", expression="t21.PSMODELAPIINTNAME", showorder=5), @DEDataQueryCodeExp(name="PSMODELAPIMETHODID", expression="t1.PSMODELAPIMETHODID", showorder=6), @DEDataQueryCodeExp(name="PSMODELAPIMETHODNAME", expression="t21.PSMODELAPIMETHODNAME", showorder=7), @DEDataQueryCodeExp(name="PSMODELAPINAME", expression="t41.PSMODELAPINAME", showorder=8), @DEDataQueryCodeExp(name="PSMODELAPIRSID", expression="t1.PSMODELAPIRSID", showorder=9), @DEDataQueryCodeExp(name="PSMODELAPIRSNAME", expression="t1.PSMODELAPIRSNAME", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSModelAPIRSDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelAPIRSDefaultDQModel() {
        this.initAnnotation(PSModelAPIRSDefaultDQModel.class);
    }
}

