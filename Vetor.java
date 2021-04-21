import java.util.Arrays;

public class Vetor {
	//Iniciar com array
	private Aluno [] alunos = new Aluno [100];

	private int totalAlunos = 0;

	//adicionar aluno
	public void adiciona (Aluno aluno) {
		//apontar a próxima posicao vazia e armazena nela
		this.alunos[totalAlunos] = aluno;
		totalAlunos ++;		

		//METODO O(N)
		/*
		 * //loop que percorra todo o array e encontre uma posição vazia 
		 * for (int i=0; i < alunos.length; i++) {
		 * //Se a posição estiver vazia, armazena aluno 
		 * if (alunos[i]== null) { 
		 * alunos[i] = aluno; 
		 * break;
		 */
	}

	//Metodo para verificar se uma posicao é válida ou nao
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= totalAlunos;
	}		
	//METODO PARA ADICIONAR EM UMA POSICAO ESPECIFICA (O(N));
	public void adiciona(int posicao, Aluno aluno) {
		//Verifica se a posicao é válida
		 if (!posicaoValida(posicao)) {
			 throw new IllegalArgumentException("Posicao Invalida!");
		 }		
		//empurra um array pra direita pra abrir um espaço vazio no meio
		for (int i = totalAlunos -1; i >= posicao; i-=1 ) {
			alunos [i+1] = alunos [i];
		}
		alunos[posicao] = aluno;
		totalAlunos++;
	}


	//pegar aluno em x posicao
	private boolean posicaoOcupada(int posicao) {
		//para garantir que a posicao esteja de acordo com o array
		return posicao >= 0 && posicao < totalAlunos;
	}
	public Aluno pega (int posicao) {
		// se a posicao for diferente (negativa ou maior que o array)
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao Invalida");
		}
		return alunos[posicao];
	}

	// remover pela x posicao
	public void remove (int posicao) {
		//Começa na posicao que quer remover e pega o proximo numero e traz pro espaço vazio
		for (int i = posicao; i < this.totalAlunos -1; i++) {
			this.alunos[i] = alunos [i+1];			
		}
		totalAlunos--;
		this.alunos[totalAlunos] = null;

	}
	//Conferir se o aluno está na lista
	public boolean contem (Aluno aluno) {
		//percorre todo o array
		for (int i=0; i < totalAlunos; i++) {
			// se o aluno que eu quero comparar, for igual ao aluno na posicao 'i', entao retorna true
			if (aluno.equals(alunos[i])) {
				return true;			
			}
		}
		return false;
	}
	//quantidade de itens no vetor
	public int tamanho() {
		return totalAlunos;

	}
	//pegar todos os toStrings de todos os métodos
	public String toString() {
		return Arrays.toString(alunos);
	}
}
