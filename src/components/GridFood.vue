<template>
  <b-container>
    <h2>Food</h2>
    <!-- <b-table striped hover :items="food"> </b-table> -->
    <GridFoodItem />
  </b-container>
</template>

<script>
import GridFoodItem from "@/components/GridFoodItem";

export default {
  name: "GridFood",
  components: { GridFoodItem },
  data() {
    return {
      food: [{ id: 1, name: "manzana", stock: 10, price: 0.5, actions: "" }],
    };
  },
  methods: {},
  computed: {},
};
</script>
