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
package net.ibizsys.pscore.srv.config.demodel.psvtstyle.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="CCA82F30-DC89-42A3-8EA2-9690A8C4ADD1", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSVIEWTYPEID`, t11.`PSVIEWTYPENAME`, t1.`PSVTSTYLEID`, t1.`PSVTSTYLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSVTSTYLE` t1  LEFT JOIN T_SRFPSVIEWTYPE t11 ON t1.PSVIEWTYPEID = t11.PSVIEWTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.`PSVIEWTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t11.`PSVIEWTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSVTSTYLEID", expression="t1.`PSVTSTYLEID`", showorder=6), @DEDataQueryCodeExp(name="PSVTSTYLENAME", expression="t1.`PSVTSTYLENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSVIEWTYPEID, t11.PSVIEWTYPENAME, t1.PSVTSTYLEID, t1.PSVTSTYLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSVTSTYLE t1  LEFT JOIN T_SRFPSVIEWTYPE t11 ON t1.PSVIEWTYPEID = t11.PSVIEWTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.PSVIEWTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t11.PSVIEWTYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSVTSTYLEID", expression="t1.PSVTSTYLEID", showorder=6), @DEDataQueryCodeExp(name="PSVTSTYLENAME", expression="t1.PSVTSTYLENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSVTStyleDefaultDQModel
extends DEDataQueryModelBase {
    public PSVTStyleDefaultDQModel() {
        this.initAnnotation(PSVTStyleDefaultDQModel.class);
    }
}

