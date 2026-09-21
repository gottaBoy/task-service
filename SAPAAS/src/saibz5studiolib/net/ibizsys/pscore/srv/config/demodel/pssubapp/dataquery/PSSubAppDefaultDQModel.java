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
package net.ibizsys.pscore.srv.config.demodel.pssubapp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="7B873881-CE50-4EE8-8B45-D5080D1DB81C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`APPPKGNAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSPFID`, t11.`PSPFNAME`, t1.`PSSUBAPPID`, t1.`PSSUBAPPNAME`, t1.`PSSUBSYSID`, t1.`PSSUBSYSNAME`, t1.`PSSYSAPPID`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSUBAPP` t1  LEFT JOIN `T_SRFPSPF` t11 ON t1.`PSPFID` = t11.`PSPFID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="VIEWMODELS", expression="t1.`VIEWMODELS`", showorder=-1), @DEDataQueryCodeExp(name="APPPKGNAME", expression="t1.`APPPKGNAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=4), @DEDataQueryCodeExp(name="PSPFNAME", expression="t11.`PSPFNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSUBAPPID", expression="t1.`PSSUBAPPID`", showorder=6), @DEDataQueryCodeExp(name="PSSUBAPPNAME", expression="t1.`PSSUBAPPNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=8), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.`PSSUBSYSNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.`PSSYSAPPID`", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.APPPKGNAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSPFID, t11.PSPFNAME, t1.PSSUBAPPID, t1.PSSUBAPPNAME, t1.PSSUBSYSID, t1.PSSUBSYSNAME, t1.PSSYSAPPID, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSUBAPP t1  LEFT JOIN T_SRFPSPF t11 ON t1.PSPFID = t11.PSPFID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="VIEWMODELS", expression="t1.VIEWMODELS", showorder=-1), @DEDataQueryCodeExp(name="APPPKGNAME", expression="t1.APPPKGNAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=4), @DEDataQueryCodeExp(name="PSPFNAME", expression="t11.PSPFNAME", showorder=5), @DEDataQueryCodeExp(name="PSSUBAPPID", expression="t1.PSSUBAPPID", showorder=6), @DEDataQueryCodeExp(name="PSSUBAPPNAME", expression="t1.PSSUBAPPNAME", showorder=7), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=8), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t1.PSSUBSYSNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSAPPID", expression="t1.PSSYSAPPID", showorder=10), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=11), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=12)}, conds={})})
public class PSSubAppDefaultDQModel
extends DEDataQueryModelBase {
    public PSSubAppDefaultDQModel() {
        this.initAnnotation(PSSubAppDefaultDQModel.class);
    }
}

