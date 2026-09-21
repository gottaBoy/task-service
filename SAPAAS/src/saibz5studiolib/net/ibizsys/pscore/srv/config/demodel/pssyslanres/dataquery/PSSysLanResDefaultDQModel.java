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
package net.ibizsys.pscore.srv.config.demodel.pssyslanres.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="134C3644-EF8E-469B-A729-0E754A8FEAD7", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`LANRESTYPE`, t1.`MEMO`, t1.`PSSYSLANRESID`, t1.`PSSYSLANRESNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`USERDATA`, t1.`VALIDFLAG` FROM `T_SRFPSSYSLANRES` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="LANRESTYPE", expression="t1.`LANRESTYPE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="PSSYSLANRESID", expression="t1.`PSSYSLANRESID`", showorder=5), @DEDataQueryCodeExp(name="PSSYSLANRESNAME", expression="t1.`PSSYSLANRESNAME`", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=8), @DEDataQueryCodeExp(name="USERDATA", expression="t1.`USERDATA`", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=10)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.LANRESTYPE, t1.MEMO, t1.PSSYSLANRESID, t1.PSSYSLANRESNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.USERDATA, t1.VALIDFLAG FROM T_SRFPSSYSLANRES t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="LANRESTYPE", expression="t1.LANRESTYPE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="PSSYSLANRESID", expression="t1.PSSYSLANRESID", showorder=5), @DEDataQueryCodeExp(name="PSSYSLANRESNAME", expression="t1.PSSYSLANRESNAME", showorder=6), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=7), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=8), @DEDataQueryCodeExp(name="USERDATA", expression="t1.USERDATA", showorder=9), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=10)}, conds={})})
public class PSSysLanResDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysLanResDefaultDQModel() {
        this.initAnnotation(PSSysLanResDefaultDQModel.class);
    }
}

