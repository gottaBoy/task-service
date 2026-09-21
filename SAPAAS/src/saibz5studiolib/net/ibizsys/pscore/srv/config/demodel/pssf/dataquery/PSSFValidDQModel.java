/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.DEDataQuery
 *  net.ibizsys.paas.core.DEDataQueryCode
 *  net.ibizsys.paas.core.DEDataQueryCodeCond
 *  net.ibizsys.paas.core.DEDataQueryCodeExp
 *  net.ibizsys.paas.core.DEDataQueryCodes
 *  net.ibizsys.paas.demodel.DEDataQueryModelBase
 */
package net.ibizsys.pscore.srv.config.demodel.pssf.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeCond;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4D1F5578-AFDD-468A-B4B1-AC223AADD6E8", name="Valid")
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CLSFCUPPERCASE`, t1.`CLSPKGPARAMS`, t1.`CODEFLAG`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DOCFLAG`, t1.`MEMO`, t1.`MODELFLAG`, t1.`PKGLOWERCASE`, t1.`PSSFID`, t1.`PSSFNAME`, t1.`SLNFLAG`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`V2FOLDER`, t1.`V2GITPATH`, t1.`VALIDFLAG` FROM `T_SRFPSSF` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CLSFCUPPERCASE", expression="t1.`CLSFCUPPERCASE`", showorder=0), @DEDataQueryCodeExp(name="CLSPKGPARAMS", expression="t1.`CLSPKGPARAMS`", showorder=1), @DEDataQueryCodeExp(name="CODEFLAG", expression="t1.`CODEFLAG`", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=4), @DEDataQueryCodeExp(name="DOCFLAG", expression="t1.`DOCFLAG`", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=6), @DEDataQueryCodeExp(name="MODELFLAG", expression="t1.`MODELFLAG`", showorder=7), @DEDataQueryCodeExp(name="PKGLOWERCASE", expression="t1.`PKGLOWERCASE`", showorder=8), @DEDataQueryCodeExp(name="PSSFID", expression="t1.`PSSFID`", showorder=9), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.`PSSFNAME`", showorder=10), @DEDataQueryCodeExp(name="SLNFLAG", expression="t1.`SLNFLAG`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="V2FOLDER", expression="t1.`V2FOLDER`", showorder=14), @DEDataQueryCodeExp(name="V2GITPATH", expression="t1.`V2GITPATH`", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.`VALIDFLAG` = 1 )")}), @DEDataQueryCode(querycode="SELECT t1.CLSFCUPPERCASE, t1.CLSPKGPARAMS, t1.CODEFLAG, t1.CREATEDATE, t1.CREATEMAN, t1.DOCFLAG, t1.MEMO, t1.MODELFLAG, t1.PKGLOWERCASE, t1.PSSFID, t1.PSSFNAME, t1.SLNFLAG, t1.UPDATEDATE, t1.UPDATEMAN, t1.V2FOLDER, t1.V2GITPATH, t1.VALIDFLAG FROM T_SRFPSSF t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CLSFCUPPERCASE", expression="t1.CLSFCUPPERCASE", showorder=0), @DEDataQueryCodeExp(name="CLSPKGPARAMS", expression="t1.CLSPKGPARAMS", showorder=1), @DEDataQueryCodeExp(name="CODEFLAG", expression="t1.CODEFLAG", showorder=2), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=3), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=4), @DEDataQueryCodeExp(name="DOCFLAG", expression="t1.DOCFLAG", showorder=5), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=6), @DEDataQueryCodeExp(name="MODELFLAG", expression="t1.MODELFLAG", showorder=7), @DEDataQueryCodeExp(name="PKGLOWERCASE", expression="t1.PKGLOWERCASE", showorder=8), @DEDataQueryCodeExp(name="PSSFID", expression="t1.PSSFID", showorder=9), @DEDataQueryCodeExp(name="PSSFNAME", expression="t1.PSSFNAME", showorder=10), @DEDataQueryCodeExp(name="SLNFLAG", expression="t1.SLNFLAG", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="V2FOLDER", expression="t1.V2FOLDER", showorder=14), @DEDataQueryCodeExp(name="V2GITPATH", expression="t1.V2GITPATH", showorder=15), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=16)}, conds={@DEDataQueryCodeCond(condition="( t1.VALIDFLAG = 1 )")})})
public class PSSFValidDQModel
extends DEDataQueryModelBase {
    public PSSFValidDQModel() {
        this.initAnnotation(PSSFValidDQModel.class);
    }
}

