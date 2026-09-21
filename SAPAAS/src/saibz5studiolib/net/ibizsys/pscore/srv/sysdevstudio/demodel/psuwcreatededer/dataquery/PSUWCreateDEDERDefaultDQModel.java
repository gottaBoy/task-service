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
package net.ibizsys.pscore.srv.sysdevstudio.demodel.psuwcreatededer.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="24B38826-318F-4F1F-844C-CF008DAE365D", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`DERPARAM`, t1.`DERPARAM2`, t1.`DERPARAM3`, t1.`DERPARAM4`, t1.`NEWPICKUPDEFNAME`, t1.`PICKUPDEFNAME`, t1.`PSDERID`, t1.`PSDERNAME`, t1.`PSDYNAINSTID`, t1.`PSUWCREATEDEDERID`, t1.`PSUWCREATEDEDERNAME`, t1.`PSUWCREATEDEID`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`WIZARDMODE` FROM `T_SRFPSUWCREATEDEDER` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="DERPARAM", expression="t1.`DERPARAM`", showorder=2), @DEDataQueryCodeExp(name="DERPARAM2", expression="t1.`DERPARAM2`", showorder=3), @DEDataQueryCodeExp(name="DERPARAM3", expression="t1.`DERPARAM3`", showorder=4), @DEDataQueryCodeExp(name="DERPARAM4", expression="t1.`DERPARAM4`", showorder=5), @DEDataQueryCodeExp(name="NEWPICKUPDEFNAME", expression="t1.`NEWPICKUPDEFNAME`", showorder=6), @DEDataQueryCodeExp(name="PICKUPDEFNAME", expression="t1.`PICKUPDEFNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDERID", expression="t1.`PSDERID`", showorder=8), @DEDataQueryCodeExp(name="PSDERNAME", expression="t1.`PSDERNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.`PSDYNAINSTID`", showorder=10), @DEDataQueryCodeExp(name="PSUWCREATEDEDERID", expression="t1.`PSUWCREATEDEDERID`", showorder=11), @DEDataQueryCodeExp(name="PSUWCREATEDEDERNAME", expression="t1.`PSUWCREATEDEDERNAME`", showorder=12), @DEDataQueryCodeExp(name="PSUWCREATEDEID", expression="t1.`PSUWCREATEDEID`", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=15), @DEDataQueryCodeExp(name="WIZARDMODE", expression="t1.`WIZARDMODE`", showorder=16)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.DERPARAM, t1.DERPARAM2, t1.DERPARAM3, t1.DERPARAM4, t1.NEWPICKUPDEFNAME, t1.PICKUPDEFNAME, t1.PSDERID, t1.PSDERNAME, t1.PSDYNAINSTID, t1.PSUWCREATEDEDERID, t1.PSUWCREATEDEDERNAME, t1.PSUWCREATEDEID, t1.UPDATEDATE, t1.UPDATEMAN, t1.WIZARDMODE FROM T_SRFPSUWCREATEDEDER t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="DERPARAM", expression="t1.DERPARAM", showorder=2), @DEDataQueryCodeExp(name="DERPARAM2", expression="t1.DERPARAM2", showorder=3), @DEDataQueryCodeExp(name="DERPARAM3", expression="t1.DERPARAM3", showorder=4), @DEDataQueryCodeExp(name="DERPARAM4", expression="t1.DERPARAM4", showorder=5), @DEDataQueryCodeExp(name="NEWPICKUPDEFNAME", expression="t1.NEWPICKUPDEFNAME", showorder=6), @DEDataQueryCodeExp(name="PICKUPDEFNAME", expression="t1.PICKUPDEFNAME", showorder=7), @DEDataQueryCodeExp(name="PSDERID", expression="t1.PSDERID", showorder=8), @DEDataQueryCodeExp(name="PSDERNAME", expression="t1.PSDERNAME", showorder=9), @DEDataQueryCodeExp(name="PSDYNAINSTID", expression="t1.PSDYNAINSTID", showorder=10), @DEDataQueryCodeExp(name="PSUWCREATEDEDERID", expression="t1.PSUWCREATEDEDERID", showorder=11), @DEDataQueryCodeExp(name="PSUWCREATEDEDERNAME", expression="t1.PSUWCREATEDEDERNAME", showorder=12), @DEDataQueryCodeExp(name="PSUWCREATEDEID", expression="t1.PSUWCREATEDEID", showorder=13), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=14), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=15), @DEDataQueryCodeExp(name="WIZARDMODE", expression="t1.WIZARDMODE", showorder=16)}, conds={})})
public class PSUWCreateDEDERDefaultDQModel
extends DEDataQueryModelBase {
    public PSUWCreateDEDERDefaultDQModel() {
        this.initAnnotation(PSUWCreateDEDERDefaultDQModel.class);
    }
}

