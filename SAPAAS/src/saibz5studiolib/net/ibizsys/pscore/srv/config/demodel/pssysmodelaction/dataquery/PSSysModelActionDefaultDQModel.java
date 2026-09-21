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
package net.ibizsys.pscore.srv.config.demodel.pssysmodelaction.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FB23B2B0-1F9F-48CE-BC76-481A20BDA18C", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSSYSMODELACTIONID`, t1.`PSSYSMODELACTIONNAME`, t1.`PSSYSMODELINSTID`, t1.`PSSYSMODELINSTNAME`, t1.`SRCPSSYSMODELINSTID`, t1.`SRCPSSYSMODELINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSMODELACTION` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSSYSMODELACTIONID", expression="t1.`PSSYSMODELACTIONID`", showorder=2), @DEDataQueryCodeExp(name="PSSYSMODELACTIONNAME", expression="t1.`PSSYSMODELACTIONNAME`", showorder=3), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.`PSSYSMODELINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t1.`PSSYSMODELINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="SRCPSSYSMODELINSTID", expression="t1.`SRCPSSYSMODELINSTID`", showorder=6), @DEDataQueryCodeExp(name="SRCPSSYSMODELINSTNAME", expression="t1.`SRCPSSYSMODELINSTNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSSYSMODELACTIONID, t1.PSSYSMODELACTIONNAME, t1.PSSYSMODELINSTID, t1.PSSYSMODELINSTNAME, t1.SRCPSSYSMODELINSTID, t1.SRCPSSYSMODELINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSMODELACTION t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSSYSMODELACTIONID", expression="t1.PSSYSMODELACTIONID", showorder=2), @DEDataQueryCodeExp(name="PSSYSMODELACTIONNAME", expression="t1.PSSYSMODELACTIONNAME", showorder=3), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.PSSYSMODELINSTID", showorder=4), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t1.PSSYSMODELINSTNAME", showorder=5), @DEDataQueryCodeExp(name="SRCPSSYSMODELINSTID", expression="t1.SRCPSSYSMODELINSTID", showorder=6), @DEDataQueryCodeExp(name="SRCPSSYSMODELINSTNAME", expression="t1.SRCPSSYSMODELINSTNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSSysModelActionDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysModelActionDefaultDQModel() {
        this.initAnnotation(PSSysModelActionDefaultDQModel.class);
    }
}

