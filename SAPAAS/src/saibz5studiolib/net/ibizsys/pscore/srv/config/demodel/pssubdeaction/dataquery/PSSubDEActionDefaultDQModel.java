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
package net.ibizsys.pscore.srv.config.demodel.pssubdeaction.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="BC7AF7B9-A27A-4666-A900-2A2AB6B5C18E", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSDEACTIONID`, t1.`PSSUBDEACTIONID`, t1.`PSSUBDEACTIONNAME`, t1.`PSSUBDEID`, t1.`PSSUBDENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSUBDEACTION` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSDEACTIONID", expression="t1.`PSDEACTIONID`", showorder=5), @DEDataQueryCodeExp(name="PSSUBDEACTIONID", expression="t1.`PSSUBDEACTIONID`", showorder=6), @DEDataQueryCodeExp(name="PSSUBDEACTIONNAME", expression="t1.`PSSUBDEACTIONNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSUBDEID", expression="t1.`PSSUBDEID`", showorder=8), @DEDataQueryCodeExp(name="PSSUBDENAME", expression="t1.`PSSUBDENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSDEACTIONID, t1.PSSUBDEACTIONID, t1.PSSUBDEACTIONNAME, t1.PSSUBDEID, t1.PSSUBDENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSUBDEACTION t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSDEACTIONID", expression="t1.PSDEACTIONID", showorder=5), @DEDataQueryCodeExp(name="PSSUBDEACTIONID", expression="t1.PSSUBDEACTIONID", showorder=6), @DEDataQueryCodeExp(name="PSSUBDEACTIONNAME", expression="t1.PSSUBDEACTIONNAME", showorder=7), @DEDataQueryCodeExp(name="PSSUBDEID", expression="t1.PSSUBDEID", showorder=8), @DEDataQueryCodeExp(name="PSSUBDENAME", expression="t1.PSSUBDENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11)}, conds={})})
public class PSSubDEActionDefaultDQModel
extends DEDataQueryModelBase {
    public PSSubDEActionDefaultDQModel() {
        this.initAnnotation(PSSubDEActionDefaultDQModel.class);
    }
}

