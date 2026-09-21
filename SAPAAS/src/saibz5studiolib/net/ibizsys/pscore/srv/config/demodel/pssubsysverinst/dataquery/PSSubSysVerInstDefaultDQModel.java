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
package net.ibizsys.pscore.srv.config.demodel.pssubsysverinst.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9727AD6C-BA24-4D51-B42B-0A2DAF66C6CE", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t11.`PSSUBSYSID`, t1.`PSSUBSYSVERID`, t1.`PSSUBSYSVERINSTID`, t1.`PSSUBSYSVERINSTNAME`, t11.`PSSUBSYSVERNAME`, t1.`PSSVRDOMAINID`, t21.`PSSVRDOMAINNAME`, t1.`PSSYSMODELINSTID`, t31.`PSSYSMODELINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSUBSYSVERINST` t1  LEFT JOIN T_SRFPSSUBSYSVER t11 ON t1.PSSUBSYSVERID = t11.PSSUBSYSVERID  LEFT JOIN T_SRFPSSVRDOMAIN t21 ON t1.PSSVRDOMAINID = t21.PSSVRDOMAINID  LEFT JOIN T_SRFPSSYSMODELINST t31 ON t1.PSSYSMODELINSTID = t31.PSSYSMODELINSTID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t11.`PSSUBSYSID`", showorder=3), @DEDataQueryCodeExp(name="PSSUBSYSVERID", expression="t1.`PSSUBSYSVERID`", showorder=4), @DEDataQueryCodeExp(name="PSSUBSYSVERINSTID", expression="t1.`PSSUBSYSVERINSTID`", showorder=5), @DEDataQueryCodeExp(name="PSSUBSYSVERINSTNAME", expression="t1.`PSSUBSYSVERINSTNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSUBSYSVERNAME", expression="t11.`PSSUBSYSVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.`PSSVRDOMAINID`", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t21.`PSSVRDOMAINNAME`", showorder=9), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.`PSSYSMODELINSTID`", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t31.`PSSYSMODELINSTNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t11.PSSUBSYSID, t1.PSSUBSYSVERID, t1.PSSUBSYSVERINSTID, t1.PSSUBSYSVERINSTNAME, t11.PSSUBSYSVERNAME, t1.PSSVRDOMAINID, t21.PSSVRDOMAINNAME, t1.PSSYSMODELINSTID, t31.PSSYSMODELINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSUBSYSVERINST t1  LEFT JOIN T_SRFPSSUBSYSVER t11 ON t1.PSSUBSYSVERID = t11.PSSUBSYSVERID  LEFT JOIN T_SRFPSSVRDOMAIN t21 ON t1.PSSVRDOMAINID = t21.PSSVRDOMAINID  LEFT JOIN T_SRFPSSYSMODELINST t31 ON t1.PSSYSMODELINSTID = t31.PSSYSMODELINSTID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t11.PSSUBSYSID", showorder=3), @DEDataQueryCodeExp(name="PSSUBSYSVERID", expression="t1.PSSUBSYSVERID", showorder=4), @DEDataQueryCodeExp(name="PSSUBSYSVERINSTID", expression="t1.PSSUBSYSVERINSTID", showorder=5), @DEDataQueryCodeExp(name="PSSUBSYSVERINSTNAME", expression="t1.PSSUBSYSVERINSTNAME", showorder=6), @DEDataQueryCodeExp(name="PSSUBSYSVERNAME", expression="t11.PSSUBSYSVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSVRDOMAINID", expression="t1.PSSVRDOMAINID", showorder=8), @DEDataQueryCodeExp(name="PSSVRDOMAINNAME", expression="t21.PSSVRDOMAINNAME", showorder=9), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.PSSYSMODELINSTID", showorder=10), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t31.PSSYSMODELINSTNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14)}, conds={})})
public class PSSubSysVerInstDefaultDQModel
extends DEDataQueryModelBase {
    public PSSubSysVerInstDefaultDQModel() {
        this.initAnnotation(PSSubSysVerInstDefaultDQModel.class);
    }
}

