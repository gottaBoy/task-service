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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnsysbd.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="ABF1DE52-AA39-475A-93FC-9427C3BB002B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEPSLNBDINSTID`, t11.`PSDEPSLNBDINSTNAME`, t1.`PSDEPSLNSYSBDID`, t1.`PSDEPSLNSYSBDNAME`, t1.`PSDEPSLNSYSID`, t21.`PSDEPSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSLNSYSBD` t1  LEFT JOIN T_SRFPSDEPSLNBDINST t11 ON t1.PSDEPSLNBDINSTID = t11.PSDEPSLNBDINSTID  LEFT JOIN T_SRFPSDEPSLNSYS t21 ON t1.PSDEPSLNSYSID = t21.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNBDINSTID", expression="t1.`PSDEPSLNBDINSTID`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNBDINSTNAME", expression="t11.`PSDEPSLNBDINSTNAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNSYSBDID", expression="t1.`PSDEPSLNSYSBDID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNSYSBDNAME", expression="t1.`PSDEPSLNSYSBDNAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.`PSDEPSLNSYSID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t21.`PSDEPSLNSYSNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEPSLNBDINSTID, t11.PSDEPSLNBDINSTNAME, t1.PSDEPSLNSYSBDID, t1.PSDEPSLNSYSBDNAME, t1.PSDEPSLNSYSID, t21.PSDEPSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSLNSYSBD t1  LEFT JOIN T_SRFPSDEPSLNBDINST t11 ON t1.PSDEPSLNBDINSTID = t11.PSDEPSLNBDINSTID  LEFT JOIN T_SRFPSDEPSLNSYS t21 ON t1.PSDEPSLNSYSID = t21.PSDEPSLNSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDEPSLNBDINSTID", expression="t1.PSDEPSLNBDINSTID", showorder=3), @DEDataQueryCodeExp(name="PSDEPSLNBDINSTNAME", expression="t11.PSDEPSLNBDINSTNAME", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNSYSBDID", expression="t1.PSDEPSLNSYSBDID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNSYSBDNAME", expression="t1.PSDEPSLNSYSBDNAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNSYSID", expression="t1.PSDEPSLNSYSID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNSYSNAME", expression="t21.PSDEPSLNSYSNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSDepSlnSysBDDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnSysBDDefaultDQModel() {
        this.initAnnotation(PSDepSlnSysBDDefaultDQModel.class);
    }
}

