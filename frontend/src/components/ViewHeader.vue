<template>
  <div class="view-header">
    <header>
      <h1>{{ heading }}</h1>
    </header>
  </div>
</template>

<script>
export default {
  name: "ViewHeader",
  props: {
    heading: String
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss">
@import "./../styles/utils.scss";

.view-header {
  margin-bottom: 40px;
}

h1 {
  font-size: 21px;
  margin: 17px 0;
  text-align: left;
}

header {
  &::after {
    content: "";
    display: block;
    height: 1px;
    width: 100%;
    background: $grey;
  }
}
</style>
