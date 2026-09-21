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
package net.ibizsys.pscore.srv.sysdesign.demodel.pssysrtdefinputtip.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="9CD8274D-33A3-448D-B295-BA87A988F0AA", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CONTENT`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`ENABLECLOSE`, t1.`MEMO`, t1.`MOREURL`, t1.`ORDERVALUE`, t1.`PSDEID`, t1.`PSDENAME`, t1.`PSSYSRTDEFINPUTTIPID`, t1.`PSSYSRTDEFINPUTTIPNAME`, t1.`UNIQUETAG`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSSYSRTDEFINPUTTIP` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="ENABLECLOSE", expression="t1.`ENABLECLOSE`", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=4), @DEDataQueryCodeExp(name="MOREURL", expression="t1.`MOREURL`", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=6), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=7), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.`PSDENAME`", showorder=8), @DEDataQueryCodeExp(name="PSSYSRTDEFINPUTTIPID", expression="t1.`PSSYSRTDEFINPUTTIPID`", showorder=9), @DEDataQueryCodeExp(name="PSSYSRTDEFINPUTTIPNAME", expression="t1.`PSSYSRTDEFINPUTTIPNAME`", showorder=10), @DEDataQueryCodeExp(name="UNIQUETAG", expression="t1.`UNIQUETAG`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=14)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CONTENT, t1.CREATEDATE, t1.CREATEMAN, t1.ENABLECLOSE, t1.MEMO, t1.MOREURL, t1.ORDERVALUE, t1.PSDEID, t1.PSDENAME, t1.PSSYSRTDEFINPUTTIPID, t1.PSSYSRTDEFINPUTTIPNAME, t1.UNIQUETAG, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSSYSRTDEFINPUTTIP t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="ENABLECLOSE", expression="t1.ENABLECLOSE", showorder=3), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=4), @DEDataQueryCodeExp(name="MOREURL", expression="t1.MOREURL", showorder=5), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=6), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=7), @DEDataQueryCodeExp(name="PSDENAME", expression="t1.PSDENAME", showorder=8), @DEDataQueryCodeExp(name="PSSYSRTDEFINPUTTIPID", expression="t1.PSSYSRTDEFINPUTTIPID", showorder=9), @DEDataQueryCodeExp(name="PSSYSRTDEFINPUTTIPNAME", expression="t1.PSSYSRTDEFINPUTTIPNAME", showorder=10), @DEDataQueryCodeExp(name="UNIQUETAG", expression="t1.UNIQUETAG", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=14)}, conds={})})
public class PSSysRTDEFInputTipDefaultDQModel
extends DEDataQueryModelBase {
    public PSSysRTDEFInputTipDefaultDQModel() {
        this.initAnnotation(PSSysRTDEFInputTipDefaultDQModel.class);
    }
}

