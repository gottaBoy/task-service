import { viewAction } from './state';
import * as mutations from './mutations';
import * as getters from './getters';

const state = {
    ...viewAction
}

export default {
    namespaced: true,
    state,
    getters,
    mutations
}