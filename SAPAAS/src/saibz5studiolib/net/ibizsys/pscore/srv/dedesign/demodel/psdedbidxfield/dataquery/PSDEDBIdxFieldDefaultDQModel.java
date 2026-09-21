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
package net.ibizsys.pscore.srv.dedesign.demodel.psdedbidxfield.dataquery;

import net.ibizsys.paas.core.DEDataQuery;
import net.ibizsys.paas.core.DEDataQueryCode;
import net.ibizsys.paas.core.DEDataQueryCodeExp;
import net.ibizsys.paas.core.DEDataQueryCodes;
import net.ibizsys.paas.demodel.DEDataQueryModelBase;

@DEDataQuery(id="4E6D1F86-CE08-4B0B-B7EA-D24B35B947A3", name="DEFAULT", defaultmode=true)
@DEDataQueryCodes(value={@DEDataQueryCode(querycode="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INCMODE`, t1.`INDEXLENGTH`, t1.`PSDEDBIDXFIELDID`, t1.`PSDEDBIDXFIELDNAME`, t1.`PSDEDBINDEXID`, t1.`PSDEDBINDEXNAME`, t1.`PSDEFID`, t1.`PSDEFNAME`, t11.`PSDEID`, t1.`SORTDIR`, t1.`UPDATEDATE`, t1.`UPDATEMAN` FROM `T_SRFPSDEDBIDXFIELD` t1  LEFT JOIN `T_SRFPSDEFIELD` t11 ON t1.`PSDEFID` = t11.`PSDEFIELDID`  ", querycodetemp="SELECT t1.`CREATEDATE`, t1.`CREATEMAN`, t1.`INCMODE`, t1.`INDEXLENGTH`, t1.`PSDEDBIDXFIELDID`, t1.`PSDEDBIDXFIELDNAME`, t1.`PSDEDBINDEXID`, t1.`PSDEDBINDEXNAME`, t1.`PSDEFID`, t1.`PSDEFNAME`, t11.`PSDEID`, t1.`SORTDIR`, t1.`UPDATEDATE`, t1.`UPDATEMAN`,t1.`SRFORIKEY` AS `SRFORIKEY`,t1.`SRFDRAFTFLAG` AS `SRFDRAFTFLAG` FROM `T_SRFPSDEDBIDXFIELD_TMP` t1  LEFT JOIN `T_SRFPSDEFIELD` t11 ON t1.`PSDEFID` = t11.`PSDEFIELDID`  ", declarecode="", dbtype="MYSQL5", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.`CREATEDATE`", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.`CREATEMAN`", showorder=1), @DEDataQueryCodeExp(name="INCMODE", expression="t1.`INCMODE`", showorder=2), @DEDataQueryCodeExp(name="INDEXLENGTH", expression="t1.`INDEXLENGTH`", showorder=3), @DEDataQueryCodeExp(name="PSDEDBIDXFIELDID", expression="t1.`PSDEDBIDXFIELDID`", showorder=4), @DEDataQueryCodeExp(name="PSDEDBIDXFIELDNAME", expression="t1.`PSDEDBIDXFIELDNAME`", showorder=5), @DEDataQueryCodeExp(name="PSDEDBINDEXID", expression="t1.`PSDEDBINDEXID`", showorder=6), @DEDataQueryCodeExp(name="PSDEDBINDEXNAME", expression="t1.`PSDEDBINDEXNAME`", showorder=7), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.`PSDEFID`", showorder=8), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.`PSDEFNAME`", showorder=9), @DEDataQueryCodeExp(name="PSDEID", expression="t11.`PSDEID`", showorder=10), @DEDataQueryCodeExp(name="SORTDIR", expression="t1.`SORTDIR`", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.`UPDATEDATE`", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.`UPDATEMAN`", showorder=13)}, conds={}), @DEDataQueryCode(querycode="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.INCMODE, t1.INDEXLENGTH, t1.PSDEDBIDXFIELDID, t1.PSDEDBIDXFIELDNAME, t1.PSDEDBINDEXID, t1.PSDEDBINDEXNAME, t1.PSDEFID, t1.PSDEFNAME, t11.PSDEID, t1.SORTDIR, t1.UPDATEDATE, t1.UPDATEMAN FROM T_SRFPSDEDBIDXFIELD t1  LEFT JOIN T_SRFPSDEFIELD t11 ON t1.PSDEFID = t11.PSDEFIELDID  ", querycodetemp="SELECT t1.CREATEDATE, t1.CREATEMAN, t1.INCMODE, t1.INDEXLENGTH, t1.PSDEDBIDXFIELDID, t1.PSDEDBIDXFIELDNAME, t1.PSDEDBINDEXID, t1.PSDEDBINDEXNAME, t1.PSDEFID, t1.PSDEFNAME, t11.PSDEID, t1.SORTDIR, t1.UPDATEDATE, t1.UPDATEMAN,t1.SRFORIKEY AS SRFORIKEY,t1.SRFDRAFTFLAG AS SRFDRAFTFLAG FROM T_SRFPSDEDBIDXFIELD_TMP t1  LEFT JOIN T_SRFPSDEFIELD t11 ON t1.PSDEFID = t11.PSDEFIELDID  ", declarecode="", dbtype="ORACLE", fieldexps={@DEDataQueryCodeExp(name="CREATEDATE", expression="t1.CREATEDATE", showorder=0), @DEDataQueryCodeExp(name="CREATEMAN", expression="t1.CREATEMAN", showorder=1), @DEDataQueryCodeExp(name="INCMODE", expression="t1.INCMODE", showorder=2), @DEDataQueryCodeExp(name="INDEXLENGTH", expression="t1.INDEXLENGTH", showorder=3), @DEDataQueryCodeExp(name="PSDEDBIDXFIELDID", expression="t1.PSDEDBIDXFIELDID", showorder=4), @DEDataQueryCodeExp(name="PSDEDBIDXFIELDNAME", expression="t1.PSDEDBIDXFIELDNAME", showorder=5), @DEDataQueryCodeExp(name="PSDEDBINDEXID", expression="t1.PSDEDBINDEXID", showorder=6), @DEDataQueryCodeExp(name="PSDEDBINDEXNAME", expression="t1.PSDEDBINDEXNAME", showorder=7), @DEDataQueryCodeExp(name="PSDEFID", expression="t1.PSDEFID", showorder=8), @DEDataQueryCodeExp(name="PSDEFNAME", expression="t1.PSDEFNAME", showorder=9), @DEDataQueryCodeExp(name="PSDEID", expression="t11.PSDEID", showorder=10), @DEDataQueryCodeExp(name="SORTDIR", expression="t1.SORTDIR", showorder=11), @DEDataQueryCodeExp(name="UPDATEDATE", expression="t1.UPDATEDATE", showorder=12), @DEDataQueryCodeExp(name="UPDATEMAN", expression="t1.UPDATEMAN", showorder=13)}, conds={})})
public class PSDEDBIdxFieldDefaultDQModel
extends DEDataQueryModelBase {
    public PSDEDBIdxFieldDefaultDQModel() {
        this.initAnnotation(PSDEDBIdxFieldDefaultDQModel.class);
    }
}

