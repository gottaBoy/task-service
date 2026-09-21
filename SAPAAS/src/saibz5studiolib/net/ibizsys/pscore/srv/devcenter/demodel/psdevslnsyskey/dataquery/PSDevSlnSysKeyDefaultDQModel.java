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
package net.ibizsys.pscore.srv.devcenter.demodel.psdevslnsyskey.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="F7C0A4AD-820A-4AA0-8611-157D22143E68", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`ADMINMODE`, t1.`BEGINTIME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENDTIME`, t1.`KEYCOUNT`, t1.`KEYSTATE`, t1.`PSDEVCENTERID`, t1.`PSDEVCENTERNAME`, t1.`PSDEVSLNSYSID`, t1.`PSDEVSLNSYSKEYID`, t1.`PSDEVSLNSYSKEYNAME`, t1.`PSDEVSLNSYSNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEVSLNSYSKEY` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="ADMINMODE", expression="t1.`ADMINMODE`", showorder=0), @DEDataQueryCodeExp(name="BEGINTIME", expression="t1.`BEGINTIME`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.`ENDTIME`", showorder=4), @DEDataQueryCodeExp(name="KEYCOUNT", expression="t1.`KEYCOUNT`", showorder=5), @DEDataQueryCodeExp(name="KEYSTATE", expression="t1.`KEYSTATE`", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.`PSDEVCENTERID`", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.`PSDEVCENTERNAME`", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.`PSDEVSLNSYSID`", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNSYSKEYID", expression="t1.`PSDEVSLNSYSKEYID`", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNSYSKEYNAME", expression="t1.`PSDEVSLNSYSKEYNAME`", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.`PSDEVSLNSYSNAME`", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.ADMINMODE, t1.BEGINTIME, t1.CREATEDATE, t1.CREATEMAN, t1.ENDTIME, t1.KEYCOUNT, t1.KEYSTATE, t1.PSDEVCENTERID, t1.PSDEVCENTERNAME, t1.PSDEVSLNSYSID, t1.PSDEVSLNSYSKEYID, t1.PSDEVSLNSYSKEYNAME, t1.PSDEVSLNSYSNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEVSLNSYSKEY t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="ADMINMODE", expression="t1.ADMINMODE", showorder=0), @DEDataQueryCodeExp(name="BEGINTIME", expression="t1.BEGINTIME", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="ENDTIME", expression="t1.ENDTIME", showorder=4), @DEDataQueryCodeExp(name="KEYCOUNT", expression="t1.KEYCOUNT", showorder=5), @DEDataQueryCodeExp(name="KEYSTATE", expression="t1.KEYSTATE", showorder=6), @DEDataQueryCodeExp(name="PSDEVCENTERID", expression="t1.PSDEVCENTERID", showorder=7), @DEDataQueryCodeExp(name="PSDEVCENTERNAME", expression="t1.PSDEVCENTERNAME", showorder=8), @DEDataQueryCodeExp(name="PSDEVSLNSYSID", expression="t1.PSDEVSLNSYSID", showorder=9), @DEDataQueryCodeExp(name="PSDEVSLNSYSKEYID", expression="t1.PSDEVSLNSYSKEYID", showorder=10), @DEDataQueryCodeExp(name="PSDEVSLNSYSKEYNAME", expression="t1.PSDEVSLNSYSKEYNAME", showorder=11), @DEDataQueryCodeExp(name="PSDEVSLNSYSNAME", expression="t1.PSDEVSLNSYSNAME", showorder=12), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=13), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=14)}, conds={})})
public class PSDevSlnSysKeyDefaultDQModel
extends DEDataQueryModelBase {
    public PSDevSlnSysKeyDefaultDQModel() {
        this.initAnnotation(PSDevSlnSysKeyDefaultDQModel.class);
    }
}

