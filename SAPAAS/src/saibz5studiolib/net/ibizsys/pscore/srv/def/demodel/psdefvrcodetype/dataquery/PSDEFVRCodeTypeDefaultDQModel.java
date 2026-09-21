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
package net.ibizsys.pscore.srv.def.demodel.psdefvrcodetype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="39DAA23F-16FE-45F8-88FE-FE75E52D2D4A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODETYPE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MAINTYPE`, t1.`MEMO`, t1.`PSDEFVRCODETYPEID`, t1.`PSDEFVRCODETYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEFVRCODETYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODETYPE", expression="t1.`CODETYPE`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MAINTYPE", expression="t1.`MAINTYPE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEFVRCODETYPEID", expression="t1.`PSDEFVRCODETYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEFVRCODETYPENAME", expression="t1.`PSDEFVRCODETYPENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODETYPE, t1.CREATEDATE, t1.CREATEMAN, t1.MAINTYPE, t1.MEMO, t1.PSDEFVRCODETYPEID, t1.PSDEFVRCODETYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEFVRCODETYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODETYPE", expression="t1.CODETYPE", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MAINTYPE", expression="t1.MAINTYPE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEFVRCODETYPEID", expression="t1.PSDEFVRCODETYPEID", showorder=5), @DEDataQueryCodeExp(name="PSDEFVRCODETYPENAME", expression="t1.PSDEFVRCODETYPENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSDEFVRCodeTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEFVRCodeTypeDefaultDQModel() {
        this.initAnnotation(PSDEFVRCodeTypeDefaultDQModel.class);
    }
}

