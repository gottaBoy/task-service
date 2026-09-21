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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysfile.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AC56B8E1-BEC0-4173-99EE-24409495E795", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNFILEID`, t11.`PSDEPSLNFILENAME`, t1.`PSDEPSLNSYSFILEID`, t1.`PSDEPSLNSYSFILENAME`, t1.`PSDEPSLNSYSID`, t21.`PSDEPSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNSYSFILE` t1  LEFT JOIN T_SRFPSDEPSLNFILE t11 ON t1.PSDEPSLNFILEID = t11.PSDEPSLNFILEID  LEFT JOIN T_SRFPSDEPSLNSYS t21 ON t1.PSDEPSLNSYSID = t21.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNFILEID", expression="t1.`PSDEPSLNFILEID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNFILENAME", expression="t11.`PSDEPSLNFILENAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNSYSFILEID", expression="t1.`PSDEPSLNSYSFILEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNSYSFILENAME", expression="t1.`PSDEPSLNSYSFILENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t21.`PSDEPSLNSYSNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNFILEID, t11.PSDEPSLNFILENAME, t1.PSDEPSLNSYSFILEID, t1.PSDEPSLNSYSFILENAME, t1.PSDEPSLNSYSID, t21.PSDEPSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNSYSFILE t1  LEFT JOIN T_SRFPSDEPSLNFILE t11 ON t1.PSDEPSLNFILEID = t11.PSDEPSLNFILEID  LEFT JOIN T_SRFPSDEPSLNSYS t21 ON t1.PSDEPSLNSYSID = t21.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNFILEID", expression="t1.PSDEPSLNFILEID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNFILENAME", expression="t11.PSDEPSLNFILENAME", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNSYSFILEID", expression="t1.PSDEPSLNSYSFILEID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNSYSFILENAME", expression="t1.PSDEPSLNSYSFILENAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t21.PSDEPSLNSYSNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDepSlnSysFileDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnSysFileDefaultDQModel() {
        this.initAnnotation(PSDepSlnSysFileDefaultDQModel.class);
    }
}

