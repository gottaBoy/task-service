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
package net.ibizsys.pscore.srv.dedesign.demodel.psdeviewctrlds.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C50C4144-5273-419B-9FD0-13FE1549D98F", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`MINORSORTDIR`, t1.`MINORSORTPSDEFID`, t1.`MINORSORTPSDEFNAME`, t1.`ORDERVALUE`, t1.`PSDEDATASETID`, t11.`PSDEDATASETNAME`, t1.`PSDEVIEWCTRLDSID`, t1.`PSDEVIEWCTRLDSNAME`, t1.`PSDEVIEWCTRLID`, t1.`PSDEVIEWCTRLNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVIEWCTRLDS` t1  LEFT JOIN T_SRFPSDEDATASET t11 ON t1.PSDEDATASETID = t11.PSDEDATASETID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="MINORSORTDIR", expression="t1.`MINORSORTDIR`", showorder=3), @DEDataQueryCodeExp(name="MINORSORTPSDEFID", expression="t1.`MINORSORTPSDEFID`", showorder=4), @DEDataQueryCodeExp(name="MINORSORTPSDEFNAME", expression="t1.`MINORSORTPSDEFNAME`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PSDEDATASETID", expression="t1.`PSDEDATASETID`", showorder=7), @DEDataQueryCodeExp(name="PSDEDATASETNAME", expression="t11.`PSDEDATASETNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVIEWCTRLDSID", expression="t1.`PSDEVIEWCTRLDSID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVIEWCTRLDSNAME", expression="t1.`PSDEVIEWCTRLDSNAME`", showorder=10), @DEDataQueryCodeExp(name="PSDEVIEWCTRLID", expression="t1.`PSDEVIEWCTRLID`", showorder=11), @DEDataQueryCodeExp(name="PSDEVIEWCTRLNAME", expression="t1.`PSDEVIEWCTRLNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.MINORSORTDIR, t1.MINORSORTPSDEFID, t1.MINORSORTPSDEFNAME, t1.ORDERVALUE, t1.PSDEDATASETID, t11.PSDEDATASETNAME, t1.PSDEVIEWCTRLDSID, t1.PSDEVIEWCTRLDSNAME, t1.PSDEVIEWCTRLID, t1.PSDEVIEWCTRLNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVIEWCTRLDS t1  LEFT JOIN T_SRFPSDEDATASET t11 ON t1.PSDEDATASETID = t11.PSDEDATASETID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="MINORSORTDIR", expression="t1.MINORSORTDIR", showorder=3), @DEDataQueryCodeExp(name="MINORSORTPSDEFID", expression="t1.MINORSORTPSDEFID", showorder=4), @DEDataQueryCodeExp(name="MINORSORTPSDEFNAME", expression="t1.MINORSORTPSDEFNAME", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PSDEDATASETID", expression="t1.PSDEDATASETID", showorder=7), @DEDataQueryCodeExp(name="PSDEDATASETNAME", expression="t11.PSDEDATASETNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVIEWCTRLDSID", expression="t1.PSDEVIEWCTRLDSID", showorder=9), @DEDataQueryCodeExp(name="PSDEVIEWCTRLDSNAME", expression="t1.PSDEVIEWCTRLDSNAME", showorder=10), @DEDataQueryCodeExp(name="PSDEVIEWCTRLID", expression="t1.PSDEVIEWCTRLID", showorder=11), @DEDataQueryCodeExp(name="PSDEVIEWCTRLNAME", expression="t1.PSDEVIEWCTRLNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSDEViewCtrlDSDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEViewCtrlDSDefaultDQModel() {
        this.initAnnotation(PSDEViewCtrlDSDefaultDQModel.class);
    }
}

