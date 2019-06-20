<template>
  <main>
    <ViewHeader :heading="workspace.name" />
    <div>
      Diagram will be here
    </div>
  </main>
</template>

<script>
import ViewHeader from "@/components/ViewHeader.vue";

export default {
  name: "WorkspaceDetails",
  components: {
    ViewHeader
  },
  computed: {
    workspace() {
      const project = this.$store.state.projects.find(
        project => project.id === this.$route.params.projectId
      );
      return project.workspaces.find(
        workspace => workspace.id === this.$route.params.workspaceId
      );
    }
  }
};
</script>
