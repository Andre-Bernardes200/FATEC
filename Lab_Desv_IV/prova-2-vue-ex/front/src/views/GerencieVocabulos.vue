<template>
    <div>
      <h1>Gerenciamento de Vocábulos</h1>
      
      <!-- Lista de Vocábulos -->
      <div v-if="vocabulos.length">
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Termo</th>
              <th>Significado</th>
              <th>Versão</th>
              <th>Situação</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="vocabulo in vocabulos" :key="vocabulo.id">
              <td>{{ vocabulo.id }}</td>
              <td>{{ vocabulo.termo }}</td>
              <td>{{ vocabulo.significado }}</td>
              <td>{{ vocabulo.versao }}</td>
              <td>{{ vocabulo.situacao }}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <p v-else>Nenhum vocábulo disponível.</p>
  
      <!-- Cadastro -->
      <div>
        <h2>Cadastrar Novo Vocábulo</h2>
        <input v-model="novoVocabulo.termo" placeholder="Termo" required />
        <input v-model="novoVocabulo.significado" placeholder="Significado" required />
        <input v-model="novoVocabulo.versao" placeholder="Versão" required />
        <input type="datetime-local" v-model="novoVocabulo.dataHoraDesativacao" />
        <button @click="cadastrarVocabulo">Cadastrar</button>
      </div>
  
      <!-- Consulta -->
      <div>
        <h2>Consultar Vocábulo</h2>
        <input v-model="filtro.termo" placeholder="Termo" />
        <input v-model="filtro.versao" placeholder="Versão" />
        <button @click="consultarVocabulo">Consultar</button>
        <button @click="limparConsulta">Limpar</button>
        
        <!-- Exibindo a lista de resultados da consulta -->
        <div v-if="resultadosConsulta.length">
          <h3>Resultados da Consulta:</h3>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Termo</th>
                <th>Significado</th>
                <th>Versão</th>
                <th>Situação</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="vocabulo in resultadosConsulta" :key="vocabulo.id">
                <td>{{ vocabulo.id }}</td>
                <td>{{ vocabulo.termo }}</td>
                <td>{{ vocabulo.significado }}</td>
                <td>{{ vocabulo.versao }}</td>
                <td>{{ vocabulo.situacao }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import axios from 'axios';
  
  const vocabulos = ref([]);
  const novoVocabulo = ref({ termo: '', significado: '', versao: '', dataHoraDesativacao: null });
  const filtro = ref({ termo: '', versao: '' });
  const resultadosConsulta = ref([]); // Lista para armazenar os resultados da consulta
  
  const carregarVocabulos = async () => {
    const response = await axios.get('http://localhost:8080/vocabulo');
    vocabulos.value = response.data.map(v => ({
      ...v,
      situacao: v.voc_data_hora_desativacao ? 'desativado' : 'ativo',
    }));
  };
  
  const cadastrarVocabulo = async () => {
    if (!novoVocabulo.value.termo || !novoVocabulo.value.significado || !novoVocabulo.value.versao) {
      alert('Preencha todos os campos obrigatórios.');
      return;
    }
    await axios.post('http://localhost:8080/vocabulo', novoVocabulo.value);
    novoVocabulo.value = { termo: '', significado: '', versao: '', dataHoraDesativacao: null };
    carregarVocabulos();
  };
  
  const consultarVocabulo = async () => {
    try {
      const { termo, versao } = filtro.value;

      if(termo.trim() == "" || versao.trim() == "" ){
        alert("Nenhum campo preenchido ou algum campo faltante")
            }
  
      const response = await axios.get(`http://localhost:8080/vocabulo/${termo}/${versao}`);
      
      if (response.data.length > 0) {
        resultadosConsulta.value = response.data.map(v => ({
          ...v,
          situacao: v.voc_data_hora_desativacao ? 'desativado' : 'ativo',
        }));
      } else { // Limpa a lista se nada for encontrado
        alert('Nenhum vocábulo encontrado.');
      }
    } catch (error) {
      console.error('Erro ao consultar vocábulos:', error); // Log de erro
    }
  };
  
  const limparConsulta = () => {
    filtro.value = { termo: '', versao: '' }; // Limpa os campos de filtro
    resultadosConsulta.value = []; // Limpa os resultados da consulta
  };
  
  carregarVocabulos();
  </script>
  