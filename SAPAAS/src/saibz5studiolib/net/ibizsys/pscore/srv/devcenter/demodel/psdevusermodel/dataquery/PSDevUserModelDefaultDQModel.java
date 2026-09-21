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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevusermodel.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FE3B0A7B-6245-4759-B8F0-59640D26CD22", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MARKFLAG`, t1.`MEMO`, t1.`PSDEVUSERMODELID`, t1.`PSDEVUSERMODELNAME`, t1.`PSMODELTYPE`, t1.`PSMODELTYPENAME`, t1.`PSOBJID`, t1.`PSOBJNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVUSERMODEL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MARKFLAG", expression="t1.`MARKFLAG`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEVUSERMODELID", expression="t1.`PSDEVUSERMODELID`", showorder=4), @DEDataQueryCodeExp(name="PSDEVUSERMODELNAME", expression="t1.`PSDEVUSERMODELNAME`", showorder=5), @DEDataQueryCodeExp(name="PSMODELTYPE", expression="t1.`PSMODELTYPE`", showorder=6), @DEDataQueryCodeExp(name="PSMODELTYPENAME", expression="t1.`PSMODELTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.`PSOBJID`", showorder=8), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.`PSOBJNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MARKFLAG, t1.MEMO, t1.PSDEVUSERMODELID, t1.PSDEVUSERMODELNAME, t1.PSMODELTYPE, t1.PSMODELTYPENAME, t1.PSOBJID, t1.PSOBJNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVUSERMODEL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MARKFLAG", expression="t1.MARKFLAG", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEVUSERMODELID", expression="t1.PSDEVUSERMODELID", showorder=4), @DEDataQueryCodeExp(name="PSDEVUSERMODELNAME", expression="t1.PSDEVUSERMODELNAME", showorder=5), @DEDataQueryCodeExp(name="PSMODELTYPE", expression="t1.PSMODELTYPE", showorder=6), @DEDataQueryCodeExp(name="PSMODELTYPENAME", expression="t1.PSMODELTYPENAME", showorder=7), @DEDataQueryCodeExp(name="PSOBJID", expression="t1.PSOBJID", showorder=8), @DEDataQueryCodeExp(name="PSOBJNAME", expression="t1.PSOBJNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSDevUserModelDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevUserModelDefaultDQModel() {
        this.initAnnotation(PSDevUserModelDefaultDQModel.class);
    }
}

