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
package net.ibizsys.pscore.srv.config.demodel.psdedqpdcond.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="647C45F7-3622-42F0-8CDE-483AC6069315", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONDOBJ`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDEDQPDCONDID`, t1.`PSDEDQPDCONDNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDQPDCOND` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONDOBJ", expression="t1.`CONDOBJ`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDEDQPDCONDID", expression="t1.`PSDEDQPDCONDID`", showorder=4), @DEDataQueryCodeExp(name="PSDEDQPDCONDNAME", expression="t1.`PSDEDQPDCONDNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONDOBJ, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDEDQPDCONDID, t1.PSDEDQPDCONDNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDQPDCOND t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONDOBJ", expression="t1.CONDOBJ", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDEDQPDCONDID", expression="t1.PSDEDQPDCONDID", showorder=4), @DEDataQueryCodeExp(name="PSDEDQPDCONDNAME", expression="t1.PSDEDQPDCONDNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSDEDQPDCondDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDQPDCondDefaultDQModel() {
        this.initAnnotation(PSDEDQPDCondDefaultDQModel.class);
    }
}

