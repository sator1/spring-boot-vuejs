<template>
  <main>
    <ViewHeader :heading="project.name" />
    <table>
      <thead>
        <tr>
          <td>Title</td>
          <td>Owner</td>
          <td>Date modified</td>
          <td>Actions</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(workspace, i) in project.workspaces" :key="i">
          <td>
            <router-link
              :to="{ path: `/${project.id}/workspace/${workspace.id}` }"
            >
              {{ workspace.name }}
            </router-link>
          </td>
          <td>{{ workspace.owner }}</td>
          <td>{{ workspace.dateModified }}</td>
          <td>
            <router-link
              :to="{ path: `/${project.id}/workspace/${workspace.id}` }"
            >
              Edit
            </router-link>
            | Delete
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>

<script>
import ViewHeader from "@/components/ViewHeader.vue";

export default {
  name: "ProjectDetails",
  components: {
    ViewHeader
  },
  computed: {
    project() {
      return this.$store.state.projects.find(
        project => project.id === this.$route.params.projectId
      );
    }
  }
};
</script>
