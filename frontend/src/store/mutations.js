export const TYPES = {
  UPDATE_PROJECTS: "updateProjects"
};

export const mutations = {
  updateProjects: (state, payload) => {
    state.projects = payload.projects;
  }
};
