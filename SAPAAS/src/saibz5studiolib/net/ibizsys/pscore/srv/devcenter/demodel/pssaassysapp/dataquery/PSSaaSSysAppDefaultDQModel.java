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
package net.ibizsys.pscore.srv.devcenter.demodel.pssaassysapp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="0B18A09C-523E-46D2-869D-6DF55824A0DC", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`APPPKGNAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSAPPTYPEID`, t11.`PSAPPTYPENAME`, t1.`PSSAASSYSAPPID`, t1.`PSSAASSYSAPPNAME`, t1.`PSSAASSYSVERID`, t21.`PSSAASSYSVERNAME`, t1.`PSSYSAPPID`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSAASSYSAPP` t1  LEFT JOIN T_SRFPSAPPTYPE t11 ON t1.PSAPPTYPEID = t11.PSAPPTYPEID  LEFT JOIN T_SRFPSSAASSYSVER t21 ON t1.PSSAASSYSVERID = t21.PSSAASSYSVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="APPPKGNAME", expression="t1.`APPPKGNAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSAPPTYPEID", expression="t1.`PSAPPTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSAPPTYPENAME", expression="t11.`PSAPPTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSSAASSYSAPPID", expression="t1.`PSSAASSYSAPPID`", showorder=6), @DEDataQueryCodeExp(name="PSSAASSYSAPPNAME", expression="t1.`PSSAASSYSAPPNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSAASSYSVERID", expression="t1.`PSSAASSYSVERID`", showorder=8), @DEDataQueryCodeExp(name="PSSAASSYSVERNAME", expression="t21.`PSSAASSYSVERNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.APPPKGNAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSAPPTYPEID, t11.PSAPPTYPENAME, t1.PSSAASSYSAPPID, t1.PSSAASSYSAPPNAME, t1.PSSAASSYSVERID, t21.PSSAASSYSVERNAME, t1.PSSYSAPPID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSAASSYSAPP t1  LEFT JOIN T_SRFPSAPPTYPE t11 ON t1.PSAPPTYPEID = t11.PSAPPTYPEID  LEFT JOIN T_SRFPSSAASSYSVER t21 ON t1.PSSAASSYSVERID = t21.PSSAASSYSVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="APPPKGNAME", expression="t1.APPPKGNAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSAPPTYPEID", expression="t1.PSAPPTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSAPPTYPENAME", expression="t11.PSAPPTYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSSAASSYSAPPID", expression="t1.PSSAASSYSAPPID", showorder=6), @DEDataQueryCodeExp(name="PSSAASSYSAPPNAME", expression="t1.PSSAASSYSAPPNAME", showorder=7), @DEDataQueryCodeExp(name="PSSAASSYSVERID", expression="t1.PSSAASSYSVERID", showorder=8), @DEDataQueryCodeExp(name="PSSAASSYSVERNAME", expression="t21.PSSAASSYSVERNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSSaaSSysAppDefaultDQModel
extends DEDataQueryModelBase {
    public PSSaaSSysAppDefaultDQModel() {
        this.initAnnotation(PSSaaSSysAppDefaultDQModel.class);
    }
}

