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
package net.ibizsys.pscore.srv.config.demodel.psviewtypelogic.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="54D0F7CE-62E2-4B8C-A728-C8E94D2A46A7", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSVIEWLOGICTYPEID`, t11.`PSVIEWLOGICTYPENAME`, t1.`PSVIEWTYPEID`, t1.`PSVIEWTYPELOGICID`, t1.`PSVIEWTYPELOGICNAME`, t21.`PSVIEWTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSVIEWTYPELOGIC` t1  LEFT JOIN T_SRFPSVIEWLOGICTYPE t11 ON t1.PSVIEWLOGICTYPEID = t11.PSVIEWLOGICTYPEID  LEFT JOIN T_SRFPSVIEWTYPE t21 ON t1.PSVIEWTYPEID = t21.PSVIEWTYPEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEID", expression="t1.`PSVIEWLOGICTYPEID`", showorder=3), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPENAME", expression="t11.`PSVIEWLOGICTYPENAME`", showorder=4), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.`PSVIEWTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSVIEWTYPELOGICID", expression="t1.`PSVIEWTYPELOGICID`", showorder=6), @DEDataQueryCodeExp(name="PSVIEWTYPELOGICNAME", expression="t1.`PSVIEWTYPELOGICNAME`", showorder=7), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t21.`PSVIEWTYPENAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSVIEWLOGICTYPEID, t11.PSVIEWLOGICTYPENAME, t1.PSVIEWTYPEID, t1.PSVIEWTYPELOGICID, t1.PSVIEWTYPELOGICNAME, t21.PSVIEWTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSVIEWTYPELOGIC t1  LEFT JOIN T_SRFPSVIEWLOGICTYPE t11 ON t1.PSVIEWLOGICTYPEID = t11.PSVIEWLOGICTYPEID  LEFT JOIN T_SRFPSVIEWTYPE t21 ON t1.PSVIEWTYPEID = t21.PSVIEWTYPEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEID", expression="t1.PSVIEWLOGICTYPEID", showorder=3), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPENAME", expression="t11.PSVIEWLOGICTYPENAME", showorder=4), @DEDataQueryCodeExp(name="PSVIEWTYPEID", expression="t1.PSVIEWTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSVIEWTYPELOGICID", expression="t1.PSVIEWTYPELOGICID", showorder=6), @DEDataQueryCodeExp(name="PSVIEWTYPELOGICNAME", expression="t1.PSVIEWTYPELOGICNAME", showorder=7), @DEDataQueryCodeExp(name="PSVIEWTYPENAME", expression="t21.PSVIEWTYPENAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10)}, conds={})})
public class PSViewTypeLogicDefaultDQModel
extends DEDataQueryModelBase {
    public PSViewTypeLogicDefaultDQModel() {
        this.initAnnotation(PSViewTypeLogicDefaultDQModel.class);
    }
}

