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
package net.ibizsys.pscore.srv.sysdesign.demodel.psdevslnsyswsgit.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AB2CA4B4-C6FF-4950-A46A-775FEF74A8BD", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`GITPASSWORD`, t1.`GITPATH`, t1.`GITUSERNAME`, t1.`MEMO`, t1.`PSDCWORKSHOPSERVERID`, t11.`PSDCWORKSHOPSERVERNAME`, t1.`PSDEVSLNSYSID`, t21.`PSDEVSLNSYSNAME`, t1.`PSDEVSLNSYSWSGITID`, t1.`PSDEVSLNSYSWSGITNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNSYSWSGIT` t1  LEFT JOIN T_SRFPSDCWORKSHOPSERVER t11 ON t1.PSDCWORKSHOPSERVERID = t11.PSDCWORKSHOPSERVERID  LEFT JOIN T_SRFPSDEVSLNSYS t21 ON t1.PSDEVSLNSYSID = t21.PSDEVSLNSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="GITPASSWORD", expression="t1.`GITPASSWORD`", showorder=2), @DEDataQueryCodeExp(name="GITPATH", expression="t1.`GITPATH`", showorder=3), @DEDataQueryCodeExp(name="GITUSERNAME", expression="t1.`GITUSERNAME`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSDCWORKSHOPSERVERID", expression="t1.`PSDCWORKSHOPSERVERID`", showorder=6), @DEDataQueryCodeExp(name="PSDCWORKSHOPSERVERNAME", expression="t11.`PSDCWORKSHOPSERVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t21.`PSDEVSLNSYSNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNSYSWSGITID", expression="t1.`PSDEVSLNSYSWSGITID`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNSYSWSGITNAME", expression="t1.`PSDEVSLNSYSWSGITNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.GITPASSWORD, t1.GITPATH, t1.GITUSERNAME, t1.MEMO, t1.PSDCWORKSHOPSERVERID, t11.PSDCWORKSHOPSERVERNAME, t1.PSDEVSLNSYSID, t21.PSDEVSLNSYSNAME, t1.PSDEVSLNSYSWSGITID, t1.PSDEVSLNSYSWSGITNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNSYSWSGIT t1  LEFT JOIN T_SRFPSDCWORKSHOPSERVER t11 ON t1.PSDCWORKSHOPSERVERID = t11.PSDCWORKSHOPSERVERID  LEFT JOIN T_SRFPSDEVSLNSYS t21 ON t1.PSDEVSLNSYSID = t21.PSDEVSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="GITPASSWORD", expression="t1.GITPASSWORD", showorder=2), @DEDataQueryCodeExp(name="GITPATH", expression="t1.GITPATH", showorder=3), @DEDataQueryCodeExp(name="GITUSERNAME", expression="t1.GITUSERNAME", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSDCWORKSHOPSERVERID", expression="t1.PSDCWORKSHOPSERVERID", showorder=6), @DEDataQueryCodeExp(name="PSDCWORKSHOPSERVERNAME", expression="t11.PSDCWORKSHOPSERVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t21.PSDEVSLNSYSNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNSYSWSGITID", expression="t1.PSDEVSLNSYSWSGITID", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNSYSWSGITNAME", expression="t1.PSDEVSLNSYSWSGITNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSDevSlnSysWSGitDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnSysWSGitDefaultDQModel() {
        this.initAnnotation(PSDevSlnSysWSGitDefaultDQModel.class);
    }
}

