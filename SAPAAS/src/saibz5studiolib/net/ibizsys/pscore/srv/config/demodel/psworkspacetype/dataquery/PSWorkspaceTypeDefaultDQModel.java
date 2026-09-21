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
package net.ibizsys.pscore.srv.config.demodel.psworkspacetype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="93803D40-33A7-4FB5-B9CC-8BEA88B81337", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`EXP`, t1.`EXP2`, t1.`MAXDEVUSER`, t1.`MEMO`, t1.`PSMODELLIMITS`, t1.`PSWORKSPACETYPEID`, t1.`PSWORKSPACETYPENAME`, t1.`TYPEPARAMS`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2`, t1.`VALIDFLAG`, t1.`WORKSPACEMODE`, t1.`WORKSPACEUSAGE` FROM `T_SRFPSWORKSPACETYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="EXP", expression="t1.`EXP`", showorder=2), @DEDataQueryCodeExp(name="EXP2", expression="t1.`EXP2`", showorder=3), @DEDataQueryCodeExp(name="MAXDEVUSER", expression="t1.`MAXDEVUSER`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSMODELLIMITS", expression="t1.`PSMODELLIMITS`", showorder=6), @DEDataQueryCodeExp(name="PSWORKSPACETYPEID", expression="t1.`PSWORKSPACETYPEID`", showorder=7), @DEDataQueryCodeExp(name="PSWORKSPACETYPENAME", expression="t1.`PSWORKSPACETYPENAME`", showorder=8), @DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.`TYPEPARAMS`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14), @DEDataQueryCodeExp(name="WORKSPACEMODE", expression="t1.`WORKSPACEMODE`", showorder=15), @DEDataQueryCodeExp(name="WORKSPACEUSAGE", expression="t1.`WORKSPACEUSAGE`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.EXP, t1.EXP2, t1.MAXDEVUSER, t1.MEMO, t1.PSMODELLIMITS, t1.PSWORKSPACETYPEID, t1.PSWORKSPACETYPENAME, t1.TYPEPARAMS, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2, t1.VALIDFLAG, t1.WORKSPACEMODE, t1.WORKSPACEUSAGE FROM T_SRFPSWORKSPACETYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="EXP", expression="t1.EXP", showorder=2), @DEDataQueryCodeExp(name="EXP2", expression="t1.EXP2", showorder=3), @DEDataQueryCodeExp(name="MAXDEVUSER", expression="t1.MAXDEVUSER", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSMODELLIMITS", expression="t1.PSMODELLIMITS", showorder=6), @DEDataQueryCodeExp(name="PSWORKSPACETYPEID", expression="t1.PSWORKSPACETYPEID", showorder=7), @DEDataQueryCodeExp(name="PSWORKSPACETYPENAME", expression="t1.PSWORKSPACETYPENAME", showorder=8), @DEDataQueryCodeExp(name="TYPEPARAMS", expression="t1.TYPEPARAMS", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14), @DEDataQueryCodeExp(name="WORKSPACEMODE", expression="t1.WORKSPACEMODE", showorder=15), @DEDataQueryCodeExp(name="WORKSPACEUSAGE", expression="t1.WORKSPACEUSAGE", showorder=16)}, conds={})})
public class PSWorkspaceTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSWorkspaceTypeDefaultDQModel() {
        this.initAnnotation(PSWorkspaceTypeDefaultDQModel.class);
    }
}

