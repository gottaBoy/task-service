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
package net.ibizsys.pscore.srv.config.demodel.psuienginetypeparam.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="69262FBD-B8FC-4E32-A310-7A2A9BDFBF18", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`PSUIENGINETYPEID`, t1.`PSUIENGINETYPENAME`, t1.`PSUIENGINETYPEPARAMID`, t1.`PSUIENGINETYPEPARAMNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSUIENGINETYPEPARAM` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="PSUIENGINETYPEID", expression="t1.`PSUIENGINETYPEID`", showorder=2), @DEDataQueryCodeExp(name="PSUIENGINETYPENAME", expression="t1.`PSUIENGINETYPENAME`", showorder=3), @DEDataQueryCodeExp(name="PSUIENGINETYPEPARAMID", expression="t1.`PSUIENGINETYPEPARAMID`", showorder=4), @DEDataQueryCodeExp(name="PSUIENGINETYPEPARAMNAME", expression="t1.`PSUIENGINETYPEPARAMNAME`", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=7)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.PSUIENGINETYPEID, t1.PSUIENGINETYPENAME, t1.PSUIENGINETYPEPARAMID, t1.PSUIENGINETYPEPARAMNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSUIENGINETYPEPARAM t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="PSUIENGINETYPEID", expression="t1.PSUIENGINETYPEID", showorder=2), @DEDataQueryCodeExp(name="PSUIENGINETYPENAME", expression="t1.PSUIENGINETYPENAME", showorder=3), @DEDataQueryCodeExp(name="PSUIENGINETYPEPARAMID", expression="t1.PSUIENGINETYPEPARAMID", showorder=4), @DEDataQueryCodeExp(name="PSUIENGINETYPEPARAMNAME", expression="t1.PSUIENGINETYPEPARAMNAME", showorder=5), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=6), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=7)}, conds={})})
public class PSUIEngineTypeParamDefaultDQModel
extends DEDataQueryModelBase {
    public PSUIEngineTypeParamDefaultDQModel() {
        this.initAnnotation(PSUIEngineTypeParamDefaultDQModel.class);
    }
}

