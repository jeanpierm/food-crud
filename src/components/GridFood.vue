<template>
  <div>
    <div class="d-flex mt-5 mb-4 justify-content-center">
      <h1 class="text-center mr-3">Food CRUD</h1>
      <FormFoodButton variant="success" text="Create" />
      <FormFoodModal @save-food="saveFood()" />
    </div>
    <div v-if="food.length">
      <table class="table text-center table-sm border">
        <thead class="thead-light">
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Stock</th>
            <th scope="col">Price</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody v-for="aliment in food" :key="aliment.id">
          <GridFoodItem @fetch-food="fetchFood()" :aliment="aliment" />
        </tbody>
      </table>
    </div>
    <div v-else>
      <h3 class="text-center mt-5">No food found!</h3>
    </div>
  </div>
</template>

<script>
import GridFoodItem from "@/components/GridFoodItem";
import FormFoodModal from "@/components/FormFoodModal";
import FormFoodButton from "@/components/FormFoodButton";
import { mapState, mapActions } from "vuex";

export default {
  name: "GridFood",
  components: { GridFoodItem, FormFoodModal, FormFoodButton },
  data() {
    return {
      food: [],
    };
  },
  methods: {
    ...mapActions(["setEditForm"]),

    async fetchFood() {
      const food = [];

      console.log("Fetching food...");
      const url = "http://localhost:8081/food";
      const response = await fetch(url, {
        method: "GET",
      })
        .then((res) => res.json())
        .catch((error) => console.error("Error:", error));

      response.map((res) => {
        food.push({
          id: res.food_id,
          name: res.food_name,
          stock: res.food_stock,
          price: res.food_price,
        });
      });
      this.food = food;
    },

    async insertFood() {
      console.log("Creating a food...");
      const url = "http://localhost:8081/food";
      await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          food_name: this.alimentSelected.name,
          food_stock: this.alimentSelected.stock,
          food_price: this.alimentSelected.price,
        }),
      })
        .then(() => this.fetchFood())
        .catch((error) => console.error("Error:", error));
    },

    async updateFood() {
      console.log("Updating a food...");
      const url = "http://localhost:8081/food";
      await fetch(url, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          food_id: this.alimentSelected.id,
          food_name: this.alimentSelected.name,
          food_stock: this.alimentSelected.stock,
          food_price: this.alimentSelected.price,
        }),
      })
        .then(() => this.fetchFood())
        .catch((error) => console.error("Error:", error));
    },

    saveFood() {
      if (this.alimentSelected.id) {
        this.updateFood();
        this.swalSuccess("modified");
      } else {
        this.insertFood();
        this.swalSuccess("added");
      }
    },

    swalSuccess(actionName) {
      this.$swal.fire(
        `Food ${actionName} succesfully!`,
        `The ${this.alimentSelected.name} has been ${actionName}.`,
        "success"
      );
    },
  },
  computed: {
    ...mapState(["alimentSelected"]),
  },
  created() {
    this.fetchFood();
  },
};
</script>
