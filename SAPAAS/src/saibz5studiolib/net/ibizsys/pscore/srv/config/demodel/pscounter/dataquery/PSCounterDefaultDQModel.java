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
package net.ibizsys.pscore.srv.config.demodel.pscounter.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="6554F863-DEF8-4085-AE5C-C6CFC8B0AC12", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`COUNTERTYPE`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`JITCTRLOBJ`, t1.`MEMO`, t1.`PSCOUNTERID`, t1.`PSCOUNTERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSCOUNTER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.`BASECLSPARAMS`", showorder=-1), @DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="COUNTERTYPE", expression="t1.`COUNTERTYPE`", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=3), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t1.`JITCTRLOBJ`", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=5), @DEDataQueryCodeExp(name="PSCOUNTERID", expression="t1.`PSCOUNTERID`", showorder=6), @DEDataQueryCodeExp(name="PSCOUNTERNAME", expression="t1.`PSCOUNTERNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.COUNTERTYPE, t1.CREATEDATE, t1.CREATEMAN, t1.JITCTRLOBJ, t1.MEMO, t1.PSCOUNTERID, t1.PSCOUNTERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSCOUNTER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BASECLSPARAMS", expression="t1.BASECLSPARAMS", showorder=-1), @DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="COUNTERTYPE", expression="t1.COUNTERTYPE", showorder=1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=2), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=3), @DEDataQueryCodeExp(name="JITCTRLOBJ", expression="t1.JITCTRLOBJ", showorder=4), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=5), @DEDataQueryCodeExp(name="PSCOUNTERID", expression="t1.PSCOUNTERID", showorder=6), @DEDataQueryCodeExp(name="PSCOUNTERNAME", expression="t1.PSCOUNTERNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSCounterDefaultDQModel
extends DEDataQueryModelBase {
    public PSCounterDefaultDQModel() {
        this.initAnnotation(PSCounterDefaultDQModel.class);
    }
}

