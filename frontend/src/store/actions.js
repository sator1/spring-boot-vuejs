import { TYPES as MUTATIONS } from "./mutations";
import { getProjects } from "./../api/api";
import { getProjectsMock } from "./../api/dataMock";

export const TYPES = {
  GET_PROJECTS: "getProjects"
};

export const creators = {
  getProjects: dispatch => dispatch(TYPES.GET_PROJECTS)
};

export const actions = {
  [TYPES.GET_PROJECTS]({ commit }) {
    return new Promise(() => {
      getProjects()
        .then(response => {
          commit(MUTATIONS.UPDATE_PROJECTS, {
            projects: response.projects
          });
        })
        .catch(error => {
          console.error(error);
          commit(MUTATIONS.UPDATE_PROJECTS, {
            ...getProjectsMock()
          });
        });
    });
  }
};
