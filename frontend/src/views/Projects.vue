<template>
  <main class="content">
    <ViewHeader heading="Projects" />
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
        <tr v-for="(project, i) in projects" :key="i">
          <td>
            <router-link :to="{ path: '/' + project.id }">
              {{ project.name }}
            </router-link>
          </td>
          <td>{{ project.owner }}</td>
          <td>{{ project.dateModified }}</td>
          <td>
            <router-link :to="{ path: '/' + project.id }">Edit</router-link>
            | Delete
          </td>
        </tr>
      </tbody>
    </table>
  </main>
</template>

<script>
// @ is an alias to /src
import ViewHeader from "@/components/ViewHeader.vue";

export default {
  name: "home",
  components: {
    ViewHeader
  },
  computed: {
    projects() {
      return this.$store.state.projects;
    }
  }
};
</script>
