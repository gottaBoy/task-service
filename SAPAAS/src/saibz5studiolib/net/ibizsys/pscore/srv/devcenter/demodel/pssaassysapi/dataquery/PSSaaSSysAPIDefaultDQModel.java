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
package net.ibizsys.pscore.srv.devcenter.demodel.pssaassysapi.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="551EC2A4-7608-48F5-9A2F-495E38B9D477", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSSAASSYSAPIID`, t1.`PSSAASSYSAPINAME`, t1.`PSSAASSYSVERID`, t11.`PSSAASSYSVERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSAASSYSAPI` t1  LEFT JOIN T_SRFPSSAASSYSVER t11 ON t1.PSSAASSYSVERID = t11.PSSAASSYSVERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSSAASSYSAPIID", expression="t1.`PSSAASSYSAPIID`", showorder=2), @DEDataQueryCodeExp(name="PSSAASSYSAPINAME", expression="t1.`PSSAASSYSAPINAME`", showorder=3), @DEDataQueryCodeExp(name="PSSAASSYSVERID", expression="t1.`PSSAASSYSVERID`", showorder=4), @DEDataQueryCodeExp(name="PSSAASSYSVERNAME", expression="t11.`PSSAASSYSVERNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSSAASSYSAPIID, t1.PSSAASSYSAPINAME, t1.PSSAASSYSVERID, t11.PSSAASSYSVERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSAASSYSAPI t1  LEFT JOIN T_SRFPSSAASSYSVER t11 ON t1.PSSAASSYSVERID = t11.PSSAASSYSVERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSSAASSYSAPIID", expression="t1.PSSAASSYSAPIID", showorder=2), @DEDataQueryCodeExp(name="PSSAASSYSAPINAME", expression="t1.PSSAASSYSAPINAME", showorder=3), @DEDataQueryCodeExp(name="PSSAASSYSVERID", expression="t1.PSSAASSYSVERID", showorder=4), @DEDataQueryCodeExp(name="PSSAASSYSVERNAME", expression="t11.PSSAASSYSVERNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSSaaSSysAPIDefaultDQModel
extends DEDataQueryModelBase {
    public PSSaaSSysAPIDefaultDQModel() {
        this.initAnnotation(PSSaaSSysAPIDefaultDQModel.class);
    }
}

