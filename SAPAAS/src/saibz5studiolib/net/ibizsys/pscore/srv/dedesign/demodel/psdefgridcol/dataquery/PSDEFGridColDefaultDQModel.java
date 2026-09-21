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
package net.ibizsys.pscore.srv.dedesign.demodel.psdefgridcol.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="158C79EF-052B-4C0A-BB24-0BD12868528C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`GCMODE`, t1.`MEMO`, t1.`PSDEFGRIDCOLID`, t1.`PSDEFGRIDCOLNAME`, t1.`PSDEFID`, t1.`PSDEFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERPARAMS`, t1.`WIDTH` FROM `T_SRFPSDEFGRIDCOL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="GCMODE", expression="t1.`GCMODE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEFGRIDCOLID", expression="t1.`PSDEFGRIDCOLID`", showorder=4), @DEDataQueryCodeExp(name="PSDEFGRIDCOLNAME", expression="t1.`PSDEFGRIDCOLNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.`PSDEFID`", showorder=6), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.`PSDEFNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.`USERPARAMS`", showorder=10), @DEDataQueryCodeExp(name="WIDTH", expression="t1.`WIDTH`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.GCMODE, t1.MEMO, t1.PSDEFGRIDCOLID, t1.PSDEFGRIDCOLNAME, t1.PSDEFID, t1.PSDEFNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERPARAMS, t1.WIDTH FROM T_SRFPSDEFGRIDCOL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="GCMODE", expression="t1.GCMODE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEFGRIDCOLID", expression="t1.PSDEFGRIDCOLID", showorder=4), @DEDataQueryCodeExp(name="PSDEFGRIDCOLNAME", expression="t1.PSDEFGRIDCOLNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.PSDEFID", showorder=6), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.PSDEFNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="USERPARAMS", expression="t1.USERPARAMS", showorder=10), @DEDataQueryCodeExp(name="WIDTH", expression="t1.WIDTH", showorder=11)}, conds={})})
public class PSDEFGridColDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEFGridColDefaultDQModel() {
        this.initAnnotation(PSDEFGridColDefaultDQModel.class);
    }
}

