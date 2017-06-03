public class ArvoreABB {

	private NoArvore raiz;
	private int quantNos;

	public ArvoreABB() {
		this.raiz = null;
		this.quantNos = 0;
	}

	public String[] pesquisa(String[] cpfs) {
		String[] linha = new String[cpfs.length];
		for (int i = 0; i < cpfs.length; i++) {
			linha[i] = this.pesquisa(Long.parseLong(cpfs[i]), this.raiz);
			if (linha[i].isEmpty()) {
				linha[i] = cpfs[i] + " - CPF INEXISTENTE";
			}
		}
		return linha;
	}

	private String pesquisa(long cpf, NoArvore no) {
		String str = "";
		double total = 0;
		if (no != null) {
			if (cpf < no.getInfo().getCpfLong())
				str = this.pesquisa(cpf, no.getEsq());
			else if (cpf > no.getInfo().getCpfLong())
				str = this.pesquisa(cpf, no.getDir());
			else {
				str = no.toString();
				total = no.getInfo().getValor();
				if (no.getRepetido() != null) {
					No repetidos = no.getRepetido();
					while (repetidos != null) {
						str += repetidos.getCompra();
						total += repetidos.getInfo().getValor();
						repetidos = repetidos.getProx();
					}
				}
				str += "TOTAL: " + total;
			}
		}
		return str;
	}

	public void insere(Item elem) {
		this.raiz = this.insere(elem, this.raiz);
		this.quantNos++;
	}

	private NoArvore insere(Item elem, NoArvore no) {
		if (no == null) {
			return (new NoArvore(elem));
		} else if (elem.getCpfLong() < no.getInfo().getCpfLong()) {
			no.setEsq(this.insere(elem, no.getEsq()));
			return no;
		} else if (elem.getCpfLong() > no.getInfo().getCpfLong()) {
			no.setDir(this.insere(elem, no.getDir()));
			return no;
		} else {// Inserir CPF repetido
			if (no.getRepetido() == null){
				no.setRep(new No(elem));
			}else {
				No repetido = no.getRepetido();
				while (repetido.getProx() != null)
					repetido = repetido.getProx();
				repetido.setProx(new No(elem));
			}
			return no;
		}
	}

	public Item[] camCentral() {
		Item[] vetOrdenado = new Item[this.quantNos];
		int[] i = new int[1];
		i[0] = 0;
		return (this.fazCamCentral(this.raiz, vetOrdenado, i));
	}

	private Item[] fazCamCentral(NoArvore arv, Item[] vetOrdenado, int[] i) {
		if (arv != null) {
			vetOrdenado = this.fazCamCentral(arv.getEsq(), vetOrdenado, i);
			vetOrdenado[i[0]] = arv.getInfo();
			i[0]++;
			if (arv.getRepetido() != null) {
				No reptidos = arv.getRepetido();
				while (reptidos != null) {
					vetOrdenado[i[0]] = reptidos.getInfo();
					i[0]++;
					reptidos = reptidos.getProx();
				}
			}
			vetOrdenado = fazCamCentral(arv.getDir(), vetOrdenado, i);
		}
		return vetOrdenado;
	}

	public ArvoreABB arvBalanceada() {
		ArvoreABB temp = new ArvoreABB();
		Item[] vetOrdenado = camCentral();
		this.balancear(vetOrdenado, temp, 0, this.quantNos - 1);
		return temp;
	}

	private void balancear(Item[] vetOrdenado, ArvoreABB temp, int ini, int fim) {
		int meio;
		if (fim >= ini) {
			meio = (ini + fim) / 2;
			if (vetOrdenado[meio] != null) {
				temp.insere(vetOrdenado[meio]);
				this.balancear(vetOrdenado, temp, ini, meio - 1);
				this.balancear(vetOrdenado, temp, meio + 1, fim);
			}
		}
	}
}
