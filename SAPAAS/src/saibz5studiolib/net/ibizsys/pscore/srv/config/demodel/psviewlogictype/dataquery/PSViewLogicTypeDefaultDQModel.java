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
package net.ibizsys.pscore.srv.config.demodel.psviewlogictype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="394F5EAD-10F1-4EFB-A1A0-2E6908A32415", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`APPVIEWLOGICOBJ`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PROCESSNAME`, t1.`PSVIEWLOGICTYPEID`, t1.`PSVIEWLOGICTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSVIEWLOGICTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="APPVIEWLOGICOBJ", expression="t1.`APPVIEWLOGICOBJ`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PROCESSNAME", expression="t1.`PROCESSNAME`", showorder=4), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEID", expression="t1.`PSVIEWLOGICTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPENAME", expression="t1.`PSVIEWLOGICTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.APPVIEWLOGICOBJ, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PROCESSNAME, t1.PSVIEWLOGICTYPEID, t1.PSVIEWLOGICTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSVIEWLOGICTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="APPVIEWLOGICOBJ", expression="t1.APPVIEWLOGICOBJ", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PROCESSNAME", expression="t1.PROCESSNAME", showorder=4), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPEID", expression="t1.PSVIEWLOGICTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSVIEWLOGICTYPENAME", expression="t1.PSVIEWLOGICTYPENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=9)}, conds={})})
public class PSViewLogicTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSViewLogicTypeDefaultDQModel() {
        this.initAnnotation(PSViewLogicTypeDefaultDQModel.class);
    }
}

