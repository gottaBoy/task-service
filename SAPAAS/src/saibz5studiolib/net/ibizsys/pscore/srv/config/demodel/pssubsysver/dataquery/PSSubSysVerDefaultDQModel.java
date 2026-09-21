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
package net.ibizsys.pscore.srv.config.demodel.pssubsysver.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2620896B-0460-40AE-999D-73442A202B88", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CLSPKGPARAMS`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSUBSYSID`, t11.`PSSUBSYSNAME`, t1.`PSSUBSYSVERID`, t1.`PSSUBSYSVERNAME`, t1.`PSSYSMODELINSTID`, t1.`PSSYSMODELINSTNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG`, t1.`VERSION` FROM `T_SRFPSSUBSYSVER` t1  LEFT JOIN T_SRFPSSUBSYS t11 ON t1.PSSUBSYSID = t11.PSSUBSYSID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="VERDETAIL", expression="t1.`VERDETAIL`", showorder=-1), @DEDataQueryCodeExp(name="VERLOG", expression="t1.`VERLOG`", showorder=-1), @DEDataQueryCodeExp(name="CLSPKGPARAMS", expression="t1.`CLSPKGPARAMS`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.`PSSUBSYSID`", showorder=4), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t11.`PSSUBSYSNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSUBSYSVERID", expression="t1.`PSSUBSYSVERID`", showorder=6), @DEDataQueryCodeExp(name="PSSUBSYSVERNAME", expression="t1.`PSSUBSYSVERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.`PSSYSMODELINSTID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t1.`PSSYSMODELINSTNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12), @DEDataQueryCodeExp(name="VERSION", expression="t1.`VERSION`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CLSPKGPARAMS, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSUBSYSID, t11.PSSUBSYSNAME, t1.PSSUBSYSVERID, t1.PSSUBSYSVERNAME, t1.PSSYSMODELINSTID, t1.PSSYSMODELINSTNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG, t1.VERSION FROM T_SRFPSSUBSYSVER t1  LEFT JOIN T_SRFPSSUBSYS t11 ON t1.PSSUBSYSID = t11.PSSUBSYSID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="VERDETAIL", expression="t1.VERDETAIL", showorder=-1), @DEDataQueryCodeExp(name="VERLOG", expression="t1.VERLOG", showorder=-1), @DEDataQueryCodeExp(name="CLSPKGPARAMS", expression="t1.CLSPKGPARAMS", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSSUBSYSID", expression="t1.PSSUBSYSID", showorder=4), @DEDataQueryCodeExp(name="PSSUBSYSNAME", expression="t11.PSSUBSYSNAME", showorder=5), @DEDataQueryCodeExp(name="PSSUBSYSVERID", expression="t1.PSSUBSYSVERID", showorder=6), @DEDataQueryCodeExp(name="PSSUBSYSVERNAME", expression="t1.PSSUBSYSVERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.PSSYSMODELINSTID", showorder=8), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t1.PSSYSMODELINSTNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12), @DEDataQueryCodeExp(name="VERSION", expression="t1.VERSION", showorder=13)}, conds={})})
public class PSSubSysVerDefaultDQModel
extends DEDataQueryModelBase {
    public PSSubSysVerDefaultDQModel() {
        this.initAnnotation(PSSubSysVerDefaultDQModel.class);
    }
}

