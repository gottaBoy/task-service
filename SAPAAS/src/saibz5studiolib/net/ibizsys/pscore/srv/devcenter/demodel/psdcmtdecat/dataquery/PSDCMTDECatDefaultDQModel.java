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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcmtdecat.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3826A094-C6E6-4548-AC71-A469282514EA", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDCMODELTEMPLID`, t1.`PSDCMODELTEMPLNAME`, t1.`PSDCMTDECATID`, t1.`PSDCMTDECATNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDCMTDECAT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDCMODELTEMPLID", expression="t1.`PSDCMODELTEMPLID`", showorder=2), @DEDataQueryCodeExp(name="PSDCMODELTEMPLNAME", expression="t1.`PSDCMODELTEMPLNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDCMTDECATID", expression="t1.`PSDCMTDECATID`", showorder=4), @DEDataQueryCodeExp(name="PSDCMTDECATNAME", expression="t1.`PSDCMTDECATNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDCMODELTEMPLID, t1.PSDCMODELTEMPLNAME, t1.PSDCMTDECATID, t1.PSDCMTDECATNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDCMTDECAT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDCMODELTEMPLID", expression="t1.PSDCMODELTEMPLID", showorder=2), @DEDataQueryCodeExp(name="PSDCMODELTEMPLNAME", expression="t1.PSDCMODELTEMPLNAME", showorder=3), @DEDataQueryCodeExp(name="PSDCMTDECATID", expression="t1.PSDCMTDECATID", showorder=4), @DEDataQueryCodeExp(name="PSDCMTDECATNAME", expression="t1.PSDCMTDECATNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSDCMTDECatDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCMTDECatDefaultDQModel() {
        this.initAnnotation(PSDCMTDECatDefaultDQModel.class);
    }
}

