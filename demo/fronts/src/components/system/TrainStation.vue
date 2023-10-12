<template>
  <div class="c">
    <div id="myechart" style="width: 600px;height:600px;" ref="demoh">
    </div>
    <div style="width: 400px;height: 600px; border: whitesmoke solid 2px">

    </div>
  </div>
</template>
<script setup lang="ts">
import * as echarts from "echarts"
import {mapData} from "@/assets/mapData"
import {onMounted, ref} from "vue";

const demoh = ref(null)
onMounted(() => {
  console.log(demoh.value)
  let myChart = echarts.init(demoh.value)
  echarts.registerMap('chinaMap',mapData)
  let option={
    geo:{
      type:"map",
      map:"chinaMap",
      roam:true,
      // label:{
      //   show:true,
      // }
    }
  }
  myChart.setOption(option)
})
</script>
<style>
#myechart{
  border: whitesmoke 2px solid;
}
.c{
  display: flex;
  justify-content: space-around;
  align-items: center;
}
</style>
<!--
<template>
  <v-chart class="chart" :option="option" autoresize />
</template>

<script setup>
import { use } from 'echarts/core';
import { CanvasRenderer } from 'echarts/renderers';
import { PieChart } from 'echarts/charts';
import {
  TitleComponent,
  TooltipComponent,
  LegendComponent,
} from 'echarts/components';
import VChart, { THEME_KEY } from 'vue-echarts';
import { ref, provide } from 'vue';

use([
  CanvasRenderer,
  PieChart,
  TitleComponent,
  TooltipComponent,
  LegendComponent,
]);

provide(THEME_KEY, 'dark');

const option = ref({
  title: {
    text: 'Traffic Sources',
    left: 'center',
  },
  tooltip: {
    trigger: 'item',
    formatter: '{a} <br/>{b} : {c} ({d}%)',
  },
  legend: {
    orient: 'vertical',
    left: 'left',
    data: ['Direct', 'Email', 'Ad Networks', 'Video Ads', 'Search Engines'],
  },
  series: [
    {
      name: 'Traffic Sources',
      type: 'pie',
      radius: '55%',
      center: ['50%', '60%'],
      data: [
        { value: 335, name: 'Direct' },
        { value: 310, name: 'Email' },
        { value: 234, name: 'Ad Networks' },
        { value: 135, name: 'Video Ads' },
        { value: 1548, name: 'Search Engines' },
      ],
      emphasis: {
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)',
        },
      },
    },
  ],
});
</script>

<style scoped>
.chart {
  height: 100vh;
}
</style>
-->
