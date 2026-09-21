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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwcreatededef.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="09E19B86-58E7-42F4-ACBE-4C968B1CFBC9", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CODENAME`, t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DEFPARAM`, t1.`DEFPARAM2`, t1.`DEFPARAM3`, t1.`DEFPARAM4`, t1.`NEWCODENAME`, t1.`NEWDEFLOGICNAME`, t1.`NEWDEFNAME`, t1.`PSDEFID`, t1.`PSDEFNAME`, t1.`PSDYNAINSTID`, t1.`PSUWCREATEDEDEFID`, t1.`PSUWCREATEDEDEFNAME`, t1.`PSUWCREATEDEID`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`WIZARDMODE` FROM `T_SRFPSUWCREATEDEDEF` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.`CODENAME`", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=2), @DEDataQueryCodeExp(name="DEFPARAM", expression="t1.`DEFPARAM`", showorder=3), @DEDataQueryCodeExp(name="DEFPARAM2", expression="t1.`DEFPARAM2`", showorder=4), @DEDataQueryCodeExp(name="DEFPARAM3", expression="t1.`DEFPARAM3`", showorder=5), @DEDataQueryCodeExp(name="DEFPARAM4", expression="t1.`DEFPARAM4`", showorder=6), @DEDataQueryCodeExp(name="NEWCODENAME", expression="t1.`NEWCODENAME`", showorder=7), @DEDataQueryCodeExp(name="NEWDEFLOGICNAME", expression="t1.`NEWDEFLOGICNAME`", showorder=8), @DEDataQueryCodeExp(name="NEWDEFNAME", expression="t1.`NEWDEFNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.`PSDEFID`", showorder=10), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.`PSDEFNAME`", showorder=11), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=12), @DEDataQueryCodeExp(name="PSUWCREATEDEDEFID", expression="t1.`PSUWCREATEDEDEFID`", showorder=13), @DEDataQueryCodeExp(name="PSUWCREATEDEDEFNAME", expression="t1.`PSUWCREATEDEDEFNAME`", showorder=14), @DEDataQueryCodeExp(name="PSUWCREATEDEID", expression="t1.`PSUWCREATEDEID`", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=17), @DEDataQueryCodeExp(name="WIZARDMODE", expression="t1.`WIZARDMODE`", showorder=18)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CODENAME, t1.CREATEDATE, t1.CREATEMAN, t1.DEFPARAM, t1.DEFPARAM2, t1.DEFPARAM3, t1.DEFPARAM4, t1.NEWCODENAME, t1.NEWDEFLOGICNAME, t1.NEWDEFNAME, t1.PSDEFID, t1.PSDEFNAME, t1.PSDYNAINSTID, t1.PSUWCREATEDEDEFID, t1.PSUWCREATEDEDEFNAME, t1.PSUWCREATEDEID, t1.UPDATEDATE, t1.UPDATEMAN, t1.WIZARDMODE FROM T_SRFPSUWCREATEDEDEF t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CODENAME", expression="t1.CODENAME", showorder=0), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=1), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=2), @DEDataQueryCodeExp(name="DEFPARAM", expression="t1.DEFPARAM", showorder=3), @DEDataQueryCodeExp(name="DEFPARAM2", expression="t1.DEFPARAM2", showorder=4), @DEDataQueryCodeExp(name="DEFPARAM3", expression="t1.DEFPARAM3", showorder=5), @DEDataQueryCodeExp(name="DEFPARAM4", expression="t1.DEFPARAM4", showorder=6), @DEDataQueryCodeExp(name="NEWCODENAME", expression="t1.NEWCODENAME", showorder=7), @DEDataQueryCodeExp(name="NEWDEFLOGICNAME", expression="t1.NEWDEFLOGICNAME", showorder=8), @DEDataQueryCodeExp(name="NEWDEFNAME", expression="t1.NEWDEFNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.PSDEFID", showorder=10), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.PSDEFNAME", showorder=11), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=12), @DEDataQueryCodeExp(name="PSUWCREATEDEDEFID", expression="t1.PSUWCREATEDEDEFID", showorder=13), @DEDataQueryCodeExp(name="PSUWCREATEDEDEFNAME", expression="t1.PSUWCREATEDEDEFNAME", showorder=14), @DEDataQueryCodeExp(name="PSUWCREATEDEID", expression="t1.PSUWCREATEDEID", showorder=15), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=16), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=17), @DEDataQueryCodeExp(name="WIZARDMODE", expression="t1.WIZARDMODE", showorder=18)}, conds={})})
public class PSUWCreateDEDEFDefaultDQModel
extends DEDataQueryModelBase {
    public PSUWCreateDEDEFDefaultDQModel() {
        this.initAnnotation(PSUWCreateDEDEFDefaultDQModel.class);
    }
}

