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
package net.ibizsys.pscore.srv.config.demodel.psdeutiltype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="138D7C5B-C4D1-4EBB-B046-DBB646CB632B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEUTILTYPEID`, t1.`PSDEUTILTYPENAME`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`UTILDESC`, t1.`UTILOBJ`, t1.`UTILPARAMS`, t1.`VALIDFLAG` FROM `T_SRFPSDEUTILTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="UTILMODEL", expression="t1.`UTILMODEL`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEUTILTYPEID", expression="t1.`PSDEUTILTYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSDEUTILTYPENAME", expression="t1.`PSDEUTILTYPENAME`", showorder=4), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="UTILDESC", expression="t1.`UTILDESC`", showorder=8), @DEDataQueryCodeExp(name="UTILOBJ", expression="t1.`UTILOBJ`", showorder=9), @DEDataQueryCodeExp(name="UTILPARAMS", expression="t1.`UTILPARAMS`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEUTILTYPEID, t1.PSDEUTILTYPENAME, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.UTILDESC, t1.UTILOBJ, t1.UTILPARAMS, t1.VALIDFLAG FROM T_SRFPSDEUTILTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="UTILMODEL", expression="t1.UTILMODEL", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEUTILTYPEID", expression="t1.PSDEUTILTYPEID", showorder=3), @DEDataQueryCodeExp(name="PSDEUTILTYPENAME", expression="t1.PSDEUTILTYPENAME", showorder=4), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="UTILDESC", expression="t1.UTILDESC", showorder=8), @DEDataQueryCodeExp(name="UTILOBJ", expression="t1.UTILOBJ", showorder=9), @DEDataQueryCodeExp(name="UTILPARAMS", expression="t1.UTILPARAMS", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSDEUtilTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEUtilTypeDefaultDQModel() {
        this.initAnnotation(PSDEUtilTypeDefaultDQModel.class);
    }
}

