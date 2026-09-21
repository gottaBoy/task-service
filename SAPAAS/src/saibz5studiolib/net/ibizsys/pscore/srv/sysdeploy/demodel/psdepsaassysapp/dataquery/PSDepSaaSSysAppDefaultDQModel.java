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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsaassysapp.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C24EAF6C-571F-4463-BE6C-F3C18BF2B946", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEPSAASSYSAPPID`, t1.`PSDEPSAASSYSAPPNAME`, t1.`PSSAASSYSAPPID`, t1.`PSSAASSYSAPPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSAASSYSAPP` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEPSAASSYSAPPID", expression="t1.`PSDEPSAASSYSAPPID`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSAASSYSAPPNAME", expression="t1.`PSDEPSAASSYSAPPNAME`", showorder=3), @DEDataQueryCodeExp(name="PSSAASSYSAPPID", expression="t1.`PSSAASSYSAPPID`", showorder=4), @DEDataQueryCodeExp(name="PSSAASSYSAPPNAME", expression="t1.`PSSAASSYSAPPNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEPSAASSYSAPPID, t1.PSDEPSAASSYSAPPNAME, t1.PSSAASSYSAPPID, t1.PSSAASSYSAPPNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSAASSYSAPP t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEPSAASSYSAPPID", expression="t1.PSDEPSAASSYSAPPID", showorder=2), @DEDataQueryCodeExp(name="PSDEPSAASSYSAPPNAME", expression="t1.PSDEPSAASSYSAPPNAME", showorder=3), @DEDataQueryCodeExp(name="PSSAASSYSAPPID", expression="t1.PSSAASSYSAPPID", showorder=4), @DEDataQueryCodeExp(name="PSSAASSYSAPPNAME", expression="t1.PSSAASSYSAPPNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSDepSaaSSysAppDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSaaSSysAppDefaultDQModel() {
        this.initAnnotation(PSDepSaaSSysAppDefaultDQModel.class);
    }
}

