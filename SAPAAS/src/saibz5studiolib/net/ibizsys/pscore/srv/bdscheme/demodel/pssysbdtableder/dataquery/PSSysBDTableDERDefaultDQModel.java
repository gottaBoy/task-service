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
package net.ibizsys.pscore.srv.bdscheme.demodel.pssysbdtableder.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="FE8DA6CF-A06E-493F-886B-8B8B62A57142", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DERLEVEL`, t1.`MEMO`, t1.`PSDERID`, t11.`PSDERNAME`, t1.`PSSYSBDTABLEDERID`, t1.`PSSYSBDTABLEDERNAME`, t1.`PSSYSBDTABLEID`, t21.`PSSYSBDTABLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERCAT`, t1.`USERTAG`, t1.`USERTAG2`, t1.`USERTAG3`, t1.`USERTAG4` FROM `T_SRFPSSYSBDTABLEDER` t1  LEFT JOIN `T_SRFPSDER` t11 ON t1.`PSDERID` = t11.`PSDERID`  LEFT JOIN `T_SRFPSSYSBDTABLE` t21 ON t1.`PSSYSBDTABLEID` = t21.`PSSYSBDTABLEID`  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DERLEVEL", expression="t1.`DERLEVEL`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSDERID", expression="t1.`PSDERID`", showorder=4), @DEDataQueryCodeExp(name="PSDERNAME", expression="t11.`PSDERNAME`", showorder=5), @DEDataQueryCodeExp(name="PSSYSBDTABLEDERID", expression="t1.`PSSYSBDTABLEDERID`", showorder=6), @DEDataQueryCodeExp(name="PSSYSBDTABLEDERNAME", expression="t1.`PSSYSBDTABLEDERNAME`", showorder=7), @DEDataQueryCodeExp(name="PSSYSBDTABLEID", expression="t1.`PSSYSBDTABLEID`", showorder=8), @DEDataQueryCodeExp(name="PSSYSBDTABLENAME", expression="t21.`PSSYSBDTABLENAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.`USERCAT`", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.`USERTAG`", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.`USERTAG2`", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.`USERTAG3`", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.`USERTAG4`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DERLEVEL, t1.MEMO, t1.PSDERID, t11.PSDERNAME, t1.PSSYSBDTABLEDERID, t1.PSSYSBDTABLEDERNAME, t1.PSSYSBDTABLEID, t21.PSSYSBDTABLENAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERCAT, t1.USERTAG, t1.USERTAG2, t1.USERTAG3, t1.USERTAG4 FROM T_SRFPSSYSBDTABLEDER t1  LEFT JOIN T_SRFPSDER t11 ON t1.PSDERID = t11.PSDERID  LEFT JOIN T_SRFPSSYSBDTABLE t21 ON t1.PSSYSBDTABLEID = t21.PSSYSBDTABLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DERLEVEL", expression="t1.DERLEVEL", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSDERID", expression="t1.PSDERID", showorder=4), @DEDataQueryCodeExp(name="PSDERNAME", expression="t11.PSDERNAME", showorder=5), @DEDataQueryCodeExp(name="PSSYSBDTABLEDERID", expression="t1.PSSYSBDTABLEDERID", showorder=6), @DEDataQueryCodeExp(name="PSSYSBDTABLEDERNAME", expression="t1.PSSYSBDTABLEDERNAME", showorder=7), @DEDataQueryCodeExp(name="PSSYSBDTABLEID", expression="t1.PSSYSBDTABLEID", showorder=8), @DEDataQueryCodeExp(name="PSSYSBDTABLENAME", expression="t21.PSSYSBDTABLENAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="USERCAT", expression="t1.USERCAT", showorder=12), @DEDataQueryCodeExp(name="USERTAG", expression="t1.USERTAG", showorder=13), @DEDataQueryCodeExp(name="USERTAG2", expression="t1.USERTAG2", showorder=14), @DEDataQueryCodeExp(name="USERTAG3", expression="t1.USERTAG3", showorder=15), @DEDataQueryCodeExp(name="USERTAG4", expression="t1.USERTAG4", showorder=16)}, conds={})})
public class PSSysBDTableDERDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysBDTableDERDefaultDQModel() {
        this.initAnnotation(PSSysBDTableDERDefaultDQModel.class);
    }
}

