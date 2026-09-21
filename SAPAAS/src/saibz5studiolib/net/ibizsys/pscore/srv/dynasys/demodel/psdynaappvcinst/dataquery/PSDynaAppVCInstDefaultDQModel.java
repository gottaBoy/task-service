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
package net.ibizsys.pscore.srv.dynasys.demodel.psdynaappvcinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="EA9A867F-2227-4740-8DFF-AB8B3D410A14", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CTRLTYPE`, t1.`MEMO`, t1.`PSDYNAAPPVCINSTID`, t1.`PSDYNAAPPVCINSTNAME`, t1.`PSDYNAAPPVIEWCTRLID`, t1.`PSDYNAAPPVIEWCTRLNAME`, t1.`PSDYNAAPPVIEWINSTID`, t1.`PSDYNAAPPVIEWINSTNAME`, t1.`PSDYNADEFORMINSTID`, t1.`PSDYNADEFORMINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDYNAAPPVCINST` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CTRLTYPE", expression="t1.`CTRLTYPE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDYNAAPPVCINSTID", expression="t1.`PSDYNAAPPVCINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSDYNAAPPVCINSTNAME", expression="t1.`PSDYNAAPPVCINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWCTRLID", expression="t1.`PSDYNAAPPVIEWCTRLID`", showorder=6), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWCTRLNAME", expression="t1.`PSDYNAAPPVIEWCTRLNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWINSTID", expression="t1.`PSDYNAAPPVIEWINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWINSTNAME", expression="t1.`PSDYNAAPPVIEWINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDYNADEFORMINSTID", expression="t1.`PSDYNADEFORMINSTID`", showorder=10), @DEDataQueryCodeExp(name="PSDYNADEFORMINSTNAME", expression="t1.`PSDYNADEFORMINSTNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CTRLTYPE, t1.MEMO, t1.PSDYNAAPPVCINSTID, t1.PSDYNAAPPVCINSTNAME, t1.PSDYNAAPPVIEWCTRLID, t1.PSDYNAAPPVIEWCTRLNAME, t1.PSDYNAAPPVIEWINSTID, t1.PSDYNAAPPVIEWINSTNAME, t1.PSDYNADEFORMINSTID, t1.PSDYNADEFORMINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDYNAAPPVCINST t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CTRLTYPE", expression="t1.CTRLTYPE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDYNAAPPVCINSTID", expression="t1.PSDYNAAPPVCINSTID", showorder=4), @DEDataQueryCodeExp(name="PSDYNAAPPVCINSTNAME", expression="t1.PSDYNAAPPVCINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWCTRLID", expression="t1.PSDYNAAPPVIEWCTRLID", showorder=6), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWCTRLNAME", expression="t1.PSDYNAAPPVIEWCTRLNAME", showorder=7), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWINSTID", expression="t1.PSDYNAAPPVIEWINSTID", showorder=8), @DEDataQueryCodeExp(name="PSDYNAAPPVIEWINSTNAME", expression="t1.PSDYNAAPPVIEWINSTNAME", showorder=9), @DEDataQueryCodeExp(name="PSDYNADEFORMINSTID", expression="t1.PSDYNADEFORMINSTID", showorder=10), @DEDataQueryCodeExp(name="PSDYNADEFORMINSTNAME", expression="t1.PSDYNADEFORMINSTNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSDynaAppVCInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSDynaAppVCInstDefaultDQModel() {
        this.initAnnotation(PSDynaAppVCInstDefaultDQModel.class);
    }
}

