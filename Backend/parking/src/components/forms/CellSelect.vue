<template>
  <div>
    <label class="form-label fw-semibold">
      Celda disponible
    </label>

    <select
      class="form-select"
      :value="modelValue"
      @change="$emit('update:modelValue', $event.target.value)"
    >
      <option disabled value="">
        Selecciona una celda
      </option>

      <option
        v-for="cell in cells"
        :key="cell.id"
        :value="cell"
      >
        {{ cell.name }}
      </option>
    </select>
  </div>
</template>

<script setup>
defineProps({
  modelValue: Object,
  cells: Array
})
</script>