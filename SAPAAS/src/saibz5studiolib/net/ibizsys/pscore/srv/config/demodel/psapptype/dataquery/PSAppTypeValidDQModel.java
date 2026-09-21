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
package net.ibizsys.pscore.srv.config.demodel.psapptype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="021591DA-09D2-4E5B-ACBD-104512B44070", name="Valid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ICONPATH`, t1.`MEMO`, t1.`MOBILEMODE`, t1.`PSAPPTYPEID`, t1.`PSAPPTYPENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSAPPTYPE` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.`ICONPATH`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="MOBILEMODE", expression="t1.`MOBILEMODE`", showorder=4), @DEDataQueryCodeExp(name="PSAPPTYPEID", expression="t1.`PSAPPTYPEID`", showorder=5), @DEDataQueryCodeExp(name="PSAPPTYPENAME", expression="t1.`PSAPPTYPENAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.ICONPATH, t1.MEMO, t1.MOBILEMODE, t1.PSAPPTYPEID, t1.PSAPPTYPENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSAPPTYPE t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="ICONPATH", expression="t1.ICONPATH", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="MOBILEMODE", expression="t1.MOBILEMODE", showorder=4), @DEDataQueryCodeExp(name="PSAPPTYPEID", expression="t1.PSAPPTYPEID", showorder=5), @DEDataQueryCodeExp(name="PSAPPTYPENAME", expression="t1.PSAPPTYPENAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSAppTypeValidDQModel
extends DEDataQueryModelBase {
    public PSAppTypeValidDQModel() {
        this.initAnnotation(PSAppTypeValidDQModel.class);
    }
}

