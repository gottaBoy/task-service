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
package net.ibizsys.pscore.srv.config.demodel.pspfpkgcat.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2E523EF3-F125-48F4-9BA8-0F9A3E232D72", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CATTAG`, t1.`CATTAG2`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSPFID`, t1.`PSPFNAME`, t1.`PSPFPKGCATID`, t1.`PSPFPKGCATNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFPKGCAT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CATTAG", expression="t1.`CATTAG`", showorder=0), @DEDataQueryCodeExp(name="CATTAG2", expression="t1.`CATTAG2`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=5), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.`PSPFNAME`", showorder=6), @DEDataQueryCodeExp(name="PSPFPKGCATID", expression="t1.`PSPFPKGCATID`", showorder=7), @DEDataQueryCodeExp(name="PSPFPKGCATNAME", expression="t1.`PSPFPKGCATNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CATTAG, t1.CATTAG2, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSPFID, t1.PSPFNAME, t1.PSPFPKGCATID, t1.PSPFPKGCATNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFPKGCAT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CATTAG", expression="t1.CATTAG", showorder=0), @DEDataQueryCodeExp(name="CATTAG2", expression="t1.CATTAG2", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=5), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.PSPFNAME", showorder=6), @DEDataQueryCodeExp(name="PSPFPKGCATID", expression="t1.PSPFPKGCATID", showorder=7), @DEDataQueryCodeExp(name="PSPFPKGCATNAME", expression="t1.PSPFPKGCATNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSPFPkgCatDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFPkgCatDefaultDQModel() {
        this.initAnnotation(PSPFPkgCatDefaultDQModel.class);
    }
}

