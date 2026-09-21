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
package net.ibizsys.pscore.srv.config.demodel.pscodename.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="BDB125C5-A972-4078-8241-D1D6B67914BF", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSCODENAMEID`, t1.`PSCODENAMENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCODENAME` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSCODENAMEID", expression="t1.`PSCODENAMEID`", showorder=2), @DEDataQueryCodeExp(name="PSCODENAMENAME", expression="t1.`PSCODENAMENAME`", showorder=3), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=4), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=5)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSCODENAMEID, t1.PSCODENAMENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCODENAME t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSCODENAMEID", expression="t1.PSCODENAMEID", showorder=2), @DEDataQueryCodeExp(name="PSCODENAMENAME", expression="t1.PSCODENAMENAME", showorder=3), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=4), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=5)}, conds={})})
public class PSCodeNameDefaultDQModel
extends DEDataQueryModelBase {
    public PSCodeNameDefaultDQModel() {
        this.initAnnotation(PSCodeNameDefaultDQModel.class);
    }
}

