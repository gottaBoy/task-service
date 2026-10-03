/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.datasyncin2.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="04c87ff6cdac6dd390613dbc44f3c51d",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="4E05B8C8-FB41-482B-9B32-CEBB49342CCD",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class DataSyncIn2DefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public DataSyncIn2DefaultDSModelBase() {
        super();

        this.initAnnotation(DataSyncIn2DefaultDSModelBase.class);
    }




}