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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaappviewctrl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="44A89CC9-EC7E-4C23-8432-A863D76DC2F3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CTRLTYPE`, t1.`MEMO`, t1.`PSDYNAAPPVIEWCTRLID`, t1.`PSDYNAAPPVIEWCTRLNAME`, t1.`PSDYNAAPPVIEWID`, t11.`PSDYNAAPPVIEWNAME`, t1.`PSDYNADEFORMID`, t1.`PSDYNADEFORMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDYNAAPPVIEWCTRL` t1  LEFT JOIN T_SRFPSDYNAAPPVIEW t11 ON t1.PSDYNAAPPVIEWID = t11.PSDYNAAPPVIEWID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CTRLTYPE", expression="t1.`CTRLTYPE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWCTRLID", expression="t1.`PSDYNAAPPVIEWCTRLID`", showorder=4), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWCTRLNAME", expression="t1.`PSDYNAAPPVIEWCTRLNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWID", expression="t1.`PSDYNAAPPVIEWID`", showorder=6), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWNAME", expression="t11.`PSDYNAAPPVIEWNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDYNADEFORMID", expression="t1.`PSDYNADEFORMID`", showorder=8), @DEDataQueryCodeExp(name="PSDYNADEFORMNAME", expression="t1.`PSDYNADEFORMNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CTRLTYPE, t1.MEMO, t1.PSDYNAAPPVIEWCTRLID, t1.PSDYNAAPPVIEWCTRLNAME, t1.PSDYNAAPPVIEWID, t11.PSDYNAAPPVIEWNAME, t1.PSDYNADEFORMID, t1.PSDYNADEFORMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDYNAAPPVIEWCTRL t1  LEFT JOIN T_SRFPSDYNAAPPVIEW t11 ON t1.PSDYNAAPPVIEWID = t11.PSDYNAAPPVIEWID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CTRLTYPE", expression="t1.CTRLTYPE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWCTRLID", expression="t1.PSDYNAAPPVIEWCTRLID", showorder=4), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWCTRLNAME", expression="t1.PSDYNAAPPVIEWCTRLNAME", showorder=5), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWID", expression="t1.PSDYNAAPPVIEWID", showorder=6), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWNAME", expression="t11.PSDYNAAPPVIEWNAME", showorder=7), @DEDataQueryCodeExp(name="PSDYNADEFORMID", expression="t1.PSDYNADEFORMID", showorder=8), @DEDataQueryCodeExp(name="PSDYNADEFORMNAME", expression="t1.PSDYNADEFORMNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDynaAppViewCtrlDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaAppViewCtrlDefaultDQModel() {
        this.initAnnotation(PSDynaAppViewCtrlDefaultDQModel.class);
    }
}

