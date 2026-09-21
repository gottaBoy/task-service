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
package net.ibizsys.pscore.srv.config.demodel.pssysutiltype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="DB2558AF-81C3-4D4E-BD37-F5A0E249D24D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSUTILTYPEID`, t1.`PSSYSUTILTYPENAME`, t1.`REGTOSYSFLAG`, t1.`TYPEOBJ`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`UTILDESC`, t1.`UTILOBJ`, t1.`UTILPARAMS`, t1.`UTILRTOBJS`, t1.`VALIDFLAG` FROM `T_SRFPSSYSUTILTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSYSUTILTYPEID", expression="t1.`PSSYSUTILTYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSSYSUTILTYPENAME", expression="t1.`PSSYSUTILTYPENAME`", showorder=4), @DEDataQueryCodeExp(name="REGTOSYSFLAG", expression="t1.`REGTOSYSFLAG`", showorder=5), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.`TYPEOBJ`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="UTILDESC", expression="t1.`UTILDESC`", showorder=9), @DEDataQueryCodeExp(name="UTILOBJ", expression="t1.`UTILOBJ`", showorder=10), @DEDataQueryCodeExp(name="UTILPARAMS", expression="t1.`UTILPARAMS`", showorder=11), @DEDataQueryCodeExp(name="UTILRTOBJS", expression="t1.`UTILRTOBJS`", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSUTILTYPEID, t1.PSSYSUTILTYPENAME, t1.REGTOSYSFLAG, t1.TYPEOBJ, t1.UPDATEDATE, t1.UPDATEMAN, t1.UTILDESC, t1.UTILOBJ, t1.UTILPARAMS, t1.UTILRTOBJS, t1.VALIDFLAG FROM T_SRFPSSYSUTILTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSYSUTILTYPEID", expression="t1.PSSYSUTILTYPEID", showorder=3), @DEDataQueryCodeExp(name="PSSYSUTILTYPENAME", expression="t1.PSSYSUTILTYPENAME", showorder=4), @DEDataQueryCodeExp(name="REGTOSYSFLAG", expression="t1.REGTOSYSFLAG", showorder=5), @DEDataQueryCodeExp(name="TYPEOBJ", expression="t1.TYPEOBJ", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="UTILDESC", expression="t1.UTILDESC", showorder=9), @DEDataQueryCodeExp(name="UTILOBJ", expression="t1.UTILOBJ", showorder=10), @DEDataQueryCodeExp(name="UTILPARAMS", expression="t1.UTILPARAMS", showorder=11), @DEDataQueryCodeExp(name="UTILRTOBJS", expression="t1.UTILRTOBJS", showorder=12), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=13)}, conds={})})
public class PSSysUtilTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysUtilTypeDefaultDQModel() {
        this.initAnnotation(PSSysUtilTypeDefaultDQModel.class);
    }
}

