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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeformrf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="87E04FAC-A830-4B93-B33D-B49F14A3F51D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAJORPSDEFORMID`, t11.`PSDEFORMNAME` AS `MAJORPSDEFORMNAME`, t1.`MEMO`, t1.`MINORPSDEFORMID`, t21.`PSDEFORMNAME` AS `MINORPSDEFORMNAME`, t1.`PSDEFORMRFID`, t1.`PSDEFORMRFNAME`, t11.`PSDEID`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEFORMRF` t1  LEFT JOIN T_SRFPSDEFORM t11 ON t1.MAJORPSDEFORMID = t11.PSDEFORMID  LEFT JOIN T_SRFPSDEFORM t21 ON t1.MINORPSDEFORMID = t21.PSDEFORMID  ", querycodetemp="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAJORPSDEFORMID`, t11.`PSDEFORMNAME` AS `MAJORPSDEFORMNAME`, t1.`MEMO`, t1.`MINORPSDEFORMID`, t21.`PSDEFORMNAME` AS `MINORPSDEFORMNAME`, t1.`PSDEFORMRFID`, t1.`PSDEFORMRFNAME`, t11.`PSDEID`, t1.`UPDATEDATE`, t1.`UPDATEMAN`,t1.`SRFORIKEY` AS `SRFORIKEY`,t1.`SRFDRAFTFLAG` AS `SRFDRAFTFLAG` FROM `T_SRFPSDEFORMRF_TMP` t1  LEFT JOIN T_SRFPSDEFORM_TMP t11 ON t1.MAJORPSDEFORMID = t11.PSDEFORMID  LEFT JOIN T_SRFPSDEFORM t21 ON t1.MINORPSDEFORMID = t21.PSDEFORMID  ", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MAJORPSDEFORMID", expression="t1.`MAJORPSDEFORMID`", showorder=2), @DEDataQueryCodeExp(name="MAJORPSDEFORMNAME", expression="t11.`PSDEFORMNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MINORPSDEFORMID", expression="t1.`MINORPSDEFORMID`", showorder=5), @DEDataQueryCodeExp(name="MINORPSDEFORMNAME", expression="t21.`PSDEFORMNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEFORMRFID", expression="t1.`PSDEFORMRFID`", showorder=7), @DEDataQueryCodeExp(name="PSDEFORMRFNAME", expression="t1.`PSDEFORMRFNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEID", expression="t11.`PSDEID`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAJORPSDEFORMID, t11.PSDEFORMNAME AS MAJORPSDEFORMNAME, t1.MEMO, t1.MINORPSDEFORMID, t21.PSDEFORMNAME AS MINORPSDEFORMNAME, t1.PSDEFORMRFID, t1.PSDEFORMRFNAME, t11.PSDEID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEFORMRF t1  LEFT JOIN T_SRFPSDEFORM t11 ON t1.MAJORPSDEFORMID = t11.PSDEFORMID  LEFT JOIN T_SRFPSDEFORM t21 ON t1.MINORPSDEFORMID = t21.PSDEFORMID  ", querycodetemp="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MAJORPSDEFORMID, t11.PSDEFORMNAME AS MAJORPSDEFORMNAME, t1.MEMO, t1.MINORPSDEFORMID, t21.PSDEFORMNAME AS MINORPSDEFORMNAME, t1.PSDEFORMRFID, t1.PSDEFORMRFNAME, t11.PSDEID, t1.UPDATEDATE, t1.UPDATEMAN,t1.SRFORIKEY AS SRFORIKEY,t1.SRFDRAFTFLAG AS SRFDRAFTFLAG FROM T_SRFPSDEFORMRF_TMP t1  LEFT JOIN T_SRFPSDEFORM_TMP t11 ON t1.MAJORPSDEFORMID = t11.PSDEFORMID  LEFT JOIN T_SRFPSDEFORM t21 ON t1.MINORPSDEFORMID = t21.PSDEFORMID  ", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MAJORPSDEFORMID", expression="t1.MAJORPSDEFORMID", showorder=2), @DEDataQueryCodeExp(name="MAJORPSDEFORMNAME", expression="t11.PSDEFORMNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MINORPSDEFORMID", expression="t1.MINORPSDEFORMID", showorder=5), @DEDataQueryCodeExp(name="MINORPSDEFORMNAME", expression="t21.PSDEFORMNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEFORMRFID", expression="t1.PSDEFORMRFID", showorder=7), @DEDataQueryCodeExp(name="PSDEFORMRFNAME", expression="t1.PSDEFORMRFNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEID", expression="t11.PSDEID", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDEFormRFDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEFormRFDefaultDQModel() {
        this.initAnnotation(PSDEFormRFDefaultDQModel.class);
    }
}

