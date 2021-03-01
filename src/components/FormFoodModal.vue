<template>
  <div>
    <b-modal
      id="modal-1"
      :title="
        alimentSelected.id ? 'Food #' + alimentSelected.id : 'Insert a food'
      "
      @ok="$emit('save-food')"
    >
      <div class="form-group">
        <label for="name">Name</label>
        <input
          type="text"
          class="form-control"
          id="name"
          v-model="alimentSelected.name"
        />
      </div>
      <div class="form-row">
        <div class="form-group col-md-6">
          <label for="stock">Stock</label>
          <input
            type="number"
            class="form-control"
            id="stock"
            v-model="alimentSelected.stock"
          />
        </div>
        <div class="form-group col-md-6">
          <label for="price">Price</label>
          <input
            type="number"
            class="form-control"
            id="price"
            v-model="alimentSelected.price"
          />
        </div>
      </div>
    </b-modal>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "FormFood",
  computed: {
    ...mapState(["alimentSelected"]),
  },
};
</script>