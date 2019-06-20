<template>
  <nav class="sidebar">
    <h2><router-link to="/">reccy</router-link></h2>
    <ul class="sidebar-list-icons">
      <li><router-link to="/">Account</router-link></li>
      <li><router-link to="/">Notifications</router-link></li>
      <li><router-link to="/">Settings</router-link></li>
    </ul>
    <h3><router-link to="/">Projects</router-link></h3>
    <ul class="sidebar-list-projects" v-if="projects.length">
      <li v-for="(project, i) in projects" :key="i">
        <router-link :to="{ path: '/' + project.id }">
          {{ project.name }}
        </router-link>
        <ul class="sidebar-list-workspaces" v-if="project.workspaces.length">
          <li v-for="(workspace, j) in project.workspaces" :key="j">
            <router-link
              :to="{ path: `/${project.id}/workspace/${workspace.id}` }"
            >
              {{ workspace.name }}
            </router-link>
          </li>
        </ul>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "Sidebar",
  props: {
    projects: {
      type: Array,
      required: true
    }
  }
};
</script>

<style lang="scss">
@import "./../styles/utils.scss";

.sidebar {
  padding: 25px;
  width: 250px;
  background: $grey;
  color: $white;
  font-size: 14px;

  ul {
    padding: 0;
    list-style: none;
  }

  a {
    color: $white;

    &:hover,
    &:focus {
      color: $green;
    }
  }

  h2 {
    font-weight: bold;
  }

  h3 {
    text-align: left;
    font-size: 14px;
    font-weight: normal;
    margin: 0;
    line-height: 1.7;
  }

  .sidebar-list-icons {
    border-top: 1px solid $white;
    border-bottom: 1px solid $white;
    padding: 10px 0;
    display: flex;
    justify-content: space-evenly;
  }

  .sidebar-list-projects {
    margin: 0;
    padding-left: 15px;
    line-height: 1.7;
    text-align: left;
  }

  .sidebar-list-workspaces {
    padding-left: 15px;
  }
}
</style>
