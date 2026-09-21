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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssystaskdata.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="A1C2D1EE-77DF-4559-8502-39A1011B204B", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSSYSTASKDATAID`, t1.`PSSYSTASKDATANAME`, t1.`PSSYSTASKID`, t11.`PSSYSTASKNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSSYSTASKDATA` t1  LEFT JOIN T_SRFPSSYSTASK t11 ON t1.PSSYSTASKID = t11.PSSYSTASKID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="PSSYSTASKDATAID", expression="t1.`PSSYSTASKDATAID`", showorder=3), @DEDataQueryCodeExp(name="PSSYSTASKDATANAME", expression="t1.`PSSYSTASKDATANAME`", showorder=4), @DEDataQueryCodeExp(name="PSSYSTASKID", expression="t1.`PSSYSTASKID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSTASKNAME", expression="t11.`PSSYSTASKNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.PSSYSTASKDATAID, t1.PSSYSTASKDATANAME, t1.PSSYSTASKID, t11.PSSYSTASKNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSSYSTASKDATA t1  LEFT JOIN T_SRFPSSYSTASK t11 ON t1.PSSYSTASKID = t11.PSSYSTASKID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="PSSYSTASKDATAID", expression="t1.PSSYSTASKDATAID", showorder=3), @DEDataQueryCodeExp(name="PSSYSTASKDATANAME", expression="t1.PSSYSTASKDATANAME", showorder=4), @DEDataQueryCodeExp(name="PSSYSTASKID", expression="t1.PSSYSTASKID", showorder=5), @DEDataQueryCodeExp(name="PSSYSTASKNAME", expression="t11.PSSYSTASKNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8)}, conds={})})
public class PSSysTaskDataDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysTaskDataDefaultDQModel() {
        this.initAnnotation(PSSysTaskDataDefaultDQModel.class);
    }
}

