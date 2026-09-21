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
package net.ibizsys.pscore.srv.config.demodel.psmodelvaluegroup.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="DFE22714-0EE5-49BA-BCB6-440503D38DC3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`GROUPDESC`, t1.`MEMO`, t1.`PSCODELISTID`, t1.`PSCODELISTNAME`, t1.`PSMODELFIELDID`, t1.`PSMODELFIELDNAME`, t1.`PSMODELID`, t1.`PSMODELNAME`, t1.`PSMODELVALUEGROUPID`, t1.`PSMODELVALUEGROUPNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSMODELVALUEGROUP` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="GROUPDESC", expression="t1.`GROUPDESC`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSCODELISTID", expression="t1.`PSCODELISTID`", showorder=4), @DEDataQueryCodeExp(name="PSCODELISTNAME", expression="t1.`PSCODELISTNAME`", showorder=5), @DEDataQueryCodeExp(name="PSMODELFIELDID", expression="t1.`PSMODELFIELDID`", showorder=6), @DEDataQueryCodeExp(name="PSMODELFIELDNAME", expression="t1.`PSMODELFIELDNAME`", showorder=7), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.`PSMODELID`", showorder=8), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.`PSMODELNAME`", showorder=9), @DEDataQueryCodeExp(name="PSMODELVALUEGROUPID", expression="t1.`PSMODELVALUEGROUPID`", showorder=10), @DEDataQueryCodeExp(name="PSMODELVALUEGROUPNAME", expression="t1.`PSMODELVALUEGROUPNAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.GROUPDESC, t1.MEMO, t1.PSCODELISTID, t1.PSCODELISTNAME, t1.PSMODELFIELDID, t1.PSMODELFIELDNAME, t1.PSMODELID, t1.PSMODELNAME, t1.PSMODELVALUEGROUPID, t1.PSMODELVALUEGROUPNAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSMODELVALUEGROUP t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="GROUPDESC", expression="t1.GROUPDESC", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSCODELISTID", expression="t1.PSCODELISTID", showorder=4), @DEDataQueryCodeExp(name="PSCODELISTNAME", expression="t1.PSCODELISTNAME", showorder=5), @DEDataQueryCodeExp(name="PSMODELFIELDID", expression="t1.PSMODELFIELDID", showorder=6), @DEDataQueryCodeExp(name="PSMODELFIELDNAME", expression="t1.PSMODELFIELDNAME", showorder=7), @DEDataQueryCodeExp(name="PSMODELID", expression="t1.PSMODELID", showorder=8), @DEDataQueryCodeExp(name="PSMODELNAME", expression="t1.PSMODELNAME", showorder=9), @DEDataQueryCodeExp(name="PSMODELVALUEGROUPID", expression="t1.PSMODELVALUEGROUPID", showorder=10), @DEDataQueryCodeExp(name="PSMODELVALUEGROUPNAME", expression="t1.PSMODELVALUEGROUPNAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSModelValueGroupDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelValueGroupDefaultDQModel() {
        this.initAnnotation(PSModelValueGroupDefaultDQModel.class);
    }
}

