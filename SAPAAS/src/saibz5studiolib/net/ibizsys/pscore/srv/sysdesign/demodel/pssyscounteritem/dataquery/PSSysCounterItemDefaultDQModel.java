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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssyscounteritem.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="3EA1A4BD-C5E3-4251-A8EC-1A00F939924A", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LOGICNAME`, t1.`MEMO`, t1.`PSSYSCOUNTERID`, t1.`PSSYSCOUNTERITEMID`, t1.`PSSYSCOUNTERITEMNAME`, t11.`PSSYSCOUNTERNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSCOUNTERITEM` t1  LEFT JOIN T_SRFPSSYSCOUNTER t11 ON t1.PSSYSCOUNTERID = t11.PSSYSCOUNTERID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.`LOGICNAME`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSSYSCOUNTERID", expression="t1.`PSSYSCOUNTERID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSCOUNTERITEMID", expression="t1.`PSSYSCOUNTERITEMID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSCOUNTERITEMNAME", expression="t1.`PSSYSCOUNTERITEMNAME`", showorder=6), @DEDataQueryCodeExp(name="PSSYSCOUNTERNAME", expression="t11.`PSSYSCOUNTERNAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.LOGICNAME, t1.MEMO, t1.PSSYSCOUNTERID, t1.PSSYSCOUNTERITEMID, t1.PSSYSCOUNTERITEMNAME, t11.PSSYSCOUNTERNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSCOUNTERITEM t1  LEFT JOIN T_SRFPSSYSCOUNTER t11 ON t1.PSSYSCOUNTERID = t11.PSSYSCOUNTERID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="LOGICNAME", expression="t1.LOGICNAME", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSSYSCOUNTERID", expression="t1.PSSYSCOUNTERID", showorder=4), @DEDataQueryCodeExp(name="PSSYSCOUNTERITEMID", expression="t1.PSSYSCOUNTERITEMID", showorder=5), @DEDataQueryCodeExp(name="PSSYSCOUNTERITEMNAME", expression="t1.PSSYSCOUNTERITEMNAME", showorder=6), @DEDataQueryCodeExp(name="PSSYSCOUNTERNAME", expression="t11.PSSYSCOUNTERNAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9)}, conds={})})
public class PSSysCounterItemDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysCounterItemDefaultDQModel() {
        this.initAnnotation(PSSysCounterItemDefaultDQModel.class);
    }
}

