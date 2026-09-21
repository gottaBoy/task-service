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
package net.ibizsys.pscore.srv.config.demodel.pspfeditortype.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="7A5F97D2-C538-453F-BC1B-4E3E3FC8BB73", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`EDITORCLASS`, t1.`MEMO`, t1.`PSEDITORTYPEID`, t11.`PSEDITORTYPENAME`, t1.`PSPFEDITORTYPEID`, t1.`PSPFEDITORTYPENAME`, t1.`PSPFID`, t21.`PSPFNAME`, t1.`PSPFSTYLEID`, t31.`PSPFSTYLENAME`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSPFEDITORTYPE` t1  LEFT JOIN T_SRFPSEDITORTYPE t11 ON t1.PSEDITORTYPEID = t11.PSEDITORTYPEID  LEFT JOIN T_SRFPSPF t21 ON t1.PSPFID = t21.PSPFID  LEFT JOIN T_SRFPSPFSTYLE t31 ON t1.PSPFSTYLEID = t31.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="EDITORDESC", expression="t1.`EDITORDESC`", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="EDITORCLASS", expression="t1.`EDITORCLASS`", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.`MEMO`", showorder=3), @DEDataQueryCodeExp(name="PSEDITORTYPEID", expression="t1.`PSEDITORTYPEID`", showorder=4), @DEDataQueryCodeExp(name="PSEDITORTYPENAME", expression="t11.`PSEDITORTYPENAME`", showorder=5), @DEDataQueryCodeExp(name="PSPFEDITORTYPEID", expression="t1.`PSPFEDITORTYPEID`", showorder=6), @DEDataQueryCodeExp(name="PSPFEDITORTYPENAME", expression="t1.`PSPFEDITORTYPENAME`", showorder=7), @DEDataQueryCodeExp(name="PSPFID", expression="t1.`PSPFID`", showorder=8), @DEDataQueryCodeExp(name="PSPFNAME", expression="t21.`PSPFNAME`", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.`PSPFSTYLEID`", showorder=10), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t31.`PSPFSTYLENAME`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.EDITORCLASS, t1.MEMO, t1.PSEDITORTYPEID, t11.PSEDITORTYPENAME, t1.PSPFEDITORTYPEID, t1.PSPFEDITORTYPENAME, t1.PSPFID, t21.PSPFNAME, t1.PSPFSTYLEID, t31.PSPFSTYLENAME, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSPFEDITORTYPE t1  LEFT JOIN T_SRFPSEDITORTYPE t11 ON t1.PSEDITORTYPEID = t11.PSEDITORTYPEID  LEFT JOIN T_SRFPSPF t21 ON t1.PSPFID = t21.PSPFID  LEFT JOIN T_SRFPSPFSTYLE t31 ON t1.PSPFSTYLEID = t31.PSPFSTYLEID  ", querycodetemp="", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="EDITORDESC", expression="t1.EDITORDESC", showorder=-1), @DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="EDITORCLASS", expression="t1.EDITORCLASS", showorder=2), @DEDataQueryCodeExp(name="MEMO", expression="t1.MEMO", showorder=3), @DEDataQueryCodeExp(name="PSEDITORTYPEID", expression="t1.PSEDITORTYPEID", showorder=4), @DEDataQueryCodeExp(name="PSEDITORTYPENAME", expression="t11.PSEDITORTYPENAME", showorder=5), @DEDataQueryCodeExp(name="PSPFEDITORTYPEID", expression="t1.PSPFEDITORTYPEID", showorder=6), @DEDataQueryCodeExp(name="PSPFEDITORTYPENAME", expression="t1.PSPFEDITORTYPENAME", showorder=7), @DEDataQueryCodeExp(name="PSPFID", expression="t1.PSPFID", showorder=8), @DEDataQueryCodeExp(name="PSPFNAME", expression="t21.PSPFNAME", showorder=9), @DEDataQueryCodeExp(name="PSPFSTYLEID", expression="t1.PSPFSTYLEID", showorder=10), @DEDataQueryCodeExp(name="PSPFSTYLENAME", expression="t31.PSPFSTYLENAME", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSPFEditorTypeDefaultDQModel
extends DEDataQueryModelBase {
    public PSPFEditorTypeDefaultDQModel() {
        this.initAnnotation(PSPFEditorTypeDefaultDQModel.class);
    }
}

