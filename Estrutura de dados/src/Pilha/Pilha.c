#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
	
	struct cel {
	    char conteudo;
	    struct cel *seg; // seguinte
	};
    typedef struct cel celula;

	void insere(celula *lst, char x) {
	    celula *novo;
	    novo = malloc(sizeof(celula));
	    novo->conteudo = x;
	    novo->seg = lst->seg;
	    lst->seg = novo;
	}

	int remove_celula (celula *lst){
		celula *lixo;
		lixo = lst->seg;
		int x = lixo->conteudo;
		lst->seg = lixo->seg;
		free(lixo);
		return x;
	}

	celula* buscar(celula *lst,int x){
		while(lst != NULL) {
			celula *prox_celula = lst->seg;
			if(prox_celula->conteudo == x){
				return lst;
			}
			lst = lst->seg;
		}
		return NULL; 
	}

    int certo (celula *lista, char listaSting[], int tamanho){
        	    
        for (int i = 0; i < tamanho; i++) {
            char prox = listaSting[i];

            if(lista->seg == NULL){
                insere(lista, prox);
            }else if((prox == '{' && lista->seg->conteudo == '(') || (prox == '(' && lista->seg->conteudo == '{') || (prox == '(' && lista->seg->conteudo == '(') || (prox == '{' && lista->seg->conteudo == '{')){
                insere(lista, prox);
            }else if(prox == ')' && lista->seg->conteudo == '('){
                remove_celula(lista);
            }else if(prox == '}' && lista->seg->conteudo == '{'){
                remove_celula(lista);
            }else if((prox == '{' && lista->seg->conteudo == ')') || (prox == '{' && lista->seg->conteudo == '(') || (prox == '}' && lista->seg->conteudo == '(')){
                break;
            }
	    }
        if(lista->seg == NULL){
            return 1;
        }else{
            return 0;
        }

    }
    
	void main() {
	    celula *lista = malloc(sizeof(celula));
	    lista->seg = NULL;

        char listaSting[] = "((})";
        int tamanho = strlen(listaSting);

        int valor = certo(lista,listaSting,tamanho);

        printf("%d",valor);

}