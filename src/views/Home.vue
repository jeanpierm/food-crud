<template>
  <div class="home">
    <GridFood />
  </div>
</template>

<script>
// @ is an alias to /src
import GridFood from "@/components/GridFood.vue";

export default {
  name: "Home",
  components: {
    GridFood,
  },
};
</script>
