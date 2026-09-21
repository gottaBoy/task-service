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
package net.ibizsys.pscore.srv.paasmgr.demodel.psdcsyncagent.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="551B30E4-E65D-4DFC-B743-8C4077A70E82", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`AGENTOBJ`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCSYNCAGENTID`, t1.`PSDCSYNCAGENTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDCSYNCAGENT` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="AGENTPARAMS", expression="t1.`AGENTPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="AGENTOBJ", expression="t1.`AGENTOBJ`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDCSYNCAGENTID", expression="t1.`PSDCSYNCAGENTID`", showorder=4), @DEDataQueryCodeExp(name="PSDCSYNCAGENTNAME", expression="t1.`PSDCSYNCAGENTNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.AGENTOBJ, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCSYNCAGENTID, t1.PSDCSYNCAGENTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDCSYNCAGENT t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="AGENTPARAMS", expression="t1.AGENTPARAMS", showorder=-1), @DEDataQueryCodeExp(name="AGENTOBJ", expression="t1.AGENTOBJ", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDCSYNCAGENTID", expression="t1.PSDCSYNCAGENTID", showorder=4), @DEDataQueryCodeExp(name="PSDCSYNCAGENTNAME", expression="t1.PSDCSYNCAGENTNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=8)}, conds={})})
public class PSDCSyncAgentDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCSyncAgentDefaultDQModel() {
        this.initAnnotation(PSDCSyncAgentDefaultDQModel.class);
    }
}

