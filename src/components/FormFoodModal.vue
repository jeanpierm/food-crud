<template>
  <div>
    <b-modal
      id="modal-1"
      centered
      :title="
        alimentSelected.id ? 'Food #' + alimentSelected.id : 'Insert a food'
      "
      @ok="handleOk"
      @show="handleShow"
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
        <span class="text-danger pl-2">
          <small>{{ isValidMsg }}</small>
        </span>
      </div>
    </b-modal>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "FormFood",
  data() {
    return {
      isValid: true,
    };
  },
  methods: {
    handleOk(bvModalEvt) {
      if (
        this.alimentSelected.name &&
        this.alimentSelected.stock &&
        this.alimentSelected.price
      ) {
        // Trigger submit handler
        this.isValid = true;
        this.$emit("save-food");
      } else {
        // Prevent modal from closing
        this.isValid = false;
        bvModalEvt.preventDefault();
      }
    },
    handleShow() {
      this.isValid = true;
    },
  },
  computed: {
    ...mapState(["alimentSelected"]),
    isValidMsg() {
      return this.isValid ? "" : "Enter all the data correctly please.";
    },
  },
};
</script>