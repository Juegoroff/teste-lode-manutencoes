<script setup>
import { ref, computed, onMounted } from 'vue'
import axios from 'axios'

const equipamentos = ref([])
const busca = ref('')

const carregarEquipamentos = async () => {
  try {
    const response = await axios.get(
      'http://localhost:8080/equipamentos'
    )

    equipamentos.value = response.data
  } catch (error) {
    console.error(error)
  }
}

const filtrados = computed(() =>
  equipamentos.value.filter(item =>
    item.nome.toLowerCase()
      .includes(busca.value.toLowerCase())
  )
)

onMounted(() => {
  carregarEquipamentos()
})
</script>

<template>
  <div class="container">
    <h1>Lode Manutenções</h1>

    <input
      v-model="busca"
      placeholder="Buscar equipamento"
      class="campo-busca"
    />

    <div
      class="card"
      v-for="equipamento in filtrados"
      :key="equipamento.id"
    >
      <h2>{{ equipamento.nome }}</h2>

      <p>
        <strong>Tipo:</strong>
        {{ equipamento.tipo }}
      </p>

      <p>
        <strong>Data:</strong>
        {{ equipamento.dataInstalacao }}
      </p>

      <p
        class="status"
        :class="equipamento.status"
      >
        {{ equipamento.status }}
      </p>
    </div>
  </div>
</template>

<style>
body {
  margin: 0;
  font-family: Arial, sans-serif;
}

.container {
  padding: 20px;
}

.campo-busca {
  width: 100%;
  padding: 10px;
  margin-bottom: 20px;
}

.card {
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 15px;
  margin-bottom: 10px;
}

.OPERACIONAL {
  color: green;
  font-weight: bold;
}

.MANUTENCAO_NECESSARIA {
  color: orange;
  font-weight: bold;
}

.CRITICO {
  color: red;
  font-weight: bold;
}
</style>