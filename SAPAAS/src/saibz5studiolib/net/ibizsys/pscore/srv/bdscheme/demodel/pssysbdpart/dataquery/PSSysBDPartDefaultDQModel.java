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
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdpart.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="D6D26E5F-5EA1-4B50-A082-1F7481FFA57D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSSYSBDPARTID`, t1.`PSSYSBDPARTNAME`, t1.`PSSYSBDSCHEMEID`, t11.`PSSYSBDSCHEMENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSSYSBDPART` t1  LEFT JOIN T_SRFPSSYSBDSCHEME t11 ON t1.PSSYSBDSCHEMEID = t11.PSSYSBDSCHEMEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSSYSBDPARTID", expression="t1.`PSSYSBDPARTID`", showorder=4), @DEDataQueryCodeExp(name="PSSYSBDPARTNAME", expression="t1.`PSSYSBDPARTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSBDSCHEMEID", expression="t1.`PSSYSBDSCHEMEID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSBDSCHEMENAME", expression="t11.`PSSYSBDSCHEMENAME`", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=9), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=10), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=11), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=12), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=13), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSSYSBDPARTID, t1.PSSYSBDPARTNAME, t1.PSSYSBDSCHEMEID, t11.PSSYSBDSCHEMENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSSYSBDPART t1  LEFT JOIN T_SRFPSSYSBDSCHEME t11 ON t1.PSSYSBDSCHEMEID = t11.PSSYSBDSCHEMEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSSYSBDPARTID", expression="t1.PSSYSBDPARTID", showorder=4), @DEDataQueryCodeExp(name="PSSYSBDPARTNAME", expression="t1.PSSYSBDPARTNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSBDSCHEMEID", expression="t1.PSSYSBDSCHEMEID", showorder=6), @DEDataQueryCodeExp(name="PSSYSBDSCHEMENAME", expression="t11.PSSYSBDSCHEMENAME", showorder=7), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=8), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=9), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=10), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=11), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=12), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=13), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=14)}, conds={})})
public class PSSysBDPartDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysBDPartDefaultDQModel() {
        this.initAnnotation(PSSysBDPartDefaultDQModel.class);
    }
}

