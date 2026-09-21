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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysapp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6D32921E-B521-4EBC-AE4A-D4EA4343BEA3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEPSLNSYSAPPID`, t1.`PSDEPSLNSYSAPPNAME`, t1.`PSDEPSLNSYSID`, t11.`PSDEPSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNSYSAPP` t1  LEFT JOIN `T_SRFPSDEPSLNSYS` t11 ON t1.`PSDEPSLNSYSID` = t11.`PSDEPSLNSYSID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEPSLNSYSAPPID", expression="t1.`PSDEPSLNSYSAPPID`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNSYSAPPNAME", expression="t1.`PSDEPSLNSYSAPPNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t11.`PSDEPSLNSYSNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEPSLNSYSAPPID, t1.PSDEPSLNSYSAPPNAME, t1.PSDEPSLNSYSID, t11.PSDEPSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNSYSAPP t1  LEFT JOIN T_SRFPSDEPSLNSYS t11 ON t1.PSDEPSLNSYSID = t11.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEPSLNSYSAPPID", expression="t1.PSDEPSLNSYSAPPID", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNSYSAPPNAME", expression="t1.PSDEPSLNSYSAPPNAME", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t11.PSDEPSLNSYSNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSDepSlnSysAppDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnSysAppDefaultDQModel() {
        this.initAnnotation(PSDepSlnSysAppDefaultDQModel.class);
    }
}

