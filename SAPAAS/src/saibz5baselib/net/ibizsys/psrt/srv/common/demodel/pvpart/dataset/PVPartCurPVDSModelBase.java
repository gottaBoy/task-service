/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.pvpart.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="689C1D69-8EF0-41B1-B64B-EF6DBE6E6851",name="CurPV",queries= {
    @DEDataSetQuery(queryid="DEA9923C-7E2A-45D0-936D-656E1473764B",queryname="CurPV")
})

/**
 *  实体数据集合[当前门户视图]模型基类
 */
public abstract class PVPartCurPVDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public PVPartCurPVDSModelBase() {
        super();

        this.initAnnotation(PVPartCurPVDSModelBase.class);
    }




}