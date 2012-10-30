package br.com.caelum.financas.infra.search;



public enum Presenca {
	FACULTATIVO{
		@Override
		public String toString() {
			return "Facultativo";
		}
	}, OBRIGATORIO{
		@Override
		public String toString() {
			return "Obrigatório";
		}
	}, OBRIGATORIO_NAO_TER{
		@Override
		public String toString() {
			return "Obrigatório não ter";
		}
	};
}
