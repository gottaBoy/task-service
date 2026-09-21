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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnsysmodel.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="47910247-E8D0-4D1C-B5E3-B05DF0A1A928", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`CURCNT`, t1.`MAXCNT`, t1.`PSDEVSLNSYSID`, t1.`PSDEVSLNSYSMODELID`, t1.`PSDEVSLNSYSMODELNAME`, t1.`PSDEVSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNSYSMODEL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="CURCNT", expression="t1.`CURCNT`", showorder=2), @DEDataQueryCodeExp(name="MAXCNT", expression="t1.`MAXCNT`", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSMODELID", expression="t1.`PSDEVSLNSYSMODELID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSMODELNAME", expression="t1.`PSDEVSLNSYSMODELNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.`PSDEVSLNSYSNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.CURCNT, t1.MAXCNT, t1.PSDEVSLNSYSID, t1.PSDEVSLNSYSMODELID, t1.PSDEVSLNSYSMODELNAME, t1.PSDEVSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNSYSMODEL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="CURCNT", expression="t1.CURCNT", showorder=2), @DEDataQueryCodeExp(name="MAXCNT", expression="t1.MAXCNT", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSMODELID", expression="t1.PSDEVSLNSYSMODELID", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSMODELNAME", expression="t1.PSDEVSLNSYSMODELNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.PSDEVSLNSYSNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDevSlnSysModelDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnSysModelDefaultDQModel() {
        this.initAnnotation(PSDevSlnSysModelDefaultDQModel.class);
    }
}

