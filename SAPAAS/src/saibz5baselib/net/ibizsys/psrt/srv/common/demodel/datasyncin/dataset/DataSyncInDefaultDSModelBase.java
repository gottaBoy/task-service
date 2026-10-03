/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncin.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="3621f160a6392fc07fea086d691daa0d",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="A14D2C92-C1B1-474B-BE28-C46CCD41DD59",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class DataSyncInDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public DataSyncInDefaultDSModelBase() {
        super();

        this.initAnnotation(DataSyncInDefaultDSModelBase.class);
    }




}