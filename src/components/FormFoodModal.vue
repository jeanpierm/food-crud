<template>
  <div>
    <b-modal
      id="modal-1"
      :title="
        alimentSelected.id ? 'Food #' + alimentSelected.id : 'Insert a food'
      "
      @ok="handleOk"
    >
      <div class="form-group">
        <label for="name">Name</label>
        <input
          required
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
            required
            type="number"
            class="form-control"
            id="stock"
            v-model="alimentSelected.stock"
          />
        </div>
        <div class="form-group col-md-6">
          <label for="price">Price</label>
          <input
            required
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
  methods: {
    handleOk(bvModalEvt) {
      if (
        this.alimentSelected.name &&
        this.alimentSelected.stock &&
        this.alimentSelected.price
      ) {
        // Trigger submit handler
        this.$emit("save-food");
      } else {
        // Prevent modal from closing
        bvModalEvt.preventDefault();
      }
    },
  },
  computed: {
    ...mapState(["alimentSelected"]),
  },
};
</script>