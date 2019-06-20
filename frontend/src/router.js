import Vue from "vue";
import Router from "vue-router";
import Projects from "./views/Projects.vue";
import ProjectDetails from "./views/ProjectDetails";
import WorkspaceDetails from "./views/WorkspaceDetails";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "projects",
      component: Projects
    },
    {
      path: "/:projectId",
      name: "projectDetails",
      component: ProjectDetails
    },
    {
      path: "/:projectId/workspace/:workspaceId",
      name: "workspaceDetails",
      component: WorkspaceDetails
    }
  ]
});
