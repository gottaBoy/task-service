/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.paasmgr.demodel.psdatasyncagenttype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="8B3DE1C0-0754-4475-90E5-92949BFD224C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLE`, t1.`MEMO`, t1.`PSDATASYNCAGENTTYPEID`, t1.`PSDATASYNCAGENTTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDATASYNCAGENTTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.`BASECLSPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.`ENABLE`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDATASYNCAGENTTYPEID", expression="t1.`PSDATASYNCAGENTTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSDATASYNCAGENTTYPENAME", expression="t1.`PSDATASYNCAGENTTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ENABLE, t1.MEMO, t1.PSDATASYNCAGENTTYPEID, t1.PSDATASYNCAGENTTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDATASYNCAGENTTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.BASECLSPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ENABLE", expression="t1.ENABLE", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDATASYNCAGENTTYPEID", expression="t1.PSDATASYNCAGENTTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSDATASYNCAGENTTYPENAME", expression="t1.PSDATASYNCAGENTTYPENAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={@DEDataQueryCodeCond(condition="t1.ENABLE = 1")})})
public class PSDataSyncAgentTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSDataSyncAgentTypeDefaultDQModel() {
        this.initAnnotation(PSDataSyncAgentTypeDefaultDQModel.class);
    }
}

