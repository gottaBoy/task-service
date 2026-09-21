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
package net.ibizsys.pscore.srv.dedesign.demodel.psdectrl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="64B9083E-B0BB-46D8-930A-51F1934A3546", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDECTRLID`, t1.`PSDECTRLNAME`, t1.`PSDECTRLTYPE`, t1.`PSDEID`, t1.`PSDENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDECTRL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDECTRLID", expression="t1.`PSDECTRLID`", showorder=3), @DEDataQueryCodeExp(name="PSDECTRLNAME", expression="t1.`PSDECTRLNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDECTRLTYPE", expression="t1.`PSDECTRLTYPE`", showorder=5), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=6), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDECTRLID, t1.PSDECTRLNAME, t1.PSDECTRLTYPE, t1.PSDEID, t1.PSDENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDECTRL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDECTRLID", expression="t1.PSDECTRLID", showorder=3), @DEDataQueryCodeExp(name="PSDECTRLNAME", expression="t1.PSDECTRLNAME", showorder=4), @DEDataQueryCodeExp(name="PSDECTRLTYPE", expression="t1.PSDECTRLTYPE", showorder=5), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=6), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDECtrlDefaultDQModel
extends DEDataQueryModelBase {
    public PSDECtrlDefaultDQModel() {
        this.initAnnotation(PSDECtrlDefaultDQModel.class);
    }
}

