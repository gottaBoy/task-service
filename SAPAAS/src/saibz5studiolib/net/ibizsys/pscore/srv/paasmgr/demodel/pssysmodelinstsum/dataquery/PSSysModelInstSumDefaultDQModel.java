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
package net.ibizsys.pscore.srv.paasmgr.demodel.pssysmodelinstsum.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="C83AF45D-925F-4FC2-9F06-50969E10ADD9", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CNT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MODELLOGICNAME`, t1.`PSSYSMODELINSTID`, t1.`PSSYSMODELINSTNAME`, t1.`PSSYSMODELINSTSUMID`, t1.`PSSYSMODELINSTSUMNAME`, t1.`TMPCNT`, t1.`TMPUSEDSIZE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USEDSIZE` FROM `T_SRFPSSYSMODELINSTSUM` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CNT", expression="t1.`CNT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MODELLOGICNAME", expression="t1.`MODELLOGICNAME`", showorder=3), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.`PSSYSMODELINSTID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t1.`PSSYSMODELINSTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSMODELINSTSUMID", expression="t1.`PSSYSMODELINSTSUMID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSMODELINSTSUMNAME", expression="t1.`PSSYSMODELINSTSUMNAME`", showorder=7), @DEDataQueryCodeExp(name="TMPCNT", expression="t1.`TMPCNT`", showorder=8), @DEDataQueryCodeExp(name="TMPUSEDSIZE", expression="t1.`TMPUSEDSIZE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USEDSIZE", expression="t1.`USEDSIZE`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CNT, t1.CREATEDATE, t1.CREATEMAN, t1.MODELLOGICNAME, t1.PSSYSMODELINSTID, t1.PSSYSMODELINSTNAME, t1.PSSYSMODELINSTSUMID, t1.PSSYSMODELINSTSUMNAME, t1.TMPCNT, t1.TMPUSEDSIZE, t1.UPDATEDATE, t1.UPDATEMAN, t1.USEDSIZE FROM T_SRFPSSYSMODELINSTSUM t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CNT", expression="t1.CNT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MODELLOGICNAME", expression="t1.MODELLOGICNAME", showorder=3), @DEDataQueryCodeExp(name="PSSYSMODELINSTID", expression="t1.PSSYSMODELINSTID", showorder=4), @DEDataQueryCodeExp(name="PSSYSMODELINSTNAME", expression="t1.PSSYSMODELINSTNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSMODELINSTSUMID", expression="t1.PSSYSMODELINSTSUMID", showorder=6), @DEDataQueryCodeExp(name="PSSYSMODELINSTSUMNAME", expression="t1.PSSYSMODELINSTSUMNAME", showorder=7), @DEDataQueryCodeExp(name="TMPCNT", expression="t1.TMPCNT", showorder=8), @DEDataQueryCodeExp(name="TMPUSEDSIZE", expression="t1.TMPUSEDSIZE", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USEDSIZE", expression="t1.USEDSIZE", showorder=12)}, conds={})})
public class PSSysModelInstSumDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysModelInstSumDefaultDQModel() {
        this.initAnnotation(PSSysModelInstSumDefaultDQModel.class);
    }
}

