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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwdeunionkey.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="93E630E9-53E5-4194-B2F1-0F45DF0C07C7", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`KEY2PSDEFID`, t1.`KEY2PSDEFNAME`, t1.`KEY3PSDEFID`, t1.`KEY3PSDEFNAME`, t1.`KEY4PSDEFID`, t1.`KEY4PSDEFNAME`, t1.`KEYPSDEFID`, t1.`KEYPSDEFNAME`, t1.`PSDEID`, t1.`PSDYNAINSTID`, t1.`PSUWDEUNIONKEYID`, t1.`PSUWDEUNIONKEYNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSUWDEUNIONKEY` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="KEY2PSDEFID", expression="t1.`KEY2PSDEFID`", showorder=2), @DEDataQueryCodeExp(name="KEY2PSDEFNAME", expression="t1.`KEY2PSDEFNAME`", showorder=3), @DEDataQueryCodeExp(name="KEY3PSDEFID", expression="t1.`KEY3PSDEFID`", showorder=4), @DEDataQueryCodeExp(name="KEY3PSDEFNAME", expression="t1.`KEY3PSDEFNAME`", showorder=5), @DEDataQueryCodeExp(name="KEY4PSDEFID", expression="t1.`KEY4PSDEFID`", showorder=6), @DEDataQueryCodeExp(name="KEY4PSDEFNAME", expression="t1.`KEY4PSDEFNAME`", showorder=7), @DEDataQueryCodeExp(name="KEYPSDEFID", expression="t1.`KEYPSDEFID`", showorder=8), @DEDataQueryCodeExp(name="KEYPSDEFNAME", expression="t1.`KEYPSDEFNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEID", expression="t1.`PSDEID`", showorder=10), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=11), @DEDataQueryCodeExp(name="PSUWDEUNIONKEYID", expression="t1.`PSUWDEUNIONKEYID`", showorder=12), @DEDataQueryCodeExp(name="PSUWDEUNIONKEYNAME", expression="t1.`PSUWDEUNIONKEYNAME`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.KEY2PSDEFID, t1.KEY2PSDEFNAME, t1.KEY3PSDEFID, t1.KEY3PSDEFNAME, t1.KEY4PSDEFID, t1.KEY4PSDEFNAME, t1.KEYPSDEFID, t1.KEYPSDEFNAME, t1.PSDEID, t1.PSDYNAINSTID, t1.PSUWDEUNIONKEYID, t1.PSUWDEUNIONKEYNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSUWDEUNIONKEY t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="KEY2PSDEFID", expression="t1.KEY2PSDEFID", showorder=2), @DEDataQueryCodeExp(name="KEY2PSDEFNAME", expression="t1.KEY2PSDEFNAME", showorder=3), @DEDataQueryCodeExp(name="KEY3PSDEFID", expression="t1.KEY3PSDEFID", showorder=4), @DEDataQueryCodeExp(name="KEY3PSDEFNAME", expression="t1.KEY3PSDEFNAME", showorder=5), @DEDataQueryCodeExp(name="KEY4PSDEFID", expression="t1.KEY4PSDEFID", showorder=6), @DEDataQueryCodeExp(name="KEY4PSDEFNAME", expression="t1.KEY4PSDEFNAME", showorder=7), @DEDataQueryCodeExp(name="KEYPSDEFID", expression="t1.KEYPSDEFID", showorder=8), @DEDataQueryCodeExp(name="KEYPSDEFNAME", expression="t1.KEYPSDEFNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEID", expression="t1.PSDEID", showorder=10), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=11), @DEDataQueryCodeExp(name="PSUWDEUNIONKEYID", expression="t1.PSUWDEUNIONKEYID", showorder=12), @DEDataQueryCodeExp(name="PSUWDEUNIONKEYNAME", expression="t1.PSUWDEUNIONKEYNAME", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15)}, conds={})})
public class PSUWDEUnionKeyDefaultDQModel
extends DEDataQueryModelBase {
    public PSUWDEUnionKeyDefaultDQModel() {
        this.initAnnotation(PSUWDEUnionKeyDefaultDQModel.class);
    }
}

