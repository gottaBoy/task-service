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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsaassys.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="512C7E3F-6A5D-4120-A63C-8041158C5FCE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`FROMDCID`, t1.`FROMDCNAME`, t1.`PSDEPSAASSYSID`, t1.`PSDEPSAASSYSNAME`, t1.`PSSAASSYSID`, t1.`PSSAASSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSAASSYS` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="FROMDCID", expression="t1.`FROMDCID`", showorder=2), @DEDataQueryCodeExp(name="FROMDCNAME", expression="t1.`FROMDCNAME`", showorder=3), @DEDataQueryCodeExp(name="PSDEPSAASSYSID", expression="t1.`PSDEPSAASSYSID`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSAASSYSNAME", expression="t1.`PSDEPSAASSYSNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSAASSYSID", expression="t1.`PSSAASSYSID`", showorder=6), @DEDataQueryCodeExp(name="PSSAASSYSNAME", expression="t1.`PSSAASSYSNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.FROMDCID, t1.FROMDCNAME, t1.PSDEPSAASSYSID, t1.PSDEPSAASSYSNAME, t1.PSSAASSYSID, t1.PSSAASSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSAASSYS t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="FROMDCID", expression="t1.FROMDCID", showorder=2), @DEDataQueryCodeExp(name="FROMDCNAME", expression="t1.FROMDCNAME", showorder=3), @DEDataQueryCodeExp(name="PSDEPSAASSYSID", expression="t1.PSDEPSAASSYSID", showorder=4), @DEDataQueryCodeExp(name="PSDEPSAASSYSNAME", expression="t1.PSDEPSAASSYSNAME", showorder=5), @DEDataQueryCodeExp(name="PSSAASSYSID", expression="t1.PSSAASSYSID", showorder=6), @DEDataQueryCodeExp(name="PSSAASSYSNAME", expression="t1.PSSAASSYSNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSDepSaaSSysDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSaaSSysDefaultDQModel() {
        this.initAnnotation(PSDepSaaSSysDefaultDQModel.class);
    }
}

