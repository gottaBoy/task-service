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
package net.ibizsys.pscore.srv.config.demodel.psmodelviewuiaction.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="78597EEA-4AE8-4AB3-81A3-5926EBE4BAC0", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`ORDERVALUE`, t1.`PSMODELUIACTIONID`, t11.`PSMODELUIACTIONNAME`, t1.`PSMODELVIEWID`, t21.`PSMODELVIEWNAME`, t1.`PSMODELVIEWUIACTIONID`, t1.`PSMODELVIEWUIACTIONNAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSMODELVIEWUIACTION` t1  LEFT JOIN T_SRFPSMODELUIACTION t11 ON t1.PSMODELUIACTIONID = t11.PSMODELUIACTIONID  LEFT JOIN T_SRFPSMODELVIEW t21 ON t1.PSMODELVIEWID = t21.PSMODELVIEWID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="BOTTOMCONTENT", expression="t1.`BOTTOMCONTENT`", showorder=-1), @DEDataQueryCodeExp(name="CONTENT", expression="t1.`CONTENT`", showorder=-1), @DEDataQueryCodeExp(name="HEADERCONTENT", expression="t1.`HEADERCONTENT`", showorder=-1), @DEDataQueryCodeExp(name="UIACTIONDESC", expression="t1.`UIACTIONDESC`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.`ORDERVALUE`", showorder=3), @DEDataQueryCodeExp(name="PSMODELUIACTIONID", expression="t1.`PSMODELUIACTIONID`", showorder=4), @DEDataQueryCodeExp(name="PSMODELUIACTIONNAME", expression="t11.`PSMODELUIACTIONNAME`", showorder=5), @DEDataQueryCodeExp(name="PSMODELVIEWID", expression="t1.`PSMODELVIEWID`", showorder=6), @DEDataQueryCodeExp(name="PSMODELVIEWNAME", expression="t21.`PSMODELVIEWNAME`", showorder=7), @DEDataQueryCodeExp(name="PSMODELVIEWUIACTIONID", expression="t1.`PSMODELVIEWUIACTIONID`", showorder=8), @DEDataQueryCodeExp(name="PSMODELVIEWUIACTIONNAME", expression="t1.`PSMODELVIEWUIACTIONNAME`", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=12)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.ORDERVALUE, t1.PSMODELUIACTIONID, t11.PSMODELUIACTIONNAME, t1.PSMODELVIEWID, t21.PSMODELVIEWNAME, t1.PSMODELVIEWUIACTIONID, t1.PSMODELVIEWUIACTIONNAME, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSMODELVIEWUIACTION t1  LEFT JOIN T_SRFPSMODELUIACTION t11 ON t1.PSMODELUIACTIONID = t11.PSMODELUIACTIONID  LEFT JOIN T_SRFPSMODELVIEW t21 ON t1.PSMODELVIEWID = t21.PSMODELVIEWID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="BOTTOMCONTENT", expression="t1.BOTTOMCONTENT", showorder=-1), @DEDataQueryCodeExp(name="CONTENT", expression="t1.CONTENT", showorder=-1), @DEDataQueryCodeExp(name="HEADERCONTENT", expression="t1.HEADERCONTENT", showorder=-1), @DEDataQueryCodeExp(name="UIACTIONDESC", expression="t1.UIACTIONDESC", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="ORDERVALUE", expression="t1.ORDERVALUE", showorder=3), @DEDataQueryCodeExp(name="PSMODELUIACTIONID", expression="t1.PSMODELUIACTIONID", showorder=4), @DEDataQueryCodeExp(name="PSMODELUIACTIONNAME", expression="t11.PSMODELUIACTIONNAME", showorder=5), @DEDataQueryCodeExp(name="PSMODELVIEWID", expression="t1.PSMODELVIEWID", showorder=6), @DEDataQueryCodeExp(name="PSMODELVIEWNAME", expression="t21.PSMODELVIEWNAME", showorder=7), @DEDataQueryCodeExp(name="PSMODELVIEWUIACTIONID", expression="t1.PSMODELVIEWUIACTIONID", showorder=8), @DEDataQueryCodeExp(name="PSMODELVIEWUIACTIONNAME", expression="t1.PSMODELVIEWUIACTIONNAME", showorder=9), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=10), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=11), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=12)}, conds={})})
public class PSModelViewUIActionDefaultDQModel
extends DEDataQueryModelBase {
    public PSModelViewUIActionDefaultDQModel() {
        this.initAnnotation(PSModelViewUIActionDefaultDQModel.class);
    }
}

