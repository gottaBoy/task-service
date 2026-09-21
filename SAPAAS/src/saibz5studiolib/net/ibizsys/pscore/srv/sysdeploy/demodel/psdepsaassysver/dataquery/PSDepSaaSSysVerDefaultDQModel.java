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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepsaassysver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="B3F92427-5E54-4003-A6CA-48B2325D5153", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSDEPSAASSYSVERID`, t1.`PSDEPSAASSYSVERNAME`, t1.`PSSAASSYSVERID`, t1.`PSSAASSYSVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEPSAASSYSVER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSDEPSAASSYSVERID", expression="t1.`PSDEPSAASSYSVERID`", showorder=2), @DEDataQueryCodeExp(name="PSDEPSAASSYSVERNAME", expression="t1.`PSDEPSAASSYSVERNAME`", showorder=3), @DEDataQueryCodeExp(name="PSSAASSYSVERID", expression="t1.`PSSAASSYSVERID`", showorder=4), @DEDataQueryCodeExp(name="PSSAASSYSVERNAME", expression="t1.`PSSAASSYSVERNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSDEPSAASSYSVERID, t1.PSDEPSAASSYSVERNAME, t1.PSSAASSYSVERID, t1.PSSAASSYSVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEPSAASSYSVER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSDEPSAASSYSVERID", expression="t1.PSDEPSAASSYSVERID", showorder=2), @DEDataQueryCodeExp(name="PSDEPSAASSYSVERNAME", expression="t1.PSDEPSAASSYSVERNAME", showorder=3), @DEDataQueryCodeExp(name="PSSAASSYSVERID", expression="t1.PSSAASSYSVERID", showorder=4), @DEDataQueryCodeExp(name="PSSAASSYSVERNAME", expression="t1.PSSAASSYSVERNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSDepSaaSSysVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSaaSSysVerDefaultDQModel() {
        this.initAnnotation(PSDepSaaSSysVerDefaultDQModel.class);
    }
}

