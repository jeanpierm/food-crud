<template>
  <b-button
    v-b-modal.modal-1
    :variant="variant"
    @click="setEditForm(alimentSelected)"
    >{{ text }}
  </b-button>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "FormFoodButton",
  props: ["variant", "alimentSelected", "text"],
  methods: {
    ...mapActions(["setEditForm"]),
  },
};
</script>