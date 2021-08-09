<template>
<v-container>
  <h1>data test</h1>
  <v-card>
    <v-card-title>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
      :headers="headers"
      :items="desserts"
      :search="search"
    ></v-data-table>
  </v-card>
  <ag-grid-vue
    style="width: 800px; height:500px"
    class="ag-theme-alpine"
    :columnDefs="columnDefs"
    :rowData="rowData"
  />


</v-container>
</template>

<script>
import { AgGridVue } from 'ag-grid-vue3';

export default {
  name: 'App',
  data() {
    return {
        columnDefs: null,
        rowData: null
    }
  },
  components: {
    AgGridVue
  },
  beforeMount() {
    this.columnDefs = [
        { field: 'make' },
        { field: 'model' },
        { field: 'price' }
    ];

    this.rowData = [
        { make: 'Toyota', model: 'Celica', price: 35000 },
        { make: 'Ford', model: 'Mondeo', price: 32000 },
        { make: 'Porsche', model: 'Boxter', price: 72000 }
    ];
  }
}
</script>
