import { IPSAppDataEntity, IPSAppDERS, IPSApplication } from "@ibiz/dynamic-model-api";
import { AppServiceBase } from "../app-service/app-base.service";

export class EntityPathService {

    /**
     * 当前应用实体路径Map
     *
     * @type {Map<number, IPSAppDERS[]>}
     * @memberof EntityPathService
     */
    private psAppDERSPathMap: Map<number, IPSAppDERS[]> = new Map<number, IPSAppDERS[]>();

    /**
     * 应用实体codeName
     *
     * @private
     * @type {string}
     * @memberof EntityPathService
     */
    private codeName!: string;

    /**
     * Creates an instance of EntityPathService.
     * @param {string} codeName
     * @memberof EntityPathService
     */
    public constructor(codeName: string) {
        this.codeName = codeName;
    }

    /**
     * 获取指定应用实体所有关系
     *
     * @param {string} codeName
     * @memberof EntityPathService
     */
    private getPSAppDERSs(codeName: string) {
        const app: IPSApplication = AppServiceBase.getInstance().getAppModelDataObject();
        const appDERSs: IPSAppDERS[] = [];
        if (app && app.getAllPSAppDERSs() && (app.getAllPSAppDERSs() as IPSAppDERS[]).length > 0) {
            (app.getAllPSAppDERSs() as IPSAppDERS[]).forEach((appDERS: IPSAppDERS) => {
                if (appDERS.minorDECodeName === codeName) {
                    appDERSs.push(appDERS);
                }
            })
        }
        return appDERSs;
    }

    /**
     * 填充指定应用实体所有关联路径
     *
     * @param {IPSAppDERS} iPSAppDERS
     * @param {IPSAppDERS[]} appDERSsArray
     * @memberof EntityPathService
     */
    private fillPSAppDERSPath(iPSAppDERS: IPSAppDERS, list: IPSAppDERS[]) {
        //判断路径中是否已经存在指定关系
        if (list.length > 0) {
            list.forEach((tempPSAppDERS: IPSAppDERS) => {
                if (iPSAppDERS.id === tempPSAppDERS.id) {
                    throw new Error(`应用实体${this.codeName}存在递归引用关系${iPSAppDERS.name}`);
                }
            })
        }
        list.unshift(iPSAppDERS);
        const majorList: IPSAppDERS[] = this.getPSAppDERSs(iPSAppDERS.majorDECodeName);
        if (majorList.length === 0) return;
        const srcList: IPSAppDERS[] = [];
        list.forEach((appDERS: IPSAppDERS) => {
            srcList.push(appDERS);
        })
        let nIndex: number = 0;
        majorList.forEach((tempPSAppDERS: IPSAppDERS) => {
            if (tempPSAppDERS.majorDECodeName === tempPSAppDERS.minorDECodeName) {
                return;
            }
            if (nIndex === 0) {
                if (iPSAppDERS.majorDEMajor !== false) {
                    //主实体，备份当前路径
                    const list2: IPSAppDERS[] = [];
                    srcList.forEach((appDERS: IPSAppDERS) => {
                        list2.push(appDERS);
                    })
                    const nIndex2 = this.psAppDERSPathMap.size;
                    this.psAppDERSPathMap.set(nIndex2, list2);
                }
                //继续主路径
                this.fillPSAppDERSPath(tempPSAppDERS, list);
            } else {
                //克隆新路径
                const list2: IPSAppDERS[] = [];
                srcList.forEach((appDERS: IPSAppDERS) => {
                    list2.push(appDERS);
                })
                const nIndex2 = this.psAppDERSPathMap.size;
                this.psAppDERSPathMap.set(nIndex2, list2);
                this.fillPSAppDERSPath(tempPSAppDERS, list2);
            }
            nIndex++;
        })
    }

    /**
     * 处理应用实体路径
     *
     * @private
     * @memberof EntityPathService
     */
    private handlePSAppDERSPaths() {
        const pathResult: Array<Array<string>> = [];
        if (this.psAppDERSPathMap.size > 0) {
            const iterator = this.psAppDERSPathMap.values();
            let i = 0;
            while (i < this.psAppDERSPathMap.size) {
                const list = iterator.next().value;
                if (list && list.length > 0) {
                    const path: Array<string> = [];
                    list.forEach((appDERS: IPSAppDERS) => {
                        path.push(appDERS.majorDECodeName);
                    })
                    pathResult.push(path);
                }
                i++;
            }
        }
        if (pathResult.length > 0) {
            pathResult.sort((a: Array<string>, b: Array<string>) => {
                return b.length - a.length;
            })
        }
        return pathResult;
    }

    /**
     * 获取指定应用实体所有路径
     *
     * @param {IPSAppDataEntity} appDataEntity
     * @memberof EntityPathService
     */
    public getPSAppDERSPaths() {
        const appDERSs: IPSAppDERS[] = this.getPSAppDERSs(this.codeName);
        if (appDERSs.length === 0) {
            return [];
        }
        appDERSs.forEach((appDERS: IPSAppDERS) => {
            if (appDERS.minorDECodeName === appDERS.majorDECodeName) {
                return;
            }
            const list: IPSAppDERS[] = [];
            const nIndex = this.psAppDERSPathMap.size;
            this.psAppDERSPathMap.set(nIndex, list);
            this.fillPSAppDERSPath(appDERS, list);
        })
        return this.handlePSAppDERSPaths();
    }

}