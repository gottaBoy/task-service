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
package net.ibizsys.pscore.srv.config.demodel.pssfpf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="AF397004-EFF9-46B2-B25F-BE8CC36FD4F8", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSPFID`, t1.`PSPFNAME`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`PSSFPFID`, t1.`PSSFPFNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSFPF` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=3), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.`PSPFNAME`", showorder=4), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=5), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSFPFID", expression="t1.`PSSFPFID`", showorder=7), @DEDataQueryCodeExp(name="PSSFPFNAME", expression="t1.`PSSFPFNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSPFID, t1.PSPFNAME, t1.PSSFID, t1.PSSFNAME, t1.PSSFPFID, t1.PSSFPFNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSFPF t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=3), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.PSPFNAME", showorder=4), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=5), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=6), @DEDataQueryCodeExp(name="PSSFPFID", expression="t1.PSSFPFID", showorder=7), @DEDataQueryCodeExp(name="PSSFPFNAME", expression="t1.PSSFPFNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSSFPFDefaultDQModel
extends DEDataQueryModelBase {
    public PSSFPFDefaultDQModel() {
        this.initAnnotation(PSSFPFDefaultDQModel.class);
    }
}

