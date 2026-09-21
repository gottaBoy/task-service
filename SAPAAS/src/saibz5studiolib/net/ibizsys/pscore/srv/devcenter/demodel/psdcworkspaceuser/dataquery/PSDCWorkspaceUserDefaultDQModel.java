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
package net.ibizsys.pscore.srv.devcenter.demodel.psdcworkspaceuser.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="506EBBBF-7668-4171-A576-2034796F34C0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ACCESSTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCWORKSPACEID`, t11.`PSDCWORKSPACENAME`, t1.`PSDCWORKSPACEUSERID`, t1.`PSDCWORKSPACEUSERNAME`, t1.`PSDEVUSERID`, t1.`PSDEVUSERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERTAG`, t1.`USERTAG2` FROM `T_SRFPSDCWORKSPACEUSER` t1  LEFT JOIN T_SRFPSDCWORKSPACE t11 ON t1.PSDCWORKSPACEID = t11.PSDCWORKSPACEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ACCESSTIME", expression="t1.`ACCESSTIME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDCWORKSPACEID", expression="t1.`PSDCWORKSPACEID`", showorder=4), @DEDataQueryCodeExp(name="PSDCWORKSPACENAME", expression="t11.`PSDCWORKSPACENAME`", showorder=5), @DEDataQueryCodeExp(name="PSDCWORKSPACEUSERID", expression="t1.`PSDCWORKSPACEUSERID`", showorder=6), @DEDataQueryCodeExp(name="PSDCWORKSPACEUSERNAME", expression="t1.`PSDCWORKSPACEUSERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.`PSDEVUSERID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.`PSDEVUSERNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ACCESSTIME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCWORKSPACEID, t11.PSDCWORKSPACENAME, t1.PSDCWORKSPACEUSERID, t1.PSDCWORKSPACEUSERNAME, t1.PSDEVUSERID, t1.PSDEVUSERNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERTAG, t1.USERTAG2 FROM T_SRFPSDCWORKSPACEUSER t1  LEFT JOIN T_SRFPSDCWORKSPACE t11 ON t1.PSDCWORKSPACEID = t11.PSDCWORKSPACEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ACCESSTIME", expression="t1.ACCESSTIME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDCWORKSPACEID", expression="t1.PSDCWORKSPACEID", showorder=4), @DEDataQueryCodeExp(name="PSDCWORKSPACENAME", expression="t11.PSDCWORKSPACENAME", showorder=5), @DEDataQueryCodeExp(name="PSDCWORKSPACEUSERID", expression="t1.PSDCWORKSPACEUSERID", showorder=6), @DEDataQueryCodeExp(name="PSDCWORKSPACEUSERNAME", expression="t1.PSDCWORKSPACEUSERNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVUSERID", expression="t1.PSDEVUSERID", showorder=8), @DEDataQueryCodeExp(name="PSDEVUSERNAME", expression="t1.PSDEVUSERNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=12), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=13)}, conds={})})
public class PSDCWorkspaceUserDefaultDQModel
extends DEDataQueryModelBase {
    public PSDCWorkspaceUserDefaultDQModel() {
        this.initAnnotation(PSDCWorkspaceUserDefaultDQModel.class);
    }
}

