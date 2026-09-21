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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnsysgd.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="97FEC74A-8B6A-4A23-A92F-5944629B5187", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEVSLNSYSGDID`, t1.`PSDEVSLNSYSGDNAME`, t1.`PSDEVSLNSYSGROUPID`, t11.`PSDEVSLNSYSGROUPNAME`, t1.`PSDEVSLNSYSID`, t21.`PSDEVSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNSYSGD` t1  LEFT JOIN T_SRFPSDEVSLNSYSGROUP t11 ON t1.PSDEVSLNSYSGROUPID = t11.PSDEVSLNSYSGROUPID  LEFT JOIN T_SRFPSDEVSLNSYS t21 ON t1.PSDEVSLNSYSID = t21.PSDEVSLNSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNSYSGDID", expression="t1.`PSDEVSLNSYSGDID`", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNSYSGDNAME", expression="t1.`PSDEVSLNSYSGDNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSGROUPID", expression="t1.`PSDEVSLNSYSGROUPID`", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSGROUPNAME", expression="t11.`PSDEVSLNSYSGROUPNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t21.`PSDEVSLNSYSNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEVSLNSYSGDID, t1.PSDEVSLNSYSGDNAME, t1.PSDEVSLNSYSGROUPID, t11.PSDEVSLNSYSGROUPNAME, t1.PSDEVSLNSYSID, t21.PSDEVSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNSYSGD t1  LEFT JOIN T_SRFPSDEVSLNSYSGROUP t11 ON t1.PSDEVSLNSYSGROUPID = t11.PSDEVSLNSYSGROUPID  LEFT JOIN T_SRFPSDEVSLNSYS t21 ON t1.PSDEVSLNSYSID = t21.PSDEVSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEVSLNSYSGDID", expression="t1.PSDEVSLNSYSGDID", showorder=3), @DEDataQueryCodeExp(name="PSDEVSLNSYSGDNAME", expression="t1.PSDEVSLNSYSGDNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEVSLNSYSGROUPID", expression="t1.PSDEVSLNSYSGROUPID", showorder=5), @DEDataQueryCodeExp(name="PSDEVSLNSYSGROUPNAME", expression="t11.PSDEVSLNSYSGROUPNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t21.PSDEVSLNSYSNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDevSlnSysGDDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnSysGDDefaultDQModel() {
        this.initAnnotation(PSDevSlnSysGDDefaultDQModel.class);
    }
}

