<template>
  <v-app>
    <Drawer />
    <View />
  </v-app>
</template>
<script>
import Drawer from './Drawer'
import View from './View'

export default {
  name: 'MainLayout',
  components: {
    Drawer,
    View,
  },
}
</script>
<style lang="">

</style>
