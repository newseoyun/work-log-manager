<template>
  <v-app-bar
    dark
    outlined
  >
    <v-app-bar-nav-icon @click="drawer = !drawer" />

    <v-toolbar-title class="ml-3 font-weight-bold">{{ $route.name || `MAIN` }}</v-toolbar-title>

    <v-spacer />

    <v-btn icon>
      <v-icon>mdi-magnify</v-icon>
    </v-btn>

    <v-btn icon class="ml-2">
      <v-icon>mdi-filter</v-icon>
    </v-btn>

    <v-btn icon class="ml-2">
      <v-icon>mdi-dots-vertical</v-icon>
    </v-btn>
  </v-app-bar>

  <v-navigation-drawer
    v-model="drawer"
    app
    absolute
  >
    <v-list
      nav
    >
      <v-list-item-group
        v-model="links"
        class=" text--accent-4"
      >
      <template v-for="(item, index) in links" :key="index">
        <v-list-item
          link
          :to="item.to"
        >
          <v-list-item-icon class="mr-3">
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </template>
      </v-list-item-group>
    </v-list>
  </v-navigation-drawer>
</template>
<script>
import { mapState } from 'vuex'

export default {
  computed: {
    ...mapState([
      'links'
    ]),
    drawer: {
      get() {
        console.log("(get) store => ", this.$store);
        return this.$store.getters.getDrawer
      },
      set(value) {
        console.log("set value ", value)
        return this.$store.commit('setDrawer', value)
      }
    }
  },
  methods: {

  }
}
</script>
<style lang="">

</style>
