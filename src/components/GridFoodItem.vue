<template>
  <tr>
    <td>{{ aliment.id }}</td>
    <td>{{ aliment.name }}</td>
    <td>{{ aliment.stock }}</td>
    <td>{{ aliment.price }}</td>
    <td class="d-flex justify-content-around">
      <FormFoodButton variant="info" text="Edit" :alimentSelected="aliment" />
      <button class="btn btn-danger" @click="deleteFood()">Delete</button>
    </td>
  </tr>
</template>

<script>
import FormFoodButton from "@/components/FormFoodButton";
import { mapState, mapActions } from "vuex";

export default {
  name: "GridFoodItem",
  props: ["aliment"],
  components: {
    FormFoodButton,
  },
  data() {
    return {};
  },
  methods: {
    ...mapActions(["setEditForm"]),
    async deleteFood() {
      console.log("Deleting food...");
      const url = `http://localhost:8081/food/${this.aliment.id}`;
      await fetch(url, {
        method: "DELETE",
      }).catch((error) => console.error("Error:", error));
      this.$emit("fetch-food");
    },
  },
  computed: {
    ...mapState(["alimentSelected"]),
  },
};
</script>
