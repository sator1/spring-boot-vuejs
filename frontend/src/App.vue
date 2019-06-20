<template>
  <div id="app">
    <Sidebar :projects="projects" />
    <router-view />
  </div>
</template>

<script>
import { creators as actions } from "./store/actions";
import Sidebar from "@/components/Sidebar.vue";

export default {
  components: {
    Sidebar
  },
  mounted() {
    actions.getProjects(this.$store.dispatch);
  },
  computed: {
    projects() {
      return this.$store.state.projects;
    }
  }
};
</script>

<style lang="scss">
@import "@/styles/index.scss";

#app {
  width: 100%;
  font-family: "Lato", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  display: flex;
  flex-grow: 1;
  background: $white;
}

#nav {
  padding: 30px;
  a {
    font-weight: bold;
    color: #2c3e50;
    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
