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
package net.ibizsys.pscore.srv.config.demodel.psbackservice.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F50EF4EB-C2E2-41F4-A300-F3FBD7E70C05", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSBACKSERVICEID`, t1.`PSBACKSERVICENAME`, t1.`SERVICEPARAMS`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSBACKSERVICE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="SERVICEOBJ", expression="t1.`SERVICEOBJ`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSBACKSERVICEID", expression="t1.`PSBACKSERVICEID`", showorder=3), @DEDataQueryCodeExp(name="PSBACKSERVICENAME", expression="t1.`PSBACKSERVICENAME`", showorder=4), @DEDataQueryCodeExp(name="SERVICEPARAMS", expression="t1.`SERVICEPARAMS`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSBACKSERVICEID, t1.PSBACKSERVICENAME, t1.SERVICEPARAMS, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSBACKSERVICE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="SERVICEOBJ", expression="t1.SERVICEOBJ", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSBACKSERVICEID", expression="t1.PSBACKSERVICEID", showorder=3), @DEDataQueryCodeExp(name="PSBACKSERVICENAME", expression="t1.PSBACKSERVICENAME", showorder=4), @DEDataQueryCodeExp(name="SERVICEPARAMS", expression="t1.SERVICEPARAMS", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSBackServiceDefaultDQModel
extends DEDataQueryModelBase {
    public PSBackServiceDefaultDQModel() {
        this.initAnnotation(PSBackServiceDefaultDQModel.class);
    }
}

