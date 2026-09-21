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
package net.ibizsys.pscore.srv.config.demodel.pspfquicktempl.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="2D838A11-5985-428C-AAA3-2ED657E3DA43", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`MEMO`, t1.`PSPFID`, t1.`PSPFNAME`, t1.`PSPFQUICKTEMPLID`, t1.`PSPFQUICKTEMPLNAME`, t1.`STYLECODE`, t1.`TEMPLCODE`, t1.`UPDATEDATE`, t1.`UPDATEMAN`, t1.`VALIDFLAG` FROM `T_SRFPSPFQUICKTEMPL` t1  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=2), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=3), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.`PSPFNAME`", showorder=4), @DEDataQueryCodeExp(name="PSPFQUICKTEMPLID", expression="t1.`PSPFQUICKTEMPLID`", showorder=5), @DEDataQueryCodeExp(name="PSPFQUICKTEMPLNAME", expression="t1.`PSPFQUICKTEMPLNAME`", showorder=6), @DEDataQueryCodeExp(name="STYLECODE", expression="t1.`STYLECODE`", showorder=7), @DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.`TEMPLCODE`", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.`VALIDFLAG`", showorder=11)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.MEMO, t1.PSPFID, t1.PSPFNAME, t1.PSPFQUICKTEMPLID, t1.PSPFQUICKTEMPLNAME, t1.STYLECODE, t1.TEMPLCODE, t1.UPDATEDATE, t1.UPDATEMAN, t1.VALIDFLAG FROM T_SRFPSPFQUICKTEMPL t1  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=2), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=3), @DEDataQueryCodeExp(name="PSPFNAME", expression="t1.PSPFNAME", showorder=4), @DEDataQueryCodeExp(name="PSPFQUICKTEMPLID", expression="t1.PSPFQUICKTEMPLID", showorder=5), @DEDataQueryCodeExp(name="PSPFQUICKTEMPLNAME", expression="t1.PSPFQUICKTEMPLNAME", showorder=6), @DEDataQueryCodeExp(name="STYLECODE", expression="t1.STYLECODE", showorder=7), @DEDataQueryCodeExp(name="TEMPLCODE", expression="t1.TEMPLCODE", showorder=8), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=9), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=10), @DEDataQueryCodeExp(name="VALIDFLAG", expression="t1.VALIDFLAG", showorder=11)}, conds={})})
public class PSPFQuickTemplDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFQuickTemplDefaultDQModel() {
        this.initAnnotation(PSPFQuickTemplDefaultDQModel.class);
    }
}

