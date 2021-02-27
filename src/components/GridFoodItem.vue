<template>
  <div>
    <p>{{ name }}</p>
  </div>
</template>

<script>
export default {
  name: "GridFoodItem",
  data() {
    return {
      id: 0,
      name: "generic",
      stock: 0,
      price: 0,
    };
  },
};
</script>
