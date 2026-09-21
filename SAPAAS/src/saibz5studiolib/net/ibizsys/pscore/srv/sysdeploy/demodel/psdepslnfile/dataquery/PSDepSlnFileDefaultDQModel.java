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
package net.ibizsys.pscore.srv.sysdeploy.demodel.psdepslnfile.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="ACD3D4EE-2437-4067-B02B-903B5AFED99D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSDCFILEID`, t11.`PSDCFILENAME`, t1.`PSDEPSLNFILEID`, t1.`PSDEPSLNFILENAME`, t1.`PSDEPSLNID`, t21.`PSDEPSLNNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSDEPSLNFILE` t1  LEFT JOIN T_SRFPSDCFILE t11 ON t1.PSDCFILEID = t11.PSDCFILEID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSDCFILEID", expression="t1.`PSDCFILEID`", showorder=3), @DEDataQueryCodeExp(name="PSDCFILENAME", expression="t11.`PSDCFILENAME`", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNFILEID", expression="t1.`PSDEPSLNFILEID`", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNFILENAME", expression="t1.`PSDEPSLNFILENAME`", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.`PSDEPSLNID`", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.`PSDEPSLNNAME`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSDCFILEID, t11.PSDCFILENAME, t1.PSDEPSLNFILEID, t1.PSDEPSLNFILENAME, t1.PSDEPSLNID, t21.PSDEPSLNNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSDEPSLNFILE t1  LEFT JOIN T_SRFPSDCFILE t11 ON t1.PSDCFILEID = t11.PSDCFILEID  LEFT JOIN T_SRFPSDEPSLN t21 ON t1.PSDEPSLNID = t21.PSDEPSLNID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSDCFILEID", expression="t1.PSDCFILEID", showorder=3), @DEDataQueryCodeExp(name="PSDCFILENAME", expression="t11.PSDCFILENAME", showorder=4), @DEDataQueryCodeExp(name="PSDEPSLNFILEID", expression="t1.PSDEPSLNFILEID", showorder=5), @DEDataQueryCodeExp(name="PSDEPSLNFILENAME", expression="t1.PSDEPSLNFILENAME", showorder=6), @DEDataQueryCodeExp(name="PSDEPSLNID", expression="t1.PSDEPSLNID", showorder=7), @DEDataQueryCodeExp(name="PSDEPSLNNAME", expression="t21.PSDEPSLNNAME", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSDepSlnFileDefaultDQModel
extends DEDataQueryModelBase {
    public PSDepSlnFileDefaultDQModel() {
        this.initAnnotation(PSDepSlnFileDefaultDQModel.class);
    }
}

