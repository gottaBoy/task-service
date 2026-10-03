/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.tssdengine.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="e4da63c72c04866163e5a74ca984d13f",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="5FC72289-4F52-43EE-AB72-855389DF00CD",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class TSSDEngineDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public TSSDEngineDefaultDSModelBase() {
        super();

        this.initAnnotation(TSSDEngineDefaultDSModelBase.class);
    }




}