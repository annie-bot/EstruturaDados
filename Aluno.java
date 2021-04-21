
public class Aluno {
	private String nome;
	public Aluno (String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		
		Aluno outro = (Aluno) obj;
		//Comparar um nome com o outro		
		return outro.getNome().equals(this.nome);
		
	}
	
	@Override
	public String toString() {
		// retorna o nome
		return nome;
	}
}
