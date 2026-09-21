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
package net.ibizsys.pscore.srv.dedesign.demodel.psdespcodepart.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="96C4552F-A5DD-4E18-8DD6-8229C3AC7464", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODEPART`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DANGERCODE`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSDESPCODEID`, t1.`PSDESPCODENAME`, t1.`PSDESPCODEPARTID`, t1.`PSDESPCODEPARTNAME`, t1.`PSDESYSPROCID`, t1.`PSDESYSPROCNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDESPCODEPART` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODEPART", expression="t1.`CODEPART`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DANGERCODE", expression="t1.`DANGERCODE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=5), @DEDataQueryCodeExp(name="PSDESPCODEID", expression="t1.`PSDESPCODEID`", showorder=6), @DEDataQueryCodeExp(name="PSDESPCODENAME", expression="t1.`PSDESPCODENAME`", showorder=7), @DEDataQueryCodeExp(name="PSDESPCODEPARTID", expression="t1.`PSDESPCODEPARTID`", showorder=8), @DEDataQueryCodeExp(name="PSDESPCODEPARTNAME", expression="t1.`PSDESPCODEPARTNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDESYSPROCID", expression="t1.`PSDESYSPROCID`", showorder=10), @DEDataQueryCodeExp(name="PSDESYSPROCNAME", expression="t1.`PSDESYSPROCNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODEPART, t1.CREATEDATE, t1.CREATEMAN, t1.DANGERCODE, t1.MEMO, t1.ORDERVALUE, t1.PSDESPCODEID, t1.PSDESPCODENAME, t1.PSDESPCODEPARTID, t1.PSDESPCODEPARTNAME, t1.PSDESYSPROCID, t1.PSDESYSPROCNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDESPCODEPART t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODEPART", expression="t1.CODEPART", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DANGERCODE", expression="t1.DANGERCODE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=5), @DEDataQueryCodeExp(name="PSDESPCODEID", expression="t1.PSDESPCODEID", showorder=6), @DEDataQueryCodeExp(name="PSDESPCODENAME", expression="t1.PSDESPCODENAME", showorder=7), @DEDataQueryCodeExp(name="PSDESPCODEPARTID", expression="t1.PSDESPCODEPARTID", showorder=8), @DEDataQueryCodeExp(name="PSDESPCODEPARTNAME", expression="t1.PSDESPCODEPARTNAME", showorder=9), @DEDataQueryCodeExp(name="PSDESYSPROCID", expression="t1.PSDESYSPROCID", showorder=10), @DEDataQueryCodeExp(name="PSDESYSPROCNAME", expression="t1.PSDESYSPROCNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSDESPCodePartDefaultDQModel
extends DEDataQueryModelBase {
    public PSDESPCodePartDefaultDQModel() {
        this.initAnnotation(PSDESPCodePartDefaultDQModel.class);
    }
}

