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
package net.ibizsys.pscore.srv.config.demodel.psdevenv.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="5821E420-5A7D-4D2F-9911-7B23791A62A2", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEVENVID`, t1.`PSDEVENVNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVENV` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEVENVID", expression="t1.`PSDEVENVID`", showorder=2), @DEDataQueryCodeExp(name="PSDEVENVNAME", expression="t1.`PSDEVENVNAME`", showorder=3), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=4), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=5)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEVENVID, t1.PSDEVENVNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVENV t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEVENVID", expression="t1.PSDEVENVID", showorder=2), @DEDataQueryCodeExp(name="PSDEVENVNAME", expression="t1.PSDEVENVNAME", showorder=3), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=4), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=5)}, conds={})})
public class PSDevEnvDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevEnvDefaultDQModel() {
        this.initAnnotation(PSDevEnvDefaultDQModel.class);
    }
}

